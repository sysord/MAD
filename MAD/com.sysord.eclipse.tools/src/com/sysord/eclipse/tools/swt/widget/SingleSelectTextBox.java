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

import org.eclipse.jface.viewers.*;
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
 * SWT widget for single selection. It's an uneditable textbox with a button opening a
 * dialog with a list of elements.
 * <p>
 * The selected element is written in the textbox using the label provider.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SingleSelectTextBox extends Composite {

    private static final String BTN_DEFAULT_LBL = " ... ";
    private static final String BTN_DESELECT_LBL = "Deselect";

    private Text txtbox;
    private Button btn_openList;
    private ListDialog dialog;
    private ILabelProvider labelProvider;
    private IContentProvider contentProvider;
    private IElementComparer elementComparer;
    private ViewerComparator comparator;
    private Object input;

    private FormToolkit toolkit;

    /**
     * Create a new {@code MultiSelectTextBox}.
     * 
     * @param parent The parent {@link Composite}.
     * @param style The style of this {@code MultiSelectTextBox}.
     */
    public SingleSelectTextBox(Composite parent, int style) {
        super(parent, style);
        init();
    }

    /**
     * Create a new {@code MultiSelectTextBox} with the given {@link FormToolkit}.
     * 
     * @param parent The parent {@link Composite}.
     * @param toolkit {@code FormToolkit} for creating the widgets.
     * @param style The style of this {@code MultiSelectTextBox}.
     */
    public SingleSelectTextBox(Composite parent, FormToolkit toolkit, int style) {
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
        GridData data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
        txtbox.setLayoutData(data);
        txtbox.setEditable(false);

        dialog = new ListDialog(getShell());

        btn_openList = new Button(this, SWT.NONE);
        btn_openList.setText(BTN_DEFAULT_LBL);
        btn_openList.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                afterClose(dialog.open());
            }
        });
    }

    /**
     * Called when the dialog is closed.
     * 
     * @param valid {@code True} if the dialog has been validated; {@code false}
     *        otherwise.
     */
    protected void afterClose(boolean valid) {
        if (valid) {
            updateTextbox();
        }
    }

    /**
     * Update the textbox content with the current selection.
     */
    protected void updateTextbox() {
        StringBuilder value = new StringBuilder();
        if (getSelection() != null) {
            value.append(labelProvider.getText(getSelection()));
        }
        txtbox.setText(value.toString());
    }

    public Text getTextbox() {
        return txtbox;
    }

    public Button getButton() {
        return btn_openList;
    }

    public Object getSelection() {
        return dialog.getSelection();
    }

    public void setSelection(Object selection) {
        dialog.setSelection(selection);
        updateTextbox();
    }

    public void setLabelProvider(ILabelProvider labelProvider) {
        this.labelProvider = labelProvider;
    }

    public void setContentProvider(IContentProvider contentProvider) {
        this.contentProvider = contentProvider;
    }

    public void setElementComparer(IElementComparer elementComparer) {
        this.elementComparer = elementComparer;
    }

    public void setComparator(ViewerComparator comparator) {
        this.comparator = comparator;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    protected class ListDialog extends Dialog {

        public static final String BTN_CANCEL_LBL = "Cancel";
        public static final String BTN_OK_LBL = "Ok";
        private static final String LBL_FILTER_FIELD = "Filter";
        protected Object selection;
        private Shell shell;
        private boolean ok;
        private TableViewer tableViewer;
        private Object mementoSelection;

        /**
         * Create a new {@code ListDialog} with its parent {@link Shell}.
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
        public ListDialog(Shell parent) {
            super(parent);
        }

        /**
         * Open this {@code ListDialog}.
         */
        public boolean open() {
            Shell parent = getParent();
            shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.RESIZE | SWT.APPLICATION_MODAL);
            shell.setText(getText());
            createDialog(shell);
            shell.pack();
            shell.open();
            Display display = parent.getDisplay();
            while (!shell.isDisposed()) {
                if (!display.readAndDispatch())
                    display.sleep();
            }
            if (isOk()) {
                mementoSelection = selection;
            } else {
                selection = mementoSelection;
            }
            return isOk();
        }

        /**
         * Create the dialog's widgets
         * 
         * @param shell The containing {@code Shell}.
         */
        protected void createDialog(Shell shell) {
            shell.setLayout(GridLayoutHelper.createNoSpacingNoMargin(1));

            final Text txt_filter = createFilterField(shell);

            Table table;
            if (toolkit != null) {
                table = toolkit.createTable(shell, SWT.BORDER | SWT.SINGLE);
            } else {
                table = new Table(shell, SWT.BORDER | SWT.SINGLE);
            }
            GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
            Point size = table.computeSize(SWT.DEFAULT, SWT.DEFAULT);
            if (size.y < 200) {
                data.heightHint = 200;
            } else if (size.y > 500) {
                data.heightHint = 500;
            }
            if (size.x < 400) {
                data.widthHint = 400;
            }
            table.setLayoutData(data);

            // Table viewer creation
            tableViewer = new TableViewer(table);
            initTableViewer();
            
            // Set the tableViewer filter
            final StringViewerFilter filter = new StringViewerFilter(tableViewer);
            tableViewer.addFilter(filter);
            txt_filter.addModifyListener(new ModifyListener() {
                
                @Override
                public void modifyText(ModifyEvent e) {
                    filter.setStringFilter(txt_filter.getText());
                }
            });

            // Buttons
            Composite buttonsContainer = null;
            if (toolkit == null) {
                buttonsContainer = new Composite(shell, SWT.NONE);
            } else {
                buttonsContainer = toolkit.createComposite(shell);
            }
            buttonsContainer.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
            buttonsContainer.setLayout(GridLayoutHelper.create(3));

            Button btn_deselect;
            if (toolkit == null) {
                btn_deselect = new Button(buttonsContainer, SWT.PUSH);
                btn_deselect.setText(BTN_DESELECT_LBL);
            } else {
                btn_deselect = toolkit.createButton(buttonsContainer, BTN_DESELECT_LBL, SWT.PUSH);
            }
            data = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false);
            data.verticalIndent = 10;
            SWTUtil.computeButtonWidth(btn_deselect, data);
            btn_deselect.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    tableViewer.setSelection(new StructuredSelection());
                }
            });

            Button btn_cancel;
            if (toolkit == null) {
                btn_cancel = new Button(buttonsContainer, SWT.PUSH);
                btn_cancel.setText(BTN_CANCEL_LBL);
            } else {
                btn_cancel = toolkit.createButton(buttonsContainer, BTN_CANCEL_LBL, SWT.PUSH);
            }
            data = new GridData(SWT.RIGHT, SWT.BEGINNING, true, false);
            data.verticalIndent = 10;
            SWTUtil.computeButtonWidth(btn_cancel, data);
            btn_cancel.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    if (ListDialog.this.shell != null && !ListDialog.this.shell.isDisposed()) {
                        ok = false;
                        ListDialog.this.shell.close();
                    }
                }
            });

            Button btn_ok;
            if (toolkit == null) {
                btn_ok = new Button(buttonsContainer, SWT.PUSH);
                btn_ok.setText(BTN_OK_LBL);
            } else {
                btn_ok = toolkit.createButton(buttonsContainer, BTN_OK_LBL, SWT.PUSH);
            }
            data = new GridData(SWT.RIGHT, SWT.BEGINNING, false, false);
            data.verticalIndent = 10;
            SWTUtil.computeButtonWidth(btn_ok, data);
            btn_ok.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    if (ListDialog.this.shell != null && !ListDialog.this.shell.isDisposed()) {
                        ok = true;
                        ListDialog.this.shell.close();
                    }
                }
            });
        }

        protected Text createFilterField(Shell shell) {
            Composite fieldContainer;
            if (toolkit != null) {
                fieldContainer = toolkit.createComposite(shell);
            } else {
                fieldContainer = new Composite(shell, SWT.NONE);
            }
            fieldContainer.setLayout(GridLayoutHelper.create(2));
            fieldContainer.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

            Label lbl_filter;
            if (toolkit != null) {
                lbl_filter = toolkit.createLabel(fieldContainer, LBL_FILTER_FIELD);
            } else {
                lbl_filter = new Label(shell, SWT.NONE);
                lbl_filter.setText(LBL_FILTER_FIELD);
            }
            
            final Text txt_filter;
            if (toolkit != null) {
                txt_filter = toolkit.createText(fieldContainer, "", SWT.BORDER);
            } else {
                txt_filter = new Text(fieldContainer, SWT.BORDER);
            }
            txt_filter.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
            
            return txt_filter;
        }

        /**
         * Initializes the table viewer
         */
        public void initTableViewer() {
            if (contentProvider != null)
                tableViewer.setContentProvider(contentProvider);
            if (labelProvider != null)
                tableViewer.setLabelProvider(labelProvider);
            if (elementComparer != null)
                tableViewer.setComparer(elementComparer);
            if (comparator != null)
                tableViewer.setComparator(comparator);
            if (input != null)
                tableViewer.setInput(input);

            StructuredSelection initSelect;
            if (selection != null) {
                initSelect = new StructuredSelection(selection);
            } else {
                initSelect = new StructuredSelection();
            }
            tableViewer.setSelection(initSelect);

            tableViewer.addPostSelectionChangedListener(new ISelectionChangedListener() {

                @Override
                public void selectionChanged(SelectionChangedEvent event) {
                    if (selection != ((IStructuredSelection) tableViewer.getSelection()).getFirstElement()) {
                        selection = tableViewer.getSelection();
                        if (selection instanceof IStructuredSelection) {
                            selection = ((IStructuredSelection) selection).getFirstElement();
                        }
                    }
                }
            });

            tableViewer.addDoubleClickListener(new IDoubleClickListener() {

                @Override
                public void doubleClick(DoubleClickEvent event) {
                    if (ListDialog.this.shell != null && !ListDialog.this.shell.isDisposed()) {
                        ok = true;
                        ListDialog.this.shell.close();
                    }
                }
            });
        }

        /**
         * Return the value of selection.
         * 
         * @return the value of selection.
         */
        public Object getSelection() {
            return selection;
        }

        public void setSelection(Object selection) {
            this.selection = selection;
            this.mementoSelection = selection;
        }

        /**
         * Return the value of ok.
         * 
         * @return the value of ok.
         */
        public boolean isOk() {
            return ok;
        }
    }
}
