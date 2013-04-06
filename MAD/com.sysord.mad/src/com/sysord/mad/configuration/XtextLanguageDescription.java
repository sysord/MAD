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
package com.sysord.mad.configuration;

/**
 * Description of the location of the plug-in describing an Xtext language.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 */
public interface XtextLanguageDescription {

	/**
	 * Returns the Xtext Dsl Qualified Bundle id.
	 * 
	 * @return the Xtext Dsl Qualified Bundle id.
	 */
	public String getBundleId();

	/**
	 * Returns the Xtext Dsl Activator class qualified name.
	 * 
	 * @return the Xtext Dsl Activator class qualified name.
	 */
	public String getActivatorClassName();

	/**
	 * Returns the Xtext Dsl language name.
	 * 
	 * @return the Xtext Dsl language name.
	 */
	public String getLanguageName();

}
