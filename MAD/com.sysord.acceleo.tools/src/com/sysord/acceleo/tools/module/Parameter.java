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

import org.eclipse.emf.ecore.EClassifier;

/**
 * Parameter of a {@link TemplatePrototype}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface Parameter {

    /**
     * Returns this parameter's name.
     * 
     * @return this parameter's name.
     */
    public String getName();

    /**
     * Returns this parameter's type.
     * 
     * @return this parameter's type.
     */
    public EClassifier getType();

    /**
     * Returns the comment of this parameter.
     * 
     * @return the comment of this parameter.
     */
    public String getComment();
}
