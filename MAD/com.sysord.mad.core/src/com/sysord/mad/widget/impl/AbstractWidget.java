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
package com.sysord.mad.widget.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import com.sysord.eclipse.tools.diagnostic.Diagnostic;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.eclipse.tools.runtime.DelayedSWTOperationSet;
import com.sysord.eclipse.tools.runtime.DelayedSWTOperationSet.SWTIdentifiedOperation;
import com.sysord.emf.tools.EMFUtil;
import com.sysord.emf.tools.misc.ActivatableAdapter;
import com.sysord.emf.tools.misc.EContentActivatableAdapter;
import com.sysord.mad.command.MadCommand;
import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.core.Activator;
import com.sysord.mad.emitter.ModelElementView;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.mao.MaoException;
import com.sysord.mad.mao.ModelAccessObject;
import com.sysord.mad.mao.ValuedSemanticElement;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.WidgetDisposeListener;
import com.sysord.mad.widget.WidgetElementListener;
import com.sysord.mad.widget.WidgetVisibilityListener;
import com.sysord.mad.widget.WidgetVisitor;

/**
 * 
 * Implementation of the default behavior of a Widget.
 * 
 * @param <T>
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractWidget<T> implements Widget<T> {

    /*
     * Clones' number of this widget.
     * Used in the creation of an unique ID for the cloned widgets.
     */
    private int cloned = 0;

    private String id;

    protected boolean isDisposed;

    protected ModelAccessObject mao;

    protected QueryEvaluationService queryEvaluationService;

    protected ConsoleLogger logger;

    /**
     * Owner view model
     */
    protected ModelElementView ownerViewModel;

    protected ValuedSemanticElement valuedElement;

    /**
     * This Widget configuration.
     */
    protected WidgetConfiguration<T> config;

    /**
     * Widget's commands
     */
    protected Map<String, MadCommand> commands = new HashMap<String, MadCommand>();

    /**
     * The {@link WidgetDisposeListener}s for this Widget.
     */
    protected List<WidgetDisposeListener> disposeListeners;

    /**
     * The {@link WidgetVisibilityListener}s for this Widget.
     */
    protected List<WidgetVisibilityListener> visibilityListeners;

    /**
     * The {@link WidgetElementListener}s for this Widget.
     */
    protected List<WidgetElementListener> elementListeners;

    protected Widget<?> ownerWidget;

    protected String label;

    protected boolean visible = true;

    private ActivatableAdapter elementAdapter;

    private SWTIdentifiedOperation updateOperation;

    /**
     * the widget status. a diagnostic providing level (error, warning) and
     * a description message.
     * if none error or warning has been detected, this property is <code>null</code>.
     */
    protected Diagnostic status;
    

	/**
     * Create a new widget.
     */
    public AbstractWidget(Class<T> valueTypeClass) {
        disposeListeners = new ArrayList<WidgetDisposeListener>(1);
        visibilityListeners = new ArrayList<WidgetVisibilityListener>(1);
        elementListeners = new ArrayList<WidgetElementListener>(1);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation of this method does nothing, subclasses should override
     * it.
     */
    @Override
    public <AT> AT getAdapter(Class<AT> adapterClass) {
        return null;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * Returns the {@link ModelElementView} owning this widget, directly or indirectly if
     * this widget is in composed widgets.
     * 
     * @return the {@link ModelElementView} owning this widget.
     */
    public ModelElementView getOwnerViewModel() {
        if (ownerViewModel == null) {
            ownerViewModel = getOwnerWidget().getOwnerViewModel();
        }
        return ownerViewModel;
    }

    /**
     * set the owner view model
     */
    public void setOwnerViewModel(ModelElementView ownerViewModel) {
        this.ownerViewModel = ownerViewModel;
    }

    @Override
    public ValuedSemanticElement getValuedSemanticElement() {
        return valuedElement;
    }

    @Override
    public void setValuedSemanticElement(ValuedSemanticElement valuedElement) {
        EObject oldElement = this.valuedElement != null ? this.valuedElement.getElement() : null;
        EObject newElement = valuedElement != null ? valuedElement.getElement() : null;
        EMFUtil.moveAdapter(getAdapter(), oldElement, newElement);
        if (this.valuedElement != null) {
            this.valuedElement.setAdapter(null);

        }
        this.valuedElement = valuedElement;
        if (valuedElement != null) {
            updateOperation = null;
            valuedElement.setAdapter(getAdapter());
        }
    }

    @Override
    public String getLabel() {
        if (label != null) {
            return label;
        }
        return config.getLabel();
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
        for (int i = 0; i < visibilityListeners.size(); i++) {
            visibilityListeners.get(i).visibilityChanged(visible);
        }
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    /**
     * Return the type Class of the value representing this Widget.
     * 
     * @return the type Class of the value representing this Widget.
     */
    public Class<T> getType() {
        return config.getWidgetValueType();
    }

    @Override
    public WidgetConfiguration<T> getConfig() {
        return config;
    }

    @Override
    public void setConfig(WidgetConfiguration<T> config) {
        this.config = config;
        if (id == null) {
            id = config.getId();
        }
    }

    @Override
    public void setOwnerWidget(Widget<?> widget) {
        this.ownerWidget = widget;
    }

    @Override
    public Widget<?> getOwnerWidget() {
        return ownerWidget;
    }

    @Override
    public EObject getContextElement() {
        if (ownerWidget != null) {
            // context element must be an EObject TODO: assertion
            return (EObject) ownerWidget.getValuedSemanticElement().getValue();
        } else {
            return getOwnerViewModel().getContextElement();
        }
    }

    @Override
    public Diagnostic getStatus() {
		return status;
	}

    @Override
	public void setStatus(Diagnostic status) {
		this.status = status;
	}

    
    /**
     * Returns the {@link Adapter} to put on the element of the
     * {@link ValuedSemanticElement}.
     * 
     * @return the {@link Adapter} to put on the element of the
     *         {@link ValuedSemanticElement}.
     */
    @Override
    public ActivatableAdapter getAdapter() {
        if (elementAdapter == null) {
            elementAdapter = createElementAdapter();
        }
        return elementAdapter;
    }

    /**
     * Creates the element {@link Adapter}.
     * 
     * @return the created adapter
     */
    private ActivatableAdapter createElementAdapter() {

        return new EContentActivatableAdapter() {

            @Override
            protected void _notifyChanged(Notification msg) {
                switch (msg.getEventType()) {
                case Notification.SET:
                case Notification.UNSET:
                case Notification.ADD:
                case Notification.REMOVE:
                case Notification.ADD_MANY:
                case Notification.REMOVE_MANY:
                case Notification.MOVE:
                    if (!(msg.getNewValue() == null && msg.getOldValue() == null) || msg.getNewValue() != null
                            && !msg.getNewValue().equals(msg.getOldValue()) || msg.getOldValue() != null
                            && !msg.getOldValue().equals(msg.getNewValue())) {
                        DelayedSWTOperationSet.get().executeOperation(getUpdateOperation());
                    }
                    break;
                }
            }
        };
    }

    /**
     * Creates an {@link SWTIdentifiedOperation} for which the invocation will trigger a
     * reload of this widget.
     * <p>
     * Returns the <strong>previously created operation</strong> if possible.
     * 
     * @return the created {@code SWTIdentifiedOperation} updating this widget.
     */
    protected SWTIdentifiedOperation getUpdateOperation() {
        if (updateOperation == null) {
            updateOperation = new SWTIdentifiedOperation(AbstractWidget.this) {

                @Override
                public void execute() {
                    try {
                        if (valuedElement != null && valuedElement.getElement() != null
                                && valuedElement.getElement().eResource() != null) {
                            EObject oldElement = valuedElement.getElement();
                            synchronized (getMao()) {
                                beforeLoadingWidget();
                                getMao().loadWidgetValue(AbstractWidget.this);
                                getQueryService().flushCache();
                            }
                            EObject newElement = valuedElement.getElement();
                            notifyElementChanged(oldElement, newElement);
                            notifyViewChanged();
                            afterLoadingWidget();
                        }
                    } catch (MaoException e) {
                        getLogger().logError(e.getMessage(), ConsoleLogger.LOW);
                        e.printStackTrace();
                    }
                }
            };
        }
        return updateOperation;
    }

    /**
     * Notifies that the view has changed
     */
    protected void notifyViewChanged() {
    	/*
    	 * This notification has been made for refreshing some label values
    	 * which are not reloaded when their context change and the output widgets
    	 * because they don't always have the context from which their value originally came.
    	 * This method is like a rocket launcher to kill a fly, the good way to
    	 * do it would be to create Label widgets that could refresh themselves and
    	 * OutputWidget with a better detection of their true origine.
    	 * (Other solution for OutputWidget would be to create their own Listener
    	 * on view change events)
    	 */
    	// TODO : Delete this notification
        final ModelElementView view = getOwnerViewModel();
        if (view != null) {
            DelayedSWTOperationSet.get().executeOperation(new SWTIdentifiedOperation(view) {
                @Override
                public void execute() {
                    view.notifyChange();
                }
            });
        }
    }

    /**
     * Called before reloading widget data.
     * <p>
     * This method does nothing by default and may be subclassed.
     */
    protected void beforeLoadingWidget() {
        // Does nothing
    }

    /**
     * Called after reloading widget data.
     * <p>
     * This method does nothing by default and may be subclassed.
     */
    protected void afterLoadingWidget() {
        // Does nothing
    }

    protected void notifyElementChanged(EObject oldElement, EObject newElement) {
        for (WidgetElementListener listener : elementListeners) {
            listener.valuedElementChanged(oldElement, newElement);
        }
    }

    @Override
    public void addCommand(String commandId, MadCommand command) {
        commands.put(commandId, command);
    }

    @Override
    public void removeCommand(String commandId) {
        commands.remove(commandId);
    }

    @Override
    public MadCommand getCommand(String commandId) {
        return commands.get(commandId);
    }

    @Override
    public void executeCommand(String commandId) {
        MadCommand command = getCommand(commandId);
        if (command != null) {
            getMao().createTransactionnalMadCommand(getValuedSemanticElement(), command).execute();
        }
    }

    @Override
    public <V> V accept(WidgetVisitor<V> visitor) {
        return visitor.visit(this);
    }

    @Override
    public void dispose() {
        if (!isDisposed) {
            if (valuedElement != null) {
                EObject element = valuedElement.getElement();
                if (element != null) {
                    element.eAdapters().remove(getAdapter());
                }
            }
            for (int i = 0; i < disposeListeners.size(); i++) {
                disposeListeners.get(i).widgetDispose(this);
            }
            isDisposed = true;
        }
    }

    @Override
    public void addDisposeListener(WidgetDisposeListener listener) {
        disposeListeners.add(listener);
    }

    @Override
    public void removeDisposeListener(WidgetDisposeListener listener) {
        disposeListeners.remove(listener);
    }

    @Override
    public void addVisibilityListener(WidgetVisibilityListener listener) {
        visibilityListeners.add(listener);
    }

    @Override
    public void removeVisibilityListener(WidgetVisibilityListener listener) {
        visibilityListeners.remove(listener);

    }

    @Override
    public void addElementListener(WidgetElementListener listener) {
        elementListeners.add(listener);
    }

    @Override
    public void removeElementListener(WidgetElementListener listener) {
        elementListeners.remove(listener);

    }

    protected ModelAccessObject getMao() {
        if (mao == null) {
            mao = Activator.getDefault().getInjector().getInstance(ModelAccessObject.class);
        }
        return mao;
    }

    protected QueryEvaluationService getQueryService() {
        if (queryEvaluationService == null) {
            queryEvaluationService = Activator.getDefault().getInjector().getInstance(QueryEvaluationService.class);
        }
        return queryEvaluationService;
    }

    protected ConsoleLogger getLogger() {
        if (logger == null) {
            logger = Activator.getDefault().getInjector().getInstance(ConsoleLogger.class);
        }
        return logger;
    }

    @Override
    public Widget<T> clone() throws CloneNotSupportedException {
        if (config == null) {
            throw new RuntimeException("The WidgetConfiguration is needed to clone a Widget.");
        }// else

        // Get the concrete cloned instance of the widget
        AbstractWidget<T> clone = _clone();

        clone.config = config;
        clone.mao = mao;
        clone.ownerWidget = ownerWidget;
        clone.valuedElement = null;
        if (ownerWidget != null) {
            clone.id = ownerWidget.getId() + "__";
        }
        clone.id += config.getId() + "_" + (++cloned);
        return clone;
    }

    protected abstract AbstractWidget<T> _clone() throws CloneNotSupportedException;

}
