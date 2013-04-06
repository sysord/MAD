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
 * A {@code ViewVisibleListener} is notified when the visibility state of a listened view
 * has changed.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ModelElementView
 */
public interface ViewVisibleListener {

	/**
	 * Notifies this listener the visibility state of the given {@link ModelElementView
	 * view} has changed.
	 * 
	 * @param view The {@link ModelElementView view} subject of the notification.
	 * @param isVisible The new visibility state of the {@link ModelElementView view}.
	 */
	public void viewVisible(ModelElementView view, boolean isVisible);
}
