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
package com.sysord.xtext.tools;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.util.CancelIndicator;
import org.osgi.framework.BundleActivator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.diagnostic.Diagnostic;
import com.sysord.eclipse.tools.diagnostic.Diagnostic.DIAGNOSTIC_LEVEL;
import com.sysord.eclipse.tools.diagnostic.DiagnosticFactory;

public class XtextUtility {

	
	/**
	 * Create a Xtext Language Descriptor from language informations
	 * 
	 * @param bundleId
	 * @param activatorClassName
	 * @param languageId
	 * @return
	 */
	public static XtextLanguageDescriptor createLanguageDescriptor(String bundleId, String activatorClassName, String languageId){
		try {
			Class<? extends BundleActivator> activatorClass = EclipseTools.findClass(bundleId, activatorClassName);
			if(activatorClass == null){
				return null;
			}			
			Method instanceAccessMethod = activatorClass.getMethod("getInstance");			
			BundleActivator activator = (BundleActivator) instanceAccessMethod.invoke(null);
			if(activator == null){
				return null;
			}
			
			//Validate Language id (must be defined in a activator class constant)
			boolean isLanguageIdValid = false;
			for(Field field : activator.getClass().getFields()){
				Object fieldValuevalue = field.get(activator.getClass());
				if(languageId.equals(fieldValuevalue)){
					isLanguageIdValid = true;
					break;
				}
			}
			if(!isLanguageIdValid){
				return null;
			}
			
			return new XtextLanguageDescriptor(bundleId, activatorClass, activator, languageId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * returns the Google Guice Injector for a Xtext Language
	 * 
	 * @param bundleId id of the plugin
	 * @param activatorClassName full qualified name of the plugin activator
	 * @return
	 */
	public static Injector getLanguageInjector(String bundleId, String activatorClassName, String languageId){
		try {
			Class<?> activatorClass = EclipseTools.findClass(bundleId, activatorClassName); 
			Method getDefaultMethod = activatorClass.getMethod("getInstance");
			Object activator = getDefaultMethod.invoke(null);
			Method getInjectorMethod = activatorClass.getMethod("getInjector", String.class);
			return (Injector) getInjectorMethod.invoke( activator, languageId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	/**
	 * returns the Google Guice Injector for a Xtext Language
	 * 
	 * @param bundleId id of the plugin
	 * @param activatorClassName full qualified name of the plugin activator
	 * @return
	 */
	public static Injector getLanguageInjector(XtextLanguageDescriptor languageDescriptor){
		try {
			Method getInjectorMethod = languageDescriptor.activatorClass.getMethod("getInjector", String.class);
			return (Injector) getInjectorMethod.invoke(languageDescriptor.activator, languageDescriptor.languageId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static XtextResource loadXtextResource(URI resourceUri) throws IOException{
		XtextResourceSet resourceSet = new XtextResourceSet();
		XtextResource resource = (XtextResource) resourceSet.createResource(resourceUri);
		resource.load(null);
		return resource;
	}
	
	/**
	 * Save the Xtext resource, a validation is done before saving for avoid lost of file content on error
	 * if validation fails, an exception is thrown
	 * @param xtextResource
	 * @param format
	 * @throws IOException
	 */
	public static void saveXtextResource(XtextResource xtextResource, boolean format) throws XtextToolsException{
		try {
			
			//Resource validation
			Diagnostic validationDiagnostic = validateXtextResource(xtextResource);
			if(validationDiagnostic.getLevel() == DIAGNOSTIC_LEVEL.ERROR){
				throw new XtextToolsException("Invalid XtextResource " + xtextResource.getURI() + " " + validationDiagnostic.getDescription());				
			}
			
			//try serialize for discovering syntax errors
			try{
				xtextResource.getSerializer().serialize(xtextResource.getContents().get(0));			
			}catch(Exception e){
				throw new XtextToolsException("Invalid XtextResource " + xtextResource.getURI() + " " + e.getMessage());				
			}


			//Define save options
			Map<Object,Object>  options =  new HashMap<Object, Object>();
			SaveOptions.Builder optionsBuilder = SaveOptions.newBuilder();
			if(format){
				optionsBuilder.format();
			}
			optionsBuilder.getOptions().addTo(options);
			//Save
			xtextResource.save(options);
			
		} catch (XtextToolsException e) {
			throw e;
		} catch (Exception e) {			
			e.printStackTrace();
			throw new XtextToolsException("Fail to save the XtextResource", e);
		}

	}
	
	public static class LanguageProperties{
		@Inject
		@Named("file.extensions")
		public String extension;
	}
	
	public static LanguageProperties getLanguageProperties(Injector languageInjector){
		return languageInjector.getInstance(LanguageProperties.class);
	}

	
	//-------------------------
	// XTEXT Resource Validation
	//-------------------------
	
	public enum XTEXT_ERROR_LEVEL{
		NO_ERROR,
		WARNING,
		CRITICAL_ERROR,
	}
	
	public static Diagnostic validateXtextResource(XtextResource xtextResource){
				
		EcoreUtil2.resolveLazyCrossReferences(xtextResource, defaultCancelIndicator());
		boolean hasError = !xtextResource.getErrors().isEmpty();
		

		
		if(!hasError){
			return DiagnosticFactory.createNoErrorsDiagnostic();
		}
			
		//analyse error
		boolean hasCriticalError = false;

		StringBuilder diagDescription = new StringBuilder();
		
		if(hasError){
			//dump errors
			for(org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic : xtextResource.getErrors()){
				if(XtextSyntaxDiagnostic.class.isAssignableFrom(diagnostic.getClass())){
					//syntax error
					hasCriticalError = true;
					diagDescription.append("GRAVE:");
					System.out.println("GRAVE:" + diagnostic.getLine() + " " + diagnostic.toString());						
				}else{
					diagDescription.append("WARNING:");
					System.out.println("WARNING:" + diagnostic.getLine() + " " + diagnostic.toString());						
				}
				diagDescription.append(" (Line").append(diagnostic.getLine()).append(") ").append(diagnostic.toString()).append("\n");
			}					
		}

		if(hasCriticalError){
			return DiagnosticFactory.createErrorDiagnostic("Xtext resource contains Errors", diagDescription.toString());
		}else{
			return DiagnosticFactory.createWarningDiagnostic("Xtext resource contains warnings", diagDescription.toString());
		} 
	}


	
	
	
	
	/**
	 * create and returns a basic cancel indicator
	 * @return
	 */
	public static CancelIndicator defaultCancelIndicator(){
		return new CancelIndicator() {public boolean isCanceled(){return false;}};
	}
	
	
	public static String dumpElement(EObject element){
		ICompositeNode compositeNode = NodeModelUtils.findActualNodeFor(element);
		if(compositeNode != null){
			String dump = compositeNode.getText();
			//System.out.println(dump);
			return dump;
		}else{
			System.err.println("dumpElement failed for " + element);
			return "dumpElement failed for " + element;
		}
	}

	/**
	 * Returns the number of tabs characters before the element.
	 * @param element
	 * @return
	 */
	public static int getIdentLevel(EObject element){
		ICompositeNode compositeNode = NodeModelUtils.findActualNodeFor(element);
		if(compositeNode != null){
			String dump = compositeNode.getText();
			int deltaOffset = compositeNode.getOffset() - compositeNode.getTotalOffset();
			int nbTabs = 0;
			int i = deltaOffset - 1;
			while(i >= 0 && dump.charAt(i) == '\t'){
				nbTabs++;
				i--;
			}
			return nbTabs;
		}else{
			System.err.println("getIdentLevel failed for " + element);
			return -1;
		}
	}

}
