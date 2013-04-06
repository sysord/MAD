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

import static com.sysord.mad.emitter.impl.SWTViewBuilder.GRID_COLUMNS;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.*;

import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.SWTWidgetCreationVisitor;
import com.sysord.mad.widget.*;

/**
 * Default SWT implementation of the {@link ComposedWidget}.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTComposedWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof ComposedWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Composed",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }

    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        final ComposedWidget<?> widget = castWidget(madWidget);
        String label = widget.getLabel() == null ? Lbl.emptyString : widget.getLabel();
        FormToolkit toolkit = getSwtContext().getToolkit();

        final Composite composedContainer = toolkit.createComposite(getSwtContext().getWidgetContainer());
        composedContainer.setLayoutData(GridDataHelper.horizontalFill());
        composedContainer.setLayout(GridLayoutHelper.createWithNoMargin(2));

        // Expandable composite for the composed widget
        ExpandableComposite expandable = toolkit.createExpandableComposite(composedContainer,
                ExpandableComposite.EXPANDED | ExpandableComposite.TREE_NODE);
        expandable.setText(label);
        expandable.setLayout(GridLayoutFactory.fillDefaults().create());
        expandable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        Composite compositeContainer = createComposed(expandable, widget);
        // Keep current container reference during the ComposedWidget's visit
        Composite saveContainer = null;
        try {
            saveContainer = getSwtContext().getWidgetContainer();
            getSwtContext().setWidgetContainer(compositeContainer);
            
            for (Widget<?> containedwidget : widget.getWidgets()) {
                if (containedwidget.isVisible()) {
                    containedwidget.accept(new SWTWidgetCreationVisitor(specificContextHolder));
                }
            }
            addCommandsButtons(composedContainer, getSwtContext().getToolkit(), widget, expandable);

            final ScrolledForm form = getSwtContext().getForm();

            final WidgetDisposeListener disposeListener = new WidgetDisposeListener() {
                @Override
                public <T2> void widgetDispose(Widget<T2> widget) {
                    if (!composedContainer.isDisposed()) {
                        composedContainer.dispose();
                        form.reflow(true);
                    }
                }
            };
            widget.addDisposeListener(disposeListener);
            composedContainer.addDisposeListener(new DisposeListener() {

                @Override
                public void widgetDisposed(DisposeEvent e) {
                    widget.removeDisposeListener(disposeListener);
                    widget.dispose();
                }
            });
        } finally {
            // Restoration of the original container
            getSwtContext().setWidgetContainer(saveContainer);
        }
        return compositeContainer;
    }

    /**
     * Create an SWT widget for {@link FlexibleWidget}.
     * 
     * @param container
     * @param widget
     */
    protected Composite createComposed(ExpandableComposite container, ComposedWidget<?> widget) {
        FormToolkit toolkit = getSwtContext().getToolkit();
        Composite composed = toolkit.createComposite(container);
        composed.setLayout(GridLayoutHelper.createWithNoMargin(GRID_COLUMNS));
        container.setClient(composed);

        addComposedWidgetListeners(widget, container);

        return composed;
    }

    /**
     * Add the necessary listeners to the given {@link ComposedWidget} and its
     * corresponding {@link ExpandableComposite}.
     * 
     * @param widget
     * @param expandable
     */
    protected void addComposedWidgetListeners(final ComposedWidget<?> widget, final ExpandableComposite expandable) {
        final ScrolledForm form = getSwtContext().getForm();

        expandable.addExpansionListener(new ExpansionAdapter() {
            @Override
            public void expansionStateChanged(ExpansionEvent e) {
                form.reflow(true);
            }
        });
    }
    
    @Override
    protected void addControlDisposedListener(Widget<?> madWidget, Control swtWidget) {
        // Does nothing
    }
    
    @Override
    protected void addVisibilityListener(Widget<?> madWidget, Control swtWidget) {
        // Does nothing
    }

}
