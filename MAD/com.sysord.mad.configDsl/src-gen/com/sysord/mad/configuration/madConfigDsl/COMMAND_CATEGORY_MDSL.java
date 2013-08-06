/**
 */
package com.sysord.mad.configuration.madConfigDsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>COMMAND CATEGORY MDSL</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getCOMMAND_CATEGORY_MDSL()
 * @model
 * @generated
 */
public enum COMMAND_CATEGORY_MDSL implements Enumerator
{
  /**
   * The '<em><b>UPDATE COMMAND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UPDATE_COMMAND_VALUE
   * @generated
   * @ordered
   */
  UPDATE_COMMAND(0, "UPDATE_COMMAND", "UPDATE_COMMAND"),

  /**
   * The '<em><b>GLOBAL COMMAND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GLOBAL_COMMAND_VALUE
   * @generated
   * @ordered
   */
  GLOBAL_COMMAND(1, "GLOBAL_COMMAND", "GLOBAL_COMMAND"),

  /**
   * The '<em><b>ITEM COMMAND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ITEM_COMMAND_VALUE
   * @generated
   * @ordered
   */
  ITEM_COMMAND(2, "ITEM_COMMAND", "ITEM_COMMAND");

  /**
   * The '<em><b>UPDATE COMMAND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UPDATE COMMAND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UPDATE_COMMAND
   * @model
   * @generated
   * @ordered
   */
  public static final int UPDATE_COMMAND_VALUE = 0;

  /**
   * The '<em><b>GLOBAL COMMAND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GLOBAL COMMAND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GLOBAL_COMMAND
   * @model
   * @generated
   * @ordered
   */
  public static final int GLOBAL_COMMAND_VALUE = 1;

  /**
   * The '<em><b>ITEM COMMAND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ITEM COMMAND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ITEM_COMMAND
   * @model
   * @generated
   * @ordered
   */
  public static final int ITEM_COMMAND_VALUE = 2;

  /**
   * An array of all the '<em><b>COMMAND CATEGORY MDSL</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final COMMAND_CATEGORY_MDSL[] VALUES_ARRAY =
    new COMMAND_CATEGORY_MDSL[]
    {
      UPDATE_COMMAND,
      GLOBAL_COMMAND,
      ITEM_COMMAND,
    };

  /**
   * A public read-only list of all the '<em><b>COMMAND CATEGORY MDSL</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<COMMAND_CATEGORY_MDSL> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>COMMAND CATEGORY MDSL</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static COMMAND_CATEGORY_MDSL get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      COMMAND_CATEGORY_MDSL result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>COMMAND CATEGORY MDSL</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static COMMAND_CATEGORY_MDSL getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      COMMAND_CATEGORY_MDSL result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>COMMAND CATEGORY MDSL</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static COMMAND_CATEGORY_MDSL get(int value)
  {
    switch (value)
    {
      case UPDATE_COMMAND_VALUE: return UPDATE_COMMAND;
      case GLOBAL_COMMAND_VALUE: return GLOBAL_COMMAND;
      case ITEM_COMMAND_VALUE: return ITEM_COMMAND;
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
  private COMMAND_CATEGORY_MDSL(int value, String name, String literal)
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
  
} //COMMAND_CATEGORY_MDSL
