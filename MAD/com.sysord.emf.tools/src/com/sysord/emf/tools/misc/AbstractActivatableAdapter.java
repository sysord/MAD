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
package com.sysord.emf.tools.misc;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * Abstract implementation of {@link ActivatableAdapter}.
 * <p>
 * An {@code AbstractActivatableAdapter} is activated by default and will receive
 * {@link Notification}s while {@link #isActive()} is {@code true}.
 * <p>
 * Activate/Deactivate it with {@link #setActive(boolean)}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractActivatableAdapter extends AdapterImpl implements ActivatableAdapter {

    private boolean active = true;

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public final void notifyChanged(Notification msg) {
        if (isActive()) {
            _notifyChanged(msg);
        }
    }

    /**
     * Notified when the listen EObject changes and if {@link #isActive()} returns
     * {@code true}.
     * 
     * @param msg
     */
    protected abstract void _notifyChanged(Notification msg);
}
