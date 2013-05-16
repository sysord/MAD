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
package com.sysord.mad.evaluator.impl.ocl.customization;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import com.sysord.mad.evaluator.impl.ocl.OCLTypeUtil;
import com.sysord.mad.evaluator.impl.ocl.customization.OCLCustomisationHelper.OCLOperationDefinition;
import com.sysord.mad.evaluator.impl.ocl.customization.OCLCustomisationHelper.OCLTypedElementDefinition;

public abstract class AbstractOclCustomLibrary {

	protected static final EClassifier OCL_ANY = OCLTypeUtil.OCL_ANY;
	protected static final EClassifier OCL_STRING = OCLTypeUtil.OCL_STRING;
	protected static final EClassifier OCL_INTEGER = OCLTypeUtil.OCL_INTEGER;
	protected static final EClassifier OCL_REAL = OCLTypeUtil.OCL_REAL;
	protected static final EClassifier OCL_BOOLEAN = OCLTypeUtil.OCL_BOOLEAN;

	protected EClassifier createSequence(EClassifier elementType){
		return OCLTypeUtil.OCL_SEQUENCE(elementType);
	}

	protected EClassifier createSet(EClassifier elementType){
		return OCLTypeUtil.OCL_SET(elementType);
	}

	protected EClassifier createOrderedSet(EClassifier elementType){
		return OCLTypeUtil.OCL_ORDERED_SET(elementType);
	}

	protected EClassifier createBag(EClassifier elementType){
		return OCLTypeUtil.OCL_BAG(elementType);
	}
		
	protected List<OCLOperationDefinition> customOperationsToRegister = new ArrayList<OCLCustomisationHelper.OCLOperationDefinition>();

	
	public AbstractOclCustomLibrary() {
		super();
		_registerCustomOCLOperations();
	}

	public List<OCLOperationDefinition> getCustomOperationsToRegister() {
		return customOperationsToRegister;
	}

	protected abstract void _registerCustomOCLOperations();
	
	protected void registerOclCustomOperation(EClassifier ownerType, String name, EClassifier returnType, EClassifier...argumentsType){
		registerOclCustomOperation(ownerType, name, returnType, null, argumentsType);
	}
	
	protected void registerOclCustomOperation(EClassifier ownerType, String name, EClassifier returnType, Method method, EClassifier...argumentsType){
		List<OCLTypedElementDefinition> parametersDefinition = new ArrayList<OCLTypedElementDefinition>();
		for(int iArg = 0; iArg < argumentsType.length; iArg++){
			parametersDefinition.add(OCLCustomisationHelper.createOCLTypedElementDefinition("arg" + iArg, argumentsType[iArg]));
		}
		
		if(method == null){
			method = retrieveOperationMethod(ownerType, name, returnType, argumentsType);
		}
		
		OCLOperationDefinition operationDef = OCLCustomisationHelper.createOCLOperationDefinition(ownerType, name, returnType, 
														this, method, parametersDefinition.toArray(new OCLTypedElementDefinition[0]));
		customOperationsToRegister.add(operationDef);
	}
	
	protected Method retrieveOperationMethod(EClassifier ownerType, String name, EClassifier returnType, EClassifier...argumentsType){
		List<Class<?>> argsType = new ArrayList<Class<?>>();
		argsType.add(OCLTypeUtil.oclTypeToClass(ownerType)); 
		for(EClassifier oclArgType : argumentsType){
			argsType.add(OCLTypeUtil.oclTypeToClass(oclArgType));
		}
		try {
			return this.getClass().getMethod(name, argsType.toArray(new Class<?>[0]));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
