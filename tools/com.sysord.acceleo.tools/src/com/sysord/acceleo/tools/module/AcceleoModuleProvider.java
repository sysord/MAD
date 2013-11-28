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
package com.sysord.acceleo.tools.module;

import java.util.List;

import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

/**
 * Provides acceleo {@link Module modules} with module {@link ModuleDescriptor
 * descriptors}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public interface AcceleoModuleProvider {

	/**
	 * Initializes this module provider with the given {@link EPackage packages}.
	 * 
	 * @deprecated Prefer using the {@link #initialize()} method and
	 *             {@link #addPackages(List)} if needed.
	 * @param packages
	 */
	@Deprecated
	public void initialize(List<EPackage> packages);

	/**
	 * Initializes this module provider.
	 * 
	 * @param packages
	 * @since 2.0
	 */
	public void initialize();

	/**
	 * Register the given packages into this provider's resource set.
	 * 
	 * @param packagesToRegister The {@link EPackage packages} to register.
	 * @since 2.0
	 */
	public void addPackages(List<EPackage> packagesToRegister);

	/**
	 * Returns the {@link Module module} corresponding to the given
	 * {@link ModuleDescriptor descriptor} or {@code null} if it was not found.
	 * 
	 * @param moduleDescriptor
	 * @return the {@link Module module} corresponding to the given
	 *         {@link ModuleDescriptor descriptor} or {@code null}.
	 * @throws IllegalStateException if this provider has not been initialized.
	 */
	public Module getModule(ModuleDescriptor moduleDescriptor);

	/**
	 * Returns the {@link Module module} corresponding to the given {@link URI} or
	 * {@code null} if it was not found.
	 * 
	 * @param moduleUri
	 * @return the {@link Module module} corresponding to the given {@link URI} or
	 *         {@code null}.
	 * @throws IllegalStateException if this provider has not been initialized.
	 */
	public Module getModule(URI moduleUri);

	/**
	 * Clear the internal cache of acceleo {@link Module modules}.
	 * @since 2.0
	 */
	public void clear();
}
