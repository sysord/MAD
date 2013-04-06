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

import com.sysord.mad.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MadFactoryImpl extends EFactoryImpl implements MadFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MadFactory init() {
		try {
			MadFactory theMadFactory = (MadFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.sysord.com/mad"); 
			if (theMadFactory != null) {
				return theMadFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MadFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MadPackage.ROOT: return createRoot();
			case MadPackage.MAD_STRING_ATTRIBUTE: return createMadStringAttribute();
			case MadPackage.MAD_BOOLEAN_ATTRIBUTE: return createMadBooleanAttribute();
			case MadPackage.MAD_ENUM_ATTRIBUTE: return createMadEnumAttribute();
			case MadPackage.MAD_SINGLE_OBJECT_ATTRIBUTE: return createMadSingleObjectAttribute();
			case MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE: return createMadMultiObjectAttribute();
			case MadPackage.MAD_COLLECTION: return createMadCollection();
			case MadPackage.MAD_ELEMENT: return createMadElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root createRoot() {
		RootImpl root = new RootImpl();
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadStringAttribute createMadStringAttribute() {
		MadStringAttributeImpl madStringAttribute = new MadStringAttributeImpl();
		return madStringAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadBooleanAttribute createMadBooleanAttribute() {
		MadBooleanAttributeImpl madBooleanAttribute = new MadBooleanAttributeImpl();
		return madBooleanAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadEnumAttribute createMadEnumAttribute() {
		MadEnumAttributeImpl madEnumAttribute = new MadEnumAttributeImpl();
		return madEnumAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadSingleObjectAttribute createMadSingleObjectAttribute() {
		MadSingleObjectAttributeImpl madSingleObjectAttribute = new MadSingleObjectAttributeImpl();
		return madSingleObjectAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadMultiObjectAttribute createMadMultiObjectAttribute() {
		MadMultiObjectAttributeImpl madMultiObjectAttribute = new MadMultiObjectAttributeImpl();
		return madMultiObjectAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadCollection createMadCollection() {
		MadCollectionImpl madCollection = new MadCollectionImpl();
		return madCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadElement createMadElement() {
		MadElementImpl madElement = new MadElementImpl();
		return madElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadPackage getMadPackage() {
		return (MadPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MadPackage getPackage() {
		return MadPackage.eINSTANCE;
	}

} //MadFactoryImpl
