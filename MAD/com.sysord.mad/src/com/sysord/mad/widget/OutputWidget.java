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
 * Uneditable widget used only for output purposes.
 * 
 * @param <T> The type of this widget's value.
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see InputWidget
 */
public interface OutputWidget<T> extends Widget<T> {

	/**
	 * Returns this widget value.
	 * 
	 * @return this widget value.
	 */
	public T getValue();

	/**
	 * Adds the specified {@link WidgetValueListener} to this widget.
	 * 
	 * @param listener The listener to add.
	 */
	public void addValueListener(WidgetValueListener<T> listener);

	/**
	 * Removes the specified {@link WidgetValueListener} from this widget.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeValueListener(WidgetValueListener<T> listener);
}
