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
package com.sysord.mad.demo.tinylibrary;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.Employee#getManager <em>Manager</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.Employee#getManaged <em>Managed</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends Person {
	/**
	 * Returns the value of the '<em><b>Manager</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.sysord.mad.demo.tinylibrary.Employee#getManaged <em>Managed</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager</em>' reference.
	 * @see #setManager(Employee)
	 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getEmployee_Manager()
	 * @see com.sysord.mad.demo.tinylibrary.Employee#getManaged
	 * @model opposite="managed"
	 * @generated
	 */
	Employee getManager();

	/**
	 * Sets the value of the '{@link com.sysord.mad.demo.tinylibrary.Employee#getManager <em>Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager</em>' reference.
	 * @see #getManager()
	 * @generated
	 */
	void setManager(Employee value);

	/**
	 * Returns the value of the '<em><b>Managed</b></em>' reference list.
	 * The list contents are of type {@link com.sysord.mad.demo.tinylibrary.Employee}.
	 * It is bidirectional and its opposite is '{@link com.sysord.mad.demo.tinylibrary.Employee#getManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed</em>' reference list.
	 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getEmployee_Managed()
	 * @see com.sysord.mad.demo.tinylibrary.Employee#getManager
	 * @model opposite="manager"
	 * @generated
	 */
	EList<Employee> getManaged();

} // Employee
