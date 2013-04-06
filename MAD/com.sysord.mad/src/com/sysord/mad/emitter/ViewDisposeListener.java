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

/**
 * A {@code ViewDisposeListener} is notified when the listened {@link ModelElementView
 * view} is disposed.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ModelElementView
 */
public interface ViewDisposeListener {

	/**
	 * Notifies this listener the given {@link ModelElementView view} has been disposed.
	 * 
	 * @param disposedView The disposed {@link ModelElementView view}.
	 */
	public void viewDispose(ModelElementView disposedView);
}
