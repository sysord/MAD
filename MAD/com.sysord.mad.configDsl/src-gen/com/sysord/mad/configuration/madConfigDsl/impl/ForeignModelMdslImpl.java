/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.ModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryMdsl;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreign Model Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl#getSynchronizerFactoryClass <em>Synchronizer Factory Class</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl#getExtensionManagerClass <em>Extension Manager Class</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl#getDslReference <em>Dsl Reference</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.ForeignModelMdslImpl#getRelocatorQuery <em>Relocator Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForeignModelMdslImpl extends MADConfigElementImpl implements ForeignModelMdsl
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected static final String LABEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected String label = LABEL_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getProvider() <em>Provider</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProvider()
   * @generated
   * @ordered
   */
  protected ModelProviderMdsl provider;

  /**
   * The cached value of the '{@link #getSynchronizerFactoryClass() <em>Synchronizer Factory Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSynchronizerFactoryClass()
   * @generated
   * @ordered
   */
  protected ClassDescriptorMdsl synchronizerFactoryClass;

  /**
   * The cached value of the '{@link #getExtensionManagerClass() <em>Extension Manager Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtensionManagerClass()
   * @generated
   * @ordered
   */
  protected ClassDescriptorMdsl extensionManagerClass;

  /**
   * The cached value of the '{@link #getDslReference() <em>Dsl Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDslReference()
   * @generated
   * @ordered
   */
  protected XtextLanguageReference dslReference;

  /**
   * The cached value of the '{@link #getRelocatorQuery() <em>Relocator Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelocatorQuery()
   * @generated
   * @ordered
   */
  protected QueryMdsl relocatorQuery;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForeignModelMdslImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MadConfigDslPackage.Literals.FOREIGN_MODEL_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLabel()
  {
    return label;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabel(String newLabel)
  {
    String oldLabel = label;
    label = newLabel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__LABEL, oldLabel, label));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelProviderMdsl getProvider()
  {
    return provider;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProvider(ModelProviderMdsl newProvider, NotificationChain msgs)
  {
    ModelProviderMdsl oldProvider = provider;
    provider = newProvider;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__PROVIDER, oldProvider, newProvider);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProvider(ModelProviderMdsl newProvider)
  {
    if (newProvider != provider)
    {
      NotificationChain msgs = null;
      if (provider != null)
        msgs = ((InternalEObject)provider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.FOREIGN_MODEL_MDSL__PROVIDER, null, msgs);
      if (newProvider != null)
        msgs = ((InternalEObject)newProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.FOREIGN_MODEL_MDSL__PROVIDER, null, msgs);
      msgs = basicSetProvider(newProvider, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__PROVIDER, newProvider, newProvider));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDescriptorMdsl getSynchronizerFactoryClass()
  {
    return synchronizerFactoryClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSynchronizerFactoryClass(ClassDescriptorMdsl newSynchronizerFactoryClass, NotificationChain msgs)
  {
    ClassDescriptorMdsl oldSynchronizerFactoryClass = synchronizerFactoryClass;
    synchronizerFactoryClass = newSynchronizerFactoryClass;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS, oldSynchronizerFactoryClass, newSynchronizerFactoryClass);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSynchronizerFactoryClass(ClassDescriptorMdsl newSynchronizerFactoryClass)
  {
    if (newSynchronizerFactoryClass != synchronizerFactoryClass)
    {
      NotificationChain msgs = null;
      if (synchronizerFactoryClass != null)
        msgs = ((InternalEObject)synchronizerFactoryClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS, null, msgs);
      if (newSynchronizerFactoryClass != null)
        msgs = ((InternalEObject)newSynchronizerFactoryClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS, null, msgs);
      msgs = basicSetSynchronizerFactoryClass(newSynchronizerFactoryClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS, newSynchronizerFactoryClass, newSynchronizerFactoryClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDescriptorMdsl getExtensionManagerClass()
  {
    return extensionManagerClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtensionManagerClass(ClassDescriptorMdsl newExtensionManagerClass, NotificationChain msgs)
  {
    ClassDescriptorMdsl oldExtensionManagerClass = extensionManagerClass;
    extensionManagerClass = newExtensionManagerClass;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS, oldExtensionManagerClass, newExtensionManagerClass);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtensionManagerClass(ClassDescriptorMdsl newExtensionManagerClass)
  {
    if (newExtensionManagerClass != extensionManagerClass)
    {
      NotificationChain msgs = null;
      if (extensionManagerClass != null)
        msgs = ((InternalEObject)extensionManagerClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS, null, msgs);
      if (newExtensionManagerClass != null)
        msgs = ((InternalEObject)newExtensionManagerClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS, null, msgs);
      msgs = basicSetExtensionManagerClass(newExtensionManagerClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS, newExtensionManagerClass, newExtensionManagerClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextLanguageReference getDslReference()
  {
    return dslReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDslReference(XtextLanguageReference newDslReference, NotificationChain msgs)
  {
    XtextLanguageReference oldDslReference = dslReference;
    dslReference = newDslReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__DSL_REFERENCE, oldDslReference, newDslReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDslReference(XtextLanguageReference newDslReference)
  {
    if (newDslReference != dslReference)
    {
      NotificationChain msgs = null;
      if (dslReference != null)
        msgs = ((InternalEObject)dslReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.FOREIGN_MODEL_MDSL__DSL_REFERENCE, null, msgs);
      if (newDslReference != null)
        msgs = ((InternalEObject)newDslReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.FOREIGN_MODEL_MDSL__DSL_REFERENCE, null, msgs);
      msgs = basicSetDslReference(newDslReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__DSL_REFERENCE, newDslReference, newDslReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryMdsl getRelocatorQuery()
  {
    return relocatorQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRelocatorQuery(QueryMdsl newRelocatorQuery, NotificationChain msgs)
  {
    QueryMdsl oldRelocatorQuery = relocatorQuery;
    relocatorQuery = newRelocatorQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__RELOCATOR_QUERY, oldRelocatorQuery, newRelocatorQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRelocatorQuery(QueryMdsl newRelocatorQuery)
  {
    if (newRelocatorQuery != relocatorQuery)
    {
      NotificationChain msgs = null;
      if (relocatorQuery != null)
        msgs = ((InternalEObject)relocatorQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.FOREIGN_MODEL_MDSL__RELOCATOR_QUERY, null, msgs);
      if (newRelocatorQuery != null)
        msgs = ((InternalEObject)newRelocatorQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.FOREIGN_MODEL_MDSL__RELOCATOR_QUERY, null, msgs);
      msgs = basicSetRelocatorQuery(newRelocatorQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.FOREIGN_MODEL_MDSL__RELOCATOR_QUERY, newRelocatorQuery, newRelocatorQuery));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__PROVIDER:
        return basicSetProvider(null, msgs);
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS:
        return basicSetSynchronizerFactoryClass(null, msgs);
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS:
        return basicSetExtensionManagerClass(null, msgs);
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__DSL_REFERENCE:
        return basicSetDslReference(null, msgs);
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__RELOCATOR_QUERY:
        return basicSetRelocatorQuery(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__NAME:
        return getName();
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__LABEL:
        return getLabel();
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__DESCRIPTION:
        return getDescription();
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__PROVIDER:
        return getProvider();
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS:
        return getSynchronizerFactoryClass();
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS:
        return getExtensionManagerClass();
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__DSL_REFERENCE:
        return getDslReference();
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__RELOCATOR_QUERY:
        return getRelocatorQuery();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__NAME:
        setName((String)newValue);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__LABEL:
        setLabel((String)newValue);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__PROVIDER:
        setProvider((ModelProviderMdsl)newValue);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS:
        setSynchronizerFactoryClass((ClassDescriptorMdsl)newValue);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS:
        setExtensionManagerClass((ClassDescriptorMdsl)newValue);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__DSL_REFERENCE:
        setDslReference((XtextLanguageReference)newValue);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__RELOCATOR_QUERY:
        setRelocatorQuery((QueryMdsl)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__LABEL:
        setLabel(LABEL_EDEFAULT);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__PROVIDER:
        setProvider((ModelProviderMdsl)null);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS:
        setSynchronizerFactoryClass((ClassDescriptorMdsl)null);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS:
        setExtensionManagerClass((ClassDescriptorMdsl)null);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__DSL_REFERENCE:
        setDslReference((XtextLanguageReference)null);
        return;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__RELOCATOR_QUERY:
        setRelocatorQuery((QueryMdsl)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__LABEL:
        return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__PROVIDER:
        return provider != null;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__SYNCHRONIZER_FACTORY_CLASS:
        return synchronizerFactoryClass != null;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__EXTENSION_MANAGER_CLASS:
        return extensionManagerClass != null;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__DSL_REFERENCE:
        return dslReference != null;
      case MadConfigDslPackage.FOREIGN_MODEL_MDSL__RELOCATOR_QUERY:
        return relocatorQuery != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", label: ");
    result.append(label);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} //ForeignModelMdslImpl
