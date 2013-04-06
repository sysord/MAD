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
package com.sysord.modeling.selection.gmf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;

import com.sysord.modeling.modelselection.contributor.ModelSelectionContributor;

/**
 * {@link ModelSelectionContributor} for GMF.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class GmfSelectionContributor implements ModelSelectionContributor {

    @Override
    public EObject getEcoreElement(Object selectedElement) {
        if (selectedElement instanceof EditPart) {
            Object modelElement = ((EditPart) selectedElement).getModel();

            if (modelElement instanceof Node) {
                return ((Node) modelElement).getElement();
            }// else

            if (modelElement instanceof Diagram) {
                return ((Diagram) modelElement).getElement();
            }// else
        }
        
        return null;
    }

}
