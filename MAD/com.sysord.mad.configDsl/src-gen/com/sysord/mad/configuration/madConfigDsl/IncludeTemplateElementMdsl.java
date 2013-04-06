/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include Template Element Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl#getRefIncludedTemplate <em>Ref Included Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getIncludeTemplateElementMdsl()
 * @model
 * @generated
 */
public interface IncludeTemplateElementMdsl extends TypeConfigurationTemplateElement
{
  /**
   * Returns the value of the '<em><b>Ref Included Template</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref Included Template</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Included Template</em>' reference.
   * @see #setRefIncludedTemplate(TypeConfigurationMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getIncludeTemplateElementMdsl_RefIncludedTemplate()
   * @model
   * @generated
   */
  TypeConfigurationMdsl getRefIncludedTemplate();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl#getRefIncludedTemplate <em>Ref Included Template</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Included Template</em>' reference.
   * @see #getRefIncludedTemplate()
   * @generated
   */
  void setRefIncludedTemplate(TypeConfigurationMdsl value);

} // IncludeTemplateElementMdsl
