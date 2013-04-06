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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.functionparser.FunctionParseException;
import com.sysord.mad.functionparser.FunctionParser;
import com.sysord.mad.functionparser.FunctionProcessor;

public class QueryEvaluatorUtil {

	/**
	 * Returns the ordered list of subqueries arguments
	 * extracted from the full map arguments.
	 * @param arguments
	 * @return
	 */
	public static List<Object> extractSubqueriesArgumentsList(Map<String, Object> arguments){
		return new ArrayList<Object>(extractSubqueriesArguments(arguments).values());
	}
	
	/**
	 * Returns an ordered Map of subqueries arguments (subquery 1, ... subquery n)
	 * extracted from the full map arguments.
	 * @param arguments
	 * @return
	 */
	public static Map<String, Object> extractSubqueriesArguments(Map<String, Object> arguments){
		Map<String, Object> extractedArguments = new LinkedHashMap<String, Object>();
		Object subQArg = null;
		int iSubQArg = 0;
		do{
			iSubQArg++;
			String subQName = QueryEvaluationService.SUBQUERY_ARGUMENT_NAME_PREFIX + iSubQArg;
			subQArg = arguments.get(subQName);
			if(subQArg != null){
				extractedArguments.put(subQName, subQArg);
			}
		}while(subQArg != null);
		return extractedArguments;
	}
	
	//TODO: merge with MADQueryUtil.findAndProcessSubqueries	
	/**
	 * QuerySourceProcessor : delegate for processing a element found by the 
	 * processQuerySource method.
	 *
	 */
	public static interface QuerySourceProcessor{
		
		/**
		 * constant part represents string before or after
		 * the searched expression
		 * @param constantPart
		 */
		public void processConstantPart(String constantPart);
				
		/**
		 * 
		 * @param foundItem
		 * @param itemNumber
		 */
		public void processMatchingItem(String foundItem, int itemNumber);
	}
	
	
	/**
	 * SubQueries are writen between '[]'
	 * subquery can contains the language id at head '[LANGUAGE:subqueryExpr]'
	 * @param querySource
	 */
	public static void processQuerySource(String querySource, String itemRegexp, QuerySourceProcessor processor){
		boolean itemFound = false;
		int matchingItemCount = 0;
		int currentOffset = 0;
		Pattern pattern = Pattern.compile(itemRegexp, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(querySource);
		while(matcher.find()){
			itemFound = true;

			String matchingItem = matcher.group(1);
			matchingItemCount++;
			
			//extract and process constant part
			if(matcher.start(1) > 0){
				String constantPart = querySource.substring(currentOffset, matcher.start(1) - 1);
				processor.processConstantPart(constantPart);
			}
			
			//Extract and process matching item expression
			processor.processMatchingItem(matchingItem, matchingItemCount);
			
			currentOffset  = matcher.end();
		}
		
		//Process last constant part if present		
		if(!itemFound){
			//no match found: queryString is the single constant part.
			processor.processConstantPart(querySource);
		}else{
			//process end of queryString as constant part if present.
			if(currentOffset < querySource.length()){
				processor.processConstantPart(querySource.substring(currentOffset));
			}
		}
		
	}
	
	
	//------------------------------------
	// Common functions parser
	//------------------------------------
	public static Object parseQuery(String sourceQuery, FunctionProcessor processor) throws QueryEvaluatorException{
		try {
			FunctionParser parser = new FunctionParser(processor);
			return parser.parse(sourceQuery);
		} catch (FunctionParseException e) {
			throw new QueryEvaluatorException(e);
		} catch(Exception e){
			throw new QueryEvaluatorException(e);			
		}
	}
	
		
	
	
}
