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
package com.sysord.eclipse.tools.swt;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * Description of an Image resource.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ImageResource {

    protected String imageURI;

    protected String bundleId;

    protected String imagePath;

    private String identifier;

    private URL imageURL;

    /**
     * Creates a new {@code ImageResource}.
     * 
     * @param imageURI
     */
    public ImageResource(String imageURI) {
        this.imageURI = imageURI;
    }

    /**
     * Creates a new {@code ImageResource}.
     * 
     * @param bundleId
     * @param imagePath
     */
    public ImageResource(String bundleId, String imagePath) {
        this.bundleId = bundleId;
        this.imagePath = imagePath;
    }

    /**
     * Defines the imageURI
     * 
     * @param imageURI The URI of the image.
     */
    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
        bundleId = null;
        imagePath = null;
        imageURL = null;
        identifier = null;
    }

    /**
     * Defines the Image with the given {@code bundleId} and {@code imagePath}.
     * 
     * @param bundleId Id of the plug-in containing the image.
     * @param imagePath Path into the plug-in of the image.
     */
    public void setImageBundle(String bundleId, String imagePath) {
        imageURI = null;
        this.bundleId = bundleId;
        this.imagePath = imagePath;
        imageURL = null;
        identifier = null;
    }

    /**
     * Returns this {@code ImageResource} {@link URL}.
     * 
     * @return this {@code ImageResource} {@link URL}.
     */
    public URL getURL() {
        if (imageURL == null) {
            if (imageURI != null) {
                imageURL = getURL(imageURI);
            } else {
                imageURL = getURL(bundleId, imagePath);
            }
        }
        return imageURL;
    }

    protected static URL getURL(String bundleId, String imageName) {
        URL imageURL = null;
        Bundle bundle = Platform.getBundle(bundleId);
        if (bundle != null) {
            imageURL = bundle.getResource(imageName);
        }
        // Todo Log error
        return imageURL;
    }

    protected static URL getURL(String imageURI) {
        URL imageURL;
        try {
            imageURL = new URL(imageURI);
        } catch (MalformedURLException e) {
            // TODO Log error
            imageURL = null;
        }
        return imageURL;
    }

    /**
     * Returns the unique identifier of this {@link ImageResource}.
     * 
     * @return the unique identifier of this {@link ImageResource}.
     */
    public String getImageIdentifier() {
        if (identifier == null) {
            if (imageURI != null) {
                identifier = imageURI;
            } else {
                identifier = bundleId + imagePath;
            }
        }
        return identifier;
    }
}
