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
import java.util.Set;

/**
 * <strong>Immutable</strong> description of a module interface.
 * <p>
 * Use {@link ModuleInterfaceBuilder} to create {@link ModuleInterface}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface ModuleInterface {

    /**
     * Returns the module {@link ModuleDescriptor descriptor}.
     * 
     * @return the module {@link ModuleDescriptor descriptor}.
     */
    public ModuleDescriptor getModuleDescriptor();

    /**
     * Returns the list of the module's metamodel URIs.
     * 
     * @return the list of the module's metamodel URIs.
     */
    public Set<String> getMetamodelUris();

    /**
     * Returns the {@link TemplatePrototype prototypes} the module must implements.
     * 
     * @return the {@link TemplatePrototype prototypes} the module must implements.
     */
    public List<TemplatePrototype> getPrototypes();
}
