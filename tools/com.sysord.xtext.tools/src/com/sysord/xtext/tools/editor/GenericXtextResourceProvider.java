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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

@SuppressWarnings("restriction")
public class GenericXtextResourceProvider implements IEditedResourceProvider{

	private String resourceName;
	private String dummyResourceExtension;
	
	private Resource resource; 

	private ResourceSet resourceSet;
	
    /**
     * Define the ressource to provide
     * @param ressourceName
     */
	public GenericXtextResourceProvider(String ressourceName) {
		super();
		if(ressourceName == null){
			ressourceName = "platform:/resource/umlExtensionDemo/test.umlext";
		}
		this.resourceName = ressourceName;
	}

	public GenericXtextResourceProvider(Resource resource) {
		super();
		this.resourceSet = resource.getResourceSet();
		this.resource = resource;
	}

	public GenericXtextResourceProvider() {
		super();
		this.resourceSet = new ResourceSetImpl();
		this.resource = resourceSet.createResource(URI.createURI("test.umlext"));
	}

	/**
	 * Provide always same resource loaded by name
	 * @param ressourceName provided resource name
	 */
	public void configureResourceByName(String ressourceName){
		if(ressourceName == null){
			ressourceName = "platform:/resource/umlExtensionDemo/test.umlext";
		}
		resourceSet = null;
		this.resourceName = ressourceName;
	}

	/**
	 * Provide always same resource 
	 * @param resource provided resource
	 */
	public void configureResource(Resource resource) {
		this.resourceSet = resource.getResourceSet();
		this.resource = resource;
	}
	
	/**
	 * Provide always an empty resource named dummyResource.resourceExtension
	 * @param resource provided resource
	 */
	public void configureResourceExtension(String resourceExtension) {
		resourceSet = null;
		dummyResourceExtension = resourceExtension;
	}
	
	
	@Override
	public XtextResource createResource() {
		 try {
			 if(resourceSet == null){
	             resourceSet = new XtextResourceSet();
	             
	             //Create a new empty resource
	             if(dummyResourceExtension != null){
	            	 resource = resourceSet.createResource(URI.createURI("dummyResource." + dummyResourceExtension));
	             }else{
	            	 //load resource by name
		             resource = resourceSet.getResource(URI.createURI(resourceName), true);
	            	 EcoreUtil.resolveAll(resource);	            	 
	             }
	             
			 }
             return (XtextResource) resource;
         } catch (Exception e) {
             return null;
         }
	}

	
    public Resource getResource() {
		return resource;
	}

	
	
}
