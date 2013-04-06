/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Definition Mdsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getEvaluator <em>Evaluator</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getForeignModel <em>Foreign Model</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getContextLocator <em>Context Locator</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getQuery <em>Query</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getExternalQueryCall <em>External Query Call</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getOptimisationLevel <em>Optimisation Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryDefinitionMdsl()
 * @model
 * @generated
 */
public interface QueryDefinitionMdsl extends QueryMdsl
{
  /**
   * Returns the value of the '<em><b>Evaluator</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Evaluator</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Evaluator</em>' reference.
   * @see #setEvaluator(QueryEvaluatorMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryDefinitionMdsl_Evaluator()
   * @model
   * @generated
   */
  QueryEvaluatorMdsl getEvaluator();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getEvaluator <em>Evaluator</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Evaluator</em>' reference.
   * @see #getEvaluator()
   * @generated
   */
  void setEvaluator(QueryEvaluatorMdsl value);

  /**
   * Returns the value of the '<em><b>Foreign Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Foreign Model</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foreign Model</em>' reference.
   * @see #setForeignModel(ForeignModelMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryDefinitionMdsl_ForeignModel()
   * @model
   * @generated
   */
  ForeignModelMdsl getForeignModel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getForeignModel <em>Foreign Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Foreign Model</em>' reference.
   * @see #getForeignModel()
   * @generated
   */
  void setForeignModel(ForeignModelMdsl value);

  /**
   * Returns the value of the '<em><b>Context Locator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context Locator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context Locator</em>' attribute.
   * @see #setContextLocator(String)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryDefinitionMdsl_ContextLocator()
   * @model
   * @generated
   */
  String getContextLocator();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getContextLocator <em>Context Locator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context Locator</em>' attribute.
   * @see #getContextLocator()
   * @generated
   */
  void setContextLocator(String value);

  /**
   * Returns the value of the '<em><b>Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Query</em>' containment reference.
   * @see #setQuery(QueryBody)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryDefinitionMdsl_Query()
   * @model containment="true"
   * @generated
   */
  QueryBody getQuery();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getQuery <em>Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Query</em>' containment reference.
   * @see #getQuery()
   * @generated
   */
  void setQuery(QueryBody value);

  /**
   * Returns the value of the '<em><b>External Query Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External Query Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External Query Call</em>' containment reference.
   * @see #setExternalQueryCall(ExternalQueryCallMdsl)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryDefinitionMdsl_ExternalQueryCall()
   * @model containment="true"
   * @generated
   */
  ExternalQueryCallMdsl getExternalQueryCall();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getExternalQueryCall <em>External Query Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>External Query Call</em>' containment reference.
   * @see #getExternalQueryCall()
   * @generated
   */
  void setExternalQueryCall(ExternalQueryCallMdsl value);

  /**
   * Returns the value of the '<em><b>Return Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Type</em>' reference.
   * @see #setReturnType(EClassifier)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryDefinitionMdsl_ReturnType()
   * @model
   * @generated
   */
  EClassifier getReturnType();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getReturnType <em>Return Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Type</em>' reference.
   * @see #getReturnType()
   * @generated
   */
  void setReturnType(EClassifier value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link com.sysord.mad.configuration.madConfigDsl.PropertyMdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryDefinitionMdsl_Properties()
   * @model containment="true"
   * @generated
   */
  EList<PropertyMdsl> getProperties();

  /**
   * Returns the value of the '<em><b>Optimisation Level</b></em>' attribute.
   * The literals are from the enumeration {@link com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Optimisation Level</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Optimisation Level</em>' attribute.
   * @see com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL
   * @see #setOptimisationLevel(QUERY_OPTIMISATION_LEVEL)
   * @see com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage#getQueryDefinitionMdsl_OptimisationLevel()
   * @model
   * @generated
   */
  QUERY_OPTIMISATION_LEVEL getOptimisationLevel();

  /**
   * Sets the value of the '{@link com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl#getOptimisationLevel <em>Optimisation Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Optimisation Level</em>' attribute.
   * @see com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL
   * @see #getOptimisationLevel()
   * @generated
   */
  void setOptimisationLevel(QUERY_OPTIMISATION_LEVEL value);

} // QueryDefinitionMdsl
