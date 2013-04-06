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

import java.util.*;
import java.util.List;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.ColorRegistry;
import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.*;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;

/**
 * Default SWT implementation of the {@link MultiSelectWidget}.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTMultiSelectWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof MultiSelectWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Multi List",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }

    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite container = getSwtContext().getWidgetContainer();
        MultiSelectWidget<Object> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        Label errorLabel = createLabelColumn(toolkit, container, widget);
        // Creation of the ListWiewer
        org.eclipse.swt.widgets.List l = new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.V_SCROLL
                | SWT.MULTI);
        l.setLayoutData(GridDataHelper.horizontalFill());
        l.setEnabled(widget.isEditable());
        ListViewer listViewer = SWTHelper.createListViewer(l, new CandidateLabelProvider(),
                new CandidateElementComparer(), widget.getCandidates());
        // Set the initial selection
        if (widget.getValue() != null) {
            List<Object> elements;
            if (widget.getValue() instanceof Collection) {
                elements = new ArrayList<Object>(((Collection<?>) widget.getValue()).size());
                for (Object o : ((Collection<?>) widget.getValue())) {
                    elements.add(o);
                }
            } else {
                elements = new ArrayList<Object>(1);
                elements.add(widget.getValue());
            }
            listViewer.setSelection(new StructuredSelection(elements), false);
        }
        toolkit.adapt(l, false, false);
        // Add the commands buttons for the list.
        addCommandsButtons(container, toolkit, widget, l);
        // Add the listeners to the widget and the listViewer.
        addMultiListListeners(widget, listViewer, errorLabel);
        return l;
    }

    /**
     * Add the needed listeners to the {@link ListViewer} widget and its corresponding
     * {@link MultiSelectWidget}.
     * 
     * @param widget
     * @param listViewer
     * @param errorLabel
     */
    protected void addMultiListListeners(final MultiSelectWidget<Object> widget, final ListViewer listViewer,
            final Label errorLabel) {
        final ISelectionChangedListener[] selectionContainer = new ISelectionChangedListener[1];
        // Add a listener on the MAD multi list widget
        final AWidgetValueListener<Object> valueListener = new AWidgetValueListener<Object>() {

            @Override
            protected void _valueChanged(Object ancientValue, Object newValue) {
                if (newValue != null && !listViewer.getControl().isDisposed()) {
                    listViewer.removeSelectionChangedListener(selectionContainer[0]);
                    List<Object> elements;
                    if (newValue instanceof Collection) {
                        elements = new ArrayList<Object>(((Collection<?>) newValue).size());
                        for (Object o : ((Collection<?>) newValue)) {
                            elements.add(o);
                        }
                    } else {
                        elements = new ArrayList<Object>(1);
                        elements.add(newValue);
                    }
                    listViewer.setSelection(new StructuredSelection(elements), false);
                    listViewer.addSelectionChangedListener(selectionContainer[0]);
                }
            }
        };
        widget.addValueListener(valueListener);
        // Create the ModelAction for changing the multiList elements
        final ModelAction listSelectionChangedAction = new ModelAction(valueListener, widget.getAdapter()) {

            @Override
            protected void action() {
                List<Object> elements = getSelectedValues();
                widget.setValue(elements);
                widget.setSelectedItem(new ArrayList<Object>(elements));
            }

            @Override
            protected boolean canRun() {
                boolean canrun = !listViewer.getList().isDisposed();
                if (canrun) {
                    String error = validate(widget, getSelectedValues());
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    if (error != null) {
                        listViewer.getList().setBackground(ColorRegistry.get(PALE_RED));
                    } else {
                        listViewer.getList().setBackground(ColorRegistry.get(WHITE));
                    }
                    canrun = canrun && error == null;
                }
                return canrun;
            }

            private List<Object> getSelectedValues() {
                List<Object> elements = new ArrayList<Object>();
                for (Object o : ((IStructuredSelection) listViewer.getSelection()).toList()) {
                    elements.add(((Candidate) o).getValue());
                }
                return elements;
            }
        };
        // Add a selection change listener on the SWT list widget
        ISelectionChangedListener selectionListener = new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                listSelectionChangedAction.execute();
            }
        };
        selectionContainer[0] = selectionListener;
        listViewer.addSelectionChangedListener(selectionListener);
        // Add an Editable listener on the MAD multi list widget
        SWTWidgetUtil.addNewEditableStateListener(widget, listViewer.getList());
    }

}
