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

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.TypeResolver;

import com.sysord.mad.evaluator.impl.ocl.customization.OCLCustomisationHelper;
import com.sysord.mad.evaluator.impl.ocl.customization.OCLCustomisationHelper.OCLOperationDefinition;
import com.sysord.mad.evaluator.impl.ocl.customization.OCLCustomisationHelper.OCLTypedElementDefinition;
import com.sysord.mad.evaluator.impl.ocl.customization.OCLCustomizationException;

public class MadOclCustomizer {
	
	//---------------------------------
	// Mad OCL additional operations
	//---------------------------------
	
	public static final String TOSTRING_OPERATION = "toString";
	public static final String TYPENAME = "typeName";
	
	//Ecore util operations
	public static final String ROOT_CONTAINER = "rootContainer";
	public static final String E_CONTAINER = "eContainer";
	
	//EObject operations
	public static final String E_CONTENTS = "eContents";
	public static final String E_ALL_CONTENTS = "eAllContents";
	public static final String METAMODEL_CLASSIFIERS = "metamodelClassifiers";
	public static final String E_GET = "eGet";

			
	/**
	 * Mad OCL additional operations definitions 
	 */
	public static final OCLOperationDefinition[] CUSTOM_OPERATIONS_DEFINITIONS = new OCLOperationDefinition[]{
		oclOperation(OCLTypeUtil.OCL_ANY, TOSTRING_OPERATION, OCLTypeUtil.OCL_STRING),
		oclOperation(OCLTypeUtil.OCL_ANY, ROOT_CONTAINER, OCLTypeUtil.OCL_ANY),
		oclOperation(OCLTypeUtil.OCL_ANY, E_CONTAINER, OCLTypeUtil.OCL_ANY),
		oclOperation(OCLTypeUtil.OCL_ANY, TYPENAME, OCLTypeUtil.OCL_STRING),
		oclOperation(OCLTypeUtil.OCL_ANY, E_CONTENTS, OCLTypeUtil.OCL_SEQUENCE),
		oclOperation(OCLTypeUtil.OCL_ANY, E_ALL_CONTENTS, OCLTypeUtil.OCL_SEQUENCE,
				OCLCustomisationHelper.createOCLTypedElementDefinition("filter", OCLTypeUtil.OCL_ANY)),
		oclOperation(OCLTypeUtil.OCL_ANY, METAMODEL_CLASSIFIERS, OCLTypeUtil.OCL_SEQUENCE,
				OCLCustomisationHelper.createOCLTypedElementDefinition("filter", OCLTypeUtil.OCL_ANY)),
		oclOperation(OCLTypeUtil.OCL_ANY, E_GET, OCLTypeUtil.OCL_ANY,
						OCLCustomisationHelper.createOCLTypedElementDefinition("feature", OCLTypeUtil.OCL_STRING)),
	};



	
	/**
	 * Storage for Custom Libraries
	 */
	protected static Set<Object> oclCustomLibraries = new LinkedHashSet<Object>();

	/**
	 * remove all registered oclCustomLibraries.
	 */
	public static void removeAllCustomLibraries(){
		oclCustomLibraries.clear();
	}
	
	/**
	 * registers an ocl custom library
	 * @param oclCustomLibrary
	 */
	public static void registerCustomLibray(Object oclCustomLibrary){
		oclCustomLibraries.add(oclCustomLibrary);
	}
	
	/**
	 * Create and return a Map containing all custom operations.
	 * @param environmentId
	 * @param typeResolver the environment type resolver
	 * @return
	 */
	public static Map<EOperation, OCLOperationDefinition> getCustomOperations(String environmentId, TypeResolver<EClassifier, ?, ?> typeResolver){
		Map<EOperation, OCLOperationDefinition> customOperations = new HashMap<EOperation, OCLCustomisationHelper.OCLOperationDefinition>();
		//add defined custom operations
		for(OCLOperationDefinition operationDefinition : CUSTOM_OPERATIONS_DEFINITIONS){
			EOperation oclOperation = OCLCustomisationHelper.createEOperationFromDefinition(operationDefinition, environmentId, typeResolver);
			customOperations.put(oclOperation, operationDefinition);
		}
		
		try {
			for(Object oclCustomLibray : oclCustomLibraries){
				//extract custom operations defined by annotation
				OCLOperationDefinition[] annotatedOperationsDefinition = OCLCustomisationHelper.createOCLOperationsDefinition(oclCustomLibray, typeResolver);
				//add custom operations 
				for(OCLOperationDefinition operationDefinition : annotatedOperationsDefinition){
						EOperation oclOperation = OCLCustomisationHelper.createEOperationFromDefinition(operationDefinition, environmentId, typeResolver);
						customOperations.put(oclOperation, operationDefinition);
				}
			}
		} catch (OCLCustomizationException e) {
			e.printStackTrace();
		}
		
		return customOperations; 
	}

		
	/**
	 * Utility method for creating an {@link OCLOperationDefinition}
	 * @param ownerType
	 * @param name
	 * @param returnType
	 * @param parametersDefinition
	 * @return
	 */
	protected static OCLOperationDefinition oclOperation(EClassifier ownerType, String name, EClassifier returnType, OCLTypedElementDefinition...parametersDefinition){
		return OCLCustomisationHelper.createOCLOperationDefinition(ownerType, name, returnType, parametersDefinition);
	}

	
	/**
	 * Utility method for creating an {@link OCLTypedElementDefinition}
	 * @param name
	 * @param type
	 * @return
	 */
	protected static OCLTypedElementDefinition oclTypedElement(String name, EClassifier type){
		return OCLCustomisationHelper.createOCLTypedElementDefinition(name, type);
	}

}
