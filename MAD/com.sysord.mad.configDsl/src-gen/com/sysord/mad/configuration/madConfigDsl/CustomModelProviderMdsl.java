/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Model Provider Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl#getClassDescriptor <em>Class Descriptor</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCustomModelProviderMdsl()
 * @model
 * @generated
 */
public interface CustomModelProviderMdsl extends ModelProviderMdsl
{
  /**
   * Returns the value of the '<em><b>Class Descriptor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Descriptor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Descriptor</em>' containment reference.
   * @see #setClassDescriptor(ClassDescriptorMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCustomModelProviderMdsl_ClassDescriptor()
   * @model containment="true"
   * @generated
   */
  ClassDescriptorMdsl getClassDescriptor();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl#getClassDescriptor <em>Class Descriptor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Descriptor</em>' containment reference.
   * @see #getClassDescriptor()
   * @generated
   */
  void setClassDescriptor(ClassDescriptorMdsl value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' attribute list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCustomModelProviderMdsl_Parameters()
   * @model unique="false"
   * @generated
   */
  EList<String> getParameters();

} // CustomModelProviderMdsl
