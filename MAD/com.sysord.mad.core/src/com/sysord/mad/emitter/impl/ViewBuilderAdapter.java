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
package com.sysord.mad.emitter.impl;

import com.sysord.mad.emitter.ViewBuilderListener;

/**
 * Abstract implementation of the {@link ViewBuilderListener}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class ViewBuilderAdapter implements ViewBuilderListener {

    protected int listenedEvents;

    /**
     * Create a default {@code ViewBuilderAdapter} listening to all
     * {@link ViewBuilderEvent}.
     */
    public ViewBuilderAdapter() {
        listenedEvents = ViewBuilderEvent.BUILD_ABOUT_TO_START | ViewBuilderEvent.TYPE_CONFIGURATION_LOADED
                | ViewBuilderEvent.MODEL_ELEMENT_VIEW_CREATED | ViewBuilderEvent.BUILD_VIEW_FINISHED;
    }

    /**
     * Create a {@code ViewBuilderAdapter} with the given bitwise listened events types.
     * 
     * @param listenedEvents
     */
    public ViewBuilderAdapter(int listenedEvents) {
        this.listenedEvents = listenedEvents;
    }

    @Override
    public int getListenedEvents() {
        return listenedEvents;
    }

}
