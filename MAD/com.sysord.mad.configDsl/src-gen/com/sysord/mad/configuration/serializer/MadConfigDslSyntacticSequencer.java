package com.sysord.mad.configuration.serializer;

import com.google.inject.Inject;
import com.sysord.mad.configuration.services.MadConfigDslGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class MadConfigDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MadConfigDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_CommandDefinitionMdsl_OnErrorKeyword_6_0_q;
	protected AbstractElementAlias match_CommandDefinitionMdsl_OnSuccessKeyword_5_0_q;
	protected AbstractElementAlias match_ForeignModelMdsl_OptionsKeyword_8_0_q;
	protected AbstractElementAlias match_LayerMdsl___SubKeyword_7_0_LayersKeyword_7_1_LeftCurlyBracketKeyword_7_2_RightCurlyBracketKeyword_7_4__q;
	protected AbstractElementAlias match_WidgetConfigurationMdsl_FlexibleTemplateKeyword_12_0_0_or_TargetTemplateKeyword_12_0_1;
	protected AbstractElementAlias match_WidgetConfigurationMdsl_ValidatorsKeyword_16_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MadConfigDslGrammarAccess) access;
		match_CommandDefinitionMdsl_OnErrorKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getCommandDefinitionMdslAccess().getOnErrorKeyword_6_0());
		match_CommandDefinitionMdsl_OnSuccessKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getCommandDefinitionMdslAccess().getOnSuccessKeyword_5_0());
		match_ForeignModelMdsl_OptionsKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getForeignModelMdslAccess().getOptionsKeyword_8_0());
		match_LayerMdsl___SubKeyword_7_0_LayersKeyword_7_1_LeftCurlyBracketKeyword_7_2_RightCurlyBracketKeyword_7_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getLayerMdslAccess().getSubKeyword_7_0()), new TokenAlias(false, false, grammarAccess.getLayerMdslAccess().getLayersKeyword_7_1()), new TokenAlias(false, false, grammarAccess.getLayerMdslAccess().getLeftCurlyBracketKeyword_7_2()), new TokenAlias(false, false, grammarAccess.getLayerMdslAccess().getRightCurlyBracketKeyword_7_4()));
		match_WidgetConfigurationMdsl_FlexibleTemplateKeyword_12_0_0_or_TargetTemplateKeyword_12_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getWidgetConfigurationMdslAccess().getFlexibleTemplateKeyword_12_0_0()), new TokenAlias(false, false, grammarAccess.getWidgetConfigurationMdslAccess().getTargetTemplateKeyword_12_0_1()));
		match_WidgetConfigurationMdsl_ValidatorsKeyword_16_0_q = new TokenAlias(false, true, grammarAccess.getWidgetConfigurationMdslAccess().getValidatorsKeyword_16_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_CommandDefinitionMdsl_OnErrorKeyword_6_0_q.equals(syntax))
				emit_CommandDefinitionMdsl_OnErrorKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CommandDefinitionMdsl_OnSuccessKeyword_5_0_q.equals(syntax))
				emit_CommandDefinitionMdsl_OnSuccessKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ForeignModelMdsl_OptionsKeyword_8_0_q.equals(syntax))
				emit_ForeignModelMdsl_OptionsKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LayerMdsl___SubKeyword_7_0_LayersKeyword_7_1_LeftCurlyBracketKeyword_7_2_RightCurlyBracketKeyword_7_4__q.equals(syntax))
				emit_LayerMdsl___SubKeyword_7_0_LayersKeyword_7_1_LeftCurlyBracketKeyword_7_2_RightCurlyBracketKeyword_7_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_WidgetConfigurationMdsl_FlexibleTemplateKeyword_12_0_0_or_TargetTemplateKeyword_12_0_1.equals(syntax))
				emit_WidgetConfigurationMdsl_FlexibleTemplateKeyword_12_0_0_or_TargetTemplateKeyword_12_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_WidgetConfigurationMdsl_ValidatorsKeyword_16_0_q.equals(syntax))
				emit_WidgetConfigurationMdsl_ValidatorsKeyword_16_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'on error:'?
	 */
	protected void emit_CommandDefinitionMdsl_OnErrorKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'on success:'?
	 */
	protected void emit_CommandDefinitionMdsl_OnSuccessKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'options:'?
	 */
	protected void emit_ForeignModelMdsl_OptionsKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('Sub' 'layers' '{' '}')?
	 */
	protected void emit_LayerMdsl___SubKeyword_7_0_LayersKeyword_7_1_LeftCurlyBracketKeyword_7_2_RightCurlyBracketKeyword_7_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'target template:' | 'flexible template:'
	 */
	protected void emit_WidgetConfigurationMdsl_FlexibleTemplateKeyword_12_0_0_or_TargetTemplateKeyword_12_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'validators:'?
	 */
	protected void emit_WidgetConfigurationMdsl_ValidatorsKeyword_16_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
