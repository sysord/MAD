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
package com.sysord.mad.model.provider.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.model.EditedModel;
import com.sysord.mad.model.provider.ModelProvider;
import com.sysord.mad.model.provider.ModelProviderService;

public class ModelProviderServiceImpl implements ModelProviderService {

	@Inject
	protected ConsoleLogger logger;

	protected Map<String, ModelProvider> providers = new HashMap<String, ModelProvider>();
	
	@Override
	public EditedModel getModel(EObject contextObject, String modelType) {
		ModelProvider provider = retreiveModelProvider(modelType);
		if(provider == null){
			logger.logError("ModelProviderService: no model provider found for model type '" + modelType + "'" );
			//XXX: null or throw exception ???
			return null;			
		}
		return provider.getModel(contextObject);
	}

	@Override
	public void registerModelProvider(String modelType, ModelProvider modelProvider) {
		logger.log("ModelProviderService: register model provider for " + modelType + " model type.");
		providers.put(modelType, modelProvider);
	}
	
	protected ModelProvider retreiveModelProvider(String modelType){
		return providers.get(modelType);
	}

	@Override
	public void unregisterAll() {
		providers.clear();
	}
	
	

}
