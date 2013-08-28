/**
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.FormatExpr;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.QueryUsage;
import com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validator Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ValidatorMdslImpl#getValidationQuery <em>Validation Query</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ValidatorMdslImpl#isI18NMessage <em>I18N Message</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ValidatorMdslImpl#getErrorMessageExpr <em>Error Message Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValidatorMdslImpl extends MinimalEObjectImpl.Container implements ValidatorMdsl
{
  /**
   * The cached value of the '{@link #getValidationQuery() <em>Validation Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidationQuery()
   * @generated
   * @ordered
   */
  protected QueryUsage validationQuery;

  /**
   * The default value of the '{@link #isI18NMessage() <em>I18N Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NMessage()
   * @generated
   * @ordered
   */
  protected static final boolean I18_NMESSAGE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isI18NMessage() <em>I18N Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NMessage()
   * @generated
   * @ordered
   */
  protected boolean i18NMessage = I18_NMESSAGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getErrorMessageExpr() <em>Error Message Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorMessageExpr()
   * @generated
   * @ordered
   */
  protected FormatExpr errorMessageExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValidatorMdslImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MadConfigDslPackage.Literals.VALIDATOR_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryUsage getValidationQuery()
  {
    return validationQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValidationQuery(QueryUsage newValidationQuery, NotificationChain msgs)
  {
    QueryUsage oldValidationQuery = validationQuery;
    validationQuery = newValidationQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.VALIDATOR_MDSL__VALIDATION_QUERY, oldValidationQuery, newValidationQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValidationQuery(QueryUsage newValidationQuery)
  {
    if (newValidationQuery != validationQuery)
    {
      NotificationChain msgs = null;
      if (validationQuery != null)
        msgs = ((InternalEObject)validationQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.VALIDATOR_MDSL__VALIDATION_QUERY, null, msgs);
      if (newValidationQuery != null)
        msgs = ((InternalEObject)newValidationQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.VALIDATOR_MDSL__VALIDATION_QUERY, null, msgs);
      msgs = basicSetValidationQuery(newValidationQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.VALIDATOR_MDSL__VALIDATION_QUERY, newValidationQuery, newValidationQuery));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isI18NMessage()
  {
    return i18NMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setI18NMessage(boolean newI18NMessage)
  {
    boolean oldI18NMessage = i18NMessage;
    i18NMessage = newI18NMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.VALIDATOR_MDSL__I18_NMESSAGE, oldI18NMessage, i18NMessage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormatExpr getErrorMessageExpr()
  {
    return errorMessageExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetErrorMessageExpr(FormatExpr newErrorMessageExpr, NotificationChain msgs)
  {
    FormatExpr oldErrorMessageExpr = errorMessageExpr;
    errorMessageExpr = newErrorMessageExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.VALIDATOR_MDSL__ERROR_MESSAGE_EXPR, oldErrorMessageExpr, newErrorMessageExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrorMessageExpr(FormatExpr newErrorMessageExpr)
  {
    if (newErrorMessageExpr != errorMessageExpr)
    {
      NotificationChain msgs = null;
      if (errorMessageExpr != null)
        msgs = ((InternalEObject)errorMessageExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.VALIDATOR_MDSL__ERROR_MESSAGE_EXPR, null, msgs);
      if (newErrorMessageExpr != null)
        msgs = ((InternalEObject)newErrorMessageExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.VALIDATOR_MDSL__ERROR_MESSAGE_EXPR, null, msgs);
      msgs = basicSetErrorMessageExpr(newErrorMessageExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.VALIDATOR_MDSL__ERROR_MESSAGE_EXPR, newErrorMessageExpr, newErrorMessageExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.VALIDATOR_MDSL__VALIDATION_QUERY:
        return basicSetValidationQuery(null, msgs);
      case MadConfigDslPackage.VALIDATOR_MDSL__ERROR_MESSAGE_EXPR:
        return basicSetErrorMessageExpr(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.VALIDATOR_MDSL__VALIDATION_QUERY:
        return getValidationQuery();
      case MadConfigDslPackage.VALIDATOR_MDSL__I18_NMESSAGE:
        return isI18NMessage();
      case MadConfigDslPackage.VALIDATOR_MDSL__ERROR_MESSAGE_EXPR:
        return getErrorMessageExpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.VALIDATOR_MDSL__VALIDATION_QUERY:
        setValidationQuery((QueryUsage)newValue);
        return;
      case MadConfigDslPackage.VALIDATOR_MDSL__I18_NMESSAGE:
        setI18NMessage((Boolean)newValue);
        return;
      case MadConfigDslPackage.VALIDATOR_MDSL__ERROR_MESSAGE_EXPR:
        setErrorMessageExpr((FormatExpr)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.VALIDATOR_MDSL__VALIDATION_QUERY:
        setValidationQuery((QueryUsage)null);
        return;
      case MadConfigDslPackage.VALIDATOR_MDSL__I18_NMESSAGE:
        setI18NMessage(I18_NMESSAGE_EDEFAULT);
        return;
      case MadConfigDslPackage.VALIDATOR_MDSL__ERROR_MESSAGE_EXPR:
        setErrorMessageExpr((FormatExpr)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.VALIDATOR_MDSL__VALIDATION_QUERY:
        return validationQuery != null;
      case MadConfigDslPackage.VALIDATOR_MDSL__I18_NMESSAGE:
        return i18NMessage != I18_NMESSAGE_EDEFAULT;
      case MadConfigDslPackage.VALIDATOR_MDSL__ERROR_MESSAGE_EXPR:
        return errorMessageExpr != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (i18NMessage: ");
    result.append(i18NMessage);
    result.append(')');
    return result.toString();
  }

} //ValidatorMdslImpl
