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
package com.sysord.mad.example.tinylibrary.wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.resource.ImageDescriptor;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.wizard.AbstractExampleWizard;
import com.sysord.mad.core.preferences.PreferenceHelper;
import com.sysord.mad.example.tinylibrary.Activator;

/**
 * Wizard for creating the Example MAD project Tiny Library.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class TinylibraryWizard extends AbstractExampleWizard {

	private Collection<ProjectDescriptor> projectDescriptors;

	@Override
	public Collection<ProjectDescriptor> getProjectDescriptors() {
		if (projectDescriptors == null) {
			createProjectDescriptors();
		}
		return projectDescriptors;
	}

	@Override
	protected ImageDescriptor getTitleImageDescriptor() {
		return EclipseTools.getImageDescriptorFromPlugin(Activator.getDefault(), "resources/book_wiz.png");//$NON-NLS-1$
	}

	/**
	 * Creates the project descriptors.
	 */
	protected void createProjectDescriptors() {
		projectDescriptors = new ArrayList<ProjectDescriptor>();
		ProjectDescriptor descriptor;
		String location;
		descriptor = new ProjectDescriptor();
		descriptor.setProjectName("com.sysord.mad.example.tinylibrary");//$NON-NLS-1$
		descriptor.setZipBundleId("com.sysord.mad.example.tinylibrary");//$NON-NLS-1$
		location = "/projects/com.sysord.mad.example.tinylibrary.zip";//$NON-NLS-1$
		descriptor.setZipLocation(location);
		projectDescriptors.add(descriptor);

	}

	/**
	 * Performs the actions after the creation of the projects.
	 * <p>
	 * Inserts the created MAD configurations into the worlspace preferences.
	 */
	@Override
	protected boolean _performFinish() {
		Set<String> filenames = new LinkedHashSet<String>();

		// Adding the default config
		filenames.add("platform:/plugin/com.sysord.mad.core/model/config.mad");//$NON-NLS-1$

		// Adding the tinylibrary.mad
		filenames.add("platform:/resource/com.sysord.mad.example.tinylibrary/tinylibrary.config.mad");//$NON-NLS-1$

		// Saving the list into the store
		PreferenceHelper.putMadConfigFilenames(filenames);

		return true;
	}
}
