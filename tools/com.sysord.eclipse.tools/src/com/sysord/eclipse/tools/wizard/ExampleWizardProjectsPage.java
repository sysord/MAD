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
package com.sysord.eclipse.tools.wizard;

import java.util.Set;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.sysord.eclipse.tools.L;
import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.eclipse.tools.wizard.AbstractExampleWizard.ProjectDescriptor;

/**
 * {@link IWizardPage Wizard Page} for the {@link AbstractExampleWizard}.
 * <p>
 * Displays the list of projects the wizard will create.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ExampleWizardProjectsPage extends WizardPage {

	/**
	 * Creates a new {@code ExampleWizardProjectsPage}.
	 * 
	 * @param pageName
	 */
	protected ExampleWizardProjectsPage() {
		super(L.title_examplePageProjects);
		setTitle(L.title_examplePageProjects);
	}

	/**
	 * Creates a new wizard page with the given image.
	 * 
	 * @param titleImage the image descriptor for the title of this wizard page,
	 *        or {@code null} if none
	 */
	protected ExampleWizardProjectsPage(ImageDescriptor titleImage) {
		super(L.title_examplePageProjects, L.title_examplePageProjects, titleImage);
		setTitle(L.title_examplePageProjects);
	}

	@Override
	public void createControl(Composite parent) {
		setMessage(L.desc_createExampleProjects);
		
		// Container
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(GridLayoutHelper.create(1));
		
		// Project Descriptors viewer
		ListViewer viewer = new ListViewer(container, SWT.SINGLE | SWT.BORDER);
		viewer.getList().setLayoutData(GridDataHelper.bothFill());
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setLabelProvider(new ProjectDescriptorLabelProvider());
		AbstractExampleWizard wizard = getExampleWizard();
		if (wizard != null) {
			viewer.setInput(wizard.getProjectDescriptors());
			Set<ProjectDescriptor> existingProjects = wizard.getExistingProjects();
			if (existingProjects.size() > 0) {
				setErrorMessage(L.err_someProjectsExist);
				setPageComplete(false);
			}
		}
		setControl(container);
	}

	/**
	 * Returns the wizard owning this page if it's an {@link AbstractExampleWizard} or
	 * {@code null}.
	 * 
	 * @return the wizard owning this page if it's an {@link AbstractExampleWizard};<br>
	 *         {@code null} otherwise.
	 */
	private AbstractExampleWizard getExampleWizard() {
		IWizard wizard = getWizard();
		if (wizard instanceof AbstractExampleWizard) {
			return (AbstractExampleWizard) wizard;
		}
		return null;
	}

	private static class ProjectDescriptorLabelProvider extends LabelProvider {
		
		@Override
		public String getText(Object element) {
			if (element instanceof ProjectDescriptor) {
				String label = L.emptyString;
				if (element != null) {
					label = ((ProjectDescriptor) element).getProjectName();
				}
				return label;
			}// else
			return super.getText(element);
		}
	}
}
