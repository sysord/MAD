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
import com.sysord.mad.MadBooleanAttribute;
import com.sysord.mad.MadCollection;
import com.sysord.mad.MadElement;
import com.sysord.mad.MadEnumAttribute;
import com.sysord.mad.MadFactory;
import com.sysord.mad.MadMultiObjectAttribute;
import com.sysord.mad.MadPackage;
import com.sysord.mad.MadSingleObjectAttribute;
import com.sysord.mad.MadStringAttribute;
import com.sysord.mad.Root;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MadPackageImpl extends EPackageImpl implements MadPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass madAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass madStringAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass madBooleanAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass madEnumAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass madSingleObjectAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass madMultiObjectAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass madCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass madElementEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.sysord.mad.MadPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MadPackageImpl() {
		super(eNS_URI, MadFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MadPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MadPackage init() {
		if (isInited) return (MadPackage)EPackage.Registry.INSTANCE.getEPackage(MadPackage.eNS_URI);

		// Obtain or create and register package
		MadPackageImpl theMadPackage = (MadPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MadPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MadPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMadPackage.createPackageContents();

		// Initialize created meta-data
		theMadPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMadPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MadPackage.eNS_URI, theMadPackage);
		return theMadPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_MadElement() {
		return (EReference)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMadAttribute() {
		return madAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMadAttribute_Name() {
		return (EAttribute)madAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMadAttribute_ValueFeature() {
		return (EReference)madAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMadAttribute_ValueOwner() {
		return (EReference)madAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMadStringAttribute() {
		return madStringAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMadStringAttribute_Value() {
		return (EAttribute)madStringAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMadBooleanAttribute() {
		return madBooleanAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMadBooleanAttribute_Value() {
		return (EAttribute)madBooleanAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMadEnumAttribute() {
		return madEnumAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMadEnumAttribute_Value() {
		return (EReference)madEnumAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMadEnumAttribute_Candidates() {
		return (EReference)madEnumAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMadSingleObjectAttribute() {
		return madSingleObjectAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMadSingleObjectAttribute_Value() {
		return (EReference)madSingleObjectAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMadSingleObjectAttribute_Candidates() {
		return (EReference)madSingleObjectAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMadMultiObjectAttribute() {
		return madMultiObjectAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMadMultiObjectAttribute_Value() {
		return (EReference)madMultiObjectAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMadMultiObjectAttribute_Candidates() {
		return (EReference)madMultiObjectAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMadCollection() {
		return madCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMadCollection_Items() {
		return (EReference)madCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMadCollection_ItemType() {
		return (EReference)madCollectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMadElement() {
		return madElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadFactory getMadFactory() {
		return (MadFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		rootEClass = createEClass(ROOT);
		createEReference(rootEClass, ROOT__MAD_ELEMENT);

		madAttributeEClass = createEClass(MAD_ATTRIBUTE);
		createEAttribute(madAttributeEClass, MAD_ATTRIBUTE__NAME);
		createEReference(madAttributeEClass, MAD_ATTRIBUTE__VALUE_FEATURE);
		createEReference(madAttributeEClass, MAD_ATTRIBUTE__VALUE_OWNER);

		madStringAttributeEClass = createEClass(MAD_STRING_ATTRIBUTE);
		createEAttribute(madStringAttributeEClass, MAD_STRING_ATTRIBUTE__VALUE);

		madBooleanAttributeEClass = createEClass(MAD_BOOLEAN_ATTRIBUTE);
		createEAttribute(madBooleanAttributeEClass, MAD_BOOLEAN_ATTRIBUTE__VALUE);

		madEnumAttributeEClass = createEClass(MAD_ENUM_ATTRIBUTE);
		createEReference(madEnumAttributeEClass, MAD_ENUM_ATTRIBUTE__VALUE);
		createEReference(madEnumAttributeEClass, MAD_ENUM_ATTRIBUTE__CANDIDATES);

		madSingleObjectAttributeEClass = createEClass(MAD_SINGLE_OBJECT_ATTRIBUTE);
		createEReference(madSingleObjectAttributeEClass, MAD_SINGLE_OBJECT_ATTRIBUTE__VALUE);
		createEReference(madSingleObjectAttributeEClass, MAD_SINGLE_OBJECT_ATTRIBUTE__CANDIDATES);

		madMultiObjectAttributeEClass = createEClass(MAD_MULTI_OBJECT_ATTRIBUTE);
		createEReference(madMultiObjectAttributeEClass, MAD_MULTI_OBJECT_ATTRIBUTE__VALUE);
		createEReference(madMultiObjectAttributeEClass, MAD_MULTI_OBJECT_ATTRIBUTE__CANDIDATES);

		madCollectionEClass = createEClass(MAD_COLLECTION);
		createEReference(madCollectionEClass, MAD_COLLECTION__ITEMS);
		createEReference(madCollectionEClass, MAD_COLLECTION__ITEM_TYPE);

		madElementEClass = createEClass(MAD_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		madAttributeEClass.getESuperTypes().add(this.getMadElement());
		madStringAttributeEClass.getESuperTypes().add(this.getMadAttribute());
		madBooleanAttributeEClass.getESuperTypes().add(this.getMadAttribute());
		madEnumAttributeEClass.getESuperTypes().add(this.getMadAttribute());
		madSingleObjectAttributeEClass.getESuperTypes().add(this.getMadAttribute());
		madMultiObjectAttributeEClass.getESuperTypes().add(this.getMadAttribute());
		madCollectionEClass.getESuperTypes().add(this.getMadElement());

		// Initialize classes and features; add operations and parameters
		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoot_MadElement(), this.getMadElement(), null, "madElement", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(madAttributeEClass, MadAttribute.class, "MadAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMadAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, MadAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMadAttribute_ValueFeature(), theEcorePackage.getEStructuralFeature(), null, "valueFeature", null, 0, 1, MadAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMadAttribute_ValueOwner(), theEcorePackage.getEObject(), null, "valueOwner", null, 0, 1, MadAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(madAttributeEClass, ecorePackage.getEJavaObject(), "getAttributeValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(madStringAttributeEClass, MadStringAttribute.class, "MadStringAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMadStringAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, MadStringAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(madBooleanAttributeEClass, MadBooleanAttribute.class, "MadBooleanAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMadBooleanAttribute_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, MadBooleanAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(madEnumAttributeEClass, MadEnumAttribute.class, "MadEnumAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMadEnumAttribute_Value(), theEcorePackage.getEEnumLiteral(), null, "value", null, 0, 1, MadEnumAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMadEnumAttribute_Candidates(), theEcorePackage.getEEnumLiteral(), null, "candidates", null, 0, -1, MadEnumAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(madSingleObjectAttributeEClass, MadSingleObjectAttribute.class, "MadSingleObjectAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMadSingleObjectAttribute_Value(), theEcorePackage.getEObject(), null, "value", null, 0, 1, MadSingleObjectAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMadSingleObjectAttribute_Candidates(), theEcorePackage.getEObject(), null, "candidates", null, 0, -1, MadSingleObjectAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(madMultiObjectAttributeEClass, MadMultiObjectAttribute.class, "MadMultiObjectAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMadMultiObjectAttribute_Value(), theEcorePackage.getEObject(), null, "value", null, 0, -1, MadMultiObjectAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMadMultiObjectAttribute_Candidates(), theEcorePackage.getEObject(), null, "candidates", null, 0, -1, MadMultiObjectAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(madCollectionEClass, MadCollection.class, "MadCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMadCollection_Items(), theEcorePackage.getEObject(), null, "items", null, 0, -1, MadCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMadCollection_ItemType(), theEcorePackage.getEClass(), null, "itemType", null, 0, 1, MadCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(madElementEClass, MadElement.class, "MadElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //MadPackageImpl
