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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.util.MadConfigDslUtil;
import com.sysord.mad.evaluator.impl.ocl.OCLQueryEvaluator;
import com.sysord.mad.query.QueryEnvironment;
import com.sysord.mad.query.SingleQueryDefinition;
import com.sysord.mad.query.QueryDefinition.OPTIMISATION_LEVEL;

public class SingleQueryDefinitionImpl<T> extends AbstractQueryDefinition<T> implements SingleQueryDefinition<T> {

	protected String targetModelType;
	protected SingleQueryDefinitionImpl<EObject> targetModelRelocatorQuery;
	
	protected String languageId;
	protected String contextLocator;

	/**
	 * Query defined in configuration
	 */
	protected String query;	
	private Map<String, Object> properties;
	
	/**
	 * Referenced external query
	 */
	protected EObject externalQueryCall;
	
	protected QueryEnvironment environment;
	
	public SingleQueryDefinitionImpl(QueryDefinitionMdsl query, Class<T> returnType, RETURN_VALUE_OCCURENCE returnValueOccurence, QueryEnvironment queryEnvironment) {
		super(returnType, returnValueOccurence);
		this.environment = queryEnvironment;
		init(query);
	}

	
	public SingleQueryDefinitionImpl(String targetModelType, String languageId, String query, 
									Class<T> returnType, RETURN_VALUE_OCCURENCE returnValueOccurence,
									OPTIMISATION_LEVEL optimisationLevel,
									QueryEnvironment queryEnvironment) {
		super(returnType, returnValueOccurence, optimisationLevel);
		this.targetModelType = targetModelType;
		this.languageId = languageId;
		this.query = query;
		this.environment = queryEnvironment;
	}



	protected void init(QueryDefinitionMdsl queryDefinitionMdsl){
		if(queryDefinitionMdsl.getForeignModel() != null){
			ForeignModelMdsl foreignModel = queryDefinitionMdsl.getForeignModel();
			targetModelType = foreignModel.getName();
			//if QueryLocator is defined create configuration
			if(foreignModel.getRelocatorQuery() != null){
				targetModelRelocatorQuery = (SingleQueryDefinitionImpl<EObject>) QueryFactory.createSingleQueryDefinition(
													MadConfigDslUtil.resolveQuery(foreignModel.getRelocatorQuery()), 
													EObject.class, RETURN_VALUE_OCCURENCE.SINGLE_VALUE);
			}
		}		
		languageId = (queryDefinitionMdsl.getEvaluator() != null ? queryDefinitionMdsl.getEvaluator().getName() : OCLQueryEvaluator.OCL_LANGUAGE_ID) ;
		query = MadConfigDslUtil.getQueryBodyString(queryDefinitionMdsl.getQuery());
		contextLocator = queryDefinitionMdsl.getContextLocator();
		
		//define optimisation level:
		switch(queryDefinitionMdsl.getOptimisationLevel()){			
		case VIEW:
			optimisationLevel = OPTIMISATION_LEVEL.VIEW;
			break;
		case NONE:
			optimisationLevel = OPTIMISATION_LEVEL.NONE;
			break;
		default:
			optimisationLevel = OPTIMISATION_LEVEL.CONTEXT;
		}
		
		//properties
		this.properties = MadConfigDslUtil.loadProperties(queryDefinitionMdsl.getProperties());
		//external Query call
		if(queryDefinitionMdsl.getExternalQueryCall() != null){
			this.externalQueryCall = queryDefinitionMdsl.getExternalQueryCall().getExternalQuery();			
		}
	}

	
	@Override
	public String getTargetModelType() {
		return targetModelType;
	}

	@Override
	public SingleQueryDefinition<EObject> getTargetModelRelocatorQuery() { 
		return targetModelRelocatorQuery;
	}

	@Override
	public String getQueryLanguageId() {
		return languageId;
	}

	@Override 
	public String getContextLocator() {
		return contextLocator;
	}

	@Override
	public String getQuery() {
		return query; 
	}
	
	@Override
	public Map<String, Object> getProperties() {
		return properties;
	}


	@Override
	public boolean isExternalQuery() {
		return externalQueryCall != null;
	}


	@Override
	public EObject getExternalQuery() {
		return externalQueryCall;
	}


	@Override
	public String toString() {
		return "SingleQueryDefinitionImpl [targetModelType=" + targetModelType + ", targetModelRelocatorQuery=" + targetModelRelocatorQuery + ", languageId="
				+ languageId + ", contextLocator=" + contextLocator + ", query=" + query + ", properties=" + properties + ", externalQueryCall="
				+ externalQueryCall + "]";
	}


	@Override
	public QueryEnvironment getEnvironment() {
		return environment;
	}

	

}
