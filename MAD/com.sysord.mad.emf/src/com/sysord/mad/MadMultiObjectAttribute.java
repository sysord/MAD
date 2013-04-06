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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Object Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.MadMultiObjectAttribute#getValue <em>Value</em>}</li>
 *   <li>{@link com.sysord.mad.MadMultiObjectAttribute#getCandidates <em>Candidates</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.MadPackage#getMadMultiObjectAttribute()
 * @model
 * @generated
 */
public interface MadMultiObjectAttribute extends MadAttribute {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference list.
	 * @see com.sysord.mad.MadPackage#getMadMultiObjectAttribute_Value()
	 * @model
	 * @generated
	 */
	EList<EObject> getValue();

	/**
	 * Returns the value of the '<em><b>Candidates</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Candidates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Candidates</em>' reference list.
	 * @see com.sysord.mad.MadPackage#getMadMultiObjectAttribute_Candidates()
	 * @model
	 * @generated
	 */
	EList<EObject> getCandidates();

} // MadMultiObjectAttribute
