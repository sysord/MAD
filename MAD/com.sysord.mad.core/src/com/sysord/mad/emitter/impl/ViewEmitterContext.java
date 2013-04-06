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
package com.sysord.mad.emitter.impl;

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.emitter.Context;
import com.sysord.mad.emitter.ViewEmitter;

/**
 * Default implementation of the {@link Context} interface, for the {@link ViewEmitter}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ViewEmitterImpl
 */
public class ViewEmitterContext implements Context {

	private TypeConfiguration typeConfiguration;
	private String label;
	private EObject contextElement;

	@Override
	public TypeConfiguration getTypeConfiguration() {
		return typeConfiguration;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public EObject getContextElement() {
		return contextElement;
	}

	/**
	 * Set the specified value typeConfiguration for typeConfiguration.
	 * 
	 * @param typeConfiguration the value to set to typeConfiguration.
	 */
	public void setTypeConfiguration(TypeConfiguration typeConfiguration) {
		this.typeConfiguration = typeConfiguration;
	}

	/**
	 * Set the specified value label for label.
	 * 
	 * @param label the value to set to label.
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Set the specified value contextElement for contextElement.
	 * 
	 * @param contextElement the value to set to contextElement.
	 */
	public void setContextElement(EObject contextElement) {
		this.contextElement = contextElement;
	}

}
