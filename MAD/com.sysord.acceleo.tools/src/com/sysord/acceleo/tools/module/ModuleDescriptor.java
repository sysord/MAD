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

/**
 * Describes a module with a bundle URI and the module qualified name.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface ModuleDescriptor {

    /**
     * Returns the bundle URI of the module.
     * 
     * @return the bundle URI of the module.
     */
    public String getBundleURI();

    /**
     * Returns the qualified name of the module.
     * 
     * @return the qualified name of the module.
     */
    public String getQualifiedName();

    /**
     * Returns the simple name of the module.
     * 
     * @return the simple name of the module.
     */
    public String getSimpleName();
}
