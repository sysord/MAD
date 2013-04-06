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

import java.util.List;

import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.emf.ecore.EPackage;

/**
 * Provides acceleo {@link Module modules} with module {@link ModuleDescriptor
 * descriptors}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface AcceleoModuleProvider {

    /**
     * Initializes this module provider with the given {@link EPackage packages}.
     * 
     * @param packages
     */
    public void initialize(List<EPackage> packages);

    /**
     * Returns the {@link Module module} corresponding to the given
     * {@link ModuleDescriptor descriptor} or {@code null} if it was not found.
     * 
     * @param moduleDescriptor
     * @return the {@link Module module} corresponding to the given
     *         {@link ModuleDescriptor descriptor} or {@code null}.
     * @throws IllegalStateException if this provider has not been initialized.
     */
    public Module getModule(ModuleDescriptor moduleDescriptor);
}
