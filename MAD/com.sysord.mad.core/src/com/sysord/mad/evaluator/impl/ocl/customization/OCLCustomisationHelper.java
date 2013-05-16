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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.expressions.CollectionKind;

import com.sysord.mad.evaluator.impl.ocl.OCLTypeUtil;

/**
 * Utility functions for create custom OCL operations description
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class OCLCustomisationHelper {
			
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

		Object libInstance;
		Method method;
		
		public OCLOperationDefinition(EClassifier ownerType, String name, EClassifier returntype, 
										Object libInstance, Method method, 
										 OCLTypedElementDefinition...parametersDefinition) {
			super();
			this.ownerType = ownerType;
			operationDefinition = new OCLTypedElementDefinition(name, returntype);
			this.libInstance = libInstance;
			this.method = method;
			parameters = parametersDefinition;
		}				
		public EClassifier getOwnerType(){return ownerType;}
		public String getName(){return operationDefinition.name;}
		public EClassifier getReturnType(){return operationDefinition.type;}
		public OCLTypedElementDefinition[] getParameters(){return parameters;}		
		public Method getMethod() {return method;}
		public Object getLibInstance() {return libInstance;}
	}
	
	public static OCLTypedElementDefinition createOCLTypedElementDefinition(String name, EClassifier type){
		return new OCLTypedElementDefinition(name, type);
	}
	public static OCLOperationDefinition createOCLOperationDefinition(EClassifier ownerType, String name, EClassifier returnType, OCLTypedElementDefinition...parametersDefinition){
		return new OCLOperationDefinition(ownerType, name, returnType, null, null, parametersDefinition);
	}
	public static OCLOperationDefinition createOCLOperationDefinition(EClassifier ownerType, String name, EClassifier returnType, 
																		Object libInstance, Method method, 
																		OCLTypedElementDefinition...parametersDefinition){
		return new OCLOperationDefinition(ownerType, name, returnType, libInstance, method, parametersDefinition);
	}
	
	
	
	/**
	 * Create OCL operations definitions by customOclOperationLibrary class introspection
	 * @param customOclOperationLibrary
	 * @return
	 * @throws OCLCustomizationException 
	 */
	public static <T> OCLOperationDefinition[] createOCLOperationsDefinition(T libInstance, TypeResolver<EClassifier, ?, ?> typeResolver) throws OCLCustomizationException{
		try {
			List<OCLOperationDefinition> operationsDefinition = new ArrayList<OCLCustomisationHelper.OCLOperationDefinition>();
			
			//if is an AbstractOCLCustomLibrary: retrieve custom operation set to register.
			if(AbstractOclCustomLibrary.class.isAssignableFrom(libInstance.getClass())){
				operationsDefinition.addAll(((AbstractOclCustomLibrary)libInstance).getCustomOperationsToRegister());
			}
			
			for(Method method : libInstance.getClass().getDeclaredMethods()){
				//select annotated method
				OCLCustomOperation annot = method.getAnnotation(OCLCustomOperation.class);
				if(annot != null){
					operationsDefinition.add(createOCLOperationsDefinition(method, libInstance, typeResolver));
				}
			}
			return operationsDefinition.toArray(new OCLOperationDefinition[0]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new OCLCustomizationException("Error during custom OCL operation creation from annotated class " + libInstance.getClass().getName());
		}
	}
	
	
	/**
	 * Create OCL operation by customOclOperationLibrary class introspection
	 * @param customOclOperationLibrary
	 * @return
	 * @throws OCLCustomizationException 
	 */
	protected static OCLOperationDefinition createOCLOperationsDefinition(Method method, Object libInstance, TypeResolver<EClassifier, ?, ?> typeResolver) throws OCLCustomizationException{
		OCLCustomOperation annot = method.getAnnotation(OCLCustomOperation.class);
		//name defined by the annotation or method name
		String operationName = ("".equals(annot.name()) ? method.getName() : annot.name());
		
		//return type defined by the annotation or ocl type from the method return type.
		EClassifier returnType = 
				(annot.returns().ignore() ? OCLTypeUtil.classToOclType(method.getReturnType()) 
				 : typeFromOCLTypeDef(annot.returns(), typeResolver));
		
		if(returnType == null){
			//TODO: log warning
			returnType = OCLTypeUtil.OCL_ANY;
		}

		//context type is the first parameter
		EClassifier contextType = null;
		List<OCLTypedElementDefinition> argumentsDefinition = createArgumentsDefinition(method, typeResolver);
		if(argumentsDefinition.size() == 0){
			//TODO: log warning
			contextType = OCLTypeUtil.OCL_ANY;				
		}else{
			//remove the context OCLTypedElementDefinition and get its Type
			contextType = argumentsDefinition.remove(0).type;
		}						
		return createOCLOperationDefinition(contextType, operationName, returnType, libInstance, method, argumentsDefinition.toArray(new OCLTypedElementDefinition[0]));
	}
	
	
	/**
	 * Create arguments definition
	 * @param method
	 * @return
	 * @throws OCLCustomizationException 
	 */
	protected static List<OCLTypedElementDefinition> createArgumentsDefinition(Method method, TypeResolver<EClassifier, ?, ?> typeResolver) throws OCLCustomizationException{
		List<OCLTypedElementDefinition> argumentsDefinition = new ArrayList<OCLTypedElementDefinition>();
		Annotation[][] argsAnnotations = method.getParameterAnnotations();
		Class<?>[] argsType = method.getParameterTypes();
		for (int iArg = 0; iArg < argsType.length; iArg++) {
			EClassifier argOCLType = null;
			if (argsAnnotations[iArg].length > 0) {
				// exists setted annotation
				Annotation[] argAnnotations = argsAnnotations[iArg];
				for (int iAnnot = 0; iAnnot < argAnnotations.length; iAnnot++) {
					if (argAnnotations[iAnnot] instanceof OCLTypeDef) {						
						argOCLType = typeFromOCLTypeDef((OCLTypeDef) argAnnotations[iAnnot], typeResolver);
					}
				}
			} else {
				// no annotation use arg type
				argOCLType = OCLTypeUtil.classToOclType(argsType[iArg]);
			}

			if (argOCLType == null) {
				// TODO: log warning
				argOCLType = OCLTypeUtil.OCL_ANY;
			}
			argumentsDefinition.add(createOCLTypedElementDefinition("arg" + iArg, argOCLType));
		}
		
		return argumentsDefinition;
	}
	
	/**
	 * Discovers and return the EClassifier type described by the {@link OCLTypeDef} annotation
	 * @param annotOclTypeDef
	 * @return
	 * @throws OCLCustomizationException 
	 */
	protected static EClassifier typeFromOCLTypeDef(OCLTypeDef annotOclTypeDef, TypeResolver<EClassifier, ?, ?> typeResolver) throws OCLCustomizationException{
		EClassifier type = null;
		EClassifier itemType = typeFromPackageAndId(annotOclTypeDef.ePackage(), annotOclTypeDef.eClassifierJavaInterface().getSimpleName());
		switch (annotOclTypeDef.containerType()) {
		case OCL_SEQUENCE:
			//type = OCLTypeUtil.createSequence(itemType);
			type = (EClassifier) typeResolver.resolveCollectionType(CollectionKind.SEQUENCE_LITERAL, itemType);			
			break;
		case OCL_SET:
			//type = OCLTypeUtil.createSet(itemType);
			type = (EClassifier) typeResolver.resolveCollectionType(CollectionKind.SET_LITERAL, itemType);			
			break;
		case OCL_ORDEREDSET:
			//type = OCLTypeUtil.createOrderedSet(itemType);
			type = (EClassifier) typeResolver.resolveCollectionType(CollectionKind.ORDERED_SET_LITERAL, itemType);			
			break;
		case OCL_BAG:
			//type = OCLTypeUtil.createBag(itemType);				
			type = (EClassifier) typeResolver.resolveCollectionType(CollectionKind.BAG_LITERAL, itemType);			
			break;
		default:
			type = itemType;
		}
		return type;
	}
	
	/**
	 * retrieve EClassifier using EPackage and EClassifierName
	 * @param ePackage
	 * @param EClassifierId
	 * @return
	 * @throws OCLCustomizationException 
	 * @throws NoSuchMethodException 
	 */
	protected static EClassifier typeFromPackageAndId(Class<? extends EPackage> ePackage, String eClassifierName) throws OCLCustomizationException{
		try {
			Field fld = ePackage.getField("eINSTANCE");
			Object ePackageInstance = fld.get(ePackage);
			Method methodGetEClassifier = ePackage.getMethod("getEClassifier", String.class);
			return (EClassifier) methodGetEClassifier.invoke(ePackageInstance, eClassifierName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new OCLCustomizationException("EClassifier " + eClassifierName +" from package " + ePackage.getName() + " cannot be found.", e);
		}
	}
	
	
    /**
     * Create an EOperation 
     * @return
     */
    public static EOperation createEOperationFromDefinition(OCLOperationDefinition operationDefinition, String environmentID, TypeResolver<EClassifier, ?, ?> typeResolver){
    	
    	EOperation operation = EcoreFactory.eINSTANCE.createEOperation();
    	//operation name
    	operation.setName(operationDefinition.getName());
        //return type
    	operation.setEType(typeResolver.resolve(operationDefinition.getReturnType()));
        
    	//add parameters definition
    	for(OCLTypedElementDefinition parmDefinition : operationDefinition.getParameters()){
        	EParameter parm = EcoreFactory.eINSTANCE.createEParameter();
            parm.setName(parmDefinition.getName());
            parm.setEType(typeResolver.resolve(parmDefinition.getType()));
            operation.getEParameters().add(parm);    		
    	}
    	
        // annotate it so that we will recognize it in the evaluation environment
        EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        annotation.setSource(environmentID);
        operation.getEAnnotations().add(annotation);

        return operation;
    }
	

}
