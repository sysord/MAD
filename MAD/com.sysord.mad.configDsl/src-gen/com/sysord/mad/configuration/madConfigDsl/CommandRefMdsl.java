/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command Ref Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#getReferenced <em>Referenced</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#isI18NLabelOverride <em>I18N Label Override</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#getLabelOverride <em>Label Override</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandRefMdsl()
 * @model
 * @generated
 */
public interface CommandRefMdsl extends CommandMdsl
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
   * @see #setReferenced(CommandDeclaration)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandRefMdsl_Referenced()
   * @model
   * @generated
   */
  CommandDeclaration getReferenced();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#getReferenced <em>Referenced</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced</em>' reference.
   * @see #getReferenced()
   * @generated
   */
  void setReferenced(CommandDeclaration value);

  /**
   * Returns the value of the '<em><b>I18N Label Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>I18N Label Override</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>I18N Label Override</em>' attribute.
   * @see #setI18NLabelOverride(boolean)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandRefMdsl_I18NLabelOverride()
   * @model
   * @generated
   */
  boolean isI18NLabelOverride();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#isI18NLabelOverride <em>I18N Label Override</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>I18N Label Override</em>' attribute.
   * @see #isI18NLabelOverride()
   * @generated
   */
  void setI18NLabelOverride(boolean value);

  /**
   * Returns the value of the '<em><b>Label Override</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label Override</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label Override</em>' containment reference.
   * @see #setLabelOverride(FormatExpr)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandRefMdsl_LabelOverride()
   * @model containment="true"
   * @generated
   */
  FormatExpr getLabelOverride();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#getLabelOverride <em>Label Override</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label Override</em>' containment reference.
   * @see #getLabelOverride()
   * @generated
   */
  void setLabelOverride(FormatExpr value);

} // CommandRefMdsl
