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
package com.sysord.acceleo.tools.module.emitter;

import java.util.Collection;

import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

import com.sysord.acceleo.tools.module.ModuleInterface;
import com.sysord.acceleo.tools.module.TemplatePrototype;

/**
 * Emitter of acceleo {@link Module modules}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface AcceleoEmitter {

    /**
     * Creates an acceleo {@link Module module} with the given {@link ModuleInterface}.
     * 
     * @param moduleInterface
     * @throws CoreException if the module file could not be created.
     */
    public void createModule(ModuleInterface moduleInterface) throws CoreException;

    /**
     * creates an import for the given ImportName in the {@link Module module}.
     * 
     * @param module
     * @param importName
     */
    public void addImport(org.eclipse.acceleo.model.mtl.Module module, String importName);

    /**
     * creates imports for the given ImportNames in the {@link Module module}.
     * 
     * @param module
     * @param importNames
     */
    public void addAllImports(org.eclipse.acceleo.model.mtl.Module module, Collection<String> importNames);
    
    /**
     * Adds the given {@link TemplatePrototype prototype} to the end of the {@link Module
     * module}.
     * 
     * @param module
     * @param prototype
     */
    public void addTemplate(Module module, TemplatePrototype prototype);

    /**
     * Adds the given {@link TemplatePrototype prototypes} to the end of the
     * {@link Module
     * module}.
     * 
     * @param module
     * @param prototype
     */
    public void addAllTemplates(Module module, Collection<TemplatePrototype> prototype);

    /**
     * Adds the given {@link TemplatePrototype prototype} after the
     * {@link TemplatePrototype afterPrototype} in the {@link Module module}.
     * 
     * @param module
     * @param prototype
     * @param afterPrototype
     */
    public void addTemplateAfter(Module module, TemplatePrototype prototype, TemplatePrototype afterPrototype);

    /**
     * Adds the given {@link TemplatePrototype prototypes} after the
     * {@link TemplatePrototype afterPrototype} in the {@link Module module}.
     * 
     * @param module
     * @param prototypes
     * @param afterPrototype
     */
    public void addAllTemplatesAfter(Module module, Collection<TemplatePrototype> prototypes,
            TemplatePrototype afterPrototype);
    
    
    /**
     * Creates a label for an Acceleo model element
     * @param element
     * @return the label or null if not exists label provider for this element
     */
    public String emitElementLabel(EObject element);
    
}
