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

import java.util.Stack;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.emf.tools.misc.EMFImageProvider;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.emitter.ModelElementView;
import com.sysord.mad.emitter.ViewDisposeListener;
import com.sysord.mad.emitter.ViewEmitter;
import com.sysord.mad.emitter.ViewHolder;
import com.sysord.mad.evaluator.FormatExpressionEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.mao.MaoException;
import com.sysord.mad.mao.ModelAccessObject;
import com.sysord.mad.query.impl.MADQueryUtil;

/**
 * Class containing the created {@link ModelElementView} (by a {@link ViewEmitter}).
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ViewHolderImpl implements ViewHolder, ViewDisposeListener {

    protected Stack<ModelElementView> views;
    
    @Inject
    protected ViewEmitter viewEmitter;

    @Inject
    protected ModelAccessObject mao;
    
    @Inject
    protected ConfigurationManager configurationManager;
    
    @Inject
    protected QueryEvaluationService queryEvaluationService;
    
	@Inject
	protected FormatExpressionEvaluationService formatExprEvaluationService;

    @Inject
    protected ConsoleLogger logger;
    
    @Inject
    protected EMFImageProvider itemProvider;

    /**
     * Default constructor
     */
    public ViewHolderImpl() {
        views = new Stack<ModelElementView>();
    }

    @Override
    public ModelElementView createView(EObject contextElement, TypeConfiguration typeConfig) throws MaoException {
        ModelElementView lastView = null;
        // Hide the last opened view
        synchronized (views) {
            if (!views.isEmpty()) {
                lastView = views.peek();
                lastView.setVisible(false);
            }
        }
        ModelElementView view;
        // Creating the context for the ViewEmitter
        ViewEmitterContext ctx = new ViewEmitterContext();
        ctx.setLabel(getViewLabel(contextElement));
        ctx.setContextElement(contextElement);
        ctx.setTypeConfiguration(typeConfig);
        viewEmitter.configure(ctx);
        
        // Create a new ModelElementView
        view = viewEmitter.emitView();
        view.addDisposeListener(this);

        // Push the view into the Stack.
        views.push(view);

        // Fill widgets values
        synchronized (mao) {
            mao.loadViewValues(view);
        }
        
        // flush query cache
        logger.log("Flush of the Query Evaluation Service Cache", ConsoleLogger.VERY_LOW);
        queryEvaluationService.flushCache();
        return view;
    }

	protected String getViewLabel(EObject contextElement) {
		// Eval and set view label
		String viewLabel;
		String viewLabelExpr = configurationManager.getLabelProviderExpressionForType(contextElement.eClass());
		if (viewLabelExpr != null) {
			viewLabel = formatExprEvaluationService.evaluateFormatExpression(contextElement, viewLabelExpr,
					MADQueryUtil.createArguments(contextElement));
		}else {
			viewLabel = itemProvider.getLabelFor(contextElement);
		}
		if(viewLabel == null){
			 viewLabel = contextElement.eClass().getName();
		}
		return viewLabel;
	}
    
    @Override
    public ModelElementView getCurrentView() {
        synchronized (views) {
            if (!views.isEmpty()) {
                return views.peek();
            }
        }
        return null;
    }

    @Override
    public void viewDispose(ModelElementView disposedView) {
        views.remove(disposedView);
    }

    @Override
    public void disposeAll() {
        synchronized (views) {
            while (!views.isEmpty()) {
                ModelElementView view = views.pop();
                view.removeDisposeListener(this);
                view.dispose();
            }
        }
    }
    
    @Override
    public void disposeLastView() {
        synchronized (views) {
            if (!views.isEmpty()) {
                ModelElementView view = views.pop();
                view.removeDisposeListener(this);
                view.dispose();
            }
        }
    }

    @Override
    public void restoreLastView() {
        synchronized (views) {
            disposeLastView();
            if (!views.isEmpty()) {
                views.peek().setVisible(true);
            }
        }
    }
    
}
