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
package com.sysord.mad.util;

import com.sysord.mad.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.sysord.mad.MadPackage
 * @generated
 */
public class MadSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MadPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MadSwitch() {
		if (modelPackage == null) {
			modelPackage = MadPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MadPackage.ROOT: {
				Root root = (Root)theEObject;
				T result = caseRoot(root);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MadPackage.MAD_ATTRIBUTE: {
				MadAttribute madAttribute = (MadAttribute)theEObject;
				T result = caseMadAttribute(madAttribute);
				if (result == null) result = caseMadElement(madAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MadPackage.MAD_STRING_ATTRIBUTE: {
				MadStringAttribute madStringAttribute = (MadStringAttribute)theEObject;
				T result = caseMadStringAttribute(madStringAttribute);
				if (result == null) result = caseMadAttribute(madStringAttribute);
				if (result == null) result = caseMadElement(madStringAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MadPackage.MAD_BOOLEAN_ATTRIBUTE: {
				MadBooleanAttribute madBooleanAttribute = (MadBooleanAttribute)theEObject;
				T result = caseMadBooleanAttribute(madBooleanAttribute);
				if (result == null) result = caseMadAttribute(madBooleanAttribute);
				if (result == null) result = caseMadElement(madBooleanAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MadPackage.MAD_ENUM_ATTRIBUTE: {
				MadEnumAttribute madEnumAttribute = (MadEnumAttribute)theEObject;
				T result = caseMadEnumAttribute(madEnumAttribute);
				if (result == null) result = caseMadAttribute(madEnumAttribute);
				if (result == null) result = caseMadElement(madEnumAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MadPackage.MAD_SINGLE_OBJECT_ATTRIBUTE: {
				MadSingleObjectAttribute madSingleObjectAttribute = (MadSingleObjectAttribute)theEObject;
				T result = caseMadSingleObjectAttribute(madSingleObjectAttribute);
				if (result == null) result = caseMadAttribute(madSingleObjectAttribute);
				if (result == null) result = caseMadElement(madSingleObjectAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MadPackage.MAD_MULTI_OBJECT_ATTRIBUTE: {
				MadMultiObjectAttribute madMultiObjectAttribute = (MadMultiObjectAttribute)theEObject;
				T result = caseMadMultiObjectAttribute(madMultiObjectAttribute);
				if (result == null) result = caseMadAttribute(madMultiObjectAttribute);
				if (result == null) result = caseMadElement(madMultiObjectAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MadPackage.MAD_COLLECTION: {
				MadCollection madCollection = (MadCollection)theEObject;
				T result = caseMadCollection(madCollection);
				if (result == null) result = caseMadElement(madCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MadPackage.MAD_ELEMENT: {
				MadElement madElement = (MadElement)theEObject;
				T result = caseMadElement(madElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoot(Root object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMadAttribute(MadAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMadStringAttribute(MadStringAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMadBooleanAttribute(MadBooleanAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMadEnumAttribute(MadEnumAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Object Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Object Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMadSingleObjectAttribute(MadSingleObjectAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Object Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Object Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMadMultiObjectAttribute(MadMultiObjectAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMadCollection(MadCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMadElement(MadElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MadSwitch
