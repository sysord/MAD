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
package com.sysord.mad.ui.swt.widget.custom;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.*;
import com.sysord.mad.ui.swt.widget.AbstractSWTWidget;
import com.sysord.mad.widget.SingleSelectWidget;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;

/**
 * Custom widget representing a single select widget with a list.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ListSingleSelectWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof SingleSelectWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "List Single Select",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }

    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite container = getSwtContext().getWidgetContainer();
        SingleSelectWidget<Object> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        Label errorLabel = createLabelColumn(toolkit, container, widget);

        // Creation of the TableViewer
        Table table = toolkit.createTable(container, SWT.BORDER | SWT.SINGLE);
        table.setLayoutData(GridDataHelper.horizontalFill());
        table.setEnabled(widget.isEditable());
        TableViewer tableViewer = new TableViewer(table);
        tableViewer.setContentProvider(ArrayContentProvider.getInstance());
        tableViewer.setComparer(new CandidateElementComparer());
        tableViewer.setLabelProvider(new CandidateLabelProvider());
        tableViewer.setComparator(CandidateComparator.instance);
        tableViewer.setInput(widget.getCandidates());
        // Set the initial selection
        if (widget.getValue() != null) {
            tableViewer.setSelection(new StructuredSelection(widget.getValue()), true);
        }
        toolkit.adapt(table, false, false);
        // Add the commands buttons for the table.
        addCommandsButtons(container, toolkit, widget, table);
        // Add the listeners to the widget and the table viewer
        addSingleListListeners(widget, tableViewer, errorLabel);

        return table;
    }

    /**
     * Adds the needed listeners to the {@link TableViewer} widget and its corresponding
     * {@link SingleSelectWidget}.
     * 
     * @param widget
     * @param tableViewer
     * @param errorLabel
     */
    protected void addSingleListListeners(final SingleSelectWidget<Object> widget, final TableViewer tableViewer,
            final Label errorLabel) {
        final ISelectionChangedListener[] selectionChangedContainer = new ISelectionChangedListener[1];
        // Add a listener on the MAD single list widget
        final AWidgetValueListener<Object> valueListener = new AWidgetValueListener<Object>() {

            @Override
            protected void _valueChanged(Object ancientValue, Object newValue) {
                if (!tableViewer.getControl().isDisposed()) {
                    tableViewer.removeSelectionChangedListener(selectionChangedContainer[0]);
                    tableViewer.setSelection(createSelection(newValue), false);
                    tableViewer.addSelectionChangedListener(selectionChangedContainer[0]);
                }
            }
        };
        widget.addValueListener(valueListener);
        final ModelAction listValueChangedAction = new ModelAction(valueListener, widget.getAdapter()) {

            @Override
            protected void action() {
                Object newValue = getSelectedValue();
                if (!widgetValueEqualsCandidate(widget, newValue)) {
                    widget.setValue(newValue);
                } else {
                    tableViewer.setSelection(new StructuredSelection());
                    widget.setSelectedItem(null);
                }
            }

            @Override
            protected boolean canRun() {
                boolean canrun = !tableViewer.getTable().isDisposed();
                if (canrun) {
                    String error = validate(widget, getSelectedValue());
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    canrun = canrun && error == null;
                }
                return canrun;
            }

            private Object getSelectedValue() {
                Object newValue = ((IStructuredSelection) tableViewer.getSelection()).getFirstElement();
                return newValue;
            }
        };
        // Add a selection change listener on the SWT list widget
        ISelectionChangedListener selectionChanged = new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                listValueChangedAction.execute();
            }
        };
        selectionChangedContainer[0] = selectionChanged;
        tableViewer.addSelectionChangedListener(selectionChanged);
        // Add an Editable listener on the MAD multi list widget
        SWTWidgetUtil.addNewEditableStateListener(widget, tableViewer.getControl());
    }

}
