/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Configuration Template Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement#getValueQuery <em>Value Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationTemplateElement()
 * @model
 * @generated
 */
public interface TypeConfigurationTemplateElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationTemplateElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Query</em>' containment reference.
   * @see #setValueQuery(QueryUsage)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationTemplateElement_ValueQuery()
   * @model containment="true"
   * @generated
   */
  QueryUsage getValueQuery();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement#getValueQuery <em>Value Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Query</em>' containment reference.
   * @see #getValueQuery()
   * @generated
   */
  void setValueQuery(QueryUsage value);

} // TypeConfigurationTemplateElement
