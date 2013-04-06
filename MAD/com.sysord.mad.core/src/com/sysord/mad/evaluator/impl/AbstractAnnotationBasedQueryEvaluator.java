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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sysord.mad.evaluator.QueryAnalyze;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.functionparser.FunctionProcessingException;

/**
 * Super class for creating evaluator using {@link EvaluatorFunction} annotation
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public abstract class AbstractAnnotationBasedQueryEvaluator extends AbstractQueryEvaluator {

	@Override
	public QueryAnalyze analyzeQuery(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		return null;
	}

	
	@Override
	protected <T> QueryResult<?> processEvaluation(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {				
		// Query must be only String Query expression.
		String sourceQuery = extractQuerySource(evaluationContext);

		try {
			Object result = null;
			// Parse and execute query
			AnnotatedFunctionProcessor processor = createFunctionProcessor(evaluationContext);
			result = QueryEvaluatorUtil.parseQuery(sourceQuery, processor);
			if (!processor.exprIsFunction) {
				throw createInvalidQueryException(sourceQuery, "Query doesn't contain function.");
			}
			return createDefaultQueryResult(result);

		} catch (QueryEvaluatorException e) {
			throw e;
		} catch (Exception e) {
			throw new QueryEvaluatorException(e);
		}
	}
		
		
	
	/**
	 * Evaluates function discovered by parser.
	 * - Search for function by name and prototype
	 * - invoke the function
	 * @param funcname
	 * @param arguments
	 * @return
	 */
	protected Object processEvalFunction(String funcname, List<Object> arguments, QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		//try to retrieve the matching method
		Method function = getFunctionMethod(funcname, arguments);
		if(function == null){
			//no matching function found
			throw createUnknowFunctionException(funcname);
		}else{
			// invoke method			
			try {
				List<Object> invocationArgs = new ArrayList<Object>(arguments);
				//Inject QueryEvaluationContext if required
				if(requireEvaluationContextInjection(function)){
					invocationArgs.add(0, evaluationContext);					
				}
				return function.invoke(this, invocationArgs.toArray());
			} catch (Exception e) {
				e.printStackTrace();
				throw createEvaluationException(funcname, arguments, e);
			}

		}
	}

	
	/**
	 * Search for method annotated with {@link EvaluatorFunction}
	 * - Method with same name or function name defined in the annotation.
	 * - conform prototype
	 * @param funcname
	 * @param arguments
	 * @return
	 */
	protected Method getFunctionMethod(String funcname, List<Object> arguments){
		for(Method candidate : this.getClass().getMethods()){
			EvaluatorFunction functionAnnotation = candidate.getAnnotation(EvaluatorFunction.class);
			//if name is defined for the function funcname must match this name otherwise funcname must match the method name
			if(functionAnnotation != null &&  
				(funcname.equals(functionAnnotation.name()) || ("".equals(functionAnnotation.name()) && candidate.getName().equals(funcname)))){
				boolean requireEvalContextInjection = requireEvaluationContextInjection(candidate);
				//validate prototype
				Class<?>[] parmTypes = candidate.getParameterTypes();
				int argSize = !requireEvalContextInjection ? arguments.size() : arguments.size() + 1; 
				if(parmTypes.length == argSize){
					int iParm = 0;					
					//validate parameters
					for(Object argument : arguments){
						//first arg is evaluation context or  arg not null and argument type is conform						
						if((requireEvalContextInjection && iParm == 0) || argument != null && parmTypes[iParm].isAssignableFrom(argument.getClass())){
							iParm++;
						}else{
							//no matching type
							break;
						}
					}
					//function found
					if(iParm == arguments.size()){
						return candidate;
					}					
				}
			}
		}
		return null;
	}
	
	/**
	 * when first argument is type of QueryEvaluationContext
	 * function requires QueryEvaluationContext injection
	 * @param function
	 * @return
	 */
	protected boolean requireEvaluationContextInjection(Method function){
		Class<?>[] functionParmTypes = function.getParameterTypes();			
		return (functionParmTypes.length > 0 && QueryEvaluationContext.class.isAssignableFrom(functionParmTypes[0]));
	}
		
	
	/**
	 * Create the function processor (parser)
	 * @param evaluationContext
	 * @return
	 */
	protected AnnotatedFunctionProcessor createFunctionProcessor(QueryEvaluationContext evaluationContext){
		return new AnnotatedFunctionProcessor(evaluationContext);
	}
	
	
	protected class AnnotatedFunctionProcessor extends AbstractBaseFunctionProcessor{

		/**
		 * flag set to true when a function is evaluated
		 */
		protected boolean exprIsFunction = false;
		
		public AnnotatedFunctionProcessor(QueryEvaluationContext evaluationContext) {
			super(evaluationContext);
		}

		/**
		 * All argument are ready, we have to eval the function
		 * if function not exists throws an exception
		 * if arguments are not conform throws an exception
		 * evaluates the function and returns the result.
		 */
		@Override
		public Object evalFunction(String funcname, List<Object> arguments) throws FunctionProcessingException {
			try {
				exprIsFunction = true;
				return processEvalFunction(funcname, arguments, evaluationContext);
			} catch (QueryEvaluatorException e) {
				e.printStackTrace();
				throw new FunctionProcessingException(e);
			}
		}
		
	}


}



















