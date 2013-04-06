/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage
 * @generated
 */
public interface MadConfigDslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MadConfigDslFactory eINSTANCE = com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>MAD Configuration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MAD Configuration</em>'.
   * @generated
   */
  MADConfiguration createMADConfiguration();

  /**
   * Returns a new object of class '<em>MAD Config Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MAD Config Element</em>'.
   * @generated
   */
  MADConfigElement createMADConfigElement();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Class Descriptor Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Descriptor Mdsl</em>'.
   * @generated
   */
  ClassDescriptorMdsl createClassDescriptorMdsl();

  /**
   * Returns a new object of class '<em>Property Type Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Type Mdsl</em>'.
   * @generated
   */
  PropertyTypeMdsl createPropertyTypeMdsl();

  /**
   * Returns a new object of class '<em>Property Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Mdsl</em>'.
   * @generated
   */
  PropertyMdsl createPropertyMdsl();

  /**
   * Returns a new object of class '<em>Property Value Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Value Mdsl</em>'.
   * @generated
   */
  PropertyValueMdsl createPropertyValueMdsl();

  /**
   * Returns a new object of class '<em>Prop Value Expr Fragment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Prop Value Expr Fragment</em>'.
   * @generated
   */
  PropValueExprFragment createPropValueExprFragment();

  /**
   * Returns a new object of class '<em>Litera Prop Value Expr Fragment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Litera Prop Value Expr Fragment</em>'.
   * @generated
   */
  LiteraPropValueExprFragment createLiteraPropValueExprFragment();

  /**
   * Returns a new object of class '<em>Icon Descriptor Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Icon Descriptor Mdsl</em>'.
   * @generated
   */
  IconDescriptorMdsl createIconDescriptorMdsl();

  /**
   * Returns a new object of class '<em>I18N Bundle Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>I18N Bundle Mdsl</em>'.
   * @generated
   */
  I18NBundleMdsl createI18NBundleMdsl();

  /**
   * Returns a new object of class '<em>Foreign Model Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Foreign Model Mdsl</em>'.
   * @generated
   */
  ForeignModelMdsl createForeignModelMdsl();

  /**
   * Returns a new object of class '<em>Model Provider Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Provider Mdsl</em>'.
   * @generated
   */
  ModelProviderMdsl createModelProviderMdsl();

  /**
   * Returns a new object of class '<em>URI Extension Model Provider Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>URI Extension Model Provider Mdsl</em>'.
   * @generated
   */
  URIExtensionModelProviderMdsl createURIExtensionModelProviderMdsl();

  /**
   * Returns a new object of class '<em>URI Model Provider Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>URI Model Provider Mdsl</em>'.
   * @generated
   */
  URIModelProviderMdsl createURIModelProviderMdsl();

  /**
   * Returns a new object of class '<em>Custom Model Provider Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Custom Model Provider Mdsl</em>'.
   * @generated
   */
  CustomModelProviderMdsl createCustomModelProviderMdsl();

  /**
   * Returns a new object of class '<em>Xtext Language Descriptor Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Xtext Language Descriptor Mdsl</em>'.
   * @generated
   */
  XtextLanguageDescriptorMdsl createXtextLanguageDescriptorMdsl();

  /**
   * Returns a new object of class '<em>Xtext Language Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Xtext Language Reference</em>'.
   * @generated
   */
  XtextLanguageReference createXtextLanguageReference();

  /**
   * Returns a new object of class '<em>Query Evaluator Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Evaluator Mdsl</em>'.
   * @generated
   */
  QueryEvaluatorMdsl createQueryEvaluatorMdsl();

  /**
   * Returns a new object of class '<em>Widget Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Widget Type</em>'.
   * @generated
   */
  WidgetType createWidgetType();

  /**
   * Returns a new object of class '<em>UI Tab Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UI Tab Mdsl</em>'.
   * @generated
   */
  UITabMdsl createUITabMdsl();

  /**
   * Returns a new object of class '<em>Layer Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Layer Mdsl</em>'.
   * @generated
   */
  LayerMdsl createLayerMdsl();

  /**
   * Returns a new object of class '<em>Type Configuration Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Configuration Mdsl</em>'.
   * @generated
   */
  TypeConfigurationMdsl createTypeConfigurationMdsl();

  /**
   * Returns a new object of class '<em>Type Configuration Template Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Configuration Template Element</em>'.
   * @generated
   */
  TypeConfigurationTemplateElement createTypeConfigurationTemplateElement();

  /**
   * Returns a new object of class '<em>Include Template Element Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Include Template Element Mdsl</em>'.
   * @generated
   */
  IncludeTemplateElementMdsl createIncludeTemplateElementMdsl();

  /**
   * Returns a new object of class '<em>Value Converter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Converter</em>'.
   * @generated
   */
  ValueConverter createValueConverter();

  /**
   * Returns a new object of class '<em>Query Based Value Converter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Based Value Converter</em>'.
   * @generated
   */
  QueryBasedValueConverter createQueryBasedValueConverter();

  /**
   * Returns a new object of class '<em>Basic Type Value Converter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Basic Type Value Converter</em>'.
   * @generated
   */
  BasicTypeValueConverter createBasicTypeValueConverter();

  /**
   * Returns a new object of class '<em>Widget Configuration Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Widget Configuration Mdsl</em>'.
   * @generated
   */
  WidgetConfigurationMdsl createWidgetConfigurationMdsl();

  /**
   * Returns a new object of class '<em>Validator Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Validator Mdsl</em>'.
   * @generated
   */
  ValidatorMdsl createValidatorMdsl();

  /**
   * Returns a new object of class '<em>Command Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command Mdsl</em>'.
   * @generated
   */
  CommandMdsl createCommandMdsl();

  /**
   * Returns a new object of class '<em>Command Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command Declaration</em>'.
   * @generated
   */
  CommandDeclaration createCommandDeclaration();

  /**
   * Returns a new object of class '<em>Command Definition Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command Definition Mdsl</em>'.
   * @generated
   */
  CommandDefinitionMdsl createCommandDefinitionMdsl();

  /**
   * Returns a new object of class '<em>Command Ref Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command Ref Mdsl</em>'.
   * @generated
   */
  CommandRefMdsl createCommandRefMdsl();

  /**
   * Returns a new object of class '<em>UI Command Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UI Command Mdsl</em>'.
   * @generated
   */
  UICommandMdsl createUICommandMdsl();

  /**
   * Returns a new object of class '<em>Display View UI Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Display View UI Command</em>'.
   * @generated
   */
  DisplayViewUICommand createDisplayViewUICommand();

  /**
   * Returns a new object of class '<em>Reload View UI Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reload View UI Command</em>'.
   * @generated
   */
  ReloadViewUICommand createReloadViewUICommand();

  /**
   * Returns a new object of class '<em>Reload Widgets UI Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reload Widgets UI Command</em>'.
   * @generated
   */
  ReloadWidgetsUICommand createReloadWidgetsUICommand();

  /**
   * Returns a new object of class '<em>Query Usage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Usage</em>'.
   * @generated
   */
  QueryUsage createQueryUsage();

  /**
   * Returns a new object of class '<em>Query Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Mdsl</em>'.
   * @generated
   */
  QueryMdsl createQueryMdsl();

  /**
   * Returns a new object of class '<em>Query Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Declaration</em>'.
   * @generated
   */
  QueryDeclaration createQueryDeclaration();

  /**
   * Returns a new object of class '<em>Query Definition Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Definition Mdsl</em>'.
   * @generated
   */
  QueryDefinitionMdsl createQueryDefinitionMdsl();

  /**
   * Returns a new object of class '<em>Query Fragment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Fragment</em>'.
   * @generated
   */
  QueryFragment createQueryFragment();

  /**
   * Returns a new object of class '<em>Literal Query Fragment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Query Fragment</em>'.
   * @generated
   */
  LiteralQueryFragment createLiteralQueryFragment();

  /**
   * Returns a new object of class '<em>Query Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Body</em>'.
   * @generated
   */
  QueryBody createQueryBody();

  /**
   * Returns a new object of class '<em>Query Ref Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Ref Mdsl</em>'.
   * @generated
   */
  QueryRefMdsl createQueryRefMdsl();

  /**
   * Returns a new object of class '<em>External Query Call Mdsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Query Call Mdsl</em>'.
   * @generated
   */
  ExternalQueryCallMdsl createExternalQueryCallMdsl();

  /**
   * Returns a new object of class '<em>Query Chain</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Chain</em>'.
   * @generated
   */
  QueryChain createQueryChain();

  /**
   * Returns a new object of class '<em>Format Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Format Expr</em>'.
   * @generated
   */
  FormatExpr createFormatExpr();

  /**
   * Returns a new object of class '<em>Format Expr Fragment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Format Expr Fragment</em>'.
   * @generated
   */
  FormatExprFragment createFormatExprFragment();

  /**
   * Returns a new object of class '<em>Literal Format Expr Fragment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Format Expr Fragment</em>'.
   * @generated
   */
  LiteralFormatExprFragment createLiteralFormatExprFragment();

  /**
   * Returns a new object of class '<em>Text Macro</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Text Macro</em>'.
   * @generated
   */
  TextMacro createTextMacro();

  /**
   * Returns a new object of class '<em>Text Macro Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Text Macro Ref</em>'.
   * @generated
   */
  TextMacroRef createTextMacroRef();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MadConfigDslPackage getMadConfigDslPackage();

} //MadConfigDslFactory
