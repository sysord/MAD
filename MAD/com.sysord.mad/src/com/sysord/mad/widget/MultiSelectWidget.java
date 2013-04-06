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

import java.util.Collection;

/**
 * A {@code MultiSelectWidget} is a {@link ListWidget} where several elements can be
 * selected and returned as this widget's value.
 * 
 * @param <T> The type of the value represented by this widget. Most probably a
 *        {@link Collection}.
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ListWidget
 * @see SingleSelectWidget
 */
public interface MultiSelectWidget<T> extends SelectWidget<T> {

}
