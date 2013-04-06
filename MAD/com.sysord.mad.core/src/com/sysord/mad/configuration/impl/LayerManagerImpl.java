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
package com.sysord.mad.configuration.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.configuration.Layer;
import com.sysord.mad.configuration.LayerManager;

public class LayerManagerImpl implements LayerManager {

	@Inject
	protected ConfigurationManager configurationManager;
	
	/**
	 * selected layers
	 */
	protected List<Layer> selectedLayers;
	
		
    public Layer getMainLayer(){
    	return configurationManager.getMainLayer();
    }
    
    /**
     * return a list containing all selected layers
     * @return
     */
    public List<Layer> getSelectedLayers(){
    	if(selectedLayers == null){
    	    selectedLayers = new ArrayList<Layer>();
    	}
    	return selectedLayers;
    }

	/**
     * return true if layer with layerId id is selected
     * @param layerId
     * @return
     */
    public boolean isLayerSelected(Layer layer){
        return getSelectedLayers().contains(layer);
    }
    
}
