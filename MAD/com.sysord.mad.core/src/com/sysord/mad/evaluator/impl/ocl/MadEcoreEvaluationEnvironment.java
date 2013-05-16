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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;

import com.sysord.mad.evaluator.impl.CurrentEvaluationContext;
import com.sysord.mad.evaluator.impl.ocl.customization.OCLCustomisationHelper;
import com.sysord.mad.evaluator.impl.ocl.customization.OCLCustomisationHelper.OCLOperationDefinition;

public class MadEcoreEvaluationEnvironment extends EcoreEvaluationEnvironment {

	public static boolean TRACE_ENABLED = false;

	/**
	 * some operations are overridden for track property or container access
	 * and update the EvaluationAnalyze. 
	 * when this flag is false this update doesn't occurs.
	 */
	protected boolean updateEvaluationAnalyze = true;
	
	
	/**
	 * Storage for custom operations definition
	 */
	protected static Map<EOperation, OCLOperationDefinition> customOperations = new HashMap<EOperation, OCLCustomisationHelper.OCLOperationDefinition>();
	
	public static void registerCustomOperations(Map<EOperation, OCLOperationDefinition> customOperationsDef){
		customOperations = customOperationsDef;		
	}
	
	/**
	 * set variable value
	 */
	@Override
	public void add(String name, Object value) {
		super.add(name, value);
	}

	/**
	 * return variable value
	 */
	@Override
	public Object getValueOf(String name) {
		return super.getValueOf(name);
	}


	public MadEcoreEvaluationEnvironment(EcoreEnvironmentFactory factory) {
		super(factory);
	}

	public MadEcoreEvaluationEnvironment(EcoreEnvironmentFactory factory, boolean updateEvalautionAnalyze) {
		super(factory);
		updateEvaluationAnalyze = updateEvalautionAnalyze;
	}

	
	public MadEcoreEvaluationEnvironment(EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent, boolean updateEvalautionAnalyze) {
		super(parent);
		updateEvaluationAnalyze = updateEvalautionAnalyze;
	}

		
	@Override
	public Object callOperation(EOperation operation, int opcode, Object source, Object[] args) throws IllegalArgumentException {
		Object result = null;
		if (operation.getEAnnotation(MadEcoreEnvironment.DEFAULT_CUSTOM_ENVIRONMENT_ID) != null) {			
        	//eval custom operation
			try {
				OCLOperationDefinition customOperationDef = customOperations.get(operation);
				if(customOperationDef.getMethod() != null){
					//eval custom operation declared by annotation
					result = evalCustomAnnotatedOperation(customOperationDef, source, args);        											
				}else{
					result = evalCustomOperation(operation, opcode, source, args);        								
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("Error during '" + operation.getName() + "' custom opearation evaluation." , e);
			}
		}else{
			//not a custom operation
            result = super.callOperation(operation, opcode, source, args);
            if(updateEvaluationAnalyze){
            	processCollectOperationCall(source, operation, args, result);
            }			
		}
		
		return result; 
	}

	

	@Override
	public Object navigateProperty(EStructuralFeature property,
			List<?> qualifiers, Object target) throws IllegalArgumentException {

		Object result = super.navigateProperty(property, qualifiers, target);
		if(updateEvaluationAnalyze){
			CurrentEvaluationContext.getEvaluationAnalyze().collectPropertyAccess(target, property, qualifiers, result);
		}
		if(TRACE_ENABLED) trace("Access property :" + property.getName() + " on "  + target.toString() + "  ==>  " + result);

		return result; 
	}

	@Override
	public Object navigateAssociationClass(EClassifier associationClass,
			EStructuralFeature navigationSource, Object target)
			throws IllegalArgumentException {

		Object result = super.navigateAssociationClass(associationClass, navigationSource, target);
		if(updateEvaluationAnalyze){
			CurrentEvaluationContext.getEvaluationAnalyze().collectAssociationClassAccess(target, navigationSource, result);
		}
		if(TRACE_ENABLED) trace("Access association class : by " + navigationSource.getName() + " to class " +  associationClass.getName() + " on "  + target.toString()  + "  ==>  " + result);

		return result; 
	}

	@Override
	public Object navigateOppositeProperty(EReference property, Object target)
			throws IllegalArgumentException {

		Object result =  super.navigateOppositeProperty(property, target);
		if(updateEvaluationAnalyze){
			CurrentEvaluationContext.getEvaluationAnalyze().collectOppositePropertyAccess(target, property, result);
		}
		if(TRACE_ENABLED) trace("Access opposite property : from " + property.getName() + " on "  + target.toString()  + "  ==>  " + result);

		return result;
	}
	
	

	
	protected void processCollectOperationCall(Object source, EOperation operation, Object[] args, Object result){
		CurrentEvaluationContext.getEvaluationAnalyze().collectOperationCall(source, operation, args, result);
		if(TRACE_ENABLED) trace("Operation call:" + operation.getName() + " ( arg...) on "  + source.toString() + "  ==>  " + result );		
	}

	protected void processCollectContainerAccess(Object source, EStructuralFeature containingFeature, Object result){
		CurrentEvaluationContext.getEvaluationAnalyze().collectContainerAccess(source, containingFeature, null, result);
		if(TRACE_ENABLED) trace("EContainer access : on "  + source.toString() + "  ==>  " + result );		
	}
	
	protected void processCollectPropertyAccess(Object source, EStructuralFeature property, List<?> qualifiers, Object result){
		CurrentEvaluationContext.getEvaluationAnalyze().collectPropertyAccess(source, property, qualifiers, result);
		if (TRACE_ENABLED)
			trace("Property access:" + property.getName() + " with qualifiers " + qualifiers == null ? "none"
					: qualifiers + " on " + source.toString() + "  ==>  " + result);
	}
	
	//-----------------------
	// CUSTOM EVALUATION
	//-----------------------
	
	protected Object evalCustomOperation(EOperation operation, int opcode, Object source, Object[] args) {
		String operationName = operation.getName();
		Object result = null;
		EObject eResult = null;

		EObject eSource = null;
		if(EObject.class.isAssignableFrom(source.getClass())){
			eSource = (EObject)source;
		}

		if(MadOclCustomizer.E_CONTAINER.equals(operationName)){
			//specific analyze for container access
			if(eSource != null){
				eResult = eSource.eContainer();
				if(eResult != null ){
					if(eSource.eContainingFeature() != null){
						processCollectContainerAccess(eSource, eSource.eContainingFeature(), eResult);
					}else{
						processCollectOperationCall(source, operation, args, eResult);
					}
				}				
			}
			return eResult;
			
		}else if(MadOclCustomizer.TOSTRING_OPERATION.equals(operationName)){
			result = source.toString();

		}else if(MadOclCustomizer.TYPENAME.equals(operationName)){
			//if EObject then return ECLass name else return java class name
			if(eSource != null){
				result = eSource.eClass().getName();
			}else{
				result = source.getClass().getSimpleName();
			}
			
		}else if(MadOclCustomizer.ROOT_CONTAINER.equals(operationName)){
			if(eSource != null){
				result = EcoreUtil.getRootContainer(eSource);
			}
		}else if(MadOclCustomizer.E_CONTENTS.equals(operationName)){
			if(eSource != null){
				result = eSource.eContents();
			}
		}else if(MadOclCustomizer.E_GET.equals(operationName)){
			if(eSource != null){
				if (args != null && args.length > 0) {
					EStructuralFeature feature = eSource.eClass().getEStructuralFeature(String.valueOf(args[0]));
					if (feature != null) {
						result = eSource.eGet(feature);
						processCollectPropertyAccess(eSource, feature, null, result);
						return result;
					}
				}
			}
		}else if(MadOclCustomizer.E_ALL_CONTENTS.equals(operationName)){
			if(eSource != null){
				final List<EObject> elements = new ArrayList<EObject>();
				final TreeIterator<EObject> iterator = eSource.eAllContents();
				final EClassifier filter;
				if (args != null && args.length > 0 && args[0] instanceof EClassifier) {
					filter = (EClassifier) args[0];
				} else {
					filter = null;
				}
				EObject currentElement;
				while (iterator.hasNext()) {
					currentElement = iterator.next();
					if (filter == null || filter.isInstance(currentElement)) {
						elements.add(currentElement);
					}
				}
				result = elements;
			}
		}else if(MadOclCustomizer.METAMODEL_CLASSIFIERS.equals(operationName)){
			if(eSource != null){
				final List<EObject> elements = new ArrayList<EObject>();
				final EPackage ePackage = eSource.eClass().getEPackage();
				final TreeIterator<EObject> iterator = ePackage.eAllContents();
				final EClassifier filter;
				if (args != null && args.length > 0 && args[0] instanceof EClassifier) {
					filter = (EClassifier) args[0];
				} else {
					filter = null;
				}
				EObject currentElement;
				while (iterator.hasNext()) {
					currentElement = iterator.next();
					if (currentElement instanceof EClassifier && (filter == null || filter.isInstance(currentElement))) {
						elements.add(currentElement);
					}
				}
				result = elements;
			}
		}
		
		//collect operation call for analyze 
		processCollectOperationCall(source, operation, args, result);
		return result;
	}
	

	/**
	 * Invoke operation method by reflection.
	 * 
	 * @param customOperationDef
	 * @param source
	 * @param args
	 * @return
	 */
	protected Object evalCustomAnnotatedOperation(OCLOperationDefinition customOperationDef, Object source, Object[] args) throws Exception{
		//arguments
		List<Object> invokationArgs = new ArrayList<Object>(Arrays.asList(args));
		//set context at head
		invokationArgs.add(0, source);
		return customOperationDef.getMethod().invoke(customOperationDef.getLibInstance(), invokationArgs.toArray());
	}

	
	protected void trace(String msg){
		System.out.println("*** TRACE:" + msg);

	}
	

}
