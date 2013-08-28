/**
 */
package com.sysord.mad.configuration.madConfigDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Type Value Converter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter#getCategory <em>Category</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getBasicTypeValueConverter()
 * @model
 * @generated
 */
public interface BasicTypeValueConverter extends ValueConverter
{
  /**
   * Returns the value of the '<em><b>Category</b></em>' attribute.
   * The literals are from the enumeration {@link com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' attribute.
   * @see com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL
   * @see #setCategory(VALUE_CONVERTER_CATEGORY_MDSL)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getBasicTypeValueConverter_Category()
   * @model
   * @generated
   */
  VALUE_CONVERTER_CATEGORY_MDSL getCategory();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter#getCategory <em>Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Category</em>' attribute.
   * @see com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL
   * @see #getCategory()
   * @generated
   */
  void setCategory(VALUE_CONVERTER_CATEGORY_MDSL value);

  /**
   * Returns the value of the '<em><b>Configuration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Configuration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Configuration</em>' attribute.
   * @see #setConfiguration(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getBasicTypeValueConverter_Configuration()
   * @model
   * @generated
   */
  String getConfiguration();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter#getConfiguration <em>Configuration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Configuration</em>' attribute.
   * @see #getConfiguration()
   * @generated
   */
  void setConfiguration(String value);

} // BasicTypeValueConverter
