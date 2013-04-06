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
package com.sysord.eclipse.tools.swt.widget;

import org.eclipse.jface.viewers.*;

/**
 * {@link ViewerFilter} for String labels of a {@link StructuredViewer}.
 * <p>
 * A {@code StringViewerFilter} is for one {@link StructuredViewer} only.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class StringViewerFilter extends ViewerFilter {
    
    protected StructuredViewer viewer;
    
    protected String filter;
    
    public StringViewerFilter(StructuredViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if (!(viewer instanceof StructuredViewer))
            return false;
        // else
        ILabelProvider labelProvider = (ILabelProvider) ((StructuredViewer) viewer).getLabelProvider();
        if (labelProvider != null) {
            String label = labelProvider.getText(element);
            return select(viewer, parentElement, element, label);
        }
        return false;
    }

    /**
     * Returns whether the given {@code element} makes it through this filter.
     * <p>
     * Called only if the viewer has a {@link ILabelProvider}.
     * 
     * @param viewer
     * @param parentElement
     * @param element
     * @param label
     * @return {@code true} if the element is included in the filter;<br>
     *         {@code false} otherwise.
     */
    protected boolean select(Viewer viewer, Object parentElement, Object element, String label) {
        return filter == null || label != null
                && (filter.length() == 0 || label.toUpperCase().startsWith(filter.toUpperCase()));
    }

    /**
     * Defines the String filter.
     * <p>
     * The viewer is automatically refreshed after.
     * 
     * @param filter
     */
    public void setStringFilter(String filter) {
        this.filter = filter;
        if (!viewer.getControl().isDisposed()) {
            viewer.refresh();
        }
    }
}
