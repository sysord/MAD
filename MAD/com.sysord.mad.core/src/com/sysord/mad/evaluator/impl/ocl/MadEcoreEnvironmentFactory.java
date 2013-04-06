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

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EvaluationVisitorImpl;
import org.eclipse.ocl.ecore.SendSignalAction;


public class MadEcoreEnvironmentFactory extends EcoreEnvironmentFactory {

    public static EcoreEnvironmentFactory INSTANCE = new MadEcoreEnvironmentFactory();

    public static boolean UPDATE_EVALUATION_ANALYZE = true;

    protected MadEcoreEvaluationEnvironment evaluationEnvironment; 
    
    
    @Override
	public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment() {
    	return new MadEcoreEnvironment(this, null);
	}

	@Override
	public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
	       if (!(parent instanceof MadEcoreEnvironment)) {
	            throw new IllegalArgumentException(
	                "Parent environment must be a MadEcoreEnvironment parent is " + parent);
	        }	        
	       return new MadEcoreEnvironment((MadEcoreEnvironment) parent);
	 }

	@Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
    	evaluationEnvironment = new MadEcoreEvaluationEnvironment(this, UPDATE_EVALUATION_ANALYZE);
		return evaluationEnvironment;
	}

    @Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment(EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
    	evaluationEnvironment = new MadEcoreEvaluationEnvironment(parent, UPDATE_EVALUATION_ANALYZE);
		return evaluationEnvironment;
	}
    
    public MadEcoreEvaluationEnvironment getMadEcoreEvaluationEnvironment(){
    	return evaluationEnvironment;
    }
    
	/**
	 * @since 3.1
	 */
	public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
			Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
		
		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> 
			result = new EvaluationVisitorImpl(env, evalEnv, extentMap);

		// decorate the evaluation visitor with tracing support
		result = new MadOCLEvaluationVisitor(result);
		
		return result;
	}
	
}
