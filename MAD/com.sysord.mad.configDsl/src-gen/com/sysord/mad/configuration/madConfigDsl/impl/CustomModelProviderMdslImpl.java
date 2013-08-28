/**
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Model Provider Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CustomModelProviderMdslImpl#getClassDescriptor <em>Class Descriptor</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CustomModelProviderMdslImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomModelProviderMdslImpl extends ModelProviderMdslImpl implements CustomModelProviderMdsl
{
  /**
   * The cached value of the '{@link #getClassDescriptor() <em>Class Descriptor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassDescriptor()
   * @generated
   * @ordered
   */
  protected ClassDescriptorMdsl classDescriptor;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<String> parameters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CustomModelProviderMdslImpl()
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
    return MadConfigDslPackage.Literals.CUSTOM_MODEL_PROVIDER_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDescriptorMdsl getClassDescriptor()
  {
    return classDescriptor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassDescriptor(ClassDescriptorMdsl newClassDescriptor, NotificationChain msgs)
  {
    ClassDescriptorMdsl oldClassDescriptor = classDescriptor;
    classDescriptor = newClassDescriptor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR, oldClassDescriptor, newClassDescriptor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassDescriptor(ClassDescriptorMdsl newClassDescriptor)
  {
    if (newClassDescriptor != classDescriptor)
    {
      NotificationChain msgs = null;
      if (classDescriptor != null)
        msgs = ((InternalEObject)classDescriptor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR, null, msgs);
      if (newClassDescriptor != null)
        msgs = ((InternalEObject)newClassDescriptor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR, null, msgs);
      msgs = basicSetClassDescriptor(newClassDescriptor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR, newClassDescriptor, newClassDescriptor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EDataTypeEList<String>(String.class, this, MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__PARAMETERS);
    }
    return parameters;
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
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR:
        return basicSetClassDescriptor(null, msgs);
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
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR:
        return getClassDescriptor();
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__PARAMETERS:
        return getParameters();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR:
        setClassDescriptor((ClassDescriptorMdsl)newValue);
        return;
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends String>)newValue);
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
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR:
        setClassDescriptor((ClassDescriptorMdsl)null);
        return;
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__PARAMETERS:
        getParameters().clear();
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
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR:
        return classDescriptor != null;
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
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
    result.append(" (parameters: ");
    result.append(parameters);
    result.append(')');
    return result.toString();
  }

} //CustomModelProviderMdslImpl
