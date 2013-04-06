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
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;

import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.mad.command.impl.UICommandDefinitionImpl;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.configuration.UICommandDefinition;
import com.sysord.mad.configuration.UICommandDefinition.UICOMMAND_TYPE;
import com.sysord.mad.configuration.ValidatorDefinition;
import com.sysord.mad.configuration.ValueConverterConfiguration;
import com.sysord.mad.configuration.ValueConverterConfiguration.VALUE_CONVERTER_CATEGORY;
import com.sysord.mad.configuration.WidgetConfiguration.WIDGET_CATEGORY;
import com.sysord.mad.configuration.XtextLanguageDescription;
import com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter;
import com.sysord.mad.configuration.madConfigDsl.DisplayViewUICommand;
import com.sysord.mad.configuration.madConfigDsl.FormatExpr;
import com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.ReloadViewUICommand;
import com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand;
import com.sysord.mad.configuration.madConfigDsl.UICommandMdsl;
import com.sysord.mad.configuration.madConfigDsl.VALUE_CONVERTER_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl;
import com.sysord.mad.configuration.madConfigDsl.ValueConverter;
import com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl;
import com.sysord.mad.configuration.util.MadConfigDslUtil;
import com.sysord.mad.core.Activator;
import com.sysord.mad.query.QueryDefinition;
import com.sysord.mad.query.QueryDefinition.RETURN_VALUE_OCCURENCE;
import com.sysord.mad.query.impl.QueryFactory;

public class ConfigurationManagerHelper {

	protected static ConsoleLogger logger;

	protected static ConsoleLogger getLogger(){
		if(logger == null){
			logger = Activator.getDefault().getInjector().getInstance(ConsoleLogger.class);
		}
		return logger;
	}

	
	
	/**
	 * convert widget category Mdsl to Mad Widget category
	 * @param widgetCategoyMDsl
	 * @return
	 */
	public static WIDGET_CATEGORY convertWidgetCategory(WIDGET_CATEGORY_MDSL widgetCategoyMDsl) {
		switch(widgetCategoyMDsl){
		case TEXT_WIDGET:
			return WIDGET_CATEGORY.TEXT_WIDGET;
		case DATE_WIDGET:
			return WIDGET_CATEGORY.DATE_WIDGET;
		case NUMBER_WIDGET:
			return WIDGET_CATEGORY.NUMBER_WIDGET;
		case BOOL_WIDGET:
			return WIDGET_CATEGORY.BOOLEAN_WIDGET;
		case SINGLE_SELECT_WIDGET:
			return WIDGET_CATEGORY.SINGLE_SELECT_WIDGET;
		case MULTI_SELECT_WIDGET:
			return WIDGET_CATEGORY.MULTI_SELECT_WIDGET;
		case XTEXT_EDITOR:
			return WIDGET_CATEGORY.XTEXT_ELEMENT_EDITOR_WIDGET;
		case XTEXT_TEXT_EDITOR:
			return WIDGET_CATEGORY.XTEXT_TEXT_EDITOR_WIDGET;			
		case NAVIGATION_WIDGET:
			return WIDGET_CATEGORY.NAVIGATION_WIDGET;
		case FLEXIBLE_WIDGET:
			return WIDGET_CATEGORY.FLEXIBLE_WIDGET;	
		case OUTPUTTEXT_WIDGET:
			return WIDGET_CATEGORY.OUTPUTTEXT_WIDGET;							
		default:
			getLogger().logError("ConfigurationManagerHelper: unexpected WidgetCategory '" + widgetCategoyMDsl + "' assume category is " + WIDGET_CATEGORY.TEXT_WIDGET + ".");
			return WIDGET_CATEGORY.TEXT_WIDGET;
		}
	}
	

	
	
	/**
	 * discover value type using widget type or valueQuery result type.
	 * @param <T>
	 * @return
	 */
	public static Class<?> discoverWidgetValueType(WidgetConfigurationMdsl widgetConfigMdsl){		
		switch(widgetConfigMdsl.getWidgetCategory()){
		case TEXT_WIDGET:
			return String.class;				
		case DATE_WIDGET:
			return Date.class;
		case NUMBER_WIDGET:
			return Number.class;			
		case BOOL_WIDGET:
			return Boolean.class;
		case XTEXT_EDITOR:
			return EObject.class; 	
		case XTEXT_TEXT_EDITOR:
			return String.class; 			
		case SINGLE_SELECT_WIDGET:
			//EENum value type is Literal
			if(EEnum.class.isAssignableFrom(MadConfigDslUtil.resolveQueryReturnType(widgetConfigMdsl.getValueQuery()).getClass())){
				return Enum.class;
			}else{
				return EObject.class; // EmfToolsFacade.getInstance().eClassifierToClass(widgetConfigMdsl.getValueQuery().getReturnType()).getClass();				
			}
		case MULTI_SELECT_WIDGET:
			return Collection.class;
		case NAVIGATION_WIDGET:
			return Collection.class;
		case OUTPUTTEXT_WIDGET:
			return String.class;				
		default:
			return null;
		}
	}




	/**
	 * discover value type using widget type or valueQuery result type.
	 * @param <T>
	 * @return
	 */
	public static  Class<?> discoverCandidatesValueType(WidgetConfigurationMdsl widgetConfigMdsl){
		switch(widgetConfigMdsl.getWidgetCategory()){
		case TEXT_WIDGET:
			return String.class;
		case DATE_WIDGET:
			return Date.class;
		case NUMBER_WIDGET:
			return Number.class;
		case BOOL_WIDGET:
			return Boolean.class;
		case XTEXT_EDITOR:
			return EObject.class; 
		case XTEXT_TEXT_EDITOR:
			return String.class; 
		case SINGLE_SELECT_WIDGET:
			if(EEnum.class.isAssignableFrom(MadConfigDslUtil.resolveQueryReturnType(widgetConfigMdsl.getValueQuery()).getClass())){
				return EEnum.class;
			}else{
				return EObject.class;
			}
		case MULTI_SELECT_WIDGET:
			if(EEnum.class.isAssignableFrom(MadConfigDslUtil.resolveQueryReturnType(widgetConfigMdsl.getValueQuery()).getClass())){
				return EEnum.class;
			}else{
				return EObject.class; 
			}
		case NAVIGATION_WIDGET:
			if(EEnum.class.isAssignableFrom(MadConfigDslUtil.resolveQueryReturnType(widgetConfigMdsl.getCandidatesQuery()).getClass())){
				return EEnum.class;
			}else{
				return EObject.class;
			}
		default:
			return null;
		}
	}

	
	/**
	 * create a valueConverterConfiguration from a valueConverter mdsl
	 * 
	 * @param valueConverterMdsl mdsl valueconverter
	 * @return
	 */
	public static ValueConverterConfiguration createValueConverterConfigurationFromValueConverterMdsl(ValueConverter valueConverterMdsl){
		if(BasicTypeValueConverter.class.isAssignableFrom(valueConverterMdsl.getClass())){
			return new ValueConverterConfigurationImpl(
					ConfigurationManagerHelper.convertValueConverterCategory(((BasicTypeValueConverter)valueConverterMdsl).getCategory()), 
					((BasicTypeValueConverter)valueConverterMdsl).getConfiguration()
			);			
		}

		//TODO: create configuration for QueryBasedValueConverter
		if(QueryBasedValueConverter.class.isAssignableFrom(valueConverterMdsl.getClass())){
		}

		return null;
		
	}
	
	/**
	 * convert value converter category Mdsl to Mad value converter category
	 * @param converterCategotyMDsl
	 * @return
	 */
	public static VALUE_CONVERTER_CATEGORY convertValueConverterCategory(VALUE_CONVERTER_CATEGORY_MDSL converterCategotyMDsl) {
		switch(converterCategotyMDsl){
		case DATE:
			return VALUE_CONVERTER_CATEGORY.DATE_CONVERTER;
		case DATETIME:
			return VALUE_CONVERTER_CATEGORY.DATETIME_CONVERTER;
		case INTEGER:
			return VALUE_CONVERTER_CATEGORY.INTEGER_CONVERTER;
		case FLOAT:
			return VALUE_CONVERTER_CATEGORY.FLOAT_CONVERTER;
		case DOUBLE:
			return VALUE_CONVERTER_CATEGORY.DOUBLE_CONVERTER;
		case XTEXT:
			return VALUE_CONVERTER_CATEGORY.XTEXT_CONVERTER;
		default:
			if(converterCategotyMDsl != null){
				getLogger().logError("ConfigurationManagerHelper: unexpected value converter category '" + converterCategotyMDsl + "',  return null.");
			}
			return null;
		}
	}
	
	public static Class<?> getInputConverterType(ValueConverter valueConverterMdsl) {
		if(BasicTypeValueConverter.class.isAssignableFrom(valueConverterMdsl.getClass())){
		VALUE_CONVERTER_CATEGORY_MDSL converterCategotyMDsl = ((BasicTypeValueConverter) valueConverterMdsl).getCategory();
		switch(converterCategotyMDsl){
		case DATE:
			return Date.class;
		case DATETIME:
			return Date.class;
		case INTEGER:
			return Integer.class;
		case FLOAT:
			return Float.class;
		case DOUBLE:
			return Double.class;
		case XTEXT:
			return String.class;			
		default:
			if(converterCategotyMDsl != null){
				getLogger().logError("ConfigurationManagerHelper: unexpected value for converter category '" + converterCategotyMDsl + "',  return null.");
			}
			return null;
		}
		}else{
			return String.class;
		}
	}

	
	
	public static XtextLanguageDescription createDslDescription(XtextLanguageDescriptorMdsl dslDescriptorMdsl){
		if(dslDescriptorMdsl != null){
			return new XtextLanguageDescriptionImpl(dslDescriptorMdsl.getBundleId(), dslDescriptorMdsl.getActivatorClassName(), dslDescriptorMdsl.getLanguageId());
		}else{
			return null;
		}
	}

	
	
	/**
	 * Create and returns a UICommandDefinition from a UICommandMdsl
	 * @param uiCommandMdsl
	 * @return
	 */
	public static UICommandDefinition createUICommandDefinition(UICommandMdsl uiCommandMdsl, List<QueryDefinitionMdsl> preQueries){
		UICOMMAND_TYPE commandType = null;		
		QueryDefinition<?> findTargetQuery = null;
		Collection<String> targetsWidgetsIds = new ArrayList<String>();
		
		if(ReloadViewUICommand.class.isAssignableFrom(uiCommandMdsl.getClass())){
			commandType = UICOMMAND_TYPE.RELOAD_VIEW;
		}
				
		if(ReloadWidgetsUICommand.class.isAssignableFrom(uiCommandMdsl.getClass())){
			commandType = UICOMMAND_TYPE.RELOAD_WIDGETS;
			//add targets widgets ids
			for(WidgetConfigurationMdsl widgetConfigMdsl : ((ReloadWidgetsUICommand)uiCommandMdsl).getWidgetsToReload()){
				targetsWidgetsIds.add(MadConfigDslUtil.getWidgetConfigId(widgetConfigMdsl));
			}
		}

		if(DisplayViewUICommand.class.isAssignableFrom(uiCommandMdsl.getClass())){
			commandType = UICOMMAND_TYPE.DISPLAY_VIEW;
			DisplayViewUICommand displayViewUICommand = (DisplayViewUICommand)uiCommandMdsl;
			//resolve target query
			if(displayViewUICommand.getTarget() != null){
				//Value Query: 
				//create value query: type is valuetype
				List<QueryDefinitionMdsl> targetQueryMdsl = MadConfigDslUtil.resolveQueryUsage(displayViewUICommand.getTarget());
				if(targetQueryMdsl != null){
					findTargetQuery = QueryFactory.createQueryDefinition(targetQueryMdsl, EObject.class, RETURN_VALUE_OCCURENCE.SINGLE_VALUE, preQueries);							
				}

			}
		}

		UICommandDefinition uiCommandDef = new UICommandDefinitionImpl(commandType, findTargetQuery);
		uiCommandDef.getTargetsWidgetsIds().addAll(targetsWidgetsIds);		
		return uiCommandDef;
	}

	
	/**
	 * Build a format expression String by concatenation of all literals and macro expression fragments
	 * if is an I18N format expression then ouput string will be prefixed with the I18N prefix
	 * 
	 * @param formatExpr
	 * @param isI18N
	 * @return
	 */
	public static String createLiteralFormatExpression(FormatExpr formatExpr, boolean isI18N){
		return createLiteralFormatExpression(formatExpr, isI18N, null);
	}


	/**
	 * Build a format expression String by concatenation of all literals and macro expression fragments
	 * if is an I18N format expression then ouput string will be prefixed with the I18N prefix
	 * 
	 * @param formatExpr
	 * @param isI18N
	 * @param preQueries
	 * @return
	 */
	public static String createLiteralFormatExpression(FormatExpr formatExpr, boolean isI18N, List<QueryDefinitionMdsl> preQueries){
		if(formatExpr == null){
			return null;
		}
		return (isI18N ? ConfigurationManager.I18N_PREFIX : "") 
				+ MadConfigDslUtil.createLiteralFormatExpression(formatExpr);
	}

	
	/**
	 * Creates a validator definition from a ValidatorMdsl
	 * 
	 * @param validatorMdsl
	 * @return
	 */
	public static ValidatorDefinition createValidator(ValidatorMdsl validatorMdsl){
		//(validator works on the value no prequeries are needed)
		//create Query validation definition: a query returning a boolean value
		List<QueryDefinitionMdsl> validationQueriesMdsl = MadConfigDslUtil.resolveQueryUsage(validatorMdsl.getValidationQuery());
		QueryDefinition<Boolean> validationQuery = QueryFactory.createQueryDefinition(validationQueriesMdsl, Boolean.class, RETURN_VALUE_OCCURENCE.SINGLE_VALUE);
		//Create error message format expression
		String errorMessageFormatExpr = createLiteralFormatExpression(validatorMdsl.getErrorMessageExpr(), validatorMdsl.isI18NMessage());
		ValidatorDefinition validatorDef = new ValidatorDefinitionImpl(validationQuery, errorMessageFormatExpr); 
		return validatorDef;
	}

	
	
}
