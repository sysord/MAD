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
package com.sysord.emf.tools.model;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Observer for track
 * modifications on a model
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public interface ModelObserver extends Adapter{

	public void elementAdded(EObject element);
	public void elementChanged(EObject element, EStructuralFeature feature, Object oldValue, Object newValue);
	public void elementRemoved(EObject element, EObject oldContainer);
		
}
