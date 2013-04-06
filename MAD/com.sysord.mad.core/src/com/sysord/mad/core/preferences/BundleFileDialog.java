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

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;

import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.eclipse.tools.swt.SWTUtil;

/**
 * Dialog for choosing a MAD configuration fil into a registered plug-in.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class BundleFileDialog extends Dialog {

	private static final String DEFAULT_TITLE = "Browse bundles";

	private static final String LBL_BUNDLE_NAME = "Plugin";

	private static final String LBL_FILE_PATH = "File path";

	private static final String LBL_CANCEL = "Cancel";

	private static final String LBL_OK = "Ok";

	private String uri;

	private Text txt_BundleName;

	private Text txt_FilePath;

	private Button btn_Ok;

	/**
	 * Creates a new {@code BundleFileDialog}.
	 */
	public BundleFileDialog(IShellProvider shellProvider) {
		super(shellProvider.getShell(), SWT.RESIZE | SWT.APPLICATION_MODAL);
		setText(DEFAULT_TITLE);
	}

	public String open() {
		Shell parent = getParent();
		Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(getText());
		createControl(shell);
		shell.setSize(shell.computeSize(450, SWT.DEFAULT));
		shell.open();
		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return uri;
	}

	/**
	 * Creates the dialog content.
	 * 
	 * @param shell
	 */
	private void createControl(final Shell shell) {
		shell.setLayout(GridLayoutHelper.create(2));

		// Bundle Name

		Label lbl_BundleName = new Label(shell, SWT.NONE);
		lbl_BundleName.setText(LBL_BUNDLE_NAME);

		txt_BundleName = new Text(shell, SWT.BORDER);
		txt_BundleName.setLayoutData(GridDataHelper.horizontalFill());

		// File path

		Label lbl_FilePath = new Label(shell, SWT.NONE);
		lbl_FilePath.setText(LBL_FILE_PATH);

		txt_FilePath = new Text(shell, SWT.BORDER);
		txt_FilePath.setLayoutData(GridDataHelper.horizontalFill());

		// Buttons

		Composite buttonsContainer = new Composite(shell, SWT.NONE);
		GridData data = GridDataHelper.horizontalFill();
		data.horizontalSpan = 2;
		buttonsContainer.setLayoutData(data);
		buttonsContainer.setLayout(GridLayoutHelper.createWithNoMargin(2));

		Button btn_Cancel = new Button(buttonsContainer, SWT.PUSH);
		btn_Cancel.setText(LBL_CANCEL);
		SWTUtil.computeButtonWidth(btn_Cancel, GridDataHelper.alignRightHorizontalGrab());

		btn_Ok = new Button(buttonsContainer, SWT.PUSH);
		btn_Ok.setText(LBL_OK);
		data = GridDataHelper.alignRightHorizontalGrab();
		data.grabExcessHorizontalSpace = false;
		SWTUtil.computeButtonWidth(btn_Ok, data);

		// Actions

		btn_Cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				uri = null;
				shell.close();
			}
		});

		btn_Ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StringBuilder uri = new StringBuilder("platform:/plugin/");
				uri.append(txt_BundleName.getText()).append('/');
				uri.append(txt_FilePath.getText());
				BundleFileDialog.this.uri = uri.toString();
				shell.close();
			}
		});

		txt_BundleName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateDialog();
			}
		});

		txt_FilePath.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateDialog();
			}
		});
	}

	private void updateDialog() {
		boolean okEnabled = txt_BundleName.getText().length() > 0 && txt_FilePath.getText().length() > 0;
		Bundle bundle = null;
		okEnabled = okEnabled && (bundle = Platform.getBundle(txt_BundleName.getText())) != null;
		okEnabled = okEnabled && bundle.getResource(txt_FilePath.getText()) != null;
		btn_Ok.setEnabled(okEnabled);
	}
}
