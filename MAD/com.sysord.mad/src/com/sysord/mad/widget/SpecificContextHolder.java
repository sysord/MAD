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
 * A class implementing this interface gives access to its hold
 * {@link SpecificWidgetContext}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see SpecificWidget
 * @see WidgetBuilder
 * @see SpecificWidgetContext
 */
public interface SpecificContextHolder {

	/**
	 * Returns the {@link SpecificWidgetContext} hold by this
	 * {@code SpecificContextHolder}.
	 * 
	 * @return the {@link SpecificWidgetContext} hold by this
	 *         {@code SpecificContextHolder}.
	 */
	public SpecificWidgetContext getSpecificWidgetContext();

	/**
	 * Defines the {@link SpecificWidgetContext} this {@code SpecificContextHolder} must
	 * hold.
	 * 
	 * @param specificWidgetContext The {@link SpecificWidgetContext} that will be hold by
	 *        this {@code SpecificContextHolder}.
	 */
	public void setSpecificWidgetContext(SpecificWidgetContext specificWidgetContext);
}
