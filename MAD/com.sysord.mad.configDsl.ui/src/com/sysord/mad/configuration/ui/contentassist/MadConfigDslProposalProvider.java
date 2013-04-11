/*
* generated by Xtext
*/
package com.sysord.mad.configuration.ui.contentassist;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationService;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationServiceProvider;
import com.sysord.mad.configuration.madConfigDsl.ExternalQueryCallMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.TypeConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class MadConfigDslProposalProvider extends AbstractMadConfigDslProposalProvider {

	@Inject
	protected ExternalQueryConfigurationServiceProvider extQServiceProvider;

	
	/**
	 * Filter: for exclude qualifiaedName with nsURI (like http://....)
	 */
	protected Predicate<IEObjectDescription> fullNsUriExclusion = new Predicate<IEObjectDescription>() {
		@Override
		public boolean apply(IEObjectDescription objectDescription) {
			String nsURI = objectDescription.getUserData("nsURI");
			return "false".equals(nsURI);
		}
	};

	
	/**
	 * Filter: for exclude qualifiedName with nsURI (like http://....)
	 */
	@Override
	public void completeTypeConfigurationMdsl_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {								
		lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor, fullNsUriExclusion);
	}

	@Override
	public void completeQueryDefinitionMdsl_ReturnType(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor, fullNsUriExclusion);
	}

	
	/**
	 * Filter layouts element proposal for exclude widgets since in layout
	 */
	@Override
	public void completeTypeConfigurationMdsl_LayoutElements(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		
		//filter layouts element proposal for exclude widgets since in layout
		final TypeConfigurationMdsl typeConfig = (TypeConfigurationMdsl) model;
		final List<WidgetConfigurationMdsl> definedLayoutElements = typeConfig.getLayoutElements();
		
		Predicate<IEObjectDescription> filter = new Predicate<IEObjectDescription>() {			
			@Override
			public boolean apply(IEObjectDescription elementDescription) {
				WidgetConfigurationMdsl widgetConfig = (WidgetConfigurationMdsl) elementDescription.getEObjectOrProxy();
				widgetConfig = (WidgetConfigurationMdsl) EcoreUtil.resolve(widgetConfig, typeConfig.eResource());
				return !definedLayoutElements.contains(widgetConfig);
			}
		};
		lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor, filter);
	}

	
	
	/**
	 * Create label for external Queries call proposal
	 */
	@Override
	public void completeExternalQueryCallMdsl_ExternalQuery(EObject model, Assignment assignment, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {

		CrossReference crossReference = (CrossReference)assignment.getTerminal();
		EReference target = GrammarUtil.getReference(crossReference);
		if(target == null){
			return;
		}

		ExternalQueryCallMdsl extQCallMdsl = (ExternalQueryCallMdsl) contentAssistContext.getCurrentModel();
		//retrieve evaluator from QueryDefinitionMdsl
		QueryDefinitionMdsl queryDefMdsl = (QueryDefinitionMdsl) extQCallMdsl.eContainer(); 
		if(queryDefMdsl.getEvaluator() == null){
			return;
		}
		
		
		
		ExternalQueryConfigurationService extQService = extQServiceProvider.getExtQService(queryDefMdsl.getEvaluator()); 
		if(extQService != null){
			IScope scope = getScopeProvider().getScope(extQCallMdsl, target);
			for (IEObjectDescription scopeElement : scope.getAllElements()) {
				EObject externalQueryElement = scopeElement.getEObjectOrProxy();
				String queryLabel = extQService.getQueryLabel(externalQueryElement);
				String queryCall = extQService.getQueryCallExpr(externalQueryElement);
				
				ICompletionProposal completionProposal = createCompletionProposal(queryCall, queryLabel, getImage(externalQueryElement), contentAssistContext);
				acceptor.accept(completionProposal);
			}			
		}

	}
	
	
	
}
