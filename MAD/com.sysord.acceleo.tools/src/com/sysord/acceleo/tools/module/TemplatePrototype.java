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

import org.eclipse.acceleo.model.mtl.Query;
import org.eclipse.acceleo.model.mtl.Template;
import org.eclipse.emf.ecore.EClassifier;

/**
 * Describes an acceleo {@link Template template} or {@link Query query} prototype. A
 * prototype is a list of parameters.
 * <p>
 * A template prototype must be <em>immutable</em> and their creation should be done via
 * a {@link PrototypeBuilder}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface TemplatePrototype {

    /**
     * Type of template.
     */
    enum TemplateType {
        TEMPLATE,
        QUERY,
    }

    /**
     * Returns this prototype's name.
     * 
     * @return this prototype's name.
     */
    public String getName();

    /**
     * Returns this prototype's comment.
     * 
     * @return this prototype's comment.
     */
    public String getComment();

    /**
     * Returns this prototype's type.
     * <p>
     * The default value is {@link TemplateType#TEMPLATE TEMPLATE}.
     * 
     * @return this prototype's type.
     */
    public TemplateType getTemplateType();

    /**
     * Returns this prototype's {@link Parameter parameters}.
     * 
     * @return this prototype's {@link Parameter parameters}.
     */
    public List<Parameter> getParameters();

    /**
     * Returns this prototype's type.
     * 
     * @return this prototype's type.
     */
    public EClassifier getReturnType();

    /**
     * Returns the comment of this prototype return type.
     * 
     * @return the comment of this prototype return type.
     */
    public String getReturnComment();

    /**
     * Returns the content of this template prototype.
     * 
     * @return the content of this template prototype.
     */
    public String getContent();

    /**
     * Returns {@code true} if this prototype is equivalent to the other, that is if they
     * have the <strong>same name</strong> and if {@link #hasSameParameters(Object)}
     * returns {@code true}.
     * 
     * @param other {@link TemplatePrototype Prototype} to compare with this one.
     * @return {@code true} if this prototype is equivalent to the other;<br>
     *         {@code false} otherwise.
     */
    public boolean equals(Object other);

    /**
     * Indicates if this prototype has <strong>the same {@link Parameter parameters}
     * </strong> and <strong>the same return type</strong> than the given prototype.
     * <p>
     * The names of the parameters are not taken into account in the comparison.
     * 
     * @param other {@link TemplatePrototype Prototype} to compare with this one.
     * @return {@code true} if this prototype has the same {@link Parameter parameters}
     *         and the same return type than the given prototype.
     */
    public boolean hasSameParameters(Object other);
}
