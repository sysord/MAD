/*
* generated by Xtext
*/
package com.sysord.mad.configuration.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import com.sysord.mad.configuration.services.MadConfigDslGrammarAccess;

public class MadConfigDslParser extends AbstractContentAssistParser {
	
	@Inject
	private MadConfigDslGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected com.sysord.mad.configuration.ui.contentassist.antlr.internal.InternalMadConfigDslParser createParser() {
		com.sysord.mad.configuration.ui.contentassist.antlr.internal.InternalMadConfigDslParser result = new com.sysord.mad.configuration.ui.contentassist.antlr.internal.InternalMadConfigDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getMADConfigElementAccess().getAlternatives(), "rule__MADConfigElement__Alternatives");
					put(grammarAccess.getPropValueExprFragmentAccess().getAlternatives(), "rule__PropValueExprFragment__Alternatives");
					put(grammarAccess.getIconDescriptorMdslAccess().getAlternatives_3(), "rule__IconDescriptorMdsl__Alternatives_3");
					put(grammarAccess.getI18NBundleMdslAccess().getAlternatives_3(), "rule__I18NBundleMdsl__Alternatives_3");
					put(grammarAccess.getModelProviderMdslAccess().getAlternatives(), "rule__ModelProviderMdsl__Alternatives");
					put(grammarAccess.getTypeConfigurationTemplateElementAccess().getAlternatives(), "rule__TypeConfigurationTemplateElement__Alternatives");
					put(grammarAccess.getValueConverterAccess().getAlternatives(), "rule__ValueConverter__Alternatives");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getAlternatives_12_0(), "rule__WidgetConfigurationMdsl__Alternatives_12_0");
					put(grammarAccess.getCommandAccess().getAlternatives(), "rule__Command__Alternatives");
					put(grammarAccess.getUICommandMdslAccess().getAlternatives(), "rule__UICommandMdsl__Alternatives");
					put(grammarAccess.getQueryUsageAccess().getAlternatives(), "rule__QueryUsage__Alternatives");
					put(grammarAccess.getQueryAccess().getAlternatives(), "rule__Query__Alternatives");
					put(grammarAccess.getQueryDefinitionMdslAccess().getAlternatives_3(), "rule__QueryDefinitionMdsl__Alternatives_3");
					put(grammarAccess.getQueryFragmentAccess().getAlternatives(), "rule__QueryFragment__Alternatives");
					put(grammarAccess.getFormatExprFragmentAccess().getAlternatives(), "rule__FormatExprFragment__Alternatives");
					put(grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getAlternatives(), "rule__VALUE_CONVERTER_CATEGORY_MDSL__Alternatives");
					put(grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getAlternatives(), "rule__WIDGET_CATEGORY_MDSL__Alternatives");
					put(grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getAlternatives(), "rule__COMMAND_CATEGORY_MDSL__Alternatives");
					put(grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getAlternatives(), "rule__QUERY_OPTIMISATION_LEVEL__Alternatives");
					put(grammarAccess.getMADConfigurationAccess().getGroup(), "rule__MADConfiguration__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getClassDescriptorMdslAccess().getGroup(), "rule__ClassDescriptorMdsl__Group__0");
					put(grammarAccess.getClassDescriptorMdslAccess().getGroup_1(), "rule__ClassDescriptorMdsl__Group_1__0");
					put(grammarAccess.getPropertyTypeMdslAccess().getGroup(), "rule__PropertyTypeMdsl__Group__0");
					put(grammarAccess.getPropertyMdslAccess().getGroup(), "rule__PropertyMdsl__Group__0");
					put(grammarAccess.getPropertyValueMdslAccess().getGroup(), "rule__PropertyValueMdsl__Group__0");
					put(grammarAccess.getPropertyValueMdslAccess().getGroup_1(), "rule__PropertyValueMdsl__Group_1__0");
					put(grammarAccess.getIconDescriptorMdslAccess().getGroup(), "rule__IconDescriptorMdsl__Group__0");
					put(grammarAccess.getIconDescriptorMdslAccess().getGroup_2(), "rule__IconDescriptorMdsl__Group_2__0");
					put(grammarAccess.getIconDescriptorMdslAccess().getGroup_3_0(), "rule__IconDescriptorMdsl__Group_3_0__0");
					put(grammarAccess.getIconDescriptorMdslAccess().getGroup_3_1(), "rule__IconDescriptorMdsl__Group_3_1__0");
					put(grammarAccess.getI18NBundleMdslAccess().getGroup(), "rule__I18NBundleMdsl__Group__0");
					put(grammarAccess.getI18NBundleMdslAccess().getGroup_2(), "rule__I18NBundleMdsl__Group_2__0");
					put(grammarAccess.getI18NBundleMdslAccess().getGroup_3_0(), "rule__I18NBundleMdsl__Group_3_0__0");
					put(grammarAccess.getI18NBundleMdslAccess().getGroup_3_1(), "rule__I18NBundleMdsl__Group_3_1__0");
					put(grammarAccess.getForeignModelMdslAccess().getGroup(), "rule__ForeignModelMdsl__Group__0");
					put(grammarAccess.getForeignModelMdslAccess().getGroup_6(), "rule__ForeignModelMdsl__Group_6__0");
					put(grammarAccess.getForeignModelMdslAccess().getGroup_8(), "rule__ForeignModelMdsl__Group_8__0");
					put(grammarAccess.getForeignModelMdslAccess().getGroup_9(), "rule__ForeignModelMdsl__Group_9__0");
					put(grammarAccess.getForeignModelMdslAccess().getGroup_11(), "rule__ForeignModelMdsl__Group_11__0");
					put(grammarAccess.getURIExtensionModelProviderMdslAccess().getGroup(), "rule__URIExtensionModelProviderMdsl__Group__0");
					put(grammarAccess.getURIModelProviderMdslAccess().getGroup(), "rule__URIModelProviderMdsl__Group__0");
					put(grammarAccess.getCustomModelProviderMdslAccess().getGroup(), "rule__CustomModelProviderMdsl__Group__0");
					put(grammarAccess.getCustomModelProviderMdslAccess().getGroup_2(), "rule__CustomModelProviderMdsl__Group_2__0");
					put(grammarAccess.getCustomModelProviderMdslAccess().getGroup_2_2(), "rule__CustomModelProviderMdsl__Group_2_2__0");
					put(grammarAccess.getXtextLanguageDescriptorMdslAccess().getGroup(), "rule__XtextLanguageDescriptorMdsl__Group__0");
					put(grammarAccess.getXtextLanguageReferenceAccess().getGroup(), "rule__XtextLanguageReference__Group__0");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getGroup(), "rule__QueryEvaluatorMdsl__Group__0");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getGroup_9(), "rule__QueryEvaluatorMdsl__Group_9__0");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getGroup_9_2(), "rule__QueryEvaluatorMdsl__Group_9_2__0");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getGroup_10(), "rule__QueryEvaluatorMdsl__Group_10__0");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getGroup_11(), "rule__QueryEvaluatorMdsl__Group_11__0");
					put(grammarAccess.getWidgetTypeAccess().getGroup(), "rule__WidgetType__Group__0");
					put(grammarAccess.getWidgetTypeAccess().getGroup_10(), "rule__WidgetType__Group_10__0");
					put(grammarAccess.getUITabMdslAccess().getGroup(), "rule__UITabMdsl__Group__0");
					put(grammarAccess.getUITabMdslAccess().getGroup_8(), "rule__UITabMdsl__Group_8__0");
					put(grammarAccess.getLayerMdslAccess().getGroup(), "rule__LayerMdsl__Group__0");
					put(grammarAccess.getLayerMdslAccess().getGroup_6(), "rule__LayerMdsl__Group_6__0");
					put(grammarAccess.getLayerMdslAccess().getGroup_7(), "rule__LayerMdsl__Group_7__0");
					put(grammarAccess.getTypeConfigurationMdslAccess().getGroup(), "rule__TypeConfigurationMdsl__Group__0");
					put(grammarAccess.getTypeConfigurationMdslAccess().getGroup_3(), "rule__TypeConfigurationMdsl__Group_3__0");
					put(grammarAccess.getTypeConfigurationMdslAccess().getGroup_5(), "rule__TypeConfigurationMdsl__Group_5__0");
					put(grammarAccess.getTypeConfigurationMdslAccess().getGroup_6(), "rule__TypeConfigurationMdsl__Group_6__0");
					put(grammarAccess.getTypeConfigurationMdslAccess().getGroup_6_2(), "rule__TypeConfigurationMdsl__Group_6_2__0");
					put(grammarAccess.getTypeConfigurationMdslAccess().getGroup_9(), "rule__TypeConfigurationMdsl__Group_9__0");
					put(grammarAccess.getIncludeTemplateElementMdslAccess().getGroup(), "rule__IncludeTemplateElementMdsl__Group__0");
					put(grammarAccess.getQueryBasedValueConverterAccess().getGroup(), "rule__QueryBasedValueConverter__Group__0");
					put(grammarAccess.getBasicTypeValueConverterAccess().getGroup(), "rule__BasicTypeValueConverter__Group__0");
					put(grammarAccess.getBasicTypeValueConverterAccess().getGroup_1(), "rule__BasicTypeValueConverter__Group_1__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup(), "rule__WidgetConfigurationMdsl__Group__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_2(), "rule__WidgetConfigurationMdsl__Group_2__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_3(), "rule__WidgetConfigurationMdsl__Group_3__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_4(), "rule__WidgetConfigurationMdsl__Group_4__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_4_2(), "rule__WidgetConfigurationMdsl__Group_4_2__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_10(), "rule__WidgetConfigurationMdsl__Group_10__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_12(), "rule__WidgetConfigurationMdsl__Group_12__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_13_0(), "rule__WidgetConfigurationMdsl__Group_13_0__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_13_1(), "rule__WidgetConfigurationMdsl__Group_13_1__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_14(), "rule__WidgetConfigurationMdsl__Group_14__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_15(), "rule__WidgetConfigurationMdsl__Group_15__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_16(), "rule__WidgetConfigurationMdsl__Group_16__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_17(), "rule__WidgetConfigurationMdsl__Group_17__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_18(), "rule__WidgetConfigurationMdsl__Group_18__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_19(), "rule__WidgetConfigurationMdsl__Group_19__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_20(), "rule__WidgetConfigurationMdsl__Group_20__0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getGroup_20_2(), "rule__WidgetConfigurationMdsl__Group_20_2__0");
					put(grammarAccess.getValidatorMdslAccess().getGroup(), "rule__ValidatorMdsl__Group__0");
					put(grammarAccess.getCommandDeclarationAccess().getGroup(), "rule__CommandDeclaration__Group__0");
					put(grammarAccess.getCommandDeclarationAccess().getGroup_3(), "rule__CommandDeclaration__Group_3__0");
					put(grammarAccess.getCommandDeclarationAccess().getGroup_4(), "rule__CommandDeclaration__Group_4__0");
					put(grammarAccess.getCommandDefinitionMdslAccess().getGroup(), "rule__CommandDefinitionMdsl__Group__0");
					put(grammarAccess.getCommandDefinitionMdslAccess().getGroup_3(), "rule__CommandDefinitionMdsl__Group_3__0");
					put(grammarAccess.getCommandDefinitionMdslAccess().getGroup_6(), "rule__CommandDefinitionMdsl__Group_6__0");
					put(grammarAccess.getCommandDefinitionMdslAccess().getGroup_7(), "rule__CommandDefinitionMdsl__Group_7__0");
					put(grammarAccess.getCommandRefMdslAccess().getGroup(), "rule__CommandRefMdsl__Group__0");
					put(grammarAccess.getCommandRefMdslAccess().getGroup_1(), "rule__CommandRefMdsl__Group_1__0");
					put(grammarAccess.getDisplayViewUICommandAccess().getGroup(), "rule__DisplayViewUICommand__Group__0");
					put(grammarAccess.getDisplayViewUICommandAccess().getGroup_1(), "rule__DisplayViewUICommand__Group_1__0");
					put(grammarAccess.getReloadViewUICommandAccess().getGroup(), "rule__ReloadViewUICommand__Group__0");
					put(grammarAccess.getReloadWidgetsUICommandAccess().getGroup(), "rule__ReloadWidgetsUICommand__Group__0");
					put(grammarAccess.getQueryDeclarationAccess().getGroup(), "rule__QueryDeclaration__Group__0");
					put(grammarAccess.getQueryDeclarationAccess().getGroup_3(), "rule__QueryDeclaration__Group_3__0");
					put(grammarAccess.getQueryDeclarationAccess().getGroup_4(), "rule__QueryDeclaration__Group_4__0");
					put(grammarAccess.getQueryDefinitionMdslAccess().getGroup(), "rule__QueryDefinitionMdsl__Group__0");
					put(grammarAccess.getQueryDefinitionMdslAccess().getGroup_0(), "rule__QueryDefinitionMdsl__Group_0__0");
					put(grammarAccess.getQueryDefinitionMdslAccess().getGroup_1(), "rule__QueryDefinitionMdsl__Group_1__0");
					put(grammarAccess.getQueryDefinitionMdslAccess().getGroup_2(), "rule__QueryDefinitionMdsl__Group_2__0");
					put(grammarAccess.getQueryDefinitionMdslAccess().getGroup_4(), "rule__QueryDefinitionMdsl__Group_4__0");
					put(grammarAccess.getQueryDefinitionMdslAccess().getGroup_5(), "rule__QueryDefinitionMdsl__Group_5__0");
					put(grammarAccess.getQueryDefinitionMdslAccess().getGroup_5_2(), "rule__QueryDefinitionMdsl__Group_5_2__0");
					put(grammarAccess.getQueryDefinitionMdslAccess().getGroup_6(), "rule__QueryDefinitionMdsl__Group_6__0");
					put(grammarAccess.getQueryBodyAccess().getGroup(), "rule__QueryBody__Group__0");
					put(grammarAccess.getQueryBodyAccess().getGroup_1(), "rule__QueryBody__Group_1__0");
					put(grammarAccess.getExternalQueryCallMdslAccess().getGroup(), "rule__ExternalQueryCallMdsl__Group__0");
					put(grammarAccess.getQueryChainAccess().getGroup(), "rule__QueryChain__Group__0");
					put(grammarAccess.getQueryChainAccess().getGroup_3(), "rule__QueryChain__Group_3__0");
					put(grammarAccess.getFormatExprAccess().getGroup(), "rule__FormatExpr__Group__0");
					put(grammarAccess.getFormatExprAccess().getGroup_1(), "rule__FormatExpr__Group_1__0");
					put(grammarAccess.getTextMacroAccess().getGroup(), "rule__TextMacro__Group__0");
					put(grammarAccess.getTextMacroAccess().getGroup_3(), "rule__TextMacro__Group_3__0");
					put(grammarAccess.getTextMacroAccess().getGroup_4(), "rule__TextMacro__Group_4__0");
					put(grammarAccess.getTextMacroRefAccess().getGroup(), "rule__TextMacroRef__Group__0");
					put(grammarAccess.getMADConfigurationAccess().getImportsAssignment_0(), "rule__MADConfiguration__ImportsAssignment_0");
					put(grammarAccess.getMADConfigurationAccess().getConfigElementsAssignment_1(), "rule__MADConfiguration__ConfigElementsAssignment_1");
					put(grammarAccess.getImportAccess().getImportURIAssignment_1(), "rule__Import__ImportURIAssignment_1");
					put(grammarAccess.getClassDescriptorMdslAccess().getClassNameAssignment_0(), "rule__ClassDescriptorMdsl__ClassNameAssignment_0");
					put(grammarAccess.getClassDescriptorMdslAccess().getPluginIdAssignment_1_1(), "rule__ClassDescriptorMdsl__PluginIdAssignment_1_1");
					put(grammarAccess.getPropertyTypeMdslAccess().getNameAssignment_0(), "rule__PropertyTypeMdsl__NameAssignment_0");
					put(grammarAccess.getPropertyTypeMdslAccess().getLabelAssignment_2(), "rule__PropertyTypeMdsl__LabelAssignment_2");
					put(grammarAccess.getPropertyMdslAccess().getPropertyNameAssignment_0(), "rule__PropertyMdsl__PropertyNameAssignment_0");
					put(grammarAccess.getPropertyMdslAccess().getPropertyValueAssignment_2(), "rule__PropertyMdsl__PropertyValueAssignment_2");
					put(grammarAccess.getPropertyValueMdslAccess().getFragmentsAssignment_0(), "rule__PropertyValueMdsl__FragmentsAssignment_0");
					put(grammarAccess.getPropertyValueMdslAccess().getFragmentsAssignment_1_1(), "rule__PropertyValueMdsl__FragmentsAssignment_1_1");
					put(grammarAccess.getLiteraPropValueExprFragmentAccess().getValueAssignment(), "rule__LiteraPropValueExprFragment__ValueAssignment");
					put(grammarAccess.getIconDescriptorMdslAccess().getNameAssignment_1(), "rule__IconDescriptorMdsl__NameAssignment_1");
					put(grammarAccess.getIconDescriptorMdslAccess().getDescriptionAssignment_2_1(), "rule__IconDescriptorMdsl__DescriptionAssignment_2_1");
					put(grammarAccess.getIconDescriptorMdslAccess().getBundleDescriptorAssignment_3_0_1(), "rule__IconDescriptorMdsl__BundleDescriptorAssignment_3_0_1");
					put(grammarAccess.getIconDescriptorMdslAccess().getBundleUriAssignment_3_1_1(), "rule__IconDescriptorMdsl__BundleUriAssignment_3_1_1");
					put(grammarAccess.getI18NBundleMdslAccess().getNameAssignment_1(), "rule__I18NBundleMdsl__NameAssignment_1");
					put(grammarAccess.getI18NBundleMdslAccess().getDescriptionAssignment_2_1(), "rule__I18NBundleMdsl__DescriptionAssignment_2_1");
					put(grammarAccess.getI18NBundleMdslAccess().getBundleDescriptorAssignment_3_0_1(), "rule__I18NBundleMdsl__BundleDescriptorAssignment_3_0_1");
					put(grammarAccess.getI18NBundleMdslAccess().getBundleUriAssignment_3_1_1(), "rule__I18NBundleMdsl__BundleUriAssignment_3_1_1");
					put(grammarAccess.getForeignModelMdslAccess().getNameAssignment_3(), "rule__ForeignModelMdsl__NameAssignment_3");
					put(grammarAccess.getForeignModelMdslAccess().getLabelAssignment_5(), "rule__ForeignModelMdsl__LabelAssignment_5");
					put(grammarAccess.getForeignModelMdslAccess().getDescriptionAssignment_6_1(), "rule__ForeignModelMdsl__DescriptionAssignment_6_1");
					put(grammarAccess.getForeignModelMdslAccess().getProviderAssignment_7(), "rule__ForeignModelMdsl__ProviderAssignment_7");
					put(grammarAccess.getForeignModelMdslAccess().getSynchronizerFactoryClassAssignment_8_2(), "rule__ForeignModelMdsl__SynchronizerFactoryClassAssignment_8_2");
					put(grammarAccess.getForeignModelMdslAccess().getExtensionManagerClassAssignment_9_2(), "rule__ForeignModelMdsl__ExtensionManagerClassAssignment_9_2");
					put(grammarAccess.getForeignModelMdslAccess().getDslReferenceAssignment_10(), "rule__ForeignModelMdsl__DslReferenceAssignment_10");
					put(grammarAccess.getForeignModelMdslAccess().getRelocatorQueryAssignment_11_1(), "rule__ForeignModelMdsl__RelocatorQueryAssignment_11_1");
					put(grammarAccess.getURIExtensionModelProviderMdslAccess().getUriExtensionAssignment_1(), "rule__URIExtensionModelProviderMdsl__UriExtensionAssignment_1");
					put(grammarAccess.getURIModelProviderMdslAccess().getModelUriAssignment_1(), "rule__URIModelProviderMdsl__ModelUriAssignment_1");
					put(grammarAccess.getCustomModelProviderMdslAccess().getClassDescriptorAssignment_1(), "rule__CustomModelProviderMdsl__ClassDescriptorAssignment_1");
					put(grammarAccess.getCustomModelProviderMdslAccess().getParametersAssignment_2_1(), "rule__CustomModelProviderMdsl__ParametersAssignment_2_1");
					put(grammarAccess.getCustomModelProviderMdslAccess().getParametersAssignment_2_2_1(), "rule__CustomModelProviderMdsl__ParametersAssignment_2_2_1");
					put(grammarAccess.getXtextLanguageDescriptorMdslAccess().getNameAssignment_1(), "rule__XtextLanguageDescriptorMdsl__NameAssignment_1");
					put(grammarAccess.getXtextLanguageDescriptorMdslAccess().getLanguageIdAssignment_3(), "rule__XtextLanguageDescriptorMdsl__LanguageIdAssignment_3");
					put(grammarAccess.getXtextLanguageDescriptorMdslAccess().getBundleIdAssignment_5(), "rule__XtextLanguageDescriptorMdsl__BundleIdAssignment_5");
					put(grammarAccess.getXtextLanguageDescriptorMdslAccess().getActivatorClassNameAssignment_7(), "rule__XtextLanguageDescriptorMdsl__ActivatorClassNameAssignment_7");
					put(grammarAccess.getXtextLanguageReferenceAccess().getXtextLanguageDescriptorAssignment_1(), "rule__XtextLanguageReference__XtextLanguageDescriptorAssignment_1");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getNameAssignment_3(), "rule__QueryEvaluatorMdsl__NameAssignment_3");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getLabelAssignment_5(), "rule__QueryEvaluatorMdsl__LabelAssignment_5");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getClassDescriptorAssignment_8(), "rule__QueryEvaluatorMdsl__ClassDescriptorAssignment_8");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypesAssignment_9_1(), "rule__QueryEvaluatorMdsl__QueryPropertiesTypesAssignment_9_1");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypesAssignment_9_2_1(), "rule__QueryEvaluatorMdsl__QueryPropertiesTypesAssignment_9_2_1");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getExtQServiceClassDescriptorAssignment_10_1(), "rule__QueryEvaluatorMdsl__ExtQServiceClassDescriptorAssignment_10_1");
					put(grammarAccess.getQueryEvaluatorMdslAccess().getDescriptionAssignment_11_1(), "rule__QueryEvaluatorMdsl__DescriptionAssignment_11_1");
					put(grammarAccess.getWidgetTypeAccess().getNameAssignment_3(), "rule__WidgetType__NameAssignment_3");
					put(grammarAccess.getWidgetTypeAccess().getCategoryAssignment_5(), "rule__WidgetType__CategoryAssignment_5");
					put(grammarAccess.getWidgetTypeAccess().getLabelAssignment_7(), "rule__WidgetType__LabelAssignment_7");
					put(grammarAccess.getWidgetTypeAccess().getClassDescriptorAssignment_9(), "rule__WidgetType__ClassDescriptorAssignment_9");
					put(grammarAccess.getWidgetTypeAccess().getDescriptionAssignment_10_1(), "rule__WidgetType__DescriptionAssignment_10_1");
					put(grammarAccess.getUITabMdslAccess().getNameAssignment_4(), "rule__UITabMdsl__NameAssignment_4");
					put(grammarAccess.getUITabMdslAccess().getI18NLabelAssignment_5(), "rule__UITabMdsl__I18NLabelAssignment_5");
					put(grammarAccess.getUITabMdslAccess().getLabelFormatExprAssignment_7(), "rule__UITabMdsl__LabelFormatExprAssignment_7");
					put(grammarAccess.getUITabMdslAccess().getDescriptionAssignment_8_1(), "rule__UITabMdsl__DescriptionAssignment_8_1");
					put(grammarAccess.getLayerMdslAccess().getNameAssignment_1(), "rule__LayerMdsl__NameAssignment_1");
					put(grammarAccess.getLayerMdslAccess().getI18NLabelAssignment_3(), "rule__LayerMdsl__I18NLabelAssignment_3");
					put(grammarAccess.getLayerMdslAccess().getLabelFormatExprAssignment_5(), "rule__LayerMdsl__LabelFormatExprAssignment_5");
					put(grammarAccess.getLayerMdslAccess().getDescriptionAssignment_6_1(), "rule__LayerMdsl__DescriptionAssignment_6_1");
					put(grammarAccess.getLayerMdslAccess().getSubLayersAssignment_7_3(), "rule__LayerMdsl__SubLayersAssignment_7_3");
					put(grammarAccess.getTypeConfigurationMdslAccess().getDefaultConfigurationAssignment_0(), "rule__TypeConfigurationMdsl__DefaultConfigurationAssignment_0");
					put(grammarAccess.getTypeConfigurationMdslAccess().getNameAssignment_2(), "rule__TypeConfigurationMdsl__NameAssignment_2");
					put(grammarAccess.getTypeConfigurationMdslAccess().getTypeAssignment_3_1(), "rule__TypeConfigurationMdsl__TypeAssignment_3_1");
					put(grammarAccess.getTypeConfigurationMdslAccess().getI18NLabelProviderAssignment_5_0(), "rule__TypeConfigurationMdsl__I18NLabelProviderAssignment_5_0");
					put(grammarAccess.getTypeConfigurationMdslAccess().getLabelProviderExpressionAssignment_5_2(), "rule__TypeConfigurationMdsl__LabelProviderExpressionAssignment_5_2");
					put(grammarAccess.getTypeConfigurationMdslAccess().getUseExplicitExtendsAssignment_6_0(), "rule__TypeConfigurationMdsl__UseExplicitExtendsAssignment_6_0");
					put(grammarAccess.getTypeConfigurationMdslAccess().getSuperConfigurationsAssignment_6_1(), "rule__TypeConfigurationMdsl__SuperConfigurationsAssignment_6_1");
					put(grammarAccess.getTypeConfigurationMdslAccess().getSuperConfigurationsAssignment_6_2_1(), "rule__TypeConfigurationMdsl__SuperConfigurationsAssignment_6_2_1");
					put(grammarAccess.getTypeConfigurationMdslAccess().getTemplateElementsAssignment_8(), "rule__TypeConfigurationMdsl__TemplateElementsAssignment_8");
					put(grammarAccess.getTypeConfigurationMdslAccess().getLayoutDefinedAssignment_9_0(), "rule__TypeConfigurationMdsl__LayoutDefinedAssignment_9_0");
					put(grammarAccess.getTypeConfigurationMdslAccess().getLayoutElementsAssignment_9_1(), "rule__TypeConfigurationMdsl__LayoutElementsAssignment_9_1");
					put(grammarAccess.getIncludeTemplateElementMdslAccess().getNameAssignment_1(), "rule__IncludeTemplateElementMdsl__NameAssignment_1");
					put(grammarAccess.getIncludeTemplateElementMdslAccess().getRefIncludedTemplateAssignment_3(), "rule__IncludeTemplateElementMdsl__RefIncludedTemplateAssignment_3");
					put(grammarAccess.getIncludeTemplateElementMdslAccess().getValueQueryAssignment_5(), "rule__IncludeTemplateElementMdsl__ValueQueryAssignment_5");
					put(grammarAccess.getQueryBasedValueConverterAccess().getConverterQueryAssignment_1(), "rule__QueryBasedValueConverter__ConverterQueryAssignment_1");
					put(grammarAccess.getBasicTypeValueConverterAccess().getCategoryAssignment_0(), "rule__BasicTypeValueConverter__CategoryAssignment_0");
					put(grammarAccess.getBasicTypeValueConverterAccess().getConfigurationAssignment_1_1(), "rule__BasicTypeValueConverter__ConfigurationAssignment_1_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getNameAssignment_1(), "rule__WidgetConfigurationMdsl__NameAssignment_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getDescriptionAssignment_2_1(), "rule__WidgetConfigurationMdsl__DescriptionAssignment_2_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getUiTabAssignment_3_1(), "rule__WidgetConfigurationMdsl__UiTabAssignment_3_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getLayersAssignment_4_1(), "rule__WidgetConfigurationMdsl__LayersAssignment_4_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getLayersAssignment_4_2_1(), "rule__WidgetConfigurationMdsl__LayersAssignment_4_2_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getI18NLabelAssignment_5(), "rule__WidgetConfigurationMdsl__I18NLabelAssignment_5");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getLabelAssignment_7(), "rule__WidgetConfigurationMdsl__LabelAssignment_7");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getWidgetCategoryAssignment_9(), "rule__WidgetConfigurationMdsl__WidgetCategoryAssignment_9");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getWidgetTypeAssignment_10_1(), "rule__WidgetConfigurationMdsl__WidgetTypeAssignment_10_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getDslReferenceAssignment_11(), "rule__WidgetConfigurationMdsl__DslReferenceAssignment_11");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getFlexibleTemplateAssignment_12_1(), "rule__WidgetConfigurationMdsl__FlexibleTemplateAssignment_12_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getVisibilityQueryAssignment_13_0_1(), "rule__WidgetConfigurationMdsl__VisibilityQueryAssignment_13_0_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getEditableQueryAssignment_13_1_1(), "rule__WidgetConfigurationMdsl__EditableQueryAssignment_13_1_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getValueQueryAssignment_14_1(), "rule__WidgetConfigurationMdsl__ValueQueryAssignment_14_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getValueConverterAssignment_15_1(), "rule__WidgetConfigurationMdsl__ValueConverterAssignment_15_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getValidatorsAssignment_16_1(), "rule__WidgetConfigurationMdsl__ValidatorsAssignment_16_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getI18NFormatAssignment_17_0(), "rule__WidgetConfigurationMdsl__I18NFormatAssignment_17_0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getValueFormatAssignment_17_2(), "rule__WidgetConfigurationMdsl__ValueFormatAssignment_17_2");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getCandidatesQueryAssignment_18_1(), "rule__WidgetConfigurationMdsl__CandidatesQueryAssignment_18_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getI18NItemLabelAssignment_19_0(), "rule__WidgetConfigurationMdsl__I18NItemLabelAssignment_19_0");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getItemLabelExpressionAssignment_19_2(), "rule__WidgetConfigurationMdsl__ItemLabelExpressionAssignment_19_2");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getCommandsAssignment_20_1(), "rule__WidgetConfigurationMdsl__CommandsAssignment_20_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getCommandsAssignment_20_2_1(), "rule__WidgetConfigurationMdsl__CommandsAssignment_20_2_1");
					put(grammarAccess.getValidatorMdslAccess().getValidationQueryAssignment_1(), "rule__ValidatorMdsl__ValidationQueryAssignment_1");
					put(grammarAccess.getValidatorMdslAccess().getI18NMessageAssignment_2(), "rule__ValidatorMdsl__I18NMessageAssignment_2");
					put(grammarAccess.getValidatorMdslAccess().getErrorMessageExprAssignment_4(), "rule__ValidatorMdsl__ErrorMessageExprAssignment_4");
					put(grammarAccess.getCommandDeclarationAccess().getNameAssignment_1(), "rule__CommandDeclaration__NameAssignment_1");
					put(grammarAccess.getCommandDeclarationAccess().getLabelAssignment_3_1(), "rule__CommandDeclaration__LabelAssignment_3_1");
					put(grammarAccess.getCommandDeclarationAccess().getDescriptionAssignment_4_1(), "rule__CommandDeclaration__DescriptionAssignment_4_1");
					put(grammarAccess.getCommandDeclarationAccess().getDefinitionAssignment_5(), "rule__CommandDeclaration__DefinitionAssignment_5");
					put(grammarAccess.getCommandDefinitionMdslAccess().getCategoryAssignment_0(), "rule__CommandDefinitionMdsl__CategoryAssignment_0");
					put(grammarAccess.getCommandDefinitionMdslAccess().getI18NLabelAssignment_1(), "rule__CommandDefinitionMdsl__I18NLabelAssignment_1");
					put(grammarAccess.getCommandDefinitionMdslAccess().getLabelAssignment_2(), "rule__CommandDefinitionMdsl__LabelAssignment_2");
					put(grammarAccess.getCommandDefinitionMdslAccess().getIconAssignment_3_1(), "rule__CommandDefinitionMdsl__IconAssignment_3_1");
					put(grammarAccess.getCommandDefinitionMdslAccess().getActionAssignment_5(), "rule__CommandDefinitionMdsl__ActionAssignment_5");
					put(grammarAccess.getCommandDefinitionMdslAccess().getOnActionSuccessUICommandsAssignment_6_1(), "rule__CommandDefinitionMdsl__OnActionSuccessUICommandsAssignment_6_1");
					put(grammarAccess.getCommandDefinitionMdslAccess().getOnActionErrorUICommandsAssignment_7_1(), "rule__CommandDefinitionMdsl__OnActionErrorUICommandsAssignment_7_1");
					put(grammarAccess.getCommandRefMdslAccess().getReferencedAssignment_0(), "rule__CommandRefMdsl__ReferencedAssignment_0");
					put(grammarAccess.getCommandRefMdslAccess().getI18NLabelOverrideAssignment_1_1(), "rule__CommandRefMdsl__I18NLabelOverrideAssignment_1_1");
					put(grammarAccess.getCommandRefMdslAccess().getLabelOverrideAssignment_1_2(), "rule__CommandRefMdsl__LabelOverrideAssignment_1_2");
					put(grammarAccess.getDisplayViewUICommandAccess().getTargetAssignment_1_1(), "rule__DisplayViewUICommand__TargetAssignment_1_1");
					put(grammarAccess.getReloadWidgetsUICommandAccess().getWidgetsToReloadAssignment_2(), "rule__ReloadWidgetsUICommand__WidgetsToReloadAssignment_2");
					put(grammarAccess.getQueryDeclarationAccess().getNameAssignment_1(), "rule__QueryDeclaration__NameAssignment_1");
					put(grammarAccess.getQueryDeclarationAccess().getLabelAssignment_3_1(), "rule__QueryDeclaration__LabelAssignment_3_1");
					put(grammarAccess.getQueryDeclarationAccess().getDescriptionAssignment_4_1(), "rule__QueryDeclaration__DescriptionAssignment_4_1");
					put(grammarAccess.getQueryDeclarationAccess().getDefinitionAssignment_5(), "rule__QueryDeclaration__DefinitionAssignment_5");
					put(grammarAccess.getQueryDefinitionMdslAccess().getEvaluatorAssignment_0_1(), "rule__QueryDefinitionMdsl__EvaluatorAssignment_0_1");
					put(grammarAccess.getQueryDefinitionMdslAccess().getForeignModelAssignment_1_1(), "rule__QueryDefinitionMdsl__ForeignModelAssignment_1_1");
					put(grammarAccess.getQueryDefinitionMdslAccess().getContextLocatorAssignment_2_1(), "rule__QueryDefinitionMdsl__ContextLocatorAssignment_2_1");
					put(grammarAccess.getQueryDefinitionMdslAccess().getQueryAssignment_3_0(), "rule__QueryDefinitionMdsl__QueryAssignment_3_0");
					put(grammarAccess.getQueryDefinitionMdslAccess().getExternalQueryCallAssignment_3_1(), "rule__QueryDefinitionMdsl__ExternalQueryCallAssignment_3_1");
					put(grammarAccess.getQueryDefinitionMdslAccess().getReturnTypeAssignment_4_1(), "rule__QueryDefinitionMdsl__ReturnTypeAssignment_4_1");
					put(grammarAccess.getQueryDefinitionMdslAccess().getPropertiesAssignment_5_1(), "rule__QueryDefinitionMdsl__PropertiesAssignment_5_1");
					put(grammarAccess.getQueryDefinitionMdslAccess().getPropertiesAssignment_5_2_1(), "rule__QueryDefinitionMdsl__PropertiesAssignment_5_2_1");
					put(grammarAccess.getQueryDefinitionMdslAccess().getOptimisationLevelAssignment_6_1(), "rule__QueryDefinitionMdsl__OptimisationLevelAssignment_6_1");
					put(grammarAccess.getLiteralQueryFragmentAccess().getValueAssignment(), "rule__LiteralQueryFragment__ValueAssignment");
					put(grammarAccess.getQueryBodyAccess().getFragmentsAssignment_0(), "rule__QueryBody__FragmentsAssignment_0");
					put(grammarAccess.getQueryBodyAccess().getFragmentsAssignment_1_1(), "rule__QueryBody__FragmentsAssignment_1_1");
					put(grammarAccess.getQueryRefMdslAccess().getReferencedAssignment(), "rule__QueryRefMdsl__ReferencedAssignment");
					put(grammarAccess.getExternalQueryCallMdslAccess().getExternalQueryAssignment_1(), "rule__ExternalQueryCallMdsl__ExternalQueryAssignment_1");
					put(grammarAccess.getQueryChainAccess().getQueriesAssignment_2(), "rule__QueryChain__QueriesAssignment_2");
					put(grammarAccess.getQueryChainAccess().getQueriesAssignment_3_1(), "rule__QueryChain__QueriesAssignment_3_1");
					put(grammarAccess.getFormatExprAccess().getFragmentsAssignment_0(), "rule__FormatExpr__FragmentsAssignment_0");
					put(grammarAccess.getFormatExprAccess().getFragmentsAssignment_1_1(), "rule__FormatExpr__FragmentsAssignment_1_1");
					put(grammarAccess.getLiteralFormatExprFragmentAccess().getValueAssignment(), "rule__LiteralFormatExprFragment__ValueAssignment");
					put(grammarAccess.getTextMacroAccess().getNameAssignment_1(), "rule__TextMacro__NameAssignment_1");
					put(grammarAccess.getTextMacroAccess().getLabelAssignment_3_1(), "rule__TextMacro__LabelAssignment_3_1");
					put(grammarAccess.getTextMacroAccess().getDescriptionAssignment_4_1(), "rule__TextMacro__DescriptionAssignment_4_1");
					put(grammarAccess.getTextMacroAccess().getMacroValueAssignment_6(), "rule__TextMacro__MacroValueAssignment_6");
					put(grammarAccess.getTextMacroRefAccess().getReferencedAssignment_1(), "rule__TextMacroRef__ReferencedAssignment_1");
					put(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), "rule__WidgetConfigurationMdsl__UnorderedGroup_13");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			com.sysord.mad.configuration.ui.contentassist.antlr.internal.InternalMadConfigDslParser typedParser = (com.sysord.mad.configuration.ui.contentassist.antlr.internal.InternalMadConfigDslParser) parser;
			typedParser.entryRuleMADConfiguration();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public MadConfigDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(MadConfigDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
