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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class ContextObjectInvocationHandler implements InvocationHandler{
	
	public static boolean TRACE__CONTEXT_OBJECT_INVOCATION_HANDLER = true; 
	
	protected boolean isEObject = false;
	protected Object contextObject;
		

	protected static final String E_GET_FEATURE_METHOD = "eGet";
	protected static final String E_CONTAINER_METHOD = "eContainer";
	protected static final String GET_FEATURE_PREFIX = "get";
	
	/**
	 * Proxies store.
	 */
	protected static Map<Object,Object> proxiesCache = new HashMap<Object,Object>();
	
	/**
	 * Classes excluded for proxy creation. 
	 */
	protected static List<Class<?>> noProxyClasses = Arrays.asList(new Class<?>[]{
		String.class, Integer.class, Double.class, Float.class, java.util.Date.class, Boolean.class	
	});

	public static void clearProxyCache(){
		proxiesCache.clear();
	}

	/**
	 * Create a proxy for the real object
	 * @param realObject
	 * @return
	 */
	public static Object createProxy(Object realObject){
		if(TRACE__CONTEXT_OBJECT_INVOCATION_HANDLER){
			System.out.println("Create proxy for " + realObject.getClass());
		}		
		Object proxy = proxiesCache.get(realObject);
		if(proxy == null){
			ClassLoader classLoader = realObject.getClass().getClassLoader();
			Set<Class<?>> interfaces = new HashSet<Class<?>>(Arrays.asList(realObject.getClass().getInterfaces()));
			Class<?> curclass = realObject.getClass();
			while(curclass != null){
				List<Class<?>> superInterfaces = Arrays.asList(curclass.getInterfaces());
				interfaces.addAll(superInterfaces);
				curclass = curclass.getSuperclass();
			}
			ContextObjectInvocationHandler invocationHandler = new ContextObjectInvocationHandler(realObject);		
			proxy = Proxy.newProxyInstance(classLoader, interfaces.toArray(new Class<?>[0]), invocationHandler);
			proxiesCache.put(realObject, proxy);
		}
		return proxy;
	}
	
	/**
	 * Retrieves the real object if the realObjectOrProxy is a proxy with a ContextObjectInvocationHandler
	 * @param realObjectOrProxy object or proxy
	 * @return if the realObjectOrProxy is a with a ContextObjectInvocationHandler return the real object
	 * otherwise return the realObjectOrProxy.
	 */
	public static Object retrieveRealObject(Object realObjectOrProxy ){
		if(realObjectOrProxy instanceof Proxy && Proxy.getInvocationHandler(realObjectOrProxy) instanceof ContextObjectInvocationHandler) {
			return ((ContextObjectInvocationHandler) Proxy.getInvocationHandler((Proxy)realObjectOrProxy)).getContextObject();
		}else{
			return realObjectOrProxy;
		}
	}

	

	
	
	public ContextObjectInvocationHandler(Object contextObject) {
		super();
		this.contextObject = contextObject;
		isEObject = EObject.class.isAssignableFrom(contextObject.getClass()) ;
		TRACE__CONTEXT_OBJECT_INVOCATION_HANDLER = false;
	}

	public Object getContextObject() {
		return contextObject;
	}



	/**
	 * Analyze all invocations
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
									
			//Invoke the method
			Object result = method.invoke(contextObject, args); 

			if(TRACE__CONTEXT_OBJECT_INVOCATION_HANDLER){
				System.out.println("ContextObjectProxy Method:" + contextObject.getClass().getName() + "." + method.getName());				
			}
			
			if(isEObject){
				//Property access
				if(E_GET_FEATURE_METHOD.equals(method.getName())){
					processEGetMethodInvocation(args, result);
				}else if(E_CONTAINER_METHOD.equals(method.getName())){
					processEContainerMethodInvocation(args, result);					
				}else if(method.getName().startsWith(GET_FEATURE_PREFIX)){
					processGetFeatureMethodInvocation(method.getName().substring(GET_FEATURE_PREFIX.length()), result);										
				}				
			}

			return createProxyIfNeeded(result);
				
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	/**
	 * Create a proxy for the object if needed or possible.
	 * no proxies are created for : Primitive types, Arrays, and java.lang base type 
	 * Proxy are created for {@link Notifier} and {@link EList}.
	 * All invocation result on {@link EList} are converted to proxy if possible.
	 * @param object
	 * @return
	 */
	protected Object createProxyIfNeeded(Object object){

		//Since a proxy
		if(object instanceof Proxy && Proxy.getInvocationHandler(object) instanceof ContextObjectInvocationHandler){
			return object;
		}
		
		//Create proxy for all notifiers. EList and all EList operations results
		//noProxyClasses, Primitive types, arrays, and IEditingDomainProvider are not instrumented.
		if(object != null 
				&& !object.getClass().isPrimitive()
				&& !object.getClass().isArray()
				&& !IEditingDomainProvider.class.isAssignableFrom(object.getClass()) 
				&& !noProxyClasses.contains(object.getClass())
				&& ( Notifier.class.isAssignableFrom(object.getClass()) 
						|| EList.class.isAssignableFrom(object.getClass())
						|| EList.class.isAssignableFrom(contextObject.getClass()))
				){			
				return createProxy(object);					
			}else{
				return object;
			}
	
	}
	
	protected void instrumentArrayItems(Object[] array){
		for(int i = 0; i < array.length; i++){
			array[i] = createProxyIfNeeded(array[i]);
		}
	}
	
		
	/**
	 * Get feature: the method is a getter on an EObject feature
	 * @param substring
	 */
	protected void processGetFeatureMethodInvocation(String featureName, Object result) {
		EObject eObject = (EObject) contextObject;
		EStructuralFeature feature = eObject.eClass().getEStructuralFeature(featureName);
		processGetFeatureMethodInvocation(feature, result);
	}

	protected void processGetFeatureMethodInvocation(EStructuralFeature feature, Object result) {
		EObject eObject = (EObject) contextObject;
		if(feature != null){
			if(result != null && eObject.eContainer() == result){
				//container access
				CurrentEvaluationContext.getEvaluationAnalyze().collectContainerAccess(eObject, feature, null, result);
				if(TRACE__CONTEXT_OBJECT_INVOCATION_HANDLER){
					System.out.println(eObject.eClass().getName() + " access container " + feature.getName());
				}
			}else{
				//property access
				CurrentEvaluationContext.getEvaluationAnalyze().collectPropertyAccess(eObject, feature, null, result);
				if(TRACE__CONTEXT_OBJECT_INVOCATION_HANDLER){
					System.out.println(eObject.eClass().getName() + " access feature " + feature.getName());
				}
			}
		}		
	}

	/**
	 * get container : the method is the eContainer on an EObject.
	 * @param args
	 * @param result
	 */
	protected void processEContainerMethodInvocation(Object[] args, Object result) {
		EObject eObject = (EObject) contextObject;
		EObject eResult = (EObject) result;
		//container access
		if(eResult != null && eObject.eContainingFeature() != null){
			CurrentEvaluationContext.getEvaluationAnalyze().collectContainerAccess(eObject, eObject.eContainingFeature(), null, eResult);
			if(TRACE__CONTEXT_OBJECT_INVOCATION_HANDLER){			
				System.out.println(eObject.eClass().getName() + " access container " + eResult.eContainingFeature().getName());
			}
		}
	}

	/**
	 * Eget: get a feature : feature is passed as argument.
	 * @param args
	 * @param result
	 */
	protected void processEGetMethodInvocation(Object[] args, Object result) {
		//invocation use the: public Object eGet(EStructuralFeature eFeature,...
		if(EStructuralFeature.class.isAssignableFrom(args[0].getClass())){
			processGetFeatureMethodInvocation((EStructuralFeature) args[0], result);
		}else if(args[0].getClass() == int.class){
			EObject eObject = (EObject) contextObject;
			EStructuralFeature eFeature = eObject.eClass().getEStructuralFeature((Integer) args[0]);
			if(TRACE__CONTEXT_OBJECT_INVOCATION_HANDLER){
				System.out.println(eObject.eClass().getName() + " eGet access ...");
			}
			processGetFeatureMethodInvocation(eFeature, result);			
		}
		
	}




	

}
