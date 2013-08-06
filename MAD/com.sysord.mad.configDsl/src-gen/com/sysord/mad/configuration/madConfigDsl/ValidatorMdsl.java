/**
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validator Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#getValidationQuery <em>Validation Query</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#isI18NMessage <em>I18N Message</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#getErrorMessageExpr <em>Error Message Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getValidatorMdsl()
 * @model
 * @generated
 */
public interface ValidatorMdsl extends EObject
{
  /**
   * Returns the value of the '<em><b>Validation Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Validation Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Validation Query</em>' containment reference.
   * @see #setValidationQuery(QueryUsage)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getValidatorMdsl_ValidationQuery()
   * @model containment="true"
   * @generated
   */
  QueryUsage getValidationQuery();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#getValidationQuery <em>Validation Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Validation Query</em>' containment reference.
   * @see #getValidationQuery()
   * @generated
   */
  void setValidationQuery(QueryUsage value);

  /**
   * Returns the value of the '<em><b>I18N Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>I18N Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>I18N Message</em>' attribute.
   * @see #setI18NMessage(boolean)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getValidatorMdsl_I18NMessage()
   * @model
   * @generated
   */
  boolean isI18NMessage();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#isI18NMessage <em>I18N Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>I18N Message</em>' attribute.
   * @see #isI18NMessage()
   * @generated
   */
  void setI18NMessage(boolean value);

  /**
   * Returns the value of the '<em><b>Error Message Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error Message Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error Message Expr</em>' containment reference.
   * @see #setErrorMessageExpr(FormatExpr)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getValidatorMdsl_ErrorMessageExpr()
   * @model containment="true"
   * @generated
   */
  FormatExpr getErrorMessageExpr();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#getErrorMessageExpr <em>Error Message Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error Message Expr</em>' containment reference.
   * @see #getErrorMessageExpr()
   * @generated
   */
  void setErrorMessageExpr(FormatExpr value);

} // ValidatorMdsl
