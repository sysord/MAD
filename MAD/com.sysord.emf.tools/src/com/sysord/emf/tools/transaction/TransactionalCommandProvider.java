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

/**
 * Service for create Transactional command
 * depending on processed model element 
 */ 
public interface TransactionalCommandProvider {

	public TransactionalCommand createTransactionalCommand(EObject processedElement, Runnable baseCommand);

	public void executeAsTransactionnalCommand(EObject processedElement, Runnable baseCommand);

	public void executeAsTransactionnalCommand(ResourceSet resourceSet, Runnable baseCommand); 
	
}
