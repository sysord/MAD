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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.sysord.emf.tools.EMFUtil;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.QueryEvaluationContext.RETURN_VALUE_OCCURENCE;
import com.sysord.mad.evaluator.QueryEvaluationContextFactory;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.evaluator.impl.QueryEvaluationContextImpl;
import com.sysord.mad.query.QueryEnvironment;
import com.sysord.mad.query.SingleQueryDefinition;
import com.sysord.mad.query.impl.MADQueryUtil.SubQueryProcessor;
import com.sysord.mad.type.TypeDescriptor;
import com.sysord.mad.type.TypedValue;

/**
 * Basic QueryEvaluationContextFactory
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class DefaultQueryEvaluationContextFactory implements QueryEvaluationContextFactory {

	public static final String SUBQUERY_ARGUMENT_NAME_PREFIX = QueryEvaluationService.SUBQUERY_ARGUMENT_NAME_PREFIX;
	
	@Override
	public QueryEvaluationContext createEvaluationContext(SingleQueryDefinition query, TypedValue typedContextObject,
															Map<String, TypedValue> arguments, boolean evaluationAnalyzeRequired) {
		
		//Language defined for the query
		String languageID =defineQueryLanguageId(query, typedContextObject, arguments);
		
		//Query environment
		QueryEnvironment environment = defineQueryEnvironment(query, typedContextObject, arguments);
		
		//context object
		Object definedContextObject = defineContextObject(query, typedContextObject, arguments);
		
		//TODO: create and fill type descriptor
		TypeDescriptor definedContextObjectType = defineContextObjectType(query, typedContextObject, arguments);
		
		//evaluation context arguments
		Map<String, TypedValue> contextArguments = defineContextArguments(query, typedContextObject, arguments);
		
		//adapted query
		Object adaptedQuery = createAdaptedQuery(query, typedContextObject, contextArguments);
		
		//query return type
		Class<?> returnType = defineReturnType(query, typedContextObject, contextArguments);
		
		//query return occurence
		RETURN_VALUE_OCCURENCE returnValueOccurence = defineReturnValueOccurence(query, typedContextObject, contextArguments);
		
		//properties for evaluation
		Map<String, Object> properties = defineContextProperties(query, typedContextObject, contextArguments);


		//Creates and return the Query evaluation context.
		return new QueryEvaluationContextImpl(languageID, environment, definedContextObject, definedContextObjectType,
												contextArguments, adaptedQuery, returnType, 
												returnValueOccurence, properties,
												evaluationAnalyzeRequired);
	}
	

	protected String defineQueryLanguageId(SingleQueryDefinition query, TypedValue typedContextObject, Map<String, TypedValue> arguments){
		return query.getQueryLanguageId();
	}

	
	protected static Map<URI,String> NSURIS_CACHE = new HashMap<URI, String>();
	
	protected QueryEnvironment defineQueryEnvironment(SingleQueryDefinition query, TypedValue typedContextObject, Map<String, TypedValue> arguments){
		QueryEnvironment environment = query.getEnvironment();
		//TODO: retrieve nsUri from the context object model
//		Object contextObject = typedContextObject.getValue();
//		if(contextObject != null && EObject.class.isAssignableFrom(contextObject.getClass()) && ((EObject)contextObject).eResource() != null ){
//			URI uri = ((EObject)contextObject).eResource().getURI();
//			String nsUri = NSURIS_CACHE.get(uri);
//			if(nsUri == null){
//				nsUri = EMFUtil.getNSUriFromURI(uri);
//				NSURIS_CACHE.put(uri, nsUri);
//			}
//			environment.getEnvironmentNSUris().add(nsUri);			
//		}
		return environment;
	}

	protected Map<String, TypedValue> defineContextArguments(SingleQueryDefinition query, TypedValue typedContextObject, Map<String, TypedValue> arguments){
		return arguments;
	}

	protected Object defineContextObject(SingleQueryDefinition query, TypedValue typedContextObject, Map<String, TypedValue> arguments){
		return typedContextObject.getValue();
	}

	protected TypeDescriptor defineContextObjectType(SingleQueryDefinition query, TypedValue typedContextObject, Map<String, TypedValue> arguments){
		return typedContextObject.getType();
	}

	
	

	/**
	 * If query is a text query: replace subqueries by theirs argument name.
	 * otherwise return the original query (probably an external query from a DSL)
	 * @param query
	 * @param contextObject
	 * @param arguments
	 * @return
	 */
	protected Object createAdaptedQuery(SingleQueryDefinition query, TypedValue contextObject, Map<String, TypedValue> arguments){
		Object definedQuery = null;
		if(query.isExternalQuery()){
			definedQuery = query.getExternalQuery();
		}else{
			definedQuery = query.getQuery();
		}
		if(definedQuery instanceof String){
			//adapt query:
			definedQuery = injectSubqueriesArguments(query, contextObject, arguments, (String) definedQuery);
		}
		return definedQuery;
	}

	/**
	 * Replace subqueries by their argument name
	 * 
	 * @param query
	 * @param contextObject
	 * @param arguments
	 * @param mainQueryExpr
	 * @return
	 */
	protected String injectSubqueriesArguments(SingleQueryDefinition query, TypedValue contextObject, Map<String, TypedValue> arguments, String mainQueryExpr){		
		InjectArgumentSubQueryProcessor subQueryProcessor = createInjectSubqueriesArgumentsProcessor(query, contextObject, arguments, mainQueryExpr);
		MADQueryUtil.findAndProcessSubqueries(query.getQueryLanguageId(), mainQueryExpr, subQueryProcessor);		
		return subQueryProcessor.getAdaptedQuery();
	}
	
	/**
	 * Create the SubQuery processor
	 * (could be override)
	 * @param query
	 * @param contextObject
	 * @param arguments
	 * @param mainQueryExpr
	 * @return
	 */
	protected InjectArgumentSubQueryProcessor createInjectSubqueriesArgumentsProcessor(SingleQueryDefinition query, TypedValue contextObject, 
																						Map<String, TypedValue> arguments, String mainQueryExpr){
		return new InjectArgumentSubQueryProcessor(query.getQueryLanguageId());
	}
	
	/**
	 * SubQuery Processor for replace subqueries by their associated argument name
	 */
	protected class InjectArgumentSubQueryProcessor implements SubQueryProcessor {

		protected String mainQueryLanguageId;
		
		public InjectArgumentSubQueryProcessor(String mainQueryLanguageId) {
			super();
			this.mainQueryLanguageId = mainQueryLanguageId;
		}

		protected StringBuilder outSb = new StringBuilder();
		
		public String getAdaptedQuery(){
			return outSb.toString();
		}
		
		@Override
		public void processConstantPart(String constantPart) {
			outSb.append(constantPart);			
		}

		@Override
		public void processSubQuery(String subQueryLanguageId, String subQuery, int subQueryNumber) {
			//injected subquery variables will be evaluated by the main query language
			String subQueryVarname = MADQueryUtil.normalizeVariablesNames(mainQueryLanguageId, "$" + SUBQUERY_ARGUMENT_NAME_PREFIX + subQueryNumber);
			outSb.append(" ").append(subQueryVarname).append(" ");						
		}
		
	}
	
	
	
	
	
	protected Class<?> defineReturnType(SingleQueryDefinition query, TypedValue contextObject, Map<String, TypedValue> arguments){
		return query.getReturnType();
	}

	protected RETURN_VALUE_OCCURENCE defineReturnValueOccurence(SingleQueryDefinition query, TypedValue contextObject, Map<String, TypedValue> arguments){
		if(query.isSingleValueReturned()){
			return RETURN_VALUE_OCCURENCE.SINGLE_VALUE;
		}else if(query.isSingleValueReturned()){
			return RETURN_VALUE_OCCURENCE.VALUES_LIST;
		}else {
			return RETURN_VALUE_OCCURENCE.UNKNOW;
		}
	}

	protected Map<String, Object> defineContextProperties(SingleQueryDefinition query, TypedValue contextObject, Map<String, TypedValue> arguments){
		return query.getProperties();
	}

}
