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
import com.sysord.mad.model.EditedModel;
import com.sysord.mad.model.provider.ModelExtensionManager;
import com.sysord.mad.model.provider.ModelSynchronizer;

public class EditedModelImpl implements EditedModel {

	protected Resource modelResource;
	protected boolean dirty;
	protected boolean saving;
	protected Resource masterModelResource;
	protected ModelSynchronizer synchronizer;
	protected ModelExtensionManager extensionManager;
	protected XtextLanguageDescription dslDescription;
	protected URI masterModelURI;
	protected boolean linkedToMasterModel;
	protected boolean isAutoReloadAllowed; //if true: when changes occurs outside of MAD, the model is silently reloaded.
	
	public EditedModelImpl(Resource modelResource, Resource masterModelResource, ModelSynchronizer synchronizer, ModelExtensionManager extensionManager,
			XtextLanguageDescription dslDescription) {
		super();
		this.modelResource = modelResource;
		this.masterModelResource = masterModelResource;
		this.synchronizer = synchronizer;
		this.extensionManager = extensionManager;
		this.dslDescription = dslDescription;
	}

	@Override
	public boolean isAutoReloadAllowed() {
		return isAutoReloadAllowed;
	}

	@Override
	public void setAutoReloadAllowed(boolean allow) {
		isAutoReloadAllowed = allow;
	}
	@Override
	public boolean isDirty() {
		return dirty;
	}
	@Override
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}


	@Override
	public boolean isSaving() {
		return saving;
	}
	@Override
	public void setSaving(boolean saving) {
		this.saving = saving;
	}

	
	@Override
	public EObject getModel() {
		if(modelResource == null || modelResource.getContents().isEmpty()){
			//logger.logError("ModelProvider: Resource '" + modelResource.getURI().toString() + "' of a provided model is now is empty.");
			return null;
		}else{
			return modelResource.getContents().get(0);
		}
	}

	@Override
	public Resource getModelResource() {
		return modelResource;
	}
	
	@Override
	public void setModelResource(Resource modelResource) {
		this.modelResource = modelResource;
	}
	
	
	@Override
	public ModelSynchronizer getSynchronizer() {
		return synchronizer;
	}
	
	@Override
	public void setSynchronizer(ModelSynchronizer synchronizer) {
		this.synchronizer = synchronizer;
	}
	
	@Override
	public boolean startSynchronizer(){
		if(synchronizer == null){
			return false;
		}
		synchronizer.start();
		return true;
	}

	@Override
	public boolean stopSynchronizer(){ 
		if(synchronizer == null){
			return false;
		}
		synchronizer.stop();
		return true;		
	}
	

	@Override
	public ModelExtensionManager getExtensionManager() {
		return extensionManager;
	}
	
	@Override
	public void setExtensionManager(ModelExtensionManager extensionManager) {
		this.extensionManager = extensionManager;
	}
	
	@Override
	public XtextLanguageDescription getDslDescription() {
		return dslDescription;
	}
	
	@Override
	public void setDslDescription(XtextLanguageDescription dslDescription) {
		this.dslDescription = dslDescription;
	}

	@Override
	public URI getMasterModelURI() {
		return masterModelResource.getURI();
	}

	
	@Override
	public boolean isLinkedToMasterModel() {
		return linkedToMasterModel;
	}
 
	@Override
	public void setLinkedToMasterModel(boolean linkedToMasterModel){
		this.linkedToMasterModel = linkedToMasterModel;
	}








}
