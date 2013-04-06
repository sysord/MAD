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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;

import com.sysord.emf.tools.EMFUtil;

/**
 * Provides images from EMF {@link ItemProviderAdapter}s.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class EMFImageProvider {

    /**
     * Returns the {@link Image} corresponding to the given {@link Notifier} element.
     * 
     * @param element The element for which to return the corresponding image.
     * @return the {@code Image} corresponding to the given {@code Notifier} element.
     */
    public Image getImageFor(Notifier element) {
        Image image = null;
        if (element != null) {
            ItemProviderAdapter providerAdapter = getItemProviderAdapter(element);
            if (providerAdapter != null) {
                Object imageURL = providerAdapter.getImage(element);
                image = ExtendedImageRegistry.getInstance().getImage(imageURL);
            }
        }
        return image;
    }

    /**
     * Returns the label corresponding to the given {@link Notifier} element.
     * 
     * @param element The element for which to return the corresponding label.
     * @return the label corresponding to the given {@code Notifier} element or null.
     */
    public String getLabelFor(Notifier element) {
        String label = null;
        if (element != null) {
            ItemProviderAdapter providerAdapter = getItemProviderAdapter(element);
            if (providerAdapter != null) {
                label = providerAdapter.getText(element);
            }
        }
        return label;
    }

    /**
     * Returns the {@link ItemProviderAdapter} corresponding to the given {@link Notifier}
     * element.
     * 
     * @param element The element for which to return the corresponding
     *        ItemProviderAdapter.
     * @return the {@code ItemProviderAdapter} corresponding to the given {@code Notifier}
     *         element or null.
     */
    public ItemProviderAdapter getItemProviderAdapter(Notifier element) {
        ItemProviderAdapter itemProvider = null;
        AdapterFactory factory = EMFUtil.getItemProviderAdapterFactoryFor(element);
        if (factory != null) {
            itemProvider = (ItemProviderAdapter) factory.adapt(element, null);
        }
        return itemProvider;
    }
}
