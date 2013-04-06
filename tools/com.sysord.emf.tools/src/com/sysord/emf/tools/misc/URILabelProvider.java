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
import org.eclipse.jface.viewers.LabelProvider;

/**
 * {@link LabelProvider} for {@link URI} elements.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class URILabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (URI.class.isInstance(element)) {
			return ((URI) element).toString();
		}// else
		
		return super.getText(element);
	}
}
