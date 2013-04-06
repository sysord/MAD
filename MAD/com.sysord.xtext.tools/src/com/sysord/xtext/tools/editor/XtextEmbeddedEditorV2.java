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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorSite;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.info.ResourceWorkingCopyFileEditorInput;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

public class XtextEmbeddedEditorV2 extends AbstractXtextEmbeddedEditorV2{


	protected Resource originalResource;
	protected String semanticElementFragment;	
	protected EObject xtextEditedElement;

	
	public XtextEmbeddedEditorV2(Injector languageInjector, IEditorSite editorSite, Composite container, EObject xtextEditedElement) {
		this.xtextInjector = languageInjector;
		this.container = container;
		this.xtextEditedElement = xtextEditedElement;
		this.editorSite = editorSite;
	}


	@Override
	public void showEditor() {				
		try {

			EObject originalSemanticElement = xtextEditedElement;
			if (originalSemanticElement == null) {
				return;
			}
			this.originalResource = originalSemanticElement.eResource();
			// Clone root EObject
			EObject semanticElement = EcoreUtil2.clone(originalResource.getContents().get(0));
			this.xtextResource = createVirtualXtextResource(semanticElement);

			// TODO manage multi resource with Xtext Linking or Scoping service
			semanticElementFragment = originalResource.getURIFragment(originalSemanticElement);
			if (semanticElementFragment == null || "".equals(semanticElementFragment)) {
				return;
			}
			//createXtextEditor(container,  new ResourceWorkingCopyFileEditorInput(xtextResource), editorSite);
			createXtextEditor(container, new ResourceWorkingCopyFileEditorInput(xtextResource), editorSite);
		} catch (Exception e) {
			e.printStackTrace();
			//Activator.logError(e);
		} finally {
		}
	}


	
	/**
	 * Close this editor.
	 * 
	 * @param isReconcile
	 */
	public void closeEditor(boolean isReconcile) {
		if (xtextEditor != null) {
			if (isReconcile ) {
				try {
					final IXtextDocument xtextDocument = xtextEditor.getDocument();
					if (!isDocumentHasErrors(xtextDocument)) {
						// subtract 2 for the artificial newlines
						int documentGrowth = xtextDocument.getLength() - initialDocumentSize - 2;
						String newText = xtextDocument.get(editorOffset + 1, initialEditorSize + documentGrowth);
						updateXtextResource(editorOffset, initialEditorSize, newText);
					}
				} catch (Exception e) {
					e.printStackTrace();
					//Activator.logError(e);
				}
			}
			xtextEditor.dispose();
			xtextEditorComposite.setVisible(false);
			xtextEditorComposite.dispose();
			xtextEditor = null;
		}
	}


	protected XtextResource createVirtualXtextResource(EObject semanticElement) throws IOException {
		IResourceFactory resourceFactory = xtextInjector.getInstance(IResourceFactory.class);
		XtextResourceSet rs = xtextInjector.getInstance(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		URI uri = createURI();
		// Create virtual resource
		XtextResource xtextVirtualResource = (XtextResource) resourceFactory.createResource(uri);
		rs.getResources().add(xtextVirtualResource);

		// Populate virtual resource with the given semantic element to edit
		xtextVirtualResource.getContents().add(semanticElement);
		// save to create file
		// TODO remove crappy hack
		xtextVirtualResource.save(Collections.emptyMap());

		// Save and reparse in order to initialize virtual Xtext resource
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		xtextVirtualResource.save(out, Collections.emptyMap());
		xtextVirtualResource.reparse(new String(out.toByteArray()));

		return xtextVirtualResource;
	}

	private URI createURI() {
		// FIXME remove crappy code and use in memory resource
		// URI uri = URI.createURI("XtextResource.ram");
		final String TEMPORARY_PROJECT_NAME = "tempProject";
		final IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(TEMPORARY_PROJECT_NAME);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(TEMPORARY_PROJECT_NAME);
		try {
			if (!project.exists()) {
				project.create(projectDescription, new NullProgressMonitor());
				project.open(new NullProgressMonitor());
			}
		} catch (final CoreException e) {
			// Propagate as runtime exception
			throw new RuntimeException(e);
		}
		URI uri = URI.createPlatformResourceURI("/" + TEMPORARY_PROJECT_NAME + "/temp.dmodel", false);
		return uri;
	}


	protected void setEditorRegion() throws BadLocationException {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		boolean success = xtextEditor.getDocument().modify(new IUnitOfWork<Boolean, XtextResource>() {

			public Boolean exec(XtextResource state) throws Exception {
				EObject semanticElementInDocument = state.getEObject(semanticElementFragment);
				if (semanticElementInDocument == null) {
					return false;
				}
				ICompositeNode xtextNode = getCompositeNode(semanticElementInDocument);
				if (xtextNode == null) {
					return false;
				}
				// getOffset() and getLength() are trimming whitespaces
				editorOffset = xtextNode.getOffset();
				initialEditorSize = xtextNode.getLength();
				initialDocumentSize = xtextDocument.getLength();

				// insert a newline directly before and after the node
				xtextDocument.replace(editorOffset, 0, "\n");
				xtextDocument.replace(editorOffset + 1 + initialEditorSize, 0, "\n");
				return true;
			}

		});
		if (success) {
			xtextEditor.showHighlightRangeOnly(true);
			xtextEditor.setHighlightRange(editorOffset + 1, initialEditorSize, true);
			xtextEditor.setFocus();
		}
	}
	
	protected void applyChanges(EObject newRootObject) {
		EObject oldRootObject = originalResource.getContents().get(0);
//		try {
//			final List<DiffElement> changes = getChanges(oldRootObject, newRootObject);
//			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(originalResource);
//			AbstractTransactionalCommand gmfCommand = new AbstractTransactionalCommand(editingDomain, "update resource after direct text edit", null) {
//				@Override
//				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
//					try {
//						for (DiffElement change : changes) {
//							System.out.println("## change: " + change);
//
//							MergeService.merge(change, true);
//						}
//						return CommandResult.newOKCommandResult();
//					} catch (Exception exc) {
//						return CommandResult.newErrorCommandResult(exc);
//					}
//				}
//			};
//			gmfCommand.execute(new NullProgressMonitor(), null);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}


	
//	public class StringUtil {

	public static int getNumLines(String s) {
		int numLines = 1;
		for (char c : s.toCharArray()) {
			if (c == '\n') {
				++numLines;
			}
		}
		return numLines;
	}

	public static int getMaxColumns(String s) {
		int maxColumns = 0;
		int currentColumns = 0;
		for (char c : s.toCharArray()) {
			if (c == '\n') {
				maxColumns = Math.max(maxColumns, currentColumns);
				currentColumns = 0;
			} else {
				++currentColumns;
			}
		}
		return Math.max(currentColumns, maxColumns);
	}
//	}
	
	
}
