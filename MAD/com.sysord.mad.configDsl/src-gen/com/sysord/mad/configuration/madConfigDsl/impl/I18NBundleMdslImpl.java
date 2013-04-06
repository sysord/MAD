/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>I18N Bundle Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.I18NBundleMdslImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.I18NBundleMdslImpl#getBundleDescriptor <em>Bundle Descriptor</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.I18NBundleMdslImpl#getBundleUri <em>Bundle Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class I18NBundleMdslImpl extends MADConfigElementImpl implements I18NBundleMdsl
{
  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getBundleDescriptor() <em>Bundle Descriptor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBundleDescriptor()
   * @generated
   * @ordered
   */
  protected ClassDescriptorMdsl bundleDescriptor;

  /**
   * The default value of the '{@link #getBundleUri() <em>Bundle Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBundleUri()
   * @generated
   * @ordered
   */
  protected static final String BUNDLE_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBundleUri() <em>Bundle Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBundleUri()
   * @generated
   * @ordered
   */
  protected String bundleUri = BUNDLE_URI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected I18NBundleMdslImpl()
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
    return MadConfigDslPackage.Literals.I18N_BUNDLE_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.I18N_BUNDLE_MDSL__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDescriptorMdsl getBundleDescriptor()
  {
    return bundleDescriptor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBundleDescriptor(ClassDescriptorMdsl newBundleDescriptor, NotificationChain msgs)
  {
    ClassDescriptorMdsl oldBundleDescriptor = bundleDescriptor;
    bundleDescriptor = newBundleDescriptor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR, oldBundleDescriptor, newBundleDescriptor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBundleDescriptor(ClassDescriptorMdsl newBundleDescriptor)
  {
    if (newBundleDescriptor != bundleDescriptor)
    {
      NotificationChain msgs = null;
      if (bundleDescriptor != null)
        msgs = ((InternalEObject)bundleDescriptor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR, null, msgs);
      if (newBundleDescriptor != null)
        msgs = ((InternalEObject)newBundleDescriptor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR, null, msgs);
      msgs = basicSetBundleDescriptor(newBundleDescriptor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR, newBundleDescriptor, newBundleDescriptor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBundleUri()
  {
    return bundleUri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBundleUri(String newBundleUri)
  {
    String oldBundleUri = bundleUri;
    bundleUri = newBundleUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_URI, oldBundleUri, bundleUri));
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
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR:
        return basicSetBundleDescriptor(null, msgs);
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
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__DESCRIPTION:
        return getDescription();
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR:
        return getBundleDescriptor();
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_URI:
        return getBundleUri();
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
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR:
        setBundleDescriptor((ClassDescriptorMdsl)newValue);
        return;
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_URI:
        setBundleUri((String)newValue);
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
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR:
        setBundleDescriptor((ClassDescriptorMdsl)null);
        return;
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_URI:
        setBundleUri(BUNDLE_URI_EDEFAULT);
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
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR:
        return bundleDescriptor != null;
      case MadConfigDslPackage.I18N_BUNDLE_MDSL__BUNDLE_URI:
        return BUNDLE_URI_EDEFAULT == null ? bundleUri != null : !BUNDLE_URI_EDEFAULT.equals(bundleUri);
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
    result.append(" (description: ");
    result.append(description);
    result.append(", bundleUri: ");
    result.append(bundleUri);
    result.append(')');
    return result.toString();
  }

} //I18NBundleMdslImpl
