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

import com.sysord.mad.MadEnumAttribute;
import com.sysord.mad.MadPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.impl.MadEnumAttributeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.sysord.mad.impl.MadEnumAttributeImpl#getCandidates <em>Candidates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MadEnumAttributeImpl extends MadAttributeImpl implements MadEnumAttribute {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EEnumLiteral value;

	/**
	 * The cached value of the '{@link #getCandidates() <em>Candidates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCandidates()
	 * @generated
	 * @ordered
	 */
	protected EList<EEnumLiteral> candidates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MadEnumAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MadPackage.Literals.MAD_ENUM_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteral getValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (EEnumLiteral)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadPackage.MAD_ENUM_ATTRIBUTE__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteral basicGetValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(EEnumLiteral newValue) {
		EEnumLiteral oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MadPackage.MAD_ENUM_ATTRIBUTE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EEnumLiteral> getCandidates() {
		if (candidates == null) {
			candidates = new EObjectResolvingEList<EEnumLiteral>(EEnumLiteral.class, this, MadPackage.MAD_ENUM_ATTRIBUTE__CANDIDATES);
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
			case MadPackage.MAD_ENUM_ATTRIBUTE__VALUE:
				if (resolve) return getValue();
				return basicGetValue();
			case MadPackage.MAD_ENUM_ATTRIBUTE__CANDIDATES:
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
			case MadPackage.MAD_ENUM_ATTRIBUTE__VALUE:
				setValue((EEnumLiteral)newValue);
				return;
			case MadPackage.MAD_ENUM_ATTRIBUTE__CANDIDATES:
				getCandidates().clear();
				getCandidates().addAll((Collection<? extends EEnumLiteral>)newValue);
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
			case MadPackage.MAD_ENUM_ATTRIBUTE__VALUE:
				setValue((EEnumLiteral)null);
				return;
			case MadPackage.MAD_ENUM_ATTRIBUTE__CANDIDATES:
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
			case MadPackage.MAD_ENUM_ATTRIBUTE__VALUE:
				return value != null;
			case MadPackage.MAD_ENUM_ATTRIBUTE__CANDIDATES:
				return candidates != null && !candidates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MadEnumAttributeImpl
