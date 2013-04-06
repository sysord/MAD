/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xtext Language Descriptor Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageDescriptorMdslImpl#getLanguageId <em>Language Id</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageDescriptorMdslImpl#getBundleId <em>Bundle Id</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageDescriptorMdslImpl#getActivatorClassName <em>Activator Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XtextLanguageDescriptorMdslImpl extends MADConfigElementImpl implements XtextLanguageDescriptorMdsl
{
  /**
   * The default value of the '{@link #getLanguageId() <em>Language Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguageId()
   * @generated
   * @ordered
   */
  protected static final String LANGUAGE_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLanguageId() <em>Language Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguageId()
   * @generated
   * @ordered
   */
  protected String languageId = LANGUAGE_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getBundleId() <em>Bundle Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBundleId()
   * @generated
   * @ordered
   */
  protected static final String BUNDLE_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBundleId() <em>Bundle Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBundleId()
   * @generated
   * @ordered
   */
  protected String bundleId = BUNDLE_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getActivatorClassName() <em>Activator Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivatorClassName()
   * @generated
   * @ordered
   */
  protected static final String ACTIVATOR_CLASS_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getActivatorClassName() <em>Activator Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivatorClassName()
   * @generated
   * @ordered
   */
  protected String activatorClassName = ACTIVATOR_CLASS_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XtextLanguageDescriptorMdslImpl()
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
    return MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLanguageId()
  {
    return languageId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLanguageId(String newLanguageId)
  {
    String oldLanguageId = languageId;
    languageId = newLanguageId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID, oldLanguageId, languageId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBundleId()
  {
    return bundleId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBundleId(String newBundleId)
  {
    String oldBundleId = bundleId;
    bundleId = newBundleId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID, oldBundleId, bundleId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getActivatorClassName()
  {
    return activatorClassName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivatorClassName(String newActivatorClassName)
  {
    String oldActivatorClassName = activatorClassName;
    activatorClassName = newActivatorClassName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME, oldActivatorClassName, activatorClassName));
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
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID:
        return getLanguageId();
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID:
        return getBundleId();
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME:
        return getActivatorClassName();
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
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID:
        setLanguageId((String)newValue);
        return;
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID:
        setBundleId((String)newValue);
        return;
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME:
        setActivatorClassName((String)newValue);
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
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID:
        setLanguageId(LANGUAGE_ID_EDEFAULT);
        return;
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID:
        setBundleId(BUNDLE_ID_EDEFAULT);
        return;
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME:
        setActivatorClassName(ACTIVATOR_CLASS_NAME_EDEFAULT);
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
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID:
        return LANGUAGE_ID_EDEFAULT == null ? languageId != null : !LANGUAGE_ID_EDEFAULT.equals(languageId);
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID:
        return BUNDLE_ID_EDEFAULT == null ? bundleId != null : !BUNDLE_ID_EDEFAULT.equals(bundleId);
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME:
        return ACTIVATOR_CLASS_NAME_EDEFAULT == null ? activatorClassName != null : !ACTIVATOR_CLASS_NAME_EDEFAULT.equals(activatorClassName);
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
    result.append(" (languageId: ");
    result.append(languageId);
    result.append(", bundleId: ");
    result.append(bundleId);
    result.append(", activatorClassName: ");
    result.append(activatorClassName);
    result.append(')');
    return result.toString();
  }

} //XtextLanguageDescriptorMdslImpl
