/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Macro Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TextMacroRef#getReferenced <em>Referenced</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTextMacroRef()
 * @model
 * @generated
 */
public interface TextMacroRef extends PropValueExprFragment, QueryFragment, FormatExprFragment
{
  /**
   * Returns the value of the '<em><b>Referenced</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced</em>' reference.
   * @see #setReferenced(TextMacro)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTextMacroRef_Referenced()
   * @model
   * @generated
   */
  TextMacro getReferenced();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TextMacroRef#getReferenced <em>Referenced</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced</em>' reference.
   * @see #getReferenced()
   * @generated
   */
  void setReferenced(TextMacro value);

} // TextMacroRef
