/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Evaluator Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryEvaluatorMdslImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryEvaluatorMdslImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryEvaluatorMdslImpl#getClassDescriptor <em>Class Descriptor</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryEvaluatorMdslImpl#getQueryPropertiesTypes <em>Query Properties Types</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryEvaluatorMdslImpl#getExtQServiceClassDescriptor <em>Ext QService Class Descriptor</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryEvaluatorMdslImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryEvaluatorMdslImpl extends MADConfigElementImpl implements QueryEvaluatorMdsl
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
   * The cached value of the '{@link #getClassDescriptor() <em>Class Descriptor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassDescriptor()
   * @generated
   * @ordered
   */
  protected ClassDescriptorMdsl classDescriptor;

  /**
   * The cached value of the '{@link #getQueryPropertiesTypes() <em>Query Properties Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQueryPropertiesTypes()
   * @generated
   * @ordered
   */
  protected EList<PropertyTypeMdsl> queryPropertiesTypes;

  /**
   * The cached value of the '{@link #getExtQServiceClassDescriptor() <em>Ext QService Class Descriptor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtQServiceClassDescriptor()
   * @generated
   * @ordered
   */
  protected ClassDescriptorMdsl extQServiceClassDescriptor;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QueryEvaluatorMdslImpl()
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
    return MadConfigDslPackage.Literals.QUERY_EVALUATOR_MDSL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_EVALUATOR_MDSL__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_EVALUATOR_MDSL__LABEL, oldLabel, label));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDescriptorMdsl getClassDescriptor()
  {
    return classDescriptor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassDescriptor(ClassDescriptorMdsl newClassDescriptor, NotificationChain msgs)
  {
    ClassDescriptorMdsl oldClassDescriptor = classDescriptor;
    classDescriptor = newClassDescriptor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR, oldClassDescriptor, newClassDescriptor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassDescriptor(ClassDescriptorMdsl newClassDescriptor)
  {
    if (newClassDescriptor != classDescriptor)
    {
      NotificationChain msgs = null;
      if (classDescriptor != null)
        msgs = ((InternalEObject)classDescriptor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR, null, msgs);
      if (newClassDescriptor != null)
        msgs = ((InternalEObject)newClassDescriptor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR, null, msgs);
      msgs = basicSetClassDescriptor(newClassDescriptor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR, newClassDescriptor, newClassDescriptor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PropertyTypeMdsl> getQueryPropertiesTypes()
  {
    if (queryPropertiesTypes == null)
    {
      queryPropertiesTypes = new EObjectContainmentEList<PropertyTypeMdsl>(PropertyTypeMdsl.class, this, MadConfigDslPackage.QUERY_EVALUATOR_MDSL__QUERY_PROPERTIES_TYPES);
    }
    return queryPropertiesTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDescriptorMdsl getExtQServiceClassDescriptor()
  {
    return extQServiceClassDescriptor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtQServiceClassDescriptor(ClassDescriptorMdsl newExtQServiceClassDescriptor, NotificationChain msgs)
  {
    ClassDescriptorMdsl oldExtQServiceClassDescriptor = extQServiceClassDescriptor;
    extQServiceClassDescriptor = newExtQServiceClassDescriptor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR, oldExtQServiceClassDescriptor, newExtQServiceClassDescriptor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtQServiceClassDescriptor(ClassDescriptorMdsl newExtQServiceClassDescriptor)
  {
    if (newExtQServiceClassDescriptor != extQServiceClassDescriptor)
    {
      NotificationChain msgs = null;
      if (extQServiceClassDescriptor != null)
        msgs = ((InternalEObject)extQServiceClassDescriptor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR, null, msgs);
      if (newExtQServiceClassDescriptor != null)
        msgs = ((InternalEObject)newExtQServiceClassDescriptor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR, null, msgs);
      msgs = basicSetExtQServiceClassDescriptor(newExtQServiceClassDescriptor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR, newExtQServiceClassDescriptor, newExtQServiceClassDescriptor));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_EVALUATOR_MDSL__DESCRIPTION, oldDescription, description));
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
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR:
        return basicSetClassDescriptor(null, msgs);
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__QUERY_PROPERTIES_TYPES:
        return ((InternalEList<?>)getQueryPropertiesTypes()).basicRemove(otherEnd, msgs);
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR:
        return basicSetExtQServiceClassDescriptor(null, msgs);
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
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__NAME:
        return getName();
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__LABEL:
        return getLabel();
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR:
        return getClassDescriptor();
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__QUERY_PROPERTIES_TYPES:
        return getQueryPropertiesTypes();
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR:
        return getExtQServiceClassDescriptor();
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__DESCRIPTION:
        return getDescription();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__NAME:
        setName((String)newValue);
        return;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__LABEL:
        setLabel((String)newValue);
        return;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR:
        setClassDescriptor((ClassDescriptorMdsl)newValue);
        return;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__QUERY_PROPERTIES_TYPES:
        getQueryPropertiesTypes().clear();
        getQueryPropertiesTypes().addAll((Collection<? extends PropertyTypeMdsl>)newValue);
        return;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR:
        setExtQServiceClassDescriptor((ClassDescriptorMdsl)newValue);
        return;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__DESCRIPTION:
        setDescription((String)newValue);
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
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__LABEL:
        setLabel(LABEL_EDEFAULT);
        return;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR:
        setClassDescriptor((ClassDescriptorMdsl)null);
        return;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__QUERY_PROPERTIES_TYPES:
        getQueryPropertiesTypes().clear();
        return;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR:
        setExtQServiceClassDescriptor((ClassDescriptorMdsl)null);
        return;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
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
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__LABEL:
        return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__CLASS_DESCRIPTOR:
        return classDescriptor != null;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__QUERY_PROPERTIES_TYPES:
        return queryPropertiesTypes != null && !queryPropertiesTypes.isEmpty();
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__EXT_QSERVICE_CLASS_DESCRIPTOR:
        return extQServiceClassDescriptor != null;
      case MadConfigDslPackage.QUERY_EVALUATOR_MDSL__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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

} //QueryEvaluatorMdslImpl
