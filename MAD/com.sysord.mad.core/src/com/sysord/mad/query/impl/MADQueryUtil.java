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
package com.sysord.mad.query.impl;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sysord.mad.core.Activator;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluatorProvider;
import com.sysord.mad.widget.OutputWidget;
import com.sysord.mad.widget.Widget;

/**
 * Utility for query source parsing and analyzing
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class MADQueryUtil {

	/**
	 * SubQuery processor: delegate for processing a subquery found by the 
	 * findAndProcessSubqueries method.
	 *
	 */
	public static interface SubQueryProcessor{
		
		/**
		 * constant part represents string before or after
		 * the subquery expression
		 * @param constantPart
		 */
		public void processConstantPart(String constantPart);
		
		/**
		 * @param languageId
		 * @param subQuery
		 * @param subQueryNumber 
		 */
		public void processSubQuery(String languageId, String subQuery, int subQueryNumber);
	}
	
	
	/**
	 * SubQueries are writen between '[]'
	 * subquery can contains the language id at head '[LANGUAGE:subqueryExpr]'
	 * variables names are normalized for the language before the processor call
	 * @param queryString
	 */
	public static void findAndProcessSubqueries(String defaultLanguageId, String queryString, SubQueryProcessor processor){
		String subqueriesRegExp = "\\[([^\\[\\]]*)\\]";
		processSource(queryString, subqueriesRegExp, new SubQueriesSourceProcessor(processor, defaultLanguageId));				
	}
	
	
	protected static class SubQueriesSourceProcessor implements SourceProcessor {
		
		SubQueryProcessor subQueryProcessor;
		String defaultLanguageId;
		
		
		public SubQueriesSourceProcessor(SubQueryProcessor subQueryProcessor, String defaultLanguageId) {
			super();
			this.subQueryProcessor = subQueryProcessor;
			this.defaultLanguageId = defaultLanguageId;
		}

		/**
		 * Unmatching parts are parts before and after the subqueries parts
		 */
		@Override
		public void processUnmatchingPart(String constantPart) {
			//Variable name normalization
			String normalized = normalizeVariablesNames(defaultLanguageId, constantPart);
			//delegate to subQuery processor
			subQueryProcessor.processConstantPart(normalized);
		}

		/**
		 * Matching parts are the subqueries parts: test between [].
		 */
		@Override
		public void processMatchingPart(String subQueryPart, int matchingNumber) {
			String subQueryLanguageId = defaultLanguageId;			
			int sepPos = subQueryPart.indexOf(':');
			if(sepPos != -1){
				//extract language id:
				subQueryLanguageId = subQueryPart.substring(0, sepPos);
				subQueryPart = subQueryPart.substring(sepPos + 1);
			}

			//Variable name normalization
			String normalized = normalizeVariablesNames(subQueryLanguageId, subQueryPart);
			//Delegate to subQuery processor
			subQueryProcessor.processSubQuery(subQueryLanguageId, normalized, matchingNumber);
		}
		
	}
	
	
	protected static QueryEvaluatorProvider queryEvaluationProvider;
	
	protected static QueryEvaluatorProvider getQueryEvaluatorProvider(){
		if(queryEvaluationProvider == null){
			queryEvaluationProvider = Activator.getDefault().getInjector().getInstance(QueryEvaluatorProvider.class);
		}
		return queryEvaluationProvider;
	}
	
	protected static String normalizeVariablesNames(String languageId, String source){
		String variableRegexp = "(\\$\\w+)";
		MessageFormat variableNameFormatter = getQueryEvaluatorProvider().getQueryEvaluator(languageId).getVariableFormat();		
		VariableNormalizerSourceProcessor variableNormalizer = new VariableNormalizerSourceProcessor(variableNameFormatter);
		processSource(source, variableRegexp, variableNormalizer);
		return variableNormalizer.normalized.toString();
	}
	
	protected static class VariableNormalizerSourceProcessor implements SourceProcessor {
		
		MessageFormat variableNameFormatter;		
		StringBuilder normalized = new StringBuilder();
				
		public VariableNormalizerSourceProcessor(MessageFormat variableNameFormatter) {
			super();
			this.variableNameFormatter = variableNameFormatter;
		}

		/**
		 * Unmatching parts are parts before and after the variables names 
		 */
		@Override
		public void processUnmatchingPart(String unmatchingPart) {
			normalized.append(unmatchingPart);			
		}

		/**
		 * Matching parts are the variables names parts: $varname.
		 */
		@Override
		public void processMatchingPart(String variableName, int matchingNumber) {
			//remove the '$' prefix to variable name.
			normalized.append(" ").append(variableNameFormatter.format(new String[]{variableName.substring(1)})).append(" ");						
		}
		
		
	}
	
	
	
	/**
	 * Create arguments map from a widget
	 * widget's context element and its model identifiers are added
	 * @param widget
	 * @return
	 */
	public static Map<String, Object> createArguments(Widget<?> widget){
		Map<String, Object>  arguments = createArguments(widget.getContextElement());
		if(OutputWidget.class.isAssignableFrom(widget.getClass())){
			arguments.put(QueryEvaluationService.WIDGET_VALUE_IDENTIFIER, ((OutputWidget)widget).getValue());			
		}
		return arguments;
	}
	
	/**
	 * Create arguments map from a context object
	 * context object and its model identifiers are added
	 * @param widget
	 * @return
	 */
	public static Map<String, Object> createArguments(EObject contextElement){
		Map<String, Object>  arguments = new HashMap<String, Object>();
		arguments.put(QueryEvaluationService.MAIN_MODEL__IDENTIFIER, EcoreUtil.getRootContainer(contextElement));		
		arguments.put(QueryEvaluationService.MAIN_CONTEXT__IDENTIFIER, contextElement);
		return arguments;
	}
	
	
	
	
	//--------------------
	// Source processor
	//--------------------
	
	/**
	 * SubQuery processor: delegate for processing a subquery found by the 
	 * findAndProcessSubqueries method.
	 *
	 */
	public static interface SourceProcessor{
		
		/**
		 * unmatching part represents string before or after
		 * a matching part
		 * @param constantPart
		 */
		public void processUnmatchingPart(String unmatchingPart);

		/**
		 * matching part represents string matching the regexp
		 * 
		 * @param matchingPart
		 * @param matchingNumber
		 */
		public void processMatchingPart(String matchingPart, int matchingNumber);
	}
	
	/**
	 * Parse a Source String using a regexp and  delegate to the {@link SourceProcessor} for
	 * processing matching and unmatching parts. 
	 * Regexp must be written for return the matching part in the group(1).
	 * @param source
	 */
	public static void processSource(String source, String regExp, SourceProcessor processor){
		int matchingPartCount = 0;
		int currentOffset = 0;
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(source);
		while(matcher.find()){
			matchingPartCount++;
			
			String matchingPart = matcher.group(1);
			
			//extract and process constant part
			if(matcher.start(1) > 0){
				//group 0: the full capture: extract part before the full capture as unmatching part
				String unmatchingPart = source.substring(currentOffset, matcher.start(0));
				if(unmatchingPart.length() > 0){
					processor.processUnmatchingPart(unmatchingPart);					
				}
			}
			
			processor.processMatchingPart(matchingPart, matchingPartCount);
			
			currentOffset  = matcher.end();
		}
		
		//Process last unmatching parts part if present		
		if(matchingPartCount == 0){
			//none matching part: source is the single unmatching part.
			processor.processUnmatchingPart(source);
		}else{
			//process end of source as unmatching part if present.
			if(currentOffset < source.length()){
				processor.processUnmatchingPart(source.substring(currentOffset));
			}
		}
		
	}
	
	
}
