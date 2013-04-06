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
 * Exception thrown by the {@link FunctionProcessor}, indicating a problem during the
 * processing of an expression type.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class FunctionProcessingException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new {@code FunctionProcessingException}.
     */
    public FunctionProcessingException() {
        super();
    }

    /**
     * Creates a new {@code FunctionProcessingException}.
     * 
     * @param message
     */
    public FunctionProcessingException(String message) {
        super(message);
    }

    /**
     * Creates a new {@code FunctionProcessingException}.
     * 
     * @param cause
     */
    public FunctionProcessingException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@code FunctionProcessingException}.
     * 
     * @param message
     * @param cause
     */
    public FunctionProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

}
