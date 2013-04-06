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
package com.sysord.eclipse.tools.diagnostic;

import com.sysord.eclipse.tools.diagnostic.Diagnostic.DIAGNOSTIC_LEVEL;

/**
 * 	Diagnostic factory
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class DiagnosticFactory {

	public static Diagnostic createDiagnostic(DIAGNOSTIC_LEVEL level, String message, String description){
		return new Diagnostic(level, message, description);
	}

	public static Diagnostic createNoErrorsDiagnostic(){
		return new Diagnostic(DIAGNOSTIC_LEVEL.NO_ERRORS, "No errors.");
	}

	public static Diagnostic createNoErrorsDiagnostic(String message, String description){
		return new Diagnostic(DIAGNOSTIC_LEVEL.NO_ERRORS, message, description);
	}

	public static Diagnostic createNoErrorsDiagnostic(String message){
		return new Diagnostic(DIAGNOSTIC_LEVEL.NO_ERRORS, message);
	}

	public static Diagnostic createInformationDiagnostic(String message, String description){
		return new Diagnostic(DIAGNOSTIC_LEVEL.INFO, message, description);
	}

	public static Diagnostic createInformationDiagnostic(String message){
		return new Diagnostic(DIAGNOSTIC_LEVEL.INFO, message);
	}

	public static Diagnostic createWarningDiagnostic(String message, String description){
		return new Diagnostic(DIAGNOSTIC_LEVEL.WARNING, message, description);
	}

	public static Diagnostic createWarningDiagnostic(String message){
		return new Diagnostic(DIAGNOSTIC_LEVEL.WARNING, message);
	}

	public static Diagnostic createErrorDiagnostic(String message, String description){
		return new Diagnostic(DIAGNOSTIC_LEVEL.ERROR, message, description);
	}

	public static Diagnostic createErrorDiagnostic(String message){
		return new Diagnostic(DIAGNOSTIC_LEVEL.ERROR, message);
	}
	
	public static Diagnostic createErrorDiagnostic(String message, Throwable cause){
		return new Diagnostic(DIAGNOSTIC_LEVEL.ERROR, message, message, cause);
	}


}
