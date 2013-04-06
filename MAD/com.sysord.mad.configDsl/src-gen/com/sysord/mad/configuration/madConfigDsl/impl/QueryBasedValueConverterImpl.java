/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter;
import com.sysord.mad.configuration.madConfigDsl.QueryUsage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Based Value Converter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryBasedValueConverterImpl#getConverterQuery <em>Converter Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryBasedValueConverterImpl extends ValueConverterImpl implements QueryBasedValueConverter
{
  /**
   * The cached value of the '{@link #getConverterQuery() <em>Converter Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConverterQuery()
   * @generated
   * @ordered
   */
  protected QueryUsage converterQuery;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QueryBasedValueConverterImpl()
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
    return MadConfigDslPackage.Literals.QUERY_BASED_VALUE_CONVERTER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryUsage getConverterQuery()
  {
    return converterQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConverterQuery(QueryUsage newConverterQuery, NotificationChain msgs)
  {
    QueryUsage oldConverterQuery = converterQuery;
    converterQuery = newConverterQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY, oldConverterQuery, newConverterQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConverterQuery(QueryUsage newConverterQuery)
  {
    if (newConverterQuery != converterQuery)
    {
      NotificationChain msgs = null;
      if (converterQuery != null)
        msgs = ((InternalEObject)converterQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY, null, msgs);
      if (newConverterQuery != null)
        msgs = ((InternalEObject)newConverterQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY, null, msgs);
      msgs = basicSetConverterQuery(newConverterQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY, newConverterQuery, newConverterQuery));
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
      case MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY:
        return basicSetConverterQuery(null, msgs);
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
      case MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY:
        return getConverterQuery();
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
      case MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY:
        setConverterQuery((QueryUsage)newValue);
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
      case MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY:
        setConverterQuery((QueryUsage)null);
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
      case MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY:
        return converterQuery != null;
    }
    return super.eIsSet(featureID);
  }

} //QueryBasedValueConverterImpl
