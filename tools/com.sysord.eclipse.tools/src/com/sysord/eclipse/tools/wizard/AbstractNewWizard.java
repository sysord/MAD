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
package com.sysord.eclipse.tools.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.sysord.eclipse.tools.EclipseToolsPlugin;
import com.sysord.eclipse.tools.L;

/**
 * {@link INewWizard Wizard} excuting a defined {@link IRunnableWithProgress operation} on
 * finish.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractNewWizard extends Wizard implements INewWizard {

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle(L.title_new);
	}

	@Override
	public final boolean performFinish() {
		try {
			beforePerformFinish();
			getContainer().run(true, false, getWizardOperation());
			return afterWizardOperation();
		} catch (InvocationTargetException e) {
			EclipseToolsPlugin.log(e);
			return false;
		} catch (InterruptedException e) {
			EclipseToolsPlugin.log(e);
			return false;
		}
	}

	/**
	 * Called after the wizard operation has finished.
	 * <p>
	 * This method returns {@code true} by default, subclasses may override it.
	 * 
	 * @return {@code true} if the wizard is considered as finished;<br>
	 *         {@code false} otherwise.
	 */
	protected boolean afterWizardOperation() {
		return true;
	}

	/**
	 * Called before {@link #performFinish()}.
	 * <p>
	 * The default implementation does nothing, subclasses may override this method to do
	 * some work before the execution of the {@link #getWizardOperation() wizard
	 * operation}.
	 */
	protected void beforePerformFinish() {
		// Does nothing
	}

	/**
	 * Returns the {@link IRunnableWithProgress operation} to execute on finish.
	 * 
	 * @return the {@link IRunnableWithProgress operation} to execute on finish.
	 */
	protected abstract IRunnableWithProgress getWizardOperation();
}
