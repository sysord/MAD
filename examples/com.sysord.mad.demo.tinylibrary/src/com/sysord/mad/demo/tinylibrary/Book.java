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

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.Book#getIsbn <em>Isbn</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.Book#getTitle <em>Title</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.Book#getCategory <em>Category</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.Book#getAuthors <em>Authors</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.Book#getPages <em>Pages</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.Book#getPublished <em>Published</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.Book#isDamaged <em>Damaged</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends EObject {
	/**
	 * Returns the value of the '<em><b>Isbn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Isbn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Isbn</em>' attribute.
	 * @see #setIsbn(String)
	 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getBook_Isbn()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getIsbn();

	/**
	 * Sets the value of the '{@link com.sysord.mad.demo.tinylibrary.Book#getIsbn <em>Isbn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Isbn</em>' attribute.
	 * @see #getIsbn()
	 * @generated
	 */
	void setIsbn(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getBook_Title()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link com.sysord.mad.demo.tinylibrary.Book#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link com.sysord.mad.demo.tinylibrary.BookCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see com.sysord.mad.demo.tinylibrary.BookCategory
	 * @see #setCategory(BookCategory)
	 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getBook_Category()
	 * @model
	 * @generated
	 */
	BookCategory getCategory();

	/**
	 * Sets the value of the '{@link com.sysord.mad.demo.tinylibrary.Book#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see com.sysord.mad.demo.tinylibrary.BookCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(BookCategory value);

	/**
	 * Returns the value of the '<em><b>Authors</b></em>' reference list.
	 * The list contents are of type {@link com.sysord.mad.demo.tinylibrary.Writer}.
	 * It is bidirectional and its opposite is '{@link com.sysord.mad.demo.tinylibrary.Writer#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authors</em>' reference list.
	 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getBook_Authors()
	 * @see com.sysord.mad.demo.tinylibrary.Writer#getBooks
	 * @model opposite="books" required="true"
	 * @generated
	 */
	EList<Writer> getAuthors();

	/**
	 * Returns the value of the '<em><b>Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' attribute.
	 * @see #isSetPages()
	 * @see #unsetPages()
	 * @see #setPages(int)
	 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getBook_Pages()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getPages();

	/**
	 * Sets the value of the '{@link com.sysord.mad.demo.tinylibrary.Book#getPages <em>Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pages</em>' attribute.
	 * @see #isSetPages()
	 * @see #unsetPages()
	 * @see #getPages()
	 * @generated
	 */
	void setPages(int value);

	/**
	 * Unsets the value of the '{@link com.sysord.mad.demo.tinylibrary.Book#getPages <em>Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPages()
	 * @see #getPages()
	 * @see #setPages(int)
	 * @generated
	 */
	void unsetPages();

	/**
	 * Returns whether the value of the '{@link com.sysord.mad.demo.tinylibrary.Book#getPages <em>Pages</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pages</em>' attribute is set.
	 * @see #unsetPages()
	 * @see #getPages()
	 * @see #setPages(int)
	 * @generated
	 */
	boolean isSetPages();

	/**
	 * Returns the value of the '<em><b>Published</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Published</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Published</em>' attribute.
	 * @see #setPublished(Date)
	 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getBook_Published()
	 * @model
	 * @generated
	 */
	Date getPublished();

	/**
	 * Sets the value of the '{@link com.sysord.mad.demo.tinylibrary.Book#getPublished <em>Published</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Published</em>' attribute.
	 * @see #getPublished()
	 * @generated
	 */
	void setPublished(Date value);

	/**
	 * Returns the value of the '<em><b>Damaged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Damaged</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Damaged</em>' attribute.
	 * @see #setDamaged(boolean)
	 * @see com.sysord.mad.demo.tinylibrary.TinylibraryPackage#getBook_Damaged()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	boolean isDamaged();

	/**
	 * Sets the value of the '{@link com.sysord.mad.demo.tinylibrary.Book#isDamaged <em>Damaged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Damaged</em>' attribute.
	 * @see #isDamaged()
	 * @generated
	 */
	void setDamaged(boolean value);

} // Book
