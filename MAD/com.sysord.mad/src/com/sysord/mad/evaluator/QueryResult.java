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

import com.sysord.mad.type.TypeDescriptor;
import com.sysord.mad.type.TypedValue;

/**
 * Result returned by a Query
 * with type information
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public interface QueryResult<T> extends TypedValue{
	public T getValue();
	public TypeDescriptor getType();
	
	public EvaluationAnalyze getEvaluationAnalyze();
	public void setEvaluationAnalyze(EvaluationAnalyze evaluationAnalyze);
}
