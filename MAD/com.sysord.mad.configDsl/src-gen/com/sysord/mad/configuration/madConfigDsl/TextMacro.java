/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Macro</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getDescription <em>Description</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getMacroValue <em>Macro Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTextMacro()
 * @model
 * @generated
 */
public interface TextMacro extends MADConfigElement
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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTextMacro_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTextMacro_Label()
   * @model
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTextMacro_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Macro Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macro Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macro Value</em>' attribute.
   * @see #setMacroValue(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTextMacro_MacroValue()
   * @model
   * @generated
   */
  String getMacroValue();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getMacroValue <em>Macro Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Macro Value</em>' attribute.
   * @see #getMacroValue()
   * @generated
   */
  void setMacroValue(String value);

} // TextMacro
