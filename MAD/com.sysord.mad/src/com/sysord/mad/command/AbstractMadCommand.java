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
package com.sysord.mad.command;

/**
 * Default implementation of the {@link MadCommand}.
 * <p>
 * As a {@link MadCommand} is {@link Runnable}, the default behavior of the {@link #run()}
 * method is to call the {@link #execute()} method of the {@code AbstractMadCommand}.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 */
public abstract class AbstractMadCommand implements MadCommand {

	@Override
	public abstract void execute();

	/**
	 * {@inheritDoc}
	 * <p>
	 * Calls the {@link #execute()} method of this {@link AbstractMadCommand}.
	 */
	@Override
	public void run() {
		try {
			execute();
		} catch (Exception e) {
			if (RuntimeException.class.isAssignableFrom(e.getClass())) {
				throw (RuntimeException) e;
			} else {
				throw new RuntimeException(e);
			}
		}
	}

}
