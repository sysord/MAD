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
package com.sysord.mad.core.preferences;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.IPreferencePageContainer;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.eclipse.tools.swt.SWTUtil;
import com.sysord.mad.core.Activator;

/**
 * Preferences page for Mad Configuration.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class MadPreferencePage implements IWorkbenchPreferencePage, IShellProvider {

	public static final String PREF_MAD_PAGE_DESCRIPTION = "Configuration files used by MAD.";
	public static final String CONFIG_FILENAME_LABEL = "MAD Configuration File";
	public static final String ERR_FILE_EXISTS = "The file {#} does not exist.";

	protected String title = "MAD preferences";
	protected String description = "Preferences for the MAD Configuration files.";
	protected String error;
	protected String message;
	protected ImageDescriptor imageDescriptor;
	protected Image image;
	protected IPreferencePageContainer preferencePageContainer;
	protected Composite container;

	protected Set<URI> uris;
	private Button btn_apply;
	private Image errImage;

	@Override
	public Point computeSize() {
		if (container != null && !container.isDisposed()) {
			return container.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		}// else

		return new Point(0, 0);
	}

	@Override
	public boolean isValid() {
		if (uris != null) {
			for (URI uri : uris) {
				File file;
				try {
					file = EclipseTools.getFileFromURI(uri);
					if (!file.exists()) {
						createErrorMessage(uri.toString());
						return false;
					}
				} catch (Exception e) {
					Activator.log(e);
					return false;
				}
			}
		}
		setErrorMessage(null);
		return true;
	}

	private void createErrorMessage(String name) {
		setErrorMessage(ERR_FILE_EXISTS.replaceFirst("\\{#\\}", name));
	}

	@Override
	public boolean okToLeave() {
		return isValid() && performOk();
	}

	@Override
	public boolean performCancel() {
		// TODO Method implementation
		return true;
	}

	@Override
	public boolean performOk() {
		save();
		return true;
	}

	@Override
	public void setContainer(IPreferencePageContainer preferencePageContainer) {
		this.preferencePageContainer = preferencePageContainer;
	}

	@Override
	public void setSize(Point size) {
		if (container != null && !container.isDisposed()) {
			container.setSize(size);
		}
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout());

		GridData data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);

		Composite filesbuttonsContainer = new Composite(container, SWT.NONE);
		filesbuttonsContainer.setLayoutData(GridDataHelper.horizontalFill());
		filesbuttonsContainer.setLayout(GridLayoutHelper.createWithNoMargin(3));

		// Create the button to add the choosed workspace file in the table viewer
		final Button btn_addFile = new Button(filesbuttonsContainer, SWT.PUSH);
		btn_addFile.setText("Workspace...");
		GridData data__btn_addFile = GridDataHelper.defaultData();
		SWTUtil.computeButtonWidth(btn_addFile, data__btn_addFile);

		// Create the button to add the choosed bundle file in the table viewer
		final Button btn_addBundleFile = new Button(filesbuttonsContainer, SWT.PUSH);
		btn_addBundleFile.setText("Plugin...");
		SWTUtil.computeButtonWidth(btn_addBundleFile, GridDataHelper.horizontalGrab());

		// Create the button to delete the selected configuration files
		final Button btn_deleteFile = new Button(filesbuttonsContainer, SWT.PUSH);
		btn_deleteFile.setText("Remove File(s)");
		btn_deleteFile.setToolTipText("Remove the files from the configuration.");
		GridData data__btn_deleteFile = GridDataFactory.swtDefaults().align(SWT.RIGHT, SWT.BEGINNING).create();
		SWTUtil.computeButtonWidth(btn_deleteFile, data__btn_deleteFile);
		btn_deleteFile.setEnabled(false);

		// Create the table of choosed files
		final TableViewer viewer = new TableViewer(container, SWT.MULTI | SWT.BORDER);
		viewer.getTable().setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		TableViewerColumn filenameColumn = new TableViewerColumn(viewer, SWT.LEFT);
		filenameColumn.getColumn().setText("File name");
		filenameColumn.getColumn().setWidth(200);
		filenameColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				String lbl = "";
				if (cell.getElement() != null && cell.getElement() instanceof URI) {
					String[] path = ((URI) cell.getElement()).getPath().split("/");
					lbl = path.length > 0 ? path[path.length - 1] : lbl;
				}
				cell.setText(lbl);
			}
		});

		viewer.addPostSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				btn_deleteFile.setEnabled(!selection.isEmpty());
			}
		});

		TableViewerColumn filepathColumn = new TableViewerColumn(viewer, SWT.LEFT);
		filepathColumn.getColumn().setText("File path");
		filepathColumn.getColumn().setWidth(400);
		filepathColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				String lbl = "";
				if (cell.getElement() != null && cell.getElement() instanceof URI) {
					lbl = ((URI) cell.getElement()).getPath();
				}
				cell.setText(lbl);
			}
		});

		viewer.setInput(uris);

		btn_addFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String f = getFile();
				if (f != null) {
					try {
						uris.add(new URI(f));
						viewer.refresh(true);
						btn_apply.setEnabled(true);
						updateButtons();
					} catch (URISyntaxException e1) {
						Activator.log(e1);
					}
				}
			}
		});

		btn_addBundleFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String f = getBundleFile();
				if (f != null) {
					try {
						uris.add(new URI(f));
						viewer.refresh(true);
						btn_apply.setEnabled(true);
						updateButtons();
					} catch (URISyntaxException e1) {
						Activator.log(e1);
					}
				}
			}
		});

		btn_deleteFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<?> selection = ((IStructuredSelection) viewer.getSelection()).toList();
				if (selection.size() > 0) {
					for (Object o : selection) {
						uris.remove(o);
					}
					viewer.refresh(true);
					btn_apply.setEnabled(true);
					isValid();
					updateButtons();
				}
			}
		});

		// Buttons of the preference page

		Composite buttonsContainer = new Composite(container, SWT.NONE);
		buttonsContainer.setLayoutData(GridDataFactory.copyData(data));
		GridLayout btnContainerLayout = new GridLayout(2, false);
		btnContainerLayout.marginWidth = 0;
		btnContainerLayout.marginHeight = 0;
		buttonsContainer.setLayout(btnContainerLayout);

		// Restore defaults, button
		Button btn_restoreDefaults = new Button(buttonsContainer, SWT.PUSH);
		btn_restoreDefaults.setText("Restore Defaults");
		GridData data__btn_RestoreDefaults = new GridData(SWT.RIGHT, SWT.BEGINNING, true, false);
		SWTUtil.computeButtonWidth(btn_restoreDefaults, data__btn_RestoreDefaults);
		btn_restoreDefaults.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String defaultStr = PreferenceHelper.getStore().getDefaultString(PreferenceHelper.PREF_CONFIG_FILENAME);
				PreferenceHelper.getStore().putValue(PreferenceHelper.PREF_CONFIG_FILENAME, defaultStr);
				initializeFilesList();
				viewer.refresh(true);
			}
		});

		// Apply button
		btn_apply = new Button(buttonsContainer, SWT.PUSH);
		btn_apply.setText("Apply");
		btn_apply.setEnabled(false);
		SWTUtil.computeButtonWidth(btn_apply, GridDataFactory.swtDefaults().align(SWT.RIGHT, SWT.BEGINNING).create());
		btn_apply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (performOk()) {
					btn_apply.setEnabled(false);
					viewer.refresh(true);
				}
			}
		});
	}

	@Override
	public void dispose() {
		if (errImage != null) {
			errImage.dispose();
		}
		if (image != null) {
			image.dispose();
		}
		if (container != null) {
			container.dispose();
		}
	}

	@Override
	public Control getControl() {
		return container;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getErrorMessage() {
		return error;
	}

	@Override
	public Image getImage() {
		if (image == null && imageDescriptor != null) {
			image = imageDescriptor.createImage();
		}
		return image;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void performHelp() {
		// Does nothing
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setImageDescriptor(ImageDescriptor image) {
		this.imageDescriptor = image;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setVisible(boolean visible) {
		if (container != null && !container.isDisposed()) {
			container.setVisible(visible);
		}
	}

	public void setErrorMessage(String errorMessage) {
		error = errorMessage;
		if (preferencePageContainer != null) {
			preferencePageContainer.updateMessage();
		}
	}

	@Override
	public void init(IWorkbench workbench) {
		initializeFilesList();
	}

	protected void initializeFilesList() {
		if (uris == null) {
			uris = new LinkedHashSet<URI>();
			for (org.eclipse.emf.common.util.URI uri : PreferenceHelper.getMadConfigURIs()) {
				try {
					uris.add(new URI(uri.toString()));
				} catch (URISyntaxException e) {
					Activator.log(e);
				}
			}
		} else {
			uris.clear();
			for (org.eclipse.emf.common.util.URI uri : PreferenceHelper.getMadConfigURIs()) {
				try {
					uris.add(new URI(uri.toString()));
				} catch (URISyntaxException e) {
					Activator.log(e);
				}
			}
		}
	}

	protected void save() {
		Set<String> filenames = new LinkedHashSet<String>();
		for (URI uri : uris) {
			filenames.add(uri.toString());
		}
		PreferenceHelper.setMadConfigFilenames(filenames);
	}

	protected String getFile() {
		WorkspaceFileDialog dialog = new WorkspaceFileDialog(this);
		String uri = dialog.open();
		return uri;
	}

	protected String getBundleFile() {
		BundleFileDialog dialog = new BundleFileDialog(this);
		return dialog.open();
	}

	protected void updateButtons() {
		if (preferencePageContainer != null) {
			preferencePageContainer.updateButtons();
		}
	}

	/**
	 * Returns the container's {@link Shell} or {@code null} if the container has not been
	 * initialized yet or has been disposed.
	 * 
	 * @return the container's {@code Shell} or {@code null}.
	 */
	@Override
	public Shell getShell() {
		return container != null && !container.isDisposed() ? container.getShell() : null;
	}

}
