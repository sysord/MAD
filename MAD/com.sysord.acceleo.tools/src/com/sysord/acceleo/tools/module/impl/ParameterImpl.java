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

import org.eclipse.emf.ecore.EClassifier;

import com.sysord.acceleo.tools.module.Parameter;
import com.sysord.emf.tools.EmfToolsFacade;

/**
 * Default implementation of a {@link Parameter parameter}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ParameterImpl implements Parameter, Cloneable {

    private String name;
    private EClassifier type;
    private String comment;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EClassifier getType() {
        return type;
    }

    @Override
    public String getComment() {
        return comment;
    }

    /**
     * Set the name.
     * 
     * @param name the value to set to name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the type.
     * 
     * @param type the value to set to type.
     */
    public void setType(EClassifier type) {
        this.type = type;
    }
    
    /**
     * Set the comment.
     *
     * @param comment the value to set to comment.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        // else
        if (obj == null || !(obj instanceof Parameter))
            return false;
        // else

        Parameter param = (Parameter) obj;

        return EmfToolsFacade.getInstance().typesEqual(getType(), param.getType());
    }

    @Override
    public String toString() {
        StringBuilder param = new StringBuilder(getName());
        param.append(" : ");
        param.append(typeName(getType()));
        return param.toString();
    }

    @Override
    public Parameter clone() throws CloneNotSupportedException {
        ParameterImpl clone = (ParameterImpl) super.clone();
        return clone;
    }
    
    public static String typeName(EClassifier eClassifier) {
        return eClassifier.getName().replace("AnyType", "OclAny");
    }
}
