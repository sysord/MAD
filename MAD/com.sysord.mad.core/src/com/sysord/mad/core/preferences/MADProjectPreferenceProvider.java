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

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;

import com.google.inject.Injector;
import com.sysord.eclipse.tools.jface.preference.AbstractProjectPreferenceProvider;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.core.Activator;
import com.sysord.mad.core.IMADConstants;

/**
 * Project Preference Provider for projects using the MAD plug-in.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class MADProjectPreferenceProvider extends AbstractProjectPreferenceProvider {
    
    protected ConsoleLogger logger;

    /**
     * Create a {@code MADProjectPreferenceProvider} for the given {@link IProject}.
     * 
     * @param project
     */
    public MADProjectPreferenceProvider(IProject project) {
        super(project);
        Injector injector = Activator.getDefault().getInjector();
        logger = injector.getInstance(ConsoleLogger.class);
    }
    
    /**
     * Returns the ids of the selected layers.
     * 
     * @return the ids of the selected layers.
     */
    public List<String> getSelectedLayers() {
        List<String> layers = new LinkedList<String>();
        String layersStr = getProjectNode().get(PreferenceHelper.PREF_SELECTED_LAYERS, "");
        if (layersStr.length() > 0) {
            Pattern layerPattern = Pattern.compile("([^\\s,]+)(?:\\s*,\\s*)?");
            Matcher matcher = layerPattern.matcher(layersStr);
            while (matcher.find()) {
                layers.add(matcher.group(1));
            }
        }
        return layers;
    }
    
    /**
     * Set the ids of the selected layers.
     * 
     * @param selectedLayers
     */
    public void setSelectedLayers(List<String> selectedLayers) {
        StringBuilder layers = new StringBuilder();
        for (String selectedLayer : selectedLayers) {
            layers.append(selectedLayer).append(' ');
        }
        getProjectNode().put(PreferenceHelper.PREF_SELECTED_LAYERS, layers.toString());
        save();
    }

    @Override
    protected String getPluginID() {
        return IMADConstants.PLUGIN_ID;
    }
    
    @Override
    protected void saveFailed(Exception exception) {
        logger.logError(exception);
    }

    /**
     * Returns the project of this {@link MADProjectPreferenceProvider}.
     * 
     * @return the project of this {@link MADProjectPreferenceProvider}.
     */
    public IProject getProject() {
        return project;
    }

}
