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
package com.sysord.modeling.selection.obeo;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;

import com.sysord.modeling.modelselection.contributor.ModelSelectionContributor;

import fr.obeo.dsl.viewpoint.DRepresentationElement;
import fr.obeo.dsl.viewpoint.DSemanticDiagram;

/**
 * {@link ModelSelectionContributor} for <a
 * href="http://marketplace.obeonetwork.com/module/uml">UML Designer</a>
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ObeoSelectionContributor implements ModelSelectionContributor {

    @Override
    public EObject getEcoreElement(Object selectedElement) {
        if (selectedElement instanceof EditPart) {
            Object modelElement = ((EditPart) selectedElement).getModel();

            if (modelElement instanceof Node) {
                EObject element = ((Node) modelElement).getElement();
                if (element instanceof DRepresentationElement) {
                    return ((DRepresentationElement) element).getTarget();
                }// else
            }

            if (modelElement instanceof Diagram) {
                EObject element = ((Diagram) modelElement).getElement();
                if (element instanceof DSemanticDiagram) {
                    return ((DSemanticDiagram) element).getTarget();
                }// else
            }
        }
        
        return null;
    }

}
