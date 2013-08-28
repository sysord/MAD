/**
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.PropertyMdsl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.PropertyMdsl#getPropertyValue <em>Property Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getPropertyMdsl()
 * @model
 * @generated
 */
public interface PropertyMdsl extends EObject
{
  /**
   * Returns the value of the '<em><b>Property Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Name</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Name</em>' reference.
   * @see #setPropertyName(PropertyTypeMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getPropertyMdsl_PropertyName()
   * @model
   * @generated
   */
  PropertyTypeMdsl getPropertyName();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.PropertyMdsl#getPropertyName <em>Property Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Name</em>' reference.
   * @see #getPropertyName()
   * @generated
   */
  void setPropertyName(PropertyTypeMdsl value);

  /**
   * Returns the value of the '<em><b>Property Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Value</em>' containment reference.
   * @see #setPropertyValue(PropertyValueMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getPropertyMdsl_PropertyValue()
   * @model containment="true"
   * @generated
   */
  PropertyValueMdsl getPropertyValue();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.PropertyMdsl#getPropertyValue <em>Property Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Value</em>' containment reference.
   * @see #getPropertyValue()
   * @generated
   */
  void setPropertyValue(PropertyValueMdsl value);

} // PropertyMdsl
