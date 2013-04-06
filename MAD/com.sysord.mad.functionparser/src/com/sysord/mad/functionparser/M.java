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
package com.sysord.mad.functionparser;

import org.eclipse.osgi.util.NLS;

/**
 * Messages
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class M extends NLS {
    private static final String BUNDLE_NAME = "com.sysord.mad.functionparser.msgs"; //$NON-NLS-1$
    public static String err_createFuncFromNonAstFunc;
    public static String err_functionStringMalformed;
    public static String err_processingErrorOccured;
    public static String err_processorCannotBeNull;
    public static String err_typeOfASTNotSupported;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, M.class);
    }

    private M() {
    }
}
