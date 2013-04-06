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

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.evaluator.EvaluationAnalyze;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.query.SingleQueryDefinition;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class QueryEvaluationServiceCache {

	
	/**
	 * data element stored in cache
	 */
	protected class CacheElement<T>{
				
		public CacheElement() {}
		
		public <ORG_T> CacheElement(CacheElement<ORG_T> cacheElement) {
			super();
			this.isAnalyzeSet = cacheElement.isAnalyzeSet;
			this.analyze = cacheElement.analyze;
			this.isResultSet = cacheElement.isResultSet;
			this.result = (T) cacheElement.result;
		}

		public boolean isAnalyzeSet = false;
		public EvaluationAnalyze analyze;
		public void setAnalyze(EvaluationAnalyze analyze){
			this.analyze = analyze;
			isAnalyzeSet = true;
		}
		
		public boolean isResultSet = false;
		public T result;
		public void setResult(T result){
			this.result = result;
			isResultSet = true;
		}
	}
	
	
//	protected Map<String, CacheElement<QueryResult<?>>> viewLevelCache = new HashMap<String, CacheElement<QueryResult<?>>>();
//	protected Map<String, Map<Object, CacheElement<QueryResult<?>>>> contextLevelCache = new HashMap<String, Map<Object, CacheElement<QueryResult<?>>>>();

	protected Map<String, CacheElement<QueryResult<?>>> viewLevelCache = new HashMap<String, CacheElement<QueryResult<?>>>();
	protected Map<String, Map<Object, CacheElement<QueryResult<?>>>> contextLevelCache = new HashMap<String, Map<Object, CacheElement<QueryResult<?>>>>();

	
	/**
	 * Flush all cached values
	 */
	public void flush(){
		viewLevelCache.clear();
		contextLevelCache.clear();
	}

	public <T> boolean containsEvaluationAnalyze(SingleQueryDefinition<T> query, Object context){
		CacheElement<QueryResult<?>> cacheElement = getCacheElement(query, context, false);
		return (cacheElement != null && cacheElement.analyze != null);
	}
	
	public <T> EvaluationAnalyze getEvaluationAnalyze(SingleQueryDefinition<T> query, Object context){
		CacheElement<QueryResult<?>> cacheElement = getCacheElement(query, context, false);
		if(cacheElement  == null) return null;
		return cacheElement.analyze;
	}

	public <T> void storeEvaluationAnalyze(SingleQueryDefinition<T> query, Object context, EvaluationAnalyze  evaluationAnalyze){
		CacheElement<QueryResult<?>> cacheElement = getCacheElement(query, context, true);
		cacheElement.setAnalyze(evaluationAnalyze);
	}

	public <T> boolean containsEvaluationResult(SingleQueryDefinition<T> query, Object context){
		CacheElement<QueryResult<?>> cacheElement = getCacheElement(query, context, false);
		//System.out.println("containsEvaluationResult:" + context.hashCode() + ":" + query.getQuery() + " => " + (cacheElement != null && cacheElement.isResultSet));
		return (cacheElement != null && cacheElement.isResultSet);
	}
	public <T> QueryResult<T> getEvaluationResult(SingleQueryDefinition<T> query, Object context){
		CacheElement<QueryResult<?>> cacheElement = getCacheElement(query, context, false);
		if(cacheElement  == null) return null;
		return (QueryResult<T>) cacheElement.result;
	}
	
	public <T> void storeEvaluationResult(SingleQueryDefinition<T> query, Object context, QueryResult<T> result){
		CacheElement<QueryResult<?>> cacheElement = getCacheElement(query, context, true);
		cacheElement.setResult(result);
		//System.out.println("storeEvaluationResult:" + context.hashCode() + ":" + query.getQuery());
	}

	
	protected <T> CacheElement<QueryResult<?>> getCacheElement(SingleQueryDefinition<T> query, Object context, boolean createIfNotExists){
		switch(query.getOptimisationLevel()){
		case VIEW:
			return getCacheElement_viewLevel(query, createIfNotExists);
		case CONTEXT:
			return getCacheElement_contextLevel(query, context, createIfNotExists);
		default:
			return null;
		}
	}
	
	
	/**
	 * retrieve cache element for query in the view level cache.
	 * @param query
	 * @return
	 */
	
	protected <T> CacheElement<QueryResult<?>> getCacheElement_viewLevel(SingleQueryDefinition<T> query, boolean createIfNotExists){
		String key = queryToKey(query);
		CacheElement<QueryResult<?>> cacheElement = viewLevelCache.get(key);
		if(cacheElement == null && createIfNotExists){
			cacheElement = createCacheElement();
			viewLevelCache.put(key, cacheElement);
		}
		if(cacheElement != null){
			//TODO: add comment for explain why we clone cache element...: just generics insolubke problem
			//return new CacheElement<QueryResult<T>>(cacheElement);			
			return cacheElement;			
		}else{
			return null;
		}
	}
	
	
	/**
	 * retrieve cache element for query and context in the context level cache.
	 * 
	 * @param query
	 * @param context
	 * @return
	 */
	
	protected <T> CacheElement<QueryResult<?>> getCacheElement_contextLevel(SingleQueryDefinition<T> query, Object context, boolean createIfNotExists){
		Map<Object, CacheElement<QueryResult<?>>> contextCache = getContextCache(query, context, createIfNotExists);
		if(contextCache == null){
			return null;
		}
		CacheElement<QueryResult<?>> cacheElement = contextCache.get(context);
		if(cacheElement == null && createIfNotExists){
			cacheElement = createCacheElement();
			contextCache.put(context, cacheElement);
		}
		if(cacheElement != null){
			//TODO: add comment for explain why we clone cache element...
			//return new CacheElement<QueryResult<T>>(cacheElement);
			return  cacheElement;
		}else{
			return null;
		}
	}

	
	protected <T> Map<Object, CacheElement<QueryResult<?>>>  getContextCache(SingleQueryDefinition<T> query, Object context, boolean createIfNotExists){
		String key = queryToKey(query);
		Map<Object, CacheElement<QueryResult<?>>> contextCache = contextLevelCache.get(key);
		if(contextCache == null && createIfNotExists){
			contextCache = new HashMap<Object, QueryEvaluationServiceCache.CacheElement<QueryResult<?>>>();
			contextLevelCache.put(key, contextCache);
		}
		return contextCache;
	}

	
	/**
	 * convert query to its string key representation
	 * @param query
	 * @return
	 */
	protected <T> String queryToKey(SingleQueryDefinition<T> query){
		return query.getQueryLanguageId() + ":" + query.getQuery();
	}
	
	protected <T> CacheElement<T> createCacheElement(){
		return new CacheElement<T>();
	}
	
}
