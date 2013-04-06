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
package com.sysord.mad.evaluator.impl;

import com.sysord.mad.evaluator.EvaluationAnalyze;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.type.TypeDescriptor;
import com.sysord.mad.type.TypeDescriptorUtil;

public  class QueryResultImpl<T> implements QueryResult<T> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static final QueryResult<?> NULL_QUERY_RESULT = new QueryResultImpl(null, TypeDescriptorUtil.NULL_TYPE);
	
	protected T value;
	protected TypeDescriptor type;
	
	protected EvaluationAnalyze evaluationAnalyze;
	
	public QueryResultImpl(T value, TypeDescriptor type, EvaluationAnalyze evaluationAnalyze) {
		super();
		this.value = value;
		this.type = type;
		this.evaluationAnalyze = evaluationAnalyze;
	}

	public QueryResultImpl(T value, TypeDescriptor type) {
		this(value, type, null);
	}



	@Override
	public T getValue() {
		return value;
	}

	@Override
	public TypeDescriptor getType() {
		return type;
	}

	public EvaluationAnalyze getEvaluationAnalyze() {
		return evaluationAnalyze;
	}

	@Override
	public void setEvaluationAnalyze(EvaluationAnalyze evaluationAnalyze) {
		this.evaluationAnalyze = evaluationAnalyze;
	}

}
