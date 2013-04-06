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
package com.sysord.mad.emitter;

import java.util.EmptyStackException;

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.mao.MaoException;

/**
 * The ViewHolder contains the created {@link ModelElementView views}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ModelElementView
 */
public interface ViewHolder {

	/**
	 * Creates a view for the specified {@link TypeConfiguration} and the {@link EObject}
	 * context element.
	 * 
	 * @param contextElement
	 * @param typeConfig
	 * @return the created view.
	 * @throws MaoException
	 */
	public ModelElementView createView(EObject contextElement, TypeConfiguration typeConfig) throws MaoException;

	/**
	 * Disposes all the registered views.
	 */
	public void disposeAll();

	/**
	 * Disposes the last registered view.<br>
	 * A disposed view cannot be restored.
	 * 
	 * @throws EmptyStackException if there is no registered views.
	 */
	public void disposeLastView();

	/**
	 * Restores the last view in the stack.
	 */
	public void restoreLastView();

	/**
	 * Returns the current view, or {@code null}.
	 * 
	 * @return the current view or {@code null}.
	 */
	public ModelElementView getCurrentView();
}
