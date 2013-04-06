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
package com.sysord.mad.widget;

import com.sysord.mad.ui.swt.widget.*;
import com.sysord.mad.widget.impl.*;

/**
 * {@link WidgetBuilder} for SWT.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTWidgetBuilder extends WidgetBuilderImpl {

    @Override
    protected void initializeDefaultWidgets() {
        super.initializeDefaultWidgets();
        // Flexible widget
        defaultWidgets.put(FlexibleWidgetImpl.class.getName(), new SWTFlexibleWidget());
        // Composed widget
        defaultWidgets.put(ComposedWidgetImpl.class.getName(), new SWTComposedWidget());
        // Basic types
        defaultWidgets.put(TextBoxWidget.class.getName(), new SWTBasicTypeWidget());
        defaultWidgets.put(CheckBoxWidget.class.getName(), new SWTBasicTypeWidget());
        defaultWidgets.put(NumberWidget.class.getName(), new SWTBasicTypeWidget());
        defaultWidgets.put(DateWidget.class.getName(), new SWTBasicTypeWidget());
        // Single select
        defaultWidgets.put(ComboWidget.class.getName(), new SWTComboWidget());
        // Multi select
        defaultWidgets.put(MultiListWidget.class.getName(), new SWTMultiSelectWidget());
        // Navigation list
        defaultWidgets.put(ListNavigationWidget.class.getName(), new SWTNavigationListWidget());
        // Output text
        defaultWidgets.put(OutputTextWidget.class.getName(), new SWTOutputTextWidget());
        // Dsl widgets
        defaultWidgets.put(ElementDslWidgetImpl.class.getName(), new SWTElementDslWidget());
        defaultWidgets.put(TextDslWidgetImpl.class.getName(), new SWTTextDslWidget());
    }
}
