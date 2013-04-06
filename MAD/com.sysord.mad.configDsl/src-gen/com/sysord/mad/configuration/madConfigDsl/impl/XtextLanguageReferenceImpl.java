/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xtext Language Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageReferenceImpl#getXtextLanguageDescriptor <em>Xtext Language Descriptor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XtextLanguageReferenceImpl extends MinimalEObjectImpl.Container implements XtextLanguageReference
{
  /**
   * The cached value of the '{@link #getXtextLanguageDescriptor() <em>Xtext Language Descriptor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXtextLanguageDescriptor()
   * @generated
   * @ordered
   */
  protected XtextLanguageDescriptorMdsl xtextLanguageDescriptor;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XtextLanguageReferenceImpl()
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
    return MadConfigDslPackage.Literals.XTEXT_LANGUAGE_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextLanguageDescriptorMdsl getXtextLanguageDescriptor()
  {
    if (xtextLanguageDescriptor != null && xtextLanguageDescriptor.eIsProxy())
    {
      InternalEObject oldXtextLanguageDescriptor = (InternalEObject)xtextLanguageDescriptor;
      xtextLanguageDescriptor = (XtextLanguageDescriptorMdsl)eResolveProxy(oldXtextLanguageDescriptor);
      if (xtextLanguageDescriptor != oldXtextLanguageDescriptor)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR, oldXtextLanguageDescriptor, xtextLanguageDescriptor));
      }
    }
    return xtextLanguageDescriptor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextLanguageDescriptorMdsl basicGetXtextLanguageDescriptor()
  {
    return xtextLanguageDescriptor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXtextLanguageDescriptor(XtextLanguageDescriptorMdsl newXtextLanguageDescriptor)
  {
    XtextLanguageDescriptorMdsl oldXtextLanguageDescriptor = xtextLanguageDescriptor;
    xtextLanguageDescriptor = newXtextLanguageDescriptor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR, oldXtextLanguageDescriptor, xtextLanguageDescriptor));
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
      case MadConfigDslPackage.XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR:
        if (resolve) return getXtextLanguageDescriptor();
        return basicGetXtextLanguageDescriptor();
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
      case MadConfigDslPackage.XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR:
        setXtextLanguageDescriptor((XtextLanguageDescriptorMdsl)newValue);
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
      case MadConfigDslPackage.XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR:
        setXtextLanguageDescriptor((XtextLanguageDescriptorMdsl)null);
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
      case MadConfigDslPackage.XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR:
        return xtextLanguageDescriptor != null;
    }
    return super.eIsSet(featureID);
  }

} //XtextLanguageReferenceImpl
