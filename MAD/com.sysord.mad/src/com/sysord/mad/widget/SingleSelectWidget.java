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
 * A {@code SingleSelectWidget} is a {@link SelectWidget} where <strong>only one</strong>
 * element can be selected at a time.
 * 
 * @param <T> The type of this widget's value. Type of the value that can be selected.
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see SelectableItem
 */
public interface SingleSelectWidget<T> extends SelectWidget<T> {

}
