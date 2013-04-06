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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.nls.I18nService;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.evaluator.FormatExpressionEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.evaluator.impl.ocl.OCLQueryEvaluator;
import com.sysord.mad.query.impl.MADQueryUtil;
import com.sysord.mad.query.impl.MADQueryUtil.SubQueryProcessor;

/**
 * Evaluator for format expression
 * parsed expressions are cached
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class FormatExpressionEvaluationServiceImpl implements FormatExpressionEvaluationService {

	protected static final String I18N_PREFIX = ConfigurationManager.I18N_PREFIX;
	
	@Inject
	protected QueryEvaluationService evaluationService;

	@Inject
	protected I18nService i18NService;
	
	/**
	 * Map for store since parsed expressions (cache)
	 */
	protected Map<String,ParsedFormatExpression> parsedExpressionCache = new HashMap<String, FormatExpressionEvaluationServiceImpl.ParsedFormatExpression>();
	
	@Override
	public String evaluateFormatExpression(Object contextObject, String formatExpression, Map<String, Object> arguments) {
		if(formatExpression == null || formatExpression.trim().length() == 0){
			return "";
		}				
		String formattedValue = null;
		if(isI18NFormatExpression(formatExpression)){
			formattedValue = i18NformatValue(contextObject, formatExpression, arguments);						
		}else{
			formattedValue = formatValue(contextObject, formatExpression, arguments);			
		}
		if(formattedValue == null){
			formattedValue = formatExpression;
		}
		return formattedValue;
	}
	
	/**
	 * I18N format expression starts with I18N prefix
	 * @param formatExpression
	 * @return
	 */
	protected boolean isI18NFormatExpression(String formatExpression){
		return formatExpression.startsWith(I18N_PREFIX);
	}
	
	/**
	 * Format the value applying the format
	 * format is a String composed of constant parts and evaluable parts between []
	 * @param ouputValue
	 * @param format
	 */
	protected String formatValue(Object context, String format, Map<String, Object> arguments) {
		if(!format.contains("[")){
			//assume is a constant format expression
			return format;
		}
		return _evalFormatExpression(context, format, arguments, null, false);
	}

	/**
	 * Format the value applying the format
	 * I18N format is a String where first constant part is the I18N key and evaluable parts between [] are arguments
	 * @param context
	 * @param format
	 */
	protected String i18NformatValue(Object context, String format, Map<String, Object> arguments) {
		List<Object>  evaluatedArguments = new ArrayList<Object>();
		//eval arguments and extract first fragment as I18NKEY
		_evalFormatExpression(context, format.substring(I18N_PREFIX.length()), arguments, evaluatedArguments, true);
		//first argument must is the I18N Key		
		String i18NKey = evaluatedArguments.get(0).toString();
		evaluatedArguments.remove(0);
		return i18NService.get(i18NKey, evaluatedArguments.toArray());			
	}
	
	/**
	 * Evaluate the format expression and build formatted string
	 * evaluated arguments are added to the outArguments list.
	 * 
	 * @param context
	 * @param format the format expression
	 * @param outArguments (can be null) list for collect arguments value
	 * @param addFirstFragmentAsArgument if true inserts first text fragment as first argument
	 * @return
	 */
	protected String _evalFormatExpression(Object context, String format, Map<String, Object> inputArguments, List<Object> outArguments, boolean addFirstFragmentAsArgument){		
		
		//look for parsed expression in cache
		ParsedFormatExpression parsedExpression = parsedExpressionCache.get(format);
		if(parsedExpression == null){
			//parse expression and store in cache
			FormatExpressionParser parser = new FormatExpressionParser();
			MADQueryUtil.findAndProcessSubqueries(OCLQueryEvaluator.OCL_LANGUAGE_ID, format, parser);
			parsedExpression = parser.parsedFormatExpression;
			parsedExpressionCache.put(format, parsedExpression);
		}

		//Eval format expression from its parsed form.
		StringBuilder formattedValue = new StringBuilder();
		for(FormatExpressionTerm term : parsedExpression.terms){
			if(term.isSubQuery){
				//eval only if context is not null and context is an EObject, otherwise subquery is consumed (replaced by empty String). 
				if(context != null){
					Object evaluationResult = evaluateQueryExpression(context, term.languageId, term.literalValue, inputArguments);
					if(evaluationResult != null){
						formattedValue.append(evaluationResult.toString());
					}else{
						//formattedValue.append("null");					
					}					
					if(outArguments != null){
						outArguments.add(evaluationResult);
					}
				}			
			}else{
				//constant part
				formattedValue.append(term.literalValue);
			}
		}
		
		//no valuable parts 
		if(!parsedExpression.containEvaluableParts){
			//add first text fragment: the format
			if(outArguments != null && addFirstFragmentAsArgument){
				outArguments.add(0, format);
			}
			return format;
		}else{
			//add first text fragment (used by I18N)
			if(outArguments != null && addFirstFragmentAsArgument){
				outArguments.add(0, parsedExpression.terms.isEmpty() ? "" : parsedExpression.terms.get(0));
			}
			return formattedValue.toString();
		}		

	}


	
	/**
	 * Expression processor for Creating ParsedFormatExpression from Format Expression
	 */
	protected class FormatExpressionParser implements SubQueryProcessor{		
		ParsedFormatExpression parsedFormatExpression = new ParsedFormatExpression();
		
		@Override
		public void processConstantPart(String constantPart) {
			parsedFormatExpression.addConstantPart(constantPart);
		}

		@Override
		public void processSubQuery(String languageId, String subQueryExpr, int subQueryNumber) {
			parsedFormatExpression.addSubQueryExpr(subQueryExpr, languageId);			
		}
		
	}

	
	//---------------------------------------
	// Parsed format Expression structure
	//---------------------------------------
	
	/**
	 * Parsed Format expression structure
	 * subqueries and constants parts are store in a list 
	 * as terms of the format expression
	 *
	 */
	protected class ParsedFormatExpression{
		protected List<FormatExpressionTerm> terms = new ArrayList<FormatExpressionEvaluationServiceImpl.FormatExpressionTerm>();
		protected boolean containEvaluableParts = false;
		
		public void addConstantPart(String constantPart){
			terms.add(new FormatExpressionTerm(constantPart, false, null));
		}

		public void addSubQueryExpr(String subQueryExpr, String languageId){
			terms.add(new FormatExpressionTerm(subQueryExpr, true, languageId));
			containEvaluableParts = true;
		}		
	}

	/**
	 * Term member of a format expression
	 */
	protected class FormatExpressionTerm{
		protected boolean isSubQuery = false;
		protected String languageId;
		protected String literalValue;
		
		public FormatExpressionTerm(String literalValue, boolean isSubQuery, String subQueryLanguageId) {
			super();
			this.isSubQuery = isSubQuery;
			this.literalValue = literalValue;
			this.languageId = subQueryLanguageId;
		}
		
		@Override
		public String toString() {
			return literalValue == null ? "null" : literalValue;
		}
	}
	
	
	protected <T> Object evaluateQueryExpression(Object defaultContext, String languageId, String queryExpression, Map<String, Object> arguments){
		try {
			return evaluationService.evaluateExpression(defaultContext, languageId, queryExpression, arguments);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
