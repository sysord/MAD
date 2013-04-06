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

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.widget.SingleSelectTextBox;
import com.sysord.mad.ui.swt.*;
import com.sysord.mad.ui.swt.widget.AbstractSWTWidget;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;

/**
 * Represents a MAD {@link SingleSelectWidget} with an SWT {@link SingleSelectTextBox}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class DialogListWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        // TODO Method implementation
        
    }

    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite container = getSwtContext().getWidgetContainer();
        SingleSelectWidget<Object> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        Label errorLabel = createLabelColumn(toolkit, container, widget);

        SingleSelectTextBox selectTextbox = new SingleSelectTextBox(container, toolkit, SWT.NONE);
        selectTextbox.setLabelProvider(new CandidateLabelProvider());
        selectTextbox.setContentProvider(new ArrayContentProvider());
        selectTextbox.setComparator(CandidateComparator.instance);
        selectTextbox.setInput(widget.getCandidates());
        selectTextbox.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());

        // Set the initial selection
        if (widget.getValue() != null) {
            Candidate element = toCandidateElement(widget.getCandidates(), widget.getValue());
            selectTextbox.setSelection(element);
        }

        toolkit.adapt(selectTextbox, true, false);

        // Add the commands buttons for the dialog list.
        addCommandsButtons(container, toolkit, widget, selectTextbox);
        // Add the listeners to the widget and the list viewer
        addDialogListListeners(widget, selectTextbox, errorLabel);

        return selectTextbox;
    }

    /**
     * Add the needed listeners to the single select textbox
     * 
     * @param widget
     * @param selectTextbox
     * @param errorLabel
     */
    protected void addDialogListListeners(final SingleSelectWidget<Object> widget,
            final SingleSelectTextBox selectTextbox, final Label errorLabel) {
        final ModifyListener[] modifyListenerContainer = new ModifyListener[1];
        // Add a listener on the MAD single list widget
        final AWidgetValueListener<Object> valueListener = new AWidgetValueListener<Object>() {
    
            @Override
            protected void _valueChanged(Object ancientValue, Object newValue) {
                if (!selectTextbox.isDisposed()) {
                    selectTextbox.getTextbox().removeModifyListener(modifyListenerContainer[0]);
                    Candidate element = toCandidateElement(widget.getCandidates(), newValue);
                    selectTextbox.setSelection(element);
                    selectTextbox.getTextbox().addModifyListener(modifyListenerContainer[0]);
                }
            }
        };
        widget.addValueListener(valueListener);
        final ModelAction listValueChangedAction = new ModelAction(valueListener, widget.getAdapter()) {
    
            @Override
            protected void action() {
                widget.setValue(getSelectedValue());
            }
    
            @Override
            protected boolean canRun() {
                boolean canrun = !selectTextbox.isDisposed();
                if (canrun) {
                    String error = validate(widget, getSelectedValue());
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    canrun = canrun && error == null;
                }
                return canrun;
            }
    
            private Object getSelectedValue() {
                Object newValue;
                if (selectTextbox.getSelection() == null) {
                    newValue = null;
                } else {
                    newValue = ((Candidate) selectTextbox.getSelection()).getValue();
                }
                return newValue;
            }
        };
        // Add a selection change listener on the SWT list widget
        ModifyListener modifyListener = new ModifyListener() {
    
            @Override
            public void modifyText(ModifyEvent e) {
                listValueChangedAction.execute();
            }
        };
        modifyListenerContainer[0] = modifyListener;
        selectTextbox.getTextbox().addModifyListener(modifyListener);
        // Add an Editable listener on the MAD pick list widget
        SWTWidgetUtil.addNewEditableStateListener(widget, selectTextbox);
    }

}
