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


import java.util.Date;

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.emitter.WidgetFactory;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.impl.*;

/**
 * 
 * Default implementation of the WidgetFactory.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class WidgetFactoryImpl implements WidgetFactory {
    
    /**
     * Default constructor
     */
    public WidgetFactoryImpl() {
        super();
    }
    
	@Override
	public ComposedWidget<?> createComposedWidget(WidgetConfiguration<?> config) {
        ComposedWidget<?> composedWidget = new ComposedWidgetImpl(config.getWidgetValueType());
        composedWidget.setConfig((WidgetConfiguration) config);
        return composedWidget;
	}

    @Override
    public FlexibleWidget<?> createFlexibleWidget(WidgetConfiguration<?> config) {
        FlexibleWidget<?> flexibleWidget = new FlexibleWidgetImpl(config.getWidgetValueType());
        flexibleWidget.setConfig((WidgetConfiguration) config);
        return flexibleWidget;
    }

    @Override
    public TextDslWidget createTextDslWidget(WidgetConfiguration<?> config) {
        TextDslWidgetImpl textDslWidgetImpl = new TextDslWidgetImpl();
        textDslWidgetImpl.setConfig((WidgetConfiguration<String>) config);
        return textDslWidgetImpl;
    }

    @Override
    public ElementDslWidget createElementDslWidget(WidgetConfiguration<?> config) {
        ElementDslWidgetImpl elementDslWidget = new ElementDslWidgetImpl();
        elementDslWidget.setConfig((WidgetConfiguration<EObject>) config);
        return elementDslWidget;
    }

    @Override
    public CheckBoxWidget createCheckBoxWidget(WidgetConfiguration<?> config) {
        CheckBoxWidget checkBoxWidget = new CheckBoxWidget();
        checkBoxWidget.setConfig((WidgetConfiguration<Boolean>) config);
        return checkBoxWidget;
    }

    @Override
    public ComboWidget<?> createComboWidget(WidgetConfiguration<?> config) {
        ComboWidget<?> comboWidget = new ComboWidget(config.getWidgetValueType());
        comboWidget.setConfig((WidgetConfiguration) config);
        return comboWidget;
    }
    
    @Override
    public ListNavigationWidget createListNavigationWidget(WidgetConfiguration<?> config) {
        final ListNavigationWidget listNavigationWidget = new ListNavigationWidget();
        listNavigationWidget.setConfig((WidgetConfiguration) config);
        return listNavigationWidget;
    }

    @Override
    public MultiListWidget<?> createMultiListWidget(WidgetConfiguration<?> config) {
        MultiListWidget<?> multiListWidget = new MultiListWidget(config.getWidgetValueType());
        multiListWidget.setConfig((WidgetConfiguration) config);
        return multiListWidget;
    }
    
    @Override
    public OutputWidget<String> createOutputTextWidget(WidgetConfiguration<?> config) {
        OutputWidget<String> outputWidget = new OutputTextWidget();
        outputWidget.setConfig((WidgetConfiguration<String>) config);
        return outputWidget;
    }

    @Override
    public TextBoxWidget createTextBoxWidget(WidgetConfiguration<?> config) {
        TextBoxWidget textBoxWidget = new TextBoxWidget();
        textBoxWidget.setConfig((WidgetConfiguration<String>) config);
        return textBoxWidget;
    }

    @Override
    public BasicTypeWidget<Date> createDateWidget(WidgetConfiguration<?> config) {
        DateWidget dateWidget = new DateWidget();
        dateWidget.setConfig((WidgetConfiguration<Date>) config);
        return dateWidget;
    }

    @Override
    public BasicTypeWidget<Number> createNumberWidget(WidgetConfiguration<?> config) {
        NumberWidget numberWidget = new NumberWidget();
        numberWidget.setConfig((WidgetConfiguration<Number>) config);
        return numberWidget;
    }


}
