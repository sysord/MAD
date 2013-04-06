/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter;
import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandDeclaration;
import com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl;
import com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.DisplayViewUICommand;
import com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl;
import com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl;
import com.sysord.mad.configuration.madConfigDsl.FormatExpr;
import com.sysord.mad.configuration.madConfigDsl.FormatExprFragment;
import com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl;
import com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.Import;
import com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl;
import com.sysord.mad.configuration.madConfigDsl.LayerMdsl;
import com.sysord.mad.configuration.madConfigDsl.LiteraPropValueExprFragment;
import com.sysord.mad.configuration.madConfigDsl.LiteralFormatExprFragment;
import com.sysord.mad.configuration.madConfigDsl.LiteralQueryFragment;
import com.sysord.mad.configuration.madConfigDsl.MADConfigElement;
import com.sysord.mad.configuration.madConfigDsl.MADConfiguration;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslFactory;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.ModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.PropValueExprFragment;
import com.sysord.mad.configuration.madConfigDsl.PropertyMdsl;
import com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl;
import com.sysord.mad.configuration.madConfigDsl.PropertyValueMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter;
import com.sysord.mad.configuration.madConfigDsl.QueryBody;
import com.sysord.mad.configuration.madConfigDsl.QueryChain;
import com.sysord.mad.configuration.madConfigDsl.QueryDeclaration;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryFragment;
import com.sysord.mad.configuration.madConfigDsl.QueryMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryRefMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryUsage;
import com.sysord.mad.configuration.madConfigDsl.ReloadViewUICommand;
import com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand;
import com.sysord.mad.configuration.madConfigDsl.TextMacro;
import com.sysord.mad.configuration.madConfigDsl.TextMacroRef;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement;
import com.sysord.mad.configuration.madConfigDsl.UICommandMdsl;
import com.sysord.mad.configuration.madConfigDsl.UITabMdsl;
import com.sysord.mad.configuration.madConfigDsl.URIExtensionModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.URIModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl;
import com.sysord.mad.configuration.madConfigDsl.ValueConverter;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.WidgetType;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MadConfigDslPackageImpl extends EPackageImpl implements MadConfigDslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass madConfigurationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass madConfigElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classDescriptorMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyTypeMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyValueMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propValueExprFragmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literaPropValueExprFragmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iconDescriptorMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass i18NBundleMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass foreignModelMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelProviderMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass uriExtensionModelProviderMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass uriModelProviderMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass customModelProviderMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xtextLanguageDescriptorMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xtextLanguageReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryEvaluatorMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass widgetTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass uiTabMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass layerMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeConfigurationMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeConfigurationTemplateElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass includeTemplateElementMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueConverterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryBasedValueConverterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass basicTypeValueConverterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass widgetConfigurationMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass validatorMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commandMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commandDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commandDefinitionMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commandRefMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass uiCommandMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass displayViewUICommandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reloadViewUICommandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reloadWidgetsUICommandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryUsageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryDefinitionMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryFragmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalQueryFragmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryRefMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalQueryCallMdslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryChainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formatExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formatExprFragmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalFormatExprFragmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass textMacroEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass textMacroRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum valuE_CONVERTER_CATEGORY_MDSLEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum widgeT_CATEGORY_MDSLEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum commanD_CATEGORY_MDSLEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum querY_OPTIMISATION_LEVELEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MadConfigDslPackageImpl()
  {
    super(eNS_URI, MadConfigDslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link MadConfigDslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MadConfigDslPackage init()
  {
    if (isInited) return (MadConfigDslPackage)EPackage.Registry.INSTANCE.getEPackage(MadConfigDslPackage.eNS_URI);

    // Obtain or create and register package
    MadConfigDslPackageImpl theMadConfigDslPackage = (MadConfigDslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MadConfigDslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MadConfigDslPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theMadConfigDslPackage.createPackageContents();

    // Initialize created meta-data
    theMadConfigDslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMadConfigDslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MadConfigDslPackage.eNS_URI, theMadConfigDslPackage);
    return theMadConfigDslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMADConfiguration()
  {
    return madConfigurationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMADConfiguration_Imports()
  {
    return (EReference)madConfigurationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMADConfiguration_ConfigElements()
  {
    return (EReference)madConfigurationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMADConfigElement()
  {
    return madConfigElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMADConfigElement_Name()
  {
    return (EAttribute)madConfigElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportURI()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassDescriptorMdsl()
  {
    return classDescriptorMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassDescriptorMdsl_ClassName()
  {
    return (EAttribute)classDescriptorMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassDescriptorMdsl_PluginId()
  {
    return (EAttribute)classDescriptorMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyTypeMdsl()
  {
    return propertyTypeMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPropertyTypeMdsl_Name()
  {
    return (EAttribute)propertyTypeMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPropertyTypeMdsl_Label()
  {
    return (EAttribute)propertyTypeMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyMdsl()
  {
    return propertyMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyMdsl_PropertyName()
  {
    return (EReference)propertyMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyMdsl_PropertyValue()
  {
    return (EReference)propertyMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyValueMdsl()
  {
    return propertyValueMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyValueMdsl_Fragments()
  {
    return (EReference)propertyValueMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropValueExprFragment()
  {
    return propValueExprFragmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteraPropValueExprFragment()
  {
    return literaPropValueExprFragmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteraPropValueExprFragment_Value()
  {
    return (EAttribute)literaPropValueExprFragmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIconDescriptorMdsl()
  {
    return iconDescriptorMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIconDescriptorMdsl_Description()
  {
    return (EAttribute)iconDescriptorMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIconDescriptorMdsl_BundleDescriptor()
  {
    return (EReference)iconDescriptorMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIconDescriptorMdsl_BundleUri()
  {
    return (EAttribute)iconDescriptorMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getI18NBundleMdsl()
  {
    return i18NBundleMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getI18NBundleMdsl_Description()
  {
    return (EAttribute)i18NBundleMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getI18NBundleMdsl_BundleDescriptor()
  {
    return (EReference)i18NBundleMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getI18NBundleMdsl_BundleUri()
  {
    return (EAttribute)i18NBundleMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForeignModelMdsl()
  {
    return foreignModelMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getForeignModelMdsl_Label()
  {
    return (EAttribute)foreignModelMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getForeignModelMdsl_Description()
  {
    return (EAttribute)foreignModelMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForeignModelMdsl_Provider()
  {
    return (EReference)foreignModelMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForeignModelMdsl_SynchronizerFactoryClass()
  {
    return (EReference)foreignModelMdslEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForeignModelMdsl_ExtensionManagerClass()
  {
    return (EReference)foreignModelMdslEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForeignModelMdsl_DslReference()
  {
    return (EReference)foreignModelMdslEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForeignModelMdsl_RelocatorQuery()
  {
    return (EReference)foreignModelMdslEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModelProviderMdsl()
  {
    return modelProviderMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getURIExtensionModelProviderMdsl()
  {
    return uriExtensionModelProviderMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getURIExtensionModelProviderMdsl_UriExtension()
  {
    return (EAttribute)uriExtensionModelProviderMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getURIModelProviderMdsl()
  {
    return uriModelProviderMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getURIModelProviderMdsl_ModelUri()
  {
    return (EAttribute)uriModelProviderMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCustomModelProviderMdsl()
  {
    return customModelProviderMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCustomModelProviderMdsl_ClassDescriptor()
  {
    return (EReference)customModelProviderMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCustomModelProviderMdsl_Parameters()
  {
    return (EAttribute)customModelProviderMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXtextLanguageDescriptorMdsl()
  {
    return xtextLanguageDescriptorMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXtextLanguageDescriptorMdsl_LanguageId()
  {
    return (EAttribute)xtextLanguageDescriptorMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXtextLanguageDescriptorMdsl_BundleId()
  {
    return (EAttribute)xtextLanguageDescriptorMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXtextLanguageDescriptorMdsl_ActivatorClassName()
  {
    return (EAttribute)xtextLanguageDescriptorMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXtextLanguageReference()
  {
    return xtextLanguageReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXtextLanguageReference_XtextLanguageDescriptor()
  {
    return (EReference)xtextLanguageReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryEvaluatorMdsl()
  {
    return queryEvaluatorMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQueryEvaluatorMdsl_Label()
  {
    return (EAttribute)queryEvaluatorMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryEvaluatorMdsl_ClassDescriptor()
  {
    return (EReference)queryEvaluatorMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryEvaluatorMdsl_QueryPropertiesTypes()
  {
    return (EReference)queryEvaluatorMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryEvaluatorMdsl_ExtQServiceClassDescriptor()
  {
    return (EReference)queryEvaluatorMdslEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQueryEvaluatorMdsl_Description()
  {
    return (EAttribute)queryEvaluatorMdslEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWidgetType()
  {
    return widgetTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWidgetType_Category()
  {
    return (EAttribute)widgetTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWidgetType_Label()
  {
    return (EAttribute)widgetTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetType_ClassDescriptor()
  {
    return (EReference)widgetTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWidgetType_Description()
  {
    return (EAttribute)widgetTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUITabMdsl()
  {
    return uiTabMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUITabMdsl_I18NLabel()
  {
    return (EAttribute)uiTabMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUITabMdsl_LabelFormatExpr()
  {
    return (EReference)uiTabMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUITabMdsl_Description()
  {
    return (EAttribute)uiTabMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLayerMdsl()
  {
    return layerMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLayerMdsl_I18NLabel()
  {
    return (EAttribute)layerMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLayerMdsl_LabelFormatExpr()
  {
    return (EReference)layerMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLayerMdsl_Description()
  {
    return (EAttribute)layerMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLayerMdsl_SubLayers()
  {
    return (EReference)layerMdslEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeConfigurationMdsl()
  {
    return typeConfigurationMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeConfigurationMdsl_DefaultConfiguration()
  {
    return (EAttribute)typeConfigurationMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeConfigurationMdsl_Type()
  {
    return (EReference)typeConfigurationMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeConfigurationMdsl_I18NLabelProvider()
  {
    return (EAttribute)typeConfigurationMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeConfigurationMdsl_LabelProviderExpression()
  {
    return (EReference)typeConfigurationMdslEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeConfigurationMdsl_UseExplicitExtends()
  {
    return (EAttribute)typeConfigurationMdslEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeConfigurationMdsl_SuperConfigurations()
  {
    return (EReference)typeConfigurationMdslEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeConfigurationMdsl_TemplateElements()
  {
    return (EReference)typeConfigurationMdslEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeConfigurationMdsl_LayoutDefined()
  {
    return (EAttribute)typeConfigurationMdslEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeConfigurationMdsl_LayoutElements()
  {
    return (EReference)typeConfigurationMdslEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeConfigurationTemplateElement()
  {
    return typeConfigurationTemplateElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeConfigurationTemplateElement_Name()
  {
    return (EAttribute)typeConfigurationTemplateElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeConfigurationTemplateElement_ValueQuery()
  {
    return (EReference)typeConfigurationTemplateElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIncludeTemplateElementMdsl()
  {
    return includeTemplateElementMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIncludeTemplateElementMdsl_RefIncludedTemplate()
  {
    return (EReference)includeTemplateElementMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueConverter()
  {
    return valueConverterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryBasedValueConverter()
  {
    return queryBasedValueConverterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryBasedValueConverter_ConverterQuery()
  {
    return (EReference)queryBasedValueConverterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBasicTypeValueConverter()
  {
    return basicTypeValueConverterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBasicTypeValueConverter_Category()
  {
    return (EAttribute)basicTypeValueConverterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBasicTypeValueConverter_Configuration()
  {
    return (EAttribute)basicTypeValueConverterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWidgetConfigurationMdsl()
  {
    return widgetConfigurationMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWidgetConfigurationMdsl_Description()
  {
    return (EAttribute)widgetConfigurationMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_UiTab()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_Layers()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWidgetConfigurationMdsl_I18NLabel()
  {
    return (EAttribute)widgetConfigurationMdslEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_Label()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWidgetConfigurationMdsl_WidgetCategory()
  {
    return (EAttribute)widgetConfigurationMdslEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_WidgetType()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_DslReference()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_FlexibleTemplate()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_VisibilityQuery()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_EditableQuery()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_ValueConverter()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_Validators()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWidgetConfigurationMdsl_I18NFormat()
  {
    return (EAttribute)widgetConfigurationMdslEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_ValueFormat()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_CandidatesQuery()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(15);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWidgetConfigurationMdsl_I18NItemLabel()
  {
    return (EAttribute)widgetConfigurationMdslEClass.getEStructuralFeatures().get(16);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_ItemLabelExpression()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(17);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWidgetConfigurationMdsl_Commands()
  {
    return (EReference)widgetConfigurationMdslEClass.getEStructuralFeatures().get(18);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValidatorMdsl()
  {
    return validatorMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValidatorMdsl_ValidationQuery()
  {
    return (EReference)validatorMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValidatorMdsl_I18NMessage()
  {
    return (EAttribute)validatorMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValidatorMdsl_ErrorMessageExpr()
  {
    return (EReference)validatorMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommandMdsl()
  {
    return commandMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommandDeclaration()
  {
    return commandDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCommandDeclaration_Label()
  {
    return (EAttribute)commandDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCommandDeclaration_Description()
  {
    return (EAttribute)commandDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommandDeclaration_Definition()
  {
    return (EReference)commandDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommandDefinitionMdsl()
  {
    return commandDefinitionMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCommandDefinitionMdsl_Category()
  {
    return (EAttribute)commandDefinitionMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCommandDefinitionMdsl_I18NLabel()
  {
    return (EAttribute)commandDefinitionMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommandDefinitionMdsl_Label()
  {
    return (EReference)commandDefinitionMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommandDefinitionMdsl_Icon()
  {
    return (EReference)commandDefinitionMdslEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommandDefinitionMdsl_Action()
  {
    return (EReference)commandDefinitionMdslEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommandDefinitionMdsl_OnActionSuccessUICommands()
  {
    return (EReference)commandDefinitionMdslEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommandDefinitionMdsl_OnActionErrorUICommands()
  {
    return (EReference)commandDefinitionMdslEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommandRefMdsl()
  {
    return commandRefMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommandRefMdsl_Referenced()
  {
    return (EReference)commandRefMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCommandRefMdsl_I18NLabelOverride()
  {
    return (EAttribute)commandRefMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommandRefMdsl_LabelOverride()
  {
    return (EReference)commandRefMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUICommandMdsl()
  {
    return uiCommandMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDisplayViewUICommand()
  {
    return displayViewUICommandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDisplayViewUICommand_Target()
  {
    return (EReference)displayViewUICommandEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReloadViewUICommand()
  {
    return reloadViewUICommandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReloadWidgetsUICommand()
  {
    return reloadWidgetsUICommandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReloadWidgetsUICommand_WidgetsToReload()
  {
    return (EReference)reloadWidgetsUICommandEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryUsage()
  {
    return queryUsageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryMdsl()
  {
    return queryMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryDeclaration()
  {
    return queryDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQueryDeclaration_Label()
  {
    return (EAttribute)queryDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQueryDeclaration_Description()
  {
    return (EAttribute)queryDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryDeclaration_Definition()
  {
    return (EReference)queryDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryDefinitionMdsl()
  {
    return queryDefinitionMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryDefinitionMdsl_Evaluator()
  {
    return (EReference)queryDefinitionMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryDefinitionMdsl_ForeignModel()
  {
    return (EReference)queryDefinitionMdslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQueryDefinitionMdsl_ContextLocator()
  {
    return (EAttribute)queryDefinitionMdslEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryDefinitionMdsl_Query()
  {
    return (EReference)queryDefinitionMdslEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryDefinitionMdsl_ExternalQueryCall()
  {
    return (EReference)queryDefinitionMdslEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryDefinitionMdsl_ReturnType()
  {
    return (EReference)queryDefinitionMdslEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryDefinitionMdsl_Properties()
  {
    return (EReference)queryDefinitionMdslEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQueryDefinitionMdsl_OptimisationLevel()
  {
    return (EAttribute)queryDefinitionMdslEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryFragment()
  {
    return queryFragmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteralQueryFragment()
  {
    return literalQueryFragmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteralQueryFragment_Value()
  {
    return (EAttribute)literalQueryFragmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryBody()
  {
    return queryBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryBody_Fragments()
  {
    return (EReference)queryBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryRefMdsl()
  {
    return queryRefMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryRefMdsl_Referenced()
  {
    return (EReference)queryRefMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalQueryCallMdsl()
  {
    return externalQueryCallMdslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalQueryCallMdsl_ExternalQuery()
  {
    return (EReference)externalQueryCallMdslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryChain()
  {
    return queryChainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQueryChain_Queries()
  {
    return (EReference)queryChainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormatExpr()
  {
    return formatExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormatExpr_Fragments()
  {
    return (EReference)formatExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormatExprFragment()
  {
    return formatExprFragmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteralFormatExprFragment()
  {
    return literalFormatExprFragmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteralFormatExprFragment_Value()
  {
    return (EAttribute)literalFormatExprFragmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTextMacro()
  {
    return textMacroEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTextMacro_Label()
  {
    return (EAttribute)textMacroEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTextMacro_Description()
  {
    return (EAttribute)textMacroEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTextMacro_MacroValue()
  {
    return (EAttribute)textMacroEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTextMacroRef()
  {
    return textMacroRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTextMacroRef_Referenced()
  {
    return (EReference)textMacroRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getVALUE_CONVERTER_CATEGORY_MDSL()
  {
    return valuE_CONVERTER_CATEGORY_MDSLEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getWIDGET_CATEGORY_MDSL()
  {
    return widgeT_CATEGORY_MDSLEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCOMMAND_CATEGORY_MDSL()
  {
    return commanD_CATEGORY_MDSLEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getQUERY_OPTIMISATION_LEVEL()
  {
    return querY_OPTIMISATION_LEVELEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MadConfigDslFactory getMadConfigDslFactory()
  {
    return (MadConfigDslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    madConfigurationEClass = createEClass(MAD_CONFIGURATION);
    createEReference(madConfigurationEClass, MAD_CONFIGURATION__IMPORTS);
    createEReference(madConfigurationEClass, MAD_CONFIGURATION__CONFIG_ELEMENTS);

    madConfigElementEClass = createEClass(MAD_CONFIG_ELEMENT);
    createEAttribute(madConfigElementEClass, MAD_CONFIG_ELEMENT__NAME);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORT_URI);

    classDescriptorMdslEClass = createEClass(CLASS_DESCRIPTOR_MDSL);
    createEAttribute(classDescriptorMdslEClass, CLASS_DESCRIPTOR_MDSL__CLASS_NAME);
    createEAttribute(classDescriptorMdslEClass, CLASS_DESCRIPTOR_MDSL__PLUGIN_ID);

    propertyTypeMdslEClass = createEClass(PROPERTY_TYPE_MDSL);
    createEAttribute(propertyTypeMdslEClass, PROPERTY_TYPE_MDSL__NAME);
    createEAttribute(propertyTypeMdslEClass, PROPERTY_TYPE_MDSL__LABEL);

    propertyMdslEClass = createEClass(PROPERTY_MDSL);
    createEReference(propertyMdslEClass, PROPERTY_MDSL__PROPERTY_NAME);
    createEReference(propertyMdslEClass, PROPERTY_MDSL__PROPERTY_VALUE);

    propertyValueMdslEClass = createEClass(PROPERTY_VALUE_MDSL);
    createEReference(propertyValueMdslEClass, PROPERTY_VALUE_MDSL__FRAGMENTS);

    propValueExprFragmentEClass = createEClass(PROP_VALUE_EXPR_FRAGMENT);

    literaPropValueExprFragmentEClass = createEClass(LITERA_PROP_VALUE_EXPR_FRAGMENT);
    createEAttribute(literaPropValueExprFragmentEClass, LITERA_PROP_VALUE_EXPR_FRAGMENT__VALUE);

    iconDescriptorMdslEClass = createEClass(ICON_DESCRIPTOR_MDSL);
    createEAttribute(iconDescriptorMdslEClass, ICON_DESCRIPTOR_MDSL__DESCRIPTION);
    createEReference(iconDescriptorMdslEClass, ICON_DESCRIPTOR_MDSL__BUNDLE_DESCRIPTOR);
    createEAttribute(iconDescriptorMdslEClass, ICON_DESCRIPTOR_MDSL__BUNDLE_URI);

    i18NBundleMdslEClass = createEClass(I18N_BUNDLE_MDSL);
    createEAttribute(i18NBundleMdslEClass, I18N_BUNDLE_MDSL__DESCRIPTION);
    createEReference(i18NBundleMdslEClass, I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR);
    createEAttribute(i18NBundleMdslEClass, I18N_BUNDLE_MDSL__BUNDLE_URI);

    foreignModelMdslEClass = createEClass(FOREIGN_MODEL_MDSL);
    createEAttribute(foreignModelMdslEClass, FOREIGN_MODEL_MDSL__LABEL);
    createEAttribute(foreignModelMdslEClass, FOREIGN_MODEL_MDSL__DESCRIPTION);
    createEReference(foreignModelMdslEClass, FOREIGN_MODEL_MDSL__PROVIDER);
    createEReference(foreignModelMdslEClass, FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS);
    createEReference(foreignModelMdslEClass, FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS);
    createEReference(foreignModelMdslEClass, FOREIGN_MODEL_MDSL__DSL_REFERENCE);
    createEReference(foreignModelMdslEClass, FOREIGN_MODEL_MDSL__RELOCATOR_QUERY);

    modelProviderMdslEClass = createEClass(MODEL_PROVIDER_MDSL);

    uriExtensionModelProviderMdslEClass = createEClass(URI_EXTENSION_MODEL_PROVIDER_MDSL);
    createEAttribute(uriExtensionModelProviderMdslEClass, URI_EXTENSION_MODEL_PROVIDER_MDSL__URI_EXTENSION);

    uriModelProviderMdslEClass = createEClass(URI_MODEL_PROVIDER_MDSL);
    createEAttribute(uriModelProviderMdslEClass, URI_MODEL_PROVIDER_MDSL__MODEL_URI);

    customModelProviderMdslEClass = createEClass(CUSTOM_MODEL_PROVIDER_MDSL);
    createEReference(customModelProviderMdslEClass, CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR);
    createEAttribute(customModelProviderMdslEClass, CUSTOM_MODEL_PROVIDER_MDSL__PARAMETERS);

    xtextLanguageDescriptorMdslEClass = createEClass(XTEXT_LANGUAGE_DESCRIPTOR_MDSL);
    createEAttribute(xtextLanguageDescriptorMdslEClass, XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID);
    createEAttribute(xtextLanguageDescriptorMdslEClass, XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID);
    createEAttribute(xtextLanguageDescriptorMdslEClass, XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME);

    xtextLanguageReferenceEClass = createEClass(XTEXT_LANGUAGE_REFERENCE);
    createEReference(xtextLanguageReferenceEClass, XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR);

    queryEvaluatorMdslEClass = createEClass(QUERY_EVALUATOR_MDSL);
    createEAttribute(queryEvaluatorMdslEClass, QUERY_EVALUATOR_MDSL__LABEL);
    createEReference(queryEvaluatorMdslEClass, QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR);
    createEReference(queryEvaluatorMdslEClass, QUERY_EVALUATOR_MDSL__QUERY_PROPERTIES_TYPES);
    createEReference(queryEvaluatorMdslEClass, QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR);
    createEAttribute(queryEvaluatorMdslEClass, QUERY_EVALUATOR_MDSL__DESCRIPTION);

    widgetTypeEClass = createEClass(WIDGET_TYPE);
    createEAttribute(widgetTypeEClass, WIDGET_TYPE__CATEGORY);
    createEAttribute(widgetTypeEClass, WIDGET_TYPE__LABEL);
    createEReference(widgetTypeEClass, WIDGET_TYPE__CLASS_DESCRIPTOR);
    createEAttribute(widgetTypeEClass, WIDGET_TYPE__DESCRIPTION);

    uiTabMdslEClass = createEClass(UI_TAB_MDSL);
    createEAttribute(uiTabMdslEClass, UI_TAB_MDSL__I18_NLABEL);
    createEReference(uiTabMdslEClass, UI_TAB_MDSL__LABEL_FORMAT_EXPR);
    createEAttribute(uiTabMdslEClass, UI_TAB_MDSL__DESCRIPTION);

    layerMdslEClass = createEClass(LAYER_MDSL);
    createEAttribute(layerMdslEClass, LAYER_MDSL__I18_NLABEL);
    createEReference(layerMdslEClass, LAYER_MDSL__LABEL_FORMAT_EXPR);
    createEAttribute(layerMdslEClass, LAYER_MDSL__DESCRIPTION);
    createEReference(layerMdslEClass, LAYER_MDSL__SUB_LAYERS);

    typeConfigurationMdslEClass = createEClass(TYPE_CONFIGURATION_MDSL);
    createEAttribute(typeConfigurationMdslEClass, TYPE_CONFIGURATION_MDSL__DEFAULT_CONFIGURATION);
    createEReference(typeConfigurationMdslEClass, TYPE_CONFIGURATION_MDSL__TYPE);
    createEAttribute(typeConfigurationMdslEClass, TYPE_CONFIGURATION_MDSL__I18_NLABEL_PROVIDER);
    createEReference(typeConfigurationMdslEClass, TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION);
    createEAttribute(typeConfigurationMdslEClass, TYPE_CONFIGURATION_MDSL__USE_EXPLICIT_EXTENDS);
    createEReference(typeConfigurationMdslEClass, TYPE_CONFIGURATION_MDSL__SUPER_CONFIGURATIONS);
    createEReference(typeConfigurationMdslEClass, TYPE_CONFIGURATION_MDSL__TEMPLATE_ELEMENTS);
    createEAttribute(typeConfigurationMdslEClass, TYPE_CONFIGURATION_MDSL__LAYOUT_DEFINED);
    createEReference(typeConfigurationMdslEClass, TYPE_CONFIGURATION_MDSL__LAYOUT_ELEMENTS);

    typeConfigurationTemplateElementEClass = createEClass(TYPE_CONFIGURATION_TEMPLATE_ELEMENT);
    createEAttribute(typeConfigurationTemplateElementEClass, TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME);
    createEReference(typeConfigurationTemplateElementEClass, TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY);

    includeTemplateElementMdslEClass = createEClass(INCLUDE_TEMPLATE_ELEMENT_MDSL);
    createEReference(includeTemplateElementMdslEClass, INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE);

    valueConverterEClass = createEClass(VALUE_CONVERTER);

    queryBasedValueConverterEClass = createEClass(QUERY_BASED_VALUE_CONVERTER);
    createEReference(queryBasedValueConverterEClass, QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY);

    basicTypeValueConverterEClass = createEClass(BASIC_TYPE_VALUE_CONVERTER);
    createEAttribute(basicTypeValueConverterEClass, BASIC_TYPE_VALUE_CONVERTER__CATEGORY);
    createEAttribute(basicTypeValueConverterEClass, BASIC_TYPE_VALUE_CONVERTER__CONFIGURATION);

    widgetConfigurationMdslEClass = createEClass(WIDGET_CONFIGURATION_MDSL);
    createEAttribute(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__DESCRIPTION);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__UI_TAB);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__LAYERS);
    createEAttribute(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__I18_NLABEL);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__LABEL);
    createEAttribute(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__WIDGET_CATEGORY);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__WIDGET_TYPE);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__FLEXIBLE_TEMPLATE);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__VALIDATORS);
    createEAttribute(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__I18_NFORMAT);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY);
    createEAttribute(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__I18_NITEM_LABEL);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION);
    createEReference(widgetConfigurationMdslEClass, WIDGET_CONFIGURATION_MDSL__COMMANDS);

    validatorMdslEClass = createEClass(VALIDATOR_MDSL);
    createEReference(validatorMdslEClass, VALIDATOR_MDSL__VALIDATION_QUERY);
    createEAttribute(validatorMdslEClass, VALIDATOR_MDSL__I18_NMESSAGE);
    createEReference(validatorMdslEClass, VALIDATOR_MDSL__ERROR_MESSAGE_EXPR);

    commandMdslEClass = createEClass(COMMAND_MDSL);

    commandDeclarationEClass = createEClass(COMMAND_DECLARATION);
    createEAttribute(commandDeclarationEClass, COMMAND_DECLARATION__LABEL);
    createEAttribute(commandDeclarationEClass, COMMAND_DECLARATION__DESCRIPTION);
    createEReference(commandDeclarationEClass, COMMAND_DECLARATION__DEFINITION);

    commandDefinitionMdslEClass = createEClass(COMMAND_DEFINITION_MDSL);
    createEAttribute(commandDefinitionMdslEClass, COMMAND_DEFINITION_MDSL__CATEGORY);
    createEAttribute(commandDefinitionMdslEClass, COMMAND_DEFINITION_MDSL__I18_NLABEL);
    createEReference(commandDefinitionMdslEClass, COMMAND_DEFINITION_MDSL__LABEL);
    createEReference(commandDefinitionMdslEClass, COMMAND_DEFINITION_MDSL__ICON);
    createEReference(commandDefinitionMdslEClass, COMMAND_DEFINITION_MDSL__ACTION);
    createEReference(commandDefinitionMdslEClass, COMMAND_DEFINITION_MDSL__ON_ACTION_SUCCESS_UI_COMMANDS);
    createEReference(commandDefinitionMdslEClass, COMMAND_DEFINITION_MDSL__ON_ACTION_ERROR_UI_COMMANDS);

    commandRefMdslEClass = createEClass(COMMAND_REF_MDSL);
    createEReference(commandRefMdslEClass, COMMAND_REF_MDSL__REFERENCED);
    createEAttribute(commandRefMdslEClass, COMMAND_REF_MDSL__I18_NLABEL_OVERRIDE);
    createEReference(commandRefMdslEClass, COMMAND_REF_MDSL__LABEL_OVERRIDE);

    uiCommandMdslEClass = createEClass(UI_COMMAND_MDSL);

    displayViewUICommandEClass = createEClass(DISPLAY_VIEW_UI_COMMAND);
    createEReference(displayViewUICommandEClass, DISPLAY_VIEW_UI_COMMAND__TARGET);

    reloadViewUICommandEClass = createEClass(RELOAD_VIEW_UI_COMMAND);

    reloadWidgetsUICommandEClass = createEClass(RELOAD_WIDGETS_UI_COMMAND);
    createEReference(reloadWidgetsUICommandEClass, RELOAD_WIDGETS_UI_COMMAND__WIDGETS_TO_RELOAD);

    queryUsageEClass = createEClass(QUERY_USAGE);

    queryMdslEClass = createEClass(QUERY_MDSL);

    queryDeclarationEClass = createEClass(QUERY_DECLARATION);
    createEAttribute(queryDeclarationEClass, QUERY_DECLARATION__LABEL);
    createEAttribute(queryDeclarationEClass, QUERY_DECLARATION__DESCRIPTION);
    createEReference(queryDeclarationEClass, QUERY_DECLARATION__DEFINITION);

    queryDefinitionMdslEClass = createEClass(QUERY_DEFINITION_MDSL);
    createEReference(queryDefinitionMdslEClass, QUERY_DEFINITION_MDSL__EVALUATOR);
    createEReference(queryDefinitionMdslEClass, QUERY_DEFINITION_MDSL__FOREIGN_MODEL);
    createEAttribute(queryDefinitionMdslEClass, QUERY_DEFINITION_MDSL__CONTEXT_LOCATOR);
    createEReference(queryDefinitionMdslEClass, QUERY_DEFINITION_MDSL__QUERY);
    createEReference(queryDefinitionMdslEClass, QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL);
    createEReference(queryDefinitionMdslEClass, QUERY_DEFINITION_MDSL__RETURN_TYPE);
    createEReference(queryDefinitionMdslEClass, QUERY_DEFINITION_MDSL__PROPERTIES);
    createEAttribute(queryDefinitionMdslEClass, QUERY_DEFINITION_MDSL__OPTIMISATION_LEVEL);

    queryFragmentEClass = createEClass(QUERY_FRAGMENT);

    literalQueryFragmentEClass = createEClass(LITERAL_QUERY_FRAGMENT);
    createEAttribute(literalQueryFragmentEClass, LITERAL_QUERY_FRAGMENT__VALUE);

    queryBodyEClass = createEClass(QUERY_BODY);
    createEReference(queryBodyEClass, QUERY_BODY__FRAGMENTS);

    queryRefMdslEClass = createEClass(QUERY_REF_MDSL);
    createEReference(queryRefMdslEClass, QUERY_REF_MDSL__REFERENCED);

    externalQueryCallMdslEClass = createEClass(EXTERNAL_QUERY_CALL_MDSL);
    createEReference(externalQueryCallMdslEClass, EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY);

    queryChainEClass = createEClass(QUERY_CHAIN);
    createEReference(queryChainEClass, QUERY_CHAIN__QUERIES);

    formatExprEClass = createEClass(FORMAT_EXPR);
    createEReference(formatExprEClass, FORMAT_EXPR__FRAGMENTS);

    formatExprFragmentEClass = createEClass(FORMAT_EXPR_FRAGMENT);

    literalFormatExprFragmentEClass = createEClass(LITERAL_FORMAT_EXPR_FRAGMENT);
    createEAttribute(literalFormatExprFragmentEClass, LITERAL_FORMAT_EXPR_FRAGMENT__VALUE);

    textMacroEClass = createEClass(TEXT_MACRO);
    createEAttribute(textMacroEClass, TEXT_MACRO__LABEL);
    createEAttribute(textMacroEClass, TEXT_MACRO__DESCRIPTION);
    createEAttribute(textMacroEClass, TEXT_MACRO__MACRO_VALUE);

    textMacroRefEClass = createEClass(TEXT_MACRO_REF);
    createEReference(textMacroRefEClass, TEXT_MACRO_REF__REFERENCED);

    // Create enums
    valuE_CONVERTER_CATEGORY_MDSLEEnum = createEEnum(VALUE_CONVERTER_CATEGORY_MDSL);
    widgeT_CATEGORY_MDSLEEnum = createEEnum(WIDGET_CATEGORY_MDSL);
    commanD_CATEGORY_MDSLEEnum = createEEnum(COMMAND_CATEGORY_MDSL);
    querY_OPTIMISATION_LEVELEEnum = createEEnum(QUERY_OPTIMISATION_LEVEL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    literaPropValueExprFragmentEClass.getESuperTypes().add(this.getPropValueExprFragment());
    iconDescriptorMdslEClass.getESuperTypes().add(this.getMADConfigElement());
    i18NBundleMdslEClass.getESuperTypes().add(this.getMADConfigElement());
    foreignModelMdslEClass.getESuperTypes().add(this.getMADConfigElement());
    uriExtensionModelProviderMdslEClass.getESuperTypes().add(this.getModelProviderMdsl());
    uriModelProviderMdslEClass.getESuperTypes().add(this.getModelProviderMdsl());
    customModelProviderMdslEClass.getESuperTypes().add(this.getModelProviderMdsl());
    xtextLanguageDescriptorMdslEClass.getESuperTypes().add(this.getMADConfigElement());
    queryEvaluatorMdslEClass.getESuperTypes().add(this.getMADConfigElement());
    widgetTypeEClass.getESuperTypes().add(this.getMADConfigElement());
    uiTabMdslEClass.getESuperTypes().add(this.getMADConfigElement());
    layerMdslEClass.getESuperTypes().add(this.getMADConfigElement());
    typeConfigurationMdslEClass.getESuperTypes().add(this.getMADConfigElement());
    includeTemplateElementMdslEClass.getESuperTypes().add(this.getTypeConfigurationTemplateElement());
    queryBasedValueConverterEClass.getESuperTypes().add(this.getValueConverter());
    basicTypeValueConverterEClass.getESuperTypes().add(this.getValueConverter());
    widgetConfigurationMdslEClass.getESuperTypes().add(this.getTypeConfigurationTemplateElement());
    commandDeclarationEClass.getESuperTypes().add(this.getMADConfigElement());
    commandDefinitionMdslEClass.getESuperTypes().add(this.getCommandMdsl());
    commandRefMdslEClass.getESuperTypes().add(this.getCommandMdsl());
    displayViewUICommandEClass.getESuperTypes().add(this.getUICommandMdsl());
    reloadViewUICommandEClass.getESuperTypes().add(this.getUICommandMdsl());
    reloadWidgetsUICommandEClass.getESuperTypes().add(this.getUICommandMdsl());
    queryMdslEClass.getESuperTypes().add(this.getQueryUsage());
    queryDeclarationEClass.getESuperTypes().add(this.getMADConfigElement());
    queryDefinitionMdslEClass.getESuperTypes().add(this.getQueryMdsl());
    literalQueryFragmentEClass.getESuperTypes().add(this.getQueryFragment());
    queryRefMdslEClass.getESuperTypes().add(this.getQueryMdsl());
    queryChainEClass.getESuperTypes().add(this.getQueryUsage());
    literalFormatExprFragmentEClass.getESuperTypes().add(this.getFormatExprFragment());
    textMacroEClass.getESuperTypes().add(this.getMADConfigElement());
    textMacroRefEClass.getESuperTypes().add(this.getPropValueExprFragment());
    textMacroRefEClass.getESuperTypes().add(this.getQueryFragment());
    textMacroRefEClass.getESuperTypes().add(this.getFormatExprFragment());

    // Initialize classes and features; add operations and parameters
    initEClass(madConfigurationEClass, MADConfiguration.class, "MADConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMADConfiguration_Imports(), this.getImport(), null, "imports", null, 0, -1, MADConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMADConfiguration_ConfigElements(), this.getMADConfigElement(), null, "configElements", null, 0, -1, MADConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(madConfigElementEClass, MADConfigElement.class, "MADConfigElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMADConfigElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, MADConfigElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classDescriptorMdslEClass, ClassDescriptorMdsl.class, "ClassDescriptorMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClassDescriptorMdsl_ClassName(), ecorePackage.getEString(), "ClassName", null, 0, 1, ClassDescriptorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassDescriptorMdsl_PluginId(), ecorePackage.getEString(), "pluginId", null, 0, 1, ClassDescriptorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyTypeMdslEClass, PropertyTypeMdsl.class, "PropertyTypeMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPropertyTypeMdsl_Name(), ecorePackage.getEString(), "name", null, 0, 1, PropertyTypeMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPropertyTypeMdsl_Label(), ecorePackage.getEString(), "label", null, 0, 1, PropertyTypeMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyMdslEClass, PropertyMdsl.class, "PropertyMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyMdsl_PropertyName(), this.getPropertyTypeMdsl(), null, "propertyName", null, 0, 1, PropertyMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyMdsl_PropertyValue(), this.getPropertyValueMdsl(), null, "propertyValue", null, 0, 1, PropertyMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyValueMdslEClass, PropertyValueMdsl.class, "PropertyValueMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyValueMdsl_Fragments(), this.getPropValueExprFragment(), null, "fragments", null, 0, -1, PropertyValueMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propValueExprFragmentEClass, PropValueExprFragment.class, "PropValueExprFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(literaPropValueExprFragmentEClass, LiteraPropValueExprFragment.class, "LiteraPropValueExprFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteraPropValueExprFragment_Value(), ecorePackage.getEString(), "value", null, 0, 1, LiteraPropValueExprFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iconDescriptorMdslEClass, IconDescriptorMdsl.class, "IconDescriptorMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIconDescriptorMdsl_Description(), ecorePackage.getEString(), "description", null, 0, 1, IconDescriptorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIconDescriptorMdsl_BundleDescriptor(), this.getClassDescriptorMdsl(), null, "bundleDescriptor", null, 0, 1, IconDescriptorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIconDescriptorMdsl_BundleUri(), ecorePackage.getEString(), "bundleUri", null, 0, 1, IconDescriptorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(i18NBundleMdslEClass, I18NBundleMdsl.class, "I18NBundleMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getI18NBundleMdsl_Description(), ecorePackage.getEString(), "description", null, 0, 1, I18NBundleMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getI18NBundleMdsl_BundleDescriptor(), this.getClassDescriptorMdsl(), null, "bundleDescriptor", null, 0, 1, I18NBundleMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getI18NBundleMdsl_BundleUri(), ecorePackage.getEString(), "bundleUri", null, 0, 1, I18NBundleMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(foreignModelMdslEClass, ForeignModelMdsl.class, "ForeignModelMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getForeignModelMdsl_Label(), ecorePackage.getEString(), "label", null, 0, 1, ForeignModelMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getForeignModelMdsl_Description(), ecorePackage.getEString(), "description", null, 0, 1, ForeignModelMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForeignModelMdsl_Provider(), this.getModelProviderMdsl(), null, "provider", null, 0, 1, ForeignModelMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForeignModelMdsl_SynchronizerFactoryClass(), this.getClassDescriptorMdsl(), null, "synchronizerFactoryClass", null, 0, 1, ForeignModelMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForeignModelMdsl_ExtensionManagerClass(), this.getClassDescriptorMdsl(), null, "extensionManagerClass", null, 0, 1, ForeignModelMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForeignModelMdsl_DslReference(), this.getXtextLanguageReference(), null, "dslReference", null, 0, 1, ForeignModelMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForeignModelMdsl_RelocatorQuery(), this.getQueryMdsl(), null, "relocatorQuery", null, 0, 1, ForeignModelMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modelProviderMdslEClass, ModelProviderMdsl.class, "ModelProviderMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(uriExtensionModelProviderMdslEClass, URIExtensionModelProviderMdsl.class, "URIExtensionModelProviderMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getURIExtensionModelProviderMdsl_UriExtension(), ecorePackage.getEString(), "uriExtension", null, 0, 1, URIExtensionModelProviderMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(uriModelProviderMdslEClass, URIModelProviderMdsl.class, "URIModelProviderMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getURIModelProviderMdsl_ModelUri(), ecorePackage.getEString(), "modelUri", null, 0, 1, URIModelProviderMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(customModelProviderMdslEClass, CustomModelProviderMdsl.class, "CustomModelProviderMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCustomModelProviderMdsl_ClassDescriptor(), this.getClassDescriptorMdsl(), null, "classDescriptor", null, 0, 1, CustomModelProviderMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCustomModelProviderMdsl_Parameters(), ecorePackage.getEString(), "parameters", null, 0, -1, CustomModelProviderMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xtextLanguageDescriptorMdslEClass, XtextLanguageDescriptorMdsl.class, "XtextLanguageDescriptorMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getXtextLanguageDescriptorMdsl_LanguageId(), ecorePackage.getEString(), "languageId", null, 0, 1, XtextLanguageDescriptorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getXtextLanguageDescriptorMdsl_BundleId(), ecorePackage.getEString(), "bundleId", null, 0, 1, XtextLanguageDescriptorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getXtextLanguageDescriptorMdsl_ActivatorClassName(), ecorePackage.getEString(), "activatorClassName", null, 0, 1, XtextLanguageDescriptorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xtextLanguageReferenceEClass, XtextLanguageReference.class, "XtextLanguageReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXtextLanguageReference_XtextLanguageDescriptor(), this.getXtextLanguageDescriptorMdsl(), null, "xtextLanguageDescriptor", null, 0, 1, XtextLanguageReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(queryEvaluatorMdslEClass, QueryEvaluatorMdsl.class, "QueryEvaluatorMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQueryEvaluatorMdsl_Label(), ecorePackage.getEString(), "label", null, 0, 1, QueryEvaluatorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQueryEvaluatorMdsl_ClassDescriptor(), this.getClassDescriptorMdsl(), null, "classDescriptor", null, 0, 1, QueryEvaluatorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQueryEvaluatorMdsl_QueryPropertiesTypes(), this.getPropertyTypeMdsl(), null, "queryPropertiesTypes", null, 0, -1, QueryEvaluatorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQueryEvaluatorMdsl_ExtQServiceClassDescriptor(), this.getClassDescriptorMdsl(), null, "extQServiceClassDescriptor", null, 0, 1, QueryEvaluatorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQueryEvaluatorMdsl_Description(), ecorePackage.getEString(), "description", null, 0, 1, QueryEvaluatorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(widgetTypeEClass, WidgetType.class, "WidgetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getWidgetType_Category(), this.getWIDGET_CATEGORY_MDSL(), "category", null, 0, 1, WidgetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWidgetType_Label(), ecorePackage.getEString(), "label", null, 0, 1, WidgetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetType_ClassDescriptor(), this.getClassDescriptorMdsl(), null, "classDescriptor", null, 0, 1, WidgetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWidgetType_Description(), ecorePackage.getEString(), "description", null, 0, 1, WidgetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(uiTabMdslEClass, UITabMdsl.class, "UITabMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUITabMdsl_I18NLabel(), ecorePackage.getEBoolean(), "i18NLabel", null, 0, 1, UITabMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUITabMdsl_LabelFormatExpr(), this.getFormatExpr(), null, "labelFormatExpr", null, 0, 1, UITabMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUITabMdsl_Description(), ecorePackage.getEString(), "description", null, 0, 1, UITabMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(layerMdslEClass, LayerMdsl.class, "LayerMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLayerMdsl_I18NLabel(), ecorePackage.getEBoolean(), "i18NLabel", null, 0, 1, LayerMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLayerMdsl_LabelFormatExpr(), this.getFormatExpr(), null, "labelFormatExpr", null, 0, 1, LayerMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLayerMdsl_Description(), ecorePackage.getEString(), "description", null, 0, 1, LayerMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLayerMdsl_SubLayers(), this.getLayerMdsl(), null, "subLayers", null, 0, -1, LayerMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeConfigurationMdslEClass, TypeConfigurationMdsl.class, "TypeConfigurationMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeConfigurationMdsl_DefaultConfiguration(), ecorePackage.getEBoolean(), "defaultConfiguration", null, 0, 1, TypeConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeConfigurationMdsl_Type(), ecorePackage.getEClass(), null, "type", null, 0, 1, TypeConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeConfigurationMdsl_I18NLabelProvider(), ecorePackage.getEBoolean(), "i18NLabelProvider", null, 0, 1, TypeConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeConfigurationMdsl_LabelProviderExpression(), this.getFormatExpr(), null, "labelProviderExpression", null, 0, 1, TypeConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeConfigurationMdsl_UseExplicitExtends(), ecorePackage.getEBoolean(), "useExplicitExtends", null, 0, 1, TypeConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeConfigurationMdsl_SuperConfigurations(), this.getTypeConfigurationMdsl(), null, "superConfigurations", null, 0, -1, TypeConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeConfigurationMdsl_TemplateElements(), this.getTypeConfigurationTemplateElement(), null, "templateElements", null, 0, -1, TypeConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeConfigurationMdsl_LayoutDefined(), ecorePackage.getEBoolean(), "layoutDefined", null, 0, 1, TypeConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeConfigurationMdsl_LayoutElements(), this.getWidgetConfigurationMdsl(), null, "layoutElements", null, 0, -1, TypeConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeConfigurationTemplateElementEClass, TypeConfigurationTemplateElement.class, "TypeConfigurationTemplateElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeConfigurationTemplateElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeConfigurationTemplateElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeConfigurationTemplateElement_ValueQuery(), this.getQueryUsage(), null, "valueQuery", null, 0, 1, TypeConfigurationTemplateElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(includeTemplateElementMdslEClass, IncludeTemplateElementMdsl.class, "IncludeTemplateElementMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIncludeTemplateElementMdsl_RefIncludedTemplate(), this.getTypeConfigurationMdsl(), null, "refIncludedTemplate", null, 0, 1, IncludeTemplateElementMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueConverterEClass, ValueConverter.class, "ValueConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(queryBasedValueConverterEClass, QueryBasedValueConverter.class, "QueryBasedValueConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQueryBasedValueConverter_ConverterQuery(), this.getQueryUsage(), null, "converterQuery", null, 0, 1, QueryBasedValueConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(basicTypeValueConverterEClass, BasicTypeValueConverter.class, "BasicTypeValueConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBasicTypeValueConverter_Category(), this.getVALUE_CONVERTER_CATEGORY_MDSL(), "category", null, 0, 1, BasicTypeValueConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBasicTypeValueConverter_Configuration(), ecorePackage.getEString(), "configuration", null, 0, 1, BasicTypeValueConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(widgetConfigurationMdslEClass, WidgetConfigurationMdsl.class, "WidgetConfigurationMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getWidgetConfigurationMdsl_Description(), ecorePackage.getEString(), "description", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_UiTab(), this.getUITabMdsl(), null, "uiTab", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_Layers(), this.getLayerMdsl(), null, "layers", null, 0, -1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWidgetConfigurationMdsl_I18NLabel(), ecorePackage.getEBoolean(), "i18NLabel", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_Label(), this.getFormatExpr(), null, "label", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWidgetConfigurationMdsl_WidgetCategory(), this.getWIDGET_CATEGORY_MDSL(), "widgetCategory", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_WidgetType(), this.getWidgetType(), null, "widgetType", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_DslReference(), this.getXtextLanguageReference(), null, "dslReference", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_FlexibleTemplate(), this.getTypeConfigurationMdsl(), null, "flexibleTemplate", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_VisibilityQuery(), this.getQueryMdsl(), null, "visibilityQuery", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_EditableQuery(), this.getQueryMdsl(), null, "editableQuery", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_ValueConverter(), this.getValueConverter(), null, "valueConverter", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_Validators(), this.getValidatorMdsl(), null, "validators", null, 0, -1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWidgetConfigurationMdsl_I18NFormat(), ecorePackage.getEBoolean(), "i18NFormat", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_ValueFormat(), this.getFormatExpr(), null, "valueFormat", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_CandidatesQuery(), this.getQueryUsage(), null, "candidatesQuery", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWidgetConfigurationMdsl_I18NItemLabel(), ecorePackage.getEBoolean(), "i18NItemLabel", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_ItemLabelExpression(), this.getFormatExpr(), null, "itemLabelExpression", null, 0, 1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWidgetConfigurationMdsl_Commands(), this.getCommandMdsl(), null, "commands", null, 0, -1, WidgetConfigurationMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(validatorMdslEClass, ValidatorMdsl.class, "ValidatorMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValidatorMdsl_ValidationQuery(), this.getQueryUsage(), null, "validationQuery", null, 0, 1, ValidatorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getValidatorMdsl_I18NMessage(), ecorePackage.getEBoolean(), "i18NMessage", null, 0, 1, ValidatorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValidatorMdsl_ErrorMessageExpr(), this.getFormatExpr(), null, "errorMessageExpr", null, 0, 1, ValidatorMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commandMdslEClass, CommandMdsl.class, "CommandMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(commandDeclarationEClass, CommandDeclaration.class, "CommandDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCommandDeclaration_Label(), ecorePackage.getEString(), "label", null, 0, 1, CommandDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommandDeclaration_Description(), ecorePackage.getEString(), "description", null, 0, 1, CommandDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommandDeclaration_Definition(), this.getCommandDefinitionMdsl(), null, "definition", null, 0, 1, CommandDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commandDefinitionMdslEClass, CommandDefinitionMdsl.class, "CommandDefinitionMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCommandDefinitionMdsl_Category(), this.getCOMMAND_CATEGORY_MDSL(), "category", null, 0, 1, CommandDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommandDefinitionMdsl_I18NLabel(), ecorePackage.getEBoolean(), "i18NLabel", null, 0, 1, CommandDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommandDefinitionMdsl_Label(), this.getFormatExpr(), null, "label", null, 0, 1, CommandDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommandDefinitionMdsl_Icon(), this.getIconDescriptorMdsl(), null, "icon", null, 0, 1, CommandDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommandDefinitionMdsl_Action(), this.getQueryMdsl(), null, "action", null, 0, 1, CommandDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommandDefinitionMdsl_OnActionSuccessUICommands(), this.getUICommandMdsl(), null, "onActionSuccessUICommands", null, 0, -1, CommandDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommandDefinitionMdsl_OnActionErrorUICommands(), this.getUICommandMdsl(), null, "onActionErrorUICommands", null, 0, -1, CommandDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commandRefMdslEClass, CommandRefMdsl.class, "CommandRefMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCommandRefMdsl_Referenced(), this.getCommandDeclaration(), null, "referenced", null, 0, 1, CommandRefMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommandRefMdsl_I18NLabelOverride(), ecorePackage.getEBoolean(), "i18NLabelOverride", null, 0, 1, CommandRefMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommandRefMdsl_LabelOverride(), this.getFormatExpr(), null, "labelOverride", null, 0, 1, CommandRefMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(uiCommandMdslEClass, UICommandMdsl.class, "UICommandMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(displayViewUICommandEClass, DisplayViewUICommand.class, "DisplayViewUICommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDisplayViewUICommand_Target(), this.getQueryUsage(), null, "target", null, 0, 1, DisplayViewUICommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reloadViewUICommandEClass, ReloadViewUICommand.class, "ReloadViewUICommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(reloadWidgetsUICommandEClass, ReloadWidgetsUICommand.class, "ReloadWidgetsUICommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReloadWidgetsUICommand_WidgetsToReload(), this.getWidgetConfigurationMdsl(), null, "widgetsToReload", null, 0, -1, ReloadWidgetsUICommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(queryUsageEClass, QueryUsage.class, "QueryUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(queryMdslEClass, QueryMdsl.class, "QueryMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(queryDeclarationEClass, QueryDeclaration.class, "QueryDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQueryDeclaration_Label(), ecorePackage.getEString(), "label", null, 0, 1, QueryDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQueryDeclaration_Description(), ecorePackage.getEString(), "description", null, 0, 1, QueryDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQueryDeclaration_Definition(), this.getQueryDefinitionMdsl(), null, "definition", null, 0, 1, QueryDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(queryDefinitionMdslEClass, QueryDefinitionMdsl.class, "QueryDefinitionMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQueryDefinitionMdsl_Evaluator(), this.getQueryEvaluatorMdsl(), null, "evaluator", null, 0, 1, QueryDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQueryDefinitionMdsl_ForeignModel(), this.getForeignModelMdsl(), null, "foreignModel", null, 0, 1, QueryDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQueryDefinitionMdsl_ContextLocator(), ecorePackage.getEString(), "contextLocator", null, 0, 1, QueryDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQueryDefinitionMdsl_Query(), this.getQueryBody(), null, "query", null, 0, 1, QueryDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQueryDefinitionMdsl_ExternalQueryCall(), this.getExternalQueryCallMdsl(), null, "externalQueryCall", null, 0, 1, QueryDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQueryDefinitionMdsl_ReturnType(), ecorePackage.getEClassifier(), null, "returnType", null, 0, 1, QueryDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQueryDefinitionMdsl_Properties(), this.getPropertyMdsl(), null, "properties", null, 0, -1, QueryDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQueryDefinitionMdsl_OptimisationLevel(), this.getQUERY_OPTIMISATION_LEVEL(), "optimisationLevel", null, 0, 1, QueryDefinitionMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(queryFragmentEClass, QueryFragment.class, "QueryFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(literalQueryFragmentEClass, LiteralQueryFragment.class, "LiteralQueryFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteralQueryFragment_Value(), ecorePackage.getEString(), "value", null, 0, 1, LiteralQueryFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(queryBodyEClass, QueryBody.class, "QueryBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQueryBody_Fragments(), this.getQueryFragment(), null, "fragments", null, 0, -1, QueryBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(queryRefMdslEClass, QueryRefMdsl.class, "QueryRefMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQueryRefMdsl_Referenced(), this.getQueryDeclaration(), null, "referenced", null, 0, 1, QueryRefMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(externalQueryCallMdslEClass, ExternalQueryCallMdsl.class, "ExternalQueryCallMdsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExternalQueryCallMdsl_ExternalQuery(), ecorePackage.getEObject(), null, "externalQuery", null, 0, 1, ExternalQueryCallMdsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(queryChainEClass, QueryChain.class, "QueryChain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQueryChain_Queries(), this.getQueryMdsl(), null, "queries", null, 0, -1, QueryChain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formatExprEClass, FormatExpr.class, "FormatExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFormatExpr_Fragments(), this.getFormatExprFragment(), null, "fragments", null, 0, -1, FormatExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formatExprFragmentEClass, FormatExprFragment.class, "FormatExprFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(literalFormatExprFragmentEClass, LiteralFormatExprFragment.class, "LiteralFormatExprFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteralFormatExprFragment_Value(), ecorePackage.getEString(), "value", null, 0, 1, LiteralFormatExprFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(textMacroEClass, TextMacro.class, "TextMacro", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTextMacro_Label(), ecorePackage.getEString(), "label", null, 0, 1, TextMacro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTextMacro_Description(), ecorePackage.getEString(), "description", null, 0, 1, TextMacro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTextMacro_MacroValue(), ecorePackage.getEString(), "macroValue", null, 0, 1, TextMacro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(textMacroRefEClass, TextMacroRef.class, "TextMacroRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTextMacroRef_Referenced(), this.getTextMacro(), null, "referenced", null, 0, 1, TextMacroRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(valuE_CONVERTER_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL.class, "VALUE_CONVERTER_CATEGORY_MDSL");
    addEEnumLiteral(valuE_CONVERTER_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL.DATE);
    addEEnumLiteral(valuE_CONVERTER_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL.DATETIME);
    addEEnumLiteral(valuE_CONVERTER_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL.INTEGER);
    addEEnumLiteral(valuE_CONVERTER_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL.FLOAT);
    addEEnumLiteral(valuE_CONVERTER_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL.DOUBLE);
    addEEnumLiteral(valuE_CONVERTER_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL.XTEXT);

    initEEnum(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.class, "WIDGET_CATEGORY_MDSL");
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.OUTPUTTEXT_WIDGET);
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.NAVIGATION_WIDGET);
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.TEXT_WIDGET);
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.BOOL_WIDGET);
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.DATE_WIDGET);
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.NUMBER_WIDGET);
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.SINGLE_SELECT_WIDGET);
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.MULTI_SELECT_WIDGET);
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.XTEXT_EDITOR);
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.XTEXT_TEXT_EDITOR);
    addEEnumLiteral(widgeT_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL.FLEXIBLE_WIDGET);

    initEEnum(commanD_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL.class, "COMMAND_CATEGORY_MDSL");
    addEEnumLiteral(commanD_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL.UPDATE_COMMAND);
    addEEnumLiteral(commanD_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL.GLOBAL_COMMAND);
    addEEnumLiteral(commanD_CATEGORY_MDSLEEnum, com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL.ITEM_COMMAND);

    initEEnum(querY_OPTIMISATION_LEVELEEnum, com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL.class, "QUERY_OPTIMISATION_LEVEL");
    addEEnumLiteral(querY_OPTIMISATION_LEVELEEnum, com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL.NONE);
    addEEnumLiteral(querY_OPTIMISATION_LEVELEEnum, com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL.VIEW);
    addEEnumLiteral(querY_OPTIMISATION_LEVELEEnum, com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL.CONTEXT);

    // Create resource
    createResource(eNS_URI);
  }

} //MadConfigDslPackageImpl
