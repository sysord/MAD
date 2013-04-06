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
package com.sysord.mad.core.preferences;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.core.Activator;

/**
 * Helper for the MAD preferences.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class PreferenceHelper {

	/*
	 * Preferences identifiers
	 */

	public static final String PREF_CONFIG_FILENAME = "madConfigurationFile";//$NON-NLS-1$
	public static final String PREF_LOGGER_LEVEL = "MADLoggerLevel";//$NON-NLS-1$
	public static final String PREF_LOGGER_TIME = "MADLoggerShowTime";//$NON-NLS-1$
	public static final String PREF_DEBUG_MODE = "MADDebugMode";//$NON-NLS-1$
	public static final String PREF_DISABLE_PROXIES = "MADProxiesDisabled";//$NON-NLS-1$
	public static final String PREF_SELECTED_LAYERS = "selectedLayers";//$NON-NLS-1$
	public static final String PREF_MODEL_AUTO_SAVE = "modelAutoSave";//$NON-NLS-1$

	/*
	 * Logger levels names
	 */

	public static final String LOG_LVL_ALL = "all";//$NON-NLS-1$
	public static final String LOG_LVL_DETAILED = "detailed";//$NON-NLS-1$
	public static final String LOG_LVL_NORMAL = "normal";//$NON-NLS-1$
	public static final String LOG_LVL_IMPORTANT = "important";//$NON-NLS-1$
	public static final String LOG_DISABLED = "disabled";//$NON-NLS-1$

	/*
	 * Utility methods
	 */

	private static IPreferenceStore store;

	/**
	 * Returns the MAD default preference store.
	 */
	public static IPreferenceStore getStore() {
		if (store == null) {
			store = Activator.getDefault().getPreferenceStore();
		}
		return store;
	}

	public static byte getLoggerLevel() {
		String level = getStore().getString(PreferenceHelper.PREF_LOGGER_LEVEL);
		byte lvl;
		if (level.equals(LOG_LVL_ALL)) {
			lvl = ConsoleLogger.VERY_HIGH | ConsoleLogger.NORMAL | ConsoleLogger.LOW | ConsoleLogger.VERY_LOW;
		} else if (level.equals(LOG_LVL_DETAILED)) {
			lvl = ConsoleLogger.VERY_HIGH | ConsoleLogger.NORMAL | ConsoleLogger.LOW;
		} else if (level.equals(LOG_LVL_NORMAL)) {
			lvl = ConsoleLogger.VERY_HIGH | ConsoleLogger.NORMAL;
		} else if (level.equals(LOG_LVL_IMPORTANT)) {
			lvl = ConsoleLogger.VERY_HIGH;
		} else if (level.equals(LOG_DISABLED)) {
			lvl = ConsoleLogger.DISABLED;
		} else {
			lvl = ConsoleLogger.VERY_HIGH | ConsoleLogger.NORMAL;
		}
		return lvl;
	}

	/**
	 * Returns the show time status of the logger.
	 * 
	 * @return the show time status of the logger.
	 */
	public static boolean getLoggerShowTime() {
		return getStore().getBoolean(PREF_LOGGER_TIME);
	}
	
	/**
	 * Returns the debug mode.
	 * 
	 * @return the debug mode.
	 */
	public static boolean getDebugMode() {
		return getStore().getBoolean(PREF_DEBUG_MODE);
	}

	/**
	 * Returns true if proxy mechanism is disabled
	 * 
	 * @return true if proxy mechanism is disabled.
	 */
	public static boolean isProxyMechanismDisabled() {
		return getStore().getBoolean(PREF_DISABLE_PROXIES);
	}

	/**
	 * Returns the MAD configuration files' URIs defined in the workspace preferences.
	 * 
	 * @return the MAD configuration files' URIs defined in the workspace preferences.
	 */
	public static List<URI> getMadConfigURIs() {
		List<String> filenamesList = getMadConfigFilenames();

		List<URI> files = new ArrayList<URI>(filenamesList.size());
		for (String filename : filenamesList) {
			try {
				final File file = EclipseTools.getFileFromURI(filename);
				final boolean exists = file != null && file.exists();
				if (exists) {
					files.add(URI.createURI(filename, true));
				}
			} catch (Exception e) {
				Activator.log(e);
			}
		}

		return files;
	}

	/**
	 * Returns the MAD configuration files' names defined in the workspace preferences.
	 * 
	 * @return the MAD configuration files' names defined in the workspace preferences.
	 */
	public static List<String> getMadConfigFilenames() {
		LinkedList<String> filenamesList = new LinkedList<String>();
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String filenames = store.getString(PREF_CONFIG_FILENAME);
		if (filenames.length() > 0) {
			Pattern filenamePattern = Pattern.compile("([^\\s,]+)(?:\\s*,\\s*)?");
			Matcher matcher = filenamePattern.matcher(filenames);
			while (matcher.find()) {
				filenamesList.add(matcher.group(1));
			}
		}
		return filenamesList;
	}

	/**
	 * Puts the given configuration files names into the preference store.
	 * 
	 * @param filenames
	 */
	public static void putMadConfigFilenames(Collection<String> filenames) {
		Set<String> savedFilenames = new LinkedHashSet<String>(getMadConfigFilenames());
		savedFilenames.addAll(filenames);
		setMadConfigFilenames(savedFilenames);
	}

	/**
	 * Saves the given configuration files names into the preference store.
	 * 
	 * @param filenames
	 */
	public static void setMadConfigFilenames(Collection<String> filenames) {
		StringBuilder names = new StringBuilder();
		char separator = ',';
		for (String filename : filenames) {
			names.append(filename);
			names.append(separator);
		}
		if (names.length() > 0) {
			names.deleteCharAt(names.length() - 1);
		}
		getStore().setValue(PreferenceHelper.PREF_CONFIG_FILENAME, names.toString());

		// Refresh the configuration manager files
		Activator.getDefault().getInjector().getInstance(ConfigurationManager.class).reloadConfigurations();
	}

	/**
	 * Indicates if the MAD foreign models must be automatically saved or not.
	 * 
	 * @return {@code true} if the models must be automatically saved; {@code false}
	 *         otherwise.
	 */
	public static boolean getAutoSave() {
		return getStore().getBoolean(PREF_MODEL_AUTO_SAVE);
	}
}
