/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MadConfigDslFactoryImpl extends EFactoryImpl implements MadConfigDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MadConfigDslFactory init()
  {
    try
    {
      MadConfigDslFactory theMadConfigDslFactory = (MadConfigDslFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.sysord.com/mad/configuration/MadConfigDsl"); 
      if (theMadConfigDslFactory != null)
      {
        return theMadConfigDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MadConfigDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MadConfigDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MadConfigDslPackage.MAD_CONFIGURATION: return createMADConfiguration();
      case MadConfigDslPackage.MAD_CONFIG_ELEMENT: return createMADConfigElement();
      case MadConfigDslPackage.IMPORT: return createImport();
      case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL: return createClassDescriptorMdsl();
      case MadConfigDslPackage.PROPERTY_TYPE_MDSL: return createPropertyTypeMdsl();
      case MadConfigDslPackage.PROPERTY_MDSL: return createPropertyMdsl();
      case MadConfigDslPackage.PROPERTY_VALUE_MDSL: return createPropertyValueMdsl();
      case MadConfigDslPackage.PROP_VALUE_EXPR_FRAGMENT: return createPropValueExprFragment();
      case MadConfigDslPackage.LITERA_PROP_VALUE_EXPR_FRAGMENT: return createLiteraPropValueExprFragment();
      case MadConfigDslPackage.ICON_DESCRIPTOR_MDSL: return createIconDescriptorMdsl();
      case MadConfigDslPackage.I18N_BUNDLE_MDSL: return createI18NBundleMdsl();
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL: return createForeignModelMdsl();
      case MadConfigDslPackage.MODEL_PROVIDER_MDSL: return createModelProviderMdsl();
      case MadConfigDslPackage.URI_EXTENSION_MODEL_PROVIDER_MDSL: return createURIExtensionModelProviderMdsl();
      case MadConfigDslPackage.URI_MODEL_PROVIDER_MDSL: return createURIModelProviderMdsl();
      case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL: return createCustomModelProviderMdsl();
      case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL: return createXtextLanguageDescriptorMdsl();
      case MadConfigDslPackage.XTEXT_LANGUAGE_REFERENCE: return createXtextLanguageReference();
      case MadConfigDslPackage.OCL_CUSTOM_LIBRARY_MDSL: return createOCLCustomLibraryMdsl();
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL: return createQueryEvaluatorMdsl();
      case MadConfigDslPackage.WIDGET_TYPE: return createWidgetType();
      case MadConfigDslPackage.UI_TAB_MDSL: return createUITabMdsl();
      case MadConfigDslPackage.LAYER_MDSL: return createLayerMdsl();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL: return createTypeConfigurationMdsl();
      case MadConfigDslPackage.TYPE_CONFIGURATION_TEMPLATE_ELEMENT: return createTypeConfigurationTemplateElement();
      case MadConfigDslPackage.INCLUDE_TEMPLATE_ELEMENT_MDSL: return createIncludeTemplateElementMdsl();
      case MadConfigDslPackage.VALUE_CONVERTER: return createValueConverter();
      case MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER: return createQueryBasedValueConverter();
      case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER: return createBasicTypeValueConverter();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL: return createWidgetConfigurationMdsl();
      case MadConfigDslPackage.VALIDATOR_MDSL: return createValidatorMdsl();
      case MadConfigDslPackage.COMMAND_MDSL: return createCommandMdsl();
      case MadConfigDslPackage.COMMAND_DECLARATION: return createCommandDeclaration();
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL: return createCommandDefinitionMdsl();
      case MadConfigDslPackage.COMMAND_REF_MDSL: return createCommandRefMdsl();
      case MadConfigDslPackage.UI_COMMAND_MDSL: return createUICommandMdsl();
      case MadConfigDslPackage.DISPLAY_VIEW_UI_COMMAND: return createDisplayViewUICommand();
      case MadConfigDslPackage.RELOAD_VIEW_UI_COMMAND: return createReloadViewUICommand();
      case MadConfigDslPackage.RELOAD_WIDGETS_UI_COMMAND: return createReloadWidgetsUICommand();
      case MadConfigDslPackage.QUERY_USAGE: return createQueryUsage();
      case MadConfigDslPackage.QUERY_MDSL: return createQueryMdsl();
      case MadConfigDslPackage.QUERY_DECLARATION: return createQueryDeclaration();
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL: return createQueryDefinitionMdsl();
      case MadConfigDslPackage.QUERY_FRAGMENT: return createQueryFragment();
      case MadConfigDslPackage.LITERAL_QUERY_FRAGMENT: return createLiteralQueryFragment();
      case MadConfigDslPackage.QUERY_BODY: return createQueryBody();
      case MadConfigDslPackage.QUERY_REF_MDSL: return createQueryRefMdsl();
      case MadConfigDslPackage.EXTERNAL_QUERY_CALL_MDSL: return createExternalQueryCallMdsl();
      case MadConfigDslPackage.QUERY_CHAIN: return createQueryChain();
      case MadConfigDslPackage.FORMAT_EXPR: return createFormatExpr();
      case MadConfigDslPackage.FORMAT_EXPR_FRAGMENT: return createFormatExprFragment();
      case MadConfigDslPackage.LITERAL_FORMAT_EXPR_FRAGMENT: return createLiteralFormatExprFragment();
      case MadConfigDslPackage.TEXT_MACRO: return createTextMacro();
      case MadConfigDslPackage.TEXT_MACRO_REF: return createTextMacroRef();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case MadConfigDslPackage.VALUE_CONVERTER_CATEGORY_MDSL:
        return createVALUE_CONVERTER_CATEGORY_MDSLFromString(eDataType, initialValue);
      case MadConfigDslPackage.WIDGET_CATEGORY_MDSL:
        return createWIDGET_CATEGORY_MDSLFromString(eDataType, initialValue);
      case MadConfigDslPackage.COMMAND_CATEGORY_MDSL:
        return createCOMMAND_CATEGORY_MDSLFromString(eDataType, initialValue);
      case MadConfigDslPackage.QUERY_OPTIMISATION_LEVEL:
        return createQUERY_OPTIMISATION_LEVELFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case MadConfigDslPackage.VALUE_CONVERTER_CATEGORY_MDSL:
        return convertVALUE_CONVERTER_CATEGORY_MDSLToString(eDataType, instanceValue);
      case MadConfigDslPackage.WIDGET_CATEGORY_MDSL:
        return convertWIDGET_CATEGORY_MDSLToString(eDataType, instanceValue);
      case MadConfigDslPackage.COMMAND_CATEGORY_MDSL:
        return convertCOMMAND_CATEGORY_MDSLToString(eDataType, instanceValue);
      case MadConfigDslPackage.QUERY_OPTIMISATION_LEVEL:
        return convertQUERY_OPTIMISATION_LEVELToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MADConfiguration createMADConfiguration()
  {
    MADConfigurationImpl madConfiguration = new MADConfigurationImpl();
    return madConfiguration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MADConfigElement createMADConfigElement()
  {
    MADConfigElementImpl madConfigElement = new MADConfigElementImpl();
    return madConfigElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDescriptorMdsl createClassDescriptorMdsl()
  {
    ClassDescriptorMdslImpl classDescriptorMdsl = new ClassDescriptorMdslImpl();
    return classDescriptorMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyTypeMdsl createPropertyTypeMdsl()
  {
    PropertyTypeMdslImpl propertyTypeMdsl = new PropertyTypeMdslImpl();
    return propertyTypeMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyMdsl createPropertyMdsl()
  {
    PropertyMdslImpl propertyMdsl = new PropertyMdslImpl();
    return propertyMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyValueMdsl createPropertyValueMdsl()
  {
    PropertyValueMdslImpl propertyValueMdsl = new PropertyValueMdslImpl();
    return propertyValueMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropValueExprFragment createPropValueExprFragment()
  {
    PropValueExprFragmentImpl propValueExprFragment = new PropValueExprFragmentImpl();
    return propValueExprFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteraPropValueExprFragment createLiteraPropValueExprFragment()
  {
    LiteraPropValueExprFragmentImpl literaPropValueExprFragment = new LiteraPropValueExprFragmentImpl();
    return literaPropValueExprFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IconDescriptorMdsl createIconDescriptorMdsl()
  {
    IconDescriptorMdslImpl iconDescriptorMdsl = new IconDescriptorMdslImpl();
    return iconDescriptorMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public I18NBundleMdsl createI18NBundleMdsl()
  {
    I18NBundleMdslImpl i18NBundleMdsl = new I18NBundleMdslImpl();
    return i18NBundleMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForeignModelMdsl createForeignModelMdsl()
  {
    ForeignModelMdslImpl foreignModelMdsl = new ForeignModelMdslImpl();
    return foreignModelMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelProviderMdsl createModelProviderMdsl()
  {
    ModelProviderMdslImpl modelProviderMdsl = new ModelProviderMdslImpl();
    return modelProviderMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URIExtensionModelProviderMdsl createURIExtensionModelProviderMdsl()
  {
    URIExtensionModelProviderMdslImpl uriExtensionModelProviderMdsl = new URIExtensionModelProviderMdslImpl();
    return uriExtensionModelProviderMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URIModelProviderMdsl createURIModelProviderMdsl()
  {
    URIModelProviderMdslImpl uriModelProviderMdsl = new URIModelProviderMdslImpl();
    return uriModelProviderMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomModelProviderMdsl createCustomModelProviderMdsl()
  {
    CustomModelProviderMdslImpl customModelProviderMdsl = new CustomModelProviderMdslImpl();
    return customModelProviderMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextLanguageDescriptorMdsl createXtextLanguageDescriptorMdsl()
  {
    XtextLanguageDescriptorMdslImpl xtextLanguageDescriptorMdsl = new XtextLanguageDescriptorMdslImpl();
    return xtextLanguageDescriptorMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextLanguageReference createXtextLanguageReference()
  {
    XtextLanguageReferenceImpl xtextLanguageReference = new XtextLanguageReferenceImpl();
    return xtextLanguageReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OCLCustomLibraryMdsl createOCLCustomLibraryMdsl()
  {
    OCLCustomLibraryMdslImpl oclCustomLibraryMdsl = new OCLCustomLibraryMdslImpl();
    return oclCustomLibraryMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryEvaluatorMdsl createQueryEvaluatorMdsl()
  {
    QueryEvaluatorMdslImpl queryEvaluatorMdsl = new QueryEvaluatorMdslImpl();
    return queryEvaluatorMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WidgetType createWidgetType()
  {
    WidgetTypeImpl widgetType = new WidgetTypeImpl();
    return widgetType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UITabMdsl createUITabMdsl()
  {
    UITabMdslImpl uiTabMdsl = new UITabMdslImpl();
    return uiTabMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LayerMdsl createLayerMdsl()
  {
    LayerMdslImpl layerMdsl = new LayerMdslImpl();
    return layerMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeConfigurationMdsl createTypeConfigurationMdsl()
  {
    TypeConfigurationMdslImpl typeConfigurationMdsl = new TypeConfigurationMdslImpl();
    return typeConfigurationMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeConfigurationTemplateElement createTypeConfigurationTemplateElement()
  {
    TypeConfigurationTemplateElementImpl typeConfigurationTemplateElement = new TypeConfigurationTemplateElementImpl();
    return typeConfigurationTemplateElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncludeTemplateElementMdsl createIncludeTemplateElementMdsl()
  {
    IncludeTemplateElementMdslImpl includeTemplateElementMdsl = new IncludeTemplateElementMdslImpl();
    return includeTemplateElementMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueConverter createValueConverter()
  {
    ValueConverterImpl valueConverter = new ValueConverterImpl();
    return valueConverter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryBasedValueConverter createQueryBasedValueConverter()
  {
    QueryBasedValueConverterImpl queryBasedValueConverter = new QueryBasedValueConverterImpl();
    return queryBasedValueConverter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BasicTypeValueConverter createBasicTypeValueConverter()
  {
    BasicTypeValueConverterImpl basicTypeValueConverter = new BasicTypeValueConverterImpl();
    return basicTypeValueConverter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WidgetConfigurationMdsl createWidgetConfigurationMdsl()
  {
    WidgetConfigurationMdslImpl widgetConfigurationMdsl = new WidgetConfigurationMdslImpl();
    return widgetConfigurationMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValidatorMdsl createValidatorMdsl()
  {
    ValidatorMdslImpl validatorMdsl = new ValidatorMdslImpl();
    return validatorMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommandMdsl createCommandMdsl()
  {
    CommandMdslImpl commandMdsl = new CommandMdslImpl();
    return commandMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommandDeclaration createCommandDeclaration()
  {
    CommandDeclarationImpl commandDeclaration = new CommandDeclarationImpl();
    return commandDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommandDefinitionMdsl createCommandDefinitionMdsl()
  {
    CommandDefinitionMdslImpl commandDefinitionMdsl = new CommandDefinitionMdslImpl();
    return commandDefinitionMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommandRefMdsl createCommandRefMdsl()
  {
    CommandRefMdslImpl commandRefMdsl = new CommandRefMdslImpl();
    return commandRefMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UICommandMdsl createUICommandMdsl()
  {
    UICommandMdslImpl uiCommandMdsl = new UICommandMdslImpl();
    return uiCommandMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DisplayViewUICommand createDisplayViewUICommand()
  {
    DisplayViewUICommandImpl displayViewUICommand = new DisplayViewUICommandImpl();
    return displayViewUICommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReloadViewUICommand createReloadViewUICommand()
  {
    ReloadViewUICommandImpl reloadViewUICommand = new ReloadViewUICommandImpl();
    return reloadViewUICommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReloadWidgetsUICommand createReloadWidgetsUICommand()
  {
    ReloadWidgetsUICommandImpl reloadWidgetsUICommand = new ReloadWidgetsUICommandImpl();
    return reloadWidgetsUICommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryUsage createQueryUsage()
  {
    QueryUsageImpl queryUsage = new QueryUsageImpl();
    return queryUsage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryMdsl createQueryMdsl()
  {
    QueryMdslImpl queryMdsl = new QueryMdslImpl();
    return queryMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryDeclaration createQueryDeclaration()
  {
    QueryDeclarationImpl queryDeclaration = new QueryDeclarationImpl();
    return queryDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryDefinitionMdsl createQueryDefinitionMdsl()
  {
    QueryDefinitionMdslImpl queryDefinitionMdsl = new QueryDefinitionMdslImpl();
    return queryDefinitionMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryFragment createQueryFragment()
  {
    QueryFragmentImpl queryFragment = new QueryFragmentImpl();
    return queryFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralQueryFragment createLiteralQueryFragment()
  {
    LiteralQueryFragmentImpl literalQueryFragment = new LiteralQueryFragmentImpl();
    return literalQueryFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryBody createQueryBody()
  {
    QueryBodyImpl queryBody = new QueryBodyImpl();
    return queryBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryRefMdsl createQueryRefMdsl()
  {
    QueryRefMdslImpl queryRefMdsl = new QueryRefMdslImpl();
    return queryRefMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalQueryCallMdsl createExternalQueryCallMdsl()
  {
    ExternalQueryCallMdslImpl externalQueryCallMdsl = new ExternalQueryCallMdslImpl();
    return externalQueryCallMdsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryChain createQueryChain()
  {
    QueryChainImpl queryChain = new QueryChainImpl();
    return queryChain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormatExpr createFormatExpr()
  {
    FormatExprImpl formatExpr = new FormatExprImpl();
    return formatExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormatExprFragment createFormatExprFragment()
  {
    FormatExprFragmentImpl formatExprFragment = new FormatExprFragmentImpl();
    return formatExprFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralFormatExprFragment createLiteralFormatExprFragment()
  {
    LiteralFormatExprFragmentImpl literalFormatExprFragment = new LiteralFormatExprFragmentImpl();
    return literalFormatExprFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextMacro createTextMacro()
  {
    TextMacroImpl textMacro = new TextMacroImpl();
    return textMacro;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextMacroRef createTextMacroRef()
  {
    TextMacroRefImpl textMacroRef = new TextMacroRefImpl();
    return textMacroRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VALUE_CONVERTER_CATEGORY_MDSL createVALUE_CONVERTER_CATEGORY_MDSLFromString(EDataType eDataType, String initialValue)
  {
    VALUE_CONVERTER_CATEGORY_MDSL result = VALUE_CONVERTER_CATEGORY_MDSL.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVALUE_CONVERTER_CATEGORY_MDSLToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WIDGET_CATEGORY_MDSL createWIDGET_CATEGORY_MDSLFromString(EDataType eDataType, String initialValue)
  {
    WIDGET_CATEGORY_MDSL result = WIDGET_CATEGORY_MDSL.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertWIDGET_CATEGORY_MDSLToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public COMMAND_CATEGORY_MDSL createCOMMAND_CATEGORY_MDSLFromString(EDataType eDataType, String initialValue)
  {
    COMMAND_CATEGORY_MDSL result = COMMAND_CATEGORY_MDSL.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCOMMAND_CATEGORY_MDSLToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QUERY_OPTIMISATION_LEVEL createQUERY_OPTIMISATION_LEVELFromString(EDataType eDataType, String initialValue)
  {
    QUERY_OPTIMISATION_LEVEL result = QUERY_OPTIMISATION_LEVEL.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertQUERY_OPTIMISATION_LEVELToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MadConfigDslPackage getMadConfigDslPackage()
  {
    return (MadConfigDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MadConfigDslPackage getPackage()
  {
    return MadConfigDslPackage.eINSTANCE;
  }

} //MadConfigDslFactoryImpl
