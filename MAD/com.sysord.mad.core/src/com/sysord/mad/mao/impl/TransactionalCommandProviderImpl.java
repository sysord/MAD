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
package com.sysord.mad.mao.impl;

import com.sysord.mad.command.MadCommand;
import com.sysord.mad.command.impl.EditingDomainTransactionalMadCommand;
import com.sysord.mad.mao.TransactionalCommandProvider;
import com.sysord.mad.mao.TransactionalMadCommand;
import com.sysord.mad.mao.ValuedSemanticElement;

public class TransactionalCommandProviderImpl implements TransactionalCommandProvider{

	@Override
	public TransactionalMadCommand createTransactionalCommand(ValuedSemanticElement processedElement, MadCommand baseCommand) {
		return createEditingDomainTransactionalCommand(processedElement, baseCommand);
	}
	
	protected TransactionalMadCommand createEditingDomainTransactionalCommand(ValuedSemanticElement processedElement, MadCommand baseCommand){
		//return new EditingDomainTransactionalMadCommand(baseCommand, processedElement.getElement().eResource().getResourceSet());
		return new EditingDomainTransactionalMadCommand(baseCommand, processedElement.getElementResource().getResourceSet());
	}

}
