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

import com.sysord.mad.evaluator.QueryAnalyze;
import com.sysord.mad.type.TypeDescriptor;

public class QueryAnalyzeImpl implements QueryAnalyze {

	TypeDescriptor returnType;
	

	public QueryAnalyzeImpl(TypeDescriptor returnType) {
		super();
		this.returnType = returnType;
	}

	@Override
	public TypeDescriptor getReturnType() {
		return returnType;
	}

}
