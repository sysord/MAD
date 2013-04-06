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

import com.sysord.mad.widget.BasicTypeWidget;
import com.sysord.mad.widget.WidgetVisitor;

/**
 * 
 * XXX Comment role class
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class CheckBoxWidget extends AbstractInputWidget<Boolean> implements BasicTypeWidget<Boolean> {
    
    /**
     * XXX Comment constructor
     * @param valueTypeClass
     */
    public CheckBoxWidget() {
        super(Boolean.class);
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
    protected AbstractWidget<Boolean> _clone() throws CloneNotSupportedException {
        return new CheckBoxWidget();
    }

    
}
