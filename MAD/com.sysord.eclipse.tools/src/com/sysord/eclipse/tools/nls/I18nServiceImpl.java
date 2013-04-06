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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

import com.sysord.eclipse.tools.EclipseToolsPlugin;
import com.sysord.eclipse.tools.L;

/**
 * Default implementation of the {@link I18nService} interface.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class I18nServiceImpl implements I18nService {

    private static final String EXTENSION = ".properties"; //$NON-NLS-1$

    private static String[] nlSuffixes;

    protected Locale locale;

    protected Map<String, I18nBundle> registeredBundles = new TreeMap<String, I18nBundle>();

    /**
     * Creates a new {@code I18nServiceImpl}.
     */
    public I18nServiceImpl() {
    }

    /**
     * Creates a new {@code I18nServiceImpl} for the given {@code bundleName}.
     * 
     * @param bundleName
     */
    public I18nServiceImpl(String pluginId, String bundleName) {
        registerBundle(pluginId, bundleName);
    }

    @Override
    public void registerBundle(String pluginId, String bundleName) {
        String key = pluginId + bundleName;
        I18nBundle bundle = new I18nBundle(pluginId, bundleName);
        registeredBundles.put(key, bundle);
        bundle.load();
    }

    @Override
    public void registerBundle(String bundleURI) {
        I18nBundle bundle = new I18nBundle(bundleURI);
        registeredBundles.put(bundleURI, bundle);
        bundle.load();
    }

    @Override
    public String get(String key) {
        return get(key, null);
    }

    @Override
    public String get(String key, Object[] bindings) {
        checkLocale();
        String value = null;
        Iterator<I18nBundle> bundleIterator = registeredBundles.values().iterator();
        while (value == null && bundleIterator.hasNext()) {
            I18nBundle bundle = bundleIterator.next();
            value = bundle.getProperty(key);
        }
        if (value != null && bindings != null && bindings.length > 0) {
            value = NLS.bind(value, bindings);
        }
        return value;
    }

    /**
     * Checks if the default locale changed since last time.
     * <p>
     * If the locale changed, the bundles will be reloaded.
     */
    protected void checkLocale() {
        Locale locale = Locale.getDefault();
        if (!locale.equals(this.locale)) {
            this.locale = locale;
            // Set the bundle's property to null
            for (I18nBundle bundle : registeredBundles.values()) {
                bundle.nlProperties = null;
            }
            // Reset the nl suffixes
            nlSuffixes = null;
        }
    }

    @Override
    public void reload() {
        for (I18nBundle bundle : registeredBundles.values()) {
            bundle.load();
        }
    }

    @Override
    public void reload(String bundleId, String bundleName) {
        I18nBundle bundle = registeredBundles.get(bundleId + bundleName);
        if (bundle != null) {
            bundle.load();
        }
    }

    /**
     * <em>Code used in the method buildVariants from {@link NLS} class</em>.
     * 
     * @param root
     * @param replaceDots Indicates if the dots have to be replaced by slashes.
     * @see NLS
     */
    protected static String[] buildVariants(String root, boolean replaceDots) {
        if (nlSuffixes == null) {
            // build list of suffixes for loading resource bundles
            String nl = Locale.getDefault().toString();
            List<String> result = new ArrayList<String>(4);
            int lastSeparator;
            while (true) {
                result.add('_' + nl + EXTENSION);
                lastSeparator = nl.lastIndexOf('_');
                if (lastSeparator == -1)
                    break;
                nl = nl.substring(0, lastSeparator);
            }
            // add the empty suffix last (most general)
            result.add(EXTENSION);
            nlSuffixes = result.toArray(new String[result.size()]);
        }
        if (root.endsWith(EXTENSION)) {//$NON-NLS-1$
        	// Suppressing file extension
        	root = root.replaceFirst("\\" + EXTENSION + "$", "");//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
        }
        if (replaceDots) {
            root = root.replace('.', '/');
        }
        String[] variants = new String[nlSuffixes.length];
        for (int i = 0; i < variants.length; i++) {
            variants[i] = root + nlSuffixes[i];
        }
        return variants;
    }

    protected static class I18nBundle {

        protected Properties nlProperties;

        protected String pluginId;

        protected String bundleName;

        protected String bundleURL;

        /**
         * Creates a new {@code I18nBundle}.
         * 
         * @param pluginId
         * @param bundleName
         */
        public I18nBundle(String pluginId, String bundleName) {
            this.pluginId = pluginId;
            this.bundleName = bundleName;
        }

        /**
         * Creates a new {@code I18nBundle} with the given URL.
         * 
         * @param pluginId
         * @param bundleName
         */
        public I18nBundle(String bundleURL) {
            this.bundleURL = bundleURL;
        }

        /**
         * Return the value of pluginId.
         * 
         * @return the value of pluginId.
         */
        public String getPluginId() {
            return pluginId;
        }

        /**
         * Return the value of bundleName.
         * 
         * @return the value of bundleName.
         */
        public String getBundleName() {
            return bundleName;
        }

        /**
         * Returns the property corresponding to the given key, or {@code null}.
         * 
         * @param key
         * @return the property corresponding to the given key, or {@code null}.
         */
        public String getProperty(String key) {
            if (nlProperties == null) {
                load();
            }
            return nlProperties == null ? null : nlProperties.getProperty(key);
        }

        /**
         * Load the bundle file into a {@link Properties} object.
         */
        protected void load() {
            if (bundleURL != null) {
                loadFromURL();
                return;
            }// else

            Bundle bundle = Platform.getBundle(pluginId);
            if (bundle == null) {
                EclipseToolsPlugin.log(L.bind(L.error_noBundleFound, pluginId), IStatus.WARNING);
            } else {
                String[] variants = buildVariants(bundleName, true);
                URL nlFileURL = bundle.getResource(variants[0]);
                int i = 1;
                while (i < variants.length && nlFileURL == null) {
                    nlFileURL = bundle.getResource(variants[i]);
                    i++;
                }
                if (nlFileURL != null) {
                    InputStream stream = null;
                    try {
                        stream = nlFileURL.openStream();
                        nlProperties = new Properties();
                        nlProperties.load(stream);
                    } catch (IOException e) {
                        EclipseToolsPlugin.log(e);
                    } finally {
                        try {
                            if (stream != null) {
                                stream.close();
                            }
                        } catch (IOException e) {
                            // ignore
                        }
                    }
                } else {
                    EclipseToolsPlugin.log(L.bind(L.error_noI18NFound, pluginId + " " + bundleName), IStatus.WARNING);//$NON-NLS-1$
                }
            }
        }

        /**
         * Loads a bundle file from an {@link URL}.
         */
        protected void loadFromURL() {
            String[] variants = buildVariants(bundleURL, false);
            URL nlFileURL = null;
            InputStream stream = null;
            int i = 0;
            while (i < variants.length && nlFileURL == null) {
                try {
                    nlFileURL = new URL(variants[i]);
                    stream = nlFileURL.openStream();
                } catch (MalformedURLException e) {
                    EclipseToolsPlugin.log(e);
                } catch (IOException e) {
                    nlFileURL = null;
                }
                i++;
            }
            if (nlFileURL != null && stream != null) {
                try {
                    nlProperties = new Properties();
                    nlProperties.load(stream);
                } catch (IOException e) {
                    EclipseToolsPlugin.log(e);
                } finally {
                    try {
                        if (stream != null) {
                            stream.close();
                        }
                    } catch (IOException e) {
                        // ignore
                    }
                }
            } else {
                EclipseToolsPlugin.log(L.bind(L.error_noI18NFound, bundleURL), IStatus.WARNING);
            }
        }
    }
}
