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
 * {@link Exception} thrown when errors occur during accesses to a model.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see ModelAccessObject
 */
public class MaoException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new {@code MaoException} with {@code null} a message and without cause.
	 */
	public MaoException() {
		super();
	}

	/**
	 * Creates a new {@code MaoException} with the given message and cause.
	 * 
	 * @param message Message of the exception.
	 * @param cause Cause of the exception.
	 */
	public MaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates a new {@code MaoException} with the given message and without cause.
	 * 
	 * @param message The message of the exception.
	 */
	public MaoException(String message) {
		super(message);
	}

	/**
	 * Creates a new {@code MaoException} with a {@code null} message and the given cause.
	 * 
	 * @param cause Cause of the exception.
	 */
	public MaoException(Throwable cause) {
		super(cause);
	}

}
