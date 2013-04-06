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

import com.sysord.mad.configuration.TypeConfiguration;

/**
 * A {@code ViewBuilderListener} is notified by {@link ViewBuilder}s on
 * {@link ViewBuilderEvent}s if the event flag corresponds to the listener flags.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface ViewBuilderListener {

    /**
     * Notified when a {@link ViewBuilderEvent} is thrown by a {@link ViewBuilder}.
     * 
     * @param event The thrown {@link ViewBuilderEvent} by the {@link ViewBuilder}.
     */
    public void builderEvent(ViewBuilderEvent event);

    /**
     * Returns the listened events flags.
     * 
     * @return the listened events flags.
     */
    public int getListenedEvents();

    /**
     * 
     * The {@code ViewBuilderEvent} are thrown by {@link ViewBuilder}s on the
     * {@link ViewBuilderListener}s having the corresponding build event flags.
     * <p>
     * Event flags :
     * <ul>
     * <li>{@link #BUILD_ABOUT_TO_START} : Fired before the the build start.</li>
     * <li>{@link #TYPE_CONFIGURATION_LOADED} : Fired when the {@link TypeConfiguration}
     * have been loaded.</li>
     * <li>{@link #MODEL_ELEMENT_VIEW_CREATED} : Fired when the {@link ModelElementView}
     * have been created.</li>
     * <li>{@link #BUILD_VIEW_FINISHED} : Fired when the build is finished.</li>
     * </ul>
     * 
     * @author Fabien Vignal <vignalf@gmail.com>
     */
    public static interface ViewBuilderEvent {

        /**
         * Flag for build about to start event.
         * <p>
         * This event occurs when a view build is about to start.
         */
        public static int BUILD_ABOUT_TO_START = 1;

        /**
         * Flag for loaded {@link TypeConfiguration} event.
         * <p>
         * This event occurs when the {@link TypeConfiguration} for the view have been
         * loaded.
         */
        public static int TYPE_CONFIGURATION_LOADED = 1 << 1;

        /**
         * Flag for created {@link ModelElementView} event.
         * <p>
         * This event occurs when the {@link ModelElementView} for the selected EObject
         * have been created.
         */
        public static int MODEL_ELEMENT_VIEW_CREATED = 1 << 2;

        /**
         * Flag for finished build view event.
         * <p>
         * This event occurs at the end of the view build.
         */
        public static int BUILD_VIEW_FINISHED = 1 << 3;

        /**
         * Returns the {@link ViewBuilder} on which this event occured.
         * 
         * @return the {@link ViewBuilder} on which this event occured.
         */
        public ViewBuilder getSource();

        /**
         * Returns this event type.
         * 
         * @return this event type.
         */
        public int getEventType();
    }
}
