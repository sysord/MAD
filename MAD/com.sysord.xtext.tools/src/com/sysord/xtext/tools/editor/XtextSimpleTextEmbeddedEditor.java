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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;
import com.sysord.emf.tools.EmfToolsFacade;
import com.sysord.xtext.tools.XtextUtility;
import com.sysord.xtext.tools.XtextUtility.XTEXT_ERROR_LEVEL;
import com.sysord.xtext.tools.editor.XtextElementEditorHelper.XtextEditedElementTextConfiguration;

@SuppressWarnings("restriction")
public class XtextSimpleTextEmbeddedEditor extends AbstractXtextEmbeddedEditor{
	
	protected String originalEditedText;
	protected String languageExtension;
	
	public XtextSimpleTextEmbeddedEditor(Injector languageInjector, Composite container, String editedText) throws XtextElementEditorException {
		super();
		languageExtension = XtextUtility.getLanguageProperties(languageInjector).extension;
		createEditedResource(editedText);		
		createEmbeddedEditor(languageInjector, container);
		if(fillEditor()){
			createListeners();			
		}else{
			sourceViewer.getTextWidget().setEnabled(false);
		}
	}
	
	@Override
	public void cancelEdition(){
		updateModel("import \"platform:/resource/_TestUML/model.uml\"", originalEditedText, "");
	}
		
	/**
	 * Create EditedResource. as a new resource for the xtext language.
	 *   
	 * @param languageInjector
	 * @param originalResource
	 */
	protected void createEditedResource(final String editedText){
		originalEditedText = editedText;
		//Create resource and fill it	
		URI editedResourceUri = URI.createURI("dummy." + languageExtension);
		XtextResourceSet resourceSet = new XtextResourceSet();
		this.xtextEditedResource =  (XtextResource) resourceSet.createResource(editedResourceUri);		
//		EmfToolsFacade.getInstance().getTransactionalCommandProvider().executeAsTransactionnalCommand(resourceSet,
//			new Runnable() {					
//				@Override
//				public void run() {
//					try {
//						xtextEditedResource.reparse("\n\n\nimport \"platform:/resource/_TestUML/model.uml\\n\n\n" + editedText);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		);
		
	}
	
	/**
	 * used to refresh the edited element
	 * @param xtextEditedElement
	 */
	public void setEditedText(String editedText) {
		try {
			createEditedResource(editedText);
			partialEditor = handle.createPartialEditor(true);
			updateModel("", originalEditedText, "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public String getEditedText() {
		try {
			XtextUtility.validateXtextResource(xtextEditedResource);
			return xtextEditedResource.getSerializer().serialize(xtextEditedResource.getContents().get(0));
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}


	
	/**
	 * extract text from element and update the model
	 * @return
	 * @throws XtextElementEditorException
	 */
	protected  boolean fillEditor() throws XtextElementEditorException{	
		//updateModel("", originalEditedText, "");
		updateModel("import \"platform:/resource/_TestUML/model.uml\"", originalEditedText, "");
		return true;
	}


	
	

	
	
	
}
