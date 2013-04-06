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

import java.util.Date;

import com.sysord.mad.widget.*;

/**
 * Represents a {@link Widget} with a {@link Date} value.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class DateWidget extends AbstractInputWidget<Date> implements BasicTypeWidget<Date> {

    /**
     * Create a {@code DateWidget}.
     */
    public DateWidget() {
        super(Date.class);
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
    protected AbstractWidget<Date> _clone() throws CloneNotSupportedException {
        return new DateWidget();
    }

}
