/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#isI18NLabel <em>I18N Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getLabelFormatExpr <em>Label Format Expr</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getSubLayers <em>Sub Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getLayerMdsl()
 * @model
 * @generated
 */
public interface LayerMdsl extends MADConfigElement
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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getLayerMdsl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>I18N Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>I18N Label</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>I18N Label</em>' attribute.
   * @see #setI18NLabel(boolean)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getLayerMdsl_I18NLabel()
   * @model
   * @generated
   */
  boolean isI18NLabel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#isI18NLabel <em>I18N Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>I18N Label</em>' attribute.
   * @see #isI18NLabel()
   * @generated
   */
  void setI18NLabel(boolean value);

  /**
   * Returns the value of the '<em><b>Label Format Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label Format Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label Format Expr</em>' containment reference.
   * @see #setLabelFormatExpr(FormatExpr)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getLayerMdsl_LabelFormatExpr()
   * @model containment="true"
   * @generated
   */
  FormatExpr getLabelFormatExpr();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getLabelFormatExpr <em>Label Format Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label Format Expr</em>' containment reference.
   * @see #getLabelFormatExpr()
   * @generated
   */
  void setLabelFormatExpr(FormatExpr value);

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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getLayerMdsl_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Sub Layers</b></em>' containment reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Layers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Layers</em>' containment reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getLayerMdsl_SubLayers()
   * @model containment="true"
   * @generated
   */
  EList<LayerMdsl> getSubLayers();

} // LayerMdsl
