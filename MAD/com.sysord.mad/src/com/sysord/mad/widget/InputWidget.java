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
 * An {@code InputWidget} represents an {@link OutputWidget} where its value can be edited.
 * 
 * @param <T> The type of element of this widget.
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see BasicTypeWidget
 * @see ListWidget
 * @see ElementDslWidget
 * @see TextDslWidget
 */
public interface InputWidget<T> extends OutputWidget<T> {

	/**
	 * Indicates if the value of this widget is editable.
	 * 
	 * @return {@code true} if the value is editable;<br>
	 *         {@code false} otherwise.
	 */
	public boolean isEditable();

	/**
	 * Sets the given {@code value} to this widget.
	 * 
	 * @param value The value to set.
	 */
	public void setValue(T value);

	/**
	 * Defines the editable state of this widget.
	 * 
	 * @param editable {@code true} if this widget's value can be edited;<br>
	 *        {@code false} otherwise.
	 */
	public void setEditable(boolean editable);

	/**
	 * Adds a new {@link WidgetEditableStateListener} to this widget.
	 * 
	 * @param listener The listener to set.
	 */
	public void addEditableStateListener(WidgetEditableStateListener listener);

	/**
	 * Removes the specified {@link WidgetEditableStateListener} from this widget.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeEditableStateListener(WidgetEditableStateListener listener);

}
