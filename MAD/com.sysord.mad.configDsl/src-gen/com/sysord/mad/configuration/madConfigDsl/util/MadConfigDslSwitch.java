/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.util;

import com.sysord.mad.configuration.madConfigDsl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage
 * @generated
 */
public class MadConfigDslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MadConfigDslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MadConfigDslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MadConfigDslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case MadConfigDslPackage.MAD_CONFIGURATION:
      {
        MADConfiguration madConfiguration = (MADConfiguration)theEObject;
        T result = caseMADConfiguration(madConfiguration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.MAD_CONFIG_ELEMENT:
      {
        MADConfigElement madConfigElement = (MADConfigElement)theEObject;
        T result = caseMADConfigElement(madConfigElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL:
      {
        ClassDescriptorMdsl classDescriptorMdsl = (ClassDescriptorMdsl)theEObject;
        T result = caseClassDescriptorMdsl(classDescriptorMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.PROPERTY_TYPE_MDSL:
      {
        PropertyTypeMdsl propertyTypeMdsl = (PropertyTypeMdsl)theEObject;
        T result = casePropertyTypeMdsl(propertyTypeMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.PROPERTY_MDSL:
      {
        PropertyMdsl propertyMdsl = (PropertyMdsl)theEObject;
        T result = casePropertyMdsl(propertyMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.PROPERTY_VALUE_MDSL:
      {
        PropertyValueMdsl propertyValueMdsl = (PropertyValueMdsl)theEObject;
        T result = casePropertyValueMdsl(propertyValueMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.PROP_VALUE_EXPR_FRAGMENT:
      {
        PropValueExprFragment propValueExprFragment = (PropValueExprFragment)theEObject;
        T result = casePropValueExprFragment(propValueExprFragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.LITERA_PROP_VALUE_EXPR_FRAGMENT:
      {
        LiteraPropValueExprFragment literaPropValueExprFragment = (LiteraPropValueExprFragment)theEObject;
        T result = caseLiteraPropValueExprFragment(literaPropValueExprFragment);
        if (result == null) result = casePropValueExprFragment(literaPropValueExprFragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.ICON_DESCRIPTOR_MDSL:
      {
        IconDescriptorMdsl iconDescriptorMdsl = (IconDescriptorMdsl)theEObject;
        T result = caseIconDescriptorMdsl(iconDescriptorMdsl);
        if (result == null) result = caseMADConfigElement(iconDescriptorMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.I18N_BUNDLE_MDSL:
      {
        I18NBundleMdsl i18NBundleMdsl = (I18NBundleMdsl)theEObject;
        T result = caseI18NBundleMdsl(i18NBundleMdsl);
        if (result == null) result = caseMADConfigElement(i18NBundleMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL:
      {
        ForeignModelMdsl foreignModelMdsl = (ForeignModelMdsl)theEObject;
        T result = caseForeignModelMdsl(foreignModelMdsl);
        if (result == null) result = caseMADConfigElement(foreignModelMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.MODEL_PROVIDER_MDSL:
      {
        ModelProviderMdsl modelProviderMdsl = (ModelProviderMdsl)theEObject;
        T result = caseModelProviderMdsl(modelProviderMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.URI_EXTENSION_MODEL_PROVIDER_MDSL:
      {
        URIExtensionModelProviderMdsl uriExtensionModelProviderMdsl = (URIExtensionModelProviderMdsl)theEObject;
        T result = caseURIExtensionModelProviderMdsl(uriExtensionModelProviderMdsl);
        if (result == null) result = caseModelProviderMdsl(uriExtensionModelProviderMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.URI_MODEL_PROVIDER_MDSL:
      {
        URIModelProviderMdsl uriModelProviderMdsl = (URIModelProviderMdsl)theEObject;
        T result = caseURIModelProviderMdsl(uriModelProviderMdsl);
        if (result == null) result = caseModelProviderMdsl(uriModelProviderMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL:
      {
        CustomModelProviderMdsl customModelProviderMdsl = (CustomModelProviderMdsl)theEObject;
        T result = caseCustomModelProviderMdsl(customModelProviderMdsl);
        if (result == null) result = caseModelProviderMdsl(customModelProviderMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL:
      {
        XtextLanguageDescriptorMdsl xtextLanguageDescriptorMdsl = (XtextLanguageDescriptorMdsl)theEObject;
        T result = caseXtextLanguageDescriptorMdsl(xtextLanguageDescriptorMdsl);
        if (result == null) result = caseMADConfigElement(xtextLanguageDescriptorMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.XTEXT_LANGUAGE_REFERENCE:
      {
        XtextLanguageReference xtextLanguageReference = (XtextLanguageReference)theEObject;
        T result = caseXtextLanguageReference(xtextLanguageReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.OCL_CUSTOM_LIBRARY_MDSL:
      {
        OCLCustomLibraryMdsl oclCustomLibraryMdsl = (OCLCustomLibraryMdsl)theEObject;
        T result = caseOCLCustomLibraryMdsl(oclCustomLibraryMdsl);
        if (result == null) result = caseMADConfigElement(oclCustomLibraryMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL:
      {
        QueryEvaluatorMdsl queryEvaluatorMdsl = (QueryEvaluatorMdsl)theEObject;
        T result = caseQueryEvaluatorMdsl(queryEvaluatorMdsl);
        if (result == null) result = caseMADConfigElement(queryEvaluatorMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.WIDGET_TYPE:
      {
        WidgetType widgetType = (WidgetType)theEObject;
        T result = caseWidgetType(widgetType);
        if (result == null) result = caseMADConfigElement(widgetType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.UI_TAB_MDSL:
      {
        UITabMdsl uiTabMdsl = (UITabMdsl)theEObject;
        T result = caseUITabMdsl(uiTabMdsl);
        if (result == null) result = caseMADConfigElement(uiTabMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.LAYER_MDSL:
      {
        LayerMdsl layerMdsl = (LayerMdsl)theEObject;
        T result = caseLayerMdsl(layerMdsl);
        if (result == null) result = caseMADConfigElement(layerMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL:
      {
        TypeConfigurationMdsl typeConfigurationMdsl = (TypeConfigurationMdsl)theEObject;
        T result = caseTypeConfigurationMdsl(typeConfigurationMdsl);
        if (result == null) result = caseMADConfigElement(typeConfigurationMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT:
      {
        TypeConfigurationTemplateElement typeConfigurationTemplateElement = (TypeConfigurationTemplateElement)theEObject;
        T result = caseTypeConfigurationTemplateElement(typeConfigurationTemplateElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.INCLUDE_TEMPLATE_ELEMENT_MDSL:
      {
        IncludeTemplateElementMdsl includeTemplateElementMdsl = (IncludeTemplateElementMdsl)theEObject;
        T result = caseIncludeTemplateElementMdsl(includeTemplateElementMdsl);
        if (result == null) result = caseTypeConfigurationTemplateElement(includeTemplateElementMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.VALUE_CONVERTER:
      {
        ValueConverter valueConverter = (ValueConverter)theEObject;
        T result = caseValueConverter(valueConverter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER:
      {
        QueryBasedValueConverter queryBasedValueConverter = (QueryBasedValueConverter)theEObject;
        T result = caseQueryBasedValueConverter(queryBasedValueConverter);
        if (result == null) result = caseValueConverter(queryBasedValueConverter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER:
      {
        BasicTypeValueConverter basicTypeValueConverter = (BasicTypeValueConverter)theEObject;
        T result = caseBasicTypeValueConverter(basicTypeValueConverter);
        if (result == null) result = caseValueConverter(basicTypeValueConverter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL:
      {
        WidgetConfigurationMdsl widgetConfigurationMdsl = (WidgetConfigurationMdsl)theEObject;
        T result = caseWidgetConfigurationMdsl(widgetConfigurationMdsl);
        if (result == null) result = caseTypeConfigurationTemplateElement(widgetConfigurationMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.VALIDATOR_MDSL:
      {
        ValidatorMdsl validatorMdsl = (ValidatorMdsl)theEObject;
        T result = caseValidatorMdsl(validatorMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.COMMAND_MDSL:
      {
        CommandMdsl commandMdsl = (CommandMdsl)theEObject;
        T result = caseCommandMdsl(commandMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.COMMAND_DECLARATION:
      {
        CommandDeclaration commandDeclaration = (CommandDeclaration)theEObject;
        T result = caseCommandDeclaration(commandDeclaration);
        if (result == null) result = caseMADConfigElement(commandDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL:
      {
        CommandDefinitionMdsl commandDefinitionMdsl = (CommandDefinitionMdsl)theEObject;
        T result = caseCommandDefinitionMdsl(commandDefinitionMdsl);
        if (result == null) result = caseCommandMdsl(commandDefinitionMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.COMMAND_REF_MDSL:
      {
        CommandRefMdsl commandRefMdsl = (CommandRefMdsl)theEObject;
        T result = caseCommandRefMdsl(commandRefMdsl);
        if (result == null) result = caseCommandMdsl(commandRefMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.UI_COMMAND_MDSL:
      {
        UICommandMdsl uiCommandMdsl = (UICommandMdsl)theEObject;
        T result = caseUICommandMdsl(uiCommandMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.DISPLAY_VIEW_UI_COMMAND:
      {
        DisplayViewUICommand displayViewUICommand = (DisplayViewUICommand)theEObject;
        T result = caseDisplayViewUICommand(displayViewUICommand);
        if (result == null) result = caseUICommandMdsl(displayViewUICommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.RELOAD_VIEW_UI_COMMAND:
      {
        ReloadViewUICommand reloadViewUICommand = (ReloadViewUICommand)theEObject;
        T result = caseReloadViewUICommand(reloadViewUICommand);
        if (result == null) result = caseUICommandMdsl(reloadViewUICommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.RELOAD_WIDGETS_UI_COMMAND:
      {
        ReloadWidgetsUICommand reloadWidgetsUICommand = (ReloadWidgetsUICommand)theEObject;
        T result = caseReloadWidgetsUICommand(reloadWidgetsUICommand);
        if (result == null) result = caseUICommandMdsl(reloadWidgetsUICommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.QUERY_USAGE:
      {
        QueryUsage queryUsage = (QueryUsage)theEObject;
        T result = caseQueryUsage(queryUsage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.QUERY_MDSL:
      {
        QueryMdsl queryMdsl = (QueryMdsl)theEObject;
        T result = caseQueryMdsl(queryMdsl);
        if (result == null) result = caseQueryUsage(queryMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.QUERY_DECLARATION:
      {
        QueryDeclaration queryDeclaration = (QueryDeclaration)theEObject;
        T result = caseQueryDeclaration(queryDeclaration);
        if (result == null) result = caseMADConfigElement(queryDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL:
      {
        QueryDefinitionMdsl queryDefinitionMdsl = (QueryDefinitionMdsl)theEObject;
        T result = caseQueryDefinitionMdsl(queryDefinitionMdsl);
        if (result == null) result = caseQueryMdsl(queryDefinitionMdsl);
        if (result == null) result = caseQueryUsage(queryDefinitionMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.QUERY_FRAGMENT:
      {
        QueryFragment queryFragment = (QueryFragment)theEObject;
        T result = caseQueryFragment(queryFragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.LITERAL_QUERY_FRAGMENT:
      {
        LiteralQueryFragment literalQueryFragment = (LiteralQueryFragment)theEObject;
        T result = caseLiteralQueryFragment(literalQueryFragment);
        if (result == null) result = caseQueryFragment(literalQueryFragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.QUERY_BODY:
      {
        QueryBody queryBody = (QueryBody)theEObject;
        T result = caseQueryBody(queryBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.QUERY_REF_MDSL:
      {
        QueryRefMdsl queryRefMdsl = (QueryRefMdsl)theEObject;
        T result = caseQueryRefMdsl(queryRefMdsl);
        if (result == null) result = caseQueryMdsl(queryRefMdsl);
        if (result == null) result = caseQueryUsage(queryRefMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.EXTERNAL_QUERY_CALL_MDSL:
      {
        ExternalQueryCallMdsl externalQueryCallMdsl = (ExternalQueryCallMdsl)theEObject;
        T result = caseExternalQueryCallMdsl(externalQueryCallMdsl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.QUERY_CHAIN:
      {
        QueryChain queryChain = (QueryChain)theEObject;
        T result = caseQueryChain(queryChain);
        if (result == null) result = caseQueryUsage(queryChain);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.FORMAT_EXPR:
      {
        FormatExpr formatExpr = (FormatExpr)theEObject;
        T result = caseFormatExpr(formatExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.FORMAT_EXPR_FRAGMENT:
      {
        FormatExprFragment formatExprFragment = (FormatExprFragment)theEObject;
        T result = caseFormatExprFragment(formatExprFragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.LITERAL_FORMAT_EXPR_FRAGMENT:
      {
        LiteralFormatExprFragment literalFormatExprFragment = (LiteralFormatExprFragment)theEObject;
        T result = caseLiteralFormatExprFragment(literalFormatExprFragment);
        if (result == null) result = caseFormatExprFragment(literalFormatExprFragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.TEXT_MACRO:
      {
        TextMacro textMacro = (TextMacro)theEObject;
        T result = caseTextMacro(textMacro);
        if (result == null) result = caseMADConfigElement(textMacro);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MadConfigDslPackage.TEXT_MACRO_REF:
      {
        TextMacroRef textMacroRef = (TextMacroRef)theEObject;
        T result = caseTextMacroRef(textMacroRef);
        if (result == null) result = casePropValueExprFragment(textMacroRef);
        if (result == null) result = caseQueryFragment(textMacroRef);
        if (result == null) result = caseFormatExprFragment(textMacroRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MAD Configuration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MAD Configuration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMADConfiguration(MADConfiguration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MAD Config Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MAD Config Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMADConfigElement(MADConfigElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Descriptor Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Descriptor Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassDescriptorMdsl(ClassDescriptorMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Type Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Type Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyTypeMdsl(PropertyTypeMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyMdsl(PropertyMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Value Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Value Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyValueMdsl(PropertyValueMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prop Value Expr Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prop Value Expr Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropValueExprFragment(PropValueExprFragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Litera Prop Value Expr Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Litera Prop Value Expr Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteraPropValueExprFragment(LiteraPropValueExprFragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Icon Descriptor Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Icon Descriptor Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIconDescriptorMdsl(IconDescriptorMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>I18N Bundle Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>I18N Bundle Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseI18NBundleMdsl(I18NBundleMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Foreign Model Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Foreign Model Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForeignModelMdsl(ForeignModelMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Provider Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Provider Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelProviderMdsl(ModelProviderMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>URI Extension Model Provider Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>URI Extension Model Provider Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseURIExtensionModelProviderMdsl(URIExtensionModelProviderMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>URI Model Provider Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>URI Model Provider Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseURIModelProviderMdsl(URIModelProviderMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Custom Model Provider Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Custom Model Provider Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCustomModelProviderMdsl(CustomModelProviderMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Xtext Language Descriptor Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Xtext Language Descriptor Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXtextLanguageDescriptorMdsl(XtextLanguageDescriptorMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Xtext Language Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Xtext Language Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXtextLanguageReference(XtextLanguageReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>OCL Custom Library Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>OCL Custom Library Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOCLCustomLibraryMdsl(OCLCustomLibraryMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Evaluator Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Evaluator Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryEvaluatorMdsl(QueryEvaluatorMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Widget Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Widget Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWidgetType(WidgetType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UI Tab Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UI Tab Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUITabMdsl(UITabMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Layer Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Layer Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLayerMdsl(LayerMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Configuration Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Configuration Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeConfigurationMdsl(TypeConfigurationMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Configuration Template Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Configuration Template Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeConfigurationTemplateElement(TypeConfigurationTemplateElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Include Template Element Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Include Template Element Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIncludeTemplateElementMdsl(IncludeTemplateElementMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Converter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Converter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueConverter(ValueConverter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Based Value Converter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Based Value Converter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryBasedValueConverter(QueryBasedValueConverter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Type Value Converter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Type Value Converter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicTypeValueConverter(BasicTypeValueConverter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Widget Configuration Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Widget Configuration Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWidgetConfigurationMdsl(WidgetConfigurationMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Validator Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Validator Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValidatorMdsl(ValidatorMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommandMdsl(CommandMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommandDeclaration(CommandDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command Definition Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command Definition Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommandDefinitionMdsl(CommandDefinitionMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command Ref Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command Ref Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommandRefMdsl(CommandRefMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UI Command Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UI Command Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUICommandMdsl(UICommandMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Display View UI Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Display View UI Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDisplayViewUICommand(DisplayViewUICommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reload View UI Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reload View UI Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReloadViewUICommand(ReloadViewUICommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reload Widgets UI Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reload Widgets UI Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReloadWidgetsUICommand(ReloadWidgetsUICommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Usage</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Usage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryUsage(QueryUsage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryMdsl(QueryMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryDeclaration(QueryDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Definition Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Definition Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryDefinitionMdsl(QueryDefinitionMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryFragment(QueryFragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal Query Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal Query Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteralQueryFragment(LiteralQueryFragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryBody(QueryBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Ref Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Ref Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryRefMdsl(QueryRefMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Query Call Mdsl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Query Call Mdsl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalQueryCallMdsl(ExternalQueryCallMdsl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Chain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Chain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryChain(QueryChain object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Format Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Format Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormatExpr(FormatExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Format Expr Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Format Expr Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormatExprFragment(FormatExprFragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal Format Expr Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal Format Expr Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteralFormatExprFragment(LiteralFormatExprFragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Text Macro</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Text Macro</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTextMacro(TextMacro object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Text Macro Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Text Macro Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTextMacroRef(TextMacroRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //MadConfigDslSwitch
