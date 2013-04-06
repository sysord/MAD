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
package com.sysord.mad.ui;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.eclipse.tools.swt.ImageResource;
import com.sysord.mad.core.Activator;

/**
 * The activator class controls the plug-in life cycle
 */
public class MadUiPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sysord.mad.ui"; //$NON-NLS-1$

    // The shared instance
    private static MadUiPlugin plugin;

    private static ConsoleLogger logger;

    /**
     * The constructor
     */
    public MadUiPlugin() {
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
    public static MadUiPlugin getDefault() {
        return plugin;
    }

    /**
     * Returns an {@link Image} corresponding to the given image name or {@code null} if
     * the image couln't be found.
     * <p>
     * The returned image is cached in this plug-in {@link ImageRegistry} and must
     * <strong>not</strong> be disposed externaly.
     * 
     * @param bundleId Id of the plug-in containing the image.
     * @param imageName Qualified name of the image to retrieve.
     * @return an {@link Image} corresponding to the given image name or {@code null}.
     */
    public static Image getImage(String bundleId, String imageName) {
        ImageResource imageResource = new ImageResource(bundleId, imageName);
        Image image = EclipseTools.getImageFromPlugin(getDefault(), imageResource);
        return image;
    }

    /**
     * Returns an {@link Image} corresponding to the given URI or {@code null} if
     * the image couln't be found.
     * <p>
     * The returned image is cached in this plug-in {@link ImageRegistry} and must
     * <strong>not</strong> be disposed externaly.
     * 
     * @param imageURI The image URI.
     * @return an {@link Image} corresponding to the given URI or {@code null}.
     */
    public static Image getImage(String imageURI) {
        ImageResource imageResource = new ImageResource(imageURI);
        Image image = EclipseTools.getImageFromPlugin(getDefault(), imageResource);
        return image;
    }

    /**
     * Returns the MAD {@link ConsoleLogger}.
     * 
     * @return the MAD {@link ConsoleLogger}.
     */
    public static ConsoleLogger getLogger() {
        if (logger == null) {
            logger = Activator.getDefault().getInjector().getInstance(ConsoleLogger.class);
        }
        return logger;
    }
}
