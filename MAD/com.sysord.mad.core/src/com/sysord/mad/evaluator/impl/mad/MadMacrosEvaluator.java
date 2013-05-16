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
package com.sysord.mad.evaluator.impl.mad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sysord.emf.tools.EmfToolsFacade;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.QueryEvaluatorException;

public class MadMacrosEvaluator implements MadMacros{

	/**
	 * All available Macros
	 */
	protected static final List<String> MACROS_CATALOG = Arrays.asList(MACROS_NAMES);
	
	/**
	 * future for obtaining result from the runnable MadCommand
	 */
	protected class MadFuture{
		public Object result;
		public QueryEvaluatorException exception;		
	}
	
	public boolean isMadMacro(String macro){
		return MACROS_CATALOG.contains(macro);
	}
	
	public EObject RunMadMacros(EObject contextObject, String macro, List<Object> macroArguments, QueryEvaluationContext evaluationContext) throws QueryEvaluatorException{
	
		if(CREATE_MACRO.equals(macro)){
			return run_CreateMacro(contextObject, macroArguments);
		}else if(UPDATE_FEATURE_MACRO.equals(macro)){
			run_UpdateFeatureMacro(contextObject, macroArguments);
		}else if(DELETE_MACRO.equals(macro)){
			run_DeleteMacro(contextObject);
		}else if(REMOVE_MACRO.equals(macro)){
			run_RemoveMacro(contextObject);			
		}else if(MOVE_UP.equals(macro)){
			run_MoveUpMacro(contextObject);			
		}else if(MOVE_DOWN.equals(macro)){
			run_MoveDownMacro(contextObject);			
		}
		
		return null;
	}



	/**
	 * Delete object and clear all its references.
	 * EcoreUtil.delete(contextObject, recursive) do the job.
	 * @param contextObject
	 */
	protected void run_DeleteMacro(final EObject contextObject) throws QueryEvaluatorException{
		Runnable baseCommand = new Runnable() {			
			@Override
			public void run() {
				EcoreUtil.delete(contextObject, true);
			}
		};
		executeAsTransactionalCommand(contextObject, baseCommand);
	}

	
	/**
	 * Remove the context object from its container
	 * EcoreUtil.remove(contextObject) do the job.
	 * 
	 * Action: remove contextObject from its container
	 * @param contextObject
	 */
	protected void run_RemoveMacro(final EObject contextObject) throws QueryEvaluatorException{
		Runnable baseCommand = new Runnable() {			
			@Override
			public void run() {
				EcoreUtil.remove(contextObject);
			}
		};		
		executeAsTransactionalCommand(contextObject, baseCommand);
	}
	
	/**
	 * Create a new EObject:
	 * - contextObject must be the container
	 * - arguments:
	 * 		- the containing feature name : String
	 * 		- the element to create EClass name (optional if not defined assume that type is the containing feature reference type)
	 * 		- the container object :EObject (optional if not defined assume that container object is the contextObject)
	 * @param contextObject
	 * @return the created element
	 */
	protected EObject run_CreateMacro(final EObject contextObject, final List<Object> macroArguments) throws QueryEvaluatorException{
		
		//Extract typename: if argument is an EClass the ECLass name else the argument String value.
		Object elementTypeArg = (macroArguments.size() >= 2 ? macroArguments.get(1) : null);
		String elementTypeNameArg = null;
		if(elementTypeArg instanceof EClass){
			elementTypeNameArg = ((EClass)elementTypeArg).getName();
		}else{
			elementTypeNameArg = String.valueOf(elementTypeArg);
		}
		final String elementTypeName = elementTypeNameArg; //(String) (macroArguments.size() >= 2 ? macroArguments.get(1) : null);
		final EObject container = (EObject) (macroArguments.size() == 3 ? macroArguments.get(2) : contextObject);
		final MadFuture future = new MadFuture();
		//get package and factory
		final EPackage ePackage = container.eClass().getEPackage();
		
		Runnable baseCommand = new Runnable() {					
			@Override
			public void run() {
				EFactory eFactory = ePackage.getEFactoryInstance();
				//get containing feature
				EReference containingFeature = (EReference) container.eClass().getEStructuralFeature((String) macroArguments.get(0));
				EClass elementToCreateType = (EClass) containingFeature.getEType();
				if(elementTypeName != null){
					elementToCreateType = (EClass) elementToCreateType.getEPackage().getEClassifier(elementTypeName);
					eFactory = elementToCreateType.getEPackage().getEFactoryInstance();
				}
				//create new object
				EObject createdObject = eFactory.create(elementToCreateType);
				//attach created object to its container
				if(containingFeature.isMany()){
					@SuppressWarnings("unchecked")
					Collection<EObject> owningCollection = (Collection<EObject>) contextObject.eGet(containingFeature);
					owningCollection.add(createdObject);
				}else{
					contextObject.eSet(containingFeature, createdObject);
				}	
				//set the result to the future
				future.result = createdObject;
			}
		};

		executeAsTransactionalCommand(container, baseCommand);
		
		return (EObject) future.result;
	}

	/**
	 * Update feature value for a context object:
	 * arguments:
	 * 	- the feature name : String
	 * 	- the value to set : Object
	 * 
	 * @param contextObject
	 * @param macroArguments
	 * @throws QueryEvaluatorException 
	 */
	protected void run_UpdateFeatureMacro(final EObject contextObject, final List<Object> macroArguments) throws QueryEvaluatorException {
		final String featureName = (String) macroArguments.get(0);
		final Object value = macroArguments.get(1);
		final EStructuralFeature feature = contextObject.eClass().getEStructuralFeature(featureName);
		if(feature == null){
			throw new QueryEvaluatorException("MAD Macro " + UPDATE_FEATURE_MACRO + ": feature '" + featureName + "' not found for " + contextObject + '.');
		}
		
		final MadFuture future = new MadFuture();
		Runnable baseCommand = new Runnable() {			
			@Override
			public void run() {
				try {
					contextObject.eSet(feature, value);
				} catch (Exception e) {
					future.exception = new QueryEvaluatorException("MAD Macro " + UPDATE_FEATURE_MACRO + ": feature '" + featureName 
																	+ " on " + contextObject + '.', e);
				}
			}
		};
		
		executeAsTransactionalCommand(contextObject, baseCommand);
		if(future.exception  != null){
			throw future.exception;
		}
	}



	
	/**
	 * change context object rank in it container 
	 * - contextObject must be a containment
	 * - contextObject must have a container (upper bound > 1)
	 * Action: change contextObject rank in its container
	 * @param contextObject
	 */
	protected void run_MoveDownMacro(final EObject contextObject)  throws QueryEvaluatorException{
		final EStructuralFeature containingFeature = contextObject.eContainingFeature();		
		if(containingFeature == null){
			throw new QueryEvaluatorException("MAD Macro " + MOVE_DOWN + ": Can't move down." + contextObject + " is not contained by a feature.");
		}
		
		Runnable baseCommand = new Runnable() {			
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				if(containingFeature.isMany()){
					Collection<Object> collContaining = (Collection<Object>)contextObject.eContainer().eGet(containingFeature);
					//locate the context object
					List<Object> listContaining = new ArrayList<Object>(collContaining);
					int objectPosition = listContaining.indexOf(contextObject);
					if(objectPosition != -1 && objectPosition < listContaining.size() - 1){
						listContaining.remove(objectPosition);
						listContaining.add(objectPosition + 1, contextObject);
						contextObject.eContainer().eSet(containingFeature, listContaining);
					}
				}				
				
			}
			

		};

		executeAsTransactionalCommand(contextObject, baseCommand);
	}


	protected void run_MoveUpMacro(final EObject contextObject) throws QueryEvaluatorException {
		final EStructuralFeature containingFeature = contextObject.eContainingFeature();		
		if(containingFeature == null){
			throw new QueryEvaluatorException("MAD Macro " + MOVE_UP + ": Can't move uP." + contextObject + " is not contained by a feature.");
		}
		
		Runnable baseCommand = new Runnable() {			
			@SuppressWarnings("unchecked")
			@Override
			public void run() {

				if(containingFeature.isMany()){
					Collection<Object> collContaining = (Collection<Object>)contextObject.eContainer().eGet(containingFeature);
					//locate the context object
					List<Object> listContaining = new ArrayList<Object>(collContaining);
					int objectPosition = listContaining.indexOf(contextObject);
					if(objectPosition != -1 && objectPosition > 0){
						listContaining.remove(objectPosition);
						listContaining.add(objectPosition - 1, contextObject);
						contextObject.eContainer().eSet(containingFeature, listContaining);
					}
				}
				
			}
		};
		executeAsTransactionalCommand(contextObject, baseCommand);
	}

	
	/**
	 * create and launch transactional command.
	 * 
	 * @param processedElement
	 * @param baseCommand
	 */
	protected void executeAsTransactionalCommand(EObject processedElement, Runnable baseCommand){
		EmfToolsFacade.getInstance().getTransactionalCommandProvider().executeAsTransactionnalCommand(processedElement, baseCommand);
	}

}
