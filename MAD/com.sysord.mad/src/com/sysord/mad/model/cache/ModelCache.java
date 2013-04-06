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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.google.common.cache.CacheLoader;
import com.sysord.mad.model.EditedModel;

/**
 * Model cache
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public interface ModelCache {
	
	
	/**
	 * no option defined
	 */
	public static final int NONE_OPTION = 0;
	/**
	 * by default resources are reloaded when changes
	 * are detected, this options disable this behavior
	 */
	public static final int DISABLE_AUTO_RELOAD = 1;
	
		
	/**
	 * add a cache listener {@link ModelCacheListener} 
	 * @param listener
	 */
	public void addListener(ModelCacheListener listener);

	/**
	 * remove a cache listener {@link ModelCacheListener} 
	 * @param listener
	 */
	public void removeListener(ModelCacheListener listener);

	/**
	 * returns true if a model with this resource URI exists in the cache
	 * @param modelResourceUri
	 * @return
	 */
	public boolean containsModel(URI modelResourceUri);
	
	/**
	 * Add model to the cache
	 * @param model
	 */
	public void storeModel(EditedModel model);
	
	/**
	 * Add model to the cache
	 * @param model
	 * @param options store options
	 */
	public void storeModel(EditedModel model, int options);
	
	/**
	 * returns a model by its resource URI
	 * @param modelResourceUri
	 * @return the model or null if not present
	 */
	public EditedModel getModel(URI modelResourceUri);

	/**
	 * remove a model from the cahce
	 * @param modelResourceUri
	 */
	public void evict(URI modelResourceUri);

	/**
	 * clear the cache: evict all contained models
	 */
	public void clear();

	/**
	 * flush the cache: save all stale resources
	 */
	public void flush();

}
