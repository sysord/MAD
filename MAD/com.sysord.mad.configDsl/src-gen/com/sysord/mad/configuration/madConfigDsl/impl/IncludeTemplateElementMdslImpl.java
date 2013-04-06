/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Include Template Element Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.IncludeTemplateElementMdslImpl#getRefIncludedTemplate <em>Ref Included Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IncludeTemplateElementMdslImpl extends TypeConfigurationTemplateElementImpl implements IncludeTemplateElementMdsl
{
  /**
   * The cached value of the '{@link #getRefIncludedTemplate() <em>Ref Included Template</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefIncludedTemplate()
   * @generated
   * @ordered
   */
  protected TypeConfigurationMdsl refIncludedTemplate;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IncludeTemplateElementMdslImpl()
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
    return MadConfigDslPackage.Literals.INCLUDE_TEMPLATE_ELEMENT_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeConfigurationMdsl getRefIncludedTemplate()
  {
    if (refIncludedTemplate != null && refIncludedTemplate.eIsProxy())
    {
      InternalEObject oldRefIncludedTemplate = (InternalEObject)refIncludedTemplate;
      refIncludedTemplate = (TypeConfigurationMdsl)eResolveProxy(oldRefIncludedTemplate);
      if (refIncludedTemplate != oldRefIncludedTemplate)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE, oldRefIncludedTemplate, refIncludedTemplate));
      }
    }
    return refIncludedTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeConfigurationMdsl basicGetRefIncludedTemplate()
  {
    return refIncludedTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefIncludedTemplate(TypeConfigurationMdsl newRefIncludedTemplate)
  {
    TypeConfigurationMdsl oldRefIncludedTemplate = refIncludedTemplate;
    refIncludedTemplate = newRefIncludedTemplate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE, oldRefIncludedTemplate, refIncludedTemplate));
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
      case MadConfigDslPackage.INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE:
        if (resolve) return getRefIncludedTemplate();
        return basicGetRefIncludedTemplate();
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
      case MadConfigDslPackage.INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE:
        setRefIncludedTemplate((TypeConfigurationMdsl)newValue);
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
      case MadConfigDslPackage.INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE:
        setRefIncludedTemplate((TypeConfigurationMdsl)null);
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
      case MadConfigDslPackage.INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE:
        return refIncludedTemplate != null;
    }
    return super.eIsSet(featureID);
  }

} //IncludeTemplateElementMdslImpl
