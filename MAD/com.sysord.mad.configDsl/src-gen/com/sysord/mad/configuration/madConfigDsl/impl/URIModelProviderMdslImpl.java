/**
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.URIModelProviderMdsl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URI Model Provider Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.URIModelProviderMdslImpl#getModelUri <em>Model Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URIModelProviderMdslImpl extends ModelProviderMdslImpl implements URIModelProviderMdsl
{
  /**
   * The default value of the '{@link #getModelUri() <em>Model Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelUri()
   * @generated
   * @ordered
   */
  protected static final String MODEL_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModelUri() <em>Model Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelUri()
   * @generated
   * @ordered
   */
  protected String modelUri = MODEL_URI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected URIModelProviderMdslImpl()
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
    return MadConfigDslPackage.Literals.URI_MODEL_PROVIDER_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getModelUri()
  {
    return modelUri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelUri(String newModelUri)
  {
    String oldModelUri = modelUri;
    modelUri = newModelUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.URI_MODEL_PROVIDER_MDSL__MODEL_URI, oldModelUri, modelUri));
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
      case MadConfigDslPackage.URI_MODEL_PROVIDER_MDSL__MODEL_URI:
        return getModelUri();
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
      case MadConfigDslPackage.URI_MODEL_PROVIDER_MDSL__MODEL_URI:
        setModelUri((String)newValue);
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
      case MadConfigDslPackage.URI_MODEL_PROVIDER_MDSL__MODEL_URI:
        setModelUri(MODEL_URI_EDEFAULT);
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
      case MadConfigDslPackage.URI_MODEL_PROVIDER_MDSL__MODEL_URI:
        return MODEL_URI_EDEFAULT == null ? modelUri != null : !MODEL_URI_EDEFAULT.equals(modelUri);
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
    result.append(" (modelUri: ");
    result.append(modelUri);
    result.append(')');
    return result.toString();
  }

} //URIModelProviderMdslImpl
