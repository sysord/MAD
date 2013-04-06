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
package com.sysord.mad.mao.impl;

import java.util.Collection;

import javax.management.RuntimeErrorException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.emf.tools.misc.EMFImageProvider;
import com.sysord.mad.command.AbstractMadCommand;
import com.sysord.mad.command.MadCommand;
import com.sysord.mad.configuration.CommandDefinition;
import com.sysord.mad.configuration.CommandDefinition.COMMAND_CATEGORY;
import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.emitter.ViewBuilder;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluatorException;
import com.sysord.mad.mao.MaoCommand;
import com.sysord.mad.mao.ValuedSemanticElement;
import com.sysord.mad.mao.ValuedSemanticElement.ACCESS_CATEGORY;
import com.sysord.mad.query.QueryDefinition;
import com.sysord.mad.query.impl.MADQueryUtil;
import com.sysord.mad.uicommand.MadUICommandService;
import com.sysord.mad.widget.NavigationWidget;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.adapter.SelectedItemProvider;
import com.sysord.xtext.tools.editor.XtextElementEditorException;
import com.sysord.xtext.tools.editor.XtextElementEditorHelper;

public class MadWidgetCommandFactory {

	@Inject
	protected QueryEvaluationService evaluationService;

	@Inject
	protected MadUICommandService uiCommandService;

	@Inject
	protected ViewBuilder viewBuilder;

	@Inject 
	protected ConsoleLogger logger;
	
	@Inject
	protected EMFImageProvider emfProvider;

	
	/**
	 * Create and add commands to the widget
	 * @param widget
	 */
	public <T> void createWidgetCommands(Widget<T> widget){
		//Specific commands (defined in MadConfigDsl)
		//--------------------------------------------
		for(CommandDefinition commandDef : widget.getConfig().getWidgetCommands()){
			MadCommand command = createWidgetCommand(widget, commandDef);
			widget.addCommand(commandDef.getCommandId(), command);
		}
	}
	
	/**
	 * Create and add only global commands commands to the widget
	 * @param widget
	 */
	public <T> void createGlobalCommands(Widget<T> widget){
		//Specific commands (defined in MadConfigDsl)
		//--------------------------------------------
		for(CommandDefinition commandDef : widget.getConfig().getWidgetCommands()){
			if(commandDef.getCommandCategory() == COMMAND_CATEGORY.GLOBAL_COMMAND){
				MadCommand command = createWidgetCommand(widget, commandDef);
				widget.addCommand(commandDef.getCommandId(), command);				
			}
		}
	}

	/**
	 * Create the update Command for the widget.
	 * the command must set the widget value to the element feature.
	 * if no update command can be created the method returns false.
	 * @param widget
	 * @return true if an update has been created and added to the widget, false otherwise.
	 */
	public <T> boolean createUpdateCommand(Widget<T> widget){
		MadCommand updateCommand = null; 
		//if exists specific update command use it:
		CommandDefinition updateCommandDef = widget.getConfig().getWidgetCommand(MaoCommand.UPDATE_COMMAND);
		if(updateCommandDef != null){
			//update command defined in MadConfigDsl
			updateCommand = createWidgetCommand(widget, updateCommandDef);
		}else{
			ValuedSemanticElement valuedElement = widget.getValuedSemanticElement();
			if(widget.getValuedSemanticElement().getAccesCategory() == ACCESS_CATEGORY.PROPERTY){
				//Create a set feature command using Evaluation analyze result
				//Only property set is supported (to improve...)
				updateCommand = createUpdateFeatureCommand(valuedElement);			
			}else if(widget.getValuedSemanticElement().getAccesCategory() == ACCESS_CATEGORY.CONTAINER){
				//value is the context container, update conists in change the context container.
				updateCommand = createChangeContainerCommand(valuedElement);
			}
		}

		//add updatecommand
		if(updateCommand == null){
			return false;
		}else{
			widget.addCommand(MaoCommand.UPDATE_COMMAND, updateCommand);
			return true;
		}

	}

		
	/**
	 * Create update command for set the new value to the owning feature
	 * @param valuedElement
	 * @return
	 */
	protected <T> MadCommand createUpdateFeatureCommand(final ValuedSemanticElement valuedElement){
		//Create a set feature command using Evaluation analyze result
		//Only property set is supported (to improve...)
		MadCommand updateCommand = new AbstractMadCommand() {					
			@Override
			public void execute() {
				ItemProviderAdapter itemProvider = emfProvider.getItemProviderAdapter(valuedElement.getElement());
				if (itemProvider != null) {
					IItemPropertyDescriptor descriptor = itemProvider.getPropertyDescriptor(valuedElement.getElement(),
							valuedElement.getFeature());
					if (descriptor != null) {
						descriptor.setPropertyValue(valuedElement.getElement(), valuedElement.getValue());
						return;// Value was updated
					}
				}
				// In case no ItemProviderAdapter or IItemPropertyDescriptor were found
				valuedElement.getElement().eSet(valuedElement.getFeature(), valuedElement.getValue());
			}
		};
		
		return updateCommand;
	}
	

	/**
	 * Create update command change the context eContainer
	 * ValuedSemanticElement is configured as follow:
	 * 		value: is the container to change
	 * 		element: is the contained element (could be the original context object)
	 * @param valuedElement
	 * @return
	 */
	protected <T> MadCommand createChangeContainerCommand(final ValuedSemanticElement valuedElement){
		MadCommand 	updateCommand = new AbstractMadCommand() {					
			@Override
			public void execute() {
				//Valued element is configured: value is the container to change, element is the contained element (may be the original context object)
				try {
					if(valuedElement.getValue() != null){
						EObject eValue = (EObject)valuedElement.getValue();
						if(valuedElement.getFeature().isMany()){
							//container is a collection
							Collection container = (Collection) eValue.eGet(valuedElement.getFeature());
							container.add(valuedElement.getElement());
						}else{
							//container is simple reference
							eValue.eSet(valuedElement.getFeature(), valuedElement.getElement()) ;														
						}
					}else{
						if(valuedElement.getFeature().isMany()){
							//container is a collection: remove contained element
							Collection container = (Collection) valuedElement.getElement().eContainer().eGet(valuedElement.getFeature());
							container.remove(valuedElement.getElement());
						}else{ 
							//container is simple reference: unreference
							EObject container = (EObject) valuedElement.getElement().eContainer();
							container.eSet(valuedElement.getFeature(), null) ;														
						}
						
					}
				} catch (Exception e) {
					//log error and relay exception
					e.printStackTrace();
					logger.logError(e);
					throw new RuntimeException(e);
				}
			}
		};						
		return updateCommand;
	}

	
	/**
	 * Create and returns a Xtext element update Command.
	 * the command retrieve the location of the original value element in the XtextDocument (text)
	 * and replace value element text by the new value element text .
	 * @param widget
	 */
	public <T> boolean createXtextElementUpdateCommand(Widget<T> widget){
		final ValuedSemanticElement valuedElement = widget.getValuedSemanticElement();
		MadCommand updateCommand = null;
		EObject originalValueElement = (EObject) valuedElement.getValue();
		if(originalValueElement != null){			
			final String originalValueElementUri = valuedElement.getElement().eResource().getURIFragment(originalValueElement);
			updateCommand = new AbstractMadCommand() {					
				@Override
				public void execute() {						
					try {
						//owner element is owned by the original resource
						EObject ownerElement = (EObject) valuedElement.getElement();
						//new value coming from a cloned resource
						EObject newValue = (EObject) valuedElement.getValue();
						//System.out.println(ownerElement.eResource() + "   " + newValue.eResource());
						//Merge new value element in the original resource
						EObject mergedValue = XtextElementEditorHelper.mergeXtextEditedElement(
							(XtextResource)newValue.eResource(),
							originalValueElementUri,
							(XtextResource)ownerElement.eResource(),
							false
						);
						valuedElement.setElement(mergedValue.eContainer());
						valuedElement.setValue(mergedValue);
					} catch (Exception e) {
						//log error and relay exception
						e.printStackTrace();
						logger.logError(e);
						throw new RuntimeException(e);
					}										
				}
			};
		
		}

		//add updatecommand
		if(updateCommand == null){
			return false;
		}else{			
			widget.addCommand(MaoCommand.UPDATE_COMMAND, updateCommand);
			return true;
		}


	}
	
	
	public <T> void createNavigationCommand(final NavigationWidget widget) {
		//TODO: use a specific property for get target template
		final TypeConfiguration targetTypeConfiguration = widget.getConfig().getFlexibleTemplate();
		MadCommand navigationCommand = new AbstractMadCommand() {
			@Override
			public void execute() {
				viewBuilder.createView(widget.getSemanticElementNavigation(), targetTypeConfiguration, null);
			}
		};
		widget.addCommand(MaoCommand.NAVIGATION_COMMAND, navigationCommand);
	}


	
	/**
	 * Create command for run the ActionQuery
	 * @param widget
	 * @param commandDef
	 * @return
	 */
	protected <T> MadCommand createWidgetCommand(final Widget<T> widget, CommandDefinition commandDef){
		if(MaoCommand.UPDATE_COMMAND.equals(commandDef.getCommandId())){
			return createGlobalCommand(widget, commandDef);
		}

		if(commandDef.getCommandCategory() == COMMAND_CATEGORY.GLOBAL_COMMAND){
			return createGlobalCommand(widget, commandDef);
		}

		if(commandDef.getCommandCategory() == COMMAND_CATEGORY.ITEM_COMMAND){
			return createItemCommand(widget, commandDef);
		}

		return null;
	}

	
	/**
	 * Create an item command for a widget
	 * widget must provide the SelectedItemProvider as adapter.
	 * the selected item must be an EObject.
	 * command will be execute with selected element as context 
	 * @param widget
	 * @param commandDef
	 */
	protected <T> MadCommand createItemCommand(final Widget<T> widget, final CommandDefinition commandDef) {
		final QueryDefinition<?> actionQuery = commandDef.getQueryAction();
		final QueryEvaluationService evaluationService = this.evaluationService;
		final SelectedItemProvider selectedItemProvider = widget.getAdapter(SelectedItemProvider.class);
		if(selectedItemProvider == null){
			logger.logError("Item command '" + commandDef.getCommandId() 
							+ "' can't be created because widget '" + widget.getId() 
							+ "' doesn't provide a SelectedItemProvider.");
			return null; 
		}
		MadCommand itemCommand = new AbstractMadCommand() {
			@Override
			public void execute() {
				try {
					Object actionResult = null; 					
					if(selectedItemProvider.getSelectedItem() != null){
						//run query action
						actionResult = evaluationService.runActionQuery(selectedItemProvider.getSelectedItem(), actionQuery, MADQueryUtil.createArguments(widget));
						//run ui commands on success
						uiCommandService.createAndLaunchUICommands(null, actionResult, commandDef.getOnSuccessPostActionCommands());						
					}
				} catch (QueryEvaluatorException e) { 
					//run on error ui commands 
					uiCommandService.createAndLaunchUICommands(null, widget.getContextElement(), commandDef.getOnErrorPostActionCommands());					
					throw new RuntimeException(e);
				}
			}
		};
		widget.addCommand(commandDef.getCommandId(), itemCommand);
		return itemCommand;
	}

	/**
	 * Create command for run the ActionQuery
	 * @param widget
	 * @param commandDef
	 * @return
	 */
	protected <T> MadCommand createGlobalCommand(final Widget<T> widget, final CommandDefinition commandDef){
		final QueryDefinition<?> actionQuery = commandDef.getQueryAction();
		final QueryEvaluationService evaluationService = this.evaluationService;
		MadCommand command = new AbstractMadCommand() {			
			@Override
			public void execute() {
				try {
					Object actionResult = null;
					//run query action
					actionResult = evaluationService.runActionQuery(widget.getContextElement(), actionQuery, MADQueryUtil.createArguments(widget));
					//run on success ui commands
					uiCommandService.createAndLaunchUICommands(widget, actionResult, commandDef.getOnSuccessPostActionCommands());
				} catch (QueryEvaluatorException e) {
					//run on error ui commands 
					uiCommandService.createAndLaunchUICommands(widget, widget.getContextElement(), commandDef.getOnErrorPostActionCommands());					
					throw new RuntimeException(e);
				}
			}
		};
		return command;
	}
	
	
}
