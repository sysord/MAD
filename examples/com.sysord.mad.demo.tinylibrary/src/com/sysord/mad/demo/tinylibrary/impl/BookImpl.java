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
package com.sysord.mad.demo.tinylibrary.impl;

import com.sysord.mad.demo.tinylibrary.Book;
import com.sysord.mad.demo.tinylibrary.BookCategory;
import com.sysord.mad.demo.tinylibrary.TinylibraryPackage;
import com.sysord.mad.demo.tinylibrary.Writer;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.impl.BookImpl#getIsbn <em>Isbn</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.impl.BookImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.impl.BookImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.impl.BookImpl#getAuthors <em>Authors</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.impl.BookImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.impl.BookImpl#getPublished <em>Published</em>}</li>
 *   <li>{@link com.sysord.mad.demo.tinylibrary.impl.BookImpl#isDamaged <em>Damaged</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BookImpl extends EObjectImpl implements Book {
	/**
	 * The default value of the '{@link #getIsbn() <em>Isbn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsbn()
	 * @generated
	 * @ordered
	 */
	protected static final String ISBN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsbn() <em>Isbn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsbn()
	 * @generated
	 * @ordered
	 */
	protected String isbn = ISBN_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final BookCategory CATEGORY_EDEFAULT = BookCategory.MYSTERY;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected BookCategory category = CATEGORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAuthors() <em>Authors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthors()
	 * @generated
	 * @ordered
	 */
	protected EList<Writer> authors;

	/**
	 * The default value of the '{@link #getPages() <em>Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected static final int PAGES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPages() <em>Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected int pages = PAGES_EDEFAULT;

	/**
	 * This is true if the Pages attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean pagesESet;

	/**
	 * The default value of the '{@link #getPublished() <em>Published</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublished()
	 * @generated
	 * @ordered
	 */
	protected static final Date PUBLISHED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublished() <em>Published</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublished()
	 * @generated
	 * @ordered
	 */
	protected Date published = PUBLISHED_EDEFAULT;

	/**
	 * The default value of the '{@link #isDamaged() <em>Damaged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDamaged()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DAMAGED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDamaged() <em>Damaged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDamaged()
	 * @generated
	 * @ordered
	 */
	protected boolean damaged = DAMAGED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BookImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TinylibraryPackage.Literals.BOOK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsbn(String newIsbn) {
		String oldIsbn = isbn;
		isbn = newIsbn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TinylibraryPackage.BOOK__ISBN, oldIsbn, isbn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TinylibraryPackage.BOOK__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BookCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(BookCategory newCategory) {
		BookCategory oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TinylibraryPackage.BOOK__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Writer> getAuthors() {
		if (authors == null) {
			authors = new EObjectWithInverseResolvingEList.ManyInverse<Writer>(Writer.class, this, TinylibraryPackage.BOOK__AUTHORS, TinylibraryPackage.WRITER__BOOKS);
		}
		return authors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPages(int newPages) {
		int oldPages = pages;
		pages = newPages;
		boolean oldPagesESet = pagesESet;
		pagesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TinylibraryPackage.BOOK__PAGES, oldPages, pages, !oldPagesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPages() {
		int oldPages = pages;
		boolean oldPagesESet = pagesESet;
		pages = PAGES_EDEFAULT;
		pagesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TinylibraryPackage.BOOK__PAGES, oldPages, PAGES_EDEFAULT, oldPagesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPages() {
		return pagesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getPublished() {
		return published;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublished(Date newPublished) {
		Date oldPublished = published;
		published = newPublished;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TinylibraryPackage.BOOK__PUBLISHED, oldPublished, published));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDamaged() {
		return damaged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDamaged(boolean newDamaged) {
		boolean oldDamaged = damaged;
		damaged = newDamaged;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TinylibraryPackage.BOOK__DAMAGED, oldDamaged, damaged));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TinylibraryPackage.BOOK__AUTHORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAuthors()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TinylibraryPackage.BOOK__AUTHORS:
				return ((InternalEList<?>)getAuthors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TinylibraryPackage.BOOK__ISBN:
				return getIsbn();
			case TinylibraryPackage.BOOK__TITLE:
				return getTitle();
			case TinylibraryPackage.BOOK__CATEGORY:
				return getCategory();
			case TinylibraryPackage.BOOK__AUTHORS:
				return getAuthors();
			case TinylibraryPackage.BOOK__PAGES:
				return getPages();
			case TinylibraryPackage.BOOK__PUBLISHED:
				return getPublished();
			case TinylibraryPackage.BOOK__DAMAGED:
				return isDamaged();
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
			case TinylibraryPackage.BOOK__ISBN:
				setIsbn((String)newValue);
				return;
			case TinylibraryPackage.BOOK__TITLE:
				setTitle((String)newValue);
				return;
			case TinylibraryPackage.BOOK__CATEGORY:
				setCategory((BookCategory)newValue);
				return;
			case TinylibraryPackage.BOOK__AUTHORS:
				getAuthors().clear();
				getAuthors().addAll((Collection<? extends Writer>)newValue);
				return;
			case TinylibraryPackage.BOOK__PAGES:
				setPages((Integer)newValue);
				return;
			case TinylibraryPackage.BOOK__PUBLISHED:
				setPublished((Date)newValue);
				return;
			case TinylibraryPackage.BOOK__DAMAGED:
				setDamaged((Boolean)newValue);
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
			case TinylibraryPackage.BOOK__ISBN:
				setIsbn(ISBN_EDEFAULT);
				return;
			case TinylibraryPackage.BOOK__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case TinylibraryPackage.BOOK__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case TinylibraryPackage.BOOK__AUTHORS:
				getAuthors().clear();
				return;
			case TinylibraryPackage.BOOK__PAGES:
				unsetPages();
				return;
			case TinylibraryPackage.BOOK__PUBLISHED:
				setPublished(PUBLISHED_EDEFAULT);
				return;
			case TinylibraryPackage.BOOK__DAMAGED:
				setDamaged(DAMAGED_EDEFAULT);
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
			case TinylibraryPackage.BOOK__ISBN:
				return ISBN_EDEFAULT == null ? isbn != null : !ISBN_EDEFAULT.equals(isbn);
			case TinylibraryPackage.BOOK__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case TinylibraryPackage.BOOK__CATEGORY:
				return category != CATEGORY_EDEFAULT;
			case TinylibraryPackage.BOOK__AUTHORS:
				return authors != null && !authors.isEmpty();
			case TinylibraryPackage.BOOK__PAGES:
				return isSetPages();
			case TinylibraryPackage.BOOK__PUBLISHED:
				return PUBLISHED_EDEFAULT == null ? published != null : !PUBLISHED_EDEFAULT.equals(published);
			case TinylibraryPackage.BOOK__DAMAGED:
				return damaged != DAMAGED_EDEFAULT;
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
		result.append(" (isbn: ");
		result.append(isbn);
		result.append(", title: ");
		result.append(title);
		result.append(", category: ");
		result.append(category);
		result.append(", pages: ");
		if (pagesESet) result.append(pages); else result.append("<unset>");
		result.append(", published: ");
		result.append(published);
		result.append(", damaged: ");
		result.append(damaged);
		result.append(')');
		return result.toString();
	}

} //BookImpl
