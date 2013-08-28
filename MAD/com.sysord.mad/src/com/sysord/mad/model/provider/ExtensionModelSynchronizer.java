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
package com.sysord.mad.model.provider;


public interface ExtensionModelSynchronizer extends ModelSynchronizer {

	/**
	 * Set extension manager for synchronize the ExtensionModel
	 * @param extensionManager
	 */
	public void setExtensionManager(ModelExtensionManager extensionManager);

}
