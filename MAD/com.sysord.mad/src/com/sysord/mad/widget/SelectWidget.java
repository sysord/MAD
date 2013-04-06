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
 * A {@code SelectWidget} is a {@link ListWidget} where one or several elements can be
 * selected.
 * 
 * @param <T> The type of this widget's value.
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see SingleSelectWidget
 * @see MultiSelectWidget
 * @see SelectableItem
 */
public interface SelectWidget<T> extends ListWidget<T>, SelectableItem {

}
