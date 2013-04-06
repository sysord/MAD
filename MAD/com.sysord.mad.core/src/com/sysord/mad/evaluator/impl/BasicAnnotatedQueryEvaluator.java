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

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.evaluator.QueryEvaluationContext;


public class BasicAnnotatedQueryEvaluator extends AbstractAnnotationBasedQueryEvaluator {

	@Override
	public String getLanguageId() {
		return "CUSTOM";
	}
	
	@EvaluatorFunction(name="add")
	public Object additionne(Integer f1, Integer f2){
		return f1 + f2;
	}
	

	@EvaluatorFunction(name="parentOfParent")
	public Object additionne(EObject eobj){
		return eobj.eContainer();
	}

	@EvaluatorFunction(name="contextType")
	public Object evalContext(QueryEvaluationContext evalContext, Integer i){
		return "" +  i + " ==> " +  evalContext.getContextObjectType().getType();
	}

}
