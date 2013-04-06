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

import org.eclipse.osgi.util.NLS;

public class Lbl extends NLS {
    private static final String BUNDLE_NAME = "com.sysord.mad.ui.labels"; //$NON-NLS-1$
    public static String autoSave;
    public static String back;
    public static String browserError;
    public static String refresh;
    public static String refreshView;
    public static String emptyString;
    public static String enableAutoSave;
    public static String error_cannotCreateWidget;
    public static String error_wrongContext;
    public static String layers;
    public static String modelChanged;
    public static String msgExternModelChanged;
    public static String parentNullViewNotCreated;
    public static String returnPrevView;
    public static String saveForeignModels;
    public static String saveModels;
    public static String selectionChanged;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Lbl.class);
    }

    private Lbl() {
    }
}
