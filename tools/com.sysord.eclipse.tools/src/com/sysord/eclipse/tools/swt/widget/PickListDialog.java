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
import java.util.Collections;

import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.eclipse.tools.swt.SWTUtil;

/**
 * Dialog with a {@link PickList pick list}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class PickListDialog extends Window {

    public static final String BTN_CANCEL_LBL = "Cancel";
    public static final String BTN_OK_LBL = "Ok";
    protected Collection<Object> selection = Collections.emptyList();
    private FormToolkit toolkit;
    private ILabelProvider choicesLabelProvider;
    private ILabelProvider selectionLabelProvider;
    private IStructuredContentProvider contentProvider;
    private ViewerComparator comparator;
    private Object input;
    private boolean disposeToolkit;
    private boolean isDisposed;

    /**
     * Creates a new {@code PickListDialog} with its parent {@link Shell}.
     * 
     * @param parent A {@code Shell} which will be the parent of this dialog.
     * 
     * @exception IllegalArgumentException <ul>
     *            <li>ERROR_NULL_ARGUMENT - if the parent is null</li>
     *            </ul>
     * @exception SWTException <ul>
     *            <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that
     *            created the parent</li>
     *            </ul>
     */
    public PickListDialog(Shell parent) {
        super(parent);
        setShellStyle(SWT.APPLICATION_MODAL | SWT.RESIZE);
        setBlockOnOpen(true);
    }

    /**
     * Creates a new {@code PickListDialog} with its parent {@link Shell} and a
     * {@link FormToolkit toolkit}.
     * 
     * @param parent A {@code Shell} which will be the parent of this dialog.
     * 
     * @exception IllegalArgumentException <ul>
     *            <li>ERROR_NULL_ARGUMENT - if the parent is null</li>
     *            </ul>
     * @exception SWTException <ul>
     *            <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that
     *            created the parent</li>
     *            </ul>
     */
    public PickListDialog(Shell parent, FormToolkit toolkit) {
        this(parent);
        this.toolkit = toolkit;
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        container.setLayout(GridLayoutHelper.createNoSpacing(1));
        createDialog(container);
        return container;
    }

    /**
     * Create the dialog's widgets
     * 
     * @param container The {@link Composite} container.
     */
    protected void createDialog(final Composite container) {
        FormToolkit toolkit = getToolkit();

        Composite filterContainer = toolkit.createComposite(container);
        filterContainer.setLayout(GridLayoutHelper.create(2));
        filterContainer.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

        toolkit.createLabel(filterContainer, "Filter");
        final Text txt_filter = toolkit.createText(filterContainer, "", SWT.BORDER);
        txt_filter.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

        final PickList picklist = new PickList(container, SWT.NONE, toolkit, PickList.ViewerType.TABLE_VIEWER,
                PickList.ViewerType.TABLE_VIEWER, 0, 0);
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        Point size = picklist.getPickListContainer().computeSize(SWT.DEFAULT, SWT.DEFAULT);
        if (size.y < 200) {
            data.heightHint = 200;
        }
        if (size.x < 400) {
            data.widthHint = 400;
        }
        picklist.getPickListContainer().setLayoutData(data);
        initializePicklist(picklist);

        // Set the picklist filter
        final StringViewerFilter choicesFilter = new StringViewerFilter(picklist.getChoicesViewer());
        final StringViewerFilter selectionFilter = new StringViewerFilter(picklist.getSelectionViewer());
        picklist.getChoicesViewer().addFilter(choicesFilter);
        picklist.getSelectionViewer().addFilter(selectionFilter);
        txt_filter.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                choicesFilter.setStringFilter(txt_filter.getText());
                selectionFilter.setStringFilter(txt_filter.getText());
            }
        });

        picklist.addPostSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                selection = picklist.getSelection();
                container.pack();
            }
        });

        // Buttons
        Composite buttonsContainer = toolkit.createComposite(container);
        buttonsContainer.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        buttonsContainer.setLayout(GridLayoutHelper.create(2));

        Button btn_cancel = toolkit.createButton(buttonsContainer, BTN_CANCEL_LBL, SWT.PUSH);
        data = new GridData(SWT.RIGHT, SWT.BEGINNING, true, false);
        SWTUtil.computeButtonWidth(btn_cancel, data);
        btn_cancel.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setReturnCode(CANCEL);
                PickListDialog.this.close();
            }
        });

        Button btn_ok = toolkit.createButton(buttonsContainer, BTN_OK_LBL, SWT.PUSH);
        data = new GridData(SWT.RIGHT, SWT.BEGINNING, false, false);
        SWTUtil.computeButtonWidth(btn_ok, data);
        btn_ok.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setReturnCode(OK);
                PickListDialog.this.close();
            }
        });
    }

    public void setLabelProvider(ILabelProvider labelProvider) {
        choicesLabelProvider = labelProvider;
        selectionLabelProvider = labelProvider;
    }

    public void setChoicesLabelProvider(ILabelProvider labelProvider) {
        choicesLabelProvider = labelProvider;
    }

    public void setSelectionLabelProvider(ILabelProvider labelProvider) {
        selectionLabelProvider = labelProvider;
    }

    public void setContentProvider(IStructuredContentProvider contentProvider) {
        this.contentProvider = contentProvider;
    }

    public void setComparator(ViewerComparator comparator) {
        this.comparator = comparator;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    private void initializePicklist(PickList picklist) {
        if (choicesLabelProvider != null)
            picklist.setChoicesLabelProvider(choicesLabelProvider);
        if (selectionLabelProvider != null)
            picklist.setSelectionLabelProvider(selectionLabelProvider);
        if (contentProvider != null)
            picklist.setChoicesContentProvider(contentProvider);
        if (comparator != null)
            picklist.setComparator(comparator);

        picklist.setInput(input);
        picklist.setSelection(new StructuredSelection(selection.toArray()));
    }

    /**
     * Return the value of selection.
     * 
     * @return the value of selection.
     */
    public Collection<Object> getSelection() {
        return selection;
    }

    public void setSelection(Collection<Object> selection) {
        this.selection = selection;
    }
    
    /**
     * Dispose this dialog.
     */
    public void dispose() {
        if (!isDisposed) {
            isDisposed = true;
            if (disposeToolkit) {
                toolkit.dispose();
            }
            selection = null;
            choicesLabelProvider = null;
            selectionLabelProvider = null;
            contentProvider = null;
            comparator = null;
            input = null;
        }
    }

    private FormToolkit getToolkit() {
        if (toolkit == null) {
            toolkit = new FormToolkit(SWTUtil.getDisplay());
            disposeToolkit = true;
        }
        return toolkit;
    }
}