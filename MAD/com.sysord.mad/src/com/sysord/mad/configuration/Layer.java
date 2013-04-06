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
 * A {@code Layer} is subset of widgets that can be displayed or hidden.
 * <p>
 * {@code Layer}s are hierarchical, and a sub-layer can't be displayed if its parent is
 * hidden.
 * <p>
 * The purpose of {@code Layer}s is to group the widgets into thematic categories for
 * displaying only the widgets that are useful at a given time.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see LayerManager
 * @see WidgetConfiguration
 */
public interface Layer {

	/**
	 * Returns this layer's ID.
	 * 
	 * @return this layer's ID.
	 */
	public String getId();

	/**
	 * Returns this layer's label.
	 * 
	 * @return this layer's label.
	 */
	public String getLabel();

	/**
	 * Returns this layer's children layers.
	 * 
	 * @return this layer's children layers.
	 */
	public List<Layer> getChildrenLayers();

}
