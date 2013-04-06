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

import com.sysord.mad.model.EditedModel;

public interface ModelCacheListener {

	/**
	 * notify that the cache dirty state has changed
	 */
	public void onDirtyStateChanged(boolean isDirty);

	/**
	 * notify that the cache has been cleared 
	 */
	public void onClear();

	/**
	 * notify that the cache has been flushed (saved)
	 */
	public void onFlush();

	/**
	 * notify that a model has been changed and saved by another application
	 * client can choice to evict the model or keep the cached version
	 */
	public void onModelChangedOutside(EditedModel model);

	
	/**
	 * notify that a model has been added to the cache
	 */
	public void onModelAdded(EditedModel model);
	
	/**
	 * notify that a model is evicted from the cache
	 * @param model
	 */
	public void onEvictModel(EditedModel model);

	/**
	 * notify that a model has became dirty
	 */
	public void onModelDirty(EditedModel model);

}
