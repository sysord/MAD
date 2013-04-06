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

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.ColorRegistry;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.*;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;

/**
 * Default SWT implementation of the {@link SingleSelectWidget}.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTComboWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof SingleSelectWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Combo",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }
    
    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite container = getSwtContext().getWidgetContainer();
        SingleSelectWidget<Object> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        Label errorLabel = createLabelColumn(toolkit, container, widget);

        Combo combo = new Combo(container, SWT.READ_ONLY);
        combo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        for (Candidate c : widget.getCandidates()) {
            combo.add(c.getLabel());
        }
        combo.setEnabled(widget.isEditable());
        // Create a ComboViewer from the CCombo
        ComboViewer comboViewer = SWTHelper.createComboViewer(combo, new CandidateLabelProvider(),
                new CandidateElementComparer(), widget.getCandidates());
        // Set the initial selection of the combo
        if (widget.getValue() != null) {
            comboViewer.setSelection(new StructuredSelection(widget.getValue()), false);
        }
        toolkit.adapt(combo, true, false);
        // Add the commands buttons for the combo.
        addCommandsButtons(container, toolkit, widget, combo);

        // Add the listeners to the widget and the combo viewer.
        addComboListeners(widget, comboViewer, errorLabel);
        return combo;
    }

    /**
     * Add the needed listeners to the {@link ComboViewer} widget and its corresponding
     * {@link SingleSelectWidget}.
     * 
     * @param widget
     * @param comboViewer
     * @param errorLabel
     */
    protected void addComboListeners(final SingleSelectWidget<Object> widget, final ComboViewer comboViewer,
            final Label errorLabel) {
        final ISelectionChangedListener[] selectionContainer = new ISelectionChangedListener[1];
        // Add a value listener on the MAD combo widget.
        final AWidgetValueListener<Object> valueListener = new AWidgetValueListener<Object>() {

            @Override
            protected void _valueChanged(Object ancientValue, Object newValue) {
                if (!comboViewer.getControl().isDisposed()) {
                    comboViewer.removeSelectionChangedListener(selectionContainer[0]);
                    ISelection selection;
                    if (newValue != null) {
                        selection = new StructuredSelection(newValue);
                    } else {
                        selection = new StructuredSelection();
                    }
                    comboViewer.setSelection(selection, true);
                    comboViewer.addSelectionChangedListener(selectionContainer[0]);
                }
            }
        };
        widget.addValueListener(valueListener);
        // Create the ModelAction for changing the combo selected element
        final ModelAction comboSelectionChangedAction = new ModelAction(valueListener, widget.getAdapter()) {

            @Override
            protected void action() {
                widget.setValue(getSelectedValue());
            }

            @Override
            protected boolean canRun() {
                boolean canrun = !comboViewer.getCombo().isDisposed();
                if (canrun) {
                    String error = validate(widget, getSelectedValue());
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    if (error != null) {
                        comboViewer.getCombo().setBackground(ColorRegistry.get(PALE_RED));
                    } else {
                        comboViewer.getCombo().setBackground(null);
                    }
                    canrun = canrun && error == null;
                }
                return canrun;
            }

            private Object getSelectedValue() {
                IStructuredSelection selection = (IStructuredSelection) comboViewer.getSelection();
                Object value;
                if (!selection.isEmpty()) {
                    value = ((Candidate) selection.getFirstElement()).getValue();
                } else {
                    value = null;
                }
                return value;
            }
        };
        // Add a selection change on the SWT combo widget
        ISelectionChangedListener selectionListener = new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                comboSelectionChangedAction.execute();
            }
        };
        selectionContainer[0] = selectionListener;
        comboViewer.addSelectionChangedListener(selectionListener);
        // Add an editable listener on the MAD combo widget.
        SWTWidgetUtil.addNewEditableStateListener(widget, comboViewer.getCombo());
    }

}
