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
package com.sysord.emf.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import com.sysord.eclipse.tools.EclipseTools;

/**
 * Utility class for EMF.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class EMFUtil {

	// Suppresses default constructor, ensuring non-instantiability.
	private EMFUtil() {
	}

	/**
	 * Move the given {@link Adapter} <em>from</em> a {@link Notifier} <em>to</em> an
	 * other.
	 * <p>
	 * The {@code Notifier}s can be {@code null}.
	 * <p>
	 * If the {@code Adapter} is {@code null}, do nothing.
	 * 
	 * @param adapter {@code Adapter} to move.
	 * @param from The {@code Notifier} from which the adapter will be taken.
	 * @param to The {@code Notifier} into which the adapter will be put.
	 */
	public static void moveAdapter(Adapter adapter, Notifier from, Notifier to) {
		if (adapter == null) {
			return;
		}// else

		if (from != to) {
			if (from != null) {
				from.eAdapters().remove(adapter);
			}
			if (to != null) {
				to.eAdapters().add(adapter);
			}
		}
	}

	private static Map<Resource, AdapterFactory> adapterFactories = Collections
			.synchronizedMap(new HashMap<Resource, AdapterFactory>());

	/**
	 * Returns the {@link AdapterFactory} associated with the given {@code element}.
	 * 
	 * @param element
	 * @return the {@link AdapterFactory} associated with the given {@code element}.
	 */
	public static AdapterFactory getItemProviderAdapterFactoryFor(Notifier element) {
		AdapterFactory factory = null;
		Resource resource = null;
		// Looking for a previously cached adapter factory for this element
		if (element instanceof EObject) {
			resource = ((EObject) element).eResource();
			if (resource != null) {
				factory = adapterFactories.get(resource);
				if (factory != null) {
					return factory;
				}// else
			}
		}

		// No factory was cached, looking in the registered adapter factories classes
		factory = getNoCachedAdapterFactory(element, new ArrayList<Class<? extends AdapterFactory>>());
		if (factory != null && resource != null) {
			adapterFactories.put(resource, factory);
		}

		return factory;
	}

	/**
	 * Returns the {@link AdapterFactory} associated with the given {@code element}.
	 * <p>
	 * <strong>Do not cache</strong> the result.
	 * 
	 * @param element
	 * @return the {@link AdapterFactory} associated with the given {@code element}.
	 */
	protected static AdapterFactory getNoCachedAdapterFactory(Notifier element,
			List<Class<? extends AdapterFactory>> alreadyChecked) {
		AdapterFactory factory = null;
		for (Class<AdapterFactory> factoryClass : getRegisteredItemProviderAdapterFactories()) {
			if (!alreadyChecked.contains(factoryClass)) {
				factory = EclipseTools.getNewInstance(factoryClass);
				if (factory != null) {
					Adapter adapter = factory.adapt(element, null);
					if (adapter != null && adapter instanceof ItemProviderAdapter) {
						if (element instanceof EObject) {
							factory = checkFactory(factory, (EObject) element, alreadyChecked);
						}
						return factory;
					}
				}
			}
		}
		return factory;
	}

	/**
	 * Checks if the given factory is appropriate for the specified element
	 * 
	 * @param factory
	 * @param element
	 * @param alreadyChecked
	 * @return A more appropriate factory if possible; the given factory otherwise.
	 */
	private static AdapterFactory checkFactory(AdapterFactory factory, EObject element,
			List<Class<? extends AdapterFactory>> alreadyChecked) {
		if (!factory.isFactoryForType(((EObject) element).eClass().getEPackage())) {
			alreadyChecked.add(factory.getClass());
			AdapterFactory newFactory = getNoCachedAdapterFactory(element, alreadyChecked);
			factory = newFactory != null ? newFactory : factory;
		}
		return factory;
	}

	/**
	 * {@link AdapterFactory}'s classes cache.
	 */
	private static List<Class<AdapterFactory>> adapterFactoriesClasses = new ArrayList<Class<AdapterFactory>>();

	/**
	 * Returns the classes of the registered {@link AdapterFactory}s for
	 * {@link ItemProviderAdapter}s.
	 * 
	 * @return the classes of the registered {@link AdapterFactory}s for
	 *         {@link ItemProviderAdapter}s.
	 */
	public static List<Class<AdapterFactory>> getRegisteredItemProviderAdapterFactories() {
		synchronized (adapterFactoriesClasses) {
			/*
			 * The only reason a new factory would be added in the workbench is when a new
			 * plug-in is installed and deployed without restarting Eclipse.
			 */
			if (adapterFactoriesClasses.size() == 0) {
				adapterFactoriesClasses = new ArrayList<Class<AdapterFactory>>();
				IConfigurationElement[] configElements = EclipseTools.getConfigurationElementsFor(
						"org.eclipse.emf.edit", "itemProviderAdapterFactories");
				configElements = EclipseTools.getConfigurationElementsFor(configElements, "factory");
				for (IConfigurationElement configElement : configElements) {
					if (configElement != null) {
						String factoryClassName = configElement.getAttribute("class");
						Class<AdapterFactory> factoryClass = EclipseTools.findClass(configElement, factoryClassName);
						if (factoryClass != null) {
							adapterFactoriesClasses.add(factoryClass);
						}
					}
				}
			}
		}
		return adapterFactoriesClasses;
	}

	/**
	 * Extract the namespace URI from a model file using EMF Resource loading.
	 * (from org.eclipse.emf.edapt.migration.ReleaseUtils)
	 * 
	 * @param modelURI
	 * @return
	 */
	public static String getNSUriFromURI(URI modelURI) {
		ResourceSet resourceSet = new ResourceSetImpl();

		// register delegating package registry
		PackageRegistry registry = new PackageRegistry(resourceSet.getPackageRegistry());
		resourceSet.setPackageRegistry(registry);

		Resource resource = resourceSet.createResource(modelURI);
		try {
			resource.load(null);
		} catch (Exception e) {
			// loading should fail here
		}

		return registry.getNsURI();
	}

	/**
	 * Creates an {@link IFile} from the given EMF {@link URI} or {@code null} if the file
	 * refered by the URI is not in the current workspace.
	 * <p>
	 * The returned {@link IFile file} is a handle and may not exist.
	 * 
	 * @param uri The {@link URI} to convert into a {@link IFile file}.
	 * @return an {@link IFile} from the given EMF {@link URI} or {@code null}.
	 */
	public static IFile createIFileFromURI(URI uri) {
		IFile file = null;
		if (uri.isPlatformResource()) {
			file = EclipseTools.getCurrentWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		return file;
	}

	/**
	 * Creates a platform resource {@link URI} if the given {@code filePath} is a resource
	 * of the current workspace, otherwise creates a file resource {@link URI}.
	 * 
	 * @param filePath The path of the resource for which to create a platform resource
	 *        {@link URI}.
	 * @return a platform resource {@link URI} of the given {@code filePath} if it is a
	 *         resource of the current workspace;
	 *         a file resource {@link URI} otherwise.
	 */
	public static URI createPlatformResourceUriIfPossible(String filePath) {
		String workspacePath = EclipseTools.getCurrentWorkspacePath().getAbsolutePath();
		if (filePath.startsWith(workspacePath)) {
			filePath = filePath.substring(workspacePath.length());
			return URI.createPlatformResourceURI(filePath, false);
		}// else

		IResource res = EclipseTools.getCurrentWorkspace().getRoot().findMember(filePath);
		if (res != null) {
			return URI.createPlatformResourceURI(filePath, false);
		}// else

		return URI.createFileURI(filePath);
	}

}
