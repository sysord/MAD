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
 * Visitor for exploring a {@link Widget widget}'s hierarchy.
 * 
 * @param <V> The type of the value returned by the <em>visit</em> methods.
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see Widget
 */
public interface WidgetVisitor<V> {

	/**
	 * Visits the given {@link Widget widget}.
	 * 
	 * @param widget The widget to visit.
	 * @return the result of the visite.
	 */
	public <T> V visit(Widget<T> widget);

	/**
	 * Visits the given {@link OutputWidget output widget}.
	 * 
	 * @param outputWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public <T> V visit(OutputWidget<T> outputWidget);

	/**
	 * Visits the given {@link InputWidget input widget}.
	 * 
	 * @param inputWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public <T> V visit(InputWidget<T> inputWidget);

	/**
	 * Visits the given {@link ActionWidget action widget}.
	 * 
	 * @param actionWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public V visit(ActionWidget actionWidget);

	/**
	 * Visits the given {@link ListWidget list widget}.
	 * 
	 * @param listWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public <T> V visit(ListWidget<T> listWidget);

	/**
	 * Visits the given {@link NavigationWidget navigation widget}.
	 * 
	 * @param navigationWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public V visit(NavigationWidget navigationWidget);

	/**
	 * Visits the given {@link SingleSelectWidget single-select widget}.
	 * 
	 * @param singleSelectWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public <T> V visit(SingleSelectWidget<T> singleSelectWidget);

	/**
	 * Visits the given {@link MultiSelectWidget multi-select widget}.
	 * 
	 * @param multiSelectWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public <T> V visit(MultiSelectWidget<T> multiSelectWidget);

	/**
	 * Visits the given {@link SelectWidget select widget}.
	 * 
	 * @param selectWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public <T> V visit(SelectWidget<T> selectWidget);

	/**
	 * Visits the given {@link BasicTypeWidget basic-type widget}.
	 * 
	 * @param basicTypeWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public <T> V visit(BasicTypeWidget<T> basicTypeWidget);

	/**
	 * Visits the given {@link FlexibleWidget flexible widget}.
	 * 
	 * @param flexibleWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public <T> V visit(FlexibleWidget<T> flexibleWidget);

	/**
	 * Visits the given {@link TextDslWidget text DSL widget}.
	 * 
	 * @param textDslWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public V visit(TextDslWidget textDslWidget);

	/**
	 * Visits the given {@link ElementDslWidget element DSL widget}.
	 * 
	 * @param elementDslWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public V visit(ElementDslWidget elementDslWidget);

	/**
	 * Visits the given {@link ComposedWidget composed widget}.
	 * 
	 * @param composedWidget The widget to visit.
	 * @return the result of the visite.
	 */
	public <T> V visit(ComposedWidget<T> composedWidget);
}
