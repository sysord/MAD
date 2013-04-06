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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;
import com.sysord.xtext.tools.XtextUtility;
import com.sysord.xtext.tools.editor.XtextElementEditorHelper.XtextEditedElementTextConfiguration;

@SuppressWarnings("restriction")
public class XtextEmbeddedEditor extends AbstractXtextEmbeddedEditor{

	protected String xtextEditedElementUri;	
	protected XtextEditedElementTextConfiguration editedElementConfiguration;
	
	
	public XtextEmbeddedEditor(Injector languageInjector, Composite container, EObject xtextEditedElement) throws XtextElementEditorException {
		this(languageInjector, container, xtextEditedElement, xtextEditedElement.eResource());
	}
	
	public XtextEmbeddedEditor(Injector languageInjector, Composite container, EObject xtextEditedElement, Resource elementResource) throws XtextElementEditorException {
		super();
		this.xtextEditedElementUri = elementResource.getURIFragment(xtextEditedElement);
		createEditedResource((XtextResource) elementResource);		
		createEmbeddedEditor(languageInjector, container);
		if(fillEditor()){
			createListeners();			
		}else{
			sourceViewer.getTextWidget().setEnabled(false);			
		}
		
		//Deselect editor content
		if(sourceViewer.getTextWidget().getText().length() > 0){
			sourceViewer.getTextWidget().setSelection(0, 0);					
		}
	}

	@Override
	public void cancelEdition(){
		updateModel();
	}

	
	public void dispose(){
		sourceViewer.unconfigure();
	}


	
	/**
	 * Create EditedResource. as a clone of the original resource.
	 *   
	 * @param languageInjector
	 * @param originalResource
	 */
	protected void createEditedResource(final XtextResource originalResource){
		//Create clone resource and fill it
		URI editedResourceUri = URI.createURI("dummy_" + originalResource.getURI().lastSegment().toString());
		XtextResourceSet resourceSet = new XtextResourceSet();
		this.xtextEditedResource =  (XtextResource) resourceSet.createResource(editedResourceUri);		
		final String originalText = originalResource.getSerializer().serialize(originalResource.getContents().get(0));
		try {
			xtextEditedResource.reparse(originalText);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * used to refresh the edited element
	 * @param xtextEditedElement
	 */
	public void setEditedElement(EObject xtextEditedElement) {
		try {
			this.xtextEditedElementUri = xtextEditedElement.eResource().getURIFragment(xtextEditedElement);
			createEditedResource((XtextResource) xtextEditedElement.eResource());
			editedElementConfiguration = XtextElementEditorHelper.createXtextEditedElementConfiguration(xtextEditedResource, xtextEditedElementUri);
			if(editedElementConfiguration != null){
				//partialEditor = handle.createPartialEditor(true);
				partialEditor.updateModel(editedElementConfiguration.textBefore, editedElementConfiguration.textElement, editedElementConfiguration.textAfter);
			}
			resetDirty();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EObject getEditedElement() {
		try {
			String newText = editedElementConfiguration.textBefore + sourceViewer.getTextWidget().getText() + editedElementConfiguration.textAfter;
			xtextEditedResource.reparse(newText);
			XtextUtility.validateXtextResource(xtextEditedResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xtextEditedResource.getEObject(editedElementConfiguration.fragmentUri);
	}


	
	/**
	 * extract text from element and update the model
	 * @return
	 * @throws XtextElementEditorException
	 */
	protected  boolean fillEditor() throws XtextElementEditorException{	
		editedElementConfiguration = XtextElementEditorHelper.createXtextEditedElementConfiguration(xtextEditedResource, xtextEditedElementUri);
		if(editedElementConfiguration != null){
			updateModel();
			return true;
		}else{			
			return false;			
		}		
	}

	/**
	 * update the model
	 */
	protected void updateModel(){
		updateModel(editedElementConfiguration.textBefore, editedElementConfiguration.textElement, editedElementConfiguration.textAfter);
	}


	
	

	
	
	
}
