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

import java.util.*;
import java.util.concurrent.*;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.emitter.*;
import com.sysord.mad.emitter.ViewBuilderListener.ViewBuilderEvent;
import com.sysord.mad.mao.MaoException;
import com.sysord.mad.mao.ModelAccessObject;
import com.sysord.mad.widget.*;

/**
 * Abstract implementation of the {@link ViewBuilder}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractViewBuilder implements ViewBuilder {

    @Inject
    protected ConfigurationManager configurationManager;

    @Inject
    protected ModelAccessObject mao;

    @Inject
    protected ConsoleLogger logger;

    protected SpecificWidgetContext context;

    protected Set<ViewBuilderListener> listeners = Collections.synchronizedSet(new HashSet<ViewBuilderListener>());

    private FutureTask<ModelElementView> viewTask;

    @Override
    public SpecificWidgetContext getCurrentContext() {
        return context;
    }

    @Override
    public void createView(final EObject semanticElement, final TypeConfiguration targetConfiguration,
            final SpecificWidgetContext context) {
        Callable<ModelElementView> callable = new Callable<ModelElementView>() {
            @Override
            public ModelElementView call() throws Exception {
                return buildView(semanticElement, targetConfiguration, context);
            }
        };
        if (viewTask != null) {
            /*
             * Cancel the previous task if necessary.
             */
            if (viewTask.cancel(true)) {
                System.err.println("##### Task of creation view CANCELED");
            }
        }
        viewTask = new FutureTask<ModelElementView>(callable);
        viewTask.run();
        _createSpecificView(viewTask);
    }

    /**
     * Build the view.
     */
    protected synchronized ModelElementView buildView(final EObject semanticElement, final TypeConfiguration targetConfiguration,
            final SpecificWidgetContext context) {
        if (context != null) {
            this.context = context;
            context.setElement(semanticElement);
        }
        this.context.setCurrentElement(semanticElement);
        try {
            if (semanticElement == null || semanticElement.eResource() == null) {
                return null;
            }// else
            
            notifyBuildStart();
            TypeConfiguration typeConfig = targetConfiguration;
            // discover target config from semanticElement type
            if (typeConfig == null && semanticElement != null) {
                typeConfig = configurationManager.getConfiguration(semanticElement.eClass());
            }
            notifyConfigLoaded();// Config loaded event
            if (typeConfig != null) {
                // Create the MAD ModelElementView
                ModelElementView view = this.context.getViewHolder().createView(semanticElement, typeConfig);
                notifyMEViewCreated();// model element view created event
                this.context.setModelElementView(view);
                return view;
            } else {
                this.context.getViewHolder().disposeLastView();
            }
        } catch (Exception e) {
            logger.logError(e, ConsoleLogger.VERY_HIGH);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public synchronized void updateCurrentView() {
    	if (context != null && context.getViewHolder() != null) {
	        logger.log("Updating view", ConsoleLogger.VERY_LOW);
	        ModelElementView view = context.getViewHolder().getCurrentView();
	        if (view != null) {
	            EObject element = view.getContextElement();
	            context.getViewHolder().disposeLastView();
	            createView(element, null, context);
	        }
    	}
    }

    @Override
    public synchronized void updateCurrentViewOuputputWidgets() {
    	if (context != null && context.getViewHolder() != null) {
	        logger.log("Updating view output widgets", ConsoleLogger.VERY_LOW);
	        ModelElementView view = context.getViewHolder().getCurrentView();
	        if (view != null) {
	            List<Widget<?>> widgets = new ArrayList<Widget<?>>(25);
	            getOutputWidget(view.getWidgets(), widgets);
	            synchronized (mao) {
	                for (Widget<?> widget : widgets) {
	                    try {
	                        mao.loadWidgetValue(widget);
	                    } catch (MaoException e) {
	                        logger.logError(e.getMessage());
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
    	}
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected List<Widget<?>> getOutputWidget(List<Widget<?>> widgetsToCheck, List<Widget<?>> widgets) {
        for (Widget<?> widget : widgetsToCheck) {
            if (widget instanceof OutputWidget && !(widget instanceof InputWidget)) {
                widgets.add(widget);
            } else if (widget instanceof FlexibleWidget) {
                List<ComposedWidget<?>> composedWidgets = ((FlexibleWidget) widget).getComposedWidgets();
                for (ComposedWidget<?> composed : composedWidgets) {
                    getOutputWidget(composed.getWidgets(), widgets);
                }
            }
        }
        return widgets;
    }

    @Override
    public void addViewBuilderListener(ViewBuilderListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeViewBuilderListener(ViewBuilderListener listener) {
        listeners.remove(listener);
    }

    private void _createSpecificView(final FutureTask<ModelElementView> viewTask) {
        new Thread() {
            @Override
            public void run() {
                ModelElementView view;
                try {
                    view = viewTask.get();
                    if (view != null) {
                        createSpecificView(view);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                notifyBuildEnd();// End of the build event
            }
        }.start();
    }

    /**
     * Creates the platform specific graphical interface from the {@link ModelElementView}
     * .
     * 
     * @param view
     */
    protected abstract void createSpecificView(ModelElementView view);

    /**
     * Notifies this {@link ViewBuilder} listeners that the given {@code eventType}
     * occurred.
     * 
     * @param eventType
     */
    protected void notify(int eventType) {
        ViewBuilderEventImpl event = new ViewBuilderEventImpl(this, eventType);
        synchronized (listeners) {
            for (ViewBuilderListener listener : listeners) {
                if ((listener.getListenedEvents() & event.getEventType()) != 0) {
                    listener.builderEvent(event);
                }
            }
        }
    }

    private void notifyBuildStart() {
        logger.log("Starting the View building", ConsoleLogger.VERY_LOW);
        notify(ViewBuilderEvent.BUILD_ABOUT_TO_START);
    }

    private void notifyConfigLoaded() {
        logger.log("Loading the TypeConfiguration", ConsoleLogger.VERY_LOW);
        notify(ViewBuilderEvent.TYPE_CONFIGURATION_LOADED);
    }

    private void notifyMEViewCreated() {
        logger.log("Model Element View created", ConsoleLogger.VERY_LOW);
        notify(ViewBuilderEvent.MODEL_ELEMENT_VIEW_CREATED);
    }

    private void notifyBuildEnd() {
        logger.log("View building finished", ConsoleLogger.VERY_LOW);
        notify(ViewBuilderEvent.BUILD_VIEW_FINISHED);
    }

    protected static class ViewBuilderEventImpl implements ViewBuilderEvent {

        ViewBuilder source;

        int eventType;

        ViewBuilderEventImpl(ViewBuilder source, int eventType) {
            this.source = source;
            this.eventType = eventType;
        }

        @Override
        public ViewBuilder getSource() {
            return source;
        }

        @Override
        public int getEventType() {
            return eventType;
        }
    }
}
