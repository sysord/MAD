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
 * A representation of the model object '<em><b>Writer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.Writer#getBooks <em>Books</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getWriter()
 * @model
 * @generated
 */
public interface Writer extends Person {
	/**
	 * Returns the value of the '<em><b>Books</b></em>' reference list.
	 * The list contents are of type {@link com.sysord.mad.demo.tinylibrary.Book}.
	 * It is bidirectional and its opposite is '{@link com.sysord.mad.demo.tinylibrary.Book#getAuthors <em>Authors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' reference list.
	 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getWriter_Books()
	 * @see com.sysord.mad.demo.tinylibrary.Book#getAuthors
	 * @model opposite="authors"
	 * @generated
	 */
	EList<Book> getBooks();

} // Writer
