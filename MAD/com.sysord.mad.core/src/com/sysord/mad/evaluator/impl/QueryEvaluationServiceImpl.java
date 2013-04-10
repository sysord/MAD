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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.MadCollection;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationService;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationServiceProvider;
import com.sysord.mad.evaluator.EvaluationAnalyze;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.QueryEvaluationContextFactory;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluator;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.evaluator.QueryEvaluatorProvider;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.model.EditedModel;
import com.sysord.mad.model.provider.ModelProviderService;
import com.sysord.mad.query.QueryChainDefinition;
import com.sysord.mad.query.QueryDefinition;
import com.sysord.mad.query.QueryDefinition.OPTIMISATION_LEVEL;
import com.sysord.mad.query.QueryDefinition.RETURN_VALUE_OCCURENCE;
import com.sysord.mad.query.SingleQueryDefinition;
import com.sysord.mad.query.impl.MADQueryUtil;
import com.sysord.mad.query.impl.MADQueryUtil.SubQueryProcessor;
import com.sysord.mad.query.impl.QueryFactory;
import com.sysord.mad.structure.MadAttributesFactory;
import com.sysord.mad.type.TypeDescriptor;
import com.sysord.mad.type.TypeDescriptor.TYPE_CATEGORY;
import com.sysord.mad.type.TypeDescriptorImpl;
import com.sysord.mad.type.TypeDescriptorUtil;
import com.sysord.mad.type.TypedValue;
import com.sysord.mad.type.TypedValueImpl;

public class QueryEvaluationServiceImpl implements QueryEvaluationService {

	@Inject
	protected ConsoleLogger logger;
	
	@Inject
	protected QueryEvaluatorProvider evaluatorProvider;

	@Inject
	protected ModelProviderService modelProvider;
	
	@Inject
	protected MadAttributesFactory attributesFactory;
	
	@Inject 
	protected ExternalQueryConfigurationServiceProvider extQServiceProvider;

	@Inject
	protected QueryEvaluationContextFactory defaultQueryEvaluationContextFactory;
	
	protected QueryEvaluationServiceCache cache = new QueryEvaluationServiceCache();

	
	protected static final boolean WITHOUT_EVALUATION_ANALYZE = false;
	protected static final boolean EVALUATION_ANALYZE = true;
	
	
	@Override
	public void flushCache() {
		cache.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T evaluateExpression(Object contextObject, String languageId, String queryExpression, Map<String, Object> arguments) throws QueryEvaluatorException {
		Map<String, TypedValue> evaluationArguments = createEvaluationArguments(contextObject, arguments);
		return (T) processQueryExprEvaluation(languageId, contextObject, queryExpression, Object.class, RETURN_VALUE_OCCURENCE.UNKNOW, evaluationArguments);
	}

	
	@Override
	public <T> T evaluate(Object contextObject, QueryDefinition<T> query, Map<String, Object> arguments) throws QueryEvaluatorException {
		try {
			Map<String, TypedValue> evaluationArguments = createEvaluationArguments(contextObject, arguments); 
			QueryResult<T> queryResult = (QueryResult<T>) _processEvaluation(contextObject, query, evaluationArguments);
			return queryResult.getValue();
		} catch (QueryEvaluatorException e){
			logger.logError("QueryEvaluationService.evaluate:" + e.getMessage());
			throw(e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError("QueryEvaluationService.evaluate:" + e.getMessage());
			throw new QueryEvaluatorException(e);
		}
	}
	
	@Override
	public <T> EvaluationAnalyze evaluateWithAnalyze(Object contextObject, QueryDefinition<T> query, Map<String, Object> arguments) throws QueryEvaluatorException {
		try {
			Map<String, TypedValue> evaluationArguments = createEvaluationArguments(contextObject, arguments);
			QueryResult<T> queryResult = _processEvaluationWithAnalyze(createTypedValue(contextObject), query, evaluationArguments);
			return queryResult.getEvaluationAnalyze();
		} catch (QueryEvaluatorException e){
			logger.logError("QueryEvaluationService.evaluateWithAnalyze:" + e.getMessage());
			throw(e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError("QueryEvaluationService.evaluateWithAnalyze:" + e.getMessage());
			throw new QueryEvaluatorException(e);
		}
	}

	@Override
	public <T> T runActionQuery(Object contextObject, QueryDefinition<T> query, Map<String, Object> arguments) throws QueryEvaluatorException {
		try {
			Map<String, TypedValue> evaluationArguments = createEvaluationArguments(contextObject, arguments);
			QueryResult<?> queryResult = _processRunQueryAction(createTypedValue(contextObject), query, evaluationArguments);
			return (T) queryResult.getValue(); 
		} catch (QueryEvaluatorException e){
			logger.logError("QueryEvaluationService.runActionQuery:" + e.getMessage());
			throw(e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError("QueryEvaluationService.runActionQuery:" + e.getMessage());
			throw new QueryEvaluatorException(e);
		}		
	}

	
	/**
	 * Converts arguments to typedValue
	 * 
	 * @param contextObject
	 * @param arguments
	 * @return
	 */
	protected Map<String, TypedValue> createEvaluationArguments(Object contextObject, Map<String, Object> arguments){
		Map<String, TypedValue> evaluationArguments = new HashMap<String, TypedValue>();
		if(arguments != null){
			for(Entry<String, Object> entryArg : arguments.entrySet()){
				evaluationArguments.put(entryArg.getKey(), createTypedValue(entryArg.getValue()));
			}
		}		
		return evaluationArguments;
	}
	
	
	protected QueryEvaluator getQueryEvaluator(SingleQueryDefinition<?> query) throws QueryEvaluatorException {
		return getQueryEvaluator(query.getQueryLanguageId());
	}

	protected QueryEvaluator getQueryEvaluator(String languageId) throws QueryEvaluatorException {
		QueryEvaluator evaluator = evaluatorProvider.getQueryEvaluator(languageId);
		if(evaluator != null){
			return evaluator;			
		}else{
			throw new QueryEvaluatorException("No evaluator found for language '" + languageId + "'");
		}
	}
	
	
	/**
	 * 
	 * @param contextObject
	 * @param query
	 * @return
	 * @throws QueryEvaluatorException 
	 */
	protected <T> QueryResult<T> _processEvaluation(Object contextObject, QueryDefinition<T> query, Map<String, TypedValue> arguments) throws QueryEvaluatorException{		
		if(SingleQueryDefinition.class.isAssignableFrom(query.getClass())){
			//unique query
			return _processSingleQueryEvaluation(createTypedValue(contextObject), (SingleQueryDefinition<T>) query, arguments, WITHOUT_EVALUATION_ANALYZE);
			
		}else if(QueryChainDefinition.class.isAssignableFrom(query.getClass())){
			//query chain
			TypedValue currentContext = createTypedValue(contextObject);
			QueryChainDefinition<T> queryChain = (QueryChainDefinition<T>)query;
			for(Iterator<SingleQueryDefinition<?>> itSingleQueryDef = queryChain.getQueriesDefinitions().iterator(); itSingleQueryDef.hasNext();){
				SingleQueryDefinition<?> singleQueryDef = itSingleQueryDef.next();
				if(itSingleQueryDef.hasNext()){
					QueryResult<?> resultContext = _processSingleQueryEvaluation(currentContext, singleQueryDef, arguments, WITHOUT_EVALUATION_ANALYZE);
					currentContext = adaptResultContext(resultContext);
				}else{
					//TODO: Validate result type and occurence
					return _processSingleQueryEvaluation(currentContext, (SingleQueryDefinition<T>)singleQueryDef, arguments, WITHOUT_EVALUATION_ANALYZE);
				}				
			}

		}
		
		return null;		
	}

	
	protected TypedValue adaptResultContext(TypedValue resultContext){
		return resultContext;
	}


	
	/**
	 * 
	 * @param contextObject
	 * @param query
	 * @return
	 * @throws QueryEvaluatorException 
	 */
	@SuppressWarnings("unchecked")
	protected <T> QueryResult<T> _processEvaluationWithAnalyze(TypedValue contextObject, QueryDefinition<T> query, Map<String, TypedValue> arguments) throws QueryEvaluatorException{		
		QueryResult<T> queryResultWithAnalyze = null;
		if(SingleQueryDefinition.class.isAssignableFrom(query.getClass())){
			//unique query
			queryResultWithAnalyze = _processSingleQueryEvaluation(contextObject, (SingleQueryDefinition<T>) query, arguments, EVALUATION_ANALYZE);			
		}else if(QueryChainDefinition.class.isAssignableFrom(query.getClass())){
			//query chain
			TypedValue currentContext = contextObject;
			QueryChainDefinition<T> queryChain = (QueryChainDefinition<T>)query;
			for(Iterator<SingleQueryDefinition<?>> itSingleQueryDef = queryChain.getQueriesDefinitions().iterator(); itSingleQueryDef.hasNext();){
				SingleQueryDefinition<?> singleQueryDef = itSingleQueryDef.next();
				if(itSingleQueryDef.hasNext()){
					TypedValue resultContext = _processSingleQueryEvaluation(currentContext, singleQueryDef, arguments, WITHOUT_EVALUATION_ANALYZE);
					currentContext = adaptResultContext(resultContext);
				}else{
					queryResultWithAnalyze = (QueryResult<T>) _processSingleQueryEvaluation(currentContext, singleQueryDef, arguments, EVALUATION_ANALYZE);
				}				
			}
		}		
		return queryResultWithAnalyze;
	}


	
	/**
	 * Single Query evaluation
	 * 
	 * @param contextObject 
	 * @param query
	 * @return
	 * @throws QueryEvaluatorException
	 */	
	protected <T> QueryResult<T> _processSingleQueryEvaluation(TypedValue contextObject, SingleQueryDefinition<T> query,
																Map<String, TypedValue> arguments, 
																boolean requireEvaluationAnalyze) throws QueryEvaluatorException{
		try {
			QueryResult<T> queryResult =  null;		
			//try retrieve result from cache 			
			if(isQueryCachable(query)){
				queryResult = cache.getEvaluationResult(query, contextObject.getValue());
				//if need analyze and not analyze is set we have to evaluate query with analyze
				if(requireEvaluationAnalyze && queryResult != null && queryResult.getEvaluationAnalyze() == null){
					queryResult = null;
				}
			}
			
			if(queryResult != null){
				logger.log(query.getOptimisationLevel() +   " Cache is useful !!! for evaluate:" + query.getQuery(), ConsoleLogger.VERY_LOW);
				//System.out.println(query.getOptimisationLevel() +   " Cache is useful !!! for evaluate:" + query.getQuery() + " " + contextObject.getValue().hashCode() + ":"  + contextObject.getValue().getClass().getSimpleName());
			}else{
				//no value in cache. evaluate query
				contextObject = relocateContext(contextObject, query, arguments);
				//extract and evaluate subqueries, input arguments are added to the ouput map
				Map<String, TypedValue> evaluationArguments = evalSubQueriesAndMergeArguments(contextObject, query, arguments);
				//create evaluation context
				QueryEvaluationContext queryEvaluationContext = createQueryEvaluationContext(query, contextObject, evaluationArguments, requireEvaluationAnalyze);
				//evaluate
				queryResult = getQueryEvaluator(query).evaluate(queryEvaluationContext);
				//validate and convert result
				//FIXME:
				queryResult = convertQueryResult(queryResult, query);
				//store result in cache
				if(isQueryCachable(query)){
					cache.storeEvaluationResult(query, contextObject.getValue(), queryResult);
				}			
			}
			logger.log("QueryEvaluationService: context:" + (contextObject.getValue()!= null ? contextObject.getValue().hashCode(): "null")
														+ " result=" +  queryResult.getValue() + " for query " + query.getQuery(), 
														ConsoleLogger.VERY_LOW);
			//System.out.println("QueryEvaluationService: result=" +  queryResult.getValue() + " for query " + query.getQuery());
			return queryResult;
		} catch (Exception e) {
			//e.printStackTrace();
			throw createEvaluationException("Error during evaluation for Query:\"" + query.getQuery() + "\"", e, query.getQuery());
		}
	}

	
	protected <T> boolean isQueryCachable(SingleQueryDefinition<T> query){
		//external Queries or query with variables are not cachable
		if(query.isExternalQuery() || query.getQuery().contains("$")){
			//System.out.println("NON CACHABLE QUERY:" + query.getQuery());
			return false;
		}
		//System.out.println("CACHABLE QUERY:" + query.getQuery());
		return query.getOptimisationLevel() == OPTIMISATION_LEVEL.VIEW || query.getOptimisationLevel() == OPTIMISATION_LEVEL.CONTEXT;
	}
	
	/**
	 * 
	 * @param contextObject
	 * @param query
	 * @return
	 * @throws QueryEvaluatorException 
	 */
	protected <T> QueryResult<T> _processRunQueryAction(TypedValue contextObject, QueryDefinition<T> query, Map<String, TypedValue> arguments) throws QueryEvaluatorException{		
		if(SingleQueryDefinition.class.isAssignableFrom(query.getClass())){
			//unique query
			return (QueryResult<T>) _processRunSingleQueryAction(contextObject, (SingleQueryDefinition<T>) query, arguments);
			
		}else if(QueryChainDefinition.class.isAssignableFrom(query.getClass())){
			//query chain
			TypedValue currentContext = contextObject;
			QueryChainDefinition<?> queryChain = (QueryChainDefinition<?>)query;
			for(Iterator<SingleQueryDefinition<?>> itSingleQueryDef = queryChain.getQueriesDefinitions().iterator(); itSingleQueryDef.hasNext();){
				SingleQueryDefinition<?> singleQueryDef = itSingleQueryDef.next();
				if(itSingleQueryDef.hasNext()){
					TypedValue resultContext = _processSingleQueryEvaluation(currentContext, singleQueryDef, arguments, WITHOUT_EVALUATION_ANALYZE);
					currentContext = adaptResultContext(resultContext);
				}else{
					return (QueryResult<T>) _processRunSingleQueryAction(currentContext, (SingleQueryDefinition<T>) singleQueryDef, arguments);
				}				
			}
		}
		return null;
	}

	protected <T> QueryResult<T> _processRunSingleQueryAction(TypedValue contextObject, SingleQueryDefinition<T> query, 
																Map<String, TypedValue> arguments) throws QueryEvaluatorException{
		try {
			contextObject = relocateContext(contextObject, query, arguments);
			//extract and evaluate subqueries, input arguments are added to the ouput map
			Map<String, TypedValue> evaluationArguments = evalSubQueriesAndMergeArguments(contextObject, query, arguments);
			//create evaluation context
			QueryEvaluationContext queryEvaluationContext = createQueryEvaluationContext(query, contextObject, evaluationArguments, WITHOUT_EVALUATION_ANALYZE);
			QueryResult<T> result = getQueryEvaluator(query).runActionQuery(queryEvaluationContext);
			//validate and convert result
			result = convertQueryResult(result, query);
			//evaluate action query 
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw createEvaluationException("Error running Query action for Query:\"" + query.getQuery() + "\"", e, query.getQuery());
		}
	}
	
	/**
	 * 
	 * Context relocation is processed from the origin context
	 * using parametrized relocator expression.
	 * 
	 * Context relocation is only applied when query use a foreign model.
	 * If query don't use a foreign model, none relocation is processed and context stay the origin context. 
	 * 
	 * current context is initialized with origin context 
	 * 
	 * if used query  provides a relocation expression:
	 * 		this relocation expression will be used
	 * else
	 * 		foreign model relocation expression will be used
	 * endif
	 * 
	 * Context relocation expression evaluation:
	 * 		- relocation expression subqueries are evaluated using origin context
	 * 		- relocation expression is evaluated with the foreign model as context.
	 *
	 * 
	 * @param contextObject the origin context
	 * @param query the query where context has to be relocated
	 * 
	 * @return the relocated query context
	 * @throws QueryEvaluatorException 
	 */
	protected <T> TypedValue relocateContext(TypedValue contextObject, SingleQueryDefinition<T> query, Map<String, TypedValue> arguments) throws QueryEvaluatorException{		

		if(!contextObject.getType().isEObject()){
			return contextObject;
		}
		
		TypedValue currentContext = contextObject;
		EObject eContextObject = (EObject) contextObject.getValue();
		
		//Remove previous RContext and FModel values (when several relocation occurs in a query chain)
		arguments.remove(RELOCATED_CONTEXT__IDENTIFIER);
		arguments.remove(FOREIGN_MODEL__IDENTIFIER);

		//no foreign model -> no relocation
		if(query.getTargetModelType() == null){
			return currentContext;
		}

		//Obtain foreign model
		EditedModel foreignModelWrapper = modelProvider.getModel(eContextObject, query.getTargetModelType());
		if(foreignModelWrapper == null || foreignModelWrapper.getModel() == null){
			logger.log("No model found for type '" + query.getTargetModelType() + "'" );
			return currentContext;			
		}
		
		EObject foreignModel = foreignModelWrapper.getModel();
		TypedValue foreignModelContext = createTypedValue(foreignModel);
		
		arguments.put(FOREIGN_MODEL__IDENTIFIER, foreignModelContext);

		
		if(query.getContextLocator() != null){
			//process relocation using Query relocation expression
			currentContext = processContextRelocation(query.getQueryLanguageId(), currentContext, query.getContextLocator(), foreignModelContext, arguments);
		}else{
			//process relocation using foreign model relocation Query 
			SingleQueryDefinition<EObject> modelRelocatorQueryDef = query.getTargetModelRelocatorQuery();
			if(modelRelocatorQueryDef != null){ //TODO: create check in DSL for avoid null locator !!!
				currentContext = processContextRelocation(modelRelocatorQueryDef.getQueryLanguageId(), 
						currentContext, modelRelocatorQueryDef.getContextLocator(), 
						foreignModelContext, arguments);
				arguments.put(RELOCATED_CONTEXT__IDENTIFIER, currentContext);
				//evaluate the foreign model query
				if(modelRelocatorQueryDef.getQuery() != null && !"".equals(modelRelocatorQueryDef.getQuery())){
					//create evaluation context
					QueryEvaluationContext queryEvaluationContext = createQueryEvaluationContext(modelRelocatorQueryDef, currentContext, arguments, WITHOUT_EVALUATION_ANALYZE);
					currentContext = getQueryEvaluator(modelRelocatorQueryDef).evaluate(queryEvaluationContext);				
				}				
			}
		}
		arguments.put(RELOCATED_CONTEXT__IDENTIFIER, currentContext);
		return currentContext;		
	}

	
//	/**
//	 * 
//	 * Context relocation is processed from the origin context
//	 * using parametrized relocator expression.
//	 * 
//	 * Context relocation is only applied when query use a foreign model.
//	 * If query don't use a foreign model, none relocation is processed and context stay the origin context. 
//	 * 
//	 * current context is initialized with origin context 
//	 * 
//	 * if used query  provides a relocation expression:
//	 * 		this relocation expression will be used
//	 * else
//	 * 		foreign model relocation expression will be used
//	 * endif
//	 * 
//	 * Context relocation expression evaluation:
//	 * 		- relocation expression subqueries are evaluated using origin context
//	 * 		- relocation expression is evaluated with the foreign model as context.
//	 *
//	 * 
//	 * @param contextObject the origin context
//	 * @param query the query where context has to be relocated
//	 * 
//	 * @return the relocated query context
//	 * @throws QueryEvaluatorException 
//	 */
//	protected <T> Object relocateContextV1(Object contextObject, SingleQueryDefinition<T> query, Map<String, Object> arguments) throws QueryEvaluatorException{		
//
//		if(!EObject.class.isAssignableFrom(contextObject.getClass())){
//			return contextObject;
//		}
//		Object  currentContext = contextObject;
//		EObject eContextObject = (EObject) contextObject;
//		
//		//Remove previous RContext and FModel values (when several relocation occurs in a query chain)
//		arguments.remove(RELOCATED_CONTEXT__IDENTIFIER);
//		arguments.remove(FOREIGN_MODEL__IDENTIFIER);
//
//		//no foreign model -> no relocation
//		if(query.getTargetModelType() == null){
//			return currentContext;
//		}
//
//		//Obtain foreign model
//		EditedModel foreignModelWrapper = modelProvider.getModel(eContextObject, query.getTargetModelType());
//		if(foreignModelWrapper == null || foreignModelWrapper.getModel() == null){
//			logger.log("No model found for type '" + query.getTargetModelType() + "'" );
//			return currentContext;			
//		}
//		
//		EObject foreignModel = foreignModelWrapper.getModel();
//		
//		arguments.put(FOREIGN_MODEL__IDENTIFIER, foreignModel);
//		
//		if(query.getContextLocator() != null){
//			//process relocation using Query relocation expression
//			currentContext = processContextRelocation(query.getQueryLanguageId(), eContextObject, query.getContextLocator(), foreignModel, arguments);
//		}else{
//			//process relocation using foreign model relocation Query 
//			SingleQueryDefinition<EObject> modelRelocatorQueryDef = query.getTargetModelRelocatorQuery();
//			if(modelRelocatorQueryDef != null){ //TODO: create check in DSL for avoid null locator !!!
//				currentContext = processContextRelocation(modelRelocatorQueryDef.getQueryLanguageId(), 
//						eContextObject, modelRelocatorQueryDef.getContextLocator(), 
//															foreignModel, arguments);
//				arguments.put(RELOCATED_CONTEXT__IDENTIFIER, currentContext);
//				//evaluate the foreign model query
//				if(modelRelocatorQueryDef.getQuery() != null && !"".equals(modelRelocatorQueryDef.getQuery())){
//					//create evaluation context
//					QueryEvaluationContext queryEvaluationContext = createQueryEvaluationContext(modelRelocatorQueryDef, currentContext, arguments);
//					currentContext = getQueryEvaluator(modelRelocatorQueryDef).evaluate(queryEvaluationContext);				
//				}				
//			}
//		}
//		arguments.put(RELOCATED_CONTEXT__IDENTIFIER, currentContext);
//		return currentContext;		
//	}

	
	/**
	 * Apply context Relocation (evaluate only Relocation Expression)
	 *  
	 * @param languageID 
	 * @param relocationParametersContextObject	context Object for subqueries evaluation
	 * @param relocatorQueryExpression relocation expression containing subQueries between brackets 
	 * @param relocationTargetObject context object for relocation (the target model)
	 * @return
	 * @throws QueryEvaluatorException 
	 */
	protected QueryResult<?> processContextRelocation(String languageID, TypedValue relocationParametersContextObject,
												String relocatorQueryExpression, TypedValue relocationTargetObject,
												Map<String, TypedValue> arguments) throws QueryEvaluatorException{
		
		//relocation arguments (merge arguments)
		Map<String, TypedValue> relocationArguments = new HashMap<String, TypedValue>();
		relocationArguments.putAll(arguments);
		
		//Eval the relocator query parameters
		//extract and evaluate subqueries, input arguments are added to the ouput map
		Map<String, TypedValue> subqueriesValue = evalSubQueries(languageID, relocationParametersContextObject, relocatorQueryExpression, relocationArguments);
		//input arguments are added to the ouput map
		relocationArguments.putAll(subqueriesValue);
		//Create a Querydefinition for the relocation expression
		SingleQueryDefinition<EObject> relocatorQdef = QueryFactory.createSingleQueryDefinition(null, languageID, relocatorQueryExpression, 
																								EObject.class, RETURN_VALUE_OCCURENCE.SINGLE_VALUE);
		
				
		//create evaluation context
		QueryEvaluationContext queryEvaluationContext = createQueryEvaluationContext(relocatorQdef, relocationTargetObject, relocationArguments, WITHOUT_EVALUATION_ANALYZE);

		//Eval reloacation expression with valued parameters
		return getQueryEvaluator(languageID).evaluate(queryEvaluationContext);
	}
	
//	/**
//	 * Apply context Relocation
//	 *  
//	 * @param languageID 
//	 * @param relocationParametersContextObject	context Object for parameters evaluation
//	 * @param relocatorQueryExpression relocation expression containing parameters between brackets 
//	 * @param relocationTargetObject context object for relocation (parameters evaluated relocatorQueryExpression evaluation)
//	 * @return
//	 * @throws QueryEvaluatorException 
//	 */
//	protected EObject processContextRelocationV1(String languageID, EObject relocationParametersContextObject, String relocatorQueryExpression, EObject relocationTargetObject) throws QueryEvaluatorException{
//		
//		//Extract and evaluate parameters
//		Pattern pattern = Pattern.compile("\\[(.*?)\\]",Pattern.DOTALL);
//		Matcher matcher = pattern.matcher(relocatorQueryExpression);
//		String convertedQuery = relocatorQueryExpression;
//		while(matcher.find()){
//			String paramExpr = matcher.group(1);
//			//create query for parameter evaluation (Only String value)
//			SingleQueryDefinition<Object> parameterQdef = new QueryDefinitionImpl<Object>(null, languageID, paramExpr, Object.class, RETURN_VALUE_OCCURENCE.SINGLE_VALUE);
//			String strParameterValue = "null";
//			try {
//				Object parameterValue = _processSingleQueryEvaluation(relocationParametersContextObject, parameterQdef);
//				strParameterValue = parameterValue.toString();
//			} catch (QueryEvaluatorException e) {
//				logger.logError("Query parameter evaluation fail. parameter expr:" + paramExpr + " . ERROR" + e.getMessage());
//				e.printStackTrace();
//			}
//			convertedQuery = matcher.replaceFirst(strParameterValue);
//		}
//		
//		//Eval the relocator query
//		SingleQueryDefinition<Object> relocatorQdef = new QueryDefinitionImpl<Object>(null, languageID, convertedQuery, Object.class, RETURN_VALUE_OCCURENCE.SINGLE_VALUE);
//		return  (EObject) _processSingleQueryEvaluation(relocationTargetObject, relocatorQdef);
//	}

	
	/**
	 * Evaluate a String query expression
	 * 
	 * @param languageID
	 * @param context
	 * @param queryExpression
	 * @param returnType
	 * @param returnOccurence
	 * @return
	 * @throws QueryEvaluatorException
	 */
	protected <T> T processQueryExprEvaluation(String languageID, Object context, String queryExpression, 
												Class<T> returnType, RETURN_VALUE_OCCURENCE returnOccurence,
												Map<String, TypedValue> arguments) throws QueryEvaluatorException{
		if(returnType == null){
			returnType  = (Class<T>) Object.class;
		}
		if(returnOccurence == null){
			returnOccurence = RETURN_VALUE_OCCURENCE.UNKNOW;
		}
		SingleQueryDefinition<T> queryDefinition = QueryFactory.createSingleQueryDefinition(
																			null, languageID,queryExpression, 
																			returnType, returnOccurence,
																			OPTIMISATION_LEVEL.CONTEXT);
		
		QueryResult<T> queryResult = _processSingleQueryEvaluation(createTypedValue(context), queryDefinition, arguments, WITHOUT_EVALUATION_ANALYZE);
		return queryResult.getValue();
	}



	/**
	 * Eval subqueries value and add all input arguments Map value 
	 * to the subqueries evalaution result.
	 * 
	 * @param evalSubQueriescontext
	 * @param mainQuery
	 * @param arguments
	 * @throws QueryEvaluatorException
	 */
	protected <T> Map<String, TypedValue> evalSubQueriesAndMergeArguments(TypedValue evalSubQueriescontext, SingleQueryDefinition<T> mainQuery, 
																		Map<String, TypedValue> arguments) throws QueryEvaluatorException{
		Map<String, TypedValue> subQueriesValues = evalSubQueries(mainQuery.getQueryLanguageId(), evalSubQueriescontext, mainQuery.getQuery(), arguments);
		if(arguments != null){
			subQueriesValues.putAll(arguments);			
		}
		return subQueriesValues;
	}

	/**
	 * SubQueries evaluation.
	 * - extract all subqueries : expression between []
	 * - evaluate subqueries
	 * 
	 * @param evalSubQueriescontext
	 * @param mainQuery
	 * @return map of subqueries evaluations result, arguments keys are ARG_1 ARG_2 .. ARG_n
	 * @throws QueryEvaluatorException 
	 */
	protected <T> Map<String, TypedValue> evalSubQueries(TypedValue evalSubQueriescontext, SingleQueryDefinition<T> mainQuery, 
														Map<String, TypedValue> arguments) throws QueryEvaluatorException{
		return evalSubQueries(mainQuery.getQueryLanguageId(), evalSubQueriescontext, mainQuery.getQuery(), arguments);
	}

	/**
	 * Parameters evaluation.
	 * - extracts all subqueries : expression between [subqueryExpr]
	 * - evaluates subqueryExpr
	 * - adds result associated to subquery variable in the arguments Map
	 * 
	 * @param languageID
	 * @param evalSubQueriescontext
	 * @param mainQuery
	 * @return arguments values.
	 * @throws QueryEvaluatorException 
	 * 
	 */
	protected <T> Map<String, TypedValue> evalSubQueries(String languageId, final TypedValue evalSubQueriescontext, 
													final String mainQuery, final Map<String, TypedValue> arguments) throws QueryEvaluatorException{
		//Extract and evaluate subqueries
		final Map<String, TypedValue> subQueriesValues = new HashMap<String, TypedValue>();
		
		//external queries doesn't have Query expression
		if(mainQuery == null){
			return subQueriesValues;
		}
				
		try {
			MADQueryUtil.findAndProcessSubqueries(languageId, mainQuery,
					
				new SubQueryProcessor() {				
					@Override
					public void processSubQuery(String languageId, String subQueryExpr, int subQueryNumber) {
						//create query for subquery evaluation 
						SingleQueryDefinition<Object> parameterQdef = QueryFactory.createSingleQueryDefinition(null, languageId, subQueryExpr, 
																							Object.class, RETURN_VALUE_OCCURENCE.UNKNOW);
						try {
							String argName = SUBQUERY_ARGUMENT_NAME_PREFIX + subQueryNumber;
							TypedValue parameterValue = _processSingleQueryEvaluation(evalSubQueriescontext, parameterQdef, arguments, WITHOUT_EVALUATION_ANALYZE);
							//add subquery evaluation result as argument
							subQueriesValues.put(argName, parameterValue);
						} catch (QueryEvaluatorException e) {
							e.printStackTrace();
							logger.logError("SubQuery evaluation fail. SuqQuery expr:" + subQueryExpr + " . ERROR" + e.getMessage());
							throw new RuntimeException(createEvaluationException("SubQuery evaluation fail. SuqQuery expr:" + subQueryExpr, e, mainQuery));
						}					
					}
					
					@Override
					public void processConstantPart(String constantPart) {
						//nothing to do
					}
				}	
			);
		} catch (Exception e) {
			throw createEvaluationException("SubQueries evaluation fail:", e, mainQuery);
		}
				
		return subQueriesValues;
	}
	
		
	/**
	 * validate evaluation result type conformance.
	 * Converts result when possible.
	 * - when result is Collection or MAP and expected occurrence is SINGLE: return first
	 * - when result is not a Collection and expected occurrence is LIST: create a list and adds the result.
	 * 
	 * When result type is not conform to expected type QueryEvaluatorException is raised.
	 * 
	 * @param result
	 * @param queryDefinition
	 * @return
	 * @throws QueryEvaluatorException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected <T> QueryResult<T> convertQueryResult(QueryResult<T> queryResult, SingleQueryDefinition<T> queryDefinition) throws QueryEvaluatorException{
		
		Object resultValue = queryResult.getValue();
		TypeDescriptor resultType = queryResult.getType();
		
		QueryResult<T> outQResult = null;
		TypeDescriptor outQResultType = null;
		
		//no conversion needed
		if(resultValue == null){
			return queryResult;
		}
		

		if(queryDefinition.isSingleValueReturned()){
			//Single value result:
			//if list take the first element
			if(resultType.isCollection()){
				List lResults = new ArrayList(((Collection)resultValue));
				if(lResults.isEmpty()){
					//no value in the collection: return null;
					return (QueryResult<T>) QueryResultImpl.NULL_QUERY_RESULT;
				}else{
					validateResultType(lResults.get(0).getClass(), queryDefinition);
					if(queryDefinition.getReturnType().isAssignableFrom(lResults.get(0).getClass())){
						//Select only first collection element, result type is the collection itemType
						return new QueryResultImpl<T>((T) lResults.get(0), resultType.getItemTypeDescriptor());						
					}else{
					}
				}
			}else if(resultType.isMap()){
				List lResults = new ArrayList(((Map)resultValue).values());
				if(lResults.isEmpty()){
					//no value in the collection: return null;
					return (QueryResult<T>) QueryResultImpl.NULL_QUERY_RESULT;
				}else{
					validateResultType(lResults.get(0).getClass(), queryDefinition);
					if(queryDefinition.getReturnType().isAssignableFrom(lResults.get(0).getClass())){
						//Select only first collection element, result type is the collection itemType
						return new QueryResultImpl<T>((T) lResults.get(0), resultType.getItemTypeDescriptor());						
					}else{
					}
				}
			}else{
				outQResult = queryResult;
			}
			
		}else if(queryDefinition.isValuesListReturned()){
			//collection values expected as result
			if(!resultType.isCollection()){
				List lResults = new ArrayList();
				if(resultType.isMap()){
					//insert map values in the output collection
					lResults.addAll(((Map)resultValue).values());
				}else{
					//insert single value in the output collection
					lResults.add(resultValue);
				}
				//create query result: result is a List with the query result element
				outQResultType = new TypeDescriptorImpl(TYPE_CATEGORY.SEQUENCE, List.class, null);
				outQResultType.setItemTypeDescriptor(resultType);
				outQResult = new QueryResultImpl<T>((T) lResults, outQResultType);
				outQResult.setEvaluationAnalyze(queryResult.getEvaluationAnalyze());
			}else{
				outQResult = queryResult;
			}
		}else{
			outQResult = queryResult;
		}

		//null value
		if(outQResult  == null){
			return (QueryResult<T>) QueryResultImpl.NULL_QUERY_RESULT;
		}
		
		//validate type
		validateQueryResultType(outQResult, queryDefinition);

		return outQResult;
	}

	
	/**
	 * Throw exception for invalid type 
	 * @throws QueryEvaluatorException
	 */
	protected <T> void validateQueryResultType(QueryResult<T> queryResult, SingleQueryDefinition<T> queryDefinition) throws QueryEvaluatorException{
		//Class<?> resultType = queryResult.getType().getType();
		Object result = queryResult.getValue();
		if(result != null){
			Class<T> expectedType = queryDefinition.getReturnType();
			if(Collection.class.isAssignableFrom(expectedType)){
				expectedType = (Class<T>) Collection.class;
			}
			if(!expectedType.isAssignableFrom(queryResult.getValue().getClass())){
				throw new QueryEvaluatorException("Query '" + queryDefinition.getQuery() 
							+ "' should returns result of type '" + queryDefinition.getReturnType().getName() + "' " +
							"'" + result.getClass().getName()	+	"' returned result is incompatible.");
			}			
		}
	}
	
	
	protected <T> T convertResult(Object result, SingleQueryDefinition<T> queryDefinition) throws QueryEvaluatorException{
			
		//no conversion needed
		if(result == null){
			return null;
		}
		
		Object convertedResult = null;

		if(queryDefinition.isSingleValueReturned()){
			//Single value result:
			//if list take the first element
			if(Collection.class.isAssignableFrom(result.getClass())){
				List lResults = new ArrayList(((Collection)result));
				if(lResults.isEmpty()){
					return null;
				}else{
					validateResultType(lResults.get(0).getClass(), queryDefinition);
					if(queryDefinition.getReturnType().isAssignableFrom(lResults.get(0).getClass())){
						return (T) lResults.get(0);						
					}else{
					}
				}
			}else if(Map.class.isAssignableFrom(result.getClass())){
				List lResults = new ArrayList(((Map)result).values());
				if(lResults.isEmpty()){
					return null;
				}else{
					validateResultType(lResults.get(0).getClass(), queryDefinition);
					if(queryDefinition.getReturnType().isAssignableFrom(lResults.get(0).getClass())){
						return (T) lResults.get(0);						
					}else{
					}
				}
			}else{
				convertedResult = result;
			}
		}else if(queryDefinition.isValuesListReturned()){
			//collection values expected as result
			if(!Collection.class.isAssignableFrom(result.getClass())){
				List lResults = new ArrayList();
				if(Map.class.isAssignableFrom(result.getClass())){
					//insert map values in the output collection
					lResults.addAll(((Map)result).values());
				}else{
					//insert single value in the output collection
					lResults.add(result);
				}
				convertedResult = lResults;								
			}else{
				convertedResult = result;				
			}
		}else{
			convertedResult = result;			
		}

		//null value
		if(convertedResult == null){
			return null;
		}
		
		//validate type
		validateResultType(convertedResult.getClass(), queryDefinition);

		return (T) convertedResult;
	}




	/**
	 * Throw exception for invalid type 
	 * @throws QueryEvaluatorException
	 */
	protected <T> void validateResultType(Class resultType, SingleQueryDefinition<T> queryDefinition) throws QueryEvaluatorException{
		Class<T> expectedType = queryDefinition.getReturnType();
		if(Collection.class.isAssignableFrom(expectedType)){
			expectedType = (Class<T>) Collection.class;
		}
		if(!expectedType.isAssignableFrom(resultType)){
			throw new QueryEvaluatorException("Query '" + queryDefinition.getQuery() 
						+ "' should returns result of type '" + queryDefinition.getReturnType().getName() + "' " +
						"'" + resultType.getName()	+	"' returned result is incompatible.");
		}
	}

	
	
	
	/**
	 * Create the Query evaluation context
	 * if an extQservice is provided for the language then obtains factory from it
	 * else use default factory. 
	 * @return
	 */
	protected QueryEvaluationContext createQueryEvaluationContext(SingleQueryDefinition query, TypedValue contextObject,
																	Map<String,TypedValue> arguments, boolean requireEvaluationAnalyze){
		QueryEvaluationContextFactory factory = getQueryEvaluationContextFactory(query.getQueryLanguageId());
		QueryEvaluationContext queryEvaluationContext = factory.createEvaluationContext(query, contextObject, arguments, requireEvaluationAnalyze);
		return queryEvaluationContext;
	}

	/**
	 * Obtains the Query evaluation context factory for the language
	 * if ExtQService exists for the language request factory to its
	 * otherwise use the default factory
	 * @param languageId
	 * @return
	 */
	protected QueryEvaluationContextFactory getQueryEvaluationContextFactory(String languageId){
		QueryEvaluationContextFactory factory = null;
		ExternalQueryConfigurationService extQService = extQServiceProvider.getExtQService(languageId);
		if(extQService != null){
			//return extQService.getQueryEvaluationContextFactory();
		}

		return defaultQueryEvaluationContextFactory;
	}

	/**
	 * Create a QueryEvaluatorException
	 * 
	 * @param message exception message
	 * @param e	origin exception
	 * @param query	query string
	 * @throws QueryEvaluatorException
	 */
	protected QueryEvaluatorException createEvaluationException(String message, Throwable cause, String query) {
		QueryEvaluatorException evalException = null;
		if(cause != null){
			message += " " + cause.getMessage();
			evalException = new QueryEvaluatorException(message, cause);
		}else {
			evalException = new QueryEvaluatorException(message);			
		}
		evalException.setQuery(query);
		return evalException;
	}


	/**
	 * Create a typed value. 
	 * type is discovered from object class
	 * @param object
	 * @return
	 */
	protected TypedValue createTypedValue(Object object){
		return new TypedValueImpl(object, TypeDescriptorUtil.createTypeDescriptor(object));
	}
	
}
