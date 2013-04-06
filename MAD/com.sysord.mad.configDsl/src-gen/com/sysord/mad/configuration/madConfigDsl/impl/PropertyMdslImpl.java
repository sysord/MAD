/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.PropertyMdsl;
import com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl;
import com.sysord.mad.configuration.madConfigDsl.PropertyValueMdsl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.PropertyMdslImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.PropertyMdslImpl#getPropertyValue <em>Property Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyMdslImpl extends MinimalEObjectImpl.Container implements PropertyMdsl
{
  /**
   * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyName()
   * @generated
   * @ordered
   */
  protected PropertyTypeMdsl propertyName;

  /**
   * The cached value of the '{@link #getPropertyValue() <em>Property Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyValue()
   * @generated
   * @ordered
   */
  protected PropertyValueMdsl propertyValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyMdslImpl()
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
    return MadConfigDslPackage.Literals.PROPERTY_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyTypeMdsl getPropertyName()
  {
    if (propertyName != null && propertyName.eIsProxy())
    {
      InternalEObject oldPropertyName = (InternalEObject)propertyName;
      propertyName = (PropertyTypeMdsl)eResolveProxy(oldPropertyName);
      if (propertyName != oldPropertyName)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_NAME, oldPropertyName, propertyName));
      }
    }
    return propertyName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyTypeMdsl basicGetPropertyName()
  {
    return propertyName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPropertyName(PropertyTypeMdsl newPropertyName)
  {
    PropertyTypeMdsl oldPropertyName = propertyName;
    propertyName = newPropertyName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_NAME, oldPropertyName, propertyName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyValueMdsl getPropertyValue()
  {
    return propertyValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPropertyValue(PropertyValueMdsl newPropertyValue, NotificationChain msgs)
  {
    PropertyValueMdsl oldPropertyValue = propertyValue;
    propertyValue = newPropertyValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_VALUE, oldPropertyValue, newPropertyValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPropertyValue(PropertyValueMdsl newPropertyValue)
  {
    if (newPropertyValue != propertyValue)
    {
      NotificationChain msgs = null;
      if (propertyValue != null)
        msgs = ((InternalEObject)propertyValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_VALUE, null, msgs);
      if (newPropertyValue != null)
        msgs = ((InternalEObject)newPropertyValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_VALUE, null, msgs);
      msgs = basicSetPropertyValue(newPropertyValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_VALUE, newPropertyValue, newPropertyValue));
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
      case MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_VALUE:
        return basicSetPropertyValue(null, msgs);
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
      case MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_NAME:
        if (resolve) return getPropertyName();
        return basicGetPropertyName();
      case MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_VALUE:
        return getPropertyValue();
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
      case MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_NAME:
        setPropertyName((PropertyTypeMdsl)newValue);
        return;
      case MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_VALUE:
        setPropertyValue((PropertyValueMdsl)newValue);
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
      case MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_NAME:
        setPropertyName((PropertyTypeMdsl)null);
        return;
      case MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_VALUE:
        setPropertyValue((PropertyValueMdsl)null);
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
      case MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_NAME:
        return propertyName != null;
      case MadConfigDslPackage.PROPERTY_MDSL__PROPERTY_VALUE:
        return propertyValue != null;
    }
    return super.eIsSet(featureID);
  }

} //PropertyMdslImpl
