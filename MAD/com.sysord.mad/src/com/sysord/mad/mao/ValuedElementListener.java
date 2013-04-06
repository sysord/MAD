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
package com.sysord.mad.mao;

import org.eclipse.emf.ecore.EObject;

/**
 * Listener for valued {@link ValuedSemanticElement element} changed.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface ValuedElementListener {

	/**
	 * Notifies this listener that the {@link EObject} element of the valued semantic
	 * element has changed.
	 * 
	 * @param oldElement Previous element.
	 * @param newElement New element replacing the old one.
	 */
	public void valuedElementChanged(EObject oldElement, EObject newElement);
}
