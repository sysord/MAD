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
package com.sysord.mad.configuration;

import org.eclipse.xtext.linking.ILinker;

import com.sysord.mad.configuration.custom.MadConfigDslLinker;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationServiceProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class MadConfigDslRuntimeModule extends com.sysord.mad.configuration.AbstractMadConfigDslRuntimeModule {

	@Override
	public Class<? extends ILinker> bindILinker() {
		return MadConfigDslLinker.class;
	}

	public Class<ExternalQueryConfigurationServiceProvider> bindExternalQueryConfigurationServiceProvider() {
		return ExternalQueryConfigurationServiceProvider.class;
	}

	
}
