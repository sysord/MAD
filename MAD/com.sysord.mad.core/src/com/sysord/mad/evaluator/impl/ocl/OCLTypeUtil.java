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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.types.OCLStandardLibrary;

public class OCLTypeUtil {

	public static final OCLStandardLibrary<EClassifier> OCL_STANDARD_LIBRAY = OCLStandardLibraryImpl.INSTANCE;
	
	public static final EClassifier OCL_T = OCL_STANDARD_LIBRAY.getT();
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

	protected static Map<String, EClassifier> registeredTypes = new HashMap<String, EClassifier>();
	
	public static EClassifier oclType(Object object){
		if(object == null){
			return null;
		}
		if(EObject.class.isAssignableFrom(object.getClass())){
			return ((EObject)object).eClass();
		}
		//Primitive types
		if(object instanceof String){
			return OCLTypeUtil.OCL_STRING;
		}
		if(object instanceof Integer){
			return OCLTypeUtil.OCL_INTEGER;
		}
		if(object instanceof Float || object instanceof Double){
			return OCLTypeUtil.OCL_REAL;
		}
		if(object instanceof Boolean){
			return OCLTypeUtil.OCL_BOOLEAN;
		}
		
		//Collection
		if(object instanceof List){
			return OCLTypeUtil.OCL_SEQUENCE;			
		}
		
		return null; //argument.getClass().getSimpleName();
	}
	
	public static EClassifier classToOclType(Class<?> basicJavaType){
		if(Object.class.equals(basicJavaType)){
			return OCL_ANY;
		}else if(String.class.equals(basicJavaType)){
			return OCL_STRING;
		}else if(Boolean.class.equals(basicJavaType)){
			return OCL_BOOLEAN;
		}else if(Long.class.equals(basicJavaType) || Integer.class.equals(basicJavaType)){
			return OCL_INTEGER;
		}else if(Float.class.equals(basicJavaType) || Double.class.equals(basicJavaType)){
			return OCL_REAL;
		}else{
			return null;
		}		
	}

	public static Class<?> oclTypeToClass(EClassifier oclType){
		if(oclType.equals(OCL_ANY)){
			return Object.class;
		}else if(oclType.equals(OCL_STRING)){
			return String.class;
		}else if(oclType.equals(OCL_BOOLEAN)){
			return Boolean.class;
		}else if(oclType.equals(OCL_INTEGER)){
			return Integer.class;
		}else if(oclType.equals(OCL_REAL)){
			return Double.class;
		}else{
			return oclType.getInstanceClass();
		}		
	}
	
	public static EClassifier OCL_SEQUENCE(){
		return OCL_SEQUENCE(OCL_T);
	}
	
	public static EClassifier OCL_SEQUENCE(EClassifier elementType){
		String key = org.eclipse.ocl.ecore.EcorePackage.Literals.SEQUENCE_TYPE.getName() + "_" + elementType.getName();
		SequenceType sequenceType = (SequenceType) registeredTypes.get(key);
		if(sequenceType == null){
			sequenceType = EcoreFactory.eINSTANCE.createSequenceType();
			sequenceType.setElementType(elementType);
			registeredTypes.put(key, sequenceType);
		}
		return sequenceType;
	}

	public static EClassifier OCL_SET(){
		return OCL_SET(OCL_T);
	}

	public static EClassifier OCL_SET(EClassifier elementType){
		String key = org.eclipse.ocl.ecore.EcorePackage.Literals.SET_TYPE.getName() + "_" + elementType.getName();
		SetType setType = (SetType) registeredTypes.get(key);
		if(setType == null){
			setType = EcoreFactory.eINSTANCE.createSetType();
			setType.setElementType(elementType);			
			registeredTypes.put(key, setType);
		}
		return setType;
	}

	public static EClassifier OCL_ORDERED_SET(){
		return OCL_ORDERED_SET(OCL_T);
	}

	public static EClassifier OCL_ORDERED_SET(EClassifier elementType){
		String key = org.eclipse.ocl.ecore.EcorePackage.Literals.ORDERED_SET_TYPE.getName() + "_" + elementType.getName();
		OrderedSetType orderedSetType = (OrderedSetType) registeredTypes.get(key);
		if(orderedSetType == null){
			orderedSetType = EcoreFactory.eINSTANCE.createOrderedSetType();
			orderedSetType.setElementType(elementType);
			registeredTypes.put(key, orderedSetType);
		}
		return orderedSetType;
	}

	public static EClassifier OCL_BAG(){
		return OCL_BAG(OCL_T);
	}

	public static EClassifier OCL_BAG(EClassifier elementType){
		String key = org.eclipse.ocl.ecore.EcorePackage.Literals.BAG_TYPE.getName() + "_" + elementType.getName();
		BagType bagType =  (org.eclipse.ocl.ecore.BagType) registeredTypes.get(key);
		if(bagType == null){
			bagType = EcoreFactory.eINSTANCE.createBagType();
			bagType.setElementType(elementType);
			registeredTypes.put(key, bagType);
		}
		return bagType;
	}
	

}
