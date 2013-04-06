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

import org.eclipse.emf.common.notify.Adapter;

/**
 * {@link Adapter} with activatable behavior.
 * <p>
 * Activate/Deactivate it with {@link #setActive(boolean)}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface ActivatableAdapter extends Adapter {

    /**
     * Indicates if this {@code ActivatableAdapter} is active.
     * 
     * @return {@code true} if this {@code ActivatableAdapter} is active;<br>
     *         {@code false} otherwise.
     */
    public boolean isActive();

    /**
     * Set the activated status of this {@code ActivatableAdapter}.
     * 
     * @param active The new activated status.
     */
    public void setActive(boolean active);
}
