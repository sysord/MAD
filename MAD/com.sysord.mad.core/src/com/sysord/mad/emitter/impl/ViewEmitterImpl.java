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
package com.sysord.mad.emitter.impl;

import org.eclipse.core.runtime.Assert;

import com.google.inject.Inject;
import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.emitter.*;
import com.sysord.mad.widget.Widget;

/**
 * 
 * Implementation of the ViewEmitter.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ViewEmitterImpl implements ViewEmitter {
    
    protected WidgetFactory widgetFactory;

    protected Context context;

	private EmitterWidgetSwitch emitterSwitch;

    /**
     * Create a new ViewEmitter with a {@link WidgetFactory}.
     * 
     * @param viewHolder
     * @param widgetFactory
     */
    @Inject
    public ViewEmitterImpl(WidgetFactory widgetFactory) {
        this.widgetFactory = widgetFactory;
        emitterSwitch = new EmitterWidgetSwitch(widgetFactory);
    }

    @Override
    public void configure(Context context) {
    	String error = null;
    	if (context.getContextElement() == null) {
    		error = "No context element defined for the View.";
    	} else if (context.getLabel() == null) {
    		error = "No label defined for the View.";
    	} else if (context.getTypeConfiguration() == null) {
    		error = "No TypeConfiguration defined for the View.";
    	}
    	if (error != null) {
    		throw new IllegalStateException(error);
    	}// else
    	
        this.context = context;
    }

    @Override
	public ModelElementView emitView() {
    	if (context == null) {
    		throw new IllegalStateException("The ViewEmitter has not been configured");
    	}// else
    	
    	// Creating the view
    	ModelElementView view = new ModelElementViewImpl();
    	view.setLabel(context.getLabel());
    	view.setContextElement(context.getContextElement());
    	
    	// Emitting the view's widgets
        for (WidgetConfiguration<?> config : context.getTypeConfiguration().getWidgetsConfigurations()) {
            Widget<?> w = emitWidget(config);
            view.addWidget(config.getId(), w);
        }
    	
    	return view;
	}

	@Override
    public Widget<?> emitWidget(WidgetConfiguration<?> config) {
        Assert.isNotNull(config, "The specified WidgetConfig is null.");
        return emitterSwitch.doSwitch(config);
    }

}
