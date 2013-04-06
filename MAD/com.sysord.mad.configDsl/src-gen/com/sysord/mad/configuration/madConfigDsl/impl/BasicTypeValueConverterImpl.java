/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Type Value Converter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.BasicTypeValueConverterImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.BasicTypeValueConverterImpl#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicTypeValueConverterImpl extends ValueConverterImpl implements BasicTypeValueConverter
{
  /**
   * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected static final VALUE_CONVERTER_CATEGORY_MDSL CATEGORY_EDEFAULT = VALUE_CONVERTER_CATEGORY_MDSL.DATE;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected VALUE_CONVERTER_CATEGORY_MDSL category = CATEGORY_EDEFAULT;

  /**
   * The default value of the '{@link #getConfiguration() <em>Configuration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfiguration()
   * @generated
   * @ordered
   */
  protected static final String CONFIGURATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfiguration()
   * @generated
   * @ordered
   */
  protected String configuration = CONFIGURATION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BasicTypeValueConverterImpl()
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
    return MadConfigDslPackage.Literals.BASIC_TYPE_VALUE_CONVERTER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VALUE_CONVERTER_CATEGORY_MDSL getCategory()
  {
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCategory(VALUE_CONVERTER_CATEGORY_MDSL newCategory)
  {
    VALUE_CONVERTER_CATEGORY_MDSL oldCategory = category;
    category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER__CATEGORY, oldCategory, category));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getConfiguration()
  {
    return configuration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConfiguration(String newConfiguration)
  {
    String oldConfiguration = configuration;
    configuration = newConfiguration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER__CONFIGURATION, oldConfiguration, configuration));
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
      case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER__CATEGORY:
        return getCategory();
      case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER__CONFIGURATION:
        return getConfiguration();
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
      case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER__CATEGORY:
        setCategory((VALUE_CONVERTER_CATEGORY_MDSL)newValue);
        return;
      case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER__CONFIGURATION:
        setConfiguration((String)newValue);
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
      case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER__CATEGORY:
        setCategory(CATEGORY_EDEFAULT);
        return;
      case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER__CONFIGURATION:
        setConfiguration(CONFIGURATION_EDEFAULT);
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
      case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER__CATEGORY:
        return category != CATEGORY_EDEFAULT;
      case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER__CONFIGURATION:
        return CONFIGURATION_EDEFAULT == null ? configuration != null : !CONFIGURATION_EDEFAULT.equals(configuration);
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
    result.append(" (category: ");
    result.append(category);
    result.append(", configuration: ");
    result.append(configuration);
    result.append(')');
    return result.toString();
  }

} //BasicTypeValueConverterImpl
