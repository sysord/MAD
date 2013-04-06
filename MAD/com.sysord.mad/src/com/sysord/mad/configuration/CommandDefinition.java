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

import com.sysord.eclipse.tools.swt.ImageResource;
import com.sysord.mad.query.QueryDefinition;

/**
 * Description of a command defined in a MAD configuration.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see WidgetConfiguration
 * @see QueryDefinition
 * @see UICommandDefinition
 */
public interface CommandDefinition {

	/**
	 * Categories of {@link CommandDefinition}s that can be used in a MAD configuration.
	 */
	public enum COMMAND_CATEGORY {
		GLOBAL_COMMAND,
		ITEM_COMMAND,
		UNKNOW_CATEGORY_COMMAND
	}

	/**
	 * Returns the ID of the command.
	 * 
	 * @return the ID of the command.
	 */
	public String getCommandId();

	/**
	 * Returns the command's {@link COMMAND_CATEGORY category}.
	 * 
	 * @return the command's {@link COMMAND_CATEGORY category}.
	 */
	public COMMAND_CATEGORY getCommandCategory();

	/**
	 * Returns the command's label.
	 * 
	 * @return the command's label.
	 */
	public String getCommandLabel();

	/**
	 * Returns the {@link QueryDefinition query} launched by the command.
	 * 
	 * @return the {@link QueryDefinition query} launched by the command.
	 */
	public QueryDefinition<?> getQueryAction();

	/**
	 * Indicates if the command uses an icon image.
	 * 
	 * @return {@code true} if the command uses an icon image;<br>
	 *         {@code false} otherwise.
	 * @see #getIconDescriptor()
	 */
	public boolean useIcon();

	/**
	 * Returns the image {@link ImageResource resource} of the icon used by the command,
	 * or {@code null} if the command doesn't use any icon.
	 * 
	 * @return the image {@link ImageResource resource} or {@code null}.
	 * @see #useIcon()
	 */
	public ImageResource getIconDescriptor();

	/**
	 * Returns the list of UI {@link UICommandDefinition commands} to execute after this
	 * command if it succeeds.
	 * 
	 * @return the list of UI {@link UICommandDefinition commands} to execute.
	 */
	public List<UICommandDefinition> getOnSuccessPostActionCommands();

	/**
	 * Returns the list of UI {@link UICommandDefinition commands} to execute after this
	 * command if it fails.
	 * 
	 * @return the list of UI {@link UICommandDefinition commands} to execute.
	 */
	public List<UICommandDefinition> getOnErrorPostActionCommands();
}
