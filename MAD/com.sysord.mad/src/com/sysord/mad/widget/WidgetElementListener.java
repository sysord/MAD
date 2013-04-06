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
package com.sysord.mad.widget;

import org.eclipse.emf.common.notify.Notification;

import com.sysord.mad.mao.ValuedElementListener;
import com.sysord.mad.mao.ValuedSemanticElement;

/**
 * Listener for valued semantic {@link ValuedSemanticElement element} changed events.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see Widget
 */
public interface WidgetElementListener extends ValuedElementListener {

    /**
     * Notifies this listener, th semantic element has been modified.
     * 
     * @param msg The notification received from the {@link ValuedSemanticElement}.
     */
    public void semanticElementChanged(Notification msg);
}
