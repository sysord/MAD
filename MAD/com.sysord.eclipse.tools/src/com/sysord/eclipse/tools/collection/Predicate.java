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
package com.sysord.eclipse.tools.collection;

/**
 * Returns {@code true} or {@code false} for a given object of type {@code T}.
 * 
 * @param <T> The type of object for which this predicate is applicable.
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface Predicate<T> {

	/**
	 * Indicates if the given {@code object} applies this predicate.
	 * 
	 * @param object The object to control if it applies this predicate.
	 * @return {@code true} if the given {@code object} applies this predicate;<br>
	 *         {@code false} otherwise.
	 */
	public boolean apply(T object);
}
