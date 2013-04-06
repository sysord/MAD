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
 * A {@code Candidate} represents a possible value in a set of choices.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ListWidget
 * @see ActionWidget
 */
public interface Candidate {

	/**
	 * Returns this {@code Candidate}'s label.
	 * 
	 * @return this {@code Candidate}'s label.
	 */
	public abstract String getLabel();

	/**
	 * Sets the given {@code label} to this {@code Candidate}.
	 * 
	 * @param label The label to set.
	 */
	public abstract void setLabel(String label);

	/**
	 * Returns the {@code value} represented by this {@code Candidate}.
	 * 
	 * @return the {@code value} represented by this {@code Candidate}.
	 */
	public abstract Object getValue();

	/**
	 * Sets the given {@code value} to this {@code Candidate}.
	 * 
	 * @param value The value to set.
	 */
	public abstract void setValue(Object value);

}
