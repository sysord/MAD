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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * Images registered by the {@link EclipseToolsPlugin}.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface IToolsSharedImages {
    
    /**
     * Instance of the {@link IToolsSharedImages} implementation.
     */
    public static final IToolsSharedImages instance = new ToolsSharedImages();

    /**
     * Resource name for the Refresh {@link Image}.
     */
    public static final String IMG_REFRESH = "resources/refresh.png"; //$NON-NLS-1$

    /**
     * Resource name for the disabled Refresh {@link Image}.
     */
    public static final String IMG_REFRESH_DISABLED = "resources/refresh_disabled.png"; //$NON-NLS-1$
    
    /**
     * Returns the {@link ImageDescriptor} for the given resource name, or {@code null} if
     * the resource has not been found.
     * 
     * @param resourceName Name of the image resource.
     * @return the {@link ImageDescriptor} for the given resource name.
     */
    public ImageDescriptor getImageDescriptor(String resourceName);
    
    /**
     * Returns the {@link Image} for the given resource name, or {@code null} if
     * the resource has not been found.
     * 
     * @param resourceName Name of the image resource.
     * @return the {@link ImageDescriptor} for the given resource name.
     */
    public Image getImage(String resourceName);
}
