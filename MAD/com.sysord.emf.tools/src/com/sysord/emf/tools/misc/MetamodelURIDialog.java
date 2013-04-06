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
package com.sysord.emf.tools.misc;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.RegisteredPackageDialog;

/**
 * Dialog for choosing URIs of the registered EMF meta-models.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class MetamodelURIDialog extends RegisteredPackageDialog {

	/**
	 * Creates a new {@code MetamodelURIDialog}.
	 * 
	 * @param shell
	 */
	public MetamodelURIDialog(Shell shell) {
		super(shell);
	}

	public URI getFirstResultURI() {
		Object firstResult = super.getFirstResult();
		return convertToURI(firstResult);
	}

	protected URI convertToURI(Object object) {
		Object result;
		if (isDevelopmentTimeVersion()) {
			result = EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(object);
		} else {
			result = EPackage.Registry.INSTANCE.get(object);
		}
		return (URI) result;
	}

	public URI[] getResultUris() {
		URI[] uris = null;
		Object[] results = getResult();
		if (results != null) {
			uris = new URI[results.length];
			for (int i = 0; i < results.length; i++) {
				uris[i] = convertToURI(results[i]);
			}
		} else {
			uris = new URI[0];
		}
		return uris;
	}
}
