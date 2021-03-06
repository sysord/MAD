/*
 * generated by Xtext
 */
package com.sysord.mad.configuration.scoping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.inject.Inject;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationService;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationServiceProvider;
import com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl;
import com.sysord.mad.configuration.madConfigDsl.MADConfigElement;
import com.sysord.mad.configuration.madConfigDsl.MADConfiguration;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationTemplateElement;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.WidgetType;
import com.sysord.mad.configuration.util.MadConfigDslUtil;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class MadConfigDslScopeProvider extends AbstractDeclarativeScopeProvider {

	@Inject
	protected ExternalQueryConfigurationServiceProvider extQServiceProvider;
	
	public static final boolean DEBUG = false;
	
	public IScope getScope(EObject context, EReference reference) {
		if(DEBUG){
			String methodName = "scope_" + reference.getEContainingClass().getName() + "_" + reference.getName();
			System.out.println(methodName + "(" + context.getClass().getSimpleName() + " context, EReference reference)");

			methodName = "scope_" + reference.getEReferenceType().getName();
			System.out.println(methodName + "(" + context.getClass().getSimpleName() + " context, EReference reference)");
		}
		return super.getScope(context, reference);
	}
	
	/**
	 * Scope provider for widgetType
	 * 
	 * only widgetType of same category of the widget configuration must be proposed.
	 * 
	 * @param context
	 * @param reference
	 * @return
	 */
	public IScope scope_WidgetConfigurationMdsl_widgetType(WidgetConfigurationMdsl context, EReference reference){
		//use delegate for retrieve imported widgetTypes
		IScope scope = delegateGetScope(context, reference);
		Set<WidgetType> widgetTypes = new HashSet<WidgetType>();
		for(IEObjectDescription description : scope.getAllElements()){
			WidgetType widgetType = (WidgetType) description.getEObjectOrProxy();
			widgetType = (WidgetType) EcoreUtil.resolve(widgetType, context.eResource());
			if(widgetType.getCategory().name().equals(context.getWidgetCategory().getName())){
				widgetTypes.add(widgetType);
			}
		}
		return Scopes.scopeFor(widgetTypes);
	}
	
	
	/**
	 * Scope provider for layout: create scope with WidgetConfigurationMdsl 
	 * @param context
	 * @param reference
	 * @return
	 */
	public IScope scope_TypeConfigurationMdsl_layoutElements(TypeConfigurationMdsl context, EReference reference){
		Set<TypeConfigurationTemplateElement>  templateElements = new HashSet<TypeConfigurationTemplateElement>();		
		for(MADConfiguration madConfig : getAllMadConfiguration(context)){
			templateElements.addAll(MadConfigDslUtil.loadWidgetsConfigurationForTypeConfigMdsl(madConfig, context, false));			
		}		
		Collection<TypeConfigurationTemplateElement>  widgetConfigElements = Collections2.filter(templateElements, new Predicate<TypeConfigurationTemplateElement>() {
													public boolean apply(TypeConfigurationTemplateElement input) {
														//return WidgetConfigurationMdsl.class.isAssignableFrom(input.getClass());
														return true;
													}
												}
		);
		return Scopes.scopeFor(widgetConfigElements);
	}
	
	/**
	 * returns all MADConfiguration from current configuration and imported configurations
	 * TODO: find a better method
	 * @return
	 */
	protected Collection<MADConfiguration> getAllMadConfiguration(EObject context){
		Set<MADConfiguration> configurations = new HashSet<MADConfiguration>();
		//curent configuration
		MADConfiguration madConfig = MadConfigDslUtil.getMadConfigurationFromElement(context);
		configurations.add(madConfig);
		//get all configElements
		IScope scope = delegateGetScope(context, MadConfigDslPackage.Literals.MAD_CONFIGURATION__CONFIG_ELEMENTS);
		for(IEObjectDescription description : scope.getAllElements()){
			MADConfigElement configElement = (MADConfigElement) description.getEObjectOrProxy();
			configElement = (MADConfigElement) EcoreUtil.resolve(configElement, context.eResource());
			if(MADConfiguration.class.isAssignableFrom(configElement.eContainer().getClass())){
				configurations.add((MADConfiguration) configElement.eContainer());				
			}
		}		
		return configurations;
	}
	
	
	//--------------------------------
	// External Queries
	//--------------------------------
	public IScope scope_ExternalQueryCallMdsl_externalQuery(ExternalQueryCallMdsl context, EReference reference){

		//Retrieve evaluator from QueryDefinitionMdsl
		QueryDefinitionMdsl queryDefMdsl = (QueryDefinitionMdsl) context.eContainer(); 
		if(queryDefMdsl.getEvaluator() == null){
			return IScope.NULLSCOPE;
		}
		
		//Register extQService
		ExternalQueryConfigurationService extQService = extQServiceProvider.getExtQService(queryDefMdsl.getEvaluator());
		if(extQService == null){
			return IScope.NULLSCOPE;						
		}
		
		IScope scope = delegateGetScope(context, reference);		
		List<EObject> queries = new ArrayList<EObject>();
		List<EClass> queriesEClass = extQService.getQueriesEClass();
		for(IEObjectDescription description : scope.getAllElements()){
			EObject candidate = description.getEObjectOrProxy();
			//TODO: filter by context type
			if(queriesEClass.contains(candidate.eClass())){
				queries.add(candidate);
			}
		}		
		return Scopes.scopeFor(queries);			
	}
	
	
}
