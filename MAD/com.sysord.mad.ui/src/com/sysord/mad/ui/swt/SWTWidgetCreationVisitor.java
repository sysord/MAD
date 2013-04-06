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
package com.sysord.mad.ui.swt;

import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.mad.widget.*;

/**
 * {@link WidgetVisitor} for creating SWT widgets with {@link FormToolkit}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTWidgetCreationVisitor extends AbstractWidgetVisitor<Boolean> {

    private SpecificContextHolder specificContextHolder;

    /**
     * Creates a new {@code FormWidgetCreationVisitor} with the given
     * {@link SpecificContextHolder}.
     * 
     * @param specificContextHolder
     * @throws NullPointerException if the given {@code specificContextHolder} is
     *         {@code null}.
     */
    public SWTWidgetCreationVisitor(SpecificContextHolder specificContextHolder) {
        if (specificContextHolder == null) {
            throw new NullPointerException("The specific context holder must not be null.");
        }// else
        this.specificContextHolder = specificContextHolder;
    }

    @Override
    public <T> Boolean visit(BasicTypeWidget<T> basicTypeWidget) {
        getWidgetBuilder().createWidget(specificContextHolder, basicTypeWidget);
        return Boolean.TRUE;
    }

    @Override
    public <T> Boolean visit(OutputWidget<T> outputWidget) {
        getWidgetBuilder().createWidget(specificContextHolder, outputWidget);
        return Boolean.TRUE;
    }

    @Override
    public <T> Boolean visit(SingleSelectWidget<T> singleSelectWidget) {
        getWidgetBuilder().createWidget(specificContextHolder, singleSelectWidget);
        return Boolean.TRUE;
    }

    @Override
    public <T> Boolean visit(MultiSelectWidget<T> multiSelectWidget) {
        getWidgetBuilder().createWidget(specificContextHolder, multiSelectWidget);
        return Boolean.TRUE;
    }

    @Override
    public Boolean visit(TextDslWidget textDslWidget) {
        getWidgetBuilder().createWidget(specificContextHolder, textDslWidget);
        return Boolean.TRUE;
    }

    @Override
    public Boolean visit(ElementDslWidget elementDslWidget) {
        getWidgetBuilder().createWidget(specificContextHolder, elementDslWidget);
        return Boolean.TRUE;
    }

    @Override
    public Boolean visit(NavigationWidget navigationWidget) {
        getWidgetBuilder().createWidget(specificContextHolder, navigationWidget);
        return Boolean.TRUE;
    }

    @Override
    public <T> Boolean visit(FlexibleWidget<T> flexibleWidget) {
        getWidgetBuilder().createWidget(specificContextHolder, flexibleWidget);
        return Boolean.TRUE;
    }

    @Override
    public <T> Boolean visit(final ComposedWidget<T> composedWidget) {
        getWidgetBuilder().createWidget(specificContextHolder, composedWidget);
        return Boolean.TRUE;
    }

    protected WidgetBuilder getWidgetBuilder() {
        return ((SWTSpecificWidgetContext) specificContextHolder.getSpecificWidgetContext()).getWidgetBuilder();
    }
}
