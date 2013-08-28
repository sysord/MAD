/**
 */
package com.sysord.mad.configuration.madConfigDsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>VALUE CONVERTER CATEGORY MDSL</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getVALUE_CONVERTER_CATEGORY_MDSL()
 * @model
 * @generated
 */
public enum VALUE_CONVERTER_CATEGORY_MDSL implements Enumerator
{
  /**
   * The '<em><b>DATE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DATE_VALUE
   * @generated
   * @ordered
   */
  DATE(0, "DATE", "DATE"),

  /**
   * The '<em><b>DATETIME</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DATETIME_VALUE
   * @generated
   * @ordered
   */
  DATETIME(1, "DATETIME", "DATETIME"),

  /**
   * The '<em><b>INTEGER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INTEGER_VALUE
   * @generated
   * @ordered
   */
  INTEGER(2, "INTEGER", "INTEGER"),

  /**
   * The '<em><b>FLOAT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLOAT_VALUE
   * @generated
   * @ordered
   */
  FLOAT(3, "FLOAT", "FLOAT"),

  /**
   * The '<em><b>DOUBLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DOUBLE_VALUE
   * @generated
   * @ordered
   */
  DOUBLE(4, "DOUBLE", "DOUBLE"),

  /**
   * The '<em><b>XTEXT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #XTEXT_VALUE
   * @generated
   * @ordered
   */
  XTEXT(5, "XTEXT", "XTEXT");

  /**
   * The '<em><b>DATE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DATE
   * @model
   * @generated
   * @ordered
   */
  public static final int DATE_VALUE = 0;

  /**
   * The '<em><b>DATETIME</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DATETIME</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DATETIME
   * @model
   * @generated
   * @ordered
   */
  public static final int DATETIME_VALUE = 1;

  /**
   * The '<em><b>INTEGER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INTEGER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INTEGER
   * @model
   * @generated
   * @ordered
   */
  public static final int INTEGER_VALUE = 2;

  /**
   * The '<em><b>FLOAT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FLOAT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FLOAT
   * @model
   * @generated
   * @ordered
   */
  public static final int FLOAT_VALUE = 3;

  /**
   * The '<em><b>DOUBLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DOUBLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DOUBLE
   * @model
   * @generated
   * @ordered
   */
  public static final int DOUBLE_VALUE = 4;

  /**
   * The '<em><b>XTEXT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>XTEXT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #XTEXT
   * @model
   * @generated
   * @ordered
   */
  public static final int XTEXT_VALUE = 5;

  /**
   * An array of all the '<em><b>VALUE CONVERTER CATEGORY MDSL</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final VALUE_CONVERTER_CATEGORY_MDSL[] VALUES_ARRAY =
    new VALUE_CONVERTER_CATEGORY_MDSL[]
    {
      DATE,
      DATETIME,
      INTEGER,
      FLOAT,
      DOUBLE,
      XTEXT,
    };

  /**
   * A public read-only list of all the '<em><b>VALUE CONVERTER CATEGORY MDSL</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<VALUE_CONVERTER_CATEGORY_MDSL> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>VALUE CONVERTER CATEGORY MDSL</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VALUE_CONVERTER_CATEGORY_MDSL get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      VALUE_CONVERTER_CATEGORY_MDSL result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>VALUE CONVERTER CATEGORY MDSL</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VALUE_CONVERTER_CATEGORY_MDSL getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      VALUE_CONVERTER_CATEGORY_MDSL result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>VALUE CONVERTER CATEGORY MDSL</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VALUE_CONVERTER_CATEGORY_MDSL get(int value)
  {
    switch (value)
    {
      case DATE_VALUE: return DATE;
      case DATETIME_VALUE: return DATETIME;
      case INTEGER_VALUE: return INTEGER;
      case FLOAT_VALUE: return FLOAT;
      case DOUBLE_VALUE: return DOUBLE;
      case XTEXT_VALUE: return XTEXT;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private VALUE_CONVERTER_CATEGORY_MDSL(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
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
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //VALUE_CONVERTER_CATEGORY_MDSL
