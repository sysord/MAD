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

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.*;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.eclipse.tools.swt.SWTUtil;
import com.sysord.emf.tools.misc.EMFImageProvider;
import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.emitter.*;
import com.sysord.mad.evaluator.FormatExpressionEvaluationService;
import com.sysord.mad.query.impl.MADQueryUtil;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.*;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.Widget;

/**
 * Implementation of the {@link AbstractViewBuilder} using {@link FormToolkit}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTViewBuilder extends AbstractViewBuilder implements SpecificContextHolder {

    public static final int GRID_COLUMNS = 4;

    public Point lastOrigin;

    private FormToolkit toolkit;

    /**
     * Contexts for each tab
     */
    protected Map<String, SWTSpecificWidgetContext> contexts;

    /**
     * Current populating context
     */
    protected SWTSpecificWidgetContext currentContext;

    /**
     * Current view
     */
    protected ModelElementView view;

    /**
     * Selected tab for a specific selected object.
     */
    protected Map<EClass, Integer> tabsCache = new HashMap<EClass, Integer>();

    protected boolean tabListenerActive = true;
    
    @Inject
    protected WidgetBuilder widgetBuilder;

    @Inject
    protected EMFImageProvider imageProvider;

    @Inject
    protected FormatExpressionEvaluationService formatExprEvaluationService;

    /**
     * Create a {@code FormViewBuilder}.
     */
    public SWTViewBuilder() {
        contexts = new TreeMap<String, SWTSpecificWidgetContext>();
        addShutdownHook();
    }

    @Override
    protected void createSpecificView(final ModelElementView view) {
        if (Display.getCurrent() == null) {
            Display.getDefault().asyncExec(new Runnable() {

                @Override
                public void run() {
                    _createSpecificView(view);
                }
            });
        } else {
            _createSpecificView(view);
        }
    }

    private void _createSpecificView(ModelElementView view) {
        if (context instanceof SWTSpecificWidgetContext) {
            this.view = view;

            // Fill SWT Specific context details
            SWTSpecificWidgetContext swtContext = (SWTSpecificWidgetContext) context;
            swtContext.setWidgetBuilder(widgetBuilder);
            Composite parent = swtContext.getParentComposite();
            Assert.isNotNull(parent, Lbl.parentNullViewNotCreated);
            swtContext.setToolkit(getToolkit(parent));

            Composite swtView;
            try {
                swtView = createView(swtContext);
            } catch (IllegalStateException e) {
                return;
            }

            ((StackLayout) parent.getLayout()).topControl = swtView;
            parent.layout();
        }
    }

    /**
     * Return the value of toolkit.
     * 
     * @param composite
     * @return the value of toolkit.
     */
    public FormToolkit getToolkit(Composite composite) {
        if (toolkit == null) {
            toolkit = new FormToolkit(SWTUtil.getDisplay(composite));
        }
        return toolkit;
    }

    @Override
    public SpecificWidgetContext getSpecificWidgetContext() {
        return currentContext;
    }

    @Override
    public void setSpecificWidgetContext(SpecificWidgetContext specificWidgetContext) {
        if (!(specificWidgetContext instanceof SWTSpecificWidgetContext)) {
            throw new IllegalArgumentException(Lbl.bind(Lbl.error_wrongContext, getClass().getSimpleName(),
                    "SWTSpecificWidgetContext"));//$NON-NLS-1$
        }// else
        currentContext = (SWTSpecificWidgetContext) specificWidgetContext;
    }

    /**
     * Create the composite view corresponding to the {@link ModelElementView} using
     * {@link FormToolkit}.
     * 
     * @param swtContext
     */
    protected Composite createView(SWTSpecificWidgetContext swtContext) {
        currentContext = swtContext;

        // Creation of the current widget containers
        TabFolder tabFolder = createWidgetContainer();
        currentContext.setCurrentTabbedContainer(tabFolder);

        // Creation of the default tab
        getTab(WidgetConfiguration.DEFAULT_UI_TAB_ID, WidgetConfiguration.DEFAULT_UI_TAB_LABEL);

        // Create SWT Widgets
        createSWTWidgets();

        // Select a tab
        if (view.getContextElement() != null) {
            Integer index = tabsCache.get(view.getContextElement().eClass());
            if (index != null && index < tabFolder.getItemCount()) {
                tabListenerActive = false;
                tabFolder.setSelection(index);
                tabListenerActive = true;
            }
        }

        contexts.clear();

        return swtContext.getCurrentTabbedContainer();
    }

    /**
     * Create the Tabbed Composite in the parent and add the Main tab item to it.
     * 
     * @param swtContext
     */
    private TabFolder createWidgetContainer() {
        // Creation of a tabbed composite
        final TabFolder tabbedContainer = new TabFolder(currentContext.getParentComposite(), SWT.BOTTOM);
        tabbedContainer.setLayout(new FillLayout(SWT.VERTICAL));

        // Add a tab changed listener
        tabbedContainer.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (tabListenerActive) {
                    Integer tabIndex = tabbedContainer.getSelectionIndex();
                    tabsCache.put(view.getContextElement().eClass(), tabIndex);
                }
            }
        });

        hookDisposeListener(view, tabbedContainer);
        hookVisibleListener(view, tabbedContainer);

        return tabbedContainer;
    }

    /**
     * Create the SWT widgets for the specified view.
     * 
     * @param view
     * @param swtContext
     */
    private void createSWTWidgets() {
        // Create the widget visitor for widget's creation
        SWTWidgetCreationVisitor swtWidgetVisitor = new SWTWidgetCreationVisitor(this);

        ModelElementView view = this.view;
        for (Widget<?> widget : view.getWidgets()) {
            if (widget.isVisible()) {
                try {
                    getTab(widget.getConfig().getTabId(), widget.getConfig().getTabLabel());
                    widget.accept(swtWidgetVisitor);
                } catch (Exception e) {
                    logger.logError(e, ConsoleLogger.VERY_HIGH);
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Change the current context for the corresponding tabName context.
     * <p>
     * Create a new tab and new context if necessary.
     * 
     * @param tabId
     * @param tabLabelExpr
     */
    private void getTab(String tabId, String tabLabelExpr) {
        SWTSpecificWidgetContext swtContext = contexts.get(tabId);
        if (swtContext == null) {
            swtContext = currentContext.clone();
            contexts.put(tabId, swtContext);
            currentContext = swtContext;
            tabListenerActive = false;
            // eval tab label from format expression
            String tabLabel = formatExprEvaluationService.evaluateFormatExpression(view.getContextElement(),
                    tabLabelExpr, MADQueryUtil.createArguments(view.getContextElement()));
            createNewTab(tabLabel);
            tabListenerActive = true;
        } else {
            currentContext = swtContext;
        }
    }

    /**
     * Create a new tab item with the specified tabName.
     */
    private void createNewTab(String tabName) {
        FormToolkit toolkit = currentContext.getToolkit();
        // Creation of the new tab
        TabItem tabItem = new TabItem(currentContext.getCurrentTabbedContainer(), SWT.NONE);
        tabItem.setText(tabName);
        currentContext.setCurrentTab(tabItem);

        // Creation of a scrolled form
        final ScrolledForm scrolledForm = toolkit.createScrolledForm(currentContext.getCurrentTabbedContainer());
        scrolledForm.setShowFocusedControl(true);
        scrolledForm.getBody().setLayout(new GridLayout());
        tabItem.setControl(scrolledForm);
        currentContext.setForm(scrolledForm);
        currentContext.setFormBody(scrolledForm.getBody());

        scrolledForm.getVerticalBar().addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!scrolledForm.isDisposed()) {
                    lastOrigin = scrolledForm.getOrigin();
                }
            }
        });

        // Container of the view elements
        String title = view.getLabel() == null ? Lbl.emptyString : view.getLabel();
        Image image = imageProvider.getImageFor(currentContext.getCurrentElement());
        Section section = SWTHelper.createSection(toolkit, scrolledForm.getBody(), title, image);
        Composite container = toolkit.createComposite(section);
        container.setLayout(new GridLayout(GRID_COLUMNS, false));
        section.setClient(container);

        // Add the context menu to the view controls
        // TODO : Bug when reloading an Expandable, the ancient menu is disposed.
        // MAD.getView().createContextMenuManager(scrolledForm.getBody(), section,
        // container);

        // Set the current widget container
        currentContext.setWidgetContainer(container);
    }

    /**
     * Add a dispose listener to the view.
     * 
     * @param view
     */
    private void hookDisposeListener(ModelElementView view, final Composite container) {
        if (view.isDisposed()) {
            container.dispose();
            throw new IllegalStateException();
        }// else

        view.addDisposeListener(new ViewDisposeListener() {

            @Override
            public void viewDispose(ModelElementView disposedView) {
                Display display = SWTUtil.getDisplay(container);
                display.asyncExec(new Runnable() {

                    @Override
                    public void run() {
                        container.dispose();
                    }
                });
            }
        });
    }

    /**
     * Add a visible listener to the view.
     * 
     * @param view
     * @param composite
     */
    private static void hookVisibleListener(ModelElementView view, final Composite composite) {
        view.addVisibleListener(new ViewVisibleListener() {

            @Override
            public void viewVisible(ModelElementView view, final boolean isVisible) {
                if (!composite.isDisposed()) {
                    Display display = SWTUtil.getDisplay(composite);
                    display.asyncExec(new Runnable() {

                        @Override
                        public void run() {
                            if (!composite.isDisposed()) {
                                composite.setVisible(isVisible);
                            }
                        }
                    });
                }
            }
        });
    }

    /**
     * Dispose this {@code ViewBuilder}.
     */
    protected void dispose() {
        if (toolkit != null) {
            toolkit.dispose();
        }
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                dispose();
            }
        });
    }
}
