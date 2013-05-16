/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Icon Descriptor Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getBundleDescriptor <em>Bundle Descriptor</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getBundleUri <em>Bundle Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getIconDescriptorMdsl()
 * @model
 * @generated
 */
public interface IconDescriptorMdsl extends MADConfigElement
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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getIconDescriptorMdsl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getIconDescriptorMdsl_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Bundle Descriptor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bundle Descriptor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bundle Descriptor</em>' containment reference.
   * @see #setBundleDescriptor(ClassDescriptorMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getIconDescriptorMdsl_BundleDescriptor()
   * @model containment="true"
   * @generated
   */
  ClassDescriptorMdsl getBundleDescriptor();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getBundleDescriptor <em>Bundle Descriptor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bundle Descriptor</em>' containment reference.
   * @see #getBundleDescriptor()
   * @generated
   */
  void setBundleDescriptor(ClassDescriptorMdsl value);

  /**
   * Returns the value of the '<em><b>Bundle Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bundle Uri</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bundle Uri</em>' attribute.
   * @see #setBundleUri(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getIconDescriptorMdsl_BundleUri()
   * @model
   * @generated
   */
  String getBundleUri();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getBundleUri <em>Bundle Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bundle Uri</em>' attribute.
   * @see #getBundleUri()
   * @generated
   */
  void setBundleUri(String value);

} // IconDescriptorMdsl
