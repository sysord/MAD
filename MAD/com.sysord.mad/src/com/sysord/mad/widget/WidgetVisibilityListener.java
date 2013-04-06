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
 * Listener for visibility changed event on widgets.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see Widget
 */
public interface WidgetVisibilityListener {

	/**
	 * Notifies this listener that the visibility of the listened widget has changed.
	 * 
	 * @param visibility Actual visibility of the widget.
	 */
	public void visibilityChanged(boolean visibility);
}
