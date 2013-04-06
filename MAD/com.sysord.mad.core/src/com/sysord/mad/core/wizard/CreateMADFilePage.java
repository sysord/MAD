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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.eclipse.tools.swt.widget.WorkspaceFileViewer;

/**
 * XXX Comment role class
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class CreateMADFilePage extends WizardPage {

	private static final String TITLE = "MAD Configuration File";
	private static final String DESCRIPTION = "Create a new MAD configuration file";
	private NewMADFileWizard wizard;
	private WorkspaceFileViewer<IContainer> viewer;
	private Text txt_Filename;

	/**
	 * Creates a new {@code CreateMADFilePage}.
	 */
	public CreateMADFilePage(NewMADFileWizard wizard) {
		super(TITLE);
		setTitle(TITLE);
		setMessage(DESCRIPTION);
		this.wizard = wizard;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(GridLayoutHelper.create(2));

		viewer = new WorkspaceFileViewer<IContainer>(IContainer.class, container, SWT.NONE);
		LinkedList<IContainer> selection = new LinkedList<IContainer>();
		if (wizard.container != null) {
			selection.add(wizard.container);
		}
		viewer.addFilter(new ViewerFilter() {
			
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof IProject) {
					return ((IProject) element).isOpen();
				}// else
				return true;
			}
		});
		viewer.initialize(null, selection);
		GridData data = GridDataHelper.bothFill();
		data.horizontalSpan = 2;
		viewer.setLayoutData(data);
		viewer.addPostSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				validatePage();
			}
		});

		Label lbl_Filename = new Label(container, SWT.NONE);
		lbl_Filename.setText("File name");
		txt_Filename = new Text(container, SWT.BORDER);
		txt_Filename.setLayoutData(GridDataHelper.horizontalFill());
		txt_Filename.setText("My.mad");
		txt_Filename.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				validatePage();
			}
		});

		validatePage();

		setControl(container);
	}

	/**
	 * Returns the folder containing the file.
	 * 
	 * @return the folder containing the file.
	 */
	public IContainer getContainingFolder() {
		List<IContainer> selection = viewer.getSelection();
		if (selection.isEmpty()) {
			return null;
		}// else
		return selection.get(0);
	}

	/**
	 * Returns the name of the file to create.
	 * <p>
	 * Adds the extension if necessary.
	 * 
	 * @return the name of the file to create.
	 */
	public String getFilename() {
		String filename = txt_Filename.getText();
		if (filename.length() > 0 && !filename.endsWith(".mad")) {
			filename += ".mad";
		}
		return filename;
	}

	/**
	 * Validates the current state of this page and determines if it is complete or
	 * display the error messages.
	 */
	protected void validatePage() {
		String filename = getFilename();
		String error = null;
		if (getContainingFolder() == null) {
			error = "Choose a folder.";
		} else if (getContainingFolder().getType() != IContainer.PROJECT
				&& getContainingFolder().getType() != IContainer.FOLDER) {
			error = "The containing folder can only be a project or a folder.";
		} else if (!getContainingFolder().exists()) {
			error = "The containing folder doesn't exist.";
		} else if (filename.length() == 0) {
			error = "Enter a file name.";
		} else {
			IFile file = getContainingFolder().getFile(new Path(filename));
			if (file.exists()) {
				error = "There already is a file with the name " + filename;
			}
		}
		setErrorMessage(error);
		setPageComplete(error == null);
	}
}
