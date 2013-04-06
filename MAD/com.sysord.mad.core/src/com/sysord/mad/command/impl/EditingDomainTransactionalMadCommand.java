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
package com.sysord.mad.command.impl;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.*;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.sysord.mad.command.MadCommand;
import com.sysord.mad.mao.TransactionalMadCommand;

public class EditingDomainTransactionalMadCommand extends TransactionalMadCommand{
	
	protected ResourceSet elementResourceSet;
	
	public EditingDomainTransactionalMadCommand(MadCommand command, ResourceSet elementResourceSet) {
		super(command);
		this.elementResourceSet = elementResourceSet;
	}

	@Override
	public void execute() {
		
	    // Looking for a Transactional editing domain
		TransactionalEditingDomain.Factory domainFactory = TransactionalEditingDomain.Factory.INSTANCE;
		EditingDomain editingDomain = domainFactory.getEditingDomain(elementResourceSet);

		if (editingDomain == null) {
		    // Looking for an Editing Domain
		    if (elementResourceSet instanceof IEditingDomainProvider) {
		        editingDomain = ((IEditingDomainProvider) elementResourceSet).getEditingDomain();
		    }
		}
		
		if (editingDomain == null) {
		    // No editing domain found, create one
            editingDomain = domainFactory.createEditingDomain(elementResourceSet);
		}
		
		Command emfCommand;
		if (editingDomain instanceof TransactionalEditingDomain) {
		    emfCommand = new RecordingCommand((TransactionalEditingDomain) editingDomain) {
                
                @Override
                protected void doExecute() {
                    // Execute the base command
                    command.execute();
                }
            };
		} else {
		    emfCommand = new AbstractCommand() {
                
                @Override
                public void redo() {
                    // Do nothing
                }
                
                @Override
                public boolean canUndo() {
                    return true;
                }
                
                @Override
                public void execute() {
                    command.execute();
                }
                
                @Override
                protected boolean prepare() {
                    return true;
                }
            };
		}
		
        editingDomain.getCommandStack().execute(emfCommand);
		
	}

}
