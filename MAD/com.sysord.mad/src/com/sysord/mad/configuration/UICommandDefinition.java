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

import java.util.List;

import com.sysord.mad.query.QueryDefinition;

/**
 * Description of an UI command defined in a MAD configuration.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see CommandDefinition
 * @see WidgetConfiguration
 */
public interface UICommandDefinition {

	/**
	 * Types of {@link UICommandDefinition}s.
	 */
	public enum UICOMMAND_TYPE {
		RELOAD_VIEW,
		RELOAD_WIDGETS,
		DISPLAY_VIEW
	}

	/**
	 * Returns the {@link UICOMMAND_TYPE type} of this command.
	 * 
	 * @return the {@link UICOMMAND_TYPE type} of this command.
	 */
	public UICOMMAND_TYPE getCommandType();

	/**
	 * Returns a {@link QueryDefinition query} that can retrieve the targeted element of
	 * this command.
	 * <p>
	 * Used for the {@link UICOMMAND_TYPE#DISPLAY_VIEW DISPLAY_VIEW} type of command.
	 * 
	 * @return a {@link QueryDefinition query} that can retrieve the targeted element of
	 *         this command.
	 */
	public QueryDefinition<?> getFindTargetQuery();

	/**
	 * Returns the IDs of all the widgets concerned by this command.
	 * <p>
	 * Used for the {@link UICOMMAND_TYPE#RELOAD_WIDGETS RELOAD_WIDGETS} type of commands.
	 * 
	 * @return the IDs of all the widgets concerned by this command.
	 */
	public List<String> getTargetsWidgetsIds();

}
