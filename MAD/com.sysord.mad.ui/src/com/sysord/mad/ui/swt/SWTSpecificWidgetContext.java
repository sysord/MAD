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
package com.sysord.mad.ui.swt;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.sysord.emf.tools.misc.ActivatableAdapter;
import com.sysord.mad.emitter.ModelElementView;
import com.sysord.mad.emitter.ViewHolder;
import com.sysord.mad.emitter.impl.SWTViewBuilder;
import com.sysord.mad.widget.*;

/**
 * {@link SpecificWidgetContext} for SWT widgets.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTSpecificWidgetContext implements SpecificWidgetContext, Cloneable {

    protected Object id;

    protected Composite parent;

    protected ViewHolder viewHolder;

    protected FormToolkit toolkit;

    protected ScrolledForm scrolledForm;

    protected Composite sectionDescriptionContainer;

    protected Label sectionErrorLabel;

    protected EObject element;

    protected EObject currentElement;

    protected ModelElementView modelElementView;

    protected WidgetBuilder widgetBuilder;

    protected ActivatableAdapter[] adapters;

    protected TabFolder currentTabbedContainer;

    protected TabItem currentTab;

    protected Map<InputWidget<?>, String> errorMessages = Collections
            .synchronizedMap(new HashMap<InputWidget<?>, String>());

    /**
     * @deprecated It was used with the old emitter and the creation of a
     *             {@link ScrolledComposite} for each tab.
     *             <p>
     *             Now, you should use {@link #formBody} and the corresponding
     *             getters/setters.<br>
     *             This is due to the {@link SWTViewBuilder} using {@link FormToolkit}.
     */
    @Deprecated
    protected ScrolledComposite currentContainer;

    /**
     * Obtained with {@link ScrolledForm#getBody()} on {@link #scrolledForm}.
     * <p>
     * The {@link ScrolledForm} being created with {@link FormToolkit}.
     */
    protected Composite formBody;

    protected Composite widgetContainer;

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = id;
    }

    @Override
    public ViewHolder getViewHolder() {
        return viewHolder;
    }

    @Override
    public void setViewHolder(ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    @Override
    public EObject getElement() {
        return element;
    }

    @Override
    public void setElement(EObject element) {
        this.element = element;
    }

    @Override
    public EObject getCurrentElement() {
        return currentElement == null ? element : currentElement;
    }

    @Override
    public void setCurrentElement(EObject element) {
        currentElement = element;
    }

    @Override
    public ModelElementView getModelElementView() {
        return modelElementView;
    }

    @Override
    public void setModelElementView(ModelElementView modelElementView) {
        this.modelElementView = modelElementView;
    }

    public Composite getParentComposite() {
        return parent;
    }

    public void setParentComposite(Composite parent) {
        this.parent = parent;
    }

    /**
     * Return the value of toolkit.
     * 
     * @return the value of toolkit.
     */
    public FormToolkit getToolkit() {
        return toolkit;
    }

    /**
     * Set the specified value toolkit for toolkit.
     * 
     * @param toolkit the value to set to toolkit.
     */
    public void setToolkit(FormToolkit toolkit) {
        this.toolkit = toolkit;
    }

    /**
     * Return the value of adapters.
     * 
     * @return the value of adapters.
     */
    public ActivatableAdapter[] getAdapters() {
        return adapters;
    }

    /**
     * Set the specified value adapters for adapters.
     * 
     * @param adapters the value to set to adapters.
     */
    public void setAdapters(ActivatableAdapter... adapters) {
        this.adapters = adapters;
    }

    /**
     * Return the value of widgetBuilder.
     * 
     * @return the value of widgetBuilder.
     */
    public WidgetBuilder getWidgetBuilder() {
        return widgetBuilder;
    }

    /**
     * Set the specified value widgetBuilder for widgetBuilder.
     * 
     * @param widgetBuilder the value to set to widgetBuilder.
     */
    public void setWidgetBuilder(WidgetBuilder widgetBuilder) {
        this.widgetBuilder = widgetBuilder;
    }

    /**
     * Return the value of currentTabbedContainer.
     * 
     * @return the value of currentTabbedContainer.
     */
    public TabFolder getCurrentTabbedContainer() {
        return currentTabbedContainer;
    }

    /**
     * Set the specified value currentTabbedContainer for currentTabbedContainer.
     * 
     * @param currentTabbedContainer the value to set to currentTabbedContainer.
     */
    public void setCurrentTabbedContainer(TabFolder currentTabbedContainer) {
        this.currentTabbedContainer = currentTabbedContainer;
    }

    /**
     * Return the value of currentTab.
     * 
     * @return the value of currentTab.
     */
    public TabItem getCurrentTab() {
        return currentTab;
    }

    /**
     * Set the specified value currentTab for currentTab.
     * 
     * @param currentTab the value to set to currentTab.
     */
    public void setCurrentTab(TabItem currentTab) {
        this.currentTab = currentTab;
    }

    /**
     * Return the value of currentContainer.
     * 
     * @return the value of currentContainer.
     * @deprecated Use {@link #getFormBody()} instead.
     */
    @Deprecated
    public ScrolledComposite getCurrentContainer() {
        return currentContainer;
    }

    /**
     * Set the specified value currentContainer for currentContainer.
     * 
     * @param currentContainer the value to set to currentContainer.
     * @deprecated Use {@link #setFormBody(Composite)} instead.
     */
    @Deprecated
    public void setCurrentContainer(ScrolledComposite currentContainer) {
        this.currentContainer = currentContainer;
    }

    /**
     * Return the value of formBody.
     * 
     * @return the value of formBody.
     */
    public Composite getFormBody() {
        return formBody;
    }

    /**
     * Set the specified value formBody for formBody.
     * 
     * @param formBody the value to set to formBody.
     */
    public void setFormBody(Composite formBody) {
        this.formBody = formBody;
    }

    /**
     * Return the value of currentForm.
     * 
     * @return the value of currentForm.
     */
    public ScrolledForm getForm() {
        return scrolledForm;
    }

    /**
     * Set the specified value currentForm for currentForm.
     * 
     * @param currentForm the value to set to currentForm.
     */
    public void setForm(ScrolledForm currentForm) {
        this.scrolledForm = currentForm;
    }

    /**
     * Return the value of sectionDescriptionContainer.
     * 
     * @return the value of sectionDescriptionContainer.
     */
    public Composite getSectionDescriptionContainer() {
        return sectionDescriptionContainer;
    }

    /**
     * Set the specified value sectionDescriptionContainer for
     * sectionDescriptionContainer.
     * 
     * @param sectionDescriptionContainer the value to set to sectionDescriptionContainer.
     */
    public void setSectionDescriptionContainer(Composite sectionDescriptionContainer) {
        this.sectionDescriptionContainer = sectionDescriptionContainer;
    }

    /**
     * Return the value of sectionErrorLabel.
     * 
     * @return the value of sectionErrorLabel.
     */
    public Label getSectionErrorLabel() {
        return sectionErrorLabel;
    }

    /**
     * Set the specified value sectionErrorLabel for sectionErrorLabel.
     * 
     * @param sectionErrorLabel the value to set to sectionErrorLabel.
     */
    public void setSectionErrorLabel(Label sectionErrorLabel) {
        this.sectionErrorLabel = sectionErrorLabel;
    }

    /**
     * Return the value of widgetContainer.
     * 
     * @return the value of widgetContainer.
     */
    public Composite getWidgetContainer() {
        return widgetContainer;
    }

    /**
     * Set the specified value widgetContainer for widgetContainer.
     * 
     * @param widgetContainer the value to set to widgetContainer.
     */
    public void setWidgetContainer(Composite widgetContainer) {
        this.widgetContainer = widgetContainer;
    }

    /**
     * Return the value of errorMessages.
     * 
     * @return the value of errorMessages.
     */
    public Map<InputWidget<?>, String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * Put the given error message into this context.
     * 
     * @param widget
     * @param message
     */
    public void putErrorMessage(InputWidget<?> widget, String message) {
        errorMessages.put(widget, message);
    }

    @Override
    public SWTSpecificWidgetContext clone() {
        SWTSpecificWidgetContext swtContext;
        try {
            swtContext = (SWTSpecificWidgetContext) super.clone();
        } catch (CloneNotSupportedException e) {
            // Should never happen, SWTSpecificWidgetContext is Cloneable
            return null;
        }
        return swtContext;
    }
}
