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
package com.sysord.acceleo.tools;

import org.eclipse.acceleo.internal.ide.ui.editors.template.AcceleoSourceContent;
import org.eclipse.acceleo.model.mtl.*;
import org.eclipse.acceleo.parser.AcceleoSourceBuffer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.Variable;

import com.sysord.acceleo.tools.module.*;
import com.sysord.acceleo.tools.module.TemplatePrototype.TemplateType;
import com.sysord.acceleo.tools.module.emitter.AcceleoEmitter;
import com.sysord.acceleo.tools.module.emitter.impl.AcceleoEmitterImpl;
import com.sysord.acceleo.tools.module.impl.*;
import com.sysord.eclipse.tools.EclipseTools;

/**
 * Tools for manipulating acceleo files.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
@SuppressWarnings("restriction")
public class AcceleoTools {

    public static final String BIN_PATH = "/bin/";

    public static final String SRC_PATH = "/src/";

    public static final String MTL_EXT = ".mtl";

    public static final String EMTL_EXT = ".emtl";

    // Suppressing default constructor, ensuring non-instantiability
    private AcceleoTools() {
    }

    /**
     * Creates and returns an {@link AcceleoModuleProvider}.
     * 
     * @return the created {@link AcceleoModuleProvider}.
     */
    public static AcceleoModuleProvider getModuleProvider() {
        return new AcceleoModuleProviderImpl();
    }

    /**
     * Returns the {@link AcceleoTemplateProvider}.
     * 
     * @return the {@link AcceleoTemplateProvider}.
     */
    public static AcceleoTemplateProvider getTemplateProvider() {
        return AcceleoTemplateProviderImpl.getInstance();
    }

    /**
     * Creates a module {@link ModuleDescriptor descriptor} for the given
     * {@code bundleURI} and {@code qualifiedName}.
     * 
     * @param bundleURI URI of the plug-in containing the module.
     * @param qualifiedName Qualified name of the module in the plug-in.
     * @return the created module {@link ModuleDescriptor descriptor} for the given
     *         {@code bundleURI} and {@code qualifiedName}.
     */
    public static ModuleDescriptor createModuleDescriptor(final String bundleURI, final String qualifiedName) {
        return new ModuleDescriptorImpl(bundleURI, qualifiedName);
    }

    /**
     * Creates a module {@link ModuleDescriptor descriptor} for the given {@link Module
     * module}.
     * <p>
     * Returns {@code null} if the given {@link Module module} has no {@link Resource
     * resource}.
     * 
     * @param module The {@code module} for which creating a module
     *        {@link ModuleDescriptor descriptor}.
     * @return the created module {@link ModuleDescriptor descriptor} for the given
     *         {@link Module module}.
     * @throws NullPointerException if the given {@link Module module} is {@code null}.
     */
    public static ModuleDescriptor createModuleDescriptor(Module module) {
        ModuleDescriptor descriptor = null;
        Resource resource = module.eResource();
        if (resource != null) {
            String uri = resource.getURI().toString();
            String[] uriSplit = uri.split("/");
            StringBuilder bundleURI = new StringBuilder();
            StringBuilder qualifiedName = new StringBuilder();
            char separator = '/';
            for (int i = 0; i < uriSplit.length && i <= 2; i++) {
                bundleURI.append(uriSplit[i]).append(separator);
            }
            bundleURI.deleteCharAt(bundleURI.length() - 1);

            separator = '.';
            for (int i = 4; i < uriSplit.length; i++) {
                qualifiedName.append(uriSplit[i]).append(separator);
            }
            qualifiedName.deleteCharAt(qualifiedName.length() - 1);
            int index = qualifiedName.lastIndexOf(".emtl");
            if (index >= 0) {
                qualifiedName.delete(index, index + 5);
            } else {
                index = qualifiedName.lastIndexOf(".mtl");
                if (index >= 0) {
                    qualifiedName.delete(index, index + 4);
                }
            }
            descriptor = new ModuleDescriptorImpl(bundleURI.toString(), qualifiedName.toString());
        }
        return descriptor;
    }

    /**
     * Creates the <em>Mtl</em> module {@link URI} for the given descriptor.
     * 
     * @param descriptor
     * @return the <em>Mtl</em> module {@link URI} for the given descriptor.
     */
    public static URI createMtlURI(ModuleDescriptor descriptor) {
        return createModuleURI(descriptor, true);
    }

    /**
     * Creates the <em>EMtl</em> module {@link URI} for the given descriptor.
     * 
     * @param descriptor
     * @return the <em>EMtl</em> module {@link URI} for the given descriptor.
     */
    public static URI createEMtlURI(ModuleDescriptor descriptor) {
        return createModuleURI(descriptor, false);
    }

    private static URI createModuleURI(ModuleDescriptor descriptor, boolean mtlUri) {
        StringBuilder uri = new StringBuilder();
        uri.append(descriptor.getBundleURI());
        uri.append(mtlUri ? SRC_PATH : BIN_PATH);
        uri.append(descriptor.getQualifiedName().replace('.', '/'));
        String ext = mtlUri ? MTL_EXT : EMTL_EXT;
        if (descriptor.getQualifiedName().endsWith(MTL_EXT)) {
            uri.replace(uri.length() - MTL_EXT.length(), uri.length(), ext);
        } else if (descriptor.getQualifiedName().endsWith(EMTL_EXT)) {
            uri.replace(uri.length() - EMTL_EXT.length(), uri.length(), ext);
        } else {
            uri.append(ext);
        }
        String strUri = uri.toString();
        if(strUri.startsWith(EclipseTools.PLATFORM_SCHEME)){
            return URI.createURI(strUri, true);        	
        }else{
            return URI.createPlatformResourceURI(strUri, true);        	        	
        }
    }

    /**
     * Returns an {@link AcceleoEmitter}.
     * 
     * @return an {@link AcceleoEmitter}.
     */
    public static AcceleoEmitter getEmitter() {
        return new AcceleoEmitterImpl();
    }

    /**
     * Creates a {@link TemplatePrototype} corresponding to the given
     * {@link ModuleElement}.
     * 
     * @param moduleElement
     * @return a {@link TemplatePrototype} corresponding to the given
     *         {@link ModuleElement}.
     */
    public static TemplatePrototype createTemplatePrototype(ModuleElement moduleElement) {
        PrototypeBuilder protoBuilder = new PrototypeBuilder().setName(moduleElement.getName());

        if (moduleElement instanceof Query) {
        	protoBuilder.setType(TemplateType.QUERY);
            protoBuilder.setReturnType(((Query) moduleElement).getType());
            for (Variable var : ((Query) moduleElement).getParameter()) {
                protoBuilder.addParameter(var.getName(), var.getType());
            }
        }
        if (moduleElement instanceof Template) {
        	protoBuilder.setType(TemplateType.TEMPLATE);
            for (Variable var : ((Template) moduleElement).getParameter()) {
                protoBuilder.addParameter(var.getName(), var.getType());
            }
        }

        return protoBuilder.create();
    }

    /**
     * Creates an {@link AcceleoSourceContent} for the given {@link IFile file} or
     * {@code null} if it could not be created.
     * 
     * @param file The MTL file (must exist).
     * @return an {@link AcceleoSourceContent} for the given {@link IFile file} or
     *         {@code null}.
     */
    public static AcceleoSourceContent createSourceContent(IFile file) {
        if (file == null || !file.exists())
            return null;
        // else

        StringBuffer buffer = new AcceleoSourceBuffer(EclipseTools.createFile(file)).getBuffer();
        AcceleoSourceContent sourceContent = new AcceleoSourceContent();
        sourceContent.init(buffer, file);
        return sourceContent;
    }
}
