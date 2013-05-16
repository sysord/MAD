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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.ColorRegistry;
import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.ModelAction;
import com.sysord.mad.ui.swt.SWTWidgetUtil;
import com.sysord.mad.ui.swt.widget.AbstractSWTWidget;
import com.sysord.mad.widget.BasicTypeWidget;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;

/**
 * Represents a MAD String {@link BasicTypeWidget} with an SWT multi lines {@link Text}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class TextAreaWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof BasicTypeWidget) || widget.getType() != String.class) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Text Area",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }

    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite container = getSwtContext().getWidgetContainer();
        BasicTypeWidget<String> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        Label errorLabel = createLabelColumn(toolkit, container, widget);
        String value = widget.getValue() == null ? Lbl.emptyString : widget.getValue();
        Text textarea = toolkit.createText(container, value, SWT.MULTI | SWT.WRAP | SWT.BORDER | SWT.V_SCROLL);
        textarea.setEnabled(widget.isEditable());
        textarea.setLayoutData(GridDataHelper.horizontalFill());
        // Add the commands buttons for the text area.
        addCommandsButtons(container, toolkit, widget, textarea);
        // Add the listeners to the widget and the text area
        addTextAreaListeners(widget, textarea, errorLabel);
        return textarea;
    }

    /**
     * Add the needed listeners to the {@link Text} widget and its corresponding
     * {@link BasicTypeWidget}.
     * 
     * @param widget
     * @param textarea
     * @param errorLabel
     */
    private void addTextAreaListeners(final BasicTypeWidget<String> widget, final Text textarea, final Label errorLabel) {
        textarea.addModifyListener(new ModifyListener() {

            Composite formBody = getSwtContext().getFormBody();

            @Override
            public void modifyText(ModifyEvent e) {
                if (formBody != null && !formBody.isDisposed()) {
                    textarea.setSize(textarea.computeSize(SWT.DEFAULT, SWT.DEFAULT));
                    getSwtContext().getFormBody().layout();
                    getSwtContext().getForm().reflow(true);
                }
            }
        });
        final FocusListener[] focusContainer = new FocusListener[1];
        // Add a listener for external widget value change.
        final AWidgetValueListener<String> valueListener = new AWidgetValueListener<String>() {

            @Override
            protected void _valueChanged(String ancientValue, String newValue) {
                if (!textarea.isDisposed()) {
                    textarea.removeFocusListener(focusContainer[0]);
                    textarea.setText(newValue == null ? Lbl.emptyString : newValue);
                    textarea.addFocusListener(focusContainer[0]);
                }
            }
        };
        widget.addValueListener(valueListener);
        // Create the ModelAction for changing the text area content
        final ModelAction textareaContentChangedAction = new ModelAction(valueListener, widget.getAdapter()) {

            @Override
            protected void action() {
                widget.setValue(textarea.getText() == null ? Lbl.emptyString : textarea.getText());
            }

            @Override
            protected boolean canRun() {
                boolean canrun = !textarea.isDisposed()
                        && !textarea.getText().equals(widget.getValue() == null ? Lbl.emptyString : widget.getValue());
                if (canrun) {
                    String error = validate(widget, textarea.getText());
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    if (error != null) {
                        textarea.setBackground(ColorRegistry.get(PALE_RED));
                    } else {
                        textarea.setBackground(ColorRegistry.get(WHITE));
                    }
                    canrun = canrun && error == null;
                }
                return canrun;
            }
        };
        // Add a ley listener
        textarea.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) && (e.stateMask & SWT.CTRL) != 0) {
					e.doit = false;
					textareaContentChangedAction.execute();
				}
			}
		});
        // Add a focus lost listener on the SWT widget updating the MAD widget value
        FocusAdapter focusListener = new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                textareaContentChangedAction.execute();
            }
        };
        focusContainer[0] = focusListener;
        textarea.addFocusListener(focusListener);
        // Add a listener on the MAD Widget editable property
        SWTWidgetUtil.addNewEditableStateListener(widget, textarea);
    }

}
