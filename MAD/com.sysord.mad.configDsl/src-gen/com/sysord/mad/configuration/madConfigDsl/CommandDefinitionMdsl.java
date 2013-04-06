/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command Definition Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#isI18NLabel <em>I18N Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getIcon <em>Icon</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getAction <em>Action</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getOnActionSuccessUICommands <em>On Action Success UI Commands</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getOnActionErrorUICommands <em>On Action Error UI Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandDefinitionMdsl()
 * @model
 * @generated
 */
public interface CommandDefinitionMdsl extends CommandMdsl
{
  /**
   * Returns the value of the '<em><b>Category</b></em>' attribute.
   * The literals are from the enumeration {@link com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' attribute.
   * @see com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL
   * @see #setCategory(COMMAND_CATEGORY_MDSL)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandDefinitionMdsl_Category()
   * @model
   * @generated
   */
  COMMAND_CATEGORY_MDSL getCategory();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getCategory <em>Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Category</em>' attribute.
   * @see com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL
   * @see #getCategory()
   * @generated
   */
  void setCategory(COMMAND_CATEGORY_MDSL value);

  /**
   * Returns the value of the '<em><b>I18N Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>I18N Label</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>I18N Label</em>' attribute.
   * @see #setI18NLabel(boolean)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandDefinitionMdsl_I18NLabel()
   * @model
   * @generated
   */
  boolean isI18NLabel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#isI18NLabel <em>I18N Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>I18N Label</em>' attribute.
   * @see #isI18NLabel()
   * @generated
   */
  void setI18NLabel(boolean value);

  /**
   * Returns the value of the '<em><b>Label</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label</em>' containment reference.
   * @see #setLabel(FormatExpr)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandDefinitionMdsl_Label()
   * @model containment="true"
   * @generated
   */
  FormatExpr getLabel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getLabel <em>Label</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' containment reference.
   * @see #getLabel()
   * @generated
   */
  void setLabel(FormatExpr value);

  /**
   * Returns the value of the '<em><b>Icon</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Icon</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Icon</em>' reference.
   * @see #setIcon(IconDescriptorMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandDefinitionMdsl_Icon()
   * @model
   * @generated
   */
  IconDescriptorMdsl getIcon();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getIcon <em>Icon</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Icon</em>' reference.
   * @see #getIcon()
   * @generated
   */
  void setIcon(IconDescriptorMdsl value);

  /**
   * Returns the value of the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' containment reference.
   * @see #setAction(QueryMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandDefinitionMdsl_Action()
   * @model containment="true"
   * @generated
   */
  QueryMdsl getAction();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getAction <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' containment reference.
   * @see #getAction()
   * @generated
   */
  void setAction(QueryMdsl value);

  /**
   * Returns the value of the '<em><b>On Action Success UI Commands</b></em>' containment reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.UICommandMdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>On Action Success UI Commands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>On Action Success UI Commands</em>' containment reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandDefinitionMdsl_OnActionSuccessUICommands()
   * @model containment="true"
   * @generated
   */
  EList<UICommandMdsl> getOnActionSuccessUICommands();

  /**
   * Returns the value of the '<em><b>On Action Error UI Commands</b></em>' containment reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.UICommandMdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>On Action Error UI Commands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>On Action Error UI Commands</em>' containment reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCommandDefinitionMdsl_OnActionErrorUICommands()
   * @model containment="true"
   * @generated
   */
  EList<UICommandMdsl> getOnActionErrorUICommands();

} // CommandDefinitionMdsl
