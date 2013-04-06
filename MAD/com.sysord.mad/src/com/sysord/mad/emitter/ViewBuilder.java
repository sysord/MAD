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

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.widget.OutputWidget;
import com.sysord.mad.widget.SpecificWidgetContext;

/**
 * A class implementing {@code ViewBuilder} can create views based on an {@link EObject}
 * semantic element and its {@link TypeConfiguration}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface ViewBuilder {

	/**
	 * Creates the view for the given {@link EObject} and its {@link TypeConfiguration}.
	 * 
	 * @param semanticElement
	 * @param targetConfiguration
	 * @param context
	 */
	public void createView(EObject semanticElement, TypeConfiguration targetConfiguration, SpecificWidgetContext context);

	/**
	 * Returns the current {@link SpecificWidgetContext} of this {@code ViewBuilder}.
	 * 
	 * @return the current {@link SpecificWidgetContext} of this {@code ViewBuilder}.
	 */
	public SpecificWidgetContext getCurrentContext();

	/**
	 * Updates the current view.
	 */
	public void updateCurrentView();

	/**
	 * Update all the {@link OutputWidget}s of the current view.
	 */
	public void updateCurrentViewOuputputWidgets();

	/**
	 * Add the given {@link ViewBuilderListener} to this {@code ViewBuilder}.
	 * 
	 * @param listener The {@code ViewBuilderListener} to remove.
	 */
	public void addViewBuilderListener(ViewBuilderListener listener);

	/**
	 * Remove the given {@link ViewBuilderListener} from this {@code ViewBuilder}.
	 * 
	 * @param listener The {@code ViewBuilderListener} to remove.
	 */
	public void removeViewBuilderListener(ViewBuilderListener listener);
}
