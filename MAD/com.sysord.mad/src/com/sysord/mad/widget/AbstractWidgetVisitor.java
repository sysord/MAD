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
package com.sysord.mad.widget;

/**
 * Default implementation of the {@link WidgetVisitor}.
 * <p>
 * All <em>visit</em> methods of this implementation return {@code null}.
 * 
 * @param <V> Value type returned by the <em>visit</em> methods.
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractWidgetVisitor<V> implements WidgetVisitor<V> {

	@Override
	public <T> V visit(Widget<T> widget) {
		return null;
	}

	@Override
	public <T> V visit(OutputWidget<T> outputWidget) {
		return null;
	}

	@Override
	public <T> V visit(InputWidget<T> inputWidget) {
		return null;
	}

	@Override
	public V visit(ActionWidget actionWidget) {
		return null;
	}

	@Override
	public <T> V visit(ListWidget<T> listWidget) {
		return null;
	}

	@Override
	public V visit(NavigationWidget navigationWidget) {
		return null;
	}

	@Override
	public <T> V visit(SingleSelectWidget<T> singleSelectWidget) {
		return null;
	}

	@Override
	public <T> V visit(MultiSelectWidget<T> multiSelectWidget) {
		return null;
	}

	@Override
	public <T> V visit(SelectWidget<T> selectWidget) {
		return null;
	}

	@Override
	public <T> V visit(BasicTypeWidget<T> basicTypeWidget) {
		return null;
	}

	@Override
	public V visit(TextDslWidget textDslWidget) {
		return null;
	}

	@Override
	public V visit(ElementDslWidget elementDslWidget) {
		return null;
	}

	@Override
	public <T> V visit(FlexibleWidget<T> flexibleWidget) {
		return null;
	}

	@Override
	public <T> V visit(ComposedWidget<T> composedWidget) {
		return null;
	}

}
