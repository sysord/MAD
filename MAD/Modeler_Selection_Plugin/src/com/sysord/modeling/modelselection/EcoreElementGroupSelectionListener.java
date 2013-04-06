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

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * Listener that will be notified for selection changed events and
 * that will select a group of similar EObject elements in the selection.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class EcoreElementGroupSelectionListener extends AbstractEcoreSelectionListener {

    /*
     * (non-Javadoc)
     * @see
     * com.sysord.modeling.modelselection.IModelSelectionListener#selectionChanged(org
     * .eclipse.jface.viewers.IStructuredSelection)
     */
    @Override
    public final void selectionChanged(IStructuredSelection selection) {
        List<EObject> elements = new ArrayList<EObject>(selection.size());
        Class<?> firstElementClass = null;
        for (Iterator<?> iterator = selection.iterator(); iterator.hasNext();) {
            EObject element = getEcoreElement(iterator.next());
            if (element != null) {
                if (firstElementClass == null) {
                    firstElementClass = element.getClass();
                }
                if (element.getClass() == firstElementClass) {
                    elements.add(element);
                }
            }
        }

        _selectionChanged(elements);
    }

    protected abstract void _selectionChanged(List<EObject> elements);
}
