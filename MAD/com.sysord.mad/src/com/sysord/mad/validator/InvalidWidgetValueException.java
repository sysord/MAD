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
package com.sysord.mad.validator;

/**
 * Exception raised when validation fails for a value.
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class InvalidWidgetValueException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidWidgetValueException(String message) {
		super(message);
	}

}
