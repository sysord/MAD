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

import com.sysord.mad.widget.MultiSelectWidget;
import com.sysord.mad.widget.WidgetVisitor;

/**
 * 
 * XXX Comment role class
 *
 * @param <T>
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class MultiListWidget<T> extends AbstractSelectWidget<T> implements MultiSelectWidget<T> {

    /**
     * XXX Comment constructor
     * 
     * @param elementListTypeClass
     */
    public MultiListWidget(Class<T> elementListTypeClass) {
        super(elementListTypeClass);
    }

    @Override
    public <V> V accept(WidgetVisitor<V> visitor) {
        V value = visitor.visit(this);
        if(value != null ){
        	return value;
        }
    	return super.accept(visitor);
    }

    @Override
    protected AbstractWidget<T> _clone() throws CloneNotSupportedException {
        return new MultiListWidget<T>(getType());
    }
    
}
