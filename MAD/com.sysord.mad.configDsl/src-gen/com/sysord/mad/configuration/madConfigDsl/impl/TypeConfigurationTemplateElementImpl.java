/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.QueryUsage;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Configuration Template Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationTemplateElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationTemplateElementImpl#getValueQuery <em>Value Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeConfigurationTemplateElementImpl extends MinimalEObjectImpl.Container implements TypeConfigurationTemplateElement
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getValueQuery() <em>Value Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueQuery()
   * @generated
   * @ordered
   */
  protected QueryUsage valueQuery;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeConfigurationTemplateElementImpl()
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
    return MadConfigDslPackage.Literals.TYPE_CONFIGURATION_TEMPLATE_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryUsage getValueQuery()
  {
    return valueQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueQuery(QueryUsage newValueQuery, NotificationChain msgs)
  {
    QueryUsage oldValueQuery = valueQuery;
    valueQuery = newValueQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY, oldValueQuery, newValueQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueQuery(QueryUsage newValueQuery)
  {
    if (newValueQuery != valueQuery)
    {
      NotificationChain msgs = null;
      if (valueQuery != null)
        msgs = ((InternalEObject)valueQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY, null, msgs);
      if (newValueQuery != null)
        msgs = ((InternalEObject)newValueQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY, null, msgs);
      msgs = basicSetValueQuery(newValueQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY, newValueQuery, newValueQuery));
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
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY:
        return basicSetValueQuery(null, msgs);
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
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME:
        return getName();
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY:
        return getValueQuery();
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
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME:
        setName((String)newValue);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY:
        setValueQuery((QueryUsage)newValue);
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
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY:
        setValueQuery((QueryUsage)null);
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
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY:
        return valueQuery != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //TypeConfigurationTemplateElementImpl
