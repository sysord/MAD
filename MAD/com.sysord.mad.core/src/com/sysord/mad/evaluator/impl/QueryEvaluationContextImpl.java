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
package com.sysord.mad.evaluator.impl;

import java.util.Map;

import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.query.QueryEnvironment;
import com.sysord.mad.type.TypeDescriptor;
import com.sysord.mad.type.TypedValue;

public class QueryEvaluationContextImpl implements QueryEvaluationContext {

	protected String languageID;
	protected QueryEnvironment environment;
	protected Object contextObject;
	protected Object overridedContextObject;
	protected TypeDescriptor contextObjectType;
	protected Map<String, TypedValue> arguments;
	protected Object query;
	protected Class<?> returnType;
	protected RETURN_VALUE_OCCURENCE returnValueOccurence = RETURN_VALUE_OCCURENCE.NONE_VALUE;
	protected Map<String, Object> properties;
	protected boolean evaluationAnalyzeRequired;
		
	public QueryEvaluationContextImpl(String languageID, QueryEnvironment environment, Object contextObject, TypeDescriptor contextObjectType,
									Map<String, TypedValue> arguments, Object query, Class<?> returnType, 
									RETURN_VALUE_OCCURENCE returnValueOccurence, 
									Map<String, Object> properties, 
									boolean evaluationAnalyzeRequired) {
		super();
		this.languageID = languageID;
		this.environment = environment;
		this.contextObject = contextObject;
		this.contextObjectType = contextObjectType;
		this.arguments = arguments;
		this.query = query;
		this.returnType = returnType;
		this.returnValueOccurence = returnValueOccurence;
		this.properties = properties;
		this.evaluationAnalyzeRequired = evaluationAnalyzeRequired;
	}

	@Override
	public String getLanguageId() {
		return languageID;
	}

	@Override
	public QueryEnvironment getEnvironment() {
		return environment;
	}

	@Override
	public Object getContextObject() {
		return contextObject;
	}
	
	@Override
	public TypeDescriptor getContextObjectType() {
		return contextObjectType;
	}

	@Override
	public Map<String, TypedValue> getArguments() {
		return arguments;
	}

	@Override
	public Object getQuery() {
		return query;
	}

	@Override
	public boolean isSourceQuery() {
		return query instanceof String;
	}

	@Override
	public Class<?> getReturnType() {
		return returnType;
	}

	@Override
	public Boolean isSingleValueReturned() {
		return returnValueOccurence == RETURN_VALUE_OCCURENCE.SINGLE_VALUE;
	}

	@Override
	public Boolean isValuesListReturned() {
		return returnValueOccurence == RETURN_VALUE_OCCURENCE.VALUES_LIST;
	}

	@Override
	public Map<String, Object> getProperties() {
		return properties;
	}

	@Override
	public boolean isEvaluationAnalyzeRequired() {
		return evaluationAnalyzeRequired;
	}

	@Override
	public void overrideContextObject(Object newContextObject) {
		overridedContextObject = contextObject;
		contextObject = newContextObject;
	}

}
