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

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.emitter.WidgetFactory;
import com.sysord.mad.widget.ComposedWidget;
import com.sysord.mad.widget.FlexibleWidget;
import com.sysord.mad.widget.Widget;

/**
 * Create and add widgets for a Composed widget
 * widgets are 
 */
public class ComposedWidgetConfigurer {

	@Inject
	protected ConfigurationManager configurationManager;
	
	@Inject
	protected WidgetFactory widgetFactory;
	
	@SuppressWarnings("unchecked")
	public <T> void configure(FlexibleWidget<T> flexibleWidget, Collection<Object> items) {
		TypeConfiguration config = null;
		for(Object composedItem : items){
			if (composedItem != null) {
				EClass eclass = ((EObject) composedItem).eClass();
				if (eclass != null) {
					config = configurationManager.getConfiguration(eclass);
					if (config != null) {
						break;
					}
				}
			}
		}
		if (config != null) {
			EmitterWidgetSwitch widgetSwitch = new EmitterWidgetSwitch(widgetFactory);
			for (WidgetConfiguration<?> widgetConfig : config.getWidgetsConfigurations()) {
				flexibleWidget.addWidget((Widget<T>) widgetSwitch.doSwitch(widgetConfig));
			}
		}
	}
	
	
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
