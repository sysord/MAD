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
package com.sysord.mad.ui.swt.widget;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.sysord.eclipse.tools.swt.ColorRegistry;
import com.sysord.mad.mao.MaoCommand;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.CandidateLabelProvider;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.Widget;

/**
 * Default SWT implementation of the {@link NavigationWidget}.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTNavigationListWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof NavigationWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Navigation List",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }

    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite container = getSwtContext().getWidgetContainer();
        NavigationWidget widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        createLabelColumn(toolkit, container, widget);

        // Creation of a TableViewer
        Table table = toolkit.createTable(container, SWT.BORDER | SWT.SINGLE);
        table.setBackground(ColorRegistry.get(NAVIGATION_COLOR));
        table.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        TableViewer viewer = new TableViewer(table);
        viewer.setLabelProvider(new CandidateLabelProvider());
        viewer.setContentProvider(ArrayContentProvider.getInstance());
        viewer.setInput(widget.getCandidates());
        table.setLinesVisible(true);
        // Add the commands buttons for the table.
        addCommandsButtons(container, toolkit, widget, table);
        addNavigationListListeners(widget, viewer);
        return table;
    }

    /**
     * Add the needed listeners to the {@link NavigationWidget} and its corresponding
     * {@code listViewer}.
     * 
     * @param widget
     * @param tableViewer
     */
    protected void addNavigationListListeners(final NavigationWidget widget, final TableViewer tableViewer) {
        tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                Object selectedElement;
                if (!selection.isEmpty()) {
                    selectedElement = ((Candidate) selection.getFirstElement()).getValue();
                } else {
                    selectedElement = null;
                }
                widget.setSelectedItem(selectedElement);
            }
        });
        tableViewer.addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                EObject selectedElement = (EObject) ((Candidate) selection.getFirstElement()).getValue();
                widget.setNavigateTo(selectedElement);
                getViewBuilder().getCurrentContext().setCurrentElement(selectedElement);
                widget.getCommand(MaoCommand.NAVIGATION_COMMAND).execute();
            }
        });
        final ScrolledForm form = getSwtContext().getForm();
        widget.addCandidatesListener(new CandidateListener() {

            @Override
            public void candidatesChanged(List<Candidate> candidates) {
                if (!tableViewer.getControl().isDisposed()) {
                    tableViewer.setInput(candidates);
                    Table table = tableViewer.getTable();
                    Point oldSize = table.getSize();
                    Point newSize = table.computeSize(SWT.DEFAULT, SWT.DEFAULT);
                    table.setSize(oldSize.x, newSize.y);
                    form.reflow(true);
                }
            }
        });
    }

}
