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
package com.sysord.mad.widget.impl;

import java.util.Map;
import java.util.TreeMap;

import com.sysord.mad.widget.*;

/**
 * Default implementation of the {@link WidgetBuilder} interface.
 * <p>
 * Provides methods for registering {@link SpecificWidget}s and creating the registered
 * {@link SpecificWidget}s in a graphical object (SWT, HTML, ...).
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class WidgetBuilderImpl implements WidgetBuilder {

    /**
     * The default implementations of the widgets.
     */
    protected Map<String, SpecificWidget> defaultWidgets;

    /**
     * Custom widgets referenced into the MAD configuration.
     */
    protected Map<String, SpecificWidget> customWidgets;

    /**
     * Constructor
     */
    public WidgetBuilderImpl() {
        defaultWidgets = new TreeMap<String, SpecificWidget>();
        customWidgets = new TreeMap<String, SpecificWidget>();
        initializeDefaultWidgets();
    }

    /**
     * Initializes the map of default widgets.
     * <p>
     * Should be overridden in subclasses.
     */
    protected void initializeDefaultWidgets() {
    }

    @Override
    public Object createWidget(SpecificContextHolder specificContextHolder, Widget<?> madWidget) {
        SpecificWidget specificWidget = null;
        String widgetType = madWidget.getConfig().getWidgetType();
        if (widgetType != null && widgetType.length() > 0) {
            // Searching for a custom implementation
            specificWidget = customWidgets.get(widgetType);
        }
        if (specificWidget == null) {
            // No custom widget, creating the default implementation
            specificWidget = defaultWidgets.get(madWidget.getClass().getName());
        }
        if (specificWidget == null) {
            // Should never happen, all widget's categories have a default implementation
            throw new RuntimeException("No implementation found for the widget "
                    + madWidget.getConfig().getWidgCategory());
        }// else
        return specificWidget.createWidget(specificContextHolder, madWidget);
    }

    @Override
    public void addSpecificWidget(String id, SpecificWidget specificWidget) {
        specificWidget.setId(id);
        customWidgets.put(id, specificWidget);
    }

    @Override
    public void removeCustomWidget(SpecificWidget customWidget) {
        customWidgets.remove(customWidget.getId());
    }

    @Override
    public void removeAll() {
        customWidgets.clear();
    }

}
