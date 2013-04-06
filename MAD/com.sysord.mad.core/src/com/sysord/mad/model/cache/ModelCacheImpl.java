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
package com.sysord.mad.model.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.emf.tools.EmfToolsFacade;
import com.sysord.emf.tools.model.EContentAdapter2;
import com.sysord.emf.tools.resource.ResourcesManager;
import com.sysord.emf.tools.resource.ResourcesManagerListener;
import com.sysord.mad.model.EditedModel;

public class ModelCacheImpl implements ModelCache {

	protected static final boolean TRACE_EVENTS = false;
	
	@Inject
	protected ConsoleLogger logger;

	/**
	 * models storage
	 */
	protected Map<URI, EditedModel> models = new HashMap<URI, EditedModel>();
	
	protected List<ModelCacheListener> listeners = new ArrayList<ModelCacheListener>();

	
	public ModelCacheImpl() {
		super();		
		if(TRACE_EVENTS){
			listeners.add(new TestModelCacheListener());			
		}
	}

	@Override
	public void addListener(ModelCacheListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeListener(ModelCacheListener listener) {
		listeners.remove(listener);		
	}

	@Override
	public boolean containsModel(URI modelResourceUri) {
		return models.containsKey(modelResourceUri);
	}

	@Override
	public void storeModel(EditedModel model) {
		storeModel(model, ModelCache.NONE_OPTION);
	}

	@Override
	public void storeModel(EditedModel model, int options) {		
		//Store in cache
		//--------------
		//evict old model for remove adapters
		evict(model.getModelResource().getURI());
		EditedModel oldModel = models.put(model.getModelResource().getURI(), model);
		//add observer
		_addModelChangeListener(model);

		//Register to ResourcesManager
		//----------------------------		
		//Declare a link between contextObject resource and provided model resource
		String linkedMasterResourceName = null; 
		if(model.isLinkedToMasterModel()){
			linkedMasterResourceName = model.getMasterModelURI().toString();
		}
		//Register to ResourcesManager + link + change listener
		getResourcesManager().manageResource(model.getModelResource(), resourcesManagerListener, linkedMasterResourceName, options);
		
		//start synchronizer
		//-------------------
		model.startSynchronizer();
		
		//notify listeners
		for(ModelCacheListener listener : listeners){
			listener.onModelAdded(model);
		}
				
	}

	@Override
	public EditedModel getModel(URI modelResourceUri) {
		return models.get(modelResourceUri);
	}

	@Override
	public void evict(URI modelResourceUri) {
		_processEvictModel(models.get(modelResourceUri));
	}

	@Override
	public void clear() {
		for(EditedModel model : models.values()){
			_processEvictModel(model);
		}
		//notify listeners
		for(ModelCacheListener listener : listeners){
			listener.onClear();
		}
	}

	/**
	 * Evicts all models.
	 * If model is diry save is processed before evict.
	 */
	@Override
	public void flush() {
		//save all dirty resources...		
		try {
			for(EditedModel cachedModel : new ArrayList<EditedModel>(models.values())){
				if(cachedModel.isDirty()){
					try{
						//_processEvictModel(cachedModel);
						_saveModel(cachedModel);
					}finally{
					}
				}
			}		
			//Notify listeners
			for(ModelCacheListener listener : listeners){
				listener.onFlush();
				listener.onDirtyStateChanged(false);	
			}
		} catch (Exception e) {
			logger.logError(e);
			throw new RuntimeException(e);
		}							
	}
	
	protected void _saveModel(EditedModel model){
		try {
			System.out.println("Cache Save model:" + model.getModelResource().getURI());
			model.setSaving(true);
			model.getModelResource().save(null);
			model.setDirty(false);
		} catch (IOException e) {
			//TODO: throw exception on fail
			e.printStackTrace();
		}finally{
		}
	}

	protected void _processEvictModel(EditedModel model){
		if(model != null){
			String modelResourceName = model.getModelResource().getURI().toString();
			logger.log("Model Cache evict:" + modelResourceName, ConsoleLogger.VERY_LOW);
			//stop synchronizer
			model.stopSynchronizer();			
			//remove listener resources manager
			getResourcesManager().removeListener(modelResourceName, resourcesManagerListener);
			getResourcesManager().releaseResource(modelResourceName);
			//remove link to master resource
			if(model.isLinkedToMasterModel()){
				getResourcesManager().unlinkResource(model.getMasterModelURI().toString(), modelResourceName);
			}

			//remove model observer
			_removeModelChangeListener(model);
			
			//remove from cache
			models.remove(model.getModelResource().getURI());
			
			//notify listeners
			for(ModelCacheListener listener : listeners){
				listener.onEvictModel(model);
			}

			return;
		}
	}

	
	/**
	 * 	Resource manager listener used to be notified on used resources change
	 * @return
	 */
	protected ResourcesManagerListener resourcesManagerListener = new ResourcesManagerListener() {		
		@Override
		public void onManagedResourceEvent(String resourceName, RESOURCE_EVENT event) {
			EditedModel cachedModel = getModel(URI.createURI(resourceName));
			if(cachedModel == null){
				//not interested by the event
				return;
			}
			logger.log("Model Cache process received event: " + event + " for "+ resourceName, ConsoleLogger.VERY_LOW);	
			if(event == RESOURCE_EVENT.CHANGED){
				//if a cached resource is changed 'out of control' (ie: other application) 
				//and our resource is dirty: notify user for choice if accept override
				if(!cachedModel.isSaving()){
					logger.log("CONFLICT:" + resourceName + " saved outside of our application.", ConsoleLogger.VERY_LOW);
					//notify listeners
					for(ModelCacheListener listener : listeners){
						listener.onModelChangedOutside(cachedModel);
					}
//				}else{
//					_processEvictModel(cachedModel);											
				}else{
					//unset saving flag
					cachedModel.setSaving(false);										
				}
				
			}else if(event == RESOURCE_EVENT.LINKED_RESOURCE_TO_BE_SAVED){
				//tag model as saving on control (ie: saved by our application)
				cachedModel.setSaving(true);
				
			}
		}
	};
	
	
	protected Adapter modelChangeObserver = new EContentAdapter2(){

		@Override
		public void notifyChanged(Notification notification) {
			//look for cached model and tag as dirty
			if(notification.getEventType() <= Notification.MOVE){
				try{
					if(TRACE_EVENTS){
						System.out.println("Cache notification:" + notification.getNotifier().getClass() + " " + notification.getEventType());
					}
					EditedModel cachedModel = null;
					if(EObject.class.isAssignableFrom(notification.getNotifier().getClass())){
					    Resource resource = ((EObject)notification.getNotifier()).eResource();
					    //When notification is a remove or delete resource is null
					    //retrieve resource using the oldvalue element
					    if(resource == null && notification.getOldValue() instanceof EObject){
					    	resource = ((EObject)notification.getOldValue()).eResource();
					    }
					    if (resource != null) {
					        cachedModel = getModel(resource.getURI());
					    }
					}else if(Resource.class.isAssignableFrom(notification.getNotifier().getClass()) && notification.getEventType() <= 6){
						//notifier is the resource
						cachedModel = getModel(((Resource)notification.getNotifier()).getURI());
					}
					
					//tag as dirty
					if(cachedModel != null && !cachedModel.isSaving()){
						cachedModel.setDirty(true);
						//notify listeners
						for(ModelCacheListener listener : listeners){
							listener.onModelDirty(cachedModel);
							listener.onDirtyStateChanged(true);							
						}

					}

				}catch(Exception e){
					e.printStackTrace();
				}				
			}
			
			super.notifyChanged(notification);
		}
		
	};
	
	protected void _addModelChangeListener(EditedModel model){
		if(!model.getModelResource().eAdapters().contains(modelChangeObserver)){
			model.getModelResource().eAdapters().add(modelChangeObserver);
		}
	}
	protected void _removeModelChangeListener(EditedModel model){
		model.getModelResource().eAdapters().remove(modelChangeObserver);		
	}
	
	private ResourcesManager resourcesManager;
	
	protected ResourcesManager getResourcesManager(){
		if(resourcesManager == null){
			resourcesManager = EmfToolsFacade.getInstance().getResourcesManager();
		}
		return resourcesManager;
	}

}
