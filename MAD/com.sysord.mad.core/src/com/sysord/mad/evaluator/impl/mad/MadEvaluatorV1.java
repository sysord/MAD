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
package com.sysord.mad.evaluator.impl.mad;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.sysord.mad.MadAttribute;
import com.sysord.mad.evaluator.EvaluationAnalyze;
import com.sysord.mad.evaluator.QueryAnalyze;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.evaluator.impl.AbstractQueryEvaluator;
import com.sysord.mad.mao.ValuedSemanticElement.ACCESS_CATEGORY;

public class MadEvaluatorV1 extends AbstractQueryEvaluator {
	
	public static final String MAD__LANGUAGE_ID = "MAD";

	@Inject
	protected MadMacrosEvaluatorV1 macroEvaluator;
	
	public static final String MAD_VALUE = "@Value";

	@Override
	public String getLanguageId() {
		return MAD__LANGUAGE_ID;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T> QueryResult processEvaluation(QueryEvaluationContext evaluationContext, Object contextObjectOrProxy) throws QueryEvaluatorException {
		//Mad query are only String Query expression. 
		if(! (evaluationContext.getQuery() instanceof String)){
			throw queryEvaluatorException(evaluationContext.getQuery().toString(), "is not a Query expression. MAD evaluator don't supports this Query.");
		}
		
		String queryExpr = (String) evaluationContext.getQuery();
		try {
			//Query is a MAD MAcro
			if (macroEvaluator.isMadMacro(queryExpr)) {
				return (T) macroEvaluator.RunMadMacros((EObject)evaluationContext.getContextObject(), queryExpr, evaluationContext.getArguments());
			}else{
				return processMadQueryEvaluation(evaluationContext);
			}
		} catch (QueryEvaluatorException e) {
			throw e;
		} catch (Exception e) {
			throw new QueryEvaluatorException(e);
		}
	}

	
	
	protected <T> T processMadQueryEvaluation(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException{

		EObject contextObject = (EObject) evaluationContext.getContextObject(); 
		String queryExpression = (String) evaluationContext.getQuery();
		Map<String, Object> arguments = evaluationContext.getArguments();
		
		if(MAD_VALUE.equals(queryExpression)){
			return process_MAD_VALUE(contextObject, queryExpression, arguments);
		}		

		
		throw queryEvaluatorException(queryExpression,"Invalid MAD_EVALUATOR Query.");
	}
	
	/**
	 * retrieve value from a contextObject
	 * 
	 * if context objet is a MadAttribute: return the value and configure the evaluationAnalyze for update the real feature.
	 * 
	 * @param contextObject
	 * @param queryDefinition
	 * @param evaluationAnalyze
	 * @return
	 * @throws QueryEvaluatorException
	 */
	protected <T> T process_MAD_VALUE(EObject contextObject, String queryExpr, Map<String,Object> arguments) throws QueryEvaluatorException{
		
		//Mad attribute
		if(MadAttribute.class.isAssignableFrom(contextObject.getClass())){
			MadAttribute madAttribute = (MadAttribute) contextObject;
			
			Object resultValue = madAttribute.getAttributeValue();
			
			EvaluationAnalyze evaluationAnalyze = getEvaluationAnalyze();
			evaluationAnalyze.setAccessCategory(ACCESS_CATEGORY.PROPERTY);
			//set true owner and feature
			evaluationAnalyze.setResultContext(madAttribute.getValueOwner());
			evaluationAnalyze.setFeatureOrOperation(madAttribute.getValueFeature());
			//set value
			evaluationAnalyze.setResultValue(resultValue);
			evaluationAnalyze.setConvertedResultValue(resultValue);
			
			return (T) resultValue;
		}
		
		return null;
	}

	@Override
	public QueryAnalyze analyzeQuery(QueryEvaluationContext evaluationContext, Object contextObjectOrProxy) throws QueryEvaluatorException {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
