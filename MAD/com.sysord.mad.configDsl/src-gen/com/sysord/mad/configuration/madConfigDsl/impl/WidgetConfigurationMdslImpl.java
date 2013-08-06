/**
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.CommandMdsl;
import com.sysord.mad.configuration.madConfigDsl.FormatExpr;
import com.sysord.mad.configuration.madConfigDsl.LayerMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.QueryMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryUsage;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.UITabMdsl;
import com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl;
import com.sysord.mad.configuration.madConfigDsl.ValueConverter;
import com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.WidgetType;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget Configuration Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getUiTab <em>Ui Tab</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getLayers <em>Layers</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#isI18NLabel <em>I18N Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getWidgetCategory <em>Widget Category</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getWidgetType <em>Widget Type</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getDslReference <em>Dsl Reference</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getFlexibleTemplate <em>Flexible Template</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getVisibilityQuery <em>Visibility Query</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getEditableQuery <em>Editable Query</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getValueConverter <em>Value Converter</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getValidators <em>Validators</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#isI18NFormat <em>I18N Format</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getValueFormat <em>Value Format</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getCandidatesQuery <em>Candidates Query</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#isI18NItemLabel <em>I18N Item Label</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getItemLabelExpression <em>Item Label Expression</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.WidgetConfigurationMdslImpl#getCommands <em>Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WidgetConfigurationMdslImpl extends TypeConfigurationTemplateElementImpl implements WidgetConfigurationMdsl
{
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
   * The cached value of the '{@link #getUiTab() <em>Ui Tab</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUiTab()
   * @generated
   * @ordered
   */
  protected UITabMdsl uiTab;

  /**
   * The cached value of the '{@link #getLayers() <em>Layers</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayers()
   * @generated
   * @ordered
   */
  protected EList<LayerMdsl> layers;

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
   * The default value of the '{@link #getWidgetCategory() <em>Widget Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidgetCategory()
   * @generated
   * @ordered
   */
  protected static final WIDGET_CATEGORY_MDSL WIDGET_CATEGORY_EDEFAULT = WIDGET_CATEGORY_MDSL.OUTPUTTEXT_WIDGET;

  /**
   * The cached value of the '{@link #getWidgetCategory() <em>Widget Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidgetCategory()
   * @generated
   * @ordered
   */
  protected WIDGET_CATEGORY_MDSL widgetCategory = WIDGET_CATEGORY_EDEFAULT;

  /**
   * The cached value of the '{@link #getWidgetType() <em>Widget Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidgetType()
   * @generated
   * @ordered
   */
  protected WidgetType widgetType;

  /**
   * The cached value of the '{@link #getDslReference() <em>Dsl Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDslReference()
   * @generated
   * @ordered
   */
  protected XtextLanguageReference dslReference;

  /**
   * The cached value of the '{@link #getFlexibleTemplate() <em>Flexible Template</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFlexibleTemplate()
   * @generated
   * @ordered
   */
  protected TypeConfigurationMdsl flexibleTemplate;

  /**
   * The cached value of the '{@link #getVisibilityQuery() <em>Visibility Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibilityQuery()
   * @generated
   * @ordered
   */
  protected QueryMdsl visibilityQuery;

  /**
   * The cached value of the '{@link #getEditableQuery() <em>Editable Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEditableQuery()
   * @generated
   * @ordered
   */
  protected QueryMdsl editableQuery;

  /**
   * The cached value of the '{@link #getValueConverter() <em>Value Converter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueConverter()
   * @generated
   * @ordered
   */
  protected ValueConverter valueConverter;

  /**
   * The cached value of the '{@link #getValidators() <em>Validators</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidators()
   * @generated
   * @ordered
   */
  protected EList<ValidatorMdsl> validators;

  /**
   * The default value of the '{@link #isI18NFormat() <em>I18N Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NFormat()
   * @generated
   * @ordered
   */
  protected static final boolean I18_NFORMAT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isI18NFormat() <em>I18N Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NFormat()
   * @generated
   * @ordered
   */
  protected boolean i18NFormat = I18_NFORMAT_EDEFAULT;

  /**
   * The cached value of the '{@link #getValueFormat() <em>Value Format</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueFormat()
   * @generated
   * @ordered
   */
  protected FormatExpr valueFormat;

  /**
   * The cached value of the '{@link #getCandidatesQuery() <em>Candidates Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCandidatesQuery()
   * @generated
   * @ordered
   */
  protected QueryUsage candidatesQuery;

  /**
   * The default value of the '{@link #isI18NItemLabel() <em>I18N Item Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NItemLabel()
   * @generated
   * @ordered
   */
  protected static final boolean I18_NITEM_LABEL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isI18NItemLabel() <em>I18N Item Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NItemLabel()
   * @generated
   * @ordered
   */
  protected boolean i18NItemLabel = I18_NITEM_LABEL_EDEFAULT;

  /**
   * The cached value of the '{@link #getItemLabelExpression() <em>Item Label Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getItemLabelExpression()
   * @generated
   * @ordered
   */
  protected FormatExpr itemLabelExpression;

  /**
   * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommands()
   * @generated
   * @ordered
   */
  protected EList<CommandMdsl> commands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WidgetConfigurationMdslImpl()
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
    return MadConfigDslPackage.Literals.WIDGET_CONFIGURATION_MDSL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UITabMdsl getUiTab()
  {
    if (uiTab != null && uiTab.eIsProxy())
    {
      InternalEObject oldUiTab = (InternalEObject)uiTab;
      uiTab = (UITabMdsl)eResolveProxy(oldUiTab);
      if (uiTab != oldUiTab)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__UI_TAB, oldUiTab, uiTab));
      }
    }
    return uiTab;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UITabMdsl basicGetUiTab()
  {
    return uiTab;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUiTab(UITabMdsl newUiTab)
  {
    UITabMdsl oldUiTab = uiTab;
    uiTab = newUiTab;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__UI_TAB, oldUiTab, uiTab));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LayerMdsl> getLayers()
  {
    if (layers == null)
    {
      layers = new EObjectResolvingEList<LayerMdsl>(LayerMdsl.class, this, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LAYERS);
    }
    return layers;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NLABEL, oldI18NLabel, i18NLabel));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LABEL, oldLabel, newLabel);
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
        msgs = ((InternalEObject)label).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LABEL, null, msgs);
      if (newLabel != null)
        msgs = ((InternalEObject)newLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LABEL, null, msgs);
      msgs = basicSetLabel(newLabel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LABEL, newLabel, newLabel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WIDGET_CATEGORY_MDSL getWidgetCategory()
  {
    return widgetCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWidgetCategory(WIDGET_CATEGORY_MDSL newWidgetCategory)
  {
    WIDGET_CATEGORY_MDSL oldWidgetCategory = widgetCategory;
    widgetCategory = newWidgetCategory == null ? WIDGET_CATEGORY_EDEFAULT : newWidgetCategory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_CATEGORY, oldWidgetCategory, widgetCategory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WidgetType getWidgetType()
  {
    if (widgetType != null && widgetType.eIsProxy())
    {
      InternalEObject oldWidgetType = (InternalEObject)widgetType;
      widgetType = (WidgetType)eResolveProxy(oldWidgetType);
      if (widgetType != oldWidgetType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_TYPE, oldWidgetType, widgetType));
      }
    }
    return widgetType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WidgetType basicGetWidgetType()
  {
    return widgetType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWidgetType(WidgetType newWidgetType)
  {
    WidgetType oldWidgetType = widgetType;
    widgetType = newWidgetType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_TYPE, oldWidgetType, widgetType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextLanguageReference getDslReference()
  {
    return dslReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDslReference(XtextLanguageReference newDslReference, NotificationChain msgs)
  {
    XtextLanguageReference oldDslReference = dslReference;
    dslReference = newDslReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE, oldDslReference, newDslReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDslReference(XtextLanguageReference newDslReference)
  {
    if (newDslReference != dslReference)
    {
      NotificationChain msgs = null;
      if (dslReference != null)
        msgs = ((InternalEObject)dslReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE, null, msgs);
      if (newDslReference != null)
        msgs = ((InternalEObject)newDslReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE, null, msgs);
      msgs = basicSetDslReference(newDslReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE, newDslReference, newDslReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeConfigurationMdsl getFlexibleTemplate()
  {
    if (flexibleTemplate != null && flexibleTemplate.eIsProxy())
    {
      InternalEObject oldFlexibleTemplate = (InternalEObject)flexibleTemplate;
      flexibleTemplate = (TypeConfigurationMdsl)eResolveProxy(oldFlexibleTemplate);
      if (flexibleTemplate != oldFlexibleTemplate)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__FLEXIBLE_TEMPLATE, oldFlexibleTemplate, flexibleTemplate));
      }
    }
    return flexibleTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeConfigurationMdsl basicGetFlexibleTemplate()
  {
    return flexibleTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFlexibleTemplate(TypeConfigurationMdsl newFlexibleTemplate)
  {
    TypeConfigurationMdsl oldFlexibleTemplate = flexibleTemplate;
    flexibleTemplate = newFlexibleTemplate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__FLEXIBLE_TEMPLATE, oldFlexibleTemplate, flexibleTemplate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryMdsl getVisibilityQuery()
  {
    return visibilityQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVisibilityQuery(QueryMdsl newVisibilityQuery, NotificationChain msgs)
  {
    QueryMdsl oldVisibilityQuery = visibilityQuery;
    visibilityQuery = newVisibilityQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY, oldVisibilityQuery, newVisibilityQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibilityQuery(QueryMdsl newVisibilityQuery)
  {
    if (newVisibilityQuery != visibilityQuery)
    {
      NotificationChain msgs = null;
      if (visibilityQuery != null)
        msgs = ((InternalEObject)visibilityQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY, null, msgs);
      if (newVisibilityQuery != null)
        msgs = ((InternalEObject)newVisibilityQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY, null, msgs);
      msgs = basicSetVisibilityQuery(newVisibilityQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY, newVisibilityQuery, newVisibilityQuery));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryMdsl getEditableQuery()
  {
    return editableQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEditableQuery(QueryMdsl newEditableQuery, NotificationChain msgs)
  {
    QueryMdsl oldEditableQuery = editableQuery;
    editableQuery = newEditableQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY, oldEditableQuery, newEditableQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEditableQuery(QueryMdsl newEditableQuery)
  {
    if (newEditableQuery != editableQuery)
    {
      NotificationChain msgs = null;
      if (editableQuery != null)
        msgs = ((InternalEObject)editableQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY, null, msgs);
      if (newEditableQuery != null)
        msgs = ((InternalEObject)newEditableQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY, null, msgs);
      msgs = basicSetEditableQuery(newEditableQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY, newEditableQuery, newEditableQuery));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueConverter getValueConverter()
  {
    return valueConverter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueConverter(ValueConverter newValueConverter, NotificationChain msgs)
  {
    ValueConverter oldValueConverter = valueConverter;
    valueConverter = newValueConverter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER, oldValueConverter, newValueConverter);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueConverter(ValueConverter newValueConverter)
  {
    if (newValueConverter != valueConverter)
    {
      NotificationChain msgs = null;
      if (valueConverter != null)
        msgs = ((InternalEObject)valueConverter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER, null, msgs);
      if (newValueConverter != null)
        msgs = ((InternalEObject)newValueConverter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER, null, msgs);
      msgs = basicSetValueConverter(newValueConverter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER, newValueConverter, newValueConverter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValidatorMdsl> getValidators()
  {
    if (validators == null)
    {
      validators = new EObjectContainmentEList<ValidatorMdsl>(ValidatorMdsl.class, this, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALIDATORS);
    }
    return validators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isI18NFormat()
  {
    return i18NFormat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setI18NFormat(boolean newI18NFormat)
  {
    boolean oldI18NFormat = i18NFormat;
    i18NFormat = newI18NFormat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NFORMAT, oldI18NFormat, i18NFormat));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormatExpr getValueFormat()
  {
    return valueFormat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueFormat(FormatExpr newValueFormat, NotificationChain msgs)
  {
    FormatExpr oldValueFormat = valueFormat;
    valueFormat = newValueFormat;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT, oldValueFormat, newValueFormat);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueFormat(FormatExpr newValueFormat)
  {
    if (newValueFormat != valueFormat)
    {
      NotificationChain msgs = null;
      if (valueFormat != null)
        msgs = ((InternalEObject)valueFormat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT, null, msgs);
      if (newValueFormat != null)
        msgs = ((InternalEObject)newValueFormat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT, null, msgs);
      msgs = basicSetValueFormat(newValueFormat, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT, newValueFormat, newValueFormat));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryUsage getCandidatesQuery()
  {
    return candidatesQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCandidatesQuery(QueryUsage newCandidatesQuery, NotificationChain msgs)
  {
    QueryUsage oldCandidatesQuery = candidatesQuery;
    candidatesQuery = newCandidatesQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY, oldCandidatesQuery, newCandidatesQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCandidatesQuery(QueryUsage newCandidatesQuery)
  {
    if (newCandidatesQuery != candidatesQuery)
    {
      NotificationChain msgs = null;
      if (candidatesQuery != null)
        msgs = ((InternalEObject)candidatesQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY, null, msgs);
      if (newCandidatesQuery != null)
        msgs = ((InternalEObject)newCandidatesQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY, null, msgs);
      msgs = basicSetCandidatesQuery(newCandidatesQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY, newCandidatesQuery, newCandidatesQuery));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isI18NItemLabel()
  {
    return i18NItemLabel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setI18NItemLabel(boolean newI18NItemLabel)
  {
    boolean oldI18NItemLabel = i18NItemLabel;
    i18NItemLabel = newI18NItemLabel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NITEM_LABEL, oldI18NItemLabel, i18NItemLabel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormatExpr getItemLabelExpression()
  {
    return itemLabelExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetItemLabelExpression(FormatExpr newItemLabelExpression, NotificationChain msgs)
  {
    FormatExpr oldItemLabelExpression = itemLabelExpression;
    itemLabelExpression = newItemLabelExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION, oldItemLabelExpression, newItemLabelExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setItemLabelExpression(FormatExpr newItemLabelExpression)
  {
    if (newItemLabelExpression != itemLabelExpression)
    {
      NotificationChain msgs = null;
      if (itemLabelExpression != null)
        msgs = ((InternalEObject)itemLabelExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION, null, msgs);
      if (newItemLabelExpression != null)
        msgs = ((InternalEObject)newItemLabelExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION, null, msgs);
      msgs = basicSetItemLabelExpression(newItemLabelExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION, newItemLabelExpression, newItemLabelExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CommandMdsl> getCommands()
  {
    if (commands == null)
    {
      commands = new EObjectContainmentEList<CommandMdsl>(CommandMdsl.class, this, MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__COMMANDS);
    }
    return commands;
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
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LABEL:
        return basicSetLabel(null, msgs);
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE:
        return basicSetDslReference(null, msgs);
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY:
        return basicSetVisibilityQuery(null, msgs);
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY:
        return basicSetEditableQuery(null, msgs);
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER:
        return basicSetValueConverter(null, msgs);
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALIDATORS:
        return ((InternalEList<?>)getValidators()).basicRemove(otherEnd, msgs);
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT:
        return basicSetValueFormat(null, msgs);
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY:
        return basicSetCandidatesQuery(null, msgs);
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION:
        return basicSetItemLabelExpression(null, msgs);
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__COMMANDS:
        return ((InternalEList<?>)getCommands()).basicRemove(otherEnd, msgs);
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
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DESCRIPTION:
        return getDescription();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__UI_TAB:
        if (resolve) return getUiTab();
        return basicGetUiTab();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LAYERS:
        return getLayers();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NLABEL:
        return isI18NLabel();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LABEL:
        return getLabel();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_CATEGORY:
        return getWidgetCategory();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_TYPE:
        if (resolve) return getWidgetType();
        return basicGetWidgetType();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE:
        return getDslReference();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__FLEXIBLE_TEMPLATE:
        if (resolve) return getFlexibleTemplate();
        return basicGetFlexibleTemplate();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY:
        return getVisibilityQuery();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY:
        return getEditableQuery();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER:
        return getValueConverter();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALIDATORS:
        return getValidators();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NFORMAT:
        return isI18NFormat();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT:
        return getValueFormat();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY:
        return getCandidatesQuery();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NITEM_LABEL:
        return isI18NItemLabel();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION:
        return getItemLabelExpression();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__COMMANDS:
        return getCommands();
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
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__UI_TAB:
        setUiTab((UITabMdsl)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LAYERS:
        getLayers().clear();
        getLayers().addAll((Collection<? extends LayerMdsl>)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NLABEL:
        setI18NLabel((Boolean)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LABEL:
        setLabel((FormatExpr)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_CATEGORY:
        setWidgetCategory((WIDGET_CATEGORY_MDSL)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_TYPE:
        setWidgetType((WidgetType)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE:
        setDslReference((XtextLanguageReference)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__FLEXIBLE_TEMPLATE:
        setFlexibleTemplate((TypeConfigurationMdsl)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY:
        setVisibilityQuery((QueryMdsl)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY:
        setEditableQuery((QueryMdsl)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER:
        setValueConverter((ValueConverter)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALIDATORS:
        getValidators().clear();
        getValidators().addAll((Collection<? extends ValidatorMdsl>)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NFORMAT:
        setI18NFormat((Boolean)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT:
        setValueFormat((FormatExpr)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY:
        setCandidatesQuery((QueryUsage)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NITEM_LABEL:
        setI18NItemLabel((Boolean)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION:
        setItemLabelExpression((FormatExpr)newValue);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__COMMANDS:
        getCommands().clear();
        getCommands().addAll((Collection<? extends CommandMdsl>)newValue);
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
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__UI_TAB:
        setUiTab((UITabMdsl)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LAYERS:
        getLayers().clear();
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NLABEL:
        setI18NLabel(I18_NLABEL_EDEFAULT);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LABEL:
        setLabel((FormatExpr)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_CATEGORY:
        setWidgetCategory(WIDGET_CATEGORY_EDEFAULT);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_TYPE:
        setWidgetType((WidgetType)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE:
        setDslReference((XtextLanguageReference)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__FLEXIBLE_TEMPLATE:
        setFlexibleTemplate((TypeConfigurationMdsl)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY:
        setVisibilityQuery((QueryMdsl)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY:
        setEditableQuery((QueryMdsl)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER:
        setValueConverter((ValueConverter)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALIDATORS:
        getValidators().clear();
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NFORMAT:
        setI18NFormat(I18_NFORMAT_EDEFAULT);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT:
        setValueFormat((FormatExpr)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY:
        setCandidatesQuery((QueryUsage)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NITEM_LABEL:
        setI18NItemLabel(I18_NITEM_LABEL_EDEFAULT);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION:
        setItemLabelExpression((FormatExpr)null);
        return;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__COMMANDS:
        getCommands().clear();
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
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__UI_TAB:
        return uiTab != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LAYERS:
        return layers != null && !layers.isEmpty();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NLABEL:
        return i18NLabel != I18_NLABEL_EDEFAULT;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__LABEL:
        return label != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_CATEGORY:
        return widgetCategory != WIDGET_CATEGORY_EDEFAULT;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__WIDGET_TYPE:
        return widgetType != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE:
        return dslReference != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__FLEXIBLE_TEMPLATE:
        return flexibleTemplate != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VISIBILITY_QUERY:
        return visibilityQuery != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__EDITABLE_QUERY:
        return editableQuery != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER:
        return valueConverter != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALIDATORS:
        return validators != null && !validators.isEmpty();
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NFORMAT:
        return i18NFormat != I18_NFORMAT_EDEFAULT;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT:
        return valueFormat != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY:
        return candidatesQuery != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__I18_NITEM_LABEL:
        return i18NItemLabel != I18_NITEM_LABEL_EDEFAULT;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__ITEM_LABEL_EXPRESSION:
        return itemLabelExpression != null;
      case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL__COMMANDS:
        return commands != null && !commands.isEmpty();
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
    result.append(" (description: ");
    result.append(description);
    result.append(", i18NLabel: ");
    result.append(i18NLabel);
    result.append(", widgetCategory: ");
    result.append(widgetCategory);
    result.append(", i18NFormat: ");
    result.append(i18NFormat);
    result.append(", i18NItemLabel: ");
    result.append(i18NItemLabel);
    result.append(')');
    return result.toString();
  }

} //WidgetConfigurationMdslImpl
