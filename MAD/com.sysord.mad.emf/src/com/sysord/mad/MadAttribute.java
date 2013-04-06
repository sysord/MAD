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
package com.sysord.mad;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.MadAttribute#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.MadAttribute#getValueFeature <em>Value Feature</em>}</li>
 *   <li>{@link com.sysord.mad.MadAttribute#getValueOwner <em>Value Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.MadPackage#getMadAttribute()
 * @model abstract="true"
 * @generated
 */
public interface MadAttribute extends MadElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.sysord.mad.MadPackage#getMadAttribute_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.sysord.mad.MadAttribute#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Feature</em>' reference.
	 * @see #setValueFeature(EStructuralFeature)
	 * @see com.sysord.mad.MadPackage#getMadAttribute_ValueFeature()
	 * @model
	 * @generated
	 */
	EStructuralFeature getValueFeature();

	/**
	 * Sets the value of the '{@link com.sysord.mad.MadAttribute#getValueFeature <em>Value Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Feature</em>' reference.
	 * @see #getValueFeature()
	 * @generated
	 */
	void setValueFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Value Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Owner</em>' reference.
	 * @see #setValueOwner(EObject)
	 * @see com.sysord.mad.MadPackage#getMadAttribute_ValueOwner()
	 * @model
	 * @generated
	 */
	EObject getValueOwner();

	/**
	 * Sets the value of the '{@link com.sysord.mad.MadAttribute#getValueOwner <em>Value Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Owner</em>' reference.
	 * @see #getValueOwner()
	 * @generated
	 */
	void setValueOwner(EObject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Object getAttributeValue();

} // MadAttribute
