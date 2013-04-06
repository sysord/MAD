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
package com.sysord.mad.emitter;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.widget.Widget;

/**
 * Group of {@link Widget}s forming a view for a specific ecore model element.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see Widget
 */
public interface ModelElementView {

	/**
	 * Returns the view label.
	 * 
	 * @return the view label.
	 */
	public String getLabel();

	/**
	 * Defines the view label
	 * 
	 * @param label The view label to set.
	 */
	public void setLabel(String label);

	/**
	 * Sets the context element, the main edited element.
	 * 
	 * @param contextElement Context element to set.
	 */
	public void setContextElement(EObject contextElement);

	/**
	 * Returns the main edited element.
	 * 
	 * @return the main edited element.
	 */
	public EObject getContextElement();

	/**
	 * Adds the widget with the specified ID to this view.
	 * 
	 * @param id The ID of the widget to add.
	 * @param widget The widget to add.
	 */
	public void addWidget(String id, Widget<?> widget);

	/**
	 * Sets the value of the widget with the given ID.
	 * <p>
	 * Does nothing if no widget exists with the specified id.
	 * 
	 * @param id The ID of the widget.
	 * @param value The value to set to the widget.
	 */
	public void setWidgetValue(String id, Object value);

	/**
	 * Returns the list of all widgets owned by the this {@code ModelElementView}.
	 * 
	 * @return the list of all widgets owned by the this {@code ModelElementView}.
	 */
	public List<Widget<?>> getWidgets();

	/**
	 * Indicates if this {@code ModelElementView} is disposed.
	 * 
	 * @return {@code true} is this {@link ModelElementView} is disposed;<br>
	 *         {@code false} otherwise.
	 */
	public boolean isDisposed();

	/**
	 * Disposes this view and its widgets.
	 */
	public void dispose();

	/**
	 * Sets the visibility of this view.
	 * 
	 * @param visible The visible state to set.
	 */
	public void setVisible(boolean visible);

	/**
	 * Notifies this view, that an element has changed in the view.
	 */
	public void notifyChange();

	/**
	 * Adds the given {@link ViewDisposeListener} to this view.
	 * 
	 * @param listener The listener to add.
	 */
	public void addDisposeListener(ViewDisposeListener listener);

	/**
	 * Removes the given {@link ViewDisposeListener} from this view.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeDisposeListener(ViewDisposeListener listener);

	/**
	 * Adds the given {@link ViewVisibleListener} to this view.
	 * 
	 * @param listener The listener to add.
	 */
	public void addVisibleListener(ViewVisibleListener listener);

	/**
	 * Removes the given {@link ViewVisibleListener} from this view.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeVisibleListener(ViewVisibleListener listener);

	/**
	 * Adds the given {@link ViewChangeListener} to this view.
	 * 
	 * @param listener The listener to add.
	 */
	public void addViewChangedListener(ViewChangeListener listener);

	/**
	 * Removes the given {@link ViewChangeListener} from this view.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeViewChangedListener(ViewChangeListener listener);
}
