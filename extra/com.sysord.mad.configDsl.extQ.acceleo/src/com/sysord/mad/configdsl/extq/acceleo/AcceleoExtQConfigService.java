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
package com.sysord.mad.configdsl.extq.acceleo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.acceleo.internal.ide.ui.acceleowizardmodel.AcceleoPackage;
import org.eclipse.acceleo.model.mtl.MtlPackage;
import org.eclipse.acceleo.model.mtl.Query;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.xtext.naming.QualifiedName;

import com.sysord.acceleo.tools.AcceleoTools;
import com.sysord.acceleo.tools.module.emitter.AcceleoEmitter;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationService;

public class AcceleoExtQConfigService implements ExternalQueryConfigurationService {

	protected AcceleoEmitter acceleoEmitter;
	
	@Override
	public Collection<EObject> selectQueries(Collection<EObject> candidates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QualifiedName qualifiedName(EObject element) {
		if(Query.class.isAssignableFrom(element.getClass())){
			Query acceleoQuery = (Query) element;
			StringBuilder name = new StringBuilder();
			name.append(acceleoQuery.getName()).append("_");
			for(Variable var : acceleoQuery.getParameter()){
				name.append("__").append(var.getName()).append("_").append(var.getType().getName());
			}
			return QualifiedName.create(name.toString());
		}else{
			return null;
		}
	}

	@Override
	public String getQueryLabel(EObject element) {
		if(acceleoEmitter == null){
			acceleoEmitter = AcceleoTools.getEmitter();
		}
		return acceleoEmitter.emitElementLabel(element);
	}

	@Override
	public String getQueryCallExpr(EObject element) {
		String queryLabel = getQueryLabel(element);
		return queryLabel.replaceFirst("\\(.*\\)", "()");
	}

	@Override
	public List<EClass> getQueriesEClass() {
		List<EClass> queriesEClass = new ArrayList<EClass>();		
		queriesEClass.add(MtlPackage.Literals.QUERY);
		return queriesEClass;
	}


}
