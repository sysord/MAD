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
package com.sysord.mad.configDsl.externalQueryManager;



import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import com.sysord.mad.configuration.extension.ExternalQueryConfigurationService;

public class ExtQManagerQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	/**
	 * Request qualified name to all external Query service
	 * when a service provide a qualified name, it is returned.
	 */
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		for(ExternalQueryConfigurationService extQConfigService : ExtQManagerManagerActivator.getDefault().getExtQConfigServices()){
			QualifiedName qn = extQConfigService.qualifiedName(obj);
			if(qn != null){
				return qn;
			}
		}
		return null;
	}
	
}
