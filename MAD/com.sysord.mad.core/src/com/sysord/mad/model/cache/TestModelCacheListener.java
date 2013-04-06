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

public class TestModelCacheListener extends ModelCacheAdapter {

	@Override
	public void onDirtyStateChanged(boolean isDirty) {
		System.out.println("onDirtyStateChanged:" + isDirty);
	}

	@Override
	public void onClear() {
		System.out.println("Cache onClear");
	}

	@Override
	public void onFlush() {
		System.out.println("Cache onFlush");
	}

	@Override
	public void onModelChangedOutside(EditedModel model) {
		System.out.println("Cached model Changed outside:" + model.getModelResource().getURI());
	}

	@Override
	public void onModelAdded(EditedModel model) {
		System.out.println("Model added:" + model.getModelResource().getURI());
	}

	@Override
	public void onEvictModel(EditedModel model) {
		System.out.println("Model evicted:" + model.getModelResource().getURI());
	}

	@Override
	public void onModelDirty(EditedModel model) {
		System.out.println("Model became dirty:" + model.getModelResource().getURI());
	}


}
