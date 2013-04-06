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

import java.text.MessageFormat;


/**
 * Interface for all Query Evaluators.
 */
public interface QueryEvaluator {

	/**
	 * Returns the evaluator language id. 
	 * @return the evaluator language id
	 */
	public String getLanguageId();

	
	/**
	 * Analyzes the query without evaluation for syntax validation
	 * and discovering return type information.
	 * <p>
	 * because this method is not used at this time, its implementation can returns {@code null}. 
	 * </p>
	 * 
	 * @param evaluationContext
	 * @return the {@link QueryAnalyze} result for this analyze  
	 * @throws QueryEvaluatorException
	 */
	public QueryAnalyze analyzeQuery(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException;
	
	/**
	 * Returns a {@link MessageFormat} for creating a variable name
	 * conform to the evaluator language syntax.
	 * @return the {@link MessageFormat} for creating a variable name
	 * conform to the evaluator language syntax.
	 */
	public MessageFormat getVariableFormat();
	
	/**
	 * Evaluate a query using the {@link QueryEvaluationContext}
	 * 
	 * @param evaluationContext
	 * @return the {@link QueryResult}
	 * @throws QueryEvaluatorException
	 * 
	 */
	public <T> QueryResult<T> evaluate(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException;
	
	
	/**
	 * Execute an action query using the {@link QueryEvaluationContext}.
	 * Action query is a query that can change model state (create, update, add/remove element etc.). 
	 * 
	 * @param evaluationContext
	 * @return an {@link QueryResult} or {@code null} depending on the action implementation. 
	 * @throws QueryEvaluatorException
	 */
	public <T> QueryResult<T> runActionQuery(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException;
}
