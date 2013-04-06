/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget Configuration Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getUiTab <em>Ui Tab</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getLayers <em>Layers</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NLabel <em>I18N Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getWidgetCategory <em>Widget Category</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getWidgetType <em>Widget Type</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getDslReference <em>Dsl Reference</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getFlexibleTemplate <em>Flexible Template</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getVisibilityQuery <em>Visibility Query</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getEditableQuery <em>Editable Query</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValueConverter <em>Value Converter</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValidators <em>Validators</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NFormat <em>I18N Format</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValueFormat <em>Value Format</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getCandidatesQuery <em>Candidates Query</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NItemLabel <em>I18N Item Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getItemLabelExpression <em>Item Label Expression</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getCommands <em>Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl()
 * @model
 * @generated
 */
public interface WidgetConfigurationMdsl extends TypeConfigurationTemplateElement
{
  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Ui Tab</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ui Tab</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ui Tab</em>' reference.
   * @see #setUiTab(UITabMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_UiTab()
   * @model
   * @generated
   */
  UITabMdsl getUiTab();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getUiTab <em>Ui Tab</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ui Tab</em>' reference.
   * @see #getUiTab()
   * @generated
   */
  void setUiTab(UITabMdsl value);

  /**
   * Returns the value of the '<em><b>Layers</b></em>' reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Layers</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Layers</em>' reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_Layers()
   * @model
   * @generated
   */
  EList<LayerMdsl> getLayers();

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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_I18NLabel()
   * @model
   * @generated
   */
  boolean isI18NLabel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NLabel <em>I18N Label</em>}' attribute.
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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_Label()
   * @model containment="true"
   * @generated
   */
  FormatExpr getLabel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getLabel <em>Label</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' containment reference.
   * @see #getLabel()
   * @generated
   */
  void setLabel(FormatExpr value);

  /**
   * Returns the value of the '<em><b>Widget Category</b></em>' attribute.
   * The literals are from the enumeration {@link com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Widget Category</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Widget Category</em>' attribute.
   * @see com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL
   * @see #setWidgetCategory(WIDGET_CATEGORY_MDSL)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_WidgetCategory()
   * @model
   * @generated
   */
  WIDGET_CATEGORY_MDSL getWidgetCategory();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getWidgetCategory <em>Widget Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Widget Category</em>' attribute.
   * @see com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL
   * @see #getWidgetCategory()
   * @generated
   */
  void setWidgetCategory(WIDGET_CATEGORY_MDSL value);

  /**
   * Returns the value of the '<em><b>Widget Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Widget Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Widget Type</em>' reference.
   * @see #setWidgetType(WidgetType)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_WidgetType()
   * @model
   * @generated
   */
  WidgetType getWidgetType();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getWidgetType <em>Widget Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Widget Type</em>' reference.
   * @see #getWidgetType()
   * @generated
   */
  void setWidgetType(WidgetType value);

  /**
   * Returns the value of the '<em><b>Dsl Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dsl Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dsl Reference</em>' containment reference.
   * @see #setDslReference(XtextLanguageReference)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_DslReference()
   * @model containment="true"
   * @generated
   */
  XtextLanguageReference getDslReference();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getDslReference <em>Dsl Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dsl Reference</em>' containment reference.
   * @see #getDslReference()
   * @generated
   */
  void setDslReference(XtextLanguageReference value);

  /**
   * Returns the value of the '<em><b>Flexible Template</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Flexible Template</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flexible Template</em>' reference.
   * @see #setFlexibleTemplate(TypeConfigurationMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_FlexibleTemplate()
   * @model
   * @generated
   */
  TypeConfigurationMdsl getFlexibleTemplate();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getFlexibleTemplate <em>Flexible Template</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Flexible Template</em>' reference.
   * @see #getFlexibleTemplate()
   * @generated
   */
  void setFlexibleTemplate(TypeConfigurationMdsl value);

  /**
   * Returns the value of the '<em><b>Visibility Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility Query</em>' containment reference.
   * @see #setVisibilityQuery(QueryMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_VisibilityQuery()
   * @model containment="true"
   * @generated
   */
  QueryMdsl getVisibilityQuery();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getVisibilityQuery <em>Visibility Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility Query</em>' containment reference.
   * @see #getVisibilityQuery()
   * @generated
   */
  void setVisibilityQuery(QueryMdsl value);

  /**
   * Returns the value of the '<em><b>Editable Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Editable Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Editable Query</em>' containment reference.
   * @see #setEditableQuery(QueryMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_EditableQuery()
   * @model containment="true"
   * @generated
   */
  QueryMdsl getEditableQuery();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getEditableQuery <em>Editable Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Editable Query</em>' containment reference.
   * @see #getEditableQuery()
   * @generated
   */
  void setEditableQuery(QueryMdsl value);

  /**
   * Returns the value of the '<em><b>Value Converter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Converter</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Converter</em>' containment reference.
   * @see #setValueConverter(ValueConverter)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_ValueConverter()
   * @model containment="true"
   * @generated
   */
  ValueConverter getValueConverter();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValueConverter <em>Value Converter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Converter</em>' containment reference.
   * @see #getValueConverter()
   * @generated
   */
  void setValueConverter(ValueConverter value);

  /**
   * Returns the value of the '<em><b>Validators</b></em>' containment reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Validators</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Validators</em>' containment reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_Validators()
   * @model containment="true"
   * @generated
   */
  EList<ValidatorMdsl> getValidators();

  /**
   * Returns the value of the '<em><b>I18N Format</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>I18N Format</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>I18N Format</em>' attribute.
   * @see #setI18NFormat(boolean)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_I18NFormat()
   * @model
   * @generated
   */
  boolean isI18NFormat();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NFormat <em>I18N Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>I18N Format</em>' attribute.
   * @see #isI18NFormat()
   * @generated
   */
  void setI18NFormat(boolean value);

  /**
   * Returns the value of the '<em><b>Value Format</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Format</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Format</em>' containment reference.
   * @see #setValueFormat(FormatExpr)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_ValueFormat()
   * @model containment="true"
   * @generated
   */
  FormatExpr getValueFormat();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValueFormat <em>Value Format</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Format</em>' containment reference.
   * @see #getValueFormat()
   * @generated
   */
  void setValueFormat(FormatExpr value);

  /**
   * Returns the value of the '<em><b>Candidates Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Candidates Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Candidates Query</em>' containment reference.
   * @see #setCandidatesQuery(QueryUsage)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_CandidatesQuery()
   * @model containment="true"
   * @generated
   */
  QueryUsage getCandidatesQuery();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getCandidatesQuery <em>Candidates Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Candidates Query</em>' containment reference.
   * @see #getCandidatesQuery()
   * @generated
   */
  void setCandidatesQuery(QueryUsage value);

  /**
   * Returns the value of the '<em><b>I18N Item Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>I18N Item Label</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>I18N Item Label</em>' attribute.
   * @see #setI18NItemLabel(boolean)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_I18NItemLabel()
   * @model
   * @generated
   */
  boolean isI18NItemLabel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NItemLabel <em>I18N Item Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>I18N Item Label</em>' attribute.
   * @see #isI18NItemLabel()
   * @generated
   */
  void setI18NItemLabel(boolean value);

  /**
   * Returns the value of the '<em><b>Item Label Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Item Label Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Item Label Expression</em>' containment reference.
   * @see #setItemLabelExpression(FormatExpr)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_ItemLabelExpression()
   * @model containment="true"
   * @generated
   */
  FormatExpr getItemLabelExpression();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getItemLabelExpression <em>Item Label Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Item Label Expression</em>' containment reference.
   * @see #getItemLabelExpression()
   * @generated
   */
  void setItemLabelExpression(FormatExpr value);

  /**
   * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.CommandMdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Commands</em>' containment reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getWidgetConfigurationMdsl_Commands()
   * @model containment="true"
   * @generated
   */
  EList<CommandMdsl> getCommands();

} // WidgetConfigurationMdsl
