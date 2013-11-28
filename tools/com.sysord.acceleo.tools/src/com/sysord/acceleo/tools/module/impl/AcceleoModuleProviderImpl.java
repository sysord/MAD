/***************************************************************************
 * Copyright (c) 2013 Sysord.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sysord - initial API and implementation
 ****************************************************************************/
package com.sysord.acceleo.tools.module.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.acceleo.common.IAcceleoConstants;
import org.eclipse.acceleo.common.internal.utils.AcceleoPackageRegistry;
import org.eclipse.acceleo.common.internal.utils.workspace.AcceleoWorkspaceUtil;
import org.eclipse.acceleo.common.internal.utils.workspace.BundleURLConverter;
import org.eclipse.acceleo.common.utils.ModelUtils;
import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.acceleo.model.mtl.MtlPackage;
import org.eclipse.acceleo.model.mtl.resource.AcceleoResourceFactoryRegistry;
import org.eclipse.acceleo.model.mtl.resource.AcceleoResourceSetImpl;
import org.eclipse.acceleo.model.mtl.resource.EMtlBinaryResourceFactoryImpl;
import org.eclipse.acceleo.model.mtl.resource.EMtlResourceFactoryImpl;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.ExpressionsPackage;

import com.sysord.acceleo.tools.AcceleoTools;
import com.sysord.acceleo.tools.module.AcceleoModuleProvider;
import com.sysord.acceleo.tools.module.ModuleDescriptor;
import com.sysord.eclipse.tools.EclipseTools;

/**
 * Default implementation of the {@link AcceleoModuleProvider} interface.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
@SuppressWarnings("restriction")
public class AcceleoModuleProviderImpl implements AcceleoModuleProvider {

	private static final AcceleoModuleProviderImpl INSTANCE;

	static {
		INSTANCE = new AcceleoModuleProviderImpl();
		INSTANCE.initialize();
	}

	private Map<URI, Module> moduleCache = Collections.synchronizedMap(new HashMap<URI, Module>());

	private ResourceSet resourceSet;

	private boolean initialized;

	private IResourceChangeListener listener;

	/**
	 * Creates a new {@code AcceleoModuleProviderImpl}.
	 */
	private AcceleoModuleProviderImpl() {
		// Singleton
	}

	/**
	 * Returns the unique instance of {@link AcceleoModuleProvider}.
	 * 
	 * @return the unique instance of {@link AcceleoModuleProvider}.
	 */
	public static AcceleoModuleProvider getInstance() {
		return INSTANCE;
	}

	/**
	 * This will update the resource set's package registry with all usual EPackages.
	 * 
	 * @param resourceSet The resource set which registry has to be updated.
	 */
	public static void registerBasePackages(ResourceSet resourceSet) {
		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);

		resourceSet.getPackageRegistry().put(org.eclipse.ocl.ecore.EcorePackage.eINSTANCE.getNsURI(),
				org.eclipse.ocl.ecore.EcorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(ExpressionsPackage.eINSTANCE.getNsURI(), ExpressionsPackage.eINSTANCE);

		resourceSet.getPackageRegistry().put(MtlPackage.eINSTANCE.getNsURI(), MtlPackage.eINSTANCE);

		resourceSet.getPackageRegistry().put("http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore", //$NON-NLS-1$
				getOCLStdLibPackage());
	}

	/**
	 * This will update the resource set's resource factory registry with all usual
	 * factories.
	 * 
	 * @param resourceSet The resource set which registry has to be updated.
	 */
	public static void registerBaseResourceFactories(ResourceSet resourceSet) {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", //$NON-NLS-1$
				new EcoreResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap()
				.put(IAcceleoConstants.BINARY_CONTENT_TYPE, new EMtlBinaryResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap()
				.put(IAcceleoConstants.XMI_CONTENT_TYPE, new EMtlResourceFactoryImpl());
	}

	/**
	 * Returns the package containing the OCL standard library.
	 * 
	 * @return The package containing the OCL standard library.
	 */
	protected static EPackage getOCLStdLibPackage() {
		EcoreEnvironmentFactory factory = new EcoreEnvironmentFactory();
		EcoreEnvironment environment = (EcoreEnvironment) factory.createEnvironment();
		EPackage oclStdLibPackage = (EPackage) EcoreUtil.getRootContainer(environment.getOCLStandardLibrary().getBag());
		environment.dispose();
		return oclStdLibPackage;
	}

	/**
	 * Checks whether the given EPackage class is located in the workspace.
	 * 
	 * @param ePackageClass The EPackage class we need to take into account.
	 * @return <code>true</code> if the given class has been loaded from a dynamically
	 *         installed bundle, <code>false</code> otherwise.
	 */
	public static boolean isInWorkspace(Class<? extends EPackage> ePackageClass) {
		return EMFPlugin.IS_ECLIPSE_RUNNING && AcceleoWorkspaceUtil.INSTANCE.isInDynamicBundle(ePackageClass);
	}

	@Override
	public void initialize(List<EPackage> packages) {
		initialize();
		if (packages != null) {
			addPackages(packages);
		}
	}

	@Override
	public void initialize() {
		if (initialized)
			return;
		// else
		synchronized (moduleCache) {
			initialized = true;

			// Creating the resource set
			resourceSet = new AcceleoResourceSetImpl();
			resourceSet.setPackageRegistry(AcceleoPackageRegistry.INSTANCE);

			// Registering acceleo resource factory registry
			Resource.Factory.Registry resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
			resourceSet.setResourceFactoryRegistry(new AcceleoResourceFactoryRegistry(resourceFactoryRegistry));

			// Creating URIConverter
			URIConverter uriConverter = createURIConverter();
			if (uriConverter != null) {
				resourceSet.setURIConverter(uriConverter);
			}

			// make sure that metamodel projects in the workspace override those in
			// plug-ins
			resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap(false));

			// register EMF resource factories
			registerBaseResourceFactories(resourceSet);

			// register EMF packages
			registerBasePackages(resourceSet);

			// register workspace listener for module resources
			registerResourceListener();
		}
	}

	@Override
	public Module getModule(ModuleDescriptor moduleDescriptor) {
		return getModule(AcceleoTools.createEMtlURI(moduleDescriptor));
	}

	@Override
	public Module getModule(URI moduleUri) {
		if (resourceSet == null) {
			throw new IllegalStateException("AcceleoModuleProvider has not been initialized.");
		}// else
		return loadModule(moduleUri);
	}

	/**
	 * Loads and returns the module corresponding to the module {@link URI
	 * uri}.
	 * 
	 * @param moduleURI
	 * @return the module corresponding to the module {@link URI
	 *         uri}.
	 */
	private Module loadModule(URI moduleURI) {
		Module module = moduleCache.get(moduleURI);
		synchronized (moduleCache) {
			if (module == null) {
				try {
					module = (Module) ModelUtils.load(moduleURI, resourceSet);
					if (module != null) {
						moduleCache.put(moduleURI, module);
					}
				} catch (Exception e) {
					int size = resourceSet.getResources().size();
					if (size > 0) {
						// We're deleting the last resource created, it's an invalid
						// resource.
						resourceSet.getResources().remove(size - 1);
					}
				}
			}
		}
		return module;
	}

	/**
	 * Creates the {@link URIConverter}.
	 * 
	 * @return the {@link URIConverter}.
	 */
	private URIConverter createURIConverter() {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			return null;
		}// else

		return new ExtensibleURIConverterImpl() {
			@Override
			public URI normalize(URI uri) {
				URI normalized = getURIMap().get(uri);
				if (normalized == null) {
					BundleURLConverter conv = new BundleURLConverter(uri.toString());
					if (conv.resolveBundle() != null) {
						normalized = URI.createURI(conv.resolveAsPlatformPlugin());
						getURIMap().put(uri, normalized);
					}
				}
				if (normalized != null) {
					return normalized;
				}
				return super.normalize(uri);
			}
		};
	}

	/**
	 * Registers a resource listener on the current workspace for listening to Module
	 * changes.
	 */
	private void registerResourceListener() {
		listener = new IResourceChangeListener() {
			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				final ResourceSet resourceSet = AcceleoModuleProviderImpl.this.resourceSet;
				final IResourceDelta delta = event.getDelta();
				final ArrayList<URI> toDelete = new ArrayList<URI>(1);
				synchronized (moduleCache) {
					for (final URI uri : moduleCache.keySet()) {
						if (delta.findMember(new Path(uri.toPlatformString(true))) != null) {
							// Delete the resource from the resource set, it will be
							// reloaded on the next call for the module
							Resource resource = moduleCache.get(uri).eResource();
							if (resource != null) {
								resourceSet.getResources().remove(resource);
								toDelete.add(uri);
							}
						}
					}
					for (int i = 0; i < toDelete.size(); i++) {
						moduleCache.remove(toDelete.get(i));
					}
				}
			}
		};
		EclipseTools.getCurrentWorkspace().addResourceChangeListener(listener, IResourceChangeEvent.POST_CHANGE);
	}

	@Override
	public void addPackages(List<EPackage> packagesToRegister) {
		final Registry registry = this.resourceSet.getPackageRegistry();
		synchronized (moduleCache) {
			for (final EPackage ePackage : packagesToRegister) {
				if (!isInWorkspace(ePackage.getClass())) {
					registry.put(ePackage.getNsURI(), ePackage);
				}
			}
		}
	}

	@Override
	public void clear() {
		if (resourceSet != null) {
			synchronized (moduleCache) {
				resourceSet.getResources().clear();
			}
		}
	}

}
