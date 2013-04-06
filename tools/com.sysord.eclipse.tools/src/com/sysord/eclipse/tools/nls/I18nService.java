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
package com.sysord.eclipse.tools.nls;

import java.util.Locale;

/**
 * Service providing internationalization support.
 * <p>
 * Several bundles can be registered in this service.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface I18nService {

    /**
     * Registers the given bundle into this {@code I18nService}.
     * <p>
     * The bundle name is the qualified name (without extension nor <em>nl</em> suffix) of
     * the file containing the i18n values.
     * 
     * @param pluginId Id of the plug-in containing the i18n bundle.
     * @param bundleName Qualified name of the i18n bundle.
     */
    public void registerBundle(String pluginId, String bundleName);

    /**
     * Registers the given bundle into this {@code I18nService}.
     * <p>
     * The bundle name URI is a platform URI indicating where to find the I18N bundle :<br>
     * {@code platform:/<plugin|resource>[/<pathToTheBundle>]/<bundleName>}
     * 
     * @param bundleURI URI of the I18N bundle.
     */
    public void registerBundle(String bundleURI);

    /**
     * Returns the value corresponding to the given {@code key} and the environment
     * {@link Locale}.
     * 
     * @param key
     * @return the value corresponding to the given {@code key} and the environment
     *         {@link Locale}.
     */
    public String get(String key);

    /**
     * Returns the value corresponding to the given {@code key} and the environment
     * {@link Locale}.
     * <p>
     * The bindings objects are inserted into the value in the given order.
     * 
     * @param key
     * @param bindings
     * @return the value corresponding to the given {@code key} and the environment
     *         {@link Locale}.
     */
    public String get(String key, Object[] bindings);

    /**
     * Forces this service to reload all the registered bundles.
     * <p>
     * Can be useful if subclasses are keeping a cache of the values.
     */
    public void reload();

    /**
     * Forces this service to reload the given bundle. If the bundle is not registered in
     * this service, nothing happen.
     * <p>
     * Can be useful if subclasses are keeping a cache of the values.
     */
    public void reload(String bundleId, String bundleName);
}
