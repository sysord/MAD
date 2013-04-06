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

import com.sysord.mad.widget.adapter.SelectedItemProvider;

/**
 * Indicates the subclasses have selectable items and provides a method to obtain the
 * selected items.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see SelectWidget
 * @see NavigationWidget
 */
public interface SelectableItem extends SelectedItemProvider {

	/**
	 * Set the current selected item (can be {@code null}).
	 * 
	 * @param selectedItem
	 */
	public void setSelectedItem(Object selectedItem);
}
