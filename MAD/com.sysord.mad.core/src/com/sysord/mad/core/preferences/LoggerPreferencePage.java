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

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.core.Activator;

/**
 * Preference Page for the MAD Logger.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class LoggerPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public static final String PREF_LOGGER_PAGE_DESCRIPTION = "MAD Logger preferences\n";
	public static final String LBL_LOGGER_LEVEL = "Minimum level of log to show";
	private static final String LBL_SHOW_TIME = "Show messages times";

	/**
	 * Create a Logger preference page with {@link FieldEditorPreferencePage#GRID} as
	 * style.
	 */
	public LoggerPreferencePage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(PREF_LOGGER_PAGE_DESCRIPTION);
	}

	@Override
	protected void createFieldEditors() {
		createLoggerLevelField();
		createLoggerShowTimeField();
	}

	/**
	 * Creates the field for the logger level preferences.
	 */
	protected void createLoggerLevelField() {
		String[][] labelAndValues = {
				{ "All", PreferenceHelper.LOG_LVL_ALL },
				{ "Detailed", PreferenceHelper.LOG_LVL_DETAILED },
				{ "Normal", PreferenceHelper.LOG_LVL_NORMAL },
				{ "Only Important logs", PreferenceHelper.LOG_LVL_IMPORTANT },
				{ "Disabled", PreferenceHelper.LOG_DISABLED } };
		RadioGroupFieldEditor editor = new RadioGroupFieldEditor(PreferenceHelper.PREF_LOGGER_LEVEL, LBL_LOGGER_LEVEL,
				1, labelAndValues, getFieldEditorParent(), true);
		addField(editor);
	}

	protected void createLoggerShowTimeField() {
		BooleanFieldEditor showTimeField = new BooleanFieldEditor(PreferenceHelper.PREF_LOGGER_TIME, LBL_SHOW_TIME,
				getFieldEditorParent());
		addField(showTimeField);
	}


	@Override
	public boolean performOk() {
		if (super.performOk()) {
			ConsoleLogger logger = Activator.getDefault().getInjector().getInstance(ConsoleLogger.class);
			logger.setLoggerLevel(PreferenceHelper.getLoggerLevel());
			logger.showTime(PreferenceHelper.getLoggerShowTime());
			return true;
		}// else
		return false;
	}
}
