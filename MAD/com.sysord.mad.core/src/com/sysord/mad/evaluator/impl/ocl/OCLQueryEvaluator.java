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



import java.text.MessageFormat;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.Environment.Internal;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.util.TypeUtil;

import com.sysord.mad.evaluator.QueryAnalyze;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.evaluator.impl.AbstractQueryEvaluator;
import com.sysord.mad.evaluator.impl.QueryAnalyzeImpl;
import com.sysord.mad.evaluator.impl.QueryResultImpl;
import com.sysord.mad.type.TypeDescriptor;
import com.sysord.mad.type.TypeDescriptor.TYPE_CATEGORY;
import com.sysord.mad.type.TypeDescriptorImpl;
import com.sysord.mad.type.TypeDescriptorUtil;
import com.sysord.mad.type.TypedValue;

public class OCLQueryEvaluator extends AbstractQueryEvaluator {
		
	public static final String OCL_LANGUAGE_ID ="OCL";
	
	
	protected OCL ocl; 
	protected OCLHelper helper;


	protected MessageFormat oclVariableFormat = new MessageFormat("{0}$");

	public static boolean UPDATE_EVALUATION_ANALYZE = true;

	public OCLQueryEvaluator() {
		super();
		setupOCL();
	}
	
	protected void setupOCL(){
		MadEcoreEnvironmentFactory.UPDATE_EVALUATION_ANALYZE = UPDATE_EVALUATION_ANALYZE;
		ocl = OCL.newInstance(MadEcoreEnvironmentFactory.INSTANCE);
		helper = ocl.createOCLHelper();
	}
	
	@Override
	public String getLanguageId() {
		return OCL_LANGUAGE_ID;
	}
	
	@Override
	public MessageFormat getVariableFormat() {
		return oclVariableFormat;
	}

	@Override
	protected void setupEnvironment(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {		
		for(Entry<String, TypedValue> argEntry :  evaluationContext.getArguments().entrySet()){
			// create a variable declaring our global application context object
			EClassifier injectedVariableType = typeDescriptorToOclType(argEntry.getValue().getType());
			//FIXME: define a default type for null value: choose OCLAny but is not the best way...
			if(injectedVariableType == null){
				injectedVariableType = OCLCustomisationHelper.OCL_ANY;
			}
			// add it to the global OCL environment (remove previous version before for ensure variable registering)
			String varname = oclVariableFormat.format(new String[]{argEntry.getKey()});
			ocl.getEnvironment().deleteElement(varname);						
			if(injectedVariableType != null){
				Variable<EClassifier, EParameter> injectedVar = ExpressionsFactory.eINSTANCE.createVariable();
				//variable name conformance
				injectedVar.setName(varname);
				injectedVar.setType(injectedVariableType);				
				// add it to the global OCL environment (remove previous version before for ensure variable registering)
				ocl.getEnvironment().deleteElement(injectedVar.getName());
				ocl.getEnvironment().addElement(injectedVar.getName(), injectedVar, true);
			}			
		}
		//TODO: register additional metamodels
//		for(String nsUri : evaluationContext.getEnvironment().getEnvironmentNSUris()){
//			EcoreEnvironmentFactory.INSTANCE.getEPackageRegistry().getEPackage(nsUri);				
//		}
		
	}

	
	@Override
	public QueryAnalyze analyzeQuery(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		
		//OCL need EOBject as context
		String querySource = extractQuerySource(evaluationContext);
		
		EClassifier oclContextType = typeDescriptorToOclType(evaluationContext.getContextObjectType());
		
		if(oclContextType != null){
			OCLExpression<EClassifier> queryExpr = createOCLQueryExpression(oclContextType, querySource);
			EClassifier oclReturnType = queryExpr.getType();
			return new QueryAnalyzeImpl(oclTypeToTypeDescriptor(oclReturnType));					
		}else{
			throw createInvalidContextTypeException(querySource, evaluationContext.getContextObjectType().getType(), EObject.class);
		}
		
	}
	

	
	
	
	protected TypeDescriptor oclTypeToTypeDescriptor(EClassifier oclType){		
		return OCLTypeDescriptorUtil.oclTypeToTypeDescriptor(oclType);
	}
	
	
	public EClassifier typeDescriptorToOclType(TypeDescriptor typeDescriptor){
		return OCLTypeDescriptorUtil.typeDescriptorToOclType(typeDescriptor);		
	}
	
	/**
	 * Create a Query result
	 * 
	 * @param result
	 * @param oclReturnType
	 * @return
	 */
	protected <T> QueryResult<T> createQueryResult(T result, EClassifier oclReturnType){
		TypeDescriptor resultTypeDescriptor;
		if(result == null){
			resultTypeDescriptor = TypeDescriptorUtil.NULL_TYPE;
		}else{
			//when result ocl return type is oclAny: we have no instanceClass
			// use default TypDescriptor builder
			if(OCLCustomisationHelper.OCL_ANY == oclReturnType){
				resultTypeDescriptor = TypeDescriptorUtil.createTypeDescriptor(result);			
			}else{
				resultTypeDescriptor = oclTypeToTypeDescriptor(oclReturnType);							
			}
		}
		return new QueryResultImpl<T>(result, resultTypeDescriptor);
	}
	
	/**
	 * if OCL update the evaluation Analyze we must not use proxy.
	 */
	protected boolean evaluateUsingProxy(){
		return !UPDATE_EVALUATION_ANALYZE;
	}

	
	@Override
	protected <T> QueryResult processEvaluation(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {

		try {
			//extract query as String
			String querySource = extractQuerySource(evaluationContext);
			
			//get context object
			Object contextObject = evaluationContext.getContextObject();
			
			if (contextObject == null) {
				return createNullQueryResult();
			}else{				
				//convert context type to ocl type
				EClassifier oclContextType = typeDescriptorToOclType(evaluationContext.getContextObjectType());			
				if(oclContextType == null){
					throw createInvalidContextTypeException(querySource, evaluationContext.getContextObjectType().getType(), EObject.class);
				}
				//Ocl Query expression
				OCLExpression<EClassifier> queryExpr = createOCLQueryExpression(oclContextType, querySource);
				//Create OCL Query
				Query query = ocl.createQuery(queryExpr);
				// Set variables values
				for (Entry<String, TypedValue> argEntry : evaluationContext.getArguments().entrySet()) {
					query.getEvaluationEnvironment().add(oclVariableFormat.format(new String[]{argEntry.getKey()}), argEntry.getValue().getValue());
				}
				//Eval query
				Object result = query.evaluate(contextObject);			
				//create and return QueryResult
				return createQueryResult(result, queryExpr.getType());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new QueryEvaluatorException(e);
		}
	}

	/**
	 * Parse OCL String expression and create a OCL Query expression.
	 * syntax error or invalid operations throws {@link QueryEvaluatorException}
	 * @param evaluationContext
	 * @param contextObjectOrProxy
	 * @return
	 * @throws QueryEvaluatorException
	 */
	@SuppressWarnings("unchecked")
	protected OCLExpression<EClassifier> createOCLQueryExpression(EClassifier contextType, String sourceQuery) throws QueryEvaluatorException{
		try {			
			// define context type
			helper.setContext(contextType);
			// create Ocl query
			OCLExpression<EClassifier> queryExpr = helper.createQuery(sourceQuery);
			return queryExpr;
		} catch (ParserException e) {
			e.printStackTrace();
			throw new QueryEvaluatorException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new QueryEvaluatorException(e);
		}

	}
	
//	protected Object getQueryContextObject(QueryEvaluationContext evaluationContext, Object contextObjectOrProxy){
//		//evaluation analyze can be updated by OCL evaluation environment
//		//or by proxy strategy. if update the evaluationAnalyze the contextObject proxy must not be used.
//		if(UPDATE_EVALUATION_ANALYZE){
//			return evaluationContext.getContextObject().getValue();				
//		}else{
//			return contextObjectOrProxy;				
//		}
//	}
	
	
	
	@Override
	protected void releaseEnvironment(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		//unSet globals variables
		for(String argName : evaluationContext.getArguments().keySet()){
			ocl.getEnvironment().deleteElement(argName);
		}
		// For optimization purposes
		clearEnvironment();
	}

			
	protected EClassifier argumentOCLType(Object argument){
		return OCLCustomisationHelper.oclType(argument);
	}

	
    /**
     * Dispose the internal environment if the resource's content size grows to much.
     */
    protected void clearEnvironment() {
        Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> environment = helper.getOCL().getEnvironment();
        if (environment != null && environment instanceof Environment.Internal) {
            Internal<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> internalEnvironment = (Environment.Internal<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) environment;
            TypeResolver<?, ?, ?> resolver = internalEnvironment.getTypeResolver();
            if (resolver != null) {
                Resource resource = resolver.getResource();
                if (resource != null) {
                    int size = resource.getContents().size();
                    if (size > 10000) {
                        internalEnvironment.dispose();
                    }
                }
            }
        }
    }



	
	
	
}
