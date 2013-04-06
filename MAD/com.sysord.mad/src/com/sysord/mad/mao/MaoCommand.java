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

/**
 * IDs of the <em>Model Access Object</em> commands.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see ModelAccessObject
 */
public interface MaoCommand {

	/**
	 * ID of the {@code MaoCommand} UPDATE.
	 */
	public static final String UPDATE_COMMAND = "UPDATE";

	/**
	 * ID of the {@code MaoCommand} NAVIGATION.
	 */
	public static final String NAVIGATION_COMMAND = "NAVIGATION";

}
