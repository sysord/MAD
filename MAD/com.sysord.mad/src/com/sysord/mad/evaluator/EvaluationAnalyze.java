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
package com.sysord.mad.evaluator;

import java.util.List;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;

import com.sysord.mad.mao.ValuedSemanticElement.ACCESS_CATEGORY;

/**
 * Query evaluation analyze:
 * 
 *  extracted informations during evaluation with analyze.
 *	provide result context  and feature accessed for get the result.
 *
 */
public interface EvaluationAnalyze {

	//TODO: add Query expected return type (formal discovery)
	//...
	
	public void clear();

	public ACCESS_CATEGORY getAccessCategory();

	public void setAccessCategory(ACCESS_CATEGORY accessCategory);

	/**
	 * Resource from where the result has been  extracted
	 * @return
	 */
	public Resource getResultResource();
	public void setResultResource(Resource resource);

	/**
	 * Context from where the result has been  extracted: the result container or feature owner
	 * @return
	 */
	public Object getResultContext();

	public void setResultContext(Object context);

	/**
	 * return the feature or operation used for provide result
	 * @return
	 */
	public ETypedElement getFeatureOrOperation();
	
	/**
	 * if Feature or operation is a Feature return the feature otherwise return null;
	 * @return
	 */
	public EStructuralFeature getFeature();
	/**
	 * if Feature or operation is an Operation return the operation otherwise return null;
	 * @return
	 */
	public EOperation getOperation();


	public void setFeatureOrOperation(ETypedElement featureOrOperation);

	/**
	 * query raw result (before conversion / adaptation)
	 * @return
	 */
	public Object getResultValue();
	public void setResultValue(Object resultValue);

	/**
	 * converted final usable result
	 * @return
	 */
	public Object getConvertedResultValue();
	public void setConvertedResultValue(Object resultValue);

	/**
	 * Query result: value and type info
	 * @return
	 */
	public QueryResult<?> getQueryResult();
	public void setQueryResult(QueryResult<?> queryResult);

	
	/**
	 * 
	 * @param context
	 * @param property
	 * @param qualifiers (Unused)
	 * @param result
	 */
	public void collectPropertyAccess(Object context,
			EStructuralFeature property, List<?> qualifiers, Object result);

	/**
	 * 
	 * @param context
	 * @param property
	 * @param result
	 */
	public void collectAssociationClassAccess(Object context,
			EStructuralFeature property, Object result);
 
	/**
	 * 
	 * @param context
	 * @param property
	 * @param result
	 */
	public void collectOppositePropertyAccess(Object context,
			EReference propertyRef, Object result);

	/**
	 * 
	 * @param context
	 * @param operation
	 * @param args
	 * @param result
	 */
	public void collectOperationCall(Object context,
			EOperation operation, Object[] args, Object result);

	/**
	 * 
	 * @param context
	 * @param property
	 * @param qualifiers
	 * @param result
	 */
	void collectContainerAccess(Object context, EStructuralFeature property, List<?> qualifiers, Object result);

	

}
