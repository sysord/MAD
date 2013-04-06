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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.emf.tools.EmfToolsFacade;
import com.sysord.emf.tools.resource.ResourcesManager;
import com.sysord.mad.configuration.XtextLanguageDescription;
import com.sysord.mad.core.preferences.PreferenceHelper;
import com.sysord.mad.model.EditedModel;
import com.sysord.mad.model.EditedModelImpl;
import com.sysord.mad.model.cache.ModelCache;
import com.sysord.mad.model.provider.ExtensionModelSynchronizer;
import com.sysord.mad.model.provider.ModelExtensionManager;
import com.sysord.mad.model.provider.ModelProvider;
import com.sysord.mad.model.provider.ModelSynchronizer;
import com.sysord.mad.model.provider.ModelSynchronizerFactory;
import com.sysord.xtext.tools.XtextUtility;

public abstract class AbstractModelProvider implements ModelProvider {

	@Inject
	protected ConsoleLogger logger;

	@Inject
	protected ModelCache modelCache;
	
	//Model provider configuration
	protected ModelSynchronizerFactory modelSynchronizerFactory;
	protected ModelExtensionManager extensionManager;
	protected XtextLanguageDescription dslDescription;
		
	public AbstractModelProvider() {
		super();		
	}
	
	public AbstractModelProvider(ModelSynchronizerFactory modelSynchronizerFactory, ModelExtensionManager extensionManager, XtextLanguageDescription dslDescription) {
		super();
		this.modelSynchronizerFactory = modelSynchronizerFactory;
		this.extensionManager = extensionManager;
		this.dslDescription = dslDescription;
	}

	@Override
	public void setModelSynchronizerFactory(ModelSynchronizerFactory modelSynchronizerFactory) {
		this.modelSynchronizerFactory = modelSynchronizerFactory;
	}

	@Override
	public void setExtensionManager(ModelExtensionManager extensionProvider) {
		this.extensionManager = extensionProvider;
	}

	@Override
	public void setDslDescription(XtextLanguageDescription dslDescription){
		this.dslDescription = dslDescription;
	}
	
	

	protected EditedModel loadModel(EObject contextObject, String strResourceUri) {	
		URI modelResourceUri = URI.createURI(strResourceUri);
		//Try to retrieve from cache
		EditedModel model = modelCache.getModel(modelResourceUri);		
		//Model since provided
		if(model != null){
			return model;
		}else{
			//try to load the model
			return _loadModel(contextObject, strResourceUri);			
		}
							
	}
	
		
	protected EditedModel _loadModel(EObject contextObject, String strResourceUri){
		int storeOptions;

		Resource modelResource = null;
		Resource masterModelResource = contextObject.eResource();
		
		//load model resource
		if(dslDescription != null){
			//xtext model: use Xtext specific resourceset
			modelResource = loadXtextModelResource(contextObject, strResourceUri);
			//xtext model used in memory (avoid model reload with different version)
			storeOptions = ModelCache.DISABLE_AUTO_RELOAD;
		}else{
			//standard Emf resource
			modelResource = loadModelResource(contextObject, strResourceUri);
			//storeOptions = ModelCache.NONE_OPTION;
			storeOptions = ModelCache.DISABLE_AUTO_RELOAD;
		}
		
		if(modelResource == null){
			logger.logError("ModelProvider: Model '" + strResourceUri + "' not found.");
			return null;
		}else if(modelResource.getContents().isEmpty()){
			logger.logError("ModelProvider: Model '" + strResourceUri + "' is empty.");
			return null;
		}else{
			//Synchronizer for the model
			ModelSynchronizer modelSynchronizer = createSynchronizer(masterModelResource, modelResource);
			modelSynchronizer.setAutoSave(PreferenceHelper.getAutoSave());

			//create the modelwrapper
			EditedModel providedModel = new EditedModelImpl(modelResource, masterModelResource, modelSynchronizer, extensionManager, dslDescription);
			//declare link between mastermodel resource and the model
			//providedModel.setLinkedToMasterModel(Activator.USE_RESOURCES_LINK);
			providedModel.setLinkedToMasterModel(true);
			
			//store model in model cache
			modelCache.storeModel(providedModel, storeOptions);
						
			
			return providedModel;
		}

	}
	
	
	
	/**
	 * Load resource from URI using resources manager
	 * @param contextObject
	 * @param strResourceUri
	 * @return
	 */
	protected Resource loadModelResource(EObject contextObject, String strResourceUri){
		//load model by uri				
		Resource resource = getResourcesManager().getResource(strResourceUri, true);
		return resource;
	}
	
	/**
	 * Load xtext resource from uri. 
	 * create an Xtext resourceSet and add the mastermodel to it
	 * @param contextObject
	 * @param strResourceUri
	 * @return
	 */
	protected Resource loadXtextModelResource(EObject contextObject, String strResourceUri){
		
		if(getResourcesManager().isManagedResource(strResourceUri)){
			return getResourcesManager().getResource(strResourceUri);
		}
		
		Injector languageInjector = XtextUtility.getLanguageInjector(dslDescription.getBundleId(), dslDescription.getActivatorClassName(), dslDescription.getLanguageName());
		XtextResource  xtextResource = null;
		if(languageInjector != null){			
			//create a resourceset
			XtextResourceSet xtextResourceSet = languageInjector.getInstance(XtextResourceSet.class);
			
			//add masterModel resource
			Map<URI, Resource> uriResourceMap = new HashMap<URI, Resource>();
			uriResourceMap.put(contextObject.eResource().getURI(), contextObject.eResource());
			xtextResourceSet.setURIResourceMap(uriResourceMap);
			
			try {
				//load xtext resource
				xtextResource = (XtextResource) xtextResourceSet.getResource(URI.createURI(strResourceUri), true);
			} catch (Exception e) {
				//TODO: add to logger
				//e.printStackTrace();
			}
			
		}
		return xtextResource;
	}
	

	protected ModelSynchronizer createSynchronizer(Resource masterResource, Resource slaveResource){
		ModelSynchronizer modelSynchronizer = null;
		if(modelSynchronizerFactory != null){
			modelSynchronizer = modelSynchronizerFactory.createModelSynchronizer();
			if(ExtensionModelSynchronizer.class.isAssignableFrom(modelSynchronizer.getClass())){
				((ExtensionModelSynchronizer)modelSynchronizer).setExtensionManager(extensionManager);
			}
			modelSynchronizer.configure(masterResource, slaveResource);
		}
		return modelSynchronizer;
	}
	
	


	private ResourcesManager resourcesManager;
	
	protected ResourcesManager getResourcesManager(){
		if(resourcesManager == null){
			resourcesManager = EmfToolsFacade.getInstance().getResourcesManager();
		}
		return resourcesManager;
	}
	

}
