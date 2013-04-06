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
package com.sysord.mad.query;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

/**
 * Holds some informations about 
 * Query environment that can be useful 
 * for helping evaluators
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public interface QueryEnvironment {

	/**
	 * Returns uris for all resources that should be imported for the query evaluation
	 * @return
	 */
	public Collection<URI> getEnvironmentResourcesURI();
	
	/**
	 * Returns NsUris for all metamodels that should be imported for the query evaluation
	 * @return
	 */
	public Collection<String> getEnvironmentNSUris();
	
}
