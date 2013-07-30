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

import org.eclipse.core.internal.content.Activator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.sysord.eclipse.tools.diagnostic.Diagnostic.DIAGNOSTIC_LEVEL;
import com.sysord.xtext.tools.XtextUtility;
import com.sysord.xtext.tools.XtextUtility.XTEXT_ERROR_LEVEL;

public abstract class AbstractXtextEmbeddedEditor {

	protected IEditedResourceProvider resourceProvider;
	protected XtextResource  xtextEditedResource;

	protected EmbeddedEditorModelAccess partialEditor;
	protected XtextSourceViewer sourceViewer;
	protected EmbeddedEditor handle; 
	protected boolean dirtyFlag = false;	

	protected boolean isDisposed = false;
	
	/**
	 * validate the full model and returns true if valid
	 * returns false otherwise.
	 * @return
	 */
	public boolean isContentValid(){
		//force reparse;
		reparse();
		//System.out.println(xtextEditedResource.getSerializer().serialize(xtextEditedResource.getContents().get(0)));
		return (XtextUtility.validateXtextResource(xtextEditedResource).getLevel() != DIAGNOSTIC_LEVEL.ERROR);
	}
	
	public abstract void reparse();

	
	
	/**
	 * restore the model in before edition state
	 */
	public abstract void cancelEdition();

	/**
	 * returns true if model has been modified
	 * @return
	 */
	public boolean isDirty() {
		return dirtyFlag;
	}

	public void resetDirty() {
		dirtyFlag = false;
	}
	
	FocusListener listener;
	
	public void addFocusListener(FocusListener listener){
		this.listener = listener; 
		 sourceViewer.getTextWidget().addFocusListener(listener);
	}
	
	public void removeFocusListener(FocusListener listener){
		 sourceViewer.getTextWidget().removeFocusListener(listener);		
	}
	
	
	public void dispose(){
		isDisposed = true;
	}
	
	public boolean isDisposed(){
		return isDisposed;
	}
	
	@SuppressWarnings("restriction")
	protected void createEmbeddedEditor(Injector languageInjector, Composite parent) throws XtextElementEditorException{
		
		EmbeddedEditorFactory editorFactory = languageInjector.getInstance(EmbeddedEditorFactory.class);

		resourceProvider = createXtextResourceProvider();
	    EmbeddedEditorFactory.Builder editorBuilder = editorFactory.newEditor(resourceProvider);
		//editorBuilder.processIssuesBy(createValidationIssueProcessor());
		
		handle = editorBuilder.showErrorAndWarningAnnotations().withParent(parent);
		//partialEditor = handle.createPartialEditor(false);
		partialEditor = handle.createPartialEditor(true);
		
		sourceViewer = handle.getViewer();
		
	}
	
	
	/**
	 * Update the model 
	 * 
	 * @param before text hidden before the edited part
	 * @param content edited part
	 * @param after text hidden after the edited part
	 */
	protected void updateModel(String before, String content, String after){
		dirtyFlag = false;
		partialEditor.updateModel(before, content, after);
	}
	
	/**
	 * Create XtextResource that returns the edited element resource
	 * @param editedElement
	 * @return
	 */
	protected  IEditedResourceProvider createXtextResourceProvider(){
		return new IEditedResourceProvider() {			
			@Override
			public XtextResource createResource() {
				return getResource();
			}
		};
	}
	
	/**
	 * returns the edited element resource
	 * @return
	 */
	protected XtextResource getResource() {
		return xtextEditedResource;
	}
	
	protected void createListeners(){
			
		//Notify change 
		StyledText textWidget = sourceViewer.getTextWidget();
		textWidget.addKeyListener(new KeyAdapter() {
		    private String previousText = sourceViewer.getTextWidget().getText();
		    
		    @Override
		    public void keyReleased(KeyEvent e) {
		        if (!previousText.equals(sourceViewer.getTextWidget().getText())) {
		            dirtyFlag = true;
		        }
		    }
        });
		
	}
	
	/**
	 * Validation issue processor:
	 * 
	 * @return
	 */
	protected  IValidationIssueProcessor createValidationIssueProcessor(){
		//TODO: should notify something ...
		 return new IValidationIssueProcessor() {
			public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
				//IStatus result = Status.OK_STATUS;
				StringBuilder messages = new StringBuilder();
				for(Issue issue: issues) {
					if (issue.getSeverity() == Severity.ERROR) {
						if (messages.length() != 0)
							messages.append('\n');
						messages.append(issue.getMessage());
					}
				}
				if (messages.length() != 0) {
					System.out.println(messages.toString());
					//result = createErrorStatus(messages.toString(), null);
				}
			}
		};
	}
	
	

}
