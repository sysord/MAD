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

import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * Interface for listening to Ecore Model selection change.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface IModelSelectionListener {
    
    /**
     * Notifies this listener that the selection has changed.
     * 
     * @param selection The selection.
     */
    public void selectionChanged(IStructuredSelection selection);
}
