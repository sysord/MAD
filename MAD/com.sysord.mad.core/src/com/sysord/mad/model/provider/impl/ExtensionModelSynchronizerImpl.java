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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.sysord.emf.tools.model.AbstractModelObserver;
import com.sysord.mad.core.Activator;
import com.sysord.mad.mao.ModelAccessObject;
import com.sysord.mad.model.EditedModel;
import com.sysord.mad.model.cache.ModelCache;
import com.sysord.mad.model.provider.ExtensionModelSynchronizer;
import com.sysord.mad.model.provider.ModelExtensionManager;

public class ExtensionModelSynchronizerImpl extends AbstractModelObserver implements ExtensionModelSynchronizer{

	/**
	 * model extension manager for synchronize ExtensionModel (create or remove extension)
	 */
	protected ModelExtensionManager extensionManager;
	
	protected Resource masterResource;
	protected Resource slaveResource;
	protected boolean  isAutoSaveEnabled;
	
	protected ModelCache modelCache;

	protected ModelCache getModelCache(){
		if(modelCache == null){
			modelCache  = Activator.getDefault().getInjector().getInstance(ModelCache.class);
		}
		return modelCache;
	}
	
	public void configure(Resource masterResource, Resource slaveResource){
		//remove observer on previous master resource
		stop();
		this.masterResource = masterResource;
		this.slaveResource = slaveResource;
	}
	
	@Override
	public void setAutoSave(boolean autosave) {
		isAutoSaveEnabled = autosave;
	}
	
	protected void _doAutosave(){
		EditedModel slaveModel = getModelCache().getModel(slaveResource.getURI());
		if(slaveModel.isDirty()){
			getModelCache().flush();			
		}
	}
	
	@Override
	public boolean initializeModel(Resource masterResource, Resource slaveResource) {
		return false;
	}
	
	@Override
	public void setExtensionManager(ModelExtensionManager extensionManager) {
		this.extensionManager = extensionManager;
	}

	
	
//	@Override
//	public void setSlaveResource(Resource slaveResource) {
//		this.slaveResource = slaveResource;
//	}
//
//	@Override
//	public void setMasterResource(Resource masterResource) {
//		//remove observer on previous master resource
//		stop();
//		this.masterResource = masterResource;
//		start();
//	}

	
	protected EObject getExtensionModel(){
		if(!slaveResource.getContents().isEmpty()){
			return  slaveResource.getContents().get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public void elementAdded(EObject element) {
		if(extensionManager.elementSupportExtension(getExtensionModel(), element)){
			//add element in extension model: request extension fro then element with create if not exists flag set to true
			extensionManager.getElementExtension(getExtensionModel(), element, null, true);
			if(isAutoSaveEnabled){
				_doAutosave();
			}
		}
	}

	@Override
	public void elementChanged(EObject element, EStructuralFeature feature, Object oldValue, Object newValue) {
		//TODO rename extension or else ...
		System.out.println("elementChanged:" + element + " " + feature + " " + oldValue + " " + newValue);
		if(extensionManager.elementSupportExtension(getExtensionModel(), element)){
			extensionManager.onExtendedElementChange(getExtensionModel(), element, feature, oldValue, newValue); 
			if(isAutoSaveEnabled){
				_doAutosave();
			}			
		}
	}

	@Override
	public void elementRemoved(EObject element, EObject oldContainer) {
		if(extensionManager.elementSupportExtension(getExtensionModel(), element)){
			extensionManager.removeExtension(getExtensionModel(), element, oldContainer, null);
			if(isAutoSaveEnabled) _doAutosave();
		}
	}


	@Override
	public void start() {
		if(this.slaveResource != null && this.masterResource != null  && !this.masterResource.eAdapters().contains(this)){
			masterResource.eAdapters().add(this);
		}		
	}

	/**
	 * stop synchronization: remove observer on master resource
	 */
	@Override
	public void stop() {
		if(isStarted()){
			masterResource.eAdapters().remove(this);
		}
	}

	
	protected boolean isStarted(){
		return this.masterResource != null  && this.masterResource.eAdapters().contains(this);
	}
	
	@Override
	protected void finalize() throws Throwable {
		stop();
		super.finalize();
	}






}
