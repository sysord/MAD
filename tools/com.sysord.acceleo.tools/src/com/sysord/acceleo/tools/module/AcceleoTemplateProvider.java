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

import org.eclipse.acceleo.model.mtl.*;

/**
 * Provides acceleo {@link Template templates} or {@link Query queries} in a specified
 * acceleo {@link Module module}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface AcceleoTemplateProvider {

    /**
     * Returns the list of templates in the specified {@link Module module} which
     * correspond to the given {@code name} and {@link TemplatePrototype prototype}.
     * <p>
     * If {@code nameIsRegex} is {@code true}, the given name is treated as a regex.
     * 
     * @param module
     * @param name
     * @param nameStartWith
     * @param prototype
     * @return the list of templates in the specified {@link Module module} which
     *         correspond to the given {@code name} and {@link TemplatePrototype
     *         prototype}.
     */
    public List<ModuleElement> getTemplates(Module module, String name, boolean nameIsRegex, TemplatePrototype prototype);

    /**
     * Returns the list of templates in the specified {@link Module module} which
     * correspond to the given {@code name}.
     * <p>
     * If {@code nameIsRegex} is {@code true}, the given name is treated as a regex.
     * 
     * @param module
     * @param name
     * @param nameStartWith
     * @param prototype
     * @return the list of templates in the specified {@link Module module} which
     *         correspond to the given {@code name}.
     */
    public List<ModuleElement> getTemplates(Module module, String name, boolean nameIsRegex);

    /**
     * Returns the list of templates in the specified {@link Module module} which
     * correspond to the given {@code name} and with the given number of parameters.
     * <p>
     * If {@code nameIsRegex} is {@code true}, the given name is treated as a regex.
     * 
     * @param module
     * @param name
     * @param nameIsRegex
     * @param numberOfParameters
     * @return
     */
    public List<ModuleElement> getTemplates(Module module, String name, boolean nameIsRegex, int numberOfParameters);

    /**
     * Returns the first template found in the specified {@link Module module} which
     * corresponds to the given {@code name}.
     * <p>
     * If {@code nameIsRegex} is {@code true}, the given name is treated as a regex.
     * 
     * @param module
     * @param name
     * @param nameStartWith
     * @param prototype
     * @return the first template found in the specified {@link Module module} which
     *         correspond to the given {@code name}.
     */
    public ModuleElement getTemplate(Module module, String name, boolean nameIsRegex);

    /**
     * Returns the first template found in the specified {@link Module module} which
     * corresponds to the given {@code name} and {@link TemplatePrototype prototype} or
     * {@code null} if no template was found.
     * <p>
     * If {@code nameIsRegex} is {@code true}, the given name is treated as a regex.
     * 
     * @param module
     * @param name
     * @param nameStartWith
     * @param prototype
     * @return the first template found in the specified {@link Module module} which
     *         correspond to the given {@code name} and {@link TemplatePrototype
     *         prototype} or {@code null}.
     */
    public ModuleElement getTemplate(Module module, String name, boolean nameIsRegex, TemplatePrototype prototype);

}
