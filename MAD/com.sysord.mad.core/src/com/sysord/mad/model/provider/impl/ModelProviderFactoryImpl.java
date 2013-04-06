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

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.mad.core.Activator;
import com.sysord.mad.model.provider.ModelProvider;
import com.sysord.mad.model.provider.ModelProviderFactory;

public class ModelProviderFactoryImpl implements ModelProviderFactory {
	
	@Inject
	Provider<URIExtenderModelProvider> URIExtenderModelProvider_GuiceProvider;
	
	@Inject
	Provider<URIModelProvider> UriModelProvider_GuiceProvider;
	
	
	@Override
	public ModelProvider createUriExtensionModelProvider(String uriExtension, Object... parameters) {
		URIExtenderModelProvider modelProvider = URIExtenderModelProvider_GuiceProvider.get();
		modelProvider.setModelUriExtension(uriExtension);
		return modelProvider;
	}

	@Override
	public ModelProvider createUriModelProvider(String modelUri,  Object... parameters) {
		URIModelProvider modelProvider = UriModelProvider_GuiceProvider.get();
		modelProvider.setModelUri(modelUri);
		return modelProvider;
	} 

	@Override
	public ModelProvider createCustomModelProvider(String pluginId, String modelProviderClassName, Object... parameters) {
		Class<? extends ModelProvider> modelProviderClass = EclipseTools.loadClass(pluginId, modelProviderClassName);
		//TODO: set parameters
		ModelProvider  modelProvider = Activator.getDefault().getInjector().getInstance(modelProviderClass);		
		return modelProvider;
	}

}
