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
package com.sysord.mad.configuration.impl;

import com.sysord.mad.configuration.ValidatorDefinition;
import com.sysord.mad.query.QueryDefinition;

public class ValidatorDefinitionImpl implements ValidatorDefinition {

	protected QueryDefinition<Boolean> validationQuery;
	protected String errorMessageExpression;
	
		
	public ValidatorDefinitionImpl(QueryDefinition<Boolean> validationQuery, String errorMessageExpression) {
		super();
		this.validationQuery = validationQuery;
		this.errorMessageExpression = errorMessageExpression;
	}

	@Override
	public QueryDefinition<Boolean> getValidationQuery() {
		return validationQuery;
	}

	@Override
	public String getErrorMessageExpression() {
		return errorMessageExpression;
	}

}
