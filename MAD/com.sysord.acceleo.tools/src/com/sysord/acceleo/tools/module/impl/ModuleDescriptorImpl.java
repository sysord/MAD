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

import com.sysord.acceleo.tools.module.ModuleDescriptor;

/**
 * Default implementation of a {@link ModuleDescriptor}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ModuleDescriptorImpl implements ModuleDescriptor {

    private String bundleURI;

    private String qualifiedName;

    /**
     * Creates a new {@code ModuleDescriptorImpl}.
     * 
     * @param bundleURI
     * @param qualifiedName
     */
    public ModuleDescriptorImpl(String bundleURI, String qualifiedName) {
        this.bundleURI = bundleURI;
        this.qualifiedName = qualifiedName;
    }

    @Override
    public String getBundleURI() {
        return bundleURI;
    }

    @Override
    public String getQualifiedName() {
        return qualifiedName;
    }

    @Override
    public String getSimpleName() {
        StringBuilder builder = new StringBuilder(qualifiedName);
        int end = qualifiedName.length();
        if (qualifiedName.endsWith(".emtl")) {
            end = qualifiedName.length() - 5;
            builder.deleteCharAt(end);
        } else if (qualifiedName.endsWith(".mtl")) {
            end = qualifiedName.length() - 4;
            builder.deleteCharAt(end);
        }
        return builder.substring(builder.lastIndexOf(".") + 1, end);
    }
}
