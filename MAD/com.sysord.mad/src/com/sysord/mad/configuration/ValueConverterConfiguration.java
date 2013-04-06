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

/**
 * Configuration for a value converter.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see WidgetConfiguration
 */
public interface ValueConverterConfiguration {

	/**
	 * Category of Value Converter.
	 */
	public enum VALUE_CONVERTER_CATEGORY {
		DATE_CONVERTER,
		DATETIME_CONVERTER,
		INTEGER_CONVERTER,
		FLOAT_CONVERTER,
		DOUBLE_CONVERTER,
		XTEXT_CONVERTER,
	}

	/**
	 * Returns the value converter {@link VALUE_CONVERTER_CATEGORY category}.
	 * 
	 * @return the value converter {@link VALUE_CONVERTER_CATEGORY category}.
	 */
	public VALUE_CONVERTER_CATEGORY getCategory();

	/**
	 * Returns the string holding the converter custom configuration.
	 * 
	 * @return the string holding the converter custom configuration.
	 */
	public String getConfiguration();

}
