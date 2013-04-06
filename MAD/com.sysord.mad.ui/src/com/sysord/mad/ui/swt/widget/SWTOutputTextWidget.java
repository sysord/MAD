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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;
import com.sysord.mad.widget.impl.OutputTextWidget;

/**
 * Default SWT implementation of the {@link OutputTextWidget}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTOutputTextWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof OutputTextWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Output Text",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }
    
    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite container = getSwtContext().getWidgetContainer();
        OutputWidget<String> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        createLabelColumn(toolkit, container, widget);

        // Composite container of the output text
        Composite outputContainer = toolkit.createComposite(container);
        outputContainer.setLayoutData(GridDataHelper.horizontalFill());
        outputContainer.setLayout(GridLayoutHelper.createWithNoMargin(1));

        // Output text created with a Text widget
        String value = widget.getValue() == null ? Lbl.emptyString : widget.getValue();
        Text outputText = toolkit.createText(outputContainer, value, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
        outputText.setLayoutData(GridDataHelper.horizontalFill());
        outputText.setEditable(false);

        // Add the commands buttons for the textbox.
        addCommandsButtons(container, toolkit, widget, outputContainer);
        // Add the listeners to the widget and the textbox.
        addOutputTextListeners(widget, outputText);
        return outputText;
    }

    /**
     * Add the needed listeners to a {@link Text} widget and its corresponding
     * {@link BasicTypeWidget}.
     * 
     * @param widget
     * @param outputText
     */
    private void addOutputTextListeners(final OutputWidget<String> widget, final Text outputText) {
        final ScrolledForm form = getSwtContext().getForm();
        outputText.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                if (form.getBody() != null && !form.getBody().isDisposed()) {
                    Point size = outputText.getSize();
                    outputText.setSize(size.x, outputText.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
                    getSwtContext().getFormBody().layout();
                    getSwtContext().getForm().reflow(true);
                }
            }
        });
        // Add a listener for external widget value change.
        final AWidgetValueListener<String> valueListener = new AWidgetValueListener<String>() {

            @Override
            protected void _valueChanged(String ancientValue, String newValue) {
                if (!outputText.isDisposed()) {
                    outputText.setText(newValue == null ? Lbl.emptyString : newValue);
                }
            }
        };
        widget.addValueListener(valueListener);
    }

}
