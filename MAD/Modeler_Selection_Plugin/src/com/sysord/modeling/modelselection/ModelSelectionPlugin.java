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

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.*;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ModelSelectionPlugin extends AbstractUIPlugin implements IWindowListener {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sysord.modeling.modelselection"; //$NON-NLS-1$

    // The shared instance
    private static ModelSelectionPlugin plugin;

    // The EditPart selection change listener
    private SelectionChangeListener selectionListener;

    /**
     * The constructor
     */
    public ModelSelectionPlugin() {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        registerSelectionChangeListener();
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        removeSelectionListener();
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static ModelSelectionPlugin getDefault() {
        return plugin;
    }

    private void registerSelectionChangeListener() {
        if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) {
            hookSelectionChangeListener();
        } else {
            PlatformUI.getWorkbench().addWindowListener(this);
        }
    }

    /**
     * Add a {@link SelectionChangeListener} to the {@link ISelectionService}.
     */
    private void hookSelectionChangeListener() {
        ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
        selectionService.addSelectionListener(getSelectionListener());
    }

    /**
     * Remove the selectionListener of the selection service.
     */
    private void removeSelectionListener() {
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                        .getSelectionService();
                selectionService.removeSelectionListener(getSelectionListener());
                selectionListener = null;
            }
        });
    }

    protected SelectionChangeListener getSelectionListener() {
        if (selectionListener == null) {
            selectionListener = new SelectionChangeListener();
        }
        return selectionListener;
    }

    /**
     * Add a {@link IModelSelectionListener}.
     * 
     * @param listener
     */
    public static void addModelSelectionListener(IModelSelectionListener listener) {
        getDefault().getSelectionListener().addModelSelectionListener(listener);
    }

    /**
     * Remove the {@link IModelSelectionListener} from this
     * <code>SelectionChangeListener</code>.
     * 
     * @param listener The {@link IModelSelectionListener} to remove.
     */
    public static void removeModelSelectionListener(IModelSelectionListener listener) {
        getDefault().getSelectionListener().removeModelSelectionListener(listener);
    }

    @Override
    public void windowActivated(IWorkbenchWindow window) {
        /*
         * We want to know when the first window is activated to get the workbench
         * activated window and obtain the selection service.
         * We can remove the listener after that.
         */
        hookSelectionChangeListener();
        
        // Remove the window listener
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                PlatformUI.getWorkbench().removeWindowListener(ModelSelectionPlugin.this);
            }
        });
    }

    @Override
    public void windowDeactivated(IWorkbenchWindow window) {
    }

    @Override
    public void windowClosed(IWorkbenchWindow window) {
    }

    @Override
    public void windowOpened(IWorkbenchWindow window) {
    }

    /**
     * This class is listening to {@link EditPart} selection change events and notifies
     * the registered {@link IModelSelectionListener}s of the new ecore EObject
     * corresponding to the selected {@link EditPart}.
     */
    private class SelectionChangeListener implements ISelectionListener {

        /**
         * The {@link IModelSelectionListener}s.
         */
        private List<IModelSelectionListener> listeners;

        @Override
        public void selectionChanged(IWorkbenchPart part, ISelection selection) {
            if (selection instanceof IStructuredSelection) {
                notifyListeners((IStructuredSelection) selection);
            }
        }

        /**
         * Notifies the {@link IModelSelectionListener}s of the new selected objects.
         * 
         * @param selection The new selection.
         */
        private void notifyListeners(IStructuredSelection selection) {
            // Creating a copy of the listeners list for avoiding concurrent
            // modification problems if the notified listeners want to be removed during
            // the notification.
            for (IModelSelectionListener listener : new ArrayList<IModelSelectionListener>(getListeners())) {
                listener.selectionChanged(selection);
            }
        }

        /**
         * Add a {@link IModelSelectionListener} to this
         * <code>SelectionChangeListener</code>.
         * 
         * @param listener
         */
        public void addModelSelectionListener(IModelSelectionListener listener) {
            getListeners().add(listener);
        }

        /**
         * Remove the {@link IModelSelectionListener} from this
         * <code>SelectionChangeListener</code>.
         * 
         * @param listener The {@link IModelSelectionListener} to remove.
         */
        public void removeModelSelectionListener(IModelSelectionListener listener) {
            getListeners().remove(listener);
        }

        /**
         * Return the liste of {@link IModelSelectionListener}s of this
         * <code>SelectionChangeListener</code>.
         * (never null)
         * 
         * @return the liste of {@link IModelSelectionListener}s of this
         *         <code>SelectionChangeListener</code>.
         */
        public List<IModelSelectionListener> getListeners() {
            if (listeners == null) {
                listeners = new ArrayList<IModelSelectionListener>(2);
            }
            return listeners;
        }
    }
}
