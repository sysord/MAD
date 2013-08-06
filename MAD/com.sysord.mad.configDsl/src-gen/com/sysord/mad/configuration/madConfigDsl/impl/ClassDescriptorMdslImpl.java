/**
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Descriptor Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ClassDescriptorMdslImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ClassDescriptorMdslImpl#getPluginId <em>Plugin Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassDescriptorMdslImpl extends MinimalEObjectImpl.Container implements ClassDescriptorMdsl
{
  /**
   * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassName()
   * @generated
   * @ordered
   */
  protected static final String CLASS_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassName()
   * @generated
   * @ordered
   */
  protected String className = CLASS_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPluginId()
   * @generated
   * @ordered
   */
  protected static final String PLUGIN_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPluginId()
   * @generated
   * @ordered
   */
  protected String pluginId = PLUGIN_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassDescriptorMdslImpl()
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
    return MadConfigDslPackage.Literals.CLASS_DESCRIPTOR_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getClassName()
  {
    return className;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassName(String newClassName)
  {
    String oldClassName = className;
    className = newClassName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL__CLASS_NAME, oldClassName, className));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPluginId()
  {
    return pluginId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPluginId(String newPluginId)
  {
    String oldPluginId = pluginId;
    pluginId = newPluginId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL__PLUGIN_ID, oldPluginId, pluginId));
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
      case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL__CLASS_NAME:
        return getClassName();
      case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL__PLUGIN_ID:
        return getPluginId();
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
      case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL__CLASS_NAME:
        setClassName((String)newValue);
        return;
      case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL__PLUGIN_ID:
        setPluginId((String)newValue);
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
      case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL__CLASS_NAME:
        setClassName(CLASS_NAME_EDEFAULT);
        return;
      case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL__PLUGIN_ID:
        setPluginId(PLUGIN_ID_EDEFAULT);
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
      case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL__CLASS_NAME:
        return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
      case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL__PLUGIN_ID:
        return PLUGIN_ID_EDEFAULT == null ? pluginId != null : !PLUGIN_ID_EDEFAULT.equals(pluginId);
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
    result.append(" (ClassName: ");
    result.append(className);
    result.append(", pluginId: ");
    result.append(pluginId);
    result.append(')');
    return result.toString();
  }

} //ClassDescriptorMdslImpl
