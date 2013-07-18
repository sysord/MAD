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
package com.sysord.eclipse.tools.jface.preference;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Provides the preferences for a specific {@link IProject} and plug-in.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractProjectPreferenceProvider {

    protected IProject project;

    protected IEclipsePreferences projectNode;

    /**
     * Create a new {@code AbstractProjectPreferenceProvider} for the given
     * {@link IProject}.
     * 
     * @param project The {@link IProject} for which this provider is for.
     * @throws NullPointerException if the given project is {@code null}.
     */
    public AbstractProjectPreferenceProvider(IProject project) {
    	if (project == null) {
    		throw new NullPointerException();
    	}// else
        this.project = project;
    }

    /**
     * Save the current state of the preferences project node.
     */
    protected void save() {
        try {
            projectNode.flush();
        } catch (BackingStoreException e) {
            saveFailed(e);
        } catch (IllegalStateException e) {
            saveFailed(e);
        }
    }

    /**
     * Called when the save operation have failed.
     * <p>
     * Should be overriden in sub-classes.
     * 
     * @param exception The raised exception when saving.
     */
    protected void saveFailed(Exception exception) {
        throw new RuntimeException(exception);
    }

    /**
     * Returns the project preferences node.
     * 
     * @return the project preferences node.
     */
    protected IEclipsePreferences getProjectNode() {
        if (projectNode == null) {
            ProjectScope projectScope = new ProjectScope(project);
            projectNode = projectScope.getNode(getPluginID());
            if (projectNode == null) {
                throw new RuntimeException("Error creating project scope for " + project.getName());
            }
        }
        return projectNode;
    }

    /**
     * Returns the ID of the plug-in providing the preferences.
     * 
     * @return the ID of the plug-in providing the preferences.
     */
    protected abstract String getPluginID();
}
