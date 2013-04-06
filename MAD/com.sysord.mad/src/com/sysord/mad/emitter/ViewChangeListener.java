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
package com.sysord.mad.emitter;

/**
 * Listening for {@link ModelElementView}'s changes.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ModelElementView
 */
public interface ViewChangeListener {

    /**
     * Notifies this listener that the given {@link ModelElementView} has changed.
     * 
     * @param view
     */
    public void viewChanged(ModelElementView view);
}
