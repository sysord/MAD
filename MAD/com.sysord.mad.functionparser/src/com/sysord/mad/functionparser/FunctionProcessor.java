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

import java.util.List;

/**
 * A {@code FunctionProcessor} provides methods for processing expression values and
 * evaluate functions.
 * <p>
 * The {@link FunctionParser} delegates the processing and the function evaluation to the
 * {@code FunctionProcessor}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see FunctionParser
 */
public interface FunctionProcessor {

    /**
     * Processes an identifier.
     * 
     * @param identifier
     * @return the processed identifier.
     * @throws FunctionProcessingException
     */
    public Object caseIdentifier(String identifier) throws FunctionProcessingException;

    /**
     * Processes a variable name.
     * 
     * @param varname
     * @return the processed variable name.
     * @throws FunctionProcessingException
     */
    public Object caseVar(String varname) throws FunctionProcessingException;

    /**
     * Processes a string value.
     * 
     * @param value
     * @return the processed string value.
     * @throws FunctionProcessingException
     */
    public Object caseString(String value) throws FunctionProcessingException;

    /**
     * Processes a boolean value.
     * 
     * @param value
     * @return the processed boolean value.
     * @throws FunctionProcessingException
     */
    public Object caseBoolean(boolean value) throws FunctionProcessingException;

    /**
     * Processes an integer value.
     * 
     * @param value
     * @return the processed integer value.
     * @throws FunctionProcessingException
     */
    public Object caseInteger(int value) throws FunctionProcessingException;

    /**
     * Processes a decimal (double) value.
     * 
     * @param value
     * @return the processed decimal value.
     * @throws FunctionProcessingException
     */
    public Object caseDecimal(double value) throws FunctionProcessingException;

    /**
     * Evaluates the function with the given name and arguments.
     * 
     * @param name Name of the function to evaluate.
     * @param arguments Arguments of the function to evaluate.
     * @return the result of the evaluation of the function.
     * @throws FunctionProcessingException
     */
    public Object evalFunction(String name, List<Object> arguments) throws FunctionProcessingException;
}
