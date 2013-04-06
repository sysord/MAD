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
package com.sysord.mad.configuration.extension;

import java.util.HashMap;
import java.util.Map;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.MADConfiguration;
import com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl;
import com.sysord.mad.configuration.util.MadConfigDslUtil;

public class ExternalQueryConfigurationServiceProvider {

	protected Map<String, ExternalQueryConfigurationService> extQServices = 
							new HashMap<String, ExternalQueryConfigurationService>();
	
	public void unregisterAllExtQServices() {
		extQServices.clear();
	}

	
	/**
	 * Register all no registered ExternalQueryConfigurationService
	 * @param madConfig
	 */
	public void registerExtQService(MADConfiguration madConfig){
		for(QueryEvaluatorMdsl queryEvaluatorMdsl : MadConfigDslUtil.getQueryEvaluatorDeclarations(madConfig)){
			registerExtQService(queryEvaluatorMdsl);
		}
	}

	/**
	 * Register ExternalQueryConfigurationService for the evaluator
	 * 
	 * @param languageId
	 * @param extQService
	 */
	public void registerExtQService(QueryEvaluatorMdsl queryEvaluatorMdsl){
		//if since registered registered with same class name: do nothing
		ExternalQueryConfigurationService extQService = getExtQService(queryEvaluatorMdsl.getName());
		if(extQService != null){
			return;
		}
		ClassDescriptorMdsl extqServiceDescriptor = queryEvaluatorMdsl.getExtQServiceClassDescriptor();
		if(extqServiceDescriptor != null){
			extQService = loadExtQService(extqServiceDescriptor.getPluginId(), extqServiceDescriptor.getClassName());	
			registerExtQService(queryEvaluatorMdsl.getName(), extQService);			
		}
	}

	/**
	 * Register ExternalQueryConfigurationService for the language
	 * 
	 * @param languageId
	 * @param extQService
	 */
	public void registerExtQService(String languageId, ExternalQueryConfigurationService extQService){
		if(extQService != null){
			extQServices.put(languageId, extQService);			
		}
	}

	/**
	 * try to retrieve the ExtQService for the evaluator.
	 * if none extQService is registered for this evaluator then try to register it.
	 * @param queryEvaluatorMdsl
	 * @return
	 */
	public ExternalQueryConfigurationService getExtQService(QueryEvaluatorMdsl queryEvaluatorMdsl){
		registerExtQService(queryEvaluatorMdsl);
		return getExtQService(queryEvaluatorMdsl.getName());
	}

	public ExternalQueryConfigurationService getExtQService(String languageId){
		return extQServices.get(languageId);
	}
	
	
	
	protected ExternalQueryConfigurationService loadExtQService(String bundleID, String className){
		try {
			Class<ExternalQueryConfigurationService> extQServiceClass = EclipseTools.findClass(bundleID, className);
			ExternalQueryConfigurationService extQService = EclipseTools.getNewInstance(extQServiceClass);
			return extQService;
		} catch (ClassNotFoundException e) {
			System.err.println("registerExtQService:" + e.getMessage());
			return null;
		}
	}


}
