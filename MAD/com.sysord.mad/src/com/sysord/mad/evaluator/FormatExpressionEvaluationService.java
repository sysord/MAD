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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * Evaluator for format expression.
 * Format expression is a string composed of string literal and
 * valuable parts (queries between []) 
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public interface FormatExpressionEvaluationService {

	/**
	 * Evaluate the formatExpression for the contextObject
	 * 
	 * @param contextObject
	 * @param formatExpression
	 * @param arguments TODO
	 * @return
	 */
	public String evaluateFormatExpression(Object contextObject, String formatExpression, Map<String, Object> arguments);

	
}
