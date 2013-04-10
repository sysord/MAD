package com.sysord.mad.configuration.validation;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ImportUriValidator;

import com.google.inject.Inject;
import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.I18NBundleMdsl;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.QueryBasedValueConverter;
import com.sysord.mad.configuration.madConfigDsl.WIDGET_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.WidgetConfigurationMdsl;
import com.sysord.mad.configuration.madConfigDsl.XtextLanguageDescriptorMdsl;
import com.sysord.mad.configuration.util.MadConfigDslUtil;
import com.sysord.xtext.tools.XtextLanguageDescriptor;
import com.sysord.xtext.tools.XtextUtility;
 

public class MadConfigDslJavaValidator extends AbstractMadConfigDslJavaValidator {

	//TODO: Warning when query type is not defined
	
	//TODO: allow context relocator only for foreign model query
	
	
	protected List<WIDGET_CATEGORY_MDSL> selectWidgetCategory = Arrays.asList(new WIDGET_CATEGORY_MDSL[]{
																				WIDGET_CATEGORY_MDSL.SINGLE_SELECT_WIDGET,
																				WIDGET_CATEGORY_MDSL.MULTI_SELECT_WIDGET
																			});
	
	/**
	 * validate access to the descripted class.
	 * if fail create a warning
	 * @param classDescriptor
	 */
	@Check
	public void checkClassDescriptor(ClassDescriptorMdsl classDescriptor){
//		if(classDescriptor.eContainer() != null && I18NBundleMdsl.class.isAssignableFrom(classDescriptor.eContainer().getClass())){
//			//Don't check I18N bundle here
//			return;
//		}
		if(MadConfigDslUtil.resolveClassDescriptorMdsl(classDescriptor) == null){
			warning("Can't find class in this environment.", MadConfigDslPackage.Literals.CLASS_DESCRIPTOR_MDSL__CLASS_NAME);			
		}
	}
	
	@Check
	public void checkI18NBungleDescriptor(I18NBundleMdsl i18nBundle){
		if(i18nBundle.getBundleUri() != null){
			//validate URI		
			if(!EcoreUtil2.isValidUri(i18nBundle, URI.createURI(i18nBundle.getBundleUri()))){
				warning("Can't find resource in this environment.", MadConfigDslPackage.Literals.I18N_BUNDLE_MDSL__BUNDLE_URI);							
			}
		}
	}
	
	/**
	 * Validate XtextLanguage descriptor:
	 * try to obtain the language injector
	 * @param xtextLanguageDescriptor
	 */
	@Check
	public void checkXtextDslDescriptor(XtextLanguageDescriptorMdsl xtextLanguageDescriptor){
		XtextLanguageDescriptor languageDescriptor = XtextUtility.createLanguageDescriptor(
						xtextLanguageDescriptor.getBundleId(), 
						xtextLanguageDescriptor.getActivatorClassName(), 
						xtextLanguageDescriptor.getLanguageId()
					);
		if(languageDescriptor == null){
			warning("Can't find Xtext language in this environment.", MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__ACTIVATOR_CLASS_NAME);						
			warning("Can't find Xtext language in this environment.", MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__BUNDLE_ID);						
			warning("Can't find Xtext language in this environment.", MadConfigDslPackage.Literals.XTEXT_LANGUAGE_DESCRIPTOR_MDSL__LANGUAGE_ID);	
		}
	}
	
	/**
	 * a set of control on widget configuration
	 * @param widgetConfig
	 */
	@Check
	public void checkWidgetConfiguration(WidgetConfigurationMdsl widgetConfig){
		
		//Value is mandatory for all widgets except : Navigation Widget
		if(widgetConfig.getWidgetCategory() != WIDGET_CATEGORY_MDSL.NAVIGATION_WIDGET){
			if(widgetConfig.getValueQuery() == null ){
				error("Query value configuration is missing.", MadConfigDslPackage.Literals.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY);
			}			
		}else{
			if(widgetConfig.getValueQuery() != null ){
				error("Query value configuration is not allowed for navigation widget use candidates.", MadConfigDslPackage.Literals.TYPE_CONFIGURATION_TEMPLATE_ELEMENT__VALUE_QUERY);
			}						
		}

		//Candidates is mandatory for Select widgets and navigation widget
		if((selectWidgetCategory.contains(widgetConfig.getWidgetCategory()) || widgetConfig.getWidgetCategory() == WIDGET_CATEGORY_MDSL.NAVIGATION_WIDGET)){
			if(widgetConfig.getCandidatesQuery() == null){				
				error("Query for provide candidates is missing.", MadConfigDslPackage.Literals.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY);										
			}
		}else{
			if(widgetConfig.getCandidatesQuery() != null){				
				error("Query for provide candidates is not allowed for " +  widgetConfig.getWidgetCategory() + " widgets.", MadConfigDslPackage.Literals.WIDGET_CONFIGURATION_MDSL__CANDIDATES_QUERY);										
			}			
		}
		
		
		//Value converter is only allowed on input and output text widget
		if(widgetConfig.getWidgetCategory() != WIDGET_CATEGORY_MDSL.TEXT_WIDGET 
				&& widgetConfig.getWidgetCategory() != WIDGET_CATEGORY_MDSL.OUTPUTTEXT_WIDGET){
			
			if(widgetConfig.getValueConverter() != null){
				error("Value converter are only allowed for TEXT_WIDGET or OUTPUTTEXT_WIDGET.", MadConfigDslPackage.Literals.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER);														
			}

		}

		//Value format is only allowed on output text widget
		if(widgetConfig.getWidgetCategory() != WIDGET_CATEGORY_MDSL.OUTPUTTEXT_WIDGET){			
			if(widgetConfig.getValueFormat() != null){
				error("Value formatter are only allowed for OUTPUTTEXT_WIDGET.", MadConfigDslPackage.Literals.WIDGET_CONFIGURATION_MDSL__VALUE_FORMAT);														
			}

		}

		
		//xtext language descriptor is mandatory for xtext widgets
		if(	(widgetConfig.getWidgetCategory() == WIDGET_CATEGORY_MDSL.XTEXT_EDITOR 
				|| widgetConfig.getWidgetCategory() == WIDGET_CATEGORY_MDSL.XTEXT_EDITOR) 
			&& widgetConfig.getDslReference() == null){
			error("Missing DSL descriptor.", MadConfigDslPackage.Literals.WIDGET_CONFIGURATION_MDSL__DSL_REFERENCE);			
		}
		
		// QueryBasedValueConverter not implemented
		if(widgetConfig.getValueConverter() != null 
			&& QueryBasedValueConverter.class.isAssignableFrom(widgetConfig.getValueConverter().getClass()) ){
			error("QueryBasedValueConverter is not implemented",
					MadConfigDslPackage.Literals.WIDGET_CONFIGURATION_MDSL__VALUE_CONVERTER);						
		}
		
	}
	

}
