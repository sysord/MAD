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

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.widget.*;
import com.sysord.mad.widget.adapter.SelectedItemProvider;

/**
 * 
 * Concrete realization of the {@link NavigationWidget} represented by a list.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ListNavigationWidget extends AbstractActionWidget implements NavigationWidget {

    private EObject semanticElementNavigation;
    
    protected Object selectedItem;

	@Override
	@SuppressWarnings("unchecked")
    public <AT> AT getAdapter(Class<AT> adapterClass) {
    	//SelectedItemProvider adapter: 
    	if(adapterClass.equals(SelectedItemProvider.class)){
        	//SelectedItemProvider that returns the contextElement
    		return (AT) this;
    	}
    	
    	return null;
    }

    
    @Override
    public EObject getSemanticElementNavigation() {
        return semanticElementNavigation;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public void setSelectedItem(Object selectedItem) {
        this.selectedItem = selectedItem;
    }

    @Override
    public <V> V accept(WidgetVisitor<V> visitor) {
        V value = visitor.visit(this);
        if (value != null) {
            return value;
        }
        return super.accept(visitor);
    }

    @Override
    protected AbstractActionWidget _clone() throws CloneNotSupportedException {
        return new ListNavigationWidget();
    }

    @Override
    public void setNavigateTo(EObject semanticElement) {
        this.semanticElementNavigation = semanticElement;
    }

}
