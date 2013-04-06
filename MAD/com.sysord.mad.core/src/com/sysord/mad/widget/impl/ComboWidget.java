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

import com.sysord.mad.widget.*;

/**
 * 
 * XXX Comment role class
 * 
 * @param <T>
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ComboWidget<T> extends AbstractSelectWidget<T> implements SingleSelectWidget<T> {

    /**
     * XXX Comment constructor
     * 
     * @param valueTypeClass
     */
    public ComboWidget(Class<T> valueTypeClass) {
        super(valueTypeClass);
    }
    
    @Override
    public Object getSelectedItem() {
        return getValue();
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
        return new ComboWidget<T>(getType());
    }
    
}
