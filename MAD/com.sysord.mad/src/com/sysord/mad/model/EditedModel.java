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
package com.sysord.mad.model;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.sysord.mad.configuration.XtextLanguageDescription;
import com.sysord.mad.model.provider.ModelExtensionManager;
import com.sysord.mad.model.provider.ModelSynchronizer;

/**
 * 
 * Wrapper for an edited model
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public interface EditedModel {
	
	public Resource getModelResource();
	public void setModelResource(Resource modelResource);

	public boolean isDirty();
	public void setDirty(boolean dirty);
	
	public boolean isSaving();
	public void setSaving(boolean saving);
	
	public EObject getModel();
	
	public ModelSynchronizer getSynchronizer();
	public void setSynchronizer(ModelSynchronizer synchronizer);
	public boolean startSynchronizer();
	public boolean stopSynchronizer();

	public ModelExtensionManager getExtensionManager();
	void setExtensionManager(ModelExtensionManager extensionManager);
	
	public XtextLanguageDescription getDslDescription();
	public void setDslDescription(XtextLanguageDescription dslDescription);
	
	public URI getMasterModelURI();

	public boolean isLinkedToMasterModel();
	public void setLinkedToMasterModel(boolean linkedToMasterModel);
	
	
	
}
