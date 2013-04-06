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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.MadCollection#getItems <em>Items</em>}</li>
 *   <li>{@link com.sysord.mad.MadCollection#getItemType <em>Item Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.MadPackage#getMadCollection()
 * @model
 * @generated
 */
public interface MadCollection extends MadElement {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' reference list.
	 * @see com.sysord.mad.MadPackage#getMadCollection_Items()
	 * @model
	 * @generated
	 */
	EList<EObject> getItems();

	/**
	 * Returns the value of the '<em><b>Item Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Type</em>' reference.
	 * @see #setItemType(EClass)
	 * @see com.sysord.mad.MadPackage#getMadCollection_ItemType()
	 * @model
	 * @generated
	 */
	EClass getItemType();

	/**
	 * Sets the value of the '{@link com.sysord.mad.MadCollection#getItemType <em>Item Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Type</em>' reference.
	 * @see #getItemType()
	 * @generated
	 */
	void setItemType(EClass value);

} // MadCollection
