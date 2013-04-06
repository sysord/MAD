/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Evaluator Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getClassDescriptor <em>Class Descriptor</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getQueryPropertiesTypes <em>Query Properties Types</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getExtQServiceClassDescriptor <em>Ext QService Class Descriptor</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryEvaluatorMdsl()
 * @model
 * @generated
 */
public interface QueryEvaluatorMdsl extends MADConfigElement
{
  /**
   * Returns the value of the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label</em>' attribute.
   * @see #setLabel(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryEvaluatorMdsl_Label()
   * @model
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryEvaluatorMdsl_ClassDescriptor()
   * @model containment="true"
   * @generated
   */
  ClassDescriptorMdsl getClassDescriptor();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getClassDescriptor <em>Class Descriptor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Descriptor</em>' containment reference.
   * @see #getClassDescriptor()
   * @generated
   */
  void setClassDescriptor(ClassDescriptorMdsl value);

  /**
   * Returns the value of the '<em><b>Query Properties Types</b></em>' containment reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query Properties Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Query Properties Types</em>' containment reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryEvaluatorMdsl_QueryPropertiesTypes()
   * @model containment="true"
   * @generated
   */
  EList<PropertyTypeMdsl> getQueryPropertiesTypes();

  /**
   * Returns the value of the '<em><b>Ext QService Class Descriptor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ext QService Class Descriptor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ext QService Class Descriptor</em>' containment reference.
   * @see #setExtQServiceClassDescriptor(ClassDescriptorMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryEvaluatorMdsl_ExtQServiceClassDescriptor()
   * @model containment="true"
   * @generated
   */
  ClassDescriptorMdsl getExtQServiceClassDescriptor();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getExtQServiceClassDescriptor <em>Ext QService Class Descriptor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ext QService Class Descriptor</em>' containment reference.
   * @see #getExtQServiceClassDescriptor()
   * @generated
   */
  void setExtQServiceClassDescriptor(ClassDescriptorMdsl value);

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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryEvaluatorMdsl_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

} // QueryEvaluatorMdsl
