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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.EclipseToolsPlugin;

/**
 * Default behavior of {@link Wizard} to create examples projects into the workspace.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractExampleWizard extends Wizard implements INewWizard {

	private Collection<ProjectDescriptor> projectDescriptors;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	@Override
	public void addPages() {
		ImageDescriptor imageDescriptor = getTitleImageDescriptor();
		IWizardPage page;
		if (imageDescriptor != null) {
			page = new ExampleWizardProjectsPage(imageDescriptor);
		} else {
			page = new ExampleWizardProjectsPage();
		}
		addPage(page);
	}

	@Override
	public final boolean performFinish() {
		if (getExistingProjects().size() == 0) {
			// Creating Workspace Operation for extracting the projects
			ZipLocatedProjectCreator projectCreator = new ZipLocatedProjectCreator(internalGetDescriptors());
			try {
				// Executing the projectCreator operation
				getContainer().run(true, false, projectCreator);
				return _performFinish();
			} catch (InvocationTargetException e) {
				EclipseToolsPlugin.log(e);
			} catch (InterruptedException e) {
				EclipseToolsPlugin.log(e);
			}
		}
		return false;
	}

	/**
	 * Performs the actions after the creation of the projects.
	 * <p>
	 * The default implementation of this method, as it is defined in
	 * {@link AbstractExampleWizard}, always returns {@code true}, subclasses may override
	 * it.
	 * 
	 * @return {@code true} if the Wizard can leave;<br>
	 *         {@code false} otherwise.
	 */
	protected boolean _performFinish() {
		return true;
	}

	/**
	 * Returns the {@link ImageDescriptor} used for the title of the page of this wizard.
	 * <p>
	 * The default implementation of this method in {@link AbstractExampleWizard} returns
	 * {@code null}, sub-classes may override it.
	 * 
	 * @return the {@link ImageDescriptor} used for the title of the page of this wizard.
	 */
	protected ImageDescriptor getTitleImageDescriptor() {
		return null;
	}

	/**
	 * Returns the project {@link ProjectDescriptor descriptors} of the projects already
	 * existing in the workspace.
	 * 
	 * @return the project descriptors of the projects already existing in the workspace.
	 */
	public Set<ProjectDescriptor> getExistingProjects() {
		Set<ProjectDescriptor> descriptors = new HashSet<ProjectDescriptor>();
		for (ProjectDescriptor descriptor : internalGetDescriptors()) {
			IProject project = EclipseTools.getCurrentWorkspace().getRoot().getProject(descriptor.getProjectName());
			if (project.exists()) {
				descriptors.add(descriptor);
			}
		}
		return descriptors;
	}

	/**
	 * Returns the collection of {@link ProjectDescriptor}s of the projects to create.
	 * 
	 * @return the collection of {@link ProjectDescriptor}s of the projects to create.
	 */
	public abstract Collection<ProjectDescriptor> getProjectDescriptors();

	private Collection<ProjectDescriptor> internalGetDescriptors() {
		if (projectDescriptors == null) {
			projectDescriptors = getProjectDescriptors();
		}
		return projectDescriptors;
	}

	/**
	 * Description of a zip project that will be extracted into the workspace.
	 * 
	 * @author Fabien Vignal <vignalf@gmail.com>
	 */
	public static class ProjectDescriptor {

		private String projectName;

		private String zipBundleId;

		private String zipLocation;

		/**
		 * Default constructor.
		 * <p>
		 * Creates a new {@code ProjectDescriptor}.
		 */
		public ProjectDescriptor() {
		}

		/**
		 * Creates a new {@code ProjectDescriptor}.
		 * 
		 * @param bundleId
		 * @param projectName
		 * @param zipLocation
		 */
		public ProjectDescriptor(String projectName, String zipBundleId, String zipLocation) {
			this.projectName = projectName;
			this.zipBundleId = zipBundleId;
			this.zipLocation = zipLocation;
		}

		/**
		 * Returns the value of projectName.
		 * 
		 * @return the value of projectName.
		 */
		public String getProjectName() {
			return projectName;
		}

		/**
		 * Returns the value of zipBundleId.
		 * 
		 * @return the value of zipBundleId.
		 */
		public String getZipBundleId() {
			return zipBundleId;
		}

		/**
		 * Returns the value of zipLocation.
		 * 
		 * @return the value of zipLocation.
		 */
		public String getZipLocation() {
			return zipLocation;
		}

		/**
		 * Sets the given {@code projectName} for projectName.
		 * 
		 * @param projectName the value to set to projectName.
		 */
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		/**
		 * Sets the given {@code zipBundleId} for zipBundleId.
		 * 
		 * @param zipBundleId the value to set to zipBundleId.
		 */
		public void setZipBundleId(String zipBundleId) {
			this.zipBundleId = zipBundleId;
		}

		/**
		 * Sets the given {@code zipLocation} for zipLocation.
		 * 
		 * @param zipLocation the value to set to zipLocation.
		 */
		public void setZipLocation(String zipLocation) {
			this.zipLocation = zipLocation;
		}
	}
}
