/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Query Call Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl#getExternalQuery <em>External Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getExternalQueryCallMdsl()
 * @model
 * @generated
 */
public interface ExternalQueryCallMdsl extends EObject
{
  /**
   * Returns the value of the '<em><b>External Query</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External Query</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External Query</em>' reference.
   * @see #setExternalQuery(EObject)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getExternalQueryCallMdsl_ExternalQuery()
   * @model
   * @generated
   */
  EObject getExternalQuery();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl#getExternalQuery <em>External Query</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>External Query</em>' reference.
   * @see #getExternalQuery()
   * @generated
   */
  void setExternalQuery(EObject value);

} // ExternalQueryCallMdsl
