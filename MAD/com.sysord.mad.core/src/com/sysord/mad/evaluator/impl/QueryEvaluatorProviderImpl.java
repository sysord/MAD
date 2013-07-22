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

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.evaluator.QueryEvaluator;
import com.sysord.mad.evaluator.QueryEvaluatorProvider;

/**
 * Store and provide all available QueryEvaluators  
 *
 */
public class QueryEvaluatorProviderImpl implements QueryEvaluatorProvider {

	@Inject
	protected ConsoleLogger logger;

	protected Map<String,QueryEvaluator> hEvaluators = new HashMap<String, QueryEvaluator>();
	
	@Override
	public void registerQueryEvaluator(QueryEvaluator evaluator) {
		registerQueryEvaluator(evaluator, evaluator.getLanguageId());
	}

	@Override
	public void registerQueryEvaluator(QueryEvaluator evaluator, String languageId) {
		logger.log("QueryEvaluatorProvider: register " + evaluator.getClass().getName() + " for language " + languageId);
		hEvaluators.put(languageId, evaluator);
	}

	@Override 
	public void unregisterAllQueryEvaluators() {
		hEvaluators.clear();
	}

	@Override
	public QueryEvaluator getQueryEvaluator(String languageId) {
		QueryEvaluator evaluator = hEvaluators.get(languageId);
		if(evaluator == null){
			logger.logError("QueryEvaluatorProvider: none QueryEvalautor registered for language " + languageId);			
		}
		return evaluator;
	}



	

}
