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
package com.sysord.mad.configuration;

import java.util.List;

/**
 * Holds the layers configurations and selections.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see Layer
 */
public interface LayerManager {

	/**
	 * Returns the main {@link Layer layer} (root layer).
	 * 
	 * @return the main layer
	 */
	public Layer getMainLayer();

	/**
	 * Returns a list containing all selected {@link Layer layers}.
	 * 
	 * @return the selected layers.
	 */
	public List<Layer> getSelectedLayers();

	/**
	 * Indicates if the given {@link Layer layer} is selected.
	 * 
	 * @param layer The layer for which we want to know if it is selected.
	 * @return {@code true} if the given {@link Layer layer} is selected;<br>
	 *         {@code false} otherwise.
	 */
	public boolean isLayerSelected(Layer layer);

}
