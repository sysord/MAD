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
package com.sysord.eclipse.tools.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * Abstract property page with basic methods habitually used in property pages.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @since 1.2
 */
public abstract class AbstractPropertyPage extends PropertyPage {

    /**
     * Returns the current selected project or {@code null} if it's not a project.
     * <p>
     * It should not be {@code null} as this page appears only on project properties.
     * 
     * @return the current selected project.
     */
    protected IProject getCurrentProject() {
        IAdaptable element = getElement();
        if (element instanceof IJavaProject) {
            element = ((IJavaProject) element).getProject();
        }

        if (element instanceof IProject) {
            return (IProject) element;
        }// else

        return null;
    }

    @Override
    protected IPreferenceStore doGetPreferenceStore() {
        ProjectScope projectScope = new ProjectScope(getCurrentProject());
        ScopedPreferenceStore store = new ScopedPreferenceStore(projectScope, getStoreId());
        return store;
    }

    /**
     * Returns the id of the store to use in this property page.
     * <p>
     * The returned id is used to create a {@link ScopedPreferenceStore}.
     * 
     * @return the id of the store to use in this property page
     * @see ScopedPreferenceStore#ScopedPreferenceStore(org.eclipse.core.runtime.preferences.IScopeContext,
     *      String)
     */
    protected abstract String getStoreId();

}
