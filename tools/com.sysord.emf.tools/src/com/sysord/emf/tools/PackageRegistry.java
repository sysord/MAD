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
package com.sysord.emf.tools;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;


/**
 * Package registry for extraction of namespace URI using EMF Resource
 * loading.
 */
public class PackageRegistry implements EPackage.Registry {

	/** Registry to which method calls are delegated. */
	private final EPackage.Registry delegate;

	/** Namespace URI. */
	private String nsURI;

	/**
	 * Default constructor.
	 * 
	 * @param delegate
	 *            Registry to which method calls are delegated
	 */
	public PackageRegistry(EPackage.Registry delegate) {
		this.delegate = delegate;
	}

	/** {@inheritDoc} */
	public void clear() {
		delegate.clear();
	}

	/** {@inheritDoc} */
	public boolean containsKey(Object key) {
		return delegate.containsKey(key);
	}

	/** {@inheritDoc} */
	public boolean containsValue(Object value) {
		return delegate.containsValue(value);
	}

	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	public Set entrySet() {
		return delegate.entrySet();
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object o) {
		return delegate.equals(o);
	}

	/** {@inheritDoc} */
	public Object get(Object key) {
		return delegate.get(key);
	}

	/** {@inheritDoc} */
	public EFactory getEFactory(String nsURI) {
		return delegate.getEFactory(nsURI);
	}

	/** {@inheritDoc} */
	public EPackage getEPackage(String nsURI) {
		if (this.nsURI == null) {
			this.nsURI = nsURI;
		}
		return delegate.getEPackage(nsURI);
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		return delegate.hashCode();
	}

	/** {@inheritDoc} */
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	public Set keySet() {
		return delegate.keySet();
	}

	/** {@inheritDoc} */
	public Object put(String key, Object value) {
		return delegate.put(key, value);
	}

	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	public void putAll(Map t) {
		delegate.putAll(t);
	}

	/** {@inheritDoc} */
	public Object remove(Object key) {
		return delegate.remove(key);
	}

	/** {@inheritDoc} */
	public int size() {
		return delegate.size();
	}

	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	public Collection values() {
		return delegate.values();
	}

	/** Returns the namespace URI. */
	public String getNsURI() {
		return nsURI;
	}

}
