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

import org.eclipse.emf.ecore.resource.Resource;

import com.sysord.emf.tools.model.ModelObserver;


/**
 * Observer of the Master model for track
 * modifications and synchronize a slave model
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public interface ModelSynchronizer extends ModelObserver{

//	/**
//	 * the master resource to observe for synchronization 
//	 * @param masterResource
//	 */
//	public void setMasterResource(Resource masterResource);
//
//	/**
//	 * resource to synchronize
//	 * @param slaveResource
//	 */
//	public void setSlaveResource(Resource slaveResource);
	

	/**
	 * Define master resource to be observed and the slave resource to be synchronized
	 * @param masterResource
	 * @param slaveResource
	 */
	public void configure(Resource masterResource, Resource slaveResource);

	/**
	 * if true slave resource will be save after every change.
	 * @param autosave
	 */
	public void setAutoSave(boolean autosave);
	
	/**
	 * start synchronizer by set up the master resource observer.
	 */
	public void start();
	
	/**
	 * stop synchronizer by remove the master resource observer.
	 */
	public void stop();
	
	
}
