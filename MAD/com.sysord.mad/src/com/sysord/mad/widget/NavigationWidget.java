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

import org.eclipse.emf.ecore.EObject;

/**
 * A {@code NavigationWidget} is an {@link ActionWidget} for which the action is to
 * navigate.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface NavigationWidget extends ActionWidget, SelectableItem {

	/**
	 * Defines the semantic {@link EObject element} to which this widget will navigate.
	 * 
	 * @param semanticElement The navigation's destination.
	 */
	public void setNavigateTo(EObject semanticElement);

	/**
	 * Returns the navigation's destination semantic {@link EObject element}.
	 * 
	 * @return the navigation's destination semantic {@link EObject element}.
	 */
	public EObject getSemanticElementNavigation();
}
