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
package com.sysord.emf.tools.transaction;


public abstract class TransactionalCommand {

	/**
	 * command to be run in transaction
	 */
	protected Runnable baseCommand;

	
	public TransactionalCommand(Runnable baseCommand) {
		super();
		this.baseCommand = baseCommand;
	}
	
	
	public abstract void execute();
	
	
	
}
