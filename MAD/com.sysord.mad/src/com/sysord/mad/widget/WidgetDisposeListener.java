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
 * Listener for widget disposing event.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see Widget
 */
public interface WidgetDisposeListener {

	/**
	 * Notifies this listener the given widget has been disposed.
	 * 
	 * @param widget The disposed widget.
	 */
	public <T> void widgetDispose(Widget<T> widget);
}
