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

import com.sysord.mad.configuration.XtextLanguageDescription;
import com.sysord.mad.model.EditedModel;

public interface ModelProvider {

	/**
	 * Defines if model must be automatically reloaded when chanes occurs outside of MAD
	 * @param enabled
	 */
	public void setAutoReload(boolean enabled);

	/**
	 * load and return the for the context
	 *  
	 * @param contextObject
	 * @return
	 */
	public EditedModel getModel(EObject contextObject);
	
	/**
	 * define the synchronizer factory for the provided model.
	 * synchronizerFactory can be null
	 * @param synchronizerFactory
	 */
	public void setModelSynchronizerFactory(ModelSynchronizerFactory synchronizerFactory);
	
	/**
	 * define the model ad-hoc extension manager for the provided model.
	 * modelExtensionManager can be null
	 * 
	 * @param modelExtensionManager
	 */
	public void setExtensionManager(ModelExtensionManager modelExtensionManager);
	
	/**
	 * define the dsl language for the provided model.
	 * if the langauge is not based on a Dsl language (like Xtext) then dslDescription can be null
	 * 
	 * @param dslDescription
	 */
	public void setDslDescription(XtextLanguageDescription dslDescription);
	
	
	
	
}
