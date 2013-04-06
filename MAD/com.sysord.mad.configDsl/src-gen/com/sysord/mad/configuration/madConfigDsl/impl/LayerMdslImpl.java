/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.FormatExpr;
import com.sysord.mad.configuration.madConfigDsl.LayerMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;

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
 * An implementation of the model object '<em><b>Layer Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.LayerMdslImpl#isI18NLabel <em>I18N Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.LayerMdslImpl#getLabelFormatExpr <em>Label Format Expr</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.LayerMdslImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.LayerMdslImpl#getSubLayers <em>Sub Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayerMdslImpl extends MADConfigElementImpl implements LayerMdsl
{
  /**
   * The default value of the '{@link #isI18NLabel() <em>I18N Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NLabel()
   * @generated
   * @ordered
   */
  protected static final boolean I18_NLABEL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isI18NLabel() <em>I18N Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NLabel()
   * @generated
   * @ordered
   */
  protected boolean i18NLabel = I18_NLABEL_EDEFAULT;

  /**
   * The cached value of the '{@link #getLabelFormatExpr() <em>Label Format Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabelFormatExpr()
   * @generated
   * @ordered
   */
  protected FormatExpr labelFormatExpr;

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
   * The cached value of the '{@link #getSubLayers() <em>Sub Layers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubLayers()
   * @generated
   * @ordered
   */
  protected EList<LayerMdsl> subLayers;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LayerMdslImpl()
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
    return MadConfigDslPackage.Literals.LAYER_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isI18NLabel()
  {
    return i18NLabel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setI18NLabel(boolean newI18NLabel)
  {
    boolean oldI18NLabel = i18NLabel;
    i18NLabel = newI18NLabel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.LAYER_MDSL__I18_NLABEL, oldI18NLabel, i18NLabel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormatExpr getLabelFormatExpr()
  {
    return labelFormatExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLabelFormatExpr(FormatExpr newLabelFormatExpr, NotificationChain msgs)
  {
    FormatExpr oldLabelFormatExpr = labelFormatExpr;
    labelFormatExpr = newLabelFormatExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.LAYER_MDSL__LABEL_FORMAT_EXPR, oldLabelFormatExpr, newLabelFormatExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabelFormatExpr(FormatExpr newLabelFormatExpr)
  {
    if (newLabelFormatExpr != labelFormatExpr)
    {
      NotificationChain msgs = null;
      if (labelFormatExpr != null)
        msgs = ((InternalEObject)labelFormatExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.LAYER_MDSL__LABEL_FORMAT_EXPR, null, msgs);
      if (newLabelFormatExpr != null)
        msgs = ((InternalEObject)newLabelFormatExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.LAYER_MDSL__LABEL_FORMAT_EXPR, null, msgs);
      msgs = basicSetLabelFormatExpr(newLabelFormatExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.LAYER_MDSL__LABEL_FORMAT_EXPR, newLabelFormatExpr, newLabelFormatExpr));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.LAYER_MDSL__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LayerMdsl> getSubLayers()
  {
    if (subLayers == null)
    {
      subLayers = new EObjectContainmentEList<LayerMdsl>(LayerMdsl.class, this, MadConfigDslPackage.LAYER_MDSL__SUB_LAYERS);
    }
    return subLayers;
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
      case MadConfigDslPackage.LAYER_MDSL__LABEL_FORMAT_EXPR:
        return basicSetLabelFormatExpr(null, msgs);
      case MadConfigDslPackage.LAYER_MDSL__SUB_LAYERS:
        return ((InternalEList<?>)getSubLayers()).basicRemove(otherEnd, msgs);
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
      case MadConfigDslPackage.LAYER_MDSL__I18_NLABEL:
        return isI18NLabel();
      case MadConfigDslPackage.LAYER_MDSL__LABEL_FORMAT_EXPR:
        return getLabelFormatExpr();
      case MadConfigDslPackage.LAYER_MDSL__DESCRIPTION:
        return getDescription();
      case MadConfigDslPackage.LAYER_MDSL__SUB_LAYERS:
        return getSubLayers();
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
      case MadConfigDslPackage.LAYER_MDSL__I18_NLABEL:
        setI18NLabel((Boolean)newValue);
        return;
      case MadConfigDslPackage.LAYER_MDSL__LABEL_FORMAT_EXPR:
        setLabelFormatExpr((FormatExpr)newValue);
        return;
      case MadConfigDslPackage.LAYER_MDSL__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case MadConfigDslPackage.LAYER_MDSL__SUB_LAYERS:
        getSubLayers().clear();
        getSubLayers().addAll((Collection<? extends LayerMdsl>)newValue);
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
      case MadConfigDslPackage.LAYER_MDSL__I18_NLABEL:
        setI18NLabel(I18_NLABEL_EDEFAULT);
        return;
      case MadConfigDslPackage.LAYER_MDSL__LABEL_FORMAT_EXPR:
        setLabelFormatExpr((FormatExpr)null);
        return;
      case MadConfigDslPackage.LAYER_MDSL__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case MadConfigDslPackage.LAYER_MDSL__SUB_LAYERS:
        getSubLayers().clear();
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
      case MadConfigDslPackage.LAYER_MDSL__I18_NLABEL:
        return i18NLabel != I18_NLABEL_EDEFAULT;
      case MadConfigDslPackage.LAYER_MDSL__LABEL_FORMAT_EXPR:
        return labelFormatExpr != null;
      case MadConfigDslPackage.LAYER_MDSL__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case MadConfigDslPackage.LAYER_MDSL__SUB_LAYERS:
        return subLayers != null && !subLayers.isEmpty();
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
    result.append(" (i18NLabel: ");
    result.append(i18NLabel);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} //LayerMdslImpl
