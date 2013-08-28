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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public abstract class AbstractXtextEmbeddedEditorV2 {

	private static int MIN_EDITOR_WIDTH = 100;

	private static int MIN_EDITOR_HEIGHT = 20;


	protected XtextEditor xtextEditor;

	protected int editorOffset;

	protected int initialEditorSize;

	protected int initialDocumentSize;

	protected Composite xtextEditorComposite;

	protected Injector xtextInjector;

	protected XtextResource xtextResource;	
	
	
	protected IEditorSite editorSite;
	protected Composite container;

	public AbstractXtextEmbeddedEditorV2(){
		
	}
			
	public AbstractXtextEmbeddedEditorV2(Injector languageInjector, IEditorSite editorSite, Composite container) {
		this.xtextInjector = languageInjector;
		this.editorSite = editorSite;
	}


	public abstract void showEditor();

	/**
	 * Create the XText editor
	 * 
	 * @param editorInput
	 *            the editor input
	 * @throws Exception
	 */
	protected void createXtextEditor(Composite parentComposite, IEditorInput editorInput, IEditorSite editorSite) throws Exception {
		xtextEditorComposite = new Decorations(parentComposite, SWT.RESIZE | SWT.ON_TOP | SWT.BORDER);
		xtextEditorComposite.setLayout(new FillLayout());
		this.xtextEditor = xtextInjector.getInstance(XtextEditor.class);
		// remove dirty state editor callback
		xtextEditor.setXtextEditorCallback(new CompoundXtextEditorCallback(Guice.createInjector(new Module() {
			public void configure(Binder binder) {
			}
		})));
		xtextEditor.init(editorSite, editorInput);
		xtextEditor.createPartControl(xtextEditorComposite);
		addKeyVerifyListener();
		setEditorRegion();
		setEditorBounds();
		xtextEditorComposite.setVisible(true);
		xtextEditorComposite.forceFocus();
		xtextEditor.setFocus();
	}
	
	
	/**
	 * Close this editor.
	 * 
	 * @param isReconcile
	 */
	public void closeEditor(boolean isReconcile) {
		if (xtextEditor != null) {
			if (isReconcile) {
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



	protected void updateXtextResource(final int offset, final int replacedTextLength, final String newText) throws IOException, BadLocationException {
		ICompositeNode oldRootNode = xtextResource.getParseResult().getRootNode();
		// final IParseResult parseResult =
		// xtextResource.getParser().reparse(oldRootNode, offset,
		// Reparse the entire document
		String originalRegion = NodeModelUtils.getTokenText(oldRootNode);
		int changeOffset = offset - oldRootNode.getTotalOffset();
		StringBuffer reparseRegion = new StringBuffer();
		reparseRegion.append(originalRegion.substring(0, changeOffset));
		reparseRegion.append(newText);
		if (changeOffset + replacedTextLength < originalRegion.length())
			reparseRegion.append(originalRegion.substring(changeOffset + replacedTextLength));
		String allText = reparseRegion.toString();
		xtextResource.reparse(allText);
		final IParseResult parseResult = xtextResource.getParseResult();
		if (!parseResult.hasSyntaxErrors()) {
			applyChanges(parseResult.getRootASTElement());
		}
	}

//	protected List<DiffElement> getChanges(EObject oldRootObject, EObject newRootObject) throws InterruptedException {
//		// use EMF compare in order to find changes
//		// between oldRootObject tree and newRootObject tree
//		Map<String, Object> options = new HashMap<String, Object>();
//		MatchModel matchModel = MatchService.doMatch(newRootObject, oldRootObject, options);
//		DiffModel diffModel = DiffService.doDiff(matchModel);
//		List<DiffElement> changes = collectChanges(diffModel);
//		return changes;
//	}
//
//	protected List<DiffElement> collectChanges(DiffModel diffModel) {
//		ArrayList<DiffElement> changes = new ArrayList<DiffElement>();
//		for (DiffElement diffElement : diffModel.getOwnedElements()) {
//			collectChanges(changes, diffElement);
//		}
//		return changes;
//	}
//
//	protected void collectChanges(List<DiffElement> changes, DiffElement diffElement) {
//		if (diffElement.getSubDiffElements().size() == 0 && !(diffElement instanceof DiffGroup)) {
//			changes.add(diffElement);
//		} else {
//			for (DiffElement elem : diffElement.getSubDiffElements()) {
//				collectChanges(changes, elem);
//			}
//		}
//	}

	protected abstract void applyChanges(EObject newRootObject);



	protected void addKeyVerifyListener() {
		ISourceViewer sourceViewer = xtextEditor.getInternalSourceViewer();
		final StyledText xtextTextWidget = sourceViewer.getTextWidget();
		xtextTextWidget.addVerifyKeyListener(new VerifyKeyListener() {
			public void verifyKey(VerifyEvent e) {
				if ((e.stateMask & SWT.CTRL) != 0 && ((e.keyCode == SWT.KEYPAD_CR) || (e.keyCode == SWT.CR))) {
					e.doit = false;
				}
			}
		});
		xtextTextWidget.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.keyCode;
				if ((e.stateMask & SWT.CTRL) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
					closeEditor(true);
				}
				if (keyCode == SWT.ESC) {
					closeEditor(true);
				}
			}
		});
	}

	protected abstract void setEditorRegion() throws BadLocationException;
	
	
	protected void setEditorBounds() {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		// mind the added newlines
		String editString = "";
		try {
			editString = xtextDocument.get(editorOffset + 1, initialEditorSize);
		} catch (BadLocationException exc) {
			exc.printStackTrace();
		}
		int numLines = getNumLines(editString);
		int numColumns = getMaxColumns(editString);

//		IFigure figure = hostEditPart.getFigure();
//		Rectangle bounds = figure.getBounds().getCopy();
//		DiagramRootEditPart diagramEditPart = (DiagramRootEditPart) hostEditPart.getRoot();
//		IFigure contentPane = diagramEditPart.getContentPane();
//		contentPane.translateToAbsolute(bounds);
//		EditPartViewer viewer = hostEditPart.getViewer();
//		Control control = viewer.getControl();
//		while (control != null && false == control instanceof Shell) {
//			bounds.translate(control.getBounds().x, control.getBounds().y);
//			control = control.getParent();
//		}
//
//		Font font = figure.getFont();
//		FontData fontData = font.getFontData()[0];
//		int fontHeightInPixel = fontData.getHeight();

//		int width = Math.max(fontHeightInPixel * (numColumns + 3), MIN_EDITOR_WIDTH);
//		int height = Math.max(fontHeightInPixel * (numLines + 4), MIN_EDITOR_HEIGHT);
//		xtextEditorComposite.setBounds(bounds.x - 200, bounds.y - 120, width, height);
//		xtextEditorComposite.setBounds(bounds.x - 200, bounds.y - 120, width + 250, height + 50);
		
		int width = Math.max(6 * (numColumns + 3), MIN_EDITOR_WIDTH);
		int height = Math.max(6 * (numLines + 4), MIN_EDITOR_HEIGHT);
		xtextEditorComposite.setBounds(500 - 200, 500 - 120, width, height);
		xtextEditorComposite.setBounds(500 - 200, 500 - 120, width + 250, height + 50);

		
	}

	protected ICompositeNode getCompositeNode(EObject semanticElement) {
		return NodeModelUtils.getNode(semanticElement);
	}

	protected boolean isDocumentHasErrors(final IXtextDocument xtextDocument) {
		return (xtextDocument.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			public Boolean exec(XtextResource state) throws Exception {
				IParseResult parseResult = state.getParseResult();
				return !state.getErrors().isEmpty() || parseResult == null || parseResult.hasSyntaxErrors();
			}
		}));
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
