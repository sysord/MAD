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
package com.sysord.mad.core.preferences;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.eclipse.tools.swt.SWTUtil;
import com.sysord.eclipse.tools.swt.widget.WorkspaceFileViewer;

/**
 * Dialog for choosing a resource in the current workspace.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class WorkspaceFileDialog extends Dialog {

	private static final String DEFAULT_TITLE = "Browse Workspace";
	private static final String LBL_CANCEL = "Cancel";
	private static final String LBL_OK = "Ok";
	private String selectedURI;
	private Button btn_Ok;

	/**
	 * Creates a new {@code WorkspaceFileDialog}.
	 */
	public WorkspaceFileDialog(IShellProvider shellProvider) {
		super(shellProvider.getShell(), SWT.RESIZE | SWT.APPLICATION_MODAL);
		setText(DEFAULT_TITLE);
	}

	/**
	 * Opens this dialog and returns the selected resource URI or {@code null}.
	 * 
	 * @return the selected resource URI or {@code null}.
	 */
	public String open() {
		Shell parent = getParent();
		Shell shell = new Shell(parent, SWT.RESIZE | SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(getText());
		createControl(shell);
		shell.setSize(shell.computeSize(550, 450));
		shell.open();
		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return selectedURI;
	}

	/**
	 * Creates the dialog content.
	 * 
	 * @param shell
	 */
	private void createControl(final Shell shell) {
		shell.setLayout(GridLayoutHelper.create(1));
		
		WorkspaceFileViewer<IResource> fileViewer = new WorkspaceFileViewer<IResource>(IResource.class, shell, SWT.NONE);
		fileViewer.setLayoutData(GridDataHelper.bothFill());
		fileViewer.addFilter(new MADConfigFilter());
		fileViewer.initialize(EclipseTools.getCurrentWorkspace().getRoot(), null);

		// Buttons

		Composite buttonsContainer = new Composite(shell, SWT.NONE);
		buttonsContainer.setLayoutData(GridDataHelper.horizontalFill());
		buttonsContainer.setLayout(GridLayoutHelper.createWithNoMargin(2));

		Button btn_Cancel = new Button(buttonsContainer, SWT.PUSH);
		btn_Cancel.setText(LBL_CANCEL);
		SWTUtil.computeButtonWidth(btn_Cancel, GridDataHelper.alignRightHorizontalGrab());

		btn_Ok = new Button(buttonsContainer, SWT.PUSH);
		btn_Ok.setText(LBL_OK);
		GridData data = GridDataHelper.alignRightHorizontalGrab();
		data.grabExcessHorizontalSpace = false;
		SWTUtil.computeButtonWidth(btn_Ok, data);
		
		// Actions
		
		fileViewer.addPostSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection.isEmpty()) {
					selectedURI = null;
				} else {
					Object selected = selection.getFirstElement();
					if (selected instanceof IFile && "mad".equals(((IFile) selected).getFileExtension())) {//$NON-NLS-1$
						String filePath = ((IFile) selected).getFullPath().toString();
						selectedURI = "platform:/resource" + filePath;//$NON-NLS-1$
					} else {
						selectedURI = null;
					}
				}
				updateDialog();
			}
		});
		
		btn_Cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedURI = null;
				shell.close();
			}
		});
		
		btn_Ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
	}

	private void updateDialog() {
		btn_Ok.setEnabled(selectedURI != null);
	}

	/**
	 * {@link ViewerFilter} for MAD Configuration files.
	 */
	private static class MADConfigFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof IProject) {
				return ((IProject) element).isOpen();
			}// else
			if (element instanceof IFile) {
				return "mad".equals(((IFile) element).getFileExtension());//$NON-NLS-1$
			}// else
			return true;
		}

	}
}
