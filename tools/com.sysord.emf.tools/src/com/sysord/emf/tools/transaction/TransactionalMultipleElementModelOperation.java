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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * XXX Comment role class
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class TransactionalMultipleElementModelOperation<E extends EObject, T> implements Runnable {

    protected List<E> elements;
    protected T newValue;

    public TransactionalMultipleElementModelOperation(List<E> elements, T newValue) {
        this.elements = elements;
        this.newValue = newValue;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        TransactionalEditingDomain editingDomain = getEditingDomain();
        if (editingDomain != null) {
            editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

                @Override
                protected void doExecute() {
                    doModelOperation();
                }
            });
        }
    }

    protected abstract void doModelOperation();

    private TransactionalEditingDomain getEditingDomain() {
        if (elements.size() > 0) {
            return TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(elements.get(0).eResource()
                    .getResourceSet());
        }// else
        return null;
    }
}
