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

import com.sysord.mad.widget.ElementDslWidget;
import com.sysord.mad.widget.WidgetVisitor;

/**
 * Implementation of {@link ElementDslWidget}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ElementDslWidgetImpl extends AbstractInputWidget<EObject> implements ElementDslWidget {

    /**
     * Create an {@code ElementDslWidgetImpl}.
     */
    public ElementDslWidgetImpl() {
        super(EObject.class);
    }

    
    @Override
    public <V> V accept(WidgetVisitor<V> visitor) {
        V value = visitor.visit((ElementDslWidget) this);
        if (value != null) {
            return value;
        }
        return super.accept(visitor);
    }

    @Override
    protected AbstractWidget<EObject> _clone() throws CloneNotSupportedException {
        return new ElementDslWidgetImpl();
    }

}
