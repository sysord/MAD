/**
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtext Language Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference#getXtextLanguageDescriptor <em>Xtext Language Descriptor</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getXtextLanguageReference()
 * @model
 * @generated
 */
public interface XtextLanguageReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Xtext Language Descriptor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xtext Language Descriptor</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xtext Language Descriptor</em>' reference.
   * @see #setXtextLanguageDescriptor(XtextLanguageDescriptorMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getXtextLanguageReference_XtextLanguageDescriptor()
   * @model
   * @generated
   */
  XtextLanguageDescriptorMdsl getXtextLanguageDescriptor();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference#getXtextLanguageDescriptor <em>Xtext Language Descriptor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xtext Language Descriptor</em>' reference.
   * @see #getXtextLanguageDescriptor()
   * @generated
   */
  void setXtextLanguageDescriptor(XtextLanguageDescriptorMdsl value);

} // XtextLanguageReference
