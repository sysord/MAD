/**
 */
package com.sysord.mad.configuration.madConfigDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Based Value Converter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter#getConverterQuery <em>Converter Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryBasedValueConverter()
 * @model
 * @generated
 */
public interface QueryBasedValueConverter extends ValueConverter
{
  /**
   * Returns the value of the '<em><b>Converter Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Converter Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Converter Query</em>' containment reference.
   * @see #setConverterQuery(QueryUsage)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryBasedValueConverter_ConverterQuery()
   * @model containment="true"
   * @generated
   */
  QueryUsage getConverterQuery();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter#getConverterQuery <em>Converter Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Converter Query</em>' containment reference.
   * @see #getConverterQuery()
   * @generated
   */
  void setConverterQuery(QueryUsage value);

} // QueryBasedValueConverter
