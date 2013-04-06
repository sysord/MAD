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
package com.sysord.mad.functionparser;

/**
 * Exception thrown when the {@link FunctionParser} detects errors in the given parsed
 * string.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class FunctionParseException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new {@code FunctionParseException}.
     */
    public FunctionParseException() {
    }

    /**
     * Creates a new {@code FunctionParseException}.
     * 
     * @param message
     */
    public FunctionParseException(String message) {
        super(message);
    }

    /**
     * Creates a new {@code FunctionParseException}.
     * 
     * @param throwable
     */
    public FunctionParseException(Throwable throwable) {
        super(throwable);
    }

    /**
     * Creates a new {@code FunctionParseException}.
     * 
     * @param message
     * @param throwable
     */
    public FunctionParseException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
