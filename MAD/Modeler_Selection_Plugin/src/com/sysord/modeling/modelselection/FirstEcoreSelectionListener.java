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
package com.sysord.modeling.modelselection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * A {@link IModelSelectionListener} notified for the selection changed of the first
 * element of this selection for Ecore elements.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class FirstEcoreSelectionListener extends AbstractEcoreSelectionListener {

    /**
     * Notifies this listener that the selection has changed.
     * 
     * @param eObject The ecore model EObject currently selected.
     */
    protected abstract void selectionChanged(EObject eObject);

    /*
     * (non-Javadoc)
     * @see
     * com.sysord.modeling.modelselection.IModelSelectionListener#selectionChanged(org
     * .eclipse.jface.viewers.IStructuredSelection)
     */
    @Override
    public void selectionChanged(IStructuredSelection selection) {
        Object element = selection.getFirstElement();
        selectionChanged(getEcoreElement(element));
    }
}
