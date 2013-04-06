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
package com.sysord.mad.mao;

import com.sysord.mad.command.AbstractMadCommand;
import com.sysord.mad.command.MadCommand;

/**
 * A {@code TransactionalMadCommand} is a {@link MadCommand} executed into an EMF
 * transaction.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see MadCommand
 * @see TransactionalCommandProvider
 */
public abstract class TransactionalMadCommand extends AbstractMadCommand {

	/**
	 * Command executed into the EMF transaction.
	 */
	protected MadCommand command;

	/**
	 * Creates a new {@code TransactionalMadCommand}.
	 * 
	 * @param command The command to execute into an EMF transaction.
	 */
	public TransactionalMadCommand(MadCommand command) {
		super();
		this.command = command;
	}

}
