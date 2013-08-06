/**
 */
package com.sysord.mad.configuration.madConfigDsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>QUERY OPTIMISATION LEVEL</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQUERY_OPTIMISATION_LEVEL()
 * @model
 * @generated
 */
public enum QUERY_OPTIMISATION_LEVEL implements Enumerator
{
  /**
   * The '<em><b>NONE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NONE_VALUE
   * @generated
   * @ordered
   */
  NONE(0, "NONE", "NONE"),

  /**
   * The '<em><b>VIEW</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VIEW_VALUE
   * @generated
   * @ordered
   */
  VIEW(1, "VIEW", "VIEW"),

  /**
   * The '<em><b>CONTEXT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONTEXT_VALUE
   * @generated
   * @ordered
   */
  CONTEXT(2, "CONTEXT", "CONTEXT");

  /**
   * The '<em><b>NONE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NONE
   * @model
   * @generated
   * @ordered
   */
  public static final int NONE_VALUE = 0;

  /**
   * The '<em><b>VIEW</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VIEW</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #VIEW
   * @model
   * @generated
   * @ordered
   */
  public static final int VIEW_VALUE = 1;

  /**
   * The '<em><b>CONTEXT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONTEXT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONTEXT
   * @model
   * @generated
   * @ordered
   */
  public static final int CONTEXT_VALUE = 2;

  /**
   * An array of all the '<em><b>QUERY OPTIMISATION LEVEL</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final QUERY_OPTIMISATION_LEVEL[] VALUES_ARRAY =
    new QUERY_OPTIMISATION_LEVEL[]
    {
      NONE,
      VIEW,
      CONTEXT,
    };

  /**
   * A public read-only list of all the '<em><b>QUERY OPTIMISATION LEVEL</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<QUERY_OPTIMISATION_LEVEL> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>QUERY OPTIMISATION LEVEL</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static QUERY_OPTIMISATION_LEVEL get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      QUERY_OPTIMISATION_LEVEL result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>QUERY OPTIMISATION LEVEL</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static QUERY_OPTIMISATION_LEVEL getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      QUERY_OPTIMISATION_LEVEL result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>QUERY OPTIMISATION LEVEL</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static QUERY_OPTIMISATION_LEVEL get(int value)
  {
    switch (value)
    {
      case NONE_VALUE: return NONE;
      case VIEW_VALUE: return VIEW;
      case CONTEXT_VALUE: return CONTEXT;
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
  private QUERY_OPTIMISATION_LEVEL(int value, String name, String literal)
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
  
} //QUERY_OPTIMISATION_LEVEL
