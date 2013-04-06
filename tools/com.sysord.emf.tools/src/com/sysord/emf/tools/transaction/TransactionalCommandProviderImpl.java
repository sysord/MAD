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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class TransactionalCommandProviderImpl implements TransactionalCommandProvider{

	@Override
	public TransactionalCommand createTransactionalCommand(EObject processedElement, Runnable baseCommand) {
		return createEditingDomainTransactionalCommand(processedElement, baseCommand);
	}
	 
	@Override
	public void executeAsTransactionnalCommand(EObject processedElement, Runnable baseCommand){
		try {
			createTransactionalCommand(processedElement, baseCommand).execute();
		} catch (Exception e) {
			throw new RuntimeException("Transactionnal command execution failure.", e);
		}
	}
 
	@Override
	public void executeAsTransactionnalCommand(ResourceSet resourceSet, Runnable baseCommand){
		try {
			createEditingDomainTransactionalCommand(resourceSet, baseCommand).execute();
		} catch (Exception e) {
			throw new RuntimeException("Transactionnal command execution failure.", e);
		}
	}
	
	protected TransactionalCommand createEditingDomainTransactionalCommand(EObject processedElement, Runnable baseCommand){
		return createEditingDomainTransactionalCommand(processedElement.eResource().getResourceSet(), baseCommand);
	}
	
	protected TransactionalCommand createEditingDomainTransactionalCommand(ResourceSet resourceSet, Runnable baseCommand){
		return new EditingDomainTransactionalMadCommand(baseCommand, resourceSet);
	}
	
	

}
