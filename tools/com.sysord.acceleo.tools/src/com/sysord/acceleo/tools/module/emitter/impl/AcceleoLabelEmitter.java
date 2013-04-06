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
package com.sysord.acceleo.tools.module.emitter.impl;

import org.eclipse.acceleo.model.mtl.Query;
import org.eclipse.acceleo.model.mtl.util.MtlSwitch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Variable;

public class AcceleoLabelEmitter extends MtlSwitch<String>{

	public String emitElementLabel(EObject element) {
		return doSwitch(element);
	}
	
	/**
	 * Create a label for Query declaration
	 * return query prototyp
	 */
	@Override
	public String caseQuery(Query query) {
		StringBuilder sb = new StringBuilder();
		sb.append(query.getName()).append("(");
		for(Variable param : query.getParameter()){
			sb.append(emitVariableLabel(param)).append(", ");
		}
		if(!query.getParameter().isEmpty()){
			sb.delete(sb.length() - 2, sb.length());
		}
		sb.append(")");

		return sb.toString();
	}
	
	/**
	 * Creates Label for a variable. 
	 * label include variable name and type
	 * @param variable
	 * @return
	 */
	protected String emitVariableLabel(Variable variable){
		StringBuilder sb = new StringBuilder();
		sb.append(variable.getName()).append(":").append(variable.getType().getName());
		return sb.toString();
	}

}
