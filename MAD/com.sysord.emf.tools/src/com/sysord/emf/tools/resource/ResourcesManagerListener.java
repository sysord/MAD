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



public interface ResourcesManagerListener {

	public enum RESOURCE_EVENT{
		LINKED_RESOURCE_TO_BE_SAVED,
		CHANGED,
		RELOADED,
		DELETED,
	}
	
	//public void onManagedResourceEvent(URI resourceUri, RESOURCE_EVENT event);
	public void onManagedResourceEvent(String resourceName, RESOURCE_EVENT event);
	
}
