/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.CommandDeclaration;
import com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl;
import com.sysord.mad.configuration.madConfigDsl.FormatExpr;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command Ref Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandRefMdslImpl#getReferenced <em>Referenced</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandRefMdslImpl#isI18NLabelOverride <em>I18N Label Override</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandRefMdslImpl#getLabelOverride <em>Label Override</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandRefMdslImpl extends CommandMdslImpl implements CommandRefMdsl
{
  /**
   * The cached value of the '{@link #getReferenced() <em>Referenced</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenced()
   * @generated
   * @ordered
   */
  protected CommandDeclaration referenced;

  /**
   * The default value of the '{@link #isI18NLabelOverride() <em>I18N Label Override</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NLabelOverride()
   * @generated
   * @ordered
   */
  protected static final boolean I18_NLABEL_OVERRIDE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isI18NLabelOverride() <em>I18N Label Override</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NLabelOverride()
   * @generated
   * @ordered
   */
  protected boolean i18NLabelOverride = I18_NLABEL_OVERRIDE_EDEFAULT;

  /**
   * The cached value of the '{@link #getLabelOverride() <em>Label Override</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabelOverride()
   * @generated
   * @ordered
   */
  protected FormatExpr labelOverride;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommandRefMdslImpl()
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
    return MadConfigDslPackage.Literals.COMMAND_REF_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommandDeclaration getReferenced()
  {
    if (referenced != null && referenced.eIsProxy())
    {
      InternalEObject oldReferenced = (InternalEObject)referenced;
      referenced = (CommandDeclaration)eResolveProxy(oldReferenced);
      if (referenced != oldReferenced)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.COMMAND_REF_MDSL__REFERENCED, oldReferenced, referenced));
      }
    }
    return referenced;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommandDeclaration basicGetReferenced()
  {
    return referenced;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferenced(CommandDeclaration newReferenced)
  {
    CommandDeclaration oldReferenced = referenced;
    referenced = newReferenced;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_REF_MDSL__REFERENCED, oldReferenced, referenced));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isI18NLabelOverride()
  {
    return i18NLabelOverride;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setI18NLabelOverride(boolean newI18NLabelOverride)
  {
    boolean oldI18NLabelOverride = i18NLabelOverride;
    i18NLabelOverride = newI18NLabelOverride;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_REF_MDSL__I18_NLABEL_OVERRIDE, oldI18NLabelOverride, i18NLabelOverride));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormatExpr getLabelOverride()
  {
    return labelOverride;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLabelOverride(FormatExpr newLabelOverride, NotificationChain msgs)
  {
    FormatExpr oldLabelOverride = labelOverride;
    labelOverride = newLabelOverride;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_REF_MDSL__LABEL_OVERRIDE, oldLabelOverride, newLabelOverride);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabelOverride(FormatExpr newLabelOverride)
  {
    if (newLabelOverride != labelOverride)
    {
      NotificationChain msgs = null;
      if (labelOverride != null)
        msgs = ((InternalEObject)labelOverride).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.COMMAND_REF_MDSL__LABEL_OVERRIDE, null, msgs);
      if (newLabelOverride != null)
        msgs = ((InternalEObject)newLabelOverride).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.COMMAND_REF_MDSL__LABEL_OVERRIDE, null, msgs);
      msgs = basicSetLabelOverride(newLabelOverride, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_REF_MDSL__LABEL_OVERRIDE, newLabelOverride, newLabelOverride));
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
      case MadConfigDslPackage.COMMAND_REF_MDSL__LABEL_OVERRIDE:
        return basicSetLabelOverride(null, msgs);
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
      case MadConfigDslPackage.COMMAND_REF_MDSL__REFERENCED:
        if (resolve) return getReferenced();
        return basicGetReferenced();
      case MadConfigDslPackage.COMMAND_REF_MDSL__I18_NLABEL_OVERRIDE:
        return isI18NLabelOverride();
      case MadConfigDslPackage.COMMAND_REF_MDSL__LABEL_OVERRIDE:
        return getLabelOverride();
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
      case MadConfigDslPackage.COMMAND_REF_MDSL__REFERENCED:
        setReferenced((CommandDeclaration)newValue);
        return;
      case MadConfigDslPackage.COMMAND_REF_MDSL__I18_NLABEL_OVERRIDE:
        setI18NLabelOverride((Boolean)newValue);
        return;
      case MadConfigDslPackage.COMMAND_REF_MDSL__LABEL_OVERRIDE:
        setLabelOverride((FormatExpr)newValue);
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
      case MadConfigDslPackage.COMMAND_REF_MDSL__REFERENCED:
        setReferenced((CommandDeclaration)null);
        return;
      case MadConfigDslPackage.COMMAND_REF_MDSL__I18_NLABEL_OVERRIDE:
        setI18NLabelOverride(I18_NLABEL_OVERRIDE_EDEFAULT);
        return;
      case MadConfigDslPackage.COMMAND_REF_MDSL__LABEL_OVERRIDE:
        setLabelOverride((FormatExpr)null);
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
      case MadConfigDslPackage.COMMAND_REF_MDSL__REFERENCED:
        return referenced != null;
      case MadConfigDslPackage.COMMAND_REF_MDSL__I18_NLABEL_OVERRIDE:
        return i18NLabelOverride != I18_NLABEL_OVERRIDE_EDEFAULT;
      case MadConfigDslPackage.COMMAND_REF_MDSL__LABEL_OVERRIDE:
        return labelOverride != null;
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
    result.append(" (i18NLabelOverride: ");
    result.append(i18NLabelOverride);
    result.append(')');
    return result.toString();
  }

} //CommandRefMdslImpl
