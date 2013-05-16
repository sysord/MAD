/**
 * Copyright (c) 2013 Sysord.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sysord - initial API and implementation
 */
package com.sysord.mad.impl;

import com.sysord.mad.MadMultiObjectAttribute;
import com.sysord.mad.MadPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Object Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.impl.MadMultiObjectAttributeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.sysord.mad.impl.MadMultiObjectAttributeImpl#getCandidates <em>Candidates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MadMultiObjectAttributeImpl extends MadAttributeImpl implements MadMultiObjectAttribute {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> value;

	/**
	 * The cached value of the '{@link #getCandidates() <em>Candidates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCandidates()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> candidates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MadMultiObjectAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MadPackage.Literals.MAD_MULTI_OBJECT_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getValue() {
		if (value == null) {
			value = new EObjectResolvingEList<EObject>(EObject.class, this, MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getCandidates() {
		if (candidates == null) {
			candidates = new EObjectResolvingEList<EObject>(EObject.class, this, MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE__CANDIDATES);
		}
		return candidates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE__VALUE:
				return getValue();
			case MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE__CANDIDATES:
				return getCandidates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends EObject>)newValue);
				return;
			case MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE__CANDIDATES:
				getCandidates().clear();
				getCandidates().addAll((Collection<? extends EObject>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE__VALUE:
				getValue().clear();
				return;
			case MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE__CANDIDATES:
				getCandidates().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE__VALUE:
				return value != null && !value.isEmpty();
			case MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE__CANDIDATES:
				return candidates != null && !candidates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Collection<?> getAttributeValue() {
		return value;
	}

} //MadMultiObjectAttributeImpl
