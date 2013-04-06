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
package com.sysord.mad.widget.adapter;

import java.util.Collection;

import com.sysord.mad.widget.SelectableItem;

/**
 * An implementation of {@link SelectedItemProvider} provides its current selected item.
 * <p>
 * If the selection can be multiple, the returned selected item will most probably be a
 * {@link Collection}.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see SelectableItem
 */
public interface SelectedItemProvider {

	/**
	 * Returns the currently selected item.
	 * 
	 * @return the currently selected item.
	 */
	public Object getSelectedItem();

}
