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

import java.util.*;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.emitter.*;
import com.sysord.mad.widget.*;

/**
 * Default implementation of the ModelElementView.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ModelElementViewImpl implements ModelElementView {
    
	private String label; 
	
	private EObject contextElement;

    private Map<String, Widget<?>> rootWidgets;
    
    private Map<String, Widget<?>> flexibleWidgets;
    
    protected List<ViewDisposeListener> disposeListeners;
    
    protected List<ViewVisibleListener> visibleListeners;
    
    protected List<ViewChangeListener> viewChangeListeners;

    private boolean disposed;
    
    /**
     * Constructor without parameter.
     */
    public ModelElementViewImpl() {
        rootWidgets = new LinkedHashMap<String, Widget<?>>();
        flexibleWidgets = new LinkedHashMap<String, Widget<?>>();
        disposeListeners = new ArrayList<ViewDisposeListener>();
        visibleListeners = new ArrayList<ViewVisibleListener>();
        viewChangeListeners = new ArrayList<ViewChangeListener>();
    }

    @Override
    public String getLabel() {
 		return label;
 	}

    @Override
 	public void setLabel(String label) {
 		this.label = label;
 	}
    
    @Override
    public void setContextElement(EObject contextElement) {
        this.contextElement = contextElement;
    }

    @Override
    public EObject getContextElement() {
        return contextElement;
    }

    @Override
    public void addWidget(String id, Widget<?> widget) {
        if (widget.getOwnerWidget() != null) {
            flexibleWidgets.put(id, widget);
        } else {
            rootWidgets.put(id, widget);
        }
        widget.setOwnerViewModel(this);
    }

    @Override
    public void setWidgetValue(String id, Object value) {
        Widget<?> w = rootWidgets.get(id);
        if (w == null) {
            w = flexibleWidgets.get(id);
        }
        Assert.isNotNull(w, "The widget's ID is not referenced in this view.");
        if (w instanceof InputWidget) {
            ((InputWidget) w).setValue(value);
        }
    }

    @Override
    public List<Widget<?>> getWidgets() {
        return new ArrayList<Widget<?>>(rootWidgets.values());
    }
    
    @Override
    public boolean isDisposed() {
        return disposed;
    }
    
    @Override
    public void dispose() {
        if (!isDisposed()) {
            disposed = true;
            viewChangeListeners.clear();
            for (int i = 0; i < disposeListeners.size(); i++) {
                disposeListeners.get(i).viewDispose(this);
            }
            for (Widget<?> widget : rootWidgets.values()) {
                widget.dispose();
            }
        }
    }

    @Override
    public void setVisible(boolean visible) {
        for (int i = 0; i < visibleListeners.size(); i++) {
            visibleListeners.get(i).viewVisible(this, visible);
        }
    }
    
    @Override
    public void notifyChange() {
        for (ViewChangeListener listener : viewChangeListeners) {
            listener.viewChanged(this);
        }
    }

    @Override
    public void addDisposeListener(ViewDisposeListener listener) {
        disposeListeners.add(listener);
    }

    @Override
    public void removeDisposeListener(ViewDisposeListener listener) {
        disposeListeners.remove(listener);
    }

    @Override
    public void addVisibleListener(ViewVisibleListener listener) {
        visibleListeners.add(listener);
    }

    @Override
    public void removeVisibleListener(ViewVisibleListener listener) {
        visibleListeners.remove(listener);
    }

    @Override
    public void addViewChangedListener(ViewChangeListener listener) {
        viewChangeListeners.add(listener);
    }

    @Override
    public void removeViewChangedListener(ViewChangeListener listener) {
        viewChangeListeners.remove(listener);
    }
}
