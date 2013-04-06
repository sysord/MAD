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
package com.sysord.mad.configuration;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;

import com.sysord.mad.emitter.ViewBuilder;

/**
 * Configuration for a type of a model element.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see ConfigurationManager
 * @see WidgetConfiguration
 * @see ViewBuilder
 */
public interface TypeConfiguration {

	/**
	 * Returns the type of the model element.
	 * 
	 * @return the type of the model element.
	 */
	public EClass getType();

	/**
	 * Sets the type of the model element.
	 * 
	 * @param type The type to set.
	 */
	public void setType(EClass type);

	/**
	 * Returns the widget {@link WidgetConfiguration configuration} for the type defined
	 * by this {@code TypeConfiguration}.
	 * 
	 * @return the widget {@link WidgetConfiguration configuration} of this
	 *         {@code TypeConfiguration}.
	 */
	public Collection<WidgetConfiguration<?>> getWidgetsConfigurations();

	/**
	 * Adds a widget {@link WidgetConfiguration configuration}.
	 * <p>
	 * If a widget configuration with the same name already exists, it will be replaced by
	 * the new one.
	 * 
	 * @param widgetConfiguration The widget {@link WidgetConfiguration configuration} to
	 *        add.
	 * @return the added widget configuration.
	 */
	public WidgetConfiguration<?> addWidgetConfigurations(WidgetConfiguration<?> widgetConfiguration);

}
