/**
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Descriptor Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl#getPluginId <em>Plugin Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getClassDescriptorMdsl()
 * @model
 * @generated
 */
public interface ClassDescriptorMdsl extends EObject
{
  /**
   * Returns the value of the '<em><b>Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Name</em>' attribute.
   * @see #setClassName(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getClassDescriptorMdsl_ClassName()
   * @model
   * @generated
   */
  String getClassName();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl#getClassName <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Name</em>' attribute.
   * @see #getClassName()
   * @generated
   */
  void setClassName(String value);

  /**
   * Returns the value of the '<em><b>Plugin Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plugin Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plugin Id</em>' attribute.
   * @see #setPluginId(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getClassDescriptorMdsl_PluginId()
   * @model
   * @generated
   */
  String getPluginId();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl#getPluginId <em>Plugin Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Plugin Id</em>' attribute.
   * @see #getPluginId()
   * @generated
   */
  void setPluginId(String value);

} // ClassDescriptorMdsl
