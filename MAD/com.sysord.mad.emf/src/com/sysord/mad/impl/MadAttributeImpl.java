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

import com.sysord.mad.MadAttribute;
import com.sysord.mad.MadPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.impl.MadAttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.impl.MadAttributeImpl#getValueFeature <em>Value Feature</em>}</li>
 *   <li>{@link com.sysord.mad.impl.MadAttributeImpl#getValueOwner <em>Value Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MadAttributeImpl extends MadElementImpl implements MadAttribute {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValueFeature() <em>Value Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature valueFeature;

	/**
	 * The cached value of the '{@link #getValueOwner() <em>Value Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueOwner()
	 * @generated
	 * @ordered
	 */
	protected EObject valueOwner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MadAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MadPackage.Literals.MAD_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MadPackage.MAD_ATTRIBUTE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getValueFeature() {
		if (valueFeature != null && valueFeature.eIsProxy()) {
			InternalEObject oldValueFeature = (InternalEObject)valueFeature;
			valueFeature = (EStructuralFeature)eResolveProxy(oldValueFeature);
			if (valueFeature != oldValueFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadPackage.MAD_ATTRIBUTE__VALUE_FEATURE, oldValueFeature, valueFeature));
			}
		}
		return valueFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetValueFeature() {
		return valueFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueFeature(EStructuralFeature newValueFeature) {
		EStructuralFeature oldValueFeature = valueFeature;
		valueFeature = newValueFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MadPackage.MAD_ATTRIBUTE__VALUE_FEATURE, oldValueFeature, valueFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getValueOwner() {
		if (valueOwner != null && valueOwner.eIsProxy()) {
			InternalEObject oldValueOwner = (InternalEObject)valueOwner;
			valueOwner = eResolveProxy(oldValueOwner);
			if (valueOwner != oldValueOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadPackage.MAD_ATTRIBUTE__VALUE_OWNER, oldValueOwner, valueOwner));
			}
		}
		return valueOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetValueOwner() {
		return valueOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueOwner(EObject newValueOwner) {
		EObject oldValueOwner = valueOwner;
		valueOwner = newValueOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MadPackage.MAD_ATTRIBUTE__VALUE_OWNER, oldValueOwner, valueOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAttributeValue() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MadPackage.MAD_ATTRIBUTE__NAME:
				return getName();
			case MadPackage.MAD_ATTRIBUTE__VALUE_FEATURE:
				if (resolve) return getValueFeature();
				return basicGetValueFeature();
			case MadPackage.MAD_ATTRIBUTE__VALUE_OWNER:
				if (resolve) return getValueOwner();
				return basicGetValueOwner();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MadPackage.MAD_ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case MadPackage.MAD_ATTRIBUTE__VALUE_FEATURE:
				setValueFeature((EStructuralFeature)newValue);
				return;
			case MadPackage.MAD_ATTRIBUTE__VALUE_OWNER:
				setValueOwner((EObject)newValue);
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
			case MadPackage.MAD_ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MadPackage.MAD_ATTRIBUTE__VALUE_FEATURE:
				setValueFeature((EStructuralFeature)null);
				return;
			case MadPackage.MAD_ATTRIBUTE__VALUE_OWNER:
				setValueOwner((EObject)null);
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
			case MadPackage.MAD_ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MadPackage.MAD_ATTRIBUTE__VALUE_FEATURE:
				return valueFeature != null;
			case MadPackage.MAD_ATTRIBUTE__VALUE_OWNER:
				return valueOwner != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MadAttributeImpl
