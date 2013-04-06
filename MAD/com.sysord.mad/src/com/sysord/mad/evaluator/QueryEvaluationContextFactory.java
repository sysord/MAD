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

import com.sysord.mad.query.SingleQueryDefinition;
import com.sysord.mad.type.TypedValue;

public interface QueryEvaluationContextFactory {

	public QueryEvaluationContext createEvaluationContext(SingleQueryDefinition query, TypedValue contextObject,
															Map<String,TypedValue> arguments, boolean evaluationAnalyzeRequired);
	
}
