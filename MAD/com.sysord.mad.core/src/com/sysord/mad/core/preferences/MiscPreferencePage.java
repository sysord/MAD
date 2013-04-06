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
 * Preference Page for Misc sesstings.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class MiscPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public static final String PREF_MISC_PAGE_DESCRIPTION = "Misc preferences\n";
	private static final String LBL_DEBUG_MODE = "Activate/Deactivate debug mode";
	public static final String LBL_DISABLE_PROXY = "Disable Proxies creation";

	/**
	 * Create a Misc preference page with {@link FieldEditorPreferencePage#GRID} as
	 * style.
	 */
	public MiscPreferencePage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(PREF_MISC_PAGE_DESCRIPTION);
	}

	@Override
	protected void createFieldEditors() {
		createDebugModeField();
		createDisableProxiesField();
	}


	protected void createDebugModeField() {
		BooleanFieldEditor debugModeField = new BooleanFieldEditor(PreferenceHelper.PREF_DEBUG_MODE, LBL_DEBUG_MODE,
				getFieldEditorParent());
		addField(debugModeField);
	}

	protected void createDisableProxiesField() {
		BooleanFieldEditor disabledProxiesField = new BooleanFieldEditor(PreferenceHelper.PREF_DISABLE_PROXIES, LBL_DISABLE_PROXY,
				getFieldEditorParent());
		addField(disabledProxiesField);
	}

}
