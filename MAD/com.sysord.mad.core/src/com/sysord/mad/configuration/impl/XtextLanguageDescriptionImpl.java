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
package com.sysord.mad.configuration.impl;

import com.sysord.mad.configuration.XtextLanguageDescription;

public class XtextLanguageDescriptionImpl implements XtextLanguageDescription {

	protected String bundleId;
	protected String activatorClassname;
	protected String languageName;
	
	public XtextLanguageDescriptionImpl(String bundleId, String activatorClassname, String languageName) {
		super();
		this.bundleId = bundleId;
		this.activatorClassname = activatorClassname;
		this.languageName = languageName;
	}

	@Override
	public String getBundleId() {
		return bundleId;
	}

	@Override
	public String getActivatorClassName() {
		return activatorClassname;
	}

	@Override
	public String getLanguageName() {
		return languageName;
	}

}
