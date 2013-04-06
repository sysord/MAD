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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.sysord.mad.MadFactory
 * @model kind="package"
 * @generated
 */
public interface MadPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mad";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sysord.com/mad";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mad";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MadPackage eINSTANCE = com.sysord.mad.impl.MadPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.sysord.mad.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sysord.mad.impl.RootImpl
	 * @see com.sysord.mad.impl.MadPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mad Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__MAD_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.sysord.mad.impl.MadElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sysord.mad.impl.MadElementImpl
	 * @see com.sysord.mad.impl.MadPackageImpl#getMadElement()
	 * @generated
	 */
	int MAD_ELEMENT = 8;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.sysord.mad.impl.MadAttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sysord.mad.impl.MadAttributeImpl
	 * @see com.sysord.mad.impl.MadPackageImpl#getMadAttribute()
	 * @generated
	 */
	int MAD_ATTRIBUTE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ATTRIBUTE__NAME = MAD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ATTRIBUTE__VALUE_FEATURE = MAD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ATTRIBUTE__VALUE_OWNER = MAD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ATTRIBUTE_FEATURE_COUNT = MAD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.sysord.mad.impl.MadStringAttributeImpl <em>String Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sysord.mad.impl.MadStringAttributeImpl
	 * @see com.sysord.mad.impl.MadPackageImpl#getMadStringAttribute()
	 * @generated
	 */
	int MAD_STRING_ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_STRING_ATTRIBUTE__NAME = MAD_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Value Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_STRING_ATTRIBUTE__VALUE_FEATURE = MAD_ATTRIBUTE__VALUE_FEATURE;

	/**
	 * The feature id for the '<em><b>Value Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_STRING_ATTRIBUTE__VALUE_OWNER = MAD_ATTRIBUTE__VALUE_OWNER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_STRING_ATTRIBUTE__VALUE = MAD_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_STRING_ATTRIBUTE_FEATURE_COUNT = MAD_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.sysord.mad.impl.MadBooleanAttributeImpl <em>Boolean Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sysord.mad.impl.MadBooleanAttributeImpl
	 * @see com.sysord.mad.impl.MadPackageImpl#getMadBooleanAttribute()
	 * @generated
	 */
	int MAD_BOOLEAN_ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_BOOLEAN_ATTRIBUTE__NAME = MAD_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Value Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_BOOLEAN_ATTRIBUTE__VALUE_FEATURE = MAD_ATTRIBUTE__VALUE_FEATURE;

	/**
	 * The feature id for the '<em><b>Value Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_BOOLEAN_ATTRIBUTE__VALUE_OWNER = MAD_ATTRIBUTE__VALUE_OWNER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_BOOLEAN_ATTRIBUTE__VALUE = MAD_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_BOOLEAN_ATTRIBUTE_FEATURE_COUNT = MAD_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.sysord.mad.impl.MadEnumAttributeImpl <em>Enum Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sysord.mad.impl.MadEnumAttributeImpl
	 * @see com.sysord.mad.impl.MadPackageImpl#getMadEnumAttribute()
	 * @generated
	 */
	int MAD_ENUM_ATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ENUM_ATTRIBUTE__NAME = MAD_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Value Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ENUM_ATTRIBUTE__VALUE_FEATURE = MAD_ATTRIBUTE__VALUE_FEATURE;

	/**
	 * The feature id for the '<em><b>Value Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ENUM_ATTRIBUTE__VALUE_OWNER = MAD_ATTRIBUTE__VALUE_OWNER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ENUM_ATTRIBUTE__VALUE = MAD_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Candidates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ENUM_ATTRIBUTE__CANDIDATES = MAD_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enum Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_ENUM_ATTRIBUTE_FEATURE_COUNT = MAD_ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.sysord.mad.impl.MadSingleObjectAttributeImpl <em>Single Object Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sysord.mad.impl.MadSingleObjectAttributeImpl
	 * @see com.sysord.mad.impl.MadPackageImpl#getMadSingleObjectAttribute()
	 * @generated
	 */
	int MAD_SINGLE_OBJECT_ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_SINGLE_OBJECT_ATTRIBUTE__NAME = MAD_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Value Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_SINGLE_OBJECT_ATTRIBUTE__VALUE_FEATURE = MAD_ATTRIBUTE__VALUE_FEATURE;

	/**
	 * The feature id for the '<em><b>Value Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_SINGLE_OBJECT_ATTRIBUTE__VALUE_OWNER = MAD_ATTRIBUTE__VALUE_OWNER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_SINGLE_OBJECT_ATTRIBUTE__VALUE = MAD_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Candidates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_SINGLE_OBJECT_ATTRIBUTE__CANDIDATES = MAD_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Single Object Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_SINGLE_OBJECT_ATTRIBUTE_FEATURE_COUNT = MAD_ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.sysord.mad.impl.MadMultiObjectAttributeImpl <em>Multi Object Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sysord.mad.impl.MadMultiObjectAttributeImpl
	 * @see com.sysord.mad.impl.MadPackageImpl#getMadMultiObjectAttribute()
	 * @generated
	 */
	int MAD_MULTI_OBJECT_ATTRIBUTE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_MULTI_OBJECT_ATTRIBUTE__NAME = MAD_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Value Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_MULTI_OBJECT_ATTRIBUTE__VALUE_FEATURE = MAD_ATTRIBUTE__VALUE_FEATURE;

	/**
	 * The feature id for the '<em><b>Value Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_MULTI_OBJECT_ATTRIBUTE__VALUE_OWNER = MAD_ATTRIBUTE__VALUE_OWNER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_MULTI_OBJECT_ATTRIBUTE__VALUE = MAD_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Candidates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_MULTI_OBJECT_ATTRIBUTE__CANDIDATES = MAD_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multi Object Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_MULTI_OBJECT_ATTRIBUTE_FEATURE_COUNT = MAD_ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.sysord.mad.impl.MadCollectionImpl <em>Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sysord.mad.impl.MadCollectionImpl
	 * @see com.sysord.mad.impl.MadPackageImpl#getMadCollection()
	 * @generated
	 */
	int MAD_COLLECTION = 7;

	/**
	 * The feature id for the '<em><b>Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_COLLECTION__ITEMS = MAD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Item Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_COLLECTION__ITEM_TYPE = MAD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAD_COLLECTION_FEATURE_COUNT = MAD_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link com.sysord.mad.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see com.sysord.mad.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the reference list '{@link com.sysord.mad.Root#getMadElement <em>Mad Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mad Element</em>'.
	 * @see com.sysord.mad.Root#getMadElement()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_MadElement();

	/**
	 * Returns the meta object for class '{@link com.sysord.mad.MadAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see com.sysord.mad.MadAttribute
	 * @generated
	 */
	EClass getMadAttribute();

	/**
	 * Returns the meta object for the attribute '{@link com.sysord.mad.MadAttribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.sysord.mad.MadAttribute#getName()
	 * @see #getMadAttribute()
	 * @generated
	 */
	EAttribute getMadAttribute_Name();

	/**
	 * Returns the meta object for the reference '{@link com.sysord.mad.MadAttribute#getValueFeature <em>Value Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value Feature</em>'.
	 * @see com.sysord.mad.MadAttribute#getValueFeature()
	 * @see #getMadAttribute()
	 * @generated
	 */
	EReference getMadAttribute_ValueFeature();

	/**
	 * Returns the meta object for the reference '{@link com.sysord.mad.MadAttribute#getValueOwner <em>Value Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value Owner</em>'.
	 * @see com.sysord.mad.MadAttribute#getValueOwner()
	 * @see #getMadAttribute()
	 * @generated
	 */
	EReference getMadAttribute_ValueOwner();

	/**
	 * Returns the meta object for class '{@link com.sysord.mad.MadStringAttribute <em>String Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Attribute</em>'.
	 * @see com.sysord.mad.MadStringAttribute
	 * @generated
	 */
	EClass getMadStringAttribute();

	/**
	 * Returns the meta object for the attribute '{@link com.sysord.mad.MadStringAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.sysord.mad.MadStringAttribute#getValue()
	 * @see #getMadStringAttribute()
	 * @generated
	 */
	EAttribute getMadStringAttribute_Value();

	/**
	 * Returns the meta object for class '{@link com.sysord.mad.MadBooleanAttribute <em>Boolean Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Attribute</em>'.
	 * @see com.sysord.mad.MadBooleanAttribute
	 * @generated
	 */
	EClass getMadBooleanAttribute();

	/**
	 * Returns the meta object for the attribute '{@link com.sysord.mad.MadBooleanAttribute#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.sysord.mad.MadBooleanAttribute#isValue()
	 * @see #getMadBooleanAttribute()
	 * @generated
	 */
	EAttribute getMadBooleanAttribute_Value();

	/**
	 * Returns the meta object for class '{@link com.sysord.mad.MadEnumAttribute <em>Enum Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Attribute</em>'.
	 * @see com.sysord.mad.MadEnumAttribute
	 * @generated
	 */
	EClass getMadEnumAttribute();

	/**
	 * Returns the meta object for the reference '{@link com.sysord.mad.MadEnumAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see com.sysord.mad.MadEnumAttribute#getValue()
	 * @see #getMadEnumAttribute()
	 * @generated
	 */
	EReference getMadEnumAttribute_Value();

	/**
	 * Returns the meta object for the reference list '{@link com.sysord.mad.MadEnumAttribute#getCandidates <em>Candidates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Candidates</em>'.
	 * @see com.sysord.mad.MadEnumAttribute#getCandidates()
	 * @see #getMadEnumAttribute()
	 * @generated
	 */
	EReference getMadEnumAttribute_Candidates();

	/**
	 * Returns the meta object for class '{@link com.sysord.mad.MadSingleObjectAttribute <em>Single Object Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Object Attribute</em>'.
	 * @see com.sysord.mad.MadSingleObjectAttribute
	 * @generated
	 */
	EClass getMadSingleObjectAttribute();

	/**
	 * Returns the meta object for the reference '{@link com.sysord.mad.MadSingleObjectAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see com.sysord.mad.MadSingleObjectAttribute#getValue()
	 * @see #getMadSingleObjectAttribute()
	 * @generated
	 */
	EReference getMadSingleObjectAttribute_Value();

	/**
	 * Returns the meta object for the reference list '{@link com.sysord.mad.MadSingleObjectAttribute#getCandidates <em>Candidates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Candidates</em>'.
	 * @see com.sysord.mad.MadSingleObjectAttribute#getCandidates()
	 * @see #getMadSingleObjectAttribute()
	 * @generated
	 */
	EReference getMadSingleObjectAttribute_Candidates();

	/**
	 * Returns the meta object for class '{@link com.sysord.mad.MadMultiObjectAttribute <em>Multi Object Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Object Attribute</em>'.
	 * @see com.sysord.mad.MadMultiObjectAttribute
	 * @generated
	 */
	EClass getMadMultiObjectAttribute();

	/**
	 * Returns the meta object for the reference list '{@link com.sysord.mad.MadMultiObjectAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Value</em>'.
	 * @see com.sysord.mad.MadMultiObjectAttribute#getValue()
	 * @see #getMadMultiObjectAttribute()
	 * @generated
	 */
	EReference getMadMultiObjectAttribute_Value();

	/**
	 * Returns the meta object for the reference list '{@link com.sysord.mad.MadMultiObjectAttribute#getCandidates <em>Candidates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Candidates</em>'.
	 * @see com.sysord.mad.MadMultiObjectAttribute#getCandidates()
	 * @see #getMadMultiObjectAttribute()
	 * @generated
	 */
	EReference getMadMultiObjectAttribute_Candidates();

	/**
	 * Returns the meta object for class '{@link com.sysord.mad.MadCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection</em>'.
	 * @see com.sysord.mad.MadCollection
	 * @generated
	 */
	EClass getMadCollection();

	/**
	 * Returns the meta object for the reference list '{@link com.sysord.mad.MadCollection#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Items</em>'.
	 * @see com.sysord.mad.MadCollection#getItems()
	 * @see #getMadCollection()
	 * @generated
	 */
	EReference getMadCollection_Items();

	/**
	 * Returns the meta object for the reference '{@link com.sysord.mad.MadCollection#getItemType <em>Item Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Item Type</em>'.
	 * @see com.sysord.mad.MadCollection#getItemType()
	 * @see #getMadCollection()
	 * @generated
	 */
	EReference getMadCollection_ItemType();

	/**
	 * Returns the meta object for class '{@link com.sysord.mad.MadElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see com.sysord.mad.MadElement
	 * @generated
	 */
	EClass getMadElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MadFactory getMadFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.sysord.mad.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sysord.mad.impl.RootImpl
		 * @see com.sysord.mad.impl.MadPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Mad Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__MAD_ELEMENT = eINSTANCE.getRoot_MadElement();

		/**
		 * The meta object literal for the '{@link com.sysord.mad.impl.MadAttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sysord.mad.impl.MadAttributeImpl
		 * @see com.sysord.mad.impl.MadPackageImpl#getMadAttribute()
		 * @generated
		 */
		EClass MAD_ATTRIBUTE = eINSTANCE.getMadAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAD_ATTRIBUTE__NAME = eINSTANCE.getMadAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Value Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAD_ATTRIBUTE__VALUE_FEATURE = eINSTANCE.getMadAttribute_ValueFeature();

		/**
		 * The meta object literal for the '<em><b>Value Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAD_ATTRIBUTE__VALUE_OWNER = eINSTANCE.getMadAttribute_ValueOwner();

		/**
		 * The meta object literal for the '{@link com.sysord.mad.impl.MadStringAttributeImpl <em>String Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sysord.mad.impl.MadStringAttributeImpl
		 * @see com.sysord.mad.impl.MadPackageImpl#getMadStringAttribute()
		 * @generated
		 */
		EClass MAD_STRING_ATTRIBUTE = eINSTANCE.getMadStringAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAD_STRING_ATTRIBUTE__VALUE = eINSTANCE.getMadStringAttribute_Value();

		/**
		 * The meta object literal for the '{@link com.sysord.mad.impl.MadBooleanAttributeImpl <em>Boolean Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sysord.mad.impl.MadBooleanAttributeImpl
		 * @see com.sysord.mad.impl.MadPackageImpl#getMadBooleanAttribute()
		 * @generated
		 */
		EClass MAD_BOOLEAN_ATTRIBUTE = eINSTANCE.getMadBooleanAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAD_BOOLEAN_ATTRIBUTE__VALUE = eINSTANCE.getMadBooleanAttribute_Value();

		/**
		 * The meta object literal for the '{@link com.sysord.mad.impl.MadEnumAttributeImpl <em>Enum Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sysord.mad.impl.MadEnumAttributeImpl
		 * @see com.sysord.mad.impl.MadPackageImpl#getMadEnumAttribute()
		 * @generated
		 */
		EClass MAD_ENUM_ATTRIBUTE = eINSTANCE.getMadEnumAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAD_ENUM_ATTRIBUTE__VALUE = eINSTANCE.getMadEnumAttribute_Value();

		/**
		 * The meta object literal for the '<em><b>Candidates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAD_ENUM_ATTRIBUTE__CANDIDATES = eINSTANCE.getMadEnumAttribute_Candidates();

		/**
		 * The meta object literal for the '{@link com.sysord.mad.impl.MadSingleObjectAttributeImpl <em>Single Object Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sysord.mad.impl.MadSingleObjectAttributeImpl
		 * @see com.sysord.mad.impl.MadPackageImpl#getMadSingleObjectAttribute()
		 * @generated
		 */
		EClass MAD_SINGLE_OBJECT_ATTRIBUTE = eINSTANCE.getMadSingleObjectAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAD_SINGLE_OBJECT_ATTRIBUTE__VALUE = eINSTANCE.getMadSingleObjectAttribute_Value();

		/**
		 * The meta object literal for the '<em><b>Candidates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAD_SINGLE_OBJECT_ATTRIBUTE__CANDIDATES = eINSTANCE.getMadSingleObjectAttribute_Candidates();

		/**
		 * The meta object literal for the '{@link com.sysord.mad.impl.MadMultiObjectAttributeImpl <em>Multi Object Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sysord.mad.impl.MadMultiObjectAttributeImpl
		 * @see com.sysord.mad.impl.MadPackageImpl#getMadMultiObjectAttribute()
		 * @generated
		 */
		EClass MAD_MULTI_OBJECT_ATTRIBUTE = eINSTANCE.getMadMultiObjectAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAD_MULTI_OBJECT_ATTRIBUTE__VALUE = eINSTANCE.getMadMultiObjectAttribute_Value();

		/**
		 * The meta object literal for the '<em><b>Candidates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAD_MULTI_OBJECT_ATTRIBUTE__CANDIDATES = eINSTANCE.getMadMultiObjectAttribute_Candidates();

		/**
		 * The meta object literal for the '{@link com.sysord.mad.impl.MadCollectionImpl <em>Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sysord.mad.impl.MadCollectionImpl
		 * @see com.sysord.mad.impl.MadPackageImpl#getMadCollection()
		 * @generated
		 */
		EClass MAD_COLLECTION = eINSTANCE.getMadCollection();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAD_COLLECTION__ITEMS = eINSTANCE.getMadCollection_Items();

		/**
		 * The meta object literal for the '<em><b>Item Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAD_COLLECTION__ITEM_TYPE = eINSTANCE.getMadCollection_ItemType();

		/**
		 * The meta object literal for the '{@link com.sysord.mad.impl.MadElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sysord.mad.impl.MadElementImpl
		 * @see com.sysord.mad.impl.MadPackageImpl#getMadElement()
		 * @generated
		 */
		EClass MAD_ELEMENT = eINSTANCE.getMadElement();

	}

} //MadPackage
