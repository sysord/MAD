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

import com.sysord.mad.command.MadCommand;

/**
 * Service for creating transactional {@link TransactionalMadCommand commands} depending
 * on a processed model element.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 */
public interface TransactionalCommandProvider {

	/**
	 * Creates a transactionnal {@link TransactionalMadCommand command} for executing the
	 * given base {@link MadCommand} in an EMF transaction.
	 * 
	 * @param processedElement The element to update.
	 * @param baseCommand The base command to execute into an EMF transaction.
	 * @return The created {@link TransactionalMadCommand}.
	 */
	public TransactionalMadCommand createTransactionalCommand(ValuedSemanticElement processedElement,
			MadCommand baseCommand);

}
