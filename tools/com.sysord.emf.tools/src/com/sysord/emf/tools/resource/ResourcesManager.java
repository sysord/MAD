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
package com.sysord.emf.tools.resource;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.widgets.Display;

import com.sysord.emf.tools.misc.LRUCache;
import com.sysord.emf.tools.misc.LRUCache.LRUCacheListener;
import com.sysord.emf.tools.resource.ResourcesManagerListener.RESOURCE_EVENT;

/**
 * this class hold used resources in a MRU
 * it load and provide resources by name, listen for changes and refresh
 */
public class ResourcesManager {


	/**
	 * lru cache resource storage
	 */
	protected LRUCache<String, ManagedResource> lruCache;
	protected static final int LRU_DEFAULT_SIZE = 3;

	public static final int NONE_OPTION = 0;
	public static final int DISABLE_AUTORELOAD_OPTION = 1;
	public static final int REMOVE_ON_CHANGE_OPTION = 2; //release the resource when change event occurs
	
	protected class ManagedResource{
		protected Resource resource;
		protected ResourceSet resourceSet;
		protected int ManagementOptions = NONE_OPTION;
		public ManagedResource(Resource resource, int managementOptions) {
			super();
			this.resource = resource;
			ManagementOptions = managementOptions;
		}
	}
	
	/**
	 * managed resources observer
	 */
	protected IResourceChangeListener resourceChangeListener; 

	
	/**
	 * Listeners
	 */
	Map<String, List<ResourcesManagerListener>> resourceslisteners =
	        Collections.synchronizedMap(new HashMap<String, List<ResourcesManagerListener>>());

	/**
	 * when a resource is linked to another resource, resource save implies all linked resources save too
	 * key is the master resource when saved all resources in the list value are saved too.
	 */
	Map<String, List<String>> resourcesLinks = new HashMap<String, List<String>>();

	/**
	 * 
	 */
	public ResourcesManager() {
		this(LRU_DEFAULT_SIZE);
	}

	/**
	 * 
	 * @param lruSize
	 */
	public ResourcesManager(int lruSize) {
		super();
		_createLRUCache(lruSize);
		_setupResourceChangeListener();
	}

	
	@Override
	protected void finalize() throws Throwable {
		_removeResourceChangeListener();
		super.finalize();
	}

	protected void _createLRUCache(int lruSize){
		
		lruCache = new LRUCache<String, ManagedResource>(lruSize);		

		LRUCacheListener<String, ManagedResource> cacheListener = new LRUCacheListener<String, ManagedResource>() {			
			@Override
				public boolean requestRemoveEldestEntry(Entry<String, ManagedResource> eldest) {
					return onRequestRemoveResource(eldest.getValue());
				}
		};
		lruCache.setCacheListener(cacheListener);
		
	}
	
	
	/**
	 * return true if a resource with this name is managed.
	 * @param resourceName
	 * @return
	 */
	public boolean isManagedResource(String resourceName){
		return lruCache.containsKey(resourceName);
	}
	
	/**
	 * provide resource by name
	 * if resource exists in cache resource is returned
	 * otherwise resource is loaded and added to the cache
	 * 
	 * @param resourceName
	 * @return
	 */
	public Resource getResource(String resourceName){
		return getResource(null, resourceName, null, null);
	}

	public Resource getResource(ResourceSet resourceSet, String resourceName){
		return getResource(resourceSet, resourceName, null, null);
	}

	/**
	 * provide resource by name
	 * if resource exists in cache resource is returned
	 * otherwise resource is loaded and added to the cache
	 * create link between the linkedMasterResourceName and the resource
	 * 
	 * @param resourceName
	 * @param linkedMasterResourceName
	 * @return
	 */
	public Resource getResource(String resourceName, String linkedMasterResourceName){
		return getResource(null, resourceName, null, linkedMasterResourceName);
	}

	public Resource getResource(ResourceSet resourceSet, String resourceName, String linkedMasterResourceName){
		return getResource(resourceSet, resourceName, null, linkedMasterResourceName);
	}

	/**
	 * provide resource by name
	 * if resource exists in cache resource is returned
	 * otherwise resource is loaded and added to the cache
	 * Install the resource listener 
	 * @param resourceName
	 * @param listener
	 * @return
	 */
	public Resource getResource(String resourceName, ResourcesManagerListener listener){
		return getResource(null, resourceName, listener, null);
	}

	/**
	 * provides resource by name
	 * if resource exists in cache resource is returned
	 * otherwise resource is loaded and added to the cache
	 * Install the resource listener and create link between the linkedMasterResourceName 
	 * and the resource
	 * 
	 * @param resourceName
	 * @param listener
	 * @param linkedMasterResourceName
	 * @return
	 */
	public Resource getResource(String resourceName, ResourcesManagerListener listener, String linkedMasterResourceName){				
		return getResource(null, resourceName, listener, linkedMasterResourceName);
	}

	public Resource getResource(ResourceSet resourceSet, String resourceName, ResourcesManagerListener listener, String linkedMasterResourceName){		
		Resource resource = _getCachedResource(resourceName);		
		if(resource == null){
			resource = _loadResource(resourceSet, resourceName);
		}		
		_installListeners(resource, listener, linkedMasterResourceName);		
		return resource;
	}
	
	/**
	 * provide resource by name
	 * if resource exists in cache resource is returned
	 * otherwise resource is loaded and added to the cache
	 * if createIfNotExist is true, when resource not exists a new 
	 * resource is created and persisted
	 * 
	 * @param resourceName
	 * @param createIfNotExist if true, when resource not exists a new resource is created and persisted
	 * 
	 * @return
	 */
	public Resource getResource(String resourceName, boolean createIfNotExist){
		return getResource(null, resourceName, createIfNotExist);
	}

	public Resource getResource(ResourceSet resourceSet, String resourceName, boolean createIfNotExist){
		Resource resource = getResource(resourceSet, resourceName);
		//resource not found: create a new resource and persist it
		if(resource == null && createIfNotExist){
			_createResource(resourceSet, resourceName, true);
		}
		return resource;
	}
	
	public void manageResource(Resource resource){
		manageResource(resource, null, null, NONE_OPTION);
	}

	public void manageResource(Resource resource, int managementOptions){
		manageResource(resource, null, null, managementOptions);
	}

	public void manageResource(Resource resource, ResourcesManagerListener listener, String linkedMasterResourceName, int managementOptions){
		//store in cache (if not null)
		_storeResource(resource, managementOptions);			
		//install listeners
		_installListeners(resource, listener, linkedMasterResourceName);
	}

	/**
	 * manage resource by name: no resource is stored only name for be notified 
	 * when the resource with this name changes.
	 * @param resourceName
	 * @param listener
	 * @param linkedMasterResourceName
	 * @param managementOptions
	 */
	public void manageResource(String resourceName, ResourcesManagerListener listener, String linkedMasterResourceName, int managementOptions){
		//store in cache (if not null)
		_storeResource(resourceName, managementOptions);			
		//install listeners
		_installListeners(resourceName, listener, linkedMasterResourceName);		
	}

	
	/**
	 * install change listener and resource link 
	 * @param resource
	 * @param listener
	 * @param linkedMasterResourceName
	 */
	protected void _installListeners(Resource resource, ResourcesManagerListener listener, String linkedMasterResourceName){				
		if(resource == null){
			return;
		}
		String resourceName = resource.getURI().toString();
		_installListeners(resourceName, listener, linkedMasterResourceName);
	}

	protected void _installListeners(String resourceName, ResourcesManagerListener listener, String linkedMasterResourceName){				
		//install listener
		if(listener != null){
			addListener(resourceName, listener);			
		}
		//create link
		if(linkedMasterResourceName != null){
			linkResource(linkedMasterResourceName, resourceName);			
		}		
	}
	
	
	protected Resource _getCachedResource(String resourceName){
		if(!isManagedResource(resourceName)){
			return null;
		}else{
			return lruCache.get(resourceName).resource;			
		}
	}

	protected ManagedResource _getCachedManagedResource(String resourceName){
		if(!isManagedResource(resourceName)){
			return null;
		}else{
			return lruCache.get(resourceName);			
		}
	}
	
	/**
	 * Link resources: when masterResource will be saved, liked resource will be saved too
	 * 
	 * @param masterResource
	 * @param linkedResource
	 */
	public void linkResource(Resource masterResource, Resource linkedResource){
		linkResource(masterResource.getURI().toString(), linkedResource.getURI().toString());
	}
	/**
	 * Link resources by name : when masterResource will be saved, liked resource will be saved too
	 *
	 * @param masterResourceName
	 * @param linkedResourceName
	 */
	public void linkResource(String masterResourceName, String linkedResourceName){
		_createLink(masterResourceName, linkedResourceName);
	}
	

	
	/**
	 * Unlink all resources linked to the masterResource
	 * 
	 * @param masterResource
	 */
	public void unlinkResources(Resource masterResource){
		unlinkResources(masterResource.getURI().toString());
	}

	/**
	 * Unlink all resources linked to the masterResource
	 * @param masterResourceName
	 */
	public void unlinkResources(String masterResourceName){
		resourcesLinks.remove(masterResourceName);
	}
	
	/**
	 * Unlink the resource from all master resources.
	 * @param linkedResourceName
	 */
	public void unlinkResource(String linkedResourceName){
		for(Entry<String, List<String>> linksEntry : resourcesLinks.entrySet()){
			linksEntry.getValue().remove(linkedResourceName);
		}
	}

	/**
	 * Unlink the linked resource from the master resource
	 * @param masterResourceName
	 * @param linkedResourceName
	 */
	public void unlinkResource(Resource masterResource, Resource linkedResource){
		unlinkResource(masterResource.getURI().toString(), linkedResource.getURI().toFileString());
	}
	
	/**
	 * Unlink the linked resource from the master resource
	 * 
	 * @param masterResourceName
	 * @param linkedResourceName
	 */
	public void unlinkResource(String masterResourceName, String linkedResourceName){
		List<String> linkedResources = resourcesLinks.get(masterResourceName);
		if(linkedResources != null){
			linkedResources.remove(linkedResourceName);
		}
	}
	
	public boolean existsLinkedResources(String masterResourceName){
		return resourcesLinks.containsKey(masterResourceName);
	}
	
	protected void _saveLinkedResources(String masterResourceName){
		List<String> linkedResourcesNames = resourcesLinks.get(masterResourceName);
		if(linkedResourcesNames != null){
			for(String linkedResourceName : linkedResourcesNames){
				notifyListeners(linkedResourceName, RESOURCE_EVENT.LINKED_RESOURCE_TO_BE_SAVED);
				Resource linkedResource = _getCachedResource(linkedResourceName);
				if(linkedResource != null){
					try {
						linkedResource.save(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	/**
	 * create link between masterResourceName and linkedResourceName
	 * @param masterResourceName
	 * @param linkedResourceName
	 */
	protected void _createLink(String masterResourceName, String linkedResourceName){
		List<String> linkedResources = _getLinkedResources(masterResourceName, true);
		if(!linkedResources.contains(linkedResourceName)){
			System.out.println("ResourcesManager: create link between:" + masterResourceName + " linked to " + linkedResourceName);
			linkedResources.add(linkedResourceName);
		}
	}

	/**
	 * returns linked resources name list for a masterResourceName
	 * @param masterResourceName
	 * @param createIfNotExists if true and no entry exists for the masterResourceName 
	 * a new entry with an empty list is created.
	 * @return
	 */
	protected List<String> _getLinkedResources(String masterResourceName, boolean createIfNotExists){
		List<String> linkedResources = resourcesLinks.get(masterResourceName);
		if(linkedResources == null && createIfNotExists){
			linkedResources = new ArrayList<String>();
			resourcesLinks.put(masterResourceName, linkedResources);				
		}		
		return linkedResources;
	}
	
	
	/**
	 * Add listener for resource event notification
	 * @param resourceName
	 * @param listener
	 */
	public void addListener(String resourceName, ResourcesManagerListener listener){
		//look for resource listener list
		List<ResourcesManagerListener> resourceListeners = resourceslisteners.get(resourceName);
		if(resourceListeners == null){
			//create new resource listener list
			resourceListeners = new ArrayList<ResourcesManagerListener>();
			resourceslisteners.put(resourceName, resourceListeners);
		}
		//add listener if not exists
		if(! resourceListeners.contains(listener)){
			resourceListeners.add(listener);
		}
	}
	
	/**
	 * remove listener for resource event notification
	 * @param resourceName
	 * @param listener
	 */
	public void removeListener(String resourceName, ResourcesManagerListener listener){
		//look for resource listener list
		List<ResourcesManagerListener> resourceListeners = resourceslisteners.get(resourceName);
		if(resourceListeners == null){
			return;
		}		
		//remove listener if exists
		_removeListener(listener, resourceListeners);
		
	}
	public void removeListener(ResourcesManagerListener listener){
	    synchronized (resourceslisteners) {
	        for(List<ResourcesManagerListener> listeners : resourceslisteners.values()){
	            _removeListener(listener, listeners);
	        }
        }
	}
	
	protected void _removeListener(ResourcesManagerListener listener, List<ResourcesManagerListener> listeners){
		listeners.remove(listener);
	}
	


	
	public void reloadResource(String resourceName){
		_reloadResource(resourceName);
	}
	
	/**
	 * remove resource by name, all listeners are removed
	 * @param resourceName
	 */
	public void releaseResource(String resourceName){
		Resource resource =  _getCachedResource(resourceName);
		if(resource != null){
			_removeResource(resource);
		}
	}
	
	
	
	/**
	 * called by the cache listener on remove eldest entry 
	 * @param value
	 * @return
	 */
	private boolean onRequestRemoveResource(ManagedResource removedResource) {
		//if exists listener for the resource don't remove the resource
		if(resourceslisteners.containsKey(removedResource.resource.getURI().toString())){
			return false;
		}
		_onReleaseResource(removedResource.resource);
		return true;
	}
	
	

	/**
	 * Load resource by name and update cache 
	 * 
	 * @param resourceName
	 * @return
	 */
	protected Resource _loadResource(ResourceSet resourceSet, String resourceName){
		if(resourceSet == null){
			resourceSet = new ResourceSetImpl();			
		}
		Resource resource = null;
		try {
    		resource = resourceSet.getResource(URI.createURI(resourceName, true), true);
    		//store in cache (if not null)
    		_storeResource(resource);
		} catch (WrappedException e) {
		    System.err.println("The resource " + resourceName + " couldn't be loaded.\n" + e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
		return resource;
	}

	protected Resource _reloadResource(String resourceName){
		Resource orgResource = _getCachedResource(resourceName);
		if(resourceName != null && orgResource != null){
			orgResource.getResourceSet().getResources().remove(orgResource);
			return _loadResource(orgResource.getResourceSet(), resourceName);			
		}else{
			return null; //_loadResource(null, resourceName);						
		}
	}

	protected Resource _createResource(ResourceSet resourceSet, String resourceName, boolean persist){
		if(resourceSet == null){
			resourceSet = new ResourceSetImpl();
		}
		Resource resource =  resourceSet.createResource(URI.createURI(resourceName, true));
		if(persist){
			try {
				resource.save(null);
			} catch (IOException e) {
				e.printStackTrace();
				resource = null;
			}			
		}
		return resource;		
	}
	
	/**
	 * store resource in the lruCache 
	 * @param resource
	 */
	protected void _storeResource(Resource resource){
		_storeResource(resource, NONE_OPTION);
	}
	protected void _storeResource(Resource resource, int managementOptions){
		if(resource != null){			
			lruCache.put(resource.getURI().toString(), new ManagedResource(resource, managementOptions));
		}
	}
	
	/**
	 * Store only resource name.
	 * @param resourceName
	 * @param managementOptions
	 */
	protected void _storeResource(String resourceName, int managementOptions){
		lruCache.put(resourceName, new ManagedResource(null, managementOptions));
	}

	/**
	 * remove resource from cache and remove its file Uri
	 * @param resource
	 */
	protected void _removeResource(Resource resource){
		lruCache.remove(resource.getURI().toString());
		_processReleaseResource(resource);
	}
	
	
	protected void _onReleaseResource(Resource resource){
		_onReleaseResource(resource.getURI().toString());
	}

	protected void _onReleaseResource(String resourceName){
		Resource resource =  _getCachedResource(resourceName);
		if(resource != null){
			_processReleaseResource(resource);
		}
	}

	
	protected void _processReleaseResource(Resource resource){
		String resourceName = resource.getURI().toString();
		//remove listeners
		resourceslisteners.remove(resourceName);
		//remove links
		unlinkResources(resourceName);
		unlinkResource(resourceName);
		//unload resource
		resource.getResourceSet().getResources().remove(resource);
		//resource.unload();
	}
	
	
	
	private void _setupResourceChangeListener(){
    	_createResourceListener();
    	IWorkspace workspace= ResourcesPlugin.getWorkspace();
    	workspace.addResourceChangeListener(resourceChangeListener);		
	}

	private void _removeResourceChangeListener(){
    	IWorkspace workspace= ResourcesPlugin.getWorkspace();
    	workspace.removeResourceChangeListener(resourceChangeListener);		
	}
	
	/**
	 * Create listener for detect changes on the managed resources
	 */
	protected void _createResourceListener(){
		final LRUCache<String, ManagedResource> managedResources = this.lruCache;
		resourceChangeListener = new IResourceChangeListener() {
			/**
			 * on resource change, if changed resource is a managed resource
			 * resource is reloaded
			 */
			public void resourceChanged(IResourceChangeEvent event) {
				try {
					// TODO: implements behavior for other event type (delete etc.)
					if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
						event.getDelta().accept(new IResourceDeltaVisitor() {
							public boolean visit(IResourceDelta delta) throws CoreException {
								if (delta.getResource() instanceof IFile) {
									IFile storage = (IFile) delta.getResource();
									final String resourceName = URI.createPlatformResourceURI(storage.getFullPath().toString(), true).toString();
									final IResourceDelta fdelta = delta;
									//System.out.println(resourceName + ":" + delta.getKind());
																		
									if (isManagedResource(resourceName) || existsLinkedResources(resourceName)) {
										// Save all resources linked to the saved
										// Reload resource 
										// Notify listeners
										_scheduleResourceProcess(resourceName);
									}
								}
								return true;
							}
						});
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		};

	}
	

	protected void _scheduleResourceProcess(final String resourceName){
		final boolean notifyListeners = resourceslisteners.containsKey(resourceName);
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					
					//Save linked resource
					_saveLinkedResources(resourceName);
					
					//Reload resource if autoReload is not disabled
					// and notify listeners for resource changes
					if(isManagedResource(resourceName)){
						System.out.println("ResourcesManager: Managed resource changed:" + resourceName);						
						ManagedResource managedResource = _getCachedManagedResource(resourceName);

						//Notify listeners about changed
						if(notifyListeners){
							notifyListeners(resourceName, RESOURCE_EVENT.CHANGED);							
						}
						
						//Autoreload the resources if not disabled.
						if((managedResource.ManagementOptions & DISABLE_AUTORELOAD_OPTION) == 0){
							System.out.println("ResourcesManager: Reload resource :" + resourceName);
							_reloadResource(resourceName);    		        												
							//Notify listeners about auto reload
							notifyListeners(resourceName, RESOURCE_EVENT.RELOADED);
						}
						
						if((managedResource.ManagementOptions & REMOVE_ON_CHANGE_OPTION) != 0){
							releaseResource(resourceName);
						}
						
					}
				}

			});
	}

	protected void notifyListeners(String resourceName, RESOURCE_EVENT event){
		if(resourceslisteners.containsKey(resourceName)){
		    synchronized (resourceslisteners) {
                List<ResourcesManagerListener> listeners = new ArrayList<ResourcesManagerListener>(resourceslisteners.get(resourceName));
                for (ResourcesManagerListener listener : listeners) {
                    listener.onManagedResourceEvent(resourceName, event);
                }
            }
		}		
	}
	

	
}
