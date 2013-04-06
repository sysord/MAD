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

import com.sysord.mad.configuration.Layer;

public class LayerImpl implements Layer {
 
	protected String id;
	protected String label;
	protected List<Layer> childrenLayers;
	
	public LayerImpl(String id, String label) {
		this(id, label, new ArrayList<Layer>());
	}
	
	
	public LayerImpl(String id, String label, List<Layer> childrenLayers) {
		super();
		this.id = id;
		this.label = label;
		this.childrenLayers = childrenLayers;
	}


	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public List<Layer> getChildrenLayers() {
		return childrenLayers;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LayerImpl other = (LayerImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
