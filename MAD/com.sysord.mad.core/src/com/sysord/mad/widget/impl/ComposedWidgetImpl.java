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

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.widget.ComposedWidget;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.adapter.SelectedItemProvider;

public class ComposedWidgetImpl<T> extends AbstractWidget<T> implements ComposedWidget<T> {
    
    protected List<Widget<?>> widgets;
    
    /**
     * Create a new {@link ComposedWidget}.
     * 
     * @param valueTypeClass
     */
    public ComposedWidgetImpl(Class<T> valueTypeClass) {
        super(valueTypeClass);
        widgets = new ArrayList<Widget<?>>(3);
    }

    @Override
    public List<Widget<?>> getWidgets() {
        return widgets;
    }

    @Override
    public void setWidgets(List<Widget<?>> widgets) {
        this.widgets = new ArrayList<Widget<?>>(widgets.size());
        this.widgets.addAll(widgets);
    }

    @Override
    public <WT> void addWidget(Widget<WT> widget) {
        widget.setOwnerWidget(this);
        widgets.add(widget);
    }

    @Override
    public <WT> void removeWidget(Widget<WT> widget) {
        widget.setOwnerWidget(null);
        widgets.remove(widget);
    }

    @Override
    public void dispose() {
        if (!isDisposed) {
            for (Widget<?> widget : widgets) {
                widget.dispose();
            }
        }
        super.dispose();
    }


    @Override
	public EObject getContextElement() {
    	return (EObject) getValuedSemanticElement().getValue();
	}
    
    @SuppressWarnings("unchecked")
	@Override
    public <AT> AT getAdapter(Class<AT> adapterClass) {
    	
    	//SelectedItemProvider adapter: 
    	if(adapterClass.equals(SelectedItemProvider.class)){
        	//SelectedItemProvider that returns the contextElement
    		final EObject selectedItem = getContextElement();
    		return (AT) new SelectedItemProvider() {
				@Override
				public Object getSelectedItem() {
					return selectedItem;
				}
			};
    	}
    	
    	return null;
    }
    
    @Override
    protected AbstractWidget<T> _clone() throws CloneNotSupportedException {
        ComposedWidgetImpl<T> composedWidget = new ComposedWidgetImpl<T>(getType());
        composedWidget.widgets = new ArrayList<Widget<?>>(widgets.size());
        for (Widget<?> widget : widgets) {
            Widget<?> clone = widget.clone();
            composedWidget.addWidget(clone);
            getOwnerViewModel().addWidget(clone.getId(), clone);
        }
        getOwnerViewModel().addWidget(composedWidget.getId(), composedWidget);
        return composedWidget;
    }
    
}
