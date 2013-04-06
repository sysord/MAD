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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.configuration.WidgetConfiguration;

public class TypeConfigurationImpl implements TypeConfiguration {

	protected EClass type;
	
	//protected List<WidgetConfiguration> widgetsConfigurations = new ArrayList<WidgetConfiguration>() ;
	protected Map<String, WidgetConfiguration<?>> widgetsConfigurations = new LinkedHashMap<String, WidgetConfiguration<?>>();
	
		
	public TypeConfigurationImpl(EClass type) {
		super();
		this.type = type;
	}

	@Override
	public EClass getType() {
		return type;
	}

	@Override
	public void setType(EClass type) {
		this.type = type;
	}

	@Override
	public WidgetConfiguration addWidgetConfigurations(WidgetConfiguration widgetConfiguration) {
		return widgetsConfigurations.put(widgetConfiguration.getName(), widgetConfiguration);
	}
	
	@Override
	public Collection<WidgetConfiguration<?>> getWidgetsConfigurations() {
		return Collections.unmodifiableCollection(widgetsConfigurations.values()) ;
	}

	@Override
	public String toString() {
		return "TypeConfigurationImpl [type=" + type
				+ ", widgetsConfigurations=" + widgetsConfigurations + "]";
	}
	
	
	

}
