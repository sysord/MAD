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
package com.sysord.mad.ui.swt;

import com.sysord.emf.tools.misc.ActivatableAdapter;
import com.sysord.mad.widget.WidgetValueListener;

/**
 * A ModelAction is an action with the goal to execute operations on the model.
 * <p>
 * The {@link WidgetValueListener} and the {@link ActivatableAdapter}s will be deactivated
 * before the execution and re-activated after.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class ModelAction {

    private WidgetValueListener<?> valueListener;
    private ActivatableAdapter[] adapters;

    /**
     * Construct a new ModelAction.
     * 
     * @param valueListener
     * @param adapters
     */
    public ModelAction(WidgetValueListener<?> valueListener, ActivatableAdapter... adapters) {
        this.valueListener = valueListener;
        this.adapters = adapters;
    }

    /**
     * Execute the defined action in an async SWT operation if the {@link #canRun()}
     * method returns {@code true}.
     */
    public void execute() {
        SWTHelper.execute(new Runnable() {

            @Override
            public void run() {
                synchronized (getLock()) {
                    if (canRun()) {
                        valueListener.setActive(false);
                        SWTWidgetUtil.deactivateAdapters(adapters);
                        action();
                        SWTWidgetUtil.activateAdapters(adapters);
                        valueListener.setActive(true);
                    }
                }
            }
        });
    }

    /**
     * The model action to execute.
     */
    protected abstract void action();

    /**
     * Indicates if this {@code ModelAction} can be run.
     * <p>
     * This method return {@code true} by default, and should be overridden in subclasses
     * if this action is conditional.
     * 
     * @return {@code true} if this {@code ModelAction} can be run; {@code false}
     *         otherwise.
     */
    protected boolean canRun() {
        return true;
    }
    
    /**
     * Provides an Object's instance for lock purposes.
     * <p>
     * Return {@code this} by default.
     * 
     * @return an Object's instance for lock purposes.
     */
    protected Object getLock() {
        return this;
    }
}
