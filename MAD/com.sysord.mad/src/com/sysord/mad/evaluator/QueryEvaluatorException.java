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
package com.sysord.mad.evaluator;

public class QueryEvaluatorException extends Exception {

	protected String query;
	
	public QueryEvaluatorException() {
		super();
	}

	public QueryEvaluatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public QueryEvaluatorException(String message, Throwable cause, String query) {
		super(message, cause);
		this.query = query;
	}

	public QueryEvaluatorException(String message) {
		super(message);
	}

	public QueryEvaluatorException(Throwable cause) {
		super(cause);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
