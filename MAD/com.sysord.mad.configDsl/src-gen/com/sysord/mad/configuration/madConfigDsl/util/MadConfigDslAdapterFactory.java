/**
 */
package com.sysord.mad.configuration.madConfigDsl.util;

import com.sysord.mad.configuration.madConfigDsl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage
 * @generated
 */
public class MadConfigDslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MadConfigDslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MadConfigDslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = MadConfigDslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MadConfigDslSwitch<Adapter> modelSwitch =
    new MadConfigDslSwitch<Adapter>()
    {
      @Override
      public Adapter caseMADConfiguration(MADConfiguration object)
      {
        return createMADConfigurationAdapter();
      }
      @Override
      public Adapter caseMADConfigElement(MADConfigElement object)
      {
        return createMADConfigElementAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseClassDescriptorMdsl(ClassDescriptorMdsl object)
      {
        return createClassDescriptorMdslAdapter();
      }
      @Override
      public Adapter casePropertyTypeMdsl(PropertyTypeMdsl object)
      {
        return createPropertyTypeMdslAdapter();
      }
      @Override
      public Adapter casePropertyMdsl(PropertyMdsl object)
      {
        return createPropertyMdslAdapter();
      }
      @Override
      public Adapter casePropertyValueMdsl(PropertyValueMdsl object)
      {
        return createPropertyValueMdslAdapter();
      }
      @Override
      public Adapter casePropValueExprFragment(PropValueExprFragment object)
      {
        return createPropValueExprFragmentAdapter();
      }
      @Override
      public Adapter caseLiteraPropValueExprFragment(LiteraPropValueExprFragment object)
      {
        return createLiteraPropValueExprFragmentAdapter();
      }
      @Override
      public Adapter caseIconDescriptorMdsl(IconDescriptorMdsl object)
      {
        return createIconDescriptorMdslAdapter();
      }
      @Override
      public Adapter caseI18NBundleMdsl(I18NBundleMdsl object)
      {
        return createI18NBundleMdslAdapter();
      }
      @Override
      public Adapter caseForeignModelMdsl(ForeignModelMdsl object)
      {
        return createForeignModelMdslAdapter();
      }
      @Override
      public Adapter caseModelProviderMdsl(ModelProviderMdsl object)
      {
        return createModelProviderMdslAdapter();
      }
      @Override
      public Adapter caseURIExtensionModelProviderMdsl(URIExtensionModelProviderMdsl object)
      {
        return createURIExtensionModelProviderMdslAdapter();
      }
      @Override
      public Adapter caseURIModelProviderMdsl(URIModelProviderMdsl object)
      {
        return createURIModelProviderMdslAdapter();
      }
      @Override
      public Adapter caseCustomModelProviderMdsl(CustomModelProviderMdsl object)
      {
        return createCustomModelProviderMdslAdapter();
      }
      @Override
      public Adapter caseXtextLanguageDescriptorMdsl(XtextLanguageDescriptorMdsl object)
      {
        return createXtextLanguageDescriptorMdslAdapter();
      }
      @Override
      public Adapter caseXtextLanguageReference(XtextLanguageReference object)
      {
        return createXtextLanguageReferenceAdapter();
      }
      @Override
      public Adapter caseOCLCustomLibraryMdsl(OCLCustomLibraryMdsl object)
      {
        return createOCLCustomLibraryMdslAdapter();
      }
      @Override
      public Adapter caseQueryEvaluatorMdsl(QueryEvaluatorMdsl object)
      {
        return createQueryEvaluatorMdslAdapter();
      }
      @Override
      public Adapter caseWidgetType(WidgetType object)
      {
        return createWidgetTypeAdapter();
      }
      @Override
      public Adapter caseUITabMdsl(UITabMdsl object)
      {
        return createUITabMdslAdapter();
      }
      @Override
      public Adapter caseLayerMdsl(LayerMdsl object)
      {
        return createLayerMdslAdapter();
      }
      @Override
      public Adapter caseTypeConfigurationMdsl(TypeConfigurationMdsl object)
      {
        return createTypeConfigurationMdslAdapter();
      }
      @Override
      public Adapter caseTypeConfigurationTemplateElement(TypeConfigurationTemplateElement object)
      {
        return createTypeConfigurationTemplateElementAdapter();
      }
      @Override
      public Adapter caseIncludeTemplateElementMdsl(IncludeTemplateElementMdsl object)
      {
        return createIncludeTemplateElementMdslAdapter();
      }
      @Override
      public Adapter caseValueConverter(ValueConverter object)
      {
        return createValueConverterAdapter();
      }
      @Override
      public Adapter caseQueryBasedValueConverter(QueryBasedValueConverter object)
      {
        return createQueryBasedValueConverterAdapter();
      }
      @Override
      public Adapter caseBasicTypeValueConverter(BasicTypeValueConverter object)
      {
        return createBasicTypeValueConverterAdapter();
      }
      @Override
      public Adapter caseWidgetConfigurationMdsl(WidgetConfigurationMdsl object)
      {
        return createWidgetConfigurationMdslAdapter();
      }
      @Override
      public Adapter caseValidatorMdsl(ValidatorMdsl object)
      {
        return createValidatorMdslAdapter();
      }
      @Override
      public Adapter caseCommandMdsl(CommandMdsl object)
      {
        return createCommandMdslAdapter();
      }
      @Override
      public Adapter caseCommandDeclaration(CommandDeclaration object)
      {
        return createCommandDeclarationAdapter();
      }
      @Override
      public Adapter caseCommandDefinitionMdsl(CommandDefinitionMdsl object)
      {
        return createCommandDefinitionMdslAdapter();
      }
      @Override
      public Adapter caseCommandRefMdsl(CommandRefMdsl object)
      {
        return createCommandRefMdslAdapter();
      }
      @Override
      public Adapter caseUICommandMdsl(UICommandMdsl object)
      {
        return createUICommandMdslAdapter();
      }
      @Override
      public Adapter caseDisplayViewUICommand(DisplayViewUICommand object)
      {
        return createDisplayViewUICommandAdapter();
      }
      @Override
      public Adapter caseReloadViewUICommand(ReloadViewUICommand object)
      {
        return createReloadViewUICommandAdapter();
      }
      @Override
      public Adapter caseReloadWidgetsUICommand(ReloadWidgetsUICommand object)
      {
        return createReloadWidgetsUICommandAdapter();
      }
      @Override
      public Adapter caseQueryUsage(QueryUsage object)
      {
        return createQueryUsageAdapter();
      }
      @Override
      public Adapter caseQueryMdsl(QueryMdsl object)
      {
        return createQueryMdslAdapter();
      }
      @Override
      public Adapter caseQueryDeclaration(QueryDeclaration object)
      {
        return createQueryDeclarationAdapter();
      }
      @Override
      public Adapter caseQueryDefinitionMdsl(QueryDefinitionMdsl object)
      {
        return createQueryDefinitionMdslAdapter();
      }
      @Override
      public Adapter caseQueryFragment(QueryFragment object)
      {
        return createQueryFragmentAdapter();
      }
      @Override
      public Adapter caseLiteralQueryFragment(LiteralQueryFragment object)
      {
        return createLiteralQueryFragmentAdapter();
      }
      @Override
      public Adapter caseQueryBody(QueryBody object)
      {
        return createQueryBodyAdapter();
      }
      @Override
      public Adapter caseQueryRefMdsl(QueryRefMdsl object)
      {
        return createQueryRefMdslAdapter();
      }
      @Override
      public Adapter caseExternalQueryCallMdsl(ExternalQueryCallMdsl object)
      {
        return createExternalQueryCallMdslAdapter();
      }
      @Override
      public Adapter caseQueryChain(QueryChain object)
      {
        return createQueryChainAdapter();
      }
      @Override
      public Adapter caseFormatExpr(FormatExpr object)
      {
        return createFormatExprAdapter();
      }
      @Override
      public Adapter caseFormatExprFragment(FormatExprFragment object)
      {
        return createFormatExprFragmentAdapter();
      }
      @Override
      public Adapter caseLiteralFormatExprFragment(LiteralFormatExprFragment object)
      {
        return createLiteralFormatExprFragmentAdapter();
      }
      @Override
      public Adapter caseTextMacro(TextMacro object)
      {
        return createTextMacroAdapter();
      }
      @Override
      public Adapter caseTextMacroRef(TextMacroRef object)
      {
        return createTextMacroRefAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.MADConfiguration <em>MAD Configuration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.MADConfiguration
   * @generated
   */
  public Adapter createMADConfigurationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.MADConfigElement <em>MAD Config Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.MADConfigElement
   * @generated
   */
  public Adapter createMADConfigElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl <em>Class Descriptor Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl
   * @generated
   */
  public Adapter createClassDescriptorMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl <em>Property Type Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl
   * @generated
   */
  public Adapter createPropertyTypeMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.PropertyMdsl <em>Property Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyMdsl
   * @generated
   */
  public Adapter createPropertyMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.PropertyValueMdsl <em>Property Value Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyValueMdsl
   * @generated
   */
  public Adapter createPropertyValueMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.PropValueExprFragment <em>Prop Value Expr Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.PropValueExprFragment
   * @generated
   */
  public Adapter createPropValueExprFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.LiteraPropValueExprFragment <em>Litera Prop Value Expr Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.LiteraPropValueExprFragment
   * @generated
   */
  public Adapter createLiteraPropValueExprFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl <em>Icon Descriptor Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl
   * @generated
   */
  public Adapter createIconDescriptorMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl <em>I18N Bundle Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl
   * @generated
   */
  public Adapter createI18NBundleMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl <em>Foreign Model Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl
   * @generated
   */
  public Adapter createForeignModelMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.ModelProviderMdsl <em>Model Provider Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.ModelProviderMdsl
   * @generated
   */
  public Adapter createModelProviderMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.URIExtensionModelProviderMdsl <em>URI Extension Model Provider Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.URIExtensionModelProviderMdsl
   * @generated
   */
  public Adapter createURIExtensionModelProviderMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.URIModelProviderMdsl <em>URI Model Provider Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.URIModelProviderMdsl
   * @generated
   */
  public Adapter createURIModelProviderMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl <em>Custom Model Provider Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl
   * @generated
   */
  public Adapter createCustomModelProviderMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl <em>Xtext Language Descriptor Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl
   * @generated
   */
  public Adapter createXtextLanguageDescriptorMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference <em>Xtext Language Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference
   * @generated
   */
  public Adapter createXtextLanguageReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl <em>OCL Custom Library Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl
   * @generated
   */
  public Adapter createOCLCustomLibraryMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl <em>Query Evaluator Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl
   * @generated
   */
  public Adapter createQueryEvaluatorMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType <em>Widget Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetType
   * @generated
   */
  public Adapter createWidgetTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.UITabMdsl <em>UI Tab Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.UITabMdsl
   * @generated
   */
  public Adapter createUITabMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl <em>Layer Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.LayerMdsl
   * @generated
   */
  public Adapter createLayerMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl <em>Type Configuration Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl
   * @generated
   */
  public Adapter createTypeConfigurationMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement <em>Type Configuration Template Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement
   * @generated
   */
  public Adapter createTypeConfigurationTemplateElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl <em>Include Template Element Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl
   * @generated
   */
  public Adapter createIncludeTemplateElementMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.ValueConverter <em>Value Converter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.ValueConverter
   * @generated
   */
  public Adapter createValueConverterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter <em>Query Based Value Converter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter
   * @generated
   */
  public Adapter createQueryBasedValueConverterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter <em>Basic Type Value Converter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter
   * @generated
   */
  public Adapter createBasicTypeValueConverterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl <em>Widget Configuration Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl
   * @generated
   */
  public Adapter createWidgetConfigurationMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl <em>Validator Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl
   * @generated
   */
  public Adapter createValidatorMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.CommandMdsl <em>Command Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandMdsl
   * @generated
   */
  public Adapter createCommandMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.CommandDeclaration <em>Command Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDeclaration
   * @generated
   */
  public Adapter createCommandDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl <em>Command Definition Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl
   * @generated
   */
  public Adapter createCommandDefinitionMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl <em>Command Ref Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl
   * @generated
   */
  public Adapter createCommandRefMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.UICommandMdsl <em>UI Command Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.UICommandMdsl
   * @generated
   */
  public Adapter createUICommandMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.DisplayViewUICommand <em>Display View UI Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.DisplayViewUICommand
   * @generated
   */
  public Adapter createDisplayViewUICommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.ReloadViewUICommand <em>Reload View UI Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.ReloadViewUICommand
   * @generated
   */
  public Adapter createReloadViewUICommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand <em>Reload Widgets UI Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand
   * @generated
   */
  public Adapter createReloadWidgetsUICommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.QueryUsage <em>Query Usage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryUsage
   * @generated
   */
  public Adapter createQueryUsageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.QueryMdsl <em>Query Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryMdsl
   * @generated
   */
  public Adapter createQueryMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.QueryDeclaration <em>Query Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDeclaration
   * @generated
   */
  public Adapter createQueryDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl <em>Query Definition Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl
   * @generated
   */
  public Adapter createQueryDefinitionMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.QueryFragment <em>Query Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryFragment
   * @generated
   */
  public Adapter createQueryFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.LiteralQueryFragment <em>Literal Query Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.LiteralQueryFragment
   * @generated
   */
  public Adapter createLiteralQueryFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.QueryBody <em>Query Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryBody
   * @generated
   */
  public Adapter createQueryBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.QueryRefMdsl <em>Query Ref Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryRefMdsl
   * @generated
   */
  public Adapter createQueryRefMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl <em>External Query Call Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl
   * @generated
   */
  public Adapter createExternalQueryCallMdslAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.QueryChain <em>Query Chain</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryChain
   * @generated
   */
  public Adapter createQueryChainAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.FormatExpr <em>Format Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.FormatExpr
   * @generated
   */
  public Adapter createFormatExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.FormatExprFragment <em>Format Expr Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.FormatExprFragment
   * @generated
   */
  public Adapter createFormatExprFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.LiteralFormatExprFragment <em>Literal Format Expr Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.LiteralFormatExprFragment
   * @generated
   */
  public Adapter createLiteralFormatExprFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.TextMacro <em>Text Macro</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.TextMacro
   * @generated
   */
  public Adapter createTextMacroAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.sysord.mad.configuration.madConfigDsl.TextMacroRef <em>Text Macro Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.sysord.mad.configuration.madConfigDsl.TextMacroRef
   * @generated
   */
  public Adapter createTextMacroRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //MadConfigDslAdapterFactory
