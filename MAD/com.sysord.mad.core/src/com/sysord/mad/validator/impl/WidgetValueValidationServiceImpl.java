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
package com.sysord.mad.validator.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.ValidationException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.Inject;
import com.sysord.mad.configuration.ValidatorDefinition;
import com.sysord.mad.evaluator.FormatExpressionEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.evaluator.impl.ocl.OCLQueryEvaluator;
import com.sysord.mad.query.QueryChainDefinition;
import com.sysord.mad.query.SingleQueryDefinition;
import com.sysord.mad.validator.InvalidWidgetValueException;
import com.sysord.mad.validator.WidgetValueValidationService;
import com.sysord.mad.widget.InputWidget;

public class WidgetValueValidationServiceImpl implements WidgetValueValidationService {


	@Inject
	protected QueryEvaluationService evaluationService;
	
	@Inject
	protected FormatExpressionEvaluationService formatExprEvaluationService;
	
	
	
	@Override
	public void validateWidget(InputWidget<?> widget, Object value) throws InvalidWidgetValueException {
		for(ValidatorDefinition validator : widget.getConfig().getValidators()){
			processValidation(widget, value, validator);
		}
	}
	
	/**
	 * Process validation for a value and a validator
	 * - eval validation query
	 * - if evaluation fail: raise a {@link RuntimeException}
	 * - if evaluation returns false: evaluate error message and raise a {@link ValidationException}
	 * - else value is valid: returns;
	 * 
	 * @param value
	 * @param validator
	 * @throws ValidationException
	 */
	protected void processValidation(InputWidget<?> widget, Object value, ValidatorDefinition validator) throws InvalidWidgetValueException {		
		QueryChainDefinition<Boolean> qChain = (QueryChainDefinition<Boolean>) validator.getValidationQuery();		
		if(qChain.getQueriesDefinitions().size() > 1){
			throw new RuntimeException("*** QUERY CHAIN ARE NOT YET SUPPORTED FOR VALIDATION ***");
		}
		SingleQueryDefinition<Boolean> validationQuery = (SingleQueryDefinition<Boolean>) qChain.getQueriesDefinitions().get(0);		
		//create arguments
		Map<String,Object> arguments = new HashMap<String,Object>();
		arguments.put(QueryEvaluationService.MAIN_CONTEXT__IDENTIFIER, widget.getContextElement());
		arguments.put(QueryEvaluationService.MAIN_MODEL__IDENTIFIER, EcoreUtil.getRootContainer(widget.getContextElement()));
		arguments.put(QueryEvaluationService.WIDGET_VALUE_IDENTIFIER, widget.getValue());		
		arguments.put(QueryEvaluationService.WIDGET_UIVALUE_IDENTIFIER, value);		
		//evaluation
		try {
			Boolean validationResult = evaluationService.evaluate(widget.getContextElement(), validationQuery, arguments);
			if(!validationResult){
				//evaluate error message and raise exception
				String errorMessage = formatExprEvaluationService.evaluateFormatExpression(widget.getContextElement(), 
																				validator.getErrorMessageExpression(), null);
				throw new InvalidWidgetValueException(errorMessage);
			}
		} catch (Exception e) {
			if(e instanceof InvalidWidgetValueException){
				throw (InvalidWidgetValueException)e;
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	/**
	 * Evaluates the subQueries and store result in a arguments value list.
	 * if subQueries is a substitution expression then return substitution value
	 * else use OCL for evaluate the subquery.
	 * 
	 * @param context
	 * @param validationRule
	 * @param substitutions
	 * @return all evaluated arguments.
	 */
	protected List<Object> _evalArguments(Object context, String validationRule, Map<String, Object> substitutions){		
		List<Object> outArguments = new ArrayList<Object>();		
		//value must be a EObject for allow evaluation
		if(context != null && EObject.class.isAssignableFrom(context.getClass())){		
			//Extract and evaluate queries parts
			Pattern pattern = Pattern.compile("\\[(.*?)\\]",Pattern.DOTALL);
			Matcher matcher = pattern.matcher(validationRule);
			while(matcher.find()){
				Object evaluationResult;
				String evaluableExpr = matcher.group(1);
				if(substitutions.containsKey(evaluableExpr)){
					evaluationResult = substitutions.get(evaluableExpr);
				}else{
					evaluationResult = evaluateQueryExpression((EObject) context, OCLQueryEvaluator.OCL_LANGUAGE_ID, evaluableExpr);									
				}
				outArguments.add(evaluationResult);
			}
		}		
		return outArguments;		
	}
	
	
	protected <T> Object evaluateQueryExpression(EObject defaultContext, String languageId, String queryExpression){
		try {
			return evaluationService.evaluateExpression(defaultContext, languageId, queryExpression, null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
