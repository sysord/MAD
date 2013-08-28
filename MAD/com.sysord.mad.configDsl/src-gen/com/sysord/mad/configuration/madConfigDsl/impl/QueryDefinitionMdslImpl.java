/**
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl;
import com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.PropertyMdsl;
import com.sysord.mad.configuration.madConfigDsl.QUERY_OPTIMISATION_LEVEL;
import com.sysord.mad.configuration.madConfigDsl.QueryBody;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Definition Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl#getEvaluator <em>Evaluator</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl#getForeignModel <em>Foreign Model</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl#getContextLocator <em>Context Locator</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl#getExternalQueryCall <em>External Query Call</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.QueryDefinitionMdslImpl#getOptimisationLevel <em>Optimisation Level</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryDefinitionMdslImpl extends QueryMdslImpl implements QueryDefinitionMdsl
{
  /**
   * The cached value of the '{@link #getEvaluator() <em>Evaluator</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvaluator()
   * @generated
   * @ordered
   */
  protected QueryEvaluatorMdsl evaluator;

  /**
   * The cached value of the '{@link #getForeignModel() <em>Foreign Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForeignModel()
   * @generated
   * @ordered
   */
  protected ForeignModelMdsl foreignModel;

  /**
   * The default value of the '{@link #getContextLocator() <em>Context Locator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContextLocator()
   * @generated
   * @ordered
   */
  protected static final String CONTEXT_LOCATOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getContextLocator() <em>Context Locator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContextLocator()
   * @generated
   * @ordered
   */
  protected String contextLocator = CONTEXT_LOCATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuery()
   * @generated
   * @ordered
   */
  protected QueryBody query;

  /**
   * The cached value of the '{@link #getExternalQueryCall() <em>External Query Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExternalQueryCall()
   * @generated
   * @ordered
   */
  protected ExternalQueryCallMdsl externalQueryCall;

  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected EClassifier returnType;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<PropertyMdsl> properties;

  /**
   * The default value of the '{@link #getOptimisationLevel() <em>Optimisation Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptimisationLevel()
   * @generated
   * @ordered
   */
  protected static final QUERY_OPTIMISATION_LEVEL OPTIMISATION_LEVEL_EDEFAULT = QUERY_OPTIMISATION_LEVEL.NONE;

  /**
   * The cached value of the '{@link #getOptimisationLevel() <em>Optimisation Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptimisationLevel()
   * @generated
   * @ordered
   */
  protected QUERY_OPTIMISATION_LEVEL optimisationLevel = OPTIMISATION_LEVEL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QueryDefinitionMdslImpl()
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
    return MadConfigDslPackage.Literals.QUERY_DEFINITION_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryEvaluatorMdsl getEvaluator()
  {
    if (evaluator != null && evaluator.eIsProxy())
    {
      InternalEObject oldEvaluator = (InternalEObject)evaluator;
      evaluator = (QueryEvaluatorMdsl)eResolveProxy(oldEvaluator);
      if (evaluator != oldEvaluator)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.QUERY_DEFINITION_MDSL__EVALUATOR, oldEvaluator, evaluator));
      }
    }
    return evaluator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryEvaluatorMdsl basicGetEvaluator()
  {
    return evaluator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvaluator(QueryEvaluatorMdsl newEvaluator)
  {
    QueryEvaluatorMdsl oldEvaluator = evaluator;
    evaluator = newEvaluator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_DEFINITION_MDSL__EVALUATOR, oldEvaluator, evaluator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForeignModelMdsl getForeignModel()
  {
    if (foreignModel != null && foreignModel.eIsProxy())
    {
      InternalEObject oldForeignModel = (InternalEObject)foreignModel;
      foreignModel = (ForeignModelMdsl)eResolveProxy(oldForeignModel);
      if (foreignModel != oldForeignModel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.QUERY_DEFINITION_MDSL__FOREIGN_MODEL, oldForeignModel, foreignModel));
      }
    }
    return foreignModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForeignModelMdsl basicGetForeignModel()
  {
    return foreignModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setForeignModel(ForeignModelMdsl newForeignModel)
  {
    ForeignModelMdsl oldForeignModel = foreignModel;
    foreignModel = newForeignModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_DEFINITION_MDSL__FOREIGN_MODEL, oldForeignModel, foreignModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getContextLocator()
  {
    return contextLocator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContextLocator(String newContextLocator)
  {
    String oldContextLocator = contextLocator;
    contextLocator = newContextLocator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_DEFINITION_MDSL__CONTEXT_LOCATOR, oldContextLocator, contextLocator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryBody getQuery()
  {
    return query;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQuery(QueryBody newQuery, NotificationChain msgs)
  {
    QueryBody oldQuery = query;
    query = newQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_DEFINITION_MDSL__QUERY, oldQuery, newQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuery(QueryBody newQuery)
  {
    if (newQuery != query)
    {
      NotificationChain msgs = null;
      if (query != null)
        msgs = ((InternalEObject)query).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.QUERY_DEFINITION_MDSL__QUERY, null, msgs);
      if (newQuery != null)
        msgs = ((InternalEObject)newQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.QUERY_DEFINITION_MDSL__QUERY, null, msgs);
      msgs = basicSetQuery(newQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_DEFINITION_MDSL__QUERY, newQuery, newQuery));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalQueryCallMdsl getExternalQueryCall()
  {
    return externalQueryCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExternalQueryCall(ExternalQueryCallMdsl newExternalQueryCall, NotificationChain msgs)
  {
    ExternalQueryCallMdsl oldExternalQueryCall = externalQueryCall;
    externalQueryCall = newExternalQueryCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL, oldExternalQueryCall, newExternalQueryCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExternalQueryCall(ExternalQueryCallMdsl newExternalQueryCall)
  {
    if (newExternalQueryCall != externalQueryCall)
    {
      NotificationChain msgs = null;
      if (externalQueryCall != null)
        msgs = ((InternalEObject)externalQueryCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL, null, msgs);
      if (newExternalQueryCall != null)
        msgs = ((InternalEObject)newExternalQueryCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL, null, msgs);
      msgs = basicSetExternalQueryCall(newExternalQueryCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL, newExternalQueryCall, newExternalQueryCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier getReturnType()
  {
    if (returnType != null && returnType.eIsProxy())
    {
      InternalEObject oldReturnType = (InternalEObject)returnType;
      returnType = (EClassifier)eResolveProxy(oldReturnType);
      if (returnType != oldReturnType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.QUERY_DEFINITION_MDSL__RETURN_TYPE, oldReturnType, returnType));
      }
    }
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier basicGetReturnType()
  {
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnType(EClassifier newReturnType)
  {
    EClassifier oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_DEFINITION_MDSL__RETURN_TYPE, oldReturnType, returnType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PropertyMdsl> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<PropertyMdsl>(PropertyMdsl.class, this, MadConfigDslPackage.QUERY_DEFINITION_MDSL__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QUERY_OPTIMISATION_LEVEL getOptimisationLevel()
  {
    return optimisationLevel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOptimisationLevel(QUERY_OPTIMISATION_LEVEL newOptimisationLevel)
  {
    QUERY_OPTIMISATION_LEVEL oldOptimisationLevel = optimisationLevel;
    optimisationLevel = newOptimisationLevel == null ? OPTIMISATION_LEVEL_EDEFAULT : newOptimisationLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.QUERY_DEFINITION_MDSL__OPTIMISATION_LEVEL, oldOptimisationLevel, optimisationLevel));
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
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__QUERY:
        return basicSetQuery(null, msgs);
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL:
        return basicSetExternalQueryCall(null, msgs);
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__EVALUATOR:
        if (resolve) return getEvaluator();
        return basicGetEvaluator();
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__FOREIGN_MODEL:
        if (resolve) return getForeignModel();
        return basicGetForeignModel();
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__CONTEXT_LOCATOR:
        return getContextLocator();
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__QUERY:
        return getQuery();
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL:
        return getExternalQueryCall();
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__RETURN_TYPE:
        if (resolve) return getReturnType();
        return basicGetReturnType();
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__PROPERTIES:
        return getProperties();
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__OPTIMISATION_LEVEL:
        return getOptimisationLevel();
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
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__EVALUATOR:
        setEvaluator((QueryEvaluatorMdsl)newValue);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__FOREIGN_MODEL:
        setForeignModel((ForeignModelMdsl)newValue);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__CONTEXT_LOCATOR:
        setContextLocator((String)newValue);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__QUERY:
        setQuery((QueryBody)newValue);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL:
        setExternalQueryCall((ExternalQueryCallMdsl)newValue);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__RETURN_TYPE:
        setReturnType((EClassifier)newValue);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends PropertyMdsl>)newValue);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__OPTIMISATION_LEVEL:
        setOptimisationLevel((QUERY_OPTIMISATION_LEVEL)newValue);
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
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__EVALUATOR:
        setEvaluator((QueryEvaluatorMdsl)null);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__FOREIGN_MODEL:
        setForeignModel((ForeignModelMdsl)null);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__CONTEXT_LOCATOR:
        setContextLocator(CONTEXT_LOCATOR_EDEFAULT);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__QUERY:
        setQuery((QueryBody)null);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL:
        setExternalQueryCall((ExternalQueryCallMdsl)null);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__RETURN_TYPE:
        setReturnType((EClassifier)null);
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__PROPERTIES:
        getProperties().clear();
        return;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__OPTIMISATION_LEVEL:
        setOptimisationLevel(OPTIMISATION_LEVEL_EDEFAULT);
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
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__EVALUATOR:
        return evaluator != null;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__FOREIGN_MODEL:
        return foreignModel != null;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__CONTEXT_LOCATOR:
        return CONTEXT_LOCATOR_EDEFAULT == null ? contextLocator != null : !CONTEXT_LOCATOR_EDEFAULT.equals(contextLocator);
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__QUERY:
        return query != null;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__EXTERNAL_QUERY_CALL:
        return externalQueryCall != null;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__RETURN_TYPE:
        return returnType != null;
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case MadConfigDslPackage.QUERY_DEFINITION_MDSL__OPTIMISATION_LEVEL:
        return optimisationLevel != OPTIMISATION_LEVEL_EDEFAULT;
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
    result.append(" (contextLocator: ");
    result.append(contextLocator);
    result.append(", optimisationLevel: ");
    result.append(optimisationLevel);
    result.append(')');
    return result.toString();
  }

} //QueryDefinitionMdslImpl
