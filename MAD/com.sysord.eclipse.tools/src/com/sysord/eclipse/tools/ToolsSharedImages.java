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

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * Implementation of the {@link IToolsSharedImages} interface.
 * <p>
 * Supplies methods for obtaining Images registered by the {@link EclipseToolsPlugin}.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ToolsSharedImages implements IToolsSharedImages {

    ToolsSharedImages() {
    }

    @Override
    public ImageDescriptor getImageDescriptor(String resourceName) {
        ImageRegistry imageRegistry = EclipseToolsPlugin.getDefault().getImageRegistry();
        ImageDescriptor descriptor = imageRegistry.getDescriptor(resourceName);
        if (descriptor == null) {
            URL resource = EclipseToolsPlugin.getDefault().getBundle().getResource(resourceName);
            if (resource != null) {
                descriptor = ImageDescriptor.createFromURL(resource);
                imageRegistry.put(resourceName, descriptor);
            }
        }
        return descriptor;
    }

    @Override
    public Image getImage(String resourceName) {
        ImageDescriptor descriptor = getImageDescriptor(resourceName);
        Image image = null;
        if (descriptor != null) {
            image = EclipseToolsPlugin.getDefault().getImageRegistry().get(resourceName);
        }
        return image;
    }
}
