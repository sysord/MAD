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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.jface.preference.IResourceViewerFilter;
import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;

/**
 * Viewer for displaying the workspace's resources of the given type.
 * 
 * @param The type of resources to display.
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class WorkspaceFileViewer<T extends IResource> extends Composite {

	private TreeViewer resourcesViewer;
	private IContainer root;
	private List<T> selection;
	private List<ViewerFilter> filters;
	protected Class<T> type;

	/**
	 * Creates a new {@code WokspaceFileViewer}.
	 * 
	 * @param type
	 * @param parent
	 * @param style
	 */
	public WorkspaceFileViewer(Class<T> type, Composite parent, int style) {
		super(parent, style);
		this.type = type;
		filters = new ArrayList<ViewerFilter>(5);
	}

	/**
	 * Initializes the content of this {@code WorkspaceFileViewer}.
	 * 
	 * @param root The root container of the displayed resources ({@code null} for all
	 *        workspaces resources).
	 * @param initialSelection {@link IContainer containers} already selected ({@code null}
	 *        is authorized).
	 */
	public void initialize(IContainer root, List<IContainer> initialSelection) {
		if (root == null || !root.exists()) {
			root = EclipseTools.getCurrentWorkspace().getRoot();
		}
		this.root = root;
		createContent();
		if (initialSelection != null) {
			IStructuredSelection selection = new StructuredSelection(initialSelection);
			resourcesViewer.setSelection(selection, true);
		}
	}

	/**
	 * Creates the content of this viewer.
	 */
	private void createContent() {
		super.setLayout(GridLayoutHelper.create(1));

		// TODO Filter textbox

		// Resources viewer
		resourcesViewer = new TreeViewer(this, SWT.SINGLE | SWT.BORDER);
		resourcesViewer.getControl().setLayoutData(GridDataHelper.bothFill());
		resourcesViewer.setLabelProvider(WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
		resourcesViewer.setContentProvider(new WorkbenchContentProvider());
		resourcesViewer.addFilter(new IResourceViewerFilter<T>(type));
		// Adding predefined filters
		for (ViewerFilter filter : filters) {
			resourcesViewer.addFilter(filter);
		}
		if (filters.size() > 0) {
			filters.clear();
		}
		resourcesViewer.setInput(root);

		resourcesViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				Object element = selection.getFirstElement();
				if (element != null) {
					if (resourcesViewer.getExpandedState(element)) {
						resourcesViewer.collapseToLevel(element, 1);
					} else {
						resourcesViewer.expandToLevel(element, 1);
					}
				}
			}
		});

		resourcesViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (!selection.isEmpty()) {
					WorkspaceFileViewer.this.selection = new ArrayList<T>(selection.size());
					for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
						Object element = iter.next();
						if (type.isInstance(element)) {
							WorkspaceFileViewer.this.selection.add(type.cast(element));
						}
					}
				}
			}
		});
	}

	/**
	 * Returns the selected elements in the Tree viewer.
	 * 
	 * @return the selected elements in the Tree viewer.
	 */
	public List<T> getSelection() {
		if (selection == null) {
			selection = Collections.emptyList();
		}
		return selection;
	}

	/**
	 * This method does nothing, the layout of this composite is a {@link GridLayout}.
	 */
	@Override
	public void setLayout(Layout layout) {
		// Does nothing
	}

	/**
	 * Adds a {@link ViewerFilter filter} to the resources viewer.
	 * 
	 * @param filter The filter to add.
	 */
	public void addFilter(ViewerFilter filter) {
		if (resourcesViewer == null) {
			filters.add(filter);
		} else {
			resourcesViewer.addFilter(filter);
		}
	}

	/**
	 * Adds a post selection changed listener.
	 * 
	 * @param listener
	 * @throws IllegalStateException if this {@code WorkspaceFileViewer} has not been
	 *         initialized.
	 */
	public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
		if (resourcesViewer == null) {
			throw new IllegalStateException("This WokspaceFileViewer may have not been initialized.");
		}// else

		resourcesViewer.addPostSelectionChangedListener(listener);
	}

}
