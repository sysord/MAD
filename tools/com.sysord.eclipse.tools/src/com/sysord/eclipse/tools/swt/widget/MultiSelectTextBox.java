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
package com.sysord.eclipse.tools.swt.widget;

import java.util.Collection;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.GridLayoutHelper;

/**
 * SWT widget for multi selection. It's an uneditable textbox with a button opening a
 * dialog with a pick list.
 * <p>
 * The selected elements are written in the textbox using the label provider.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class MultiSelectTextBox extends Composite {

    private static final String BTN_DEFAULT_LBL = " ... ";
    private Text txtbox;
    private Button btn_openPicklist;
    private PickListDialog dialog;
    private ILabelProvider labelProvider;
    private FormToolkit toolkit;

    /**
     * Create a new {@code MultiSelectTextBox}.
     * 
     * @param parent The parent {@link Composite}.
     * @param style The style of this {@code MultiSelectTextBox}.
     */
    public MultiSelectTextBox(Composite parent, int style) {
        super(parent, style);
        init();
    }

    /**
     * Create a new {@code MultiSelectTextBox}.
     * 
     * @param parent The parent {@link Composite}.
     * @param toolkit The {@link FormToolkit} used for creating this
     *        {@code MultiSelectTextBox}.
     * @param style The style of this {@code MultiSelectTextBox}.
     */
    public MultiSelectTextBox(Composite parent, FormToolkit toolkit, int style) {
        super(parent, style);
        this.toolkit = toolkit;
        init();
    }

    /**
     * Initialize the default properties and behavior of this {@code MultiSelectTextBox}.
     * <p>
     * (Create the textbox and the button)
     */
    private void init() {
        setLayout(GridLayoutHelper.createWithNoMargin(2));

        txtbox = new Text(this, SWT.BORDER);
        txtbox.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtbox.setEditable(false);

        dialog = new PickListDialog(getShell(), toolkit);

        btn_openPicklist = new Button(this, SWT.NONE);
        btn_openPicklist.setText(BTN_DEFAULT_LBL);
        btn_openPicklist.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                afterClose(dialog.open());
            }
        });
    }

    /**
     * Called when the dialog is closed.
     * 
     * @param code the returned code when closed
     */
    protected void afterClose(int code) {
        if (code == PickListDialog.OK) {
            updateTextbox();
        }
    }

    /**
     * Update the textbox content with the current selection.
     */
    protected void updateTextbox() {
        StringBuilder value = new StringBuilder();
        for (Object element : getSelection()) {
            value.append(labelProvider.getText(element));
            value.append(", ");
        }
        if (value.length() > 0) {
            value.delete(value.length() - 2, value.length());
        }
        txtbox.setText(value.toString());
    }

    public Text getTextbox() {
        return txtbox;
    }

    public Button getButton() {
        return btn_openPicklist;
    }

    public Collection<Object> getSelection() {
        return dialog.getSelection();
    }

    public void setSelection(Collection<Object> selection) {
        dialog.setSelection(selection);
        updateTextbox();
    }

    public void setLabelProvider(ILabelProvider labelProvider) {
        this.labelProvider = labelProvider;
        dialog.setLabelProvider(labelProvider);
    }

    public void setContentProvider(IStructuredContentProvider contentProvider) {
        dialog.setContentProvider(contentProvider);
    }

    public void setComparator(ViewerComparator comparator) {
        dialog.setComparator(comparator);
    }

    public void setInput(Object input) {
        dialog.setInput(input);
    }
    
    @Override
    public void dispose() {
        if (!isDisposed()) {
            txtbox.dispose();
            dialog.dispose();
        }
        super.dispose();
    }
}
