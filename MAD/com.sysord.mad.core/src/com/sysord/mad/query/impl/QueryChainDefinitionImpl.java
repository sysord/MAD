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
import java.util.List;

import com.sysord.mad.query.QueryChainDefinition;
import com.sysord.mad.query.SingleQueryDefinition;

public class QueryChainDefinitionImpl<T> extends AbstractQueryDefinition<T> implements QueryChainDefinition<T> {

	protected List<SingleQueryDefinition<?>> queriesDefinitions = new ArrayList<SingleQueryDefinition<?>>();
	
	public QueryChainDefinitionImpl(List<SingleQueryDefinition<?>> queriesDefinitions, Class<T> returnType, RETURN_VALUE_OCCURENCE returnValueOccurence) {
		super(returnType, returnValueOccurence);
		this.queriesDefinitions = queriesDefinitions;
	}

	public QueryChainDefinitionImpl(List<SingleQueryDefinition<?>> queriesDefinitions, Class<T> returnType, RETURN_VALUE_OCCURENCE returnValueOccurence, 
									OPTIMISATION_LEVEL optimisationLevel) {
		super(returnType, returnValueOccurence, optimisationLevel);
		this.queriesDefinitions = queriesDefinitions;
	}
	
		

	@Override
	public List<SingleQueryDefinition<?>> getQueriesDefinitions() {
		return queriesDefinitions;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getTargetModelType() {
		SingleQueryDefinition<T> lastQuery = (SingleQueryDefinition<T>) queriesDefinitions.get(queriesDefinitions.size() - 1);
		return lastQuery.getTargetModelType();
	}


}
