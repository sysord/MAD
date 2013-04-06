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
package com.sysord.acceleo.tools.module.emitter.impl;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.acceleo.internal.ide.ui.editors.template.AcceleoSourceContent;
import org.eclipse.acceleo.parser.AcceleoSourceBuffer;
import org.eclipse.acceleo.parser.cst.Module;
import org.eclipse.acceleo.parser.cst.ModuleElement;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.sysord.acceleo.tools.AcceleoTools;
import com.sysord.acceleo.tools.module.*;
import com.sysord.acceleo.tools.module.TemplatePrototype.TemplateType;
import com.sysord.acceleo.tools.module.emitter.AcceleoEmitter;
import com.sysord.acceleo.tools.module.impl.ParameterImpl;
import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.emf.tools.EMFUtil;

/**
 * Default implementation of an acceleo {@link AcceleoEmitter emitter}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
@SuppressWarnings("restriction")
public class AcceleoEmitterImpl implements AcceleoEmitter {

    private static final String COMMENT_LR_REPLACEMENT = "\n * ";
    private static final char LR = '\n';
    private static final String LR_STR = "\n";
    private static final char TAB = '\t';

    @Override
    public void createModule(ModuleInterface moduleInterface) throws CoreException {
        URI mtlUri = AcceleoTools.createMtlURI(moduleInterface.getModuleDescriptor());
        IFile file = EMFUtil.createIFileFromURI(mtlUri);
        createFile(file);
        StringBuffer buffer = new AcceleoSourceBuffer(EclipseTools.createFile(file)).getBuffer();
        AcceleoSourceContent sourceContent = new AcceleoSourceContent();
        clearBuffer(buffer);
        sourceContent.init(buffer, file);
        fillBuffer(sourceContent, buffer, moduleInterface);
        saveContent(file, buffer);
    }

    @Override
    public void addTemplate(org.eclipse.acceleo.model.mtl.Module module, TemplatePrototype prototype) {
        addAllTemplates(module, Arrays.asList(prototype));
    }

    @Override
    public void addAllTemplates(org.eclipse.acceleo.model.mtl.Module module, Collection<TemplatePrototype> prototypes) {
        addAllTemplatesAfter(module, prototypes, null);
    }

    @Override
    public void addTemplateAfter(org.eclipse.acceleo.model.mtl.Module module, TemplatePrototype prototype,
            TemplatePrototype afterPrototype) {
        addAllTemplatesAfter(module, Arrays.asList(prototype), afterPrototype);
    }

    @Override
    public void addAllTemplatesAfter(org.eclipse.acceleo.model.mtl.Module module,
            Collection<TemplatePrototype> prototypes, TemplatePrototype afterPrototype) {
        ModuleDescriptor descriptor = AcceleoTools.createModuleDescriptor(module);
        URI mtlUri = AcceleoTools.createMtlURI(descriptor);
        IFile file = EMFUtil.createIFileFromURI(mtlUri);
        StringBuffer buffer = new AcceleoSourceBuffer(EclipseTools.createFile(file)).getBuffer();
        AcceleoSourceContent sourceContent = new AcceleoSourceContent();
        sourceContent.init(buffer, file);
        org.eclipse.acceleo.model.mtl.ModuleElement element = null;
        if (afterPrototype != null) {
            element = AcceleoTools.getTemplateProvider().getTemplate(module, afterPrototype.getName(), false,
                    afterPrototype);
        }
        int originalLength = buffer.length();
        int offset = 0;
        int startPosition = 0;
        if (element != null) {
            startPosition = element.getEndPosition();
        } else {
            Module cst = sourceContent.getCST();
            EList<ModuleElement> moduleElements = cst.getOwnedModuleElement();
            if (moduleElements.size() > 0) {
                startPosition = moduleElements.get(moduleElements.size() - 1).getEndPosition();
            } else {
                startPosition = buffer.length();
            }
        }
        for (TemplatePrototype prototype : prototypes) {
            addTemplate(sourceContent, buffer, startPosition + offset, prototype);
            offset = buffer.length() - originalLength;
        }
        saveContent(file, buffer);
    }

    /**
     * Clears the given buffer content.
     * 
     * @param buffer
     */
    private void clearBuffer(StringBuffer buffer) {
        if (buffer.length() > 0) {
            // Clear the existing content of the file
            buffer.delete(0, buffer.length());
        }
    }

    /**
     * Emitt the given {@link ModuleInterface module interface} into the buffer.
     * 
     * @param sourceContent
     * @param buffer
     * @param moduleInterface
     */
    private void fillBuffer(AcceleoSourceContent sourceContent, StringBuffer buffer, ModuleInterface moduleInterface) {
        // Add the encoding
        buffer.append("[comment encoding = UTF-8 /]\n");
        // Add the module name and the meta-model URIs
        buffer.append("[module ");
        buffer.append(moduleInterface.getModuleDescriptor().getSimpleName());
        buffer.append('(');
        for (String uri : moduleInterface.getMetamodelUris()) {
            buffer.append('\'').append(uri).append("', ");
        }
        // Delete the last comma and space
        buffer.delete(buffer.length() - 2, buffer.length());
        buffer.append(")]");

        // Creation of the templates and queries
        for (TemplatePrototype prototype : moduleInterface.getPrototypes()) {
            addTemplate(sourceContent, buffer, buffer.length(), prototype);
        }
    }

    /**
     * Creates the file into the workspace if it doesn't exist.
     * 
     * @param file
     * @throws CoreException
     */
    private void createFile(IFile file) throws CoreException {
        if (!file.exists()) {
            EclipseTools.createIFile(file);
        }
    }

    // Template emitter
    private void addTemplate(AcceleoSourceContent sourceContent, StringBuffer buffer, int startPosition,
            TemplatePrototype prototype) {
        StringBuilder template = new StringBuilder("\n\n");
        // Template's full comment
        if (prototype.getComment() != null) {
            template.append("[**\n * ");
            template.append(prototype.getComment().replaceAll(LR_STR, COMMENT_LR_REPLACEMENT));
            // Parameters comments
            boolean firstParam = true;
            for (Parameter param : prototype.getParameters()) {
                if (param.getComment() != null) {
                    if (firstParam) {
                        firstParam = false;
                        template.append(COMMENT_LR_REPLACEMENT);
                    }
                    template.append("\n * @param ").append(
                            param.getComment().replaceAll(LR_STR, COMMENT_LR_REPLACEMENT));
                }
            }
            // Return comment
            if (prototype.getReturnComment() != null) {
                if (firstParam) {
                    firstParam = false;
                    template.append(COMMENT_LR_REPLACEMENT);
                }
                template.append("\n * @return ");
                template.append(prototype.getReturnComment().replaceAll(LR_STR, COMMENT_LR_REPLACEMENT));
            }
            // Comment end
            template.append("\n *]\n");
        }

        // Template begin
        if (prototype.getTemplateType() == TemplateType.TEMPLATE) {
            template.append("[template public ");
        } else {
            template.append("[query public ");
        }
        template.append(prototype.getName()).append('(');
        // Prototype parameters
        for (Parameter parameter : prototype.getParameters()) {
            template.append(parameter.toString());
            template.append(", ");
        }
        // Delete the last comma and space
        if (prototype.getParameters().size() > 0) {
            template.delete(template.length() - 2, template.length());
        }
        template.append(')');

        if (prototype.getTemplateType() == TemplateType.TEMPLATE) {
            template.append(']');
        } else {
            template.append(" : ");
            template.append(prototype.getReturnType() == null ? "String" : ParameterImpl.typeName(prototype
                    .getReturnType()));
            template.append(" =");
        }

        // Content of the template
        if (prototype.getContent() != null) {
            template.append(LR);
            if (prototype.getTemplateType() == TemplateType.QUERY) {
                template.append(TAB).append(prototype.getContent().replaceAll(LR_STR, "\n\t"));
            } else {
                template.append(prototype.getContent());
            }
        } else if (prototype.getTemplateType() == TemplateType.QUERY) {
            template.append(LR).append("\tnull");
        }

        // Closing the template
        if (prototype.getTemplateType() == TemplateType.TEMPLATE) {
            template.append(LR).append("[/template]");
        } else {
            template.append(LR).append("/]");
        }

        // Insertion of the template in the buffer and updating the CST
        buffer.insert(startPosition, template.toString());
        sourceContent.updateCST(0, buffer.length(), buffer.toString());
    }

    /**
     * Flush of the given buffer into the file.
     * <p>
     * Erases the original file's content.
     * 
     * @param file
     * @param buffer
     */
    private void saveContent(IFile file, StringBuffer buffer) {
        try {
            file.setContents(new ByteArrayInputStream(buffer.toString().getBytes()), 0, null);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * Label emitter creates and returns labels for Acceleo Mtl model elements.
     */
    protected AcceleoLabelEmitter labelEmitter;
    
	@Override
	public String emitElementLabel(EObject element) {
		if(labelEmitter == null){
			labelEmitter = new AcceleoLabelEmitter();
		}
		return labelEmitter.emitElementLabel(element);
	}
    
    
    
    
}
