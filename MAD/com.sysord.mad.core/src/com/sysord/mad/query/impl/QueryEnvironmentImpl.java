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
package com.sysord.mad.query.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

import com.sysord.mad.query.QueryEnvironment;

public class QueryEnvironmentImpl implements QueryEnvironment {

	protected Collection<URI> resourcesURI;
	protected Collection<String> resourcesNsUris;
	
	
	public QueryEnvironmentImpl(Collection<URI> resourcesURI, Collection<String> resourcesNsUris) {
		super();
		this.resourcesURI = resourcesURI;
		this.resourcesNsUris = resourcesNsUris;
	}

	@Override
	public Collection<URI> getEnvironmentResourcesURI() {
		return resourcesURI;
	}

	@Override
	public Collection<String> getEnvironmentNSUris() {
		return resourcesNsUris;
	}

}
