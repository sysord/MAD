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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.sysord.mad.MadAttribute;
import com.sysord.mad.evaluator.EvaluationAnalyze;
import com.sysord.mad.evaluator.QueryAnalyze;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.evaluator.impl.AbstractQueryEvaluator;
import com.sysord.mad.evaluator.impl.QueryEvaluatorUtil;
import com.sysord.mad.functionparser.FunctionProcessingException;
import com.sysord.mad.mao.ValuedSemanticElement.ACCESS_CATEGORY;


public class MadEvaluator extends AbstractQueryEvaluator {
	
	public static final String MAD__LANGUAGE_ID = "MAD";

	@Inject
	protected MadMacrosEvaluator macroEvaluator;
	
	public static final String MAD_VALUE = "@Value";

	@Override
	public String getLanguageId() {
		return MAD__LANGUAGE_ID;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T> QueryResult<?> processEvaluation(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		//Mad query are only String Query expression. 
		if(! (evaluationContext.getQuery() instanceof String)){
			throw queryEvaluatorException(evaluationContext.getQuery().toString(), "is not a Query expression. MAD evaluator don't supports this Query.");
		}

		try {
			Object result = null;
			String sourceQuery = (String) evaluationContext.getQuery();
			//specific: @ is not supported by parser at this time
			if(MAD_VALUE.equals(sourceQuery)){
				result = process_MAD_VALUE((EObject)evaluationContext.getContextObject(), null);
			}else{
				//Parse and execute query
				MadEvaluatorFunctionProcessor processor = new MadEvaluatorFunctionProcessor(evaluationContext);
				result = QueryEvaluatorUtil.parseQuery(sourceQuery, processor);
				if(!processor.exprIsFunction){
					throw createInvalidQueryException(sourceQuery, "Query doesn't contain function.");
				}
			}			
			return createDefaultQueryResult(result);
			
		} catch (QueryEvaluatorException e) {
			throw e;
		} catch (Exception e) {
			throw new QueryEvaluatorException(e);
		}
	}

	
	protected Object evaluateMadFunction(String funcname, List<Object> functionArguments, QueryEvaluationContext evaluationContext) throws QueryEvaluatorException{
		try {
			//Query is a MAD MAcro
			if (macroEvaluator.isMadMacro(funcname)) {
				//DON'T USE PROXY FOR ACTION QUERY
				return macroEvaluator.RunMadMacros((EObject)evaluationContext.getContextObject(), funcname, functionArguments, evaluationContext);
			}else{								
				return processMadQueryEvaluation(evaluationContext, funcname, functionArguments);
			}
		} catch (QueryEvaluatorException e) {
			throw e;
		} catch (Exception e) {
			throw new QueryEvaluatorException(e);
		}
		
	}
	
	protected class MadEvaluatorFunctionProcessor extends AbstractBaseFunctionProcessor{

		/**
		 * flag set to treu when a function is evaluated
		 */
		protected boolean exprIsFunction = false;
		
		public MadEvaluatorFunctionProcessor(QueryEvaluationContext evaluationContext) {
			super(evaluationContext);
		}

		/**
		 * All argument are ready, we have to eval the function
		 * if function not exists throws an exception
		 * if arguments are not conform throws an exception
		 * evaluates the function and returns the result.
		 */
		@Override
		public Object evalFunction(String funcname, List<Object> arguments) throws FunctionProcessingException {
			try {
				exprIsFunction = true;
				return evaluateMadFunction(funcname, arguments, evaluationContext);
			} catch (QueryEvaluatorException e) {
				throw new FunctionProcessingException("Fail during '" + funcname + "' evaluation.", e);
			}
		}
		
	}
	
	
	protected <T> T processMadQueryEvaluation(QueryEvaluationContext evaluationContext, String funcName, List<Object> functionArguments) throws QueryEvaluatorException{
		
		if(MAD_VALUE.equals(funcName)){
			return process_MAD_VALUE((EObject)evaluationContext.getContextObject(), functionArguments);
		}		
		
		throw queryEvaluatorException(funcName,"Unknow MAD_EVALUATOR function.");
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
	protected <T> T process_MAD_VALUE(EObject contextObject, List<Object> arguments) throws QueryEvaluatorException{
		
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
	public QueryAnalyze analyzeQuery(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
