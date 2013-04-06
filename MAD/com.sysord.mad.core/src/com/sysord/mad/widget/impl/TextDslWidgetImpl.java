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
 * Implementation of {@link TextDslWidget}.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class TextDslWidgetImpl extends AbstractInputWidget<String> implements TextDslWidget {
    
    protected String grammar;

    /**
     * Create a {@code TextDslWidgetImpl}.
     */
    public TextDslWidgetImpl() {
        super(String.class);
    }

    @Override
    public String getGrammar() {
        return grammar;
    }

    @Override
    public void setGrammar(String grammar) {
        this.grammar = grammar;
    }

    @Override
    public <V> V accept(WidgetVisitor<V> visitor) {
        V value = visitor.visit((TextDslWidget)this);
        if(value != null ){
        	return value;
        }
    	return super.accept(visitor);
    }

    @Override
    protected AbstractWidget<String> _clone() throws CloneNotSupportedException {
        return new TextDslWidgetImpl();
    }

}
