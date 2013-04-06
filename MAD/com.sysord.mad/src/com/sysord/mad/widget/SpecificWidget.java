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
 * Platform specific widget used for UI purpose.
 * <p>
 * The {@code SpecificWidget}s are referenced by the {@link WidgetBuilder} that will be
 * called to create them.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see WidgetBuilder
 */
public interface SpecificWidget {

	/**
	 * Returns this {@code CustomWidget} ID.
	 * 
	 * @return this {@code CustomWidget} ID.
	 */
	public String getId();

	/**
	 * Sets the specified value ID.
	 * 
	 * @param ID the value to set.
	 */
	public void setId(String ID);

	/**
	 * Creates the custom widget with the specified context and MAD {@link Widget}.
	 * 
	 * @param specificContextHolder
	 * @param madWidget
	 * @return the new created specific widget.
	 */
	public Object createWidget(SpecificContextHolder specificContextHolder, Widget<?> madWidget);
}
