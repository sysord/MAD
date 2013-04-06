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
package com.sysord.mad.command;

/**
 * {@link Runnable} simple command.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 */
public interface MadCommand extends Runnable {

	/**
	 * Executes this command.
	 */
	public void execute();
	
}
