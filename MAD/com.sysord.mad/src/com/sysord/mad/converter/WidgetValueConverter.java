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
package com.sysord.mad.converter;

import com.sysord.mad.widget.Widget;

/**
 * A {@code WidgetValueConverter} represents a bridge between a widget value type and a
 * semantic element represented by the widget.
 * 
 * @param <V> The widget value type.
 * @param <E> The semantic element type.
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see Widget
 */
public interface WidgetValueConverter<V, E> {

	/**
	 * Converts a widget value into the corresponding semantic element.
	 * 
	 * @param value The value to convert into the semantic element type.
	 * @return the corresponding semantic element.
	 */
	public E convertFromWidgetValue(V value);

	/**
	 * Converts a semantic element into the corresponding widget value.
	 * 
	 * @param semanticElement The semantic element to convert into the widget value type.
	 * @return the corresponding widget value.
	 */
	public V convertFromElement(E semanticElement);
}
