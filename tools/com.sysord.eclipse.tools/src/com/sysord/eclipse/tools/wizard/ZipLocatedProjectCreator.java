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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.osgi.framework.Bundle;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.L;
import com.sysord.eclipse.tools.wizard.AbstractExampleWizard.ProjectDescriptor;

/**
 * {@link WorkspaceModifyOperation} for creating projects from a {@link ProjectDescriptor}
 * containing the description of a project and the location of the zipped content of the
 * project.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ZipLocatedProjectCreator extends WorkspaceModifyOperation {

	protected Collection<ProjectDescriptor> projectDescriptors;

	/**
	 * Creates a new {@code ZipLocatedProjectCreator}.
	 * 
	 * @param projectDescriptors
	 */
	public ZipLocatedProjectCreator(ProjectDescriptor projectDescriptor) {
		projectDescriptors = new LinkedList<ProjectDescriptor>();
		projectDescriptors.add(projectDescriptor);
	}

	/**
	 * Creates a new {@code ZipLocatedProjectCreator}.
	 * 
	 * @param projectDescriptors
	 */
	public ZipLocatedProjectCreator(Collection<ProjectDescriptor> projectDescriptors) {
		this.projectDescriptors = projectDescriptors;
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
			InterruptedException {
		monitor.beginTask(L.msg_unzippingProjects, projectDescriptors.size());
		for (ProjectDescriptor projectDescriptor : projectDescriptors) {
			createProject(projectDescriptor, monitor);
			monitor.worked(1);
		}
		monitor.done();
	}

	/**
	 * Creates in the workspace the project described by the given
	 * {@link ProjectDescriptor projectDescriptor}.
	 * 
	 * @param projectDescriptor Descriptor of the project to create.
	 * @param monitor The progress monitor to use to display progress
	 * @throws CoreException
	 * @throws InvocationTargetException
	 */
	protected void createProject(ProjectDescriptor projectDescriptor, IProgressMonitor monitor) throws CoreException,
			InvocationTargetException {
		// Creation of the project into the workspace
		IProject project = EclipseTools.getCurrentWorkspace().getRoot().getProject(projectDescriptor.getProjectName());
		project.create(monitor);

		// Opening the project
		project.open(monitor);

		try {
			// Extraction of the project content
			unzipProject(project, projectDescriptor, monitor);

			// Refreshing project
			project.refreshLocal(IProject.DEPTH_INFINITE, monitor);

			// Doing this for updating the project description
			// from the .project file.
			// TODO : Find a better solution
			project.close(monitor);
			project.open(monitor);
		} catch (IOException e) {
			throw new InvocationTargetException(e);
		}
	}

	/**
	 * Unzip the content of the project discribed by the given {@link ProjectDescriptor
	 * descriptor} into the specified {@code project}.
	 * 
	 * @param project
	 * @param projectDescriptor
	 * @param monitor
	 * @throws IOException
	 */
	protected void unzipProject(IProject project, ProjectDescriptor projectDescriptor, IProgressMonitor monitor)
			throws IOException {
		monitor = SubMonitor.convert(monitor);
		// Output folder
		String output = EclipseTools.getCurrentWorkspacePath().getAbsolutePath() + project.getFullPath().toOSString();
		// Bundle containing the zipped project
		Bundle zipBundle = Platform.getBundle(projectDescriptor.getZipBundleId());
		File tempFile = EclipseTools.getFileFromBundle(zipBundle, projectDescriptor.getZipLocation());
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(tempFile);
			monitor.beginTask(L.bind(L.msg_unzippingTheProject, project.getName()), zipFile.size());
			Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
			while (zipEntries.hasMoreElements()) {
				ZipEntry entry = zipEntries.nextElement();
				monitor.subTask(entry.getName());
				String path = output + File.separatorChar + entry.getName();
				File currentFile = new File(path);
				if (entry.isDirectory()) {
					// Creation of the directory and its parents if necessary
					currentFile.mkdirs();
				} else {
					if (!currentFile.exists()) {
						// Creation of the file
						currentFile.createNewFile();
					}
					// Add the content
					copyFileContent(zipFile, entry, currentFile);
				}
				monitor.worked(1);
			}
		} finally {
			if (zipFile != null) {
				try {
					zipFile.close();
				} catch (IOException e) {
					// Ignore
				}
			}
		}
	}

	/**
	 * Copies the content of the given {@code entry} into the specified
	 * {@code destinationFile}.
	 * 
	 * @param zipFile
	 * @param entry
	 * @param destinationFile
	 * @throws IOException
	 */
	private void copyFileContent(ZipFile zipFile, ZipEntry entry, File destinationFile) throws IOException {
		InputStream zis = zipFile.getInputStream(entry);
		FileOutputStream fos = new FileOutputStream(destinationFile);
		byte[] buffer = new byte[1024];

		try {
			int len = 0;
			while ((len = zis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// Ignore
			}
		}
	}

}
