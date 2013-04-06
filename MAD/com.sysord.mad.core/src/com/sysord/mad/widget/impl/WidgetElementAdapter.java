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
package com.sysord.mad.widget.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.widget.WidgetElementListener;

/**
 * Abstract implementation of the {@link WidgetElementListener} interface with empty
 * methods.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class WidgetElementAdapter implements WidgetElementListener {

    @Override
    public void valuedElementChanged(EObject oldElement, EObject newElement) {
        // Do nothing
    }

    @Override
    public void semanticElementChanged(Notification msg) {
        // Do nothing
    }

}
