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

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.emitter.ModelElementView;
import com.sysord.mad.emitter.ViewBuilder;
import com.sysord.mad.emitter.ViewHolder;

/**
 * Context used for creating specific widgets.
 * <p>
 * Subclasses may add other accessors for the different target specific platforms.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ViewBuilder
 */
public interface SpecificWidgetContext {

	/**
	 * Returns the current MAD view ID.
	 * 
	 * @return the current MAD view ID.
	 */
	public Object getId();

	/**
	 * Set the current MAD view ID.
	 * 
	 * @param id
	 */
	public void setId(Object id);

	/**
	 * Returns the {@link ViewHolder}.
	 * 
	 * @return the {@link ViewHolder}.
	 */
	public ViewHolder getViewHolder();

	/**
	 * Set the {@link ViewHolder}
	 * 
	 * @param viewHolder
	 */
	public void setViewHolder(ViewHolder viewHolder);

	/**
	 * Returns the selected {@link EObject} element.
	 * 
	 * @return the selected {@link EObject} element.
	 */
	public EObject getElement();

	/**
	 * Defines the selected {@link EObject} element.
	 * 
	 * @param element
	 */
	public void setElement(EObject element);

	/**
	 * Returns the current element;
	 * 
	 * @return the current element
	 */
	public EObject getCurrentElement();

	/**
	 * Defines the current {@link EObject} element.
	 * 
	 * @param element
	 */
	public void setCurrentElement(EObject element);

	/**
	 * Returns the {@link ModelElementView} for this {@code SpecificWidgetContext}'s
	 * element.
	 * 
	 * @return the {@code ModelElementView} for this {@code SpecificWidgetContext}'s
	 *         element.
	 */
	public ModelElementView getModelElementView();

	/**
	 * Defines the {@link ModelElementView} for this {@code SpecificWidgetContext}'s
	 * element.
	 */
	public void setModelElementView(ModelElementView modelElementView);
}
