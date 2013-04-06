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

import com.sysord.mad.evaluator.FormatExpressionEvaluationService;
import com.sysord.mad.query.QueryDefinition;
import com.sysord.mad.validator.WidgetValueValidationService;

/**
 * Definition of a widget value validator.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see WidgetValueValidationService
 * @see WidgetConfiguration
 */
public interface ValidatorDefinition {

	/**
	 * Returns the query defined for the validation of a value.
	 * <p>
	 * The query will return a boolean value indicating if the validation is correct (
	 * {@code true}) or not ({@code false}).
	 * 
	 * @return the query defined for the validation of a value.
	 */
	public QueryDefinition<Boolean> getValidationQuery();

	/**
	 * Returns the error message as a format expression.
	 * <p>
	 * A format expression is a string expression usable for any label in the MAD
	 * configuration (see {@link FormatExpressionEvaluationService} for more details).
	 * 
	 * @return the error message.
	 */
	public String getErrorMessageExpression();

}
