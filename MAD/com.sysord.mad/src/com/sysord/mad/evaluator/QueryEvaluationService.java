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

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.query.QueryDefinition;

/**
 * Query Evaluation
 * 
 * Get evaluator for query language and use it for Evaluate 
 *
 */
public interface QueryEvaluationService { 

	public static final String SUBQUERY_ARGUMENT_NAME_PREFIX = "SUBQ_";

	
	//INJECTED IDENTIFIERS
	
	/**
	 * Main model is the model of the context element
	 */
	public static final String MAIN_MODEL__IDENTIFIER = "MODEL";
	public static final String FOREIGN_MODEL__IDENTIFIER = "FMODEL";
	public static final String MAIN_CONTEXT__IDENTIFIER = "CONTEXT";
	public static final String RELOCATED_CONTEXT__IDENTIFIER = "RCONTEXT";
	public static final String COMMAND_RESULT_IDENTIFIER = "RESULT";
	public static final String WIDGET_VALUE_IDENTIFIER = "VALUE";
	public static final String WIDGET_UIVALUE_IDENTIFIER = "UIVALUE";
	//public static final String WIDGET_IDENTIFIER = "WIDGET";
	
	
	/**
	 * flush the optimisation cache
	 */
	public void flushCache();

	/**
	 * Evaluate from the contextObject the query expression wrote in the language defined by languageId 
	 * 
	 * @param contextObject
	 * @param languageId
	 * @param queryExpr
	 * @param arguments 
	 * @return
	 */
	public <T> T evaluateExpression(Object contextObject, String languageId, String queryExpr, Map<String, Object> arguments) throws QueryEvaluatorException;

	/**
	 * Evaluate the query from the contextObject
	 * 
	 * @param contextObject
	 * @param query
	 * @param arguments TODO
	 * @return
	 */
	public <T> T evaluate(Object contextObject, QueryDefinition<T> query, Map<String, Object> arguments) throws QueryEvaluatorException;
	

	/**
	 * Evaluate the query  from the contextObject and return the associated evaluation analyze
	 * 
	 * @param contextObject
	 * @param query
	 * @param arguments TODO
	 * @return
	 * @throws QueryEvaluatorException
	 */
	public <T> EvaluationAnalyze evaluateWithAnalyze(Object contextObject, QueryDefinition<T> query, Map<String, Object> arguments) throws QueryEvaluatorException;

	
	/**
	 * Execute an action query
	 * action query is a query that can change model state (update, add/remove element etc.) 
	 * @param contextObject
	 * @param query
	 * @param arguments
	 * @return an Object or null (depending on the Action implementation)
	 * @throws QueryEvaluatorException
	 */
	public <T> T runActionQuery(Object contextObject, QueryDefinition<T> query, Map<String, Object> arguments) throws QueryEvaluatorException;
	
}
