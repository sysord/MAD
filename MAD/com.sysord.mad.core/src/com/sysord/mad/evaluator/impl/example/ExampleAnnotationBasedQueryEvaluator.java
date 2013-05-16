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
package com.sysord.mad.evaluator.impl.example;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.sysord.mad.emitter.ViewHolder;
import com.sysord.mad.evaluator.QueryEvaluationContext;
import com.sysord.mad.evaluator.impl.AbstractAnnotationBasedQueryEvaluator;
import com.sysord.mad.evaluator.impl.EvaluatorFunction;
import com.sysord.mad.widget.Widget;

/**
 * This class shows how to create a custom evaluator.
 * Function are registered using the {@link EvaluatorFunction} annotation.
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class ExampleAnnotationBasedQueryEvaluator extends AbstractAnnotationBasedQueryEvaluator {
	
	@Override
	public String getLanguageId() {
		return "EXAMPLE_ANNOT";
	}
	
	/**
	 * Provides the add(Integer, Integer) function
	 * @param f1 
	 * @param f2
	 * @return the addition result 
	 */
	@EvaluatorFunction
	public Object add(Integer f1, Integer f2){
		return f1 + f2;
	}
	
	/**
	 * Provides the toString(Object) function
	 * @param arg
	 * @return
	 */
	@EvaluatorFunction
	public String toString(Object arg){
		return String.valueOf(arg);
	}

	/**
	 * Provides the parent(EObject) function
	 * the function name is defined by the name property of the annotation
	 * @param eobj
	 * @return
	 */
	@EvaluatorFunction(name="parent")
	public Object getTheParent(EObject eobj){
		return eobj.eContainer();
	}

	@EvaluatorFunction(name="contextType")
	public Object evalContext(QueryEvaluationContext evalContext, Integer i){
		return evalContext.getContextObjectType().getType();
	}
	
	
	
	/**
	 * viewHolder for getting currentView and retrieve widgets
	 */
	@Inject
	ViewHolder viewHolder;
	
	/**
	 * Provides the widgetValue(String) function
	 * retrieves widget from the viewHolder and returns its value.
	 * @param widgetName the widget name defined by the configuration
	 * @return
	 */
	@EvaluatorFunction(name="widgetValue")
	public Object widgetValue(String widgetName){
		for(Widget<?> widget : viewHolder.getCurrentView().getWidgets()){
			if(widgetName.equals(widget.getConfig().getName())){
				return widget.getValuedSemanticElement().getValue();
			}
		}
		return null;
	}

}
