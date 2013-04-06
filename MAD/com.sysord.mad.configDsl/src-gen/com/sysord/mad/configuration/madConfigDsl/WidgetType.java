/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getCategory <em>Category</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getClassDescriptor <em>Class Descriptor</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetType()
 * @model
 * @generated
 */
public interface WidgetType extends MADConfigElement
{
  /**
   * Returns the value of the '<em><b>Category</b></em>' attribute.
   * The literals are from the enumeration {@link com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' attribute.
   * @see com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL
   * @see #setCategory(WIDGET_CATEGORY_MDSL)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetType_Category()
   * @model
   * @generated
   */
  WIDGET_CATEGORY_MDSL getCategory();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getCategory <em>Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Category</em>' attribute.
   * @see com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL
   * @see #getCategory()
   * @generated
   */
  void setCategory(WIDGET_CATEGORY_MDSL value);

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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetType_Label()
   * @model
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getLabel <em>Label</em>}' attribute.
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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetType_ClassDescriptor()
   * @model containment="true"
   * @generated
   */
  ClassDescriptorMdsl getClassDescriptor();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getClassDescriptor <em>Class Descriptor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Descriptor</em>' containment reference.
   * @see #getClassDescriptor()
   * @generated
   */
  void setClassDescriptor(ClassDescriptorMdsl value);

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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetType_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

} // WidgetType
