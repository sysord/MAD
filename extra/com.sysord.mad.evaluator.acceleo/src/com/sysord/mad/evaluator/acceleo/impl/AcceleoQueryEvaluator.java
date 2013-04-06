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
package com.sysord.mad.evaluator.acceleo.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.engine.generation.strategy.IAcceleoGenerationStrategy;
import org.eclipse.acceleo.engine.generation.strategy.PreviewStrategy;
import org.eclipse.acceleo.engine.service.AcceleoService;
import org.eclipse.acceleo.model.mtl.Query;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Variable;

import com.sysord.mad.evaluator.QueryAnalyze;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.QueryEvaluator;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.evaluator.impl.AbstractQueryEvaluator;
import com.sysord.mad.evaluator.impl.QueryResultImpl;
import com.sysord.mad.evaluator.impl.ocl.OCLCustomisationHelper;
import com.sysord.mad.evaluator.impl.ocl.OCLTypeDescriptorUtil;
import com.sysord.mad.type.TypeDescriptor;
import com.sysord.mad.type.TypeDescriptorUtil;

public class AcceleoQueryEvaluator  extends AbstractQueryEvaluator implements QueryEvaluator{

	public static final String ACCELEO__LANGUAGE_ID = "EMFQ2";
	
	protected BasicAcceleoService acceleoService;

			
	public AcceleoQueryEvaluator() {
		super();
		setupEnvironment();
	}


	protected void setupEnvironment(){
		_createAcceleoService();
	}

	
	@Override
	public String getLanguageId() {
		return ACCELEO__LANGUAGE_ID;
	}

	
	protected TypeDescriptor oclTypeToTypeDescriptor(EClassifier oclType){		
		return OCLTypeDescriptorUtil.oclTypeToTypeDescriptor(oclType);
	}
	
	
	public EClassifier typeDescriptorToOclType(TypeDescriptor typeDescriptor){
		return OCLTypeDescriptorUtil.typeDescriptorToOclType(typeDescriptor);		
	}

	
	@Override
	protected <T> QueryResult processEvaluation(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		
		Object acceleoContextObject = evaluationContext.getContextObject();
		
		if(acceleoContextObject == null){
			throw createInvalidContextException(evaluationContext.getQuery().toString(), evaluationContext.getContextObject(), EObject.class);			
		}		
		
		if(evaluationContext.getQuery() instanceof String){
			return evaluateAcceleoQueryExpression(evaluationContext, acceleoContextObject);
		}else if(Query.class.isAssignableFrom(evaluationContext.getQuery().getClass())){
			return evaluateAcceleoQuery(evaluationContext, (Query) evaluationContext.getQuery(), acceleoContextObject);
		}else{
			return null;
		}

	}

	protected <T> QueryResult<T> evaluateAcceleoQuery(QueryEvaluationContext evaluationContext, Query query, Object contextObjectOrProxy) {
		Object result = evalQuery(evaluationContext, query, contextObjectOrProxy);
		//create and return QueryResult
		return (QueryResult<T>) createQueryResult(result, query.getType());
	}


	protected <T> T evaluateAcceleoQueryExpression(QueryEvaluationContext evaluationContext, Object contextObjectOrProxy) {
		// TODO : find compilation method
		return null;
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
	 * Evaluate acceleo query
	 * 
	 * @param query
	 * @param arguments
	 * @return
	 */
	public Object evalQuery(QueryEvaluationContext evaluationContext, Query query, Object contextObjectOrProxy){
		List<Object> acceleoArguments = new ArrayList<Object>();
		//set context object
		if(contextObjectOrProxy != null){
			//création du proxy
			acceleoArguments.add(contextObjectOrProxy);				
		}
		
		//TODO: set parameters
		//acceleoArguments.addAll(generationContext.getArguments());
		for(int i = 1; i < query.getParameter().size(); i++){
			 Variable queryParm = query.getParameter().get(i);
			if(evaluationContext.getArguments().containsKey(queryParm.getName())){
				acceleoArguments.add(evaluationContext.getArguments().get(queryParm.getName()));
			}else{
				//set null value
				acceleoArguments.add(null);
			}
		}

		//Apply Preview strategy for get String without write in ouput file
		IAcceleoGenerationStrategy strategy = new PreviewStrategy();
		Object result = acceleoService.evaluateQuery(query, acceleoArguments, strategy, null);
		getEvaluationAnalyze().setConvertedResultValue(result);
		return result;
	}
	
	/**
	 * This will be used prior to each generation to create the instance of {@link AcceleoService} that will
	 * be used to interface with the generation engine.
	 * <p>
	 * This default implementation should be sufficient for all cases, it will delegate creation of the
	 * generation strategy to {@link #getGenerationStrategy()}, register the generation listeners as returned
	 * by {@link #getGenerationListeners()}, then register all properties as returned by [@link
	 * #getProperties()} in the generation context.
	 * </p>
	 * 
	 * @return The Acceleo service that is to be used for generations launched through this launcher.
	 */
	protected void _createAcceleoService() {
		BasicAcceleoService service = null;
		//Apply Preview strategy for get String without write in ouput file
		IAcceleoGenerationStrategy strategy = new PreviewStrategy();
		service = new BasicAcceleoService(strategy);					
		acceleoService  = service;
	}


	@Override
	public QueryAnalyze analyzeQuery(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
