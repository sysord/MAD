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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.ecore.SetType;

import com.sysord.mad.type.TypeDescriptor;
import com.sysord.mad.type.TypeDescriptor.TYPE_CATEGORY;
import com.sysord.mad.type.TypeDescriptorImpl;

public class OCLTypeDescriptorUtil {
	
	public static TypeDescriptor oclTypeToTypeDescriptor(EClassifier oclType){
		
		//creates and fill the QueryAnalyze
		TYPE_CATEGORY resultCategory;
		Class<?> resultType = null;
		EClassifier resultEtype = null;
		TypeDescriptor itemAnalyze = null;
		
		if(OCLTypeUtil.OCL_STRING.equals(oclType)){
			resultCategory = TYPE_CATEGORY.STRING;
			resultType = oclType.getInstanceClass();
		
		}else if(OCLTypeUtil.OCL_BOOLEAN.equals(oclType)){
			resultCategory = TYPE_CATEGORY.BOOLEAN;
			resultType = oclType.getInstanceClass();			
		
		}else if(OCLTypeUtil.OCL_INTEGER.equals(oclType)){
			resultCategory = TYPE_CATEGORY.INTEGER;
			resultType = oclType.getInstanceClass();			
		
		}else if(OCLTypeUtil.OCL_REAL.equals(oclType)){
			resultCategory = TYPE_CATEGORY.DOUBLE;
			resultType = oclType.getInstanceClass();
			
		}else if(SequenceType.class.isAssignableFrom(oclType.getClass())){
			resultCategory = TYPE_CATEGORY.SEQUENCE;			
			resultType = oclType.getInstanceClass();
			itemAnalyze = oclTypeToTypeDescriptor(((SequenceType)oclType).getElementType());
			
		}else if(SetType.class.isAssignableFrom(oclType.getClass())){
			resultCategory = TYPE_CATEGORY.SET;			
			resultType = oclType.getInstanceClass();
			itemAnalyze = oclTypeToTypeDescriptor(((SetType)oclType).getElementType());

		}else if(OrderedSetType.class.isAssignableFrom(oclType.getClass())){
			resultCategory = TYPE_CATEGORY.ORDERED_SET;			
			resultType = oclType.getInstanceClass();
			itemAnalyze = oclTypeToTypeDescriptor(((OrderedSetType)oclType).getElementType());
			
		}else if(BagType.class.isAssignableFrom(oclType.getClass())){
			resultCategory = TYPE_CATEGORY.BAG;			
			resultType = oclType.getInstanceClass();
			itemAnalyze = oclTypeToTypeDescriptor(((BagType)oclType).getElementType());
			
		}else {
			resultCategory = TYPE_CATEGORY.OBJECT;			
			resultType = oclType.getInstanceClass();
			if(resultType != null && EObject.class.isAssignableFrom(resultType)){
				resultCategory = TYPE_CATEGORY.EOBJECT;							
				resultEtype = oclType;
			}
		}
		
		//doesn't find the instanceClass
		if(resultType == null){
			resultType = Object.class;
		}
		TypeDescriptor analyze = new TypeDescriptorImpl(resultCategory, resultType, resultEtype);
		analyze.setItemTypeDescriptor(itemAnalyze);
		return analyze;
	}
	
	
	public static EClassifier typeDescriptorToOclType(TypeDescriptor typeDescriptor){
		
		switch(typeDescriptor.getTypeCategory()){
		case EOBJECT:
			return typeDescriptor.getEType();			
		case NULL:
			return null;
		case STRING:
			return OCLTypeUtil.OCL_STRING;
		case BOOLEAN:
			return OCLTypeUtil.OCL_BOOLEAN;
		case LONG:
			return OCLTypeUtil.OCL_INTEGER;
		case INTEGER:
			return OCLTypeUtil.OCL_INTEGER;
		case FLOAT:
			return OCLTypeUtil.OCL_REAL;
		case DOUBLE:
			return OCLTypeUtil.OCL_REAL;
		case SEQUENCE:
			return OCLTypeUtil.OCL_SEQUENCE(typeDescriptorToOclType(typeDescriptor.getItemTypeDescriptor()));
		case SET:
			return OCLTypeUtil.OCL_SET(typeDescriptorToOclType(typeDescriptor.getItemTypeDescriptor()));
		case ORDERED_SET:
			return OCLTypeUtil.OCL_ORDERED_SET(typeDescriptorToOclType(typeDescriptor.getItemTypeDescriptor()));
		case BAG:
			return OCLTypeUtil.OCL_BAG(typeDescriptorToOclType(typeDescriptor.getItemTypeDescriptor()));
		default:
			return OCLTypeUtil.OCL_ANY;
		}
		
	}

}
