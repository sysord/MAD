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

import java.util.List;

import com.sysord.mad.mao.ValuedSemanticElement;

/**
 * A {@code FlexibleWidget} is a definition of a {@link ComposedWidget} that is repeatable
 * over a collection of values of the same type.
 * <p>
 * The creation of a {@code FlexibleWidget} is done in two times :
 * <ul>
 * <li>First, the definition of a {@code FlexibleWidget} is done by the addition of
 * several widgets (with the {@link #addWidget(Widget)} method) that will be put into an
 * internal {@code ComposedWidget}.</li>
 * <li>Then, the {@code FlexibleWidget} is constructed when the
 * {@link #createComposedWidget(ValuedSemanticElement)} method is called for values of the
 * same type.</li>
 * </ul>
 * 
 * @param <T> Type of the value of the {@link ComposedWidget}s composing this
 *        {@code FlexibleWidget}.
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ComposedWidget
 */
public interface FlexibleWidget<T> extends Widget<T> {

	/**
	 * Creates a new {@link ComposedWidget} with the defined prototype and add it to this
	 * {@link FlexibleWidget}.
	 * 
	 * @param valueElement the ValuedSemanticElement
	 * @return the new created {@link ComposedWidget}.
	 * @see #addWidget(Widget)
	 */
	public ComposedWidget<T> createComposedWidget(ValuedSemanticElement valueElement);

	/**
	 * Returns the composed widgets of this {@link FlexibleWidget}.
	 * 
	 * @return the composed widgets of this {@link FlexibleWidget}.
	 */
	public List<ComposedWidget<T>> getComposedWidgets();

	/**
	 * Adds the widget to the internal {@link ComposedWidget} prototype.<br>
	 * This prototype will be cloned when invoking the {@code createComposedWidget}
	 * method.
	 * 
	 * @param widget The widget to add to the internal prototype.
	 * @see #createComposedWidget(ValuedSemanticElement)
	 */
	public void addWidget(Widget<T> widget);
}
