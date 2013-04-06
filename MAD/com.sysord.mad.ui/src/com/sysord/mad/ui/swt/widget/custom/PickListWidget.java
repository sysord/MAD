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

import java.util.*;
import java.util.List;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.widget.PickList;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.*;
import com.sysord.mad.ui.swt.widget.AbstractSWTWidget;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;

/**
 * Custom widget representing a multi select widget with a pick list.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class PickListWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof MultiSelectWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Pick List",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite container = getSwtContext().getWidgetContainer();
        MultiSelectWidget<Object> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        Label errorLabel = createLabelColumn(toolkit, container, widget);

        PickList picklist = new PickList(container, SWT.BORDER, toolkit, PickList.ViewerType.TABLE_VIEWER,
                PickList.ViewerType.TABLE_VIEWER, 0, 0);
        picklist.getPickListContainer().setLayoutData(GridDataHelper.horizontalFill());
        CandidateLabelProvider labelProvider = new CandidateLabelProvider();
        picklist.setSelectionLabelProvider(labelProvider);
        picklist.setChoicesLabelProvider(labelProvider);
        picklist.setChoicesContentProvider(ArrayContentProvider.getInstance());
        picklist.setElementComparer(new CandidateElementComparer());
        picklist.setComparator(CandidateComparator.instance);
        picklist.setInput(widget.getCandidates());

        // Set the initial selection
        if (widget.getValue() != null) {
            Collection<Candidate> elements = Collections.emptyList();
            if (widget.getValue() instanceof Collection) {
                elements = toCandidateList(widget.getCandidates(), (Collection<Object>) widget.getValue());
            }
            IStructuredSelection selection = new StructuredSelection(elements.toArray());
            picklist.setSelection(selection);
        }

        // Add the commands buttons for the pick list.
        addCommandsButtons(container, toolkit, widget, picklist.getPickListContainer());
        // Add the listeners to the widget and the pick list viewer
        addPickListListeners(widget, picklist, errorLabel);

        return picklist.getPickListContainer();
    }

    /**
     * Add the needed listeners to the widget and the picklist.
     * 
     * @param widget
     * @param picklist
     * @param errorLabel
     */
    private void addPickListListeners(final MultiSelectWidget<Object> widget, final PickList picklist,
            final Label errorLabel) {
        final ISelectionChangedListener[] selectionChangedContainer = new ISelectionChangedListener[1];
        // Add a listener on the MAD single pick list widget
        final AWidgetValueListener<Object> valueListener = new AWidgetValueListener<Object>() {

            @Override
            @SuppressWarnings("unchecked")
            protected void _valueChanged(Object ancientValue, Object newValue) {
                if (newValue != null && !picklist.getPickListContainer().isDisposed()) {
                    picklist.removePostSelectionChangedListener(selectionChangedContainer[0]);
                    Collection<Candidate> elements = Collections.emptyList();
                    if (newValue instanceof Collection) {
                        elements = toCandidateList(widget.getCandidates(), (Collection<Object>) newValue);
                    }
                    IStructuredSelection selection = new StructuredSelection(elements.toArray());
                    picklist.setSelection(selection);
                    picklist.addPostSelectionChangedListener(selectionChangedContainer[0]);
                }
            }
        };
        widget.addValueListener(valueListener);
        // Add a candidates listener on the mad widget picklist.
        widget.addCandidatesListener(new CandidateListener() {
            @Override
            public void candidatesChanged(List<Candidate> candidates) {
                picklist.refreshInput(candidates);
            }
        });
        final ModelAction listValuesChangedAction = new ModelAction(valueListener, widget.getAdapter()) {

            @Override
            protected void action() {
                widget.setValue(getSelectedValues());
            }

            @Override
            protected boolean canRun() {
                boolean canrun = !picklist.getChoicesViewer().getControl().isDisposed();
                if (canrun) {
                    String error = validate(widget, getSelectedValues());
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    canrun = canrun && error == null;
                }
                return canrun;
            }

            private Object getSelectedValues() {
                Collection<Object> values = candidatesToElementList(picklist.getSelection());
                return values;
            }
        };
        // Add a selection change listener on the SWT pick list widget
        ISelectionChangedListener selectionChangedListener = new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                listValuesChangedAction.execute();
            }
        };
        selectionChangedContainer[0] = selectionChangedListener;
        picklist.addPostSelectionChangedListener(selectionChangedListener);
        // Add an Editable listener on the MAD pick list widget
        SWTWidgetUtil.addNewEditableStateListener(widget, picklist.getPickListContainer());
    }

}
