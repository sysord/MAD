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

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.swt.SWTUtil;
import com.sysord.eclipse.tools.wizard.AbstractNewWizard;
import com.sysord.mad.core.Activator;
import com.sysord.mad.core.IMADConstants;

/**
 * Wizard for creating MAD configuration files.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class NewMADFileWizard extends AbstractNewWizard {

	private static final String IMPORT = "import";
	private static final char QUOTE = '"';
	private static final char LR = '\n';

	/**
	 * The container of the file to create.
	 */
	protected IContainer container;

	/**
	 * The file this wizard will create.
	 */
	protected IFile configurationFile;

	private CreateMADFilePage chooseFolderPage;

	private MADFileURIPage uriPage;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setDefaultPageImageDescriptor(Activator.getDefault().getImageDescriptor(IMADConstants.WIZ_NEW_MAD_FILE));

		Object selected = selection.getFirstElement();
		if (selected != null && selected instanceof IResource) {
			IResource resource = (IResource) selected;
			if (resource.getType() == IResource.FILE) {
				resource = resource.getParent();
			}
			if (resource.getType() == IResource.FOLDER || resource.getType() == IResource.PROJECT) {
				container = (IContainer) resource;
			}
		}
	}

	/**
	 * Returns the {@link IContainer container} of the selected resource or itself if it
	 * is a container.
	 * 
	 * @return the {@link IContainer container} of the selected resource.
	 */
	public IContainer getSelectedContainer() {
		if (chooseFolderPage != null) {
			container = chooseFolderPage.getContainingFolder();
		}
		return container;
	}

	@Override
	public void addPages() {
		chooseFolderPage = new CreateMADFilePage(this);
		addPage(chooseFolderPage);
		uriPage = new MADFileURIPage();
		addPage(uriPage);
	}

	@Override
	protected IRunnableWithProgress getWizardOperation() {
		return new CreateMadConfigFileOperation();
	}

	@Override
	protected boolean afterWizardOperation() {
		// Opening the editor for the created file
		if (configurationFile != null && configurationFile.exists()) {
			EclipseTools.openDefaultEditor(configurationFile);
		}
		// TODO Error message if the file is null or doesn't exist
		return true;
	}

	protected String getFilename() {
		return chooseFolderPage.getFilename();
	}

	/**
	 * Returns the initial content to put on the created file.
	 * 
	 * @return the initial content to put on the created file.
	 */
	protected String getInitialContent() {
		StringBuilder content = new StringBuilder();
		for (URI uri : uriPage.getURIs()) {
			content.append(IMPORT).append(' ');
			content.append(QUOTE);
			content.append(uri.toString().replaceFirst("\\.genmodel$", ".ecore"));
			content.append(QUOTE).append(LR);
		}
		return content.toString();
	}

	private class CreateMadConfigFileOperation extends WorkspaceModifyOperation {

		@Override
		protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
				InterruptedException {
			if (getSelectedContainer() != null && getSelectedContainer().exists()) {
				// Creation of the MAD configuration file
				configurationFile = createFile(getSelectedContainer(), monitor);
			}
		}

		/**
		 * Creates the MAD configuration file.
		 * 
		 * @param container The container of the file to create.
		 * @param monitor
		 * @return the created MAD configuration file or {@code null}.
		 */
		public IFile createFile(IContainer container, IProgressMonitor monitor) {
			FutureTask<String> filenameProvider = getFilenameProvider();
			SWTUtil.getDisplay().syncExec(filenameProvider);
			IFile file = null;
			try {
				file = container.getFile(new Path(filenameProvider.get()));
				file.create(new ByteArrayInputStream(getInitialContent().getBytes(ResourcesPlugin.getEncoding())),
						true, monitor);
				return file;
			} catch (UnsupportedEncodingException e) {
				Activator.log(e);
			} catch (CoreException e) {
				Activator.log(e);
			} catch (ExecutionException e) {
				Activator.log(e);
			} catch (InterruptedException e) {
				// Ignore
			} catch (CancellationException e) {
				// Ignore
			}
			return null;
		}
		
		private FutureTask<String> getFilenameProvider() {
			return new FutureTask<String>(new Callable<String>() {

				@Override
				public String call() throws Exception {
					return getFilename();
				}
			});
		}

	}
}
