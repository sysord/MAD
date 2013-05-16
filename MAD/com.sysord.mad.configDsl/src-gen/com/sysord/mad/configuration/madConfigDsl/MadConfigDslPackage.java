/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslFactory
 * @model kind="package"
 * @generated
 */
public interface MadConfigDslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "madConfigDsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.sysord.com/mad/configuration/MadConfigDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "madConfigDsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MadConfigDslPackage eINSTANCE = com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl.init();

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.MADConfigurationImpl <em>MAD Configuration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MADConfigurationImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getMADConfiguration()
   * @generated
   */
  int MAD_CONFIGURATION = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAD_CONFIGURATION__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Config Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAD_CONFIGURATION__CONFIG_ELEMENTS = 1;

  /**
   * The number of structural features of the '<em>MAD Configuration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAD_CONFIGURATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.MADConfigElementImpl <em>MAD Config Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MADConfigElementImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getMADConfigElement()
   * @generated
   */
  int MAD_CONFIG_ELEMENT = 1;

  /**
   * The number of structural features of the '<em>MAD Config Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAD_CONFIG_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.ImportImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 2;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORT_URI = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ClassDescriptorMdslImpl <em>Class Descriptor Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.ClassDescriptorMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getClassDescriptorMdsl()
   * @generated
   */
  int CLASS_DESCRIPTOR_MDSL = 3;

  /**
   * The feature id for the '<em><b>Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DESCRIPTOR_MDSL__CLASS_NAME = 0;

  /**
   * The feature id for the '<em><b>Plugin Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DESCRIPTOR_MDSL__PLUGIN_ID = 1;

  /**
   * The number of structural features of the '<em>Class Descriptor Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DESCRIPTOR_MDSL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.PropertyTypeMdslImpl <em>Property Type Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.PropertyTypeMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getPropertyTypeMdsl()
   * @generated
   */
  int PROPERTY_TYPE_MDSL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_TYPE_MDSL__NAME = 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_TYPE_MDSL__LABEL = 1;

  /**
   * The number of structural features of the '<em>Property Type Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_TYPE_MDSL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.PropertyMdslImpl <em>Property Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.PropertyMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getPropertyMdsl()
   * @generated
   */
  int PROPERTY_MDSL = 5;

  /**
   * The feature id for the '<em><b>Property Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_MDSL__PROPERTY_NAME = 0;

  /**
   * The feature id for the '<em><b>Property Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_MDSL__PROPERTY_VALUE = 1;

  /**
   * The number of structural features of the '<em>Property Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_MDSL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.PropertyValueMdslImpl <em>Property Value Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.PropertyValueMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getPropertyValueMdsl()
   * @generated
   */
  int PROPERTY_VALUE_MDSL = 6;

  /**
   * The feature id for the '<em><b>Fragments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_VALUE_MDSL__FRAGMENTS = 0;

  /**
   * The number of structural features of the '<em>Property Value Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_VALUE_MDSL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.PropValueExprFragmentImpl <em>Prop Value Expr Fragment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.PropValueExprFragmentImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getPropValueExprFragment()
   * @generated
   */
  int PROP_VALUE_EXPR_FRAGMENT = 7;

  /**
   * The number of structural features of the '<em>Prop Value Expr Fragment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROP_VALUE_EXPR_FRAGMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.LiteraPropValueExprFragmentImpl <em>Litera Prop Value Expr Fragment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.LiteraPropValueExprFragmentImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getLiteraPropValueExprFragment()
   * @generated
   */
  int LITERA_PROP_VALUE_EXPR_FRAGMENT = 8;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERA_PROP_VALUE_EXPR_FRAGMENT__VALUE = PROP_VALUE_EXPR_FRAGMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Litera Prop Value Expr Fragment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERA_PROP_VALUE_EXPR_FRAGMENT_FEATURE_COUNT = PROP_VALUE_EXPR_FRAGMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.IconDescriptorMdslImpl <em>Icon Descriptor Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.IconDescriptorMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getIconDescriptorMdsl()
   * @generated
   */
  int ICON_DESCRIPTOR_MDSL = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ICON_DESCRIPTOR_MDSL__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ICON_DESCRIPTOR_MDSL__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Bundle Descriptor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ICON_DESCRIPTOR_MDSL__BUNDLE_DESCRIPTOR = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Bundle Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ICON_DESCRIPTOR_MDSL__BUNDLE_URI = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Icon Descriptor Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ICON_DESCRIPTOR_MDSL_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.I18NBundleMdslImpl <em>I18N Bundle Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.I18NBundleMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getI18NBundleMdsl()
   * @generated
   */
  int I18N_BUNDLE_MDSL = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int I18N_BUNDLE_MDSL__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int I18N_BUNDLE_MDSL__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Bundle Descriptor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Bundle Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int I18N_BUNDLE_MDSL__BUNDLE_URI = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>I18N Bundle Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int I18N_BUNDLE_MDSL_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl <em>Foreign Model Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getForeignModelMdsl()
   * @generated
   */
  int FOREIGN_MODEL_MDSL = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREIGN_MODEL_MDSL__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREIGN_MODEL_MDSL__LABEL = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREIGN_MODEL_MDSL__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Provider</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREIGN_MODEL_MDSL__PROVIDER = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Synchronizer Factory Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Extension Manager Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Dsl Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREIGN_MODEL_MDSL__DSL_REFERENCE = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Relocator Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREIGN_MODEL_MDSL__RELOCATOR_QUERY = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Foreign Model Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREIGN_MODEL_MDSL_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ModelProviderMdslImpl <em>Model Provider Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.ModelProviderMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getModelProviderMdsl()
   * @generated
   */
  int MODEL_PROVIDER_MDSL = 12;

  /**
   * The number of structural features of the '<em>Model Provider Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_PROVIDER_MDSL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.URIExtensionModelProviderMdslImpl <em>URI Extension Model Provider Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.URIExtensionModelProviderMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getURIExtensionModelProviderMdsl()
   * @generated
   */
  int URI_EXTENSION_MODEL_PROVIDER_MDSL = 13;

  /**
   * The feature id for the '<em><b>Uri Extension</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URI_EXTENSION_MODEL_PROVIDER_MDSL__URI_EXTENSION = MODEL_PROVIDER_MDSL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>URI Extension Model Provider Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URI_EXTENSION_MODEL_PROVIDER_MDSL_FEATURE_COUNT = MODEL_PROVIDER_MDSL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.URIModelProviderMdslImpl <em>URI Model Provider Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.URIModelProviderMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getURIModelProviderMdsl()
   * @generated
   */
  int URI_MODEL_PROVIDER_MDSL = 14;

  /**
   * The feature id for the '<em><b>Model Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URI_MODEL_PROVIDER_MDSL__MODEL_URI = MODEL_PROVIDER_MDSL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>URI Model Provider Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URI_MODEL_PROVIDER_MDSL_FEATURE_COUNT = MODEL_PROVIDER_MDSL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.CustomModelProviderMdslImpl <em>Custom Model Provider Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.CustomModelProviderMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCustomModelProviderMdsl()
   * @generated
   */
  int CUSTOM_MODEL_PROVIDER_MDSL = 15;

  /**
   * The feature id for the '<em><b>Class Descriptor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR = MODEL_PROVIDER_MDSL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_MODEL_PROVIDER_MDSL__PARAMETERS = MODEL_PROVIDER_MDSL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Custom Model Provider Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_MODEL_PROVIDER_MDSL_FEATURE_COUNT = MODEL_PROVIDER_MDSL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageDescriptorMdslImpl <em>Xtext Language Descriptor Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageDescriptorMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getXtextLanguageDescriptorMdsl()
   * @generated
   */
  int XTEXT_LANGUAGE_DESCRIPTOR_MDSL = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_LANGUAGE_DESCRIPTOR_MDSL__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Language Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Bundle Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Activator Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Xtext Language Descriptor Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_LANGUAGE_DESCRIPTOR_MDSL_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageReferenceImpl <em>Xtext Language Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageReferenceImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getXtextLanguageReference()
   * @generated
   */
  int XTEXT_LANGUAGE_REFERENCE = 17;

  /**
   * The feature id for the '<em><b>Xtext Language Descriptor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR = 0;

  /**
   * The number of structural features of the '<em>Xtext Language Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_LANGUAGE_REFERENCE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.OCLCustomLibraryMdslImpl <em>OCL Custom Library Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.OCLCustomLibraryMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getOCLCustomLibraryMdsl()
   * @generated
   */
  int OCL_CUSTOM_LIBRARY_MDSL = 18;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_CUSTOM_LIBRARY_MDSL__LABEL = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Class Descriptor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_CUSTOM_LIBRARY_MDSL__CLASS_DESCRIPTOR = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_CUSTOM_LIBRARY_MDSL__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>OCL Custom Library Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_CUSTOM_LIBRARY_MDSL_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryEvaluatorMdslImpl <em>Query Evaluator Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryEvaluatorMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryEvaluatorMdsl()
   * @generated
   */
  int QUERY_EVALUATOR_MDSL = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EVALUATOR_MDSL__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EVALUATOR_MDSL__LABEL = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Class Descriptor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Query Properties Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EVALUATOR_MDSL__QUERY_PROPERTIES_TYPES = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Ext QService Class Descriptor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EVALUATOR_MDSL__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Query Evaluator Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EVALUATOR_MDSL_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetTypeImpl <em>Widget Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.WidgetTypeImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getWidgetType()
   * @generated
   */
  int WIDGET_TYPE = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_TYPE__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Category</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_TYPE__CATEGORY = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_TYPE__LABEL = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Class Descriptor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_TYPE__CLASS_DESCRIPTOR = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_TYPE__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Widget Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_TYPE_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.UITabMdslImpl <em>UI Tab Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.UITabMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getUITabMdsl()
   * @generated
   */
  int UI_TAB_MDSL = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UI_TAB_MDSL__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>I18N Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UI_TAB_MDSL__I18_NLABEL = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Label Format Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UI_TAB_MDSL__LABEL_FORMAT_EXPR = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UI_TAB_MDSL__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>UI Tab Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UI_TAB_MDSL_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.LayerMdslImpl <em>Layer Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.LayerMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getLayerMdsl()
   * @generated
   */
  int LAYER_MDSL = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYER_MDSL__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>I18N Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYER_MDSL__I18_NLABEL = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Label Format Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYER_MDSL__LABEL_FORMAT_EXPR = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYER_MDSL__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Sub Layers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYER_MDSL__SUB_LAYERS = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Layer Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYER_MDSL_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl <em>Type Configuration Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getTypeConfigurationMdsl()
   * @generated
   */
  int TYPE_CONFIGURATION_MDSL = 23;

  /**
   * The feature id for the '<em><b>Default Configuration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL__DEFAULT_CONFIGURATION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL__TYPE = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>I18N Label Provider</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL__I18_NLABEL_PROVIDER = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Label Provider Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Use Explicit Extends</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL__USE_EXPLICIT_EXTENDS = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Super Configurations</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL__SUPER_CONFIGURATIONS = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Template Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL__TEMPLATE_ELEMENTS = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Layout Defined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL__LAYOUT_DEFINED = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Layout Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL__LAYOUT_ELEMENTS = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 9;

  /**
   * The number of structural features of the '<em>Type Configuration Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_MDSL_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 10;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationTemplateElementImpl <em>Type Configuration Template Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationTemplateElementImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getTypeConfigurationTemplateElement()
   * @generated
   */
  int TYPE_CONFIGURATION_TEMPLATE_ELEMENT = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Value Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY = 1;

  /**
   * The number of structural features of the '<em>Type Configuration Template Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.IncludeTemplateElementMdslImpl <em>Include Template Element Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.IncludeTemplateElementMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getIncludeTemplateElementMdsl()
   * @generated
   */
  int INCLUDE_TEMPLATE_ELEMENT_MDSL = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_TEMPLATE_ELEMENT_MDSL__NAME = TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Value Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_TEMPLATE_ELEMENT_MDSL__VALUE_QUERY = TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY;

  /**
   * The feature id for the '<em><b>Ref Included Template</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Include Template Element Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_TEMPLATE_ELEMENT_MDSL_FEATURE_COUNT = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ValueConverterImpl <em>Value Converter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.ValueConverterImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getValueConverter()
   * @generated
   */
  int VALUE_CONVERTER = 26;

  /**
   * The number of structural features of the '<em>Value Converter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_CONVERTER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryBasedValueConverterImpl <em>Query Based Value Converter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryBasedValueConverterImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryBasedValueConverter()
   * @generated
   */
  int QUERY_BASED_VALUE_CONVERTER = 27;

  /**
   * The feature id for the '<em><b>Converter Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY = VALUE_CONVERTER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Query Based Value Converter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_BASED_VALUE_CONVERTER_FEATURE_COUNT = VALUE_CONVERTER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.BasicTypeValueConverterImpl <em>Basic Type Value Converter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.BasicTypeValueConverterImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getBasicTypeValueConverter()
   * @generated
   */
  int BASIC_TYPE_VALUE_CONVERTER = 28;

  /**
   * The feature id for the '<em><b>Category</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_TYPE_VALUE_CONVERTER__CATEGORY = VALUE_CONVERTER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Configuration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_TYPE_VALUE_CONVERTER__CONFIGURATION = VALUE_CONVERTER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Basic Type Value Converter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_TYPE_VALUE_CONVERTER_FEATURE_COUNT = VALUE_CONVERTER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl <em>Widget Configuration Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getWidgetConfigurationMdsl()
   * @generated
   */
  int WIDGET_CONFIGURATION_MDSL = 29;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__NAME = TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Value Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__VALUE_QUERY = TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__DESCRIPTION = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ui Tab</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__UI_TAB = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Layers</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__LAYERS = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>I18N Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__I18_NLABEL = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Label</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__LABEL = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Widget Category</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__WIDGET_CATEGORY = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Widget Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__WIDGET_TYPE = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Dsl Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Flexible Template</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__FLEXIBLE_TEMPLATE = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Visibility Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Editable Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Value Converter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Validators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__VALIDATORS = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>I18N Format</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__I18_NFORMAT = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 13;

  /**
   * The feature id for the '<em><b>Value Format</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 14;

  /**
   * The feature id for the '<em><b>Candidates Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 15;

  /**
   * The feature id for the '<em><b>I18N Item Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__I18_NITEM_LABEL = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 16;

  /**
   * The feature id for the '<em><b>Item Label Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 17;

  /**
   * The feature id for the '<em><b>Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL__COMMANDS = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 18;

  /**
   * The number of structural features of the '<em>Widget Configuration Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDGET_CONFIGURATION_MDSL_FEATURE_COUNT = TYPE_CONFIGURATION_TEMPLATE_ELEMENT_FEATURE_COUNT + 19;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ValidatorMdslImpl <em>Validator Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.ValidatorMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getValidatorMdsl()
   * @generated
   */
  int VALIDATOR_MDSL = 30;

  /**
   * The feature id for the '<em><b>Validation Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATOR_MDSL__VALIDATION_QUERY = 0;

  /**
   * The feature id for the '<em><b>I18N Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATOR_MDSL__I18_NMESSAGE = 1;

  /**
   * The feature id for the '<em><b>Error Message Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATOR_MDSL__ERROR_MESSAGE_EXPR = 2;

  /**
   * The number of structural features of the '<em>Validator Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATOR_MDSL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandMdslImpl <em>Command Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.CommandMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCommandMdsl()
   * @generated
   */
  int COMMAND_MDSL = 31;

  /**
   * The number of structural features of the '<em>Command Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_MDSL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDeclarationImpl <em>Command Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.CommandDeclarationImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCommandDeclaration()
   * @generated
   */
  int COMMAND_DECLARATION = 32;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DECLARATION__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DECLARATION__LABEL = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DECLARATION__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DECLARATION__DEFINITION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Command Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DECLARATION_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl <em>Command Definition Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCommandDefinitionMdsl()
   * @generated
   */
  int COMMAND_DEFINITION_MDSL = 33;

  /**
   * The feature id for the '<em><b>Category</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DEFINITION_MDSL__CATEGORY = COMMAND_MDSL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>I18N Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DEFINITION_MDSL__I18_NLABEL = COMMAND_MDSL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Label</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DEFINITION_MDSL__LABEL = COMMAND_MDSL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Icon</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DEFINITION_MDSL__ICON = COMMAND_MDSL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DEFINITION_MDSL__ACTION = COMMAND_MDSL_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>On Action Success UI Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DEFINITION_MDSL__ON_ACTION_SUCCESS_UI_COMMANDS = COMMAND_MDSL_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>On Action Error UI Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DEFINITION_MDSL__ON_ACTION_ERROR_UI_COMMANDS = COMMAND_MDSL_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Command Definition Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_DEFINITION_MDSL_FEATURE_COUNT = COMMAND_MDSL_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandRefMdslImpl <em>Command Ref Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.CommandRefMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCommandRefMdsl()
   * @generated
   */
  int COMMAND_REF_MDSL = 34;

  /**
   * The feature id for the '<em><b>Referenced</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_REF_MDSL__REFERENCED = COMMAND_MDSL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>I18N Label Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_REF_MDSL__I18_NLABEL_OVERRIDE = COMMAND_MDSL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Label Override</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_REF_MDSL__LABEL_OVERRIDE = COMMAND_MDSL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Command Ref Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_REF_MDSL_FEATURE_COUNT = COMMAND_MDSL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.UICommandMdslImpl <em>UI Command Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.UICommandMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getUICommandMdsl()
   * @generated
   */
  int UI_COMMAND_MDSL = 35;

  /**
   * The number of structural features of the '<em>UI Command Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UI_COMMAND_MDSL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.DisplayViewUICommandImpl <em>Display View UI Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.DisplayViewUICommandImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getDisplayViewUICommand()
   * @generated
   */
  int DISPLAY_VIEW_UI_COMMAND = 36;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPLAY_VIEW_UI_COMMAND__TARGET = UI_COMMAND_MDSL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Display View UI Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPLAY_VIEW_UI_COMMAND_FEATURE_COUNT = UI_COMMAND_MDSL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ReloadViewUICommandImpl <em>Reload View UI Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.ReloadViewUICommandImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getReloadViewUICommand()
   * @generated
   */
  int RELOAD_VIEW_UI_COMMAND = 37;

  /**
   * The number of structural features of the '<em>Reload View UI Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELOAD_VIEW_UI_COMMAND_FEATURE_COUNT = UI_COMMAND_MDSL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ReloadWidgetsUICommandImpl <em>Reload Widgets UI Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.ReloadWidgetsUICommandImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getReloadWidgetsUICommand()
   * @generated
   */
  int RELOAD_WIDGETS_UI_COMMAND = 38;

  /**
   * The feature id for the '<em><b>Widgets To Reload</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELOAD_WIDGETS_UI_COMMAND__WIDGETS_TO_RELOAD = UI_COMMAND_MDSL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reload Widgets UI Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELOAD_WIDGETS_UI_COMMAND_FEATURE_COUNT = UI_COMMAND_MDSL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryUsageImpl <em>Query Usage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryUsageImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryUsage()
   * @generated
   */
  int QUERY_USAGE = 39;

  /**
   * The number of structural features of the '<em>Query Usage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_USAGE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryMdslImpl <em>Query Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryMdsl()
   * @generated
   */
  int QUERY_MDSL = 40;

  /**
   * The number of structural features of the '<em>Query Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_MDSL_FEATURE_COUNT = QUERY_USAGE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDeclarationImpl <em>Query Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryDeclarationImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryDeclaration()
   * @generated
   */
  int QUERY_DECLARATION = 41;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DECLARATION__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DECLARATION__LABEL = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DECLARATION__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DECLARATION__DEFINITION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Query Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DECLARATION_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl <em>Query Definition Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryDefinitionMdsl()
   * @generated
   */
  int QUERY_DEFINITION_MDSL = 42;

  /**
   * The feature id for the '<em><b>Evaluator</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DEFINITION_MDSL__EVALUATOR = QUERY_MDSL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Foreign Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DEFINITION_MDSL__FOREIGN_MODEL = QUERY_MDSL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Context Locator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DEFINITION_MDSL__CONTEXT_LOCATOR = QUERY_MDSL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DEFINITION_MDSL__QUERY = QUERY_MDSL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>External Query Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL = QUERY_MDSL_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DEFINITION_MDSL__RETURN_TYPE = QUERY_MDSL_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DEFINITION_MDSL__PROPERTIES = QUERY_MDSL_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Optimisation Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DEFINITION_MDSL__OPTIMISATION_LEVEL = QUERY_MDSL_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Query Definition Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_DEFINITION_MDSL_FEATURE_COUNT = QUERY_MDSL_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryFragmentImpl <em>Query Fragment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryFragmentImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryFragment()
   * @generated
   */
  int QUERY_FRAGMENT = 43;

  /**
   * The number of structural features of the '<em>Query Fragment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_FRAGMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.LiteralQueryFragmentImpl <em>Literal Query Fragment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.LiteralQueryFragmentImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getLiteralQueryFragment()
   * @generated
   */
  int LITERAL_QUERY_FRAGMENT = 44;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_QUERY_FRAGMENT__VALUE = QUERY_FRAGMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal Query Fragment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_QUERY_FRAGMENT_FEATURE_COUNT = QUERY_FRAGMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryBodyImpl <em>Query Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryBodyImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryBody()
   * @generated
   */
  int QUERY_BODY = 45;

  /**
   * The feature id for the '<em><b>Fragments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_BODY__FRAGMENTS = 0;

  /**
   * The number of structural features of the '<em>Query Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_BODY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryRefMdslImpl <em>Query Ref Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryRefMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryRefMdsl()
   * @generated
   */
  int QUERY_REF_MDSL = 46;

  /**
   * The feature id for the '<em><b>Referenced</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_REF_MDSL__REFERENCED = QUERY_MDSL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Query Ref Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_REF_MDSL_FEATURE_COUNT = QUERY_MDSL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ExternalQueryCallMdslImpl <em>External Query Call Mdsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.ExternalQueryCallMdslImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getExternalQueryCallMdsl()
   * @generated
   */
  int EXTERNAL_QUERY_CALL_MDSL = 47;

  /**
   * The feature id for the '<em><b>External Query</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY = 0;

  /**
   * The number of structural features of the '<em>External Query Call Mdsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_QUERY_CALL_MDSL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryChainImpl <em>Query Chain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryChainImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryChain()
   * @generated
   */
  int QUERY_CHAIN = 48;

  /**
   * The feature id for the '<em><b>Queries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_CHAIN__QUERIES = QUERY_USAGE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Query Chain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_CHAIN_FEATURE_COUNT = QUERY_USAGE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.FormatExprImpl <em>Format Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.FormatExprImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getFormatExpr()
   * @generated
   */
  int FORMAT_EXPR = 49;

  /**
   * The feature id for the '<em><b>Fragments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAT_EXPR__FRAGMENTS = 0;

  /**
   * The number of structural features of the '<em>Format Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAT_EXPR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.FormatExprFragmentImpl <em>Format Expr Fragment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.FormatExprFragmentImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getFormatExprFragment()
   * @generated
   */
  int FORMAT_EXPR_FRAGMENT = 50;

  /**
   * The number of structural features of the '<em>Format Expr Fragment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAT_EXPR_FRAGMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.LiteralFormatExprFragmentImpl <em>Literal Format Expr Fragment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.LiteralFormatExprFragmentImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getLiteralFormatExprFragment()
   * @generated
   */
  int LITERAL_FORMAT_EXPR_FRAGMENT = 51;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FORMAT_EXPR_FRAGMENT__VALUE = FORMAT_EXPR_FRAGMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal Format Expr Fragment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FORMAT_EXPR_FRAGMENT_FEATURE_COUNT = FORMAT_EXPR_FRAGMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.TextMacroImpl <em>Text Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.TextMacroImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getTextMacro()
   * @generated
   */
  int TEXT_MACRO = 52;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_MACRO__NAME = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_MACRO__LABEL = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_MACRO__DESCRIPTION = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Macro Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_MACRO__MACRO_VALUE = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Text Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_MACRO_FEATURE_COUNT = MAD_CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.TextMacroRefImpl <em>Text Macro Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.impl.TextMacroRefImpl
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getTextMacroRef()
   * @generated
   */
  int TEXT_MACRO_REF = 53;

  /**
   * The feature id for the '<em><b>Referenced</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_MACRO_REF__REFERENCED = PROP_VALUE_EXPR_FRAGMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Text Macro Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_MACRO_REF_FEATURE_COUNT = PROP_VALUE_EXPR_FRAGMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL <em>VALUE CONVERTER CATEGORY MDSL</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getVALUE_CONVERTER_CATEGORY_MDSL()
   * @generated
   */
  int VALUE_CONVERTER_CATEGORY_MDSL = 54;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL <em>WIDGET CATEGORY MDSL</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getWIDGET_CATEGORY_MDSL()
   * @generated
   */
  int WIDGET_CATEGORY_MDSL = 55;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL <em>COMMAND CATEGORY MDSL</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCOMMAND_CATEGORY_MDSL()
   * @generated
   */
  int COMMAND_CATEGORY_MDSL = 56;

  /**
   * The meta object id for the '{@link com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL <em>QUERY OPTIMISATION LEVEL</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL
   * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQUERY_OPTIMISATION_LEVEL()
   * @generated
   */
  int QUERY_OPTIMISATION_LEVEL = 57;


  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.MADConfiguration <em>MAD Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAD Configuration</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.MADConfiguration
   * @generated
   */
  EClass getMADConfiguration();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.MADConfiguration#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.MADConfiguration#getImports()
   * @see #getMADConfiguration()
   * @generated
   */
  EReference getMADConfiguration_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.MADConfiguration#getConfigElements <em>Config Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Config Elements</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.MADConfiguration#getConfigElements()
   * @see #getMADConfiguration()
   * @generated
   */
  EReference getMADConfiguration_ConfigElements();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.MADConfigElement <em>MAD Config Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAD Config Element</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.MADConfigElement
   * @generated
   */
  EClass getMADConfigElement();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl <em>Class Descriptor Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Descriptor Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl
   * @generated
   */
  EClass getClassDescriptorMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl#getClassName <em>Class Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Class Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl#getClassName()
   * @see #getClassDescriptorMdsl()
   * @generated
   */
  EAttribute getClassDescriptorMdsl_ClassName();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl#getPluginId <em>Plugin Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Plugin Id</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl#getPluginId()
   * @see #getClassDescriptorMdsl()
   * @generated
   */
  EAttribute getClassDescriptorMdsl_PluginId();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl <em>Property Type Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Type Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl
   * @generated
   */
  EClass getPropertyTypeMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl#getName()
   * @see #getPropertyTypeMdsl()
   * @generated
   */
  EAttribute getPropertyTypeMdsl_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl#getLabel()
   * @see #getPropertyTypeMdsl()
   * @generated
   */
  EAttribute getPropertyTypeMdsl_Label();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.PropertyMdsl <em>Property Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyMdsl
   * @generated
   */
  EClass getPropertyMdsl();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.PropertyMdsl#getPropertyName <em>Property Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyMdsl#getPropertyName()
   * @see #getPropertyMdsl()
   * @generated
   */
  EReference getPropertyMdsl_PropertyName();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.PropertyMdsl#getPropertyValue <em>Property Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property Value</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyMdsl#getPropertyValue()
   * @see #getPropertyMdsl()
   * @generated
   */
  EReference getPropertyMdsl_PropertyValue();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.PropertyValueMdsl <em>Property Value Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Value Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyValueMdsl
   * @generated
   */
  EClass getPropertyValueMdsl();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.PropertyValueMdsl#getFragments <em>Fragments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fragments</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.PropertyValueMdsl#getFragments()
   * @see #getPropertyValueMdsl()
   * @generated
   */
  EReference getPropertyValueMdsl_Fragments();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.PropValueExprFragment <em>Prop Value Expr Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prop Value Expr Fragment</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.PropValueExprFragment
   * @generated
   */
  EClass getPropValueExprFragment();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.LiteraPropValueExprFragment <em>Litera Prop Value Expr Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Litera Prop Value Expr Fragment</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LiteraPropValueExprFragment
   * @generated
   */
  EClass getLiteraPropValueExprFragment();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.LiteraPropValueExprFragment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LiteraPropValueExprFragment#getValue()
   * @see #getLiteraPropValueExprFragment()
   * @generated
   */
  EAttribute getLiteraPropValueExprFragment_Value();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl <em>Icon Descriptor Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Icon Descriptor Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl
   * @generated
   */
  EClass getIconDescriptorMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getName()
   * @see #getIconDescriptorMdsl()
   * @generated
   */
  EAttribute getIconDescriptorMdsl_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getDescription()
   * @see #getIconDescriptorMdsl()
   * @generated
   */
  EAttribute getIconDescriptorMdsl_Description();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getBundleDescriptor <em>Bundle Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bundle Descriptor</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getBundleDescriptor()
   * @see #getIconDescriptorMdsl()
   * @generated
   */
  EReference getIconDescriptorMdsl_BundleDescriptor();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getBundleUri <em>Bundle Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bundle Uri</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl#getBundleUri()
   * @see #getIconDescriptorMdsl()
   * @generated
   */
  EAttribute getIconDescriptorMdsl_BundleUri();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl <em>I18N Bundle Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>I18N Bundle Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl
   * @generated
   */
  EClass getI18NBundleMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl#getName()
   * @see #getI18NBundleMdsl()
   * @generated
   */
  EAttribute getI18NBundleMdsl_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl#getDescription()
   * @see #getI18NBundleMdsl()
   * @generated
   */
  EAttribute getI18NBundleMdsl_Description();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl#getBundleDescriptor <em>Bundle Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bundle Descriptor</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl#getBundleDescriptor()
   * @see #getI18NBundleMdsl()
   * @generated
   */
  EReference getI18NBundleMdsl_BundleDescriptor();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl#getBundleUri <em>Bundle Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bundle Uri</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl#getBundleUri()
   * @see #getI18NBundleMdsl()
   * @generated
   */
  EAttribute getI18NBundleMdsl_BundleUri();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl <em>Foreign Model Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Foreign Model Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl
   * @generated
   */
  EClass getForeignModelMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getName()
   * @see #getForeignModelMdsl()
   * @generated
   */
  EAttribute getForeignModelMdsl_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getLabel()
   * @see #getForeignModelMdsl()
   * @generated
   */
  EAttribute getForeignModelMdsl_Label();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getDescription()
   * @see #getForeignModelMdsl()
   * @generated
   */
  EAttribute getForeignModelMdsl_Description();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getProvider <em>Provider</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Provider</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getProvider()
   * @see #getForeignModelMdsl()
   * @generated
   */
  EReference getForeignModelMdsl_Provider();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getSynchronizerFactoryClass <em>Synchronizer Factory Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Synchronizer Factory Class</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getSynchronizerFactoryClass()
   * @see #getForeignModelMdsl()
   * @generated
   */
  EReference getForeignModelMdsl_SynchronizerFactoryClass();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getExtensionManagerClass <em>Extension Manager Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Extension Manager Class</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getExtensionManagerClass()
   * @see #getForeignModelMdsl()
   * @generated
   */
  EReference getForeignModelMdsl_ExtensionManagerClass();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getDslReference <em>Dsl Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dsl Reference</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getDslReference()
   * @see #getForeignModelMdsl()
   * @generated
   */
  EReference getForeignModelMdsl_DslReference();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getRelocatorQuery <em>Relocator Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Relocator Query</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getRelocatorQuery()
   * @see #getForeignModelMdsl()
   * @generated
   */
  EReference getForeignModelMdsl_RelocatorQuery();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.ModelProviderMdsl <em>Model Provider Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Provider Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ModelProviderMdsl
   * @generated
   */
  EClass getModelProviderMdsl();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.URIExtensionModelProviderMdsl <em>URI Extension Model Provider Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>URI Extension Model Provider Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.URIExtensionModelProviderMdsl
   * @generated
   */
  EClass getURIExtensionModelProviderMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.URIExtensionModelProviderMdsl#getUriExtension <em>Uri Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uri Extension</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.URIExtensionModelProviderMdsl#getUriExtension()
   * @see #getURIExtensionModelProviderMdsl()
   * @generated
   */
  EAttribute getURIExtensionModelProviderMdsl_UriExtension();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.URIModelProviderMdsl <em>URI Model Provider Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>URI Model Provider Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.URIModelProviderMdsl
   * @generated
   */
  EClass getURIModelProviderMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.URIModelProviderMdsl#getModelUri <em>Model Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Model Uri</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.URIModelProviderMdsl#getModelUri()
   * @see #getURIModelProviderMdsl()
   * @generated
   */
  EAttribute getURIModelProviderMdsl_ModelUri();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl <em>Custom Model Provider Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Custom Model Provider Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl
   * @generated
   */
  EClass getCustomModelProviderMdsl();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl#getClassDescriptor <em>Class Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Class Descriptor</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl#getClassDescriptor()
   * @see #getCustomModelProviderMdsl()
   * @generated
   */
  EReference getCustomModelProviderMdsl_ClassDescriptor();

  /**
   * Returns the meta object for the attribute list '{@link com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Parameters</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl#getParameters()
   * @see #getCustomModelProviderMdsl()
   * @generated
   */
  EAttribute getCustomModelProviderMdsl_Parameters();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl <em>Xtext Language Descriptor Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Xtext Language Descriptor Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl
   * @generated
   */
  EClass getXtextLanguageDescriptorMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl#getName()
   * @see #getXtextLanguageDescriptorMdsl()
   * @generated
   */
  EAttribute getXtextLanguageDescriptorMdsl_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl#getLanguageId <em>Language Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Language Id</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl#getLanguageId()
   * @see #getXtextLanguageDescriptorMdsl()
   * @generated
   */
  EAttribute getXtextLanguageDescriptorMdsl_LanguageId();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl#getBundleId <em>Bundle Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bundle Id</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl#getBundleId()
   * @see #getXtextLanguageDescriptorMdsl()
   * @generated
   */
  EAttribute getXtextLanguageDescriptorMdsl_BundleId();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl#getActivatorClassName <em>Activator Class Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Activator Class Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl#getActivatorClassName()
   * @see #getXtextLanguageDescriptorMdsl()
   * @generated
   */
  EAttribute getXtextLanguageDescriptorMdsl_ActivatorClassName();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference <em>Xtext Language Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Xtext Language Reference</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference
   * @generated
   */
  EClass getXtextLanguageReference();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference#getXtextLanguageDescriptor <em>Xtext Language Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Xtext Language Descriptor</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference#getXtextLanguageDescriptor()
   * @see #getXtextLanguageReference()
   * @generated
   */
  EReference getXtextLanguageReference_XtextLanguageDescriptor();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl <em>OCL Custom Library Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>OCL Custom Library Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl
   * @generated
   */
  EClass getOCLCustomLibraryMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl#getLabel()
   * @see #getOCLCustomLibraryMdsl()
   * @generated
   */
  EAttribute getOCLCustomLibraryMdsl_Label();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl#getClassDescriptor <em>Class Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Class Descriptor</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl#getClassDescriptor()
   * @see #getOCLCustomLibraryMdsl()
   * @generated
   */
  EReference getOCLCustomLibraryMdsl_ClassDescriptor();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl#getDescription()
   * @see #getOCLCustomLibraryMdsl()
   * @generated
   */
  EAttribute getOCLCustomLibraryMdsl_Description();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl <em>Query Evaluator Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Evaluator Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl
   * @generated
   */
  EClass getQueryEvaluatorMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getName()
   * @see #getQueryEvaluatorMdsl()
   * @generated
   */
  EAttribute getQueryEvaluatorMdsl_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getLabel()
   * @see #getQueryEvaluatorMdsl()
   * @generated
   */
  EAttribute getQueryEvaluatorMdsl_Label();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getClassDescriptor <em>Class Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Class Descriptor</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getClassDescriptor()
   * @see #getQueryEvaluatorMdsl()
   * @generated
   */
  EReference getQueryEvaluatorMdsl_ClassDescriptor();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getQueryPropertiesTypes <em>Query Properties Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Query Properties Types</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getQueryPropertiesTypes()
   * @see #getQueryEvaluatorMdsl()
   * @generated
   */
  EReference getQueryEvaluatorMdsl_QueryPropertiesTypes();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getExtQServiceClassDescriptor <em>Ext QService Class Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ext QService Class Descriptor</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getExtQServiceClassDescriptor()
   * @see #getQueryEvaluatorMdsl()
   * @generated
   */
  EReference getQueryEvaluatorMdsl_ExtQServiceClassDescriptor();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl#getDescription()
   * @see #getQueryEvaluatorMdsl()
   * @generated
   */
  EAttribute getQueryEvaluatorMdsl_Description();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType <em>Widget Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Widget Type</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetType
   * @generated
   */
  EClass getWidgetType();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetType#getName()
   * @see #getWidgetType()
   * @generated
   */
  EAttribute getWidgetType_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Category</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetType#getCategory()
   * @see #getWidgetType()
   * @generated
   */
  EAttribute getWidgetType_Category();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetType#getLabel()
   * @see #getWidgetType()
   * @generated
   */
  EAttribute getWidgetType_Label();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getClassDescriptor <em>Class Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Class Descriptor</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetType#getClassDescriptor()
   * @see #getWidgetType()
   * @generated
   */
  EReference getWidgetType_ClassDescriptor();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.WidgetType#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetType#getDescription()
   * @see #getWidgetType()
   * @generated
   */
  EAttribute getWidgetType_Description();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.UITabMdsl <em>UI Tab Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UI Tab Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.UITabMdsl
   * @generated
   */
  EClass getUITabMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.UITabMdsl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.UITabMdsl#getName()
   * @see #getUITabMdsl()
   * @generated
   */
  EAttribute getUITabMdsl_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.UITabMdsl#isI18NLabel <em>I18N Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I18N Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.UITabMdsl#isI18NLabel()
   * @see #getUITabMdsl()
   * @generated
   */
  EAttribute getUITabMdsl_I18NLabel();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.UITabMdsl#getLabelFormatExpr <em>Label Format Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Label Format Expr</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.UITabMdsl#getLabelFormatExpr()
   * @see #getUITabMdsl()
   * @generated
   */
  EReference getUITabMdsl_LabelFormatExpr();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.UITabMdsl#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.UITabMdsl#getDescription()
   * @see #getUITabMdsl()
   * @generated
   */
  EAttribute getUITabMdsl_Description();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl <em>Layer Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Layer Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LayerMdsl
   * @generated
   */
  EClass getLayerMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getName()
   * @see #getLayerMdsl()
   * @generated
   */
  EAttribute getLayerMdsl_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#isI18NLabel <em>I18N Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I18N Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LayerMdsl#isI18NLabel()
   * @see #getLayerMdsl()
   * @generated
   */
  EAttribute getLayerMdsl_I18NLabel();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getLabelFormatExpr <em>Label Format Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Label Format Expr</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getLabelFormatExpr()
   * @see #getLayerMdsl()
   * @generated
   */
  EReference getLayerMdsl_LabelFormatExpr();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getDescription()
   * @see #getLayerMdsl()
   * @generated
   */
  EAttribute getLayerMdsl_Description();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getSubLayers <em>Sub Layers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub Layers</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LayerMdsl#getSubLayers()
   * @see #getLayerMdsl()
   * @generated
   */
  EReference getLayerMdsl_SubLayers();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl <em>Type Configuration Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Configuration Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl
   * @generated
   */
  EClass getTypeConfigurationMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isDefaultConfiguration <em>Default Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default Configuration</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isDefaultConfiguration()
   * @see #getTypeConfigurationMdsl()
   * @generated
   */
  EAttribute getTypeConfigurationMdsl_DefaultConfiguration();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getName()
   * @see #getTypeConfigurationMdsl()
   * @generated
   */
  EAttribute getTypeConfigurationMdsl_Name();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getType()
   * @see #getTypeConfigurationMdsl()
   * @generated
   */
  EReference getTypeConfigurationMdsl_Type();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isI18NLabelProvider <em>I18N Label Provider</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I18N Label Provider</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isI18NLabelProvider()
   * @see #getTypeConfigurationMdsl()
   * @generated
   */
  EAttribute getTypeConfigurationMdsl_I18NLabelProvider();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getLabelProviderExpression <em>Label Provider Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Label Provider Expression</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getLabelProviderExpression()
   * @see #getTypeConfigurationMdsl()
   * @generated
   */
  EReference getTypeConfigurationMdsl_LabelProviderExpression();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isUseExplicitExtends <em>Use Explicit Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Use Explicit Extends</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isUseExplicitExtends()
   * @see #getTypeConfigurationMdsl()
   * @generated
   */
  EAttribute getTypeConfigurationMdsl_UseExplicitExtends();

  /**
   * Returns the meta object for the reference list '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getSuperConfigurations <em>Super Configurations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Super Configurations</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getSuperConfigurations()
   * @see #getTypeConfigurationMdsl()
   * @generated
   */
  EReference getTypeConfigurationMdsl_SuperConfigurations();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getTemplateElements <em>Template Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Template Elements</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getTemplateElements()
   * @see #getTypeConfigurationMdsl()
   * @generated
   */
  EReference getTypeConfigurationMdsl_TemplateElements();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isLayoutDefined <em>Layout Defined</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Layout Defined</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isLayoutDefined()
   * @see #getTypeConfigurationMdsl()
   * @generated
   */
  EAttribute getTypeConfigurationMdsl_LayoutDefined();

  /**
   * Returns the meta object for the reference list '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getLayoutElements <em>Layout Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Layout Elements</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getLayoutElements()
   * @see #getTypeConfigurationMdsl()
   * @generated
   */
  EReference getTypeConfigurationMdsl_LayoutElements();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement <em>Type Configuration Template Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Configuration Template Element</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement
   * @generated
   */
  EClass getTypeConfigurationTemplateElement();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement#getName()
   * @see #getTypeConfigurationTemplateElement()
   * @generated
   */
  EAttribute getTypeConfigurationTemplateElement_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement#getValueQuery <em>Value Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Query</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement#getValueQuery()
   * @see #getTypeConfigurationTemplateElement()
   * @generated
   */
  EReference getTypeConfigurationTemplateElement_ValueQuery();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl <em>Include Template Element Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include Template Element Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl
   * @generated
   */
  EClass getIncludeTemplateElementMdsl();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl#getRefIncludedTemplate <em>Ref Included Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref Included Template</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl#getRefIncludedTemplate()
   * @see #getIncludeTemplateElementMdsl()
   * @generated
   */
  EReference getIncludeTemplateElementMdsl_RefIncludedTemplate();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.ValueConverter <em>Value Converter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Converter</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ValueConverter
   * @generated
   */
  EClass getValueConverter();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter <em>Query Based Value Converter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Based Value Converter</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter
   * @generated
   */
  EClass getQueryBasedValueConverter();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter#getConverterQuery <em>Converter Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Converter Query</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter#getConverterQuery()
   * @see #getQueryBasedValueConverter()
   * @generated
   */
  EReference getQueryBasedValueConverter_ConverterQuery();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter <em>Basic Type Value Converter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Type Value Converter</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter
   * @generated
   */
  EClass getBasicTypeValueConverter();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Category</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter#getCategory()
   * @see #getBasicTypeValueConverter()
   * @generated
   */
  EAttribute getBasicTypeValueConverter_Category();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter#getConfiguration <em>Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Configuration</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter#getConfiguration()
   * @see #getBasicTypeValueConverter()
   * @generated
   */
  EAttribute getBasicTypeValueConverter_Configuration();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl <em>Widget Configuration Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Widget Configuration Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl
   * @generated
   */
  EClass getWidgetConfigurationMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getDescription()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EAttribute getWidgetConfigurationMdsl_Description();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getUiTab <em>Ui Tab</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ui Tab</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getUiTab()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_UiTab();

  /**
   * Returns the meta object for the reference list '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getLayers <em>Layers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Layers</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getLayers()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_Layers();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NLabel <em>I18N Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I18N Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NLabel()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EAttribute getWidgetConfigurationMdsl_I18NLabel();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getLabel()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_Label();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getWidgetCategory <em>Widget Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Widget Category</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getWidgetCategory()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EAttribute getWidgetConfigurationMdsl_WidgetCategory();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getWidgetType <em>Widget Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Widget Type</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getWidgetType()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_WidgetType();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getDslReference <em>Dsl Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dsl Reference</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getDslReference()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_DslReference();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getFlexibleTemplate <em>Flexible Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Flexible Template</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getFlexibleTemplate()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_FlexibleTemplate();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getVisibilityQuery <em>Visibility Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Visibility Query</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getVisibilityQuery()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_VisibilityQuery();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getEditableQuery <em>Editable Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Editable Query</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getEditableQuery()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_EditableQuery();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValueConverter <em>Value Converter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Converter</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValueConverter()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_ValueConverter();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValidators <em>Validators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Validators</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValidators()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_Validators();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NFormat <em>I18N Format</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I18N Format</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NFormat()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EAttribute getWidgetConfigurationMdsl_I18NFormat();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValueFormat <em>Value Format</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Format</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getValueFormat()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_ValueFormat();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getCandidatesQuery <em>Candidates Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Candidates Query</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getCandidatesQuery()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_CandidatesQuery();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NItemLabel <em>I18N Item Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I18N Item Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#isI18NItemLabel()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EAttribute getWidgetConfigurationMdsl_I18NItemLabel();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getItemLabelExpression <em>Item Label Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Item Label Expression</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getItemLabelExpression()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_ItemLabelExpression();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getCommands <em>Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Commands</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl#getCommands()
   * @see #getWidgetConfigurationMdsl()
   * @generated
   */
  EReference getWidgetConfigurationMdsl_Commands();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl <em>Validator Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Validator Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl
   * @generated
   */
  EClass getValidatorMdsl();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#getValidationQuery <em>Validation Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Validation Query</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#getValidationQuery()
   * @see #getValidatorMdsl()
   * @generated
   */
  EReference getValidatorMdsl_ValidationQuery();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#isI18NMessage <em>I18N Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I18N Message</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#isI18NMessage()
   * @see #getValidatorMdsl()
   * @generated
   */
  EAttribute getValidatorMdsl_I18NMessage();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#getErrorMessageExpr <em>Error Message Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Error Message Expr</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl#getErrorMessageExpr()
   * @see #getValidatorMdsl()
   * @generated
   */
  EReference getValidatorMdsl_ErrorMessageExpr();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.CommandMdsl <em>Command Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandMdsl
   * @generated
   */
  EClass getCommandMdsl();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.CommandDeclaration <em>Command Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command Declaration</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDeclaration
   * @generated
   */
  EClass getCommandDeclaration();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.CommandDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDeclaration#getName()
   * @see #getCommandDeclaration()
   * @generated
   */
  EAttribute getCommandDeclaration_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.CommandDeclaration#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDeclaration#getLabel()
   * @see #getCommandDeclaration()
   * @generated
   */
  EAttribute getCommandDeclaration_Label();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.CommandDeclaration#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDeclaration#getDescription()
   * @see #getCommandDeclaration()
   * @generated
   */
  EAttribute getCommandDeclaration_Description();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.CommandDeclaration#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Definition</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDeclaration#getDefinition()
   * @see #getCommandDeclaration()
   * @generated
   */
  EReference getCommandDeclaration_Definition();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl <em>Command Definition Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command Definition Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl
   * @generated
   */
  EClass getCommandDefinitionMdsl();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Category</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getCategory()
   * @see #getCommandDefinitionMdsl()
   * @generated
   */
  EAttribute getCommandDefinitionMdsl_Category();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#isI18NLabel <em>I18N Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I18N Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#isI18NLabel()
   * @see #getCommandDefinitionMdsl()
   * @generated
   */
  EAttribute getCommandDefinitionMdsl_I18NLabel();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getLabel()
   * @see #getCommandDefinitionMdsl()
   * @generated
   */
  EReference getCommandDefinitionMdsl_Label();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getIcon <em>Icon</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Icon</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getIcon()
   * @see #getCommandDefinitionMdsl()
   * @generated
   */
  EReference getCommandDefinitionMdsl_Icon();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getAction()
   * @see #getCommandDefinitionMdsl()
   * @generated
   */
  EReference getCommandDefinitionMdsl_Action();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getOnActionSuccessUICommands <em>On Action Success UI Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>On Action Success UI Commands</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getOnActionSuccessUICommands()
   * @see #getCommandDefinitionMdsl()
   * @generated
   */
  EReference getCommandDefinitionMdsl_OnActionSuccessUICommands();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getOnActionErrorUICommands <em>On Action Error UI Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>On Action Error UI Commands</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl#getOnActionErrorUICommands()
   * @see #getCommandDefinitionMdsl()
   * @generated
   */
  EReference getCommandDefinitionMdsl_OnActionErrorUICommands();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl <em>Command Ref Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command Ref Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl
   * @generated
   */
  EClass getCommandRefMdsl();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#getReferenced <em>Referenced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Referenced</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#getReferenced()
   * @see #getCommandRefMdsl()
   * @generated
   */
  EReference getCommandRefMdsl_Referenced();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#isI18NLabelOverride <em>I18N Label Override</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I18N Label Override</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#isI18NLabelOverride()
   * @see #getCommandRefMdsl()
   * @generated
   */
  EAttribute getCommandRefMdsl_I18NLabelOverride();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#getLabelOverride <em>Label Override</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Label Override</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl#getLabelOverride()
   * @see #getCommandRefMdsl()
   * @generated
   */
  EReference getCommandRefMdsl_LabelOverride();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.UICommandMdsl <em>UI Command Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UI Command Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.UICommandMdsl
   * @generated
   */
  EClass getUICommandMdsl();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.DisplayViewUICommand <em>Display View UI Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Display View UI Command</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.DisplayViewUICommand
   * @generated
   */
  EClass getDisplayViewUICommand();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.DisplayViewUICommand#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.DisplayViewUICommand#getTarget()
   * @see #getDisplayViewUICommand()
   * @generated
   */
  EReference getDisplayViewUICommand_Target();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.ReloadViewUICommand <em>Reload View UI Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reload View UI Command</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ReloadViewUICommand
   * @generated
   */
  EClass getReloadViewUICommand();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand <em>Reload Widgets UI Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reload Widgets UI Command</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand
   * @generated
   */
  EClass getReloadWidgetsUICommand();

  /**
   * Returns the meta object for the reference list '{@link com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand#getWidgetsToReload <em>Widgets To Reload</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Widgets To Reload</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand#getWidgetsToReload()
   * @see #getReloadWidgetsUICommand()
   * @generated
   */
  EReference getReloadWidgetsUICommand_WidgetsToReload();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.QueryUsage <em>Query Usage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Usage</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryUsage
   * @generated
   */
  EClass getQueryUsage();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.QueryMdsl <em>Query Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryMdsl
   * @generated
   */
  EClass getQueryMdsl();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.QueryDeclaration <em>Query Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Declaration</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDeclaration
   * @generated
   */
  EClass getQueryDeclaration();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.QueryDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDeclaration#getName()
   * @see #getQueryDeclaration()
   * @generated
   */
  EAttribute getQueryDeclaration_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.QueryDeclaration#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDeclaration#getLabel()
   * @see #getQueryDeclaration()
   * @generated
   */
  EAttribute getQueryDeclaration_Label();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.QueryDeclaration#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDeclaration#getDescription()
   * @see #getQueryDeclaration()
   * @generated
   */
  EAttribute getQueryDeclaration_Description();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.QueryDeclaration#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Definition</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDeclaration#getDefinition()
   * @see #getQueryDeclaration()
   * @generated
   */
  EReference getQueryDeclaration_Definition();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl <em>Query Definition Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Definition Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl
   * @generated
   */
  EClass getQueryDefinitionMdsl();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getEvaluator <em>Evaluator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Evaluator</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getEvaluator()
   * @see #getQueryDefinitionMdsl()
   * @generated
   */
  EReference getQueryDefinitionMdsl_Evaluator();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getForeignModel <em>Foreign Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Foreign Model</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getForeignModel()
   * @see #getQueryDefinitionMdsl()
   * @generated
   */
  EReference getQueryDefinitionMdsl_ForeignModel();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getContextLocator <em>Context Locator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Context Locator</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getContextLocator()
   * @see #getQueryDefinitionMdsl()
   * @generated
   */
  EAttribute getQueryDefinitionMdsl_ContextLocator();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Query</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getQuery()
   * @see #getQueryDefinitionMdsl()
   * @generated
   */
  EReference getQueryDefinitionMdsl_Query();

  /**
   * Returns the meta object for the containment reference '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getExternalQueryCall <em>External Query Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>External Query Call</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getExternalQueryCall()
   * @see #getQueryDefinitionMdsl()
   * @generated
   */
  EReference getQueryDefinitionMdsl_ExternalQueryCall();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Return Type</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getReturnType()
   * @see #getQueryDefinitionMdsl()
   * @generated
   */
  EReference getQueryDefinitionMdsl_ReturnType();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getProperties()
   * @see #getQueryDefinitionMdsl()
   * @generated
   */
  EReference getQueryDefinitionMdsl_Properties();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getOptimisationLevel <em>Optimisation Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optimisation Level</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getOptimisationLevel()
   * @see #getQueryDefinitionMdsl()
   * @generated
   */
  EAttribute getQueryDefinitionMdsl_OptimisationLevel();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.QueryFragment <em>Query Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Fragment</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryFragment
   * @generated
   */
  EClass getQueryFragment();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.LiteralQueryFragment <em>Literal Query Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Query Fragment</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LiteralQueryFragment
   * @generated
   */
  EClass getLiteralQueryFragment();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.LiteralQueryFragment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LiteralQueryFragment#getValue()
   * @see #getLiteralQueryFragment()
   * @generated
   */
  EAttribute getLiteralQueryFragment_Value();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.QueryBody <em>Query Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Body</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryBody
   * @generated
   */
  EClass getQueryBody();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.QueryBody#getFragments <em>Fragments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fragments</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryBody#getFragments()
   * @see #getQueryBody()
   * @generated
   */
  EReference getQueryBody_Fragments();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.QueryRefMdsl <em>Query Ref Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Ref Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryRefMdsl
   * @generated
   */
  EClass getQueryRefMdsl();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.QueryRefMdsl#getReferenced <em>Referenced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Referenced</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryRefMdsl#getReferenced()
   * @see #getQueryRefMdsl()
   * @generated
   */
  EReference getQueryRefMdsl_Referenced();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl <em>External Query Call Mdsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Query Call Mdsl</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl
   * @generated
   */
  EClass getExternalQueryCallMdsl();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl#getExternalQuery <em>External Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>External Query</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl#getExternalQuery()
   * @see #getExternalQueryCallMdsl()
   * @generated
   */
  EReference getExternalQueryCallMdsl_ExternalQuery();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.QueryChain <em>Query Chain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Chain</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryChain
   * @generated
   */
  EClass getQueryChain();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.QueryChain#getQueries <em>Queries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Queries</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QueryChain#getQueries()
   * @see #getQueryChain()
   * @generated
   */
  EReference getQueryChain_Queries();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.FormatExpr <em>Format Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Format Expr</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.FormatExpr
   * @generated
   */
  EClass getFormatExpr();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysord.mad.configuration.madConfigDsl.FormatExpr#getFragments <em>Fragments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fragments</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.FormatExpr#getFragments()
   * @see #getFormatExpr()
   * @generated
   */
  EReference getFormatExpr_Fragments();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.FormatExprFragment <em>Format Expr Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Format Expr Fragment</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.FormatExprFragment
   * @generated
   */
  EClass getFormatExprFragment();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.LiteralFormatExprFragment <em>Literal Format Expr Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Format Expr Fragment</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LiteralFormatExprFragment
   * @generated
   */
  EClass getLiteralFormatExprFragment();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.LiteralFormatExprFragment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.LiteralFormatExprFragment#getValue()
   * @see #getLiteralFormatExprFragment()
   * @generated
   */
  EAttribute getLiteralFormatExprFragment_Value();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.TextMacro <em>Text Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Text Macro</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TextMacro
   * @generated
   */
  EClass getTextMacro();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TextMacro#getName()
   * @see #getTextMacro()
   * @generated
   */
  EAttribute getTextMacro_Name();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TextMacro#getLabel()
   * @see #getTextMacro()
   * @generated
   */
  EAttribute getTextMacro_Label();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TextMacro#getDescription()
   * @see #getTextMacro()
   * @generated
   */
  EAttribute getTextMacro_Description();

  /**
   * Returns the meta object for the attribute '{@link com.sysord.mad.configuration.madConfigDsl.TextMacro#getMacroValue <em>Macro Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Macro Value</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TextMacro#getMacroValue()
   * @see #getTextMacro()
   * @generated
   */
  EAttribute getTextMacro_MacroValue();

  /**
   * Returns the meta object for class '{@link com.sysord.mad.configuration.madConfigDsl.TextMacroRef <em>Text Macro Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Text Macro Ref</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TextMacroRef
   * @generated
   */
  EClass getTextMacroRef();

  /**
   * Returns the meta object for the reference '{@link com.sysord.mad.configuration.madConfigDsl.TextMacroRef#getReferenced <em>Referenced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Referenced</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.TextMacroRef#getReferenced()
   * @see #getTextMacroRef()
   * @generated
   */
  EReference getTextMacroRef_Referenced();

  /**
   * Returns the meta object for enum '{@link com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL <em>VALUE CONVERTER CATEGORY MDSL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>VALUE CONVERTER CATEGORY MDSL</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL
   * @generated
   */
  EEnum getVALUE_CONVERTER_CATEGORY_MDSL();

  /**
   * Returns the meta object for enum '{@link com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL <em>WIDGET CATEGORY MDSL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>WIDGET CATEGORY MDSL</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL
   * @generated
   */
  EEnum getWIDGET_CATEGORY_MDSL();

  /**
   * Returns the meta object for enum '{@link com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL <em>COMMAND CATEGORY MDSL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>COMMAND CATEGORY MDSL</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL
   * @generated
   */
  EEnum getCOMMAND_CATEGORY_MDSL();

  /**
   * Returns the meta object for enum '{@link com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL <em>QUERY OPTIMISATION LEVEL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>QUERY OPTIMISATION LEVEL</em>'.
   * @see com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL
   * @generated
   */
  EEnum getQUERY_OPTIMISATION_LEVEL();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MadConfigDslFactory getMadConfigDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.MADConfigurationImpl <em>MAD Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MADConfigurationImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getMADConfiguration()
     * @generated
     */
    EClass MAD_CONFIGURATION = eINSTANCE.getMADConfiguration();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAD_CONFIGURATION__IMPORTS = eINSTANCE.getMADConfiguration_Imports();

    /**
     * The meta object literal for the '<em><b>Config Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAD_CONFIGURATION__CONFIG_ELEMENTS = eINSTANCE.getMADConfiguration_ConfigElements();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.MADConfigElementImpl <em>MAD Config Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MADConfigElementImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getMADConfigElement()
     * @generated
     */
    EClass MAD_CONFIG_ELEMENT = eINSTANCE.getMADConfigElement();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.ImportImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ClassDescriptorMdslImpl <em>Class Descriptor Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.ClassDescriptorMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getClassDescriptorMdsl()
     * @generated
     */
    EClass CLASS_DESCRIPTOR_MDSL = eINSTANCE.getClassDescriptorMdsl();

    /**
     * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_DESCRIPTOR_MDSL__CLASS_NAME = eINSTANCE.getClassDescriptorMdsl_ClassName();

    /**
     * The meta object literal for the '<em><b>Plugin Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_DESCRIPTOR_MDSL__PLUGIN_ID = eINSTANCE.getClassDescriptorMdsl_PluginId();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.PropertyTypeMdslImpl <em>Property Type Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.PropertyTypeMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getPropertyTypeMdsl()
     * @generated
     */
    EClass PROPERTY_TYPE_MDSL = eINSTANCE.getPropertyTypeMdsl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_TYPE_MDSL__NAME = eINSTANCE.getPropertyTypeMdsl_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_TYPE_MDSL__LABEL = eINSTANCE.getPropertyTypeMdsl_Label();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.PropertyMdslImpl <em>Property Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.PropertyMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getPropertyMdsl()
     * @generated
     */
    EClass PROPERTY_MDSL = eINSTANCE.getPropertyMdsl();

    /**
     * The meta object literal for the '<em><b>Property Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_MDSL__PROPERTY_NAME = eINSTANCE.getPropertyMdsl_PropertyName();

    /**
     * The meta object literal for the '<em><b>Property Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_MDSL__PROPERTY_VALUE = eINSTANCE.getPropertyMdsl_PropertyValue();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.PropertyValueMdslImpl <em>Property Value Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.PropertyValueMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getPropertyValueMdsl()
     * @generated
     */
    EClass PROPERTY_VALUE_MDSL = eINSTANCE.getPropertyValueMdsl();

    /**
     * The meta object literal for the '<em><b>Fragments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_VALUE_MDSL__FRAGMENTS = eINSTANCE.getPropertyValueMdsl_Fragments();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.PropValueExprFragmentImpl <em>Prop Value Expr Fragment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.PropValueExprFragmentImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getPropValueExprFragment()
     * @generated
     */
    EClass PROP_VALUE_EXPR_FRAGMENT = eINSTANCE.getPropValueExprFragment();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.LiteraPropValueExprFragmentImpl <em>Litera Prop Value Expr Fragment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.LiteraPropValueExprFragmentImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getLiteraPropValueExprFragment()
     * @generated
     */
    EClass LITERA_PROP_VALUE_EXPR_FRAGMENT = eINSTANCE.getLiteraPropValueExprFragment();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERA_PROP_VALUE_EXPR_FRAGMENT__VALUE = eINSTANCE.getLiteraPropValueExprFragment_Value();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.IconDescriptorMdslImpl <em>Icon Descriptor Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.IconDescriptorMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getIconDescriptorMdsl()
     * @generated
     */
    EClass ICON_DESCRIPTOR_MDSL = eINSTANCE.getIconDescriptorMdsl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ICON_DESCRIPTOR_MDSL__NAME = eINSTANCE.getIconDescriptorMdsl_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ICON_DESCRIPTOR_MDSL__DESCRIPTION = eINSTANCE.getIconDescriptorMdsl_Description();

    /**
     * The meta object literal for the '<em><b>Bundle Descriptor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ICON_DESCRIPTOR_MDSL__BUNDLE_DESCRIPTOR = eINSTANCE.getIconDescriptorMdsl_BundleDescriptor();

    /**
     * The meta object literal for the '<em><b>Bundle Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ICON_DESCRIPTOR_MDSL__BUNDLE_URI = eINSTANCE.getIconDescriptorMdsl_BundleUri();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.I18NBundleMdslImpl <em>I18N Bundle Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.I18NBundleMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getI18NBundleMdsl()
     * @generated
     */
    EClass I18N_BUNDLE_MDSL = eINSTANCE.getI18NBundleMdsl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute I18N_BUNDLE_MDSL__NAME = eINSTANCE.getI18NBundleMdsl_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute I18N_BUNDLE_MDSL__DESCRIPTION = eINSTANCE.getI18NBundleMdsl_Description();

    /**
     * The meta object literal for the '<em><b>Bundle Descriptor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference I18N_BUNDLE_MDSL__BUNDLE_DESCRIPTOR = eINSTANCE.getI18NBundleMdsl_BundleDescriptor();

    /**
     * The meta object literal for the '<em><b>Bundle Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute I18N_BUNDLE_MDSL__BUNDLE_URI = eINSTANCE.getI18NBundleMdsl_BundleUri();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl <em>Foreign Model Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getForeignModelMdsl()
     * @generated
     */
    EClass FOREIGN_MODEL_MDSL = eINSTANCE.getForeignModelMdsl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOREIGN_MODEL_MDSL__NAME = eINSTANCE.getForeignModelMdsl_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOREIGN_MODEL_MDSL__LABEL = eINSTANCE.getForeignModelMdsl_Label();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOREIGN_MODEL_MDSL__DESCRIPTION = eINSTANCE.getForeignModelMdsl_Description();

    /**
     * The meta object literal for the '<em><b>Provider</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOREIGN_MODEL_MDSL__PROVIDER = eINSTANCE.getForeignModelMdsl_Provider();

    /**
     * The meta object literal for the '<em><b>Synchronizer Factory Class</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS = eINSTANCE.getForeignModelMdsl_SynchronizerFactoryClass();

    /**
     * The meta object literal for the '<em><b>Extension Manager Class</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS = eINSTANCE.getForeignModelMdsl_ExtensionManagerClass();

    /**
     * The meta object literal for the '<em><b>Dsl Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOREIGN_MODEL_MDSL__DSL_REFERENCE = eINSTANCE.getForeignModelMdsl_DslReference();

    /**
     * The meta object literal for the '<em><b>Relocator Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOREIGN_MODEL_MDSL__RELOCATOR_QUERY = eINSTANCE.getForeignModelMdsl_RelocatorQuery();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ModelProviderMdslImpl <em>Model Provider Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.ModelProviderMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getModelProviderMdsl()
     * @generated
     */
    EClass MODEL_PROVIDER_MDSL = eINSTANCE.getModelProviderMdsl();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.URIExtensionModelProviderMdslImpl <em>URI Extension Model Provider Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.URIExtensionModelProviderMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getURIExtensionModelProviderMdsl()
     * @generated
     */
    EClass URI_EXTENSION_MODEL_PROVIDER_MDSL = eINSTANCE.getURIExtensionModelProviderMdsl();

    /**
     * The meta object literal for the '<em><b>Uri Extension</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute URI_EXTENSION_MODEL_PROVIDER_MDSL__URI_EXTENSION = eINSTANCE.getURIExtensionModelProviderMdsl_UriExtension();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.URIModelProviderMdslImpl <em>URI Model Provider Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.URIModelProviderMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getURIModelProviderMdsl()
     * @generated
     */
    EClass URI_MODEL_PROVIDER_MDSL = eINSTANCE.getURIModelProviderMdsl();

    /**
     * The meta object literal for the '<em><b>Model Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute URI_MODEL_PROVIDER_MDSL__MODEL_URI = eINSTANCE.getURIModelProviderMdsl_ModelUri();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.CustomModelProviderMdslImpl <em>Custom Model Provider Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.CustomModelProviderMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCustomModelProviderMdsl()
     * @generated
     */
    EClass CUSTOM_MODEL_PROVIDER_MDSL = eINSTANCE.getCustomModelProviderMdsl();

    /**
     * The meta object literal for the '<em><b>Class Descriptor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CUSTOM_MODEL_PROVIDER_MDSL__CLASS_DESCRIPTOR = eINSTANCE.getCustomModelProviderMdsl_ClassDescriptor();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CUSTOM_MODEL_PROVIDER_MDSL__PARAMETERS = eINSTANCE.getCustomModelProviderMdsl_Parameters();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageDescriptorMdslImpl <em>Xtext Language Descriptor Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageDescriptorMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getXtextLanguageDescriptorMdsl()
     * @generated
     */
    EClass XTEXT_LANGUAGE_DESCRIPTOR_MDSL = eINSTANCE.getXtextLanguageDescriptorMdsl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XTEXT_LANGUAGE_DESCRIPTOR_MDSL__NAME = eINSTANCE.getXtextLanguageDescriptorMdsl_Name();

    /**
     * The meta object literal for the '<em><b>Language Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID = eINSTANCE.getXtextLanguageDescriptorMdsl_LanguageId();

    /**
     * The meta object literal for the '<em><b>Bundle Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID = eINSTANCE.getXtextLanguageDescriptorMdsl_BundleId();

    /**
     * The meta object literal for the '<em><b>Activator Class Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME = eINSTANCE.getXtextLanguageDescriptorMdsl_ActivatorClassName();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageReferenceImpl <em>Xtext Language Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.XtextLanguageReferenceImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getXtextLanguageReference()
     * @generated
     */
    EClass XTEXT_LANGUAGE_REFERENCE = eINSTANCE.getXtextLanguageReference();

    /**
     * The meta object literal for the '<em><b>Xtext Language Descriptor</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR = eINSTANCE.getXtextLanguageReference_XtextLanguageDescriptor();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.OCLCustomLibraryMdslImpl <em>OCL Custom Library Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.OCLCustomLibraryMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getOCLCustomLibraryMdsl()
     * @generated
     */
    EClass OCL_CUSTOM_LIBRARY_MDSL = eINSTANCE.getOCLCustomLibraryMdsl();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OCL_CUSTOM_LIBRARY_MDSL__LABEL = eINSTANCE.getOCLCustomLibraryMdsl_Label();

    /**
     * The meta object literal for the '<em><b>Class Descriptor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OCL_CUSTOM_LIBRARY_MDSL__CLASS_DESCRIPTOR = eINSTANCE.getOCLCustomLibraryMdsl_ClassDescriptor();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OCL_CUSTOM_LIBRARY_MDSL__DESCRIPTION = eINSTANCE.getOCLCustomLibraryMdsl_Description();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryEvaluatorMdslImpl <em>Query Evaluator Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryEvaluatorMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryEvaluatorMdsl()
     * @generated
     */
    EClass QUERY_EVALUATOR_MDSL = eINSTANCE.getQueryEvaluatorMdsl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY_EVALUATOR_MDSL__NAME = eINSTANCE.getQueryEvaluatorMdsl_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY_EVALUATOR_MDSL__LABEL = eINSTANCE.getQueryEvaluatorMdsl_Label();

    /**
     * The meta object literal for the '<em><b>Class Descriptor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR = eINSTANCE.getQueryEvaluatorMdsl_ClassDescriptor();

    /**
     * The meta object literal for the '<em><b>Query Properties Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_EVALUATOR_MDSL__QUERY_PROPERTIES_TYPES = eINSTANCE.getQueryEvaluatorMdsl_QueryPropertiesTypes();

    /**
     * The meta object literal for the '<em><b>Ext QService Class Descriptor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR = eINSTANCE.getQueryEvaluatorMdsl_ExtQServiceClassDescriptor();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY_EVALUATOR_MDSL__DESCRIPTION = eINSTANCE.getQueryEvaluatorMdsl_Description();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetTypeImpl <em>Widget Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.WidgetTypeImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getWidgetType()
     * @generated
     */
    EClass WIDGET_TYPE = eINSTANCE.getWidgetType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WIDGET_TYPE__NAME = eINSTANCE.getWidgetType_Name();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WIDGET_TYPE__CATEGORY = eINSTANCE.getWidgetType_Category();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WIDGET_TYPE__LABEL = eINSTANCE.getWidgetType_Label();

    /**
     * The meta object literal for the '<em><b>Class Descriptor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_TYPE__CLASS_DESCRIPTOR = eINSTANCE.getWidgetType_ClassDescriptor();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WIDGET_TYPE__DESCRIPTION = eINSTANCE.getWidgetType_Description();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.UITabMdslImpl <em>UI Tab Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.UITabMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getUITabMdsl()
     * @generated
     */
    EClass UI_TAB_MDSL = eINSTANCE.getUITabMdsl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UI_TAB_MDSL__NAME = eINSTANCE.getUITabMdsl_Name();

    /**
     * The meta object literal for the '<em><b>I18N Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UI_TAB_MDSL__I18_NLABEL = eINSTANCE.getUITabMdsl_I18NLabel();

    /**
     * The meta object literal for the '<em><b>Label Format Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UI_TAB_MDSL__LABEL_FORMAT_EXPR = eINSTANCE.getUITabMdsl_LabelFormatExpr();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UI_TAB_MDSL__DESCRIPTION = eINSTANCE.getUITabMdsl_Description();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.LayerMdslImpl <em>Layer Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.LayerMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getLayerMdsl()
     * @generated
     */
    EClass LAYER_MDSL = eINSTANCE.getLayerMdsl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LAYER_MDSL__NAME = eINSTANCE.getLayerMdsl_Name();

    /**
     * The meta object literal for the '<em><b>I18N Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LAYER_MDSL__I18_NLABEL = eINSTANCE.getLayerMdsl_I18NLabel();

    /**
     * The meta object literal for the '<em><b>Label Format Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LAYER_MDSL__LABEL_FORMAT_EXPR = eINSTANCE.getLayerMdsl_LabelFormatExpr();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LAYER_MDSL__DESCRIPTION = eINSTANCE.getLayerMdsl_Description();

    /**
     * The meta object literal for the '<em><b>Sub Layers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LAYER_MDSL__SUB_LAYERS = eINSTANCE.getLayerMdsl_SubLayers();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl <em>Type Configuration Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getTypeConfigurationMdsl()
     * @generated
     */
    EClass TYPE_CONFIGURATION_MDSL = eINSTANCE.getTypeConfigurationMdsl();

    /**
     * The meta object literal for the '<em><b>Default Configuration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_CONFIGURATION_MDSL__DEFAULT_CONFIGURATION = eINSTANCE.getTypeConfigurationMdsl_DefaultConfiguration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_CONFIGURATION_MDSL__NAME = eINSTANCE.getTypeConfigurationMdsl_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_CONFIGURATION_MDSL__TYPE = eINSTANCE.getTypeConfigurationMdsl_Type();

    /**
     * The meta object literal for the '<em><b>I18N Label Provider</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_CONFIGURATION_MDSL__I18_NLABEL_PROVIDER = eINSTANCE.getTypeConfigurationMdsl_I18NLabelProvider();

    /**
     * The meta object literal for the '<em><b>Label Provider Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION = eINSTANCE.getTypeConfigurationMdsl_LabelProviderExpression();

    /**
     * The meta object literal for the '<em><b>Use Explicit Extends</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_CONFIGURATION_MDSL__USE_EXPLICIT_EXTENDS = eINSTANCE.getTypeConfigurationMdsl_UseExplicitExtends();

    /**
     * The meta object literal for the '<em><b>Super Configurations</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_CONFIGURATION_MDSL__SUPER_CONFIGURATIONS = eINSTANCE.getTypeConfigurationMdsl_SuperConfigurations();

    /**
     * The meta object literal for the '<em><b>Template Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_CONFIGURATION_MDSL__TEMPLATE_ELEMENTS = eINSTANCE.getTypeConfigurationMdsl_TemplateElements();

    /**
     * The meta object literal for the '<em><b>Layout Defined</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_CONFIGURATION_MDSL__LAYOUT_DEFINED = eINSTANCE.getTypeConfigurationMdsl_LayoutDefined();

    /**
     * The meta object literal for the '<em><b>Layout Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_CONFIGURATION_MDSL__LAYOUT_ELEMENTS = eINSTANCE.getTypeConfigurationMdsl_LayoutElements();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationTemplateElementImpl <em>Type Configuration Template Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationTemplateElementImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getTypeConfigurationTemplateElement()
     * @generated
     */
    EClass TYPE_CONFIGURATION_TEMPLATE_ELEMENT = eINSTANCE.getTypeConfigurationTemplateElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME = eINSTANCE.getTypeConfigurationTemplateElement_Name();

    /**
     * The meta object literal for the '<em><b>Value Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY = eINSTANCE.getTypeConfigurationTemplateElement_ValueQuery();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.IncludeTemplateElementMdslImpl <em>Include Template Element Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.IncludeTemplateElementMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getIncludeTemplateElementMdsl()
     * @generated
     */
    EClass INCLUDE_TEMPLATE_ELEMENT_MDSL = eINSTANCE.getIncludeTemplateElementMdsl();

    /**
     * The meta object literal for the '<em><b>Ref Included Template</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE = eINSTANCE.getIncludeTemplateElementMdsl_RefIncludedTemplate();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ValueConverterImpl <em>Value Converter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.ValueConverterImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getValueConverter()
     * @generated
     */
    EClass VALUE_CONVERTER = eINSTANCE.getValueConverter();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryBasedValueConverterImpl <em>Query Based Value Converter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryBasedValueConverterImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryBasedValueConverter()
     * @generated
     */
    EClass QUERY_BASED_VALUE_CONVERTER = eINSTANCE.getQueryBasedValueConverter();

    /**
     * The meta object literal for the '<em><b>Converter Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY = eINSTANCE.getQueryBasedValueConverter_ConverterQuery();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.BasicTypeValueConverterImpl <em>Basic Type Value Converter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.BasicTypeValueConverterImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getBasicTypeValueConverter()
     * @generated
     */
    EClass BASIC_TYPE_VALUE_CONVERTER = eINSTANCE.getBasicTypeValueConverter();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASIC_TYPE_VALUE_CONVERTER__CATEGORY = eINSTANCE.getBasicTypeValueConverter_Category();

    /**
     * The meta object literal for the '<em><b>Configuration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASIC_TYPE_VALUE_CONVERTER__CONFIGURATION = eINSTANCE.getBasicTypeValueConverter_Configuration();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl <em>Widget Configuration Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getWidgetConfigurationMdsl()
     * @generated
     */
    EClass WIDGET_CONFIGURATION_MDSL = eINSTANCE.getWidgetConfigurationMdsl();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WIDGET_CONFIGURATION_MDSL__DESCRIPTION = eINSTANCE.getWidgetConfigurationMdsl_Description();

    /**
     * The meta object literal for the '<em><b>Ui Tab</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__UI_TAB = eINSTANCE.getWidgetConfigurationMdsl_UiTab();

    /**
     * The meta object literal for the '<em><b>Layers</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__LAYERS = eINSTANCE.getWidgetConfigurationMdsl_Layers();

    /**
     * The meta object literal for the '<em><b>I18N Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WIDGET_CONFIGURATION_MDSL__I18_NLABEL = eINSTANCE.getWidgetConfigurationMdsl_I18NLabel();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__LABEL = eINSTANCE.getWidgetConfigurationMdsl_Label();

    /**
     * The meta object literal for the '<em><b>Widget Category</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WIDGET_CONFIGURATION_MDSL__WIDGET_CATEGORY = eINSTANCE.getWidgetConfigurationMdsl_WidgetCategory();

    /**
     * The meta object literal for the '<em><b>Widget Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__WIDGET_TYPE = eINSTANCE.getWidgetConfigurationMdsl_WidgetType();

    /**
     * The meta object literal for the '<em><b>Dsl Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE = eINSTANCE.getWidgetConfigurationMdsl_DslReference();

    /**
     * The meta object literal for the '<em><b>Flexible Template</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__FLEXIBLE_TEMPLATE = eINSTANCE.getWidgetConfigurationMdsl_FlexibleTemplate();

    /**
     * The meta object literal for the '<em><b>Visibility Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY = eINSTANCE.getWidgetConfigurationMdsl_VisibilityQuery();

    /**
     * The meta object literal for the '<em><b>Editable Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY = eINSTANCE.getWidgetConfigurationMdsl_EditableQuery();

    /**
     * The meta object literal for the '<em><b>Value Converter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER = eINSTANCE.getWidgetConfigurationMdsl_ValueConverter();

    /**
     * The meta object literal for the '<em><b>Validators</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__VALIDATORS = eINSTANCE.getWidgetConfigurationMdsl_Validators();

    /**
     * The meta object literal for the '<em><b>I18N Format</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WIDGET_CONFIGURATION_MDSL__I18_NFORMAT = eINSTANCE.getWidgetConfigurationMdsl_I18NFormat();

    /**
     * The meta object literal for the '<em><b>Value Format</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT = eINSTANCE.getWidgetConfigurationMdsl_ValueFormat();

    /**
     * The meta object literal for the '<em><b>Candidates Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY = eINSTANCE.getWidgetConfigurationMdsl_CandidatesQuery();

    /**
     * The meta object literal for the '<em><b>I18N Item Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WIDGET_CONFIGURATION_MDSL__I18_NITEM_LABEL = eINSTANCE.getWidgetConfigurationMdsl_I18NItemLabel();

    /**
     * The meta object literal for the '<em><b>Item Label Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION = eINSTANCE.getWidgetConfigurationMdsl_ItemLabelExpression();

    /**
     * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDGET_CONFIGURATION_MDSL__COMMANDS = eINSTANCE.getWidgetConfigurationMdsl_Commands();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ValidatorMdslImpl <em>Validator Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.ValidatorMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getValidatorMdsl()
     * @generated
     */
    EClass VALIDATOR_MDSL = eINSTANCE.getValidatorMdsl();

    /**
     * The meta object literal for the '<em><b>Validation Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALIDATOR_MDSL__VALIDATION_QUERY = eINSTANCE.getValidatorMdsl_ValidationQuery();

    /**
     * The meta object literal for the '<em><b>I18N Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALIDATOR_MDSL__I18_NMESSAGE = eINSTANCE.getValidatorMdsl_I18NMessage();

    /**
     * The meta object literal for the '<em><b>Error Message Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALIDATOR_MDSL__ERROR_MESSAGE_EXPR = eINSTANCE.getValidatorMdsl_ErrorMessageExpr();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandMdslImpl <em>Command Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.CommandMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCommandMdsl()
     * @generated
     */
    EClass COMMAND_MDSL = eINSTANCE.getCommandMdsl();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDeclarationImpl <em>Command Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.CommandDeclarationImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCommandDeclaration()
     * @generated
     */
    EClass COMMAND_DECLARATION = eINSTANCE.getCommandDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND_DECLARATION__NAME = eINSTANCE.getCommandDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND_DECLARATION__LABEL = eINSTANCE.getCommandDeclaration_Label();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND_DECLARATION__DESCRIPTION = eINSTANCE.getCommandDeclaration_Description();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_DECLARATION__DEFINITION = eINSTANCE.getCommandDeclaration_Definition();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl <em>Command Definition Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCommandDefinitionMdsl()
     * @generated
     */
    EClass COMMAND_DEFINITION_MDSL = eINSTANCE.getCommandDefinitionMdsl();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND_DEFINITION_MDSL__CATEGORY = eINSTANCE.getCommandDefinitionMdsl_Category();

    /**
     * The meta object literal for the '<em><b>I18N Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND_DEFINITION_MDSL__I18_NLABEL = eINSTANCE.getCommandDefinitionMdsl_I18NLabel();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_DEFINITION_MDSL__LABEL = eINSTANCE.getCommandDefinitionMdsl_Label();

    /**
     * The meta object literal for the '<em><b>Icon</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_DEFINITION_MDSL__ICON = eINSTANCE.getCommandDefinitionMdsl_Icon();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_DEFINITION_MDSL__ACTION = eINSTANCE.getCommandDefinitionMdsl_Action();

    /**
     * The meta object literal for the '<em><b>On Action Success UI Commands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_DEFINITION_MDSL__ON_ACTION_SUCCESS_UI_COMMANDS = eINSTANCE.getCommandDefinitionMdsl_OnActionSuccessUICommands();

    /**
     * The meta object literal for the '<em><b>On Action Error UI Commands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_DEFINITION_MDSL__ON_ACTION_ERROR_UI_COMMANDS = eINSTANCE.getCommandDefinitionMdsl_OnActionErrorUICommands();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandRefMdslImpl <em>Command Ref Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.CommandRefMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCommandRefMdsl()
     * @generated
     */
    EClass COMMAND_REF_MDSL = eINSTANCE.getCommandRefMdsl();

    /**
     * The meta object literal for the '<em><b>Referenced</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_REF_MDSL__REFERENCED = eINSTANCE.getCommandRefMdsl_Referenced();

    /**
     * The meta object literal for the '<em><b>I18N Label Override</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND_REF_MDSL__I18_NLABEL_OVERRIDE = eINSTANCE.getCommandRefMdsl_I18NLabelOverride();

    /**
     * The meta object literal for the '<em><b>Label Override</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_REF_MDSL__LABEL_OVERRIDE = eINSTANCE.getCommandRefMdsl_LabelOverride();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.UICommandMdslImpl <em>UI Command Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.UICommandMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getUICommandMdsl()
     * @generated
     */
    EClass UI_COMMAND_MDSL = eINSTANCE.getUICommandMdsl();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.DisplayViewUICommandImpl <em>Display View UI Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.DisplayViewUICommandImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getDisplayViewUICommand()
     * @generated
     */
    EClass DISPLAY_VIEW_UI_COMMAND = eINSTANCE.getDisplayViewUICommand();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPLAY_VIEW_UI_COMMAND__TARGET = eINSTANCE.getDisplayViewUICommand_Target();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ReloadViewUICommandImpl <em>Reload View UI Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.ReloadViewUICommandImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getReloadViewUICommand()
     * @generated
     */
    EClass RELOAD_VIEW_UI_COMMAND = eINSTANCE.getReloadViewUICommand();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ReloadWidgetsUICommandImpl <em>Reload Widgets UI Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.ReloadWidgetsUICommandImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getReloadWidgetsUICommand()
     * @generated
     */
    EClass RELOAD_WIDGETS_UI_COMMAND = eINSTANCE.getReloadWidgetsUICommand();

    /**
     * The meta object literal for the '<em><b>Widgets To Reload</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELOAD_WIDGETS_UI_COMMAND__WIDGETS_TO_RELOAD = eINSTANCE.getReloadWidgetsUICommand_WidgetsToReload();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryUsageImpl <em>Query Usage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryUsageImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryUsage()
     * @generated
     */
    EClass QUERY_USAGE = eINSTANCE.getQueryUsage();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryMdslImpl <em>Query Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryMdsl()
     * @generated
     */
    EClass QUERY_MDSL = eINSTANCE.getQueryMdsl();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDeclarationImpl <em>Query Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryDeclarationImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryDeclaration()
     * @generated
     */
    EClass QUERY_DECLARATION = eINSTANCE.getQueryDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY_DECLARATION__NAME = eINSTANCE.getQueryDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY_DECLARATION__LABEL = eINSTANCE.getQueryDeclaration_Label();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY_DECLARATION__DESCRIPTION = eINSTANCE.getQueryDeclaration_Description();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_DECLARATION__DEFINITION = eINSTANCE.getQueryDeclaration_Definition();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl <em>Query Definition Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryDefinitionMdsl()
     * @generated
     */
    EClass QUERY_DEFINITION_MDSL = eINSTANCE.getQueryDefinitionMdsl();

    /**
     * The meta object literal for the '<em><b>Evaluator</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_DEFINITION_MDSL__EVALUATOR = eINSTANCE.getQueryDefinitionMdsl_Evaluator();

    /**
     * The meta object literal for the '<em><b>Foreign Model</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_DEFINITION_MDSL__FOREIGN_MODEL = eINSTANCE.getQueryDefinitionMdsl_ForeignModel();

    /**
     * The meta object literal for the '<em><b>Context Locator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY_DEFINITION_MDSL__CONTEXT_LOCATOR = eINSTANCE.getQueryDefinitionMdsl_ContextLocator();

    /**
     * The meta object literal for the '<em><b>Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_DEFINITION_MDSL__QUERY = eINSTANCE.getQueryDefinitionMdsl_Query();

    /**
     * The meta object literal for the '<em><b>External Query Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL = eINSTANCE.getQueryDefinitionMdsl_ExternalQueryCall();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_DEFINITION_MDSL__RETURN_TYPE = eINSTANCE.getQueryDefinitionMdsl_ReturnType();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_DEFINITION_MDSL__PROPERTIES = eINSTANCE.getQueryDefinitionMdsl_Properties();

    /**
     * The meta object literal for the '<em><b>Optimisation Level</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY_DEFINITION_MDSL__OPTIMISATION_LEVEL = eINSTANCE.getQueryDefinitionMdsl_OptimisationLevel();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryFragmentImpl <em>Query Fragment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryFragmentImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryFragment()
     * @generated
     */
    EClass QUERY_FRAGMENT = eINSTANCE.getQueryFragment();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.LiteralQueryFragmentImpl <em>Literal Query Fragment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.LiteralQueryFragmentImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getLiteralQueryFragment()
     * @generated
     */
    EClass LITERAL_QUERY_FRAGMENT = eINSTANCE.getLiteralQueryFragment();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL_QUERY_FRAGMENT__VALUE = eINSTANCE.getLiteralQueryFragment_Value();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryBodyImpl <em>Query Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryBodyImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryBody()
     * @generated
     */
    EClass QUERY_BODY = eINSTANCE.getQueryBody();

    /**
     * The meta object literal for the '<em><b>Fragments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_BODY__FRAGMENTS = eINSTANCE.getQueryBody_Fragments();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryRefMdslImpl <em>Query Ref Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryRefMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryRefMdsl()
     * @generated
     */
    EClass QUERY_REF_MDSL = eINSTANCE.getQueryRefMdsl();

    /**
     * The meta object literal for the '<em><b>Referenced</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_REF_MDSL__REFERENCED = eINSTANCE.getQueryRefMdsl_Referenced();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.ExternalQueryCallMdslImpl <em>External Query Call Mdsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.ExternalQueryCallMdslImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getExternalQueryCallMdsl()
     * @generated
     */
    EClass EXTERNAL_QUERY_CALL_MDSL = eINSTANCE.getExternalQueryCallMdsl();

    /**
     * The meta object literal for the '<em><b>External Query</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY = eINSTANCE.getExternalQueryCallMdsl_ExternalQuery();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryChainImpl <em>Query Chain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.QueryChainImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQueryChain()
     * @generated
     */
    EClass QUERY_CHAIN = eINSTANCE.getQueryChain();

    /**
     * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_CHAIN__QUERIES = eINSTANCE.getQueryChain_Queries();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.FormatExprImpl <em>Format Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.FormatExprImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getFormatExpr()
     * @generated
     */
    EClass FORMAT_EXPR = eINSTANCE.getFormatExpr();

    /**
     * The meta object literal for the '<em><b>Fragments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMAT_EXPR__FRAGMENTS = eINSTANCE.getFormatExpr_Fragments();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.FormatExprFragmentImpl <em>Format Expr Fragment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.FormatExprFragmentImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getFormatExprFragment()
     * @generated
     */
    EClass FORMAT_EXPR_FRAGMENT = eINSTANCE.getFormatExprFragment();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.LiteralFormatExprFragmentImpl <em>Literal Format Expr Fragment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.LiteralFormatExprFragmentImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getLiteralFormatExprFragment()
     * @generated
     */
    EClass LITERAL_FORMAT_EXPR_FRAGMENT = eINSTANCE.getLiteralFormatExprFragment();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL_FORMAT_EXPR_FRAGMENT__VALUE = eINSTANCE.getLiteralFormatExprFragment_Value();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.TextMacroImpl <em>Text Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.TextMacroImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getTextMacro()
     * @generated
     */
    EClass TEXT_MACRO = eINSTANCE.getTextMacro();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXT_MACRO__NAME = eINSTANCE.getTextMacro_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXT_MACRO__LABEL = eINSTANCE.getTextMacro_Label();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXT_MACRO__DESCRIPTION = eINSTANCE.getTextMacro_Description();

    /**
     * The meta object literal for the '<em><b>Macro Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXT_MACRO__MACRO_VALUE = eINSTANCE.getTextMacro_MacroValue();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.impl.TextMacroRefImpl <em>Text Macro Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.impl.TextMacroRefImpl
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getTextMacroRef()
     * @generated
     */
    EClass TEXT_MACRO_REF = eINSTANCE.getTextMacroRef();

    /**
     * The meta object literal for the '<em><b>Referenced</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXT_MACRO_REF__REFERENCED = eINSTANCE.getTextMacroRef_Referenced();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL <em>VALUE CONVERTER CATEGORY MDSL</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getVALUE_CONVERTER_CATEGORY_MDSL()
     * @generated
     */
    EEnum VALUE_CONVERTER_CATEGORY_MDSL = eINSTANCE.getVALUE_CONVERTER_CATEGORY_MDSL();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL <em>WIDGET CATEGORY MDSL</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getWIDGET_CATEGORY_MDSL()
     * @generated
     */
    EEnum WIDGET_CATEGORY_MDSL = eINSTANCE.getWIDGET_CATEGORY_MDSL();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL <em>COMMAND CATEGORY MDSL</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getCOMMAND_CATEGORY_MDSL()
     * @generated
     */
    EEnum COMMAND_CATEGORY_MDSL = eINSTANCE.getCOMMAND_CATEGORY_MDSL();

    /**
     * The meta object literal for the '{@link com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL <em>QUERY OPTIMISATION LEVEL</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL
     * @see com.sysord.mad.configuration.madConfigDsl.impl.MadConfigDslPackageImpl#getQUERY_OPTIMISATION_LEVEL()
     * @generated
     */
    EEnum QUERY_OPTIMISATION_LEVEL = eINSTANCE.getQUERY_OPTIMISATION_LEVEL();

  }

} //MadConfigDslPackage
