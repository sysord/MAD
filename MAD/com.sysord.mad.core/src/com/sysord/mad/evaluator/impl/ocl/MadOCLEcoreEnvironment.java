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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;

import com.sysord.mad.evaluator.impl.ocl.OCLCustomisationHelper.OCLOperationDefinition;
import com.sysord.mad.evaluator.impl.ocl.OCLCustomisationHelper.OCLTypedElementDefinition;

/**
 * Custom environment for add new EOperation to OCL
 *
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class MadOCLEcoreEnvironment extends EcoreEnvironment {

	public static final String DEFAULT_CUSTOM_ENVIRONMENT_ID = "MadCustomEnvironment";

	
	protected List<EOperation> customOperations = new ArrayList<EOperation>();

	
	public MadOCLEcoreEnvironment(EcoreEnvironmentFactory fac, Resource resource) {
		super(fac, resource);
		defineCustomOperations();
	}

	public MadOCLEcoreEnvironment(MadOCLEcoreEnvironment parent) {
		super(parent);
		// this constructor is used to initialize child environments
		customOperations.addAll(customOperations);
	}
	
	protected String getCustomEnvironmentId(){
		return DEFAULT_CUSTOM_ENVIRONMENT_ID;
	}

	/**
	 * Create simple operation by name
	 */
    protected void defineCustomOperations() {
    	for(OCLOperationDefinition customOperationDefinition : MadEcoreEvaluationEnvironment.CUSTOM_OPERATIONS_DEFINITIONS){
        	customOperations.add(createOperationFromDefinition(customOperationDefinition));    		
    	}
    }

    /**
     * Create an operation for OCLAny by name 
     * @param operationName
     * @return
     */
    protected EOperation createOperationFromDefinition(OCLOperationDefinition operationDefinition ){
    	
    	EOperation operation = EcoreFactory.eINSTANCE.createEOperation();
    	//operation name
    	operation.setName(operationDefinition.getName());
        //return type
    	operation.setEType(operationDefinition.getReturnType());
        
    	//add parameters definition
    	for(OCLTypedElementDefinition parmDefinition : operationDefinition.getParameters()){
        	EParameter parm = EcoreFactory.eINSTANCE.createEParameter();
            parm.setName(parmDefinition.getName());
            parm.setEType(parmDefinition.getType());
            operation.getEParameters().add(parm);    		
    	}
    	
        // annotate it so that we will recognize it in the evaluation environment
        EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        annotation.setSource(getCustomEnvironmentId());
        operation.getEAnnotations().add(annotation);

        //add operation to owner type
        addHelperOperation(operationDefinition.getOwnerType(), operation);
        return operation;
    }

}
