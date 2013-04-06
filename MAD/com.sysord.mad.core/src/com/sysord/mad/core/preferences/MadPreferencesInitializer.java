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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.sysord.mad.core.Activator;

/**
 * Preferences initializer for MAD Configuration.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class MadPreferencesInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceHelper.PREF_CONFIG_FILENAME, "platform:/plugin/com.sysord.mad.core/model/config.mad");
		store.setDefault(PreferenceHelper.PREF_LOGGER_LEVEL, PreferenceHelper.LOG_LVL_NORMAL);
		store.setDefault(PreferenceHelper.PREF_LOGGER_TIME, true);
		store.setDefault(PreferenceHelper.PREF_DEBUG_MODE, false);
		store.setDefault(PreferenceHelper.PREF_DISABLE_PROXIES, false);
		store.setDefault(PreferenceHelper.PREF_MODEL_AUTO_SAVE, true);
	}

}
