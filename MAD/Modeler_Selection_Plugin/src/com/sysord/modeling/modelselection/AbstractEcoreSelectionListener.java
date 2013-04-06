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
package com.sysord.modeling.modelselection;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.modeling.modelselection.contributor.ModelSelectionContributor;

/**
 * Abstract implementation of the {@link IModelSelectionListener}.
 * <p>
 * This class provides methods for obtaining registered contributions from other plug-ins.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractEcoreSelectionListener implements IModelSelectionListener {

	private static final String GMF_BUNDLE = "com.sysord.modeling.selection.gmf";//$NON-NLS-1$
	private static final String GMF_CONTRIBUTOR = "com.sysord.modeling.selection.gmf.GmfSelectionContributor";//$NON-NLS-1$

	private static ArrayList<ModelSelectionContributor> contributors;
	private static ModelSelectionContributor gmfContributor;
	private static boolean gmfContributorNotFound;

	protected List<ModelSelectionContributor> getContributors() {
		if (contributors == null) {
			contributors = new ArrayList<ModelSelectionContributor>();
			initContributors(contributors);
		}
		return contributors;
	}

	/**
	 * Initialize the given contributors list.
	 * 
	 * @param contributors
	 */
	protected void initContributors(ArrayList<ModelSelectionContributor> contributors) {
		IConfigurationElement[] configElements = EclipseTools.getConfigurationElementsFor(
				ModelSelectionPlugin.PLUGIN_ID, "contributors");//$NON-NLS-1$
		configElements = EclipseTools.getConfigurationElementsFor(configElements, "selectionContributor");//$NON-NLS-1$
		for (int i = 0; i < configElements.length; i++) {
			final IConfigurationElement configElement = configElements[i];
			String className = configElement.getAttribute("class");//$NON-NLS-1$
			if (className != null) {
				Class<ModelSelectionContributor> contributorClass = EclipseTools.findClass(configElement, className);
				if (contributorClass != null) {
					ModelSelectionContributor contributor = EclipseTools.getNewInstance(contributorClass);
					if (contributor != null) {
						contributors.add(contributor);
					}
				}
			}
		}
	}

	/**
	 * Returns the {@link EObject} element corresponding to the given
	 * {@code selectedElement}.
	 * <p>
	 * The default behavior of this method is to firstly call the
	 * {@code getEcoreElement(Object)} on all the registered
	 * {@link ModelSelectionContributor}s. <br>
	 * If no {@code EObject} corresponds, the {@code GmfSelectionContributor} is called
	 * and returns the corresponding {@code EObject} of the selected diagram element if
	 * possible. <br>
	 * If it's not a GMF element, nor an {@code EObject}, {@code null} is returned.
	 * 
	 * @param selectedElement The selected <code>Object</code>.
	 * @return the corresponding model {@code EObject}.
	 */
	public EObject getEcoreElement(Object selectedElement) {
		for (ModelSelectionContributor contributor : getContributors()) {
			EObject modelElement = contributor.getEcoreElement(selectedElement);
			if (modelElement != null) {
				return modelElement;
			}// else
		}

		/*
		 * Check the gmf contributor after the others
		 * GMF is a special case because the model element is directly accessible with the
		 * Node whereas other modelers using GMF could add other EObjects between the Node
		 * and the model element.
		 */
		ModelSelectionContributor gmfContributor = getGmfContributor();
		if (gmfContributor != null) {
			EObject modelElement = gmfContributor.getEcoreElement(selectedElement);
			if (modelElement != null) {
				return modelElement;
			}
		}

		if (selectedElement instanceof EObject) {
			return (EObject) selectedElement;
		}// else

		return null;
	}

	/**
	 * Returns the GMF Contributor if the plug-in is present.
	 * 
	 * @return the GMF Contributor if the plug-in is present; {@code null} otherwise.
	 */
	private ModelSelectionContributor getGmfContributor() {
		if (gmfContributor != null || gmfContributorNotFound)
			return gmfContributor;
		// else

		Class<ModelSelectionContributor> contributorClass = EclipseTools.loadClass(GMF_BUNDLE, GMF_CONTRIBUTOR);
		gmfContributor = null;
		if (contributorClass != null) {
			gmfContributor = EclipseTools.getNewInstance(contributorClass);
		}
		if (gmfContributor == null) {
			gmfContributorNotFound = true;
		}
		return gmfContributor;
	}
}
