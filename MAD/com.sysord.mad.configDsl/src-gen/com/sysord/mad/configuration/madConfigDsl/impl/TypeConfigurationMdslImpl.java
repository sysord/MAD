/**
 */
package com.sysord.mad.configuration.madConfigDsl.impl;

import com.sysord.mad.configuration.madConfigDsl.FormatExpr;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement;

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
 * An implementation of the model object '<em><b>Type Configuration Mdsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl#isDefaultConfiguration <em>Default Configuration</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl#isI18NLabelProvider <em>I18N Label Provider</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl#getLabelProviderExpression <em>Label Provider Expression</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl#isUseExplicitExtends <em>Use Explicit Extends</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl#getSuperConfigurations <em>Super Configurations</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl#getTemplateElements <em>Template Elements</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl#isLayoutDefined <em>Layout Defined</em>}</li>
 *   <li>{@link com.sysord.mad.configuration.madConfigDsl.impl.TypeConfigurationMdslImpl#getLayoutElements <em>Layout Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeConfigurationMdslImpl extends MADConfigElementImpl implements TypeConfigurationMdsl
{
  /**
   * The default value of the '{@link #isDefaultConfiguration() <em>Default Configuration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefaultConfiguration()
   * @generated
   * @ordered
   */
  protected static final boolean DEFAULT_CONFIGURATION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDefaultConfiguration() <em>Default Configuration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefaultConfiguration()
   * @generated
   * @ordered
   */
  protected boolean defaultConfiguration = DEFAULT_CONFIGURATION_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EClass type;

  /**
   * The default value of the '{@link #isI18NLabelProvider() <em>I18N Label Provider</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NLabelProvider()
   * @generated
   * @ordered
   */
  protected static final boolean I18_NLABEL_PROVIDER_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isI18NLabelProvider() <em>I18N Label Provider</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isI18NLabelProvider()
   * @generated
   * @ordered
   */
  protected boolean i18NLabelProvider = I18_NLABEL_PROVIDER_EDEFAULT;

  /**
   * The cached value of the '{@link #getLabelProviderExpression() <em>Label Provider Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabelProviderExpression()
   * @generated
   * @ordered
   */
  protected FormatExpr labelProviderExpression;

  /**
   * The default value of the '{@link #isUseExplicitExtends() <em>Use Explicit Extends</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseExplicitExtends()
   * @generated
   * @ordered
   */
  protected static final boolean USE_EXPLICIT_EXTENDS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUseExplicitExtends() <em>Use Explicit Extends</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseExplicitExtends()
   * @generated
   * @ordered
   */
  protected boolean useExplicitExtends = USE_EXPLICIT_EXTENDS_EDEFAULT;

  /**
   * The cached value of the '{@link #getSuperConfigurations() <em>Super Configurations</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperConfigurations()
   * @generated
   * @ordered
   */
  protected EList<TypeConfigurationMdsl> superConfigurations;

  /**
   * The cached value of the '{@link #getTemplateElements() <em>Template Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateElements()
   * @generated
   * @ordered
   */
  protected EList<TypeConfigurationTemplateElement> templateElements;

  /**
   * The default value of the '{@link #isLayoutDefined() <em>Layout Defined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLayoutDefined()
   * @generated
   * @ordered
   */
  protected static final boolean LAYOUT_DEFINED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLayoutDefined() <em>Layout Defined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLayoutDefined()
   * @generated
   * @ordered
   */
  protected boolean layoutDefined = LAYOUT_DEFINED_EDEFAULT;

  /**
   * The cached value of the '{@link #getLayoutElements() <em>Layout Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayoutElements()
   * @generated
   * @ordered
   */
  protected EList<TypeConfigurationTemplateElement> layoutElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeConfigurationMdslImpl()
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
    return MadConfigDslPackage.Literals.TYPE_CONFIGURATION_MDSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDefaultConfiguration()
  {
    return defaultConfiguration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultConfiguration(boolean newDefaultConfiguration)
  {
    boolean oldDefaultConfiguration = defaultConfiguration;
    defaultConfiguration = newDefaultConfiguration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__DEFAULT_CONFIGURATION, oldDefaultConfiguration, defaultConfiguration));
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
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (EClass)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(EClass newType)
  {
    EClass oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isI18NLabelProvider()
  {
    return i18NLabelProvider;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setI18NLabelProvider(boolean newI18NLabelProvider)
  {
    boolean oldI18NLabelProvider = i18NLabelProvider;
    i18NLabelProvider = newI18NLabelProvider;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__I18_NLABEL_PROVIDER, oldI18NLabelProvider, i18NLabelProvider));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormatExpr getLabelProviderExpression()
  {
    return labelProviderExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLabelProviderExpression(FormatExpr newLabelProviderExpression, NotificationChain msgs)
  {
    FormatExpr oldLabelProviderExpression = labelProviderExpression;
    labelProviderExpression = newLabelProviderExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION, oldLabelProviderExpression, newLabelProviderExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabelProviderExpression(FormatExpr newLabelProviderExpression)
  {
    if (newLabelProviderExpression != labelProviderExpression)
    {
      NotificationChain msgs = null;
      if (labelProviderExpression != null)
        msgs = ((InternalEObject)labelProviderExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION, null, msgs);
      if (newLabelProviderExpression != null)
        msgs = ((InternalEObject)newLabelProviderExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION, null, msgs);
      msgs = basicSetLabelProviderExpression(newLabelProviderExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION, newLabelProviderExpression, newLabelProviderExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUseExplicitExtends()
  {
    return useExplicitExtends;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUseExplicitExtends(boolean newUseExplicitExtends)
  {
    boolean oldUseExplicitExtends = useExplicitExtends;
    useExplicitExtends = newUseExplicitExtends;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__USE_EXPLICIT_EXTENDS, oldUseExplicitExtends, useExplicitExtends));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeConfigurationMdsl> getSuperConfigurations()
  {
    if (superConfigurations == null)
    {
      superConfigurations = new EObjectResolvingEList<TypeConfigurationMdsl>(TypeConfigurationMdsl.class, this, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__SUPER_CONFIGURATIONS);
    }
    return superConfigurations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeConfigurationTemplateElement> getTemplateElements()
  {
    if (templateElements == null)
    {
      templateElements = new EObjectContainmentEList<TypeConfigurationTemplateElement>(TypeConfigurationTemplateElement.class, this, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TEMPLATE_ELEMENTS);
    }
    return templateElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isLayoutDefined()
  {
    return layoutDefined;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLayoutDefined(boolean newLayoutDefined)
  {
    boolean oldLayoutDefined = layoutDefined;
    layoutDefined = newLayoutDefined;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LAYOUT_DEFINED, oldLayoutDefined, layoutDefined));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeConfigurationTemplateElement> getLayoutElements()
  {
    if (layoutElements == null)
    {
      layoutElements = new EObjectResolvingEList<TypeConfigurationTemplateElement>(TypeConfigurationTemplateElement.class, this, MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LAYOUT_ELEMENTS);
    }
    return layoutElements;
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
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION:
        return basicSetLabelProviderExpression(null, msgs);
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TEMPLATE_ELEMENTS:
        return ((InternalEList<?>)getTemplateElements()).basicRemove(otherEnd, msgs);
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
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__DEFAULT_CONFIGURATION:
        return isDefaultConfiguration();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__NAME:
        return getName();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__I18_NLABEL_PROVIDER:
        return isI18NLabelProvider();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION:
        return getLabelProviderExpression();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__USE_EXPLICIT_EXTENDS:
        return isUseExplicitExtends();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__SUPER_CONFIGURATIONS:
        return getSuperConfigurations();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TEMPLATE_ELEMENTS:
        return getTemplateElements();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LAYOUT_DEFINED:
        return isLayoutDefined();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LAYOUT_ELEMENTS:
        return getLayoutElements();
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
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__DEFAULT_CONFIGURATION:
        setDefaultConfiguration((Boolean)newValue);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__NAME:
        setName((String)newValue);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TYPE:
        setType((EClass)newValue);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__I18_NLABEL_PROVIDER:
        setI18NLabelProvider((Boolean)newValue);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION:
        setLabelProviderExpression((FormatExpr)newValue);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__USE_EXPLICIT_EXTENDS:
        setUseExplicitExtends((Boolean)newValue);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__SUPER_CONFIGURATIONS:
        getSuperConfigurations().clear();
        getSuperConfigurations().addAll((Collection<? extends TypeConfigurationMdsl>)newValue);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TEMPLATE_ELEMENTS:
        getTemplateElements().clear();
        getTemplateElements().addAll((Collection<? extends TypeConfigurationTemplateElement>)newValue);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LAYOUT_DEFINED:
        setLayoutDefined((Boolean)newValue);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LAYOUT_ELEMENTS:
        getLayoutElements().clear();
        getLayoutElements().addAll((Collection<? extends TypeConfigurationTemplateElement>)newValue);
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
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__DEFAULT_CONFIGURATION:
        setDefaultConfiguration(DEFAULT_CONFIGURATION_EDEFAULT);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TYPE:
        setType((EClass)null);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__I18_NLABEL_PROVIDER:
        setI18NLabelProvider(I18_NLABEL_PROVIDER_EDEFAULT);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION:
        setLabelProviderExpression((FormatExpr)null);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__USE_EXPLICIT_EXTENDS:
        setUseExplicitExtends(USE_EXPLICIT_EXTENDS_EDEFAULT);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__SUPER_CONFIGURATIONS:
        getSuperConfigurations().clear();
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TEMPLATE_ELEMENTS:
        getTemplateElements().clear();
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LAYOUT_DEFINED:
        setLayoutDefined(LAYOUT_DEFINED_EDEFAULT);
        return;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LAYOUT_ELEMENTS:
        getLayoutElements().clear();
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
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__DEFAULT_CONFIGURATION:
        return defaultConfiguration != DEFAULT_CONFIGURATION_EDEFAULT;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TYPE:
        return type != null;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__I18_NLABEL_PROVIDER:
        return i18NLabelProvider != I18_NLABEL_PROVIDER_EDEFAULT;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LABEL_PROVIDER_EXPRESSION:
        return labelProviderExpression != null;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__USE_EXPLICIT_EXTENDS:
        return useExplicitExtends != USE_EXPLICIT_EXTENDS_EDEFAULT;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__SUPER_CONFIGURATIONS:
        return superConfigurations != null && !superConfigurations.isEmpty();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__TEMPLATE_ELEMENTS:
        return templateElements != null && !templateElements.isEmpty();
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LAYOUT_DEFINED:
        return layoutDefined != LAYOUT_DEFINED_EDEFAULT;
      case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL__LAYOUT_ELEMENTS:
        return layoutElements != null && !layoutElements.isEmpty();
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
    result.append(" (defaultConfiguration: ");
    result.append(defaultConfiguration);
    result.append(", name: ");
    result.append(name);
    result.append(", i18NLabelProvider: ");
    result.append(i18NLabelProvider);
    result.append(", useExplicitExtends: ");
    result.append(useExplicitExtends);
    result.append(", layoutDefined: ");
    result.append(layoutDefined);
    result.append(')');
    return result.toString();
  }

} //TypeConfigurationMdslImpl
