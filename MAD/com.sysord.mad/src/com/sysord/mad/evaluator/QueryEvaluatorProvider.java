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

/**
 *  
 *
 */
public interface QueryEvaluatorProvider {

	/**
	 * Register the Query evaluator and associates it
	 * to its language id.
	 * @param evaluator
	 */
	public void registerQueryEvaluator(QueryEvaluator evaluator);

	/**
	 * Register the Query evaluator and associates it
	 * to the language id.
	 * 
	 * @param evaluator
	 * @param languageId
	 */
	public void registerQueryEvaluator(QueryEvaluator evaluator, String languageId);
	
	/**
	 * Unregister all registered QueryEvaluators
	 */
	public void unregisterAllQueryEvaluators();
	
	/**
	 * Provide the evaluator associated to the language id
	 * 
	 * @param languageId id for the language to be evaluated
	 * @return the evaluator associated to the language id or null
	 */
	public QueryEvaluator getQueryEvaluator(String languageId);
	
}
