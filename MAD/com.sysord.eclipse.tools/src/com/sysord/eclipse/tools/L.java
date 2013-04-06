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
package com.sysord.eclipse.tools;

import org.eclipse.osgi.util.NLS;

/**
 * Message bundle class for the Eclipse Tools plug-in.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class L extends NLS {
    private static final String BUNDLE_NAME = "com.sysord.eclipse.tools.labels"; //$NON-NLS-1$
    public static String desc_createExampleProjects;
	public static String emptyString;
	public static String err_someProjectsExist;
	public static String error_acceptOnlySwtIdentOp;
	public static String error_fileNotExistsInBundle;
	public static String error_fileSProjectNotExist;
    public static String error_foundOtherThanIFolder;
    public static String error_noBundleFound;
    public static String error_noI18NFound;
	public static String error_onlyPlatformScheme;
	public static String msg_unzippingProjects;
	public static String msg_unzippingTheProject;
	public static String title_examplePageProjects;
	public static String title_new;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, L.class);
    }

    private L() {
    }
}
