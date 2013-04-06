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
package com.sysord.mad.core.wizard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.eclipse.tools.swt.SWTUtil;
import com.sysord.emf.tools.misc.MetamodelURIDialog;
import com.sysord.emf.tools.misc.URILabelProvider;

/**
 * Page for choosing the metamodel to import into the MAD configuration file.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class MADFileURIPage extends WizardPage {

	private static final String TITLE = "Metamodels";
	private static final String DESCRIPTION = "Define the meta-models to import";
	protected Set<URI> uris = new HashSet<URI>();
	private Button btn_NsURI;
	private ListViewer viewer;
	private Button btn_Remove;

	/**
	 * Creates a new {@code MADFileURIPage}.
	 */
	public MADFileURIPage() {
		super(TITLE);
		setTitle(TITLE);
		setMessage(DESCRIPTION);
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(GridLayoutHelper.create(1));

		Composite buttonsContainer = new Composite(container, SWT.NONE);
		buttonsContainer.setLayoutData(GridDataHelper.horizontalFill());
		buttonsContainer.setLayout(GridLayoutHelper.createWithNoMargin(2));

		btn_NsURI = new Button(buttonsContainer, SWT.PUSH);
		btn_NsURI.setText("Browse...");
		SWTUtil.computeButtonWidth(btn_NsURI, GridDataHelper.defaultData());

		btn_Remove = new Button(buttonsContainer, SWT.PUSH);
		btn_Remove.setText("Remove");
		GridData data = GridDataHelper.horizontalFill();
		data.horizontalAlignment = SWT.RIGHT;
		SWTUtil.computeButtonWidth(btn_Remove, data);

		viewer = new ListViewer(container, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.getControl().setLayoutData(GridDataHelper.bothFill());
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setLabelProvider(new URILabelProvider());
		viewer.setInput(uris);
		viewer.addPostSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				btn_Remove.setEnabled(!event.getSelection().isEmpty());
			}
		});

		btn_NsURI.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MetamodelURIDialog dialog = new MetamodelURIDialog(getShell());
				int response = dialog.open();
				if (response == MetamodelURIDialog.OK) {
					URI[] results = dialog.getResultUris();
					uris.addAll(Arrays.asList(results));
					viewer.refresh();
				}
				validatePage();
			}
		});

		btn_Remove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				uris.removeAll(selection.toList());
				viewer.refresh();
				validatePage();
			}
		});
		btn_Remove.setEnabled(false);
		setPageComplete(true);

		setControl(container);
	}

	/**
	 * Returns the uris to import into the configuration file.
	 * 
	 * @return the uris to import into the configuration file.
	 */
	public Set<URI> getURIs() {
		return uris;
	}

	/**
	 * Validates the state of this page and marks this page as complete if necessary.
	 */
	protected void validatePage() {
		// Does nothing
	}

}
