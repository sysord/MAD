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

/**
 * A {@code ComposedWidget} is a widget that contains other {@link Widget widgets}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see FlexibleWidget
 */
public interface ComposedWidget<T> extends Widget<T> {

	/**
	 * Returns the widgets of this {@code ComposedWidget}s.
	 * 
	 * @return the widgets of this {@code ComposedWidget}s.
	 */
	public List<Widget<?>> getWidgets();

	/**
	 * Sets the collection of widgets of this {@code ComposedWidget}.
	 * 
	 * @param widgets
	 */
	public void setWidgets(List<Widget<?>> widgets);

	/**
	 * Adds the given {@code widget} to this {@code ComposedWidget}.
	 * 
	 * @param widget The widget to add.
	 */
	public <WT> void addWidget(Widget<WT> widget);

	/**
	 * Removes the given {@code widget} from this {@code ComposedWidget}.
	 * 
	 * @param widget The widget to remove.
	 */
	public <WT> void removeWidget(Widget<WT> widget);
}
