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
package com.sysord.eclipse.tools;

import org.eclipse.core.runtime.*;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EclipseToolsPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sysord.eclipse.tools"; //$NON-NLS-1$

    // The shared instance
    private static EclipseToolsPlugin plugin;

    /**
     * The constructor
     */
    public EclipseToolsPlugin() {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static EclipseToolsPlugin getDefault() {
        return plugin;
    }

    /**
     * Logs the given {@link Exception exception}.
     * 
     * @param exception The {@code exception} to log.
     */
    public static void log(Exception exception) {
        log(exception.getMessage(), IStatus.ERROR, exception);
    }

    /**
     * Logs the given message with the specified {@code severity}.
     * <p>
     * The {@code severity} is one of :
     * <ul>
     * <li>{@link IStatus#INFO}</li>
     * <li>{@link IStatus#WARNING}</li>
     * <li>{@link IStatus#ERROR}</li>
     * </ul>
     * 
     * @param message The message to log.
     * @param severity The severity of the message.
     */
    public static void log(String message, int severity) {
        log(message, severity, null);
    }

    /**
     * Logs the given message with the specified {@code severity} and {@link Exception
     * exception}.
     * <p>
     * The {@code severity} is one of :
     * <ul>
     * <li>{@link IStatus#INFO}</li>
     * <li>{@link IStatus#WARNING}</li>
     * <li>{@link IStatus#ERROR}</li>
     * </ul>
     * The {@code exception} can be {@code null}.
     * 
     * @param message The message to log.
     * @param severity The severity of the message.
     * @param exception The originating exception.
     */
    public static void log(String message, int severity, Exception exception) {
        ILog log = getDefault().getLog();
        IStatus status = new Status(severity, PLUGIN_ID, message, exception);
        log.log(status);
    }
}
