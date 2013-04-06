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
package com.sysord.mad.emitter.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.sysord.mad.configuration.*;
import com.sysord.mad.emitter.WidgetFactory;
import com.sysord.mad.widget.ComposedWidget;

/**
 * Create and add widgets for a Composed widget
 * widgets are 
 */
public class ComposedWidgetConfigurer {

	@Inject
	protected ConfigurationManager configurationManager;
	
	@Inject
	protected WidgetFactory widgetFactory;
	
	
	public void configureComposedWidget(ComposedWidget<?> composedWidget){
		
		EObject value = (EObject) composedWidget.getValuedSemanticElement().getValue();
		if(value == null) return;
		EClass valueType = value.eClass();
		
		//Load configuration for the value type
		TypeConfiguration typeConfig = configurationManager.getConfiguration(valueType);
		if(typeConfig != null){
			//Create and add widgets
			EmitterWidgetSwitch emitterSwitch = new EmitterWidgetSwitch(widgetFactory);
			for(WidgetConfiguration<?> widgetConfiguration : typeConfig.getWidgetsConfigurations()){
				composedWidget.addWidget(emitterSwitch.doSwitch(widgetConfiguration));
			}			
		}
		
	}

}
