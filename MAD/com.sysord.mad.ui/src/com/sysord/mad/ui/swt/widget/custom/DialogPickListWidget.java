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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.widget.MultiSelectTextBox;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.*;
import com.sysord.mad.ui.swt.widget.AbstractSWTWidget;
import com.sysord.mad.widget.MultiSelectWidget;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;

/**
 * Represents a MAD {@link MultiSelectWidget} with an SWT {@link MultiSelectTextBox}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class DialogPickListWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof MultiSelectWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Dialog Pick List",//$NON-NLS-1$
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

        MultiSelectTextBox selectTextbox = new MultiSelectTextBox(container, SWT.NONE);
        selectTextbox.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        selectTextbox.setLabelProvider(new CandidateLabelProvider());
        selectTextbox.setContentProvider(ArrayContentProvider.getInstance());
        selectTextbox.setComparator(CandidateComparator.instance);
        selectTextbox.setInput(widget.getCandidates());

        // Set the initial selection
        if (widget.getValue() != null) {
            Collection<? extends Object> elements;
            if (widget.getValue() instanceof Collection) {
                elements = toCandidateList(widget.getCandidates(), (Collection<Object>) widget.getValue());
            } else {
                elements = Collections.emptyList();
            }
            selectTextbox.setSelection((Collection<Object>) elements);
        }

        toolkit.adapt(selectTextbox);

        // Add the commands buttons for the dialog pick list.
        addCommandsButtons(container, toolkit, widget, selectTextbox);
        // Add the listeners to the widget and the pick list viewer
        addDialogPickListListeners(widget, selectTextbox, errorLabel);

        return selectTextbox;
    }

    /**
     * Adds the needed listeners to the multi select textbox
     * 
     * @param widget
     * @param selectTextbox
     * @param errorLabel
     */
    protected void addDialogPickListListeners(final MultiSelectWidget<Object> widget,
            final MultiSelectTextBox selectTextbox, final Label errorLabel) {
        final ModifyListener[] modifyListenerContainer = new ModifyListener[1];
        // Add a listener on the MAD single pick list widget
        final AWidgetValueListener<Object> valueListener = new AWidgetValueListener<Object>() {
    
            @SuppressWarnings("unchecked")
            @Override
            protected void _valueChanged(Object ancientValue, Object newValue) {
                if (newValue != null && !selectTextbox.isDisposed()) {
                    selectTextbox.getTextbox().removeModifyListener(modifyListenerContainer[0]);
                    Collection<? extends Object> elements;
                    if (newValue instanceof Collection) {
                        elements = toCandidateList(widget.getCandidates(), (Collection<Object>) newValue);
                    } else {
                        elements = Collections.emptyList();
                    }
                    selectTextbox.setSelection((Collection<Object>) elements);
                    selectTextbox.getTextbox().addModifyListener(modifyListenerContainer[0]);
                }
            }
        };
        widget.addValueListener(valueListener);
        final ModelAction listValuesChangedAction = new ModelAction(valueListener, widget.getAdapter()) {
    
            @Override
            protected void action() {
                widget.setValue(getSelectedValues());
            }
    
            @Override
            protected boolean canRun() {
                boolean canrun = !selectTextbox.isDisposed();
                if (canrun) {
                    String error = validate(widget, getSelectedValues());
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    canrun = canrun && error == null;
                }
                return canrun;
            }
    
            private Collection<Object> getSelectedValues() {
                Collection<Object> values = candidatesToElementList(selectTextbox.getSelection());
                return values;
            }
        };
        // Add a selection change listener on the SWT pick list widget
        ModifyListener modifyListener = new ModifyListener() {
    
            @Override
            public void modifyText(ModifyEvent e) {
                listValuesChangedAction.execute();
            }
        };
        modifyListenerContainer[0] = modifyListener;
        selectTextbox.getTextbox().addModifyListener(modifyListener);
        // Add an Editable listener on the MAD pick list widget
        SWTWidgetUtil.addNewEditableStateListener(widget, selectTextbox);
    }

}
