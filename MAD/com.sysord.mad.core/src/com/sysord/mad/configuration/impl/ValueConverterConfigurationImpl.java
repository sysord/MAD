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

import com.sysord.mad.configuration.ValueConverterConfiguration;

public class ValueConverterConfigurationImpl implements ValueConverterConfiguration {

	protected VALUE_CONVERTER_CATEGORY category;
	protected String configuration;
	
	
	public ValueConverterConfigurationImpl(VALUE_CONVERTER_CATEGORY category, String configuration) {
		super();
		this.category = category;
		this.configuration = configuration;
	}

	@Override
	public VALUE_CONVERTER_CATEGORY getCategory() {		
		return category;
	}

	@Override
	public String getConfiguration() {
		return configuration;
	}

}
