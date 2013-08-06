package com.sysord.xtext.tools.ui;

import org.eclipse.xtext.ui.editor.AbstractDirtyStateAwareEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * EditorCallBack  for replacing the {@link NatureAddingEditorCallback}
 * and avoid the Dialog "add Xtext nature..." every time when a Dsl file 
 * owned by a project without XtextNature is opened in editor. 
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class NatureAddingDisabledEditorCallback extends AbstractDirtyStateAwareEditorCallback {

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		super.afterCreatePartControl(editor);
	}
}
