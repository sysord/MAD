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
package com.sysord.mad.ui.swt.dialog;

import java.util.*;
import java.util.List;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

import com.google.inject.Injector;
import com.sysord.mad.configuration.Layer;
import com.sysord.mad.configuration.LayerManager;
import com.sysord.mad.core.Activator;
import com.sysord.mad.core.preferences.MADProjectPreferenceProvider;
import com.sysord.mad.emitter.ViewBuilder;
import com.sysord.mad.evaluator.FormatExpressionEvaluationService;

/**
 * {@link Dialog} with a tree view of the MAD configuration layers.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class LayerDialog extends Dialog {

    private ViewBuilder viewBuilder;

    private LayerManager layerManager;

    private MADProjectPreferenceProvider projectPreferenceProvider;

    private Layer mainLayer;

    private List<Layer> selectedLayers;

    protected TreeViewer viewer;

    /**
     * Create a new {@code LayerDialog} with its parent {@link Shell}.
     * 
     * @param parent A {@code Shell} which will be the parent of this dialog.
     * @param projectPreferenceProvider Preference provider for the current project.
     * 
     * @exception IllegalArgumentException <ul>
     *            <li>ERROR_NULL_ARGUMENT - if the parent is null</li>
     *            </ul>
     * @exception SWTException <ul>
     *            <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that
     *            created the parent</li>
     *            </ul>
     */
    public LayerDialog(Shell parent, MADProjectPreferenceProvider projectPreferenceProvider) {
        super(parent);
        this.projectPreferenceProvider = projectPreferenceProvider;
        Injector injector = Activator.getDefault().getInjector();
        viewBuilder = injector.getInstance(ViewBuilder.class);
        layerManager = injector.getInstance(LayerManager.class);
        initialize();
    }

    /**
     * Initialize the dialog.
     */
    private void initialize() {
        // The Main layer
        mainLayer = layerManager.getMainLayer();
        // The selected layers
        selectedLayers = layerManager.getSelectedLayers();
        // Add the Main layer to the selected layers
        if (!selectedLayers.contains(mainLayer)) {
            selectedLayers.add(mainLayer);
        }
    }

    /**
     * Reload the layers configurations and clear the selection.
     */
    public void refresh() {
        initialize();
        if (!viewer.getControl().isDisposed()) {
            viewer.setSelection(new StructuredSelection());
            viewer.setInput(getInput());
            viewer.setSelection(getInitialSelection());
        }
    }

    /**
     * Open this dialog.
     * 
     * @return
     */
    public Object open() {
        Shell parent = getParent();
        Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.RESIZE | SWT.APPLICATION_MODAL);
        shell.setText(getText());

        createDialogControl(shell);

        shell.setMinimumSize(220, 300);
        shell.pack();
        shell.open();
        Display display = parent.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        closing();
        return null;
    }

    /**
     * Called when this dialog is closing.
     */
    protected void closing() {
        List<Layer> selectedLayers = layerManager.getSelectedLayers();
        List<String> layersIds = new ArrayList<String>(selectedLayers.size());
        for (Layer layer : selectedLayers) {
            layersIds.add(layer.getId());
        }
        if (projectPreferenceProvider != null) {
            projectPreferenceProvider.setSelectedLayers(layersIds);
        }
    }

    /**
     * Create the dialog widgets.
     * 
     * @param shell
     */
    protected void createDialogControl(Shell parent) {
        parent.setLayout(new FillLayout());

        Tree layerTree = new Tree(parent, SWT.CHECK | SWT.MULTI);
        viewer = new TreeViewer(layerTree);
        viewer.setContentProvider(getContentProvider());
        viewer.setLabelProvider(getLabelProvider());
        viewer.setInput(getInput());
        setSelection(getInitialSelection());

        layerTree.addSelectionListener(getSelectionListener());

        viewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                TreeViewer viewer = (TreeViewer) event.getViewer();
                IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection();
                Object selectedNode = thisSelection.getFirstElement();
                viewer.setExpandedState(selectedNode, !viewer.getExpandedState(selectedNode));
            }
        });
    }

    /**
     * Set the given selection.
     * 
     * @param initialSelection
     */
    private void setSelection(IStructuredSelection initialSelection) {
        viewer.setSelection(initialSelection);
        for (TreeItem item : viewer.getTree().getSelection()) {
            item.setChecked(true);
        }
        /*
         * We don't need the selection it-self, so we're clearing it.
         * We only need that the selected elements become CHECKED tree items.
         */
        viewer.setSelection(StructuredSelection.EMPTY);
    }

    public TreeViewer getViewer() {
        return viewer;
    }

    /**
     * Creates a {@link SelectionListener} for the {@link TreeViewer}.
     * 
     * @return the created listener.
     */
    protected SelectionListener getSelectionListener() {
        SelectionListener listener = new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if ((e.detail & SWT.CHECK) != 0) {
                    if (e.item == null || !(e.item instanceof TreeItem))
                        return;
                    // else
                    TreeItem selectedItem = (TreeItem) e.item;
                    if (selectedItem.getData() != null && selectedItem.getData() instanceof TreeNode) {
                        TreeNode selectedNode = (TreeNode) selectedItem.getData();
                        if (selectedItem.getChecked()) {
                            selectedLayers.add((Layer) selectedNode.getValue());

                            // Select parent layers
                            TreeNode currentNode = selectedNode.getParent();
                            TreeItem currentItem = selectedItem.getParentItem();
                            while (currentNode != null && currentItem != null) {
                                currentItem.setChecked(true);
                                if (!selectedLayers.contains(currentNode.getValue())) {
                                    selectedLayers.add((Layer) currentNode.getValue());
                                }
                                currentNode = currentNode.getParent();
                                currentItem = currentItem.getParentItem();
                            }

                            // Select all children
                            select(selectedNode, selectedItem, selectedLayers);
                        } else {
                            deselect(selectedNode, selectedItem, selectedLayers);
                        }
                        viewBuilder.updateCurrentView();
                    }
                }
            }
        };
        return listener;
    }

    /**
     * Returns the initial selection.
     * 
     * @return the initial selection.
     */
    protected IStructuredSelection getInitialSelection() {
        Stack<TreeNode> layerStack = new Stack<TreeNode>();
        for (TreeNode node : (TreeNode[]) viewer.getInput()) {
            layerStack.push(node);
        }
        List<TreeNode> elements = new LinkedList<TreeNode>();
        while (!layerStack.isEmpty()) {
            addSelectedElement(layerStack, elements);
        }
        return new StructuredSelection(elements);
    }

    private void addSelectedElement(Stack<TreeNode> layerStack, List<TreeNode> elements) {
        TreeNode parentNode = layerStack.pop();
        if (selectedLayers.contains(parentNode.getValue())) {
            elements.add(parentNode);
            // A selected element have always its parent selected.
            // So we check only the children of the selected elements
            if (parentNode.getChildren() != null) {
                for (TreeNode node : parentNode.getChildren()) {
                    layerStack.push(node);
                }
            }
        }
    }

    /**
     * Returns an {@link ITreeContentProvider} used by the tree viewer of this dialog.
     * <p>
     * By default, a {@link TreeNodeContentProvider}.
     * 
     * @return an {@link ITreeContentProvider} used by the tree viewer of this dialog.
     */
    protected ITreeContentProvider getContentProvider() {
        return new TreeNodeContentProvider();
    }

    /**
     * Returns the input for the tree viewer of this dialog.
     * <p>
     * By default, the viewer uses a {@link TreeNodeContentProvider} so this method should
     * return a {@link TreeNode}.<br>
     * Subclass the {@code getContentProvider} method for changing the content provider
     * type and using an other type of input.
     * 
     * @return the input for the tree viewer of this dialog.
     */
    protected Object getInput() {
        TreeNode layerTree = new TreeNode(mainLayer);
        Stack<TreeNode> layerStack = new Stack<TreeNode>();
        layerStack.push(layerTree);
        while (!layerStack.isEmpty()) {
            addLayer(layerStack);
        }
        TreeNode[] children = layerTree.getChildren();
        return children == null ? new TreeNode[0] : children;
    }

    /**
     * Returns the label provider for the tree viewer of this dialog.
     * 
     * @return the label provider for the tree viewer of this dialog.
     */
    protected ILabelProvider getLabelProvider() {
        return new LabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof TreeNode) {
                    Object object = ((TreeNode) element).getValue();
                    if (object instanceof Layer) {
                        // none context is used for evaluate expression but use
                        // evaluateFormatExpression for the I18N support.
                        String layerLabel = getFormatExprEvaluationService().evaluateFormatExpression(null,
                                ((Layer) object).getLabel(), null);
                        return layerLabel;
                    }
                }// else
                return super.getText(element);
            }
        };
    }

    private void addLayer(Stack<TreeNode> layerStack) {
        TreeNode parentNode = layerStack.pop();
        Layer parentLayer = (Layer) parentNode.getValue();
        TreeNode[] children = new TreeNode[parentLayer.getChildrenLayers().size()];
        int i = 0;
        for (Layer layer : parentLayer.getChildrenLayers()) {
            TreeNode node = new TreeNode(layer);
            children[i++] = node;
            node.setParent(parentNode);
            layerStack.push(node);
        }
        parentNode.setChildren(children);
    }

    /**
     * Select the given selected node and its children.
     * 
     * @param selectedNode
     * @param selectedItem
     * @param selectedLayers
     */
    protected void select(TreeNode selectedNode, TreeItem selectedItem, List<Layer> selectedLayers) {
        if (!selectedLayers.contains(selectedNode.getValue())) {
            selectedLayers.add((Layer) selectedNode.getValue());
        }
        selectedItem.setChecked(true);
        if (!selectedItem.getExpanded()) {
            // Expand the node for loading the children
            selectedItem.setExpanded(true);
            viewer.refresh(true);
        }
        int i = 0;
        if (selectedNode.getChildren() != null) {
            for (TreeNode child : selectedNode.getChildren()) {
                select(child, selectedItem.getItem(i++), selectedLayers);
            }
        }
    }

    /**
     * Deselect the given selected node and its children.
     * 
     * @param selectedNode
     * @param selectedItem
     * @param selectedLayers
     */
    protected void deselect(TreeNode selectedNode, TreeItem selectedItem, List<Layer> selectedLayers) {
        if (selectedLayers.remove(selectedNode.getValue())) {
            selectedItem.setChecked(false);
            int i = 0;
            if (selectedNode.getChildren() != null) {
                for (TreeNode child : selectedNode.getChildren()) {
                    deselect(child, selectedItem.getItem(i++), selectedLayers);
                }
            }
        }
    }

    /**
     * Format expression evaluation service.
     */
    protected FormatExpressionEvaluationService formatExprEvaluationService;

    /**
     * retrieves and returns the {@link FormatExpressionEvaluationService} using injector
     * 
     * @return
     */
    protected FormatExpressionEvaluationService getFormatExprEvaluationService() {
        if (formatExprEvaluationService == null) {
            formatExprEvaluationService = Activator.getDefault().getInjector()
                    .getInstance(FormatExpressionEvaluationService.class);
        }
        return formatExprEvaluationService;
    }

}
