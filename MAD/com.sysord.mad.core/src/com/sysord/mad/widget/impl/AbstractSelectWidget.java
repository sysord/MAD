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

import com.sysord.mad.widget.SelectWidget;
import com.sysord.mad.widget.WidgetVisitor;
import com.sysord.mad.widget.adapter.SelectedItemProvider;

/**
 * XXX Comment role class
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractSelectWidget<T> extends AbstractListWidget<T> implements SelectWidget<T> {
    
    protected Object selectedItem;

	/**
	 * Creates a new {@code AbstractSelectWidget} with the given {@code valueTypeClass}.
	 * 
	 * @param valueTypeClass
	 */
	public AbstractSelectWidget(Class<T> valueTypeClass) {
		super(valueTypeClass);
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
    @SuppressWarnings("unchecked")
    public <AT> AT getAdapter(Class<AT> adapterClass) {
        // SelectedItemProvider adapter:
        if (adapterClass.equals(SelectedItemProvider.class)) {
            // SelectedItemProvider that returns the contextElement
            return (AT) this;
        }// else

        return null;
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
    public AbstractSelectWidget<T> clone() throws CloneNotSupportedException {
        AbstractSelectWidget<T> clone = (AbstractSelectWidget<T>) super.clone();
        clone.selectedItem = null;
        return clone;
    }

}
