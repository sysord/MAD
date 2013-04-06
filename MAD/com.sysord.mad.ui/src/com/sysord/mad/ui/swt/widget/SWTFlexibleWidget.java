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
package com.sysord.mad.ui.swt.widget;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.mad.emitter.impl.SWTViewBuilder;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.SWTSpecificWidgetContext;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.impl.WidgetElementAdapter;

/**
 * Default SWT implementation of the {@link FlexibleWidget}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTFlexibleWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof FlexibleWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Flexible",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }

    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        FlexibleWidget<?> flexibleWidget = castWidget(madWidget);
        addFlexibleCommandsButtons(getSwtContext().getWidgetContainer(), getSwtContext().getToolkit(), flexibleWidget);
        Composite flexibleContainer = createFlexible(getSwtContext().getWidgetContainer(), flexibleWidget);
        // Keep current container reference during the FlexibleWidget's visit
        Composite saveContainer = null;
        try {
            saveContainer = getSwtContext().getWidgetContainer();
            getSwtContext().setWidgetContainer(flexibleContainer);
            for (ComposedWidget<?> composedWidget : flexibleWidget.getComposedWidgets()) {
                if (composedWidget.isVisible()) {
                    getSwtContext().getWidgetBuilder().createWidget(specificContextHolder, composedWidget);
                }
            }
            addFlexibleListeners(flexibleWidget, flexibleContainer);
        } finally {
            // Restoration of the original container
            getSwtContext().setWidgetContainer(saveContainer);
        }
        return flexibleContainer;
    }

    /**
     * Create an SWT widget for {@link FlexibleWidget}.
     * 
     * @param container
     * @param widget
     */
    private Composite createFlexible(Composite container, FlexibleWidget<?> widget) {
        FormToolkit toolkit = getSwtContext().getToolkit();
        // Label
        createLabelColumn(toolkit, container, widget);

        // Flexible
        Composite flexible = toolkit.createComposite(container);
        flexible.setLayout(GridLayoutFactory.fillDefaults().create());
        GridData data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
        data.horizontalSpan = 2;
        flexible.setLayoutData(data);

        return flexible;
    }

    private void addFlexibleListeners(final FlexibleWidget<?> widget, final Composite container) {
        /*
         * If the widget is already in a Flexible widget, it will be reloaded with its
         * parent.
         */
        if (!hasParentFlexible(widget)) {
            // We keep a copy of the current context that will be used on the widget
            // reload action.
            final SWTSpecificWidgetContext ctx = getSwtContext().clone();
            widget.addElementListener(new WidgetElementAdapter() {
                @Override
                public void valuedElementChanged(EObject oldElement, EObject newElement) {
                    SWTSpecificWidgetContext savedContext = getSwtContext();
                    try {
                        specificContextHolder.setSpecificWidgetContext(ctx);
                        for (ComposedWidget<?> composedWidget : widget.getComposedWidgets()) {
                            if (composedWidget.isVisible()) {
                                getSwtContext().getWidgetBuilder().createWidget(specificContextHolder, composedWidget);
                            }
                        }
                        GridData layoutData = GridDataHelper.horizontalFill();
                        layoutData.horizontalSpan = 2;
                        container.getParent().setLayoutData(layoutData);

                        getSwtContext().getForm().reflow(true);
                        if (getViewBuilder() instanceof SWTViewBuilder) {
                            Point origin = ((SWTViewBuilder) getViewBuilder()).lastOrigin;
                            if (origin != null) {
                                getSwtContext().getForm().setOrigin(origin);
                            }
                        }
                    } finally {
                        specificContextHolder.setSpecificWidgetContext(savedContext);
                    }
                }
            });
        }
    }

    /**
     * Indicates if the given {@code widget} has a {@link FlexibleWidget} parent.
     * <p>
     * It could an indirect parent.
     * 
     * @param widget
     * @return {@code true} if the given {@code widget} has a {@link FlexibleWidget}
     *         parent;<br>
     *         {@code false} otherwise.
     */
    protected boolean hasParentFlexible(Widget<?> widget) {
        while (widget.getOwnerWidget() != null) {
            if (widget.getOwnerWidget() instanceof FlexibleWidget) {
                return true;
            }// else
            widget = widget.getOwnerWidget();
        }
        return false;
    }
    
    @Override
    protected void addVisibilityListener(Widget<?> madWidget, Control swtWidget) {
        // Does nothing
    }
}
