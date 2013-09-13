/***************************************************************************
 * Copyright (c) 2013 Sysord.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sysord - initial API and implementation
 ****************************************************************************/
package com.sysord.mad.configuration.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.diagnostic.Diagnostic.DIAGNOSTIC_LEVEL;
import com.sysord.eclipse.tools.nls.I18nService;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.emf.tools.EmfToolsFacade;
import com.sysord.emf.tools.resource.ResourcesManager;
import com.sysord.emf.tools.resource.ResourcesManagerListener;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.configuration.Layer;
import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.configuration.XtextLanguageDescription;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationServiceProvider;
import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl;
import com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl;
import com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl;
import com.sysord.mad.configuration.madConfigDsl.LayerMdsl;
import com.sysord.mad.configuration.madConfigDsl.MADConfiguration;
import com.sysord.mad.configuration.madConfigDsl.ModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement;
import com.sysord.mad.configuration.madConfigDsl.URIExtensionModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.URIModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.WidgetType;
import com.sysord.mad.configuration.util.MadConfigDslUtil;
import com.sysord.mad.core.Activator;
import com.sysord.mad.core.IMADConstants;
import com.sysord.mad.core.preferences.PreferenceHelper;
import com.sysord.mad.evaluator.QueryEvaluator;
import com.sysord.mad.evaluator.QueryEvaluatorProvider;
import com.sysord.mad.evaluator.impl.ocl.MadOclCustomizer;
import com.sysord.mad.evaluator.impl.ocl.OCLQueryEvaluator;
import com.sysord.mad.model.provider.ModelExtensionManager;
import com.sysord.mad.model.provider.ModelProvider;
import com.sysord.mad.model.provider.ModelProviderFactory;
import com.sysord.mad.model.provider.ModelProviderService;
import com.sysord.mad.model.provider.ModelSynchronizerFactory;
import com.sysord.mad.query.impl.QueryFactory;
import com.sysord.mad.widget.SpecificWidget;
import com.sysord.mad.widget.WidgetBuilder;
import com.sysord.xtext.tools.XtextUtility;

/**
 * Extract Mad configuration for an element type
 *
 * Configuration is build loading Xtext MadDslConfig Model.
 *
 */
public class ConfigurationManagerImpl implements ConfigurationManager{


	protected ResourcesManager resourcesManager;
	
	@Inject
	protected ConsoleLogger logger;
	
	@Inject
	protected ModelProviderService modelProviderService;	
	
	@Inject
	protected ModelProviderFactory modelProviderFactory;
	
	@Inject
	protected QueryEvaluatorProvider evaluatorProvider;
	
	@Inject
	protected WidgetBuilder widgetBuilder;

	@Inject
	protected I18nService i18NService;
	
	@Inject 
	protected ExternalQueryConfigurationServiceProvider extQServiceProvider;

	
	/**
	 * Configuration URIS storage
	 */
	protected Map<String,URI> hMadconfigurationsURI = new HashMap<String, URI>();
	
	/**
	 * the main layer
	 */
	protected Layer mainLayer;
	
	/**
	 * all layers by id storage
	 */
	protected Map<String, Layer> layers = new HashMap<String, Layer>();
		
	/**
	 * Listeners (noification when configuration is reloaded)
	 */
	protected List<ConfigurationManagerListener> listeners = new ArrayList<ConfigurationManager.ConfigurationManagerListener>();
	
	
	/**
	 * List containing all resources URI imported in MAd configurations
	 */
	protected Collection<URI> importedURIs;
	
	/**
	 * List containing NsURI of all imported resources in MAd configurations
	 */
	protected Collection<String> importedNsURIs;
	
	
	protected GenericHierarchicalCache<Object> configurationCache = new GenericHierarchicalCache<Object>();
	protected static final String TYPE_CONFIGURATION__CACHE = "#TYPE_CONFIGURATION#";
	protected static final String LABEL_PROVIDER__CACHE = "#LABEL_PROVIDER#";
	protected static final String IMPORTED_URIS__CACHE = "#IMPORTED_URIS#";
	protected static final String IMPORTED_NSURIS__CACHE = "#IMPORTED_NSURIS#";
	
	
	public ConfigurationManagerImpl() {
		super();
	}

	@Override
	public void initialize(){
		loadMADConfiguration();
		configureProviders();
	}
	
	/**
	 * returns a list containing all resources URI imported in Mad configurations
	 * @return
	 */
	@Override
	public Collection<URI> getImportedURIs(){
		Collection<URI> importedURIs = new HashSet<URI>();
		importedURIs = new ArrayList<URI>();
		for(MADConfiguration madConfig : _getMadConfigurations()){
			importedURIs.addAll(getImportedURIs(madConfig));
		}
		return importedURIs;			
	}

	/**
	 * returns a list containing all resources URI imported in a Mad configuration
	 * @return
	 */
	@Override
	public Collection<URI> getImportedURIs(MADConfiguration madConfig ){
		Collection<URI> importedURIs = null;
		//try to get from cache
		List<Object> cacheKey = _create_ImportedURIs_CacheKey(madConfig);
		if(configurationCache.containsItem(cacheKey)){
			logger.log("Configuration manager use cache to get Imported URIs for madConfig:" + madConfig, ConsoleLogger.VERY_LOW);
			return (Collection<URI>) configurationCache.getItem(cacheKey);
		}else{
			importedURIs = MadConfigDslUtil.getImportedURI(madConfig);			
			//store in cache
			configurationCache.storeItem(cacheKey, importedURIs);
		}
		return new HashSet<URI>(importedURIs);	
	}

	/**
	 * generate cache key for imported Uris from MADConfiguration
	 * @param madConfig
	 * @return
	 */
	protected List<Object> _create_ImportedURIs_CacheKey(MADConfiguration madConfig){
		return Arrays.asList(new Object[]{IMPORTED_URIS__CACHE, madConfig});
	}

	
	/**
	 * returns a list containing NSUris of all imported resources in Mad configurations
	 * @return
	 */
	@Override
	public Collection<String> getImportedResourcesNsURIs(){
		Collection<String> importedURIs = new HashSet<String>();
		importedURIs = new ArrayList<String>();
		for(MADConfiguration madConfig : _getMadConfigurations()){
			importedURIs.addAll(getImportedResourcesNsURIs(madConfig));
		}
		return importedURIs;			
	}

	/**
	 * returns a list containing NSUris of all imported resources in a Mad configuration
	 * @return
	 */
	@Override
	public Collection<String> getImportedResourcesNsURIs(MADConfiguration madConfig ){
		Collection<String> importedNsURIs = null;
		//try to get from cache
		List<Object> cacheKey = _create_ImportedResourcesNsURIs_CacheKey(madConfig);
		if(configurationCache.containsItem(cacheKey)){
			logger.log("Configuration manager use cache to get Imported URIs for madConfig:" + madConfig, ConsoleLogger.VERY_LOW);
			return (Collection<String>) configurationCache.getItem(cacheKey);
		}else{
			importedNsURIs = MadConfigDslUtil.getImportedResourcesNSURI(getImportedURIs(madConfig));
			//store in cache
			configurationCache.storeItem(cacheKey, importedNsURIs);			
		}
		return new HashSet<String>(importedNsURIs);	
	}

	/**
	 * generate cache key for imported NsUris from MADConfiguration
	 * @param madConfig
	 * @return
	 */
	protected List<Object> _create_ImportedResourcesNsURIs_CacheKey(MADConfiguration madConfig){
		return Arrays.asList(new Object[]{IMPORTED_NSURIS__CACHE, madConfig});
	}

	
	
	
	@Override
	public void addListener(ConfigurationManagerListener listener){
		listeners.add(listener);
	}

	@Override
	public void removeListener(ConfigurationManagerListener listener){
		listeners.remove(listener);		
	}
	
	/**
	 * Load mad configuration
	 * from one or several Xtext MadDslConfig Model
	 */
	protected void loadMADConfiguration(){
		//add default Mad configuration
		hMadconfigurationsURI.clear();
		//flush configuration cache
		configurationCache.flush();
		//todo: replace by bootstrap included in plugin
		//hMadconfigurationsURI.put(DEFAULT_MAD_CONFIG, URI.createPlatformResourceURI("MAD.config/config.mad", true) );		

		//add user Mad configurations
		for(URI madConfigURI : PreferenceHelper.getMadConfigURIs()){
			hMadconfigurationsURI.put(madConfigURI.toString(), madConfigURI);					
		}
				
	}
	
	
	/**
	 * Create and return configuration for Eclass type
	 */
	@Override
	public TypeConfiguration getConfiguration(EClass type) {
		//try to get from cache
		List<Object> cacheKey = _create_TypeConfiguration_CacheKey(type);
		if(configurationCache.containsItem(cacheKey)){
			logger.log("Configuration manager use cache to get TypeConfiguration for type:" + type.getName(), ConsoleLogger.VERY_LOW);
			return (TypeConfiguration) configurationCache.getItem(cacheKey);
		} 
				
		TypeConfiguration typeConfiguration = null;		
		for(MADConfiguration madConfig : _getMadConfigurations()){
			if(MadConfigDslUtil.getTypeConfiguration(madConfig, type) != null){
				if(typeConfiguration == null){
					typeConfiguration = new TypeConfigurationImpl(type);
				}
				loadConfigurationTypeConfiguration(typeConfiguration, madConfig);
			}
		}
		
		//store in cache
		configurationCache.storeItem(cacheKey, typeConfiguration);

		if(typeConfiguration == null) {
			logger.log("No configuration for type:" + type.getName(), ConsoleLogger.VERY_LOW);
		}

		return typeConfiguration;
	}

	/**
	 * generate cache key for type configuration from type
	 * @param type
	 * @return
	 */
	protected List<Object> _create_TypeConfiguration_CacheKey(EClass type){
		return Arrays.asList(new Object[]{TYPE_CONFIGURATION__CACHE, type});
	}
	
	
	
	@Override
	public Layer getMainLayer(){
		if(mainLayer == null){
			_loadLayers();
		}
		return mainLayer;
	}
	
	
	/**
	 * get layers configuration and build the main layer structure
	 */
	protected void _loadLayers(){
		layers.clear();
		mainLayer = new LayerImpl(MAIN_LAYER, "Main layer");
		for(MADConfiguration madConfig : _getMadConfigurations()){
			for(LayerMdsl layerMdsl : MadConfigDslUtil.getFirstLevelLayers(madConfig)){
				//create layer
				ceateLayerFromLayerMdsl(mainLayer, layerMdsl);
			}
		}
	}
	
	/**
	 * create a layer from layer mdsl, add to its parent and
	 * recurse for its all children.
	 * 
	 * @param parentLayer parent layer
	 * @param layerMdsl mdsl layer configuration
	 * @return
	 */
	protected Layer ceateLayerFromLayerMdsl(Layer parentLayer, LayerMdsl layerMdsl){
		//create layer
		String layerFormatExpr = ConfigurationManagerHelper.createLiteralFormatExpression(layerMdsl.getLabelFormatExpr(), layerMdsl.isI18NLabel()); 
		Layer layer = new LayerImpl(layerMdsl.getName(), layerFormatExpr);
		layers.put(layerMdsl.getName(), layer);
		//add to parent
		parentLayer.getChildrenLayers().add(layer);
		//recurs for all children
		for(LayerMdsl sublayerMdsl : layerMdsl.getSubLayers()){
			ceateLayerFromLayerMdsl(layer, sublayerMdsl);
		}
		return layer;		
	}
	
		
	@Override
	public Layer getLayerById(String layerId) {
		if(mainLayer == null){
			_loadLayers();
		}
		return layers.get(layerId);
	}

	/**
	 * Provide configured label provider for a type
	 * @param type the type eClass
	 * @return null if not exists label provider for the type
	 */
	@Override
	public String getLabelProviderExpressionForType(EClass type) {
		//try to get from cache
		List<Object> cacheKey = _create_LabelProvider_CacheKey(type);
		if(configurationCache.containsItem(cacheKey)){
			logger.log("Configuration manager use cache to get label provider for type:" + type.getName(), ConsoleLogger.VERY_LOW);
			return (String) configurationCache.getItem(cacheKey);
		} 
		
		String labelProvider = null;
		for(MADConfiguration madConfig : _getMadConfigurations()){
			String wLabelProv = MadConfigDslUtil.getLabelProviderExpressionForType(madConfig, type, I18N_PREFIX);
			if(wLabelProv != null) labelProvider = wLabelProv;
		}
		
		if(labelProvider != null){
			//store in cache
			configurationCache.storeItem(cacheKey, labelProvider);
		}
		
		return labelProvider  ;		
	}
	
	/**
	 * generate cache key for label provider from type
	 * @param type
	 * @return
	 */
	protected List<Object> _create_LabelProvider_CacheKey(EClass type){
		return Arrays.asList(new Object[]{LABEL_PROVIDER__CACHE, type});
	}
	
	/**
	 * Create and load type configuration from type as Eclass
	 * @param type
	 * @param madConfig
	 * @return
	 */
	protected TypeConfiguration createAndLoadTypeConfigurationForType(EClass type, MADConfiguration madConfig){
		TypeConfiguration typeConfiguration = new TypeConfigurationImpl(type);
		loadConfigurationTypeConfiguration(typeConfiguration, madConfig);
		return typeConfiguration;
	}

	/**
	 * Create and load type configuration using type configuration from madDslConfig
	 * 
	 * @param typeConfigMdsl
	 * @param madConfig
	 * @return
	 */
	protected TypeConfiguration createAndLoadTypeConfigurationForTypeConfigMdsl(TypeConfigurationMdsl typeConfigMdsl, MADConfiguration madConfig){
		if(typeConfigMdsl == null){
			return null;
		}
		TypeConfiguration typeConfiguration = new TypeConfigurationImpl(typeConfigMdsl.getType());
		loadConfiguration(typeConfiguration, typeConfigMdsl.getTemplateElements(), madConfig, null);
		return typeConfiguration;
	}

	
	/**
	 * Load element in a type configuration
	 * 
	 * @param typeConfiguration
	 * @param madConfig
	 */
	protected void loadConfigurationTypeConfiguration(TypeConfiguration typeConfiguration, MADConfiguration madConfig){
		//Extract widgets configurations
		//List<TypeConfigurationTemplateElement> templateElements = MadConfigDslUtil.getTemplateConfigurations(madConfig, typeConfiguration.getType());
		List<TypeConfigurationTemplateElement> templateElements = MadConfigDslUtil.getTemplateConfigurations(madConfig, typeConfiguration.getType());
		//Load widget configuration and add adapted widgetConfigDsl
		loadConfiguration(typeConfiguration, templateElements, madConfig, null);
	}

	/**
	 * load type configuration from templateElements
	 * 
	 * @param typeConfiguration
	 * @param templateElements
	 * @param processedTemplates name of processed template for detect and avoid cycles
	 * @param madConfig
	 */
	protected void loadConfiguration(TypeConfiguration typeConfiguration, List<TypeConfigurationTemplateElement> templateElements,
									MADConfiguration madConfig, List<String> processedTemplates){
		
		loadConfiguration(typeConfiguration, templateElements, madConfig, processedTemplates, null);
	}
	
	/**
	 * 
	 * @param typeConfiguration
	 * @param templateElements
	 * @param madConfig
	 * @param processedTemplates
	 * @param preQueries when templateElements are provided by an included template preQuery is the include template query value.
	 */
	protected void loadConfiguration(TypeConfiguration typeConfiguration, List<TypeConfigurationTemplateElement> templateElements,
				MADConfiguration madConfig, List<String> processedTemplates, List<QueryDefinitionMdsl> preQueries){
		
		//init cycle detection structure
		if(processedTemplates == null){
			processedTemplates = new ArrayList<String>();
		}
		
		//Add adapted widgetConfigDsl
		for(TypeConfigurationTemplateElement templateElement : templateElements){
			
			//Add widget configuration
			if(WidgetConfigurationMdsl.class.isAssignableFrom(templateElement.getClass())){
				_createAndAddWidgetConfiguration(madConfig, typeConfiguration, (WidgetConfigurationMdsl)templateElement, processedTemplates, preQueries);
				
			}else if(IncludeTemplateElementMdsl.class.isAssignableFrom(templateElement.getClass())){
				//include widget from another template
				_includeTemplateWidgets(madConfig, typeConfiguration, (IncludeTemplateElementMdsl)templateElement, processedTemplates, preQueries);
			}
			
		}
	}
	
	protected WidgetConfiguration _createAndAddWidgetConfiguration(MADConfiguration madConfig, TypeConfiguration typeConfiguration, 
																	WidgetConfigurationMdsl widgetConfigDsl, List<String> processedTemplates,
																	List<QueryDefinitionMdsl> preQueries){
		TypeConfiguration flexibleTypeConfiguration = null;
		if(widgetConfigDsl.getFlexibleTemplate() != null){
			//detect cycle:
			if(processedTemplates.contains(widgetConfigDsl.getFlexibleTemplate().getName())){
				logger.logError("Configuration manager detects cycle with " + widgetConfigDsl.getFlexibleTemplate().getName());
			}else{
				processedTemplates.add(widgetConfigDsl.getFlexibleTemplate().getName());
				//load flexible template (flexible widget or navigation widget as target)
				List<TypeConfigurationTemplateElement> flexibleTemplateElments = MadConfigDslUtil.loadWidgetsConfigurationForTypeConfigMdsl(madConfig, widgetConfigDsl.getFlexibleTemplate());
				flexibleTypeConfiguration = new TypeConfigurationImpl(widgetConfigDsl.getFlexibleTemplate().getType());						
				loadConfiguration(flexibleTypeConfiguration, flexibleTemplateElments, madConfig, processedTemplates, preQueries);											
			}
		}

		//Specific widget configuration for flexible widget
		if(widgetConfigDsl.getWidgetCategory() == WIDGET_CATEGORY_MDSL.FLEXIBLE_WIDGET){
			//flexible widget
			return typeConfiguration.addWidgetConfigurations(createFlexibleWidgetConfiguration(widgetConfigDsl, flexibleTypeConfiguration, preQueries));									
		}else{
			//basic widget
			return typeConfiguration.addWidgetConfigurations(createWidgetConfiguration(widgetConfigDsl, flexibleTypeConfiguration, preQueries));				
		}					
	}
	
	/**
	 * Get widget from a named template and add them to the configuration
	 * @param madConfig
	 * @param typeConfiguration
	 * @param widgetConfigDsl
	 * @param processedTemplates
	 */
	protected void _includeTemplateWidgets(MADConfiguration madConfig, TypeConfiguration typeConfiguration, 
						IncludeTemplateElementMdsl includeTemplateElementMdsl, List<String> processedTemplates,
						List<QueryDefinitionMdsl> preQueries){
		
		//retrieve the included template
		TypeConfigurationMdsl includedTypeConfigMdsl = 	includeTemplateElementMdsl.getRefIncludedTemplate();
		//extract includedTemplatevalueQueries (prefix for all included widget queries)
		List<QueryDefinitionMdsl> includedTemplatevalueQueries = new ArrayList<QueryDefinitionMdsl>();
		if(preQueries != null){
			includedTemplatevalueQueries.addAll(preQueries);
		}
		includedTemplatevalueQueries.addAll(MadConfigDslUtil.resolveQueryUsage(includeTemplateElementMdsl.getValueQuery()));
		
		//include elements (name conflict problem)
		//List<TypeConfigurationTemplateElement> incudedElements = MadConfigDslUtil.loadWidgetsConfigurationForTypeConfigMdsl(madConfig, includedTypeConfigMdsl);
		//loadConfiguration(typeConfiguration, incudedElements, madConfig, processedTemplates, includedTemplatevalueQueries);
		loadConfiguration(typeConfiguration, includedTypeConfigMdsl.getTemplateElements(), madConfig, processedTemplates, includedTemplatevalueQueries);
	}
	
	
	/**
	 * Create widgetConfiguration for a basic widget
	 * 
	 * @param widgetConfigMdsl
	 * @return
	 */
	protected <VT,CT> WidgetConfiguration<VT> createWidgetConfiguration(WidgetConfigurationMdsl widgetConfigMdsl, 
																		TypeConfiguration flexibleTypeConfiguration,
																		List<QueryDefinitionMdsl> preQueries){
		
		Class<VT> widgetValueType = (Class<VT>) ConfigurationManagerHelper.discoverWidgetValueType(widgetConfigMdsl);
		Class<CT> candidatesValueType = (Class<CT>) ConfigurationManagerHelper.discoverCandidatesValueType(widgetConfigMdsl);
		WidgetConfiguration<VT> widgetConfig = new WidgetConfigurationImpl<VT>(widgetConfigMdsl, widgetValueType, candidatesValueType, flexibleTypeConfiguration, preQueries);		
		initWidgetLayers(widgetConfigMdsl, widgetConfig);
		return widgetConfig;

	}

	/**
	 * Create widgetConfiguration for a flexible Widget 
	 * @param widgetConfigMdsl
	 * @param flexible template configuration
	 * @return
	 */
	protected <VT,CT> WidgetConfiguration<VT> createFlexibleWidgetConfiguration(WidgetConfigurationMdsl widgetConfigMdsl, 
																				TypeConfiguration flexibleTypeConfiguration,
																				List<QueryDefinitionMdsl> preQueries){
		//create mad type configuration 
		Class<VT> widgetValueType = (Class<VT>) Object.class; //we don't know if query will return one object or a collection.
		Class<CT> candidatesValueType = (Class<CT>) Object.class; //unused 
		// WidgetConfiguration for Flexible widget:
		WidgetConfiguration<VT> widgetConfig = new WidgetConfigurationImpl<VT>(widgetConfigMdsl, widgetValueType, candidatesValueType, flexibleTypeConfiguration, preQueries);
		initWidgetLayers(widgetConfigMdsl, widgetConfig);
		return widgetConfig;
	}

	/**
	 * fill layers list for the widget configuration
	 * @param widgetConfigMdsl
	 * @param widgetConfiguration
	 */
	protected <VT> void initWidgetLayers(WidgetConfigurationMdsl widgetConfigMdsl, WidgetConfiguration<VT> widgetConfiguration){
		for(LayerMdsl layerMdsl : widgetConfigMdsl.getLayers()){
			Layer layer = getLayerById(layerMdsl.getName());
			if(layer != null){
				widgetConfiguration.getLayers().add(layer);
			}
		}
	}

	

	
	/**
	 * Create and register model providers from the MadConfig 
	 */
	protected void configureModelProvider(){
		modelProviderService.unregisterAll();
		for(MADConfiguration madConfig : _getMadConfigurations()){
			for(ForeignModelMdsl foreignModelDecl : MadConfigDslUtil.getForeignModelDeclarations(madConfig)){
				ModelProvider modelProvider = createModelProvider(foreignModelDecl);
				if(modelProvider != null){
					modelProviderService.registerModelProvider(foreignModelDecl.getName(), modelProvider);
				}
			}
		}			
	}

	protected ModelProvider createModelProvider(ForeignModelMdsl foreignModelDecl){
		ModelProviderMdsl modelProviderMdsl = foreignModelDecl.getProvider();
		
		ModelProvider modelProvider = null;
						
		if(URIModelProviderMdsl.class.isAssignableFrom(modelProviderMdsl.getClass())){
			modelProvider = modelProviderFactory.createUriModelProvider(((URIModelProviderMdsl)modelProviderMdsl).getModelUri());
			
		}else if(URIExtensionModelProviderMdsl.class.isAssignableFrom(modelProviderMdsl.getClass())){
			modelProvider = modelProviderFactory.createUriExtensionModelProvider(((URIExtensionModelProviderMdsl)modelProviderMdsl).getUriExtension());
			
		}else if(CustomModelProviderMdsl.class.isAssignableFrom(modelProviderMdsl.getClass())){
			CustomModelProviderMdsl customModelProviderDsl = (CustomModelProviderMdsl)modelProviderMdsl;
			modelProvider = modelProviderFactory.createCustomModelProvider(customModelProviderDsl.getClassDescriptor().getPluginId(), 
																	customModelProviderDsl.getClassDescriptor().getClassName(),
																	customModelProviderDsl.getParameters().toArray());			
		}
				
		if(modelProvider != null){
			//set the autoReload option
			modelProvider.setAutoReload(foreignModelDecl.isAutoReloadEnabled());
			
			//Try to obtains the defined Synchronizer
			ModelSynchronizerFactory synchronizerFactory = createModelSynchronizerFactory(foreignModelDecl);
			modelProvider.setModelSynchronizerFactory(synchronizerFactory);
			
			//Try to obtains the defined ModelExtensionManager
			ModelExtensionManager extensionManager = createModelExtensionManager(foreignModelDecl);	
			modelProvider.setExtensionManager(extensionManager);

			//Try to obtains the defined DSL descriptor
			XtextLanguageDescription dslDescription = createDslDescription(foreignModelDecl);
			modelProvider.setDslDescription(dslDescription);

		}
		
		return modelProvider;
	}

	
	/**
	 * Try to create the model synchronizer if defined.
	 * @param foreignModelDecl
	 * @return
	 */
	protected ModelSynchronizerFactory createModelSynchronizerFactory(ForeignModelMdsl foreignModelDecl){
		//Try to obtains the defined Synchronizer
		Class<ModelSynchronizerFactory> synchonizerFactoryClass = null;
		ModelSynchronizerFactory synchronizerFactory = null;
		if(foreignModelDecl.getSynchronizerFactoryClass() != null){
			synchonizerFactoryClass = MadConfigDslUtil.resolveClassDescriptorMdsl(foreignModelDecl.getSynchronizerFactoryClass());
			if(synchonizerFactoryClass != null){
				try {
					synchronizerFactory = Activator.getDefault().getInjector().getInstance(synchonizerFactoryClass);
				} catch (Exception e) {
					logger.logError(e.getMessage(), ConsoleLogger.LOW);
				}
			}
			if(synchronizerFactory == null){
				logger.logError("Model synchronizer factory for foreign model '" + foreignModelDecl.getName() 
								+ "' not found. Class descriptor:" + foreignModelDecl.getSynchronizerFactoryClass()
								, ConsoleLogger.LOW);
			}
		}
		return synchronizerFactory ;
	}
	
	
	/**
	 * Try to create the model extension manager if defined.
	 * @param foreignModelDecl
	 * @return
	 */
	protected ModelExtensionManager createModelExtensionManager(ForeignModelMdsl foreignModelDecl){
		Class<ModelExtensionManager> extensionManagerClass = null;
		ModelExtensionManager extensionManager = null;
		if(foreignModelDecl.getExtensionManagerClass() != null){
			extensionManagerClass = MadConfigDslUtil.resolveClassDescriptorMdsl(foreignModelDecl.getExtensionManagerClass());
			if(extensionManagerClass != null){
				try {
					extensionManager = Activator.getDefault().getInjector().getInstance(extensionManagerClass);
				} catch (Exception e) {
					logger.logError(e.getMessage(), ConsoleLogger.LOW);
				}
			}
			if(extensionManager == null){
				logger.logError("ExtensionManager for foreign model '" + foreignModelDecl.getName() 
								+ "' not found. Class descriptor:" + foreignModelDecl.getExtensionManagerClass()
								, ConsoleLogger.LOW);
			}
		}
		return extensionManager;
	}

	/**
	 * try to retreive the Dsl description if defined
	 * @param foreignModelDecl
	 * @return
	 */
	protected XtextLanguageDescription createDslDescription(ForeignModelMdsl foreignModelDecl){
		XtextLanguageDescription dslDescription = null;
		if(foreignModelDecl.getDslReference() != null){
			dslDescription = ConfigurationManagerHelper.createDslDescription(foreignModelDecl.getDslReference().getXtextLanguageDescriptor());	
		}
		return dslDescription;
	}

	

	/**
	 * register I18N Bundles from the MadConfig 
	 */
	protected void registerI18NBundles(){				
		for(MADConfiguration madConfig : _getMadConfigurations()){
			for(I18NBundleMdsl i18NBundleMdsl : MadConfigDslUtil.getI18NBundleDeclarations(madConfig)){
				if(i18NBundleMdsl.getBundleDescriptor() != null){
					i18NService.registerBundle(i18NBundleMdsl.getBundleDescriptor().getPluginId(), 
							i18NBundleMdsl.getBundleDescriptor().getClassName());					
				}else if(i18NBundleMdsl.getBundleUri() != null){
					i18NService.registerBundle(i18NBundleMdsl.getBundleUri());										
				}
			}
		}
		
	}

	
	/**
	 * Create and register Query evaluator providers from the MadConfig 
	 */
	protected void configureQueryEvaluatorProvider(){
		
		evaluatorProvider.unregisterAllQueryEvaluators();
		
		//Register default OCL query evaluator
		setupOCLQueryEvaluator();

		for(MADConfiguration madConfig : _getMadConfigurations()){
			for(QueryEvaluatorMdsl queryEvaluatorMdsl : MadConfigDslUtil.getQueryEvaluatorDeclarations(madConfig)){
				//exclude OCL configuration since added.
				if(!OCLQueryEvaluator.OCL_LANGUAGE_ID.equals(queryEvaluatorMdsl.getName())){
					QueryEvaluator evaluator = createQueryEvaluator(queryEvaluatorMdsl);
					if(evaluator != null){
						evaluatorProvider.registerQueryEvaluator(evaluator, queryEvaluatorMdsl.getName());
					}
				}
			}
		}
		
	}

		
	protected QueryEvaluator createQueryEvaluator(QueryEvaluatorMdsl queryEvaluatorMdsl) {
		Class<? extends QueryEvaluator> queryEvaluatorClass = classFromClassDescriptorMdsl(queryEvaluatorMdsl.getClassDescriptor());
		if(queryEvaluatorClass != null){
			return Activator.getDefault().getInjector().getInstance(queryEvaluatorClass);
		}else{
			return null;
		}		
	}

	/**
	 * Creates and registers the OCL Query evaluator provider
	 */
	protected void setupOCLQueryEvaluator(){
		
		//Register custom OCL libraries
		MadOclCustomizer.removeAllCustomLibraries();
		for(MADConfiguration madConfig : _getMadConfigurations()){
			for(OCLCustomLibraryMdsl oclCustomLibraryMdsl : MadConfigDslUtil.getOCLCustomLibraryDeclarations(madConfig)){
				Object oclCustomLibrary = retreiveOCLCustomLibray(oclCustomLibraryMdsl);
				if(oclCustomLibrary != null){
					//register OCL custom libray
					MadOclCustomizer.registerCustomLibray(oclCustomLibrary);
				}else{
					logger.logError("ExtensionManager for foreign model '" + oclCustomLibraryMdsl.getLabel() 
							+ "' not found. Class descriptor:" + oclCustomLibraryMdsl.getClassDescriptor()
							, ConsoleLogger.LOW);

				}
			}
		}

		//Register default OCL query evaluator
		OCLQueryEvaluator oclQueryEvaluator = new OCLQueryEvaluator();
		evaluatorProvider.registerQueryEvaluator(oclQueryEvaluator);

	}
	
	protected Object retreiveOCLCustomLibray(OCLCustomLibraryMdsl oclCustomLibraryMdsl) {
		Class<?> oclCustomLibraryClass = MadConfigDslUtil.resolveClassDescriptorMdsl(oclCustomLibraryMdsl.getClassDescriptor());
		if(oclCustomLibraryClass != null){
			return Activator.getDefault().getInjector().getInstance(oclCustomLibraryClass);
		}else{
			return null;			
		}
	}

	
	private void configureExtQServiceProvider() {
		extQServiceProvider.unregisterAllExtQServices();		
		for(MADConfiguration madConfig : _getMadConfigurations()){
			extQServiceProvider.registerExtQService(madConfig);
		}		
	}

	

	public void configureConcreteWidgetBuilder(){
		//Load and store all widget types in work map
		Map<String, WidgetType> hWidgetTypeConfgsMdsl = new HashMap<String, WidgetType>();
		for(MADConfiguration madConfig : _getMadConfigurations()){
			for(WidgetType widgetTypeMdsl : MadConfigDslUtil.getWidgetTypes(madConfig)){
				hWidgetTypeConfgsMdsl.put(widgetTypeMdsl.getName(), widgetTypeMdsl);
			}
		} 
		
		//build and add all custom widgets to the widget builder
		widgetBuilder.removeAll();
		for(WidgetType widgetTypeMdsl : hWidgetTypeConfgsMdsl.values()){
			Class<? extends SpecificWidget> customWidgetClass = classFromClassDescriptorMdsl(widgetTypeMdsl.getClassDescriptor());
			if(customWidgetClass != null){
				SpecificWidget customWidget = Activator.getDefault().getInjector().getInstance(customWidgetClass);
				if(customWidget != null){
					widgetBuilder.addSpecificWidget(widgetTypeMdsl.getName(), customWidget);
				}
			}else{
				logger.logError("Fail to create custom widget:" + widgetTypeMdsl.getName() + " (" + widgetTypeMdsl.getLabel()  +") check 'Widget type' declaration.");
			}
		}
	}



	
	
	protected <T> Class<T> classFromClassDescriptorMdsl(ClassDescriptorMdsl classDescriptor){
		return EclipseTools.loadClass(
				(classDescriptor.getPluginId() == null ? IMADConstants.PLUGIN_ID : classDescriptor.getPluginId()), 
				classDescriptor.getClassName()
		);		
	}

	protected void configureProviders(){
		registerI18NBundles();
		configureQueryEvaluatorProvider();
		configureModelProvider();
		configureConcreteWidgetBuilder();
		configureExtQServiceProvider();
		QueryFactory.flushCache();
	}


	/**
	 * Resource manager listener used to be notified on used resources change
	 */
	ResourcesManagerListener resourceManagerListener = new ResourcesManagerListener() {		
		@Override
		public void onManagedResourceEvent(String resourceName, RESOURCE_EVENT event) {
			logger.log("Configuration manager receive:" + resourceName + " " + event, ConsoleLogger.VERY_LOW);
			if(event == RESOURCE_EVENT.RELOADED){
				reloadConfigurations();
			}
		}
	};

	@Override
	public void reloadConfigurations() {
		loadMADConfiguration();
		//Reload layers
		_loadLayers();
		//Reload providers (model provider + Query evaluator provider)
		configureProviders();
		// Notify listeners
		for(ConfigurationManagerListener listener : listeners){
			listener.onConfigurationReloaded();
		}
	}

	private ResourcesManager _getResourcesManager(){
		if(resourcesManager == null){
			resourcesManager = EmfToolsFacade.getInstance().getResourcesManager();
		}
		return resourcesManager;
	}

	protected List<MADConfiguration> _getMadConfigurations(){
		List<MADConfiguration> madConfigurations = new ArrayList<MADConfiguration>();
		for(URI uri : hMadconfigurationsURI.values()){
			Resource madConfigResource = _getResourcesManager().getResource(uri.toString(), resourceManagerListener);
			//validate config 
			if(XtextUtility.validateXtextResource((XtextResource) madConfigResource).getLevel() != DIAGNOSTIC_LEVEL.ERROR){					
				MADConfiguration madConfig = MadConfigDslUtil.getMadConfiguration(madConfigResource);
				if(madConfig != null){
					madConfigurations.add(madConfig);
				}else{
					logger.logError("Unable to find mad configuration from :" + uri.toString());
				}
			}else{
				logger.logError("Ignore mad configuration '" + uri.toString() + "' because it contains errors.");				
			}
		}
		return madConfigurations;		
	}

	
}
