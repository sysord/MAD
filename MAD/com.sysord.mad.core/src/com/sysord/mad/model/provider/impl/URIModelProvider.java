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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.sysord.emf.tools.EmfToolsFacade;
import com.sysord.emf.tools.resource.ResourcesManager;
import com.sysord.mad.core.Activator;
import com.sysord.mad.model.EditedModel;
import com.sysord.mad.model.provider.ModelExtensionManager;
import com.sysord.mad.model.provider.ModelProvider;
import com.sysord.mad.model.provider.ModelSynchronizer;

/**
 * Load model using URI 
 *
 */
public class URIModelProvider extends AbstractModelProvider {

	/**
	 * Model URI 
	 */
	protected String modelUri;
	
	
	public URIModelProvider() {
		super();
	}

	public URIModelProvider(String modelUri) {
		super();
		this.modelUri = modelUri;
	}
		
	
	public String getModelUri() {
		return modelUri;
	}

	public void setModelUri(String modelUri) {
		this.modelUri = modelUri;
	}


	@Override
	public EditedModel getModel(EObject contextObject) {
		//load model by uri
		return loadModel(contextObject, modelUri);
	}
	


}
