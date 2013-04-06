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
 * A {@code WidgetBuilder} references all the implementation classes of the widgets that
 * it can build.
 * <p>
 * These classes can be referenced at the initialization for defining defaults specific
 * widgets and at runtime when the MAD configuration proposes custom implementations of
 * the specific widgets.
 * <p>
 * All {@link SpecificWidget} creation should be done by a {@code WidgetBuilder}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see SpecificWidget
 * @see SpecificContextHolder
 */
public interface WidgetBuilder {

	/**
	 * Creates a new specific widget with the given MAD {@link Widget}.
	 * 
	 * @param specificContextHolder
	 * @param madWidget
	 * @return the new created specific widget.
	 */
	public Object createWidget(SpecificContextHolder specificContextHolder, Widget<?> madWidget);

	/**
	 * Add a {@link SpecificWidget} to this {@code WidgetBuilder}.
	 * 
	 * @param id
	 * @param specificWidget
	 */
	public void addSpecificWidget(String id, SpecificWidget specificWidget);

	/**
	 * Remove the specified {@link SpecificWidget} from this {@code WidgetBuilder}.
	 * 
	 * @param customWidget
	 */
	public void removeCustomWidget(SpecificWidget customWidget);

	/**
	 * Remove all registered {@link SpecificWidget}s.
	 */
	public void removeAll();
}
