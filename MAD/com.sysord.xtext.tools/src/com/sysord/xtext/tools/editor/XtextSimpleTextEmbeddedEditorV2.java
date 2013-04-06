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
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorSite;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.editor.info.ResourceWorkingCopyFileEditorInput;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;
import com.sysord.emf.tools.EmfToolsFacade;
import com.sysord.xtext.tools.XtextUtility;
import com.sysord.xtext.tools.XtextUtility.XTEXT_ERROR_LEVEL;
import com.sysord.xtext.tools.editor.XtextElementEditorHelper.XtextEditedElementTextConfiguration;

@SuppressWarnings("restriction")
public class XtextSimpleTextEmbeddedEditorV2 extends AbstractXtextEmbeddedEditorV2{
	
	protected String originalEditedText;
	protected String languageExtension;
	
	@Override
	public void showEditor() {
//		try {
//
//			EObject originalSemanticElement = xtextEditedElement;
//			if (originalSemanticElement == null) {
//				return;
//			}
//			this.originalResource = originalSemanticElement.eResource();
//			// Clone root EObject
//			EObject semanticElement = EcoreUtil2.clone(originalResource.getContents().get(0));
//			this.xtextResource = createVirtualXtextResource(semanticElement);
//
//			// TODO manage multi resource with Xtext Linking or Scoping service
//			semanticElementFragment = originalResource.getURIFragment(originalSemanticElement);
//			if (semanticElementFragment == null || "".equals(semanticElementFragment)) {
//				return;
//			}
//			//createXtextEditor(container,  new ResourceWorkingCopyFileEditorInput(xtextResource), editorSite);
//			createXtextEditor(container, new ResourceWorkingCopyFileEditorInput(xtextResource), editorSite);
//		} catch (Exception e) {
//			e.printStackTrace();
//			//Activator.logError(e);
//		} finally {
//		}		
	}
	
	@Override
	protected void applyChanges(EObject newRootObject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setEditorRegion() throws BadLocationException {
		// TODO Auto-generated method stub
		
	}
	

	
	

	
	
	
}
