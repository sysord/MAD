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
package com.sysord.mad.uicommand;

import java.util.List;

import com.sysord.mad.configuration.UICommandDefinition;
import com.sysord.mad.widget.Widget;

/**
 * Executor of <em>user-interface</em> {@link MadUICommand comands}.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 */
public interface MadUICommandService {

	/**
	 * Creates and launches an UI {@link MadUICommand command} from its definition.
	 * 
	 * @param widget The widget from which the command is launched.
	 * @param commandResult the context for evaluation
	 * @param uiCommandDef the ui command definition
	 */
	public void createAndLaunchUICommand(Widget<?> widget, Object commandResult, UICommandDefinition uiCommandDef);

	/**
	 * Creates and launches a list of UI {@link MadUICommand commands} from their
	 * definition.
	 * 
	 * @param widget The widget from which the commands are launched.
	 * @param context the context for evaluation
	 * @param uiCommandsDef the ui commands definitions
	 */
	public void createAndLaunchUICommands(Widget<?> widget, Object context, List<UICommandDefinition> uiCommandsDef);

}
