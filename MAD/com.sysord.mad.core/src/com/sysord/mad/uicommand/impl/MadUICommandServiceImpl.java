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
package com.sysord.mad.uicommand.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.configuration.UICommandDefinition;
import com.sysord.mad.emitter.ViewBuilder;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.query.impl.MADQueryUtil;
import com.sysord.mad.uicommand.AbstractMadUICommand;
import com.sysord.mad.uicommand.MadUICommand;
import com.sysord.mad.uicommand.MadUICommandService;
import com.sysord.mad.widget.Widget;

public class MadUICommandServiceImpl implements MadUICommandService {

	@Inject
	protected QueryEvaluationService evaluationService;

	@Inject
	protected ViewBuilder viewBuilder;

	@Inject
	protected ConsoleLogger logger;
	
	@Override
	public void createAndLaunchUICommand(Widget<?> widget, Object commandResult, UICommandDefinition uiCommandDef) {
		createAndLaunchUICommands(widget, commandResult, Arrays.asList(new UICommandDefinition[]{uiCommandDef}));
	}

	@Override
	public void createAndLaunchUICommands(Widget<?> widget, Object commandResult, List<UICommandDefinition> uiCommandsDef) {
		MadUICommand uiCommand = createUiCommand(widget, commandResult, uiCommandsDef);
		Display.getDefault().asyncExec(uiCommand);
	}


	
	/**
	 * Create ui command for evaluate ui commands definitions
	 * @param context
	 * @param uiCommandsDef
	 * @return
	 */
	protected MadUICommand createUiCommand(final Widget<?> widget, final Object commandResult, final List<UICommandDefinition> uiCommandsDef){
		return new AbstractMadUICommand(){
			@Override
			public void execute() {
				try {
					for(UICommandDefinition uiCommandDef : uiCommandsDef){
						switch(uiCommandDef.getCommandType()){
						case RELOAD_VIEW:
							execute_RELOAD_VIEW(commandResult, uiCommandDef);
							break;
						case RELOAD_WIDGETS:
							//TODO: Reload widgets by their id
							break;
						case DISPLAY_VIEW:
							execute_DISPLAY_VIEW(widget, commandResult, uiCommandDef);
							break;
						}			
					}
				} catch (QueryEvaluatorException e) {
					throw new RuntimeException(e);
				}				
			}
			
		};
		
	}
	
	/**
	 * Execute the display view ui command.
	 * try to find the target element evaluating the target query
	 * if target element found, creates and displays the view for the target element.
	 * @param context
	 * @param uiCommandDef
	 * @throws QueryEvaluatorException
	 */
	protected void execute_DISPLAY_VIEW(Widget<?> widget, Object commandResult, UICommandDefinition uiCommandDef) throws QueryEvaluatorException{
		//evaluate target query
		Map<String, Object> arguments = MADQueryUtil.createArguments(widget);
		arguments.put(QueryEvaluationService.COMMAND_RESULT_IDENTIFIER, commandResult);
		
		Object targetObject = evaluationService.evaluate(commandResult, uiCommandDef.getFindTargetQuery(), arguments);
		if(targetObject == null){
			logger.log("DISPLAY_VIEW: No target found for display view.");
			return;
		}
		
		if(!EObject.class.isAssignableFrom(targetObject.getClass())){
			logger.log("DISPLAY_VIEW: Target is not an element (EObject)");
			return;
		}
		
		//create and display the view for the target element
		viewBuilder.createView((EObject)targetObject, null, null);		
		
	}
	
	/**
	 * Execute the reload view ui command.
	 * reload the current view
	 * @param context
	 * @param uiCommandDef
	 */
	protected void execute_RELOAD_VIEW(Object context, UICommandDefinition uiCommandDef){
		viewBuilder.updateCurrentView();
	}

	/**
	 * Execute the reload widgets ui command.
	 * reload the values for widgets defined in the uiCommandDef 
	 * @param context
	 * @param uiCommandDef
	 */
	protected void execute_RELOAD_WIDGETS(Object context, UICommandDefinition uiCommandDef){
		//TODO:
	}

}
