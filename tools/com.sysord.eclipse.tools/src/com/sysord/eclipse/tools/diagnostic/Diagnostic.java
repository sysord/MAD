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

/**
 * Structure for holding diagnostic information
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class Diagnostic {
	
	public enum DIAGNOSTIC_LEVEL{
		NO_ERRORS,
		INFO,
		WARNING,
		ERROR,
	}
	
	/**
	 * The diagnostic level
	 */
	protected DIAGNOSTIC_LEVEL level;
	
	/**
	 * The diagnostic short message
	 */
	protected String message;
		
	/**
	 * The diagnostic description
	 */
	protected String description;


	/**
	 * The diagnostic cause (for errors)
	 */
	protected Throwable cause;
	

	public Diagnostic(DIAGNOSTIC_LEVEL level, String message, String description, Throwable cause) {
		super();
		this.level = level;
		this.message = message;
		this.description = description;
		this.cause = cause;
	}

	public Diagnostic(DIAGNOSTIC_LEVEL level, String message, String description) {
		this(level, message, description, null);
	}
		
	public Diagnostic(DIAGNOSTIC_LEVEL level, String message) {
		this(level, message, message);
	}

	/**
	 * the diagnostic level getter
	 * @return
	 */
	public DIAGNOSTIC_LEVEL getLevel() {
		return level;
	}

	/**
	 * the diagnostic level setter
	 * @param level
	 */
	public void setLevel(DIAGNOSTIC_LEVEL level) {
		this.level = level;
	}

	/**
	 * the diagnostic message getter
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * the diagnostic message setter
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * the diagnostic description getter
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * the diagnostic description setter
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * the diagnostic cause getter
	 * @param cause
	 */
	public Throwable getCause() {
		return cause;
	}

	/**
	 * the diagnostic cause setter
	 * @param cause
	 */
	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	
}
