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
package com.sysord.mad.emitter;

import java.util.Date;

import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.widget.*;

/**
 * A factory for creating {@link Widget}s.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ViewEmitter
 * @see WidgetSwitch
 */
public interface WidgetFactory {

    /**
     * Creates a new {@link ComposedWidget}.
     * 
     * @param config The widget's configuration.
     * @return the created {@code ComposedWidget}.
     */
    public ComposedWidget<?> createComposedWidget(WidgetConfiguration<?> config);

    /**
     * Creates a new {@link FlexibleWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created {@code FlexibleWidget}.
     */
    public FlexibleWidget<?> createFlexibleWidget(WidgetConfiguration<?> config);

    /**
     * Creates a new {@link TextDslWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created {@code TextDslWidget}.
     */
    public TextDslWidget createTextDslWidget(WidgetConfiguration<?> config);

    /**
     * Creates a new {@link ElementDslWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created {@code ElementDslWidget}.
     */
    public ElementDslWidget createElementDslWidget(WidgetConfiguration<?> config);

    /**
     * Creates a new boolean {@link BasicTypeWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created boolean {@code BasicTypeWidget}.
     */
    public BasicTypeWidget<Boolean> createCheckBoxWidget(WidgetConfiguration<?> config);

    /**
     * Creates a new combo {@link SingleSelectWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created combo {@code SingleSelectWidget}.
     */
    public SingleSelectWidget<?> createComboWidget(WidgetConfiguration<?> config);

    /**
     * Creates a new list {@link NavigationWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created list {@code NavigationWidget}.
     */
    public NavigationWidget createListNavigationWidget(WidgetConfiguration<?> config);

    /**
     * Creates a new list {@link MultiSelectWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created list {@code MultiSelectWidget}.
     */
    public MultiSelectWidget<?> createMultiListWidget(WidgetConfiguration<?> config);

    /**
     * Creates a new output text {@link OutputWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created output text {@code OutputWidget}.
     */
    public OutputWidget<String> createOutputTextWidget(WidgetConfiguration<?> config);

    /**
     * Creates a new text box {@link BasicTypeWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created text box {@code BasicTypeWidget}.
     */
    public BasicTypeWidget<String> createTextBoxWidget(WidgetConfiguration<?> config);
    
    /**
     * Creates a new Date {@link BasicTypeWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created Date {@code BasicTypeWidget}
     */
    public BasicTypeWidget<Date> createDateWidget(WidgetConfiguration<?> config);
    
    /**
     * Creates a new Number {@link BasicTypeWidget}.
     * 
     * @param config the widget's configuration.
     * @return the created Number {@code BasicTypeWidget}
     */
    public BasicTypeWidget<Number> createNumberWidget(WidgetConfiguration<?> config);

}
