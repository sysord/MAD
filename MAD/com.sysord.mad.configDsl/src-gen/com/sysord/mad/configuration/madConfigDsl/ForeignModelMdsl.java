/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Model Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getProvider <em>Provider</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getSynchronizerFactoryClass <em>Synchronizer Factory Class</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getExtensionManagerClass <em>Extension Manager Class</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getDslReference <em>Dsl Reference</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getRelocatorQuery <em>Relocator Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getForeignModelMdsl()
 * @model
 * @generated
 */
public interface ForeignModelMdsl extends MADConfigElement
{
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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getForeignModelMdsl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label</em>' attribute.
   * @see #setLabel(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getForeignModelMdsl_Label()
   * @model
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getForeignModelMdsl_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Provider</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Provider</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Provider</em>' containment reference.
   * @see #setProvider(ModelProviderMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getForeignModelMdsl_Provider()
   * @model containment="true"
   * @generated
   */
  ModelProviderMdsl getProvider();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getProvider <em>Provider</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Provider</em>' containment reference.
   * @see #getProvider()
   * @generated
   */
  void setProvider(ModelProviderMdsl value);

  /**
   * Returns the value of the '<em><b>Synchronizer Factory Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Synchronizer Factory Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Synchronizer Factory Class</em>' containment reference.
   * @see #setSynchronizerFactoryClass(ClassDescriptorMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getForeignModelMdsl_SynchronizerFactoryClass()
   * @model containment="true"
   * @generated
   */
  ClassDescriptorMdsl getSynchronizerFactoryClass();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getSynchronizerFactoryClass <em>Synchronizer Factory Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Synchronizer Factory Class</em>' containment reference.
   * @see #getSynchronizerFactoryClass()
   * @generated
   */
  void setSynchronizerFactoryClass(ClassDescriptorMdsl value);

  /**
   * Returns the value of the '<em><b>Extension Manager Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension Manager Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extension Manager Class</em>' containment reference.
   * @see #setExtensionManagerClass(ClassDescriptorMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getForeignModelMdsl_ExtensionManagerClass()
   * @model containment="true"
   * @generated
   */
  ClassDescriptorMdsl getExtensionManagerClass();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getExtensionManagerClass <em>Extension Manager Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extension Manager Class</em>' containment reference.
   * @see #getExtensionManagerClass()
   * @generated
   */
  void setExtensionManagerClass(ClassDescriptorMdsl value);

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
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getForeignModelMdsl_DslReference()
   * @model containment="true"
   * @generated
   */
  XtextLanguageReference getDslReference();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getDslReference <em>Dsl Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dsl Reference</em>' containment reference.
   * @see #getDslReference()
   * @generated
   */
  void setDslReference(XtextLanguageReference value);

  /**
   * Returns the value of the '<em><b>Relocator Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relocator Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relocator Query</em>' containment reference.
   * @see #setRelocatorQuery(QueryMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getForeignModelMdsl_RelocatorQuery()
   * @model containment="true"
   * @generated
   */
  QueryMdsl getRelocatorQuery();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl#getRelocatorQuery <em>Relocator Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relocator Query</em>' containment reference.
   * @see #getRelocatorQuery()
   * @generated
   */
  void setRelocatorQuery(QueryMdsl value);

} // ForeignModelMdsl
