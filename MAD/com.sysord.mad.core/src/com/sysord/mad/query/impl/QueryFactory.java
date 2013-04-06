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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.configuration.madConfigDsl.MADConfiguration;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.util.MadConfigDslUtil;
import com.sysord.mad.core.Activator;
import com.sysord.mad.query.QueryChainDefinition;
import com.sysord.mad.query.QueryDefinition;
import com.sysord.mad.query.QueryDefinition.OPTIMISATION_LEVEL;
import com.sysord.mad.query.QueryDefinition.RETURN_VALUE_OCCURENCE;
import com.sysord.mad.query.QueryEnvironment;
import com.sysord.mad.query.SingleQueryDefinition;

public class QueryFactory {

	/**
	 * Mad configuration Manger
	 */
	protected static ConfigurationManager configurationManager;

	protected static QueryEnvironment defaultQueryEnvironment;
	
	protected static ConfigurationManager getConfigurationManager(){
		if(configurationManager == null){
			configurationManager = Activator.getDefault().getInjector().getInstance(ConfigurationManager.class);
		}
		return configurationManager ;
	}
	
	public static void flushCache(){
		defaultQueryEnvironment = null;
	}
	
	/**
	 * Create a QueryDefinition from a single QueryDefinitionMdsl
	 * created query definition is a SingleQueryDefinition.
	 * 
	 * @param queriesDefinitionsMdsl
	 * @param expectedReturnType
	 * @param expectedOccurence
	 * @return
	 */
	public static <T> QueryDefinition<T> createQueryDefinition(QueryDefinitionMdsl queriesDefinitionsMdsl, Class<T> expectedReturnType, RETURN_VALUE_OCCURENCE expectedOccurence){				
		return QueryFactory.createSingleQueryDefinition(queriesDefinitionsMdsl, expectedReturnType, expectedOccurence);
	}

	/**
	 * Create a QueryChainDefinition from a list of QueryDefinitionMdsl.
	 * created query is a QueryChainDefinition
	 * 
	 * @param queriesDefinitionsMdsl
	 * @param expectedReturnType
	 * @param expectedOccurence
	 * @return
	 */
	public static <T> QueryDefinition<T> createQueryDefinition(List<QueryDefinitionMdsl> queriesDefinitionsMdsl, 
			Class<?> expectedReturnType, RETURN_VALUE_OCCURENCE expectedOccurence){
		return QueryFactory.createQueryDefinition(queriesDefinitionsMdsl, expectedReturnType, expectedOccurence, null);
	}

	/**
	 * Create a QueryChainDefinition from a list of QueryDefinitionMdsl.
	 * created query is a QueryChainDefinition, if preQueries is provided
	 * preQueries are inserted at the begin of chain.
	 * 
	 * @param queriesDefinitionsMdsl
	 * @param expectedReturnType
	 * @param expectedOccurence
	 * @param preQueries
	 * @return
	 */
	public static <T> QueryDefinition<T> createQueryDefinition(List<QueryDefinitionMdsl> queriesDefinitionsMdsl, 
														Class<?> expectedReturnType, RETURN_VALUE_OCCURENCE expectedOccurence, 
														List<QueryDefinitionMdsl> preQueries){
		
		List<SingleQueryDefinition<?>> queriesDefinitions = new ArrayList<SingleQueryDefinition<?>>();
		RETURN_VALUE_OCCURENCE returnOccurence = null;
		Class<T> returnType = null;
		
		//merges queriesDefinition and preQueries if present.
		List<QueryDefinitionMdsl> mergedQueriesDefinitionsMdsl = new ArrayList<QueryDefinitionMdsl>();
		if(preQueries != null){
			mergedQueriesDefinitionsMdsl.addAll(preQueries);
		}
		mergedQueriesDefinitionsMdsl.addAll(queriesDefinitionsMdsl);
		
		for(Iterator<QueryDefinitionMdsl> itQueryDefMdsl = mergedQueriesDefinitionsMdsl.iterator(); itQueryDefMdsl.hasNext();){
			QueryDefinitionMdsl queryDefMdsl = itQueryDefMdsl.next();
			if(!itQueryDefMdsl.hasNext()){
				//last query must be configured like the chain
				returnOccurence = expectedOccurence;
				returnType = (Class<T>) expectedReturnType;
			}
			SingleQueryDefinition<?> singleQueryDefinition = QueryFactory.createSingleQueryDefinition(queryDefMdsl, returnType , returnOccurence);
			queriesDefinitions.add(singleQueryDefinition);
		}
	
		if(expectedReturnType == null) expectedReturnType = Object.class;
		if(expectedOccurence == null) expectedOccurence = RETURN_VALUE_OCCURENCE.UNKNOW;
		
		returnType = (Class<T>) expectedReturnType;
		returnOccurence = expectedOccurence;
		//TODO: discover return type and occurence
		//...
		QueryChainDefinition<T> queryChainDefinition = new QueryChainDefinitionImpl<T>(queriesDefinitions, returnType, returnOccurence);
		
		return queryChainDefinition;
	}

	/**
	 * Create a SingleQueryDefinition from a single QueryDefinitionMdsl
	 * 
	 * @param queryDefMdsl
	 * @param expectedReturnType
	 * @param expectedOccurence
	 * @return
	 */
	public static  <T>  SingleQueryDefinition<T> createSingleQueryDefinition(QueryDefinitionMdsl queryDefMdsl, Class<T> expectedReturnType, RETURN_VALUE_OCCURENCE expectedOccurence){
		if(expectedReturnType == null) expectedReturnType = (Class<T>) Object.class;
		if(expectedOccurence == null) expectedOccurence = RETURN_VALUE_OCCURENCE.UNKNOW;
		Class<T> returnType = (Class<T>) expectedReturnType;
		RETURN_VALUE_OCCURENCE returnOccurence = expectedOccurence;
		//TODO: discover return type and occurence
		//...
		QueryEnvironment environment = createQueryEnvironment(queryDefMdsl);
		SingleQueryDefinition<T> queryDefinition = new SingleQueryDefinitionImpl<T>(queryDefMdsl, returnType, returnOccurence, environment);			
		return queryDefinition;
	}

	
	/**
	 * Create a SingleQueryDefinition 
	 * 
 	 * @param targetModelType
	 * @param languageId
	 * @param query
	 * @param returnType
	 * @param returnValueOccurence
	 * @return
	 */
	public static <T> SingleQueryDefinition<T> createSingleQueryDefinition(String targetModelType, String languageId, String query, 
										Class<T> returnType, RETURN_VALUE_OCCURENCE returnValueOccurence) {
		return createSingleQueryDefinition(targetModelType, languageId, query, returnType, returnValueOccurence, null, createDefaultQueryEnvironment());
	}
	
	public static <T> SingleQueryDefinition<T> createSingleQueryDefinition(String targetModelType, String languageId, String query, 
							Class<T> returnType, RETURN_VALUE_OCCURENCE returnValueOccurence, OPTIMISATION_LEVEL optimisationLevel) {
		return createSingleQueryDefinition(targetModelType, languageId, query, returnType, returnValueOccurence, optimisationLevel, createDefaultQueryEnvironment());
	}

	
	/**
	 * Create a SingleQueryDefinition 
	 * 
	 * @param targetModelType
	 * @param languageId
	 * @param query
	 * @param returnType
	 * @param returnValueOccurence
	 * @param queryEnvironment
	 * @return
	 */
	public static <T> SingleQueryDefinition<T> createSingleQueryDefinition(String targetModelType, String languageId, String query, 
																Class<T> returnType, RETURN_VALUE_OCCURENCE returnValueOccurence,
																OPTIMISATION_LEVEL optimisationLevel,
																QueryEnvironment queryEnvironment) {
		return new SingleQueryDefinitionImpl<T>(targetModelType, languageId, query, returnType, returnValueOccurence, optimisationLevel, queryEnvironment);
	}

	
	/**
	 * Collects information about query definition environment (imported models, nsUris etc.)
	 * and create a QueryEnvironment for the query
	 * @param queryDefMdsl
	 * @return
	 */
	protected static QueryEnvironment createQueryEnvironment(QueryDefinitionMdsl queryDefMdsl){
		MADConfiguration madConfig = MadConfigDslUtil.getMadConfigurationFromElement(queryDefMdsl);
		if(madConfig != null){
			Collection<URI> resourcesURI = getConfigurationManager().getImportedURIs(madConfig);
			Collection<String> resourcesNsUris = getConfigurationManager().getImportedResourcesNsURIs(madConfig);
			return new QueryEnvironmentImpl(resourcesURI, resourcesNsUris);
		}else{
			return null;
		}
	}

	/**
	 * Collects information about environment (imported models, nsUris etc.)
	 * and create a QueryEnvironment
	 * @param queryDefMdsl
	 * @return
	 */	
	protected static QueryEnvironment createDefaultQueryEnvironment(){
		if(defaultQueryEnvironment == null){
			Collection<URI> resourcesURI = getConfigurationManager().getImportedURIs();
			Collection<String> resourcesNsUris = getConfigurationManager().getImportedResourcesNsURIs();
			defaultQueryEnvironment = new QueryEnvironmentImpl(resourcesURI, resourcesNsUris);			
		}
		return defaultQueryEnvironment;
	}

}
