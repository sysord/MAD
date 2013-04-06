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
package com.sysord.mad.model.provider;

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.model.EditedModel;

/**
 * Service for get and return models
 * by modelType and context
 */
public interface ModelProviderService {

	/**
	 * load and return the modeltype for the context
	 *  
	 * @param contextObject
	 * @param modelType
	 * @return
	 */
	public EditedModel getModel(EObject contextObject, String modelType);
	
	/**
	 * register a model provider for a modelType
	 * 
	 * @param modelType
	 * @param modelProvider
	 */
	public void registerModelProvider(String modelType, ModelProvider modelProvider);
	

	/**
	 * remove all model providers
	 */
	public void unregisterAll();

}
