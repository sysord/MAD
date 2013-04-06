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

import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.emitter.WidgetFactory;
import com.sysord.mad.widget.*;

/**
 * Implementation of {@link WidgetSwitch} for the creation of MAD Widgets
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class EmitterWidgetSwitch extends WidgetSwitch<Widget<?>> {

    protected WidgetFactory widgetFactory;

    /**
     * Creation of a new EmitterWidgetSwitch with the {@link WidgetConfiguration} of the
     * widget to create.
     * 
     * @param widgetConfig
     */
    public EmitterWidgetSwitch(WidgetFactory widgetFactory) {
        this.widgetFactory = widgetFactory;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected Widget<?> caseFlexibleWidget() {
        FlexibleWidget<?> flexibleWidget = widgetFactory.createFlexibleWidget(widgetConfig);
        TypeConfiguration typeConfig = widgetConfig.getFlexibleTemplate();
        if(typeConfig != null){
        	// Flexible template is defined
            for (WidgetConfiguration<?> config : typeConfig.getWidgetsConfigurations()) {
                Widget widget = doSwitch(config);
                flexibleWidget.addWidget(widget);
            }        	
        }
        return flexibleWidget;
    }

    @Override
    protected Widget<?> caseCheckbox() {
        return widgetFactory.createCheckBoxWidget(widgetConfig);
    }
    
    @Override
    protected Widget<?> caseOutputText() {
        return widgetFactory.createOutputTextWidget(widgetConfig);
    }

    @Override
    protected Widget<?> caseTextbox() {
        return widgetFactory.createTextBoxWidget(widgetConfig);
    }

    @Override
    protected Widget<?> caseNumber() {
        return widgetFactory.createNumberWidget(widgetConfig);
    }

    @Override
    protected Widget<?> caseDate() {
        return widgetFactory.createDateWidget(widgetConfig);
    }

    @Override
    protected Widget<?> caseCombo() {
        return widgetFactory.createComboWidget(widgetConfig);
    }

    @Override
    protected Widget<?> caseMultiList() {
        return widgetFactory.createMultiListWidget(widgetConfig);
    }

    @Override
    protected Widget<?> caseTextDsl() {
        return widgetFactory.createTextDslWidget(widgetConfig);
    }

    @Override
    protected Widget<?> caseElementDsl() {
        return widgetFactory.createElementDslWidget(widgetConfig);
    }

    @Override
    protected Widget<?> caseNavigationList() {
        return widgetFactory.createListNavigationWidget(widgetConfig);
    }
}
