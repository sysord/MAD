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
package com.sysord.mad.mao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.Inject;
import com.sysord.eclipse.tools.diagnostic.DiagnosticFactory;
import com.sysord.eclipse.tools.nls.I18nService;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.emf.tools.misc.EMFImageProvider;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.configuration.Layer;
import com.sysord.mad.configuration.LayerManager;
import com.sysord.mad.configuration.TypeConfiguration;
import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.configuration.WidgetConfiguration.WIDGET_CATEGORY;
import com.sysord.mad.core.Activator;
import com.sysord.mad.emitter.ViewBuilder;
import com.sysord.mad.emitter.impl.ComposedWidgetConfigurer;
import com.sysord.mad.evaluator.EvaluationAnalyze;
import com.sysord.mad.evaluator.FormatExpressionEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.mao.MaoCommand;
import com.sysord.mad.mao.ValuedSemanticElement;
import com.sysord.mad.mao.ValuedSemanticElement.ACCESS_CATEGORY;
import com.sysord.mad.model.cache.ModelCache;
import com.sysord.mad.query.QueryDefinition;
import com.sysord.mad.query.impl.MADQueryUtil;
import com.sysord.mad.widget.AbstractWidgetVisitor;
import com.sysord.mad.widget.Candidate;
import com.sysord.mad.widget.ComposedWidget;
import com.sysord.mad.widget.ElementDslWidget;
import com.sysord.mad.widget.FlexibleWidget;
import com.sysord.mad.widget.InputWidget;
import com.sysord.mad.widget.ListWidget;
import com.sysord.mad.widget.NavigationWidget;
import com.sysord.mad.widget.OutputWidget;
import com.sysord.mad.widget.TextDslWidget;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.CandidateImpl;

/**
 * Fill widget value 
 *
 */
public class LoadWidgetValueVisitor extends AbstractWidgetVisitor<Boolean> {

	@Inject
	protected ConfigurationManager configurationManager;

    @Inject
    protected EMFImageProvider itemProvider;

	@Inject
	protected LayerManager layerManager;

	@Inject
	protected QueryEvaluationService evaluationService;

	@Inject
	protected FormatExpressionEvaluationService formatExprEvaluationService;
	
	@Inject
	protected ViewBuilder viewBuilder;

	@Inject
	protected MadWidgetCommandFactory madCommandFactory;

	@Inject 
	protected ConsoleLogger logger;
	
	@Inject
	I18nService i18NService;
	
	/**
	 * Model chache is used for discover foreign model elements
	 */
	@Inject ModelCache modelCache;
	
	
	//@Override
	public <T> Boolean visit(OutputWidget<T> outputWidget) {

		//evaluate visibility
		if(setWidgetVisibility(outputWidget) == false){
			return true; //if not visible stop the load value process by returning true (switch behaviour).
		}

		Map<String, Object>  arguments = new HashMap<String, Object>();
		arguments.put(QueryEvaluationService.MAIN_CONTEXT__IDENTIFIER, outputWidget.getContextElement());

		//evaluate valueQuery
		//TODO: could use evaluation without analyze
		EvaluationAnalyze analyze = evaluateWithAnalyzeQuery(outputWidget.getContextElement(), outputWidget.getConfig().getValueQuery(), MADQueryUtil.createArguments(outputWidget));		
		Object ouputValue = analyze.getConvertedResultValue();
		
		//apply format if defined
		if(outputWidget.getConfig().getFormat() != null && !"".equals(outputWidget.getConfig().getFormat().trim())){
			//apply format on the value. 
			ouputValue = formatValue(ouputValue, outputWidget.getConfig().getFormat());
		}
		
		//create element description
		ValuedSemanticElement valuedElement = createValuedSemanticElement(outputWidget, analyze, ouputValue);
		
		//affect value
		outputWidget.setValuedSemanticElement(valuedElement);

		//eval label
		evalWidgetLabel(outputWidget);

		madCommandFactory.createWidgetCommands(outputWidget);

		return true;
	}


	/**
	 * Set the value for all InputWidget
	 */
	@Override
	public <T> Boolean visit(InputWidget<T> inputWidget) {

		//evaluate visibility
		if(setWidgetVisibility(inputWidget) == false){
			return true; //if not visible stop the load value process by returning true (switch behaviour).
		}

		//evaluate editability
		setWidgetEditability(inputWidget);

		//evaluate valueQuery with widget arguments      
		EvaluationAnalyze analyze = evaluateWithAnalyzeQuery(inputWidget.getContextElement(), inputWidget.getConfig().getValueQuery(), 
															MADQueryUtil.createArguments(inputWidget));
		//create element description
		ValuedSemanticElement valuedElement = createValuedSemanticElement(inputWidget, analyze, null);

		//affect value
		inputWidget.setValuedSemanticElement(valuedElement);

		//eval label
		evalWidgetLabel(inputWidget);

		madCommandFactory.createWidgetCommands(inputWidget);
		//Update command
		if(inputWidget.isEditable() && !madCommandFactory.createUpdateCommand(inputWidget)){
			//If none update command has been created put a warning and set the widget not editable
			setNoUpdateCommandWarning(inputWidget);
		}

		return true;
	}

	
	/**
	 * load widget value + fill candidates for all ListWidget
	 */
	@Override
	public <T> Boolean visit(ListWidget<T> listWidget) {

		//Load value
		visit((InputWidget<T>)listWidget);

		if(!listWidget.isVisible()){
			return true; //if not visible stop the load value
		}

		boolean addNullItem = (listWidget.getConfig().getWidgCategory() == WIDGET_CATEGORY.SINGLE_SELECT_WIDGET);
		List<Candidate> candidates = createCandidates(listWidget.getContextElement(), listWidget.getConfig(), listWidget, addNullItem);
		listWidget.setCandidates(candidates);

		return true;
	}


	/**
	 * fill candidates for Navigation widget
	 */
	@Override
	public Boolean visit(NavigationWidget navigationWidget) {
		//evaluate visibility
		if(setWidgetVisibility(navigationWidget) == false){
			return true; //stop the load value
		}

		List<Candidate> candidates = createCandidates(navigationWidget.getContextElement(), navigationWidget.getConfig(), navigationWidget, false);
		navigationWidget.setCandidates(candidates);
		//evaluate valueQuery       
		EvaluationAnalyze analyze = evaluateWithAnalyzeQuery(navigationWidget.getContextElement(), navigationWidget.getConfig().getCandidatesQuery(), MADQueryUtil.createArguments(navigationWidget));
		//create element description
		ValuedSemanticElement valuedElement = createValuedSemanticElement(navigationWidget, analyze, null);
		//affect value
		navigationWidget.setValuedSemanticElement(valuedElement);

		//eval label
		evalWidgetLabel(navigationWidget); 

		// Create commands (item commands will be redefined after)
		madCommandFactory.createWidgetCommands(navigationWidget);
				
		// Navigation command
		madCommandFactory.createNavigationCommand(navigationWidget);
				
		return true;
	}



	/**
	 * Simple format expression evaluation without argument or widget
	 * format expression is a String composed of constant parts and evaluable parts between []
	 * if widget is an included widget, the evaluation context will be relocated using the include query.
	 * @param contextElement
	 * @param formatExpr
	 * @return
	 */
	protected String formatValue(Object contextElement, String formatExpr) {
		return formatValue(contextElement, formatExpr, new HashMap<String, Object>());
	}

	/**
	 * Evaluate the format expression
	 * format expression is a String composed of const part and evaluable parts between []
	 * 
	 * @param contextElement
	 * @param formatExpr
	 * @param widget
	 * @param adaptIncludedWidget when true if widget is an included widget, 
	 * 		the evaluation context will be relocated using the include query.
	 * @return
	 */
	protected String formatValue(Object contextElement, String formatExpr, Widget<?> widget) {
		try {
			Map<String, Object> arguments = MADQueryUtil.createArguments(widget);
			EObject evalContext = widget.getContextElement();
			if(widget.getConfig().isIncludedWidget()){
				//relocate context using include query if widget is an included widget.
				evalContext = evaluateQuery(evalContext, widget.getConfig().getIncludeQuery(), arguments);
			}
			return formatValue(evalContext, formatExpr, arguments);
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError(e);
			return "ERROR:" + formatExpr;
		}
	}
	
	/**
	 * Evaluate the format expression
	 * format expression is a String composed of const part and evaluable parts between []
	 * 
	 * @param evalContext
	 * @param formatExpr
	 * @param arguments
	 * @return
	 */
	protected String formatValue(Object evalContext, String formatExpr, Map<String, Object> arguments){
		try {
			return formatExprEvaluationService.evaluateFormatExpression(evalContext, formatExpr, arguments);
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError(e);
			return "ERROR:" + formatExpr;
		}		
	}


	
	/**
	 * Create candidates list
	 * 
	 * @param defaultContext
	 * @param widgetConfigMdsl
	 * @param widget
	 * @return
	 */
	protected <T> List<Candidate> createCandidates(EObject defaultContext, WidgetConfiguration<T> widgetConfigMdsl, Widget<T> widget, boolean createNullItem){
		List<Candidate> lCandidates = new ArrayList<Candidate>();

		Collection<?> candidateValues = (Collection<?>) evaluateQuery(defaultContext, widgetConfigMdsl.getCandidatesQuery(), MADQueryUtil.createArguments(widget));

		//Candidates Conversion (from EEnumLiteral to Enum)
		//Discover EnumClass
		Class<?> enumInstanceClass = null;
		if(widgetConfigMdsl.getWidgetValueType().equals(Enum.class)){
			enumInstanceClass = widget.getValuedSemanticElement().getFeatureOrOperation().getEType().getInstanceClass();
		}

		//null candidate value
		if (createNullItem) {
			lCandidates.add(new CandidateImpl("", null));
		}

		for(Object candValue : candidateValues){

			//Eval label
			String candidateLabel;
			if(widgetConfigMdsl.getItemLabelExpression() != null){
				candidateLabel = formatValue(candValue, widgetConfigMdsl.getItemLabelExpression());
			}else{
				candidateLabel = getItemLabel((EObject) candValue, widget);
			}

			//Convert candidate (from EEnumLiteral to Enum)
			//XXX: should be improved 
			if(enumInstanceClass != null){
				try {
					//convert Candvalue: get enum by name using static emf generated method: getByName
					candValue = enumInstanceClass.getMethod("getByName", String.class).invoke(widget.getValuedSemanticElement().getFeatureOrOperation().getEType(), ((EEnumLiteral)candValue).getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			lCandidates.add(new CandidateImpl(candidateLabel, candValue));
		}
		
		return lCandidates;     
	}


	/**
	 * Retrieves label for an element.
	 * if a label provider is defined for the element, uses this label provider
	 * else use the itemProviderAdapter for retrieving the label.
	 * if none label has been provided returns the element toString()
	 * 
	 * @param element
	 * @return label 
	 */
	protected String getItemLabel(EObject contextElement, Widget<?> widget){
		String label = null;
		if(contextElement == null){
			return "null";
		}
		String labelProviderExpr = configurationManager.getLabelProviderExpressionForType(contextElement.eClass());
		if(labelProviderExpr != null){
			label = formatValue(contextElement, labelProviderExpr);
		}else{
			//use itemProviderAdapter (genModel definition)
			label = itemProvider.getLabelFor(contextElement);
		}
		if(label == null){
			label = contextElement.toString();                          		
		}

		return label;
	}


	/**
	 * ComposedWidgetConfigurer: create and adds widget from
	 * Composed value type configuration. 
	 */
	protected ComposedWidgetConfigurer composedWidgetConfigurer;
	protected ComposedWidgetConfigurer getComposedWidgetConfigurer(){
		if(composedWidgetConfigurer == null){
			composedWidgetConfigurer = Activator.getDefault().getInjector().getInstance(ComposedWidgetConfigurer.class);
		}
		return composedWidgetConfigurer;
	}

	/**
	 * 
	 */
	@Override
	public <T> Boolean visit(FlexibleWidget<T> flexibleWidget) {

		//evaluate visibility
		if(setWidgetVisibility(flexibleWidget) == false){
			return true; //if not visible stop the load value
		}
		//evaluate editability
		//setWidgetEditability(flexibleWidget);

		evalWidgetLabel(flexibleWidget);

		//evaluate ValueQuery  (get all items)     
		EvaluationAnalyze analyze = evaluateWithAnalyzeQuery(flexibleWidget.getContextElement(), flexibleWidget.getConfig().getValueQuery(), MADQueryUtil.createArguments(flexibleWidget));
		//Convert value to collection
		Object valueResult = analyze.getConvertedResultValue();
		Collection<Object> collflexibleWidgetValues = null;
		if(valueResult != null && Collection.class.isAssignableFrom(valueResult.getClass())){
			collflexibleWidgetValues = (Collection<Object>) valueResult;
		}else{
			collflexibleWidgetValues = new ArrayList<Object>();
			collflexibleWidgetValues.add(valueResult);    		
		}			

		//Create element description
		//XXX: create smart choice for ValuedSemanticElementImpl element.
//		ValuedSemanticElement valuedElement = new ValuedSemanticElementImpl(flexibleWidget.getContextElement(), 
//												isForeignModelElement(flexibleWidget.getContextElement(), analyze)
//												, analyze.getAccessCategory(),
//												analyze.getFeatureOrOperation(), collflexibleWidgetValues);
		
		ValuedSemanticElement valuedElement = createValuedSemanticElement(flexibleWidget, analyze, collflexibleWidgetValues);
		//affect value
		flexibleWidget.setValuedSemanticElement(valuedElement);


		TypeConfiguration flexibleTemplate = flexibleWidget.getConfig().getFlexibleTemplate();
		String flexibleTemplateLabelProviderExpr = null;

		//For each flexible value create composed with valued element.
		for(Object composedItem : collflexibleWidgetValues){
			ValuedSemanticElement composedValuedElement = new ValuedSemanticElementImpl((EObject)composedItem,
															isForeignModelElement((EObject)composedItem, analyze)
															,ACCESS_CATEGORY.NONE, null, (EObject)composedItem);
			
			ComposedWidget<T> composedWidget = flexibleWidget.createComposedWidget(composedValuedElement);
			Boolean existsLabelProviderForFlexibleTemplate = null;
			//Label
			if(flexibleWidget.getConfig().getItemLabelExpression() != null){
				//label provider: configuration for all flexible items
				composedWidget.setLabel(formatValue(composedValuedElement.getValue() ,flexibleWidget.getConfig().getItemLabelExpression()));
			}else {

				//label provider: load and use label provider defined in the type configuration of the flexibleTemplate
				if(flexibleTemplate != null){
					if(existsLabelProviderForFlexibleTemplate == null){
						//try getting the label provider
						flexibleTemplateLabelProviderExpr = configurationManager.getLabelProviderExpressionForType(flexibleTemplate.getType());
						existsLabelProviderForFlexibleTemplate = (flexibleTemplateLabelProviderExpr != null);
					}            		
				}else{
					//label provider: flexible item type is dynamic, try to get the label provider for the item type
					if(composedValuedElement.getValue() != null){
						flexibleTemplateLabelProviderExpr = configurationManager.getLabelProviderExpressionForType(((EObject)composedValuedElement.getValue()).eClass());						
					}
				}

				if(flexibleTemplateLabelProviderExpr != null){
					composedWidget.setLabel(formatValue(composedValuedElement.getValue(), flexibleTemplateLabelProviderExpr));
				}

			}

			//if dynamic template: template retrieve from value type
			//Create widgets configuration for value type
			if(flexibleTemplate == null){
				getComposedWidgetConfigurer().configureComposedWidget(composedWidget);
			}

			//fill value for composed widget
			visit(composedWidget);
		}

		madCommandFactory.createGlobalCommands(flexibleWidget);

		return true;
	}



	@Override
	public <T> Boolean visit(ComposedWidget<T> composedWidget) {
		//evaluate visibility
		if(setWidgetVisibility(composedWidget) == false){
			return true; //if not visible stop the load value
		}

		for(Widget<?> widget : composedWidget.getWidgets()){
			widget.accept(this);
		}
		madCommandFactory.createWidgetCommands(composedWidget);
		return true;
	}



	/**
	 * load value for a Xtext element editor
	 */
	@Override
	public  Boolean visit(ElementDslWidget elementDslWidget) {
		visit((InputWidget<EObject>) elementDslWidget);
		
		if(!elementDslWidget.isVisible()){
			return true; //if not visible stop the load value
		}
		
		//if not exists specific update command use it:
		//Override standard update command with Xtext element specific update command
		if(elementDslWidget.getConfig().getWidgetCommand(MaoCommand.UPDATE_COMMAND) == null){
			if(elementDslWidget.isEditable() && !madCommandFactory.createXtextElementUpdateCommand(elementDslWidget)){
				setNoUpdateCommandWarning(elementDslWidget);
			}
		}
		return true;
	}

	
	/**
	 * load value for a text to be edited in a Xtext editor
	 */
	@Override
	public Boolean visit(TextDslWidget textDslWidget) {
		visit((InputWidget<String>) textDslWidget);
		
		if(!textDslWidget.isVisible()){
			return true; //if not visible stop the load value
		}

		//if not exists specific update command use it:
		//Override standard update command with Xtext element specific update command
		if(textDslWidget.getConfig().getWidgetCommand(MaoCommand.UPDATE_COMMAND) == null){
			//createXtextElementUpdateCommand(elementDslWidget);			
		}
		return true;
	}


	/**
	 * Put a diagnostic for declaring that an input widget have no update command
	 * widget editability is also set to false
	 * @param widget
	 */
	protected <T> void setNoUpdateCommandWarning(InputWidget<T> widget){
		widget.setEditable(false);
		widget.setStatus(DiagnosticFactory.createWarningDiagnostic("No update command"));
	}

	/**
	 * Create a valuedSemanticElement from analyze and widget context.
	 * if analyze provide a result context then use analyze information
	 * otherwise choose the widget context as the valuedSemanticElement element.
	 * 
	 * @param widget 
	 * @param analyze 
	 * @param value can be null, if provided override the analyze converted value.
	 * @return
	 */
	protected <T> ValuedSemanticElement createValuedSemanticElement(Widget<T> widget, EvaluationAnalyze analyze, Object value){
		//value not provided: use the analyze result
		if(value == null){
			value = analyze.getConvertedResultValue();
		}
		
		ValuedSemanticElement valuedElement;
		boolean isForeignModel = isForeignModelElement(widget.getContextElement(), analyze);
		if(analyze.getResultContext() != null && EObject.class.isAssignableFrom(analyze.getResultContext().getClass())){
			//analyze provide a result context
			valuedElement = new ValuedSemanticElementImpl(
					(EObject)analyze.getResultContext(), isForeignModel,
					analyze.getAccessCategory(), analyze.getFeatureOrOperation(), 
					value);			
		}else{
			//analyze doesn't provide a result context: use widget context as context element
			//no access category is defined
			valuedElement = new ValuedSemanticElementImpl(
					widget.getContextElement(), isForeignModel,
					ACCESS_CATEGORY.NONE, null, value);			
		}
		
		return valuedElement;
	}
	
	
	/**
	 * If the widget has layers definition at least one of the layers must be selected otherwise visibility is set to false.
	 * when visibility is true and the widget provide a visibility query then evaluate the query and set the result as visible property.
	 * @param widget
	 * @return the widget visibility
	 */
	protected <T> boolean setWidgetVisibility(Widget<T> widget){
		boolean widgetVisibility = false;
		if(widget.getConfig().getLayers().isEmpty()){
			widgetVisibility  =  true;
		}else{
			for(Layer layer : widget.getConfig().getLayers()){
				if(layerManager.isLayerSelected(layer)){
					widgetVisibility  =  true;
				}
			}			
		}
		
		if(widgetVisibility && widget.getConfig().getVisibilityQuery() != null){
			widgetVisibility = evaluateQuery(widget.getContextElement(), widget.getConfig().getVisibilityQuery(), MADQueryUtil.createArguments(widget));			
		}
		widget.setVisible(widgetVisibility);
		return widgetVisibility;
	}

	/**
	 * If the widget provide a editable query then evaluate the query and set the result as editable property.
	 * otherwise set editable to true
	 * @param widget
	 * @return the widget visibility
	 */
	protected <T> boolean setWidgetEditability(InputWidget<T> widget){
		boolean widgetEditability  =  true;
		if(widget.getConfig().getEditableQuery() != null){
			widgetEditability  = evaluateQuery(widget.getContextElement(), widget.getConfig().getEditableQuery(), MADQueryUtil.createArguments(widget));			
		}
		widget.setEditable(widgetEditability);
		return widgetEditability ;
	}


	/**
	 * Label have to be evaluated by the type configuration label provider
	 */
	protected static final String PROVIDER__LABEL_TAG = "@Provider";
	

	/**
	 * Label is a format expression.
	 * evaluates this format expression. 
	 * @param widget
	 */
	protected <T> void evalWidgetLabel(Widget<T> widget){
		try {
			String labelValue = null;
			//formatValue			
			if(PROVIDER__LABEL_TAG.equalsIgnoreCase(widget.getLabel())){
				labelValue = getItemLabel(widget.getContextElement(), widget);
			}else{
				//Format the label value built with const parts and evaluable parts (queries between []).
				labelValue = formatValue(widget.getContextElement(), widget.getLabel(), widget);
			}
			
			//if label value has been computed set the label value
			if(labelValue != null){
				widget.setLabel(labelValue);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	/**
	 * Internal Query evaluation
	 * 
	 * @param defaultContext
	 * @param queryDefinition
	 * @return
	 */
	protected <T> T evaluateQuery(EObject defaultContext, QueryDefinition<T> queryDefinition, Map<String, Object> arguments){
		try {
			return evaluationService.evaluate(defaultContext, queryDefinition, arguments);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Internal Query + analyze evaluation
	 * 
	 * @param defaultContext
	 * @param queryDefinition
	 * @param arguments TODO
	 * @return
	 */
	protected <T> EvaluationAnalyze evaluateWithAnalyzeQuery(EObject defaultContext, QueryDefinition<T> queryDefinition, Map<String, Object> arguments){
		try {
			return evaluationService.evaluateWithAnalyze(defaultContext, queryDefinition, arguments);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected <T> Object evaluateQueryExpression(EObject defaultContext, String languageId, String queryExpression, Map<String, Object> arguments){
		try {
			return evaluationService.evaluateExpression(defaultContext, languageId, queryExpression, arguments);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * return true if element is owned by a foreign model.
	 * if resultAnalyze element resource is stored in cache: assume that element is owned by a foreign model. 
	 * @param orgContext
	 * @param resultAnalyze
	 * @return
	 */
	protected boolean isForeignModelElement(EObject orgContext, EvaluationAnalyze resultAnalyze ){
//		if(orgContext == null || resultAnalyze.getResultValue() == null || resultAnalyze.getResultContext() == null){
//			//can't determine
//			return false;
//		}
				
		Resource resultResource = null;
		if(resultAnalyze.getResultValue() != null && EObject.class.isAssignableFrom(resultAnalyze.getResultValue().getClass())){
			resultResource  = ((EObject)resultAnalyze.getResultValue()).eResource();
		}
		
		if(resultAnalyze.getResultContext() != null && EObject.class.isAssignableFrom(resultAnalyze.getResultContext().getClass())){		
			resultResource  = ((EObject)resultAnalyze.getResultContext()).eResource();			
		}
		
		if(resultResource  == null){
			//can't determine
			return false;
		}

		return modelCache.getModel(resultResource.getURI()) != null;
	}


}
