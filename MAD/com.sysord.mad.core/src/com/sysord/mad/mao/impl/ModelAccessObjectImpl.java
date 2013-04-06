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

import com.google.inject.Inject;
import com.sysord.eclipse.tools.diagnostic.DiagnosticFactory;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.command.MadCommand;
import com.sysord.mad.configuration.WidgetConfiguration.WIDGET_CATEGORY;
import com.sysord.mad.core.Activator;
import com.sysord.mad.core.preferences.PreferenceHelper;
import com.sysord.mad.emitter.ModelElementView;
import com.sysord.mad.mao.MaoCommand;
import com.sysord.mad.mao.MaoException;
import com.sysord.mad.mao.ModelAccessObject;
import com.sysord.mad.mao.TransactionalCommandProvider;
import com.sysord.mad.mao.ValuedSemanticElement;
import com.sysord.mad.model.cache.ModelCache;
import com.sysord.mad.widget.InputWidget;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.WidgetVisitor;

public class ModelAccessObjectImpl implements ModelAccessObject {

	@Inject
	protected ConsoleLogger logger;
	
	@Inject
	protected ModelCache modelCache;
	
	WidgetVisitor<Boolean> loadWidgetValueVisitor;
	
    TransactionalCommandProvider transactionalCommandProvider;
    
		
	public ModelAccessObjectImpl() {
		super();
	}

	@Override
	public void loadViewValues(ModelElementView modelElementView) throws MaoException {
		for(Widget<?> widget : modelElementView.getWidgets()){
			try {
				loadWidgetValue(widget);
			} catch (Exception e) {
				String errorMessage = "Widget " + widget.getId()  + ": fail to load value. (error message:" + e.getMessage() + ")"; 
				logger.logError(errorMessage);
				if(!PreferenceHelper.getDebugMode()){
					//if not debug mode, hide the widget
					widget.setVisible(false);					
				}else{
					widget.setStatus(DiagnosticFactory.createErrorDiagnostic(errorMessage, e));
					if(InputWidget.class.isAssignableFrom(widget.getClass())){
						((InputWidget<?>)widget).setEditable(false);											
					}
				}
			}
		}
	}

	@Override
	public void persistViewValues(ModelElementView modelElementView) throws MaoException {
		for(Widget<?> widget : modelElementView.getWidgets()){
			persistWidgetValue(widget);
		}
	}

	@Override
	public void loadWidgetValue(Widget<?> widget) throws MaoException {
		try {
			widget.accept(getLoadWidgetValueVisitor());
		} catch (Exception e) {
			e.printStackTrace();
			throw new MaoException(e);
		}
	}

    @Override
    public void persistWidgetValue(final Widget<?> widget) throws MaoException {
        try {
        	MadCommand updateCommand = widget.getCommand(MaoCommand.UPDATE_COMMAND);
        	if(updateCommand != null){
        		
        		ValuedSemanticElement valuedSemanticElement = widget.getValuedSemanticElement();
        		
        		if(!_widgetValueIsValid(valuedSemanticElement, widget.getId())){
        			return;
        		}
        		
        		//Execute update command as transactional command
        		createTransactionnalMadCommand(valuedSemanticElement, updateCommand).execute();
        		//When element is not owned by the main editing model: we have to save its resource 
            	if(valuedSemanticElement.isForeignModelElement() && valuedSemanticElement.getElement() != null){
            		//save dirties models
            		if(isAutosaveEnabled()){
            			modelCache.flush();
            			//flush evict the model, reload widget value
            			//Xtext editor are since reloaded with the merged element
            			if(widget.getConfig().getWidgCategory() != WIDGET_CATEGORY.XTEXT_ELEMENT_EDITOR_WIDGET 
            				&& widget.getConfig().getWidgCategory() != WIDGET_CATEGORY.XTEXT_TEXT_EDITOR_WIDGET){
    						loadWidgetValue(widget);            				
            			}
            		}            		
        		}
        	}else{
            	logger.log("ModelAccessObject: no update command for persist value of widget '" + widget.getId() + "' value will not be persisted." , ConsoleLogger.VERY_LOW);
        	}
        } catch (Exception e) {
        	logger.logError("ModelAccessObject: fail to persist value for widget '" + widget.getId() + "' :" + e.getMessage());
            throw new MaoException(e);
        }
    } 
    
    
    
    protected boolean isAutosaveEnabled(){
    	return PreferenceHelper.getAutoSave();
    }

    /**
     * Validate widget value before save
     * - value not null
     * - value element is attached to a valid resource
     * 
     * @return true if valid
     */
    protected boolean _widgetValueIsValid(ValuedSemanticElement valuedSemanticElement, String widgetId){
    	if(valuedSemanticElement == null){
        	logger.logError("ModelAccessObject: no value for widget '" + widgetId + "' value will not be persisted.");
        	return false;
    	}

    	if(valuedSemanticElement.getElement().eResource() == null){
        	logger.logError("ModelAccessObject: value container have no valid resource.'" + widgetId + "' value will not be persisted.");
        	return false;
    	}

    	return true;
    }
    
    @Override
    public MadCommand createTransactionnalMadCommand(ValuedSemanticElement processedElement, MadCommand baseCommand){
    	return getTransactionalCommandProvider().createTransactionalCommand(processedElement, baseCommand);
    }
    
    
	public WidgetVisitor<Boolean> getLoadWidgetValueVisitor() {
		if (loadWidgetValueVisitor == null) {
			loadWidgetValueVisitor = Activator.getDefault().getInjector().getInstance(LoadWidgetValueVisitor.class);
		}
		return loadWidgetValueVisitor;
	}

    public TransactionalCommandProvider getTransactionalCommandProvider() {
        if (transactionalCommandProvider == null) {
        	transactionalCommandProvider = Activator.getDefault().getInjector().getInstance(TransactionalCommandProvider.class);
        }
        return transactionalCommandProvider;
    }

}
