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
package com.sysord.xtext.tools.editor;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.CancelIndicator;

import com.sysord.xtext.tools.XtextUtility;


public class XtextElementEditorHelper {
	
	/**
	 * Load a resource and return the associated XtextResource
	 * 
	 * if resource loaded is a XtextResource return it,
	 * 
	 * @param resourceName
	 * @param resolveAll if true all proxies are resolved
	 * 
	 * @return 
	 * 
	 * @throws XtextElementEditorException
	 */
	public static XtextResource loadXtextRessource(String resourceName, boolean resolveAll) throws XtextElementEditorException{
		return _loadXtextRessource(resourceName, resolveAll, null);
	}

	/**
	 * Load a resource and return the associated XtextResource
	 * 
	 * if resource loaded is a XtextResource return it,
	 * else create an XtextResource for the language and fill it using adhock serializer
	 * 
	 * @param resourceName
	 * @param resolveAll
	 * @param xtextLanguageExtension
	 * @return
	 * @throws XtextElementEditorException
	 */
	public static XtextResource loadXtextRessource(String resourceName, boolean resolveAll, String xtextLanguageExtension) throws XtextElementEditorException{
		return _loadXtextRessource(resourceName, resolveAll, xtextLanguageExtension);
	}

	/**
	 * Load a resource and return the associated XtextResource
	 * 
	 * @param resourceName
	 * @param resolveAll	if true all proxies are resolved
	 * @param xtextLanguageExtension
	 * @return
	 * @throws XtextElementEditorException
	 */
	private static XtextResource _loadXtextRessource(String resourceName, boolean resolveAll, String xtextLanguageExtension) throws XtextElementEditorException{
		
		ResourceSet resourceSet = new ResourceSetImpl();
		URI resourceUri = URI.createURI(resourceName);
		Resource resource = resourceSet.getResource(resourceUri, true);
		if(resource == null){
			throw new XtextElementEditorException("Failed to load resource " + resourceName);
		}

		//resolve all proxies
    	if(resolveAll){
    		EcoreUtil.resolveAll(resource);
    	}
    	
    	XtextResource xtextResource;
    	
    	//if its a Xtrextresource return it else try to create a XtextResource
    	if(XtextResource.class.isAssignableFrom(resource.getClass())){
    		xtextResource = (XtextResource) resource;
    	}else{
    		if(xtextLanguageExtension != null){
    			xtextResource = convertToXtextResource(resource, xtextLanguageExtension);
    		}else{
    			throw new XtextElementEditorException("Failed to load resource " + resourceName + " as XtextResource.");
    		}
    	}
    	
		return xtextResource;
	}

	
	/**
	 * Convert resource to XtextResource for the language with xtextLanguageExtension extension
	 * 
	 * @param resource
	 * @param xtextLanguageExtension
	 * @return
	 * @throws XtextElementEditorException
	 */
	private static XtextResource convertToXtextResource(Resource resource, String xtextLanguageExtension) throws XtextElementEditorException{
		
		//TODO get an Injector: obtain Bundle by name and get injector
		//Injector injector = UmllDslActivator.getInstance().getInjector(UmllDslActivator.COM_SYSORD_UMLLDSL);
		
		XtextResourceSet xtextResourceSet = new XtextResourceSet(); //injector.getInstance(XtextResourceSet.class);
		ISerializer serializer = null;//injector.getInstance(ISerializer.class);
		
		//create xtext language Uri
		URI uri = URI.createURI(resource.getURI().lastSegment() + "." + xtextLanguageExtension);
		XtextResource xtextResource = (XtextResource) xtextResourceSet.createResource(uri);
		if(xtextResource == null){
			throw new XtextElementEditorException("Failed to create XtextResource for language " + xtextLanguageExtension);
		}
		
		try {
			//Serialize resource as text
			String resourceAsText = xtextResource.getSerializer().serialize(resource.getContents().get(0));
			//Fill xtextResource
			xtextResource.reparse(resourceAsText);
		} catch (Exception e) {
			e.printStackTrace();
			throw new XtextElementEditorException("XtextResource " + uri.toString() + " parse failed.", e);
		}

		return xtextResource;
	}
	
	/**
	 * Textual representation for a model and 
	 * an edited element
	 */
	public static class XtextEditedElementTextConfiguration {
		String fragmentUri;
		String textBefore;
		String textElement;
		String textAfter;		
	}
	
	public static XtextEditedElementTextConfiguration createXtextEditedElementConfiguration(XtextResource xtextResource, String editedElementFragmentUri) throws XtextElementEditorException{
				
		//look for element node (force reparse)
		reparseResource(xtextResource);			
		ICompositeNode xtextElementNode = getCompositeNode(xtextResource, editedElementFragmentUri, false);

		String fullModelText = xtextResource.getParseResult().getRootNode().getText();
		XtextEditedElementTextConfiguration editedElementText = new XtextEditedElementTextConfiguration();
		editedElementText.fragmentUri = editedElementFragmentUri;
		editedElementText.textBefore = fullModelText.substring(0, xtextElementNode.getOffset());
		editedElementText.textElement = fullModelText.substring(xtextElementNode.getOffset(),xtextElementNode.getOffset() + xtextElementNode.getLength());
		editedElementText.textAfter = fullModelText.substring(xtextElementNode.getOffset() + xtextElementNode.getLength());

		return editedElementText;
	}
	
	protected static ICompositeNode getCompositeNode(XtextResource xtextResource, String ElementFragmentUri, boolean allowReparse) throws XtextElementEditorException{
		EObject element = xtextResource.getEObject(ElementFragmentUri);
		if(element == null){
			throw new XtextElementEditorException("Edited element not found with FragmentUri " + ElementFragmentUri);
		}
		return _retrieveCompositeNode(xtextResource, ElementFragmentUri, !allowReparse);
	}
	

	private static ICompositeNode getCompositeNode(EObject semanticElement) {
		return NodeModelUtils.findActualNodeFor(semanticElement);
	}

	protected static ICompositeNode _retrieveCompositeNode(XtextResource xtextResource, String ElementFragmentUri, boolean hasBeenReparsed) throws XtextElementEditorException{
		EObject element = xtextResource.getEObject(ElementFragmentUri);
		ICompositeNode xtextElementNode = getCompositeNode(element);
		if (xtextElementNode != null) {
			return xtextElementNode;
		}else{
			//NOT FOUND
			if(hasBeenReparsed){
				//has been reparsed: so can't find node
				throw new XtextElementEditorException("Not node found for element " + element);				
			}else{
				//reparse and retry
				reparseResource(xtextResource);			
				return _retrieveCompositeNode(xtextResource, ElementFragmentUri, true);
			}
		}
	}
	
	protected static void reparseResource(XtextResource xtextResource) throws XtextElementEditorException{
		try {
			xtextResource.reparse(xtextResource.getSerializer().serialize(xtextResource.getContents().get(0)));
		} catch (IOException e) {
			throw new XtextElementEditorException(e);
		}
	}
	
	
	public static EObject mergeXtextEditedElement(XtextResource editedResource, String editedElementFragmentUri, XtextResource mergedResource, boolean persist) throws XtextElementEditorException{

		try {

			//get original resource and element 
			XtextEditedElementTextConfiguration orgEditedElementTextConfiguration = createXtextEditedElementConfiguration(mergedResource, editedElementFragmentUri);				
			
			//get edited state
			XtextEditedElementTextConfiguration newEditedElementTextConfiguration = createXtextEditedElementConfiguration(editedResource, editedElementFragmentUri);		
			
			//merge: insert new text
			StringBuffer sbNewText = new StringBuffer();
			sbNewText.append(orgEditedElementTextConfiguration.textBefore)
					.append(newEditedElementTextConfiguration.textElement)
					.append(orgEditedElementTextConfiguration.textAfter);

			//Reparse for find syntax error
			mergedResource.reparse(sbNewText.toString());
			
			switch(XtextUtility.validateXtextResource(mergedResource).getLevel()){
				case ERROR:
					//Critical error			
					throw new XtextElementEditorException("Error in edited element." + editedElementFragmentUri);
				default:
			}
							
			if(persist){
				EcoreUtil.resolveAll(mergedResource);
				mergedResource.save(null);
			}				

			EObject mergedElement = mergedResource.getEObject(editedElementFragmentUri);
			return mergedElement;
																
		} catch (Exception e) {
			throw new XtextElementEditorException("Merge edited element Failed " + editedElementFragmentUri, e);
		}
		
	}

	
	public static String mergeXtextEditedElementV1(XtextResource editedResource, String editedElementFragmentUri, boolean persist) throws XtextElementEditorException{

		try {
			String resourceName = "/modeleDemo/umllDemo.umllDsl";
			resourceName = editedResource.getURI().toString();
			//get resource and element 
			XtextResource resource = loadXtextRessource(resourceName, true);		
			XtextEditedElementTextConfiguration orgEditedElementTextConfiguration = createXtextEditedElementConfiguration(resource, editedElementFragmentUri);				
			
			//get edited state
			XtextEditedElementTextConfiguration newEditedElementTextConfiguration = createXtextEditedElementConfiguration(editedResource, editedElementFragmentUri);		
			
			//merge
			orgEditedElementTextConfiguration.textElement = newEditedElementTextConfiguration.textElement;
			
//			resource.update(orgEditedElementTextConfiguration.textBefore.length() , 
//							orgEditedElementTextConfiguration.textElement.length(), 
//							newEditedElementTextConfiguration.textElement);

			StringBuffer sbNewText = new StringBuffer();
			sbNewText.append(orgEditedElementTextConfiguration.textBefore)
					.append(newEditedElementTextConfiguration.textElement)
					.append(orgEditedElementTextConfiguration.textAfter);

			//Reparse for find syntax error
			resource.reparse(sbNewText.toString());									
			//warnings: reference error
			EcoreUtil2.resolveLazyCrossReferences(resource, new CancelIndicator() {public boolean isCanceled(){return false;}});
			boolean hasError = !resource.getErrors().isEmpty();
			//analyse error
			boolean hasCriticalError = false;
			if(!resource.getErrors().isEmpty()){
				//dump errors
				for(org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic : resource.getErrors()){
					if(XtextSyntaxDiagnostic.class.isAssignableFrom(diagnostic.getClass())){
						//syntax error
						hasCriticalError = true;
						System.out.println("GRAVE:" + diagnostic.getLine() + " " + diagnostic.toString());						
					}else{
						System.out.println("WARNING:" + diagnostic.getLine() + " " + diagnostic.toString());						
					}
				}					
			}
			
			//Critical error			
			if(hasCriticalError){
				throw new XtextElementEditorException("Error in edited element." + editedElementFragmentUri);
			}
				
				
			if(persist){
					EcoreUtil.resolveAll(resource);
					//System.out.println(resource.getSerializer().serialize(resource.getContents().get(0)));
					resource.save(null);
					System.out.println("Saved !!");
			}				

			return sbNewText.toString();
																
		} catch (Exception e) {
			throw new XtextElementEditorException("Merge edited element Failed " + editedElementFragmentUri, e);
		}
		
	}
	
	
	
	

	
	
}
