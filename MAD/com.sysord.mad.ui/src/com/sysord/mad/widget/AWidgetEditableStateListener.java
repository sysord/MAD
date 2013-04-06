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
package com.sysord.mad.widget;

import com.sysord.mad.widget.WidgetEditableStateListener;

/**
 * Default implementation for the {@link WidgetEditableStateListener}.
 * It takes account of the active state of the listener.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AWidgetEditableStateListener implements WidgetEditableStateListener {

    private boolean active;

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void editableStateChanged(boolean newEditableState) {
        if (active) {
            _editableStateChanged(newEditableState);
        }
    }

    /**
     * Notifies this listener that the editable state of this Widget has changed. <br>
     * Notification happen only if this listener is active.
     * 
     * @param newEditableState
     */
    protected abstract void _editableStateChanged(boolean newEditableState);

}
