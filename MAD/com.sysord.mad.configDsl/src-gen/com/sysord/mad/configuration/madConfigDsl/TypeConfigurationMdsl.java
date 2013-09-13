/**
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Configuration Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isDefaultConfiguration <em>Default Configuration</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getType <em>Type</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isI18NLabelProvider <em>I18N Label Provider</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getLabelProviderExpression <em>Label Provider Expression</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isUseExplicitExtends <em>Use Explicit Extends</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getSuperConfigurations <em>Super Configurations</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getTemplateElements <em>Template Elements</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isLayoutDefined <em>Layout Defined</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getLayoutElements <em>Layout Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl()
 * @model
 * @generated
 */
public interface TypeConfigurationMdsl extends MADConfigElement
{
  /**
   * Returns the value of the '<em><b>Default Configuration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Configuration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Configuration</em>' attribute.
   * @see #setDefaultConfiguration(boolean)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl_DefaultConfiguration()
   * @model
   * @generated
   */
  boolean isDefaultConfiguration();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isDefaultConfiguration <em>Default Configuration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Configuration</em>' attribute.
   * @see #isDefaultConfiguration()
   * @generated
   */
  void setDefaultConfiguration(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClass)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl_Type()
   * @model
   * @generated
   */
  EClass getType();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClass value);

  /**
   * Returns the value of the '<em><b>I18N Label Provider</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>I18N Label Provider</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>I18N Label Provider</em>' attribute.
   * @see #setI18NLabelProvider(boolean)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl_I18NLabelProvider()
   * @model
   * @generated
   */
  boolean isI18NLabelProvider();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isI18NLabelProvider <em>I18N Label Provider</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>I18N Label Provider</em>' attribute.
   * @see #isI18NLabelProvider()
   * @generated
   */
  void setI18NLabelProvider(boolean value);

  /**
   * Returns the value of the '<em><b>Label Provider Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label Provider Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label Provider Expression</em>' containment reference.
   * @see #setLabelProviderExpression(FormatExpr)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl_LabelProviderExpression()
   * @model containment="true"
   * @generated
   */
  FormatExpr getLabelProviderExpression();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#getLabelProviderExpression <em>Label Provider Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label Provider Expression</em>' containment reference.
   * @see #getLabelProviderExpression()
   * @generated
   */
  void setLabelProviderExpression(FormatExpr value);

  /**
   * Returns the value of the '<em><b>Use Explicit Extends</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Explicit Extends</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Explicit Extends</em>' attribute.
   * @see #setUseExplicitExtends(boolean)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl_UseExplicitExtends()
   * @model
   * @generated
   */
  boolean isUseExplicitExtends();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isUseExplicitExtends <em>Use Explicit Extends</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Explicit Extends</em>' attribute.
   * @see #isUseExplicitExtends()
   * @generated
   */
  void setUseExplicitExtends(boolean value);

  /**
   * Returns the value of the '<em><b>Super Configurations</b></em>' reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Configurations</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Configurations</em>' reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl_SuperConfigurations()
   * @model
   * @generated
   */
  EList<TypeConfigurationMdsl> getSuperConfigurations();

  /**
   * Returns the value of the '<em><b>Template Elements</b></em>' containment reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template Elements</em>' containment reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl_TemplateElements()
   * @model containment="true"
   * @generated
   */
  EList<TypeConfigurationTemplateElement> getTemplateElements();

  /**
   * Returns the value of the '<em><b>Layout Defined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Layout Defined</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Layout Defined</em>' attribute.
   * @see #setLayoutDefined(boolean)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl_LayoutDefined()
   * @model
   * @generated
   */
  boolean isLayoutDefined();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl#isLayoutDefined <em>Layout Defined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Layout Defined</em>' attribute.
   * @see #isLayoutDefined()
   * @generated
   */
  void setLayoutDefined(boolean value);

  /**
   * Returns the value of the '<em><b>Layout Elements</b></em>' reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Layout Elements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Layout Elements</em>' reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getTypeConfigurationMdsl_LayoutElements()
   * @model
   * @generated
   */
  EList<TypeConfigurationTemplateElement> getLayoutElements();

} // TypeConfigurationMdsl
