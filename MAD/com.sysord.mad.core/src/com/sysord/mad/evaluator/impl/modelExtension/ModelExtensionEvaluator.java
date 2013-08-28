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
package com.sysord.mad.evaluator.impl.modelExtension;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.evaluator.QueryAnalyze;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.evaluator.QueryResult;
import com.sysord.mad.evaluator.impl.AbstractQueryEvaluator;
import com.sysord.mad.evaluator.impl.QueryEvaluatorUtil;
import com.sysord.mad.functionparser.FunctionProcessingException;
import com.sysord.mad.model.EditedModel;
import com.sysord.mad.model.cache.ModelCache;
import com.sysord.mad.model.provider.ModelExtensionManager;

public class ModelExtensionEvaluator extends AbstractQueryEvaluator {

	public static final String MODEL_EXTENSION__LANGUAGE_ID = "MODEL_EXTENSION";

	
	public static final String ELEMENT_EXTENSION = "ELEMENT_EXTENSION";
	public static final String EXTENSION = "EXTENSION";
	
		
	@Override
	public String getLanguageId() {
		return MODEL_EXTENSION__LANGUAGE_ID;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T> QueryResult processEvaluation(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		try {
			//MODEL_EXTENSION queries are only String Query expression. 
			if(!(evaluationContext.getQuery() instanceof String)){
				throw createInvalidQueryException(evaluationContext.getQuery().toString(), "MODEL_EXTENSION evaluator supports only Query expression.");
			}
			//extract query instruction		
			String queryExpression = (String) evaluationContext.getQuery();
			
			//context must be an EObject
			validateContextAsEObject(MODEL_EXTENSION__LANGUAGE_ID, evaluationContext.getContextObject(), NULL_CONTEXT_ALLOWED, RESOURCE_IS_REQUIRED);
			
			Object contextObject = evaluationContext.getContextObject();
			Object result = null;
			//Null context return null extension
			if(contextObject != null){						
				//ascending compatibility: "" was allowed in Model extension queries.
				if("".equals(queryExpression)){
					result = contextObject;
				}else{
					//parse and evaluate query
					ModelExtensionEvaluatorFunctionProcessor processor = new ModelExtensionEvaluatorFunctionProcessor(evaluationContext);
					result = QueryEvaluatorUtil.parseQuery((String) evaluationContext.getQuery(), processor);					
				}
			}
			//create and return Query result.
			return createDefaultQueryResult(result);

		} catch (QueryEvaluatorException e) {
			throw e;
		} catch (Exception e) {
			throw new QueryEvaluatorException(e);
		}

	}
	

	protected class ModelExtensionEvaluatorFunctionProcessor extends AbstractBaseFunctionProcessor{

		public ModelExtensionEvaluatorFunctionProcessor(QueryEvaluationContext evaluationContext) {
			super(evaluationContext);
		}

		/**
		 * All argument are ready, we have to evaluate the function
		 * if function not exists throws an exception
		 * if arguments are not conform throws an exception
		 * evaluates the function and returns the result.
		 */
		@Override
		public Object evalFunction(String funcname, List<Object> arguments) throws FunctionProcessingException {
			try {
				return evaluateModelExtensionFunction(funcname, arguments, evaluationContext, evaluationContext.getContextObject());
			} catch (QueryEvaluatorException e) {
				throw new FunctionProcessingException("Fail during '" + funcname + "' evaluation.", e);
			}
		}
		
	}

	
	protected Object evaluateModelExtensionFunction(String funcName, List<Object> functionArguments, 
													QueryEvaluationContext evaluationContext, 
													Object contextObjectOrProxy) throws QueryEvaluatorException{
		try {
			
			if(funcName.startsWith(ELEMENT_EXTENSION)){
				return process_ELEMENT_EXTENSION(contextObjectOrProxy, functionArguments, evaluationContext);
			}

			if(funcName.startsWith(EXTENSION)){
				return process_EXTENSION(contextObjectOrProxy, functionArguments, evaluationContext);
			}

			throw createInvalidQueryException(funcName, "function '" + funcName + "' not found.");

		} catch (QueryEvaluatorException e) {
			throw e;
		} catch (Exception e) {
			throw new QueryEvaluatorException(e);
		}
		
	}


	
		
	/**
	 * Get a specific extension or the extensions container for an extended element 
	 * Element are retrieved using the ModelExtensionManager associated to the model. 
	 * 
	 * function ELEMENT_EXTENSION:
	 * 
	 * format: ELEMENT_EXTENSIONS(extendedElement, extensionType, discriminator)
	 * Parameters:
	 * 		extendedElement: extended element 
	 * 		extensionTypeName: Type Name for the searched extension (optional)
	 * 		discriminator: discriminator for the searched extension (optional)
	 * 
	 * Return:
	 * if extensionTypeName is provided search and returns the extension of type ExtensionTypeName 
	 * if extensionTypeName is not provided returns the extension container.
	 * 
	 * @param contextObject UMLExtensionModel
	 * @param queryDefinition
	 * @return 
	 * @throws QueryEvaluatorException 
	 */
	private <T> EObject process_ELEMENT_EXTENSION(Object contextObject, List<Object> arguments, QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {

		
		try {

			//Context object is an EObject, it must not be detached (have a resource)
			validateContextAsEObject(ELEMENT_EXTENSION, contextObject, NULL_CONTEXT_IS_NOT_ALLOWED, RESOURCE_IS_REQUIRED);	
			EObject contextEObject = (EObject) contextObject;

			//Get the modelExtensionManager associated to the extension model
			ModelExtensionManager extensionManager = getModelExtensionManager(contextEObject);

			
			//Validate parameters: min 1 / max 3
			validateFunctionArguments(ELEMENT_EXTENSION, 1, 3, arguments);
						
			//Initialize parameters
			EObject extendedElement = (EObject) arguments.get(0);
			String extensionTypeName =  arguments.size() >= 2 ? (String) arguments.get(1) : null;
			String discriminator = 		arguments.size() >= 3 ? (String) arguments.get(1) : null;
			
			
			if(extendedElement == null){
				throw createInvalidQueryException(evaluationContext.getQuery().toString(), "Extended element is null.");
			}
			
			//delegate search and create if not exists to extension manager.
			EObject result =  extensionManager.getElementExtension(contextEObject, extendedElement, extensionTypeName, discriminator, true);
			
			//fill analyze
			fillAnalyze(result);
			
			//save if change occurs
			saveModelIfModified(contextEObject);
			
			return result;

		} catch (QueryEvaluatorException e) {
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
			throw new QueryEvaluatorException(e);
			//return null;
		}
		
		
	}

		
	
	/**
	 * Get a specific extension contained by an extensions container (the contextObject).
	 * Element are retrieved using the ModelExtensionManager associated to the model. 
	 * 
	 * Query EXTENSION:
	 * 
	 * format: EXTENSIONS(extensionTypeName, discriminator)
	 * Context: an extensions container
	 * Parameters:
	 * 		extensionTypeName: Type Name for the searched extension
	 * 		discriminator: discriminator for the searched extension (optional)
	 * 
	 * Return:
	 * if extensionTypeName is provided search and returns the extension of type ExtensionTypeName 
	 * if extensionTypeName is not provided returns the extension container.
	 * 
	 * @param contextObject UMLExtensionModel
	 * @param queryDefinition
	 * @return 
	 * @throws QueryEvaluatorException 
	 */
	private <T> EObject process_EXTENSION(Object contextObject, List<Object> arguments, QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
				
		try {

			//Context object is an EObject, it must not be detached (have a resource)
			validateContextAsEObject(ELEMENT_EXTENSION, contextObject, NULL_CONTEXT_IS_NOT_ALLOWED, RESOURCE_IS_REQUIRED);	
			EObject contextEObject = (EObject) contextObject;

			//Get the modelExtensionManager associated to the extension model
			ModelExtensionManager extensionManager = getModelExtensionManager(contextEObject);
			
			//Extract parameters: min 1 / max 2
			validateFunctionArguments(EXTENSION, 1, 2, arguments);
						
			//Initialize parameters
			String extensionTypeName = (String) arguments.get(0);
			String discriminator = 	arguments.size() >= 2 ? (String) arguments.get(1): null;			
			
			EObject result =  extensionManager.getContainedExtension(contextEObject, extensionTypeName, discriminator, true);
			
			//fill analyze
			fillAnalyze(result);

			//save if change occurs
			saveModelIfModified(contextEObject);

			return result;

		} catch (QueryEvaluatorException e) {
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	/**
	 * returns the ModelExtensionManager associated to the contextObject model.
	 * 
	 * @param contextObject
	 * @return
	 * @throws QueryEvaluatorException
	 * 			if model doesn't exists in model cache	
	 * 			if model doesn't provide an extension manager
	 */
	protected ModelExtensionManager getModelExtensionManager(EObject contextObject) throws QueryEvaluatorException{
		//Get Model from cache
		EditedModel model = getEditedModel(contextObject);
		//model must provide an extension manager
		if(model.getExtensionManager() == null){
			throw createEvaluatorQueryException("ModelExtensionEvaluator: " + model.getModelResource().getURI() + " have not extension manager. Can't execute query.");
		}
		return model.getExtensionManager();
	}
	
	/**
	 * Returns the {@link EditedModel} owning the contextObject from the {@link ModelCache}
	 * @param contextObject
	 * @return
	 * @throws QueryEvaluatorException if no model exists in cache for this contextObject.
	 */
	protected EditedModel getEditedModel(EObject contextObject) throws QueryEvaluatorException{
		//Get Model from cache
		EditedModel model = getModelCache().getModel(contextObject.eResource().getURI());			
		//model must be available
		if(model == null){
			throw createEvaluatorQueryException("ModelExtensionEvaluator: can't find the context model " +  contextObject.eResource().getURI() + ".");
		}
		return model;
	}
	

	/**
	 * If resource have been flagged as modified
	 * request the {@link ModelCache} for saving the model
	 * @param contextObject
	 */
	protected void saveModelIfModified(EObject contextObject){
		if(contextObject.eResource().isModified()){
			getModelCache().persistModel(contextObject.eResource().getURI());
			contextObject.eResource().setModified(false);
		}
	}

	@Override
	public QueryAnalyze analyzeQuery(QueryEvaluationContext evaluationContext) throws QueryEvaluatorException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
