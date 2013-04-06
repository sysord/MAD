/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Query Call Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ExternalQueryCallMdslImpl#getExternalQuery <em>External Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalQueryCallMdslImpl extends MinimalEObjectImpl.Container implements ExternalQueryCallMdsl
{
  /**
   * The cached value of the '{@link #getExternalQuery() <em>External Query</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExternalQuery()
   * @generated
   * @ordered
   */
  protected EObject externalQuery;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExternalQueryCallMdslImpl()
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
    return MadConfigDslPackage.Literals.EXTERNAL_QUERY_CALL_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getExternalQuery()
  {
    if (externalQuery != null && externalQuery.eIsProxy())
    {
      InternalEObject oldExternalQuery = (InternalEObject)externalQuery;
      externalQuery = eResolveProxy(oldExternalQuery);
      if (externalQuery != oldExternalQuery)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY, oldExternalQuery, externalQuery));
      }
    }
    return externalQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetExternalQuery()
  {
    return externalQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExternalQuery(EObject newExternalQuery)
  {
    EObject oldExternalQuery = externalQuery;
    externalQuery = newExternalQuery;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY, oldExternalQuery, externalQuery));
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
      case MadConfigDslPackage.EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY:
        if (resolve) return getExternalQuery();
        return basicGetExternalQuery();
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
      case MadConfigDslPackage.EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY:
        setExternalQuery((EObject)newValue);
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
      case MadConfigDslPackage.EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY:
        setExternalQuery((EObject)null);
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
      case MadConfigDslPackage.EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY:
        return externalQuery != null;
    }
    return super.eIsSet(featureID);
  }

} //ExternalQueryCallMdslImpl
