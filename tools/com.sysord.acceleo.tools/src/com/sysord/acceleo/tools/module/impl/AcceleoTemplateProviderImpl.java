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

import java.util.*;

import org.eclipse.acceleo.model.mtl.*;

import com.sysord.acceleo.tools.AcceleoTools;
import com.sysord.acceleo.tools.module.AcceleoTemplateProvider;
import com.sysord.acceleo.tools.module.TemplatePrototype;

/**
 * Default implementation of the {@link AcceleoTemplateProvider} interface.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class AcceleoTemplateProviderImpl implements AcceleoTemplateProvider {

    /**
     * Unique instance of the {@link AcceleoTemplateProvider}.
     */
    private static AcceleoTemplateProvider instance = new AcceleoTemplateProviderImpl();

    // Suppressing default constructor, ensuring Singleton pattern
    private AcceleoTemplateProviderImpl() {
    }

    /**
     * Returns the unique instance of the {@link AcceleoTemplateProvider}.
     * 
     * @return the unique instance of the {@link AcceleoTemplateProvider}.
     */
    public static AcceleoTemplateProvider getInstance() {
        return instance;
    }

    @Override
    public List<ModuleElement> getTemplates(Module module, String name, boolean nameIsRegex, TemplatePrototype prototype) {
        List<ModuleElement> templates = new ArrayList<ModuleElement>(5);
        for (ModuleElement moduleElement : module.getOwnedModuleElement()) {
            if ((moduleElement instanceof Template || moduleElement instanceof Query)
                    && (nameIsRegex && moduleElement.getName().matches(name) || !nameIsRegex
                            && moduleElement.getName().equals(name))
                    && (prototype == null || prototype.hasSameParameters(AcceleoTools
                            .createTemplatePrototype(moduleElement)))) {
                templates.add(moduleElement);
            }
        }
        return templates;
    }

    @Override
    public ModuleElement getTemplate(Module module, String name, boolean nameIsRegex, TemplatePrototype prototype) {
        List<ModuleElement> templates = getTemplates(module, name, nameIsRegex, prototype);
        return templates.size() > 0 ? templates.get(0) : null;
    }

    @Override
    public List<ModuleElement> getTemplates(Module module, String name, boolean nameIsRegex, int numberOfParameters) {
        List<ModuleElement> templates = new ArrayList<ModuleElement>(5);
        for (ModuleElement moduleElement : module.getOwnedModuleElement()) {
            if ((moduleElement instanceof Template || moduleElement instanceof Query)
                    && (nameIsRegex && moduleElement.getName().matches(name) || !nameIsRegex
                            && moduleElement.getName().equals(name))
                    && (moduleElement instanceof Template
                            && ((Template) moduleElement).getParameter().size() == numberOfParameters || moduleElement instanceof Query
                            && ((Query) moduleElement).getParameter().size() == numberOfParameters)) {
                templates.add(moduleElement);
            }
        }
        return templates;
    }

    @Override
    public List<ModuleElement> getTemplates(Module module, String name, boolean nameIsRegex) {
        return getTemplates(module, name, nameIsRegex, null);
    }

    @Override
    public ModuleElement getTemplate(Module module, String name, boolean nameIsRegex) {
        return getTemplate(module, name, nameIsRegex, null);
    }

}
