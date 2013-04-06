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
package com.sysord.mad.widget;

/**
 * Listener for editable state changed events on {@link InputWidget}s.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see InputWidget
 */
public interface WidgetEditableStateListener {

	/**
	 * Notifies this listener that the editable state has changed.
	 * 
	 * @param newEditableState New editable state of the listened widget.
	 */
	public void editableStateChanged(boolean newEditableState);

	/**
	 * Activates/Deactivates this listener.
	 * 
	 * @param active The active state to set.
	 */
	public void setActive(boolean active);

	/**
	 * Indicates if this listener is active or not.<br>
	 * An inactive listener should do nothing when notified.
	 * 
	 * @return {@code true} if this listener is active;<br>
	 *         {@code false} otherwise.
	 */
	public boolean isActive();
}
