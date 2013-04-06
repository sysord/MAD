/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reload Widgets UI Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand#getWidgetsToReload <em>Widgets To Reload</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getReloadWidgetsUICommand()
 * @model
 * @generated
 */
public interface ReloadWidgetsUICommand extends UICommandMdsl
{
  /**
   * Returns the value of the '<em><b>Widgets To Reload</b></em>' reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Widgets To Reload</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Widgets To Reload</em>' reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getReloadWidgetsUICommand_WidgetsToReload()
   * @model
   * @generated
   */
  EList<WidgetConfigurationMdsl> getWidgetsToReload();

} // ReloadWidgetsUICommand
