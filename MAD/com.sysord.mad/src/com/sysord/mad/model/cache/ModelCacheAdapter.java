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

public abstract class ModelCacheAdapter implements ModelCacheListener{

	@Override
	public void onDirtyStateChanged(boolean isDirty) {
	}

	@Override
	public void onClear() {
	}

	@Override
	public void onFlush() {
	}

	@Override
	public void onModelChangedOutside(EditedModel model) {
	}

	@Override
	public void onModelAdded(EditedModel model) {
	}

	@Override
	public void onEvictModel(EditedModel model) {
	}

	@Override
	public void onModelDirty(EditedModel model) {
	}


}
