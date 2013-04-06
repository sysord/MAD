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

import com.sysord.mad.query.QueryDefinition;

public abstract class AbstractQueryDefinition<T> implements QueryDefinition<T> {

	protected Class<T> returnType;
	protected RETURN_VALUE_OCCURENCE returnValueOccurence = RETURN_VALUE_OCCURENCE.SINGLE_VALUE;

	protected OPTIMISATION_LEVEL optimisationLevel;
		
	public AbstractQueryDefinition(Class<T> returnType, RETURN_VALUE_OCCURENCE returnValueOccurence) {
		this(returnType, returnValueOccurence, null);
	}
	
	
	public AbstractQueryDefinition(Class<T> returnType, RETURN_VALUE_OCCURENCE returnValueOccurence, OPTIMISATION_LEVEL optimisationLevel) {
		super();		
		if(returnType == null){
			returnType = (Class<T>) Object.class;
		}
		this.returnType = returnType;
		this.returnValueOccurence = returnValueOccurence;
		if(optimisationLevel == null)optimisationLevel = OPTIMISATION_LEVEL.CONTEXT;
		this.optimisationLevel = optimisationLevel;
	}


	@Override
	public Class<T> getReturnType(){
		return returnType;
	}
	
	@Override
	public Boolean isSingleValueReturned(){
		return returnValueOccurence == RETURN_VALUE_OCCURENCE.SINGLE_VALUE;
	}

	@Override 
	public Boolean isValuesListReturned(){
		return returnValueOccurence == RETURN_VALUE_OCCURENCE.VALUES_LIST;
	}

	@Override
	public boolean useOptimisation() {
		return optimisationLevel != null && optimisationLevel != OPTIMISATION_LEVEL.NONE;
	}

	@Override
	public OPTIMISATION_LEVEL getOptimisationLevel() {
		return optimisationLevel;
	}
	
	
}
