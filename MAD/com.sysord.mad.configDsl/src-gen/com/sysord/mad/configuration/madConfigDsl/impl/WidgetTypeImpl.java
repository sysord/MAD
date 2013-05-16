/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.WidgetType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetTypeImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetTypeImpl#getClassDescriptor <em>Class Descriptor</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetTypeImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WidgetTypeImpl extends MADConfigElementImpl implements WidgetType
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
   * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected static final WIDGET_CATEGORY_MDSL CATEGORY_EDEFAULT = WIDGET_CATEGORY_MDSL.OUTPUTTEXT_WIDGET;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected WIDGET_CATEGORY_MDSL category = CATEGORY_EDEFAULT;

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
  protected WidgetTypeImpl()
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
    return MadConfigDslPackage.Literals.WIDGET_TYPE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_TYPE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WIDGET_CATEGORY_MDSL getCategory()
  {
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCategory(WIDGET_CATEGORY_MDSL newCategory)
  {
    WIDGET_CATEGORY_MDSL oldCategory = category;
    category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_TYPE__CATEGORY, oldCategory, category));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_TYPE__LABEL, oldLabel, label));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_TYPE__CLASS_DESCRIPTOR, oldClassDescriptor, newClassDescriptor);
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
        msgs = ((InternalEObject)classDescriptor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_TYPE__CLASS_DESCRIPTOR, null, msgs);
      if (newClassDescriptor != null)
        msgs = ((InternalEObject)newClassDescriptor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_TYPE__CLASS_DESCRIPTOR, null, msgs);
      msgs = basicSetClassDescriptor(newClassDescriptor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_TYPE__CLASS_DESCRIPTOR, newClassDescriptor, newClassDescriptor));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_TYPE__DESCRIPTION, oldDescription, description));
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
      case MadConfigDslPackage.WIDGET_TYPE__CLASS_DESCRIPTOR:
        return basicSetClassDescriptor(null, msgs);
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
      case MadConfigDslPackage.WIDGET_TYPE__NAME:
        return getName();
      case MadConfigDslPackage.WIDGET_TYPE__CATEGORY:
        return getCategory();
      case MadConfigDslPackage.WIDGET_TYPE__LABEL:
        return getLabel();
      case MadConfigDslPackage.WIDGET_TYPE__CLASS_DESCRIPTOR:
        return getClassDescriptor();
      case MadConfigDslPackage.WIDGET_TYPE__DESCRIPTION:
        return getDescription();
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
      case MadConfigDslPackage.WIDGET_TYPE__NAME:
        setName((String)newValue);
        return;
      case MadConfigDslPackage.WIDGET_TYPE__CATEGORY:
        setCategory((WIDGET_CATEGORY_MDSL)newValue);
        return;
      case MadConfigDslPackage.WIDGET_TYPE__LABEL:
        setLabel((String)newValue);
        return;
      case MadConfigDslPackage.WIDGET_TYPE__CLASS_DESCRIPTOR:
        setClassDescriptor((ClassDescriptorMdsl)newValue);
        return;
      case MadConfigDslPackage.WIDGET_TYPE__DESCRIPTION:
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
      case MadConfigDslPackage.WIDGET_TYPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MadConfigDslPackage.WIDGET_TYPE__CATEGORY:
        setCategory(CATEGORY_EDEFAULT);
        return;
      case MadConfigDslPackage.WIDGET_TYPE__LABEL:
        setLabel(LABEL_EDEFAULT);
        return;
      case MadConfigDslPackage.WIDGET_TYPE__CLASS_DESCRIPTOR:
        setClassDescriptor((ClassDescriptorMdsl)null);
        return;
      case MadConfigDslPackage.WIDGET_TYPE__DESCRIPTION:
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
      case MadConfigDslPackage.WIDGET_TYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MadConfigDslPackage.WIDGET_TYPE__CATEGORY:
        return category != CATEGORY_EDEFAULT;
      case MadConfigDslPackage.WIDGET_TYPE__LABEL:
        return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
      case MadConfigDslPackage.WIDGET_TYPE__CLASS_DESCRIPTOR:
        return classDescriptor != null;
      case MadConfigDslPackage.WIDGET_TYPE__DESCRIPTION:
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
    result.append(", category: ");
    result.append(category);
    result.append(", label: ");
    result.append(label);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} //WidgetTypeImpl
