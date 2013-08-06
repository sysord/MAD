/**
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.URIExtensionModelProviderMdsl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URI Extension Model Provider Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.URIExtensionModelProviderMdslImpl#getUriExtension <em>Uri Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URIExtensionModelProviderMdslImpl extends ModelProviderMdslImpl implements URIExtensionModelProviderMdsl
{
  /**
   * The default value of the '{@link #getUriExtension() <em>Uri Extension</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUriExtension()
   * @generated
   * @ordered
   */
  protected static final String URI_EXTENSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUriExtension() <em>Uri Extension</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUriExtension()
   * @generated
   * @ordered
   */
  protected String uriExtension = URI_EXTENSION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected URIExtensionModelProviderMdslImpl()
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
    return MadConfigDslPackage.Literals.URI_EXTENSION_MODEL_PROVIDER_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUriExtension()
  {
    return uriExtension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUriExtension(String newUriExtension)
  {
    String oldUriExtension = uriExtension;
    uriExtension = newUriExtension;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.URI_EXTENSION_MODEL_PROVIDER_MDSL__URI_EXTENSION, oldUriExtension, uriExtension));
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
      case MadConfigDslPackage.URI_EXTENSION_MODEL_PROVIDER_MDSL__URI_EXTENSION:
        return getUriExtension();
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
      case MadConfigDslPackage.URI_EXTENSION_MODEL_PROVIDER_MDSL__URI_EXTENSION:
        setUriExtension((String)newValue);
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
      case MadConfigDslPackage.URI_EXTENSION_MODEL_PROVIDER_MDSL__URI_EXTENSION:
        setUriExtension(URI_EXTENSION_EDEFAULT);
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
      case MadConfigDslPackage.URI_EXTENSION_MODEL_PROVIDER_MDSL__URI_EXTENSION:
        return URI_EXTENSION_EDEFAULT == null ? uriExtension != null : !URI_EXTENSION_EDEFAULT.equals(uriExtension);
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
    result.append(" (uriExtension: ");
    result.append(uriExtension);
    result.append(')');
    return result.toString();
  }

} //URIExtensionModelProviderMdslImpl
