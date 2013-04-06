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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.sysord.eclipse.tools.swt.ImageResource;
import com.sysord.mad.command.impl.CommandDefinitionImpl;
import com.sysord.mad.configuration.CommandDefinition;
import com.sysord.mad.configuration.Layer;
import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.configuration.ValidatorDefinition;
import com.sysord.mad.configuration.ValueConverterConfiguration;
import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.configuration.XtextLanguageDescription;
import com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.UICommandMdsl;
import com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl;
import com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;
import com.sysord.mad.configuration.util.MadConfigDslUtil;
import com.sysord.mad.configuration.util.MadConfigDslUtil.FormatExpressionDescriptor;
import com.sysord.mad.mao.MaoCommand;
import com.sysord.mad.query.QueryDefinition;
import com.sysord.mad.query.QueryDefinition.RETURN_VALUE_OCCURENCE;
import com.sysord.mad.query.impl.QueryFactory;
import com.sysord.mad.query.impl.SingleQueryDefinitionImpl;

public class WidgetConfigurationImpl<VT> implements WidgetConfiguration<VT> {

	protected WidgetConfigurationMdsl widgetConfigDsl;
	protected String id;
	protected String name;
	protected Class<VT> widgetValueType;
	protected Class<?> candidatesType;
	
	protected QueryDefinition<?> valueQuery;
	protected QueryDefinition<Collection<?>> candidatesQuery;
	protected String itemLabelExpression;
	
	protected QueryDefinition<Boolean> visibilityQuery;
	protected QueryDefinition<Boolean> editableQuery;

	protected ValueConverterConfiguration valueConverterConfiguration;

	protected String labelExpression;
	protected String format;

	protected String tabLabelExpression;

	
	protected List<Layer> layers = new ArrayList<Layer>();
	
	protected Map<String, CommandDefinition> widgetCommands = new LinkedHashMap<String, CommandDefinition>();
		
	/**
	 * type configuration template to be replicated
	 * in flexible widget
	 */
	protected TypeConfiguration flexibleTemplate;
	
	
	/**
	 * Xtext DSL language description used for localize bundle
	 * for Xtext Widgets
	 */
	protected XtextLanguageDescription xtextLanguageDescription;

	/**
	 * When widget is included with its template
	 * in another template ('includeWidget:' directive)
	 * the Query defined by include widget configuration must be
	 * used for relocate context in several cases: value, label, commands etc..
	 */	
	protected QueryDefinition<EObject> includeQuery;

	/**
	 * validators defined for the widget
	 */
	protected  List<ValidatorDefinition> validators = new ArrayList<ValidatorDefinition>();
	
	public WidgetConfigurationImpl(WidgetConfigurationMdsl widgetConfigDsl, Class<VT> widgetValueType) {
		this(widgetConfigDsl, widgetValueType, Object.class);
	}

	public WidgetConfigurationImpl(WidgetConfigurationMdsl widgetConfigDsl, Class<VT> widgetValueType, Class<?> candidatesValueType) {
		this(widgetConfigDsl, widgetValueType, Object.class, (TypeConfiguration)null, null);
	}

	/**
	 * Flexible widget configuration constructor
	 * 
	 * @param widgetConfigDsl
	 * @param widgetValueType
	 * @param candidatesValueType
	 * @param flexibleTemplate
	 */
	public WidgetConfigurationImpl(WidgetConfigurationMdsl widgetConfigDsl, Class<VT> widgetValueType, Class<?> candidatesValueType,
									TypeConfiguration flexibleTemplate, List<QueryDefinitionMdsl> preQueries) {
		super();
		this.widgetConfigDsl = widgetConfigDsl;
		this.widgetValueType = widgetValueType;
		this.candidatesType = candidatesValueType;
		this.flexibleTemplate = flexibleTemplate;
		this.id = MadConfigDslUtil.getWidgetConfigId(widgetConfigDsl); 
		this.name = widgetConfigDsl.getName();
		this.labelExpression = ConfigurationManagerHelper.createLiteralFormatExpression(widgetConfigDsl.getLabel(), 
																			widgetConfigDsl.isI18NLabel());
		this.format = ConfigurationManagerHelper.createLiteralFormatExpression(widgetConfigDsl.getValueFormat()
																			, widgetConfigDsl.isI18NFormat());
		createQueriesDefinitions(preQueries);
		createCommandsDefinition(preQueries);
		createValueConverterConfiguration();
		createXtextLanguageDescription();
		createValidatorsConfiguration();
	}

	
	@Override
	public boolean isIncludedWidget(){
		return includeQuery != null;		
	}
	
	@Override
	public QueryDefinition<EObject> getIncludeQuery() {
		return includeQuery;
	}


	@Override
	public boolean isFlexibleWidget(){
		return widgetConfigDsl.getWidgetCategory() == WIDGET_CATEGORY_MDSL.FLEXIBLE_WIDGET;  //flexibleTemplate != null;
	}

	
	@Override
	public TypeConfiguration getFlexibleTemplate() {
		return flexibleTemplate; 
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void createQueriesDefinitions(List<QueryDefinitionMdsl> preQueries){

		//Include Query: when widget is include create include query whith the include clause.
		if(preQueries != null && !preQueries.isEmpty()){
			includeQuery = QueryFactory.createQueryDefinition(preQueries, EObject.class, RETURN_VALUE_OCCURENCE.UNKNOW);										
		}
				
		RETURN_VALUE_OCCURENCE occurence = RETURN_VALUE_OCCURENCE.SINGLE_VALUE;
		//Widget Value Occurence: single value or list
		if(getWidgCategory() == WIDGET_CATEGORY.MULTI_SELECT_WIDGET || getWidgCategory() == WIDGET_CATEGORY.NAVIGATION_WIDGET || isFlexibleWidget()){
			occurence = RETURN_VALUE_OCCURENCE.VALUES_LIST;		
		}
		
		//Value Query: 
		//create value query: type is valuetype
		List<QueryDefinitionMdsl> valueQueryMdsl = MadConfigDslUtil.resolveQueryUsage(widgetConfigDsl.getValueQuery());
		if(valueQueryMdsl != null){
			//TextWidget input or output can use a ValueConverte. discover query value type from its converter
			Class<?> queryValueType = widgetValueType;
			if((getWidgCategory() == WIDGET_CATEGORY.TEXT_WIDGET || getWidgCategory() == WIDGET_CATEGORY.OUTPUTTEXT_WIDGET) && widgetConfigDsl.getValueConverter() != null){
				queryValueType = ConfigurationManagerHelper.getInputConverterType(widgetConfigDsl.getValueConverter());
			}
			//output text widget can use a value formatter. we can't discover query return type
			if(widgetConfigDsl.getValueFormat() != null){
				queryValueType = null;
			}
			valueQuery = QueryFactory.createQueryDefinition(valueQueryMdsl, queryValueType, occurence, preQueries);							
		}
		
		
		//Candidates Query: 
		//create candidates query: type is List of candidate type
		List<QueryDefinitionMdsl> candidatesQueryMdsl = null;
		if((getWidgCategory() == WIDGET_CATEGORY.SINGLE_SELECT_WIDGET || getWidgCategory() == WIDGET_CATEGORY.MULTI_SELECT_WIDGET
		        || getWidgCategory() == WIDGET_CATEGORY.NAVIGATION_WIDGET) && widgetConfigDsl.getCandidatesQuery() != null) {
			candidatesQueryMdsl = MadConfigDslUtil.resolveQueryUsage(widgetConfigDsl.getCandidatesQuery());
			if(candidatesQueryMdsl != null){
				candidatesQuery = QueryFactory.createQueryDefinition(candidatesQueryMdsl, Collection.class, RETURN_VALUE_OCCURENCE.VALUES_LIST, preQueries);
			}
		}
		

		//Item label expression: 
		if(widgetConfigDsl.getItemLabelExpression() != null){
			itemLabelExpression = ConfigurationManagerHelper.createLiteralFormatExpression(
							widgetConfigDsl.getItemLabelExpression(),
							widgetConfigDsl.isI18NItemLabel());
		}
		
		//Create visibility Query condition 
		if(widgetConfigDsl.getVisibilityQuery() != null){
			QueryDefinitionMdsl visibilityQueryDefMdsl = MadConfigDslUtil.resolveQuery(widgetConfigDsl.getVisibilityQuery());
			if(preQueries != null){
				List<QueryDefinitionMdsl> visibilityQueryMdsl = new ArrayList<QueryDefinitionMdsl>();
				visibilityQueryMdsl.addAll(preQueries);
				visibilityQueryMdsl.add(visibilityQueryDefMdsl);				
				visibilityQuery = QueryFactory.createQueryDefinition(visibilityQueryMdsl, Boolean.class, RETURN_VALUE_OCCURENCE.SINGLE_VALUE);			
			}else{
				visibilityQuery = QueryFactory.createSingleQueryDefinition(visibilityQueryDefMdsl, Boolean.class, RETURN_VALUE_OCCURENCE.SINGLE_VALUE);
			}
		}
		
		//Create editable Query condition 
		if(widgetConfigDsl.getEditableQuery() != null){
			QueryDefinitionMdsl editableQueryDefMdsl = MadConfigDslUtil.resolveQuery(widgetConfigDsl.getEditableQuery());
			if(preQueries != null){
				List<QueryDefinitionMdsl> editableQueryMdsl = new ArrayList<QueryDefinitionMdsl>();
				editableQueryMdsl.addAll(preQueries);
				editableQueryMdsl.add(editableQueryDefMdsl);				
				editableQuery = QueryFactory.createQueryDefinition(editableQueryMdsl, Boolean.class, RETURN_VALUE_OCCURENCE.SINGLE_VALUE);			
			}else{
				editableQuery = QueryFactory.createSingleQueryDefinition(editableQueryDefMdsl, Boolean.class, RETURN_VALUE_OCCURENCE.SINGLE_VALUE);				
			}
		}
		
	}
	

	/**
	 * create and store commandDefinition built from commandDefinitionMdsl
	 */
	protected void createCommandsDefinition(List<QueryDefinitionMdsl> preQueries){
		String commandId;
		for(CommandMdsl commandMdsl : widgetConfigDsl.getCommands()){
			
			CommandDefinitionMdsl commandDefinitionMdsl = MadConfigDslUtil.resolveCommand(commandMdsl);
			FormatExpressionDescriptor formatExprInfos = MadConfigDslUtil.resolveCommandLabelExpression(commandMdsl);			
			String commandLabelExpr = ConfigurationManagerHelper.createLiteralFormatExpression(
											formatExprInfos.formatExpr, 
											formatExprInfos.isI18N);	
			
			if(commandDefinitionMdsl.getCategory() == COMMAND_CATEGORY_MDSL.UPDATE_COMMAND){
				commandId = MaoCommand.UPDATE_COMMAND;
			}else{
				commandId =  getId() + "__" + commandLabelExpr.replace(' ', '.');				
			}
			CommandDefinition commandDef = new CommandDefinitionImpl(commandId, commandDefinitionMdsl, 
														preQueries, commandLabelExpr);

			//create on success uiCommands
			for(UICommandMdsl uiCommandMdsl : commandDefinitionMdsl.getOnActionSuccessUICommands()){
				commandDef.getOnSuccessPostActionCommands().add(ConfigurationManagerHelper.createUICommandDefinition(uiCommandMdsl, preQueries));
			}

			//create on error uiCommands
			for(UICommandMdsl uiCommandMdsl : commandDefinitionMdsl.getOnActionErrorUICommands()){
				commandDef.getOnErrorPostActionCommands().add(ConfigurationManagerHelper.createUICommandDefinition(uiCommandMdsl, preQueries));
			}

			widgetCommands.put(commandId, commandDef);
		}
	}
	

	
	
	protected void createValueConverterConfiguration() {
		if(widgetConfigDsl.getValueConverter() != null){
			valueConverterConfiguration = ConfigurationManagerHelper.createValueConverterConfigurationFromValueConverterMdsl(widgetConfigDsl.getValueConverter());			
		}
	}
	
	
	protected void createXtextLanguageDescription(){
		if(widgetConfigDsl.getDslReference() != null){
			xtextLanguageDescription = ConfigurationManagerHelper.createDslDescription(widgetConfigDsl.getDslReference().getXtextLanguageDescriptor());
		}
	}
	
	protected void createValidatorsConfiguration() {
		for(ValidatorMdsl validatorMdsl : widgetConfigDsl.getValidators()){
			validators.add(ConfigurationManagerHelper.createValidator(validatorMdsl));
		}
	}

	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public Class<VT> getWidgetValueType() {
		return widgetValueType;
	}

	public Class<?> getCandidatesType() {
		return candidatesType;
	}

	
	@Override
	public String getLabel() {
		return labelExpression;
	}

	@Override
	public WIDGET_CATEGORY getWidgCategory() {
		return ConfigurationManagerHelper.convertWidgetCategory(widgetConfigDsl.getWidgetCategory());
	}

	@Override
	public String getWidgetType(){
		return widgetConfigDsl.getWidgetType() == null ? "" : widgetConfigDsl.getWidgetType().getName();
	}

		
	@Override
	public String getTabId() {
		if(widgetConfigDsl.getUiTab() != null){
			return widgetConfigDsl.getUiTab().getName();
		}else{
			return DEFAULT_UI_TAB_ID;
		}
	}

	@Override
	public String getTabLabel() {
		if(widgetConfigDsl.getUiTab() != null){
			if(tabLabelExpression == null){
				tabLabelExpression = ConfigurationManagerHelper.createLiteralFormatExpression(
										widgetConfigDsl.getUiTab().getLabelFormatExpr(),
										widgetConfigDsl.getUiTab().isI18NLabel()
									);
			}
			return tabLabelExpression;
		}else{
			return DEFAULT_UI_TAB_LABEL;
		}
	}

	@Override
	public QueryDefinition<Boolean> getVisibilityQuery() {
		return visibilityQuery;
	}

	@Override
	public QueryDefinition<Boolean> getEditableQuery() {
		return editableQuery;
	}

	
	@Override
	public List<Layer> getLayers() {
		return layers;
	}

	@Override
	public QueryDefinition<?> getValueQuery() {
		return valueQuery;
	}

	@Override
	public QueryDefinition<Collection<?>> getCandidatesQuery() {
		return candidatesQuery;
	}

	@Override
	public ValueConverterConfiguration getValueConverterConfiguration() {
		return valueConverterConfiguration;
	}

	
	
	@Override
	public List<ValidatorDefinition> getValidators() {
		return validators;
	}

	@Override
	public String getFormat() {
		return format;
	}
	
	@Override
	public String getItemLabelExpression() {
		return itemLabelExpression;
	}


	@Override
	public String toString() {
		return "WidgetConfigurationImpl [\nwidgetConfigDsl=" + widgetConfigDsl
				+ ", \nwidgetValueType=" + widgetValueType + ", \nvalueQuery="
				+ valueQuery + ", \ncandidatesQuery=" + candidatesQuery
				+ ", \nitemLabelQuery=" + itemLabelExpression + "]\n";
	}

	@Override
	public Collection<CommandDefinition> getWidgetCommands() {
		return widgetCommands.values();
	}

	@Override
	public CommandDefinition getWidgetCommand(String commandId) {
		return widgetCommands.get(commandId);
	}

	@Override
	public XtextLanguageDescription getXtextWidgetLanguageDescriptor() {
		return xtextLanguageDescription;
	}
	

}
