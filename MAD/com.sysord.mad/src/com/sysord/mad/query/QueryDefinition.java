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


public interface QueryDefinition<T> {

	public enum OPTIMISATION_LEVEL{
		/**
		 * Query will be evaluated only one time during the view rendering
		 */
		VIEW,
		/**
		 * Query will be evaluated only one time for a same context
		 */
		CONTEXT,
		/**
		 * Query will be evaluated every time
		 */
		NONE,
	}

	public enum RETURN_VALUE_OCCURENCE{
		NONE_VALUE,
		SINGLE_VALUE,
		VALUES_LIST,
		UNKNOW,
	}

	/**
	 * return the target model type where the query will be done
	 * @return the target model type
	 */
	public String getTargetModelType(); 
	
	public Class<T> getReturnType();

	public Boolean isSingleValueReturned();
	public Boolean isValuesListReturned();
	
	public boolean useOptimisation();
	public OPTIMISATION_LEVEL getOptimisationLevel();

	
}
