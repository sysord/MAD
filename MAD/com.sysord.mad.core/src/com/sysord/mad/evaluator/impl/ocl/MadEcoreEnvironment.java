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
package com.sysord.mad.evaluator.impl.ocl;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;

import com.sysord.mad.evaluator.impl.ocl.customization.OCLCustomisationHelper.OCLOperationDefinition;

/**
 * Custom environment for add new EOperation to OCL
 *
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class MadEcoreEnvironment extends EcoreEnvironment {

	public static final String DEFAULT_CUSTOM_ENVIRONMENT_ID = "MadCustomEnvironment";
	
	
	public MadEcoreEnvironment(MadEcoreEnvironment parent) {
		super(parent);
		//defineCustomOperations();
	}
	
	
	public MadEcoreEnvironment(EcoreEnvironmentFactory fac, Resource resource) {
		super(fac, resource);
		defineCustomOperations();
	}

	
	protected String getCustomEnvironmentId(){
		return DEFAULT_CUSTOM_ENVIRONMENT_ID;
	}

	
	/**
	 * Define and register custom operations
	 */
    protected void defineCustomOperations() {
    	Map<EOperation, OCLOperationDefinition> customOperationsDef = MadOclCustomizer.getCustomOperations(getCustomEnvironmentId(), getTypeResolver());
    	for(Entry<EOperation, OCLOperationDefinition> operationDefEntry : customOperationsDef.entrySet()){
    		EOperation oclOperation = operationDefEntry.getKey();
            //add operation to owner type (with owner type resolution)
            addHelperOperation(getTypeResolver().resolve(operationDefEntry.getValue().getOwnerType()), oclOperation);
    	}
    	MadEcoreEvaluationEnvironment.registerCustomOperations(customOperationsDef);
    }
	

}
