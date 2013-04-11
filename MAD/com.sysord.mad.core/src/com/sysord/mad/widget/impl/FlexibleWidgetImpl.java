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

import java.util.ArrayList;
import java.util.List;

import com.sysord.mad.mao.ValuedSemanticElement;
import com.sysord.mad.widget.*;

/**
 * Implementation of the {@link FlexibleWidget} interface.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class FlexibleWidgetImpl<T> extends AbstractWidget<T> implements FlexibleWidget<T> {
    
    protected ComposedWidget<T> prototype;
    
    protected List<ComposedWidget<T>> composedWidgets;

    /**
     * Create a new {@link FlexibleWidget}.
     * 
     * @param valueTypeClass
     */
    public FlexibleWidgetImpl(Class<T> valueTypeClass) {
        super(valueTypeClass);
        composedWidgets = new ArrayList<ComposedWidget<T>>();
    }

    @Override
    public ComposedWidget<T> createComposedWidget(ValuedSemanticElement valueElement) {
        try {
            ComposedWidget<T> composedWidget = (ComposedWidget<T>) getPrototype().clone();
            composedWidget.setValuedSemanticElement(valueElement);
            composedWidgets.add(composedWidget);
            return composedWidget;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ComposedWidget<T>> getComposedWidgets() {
        return composedWidgets;
    }

    @Override
    protected void beforeLoadingWidget() {
    	prototype = null;
        for (ComposedWidget<T> composedWidget : composedWidgets) {
            composedWidget.dispose();
        }
        composedWidgets.clear();
    }
    
    @Override
    protected AbstractWidget<T> _clone() throws CloneNotSupportedException {
        FlexibleWidgetImpl<T> widget = new FlexibleWidgetImpl<T>(getType());
        widget.prototype = (ComposedWidget<T>) getPrototype().clone();
        return widget;
    }

    @Override
    public void addWidget(Widget<T> widget) {
        widget.setOwnerWidget(this);
        getPrototype().addWidget(widget);
    }

    private ComposedWidget<T> getPrototype() {
        if (prototype == null) {
            prototype = new ComposedWidgetImpl<T>(getType());
            prototype.setConfig(getConfig());
            prototype.setOwnerWidget(this);
        }
        return prototype;
    }

    @Override
    public <V> V accept(WidgetVisitor<V> visitor) {
        V value = visitor.visit(this);
        if(value != null ){
        	return value;
        }
    	return super.accept(visitor);
    }


}
