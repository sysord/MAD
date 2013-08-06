/**
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.Import;
import com.sysord.mad.configuration.madConfigDsl.MADConfigElement;
import com.sysord.mad.configuration.madConfigDsl.MADConfiguration;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAD Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.MADConfigurationImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.MADConfigurationImpl#getConfigElements <em>Config Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MADConfigurationImpl extends MinimalEObjectImpl.Container implements MADConfiguration
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getConfigElements() <em>Config Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfigElements()
   * @generated
   * @ordered
   */
  protected EList<MADConfigElement> configElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MADConfigurationImpl()
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
    return MadConfigDslPackage.Literals.MAD_CONFIGURATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, MadConfigDslPackage.MAD_CONFIGURATION__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MADConfigElement> getConfigElements()
  {
    if (configElements == null)
    {
      configElements = new EObjectContainmentEList<MADConfigElement>(MADConfigElement.class, this, MadConfigDslPackage.MAD_CONFIGURATION__CONFIG_ELEMENTS);
    }
    return configElements;
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
      case MadConfigDslPackage.MAD_CONFIGURATION__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case MadConfigDslPackage.MAD_CONFIGURATION__CONFIG_ELEMENTS:
        return ((InternalEList<?>)getConfigElements()).basicRemove(otherEnd, msgs);
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
      case MadConfigDslPackage.MAD_CONFIGURATION__IMPORTS:
        return getImports();
      case MadConfigDslPackage.MAD_CONFIGURATION__CONFIG_ELEMENTS:
        return getConfigElements();
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
      case MadConfigDslPackage.MAD_CONFIGURATION__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case MadConfigDslPackage.MAD_CONFIGURATION__CONFIG_ELEMENTS:
        getConfigElements().clear();
        getConfigElements().addAll((Collection<? extends MADConfigElement>)newValue);
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
      case MadConfigDslPackage.MAD_CONFIGURATION__IMPORTS:
        getImports().clear();
        return;
      case MadConfigDslPackage.MAD_CONFIGURATION__CONFIG_ELEMENTS:
        getConfigElements().clear();
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
      case MadConfigDslPackage.MAD_CONFIGURATION__IMPORTS:
        return imports != null && !imports.isEmpty();
      case MadConfigDslPackage.MAD_CONFIGURATION__CONFIG_ELEMENTS:
        return configElements != null && !configElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MADConfigurationImpl
