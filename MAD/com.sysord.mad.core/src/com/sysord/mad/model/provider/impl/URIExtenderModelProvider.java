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

import com.sysord.emf.tools.EmfToolsFacade;
import com.sysord.emf.tools.resource.ResourcesManager;
import com.sysord.mad.core.Activator;
import com.sysord.mad.model.EditedModel;
import com.sysord.mad.model.provider.ModelExtensionManager;
import com.sysord.mad.model.provider.ModelProvider;
import com.sysord.mad.model.provider.ModelSynchronizer;

/**
 * Load model using URI created by suffixing context model uri
 * with modelUriExtension
 *
 */
public class URIExtenderModelProvider extends AbstractModelProvider {

	/**
	 * URI suffix
	 */
	protected String modelUriExtension;
	
	
	public URIExtenderModelProvider() {
		super();
	}
	
	public URIExtenderModelProvider(String modelUriExtension) {
		super();
		this.modelUriExtension = modelUriExtension;
	}

	
	public String getModelUriExtension() {
		return modelUriExtension;
	}

	public void setModelUriExtension(String modelUriExtension) {
		this.modelUriExtension = modelUriExtension;
	}

	
	@Override
	public EditedModel getModel(EObject contextObject) {		
		//extends context resource uri
		String strResourceUri = contextObject.eResource().getURI().toString() + "__" + modelUriExtension;
		return loadModel(contextObject, strResourceUri);
	}
	

	
	
}
