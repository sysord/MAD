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

import com.sysord.mad.configuration.WidgetTypeConfiguration;
import com.sysord.mad.configuration.WidgetConfiguration.WIDGET_CATEGORY;

public class WidgetTypeConfigurationImpl implements WidgetTypeConfiguration {

	protected String id;
	protected WIDGET_CATEGORY category;
	protected String label;
	protected String description;
	protected String factoryClassName;
	
		
	public WidgetTypeConfigurationImpl(String id, WIDGET_CATEGORY category,
			String label, String description, String factoryClassName) {
		super();
		this.id = id;
		this.category = category;
		this.label = label;
		this.description = description;
		this.factoryClassName = factoryClassName;
	}

	@Override
	public String getWidgetTypeId() {
		return id;
	}

	@Override
	public WIDGET_CATEGORY getWidgetCategory() {
		return category;
	}

	@Override
	public String getWidgetTypeLabel() {
		return label;
	}

	@Override
	public String getWidgetTypeDescription() {
		return description;
	}

	@Override
	public String getFactoryClassName() {
		return factoryClassName;
	}

}
