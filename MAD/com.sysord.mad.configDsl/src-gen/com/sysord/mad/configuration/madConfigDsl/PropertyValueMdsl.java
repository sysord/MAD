/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Value Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.PropertyValueMdsl#getFragments <em>Fragments</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getPropertyValueMdsl()
 * @model
 * @generated
 */
public interface PropertyValueMdsl extends EObject
{
  /**
   * Returns the value of the '<em><b>Fragments</b></em>' containment reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.PropValueExprFragment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fragments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fragments</em>' containment reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getPropertyValueMdsl_Fragments()
   * @model containment="true"
   * @generated
   */
  EList<PropValueExprFragment> getFragments();

} // PropertyValueMdsl
