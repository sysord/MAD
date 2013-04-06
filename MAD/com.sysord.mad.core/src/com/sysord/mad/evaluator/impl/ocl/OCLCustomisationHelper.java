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

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.types.OCLStandardLibrary;

/**
 * Utility functions for create custom OCL operations description
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class OCLCustomisationHelper {

	public static final OCLStandardLibrary<EClassifier> OCL_STANDARD_LIBRAY = OCLStandardLibraryImpl.INSTANCE;
	
	public static final EClassifier OCL_ANY = OCL_STANDARD_LIBRAY.getOclAny();
	public static final EClassifier OCL_STRING = OCL_STANDARD_LIBRAY.getString();
	public static final EClassifier OCL_INTEGER = OCL_STANDARD_LIBRAY.getInteger();
	public static final EClassifier OCL_REAL = OCL_STANDARD_LIBRAY.getReal();
	public static final EClassifier OCL_BOOLEAN = OCL_STANDARD_LIBRAY.getBoolean();
	
	public static final EClassifier OCL_COLLECTION = OCL_STANDARD_LIBRAY.getCollection();
	public static final EClassifier OCL_SEQUENCE = OCL_STANDARD_LIBRAY.getSequence();
	public static final EClassifier OCL_SET = OCL_STANDARD_LIBRAY.getSet();
	public static final EClassifier OCL_ORDEREDSET = OCL_STANDARD_LIBRAY.getOrderedSet();
	public static final EClassifier OCL_BAG = OCL_STANDARD_LIBRAY.getBag();

	public static final EClassifier ECORE_EOBJECT = EcorePackage.Literals.EOBJECT;
	
	
	public static EClassifier oclType(Object object){
		if(object == null){
			return null;
		}
		if(EObject.class.isAssignableFrom(object.getClass())){
			return ((EObject)object).eClass();
		}
		//Primitive types
		if(object instanceof String){
			return OCLCustomisationHelper.OCL_STRING;
		}
		if(object instanceof Integer){
			return OCLCustomisationHelper.OCL_INTEGER;
		}
		if(object instanceof Float || object instanceof Double){
			return OCLCustomisationHelper.OCL_REAL;
		}
		if(object instanceof Boolean){
			return OCLCustomisationHelper.OCL_BOOLEAN;
		}
		
		//Collection
		if(object instanceof List){
			return OCLCustomisationHelper.OCL_SEQUENCE;			
		}
		
		return null; //argument.getClass().getSimpleName();
	}
	
	
	public static class OCLTypedElementDefinition{
		String name;
		EClassifier type;
		public OCLTypedElementDefinition(String name, EClassifier type) {
			super();
			this.name = name;
			this.type = type;
		}
		public String getName() {return name;}
		public EClassifier getType() {return type;}
		
	}
	
	public static class OCLOperationDefinition{
		EClassifier ownerType;
		OCLTypedElementDefinition operationDefinition;
		OCLTypedElementDefinition[] parameters;
		
		public OCLOperationDefinition(EClassifier ownerType, String name, EClassifier returntype, OCLTypedElementDefinition...parametersDefinition) {
			super();
			this.ownerType = ownerType;
			operationDefinition = new OCLTypedElementDefinition(name, returntype);
			parameters = parametersDefinition;
		}				
		public EClassifier getOwnerType(){return ownerType;}
		public String getName(){return operationDefinition.name;}
		public EClassifier getReturnType(){return operationDefinition.type;}
		public OCLTypedElementDefinition[] getParameters(){return parameters;}		
	}
	
	public static OCLTypedElementDefinition createOCLTypedElementDefinition(String name, EClassifier type){
		return new OCLTypedElementDefinition(name, type);
	}
	public static OCLOperationDefinition createOCLOperationDefinition(EClassifier ownerType, String name, EClassifier returnType, OCLTypedElementDefinition...parametersDefinition){
		return new OCLOperationDefinition(ownerType, name, returnType, parametersDefinition);
	}

}
