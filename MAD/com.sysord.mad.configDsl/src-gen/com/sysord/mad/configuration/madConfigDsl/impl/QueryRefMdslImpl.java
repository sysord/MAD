/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.QueryDeclaration;
import com.sysord.mad.configuration.madConfigDsl.QueryRefMdsl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Ref Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryRefMdslImpl#getReferenced <em>Referenced</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryRefMdslImpl extends QueryMdslImpl implements QueryRefMdsl
{
  /**
   * The cached value of the '{@link #getReferenced() <em>Referenced</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenced()
   * @generated
   * @ordered
   */
  protected QueryDeclaration referenced;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QueryRefMdslImpl()
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
    return MadConfigDslPackage.Literals.QUERY_REF_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryDeclaration getReferenced()
  {
    if (referenced != null && referenced.eIsProxy())
    {
      InternalEObject oldReferenced = (InternalEObject)referenced;
      referenced = (QueryDeclaration)eResolveProxy(oldReferenced);
      if (referenced != oldReferenced)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.QUERY_REF_MDSL__REFERENCED, oldReferenced, referenced));
      }
    }
    return referenced;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryDeclaration basicGetReferenced()
  {
    return referenced;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferenced(QueryDeclaration newReferenced)
  {
    QueryDeclaration oldReferenced = referenced;
    referenced = newReferenced;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_REF_MDSL__REFERENCED, oldReferenced, referenced));
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
      case MadConfigDslPackage.QUERY_REF_MDSL__REFERENCED:
        if (resolve) return getReferenced();
        return basicGetReferenced();
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
      case MadConfigDslPackage.QUERY_REF_MDSL__REFERENCED:
        setReferenced((QueryDeclaration)newValue);
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
      case MadConfigDslPackage.QUERY_REF_MDSL__REFERENCED:
        setReferenced((QueryDeclaration)null);
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
      case MadConfigDslPackage.QUERY_REF_MDSL__REFERENCED:
        return referenced != null;
    }
    return super.eIsSet(featureID);
  }

} //QueryRefMdslImpl
