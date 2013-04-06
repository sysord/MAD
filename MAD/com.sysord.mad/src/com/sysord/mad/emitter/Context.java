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

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.configuration.TypeConfiguration;

/**
 * Context of a {@link ViewEmitter}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ViewEmitter
 */
public interface Context {

	/**
	 * Returns the {@link TypeConfiguration} defined in this {@code Context}.
	 * 
	 * @return the {@link TypeConfiguration} defined in this {@code Context}.
	 */
	public TypeConfiguration getTypeConfiguration();

	/**
	 * Returns the label defined in this {@code Context}.
	 * 
	 * @return the label defined in this {@code Context}.
	 */
	public String getLabel();

	/**
	 * Returns the context {@link EObject element} defined int this {@code Context}.
	 * 
	 * @return the context {@link EObject element} defined int this {@code Context}.
	 */
	public EObject getContextElement();
}
