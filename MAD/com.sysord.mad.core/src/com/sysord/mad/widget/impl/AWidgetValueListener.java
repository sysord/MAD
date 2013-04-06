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
package com.sysord.mad.widget.impl;

import com.sysord.mad.widget.WidgetValueListener;

/**
 * Default implementation for the {@link WidgetValueListener}.
 * It takes account of the active state of the listener.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AWidgetValueListener<T> implements WidgetValueListener<T> {

    private boolean active = true;

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void valueChanged(T ancientValue, T newValue) {
        if (active) {
            _valueChanged(ancientValue, newValue);
        }
    }

    /**
     * Notifies this listener that the value of the listened widget has changed. <br>
     * Notification happen only if this listener is active.
     * 
     * @param ancientValue
     * @param newValue
     */
    protected abstract void _valueChanged(T ancientValue, T newValue);

}
