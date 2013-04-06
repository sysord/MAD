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
package com.sysord.acceleo.tools.module;

import java.util.*;

import com.sysord.acceleo.tools.module.impl.ModuleDescriptorImpl;

/**
 * Builder of {@link ModuleInterface}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ModuleInterfaceBuilder {

    // The module interface defined by this builder
    private ModuleInterfaceImpl moduleInterface = new ModuleInterfaceImpl();

    /**
     * Defines the module descriptor of the {@link ModuleInterface}.
     * 
     * @param descriptor
     * @return this {@link ModuleInterfaceBuilder builder}.
     */
    public ModuleInterfaceBuilder setDescriptor(ModuleDescriptor descriptor) {
        moduleInterface.descriptor = descriptor;
        return this;
    }

    /**
     * Add the given meta-model's URI for the {@link ModuleInterface}.
     * 
     * @param uri
     * @return this {@link ModuleInterfaceBuilder builder}.
     */
    public ModuleInterfaceBuilder addMetamodelUri(String uri) {
        moduleInterface.metamodelUris.add(uri);
        return this;
    }

    /**
     * Add the given {@link TemplatePrototype prototype} for the {@link ModuleInterface}.
     * 
     * @param prototype
     * @return this {@link ModuleInterfaceBuilder builder}.
     */
    public ModuleInterfaceBuilder addPrototype(TemplatePrototype prototype) {
        moduleInterface.prototypes.add(prototype);
        return this;
    }

    /**
     * Add the given meta-model's URIs for the {@link ModuleInterface}.
     * 
     * @param uris
     * @return this {@link ModuleInterfaceBuilder builder}.
     */
    public ModuleInterfaceBuilder addAllMetamodelUris(Collection<String> uris) {
        moduleInterface.metamodelUris.addAll(uris);
        return this;
    }

    /**
     * Add the given {@link TemplatePrototype prototypes} for the {@link ModuleInterface}.
     * 
     * @param prototypes
     * @return this {@link ModuleInterfaceBuilder builder}.
     */
    public ModuleInterfaceBuilder addAllPrototypes(Collection<TemplatePrototype> prototypes) {
        moduleInterface.prototypes.addAll(prototypes);
        return this;
    }

    /**
     * Returns an instance of {@link ModuleInterface} corresponding to this builder
     * definition.
     * <p>
     * The returned module interface is an <em>immutable</em> <strong>deep copy</strong>
     * of the internal module interface of this builder.
     * 
     * @return an instance of {@link ModuleInterface} corresponding to this builder
     *         definition.
     */
    public ModuleInterface create() {
        try {
            return moduleInterface.clone();
        } catch (CloneNotSupportedException e) {
            // Should never happen, but in case returns the built ModuleInterface
            return moduleInterface;
        }
    }

    private static class ModuleInterfaceImpl implements ModuleInterface, Cloneable {

        private ModuleDescriptor descriptor;
        private HashSet<String> metamodelUris;
        private List<TemplatePrototype> prototypes;

        // Unmodifiable lists for avoiding external modifications
        private Set<String> externViewMetamodelUris;
        private List<TemplatePrototype> externViewPrototypes;

        /**
         * Creates a new {@code ModuleInterfaceBuilder.ModuleInterfaceImpl}.
         */
        public ModuleInterfaceImpl() {
            metamodelUris = new HashSet<String>(1);
            prototypes = new ArrayList<TemplatePrototype>();
            externViewMetamodelUris = Collections.unmodifiableSet(metamodelUris);
            externViewPrototypes = Collections.unmodifiableList(prototypes);
        }

        @Override
        public ModuleDescriptor getModuleDescriptor() {
            return descriptor;
        }

        @Override
        public Set<String> getMetamodelUris() {
            return externViewMetamodelUris;
        }

        @Override
        public List<TemplatePrototype> getPrototypes() {
            return externViewPrototypes;
        }

        @Override
        protected ModuleInterfaceImpl clone() throws CloneNotSupportedException {
            ModuleInterfaceImpl moduleInterface = new ModuleInterfaceImpl();
            moduleInterface.descriptor = new ModuleDescriptorImpl(descriptor.getBundleURI(),
                    descriptor.getQualifiedName());
            moduleInterface.metamodelUris.addAll(metamodelUris);
            moduleInterface.prototypes.addAll(prototypes);
            return moduleInterface;
        }
    }
}
