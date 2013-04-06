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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * {@link ViewerFilter} filtering on the resource type.
 * <p>
 * <ul>
 * <li>{@link IResource}</li>
 * <li>{@link IContainer}</li>
 * <li>{@link IWorkspaceRoot}</li>
 * <li>{@link IProject}</li>
 * <li>{@link IFolder}</li>
 * <li>{@link IFile}</li>
 * </ul>
 * 
 * @param <T> The resource type
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class IResourceViewerFilter<T extends IResource> extends ViewerFilter {

	protected Class<T> type;

	/**
	 * Creates a new {@code IResourceViewerFilter}.
	 * 
	 * @param type
	 */
	public IResourceViewerFilter(Class<T> type) {
		if (type == null) {
			throw new IllegalArgumentException("The type cannot be null.");
		}// else

		this.type = type;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return type.isInstance(element);
	}

}
