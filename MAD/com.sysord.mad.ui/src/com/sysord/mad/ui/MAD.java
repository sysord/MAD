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
package com.sysord.mad.ui;

import java.util.*;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.*;
import org.eclipse.ui.part.ViewPart;

import com.google.inject.Injector;
import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.IToolsSharedImages;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.configuration.*;
import com.sysord.mad.configuration.ConfigurationManager.ConfigurationManagerListener;
import com.sysord.mad.core.Activator;
import com.sysord.mad.core.preferences.MADProjectPreferenceProvider;
import com.sysord.mad.core.preferences.PreferenceHelper;
import com.sysord.mad.emitter.*;
import com.sysord.mad.emitter.impl.ViewBuilderAdapter;
import com.sysord.mad.model.EditedModel;
import com.sysord.mad.model.cache.ModelCache;
import com.sysord.mad.model.cache.ModelCacheAdapter;
import com.sysord.mad.ui.swt.SWTHelper;
import com.sysord.mad.ui.swt.SWTSpecificWidgetContext;
import com.sysord.mad.ui.swt.dialog.LayerDialog;
import com.sysord.modeling.modelselection.*;

/**
 * Main view for the Model Aggregator eDitor.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class MAD extends ViewPart {
    
    /*
     * MAD Services
     */

    private ConsoleLogger logger;
    private ModelCache modelCache;
    private ViewBuilder viewBuilder;
    private ViewHolder viewHolder;
    private LayerManager layerManager;
    private ConfigurationManager configurationManager;

    /*
     * MAD UI Services
     */
    
    private MADProjectPreferenceProvider currentPreferenceProvider;

    /*
     * Cache
     */
    
    private Map<URI, MADProjectPreferenceProvider> preferenceProviders;
    private IProject lastProject;

    /*
     * Actions used in the view
     */
    
    private Action backwardAction;
    private Action layerPopupAction;
    private Action saveForeignModelAction;
    private Action autoSaveChangeStatusAction;
    private Action refreshViewAction;

    /*
     * Properties
     */
    
    // SWT
    private Composite parent;
    private MenuManager menuMgr;
    private LayerDialog layerDialog;
    // Others
    private EObject selectedEObject;
    private SWTSpecificWidgetContext swtContext;
    private boolean autoSave;
    private IModelSelectionListener listener;
    private ViewChangeListener viewChangeListener;
    
    /**
     * Default constructor.
     */
    public MAD() {
        Injector injector = Activator.getDefault().getInjector();
        logger = injector.getInstance(ConsoleLogger.class);
        modelCache = injector.getInstance(ModelCache.class);
        viewBuilder = injector.getInstance(ViewBuilder.class);
        viewHolder = injector.getInstance(ViewHolder.class);
        layerManager = injector.getInstance(LayerManager.class);
        configurationManager = injector.getInstance(ConfigurationManager.class);
        preferenceProviders = new HashMap<URI, MADProjectPreferenceProvider>(2);
        init();
    }

    protected void init() {
        logger.showTime(PreferenceHelper.getLoggerShowTime());
        addModelCacheListener();
        addConfigurationManagerListener();
        addModelSelectionListener();
        initializePreferences();
        viewBuilder.addViewBuilderListener(new ViewBuilderAdapter() {
            
            @Override
            public void builderEvent(ViewBuilderEvent event) {
                if ((event.getEventType() & ViewBuilderEvent.BUILD_VIEW_FINISHED) != 0 && swtContext != null
                        && swtContext.getModelElementView() != null) {
                    addModelElementViewListener(swtContext.getModelElementView());
                }
            }
        });
    }

    /**
     * Add the listener given by {@link #getSelectionChangedListener()} to the
     * {@link ModelSelectionPlugin}.
     */
    protected void addModelSelectionListener() {
        ModelSelectionPlugin.addModelSelectionListener(getSelectionChangedListener());
    }

    /**
     * Initialize MAD with the defined preferences.
     */
    protected void initializePreferences() {
        logger.setLoggerLevel(PreferenceHelper.getLoggerLevel());
        autoSave = PreferenceHelper.getAutoSave();
    }

    /**
     * Returns a {@link IModeltSelectionListener} for listening the selection of EObjects.
     * 
     * @return a {@link IModelSelectionListener}.
     */
    protected IModelSelectionListener getSelectionChangedListener() {
        if (listener == null) {
            listener = new FirstEcoreSelectionListener() {
                @Override
                protected void selectionChanged(EObject eObject) {
                    _selectionChanged(eObject);
                }
            };
        }
        return listener;
    }

    @Override
    public void createPartControl(Composite parent) {
        this.parent = parent;
        swtContext = createContext(parent);
        StackLayout layout = new StackLayout();
        parent.setLayout(layout);

        IActionBars bars = getViewSite().getActionBars();
        // Actions on the same level of the tab view (to the right)
        IToolBarManager manager = bars.getToolBarManager();
        // Actions in the menu of the view (accessible in top right)
        IMenuManager menuManager = bars.getMenuManager();

        createActions();

        // Add the backward and layer actions.

        // In the toolbar
        manager.add(refreshViewAction);
        manager.add(backwardAction);
        manager.add(saveForeignModelAction);
        // In the toolbar menu
        menuManager.add(layerPopupAction);
        menuManager.add(autoSaveChangeStatusAction);
        menuManager.add(new Separator());
        menuManager.add(backwardAction);
    }
    
    protected SWTSpecificWidgetContext createContext(Composite parentComposite) {
        SWTSpecificWidgetContext swtContext = new SWTSpecificWidgetContext();
        swtContext.setId(this);
        swtContext.setParentComposite(parentComposite);
        swtContext.setViewHolder(viewHolder);
        return swtContext;
    }

    /**
     * Notified when the selection has changed.
     * 
     * @param eObject
     */
    protected void _selectionChanged(final EObject eObject) {
        SWTHelper.execute(new Runnable() {

            @Override
            public void run() {
                update(eObject);
                if (eObject != selectedEObject) {
                    String name = eObject == null ? "null" : eObject.getClass().getName(); //$NON-NLS-1$
                    String message = Lbl.selectionChanged + name;
                    logger.log(message, ConsoleLogger.LOW);
                    selectedEObject = eObject;
                    viewHolder.disposeAll();
                    viewBuilder.createView(selectedEObject, null, swtContext);
                }
            }
        });
    }

    /**
     * Updates the preferences provider and the layer selection for the given
     * {@link EObject}.
     * 
     * @param eObject
     */
    protected void update(EObject eObject) {
        updateProjectPreferenceProvider(eObject);
        updateLayerSelection();
    }

    /**
     * Updates the current Project Preference Provider for the project containing the
     * resource of the given {@link EObject}.
     * 
     * @param eObject
     */
    protected void updateProjectPreferenceProvider(EObject eObject) {
        if (eObject == null || eObject.eResource() == null)
            return;
        // else

        URI resourceURI = eObject.eResource().getURI();
        currentPreferenceProvider = preferenceProviders.get(resourceURI);
        if (currentPreferenceProvider == null) {
            String path = resourceURI.toString();
            if (path.startsWith(EclipseTools.PLATFORM_RESOURCE)) {
                path = path.substring(EclipseTools.PLATFORM_RESOURCE.length());
                IProject project = EclipseTools.getCurrentWorkspace().getRoot().findMember(path).getProject();
                if (project != null) {
                    currentPreferenceProvider = new MADProjectPreferenceProvider(project);
                    preferenceProviders.put(resourceURI, currentPreferenceProvider);
                }
            }
        }
    }

    /**
     * Updates the layer selection from the project preferences if the selected EObject is
     * in an other project than the previous selected EObject.
     */
    protected void updateLayerSelection() {
        if (currentPreferenceProvider != null && lastProject != currentPreferenceProvider.getProject()) {
            lastProject = currentPreferenceProvider.getProject();

            List<String> layersIds = currentPreferenceProvider.getSelectedLayers();
            List<Layer> selectedLayers = layerManager.getSelectedLayers();
            selectedLayers.clear();
            for (String layerId : layersIds) {
                Layer layer = configurationManager.getLayerById(layerId);
                if (layer != null) {
                    selectedLayers.add(layer);
                }
            }
        }
    }

    /**
     * Add a listener to the {@link ModelCache} for listening to foreign models changes.
     */
    protected void addModelCacheListener() {
        modelCache.addListener(new ModelCacheAdapter() {

            @Override
            public void onDirtyStateChanged(boolean isDirty) {
                if (saveForeignModelAction != null) {
                    saveForeignModelAction.setEnabled(isDirty && !autoSave);
                }
            }

            @Override
            public void onFlush() {
                if (saveForeignModelAction != null) {
                    // All resources have been saved
                    saveForeignModelAction.setEnabled(false);
                }
            }

            @Override
            public void onModelChangedOutside(EditedModel model) {
            	//if auto reload is allowed: evic the model, it will be reloaded silently
            	boolean evictModel = model.isAutoReloadAllowed() || requestForApplyChanges(model);
                if(evictModel){
                	modelCache.evict(model.getModelResource().getURI());
                }                
            }

            /**
             * Requests to user for evicting managed model.
             * @param model
             * @return
             */
            protected boolean requestForApplyChanges(EditedModel model){
                if (parent != null && !parent.isDisposed()) {
                    MessageBox messageBox = new MessageBox(parent.getShell(), SWT.ICON_WARNING | SWT.YES | SWT.NO
                            | SWT.RESIZE);
                    messageBox.setText(Lbl.modelChanged);
                    String modelURI = model.getModelResource().getURI().toString();
                    messageBox.setMessage(Lbl.bind(Lbl.msgExternModelChanged, modelURI));
                    int result = messageBox.open();
                    return result == SWT.YES;
                }
                return false;
            }
            
            
        });
    }

    /**
     * Add a {@link ConfigurationManagerListener} for reloading the view when the
     * configuration have changed.
     */
    protected void addConfigurationManagerListener() {
        configurationManager.addListener(new ConfigurationManagerListener() {

            @Override
            public void onConfigurationReloaded() {
                if (layerDialog != null) {
                    layerDialog.refresh();
                }
                viewBuilder.updateCurrentView();
            }

			@Override
			public void onInvalidMadConfiguration(String respourceUri, String message) {
				
			}
        });
    }
    
    private void addModelElementViewListener(ModelElementView view) {
        view.removeViewChangedListener(getViewChangeListener());
        view.addViewChangedListener(getViewChangeListener());
    }

    /**
     * Creates and returns the {@link ViewChangeListener}.
     * <p>
     * Created only at the first call.
     * 
     * @return the created {@link ViewChangeListener}.
     */
    private ViewChangeListener getViewChangeListener() {
        if (viewChangeListener == null) {
            viewChangeListener = new ViewChangeListener() {
                
                @Override
                public void viewChanged(ModelElementView view) {
                    viewBuilder.updateCurrentViewOuputputWidgets();
                }
            };
        }
        return viewChangeListener;
    }

    /**
     * Create the context menu for the current tabbed container.
     * 
     * @param controls {@link Control}s for which the context menu will be set.
     */
    public void createContextMenuManager(Control... controls) {
        /*
         * Bug when reloading an Expandable of the view.
         * The menu have been disposed with the replaced Expandable.
         * The menu should be removed from the Expandable before the disposal.
         */
        for (Control control : controls) {
            Menu menu = getMenuManager().createContextMenu(control);
            control.setMenu(menu);
        }
    }

    private MenuManager getMenuManager() {
        if (menuMgr == null) {
            menuMgr = new MenuManager("#PopupMenu"); //$NON-NLS-1$
            menuMgr.setRemoveAllWhenShown(true);
            menuMgr.addMenuListener(new IMenuListener() {
                public void menuAboutToShow(IMenuManager manager) {
                    MAD.this.fillContextMenu(manager);
                }
            });
            getSite().registerContextMenu(menuMgr, null);
        }
        return menuMgr;
    }

    /**
     * Fill the view context menu.
     * 
     * @param manager
     */
    protected void fillContextMenu(IMenuManager contextMenuManager) {
        contextMenuManager.add(backwardAction);
        contextMenuManager.add(new Separator());
        contextMenuManager.add(layerPopupAction);
        // Other plug-ins can contribute there actions here
        contextMenuManager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
    }

    /**
     * Create the view actions.
     */
    private void createActions() {
        createBackwardAction();
        createLayerPopupAction();
        createSaveForeignModelsAction();
        createAutoSaveChangeAction();
        createRefreshViewAction();
    }

    /**
     * Create the layer dialog popup action.
     */
    private void createLayerPopupAction() {
        layerPopupAction = new Action(Lbl.layers) {
            @Override
            public void run() {
                createLayerDialog().open();
            }
        };
    }

    /**
     * Create the backward action.
     * <p>
     * Action for going back to the previous view in a navigation widget.
     */
    private void createBackwardAction() {
        backwardAction = new Action(Lbl.back) {
            @Override
            public void run() {
                viewHolder.restoreLastView();
            }
        };
        backwardAction.setToolTipText(Lbl.returnPrevView);
        backwardAction.setImageDescriptor(EclipseTools.getSharedImageDescriptor(ISharedImages.IMG_TOOL_BACK));
    }

    /**
     * Create the Save foreign model action.
     * <p>
     * Action for saving the foreign models related to the current observed model in MAD.
     */
    private void createSaveForeignModelsAction() {
        saveForeignModelAction = new Action() {
            @Override
            public void run() {
                modelCache.flush();
                // Refresh the view for reloading the widgets and there backed elements
                viewBuilder.updateCurrentView();
            }
        };
        saveForeignModelAction.setToolTipText(Lbl.saveForeignModels);
        saveForeignModelAction.setText(Lbl.saveModels);
        saveForeignModelAction.setImageDescriptor(EclipseTools
                .getSharedImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));
        saveForeignModelAction.setDisabledImageDescriptor(EclipseTools
                .getSharedImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT_DISABLED));
        saveForeignModelAction.setEnabled(false);
    }

    private void createAutoSaveChangeAction() {
        autoSaveChangeStatusAction = new Action(Lbl.autoSave, Action.AS_CHECK_BOX) {
            @Override
            public void run() {
                autoSave = isChecked();
                PreferenceHelper.getStore().setValue(PreferenceHelper.PREF_MODEL_AUTO_SAVE, autoSave);
            }
        };
        autoSaveChangeStatusAction.setToolTipText(Lbl.enableAutoSave);
        autoSaveChangeStatusAction.setChecked(autoSave);
    }
    
    private void createRefreshViewAction() {
        refreshViewAction = new Action(Lbl.refresh) {
            @Override
            public void run() {
                viewBuilder.updateCurrentView();
            }
        };
        refreshViewAction.setToolTipText(Lbl.refreshView);
        refreshViewAction.setImageDescriptor(IToolsSharedImages.instance
                .getImageDescriptor(IToolsSharedImages.IMG_REFRESH));
        refreshViewAction.setDisabledImageDescriptor(IToolsSharedImages.instance
                .getImageDescriptor(IToolsSharedImages.IMG_REFRESH_DISABLED));
    }

    /**
     * Create the {@link LayerDialog} for the layer selection.
     * 
     * @return the created {@link LayerDialog}.
     */
    private LayerDialog createLayerDialog() {
        if (layerDialog != null) {
            return layerDialog;
        }// else
        layerDialog = new LayerDialog(parent.getShell(), currentPreferenceProvider);
        return layerDialog;
    }

    @Override
    public void setFocus() {
        // Do nothing
    }

    @Override
    public void dispose() {
        if (listener != null) {
            ModelSelectionPlugin.removeModelSelectionListener(listener);
        }
        if (menuMgr != null) {
            menuMgr.dispose();
        }
        viewHolder.disposeAll();
        super.dispose();
    }
}
