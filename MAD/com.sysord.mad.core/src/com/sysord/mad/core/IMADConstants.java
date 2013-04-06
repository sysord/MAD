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
package com.sysord.mad.core;

/**
 * XXX Comment role class
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface IMADConstants {

	/**
	 * The MAD Core plugin ID.
	 */
	public static final String PLUGIN_ID = "com.sysord.mad.core"; //$NON-NLS-1$

	/**
	 * ID of the MAD extension point.
	 */
	public static final String MAD_EXTENSION_ID = "madExtension";

	/**
	 * Name of the node in the MAD extension point containing the module class.
	 */
	public static final String MAD_EXT_MODULE = "module";

	/*
	 * Images referenced by the MAD Core plugin.
	 */

	public static final String WIZ_NEW_MAD_FILE = "resources/newmadfile_wiz.png";
	public static final String ICO_NEW_MAD_FILE = "resources/newmadfile.gif";
}
