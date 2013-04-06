/**
 * <copyright>
 * </copyright>
 *
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.FormatExpr;
import com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.QueryMdsl;
import com.sysord.mad.configuration.madConfigDsl.UICommandMdsl;

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
 * An implementation of the model object '<em><b>Command Definition Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl#isI18NLabel <em>I18N Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl#getAction <em>Action</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl#getOnActionSuccessUICommands <em>On Action Success UI Commands</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.CommandDefinitionMdslImpl#getOnActionErrorUICommands <em>On Action Error UI Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandDefinitionMdslImpl extends CommandMdslImpl implements CommandDefinitionMdsl
{
  /**
   * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected static final COMMAND_CATEGORY_MDSL CATEGORY_EDEFAULT = COMMAND_CATEGORY_MDSL.UPDATE_COMMAND;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected COMMAND_CATEGORY_MDSL category = CATEGORY_EDEFAULT;

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
   * The cached value of the '{@link #getLabel() <em>Label</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected FormatExpr label;

  /**
   * The cached value of the '{@link #getIcon() <em>Icon</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIcon()
   * @generated
   * @ordered
   */
  protected IconDescriptorMdsl icon;

  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected QueryMdsl action;

  /**
   * The cached value of the '{@link #getOnActionSuccessUICommands() <em>On Action Success UI Commands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOnActionSuccessUICommands()
   * @generated
   * @ordered
   */
  protected EList<UICommandMdsl> onActionSuccessUICommands;

  /**
   * The cached value of the '{@link #getOnActionErrorUICommands() <em>On Action Error UI Commands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOnActionErrorUICommands()
   * @generated
   * @ordered
   */
  protected EList<UICommandMdsl> onActionErrorUICommands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommandDefinitionMdslImpl()
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
    return MadConfigDslPackage.Literals.COMMAND_DEFINITION_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public COMMAND_CATEGORY_MDSL getCategory()
  {
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCategory(COMMAND_CATEGORY_MDSL newCategory)
  {
    COMMAND_CATEGORY_MDSL oldCategory = category;
    category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_DEFINITION_MDSL__CATEGORY, oldCategory, category));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_DEFINITION_MDSL__I18_NLABEL, oldI18NLabel, i18NLabel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormatExpr getLabel()
  {
    return label;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLabel(FormatExpr newLabel, NotificationChain msgs)
  {
    FormatExpr oldLabel = label;
    label = newLabel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_DEFINITION_MDSL__LABEL, oldLabel, newLabel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabel(FormatExpr newLabel)
  {
    if (newLabel != label)
    {
      NotificationChain msgs = null;
      if (label != null)
        msgs = ((InternalEObject)label).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.COMMAND_DEFINITION_MDSL__LABEL, null, msgs);
      if (newLabel != null)
        msgs = ((InternalEObject)newLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.COMMAND_DEFINITION_MDSL__LABEL, null, msgs);
      msgs = basicSetLabel(newLabel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_DEFINITION_MDSL__LABEL, newLabel, newLabel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IconDescriptorMdsl getIcon()
  {
    if (icon != null && icon.eIsProxy())
    {
      InternalEObject oldIcon = (InternalEObject)icon;
      icon = (IconDescriptorMdsl)eResolveProxy(oldIcon);
      if (icon != oldIcon)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ICON, oldIcon, icon));
      }
    }
    return icon;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IconDescriptorMdsl basicGetIcon()
  {
    return icon;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIcon(IconDescriptorMdsl newIcon)
  {
    IconDescriptorMdsl oldIcon = icon;
    icon = newIcon;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ICON, oldIcon, icon));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryMdsl getAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAction(QueryMdsl newAction, NotificationChain msgs)
  {
    QueryMdsl oldAction = action;
    action = newAction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ACTION, oldAction, newAction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAction(QueryMdsl newAction)
  {
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ACTION, null, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ACTION, null, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ACTION, newAction, newAction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UICommandMdsl> getOnActionSuccessUICommands()
  {
    if (onActionSuccessUICommands == null)
    {
      onActionSuccessUICommands = new EObjectContainmentEList<UICommandMdsl>(UICommandMdsl.class, this, MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_SUCCESS_UI_COMMANDS);
    }
    return onActionSuccessUICommands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UICommandMdsl> getOnActionErrorUICommands()
  {
    if (onActionErrorUICommands == null)
    {
      onActionErrorUICommands = new EObjectContainmentEList<UICommandMdsl>(UICommandMdsl.class, this, MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_ERROR_UI_COMMANDS);
    }
    return onActionErrorUICommands;
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
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__LABEL:
        return basicSetLabel(null, msgs);
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ACTION:
        return basicSetAction(null, msgs);
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_SUCCESS_UI_COMMANDS:
        return ((InternalEList<?>)getOnActionSuccessUICommands()).basicRemove(otherEnd, msgs);
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_ERROR_UI_COMMANDS:
        return ((InternalEList<?>)getOnActionErrorUICommands()).basicRemove(otherEnd, msgs);
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
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__CATEGORY:
        return getCategory();
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__I18_NLABEL:
        return isI18NLabel();
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__LABEL:
        return getLabel();
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ICON:
        if (resolve) return getIcon();
        return basicGetIcon();
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ACTION:
        return getAction();
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_SUCCESS_UI_COMMANDS:
        return getOnActionSuccessUICommands();
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_ERROR_UI_COMMANDS:
        return getOnActionErrorUICommands();
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
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__CATEGORY:
        setCategory((COMMAND_CATEGORY_MDSL)newValue);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__I18_NLABEL:
        setI18NLabel((Boolean)newValue);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__LABEL:
        setLabel((FormatExpr)newValue);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ICON:
        setIcon((IconDescriptorMdsl)newValue);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ACTION:
        setAction((QueryMdsl)newValue);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_SUCCESS_UI_COMMANDS:
        getOnActionSuccessUICommands().clear();
        getOnActionSuccessUICommands().addAll((Collection<? extends UICommandMdsl>)newValue);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_ERROR_UI_COMMANDS:
        getOnActionErrorUICommands().clear();
        getOnActionErrorUICommands().addAll((Collection<? extends UICommandMdsl>)newValue);
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
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__CATEGORY:
        setCategory(CATEGORY_EDEFAULT);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__I18_NLABEL:
        setI18NLabel(I18_NLABEL_EDEFAULT);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__LABEL:
        setLabel((FormatExpr)null);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ICON:
        setIcon((IconDescriptorMdsl)null);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ACTION:
        setAction((QueryMdsl)null);
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_SUCCESS_UI_COMMANDS:
        getOnActionSuccessUICommands().clear();
        return;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_ERROR_UI_COMMANDS:
        getOnActionErrorUICommands().clear();
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
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__CATEGORY:
        return category != CATEGORY_EDEFAULT;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__I18_NLABEL:
        return i18NLabel != I18_NLABEL_EDEFAULT;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__LABEL:
        return label != null;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ICON:
        return icon != null;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ACTION:
        return action != null;
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_SUCCESS_UI_COMMANDS:
        return onActionSuccessUICommands != null && !onActionSuccessUICommands.isEmpty();
      case MadConfigDslPackage.COMMAND_DEFINITION_MDSL__ON_ACTION_ERROR_UI_COMMANDS:
        return onActionErrorUICommands != null && !onActionErrorUICommands.isEmpty();
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
    result.append(", i18NLabel: ");
    result.append(i18NLabel);
    result.append(')');
    return result.toString();
  }

} //CommandDefinitionMdslImpl
