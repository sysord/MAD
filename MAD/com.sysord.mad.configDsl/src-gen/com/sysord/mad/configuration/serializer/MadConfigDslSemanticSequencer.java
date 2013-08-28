package com.sysord.mad.configuration.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sysord.mad.configuration.madConfigDsl.BasicTypeValueConverter;
import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandDeclaration;
import com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandRefMdsl;
import com.sysord.mad.configuration.madConfigDsl.CustomModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.DisplayViewUICommand;
import com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl;
import com.sysord.mad.configuration.madConfigDsl.ForeignModelMdsl;
import com.sysord.mad.configuration.madConfigDsl.FormatExpr;
import com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl;
import com.sysord.mad.configuration.madConfigDsl.IconDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.Import;
import com.sysord.mad.configuration.madConfigDsl.IncludeTemplateElementMdsl;
import com.sysord.mad.configuration.madConfigDsl.LayerMdsl;
import com.sysord.mad.configuration.madConfigDsl.LiteraPropValueExprFragment;
import com.sysord.mad.configuration.madConfigDsl.LiteralFormatExprFragment;
import com.sysord.mad.configuration.madConfigDsl.LiteralQueryFragment;
import com.sysord.mad.configuration.madConfigDsl.MADConfiguration;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.OCLCustomLibraryMdsl;
import com.sysord.mad.configuration.madConfigDsl.PropertyMdsl;
import com.sysord.mad.configuration.madConfigDsl.PropertyTypeMdsl;
import com.sysord.mad.configuration.madConfigDsl.PropertyValueMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter;
import com.sysord.mad.configuration.madConfigDsl.QueryBody;
import com.sysord.mad.configuration.madConfigDsl.QueryChain;
import com.sysord.mad.configuration.madConfigDsl.QueryDeclaration;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryEvaluatorMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryRefMdsl;
import com.sysord.mad.configuration.madConfigDsl.ReloadViewUICommand;
import com.sysord.mad.configuration.madConfigDsl.ReloadWidgetsUICommand;
import com.sysord.mad.configuration.madConfigDsl.TextMacro;
import com.sysord.mad.configuration.madConfigDsl.TextMacroRef;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.UITabMdsl;
import com.sysord.mad.configuration.madConfigDsl.URIExtensionModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.URIModelProviderMdsl;
import com.sysord.mad.configuration.madConfigDsl.ValidatorMdsl;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.WidgetType;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageReference;
import com.sysord.mad.configuration.services.MadConfigDslGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class MadConfigDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MadConfigDslGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == MadConfigDslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MadConfigDslPackage.BASIC_TYPE_VALUE_CONVERTER:
				if(context == grammarAccess.getBasicTypeValueConverterRule() ||
				   context == grammarAccess.getValueConverterRule()) {
					sequence_BasicTypeValueConverter(context, (BasicTypeValueConverter) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.CLASS_DESCRIPTOR_MDSL:
				if(context == grammarAccess.getClassDescriptorMdslRule()) {
					sequence_ClassDescriptorMdsl(context, (ClassDescriptorMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.COMMAND_DECLARATION:
				if(context == grammarAccess.getCommandDeclarationRule() ||
				   context == grammarAccess.getMADConfigElementRule()) {
					sequence_CommandDeclaration(context, (CommandDeclaration) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.COMMAND_DEFINITION_MDSL:
				if(context == grammarAccess.getCommandRule() ||
				   context == grammarAccess.getCommandDefinitionMdslRule()) {
					sequence_CommandDefinitionMdsl(context, (CommandDefinitionMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.COMMAND_REF_MDSL:
				if(context == grammarAccess.getCommandRule() ||
				   context == grammarAccess.getCommandRefMdslRule()) {
					sequence_CommandRefMdsl(context, (CommandRefMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.CUSTOM_MODEL_PROVIDER_MDSL:
				if(context == grammarAccess.getCustomModelProviderMdslRule() ||
				   context == grammarAccess.getModelProviderMdslRule()) {
					sequence_CustomModelProviderMdsl(context, (CustomModelProviderMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.DISPLAY_VIEW_UI_COMMAND:
				if(context == grammarAccess.getDisplayViewUICommandRule() ||
				   context == grammarAccess.getUICommandMdslRule()) {
					sequence_DisplayViewUICommand(context, (DisplayViewUICommand) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.EXTERNAL_QUERY_CALL_MDSL:
				if(context == grammarAccess.getExternalQueryCallMdslRule()) {
					sequence_ExternalQueryCallMdsl(context, (ExternalQueryCallMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.FOREIGN_MODEL_MDSL:
				if(context == grammarAccess.getForeignModelMdslRule() ||
				   context == grammarAccess.getMADConfigElementRule()) {
					sequence_ForeignModelMdsl(context, (ForeignModelMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.FORMAT_EXPR:
				if(context == grammarAccess.getFormatExprRule()) {
					sequence_FormatExpr(context, (FormatExpr) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.I18N_BUNDLE_MDSL:
				if(context == grammarAccess.getI18NBundleMdslRule() ||
				   context == grammarAccess.getMADConfigElementRule()) {
					sequence_I18NBundleMdsl(context, (I18NBundleMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.ICON_DESCRIPTOR_MDSL:
				if(context == grammarAccess.getIconDescriptorMdslRule() ||
				   context == grammarAccess.getMADConfigElementRule()) {
					sequence_IconDescriptorMdsl(context, (IconDescriptorMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.INCLUDE_TEMPLATE_ELEMENT_MDSL:
				if(context == grammarAccess.getIncludeTemplateElementMdslRule() ||
				   context == grammarAccess.getTypeConfigurationTemplateElementRule()) {
					sequence_IncludeTemplateElementMdsl(context, (IncludeTemplateElementMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.LAYER_MDSL:
				if(context == grammarAccess.getLayerMdslRule() ||
				   context == grammarAccess.getMADConfigElementRule()) {
					sequence_LayerMdsl(context, (LayerMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.LITERA_PROP_VALUE_EXPR_FRAGMENT:
				if(context == grammarAccess.getLiteraPropValueExprFragmentRule() ||
				   context == grammarAccess.getPropValueExprFragmentRule()) {
					sequence_LiteraPropValueExprFragment(context, (LiteraPropValueExprFragment) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.LITERAL_FORMAT_EXPR_FRAGMENT:
				if(context == grammarAccess.getFormatExprFragmentRule() ||
				   context == grammarAccess.getLiteralFormatExprFragmentRule()) {
					sequence_LiteralFormatExprFragment(context, (LiteralFormatExprFragment) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.LITERAL_QUERY_FRAGMENT:
				if(context == grammarAccess.getLiteralQueryFragmentRule() ||
				   context == grammarAccess.getQueryFragmentRule()) {
					sequence_LiteralQueryFragment(context, (LiteralQueryFragment) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.MAD_CONFIGURATION:
				if(context == grammarAccess.getMADConfigurationRule()) {
					sequence_MADConfiguration(context, (MADConfiguration) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.OCL_CUSTOM_LIBRARY_MDSL:
				if(context == grammarAccess.getMADConfigElementRule() ||
				   context == grammarAccess.getOCLCustomLibraryMdslRule()) {
					sequence_OCLCustomLibraryMdsl(context, (OCLCustomLibraryMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.PROPERTY_MDSL:
				if(context == grammarAccess.getPropertyMdslRule()) {
					sequence_PropertyMdsl(context, (PropertyMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.PROPERTY_TYPE_MDSL:
				if(context == grammarAccess.getPropertyTypeMdslRule()) {
					sequence_PropertyTypeMdsl(context, (PropertyTypeMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.PROPERTY_VALUE_MDSL:
				if(context == grammarAccess.getPropertyValueMdslRule()) {
					sequence_PropertyValueMdsl(context, (PropertyValueMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.QUERY_BASED_VALUE_CONVERTER:
				if(context == grammarAccess.getQueryBasedValueConverterRule() ||
				   context == grammarAccess.getValueConverterRule()) {
					sequence_QueryBasedValueConverter(context, (QueryBasedValueConverter) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.QUERY_BODY:
				if(context == grammarAccess.getQueryBodyRule()) {
					sequence_QueryBody(context, (QueryBody) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.QUERY_CHAIN:
				if(context == grammarAccess.getQueryChainRule() ||
				   context == grammarAccess.getQueryUsageRule()) {
					sequence_QueryChain(context, (QueryChain) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.QUERY_DECLARATION:
				if(context == grammarAccess.getMADConfigElementRule() ||
				   context == grammarAccess.getQueryDeclarationRule()) {
					sequence_QueryDeclaration(context, (QueryDeclaration) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.QUERY_DEFINITION_MDSL:
				if(context == grammarAccess.getQueryRule() ||
				   context == grammarAccess.getQueryDefinitionMdslRule() ||
				   context == grammarAccess.getQueryUsageRule()) {
					sequence_QueryDefinitionMdsl(context, (QueryDefinitionMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.QUERY_EVALUATOR_MDSL:
				if(context == grammarAccess.getMADConfigElementRule() ||
				   context == grammarAccess.getQueryEvaluatorMdslRule()) {
					sequence_QueryEvaluatorMdsl(context, (QueryEvaluatorMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.QUERY_REF_MDSL:
				if(context == grammarAccess.getQueryRule() ||
				   context == grammarAccess.getQueryRefMdslRule() ||
				   context == grammarAccess.getQueryUsageRule()) {
					sequence_QueryRefMdsl(context, (QueryRefMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.RELOAD_VIEW_UI_COMMAND:
				if(context == grammarAccess.getReloadViewUICommandRule() ||
				   context == grammarAccess.getUICommandMdslRule()) {
					sequence_ReloadViewUICommand(context, (ReloadViewUICommand) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.RELOAD_WIDGETS_UI_COMMAND:
				if(context == grammarAccess.getReloadWidgetsUICommandRule() ||
				   context == grammarAccess.getUICommandMdslRule()) {
					sequence_ReloadWidgetsUICommand(context, (ReloadWidgetsUICommand) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.TEXT_MACRO:
				if(context == grammarAccess.getMADConfigElementRule() ||
				   context == grammarAccess.getTextMacroRule()) {
					sequence_TextMacro(context, (TextMacro) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.TEXT_MACRO_REF:
				if(context == grammarAccess.getFormatExprFragmentRule() ||
				   context == grammarAccess.getPropValueExprFragmentRule() ||
				   context == grammarAccess.getQueryFragmentRule() ||
				   context == grammarAccess.getTextMacroRefRule()) {
					sequence_TextMacroRef(context, (TextMacroRef) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.TYPE_CONFIGURATION_MDSL:
				if(context == grammarAccess.getMADConfigElementRule() ||
				   context == grammarAccess.getTypeConfigurationMdslRule()) {
					sequence_TypeConfigurationMdsl(context, (TypeConfigurationMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.UI_TAB_MDSL:
				if(context == grammarAccess.getMADConfigElementRule() ||
				   context == grammarAccess.getUITabMdslRule()) {
					sequence_UITabMdsl(context, (UITabMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.URI_EXTENSION_MODEL_PROVIDER_MDSL:
				if(context == grammarAccess.getModelProviderMdslRule() ||
				   context == grammarAccess.getURIExtensionModelProviderMdslRule()) {
					sequence_URIExtensionModelProviderMdsl(context, (URIExtensionModelProviderMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.URI_MODEL_PROVIDER_MDSL:
				if(context == grammarAccess.getModelProviderMdslRule() ||
				   context == grammarAccess.getURIModelProviderMdslRule()) {
					sequence_URIModelProviderMdsl(context, (URIModelProviderMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.VALIDATOR_MDSL:
				if(context == grammarAccess.getValidatorMdslRule()) {
					sequence_ValidatorMdsl(context, (ValidatorMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.WIDGET_CONFIGURATION_MDSL:
				if(context == grammarAccess.getTypeConfigurationTemplateElementRule() ||
				   context == grammarAccess.getWidgetConfigurationMdslRule()) {
					sequence_WidgetConfigurationMdsl(context, (WidgetConfigurationMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.WIDGET_TYPE:
				if(context == grammarAccess.getMADConfigElementRule() ||
				   context == grammarAccess.getWidgetTypeRule()) {
					sequence_WidgetType(context, (WidgetType) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.XTEXT_LANGUAGE_DESCRIPTOR_MDSL:
				if(context == grammarAccess.getMADConfigElementRule() ||
				   context == grammarAccess.getXtextLanguageDescriptorMdslRule()) {
					sequence_XtextLanguageDescriptorMdsl(context, (XtextLanguageDescriptorMdsl) semanticObject); 
					return; 
				}
				else break;
			case MadConfigDslPackage.XTEXT_LANGUAGE_REFERENCE:
				if(context == grammarAccess.getXtextLanguageReferenceRule()) {
					sequence_XtextLanguageReference(context, (XtextLanguageReference) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (category=VALUE_CONVERTER_CATEGORY_MDSL configuration=STRING?)
	 */
	protected void sequence_BasicTypeValueConverter(EObject context, BasicTypeValueConverter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ClassName=ID pluginId=ID?)
	 */
	protected void sequence_ClassDescriptorMdsl(EObject context, ClassDescriptorMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID label=STRING? description=STRING? definition=CommandDefinitionMdsl)
	 */
	protected void sequence_CommandDeclaration(EObject context, CommandDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         category=COMMAND_CATEGORY_MDSL 
	 *         (i18NLabel?='I18N'? label=FormatExpr)? 
	 *         icon=[IconDescriptorMdsl|ID]? 
	 *         action=Query 
	 *         onActionSuccessUICommands+=UICommandMdsl* 
	 *         onActionErrorUICommands+=UICommandMdsl*
	 *     )
	 */
	protected void sequence_CommandDefinitionMdsl(EObject context, CommandDefinitionMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (referenced=[CommandDeclaration|ID] (i18NLabelOverride?='I18N'? labelOverride=FormatExpr)?)
	 */
	protected void sequence_CommandRefMdsl(EObject context, CommandRefMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (classDescriptor=ClassDescriptorMdsl (parameters+=STRING parameters+=STRING?)?)
	 */
	protected void sequence_CustomModelProviderMdsl(EObject context, CustomModelProviderMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     target=QueryUsage
	 */
	protected void sequence_DisplayViewUICommand(EObject context, DisplayViewUICommand semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.DISPLAY_VIEW_UI_COMMAND__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.DISPLAY_VIEW_UI_COMMAND__TARGET));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDisplayViewUICommandAccess().getTargetQueryUsageParserRuleCall_1_1_0(), semanticObject.getTarget());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     externalQuery=[EObject|ID]
	 */
	protected void sequence_ExternalQueryCallMdsl(EObject context, ExternalQueryCallMdsl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.EXTERNAL_QUERY_CALL_MDSL__EXTERNAL_QUERY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExternalQueryCallMdslAccess().getExternalQueryEObjectIDTerminalRuleCall_1_0_1(), semanticObject.getExternalQuery());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         label=STRING 
	 *         description=STRING? 
	 *         provider=ModelProviderMdsl 
	 *         autoReloadEnabled?='AUTO_RELOAD'? 
	 *         synchronizerFactoryClass=ClassDescriptorMdsl? 
	 *         extensionManagerClass=ClassDescriptorMdsl? 
	 *         dslReference=XtextLanguageReference? 
	 *         relocatorQuery=Query?
	 *     )
	 */
	protected void sequence_ForeignModelMdsl(EObject context, ForeignModelMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (fragments+=FormatExprFragment fragments+=FormatExprFragment*)
	 */
	protected void sequence_FormatExpr(EObject context, FormatExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID description=STRING? (bundleDescriptor=ClassDescriptorMdsl | bundleUri=STRING))
	 */
	protected void sequence_I18NBundleMdsl(EObject context, I18NBundleMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID description=STRING? (bundleDescriptor=ClassDescriptorMdsl | bundleUri=STRING))
	 */
	protected void sequence_IconDescriptorMdsl(EObject context, IconDescriptorMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     importURI=STRING
	 */
	protected void sequence_Import(EObject context, Import semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.IMPORT__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.IMPORT__IMPORT_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID refIncludedTemplate=[TypeConfigurationMdsl|ID] valueQuery=QueryUsage)
	 */
	protected void sequence_IncludeTemplateElementMdsl(EObject context, IncludeTemplateElementMdsl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__NAME));
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY));
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.INCLUDE_TEMPLATE_ELEMENT_MDSL__REF_INCLUDED_TEMPLATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIncludeTemplateElementMdslAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getIncludeTemplateElementMdslAccess().getRefIncludedTemplateTypeConfigurationMdslIDTerminalRuleCall_3_0_1(), semanticObject.getRefIncludedTemplate());
		feeder.accept(grammarAccess.getIncludeTemplateElementMdslAccess().getValueQueryQueryUsageParserRuleCall_5_0(), semanticObject.getValueQuery());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID i18NLabel?='I18N'? labelFormatExpr=FormatExpr description=STRING? subLayers+=LayerMdsl*)
	 */
	protected void sequence_LayerMdsl(EObject context, LayerMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_LiteraPropValueExprFragment(EObject context, LiteraPropValueExprFragment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.LITERA_PROP_VALUE_EXPR_FRAGMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.LITERA_PROP_VALUE_EXPR_FRAGMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLiteraPropValueExprFragmentAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_LiteralFormatExprFragment(EObject context, LiteralFormatExprFragment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.LITERAL_FORMAT_EXPR_FRAGMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.LITERAL_FORMAT_EXPR_FRAGMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLiteralFormatExprFragmentAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_LiteralQueryFragment(EObject context, LiteralQueryFragment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.LITERAL_QUERY_FRAGMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.LITERAL_QUERY_FRAGMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLiteralQueryFragmentAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (imports+=Import* configElements+=MADConfigElement*)
	 */
	protected void sequence_MADConfiguration(EObject context, MADConfiguration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (label=STRING classDescriptor=ClassDescriptorMdsl description=STRING?)
	 */
	protected void sequence_OCLCustomLibraryMdsl(EObject context, OCLCustomLibraryMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (propertyName=[PropertyTypeMdsl|ID] propertyValue=PropertyValueMdsl)
	 */
	protected void sequence_PropertyMdsl(EObject context, PropertyMdsl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.PROPERTY_MDSL__PROPERTY_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.PROPERTY_MDSL__PROPERTY_NAME));
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.PROPERTY_MDSL__PROPERTY_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.PROPERTY_MDSL__PROPERTY_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPropertyMdslAccess().getPropertyNamePropertyTypeMdslIDTerminalRuleCall_0_0_1(), semanticObject.getPropertyName());
		feeder.accept(grammarAccess.getPropertyMdslAccess().getPropertyValuePropertyValueMdslParserRuleCall_2_0(), semanticObject.getPropertyValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID label=STRING)
	 */
	protected void sequence_PropertyTypeMdsl(EObject context, PropertyTypeMdsl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.PROPERTY_TYPE_MDSL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.PROPERTY_TYPE_MDSL__NAME));
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.PROPERTY_TYPE_MDSL__LABEL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.PROPERTY_TYPE_MDSL__LABEL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPropertyTypeMdslAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPropertyTypeMdslAccess().getLabelSTRINGTerminalRuleCall_2_0(), semanticObject.getLabel());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (fragments+=PropValueExprFragment fragments+=PropValueExprFragment*)
	 */
	protected void sequence_PropertyValueMdsl(EObject context, PropertyValueMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     converterQuery=QueryUsage
	 */
	protected void sequence_QueryBasedValueConverter(EObject context, QueryBasedValueConverter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.QUERY_BASED_VALUE_CONVERTER__CONVERTER_QUERY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getQueryBasedValueConverterAccess().getConverterQueryQueryUsageParserRuleCall_1_0(), semanticObject.getConverterQuery());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (fragments+=QueryFragment fragments+=QueryFragment*)
	 */
	protected void sequence_QueryBody(EObject context, QueryBody semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (queries+=Query+ queries+=Query*)
	 */
	protected void sequence_QueryChain(EObject context, QueryChain semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID label=STRING? description=STRING? definition=QueryDefinitionMdsl)
	 */
	protected void sequence_QueryDeclaration(EObject context, QueryDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         evaluator=[QueryEvaluatorMdsl|ID]? 
	 *         foreignModel=[ForeignModelMdsl|ID]? 
	 *         contextLocator=STRING? 
	 *         (query=QueryBody | externalQueryCall=ExternalQueryCallMdsl) 
	 *         returnType=[EClassifier|ID]? 
	 *         (properties+=PropertyMdsl properties+=PropertyMdsl*)? 
	 *         optimisationLevel=QUERY_OPTIMISATION_LEVEL?
	 *     )
	 */
	protected void sequence_QueryDefinitionMdsl(EObject context, QueryDefinitionMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         label=STRING 
	 *         classDescriptor=ClassDescriptorMdsl 
	 *         (queryPropertiesTypes+=PropertyTypeMdsl queryPropertiesTypes+=PropertyTypeMdsl*)? 
	 *         extQServiceClassDescriptor=ClassDescriptorMdsl? 
	 *         description=STRING?
	 *     )
	 */
	protected void sequence_QueryEvaluatorMdsl(EObject context, QueryEvaluatorMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     referenced=[QueryDeclaration|ID]
	 */
	protected void sequence_QueryRefMdsl(EObject context, QueryRefMdsl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.QUERY_REF_MDSL__REFERENCED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.QUERY_REF_MDSL__REFERENCED));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getQueryRefMdslAccess().getReferencedQueryDeclarationIDTerminalRuleCall_0_1(), semanticObject.getReferenced());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {ReloadViewUICommand}
	 */
	protected void sequence_ReloadViewUICommand(EObject context, ReloadViewUICommand semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     widgetsToReload+=[WidgetConfigurationMdsl|ID]+
	 */
	protected void sequence_ReloadWidgetsUICommand(EObject context, ReloadWidgetsUICommand semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     referenced=[TextMacro|ID]
	 */
	protected void sequence_TextMacroRef(EObject context, TextMacroRef semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.TEXT_MACRO_REF__REFERENCED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.TEXT_MACRO_REF__REFERENCED));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTextMacroRefAccess().getReferencedTextMacroIDTerminalRuleCall_1_0_1(), semanticObject.getReferenced());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID label=STRING? description=STRING? macroValue=STRING)
	 */
	protected void sequence_TextMacro(EObject context, TextMacro semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         defaultConfiguration?='DEFAULT'? 
	 *         name=ID 
	 *         type=[EClass|ID]? 
	 *         (i18NLabelProvider?='I18N'? labelProviderExpression=FormatExpr)? 
	 *         (useExplicitExtends?='extends:' superConfigurations+=[TypeConfigurationMdsl|ID] superConfigurations+=[TypeConfigurationMdsl|ID]*)? 
	 *         templateElements+=TypeConfigurationTemplateElement* 
	 *         (layoutDefined?='layout:' layoutElements+=[WidgetConfigurationMdsl|ID]*)?
	 *     )
	 */
	protected void sequence_TypeConfigurationMdsl(EObject context, TypeConfigurationMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID i18NLabel?='I18N'? labelFormatExpr=FormatExpr description=STRING?)
	 */
	protected void sequence_UITabMdsl(EObject context, UITabMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     uriExtension=STRING
	 */
	protected void sequence_URIExtensionModelProviderMdsl(EObject context, URIExtensionModelProviderMdsl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.URI_EXTENSION_MODEL_PROVIDER_MDSL__URI_EXTENSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.URI_EXTENSION_MODEL_PROVIDER_MDSL__URI_EXTENSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getURIExtensionModelProviderMdslAccess().getUriExtensionSTRINGTerminalRuleCall_1_0(), semanticObject.getUriExtension());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     modelUri=STRING
	 */
	protected void sequence_URIModelProviderMdsl(EObject context, URIModelProviderMdsl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.URI_MODEL_PROVIDER_MDSL__MODEL_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.URI_MODEL_PROVIDER_MDSL__MODEL_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getURIModelProviderMdslAccess().getModelUriSTRINGTerminalRuleCall_1_0(), semanticObject.getModelUri());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (validationQuery=QueryUsage i18NMessage?='I18N'? errorMessageExpr=FormatExpr)
	 */
	protected void sequence_ValidatorMdsl(EObject context, ValidatorMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         description=STRING? 
	 *         uiTab=[UITabMdsl|ID]? 
	 *         (layers+=[LayerMdsl|ID] layers+=[LayerMdsl|ID]*)? 
	 *         i18NLabel?='I18N'? 
	 *         label=FormatExpr 
	 *         widgetCategory=WIDGET_CATEGORY_MDSL 
	 *         widgetType=[WidgetType|ID]? 
	 *         dslReference=XtextLanguageReference? 
	 *         flexibleTemplate=[TypeConfigurationMdsl|ID]? 
	 *         visibilityQuery=Query? 
	 *         editableQuery=Query? 
	 *         valueQuery=QueryUsage? 
	 *         valueConverter=ValueConverter? 
	 *         validators+=ValidatorMdsl* 
	 *         (i18NFormat?='I18N'? valueFormat=FormatExpr)? 
	 *         candidatesQuery=QueryUsage? 
	 *         (i18NItemLabel?='I18N'? itemLabelExpression=FormatExpr)? 
	 *         (commands+=Command commands+=Command*)?
	 *     )
	 */
	protected void sequence_WidgetConfigurationMdsl(EObject context, WidgetConfigurationMdsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID category=WIDGET_CATEGORY_MDSL label=STRING classDescriptor=ClassDescriptorMdsl description=STRING?)
	 */
	protected void sequence_WidgetType(EObject context, WidgetType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID languageId=ID bundleId=ID activatorClassName=ID)
	 */
	protected void sequence_XtextLanguageDescriptorMdsl(EObject context, XtextLanguageDescriptorMdsl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__NAME));
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID));
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID));
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getXtextLanguageDescriptorMdslAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getXtextLanguageDescriptorMdslAccess().getLanguageIdIDTerminalRuleCall_3_0(), semanticObject.getLanguageId());
		feeder.accept(grammarAccess.getXtextLanguageDescriptorMdslAccess().getBundleIdIDTerminalRuleCall_5_0(), semanticObject.getBundleId());
		feeder.accept(grammarAccess.getXtextLanguageDescriptorMdslAccess().getActivatorClassNameIDTerminalRuleCall_7_0(), semanticObject.getActivatorClassName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     xtextLanguageDescriptor=[XtextLanguageDescriptorMdsl|ID]
	 */
	protected void sequence_XtextLanguageReference(EObject context, XtextLanguageReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MadConfigDslPackage.Literals.XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MadConfigDslPackage.Literals.XTEXT_LANGUAGE_REFERENCE__XTEXT_LANGUAGE_DESCRIPTOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getXtextLanguageReferenceAccess().getXtextLanguageDescriptorXtextLanguageDescriptorMdslIDTerminalRuleCall_1_0_1(), semanticObject.getXtextLanguageDescriptor());
		feeder.finish();
	}
}
