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
package com.sysord.modeling.modelselection.contributor;

import org.eclipse.emf.ecore.EObject;

/**
 * A {@code ModelSelectionContributor} provides a method for converting an {@code Object}
 * into an {@link EObject} element.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface ModelSelectionContributor {

    /**
     * Returns the {@link EObject} related to the given {@code selectedElement}.
     * 
     * @param selectedElement The currently selected element.
     * @return the {@code EObject} related to the given {@code selectedElement}.
     */
    public EObject getEcoreElement(Object selectedElement);
}
