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
package com.sysord.mad.evaluator.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;

import com.sysord.mad.evaluator.EvaluationAnalyze;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.mao.ValuedSemanticElement.ACCESS_CATEGORY;

/**
 * Evaluation analyzer:
 * 
 *  injected in the Thread local 
 *  informations collected during evaluation are store in this analyzer
 *
 */
public class EvaluationAnalyzeImpl implements EvaluationAnalyze {

	 
	/**
	 * Access category
	 */
	protected ACCESS_CATEGORY accessCategory = ACCESS_CATEGORY.NONE;
	
	/**
	 * Resource owning the result
	 */
	protected Resource resultResource;
	
	/**
	 * Last used context for obtain resultValue
	 */
	protected Object resultContext;

	/**
	 * Feature (value owner) or operation 
	 */
	protected ETypedElement featureOrOperation;
	
	/**
	 * Result (Query result before conversion / adaptation)
	 */
	protected Object resultValue;


	/**
	 * Value after conversion by QueryEvaluator
	 */
	protected Object convertedResultValue;
	
	/**
	 * Query result
	 */
	protected QueryResult result;

	
	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#clear()
	 */
	@Override
	public void clear(){
		updateState(ACCESS_CATEGORY.NONE, null, null, null);
	}
				
	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#getAccessCategory()
	 */
	@Override
	public ACCESS_CATEGORY getAccessCategory() {
		return accessCategory;
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#setAccessCategory(com.sysord.mad.evaluator.impl.ocl.OCLEvaluationAnalyze.ACCESS_CATEGORY)
	 */
	@Override
	public void setAccessCategory(ACCESS_CATEGORY accessCategory) {
		this.accessCategory = accessCategory;
	}

	@Override
	public void setResultResource(Resource resource) {
		resultResource = resource;
	}

	@Override
	public Resource getResultResource() {
		if(resultResource != null){
			return resultResource;
		}else{
			if(resultContext != null && EObject.class.isAssignableFrom(resultContext.getClass())){
				return ((EObject)resultContext).eResource();
			}else{
				return null;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#getContext()
	 */
	@Override
	public Object getResultContext() {
		return resultContext;
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#setContext(java.lang.Object)
	 */
	@Override
	public void setResultContext(Object context) {
		this.resultContext = context;
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#getFeatureOrOperation()
	 */
	@Override
	public ETypedElement getFeatureOrOperation() {
		return featureOrOperation;
	}

	@Override
	public EStructuralFeature getFeature() {
		if(!EStructuralFeature.class.isAssignableFrom(featureOrOperation.getClass())){
			return null;
		}else{
			return (EStructuralFeature) featureOrOperation;			
		}
	}

	@Override
	public EOperation getOperation() {
		if(!EOperation.class.isAssignableFrom(featureOrOperation.getClass())){
			return null;
		}else{
			return (EOperation) featureOrOperation;			
		}
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#setFeatureOrOperation(org.eclipse.emf.ecore.ETypedElement)
	 */
	@Override
	public void setFeatureOrOperation(ETypedElement featureOrOperation) {
		this.featureOrOperation = featureOrOperation;
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#getResultValue()
	 */
	@Override
	public Object getResultValue() {
		return resultValue;
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#setResultValue(java.lang.Object)
	 */
	@Override
	public void setResultValue(Object resultValue) {
		this.resultValue = resultValue;
	}

	@Override
	public Object getConvertedResultValue() {
		return this.convertedResultValue;
	}

	@Override
	public void setConvertedResultValue(Object convertedResultValue) {
		this.convertedResultValue = convertedResultValue;
	}
	
	@Override
	public QueryResult getQueryResult() {
		return result;
	}
	
	@Override
	public void setQueryResult(QueryResult queryResult) {
		this.result = queryResult;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#collectPropertyAccess(java.lang.Object, org.eclipse.emf.ecore.EStructuralFeature, java.util.List, java.lang.Object)
	 */
	@Override
	public void collectPropertyAccess(Object context, EStructuralFeature property, List<?> qualifiers, Object result){
		updateState(ACCESS_CATEGORY.PROPERTY, context, property, result);		
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#collectPropertyAccess(java.lang.Object, org.eclipse.emf.ecore.EStructuralFeature, java.util.List, java.lang.Object)
	 */
	@Override 
	public void collectContainerAccess(Object context, EStructuralFeature property, List<?> qualifiers, Object result){
		updateState(ACCESS_CATEGORY.CONTAINER, context, property, result);		
	}

	
	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#collectAssociationClassAccess(java.lang.Object, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	@Override
	public void collectAssociationClassAccess(Object context, EStructuralFeature property, Object result){
		updateState(ACCESS_CATEGORY.ASSOCIATION_CLASS, context, property, result);		
	}
	
	
	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#collectOppositePropertyAccess(java.lang.Object, org.eclipse.emf.ecore.EReference, java.lang.Object)
	 */
	@Override
	public void collectOppositePropertyAccess(Object context, EReference propertyRef, Object result){
		updateState(ACCESS_CATEGORY.OPPOSITE_PROPERTY, context, propertyRef, result);		
	}
	
	/* (non-Javadoc)
	 * @see com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyze#collectOperationCall(java.lang.Object, org.eclipse.emf.ecore.EOperation, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void collectOperationCall(Object context, EOperation operation, Object[] args, Object result){
		updateState(ACCESS_CATEGORY.OPERATION_CALL, context, operation, result);
	}

	/**
	 * 
	 * @param accessCategory
	 * @param context
	 * @param feature
	 * @param resultValue
	 */
	protected void updateState(ACCESS_CATEGORY accessCategory, Object context, ETypedElement feature,Object resultValue ){
		this.accessCategory = accessCategory;
		this.resultContext = context;
		this.featureOrOperation = feature;
		this.resultValue = resultValue;
	}

	@Override
	public String toString() {
		return "OCLEvaluationAnalyze [accessCategory=" + accessCategory
				+ ", context=" + resultContext + ", featureOrOperation="
				+ featureOrOperation + ", resultValue=" + resultValue
				+ ", convertedResultValue=" + convertedResultValue + "]";
	}





	
}
