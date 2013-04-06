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

import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.sysord.mad.configuration.impl.ConfigurationManagerHelper;
import com.sysord.mad.core.preferences.PreferenceHelper;
import com.sysord.mad.evaluator.EvaluationAnalyze;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.QueryEvaluator;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.evaluator.impl.ocl.EvaluationAnalyzeImpl;
import com.sysord.mad.evaluator.impl.ocl.OCLQueryEvaluator;
import com.sysord.mad.functionparser.FunctionProcessingException;
import com.sysord.mad.functionparser.FunctionProcessor;
import com.sysord.mad.mao.ValuedSemanticElement.ACCESS_CATEGORY;
import com.sysord.mad.model.cache.ModelCache;
import com.sysord.mad.type.TypeDescriptorUtil;
import com.sysord.mad.type.TypedValue;

public abstract class AbstractQueryEvaluator implements QueryEvaluator {

	@Inject
	private ModelCache modelCache;

	/**
	 * Default variable format: ${varname}
	 */
	protected MessageFormat defaultVariableFormat = new MessageFormat("${0}");
	
	/**
	 * returns the default variable format: ${varname}
	 */
	
	
	@Override
	public MessageFormat getVariableFormat() {
		return defaultVariableFormat;
	}

	@Override
	public <T> QueryResult<T> evaluate(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		return _processEvaluation(evaluationContext);			
	}


	@Override
	public <T> QueryResult<T> runActionQuery(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		QueryResult<T> queryResult = _processEvaluation(evaluationContext);
		return queryResult;
	}
	
	

	

	
	/**
	 * Evaluation:
	 * 
	 * - setup environment
	 * 
	 * @param evaluationContext
	 * @return
	 * @throws QueryEvaluatorException
	 */
	protected <T> QueryResult<T> _processEvaluation(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException{
		try {
			
			//create evaluation analyze
			createEvaluationAnalyzer();
			
			setupEnvironment(evaluationContext);

			Object originalContext = null;
			//if need evaluation analyze and evaluator supports proxy: create a proxy 
			if(evaluationContext.isEvaluationAnalyzeRequired() && canUseProxies()){
				originalContext = evaluationContext.getContextObject();
				//create a proxy for context object for tracking and analyze feature access	
				ContextObjectInvocationHandler.clearProxyCache();
				Object contextObjectProxy = ContextObjectInvocationHandler.createProxy(evaluationContext.getContextObject());
				//override original context value by the proxy
				if(contextObjectProxy != null){
					evaluationContext.overrideContextObject(contextObjectProxy);					
				}
			}
			
			QueryResult<?> evaluationResult = processEvaluation(evaluationContext);
			
			//if need evaluation analyze and evaluator supports proxy: return could be a proxy
			//we have to retrieve the real object and set it into Query result
			if(evaluationContext.isEvaluationAnalyzeRequired() && canUseProxies()){
				//restore real context object
				evaluationContext.overrideContextObject(originalContext);
				//extract real result object
				evaluationResult = createDefaultQueryResult(ContextObjectInvocationHandler.retrieveRealObject(evaluationResult.getValue()));				
				//extract analyze info real objects.
				EvaluationAnalyze analyze = getEvaluationAnalyze();
				analyze.setResultResource((Resource) ContextObjectInvocationHandler.retrieveRealObject(analyze.getResultResource()));
				analyze.setResultContext(ContextObjectInvocationHandler.retrieveRealObject(analyze.getResultContext()));
				analyze.setResultValue(ContextObjectInvocationHandler.retrieveRealObject(analyze.getResultValue()));								
			}

			
			//apply conversion if defined for the specific evaluator
			QueryResult<?> convertedQueryResult = convertResult(evaluationResult, evaluationContext);
			
			//set the evaluationResult as converted value for evaluation analyze
			getEvaluationAnalyze().setConvertedResultValue(convertedQueryResult.getValue());
			
			// check analyze and clear it if invalid
			if(evaluationContext.isEvaluationAnalyzeRequired()){
				checkAnalyzeValidity(evaluationResult);				
				convertedQueryResult.setEvaluationAnalyze(getEvaluationAnalyze());
			}
						
			return (QueryResult<T>) convertedQueryResult;
			
		} catch (QueryEvaluatorException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new QueryEvaluatorException(e);
		} finally{
			releaseEnvironment(evaluationContext);
			//remove evaluation analyze
			releaseEvaluationAnalyzer();
		}
	}

	/**
	 * Setup environment:
	 *  - register EMF package and NSURI 
	 *  - declare arguments to the evaluation engine
	 * @param evaluationContext
	 */
	protected void setupEnvironment(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException{		
	}

	
	/**
	 * return true if evaluator allows Proxies for monitoring the evaluation
	 * @return
	 */
	protected boolean evaluateUsingProxy(){
		return true;
	}
	
	/**
	 * Returns true if proxies can be used for the evaluation.
	 * true if the evaluator supports proxies and proxy mechanism is not disabled.
	 * @return true if proxies can be used for the evaluation
	 * 
	 */
	protected final boolean canUseProxies(){
		return evaluateUsingProxy() && !PreferenceHelper.isProxyMechanismDisabled();		
	}
	
	/**
	 * Environment is ready, launch the query evaluation
	 * @param evaluationContext
	 * @return
	 * @throws QueryEvaluatorException
	 */
	protected abstract 	<T> QueryResult<?> processEvaluation(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException;


	/**
	 * 
	 * @param queryResult
	 * @param evaluationContext
	 * @return
	 */
	protected QueryResult<?> convertResult(QueryResult<?> queryResult, QueryEvaluationContext evaluationContext){
		return queryResult;
	}

	/**
	 * Release environment:
	 * release all resources or cache at end of evaluation
	 * @param evaluationContext
	 */
	protected void releaseEnvironment(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException{		
	}
	



	
	//-------------------------
	// Queries
	//-------------------------
	/**
	 * Extract query source from evaluation context
	 * if query is not a String or is null, 
	 * a QueryEvaluatorException is throw
	 * @param evaluationContext
	 * @return
	 * @throws QueryEvaluatorException
	 */
	protected String extractQuerySource(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		if(evaluationContext.getQuery() == null || !String.class.isAssignableFrom(evaluationContext.getQuery().getClass()) ){
			throw createInvalidQueryException(evaluationContext.getQuery().toString(), getLanguageId()  + " supports only string queries.");
		}else{
			return (String) evaluationContext.getQuery();
		}
	}
	
	
	//----------------------------
	// Evaluation analyze .
	//-----------------------------
	
	/**
	 * Fill analyze with an evaluation result.
	 * @param result
	 */
	protected void fillAnalyze(Object result){
		EvaluationAnalyze evaluationAnalyze = getEvaluationAnalyze();
		//fill analyze
		if(result != null && result instanceof EObject){
			//TODO: check strategy validity...
			EObject eResult = (EObject) result;
			if(eResult.eContainingFeature() != null){
				evaluationAnalyze.setAccessCategory(ACCESS_CATEGORY.PROPERTY);
			}
			evaluationAnalyze.setFeatureOrOperation(eResult.eContainingFeature());
			evaluationAnalyze.setResultContext(eResult.eContainer());				
		}			
		evaluationAnalyze.setResultValue(result);		
		evaluationAnalyze.setConvertedResultValue(result);
	}

	
	/**
	 * create and inject Evaluation analyze structure in the current thread
	 */
	protected EvaluationAnalyze createEvaluationAnalyzer(){
		EvaluationAnalyze analyzer = new EvaluationAnalyzeImpl();
		CurrentEvaluationContext.setEvaluationAnalyze(analyzer);
		return analyzer;
	}
	
	/**
	 * Remove evaluation analyzer from the thread
	 */
	protected EvaluationAnalyze releaseEvaluationAnalyzer(){
		EvaluationAnalyze analyzer = CurrentEvaluationContext.getEvaluationAnalyze();
		CurrentEvaluationContext.releaseEvaluationAnalyser();
		return analyzer;
	}

	protected EvaluationAnalyze getEvaluationAnalyze(){
		return CurrentEvaluationContext.getEvaluationAnalyze();
	}
	
	
	
	/**
	 * if evaluation use operation not monitored (observed), Analyze could be invalid.
	 * Analyze is invalid if QueryResult != Query result stored in the EvaluationAnlyze structure
	 * when analyze is invalid: collected information are cleared.
	 */
	protected boolean checkAnalyzeValidity(QueryResult<?> queryResult){
		Object analyzeResult = CurrentEvaluationContext.getEvaluationAnalyze().getResultValue();
		if(analyzeResult == queryResult.getValue() || (analyzeResult != null && analyzeResult.equals(queryResult.getValue())) ){
			return true;
//		}else if(Collection.class.isAssignableFrom(analyzeResult.getClass()) && Collection.class.isAssignableFrom(queryResult.getClass()) 
//				&& ((Collection)analyzeResult).size() == ((Collection)queryResult).size()){
//				//collection with same size: check content
//			boolean valid = ((Collection)analyzeResult).containsAll(((Collection)queryResult));
//			return valid;
		}else{
			//result are different => invalid
			CurrentEvaluationContext.getEvaluationAnalyze().clear();
			return false;
		}
	}

	
	//-------------------------------
	// Query Result Utility functions
	//-------------------------------
	
	/**
	 * Create a {@link QueryResult} from a result object.
	 * @param result
	 * @return the created {@link QueryResult}
	 */
	protected QueryResult<?> createDefaultQueryResult(Object result){
		//TODO: manage collection
		return new QueryResultImpl<Object>(result, TypeDescriptorUtil.createTypeDescriptor(result));
	}

	protected QueryResult<?> createNullQueryResult(){
		return new QueryResultImpl<Object>(null, TypeDescriptorUtil.NULL_TYPE);
	}

	/**
	 * if object is an EObject return object else return null
	 * @param result
	 * @return
	 */
	protected EObject objectToEobject(Object object) {
		if(object != null && EObject.class.isAssignableFrom(object.getClass())){
			return (EObject) object;
		}else{
			return null;
		}
	}
	
	/**
	 * This method can be used to convert and validate result for compliance with evaluationContext expected result.
	 * @param result
	 * @return
	 */	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected <T> T convertsAndValidatesResult(Object result, QueryEvaluationContext evaluationContext) throws QueryEvaluatorException{

		Object convertedResult = null;

		if(evaluationContext.isSingleValueReturned()){
			//Single value result:
			//if list take the first element
			if(Collection.class.isAssignableFrom(result.getClass())){
				List lResults = new ArrayList(((Collection)result));
				if(lResults.isEmpty()){
					return null;
				}else{
					validateResultType(lResults.get(0).getClass(), evaluationContext);
					if(evaluationContext.getReturnType().isAssignableFrom(lResults.get(0).getClass())){
						return (T) lResults.get(0);						
					}else{
					}
				}
			}else if(Map.class.isAssignableFrom(result.getClass())){
				List lResults = new ArrayList(((Map)result).values());
				if(lResults.isEmpty()){
					return null;
				}else{
					validateResultType(lResults.get(0).getClass(), evaluationContext);
					if(evaluationContext.getReturnType().isAssignableFrom(lResults.get(0).getClass())){
						return (T) lResults.get(0);						
					}else{
					}
				}
			}else{
				convertedResult = result;
			}
		}else if(evaluationContext.isValuesListReturned()){
			//collection values expected as result
			if(!Collection.class.isAssignableFrom(result.getClass())){
				List lResults = new ArrayList();
				if(Map.class.isAssignableFrom(result.getClass())){
					//insert map values in the output collection
					lResults.addAll(((Map)result).values());
				}else{
					//insert single value in the output collection
					lResults.add(result);
				}
				convertedResult = lResults;								
			}else{
				convertedResult = result;				
			}
		}else{
			convertedResult = result;			
		}

		//null value
		if(convertedResult == null){
			return null;
		}
		
		//validate type
		validateResultType(convertedResult.getClass(), evaluationContext);

		return (T) convertedResult;
	}
	
	
	/**
	 * this method can be used for validate the result type.
	 * Throw exception for invalid type 
	 * @throws QueryEvaluatorException
	 */
	protected void validateResultType(Class<?> resultType, QueryEvaluationContext evaluationContext) throws QueryEvaluatorException{
		Class<?> expectedType = evaluationContext.getReturnType();
		if(Collection.class.isAssignableFrom(expectedType)){
			expectedType = Collection.class;
		}
		if(!expectedType.isAssignableFrom(resultType)){
			throw new QueryEvaluatorException("Query '" + evaluationContext.getQuery() 
						+ "' should returns result of type '" + evaluationContext.getReturnType().getName() + "' " +
						"'" + resultType.getName()	+	"' returned result is incompatible.");
		}
	}
	

	
	
	/**
	 * Model cache accessor
	 * @return
	 */
	protected ModelCache getModelCache(){
		return modelCache;
	}

	
	/**
	 * Returns the ordered list of subqueries arguments
	 * @param arguments
	 * @return
	 */
	protected List<Object> extractSubqueriesArgumentsList(Map<String, Object> arguments){
		return QueryEvaluatorUtil.extractSubqueriesArgumentsList(arguments);
	}
	
	/**
	 * Returns an ordered Map of subqueries arguments (subquery 1, ... subquery n)
	 * @param arguments
	 * @return
	 */
	protected Map<String, Object> extractSubqueriesArguments(Map<String, Object> arguments){
		return QueryEvaluatorUtil.extractSubqueriesArguments(arguments);
	}
	
	protected Object[] extractAndValidateSubqueriesAsParameters(String funcName, String queryExpr, int minParmNumber, int maxParmNumber, Map<String, Object> arguments) throws QueryEvaluatorException{
		List<Object> subqueriesAsParameters  = extractSubqueriesArgumentsList(arguments);
		
		if(subqueriesAsParameters.size() < minParmNumber || subqueriesAsParameters.size() > maxParmNumber ){
			throw queryEvaluatorException(funcName, "Expect between " + minParmNumber + " and " + maxParmNumber +  " parameters." +
					" Query provides " + subqueriesAsParameters.size() + " parameters. (Query:" + queryExpr + ")");			
		}
		
		return subqueriesAsParameters.toArray();
	}

	
	
	//----------------------------
	// Checks before evaluation.
	//-----------------------------

	//Contants Flags for validation
	protected static boolean NULL_CONTEXT_ALLOWED = true;
	protected static boolean NULL_CONTEXT_IS_NOT_ALLOWED = false;
	protected static boolean RESOURCE_IS_REQUIRED = true;
	protected static boolean RESOURCE_IS_NOT_REQUIRED = false;
	
	
	/**
	 * Validate the context: type compatibility and not null. 
	 * if validation fails then throws QueryEvaluatorException
	 * 
	 * @param expectedType type expected for the context
	 * @param context 
	 * @param nullContextAllowed if true and context is {@code null} an exception is thrown
	 * @throws QueryEvaluatorException
	 */
	protected void validateContext(String funcName, Class<?> expectedType, Object context, boolean nullContextAllowed) throws QueryEvaluatorException{
		if(context == null){
			if(nullContextAllowed){
				return;
			}else{
				throw queryEvaluatorException(funcName, "Context is null.");
			}			
		} 

		if(!expectedType.isAssignableFrom(context.getClass())){
			throw queryEvaluatorException(funcName, "Expects " + expectedType.getName() + " as context " + context.getClass() + " is not compatible.");
		}

		if(EObject.class.isAssignableFrom(context.getClass()) && ((EObject)context).eResource() == null){
			throw queryEvaluatorException(funcName, "Context have not resource. (" + context + ")");			
		}
		
	}

	
	/**
	 * Validate context:
	 * it must be an EObject or null if nullContextAllowed
	 * if resourceIsResquired is true , the context must have a valid resource.
	 * When context object is null the resourceIsResquired validation is skipped.
	 * If validation fails a {@link QueryEvaluatorException} is thrown.
	 * @param funcName
	 * @param context
	 * @param nullContextAllowed
	 * @param resourceIsResquired
	 * @throws QueryEvaluatorException
	 */
	protected void validateContextAsEObject(String funcName, Object context, boolean nullContextAllowed, boolean resourceIsResquired) throws QueryEvaluatorException{
		if(context == null){
			if(nullContextAllowed){
				return;
			}else{
				throw queryEvaluatorException(funcName, "Context is null.");
			}			
		} 

		if(!EObject.class.isAssignableFrom(context.getClass())){
			throw queryEvaluatorException(funcName, "Expects EObject as context " + context.getClass() + " is not compatible.");
		}

		if( context != null  && resourceIsResquired &&  ((EObject)context).eResource() == null){
			throw queryEvaluatorException(funcName, "Context have not resource. (" + context + ")");			
		}
		
	}

	/**
	 * Validate arguments number
	 * 
	 * @param funcName
	 * @param minParmNumber
	 * @param maxParmNumber
	 * @param arguments
	 * @throws QueryEvaluatorException
	 */
	protected void validateFunctionArguments(String funcName, int minParmNumber, int maxParmNumber, List<Object> arguments) throws QueryEvaluatorException{
		
		if(arguments.size() < minParmNumber || arguments.size() > maxParmNumber ){
			throw queryEvaluatorException(funcName, "Expect between " + minParmNumber + " and " + maxParmNumber +  " parameters." +
					" Function call provides " + arguments.size() + " parameters.");			
		}
		
	}
	
	
	/**
	 * Base function processor for parsing evaluators prefixed grammar 
	 */
	protected abstract class AbstractBaseFunctionProcessor implements FunctionProcessor{

		protected QueryEvaluationContext evaluationContext;
		
		/**
		 * Using strict mode, if a variable doesn't exists an exception is thrown
		 */
		protected boolean useStrictMode = true;
		
		public AbstractBaseFunctionProcessor(QueryEvaluationContext evaluationContext) {
			super();
			this.evaluationContext = evaluationContext;
		}

		@Override
		public Object caseIdentifier(String identifier) throws FunctionProcessingException {
			//unused at this time
			return null;
		}

		/**
		 * Return the variable value from arguments Map.
		 */
		@Override
		public Object caseVar(String varname) throws FunctionProcessingException {
			
			//convert to argument name
			String argumentName = varname; 
			if(useStrictMode && !evaluationContext.getArguments().containsKey(argumentName)){
				throw new FunctionProcessingException("Unknow variable:" + argumentName);				
			}			
			//variable are typed value:
			TypedValue typedVariable = evaluationContext.getArguments().get(argumentName);
			if(evaluationContext.isEvaluationAnalyzeRequired() && canUseProxies()){
				//return a proxy for the variable value
				return ContextObjectInvocationHandler.createProxy(typedVariable.getValue());
			}else{
				//return the variable value
				return typedVariable.getValue();				
			}
		}

		/**
		 * String literal: returns the string value
		 */
		@Override
		public Object caseString(String value) throws FunctionProcessingException {
			return value;
		}

		/**
		 * Boolean literal: returns the boolean value
		 */
		@Override
		public Object caseBoolean(boolean value) throws FunctionProcessingException {
			return value;
		}

		/**
		 * Integer literal: returns the integer value
		 */
		@Override
		public Object caseInteger(int value) throws FunctionProcessingException {
			return value;
		}

		/**
		 * Decimal literal: return the double value
		 */
		@Override
		public Object caseDecimal(double value) throws FunctionProcessingException {
			return value;
		}

		/**
		 * All argument are ready, we have to eval the function
		 * if function not exists throws an exception
		 * if arguments are not conform throws an exception
		 * evaluates the function and returns the result.
		 */
		@Override
		public abstract Object evalFunction(String funcname, List<Object> arguments) throws FunctionProcessingException;
		
	}
	
	
	//-------------------------------------------
	// Evaluation / query validation exceptions
	//-------------------------------------------
		
	protected QueryEvaluatorException createEvaluatorQueryException(String message){
		return new QueryEvaluatorException(exceptionBaseMessage() + message);
	}

	protected QueryEvaluatorException queryEvaluatorException(String funcName, String message){
		return new QueryEvaluatorException(exceptionBaseMessage() + funcName + ":" + message + ".");
	}


	protected QueryEvaluatorException createUnknowFunctionException(String funcname){
		return new QueryEvaluatorException(exceptionBaseMessage() + " Unknow function " + funcname + ".");
	}

	protected QueryEvaluatorException createInvalidContextException(String queryExpr,Object context, Class<?> expectedType){
		return new QueryEvaluatorException(exceptionBaseMessage() + "Query:" + queryExpr + ":" + "context is invalid. Expecting type " + expectedType.getName() + "(received context:" + context + ")");
	}

	protected QueryEvaluatorException createEvaluationException(String funcname, List<Object> arguments, Throwable e){
		return new QueryEvaluatorException(exceptionBaseMessage() + " Error during evaluation " +
				"function:" + funcname + 
				" arguments:" + arguments + ".",
				e);
	}

	
	protected QueryEvaluatorException createInvalidContextTypeException(String queryExpr, Class<?> contextType, Class<?> expectedType){
		return new QueryEvaluatorException(exceptionBaseMessage() + "Query:" + queryExpr + ":" + "context is invalid. Expecting type " + expectedType.getName() + " context type is " + contextType.getName());
	}

	protected QueryEvaluatorException queryEvaluatorException(String queryExpr, String message, Throwable orgException){
		return new QueryEvaluatorException(exceptionBaseMessage() + "Query:" + queryExpr + ":" + message + ". " + orgException.getMessage(), orgException);
	}

	protected QueryEvaluatorException createInvalidQueryException(String queryExpr, String message){
		return new QueryEvaluatorException(exceptionBaseMessage() + "Query:" + queryExpr + ": query is invalid. " + message);
	}

	protected QueryEvaluatorException createEvaluatorQueryException(String queryExpr, String message){
		return new QueryEvaluatorException(exceptionBaseMessage() + "Query:" + queryExpr + ":"  + message);
	}
	
	protected String exceptionBaseMessage(){
		return getLanguageId() + " - ";
	}

}
