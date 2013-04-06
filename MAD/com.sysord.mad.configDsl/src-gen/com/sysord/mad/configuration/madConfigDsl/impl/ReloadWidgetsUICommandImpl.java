/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reload Widgets UI Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ReloadWidgetsUICommandImpl#getWidgetsToReload <em>Widgets To Reload</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReloadWidgetsUICommandImpl extends UICommandMdslImpl implements ReloadWidgetsUICommand
{
  /**
   * The cached value of the '{@link #getWidgetsToReload() <em>Widgets To Reload</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidgetsToReload()
   * @generated
   * @ordered
   */
  protected EList<WidgetConfigurationMdsl> widgetsToReload;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReloadWidgetsUICommandImpl()
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
    return MadConfigDslPackage.Literals.RELOAD_WIDGETS_UI_COMMAND;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<WidgetConfigurationMdsl> getWidgetsToReload()
  {
    if (widgetsToReload == null)
    {
      widgetsToReload = new EObjectResolvingEList<WidgetConfigurationMdsl>(WidgetConfigurationMdsl.class, this, MadConfigDslPackage.RELOAD_WIDGETS_UI_COMMAND__WIDGETS_TO_RELOAD);
    }
    return widgetsToReload;
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
      case MadConfigDslPackage.RELOAD_WIDGETS_UI_COMMAND__WIDGETS_TO_RELOAD:
        return getWidgetsToReload();
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
      case MadConfigDslPackage.RELOAD_WIDGETS_UI_COMMAND__WIDGETS_TO_RELOAD:
        getWidgetsToReload().clear();
        getWidgetsToReload().addAll((Collection<? extends WidgetConfigurationMdsl>)newValue);
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
      case MadConfigDslPackage.RELOAD_WIDGETS_UI_COMMAND__WIDGETS_TO_RELOAD:
        getWidgetsToReload().clear();
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
      case MadConfigDslPackage.RELOAD_WIDGETS_UI_COMMAND__WIDGETS_TO_RELOAD:
        return widgetsToReload != null && !widgetsToReload.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ReloadWidgetsUICommandImpl
