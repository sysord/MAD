package com.sysord.mad.configuration.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.emf.tools.EMFUtil;
import com.sysord.emf.tools.EmfToolsFacade;
import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl;
import com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl;
import com.sysord.mad.configuration.madConfigDsl.FormatExpr;
import com.sysord.mad.configuration.madConfigDsl.FormatExprFragment;
import com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl;
import com.sysord.mad.configuration.madConfigDsl.Import;
import com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl;
import com.sysord.mad.configuration.madConfigDsl.LayerMdsl;
import com.sysord.mad.configuration.madConfigDsl.LiteralFormatExprFragment;
import com.sysord.mad.configuration.madConfigDsl.LiteralQueryFragment;
import com.sysord.mad.configuration.madConfigDsl.MADConfigElement;
import com.sysord.mad.configuration.madConfigDsl.MADConfiguration;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl;
import com.sysord.mad.configuration.madConfigDsl.PropertyMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryBody;
import com.sysord.mad.configuration.madConfigDsl.QueryChain;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryFragment;
import com.sysord.mad.configuration.madConfigDsl.QueryMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryRefMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryUsage;
import com.sysord.mad.configuration.madConfigDsl.TextMacroRef;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement;
import com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.WidgetType;

/**
 * Utility functions for request the MadConfigDslModel
 */
public class MadConfigDslUtil {

	
	protected static EmfToolsFacade emfTools = EmfToolsFacade.getInstance();
	
	/**
	 * provide the MADConfiguration root element from a MadConfigDsl resource
	 * 
	 * @param madConfigResource
	 * @return
	 */
	public static MADConfiguration getMadConfiguration(Resource madConfigResource){
		if(madConfigResource.getContents().isEmpty()){
			return null;
		}else{
			EObject root = madConfigResource.getContents().get(0);
			if(MADConfiguration.class.isAssignableFrom(root.getClass())){
				return (MADConfiguration) root;				
			}else{
				return null;
			}
		}
	}
	

	/**
	 * Provides MADConfigElement container of a MADConfigElement
	 * @param configElement
	 * @return
	 */
	public static MADConfiguration getMadConfigurationFromElement(MADConfigElement configElement){
		return (MADConfiguration) configElement.eContainer();
	}

	/**
	 * Provides MADConfigElement container of a MADConfig model Element
	 * @param modelElement
	 * @return
	 */
	public static MADConfiguration getMadConfigurationFromElement(EObject modelElement){
		return emfTools.getAssignableParent(modelElement, MADConfiguration.class);
	}
	
	
	//-------------
	// IMPORT
	//-------------
	
	/**
	 * Creates and returns a list of all imported uris in the mad configuration
	 * @param madConfig
	 * @return
	 */
	public static Collection<URI> getImportedURI(MADConfiguration madConfig){
		Set<URI> importedURIS = new HashSet<URI>();
		for(Import importDecl : madConfig.getImports()){
			importedURIS.add(URI.createURI(importDecl.getImportURI()));
		}		
		return importedURIS;
	}

	/**
	 * Creates and returns a list of all imported resources NSUri
	 * @param resourcesUri
	 * @return
	 */
	public static Collection<String> getImportedResourcesNSURI(Collection<URI> resourcesUri){
		Set<String> nsUris = new HashSet<String>();
		for(URI uri : resourcesUri){
			String nsUri = EMFUtil.getNSUriFromURI(uri);
			if(nsUri != null){
				nsUris.add(EMFUtil.getNSUriFromURI(uri));				
			}
		}				
		return nsUris;
	}
	


	//-------------
	// I18N
	//-------------

	/**
	 * Return all I18NBundle declarations for the model
	 * @param madConfig
	 * @return
	 */
	public static Collection<I18NBundleMdsl> getI18NBundleDeclarations(MADConfiguration madConfig){
		return EcoreUtil.getObjectsByType(madConfig.getConfigElements(), MadConfigDslPackage.Literals.I18N_BUNDLE_MDSL);		
	}

	//-------------
	// LAYERS
	//-------------
	
	/**
	 * return all Layers defined in configuration
	 * @param madConfig
	 * @return
	 */
	public static Collection<LayerMdsl> getAllLayers(MADConfiguration madConfig){
		return EcoreUtil.getObjectsByType(madConfig.getConfigElements(), MadConfigDslPackage.Literals.LAYER_MDSL);		
	}

	/**
	 * return all first level Layers defined in configuration.
	 * a first level layer is a layer that is not owned by a an other layer
	 * @param madConfig
	 * @return
	 */
	public static Collection<LayerMdsl> getFirstLevelLayers(MADConfiguration madConfig){
		Collection<LayerMdsl> allLayers = getAllLayers(madConfig);
		Collection<LayerMdsl> firstLevelLayers = new ArrayList<LayerMdsl>();
		for(LayerMdsl layerMdsl : allLayers){
			if(!LayerMdsl.class.isAssignableFrom(layerMdsl.eContainer().getClass())){
				firstLevelLayers.add(layerMdsl);
			}
		}
		return firstLevelLayers;
	}

	
	//----------------------
	// TYPE CONFIGURATION
	//----------------------

	/**
	 * retrieve all widgets configuration for a type and all its super types.
	 * @return
	 */
	public static List<TypeConfigurationTemplateElement> getTemplateConfigurations(MADConfiguration madConfig, EClass type){
		return loadWidgetsConfigurationForType(madConfig, type);
	}
	
	/**
	 * retrieve all widgets configuration for a type and all its super types.
	 * @return
	 */
	public static List<TypeConfigurationTemplateElement> loadWidgetsConfigurationForType(MADConfiguration madConfig, EClass type){		
		//Collect all types configuration hierarchy by ascending navigation
		List<TypeConfigurationTemplateElement> templateElements = _loadWidgetsConfiguration(getTypeConfigurationHierarchy(madConfig, type));
		//apply layout
		TypeConfigurationMdsl typeConfigMdsl = getTypeConfiguration(madConfig, type);
		return applyLayout(templateElements, typeConfigMdsl);
	}


	/**
	 * retrieve all widgets configuration for a typeConfigMdsl and all its super types.
	 * @return
	 */
	public static List<TypeConfigurationTemplateElement> loadWidgetsConfigurationForTypeConfigMdsl(MADConfiguration madConfig, TypeConfigurationMdsl typeConfigMdsl){		
		return loadWidgetsConfigurationForTypeConfigMdsl(madConfig, typeConfigMdsl, true);	
	}

	/**
	 * retrieve all widgets configuration for a typeConfigMdsl and all its super types.
	 * @return
	 */
	public static List<TypeConfigurationTemplateElement> loadWidgetsConfigurationForTypeConfigMdsl(MADConfiguration madConfig, TypeConfigurationMdsl typeConfigMdsl, boolean applyLayout){		
		//Collect all types configuration hierarchy by ascending navigation
		List<TypeConfigurationTemplateElement> templateElements = _loadWidgetsConfiguration(getTypeConfigurationHierarchy(madConfig, typeConfigMdsl));
		if(!applyLayout) return templateElements;
		//apply layout
		return applyLayout(templateElements, typeConfigMdsl);		
	}

	/**
	 * Apply layout: simple widget ordering.
	 * If a template is defined for the element, reorder widgets like defined by template 
	 * 
	 * @param templateElements
	 * @param typeConfigMdsl
	 * @return
	 */
	public static List<TypeConfigurationTemplateElement>  applyLayout(List<TypeConfigurationTemplateElement> templateElements, TypeConfigurationMdsl typeConfigMdsl){
		//no layout defined 
		if(typeConfigMdsl == null || !typeConfigMdsl.isLayoutDefined()){
			return templateElements;
		}
		
		List<TypeConfigurationTemplateElement> layoutedTemplate = new ArrayList<TypeConfigurationTemplateElement>();		
		for(TypeConfigurationTemplateElement layoutElement : typeConfigMdsl.getLayoutElements()){
			for(TypeConfigurationTemplateElement templateElement : templateElements){
				if(layoutElement.getName().equals(templateElement.getName())){
					layoutedTemplate.add(templateElement);
				}
			}			
		}
		return layoutedTemplate;
	}
	
	
	protected static List<TypeConfigurationTemplateElement> _loadWidgetsConfiguration(List<TypeConfigurationMdsl> typesConfigurationHierarchy ){
		
		Map<String, TypeConfigurationTemplateElement> loadedWidgetsConfigurationDsl = new LinkedHashMap<String, TypeConfigurationTemplateElement>();		
		for(TypeConfigurationMdsl typeConfigMdsl : typesConfigurationHierarchy){
			//Load widget in the map: existing widget (by name) are overridden
			for(TypeConfigurationTemplateElement templateElement : typeConfigMdsl.getTemplateElements()){
				if(WidgetConfigurationMdsl.class.isAssignableFrom(templateElement.getClass())){
					WidgetConfigurationMdsl widgetConfigDsl = (WidgetConfigurationMdsl)templateElement;
					loadedWidgetsConfigurationDsl.put(widgetConfigDsl.getName(), widgetConfigDsl);
					
				}else if(IncludeTemplateElementMdsl.class.isAssignableFrom(templateElement.getClass())){
					IncludeTemplateElementMdsl includeTemplateElementMdsl = (IncludeTemplateElementMdsl) templateElement;
					loadedWidgetsConfigurationDsl.put("Include__" + includeTemplateElementMdsl.getRefIncludedTemplate().getName(), includeTemplateElementMdsl);					
				}
				
			}			
		}	
		
		return new ArrayList<TypeConfigurationTemplateElement>(loadedWidgetsConfigurationDsl.values());
	}

	
	/**
	 * return list containing type configuration and all super type configuration for the type
	 * 
	 * @param madConfig
	 * @param type
	 * @return
	 */
	protected static List<TypeConfigurationMdsl> getTypeConfigurationHierarchy(MADConfiguration madConfig, EClass type){
		//get all imported MADConfiguration
		List<MADConfiguration> importedConfigurations = new ArrayList<MADConfiguration>();
		importedConfigurations.add(madConfig);
		computeAllImportedConfigurations(madConfig, importedConfigurations);
		
		List<TypeConfigurationMdsl> typesConfigurationHierarchy = new ArrayList<TypeConfigurationMdsl>();
		_fillTypeConfigurationHierarchy(importedConfigurations, type, null, typesConfigurationHierarchy);
		return typesConfigurationHierarchy;
	}
	
	/**
	 * return list containing type configuration and all super type configuration for the type configuration
	 * 
	 * @param madConfig
	 * @param typeConfig
	 * @return
	 */
	protected static List<TypeConfigurationMdsl> getTypeConfigurationHierarchy(MADConfiguration madConfig, TypeConfigurationMdsl typeConfig){
		//get all imported MADConfiguration
		List<MADConfiguration> importedConfigurations = new ArrayList<MADConfiguration>();
		importedConfigurations.add(madConfig);
		computeAllImportedConfigurations(madConfig, importedConfigurations);

		List<TypeConfigurationMdsl> typesConfigurationHierarchy = new ArrayList<TypeConfigurationMdsl>();
		_fillTypeConfigurationHierarchy(importedConfigurations, typeConfig.getType(), typeConfig, typesConfigurationHierarchy);
		return typesConfigurationHierarchy;
	}
	
	/**
	 * Add type configuration to typesConfigurationHierarchy
	 * if type typeConfigMdsl is provided add this type else try to retrieve configuration for the type.
	 * Super types configuration are searched using
	 *  	implicit extends: Ecore metamodel super type configuration are searched and added to the typesConfigurationHierarchy.
	 * or 	explicit extends: super configurations defined for the type are added to the typesConfigurationHierarchy 
	 * 
	 * @param madConfigurations
	 * @param type
	 * @param typeConfigMdsl
	 * @param typesConfigurationHierarchy
	 */
	protected static void _fillTypeConfigurationHierarchy(List<MADConfiguration> madConfigurations, EClass type, TypeConfigurationMdsl typeConfigMdsl , List<TypeConfigurationMdsl> typesConfigurationHierarchy){
		//try to retrieve type configuration for type if not provided
		if(typeConfigMdsl == null){
			typeConfigMdsl = getTypeConfiguration(madConfigurations, type, (List<String>)null);			
		}
		
		//System.out.println(type.getName());
		if(typeConfigMdsl != null){
			//System.out.println("*** CONFIG:" + typeConfigMdsl.getName());
			//add type configuration if not registered
			if(!typesConfigurationHierarchy.contains(typeConfigMdsl)){
				typesConfigurationHierarchy.add(0, typeConfigMdsl);				
			}
			//apply explicit extends if defined
			if(typeConfigMdsl.isUseExplicitExtends()){
				//explicit extends if defined:
				//add super configurations 
				for(TypeConfigurationMdsl superConfigMdsl : typeConfigMdsl.getSuperConfigurations()){
					_fillTypeConfigurationHierarchy(madConfigurations, superConfigMdsl.getType(), superConfigMdsl, typesConfigurationHierarchy);
				}
				return;
			}
		}
		
		//not type configuration retrieved or type use implicit extends
		//implicit extends: Ecore metamodel super type configuration are loaded
		for(EClass superClass : type.getESuperTypes()){
			_fillTypeConfigurationHierarchy(madConfigurations, superClass, null, typesConfigurationHierarchy);
		}			

		return;
		
	}
	
	protected static void computeAllImportedConfigurations(MADConfiguration madConfig, List<MADConfiguration> importedConfigurations){
		//retrieve imported configuration
		for(Import importElement : madConfig.getImports()){
			String importURI = importElement.getImportURI();
			if(importURI.endsWith(".mad")){
				Resource importedResource = emfTools.getInstance().getResourcesManager().getResource(importURI);
				if(importedResource != null && !importedResource.getContents().isEmpty()){
					MADConfiguration importedConfiguration = (MADConfiguration)importedResource.getContents().get(0);
					if(!importedConfigurations.contains(importedConfiguration)){
						importedConfigurations.add(importedConfiguration);
						computeAllImportedConfigurations(importedConfiguration, importedConfigurations);
					}
				}
			}
		}
	}

	
	/**
	 * returns list containing type configuration and all super type configuration for the type
	 * 
	 * @deprecated
	 * @param madConfig
	 * @param type
	 * @return
	 */
	protected static List<TypeConfigurationMdsl> getTypeConfigurationHierarchyV1(MADConfiguration madConfig, EClass type){
		List<TypeConfigurationMdsl> typesConfigurationHierarchy = new ArrayList<TypeConfigurationMdsl>();
		_fillTypeConfigurationHierarchyV1(madConfig, type, null, typesConfigurationHierarchy);
		return typesConfigurationHierarchy;
	}
	
	/**
	 * returns list containing type configuration and all super type configuration for the type configuration
	 * 
	 * @deprecated
	 * @param madConfig
	 * @param typeConfig
	 * @return
	 */
	protected static List<TypeConfigurationMdsl> getTypeConfigurationHierarchyV1(MADConfiguration madConfig, TypeConfigurationMdsl typeConfig){
		List<TypeConfigurationMdsl> typesConfigurationHierarchy = new ArrayList<TypeConfigurationMdsl>();
		_fillTypeConfigurationHierarchyV1(madConfig, typeConfig.getType(), typeConfig, typesConfigurationHierarchy);
		return typesConfigurationHierarchy;
	}

	/**
	 * @deprecated 
	 * 
	 * Add type configuration to typesConfigurationHierarchy
	 * if type typeConfigMdsl is provided add this type else try to retrieve configuration for the type.
	 * Super types configuration are searched using
	 *  	implicit extends: Ecore metamodel super type configuration are searched and added to the typesConfigurationHierarchy.
	 * or 	explicit extends: super configurations defined for the type are added to the typesConfigurationHierarchy 
	 * 
	 * @param madConfig
	 * @param type
	 * @param typeConfigMdsl
	 * @param typesConfigurationHierarchy
	 */
	protected static void _fillTypeConfigurationHierarchyV1(MADConfiguration madConfig, EClass type, TypeConfigurationMdsl typeConfigMdsl , List<TypeConfigurationMdsl> typesConfigurationHierarchy){
		//try to retrieve type configuration for type if not provided
		if(typeConfigMdsl == null){
			typeConfigMdsl = getTypeConfiguration(madConfig, type);			
		}
		
		//System.out.println(type.getName());
		if(typeConfigMdsl != null){
			//System.out.println("*** CONFIG:" + typeConfigMdsl.getName());
			//add type configuration if not registered
			if(!typesConfigurationHierarchy.contains(typeConfigMdsl)){
				typesConfigurationHierarchy.add(0, typeConfigMdsl);				
			}
			//apply explicit extends if defined
			if(typeConfigMdsl.isUseExplicitExtends()){
				//explicit extends if defined:
				//add super configurations 
				for(TypeConfigurationMdsl superConfigMdsl : typeConfigMdsl.getSuperConfigurations()){
					_fillTypeConfigurationHierarchyV1(madConfig, superConfigMdsl.getType(), superConfigMdsl, typesConfigurationHierarchy);
				}
				return;
			}
		}
		
		//not type configuration retrieved or type use implicit extends
		//implicit extends: Ecore metamodel super type configuration are loaded
		for(EClass superClass : type.getESuperTypes()){
			_fillTypeConfigurationHierarchyV1(madConfig, superClass, null, typesConfigurationHierarchy);
		}			

		return;
		
	}
	


	
	
	/**
	 * return configuration for a type
	 * 
	 * @param madConfig
	 * @param type
	 * @return
	 */
	public static TypeConfigurationMdsl getTypeConfiguration(MADConfiguration madConfig, EClass type){
		return getTypeConfiguration(madConfig, type, (List<String>)null); 
	}

	/**
	 * return configuration for a type and a configuration name
	 * 
	 * @param madConfig
	 * @param type
	 * @param configurationName select only configuration named configurationName
	 * @return
	 */
	public static TypeConfigurationMdsl getTypeConfiguration(MADConfiguration madConfig, EClass type, String configurationName){
		return getTypeConfiguration(madConfig, type, Arrays.asList(new String[]{configurationName}));
	}
	
	/**
	 * Returns configuration for a type and a configuration name configuration is searched in madConfig
	 * 
	 * @param madConfig
	 * @param type
	 * @param configurationName select only configuration named configurationName
	 * @return
	 */
	public static TypeConfigurationMdsl getTypeConfiguration(MADConfiguration madConfig, EClass type, List<String> configurationNames){
		return getTypeConfiguration(Arrays.asList(new MADConfiguration[]{madConfig}), type, configurationNames);
	}

	/**
	 * Returns configuration for a type and a configuration name. configuration is searched in madConfigurations
	 * 
	 * @param madConfigurations
	 * @param type
	 * @param configurationNames
	 * @return
	 */
	public static TypeConfigurationMdsl getTypeConfiguration(List<MADConfiguration> madConfigurations, EClass type, List<String> configurationNames){
		List<TypeConfigurationMdsl> lTypesConfiguration = new ArrayList<TypeConfigurationMdsl>();
		for(MADConfiguration madConfig : madConfigurations){
			lTypesConfiguration.addAll(getTypesConfigurations(madConfig, Arrays.asList(new EClass[]{type}), configurationNames));			
		}
		
		if(lTypesConfiguration.isEmpty()){
			return null;			
		}else{
			//no selection by name: return default type configuration if exists
			if(configurationNames == null){
				for(TypeConfigurationMdsl typeConfigMdsl : lTypesConfiguration){
					if(typeConfigMdsl.isDefaultConfiguration()){
						return typeConfigMdsl;
					}
				}
				//no default configuration, will return first
			}
			//return first selected configuration
			return lTypesConfiguration.get(0);				
		}
	}

	/**
	 * Create a qualified id for a widget config
	 * @param widgetConfigurationMdsl
	 * @return
	 */
	public static String getWidgetConfigId(WidgetConfigurationMdsl widgetConfigurationMdsl){
		//return : type id + name : 
		//TODO: provide full qualified container name
		TypeConfigurationMdsl typeConfigMdsl = (TypeConfigurationMdsl) widgetConfigurationMdsl.eContainer();		
		return typeConfigMdsl.getType().getName() + '.' + widgetConfigurationMdsl.getName();
	}

	
	/**
	 * Extract typeConfiguration for several types
	 * 
	 * @param madConfig
	 * @param types
	 * @param configurationName select only this configuration name for the types
	 * @return
	 */
	private static List<TypeConfigurationMdsl> getTypesConfigurations(MADConfiguration madConfig, List<EClass> types, String configurationName){
		List<String> configurationsNames = (configurationName == null ? null : Arrays.asList(new String[]{configurationName}));
		return getTypesConfigurations(madConfig, types, configurationsNames);
	}
	
	/**
	 * Extract typeConfiguration for several types
	 * 
	 * @param madConfig
	 * @param types
	 * @param configurationsNames select only configuration with thats names
	 * @return
	 */
	private static List<TypeConfigurationMdsl> getTypesConfigurations(MADConfiguration madConfig, List<EClass> types, List<String> configurationsNames){
		
		List<TypeConfigurationMdsl> lTypesConfiguration = new ArrayList<TypeConfigurationMdsl>();
		for(TypeConfigurationMdsl typeConfig : getTypesConfigurations(madConfig)){
			for(EClass type : types){
				if(emfTools.isEClassEquals(type, typeConfig.getType())){
					if(configurationsNames == null || configurationsNames.isEmpty()){
						lTypesConfiguration.add(typeConfig);
					}else{
						//selection by name
						if(configurationsNames.contains(typeConfig.getName())){
							lTypesConfiguration.add(typeConfig);
						}
					}
				}
			}
		}
		return lTypesConfiguration;
	}

	private static List<TypeConfigurationMdsl> getTypesConfigurations(MADConfiguration madConfig, List<String> configurationsNames){
		
		List<TypeConfigurationMdsl> lTypesConfiguration = new ArrayList<TypeConfigurationMdsl>();
		for(TypeConfigurationMdsl typeConfig : getTypesConfigurations(madConfig)){
			//selection by name
			if(configurationsNames.contains(typeConfig.getName())){
				lTypesConfiguration.add(typeConfig);
				return lTypesConfiguration;
			}
		}
		return lTypesConfiguration;
	}

	
	public static Collection<TypeConfigurationMdsl> getTypesConfigurations(MADConfiguration madConfig){
		return EcoreUtil.getObjectsByType(madConfig.getConfigElements(), MadConfigDslPackage.Literals.TYPE_CONFIGURATION_MDSL);
	}
	

	
	/**
	 * Return the label provider expression define for a type or one of its super type
	 * 
	 * @param madConfig
	 * @param type
	 * @return
	 */
	public static String getLabelProviderExpressionForType(MADConfiguration madConfig, EClass type, String i18NPrefix){
		String  labelProviderExpr = null;
		if(type != null){
			TypeConfigurationMdsl typeConfigMdsl = getTypeConfiguration(madConfig, type);
			if(typeConfigMdsl != null){				
				labelProviderExpr = createLiteralFormatExpression(typeConfigMdsl.getLabelProviderExpression());
				if(labelProviderExpr != null){
					if(typeConfigMdsl.isI18NLabelProvider()){
						labelProviderExpr = i18NPrefix + labelProviderExpr;
					}
					return labelProviderExpr;
				}
			}
			//look for label provider in super type configuration
			for(EClass superType : type.getESuperTypes()){
				labelProviderExpr = getLabelProviderExpressionForType(madConfig, superType, i18NPrefix);
				if(labelProviderExpr != null){
					return labelProviderExpr;
				}
			}
		}
		return null;
	}




	/**
	 * Return all WidgetType configuation for the model (Mapping Widget id -> Factory class)
	 * @param madConfig
	 * @return
	 */
	public static Collection<WidgetType> getWidgetTypes(MADConfiguration madConfig){
		return EcoreUtil.getObjectsByType(madConfig.getConfigElements(), MadConfigDslPackage.Literals.WIDGET_TYPE);		
	}

	/**
	 * Return all WidgetType configuation for the model (Mapping Widget id -> Factory class)
	 * @param madConfig
	 * @param category select only widget type for this category
	 * @return
	 */
	public static Collection<WidgetType> getWidgetTypes(MADConfiguration madConfig, WIDGET_CATEGORY_MDSL category){
		Collection<WidgetType> allWidgetType = getWidgetTypes(madConfig);
		Collection<WidgetType> categoryWidgetsType = new ArrayList<WidgetType>(); 
		for(WidgetType widgetType : allWidgetType){
			if(category == widgetType.getCategory()){
				categoryWidgetsType.add(widgetType);				
			}
		}
		return categoryWidgetsType;		
	}

	/**
	 * Return all Query evaluator declarations for the model
	 * @param madConfig
	 * @return
	 */
	public static Collection<QueryEvaluatorMdsl> getQueryEvaluatorDeclarations(MADConfiguration madConfig){
		return EcoreUtil.getObjectsByType(madConfig.getConfigElements(), MadConfigDslPackage.Literals.QUERY_EVALUATOR_MDSL);		
	}

	/**
	 * Return all Query OCL Custom libraries declarations for the model
	 * @param madConfig
	 * @return
	 */
	public static Collection<OCLCustomLibraryMdsl> getOCLCustomLibraryDeclarations(MADConfiguration madConfig){
		return EcoreUtil.getObjectsByType(madConfig.getConfigElements(), MadConfigDslPackage.Literals.OCL_CUSTOM_LIBRARY_MDSL);		
	}
	
	/**
	 * Return all Foreign model declarations for the model
	 * @param madConfig
	 * @return
	 */
	public static Collection<ForeignModelMdsl> getForeignModelDeclarations(MADConfiguration madConfig){
		return EcoreUtil.getObjectsByType(madConfig.getConfigElements(), MadConfigDslPackage.Literals.FOREIGN_MODEL_MDSL);		
	}
	
	
	/**
	 * Return Query return type for a Query usage
	 *  
	 * @param queryUsage
	 * @return
	 */
	public static EClassifier resolveQueryReturnType(QueryUsage queryUsage){
		if(queryUsage == null){
			return null;
		}
		if(QueryMdsl.class.isAssignableFrom(queryUsage.getClass())){
			return resolveQueryReturnType((QueryMdsl)queryUsage);
		}else if(QueryChain.class.isAssignableFrom(queryUsage.getClass())){
			//return last member query return type
			QueryChain queryChain = (QueryChain) queryUsage;
			return resolveQueryReturnType(queryChain.getQueries().get(queryChain.getQueries().size() - 1));
		}else{
			//TODO: raise exception or return EcorePackage.Literals.ECLASS
			return null;
		}
	}

	
	/**
	 * Return Query return type for a Query
	 * 
	 * @param queryMdsl
	 * @return
	 */
	public static EClassifier resolveQueryReturnType(QueryMdsl queryMdsl){
		QueryDefinitionMdsl queryDefinitionDefMdsl = resolveQuery(queryMdsl);
		if(queryDefinitionDefMdsl == null){
			return null;
		}else {
			return queryDefinitionDefMdsl.getReturnType();
		}		
	}

	
	/**
	 * Return Querydefinition for a Query element
	 *  
	 * @param queryMdsl
	 * @return
	 */
	public static QueryDefinitionMdsl resolveQuery(QueryMdsl queryMdsl){
		if(queryMdsl == null){
			return null;
		}
		if(QueryDefinitionMdsl.class.isAssignableFrom(queryMdsl.getClass())){
			return (QueryDefinitionMdsl) queryMdsl;
		}else if(QueryRefMdsl.class.isAssignableFrom(queryMdsl.getClass())){
			//query reference
			return ((QueryRefMdsl) queryMdsl).getReferenced().getDefinition();
		}else{
			//TODO: raise exception
			return null;
		}
	}

	/**
	 * convert Query body to a query string
	 * if query body use macros then macros are substitute by their associated value
	 *  
	 * @param queryBody
	 * @return
	 */
	public static String getQueryBodyString(QueryBody queryBody){
		if(queryBody == null){
			return null;
		}
		String queryBodyStr = "";		
		for(QueryFragment queryFragment : queryBody.getFragments()){
			if(TextMacroRef.class.isAssignableFrom(queryFragment.getClass())){
				queryBodyStr += ((TextMacroRef)queryFragment).getReferenced().getMacroValue();
			}else if(LiteralQueryFragment.class.isAssignableFrom(queryFragment.getClass())){
				queryBodyStr += ((LiteralQueryFragment)queryFragment).getValue();
			}
		}
		return queryBodyStr;
	}

	
	/**
	 * Return all Querydefinitions for a Query usage element
	 *  
	 * @param queryMdsl
	 * @return
	 */
	public static List<QueryDefinitionMdsl> resolveQueryUsage(QueryUsage queryUsage){
		if(queryUsage == null){
			return null;
		}
		List<QueryDefinitionMdsl> queryDefinitionsMdsl = new ArrayList<QueryDefinitionMdsl>();
		if(QueryMdsl.class.isAssignableFrom(queryUsage.getClass())){
			queryDefinitionsMdsl.add(resolveQuery((QueryMdsl) queryUsage));
		}else if(QueryChain.class.isAssignableFrom(queryUsage.getClass())){
			for(QueryMdsl queryMdsl : ((QueryChain)queryUsage).getQueries()){
				queryDefinitionsMdsl.add(resolveQuery(queryMdsl));
			}
		}
		return queryDefinitionsMdsl;
	}

	
	/**
	 * Build a format expression String by concatenation of all literals and macro expression fragments
	 * @param formatExpr
	 * @return
	 */
	public static String createLiteralFormatExpression(FormatExpr formatExpr){
		if(formatExpr == null){
			return null;
		}
		StringBuilder literalFormatExpr = new StringBuilder();
		for(FormatExprFragment fragment : formatExpr.getFragments()){
			if(TextMacroRef.class.isAssignableFrom(fragment.getClass())){
				literalFormatExpr.append(((TextMacroRef)fragment).getReferenced().getMacroValue());
			}else{
				literalFormatExpr.append(((LiteralFormatExprFragment)fragment).getValue());				
			}
		}
		return literalFormatExpr.toString();
	}
	
	/**
	 * Structure for return FormatExpression with I18N flag
	 */
	public static class FormatExpressionDescriptor{
		public boolean isI18N = false;
		public FormatExpr formatExpr = null;
		public FormatExpressionDescriptor(boolean isI18N, FormatExpr formatExpr) {
			super();
			this.isI18N = isI18N;
			this.formatExpr = formatExpr;
		}		
	}
	
	/**
	 * Returns CommandDefinition for a Command element
	 *  
	 * @param commandMdsl
	 * @return
	 */
	public static CommandDefinitionMdsl resolveCommand(CommandMdsl commandMdsl){
		if(commandMdsl == null){
			return null;
		}
		if(CommandDefinitionMdsl.class.isAssignableFrom(commandMdsl.getClass())){
			return (CommandDefinitionMdsl) commandMdsl;
		}else if(CommandRefMdsl.class.isAssignableFrom(commandMdsl.getClass())){
			//command reference
			return ((CommandRefMdsl) commandMdsl).getReferenced().getDefinition();
		}else{
			//TODO: raise exception
			return null;
		}
	}


	/**
	 * Returns FormatExpression description from command
	 * if command is a referenced command referencer can override label
	 * this method return the label to use and its i18N flag.
	 * 
	 * @param commandMdsl
	 * @return
	 */
	public static FormatExpressionDescriptor resolveCommandLabelExpression(CommandMdsl commandMdsl){
		if(commandMdsl == null){
			return null;
		}
		boolean isI18N = false;
		FormatExpr formatExpr = null;
		if(CommandDefinitionMdsl.class.isAssignableFrom(commandMdsl.getClass())){
			formatExpr = ((CommandDefinitionMdsl) commandMdsl).getLabel();
			isI18N = ((CommandDefinitionMdsl) commandMdsl).isI18NLabel();
		}else if(CommandRefMdsl.class.isAssignableFrom(commandMdsl.getClass())){
			//command reference
			if(((CommandRefMdsl)commandMdsl).getLabelOverride() != null){
				//extract redefined label expression
				formatExpr = ((CommandRefMdsl)commandMdsl).getLabelOverride();
				isI18N = ((CommandRefMdsl)commandMdsl).isI18NLabelOverride();
			}else{
				//extract referenced command label expression
				formatExpr =  ((CommandRefMdsl) commandMdsl).getReferenced().getDefinition().getLabel();				
				isI18N = ((CommandRefMdsl) commandMdsl).getReferenced().getDefinition().isI18NLabel();
			}
		}else{
			//TODO: raise exception
			return null;
		}
		//creates and returns info structure 
		return new FormatExpressionDescriptor(isI18N, formatExpr);
	}

		
	public static  <T> Class<T> resolveClassDescriptorMdsl(ClassDescriptorMdsl classDescriptor){
		if(classDescriptor == null) return null;
		try {
			return EclipseTools.loadClass(classDescriptor.getPluginId(), classDescriptor.getClassName());
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}	
	}
	
		
	/**
	 * Load Map with properties from MadCOnfig
	 * @param propertiesMdsl
	 * @return
	 */
	public static Map<String,Object> loadProperties(List<PropertyMdsl> propertiesMdsl){
		Map<String,Object> properties = new HashMap<String, Object>();
		for(PropertyMdsl propertyMdsl : propertiesMdsl){
			properties.put(propertyMdsl.getPropertyName().getName(), propertyMdsl.getPropertyValue());
		}
		return properties;
	}

	
}
