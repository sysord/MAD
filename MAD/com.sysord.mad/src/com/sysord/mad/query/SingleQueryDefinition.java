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
package com.sysord.mad.query;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public interface SingleQueryDefinition<T> extends QueryDefinition<T>{

	

	/**
	 * return the Query for relocation in a foreign model
	 * @return
	 */
	public SingleQueryDefinition<EObject> getTargetModelRelocatorQuery();

	/**
	 * Query string with parametrized part for
	 * obtains a new context from the current context
	 * @return
	 */
	public String getContextLocator();

	/**
	 * return the id for the query Language
	 * @return the id for the query Language
	 */
	public String getQueryLanguageId();
		
	/**
	 * returns the query string
	 * @return the query string
	 */
	public String getQuery();

	/**
	 * Properties can be defined in the query configuration
	 * this method returns the properties set defined for the query 
	 * @return
	 */
	public Map<String,Object> getProperties();
	
	/**
	 * Returns true if the query is an external query
	 * the external query must be an EMF model element
	 * representing a query in an external language
	 * @return
	 */
	public boolean isExternalQuery();
	
	/**
	 * Returns the external query.
	 * External query must be an EMF model element
	 * representing a query in an external language
	 * 
	 * @return
	 */
	public EObject getExternalQuery();
	
	
	public QueryEnvironment getEnvironment();
	
}
