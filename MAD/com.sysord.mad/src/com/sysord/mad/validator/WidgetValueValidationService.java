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
package com.sysord.mad.validator;

import javax.xml.bind.ValidationException;

import com.sysord.mad.configuration.ValidatorDefinition;
import com.sysord.mad.widget.InputWidget;

/**
 * Service for validating the future value of a widget.
 * <p>
 * This service uses the {@link ValidatorDefinition validators} defined by a given widget
 * to validate the value to put into this widget.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see ValidatorDefinition
 * @see InputWidget
 */
public interface WidgetValueValidationService {

	/**
	 * Validate the value for a widget.
	 * each widget validator is processed, when a validator
	 * detects a value as invalid a {@link ValidationException} is raised.
	 * 
	 * @param widget
	 * @param value
	 * @throws ValidationException
	 */
	public void validateWidget(InputWidget<?> widget, Object value) throws InvalidWidgetValueException;

}
