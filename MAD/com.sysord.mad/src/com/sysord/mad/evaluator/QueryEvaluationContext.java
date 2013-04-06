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
package com.sysord.mad.evaluator;

import java.util.Map;

import com.sysord.mad.query.QueryEnvironment;
import com.sysord.mad.type.TypeDescriptor;
import com.sysord.mad.type.TypedValue;

/**
 * Evaluation context for query evaluation.
 * Contains information about context object, environment,
 * expected result type and occurrence. The QueryEvaluationContext
 * hold also arguments for the evaluation. 
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public interface QueryEvaluationContext {

	/**
	 * Return occurrence type
	 */
	public enum RETURN_VALUE_OCCURENCE{
		/**
		 * Query doesn't return value
		 */
		NONE_VALUE,
		/**
		 * Query returns a single value
		 */
		SINGLE_VALUE,
		/**
		 * Query returns a collection of values
		 */
		VALUES_LIST,
		/**
		 * We don't know ...
		 */
		UNKNOW,
	}

	/**
	 * Returns the evaluator language id. 
	 * @return the evaluator language id
	 */
	public String getLanguageId();
	
	/**
	 * Returns the query evaluation environment
	 * @return the {@link QueryEnvironment}.
	 */
	public QueryEnvironment getEnvironment();
	
	/**
	 * Context object for evaluation
	 * @return
	 */
	public Object getContextObject();
	
	/**
	 * Returns the context object type description.
	 * @return the context object type.
	 */
	public TypeDescriptor getContextObjectType();
	
	/**
	 * Arguments for the evaluation.
	 * @return Arguments for the evaluation.
	 */
	public Map<String, TypedValue> getArguments();

	/**
	 * Returns the query. The query can be an object or a string expression.
	 * @return the query
	 */
	public Object getQuery();
	
	/**
	 * Returns  {@code true} if the query is a String expression.
	 * @return {@code true} if the query is a String expression otherwise {@code false}  is returned.
	 */
	public boolean isSourceQuery();
	
	//TODO: replace by type descriptor
	public Class<?> getReturnType();
	
	/**
	 * Returns {@code true} if the query must return a single value.
	 * @return {@code true} if the query must return a single value. 
	 */
	public Boolean isSingleValueReturned();
	
	/**
	 * Returns {@code true} if the query must return a collection of values.
	 * @return {@code true} if the query must return a collection of values. 
	 */
	public Boolean isValuesListReturned();

	
	/**
	 * Properties useful for evalaution
	 * @return
	 */
	public Map<String, Object> getProperties();

	/**
	 * Read the evaluation analyze is required flag.
	 * @return {@code true} if an evaluation analyze is required for the query.
	 */
	public boolean isEvaluationAnalyzeRequired();
	
	/**
	 * Replaces actual context object by this new context object
	 */
	public void overrideContextObject(Object newContextObject);
}
