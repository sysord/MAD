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
package com.sysord.xtext.tools;

import org.osgi.framework.BundleActivator;

/**
 * Descriptor for locate a Xtext Dsl
 * 
 * hold informations about a Xtext Dsl plugin
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class XtextLanguageDescriptor {
	/**
	 * Qualified Bundle id
	 */
	protected String bundleId;
	
	/**
	 * Activator plugin class
	 */
	protected Class<? extends BundleActivator> activatorClass;
	
	/**
	 * Activator instance
	 */
	protected BundleActivator activator;
	
	/**
	 * Language id
	 */
	protected String languageId;

	
	public XtextLanguageDescriptor(String bundleId, Class<? extends BundleActivator> activatorClass, BundleActivator activator, String languageId) {
		super();
		this.bundleId = bundleId;
		this.activatorClass = activatorClass;
		this.activator = activator;
		this.languageId = languageId;
	}
}
