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

import com.sysord.mad.configuration.WidgetConfiguration.WIDGET_CATEGORY;

/**
 * Handles widget type configuration.
 * <p>
 * Contains description, label and factory classname.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 */
public interface WidgetTypeConfiguration {

	/**
	 * Provides id used for mapping the widget to its implementation.
	 * 
	 * @return the widget ID.
	 */
	public String getWidgetTypeId();

	/**
	 * Returns the widget type {@link WIDGET_CATEGORY category}.
	 * 
	 * @return the widget type {@link WIDGET_CATEGORY category}.
	 */
	public WIDGET_CATEGORY getWidgetCategory();

	/**
	 * Returns descriptive information: widget type label.
	 * 
	 * @return descriptive information: widget type label.
	 */
	public String getWidgetTypeLabel();

	/**
	 * Returns descriptive information: widget type description.
	 * 
	 * @return descriptive information: widget type description.
	 */
	public String getWidgetTypeDescription();

	/**
	 * Qualified class name of the concrete widget factory.
	 * 
	 * @return the qualified class name of the concrete widget factory.
	 */
	public String getFactoryClassName();

}
