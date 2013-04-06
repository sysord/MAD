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
package com.sysord.mad.log;

import org.eclipse.ui.console.MessageConsole;

import com.sysord.eclipse.tools.runtime.ConsoleLogger;

/**
 * Implementation of the {@link MADLogger} interface.
 * <p>
 * Log the messages and errors in a {@link MessageConsole}, and the errors are written in
 * red.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class MADLoggerImpl extends ConsoleLogger {

    public static final String CONSOLE_ID = "MAD Console";

    @Override
    protected String getConsoleId() {
        return CONSOLE_ID;
    }
}
