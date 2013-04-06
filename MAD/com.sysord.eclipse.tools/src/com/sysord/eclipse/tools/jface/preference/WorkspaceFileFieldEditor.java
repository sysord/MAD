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
package com.sysord.eclipse.tools.jface.preference;

import java.io.File;

import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.swt.widgets.Composite;

import com.sysord.eclipse.tools.EclipseTools;

/**
 * A {@link FileFieldEditor} for the current workspace files only.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class WorkspaceFileFieldEditor extends FileFieldEditor {

    /**
     * Constructor
     */
    protected WorkspaceFileFieldEditor() {
        super.setFilterPath(EclipseTools.getCurrentWorkspacePath());
    }

    /**
     * Creates a workspace file field editor.
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param parent the parent of the field editor's control
     */
    public WorkspaceFileFieldEditor(String name, String labelText, Composite parent) {
        this(name, labelText, false, parent);
    }

    /**
     * Creates a workspace file field editor.
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param enforceAbsolute <code>true</code> if the file path
     *        must be absolute, and <code>false</code> otherwise
     * @param parent the parent of the field editor's control
     */
    public WorkspaceFileFieldEditor(String name, String labelText, boolean enforceAbsolute, Composite parent) {
        this(name, labelText, enforceAbsolute, VALIDATE_ON_FOCUS_LOST, parent);
    }

    /**
     * Creates a workspace file field editor.
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param enforceAbsolute <code>true</code> if the file path
     *        must be absolute, and <code>false</code> otherwise
     * @param validationStrategy either
     *        {@link StringButtonFieldEditor#VALIDATE_ON_KEY_STROKE} to perform on the fly
     *        checking, or {@link StringButtonFieldEditor#VALIDATE_ON_FOCUS_LOST} (the
     *        default) to perform validation only after the text has been typed in
     * @param parent the parent of the field editor's control.
     * @since 3.4
     * @see StringButtonFieldEditor#VALIDATE_ON_KEY_STROKE
     * @see StringButtonFieldEditor#VALIDATE_ON_FOCUS_LOST
     */
    public WorkspaceFileFieldEditor(String name, String labelText, boolean enforceAbsolute, int validationStrategy,
            Composite parent) {
        super(name, labelText, enforceAbsolute, validationStrategy, parent);
    }

    @Override
    protected void init(String name, String text) {
        super.init(name, text);
        super.setFilterPath(EclipseTools.getCurrentWorkspacePath());
    }

    @Override
    protected boolean checkState() {
        String msg = null;

        String path = getTextControl().getText();
        if (path != null) {
            path = path.trim();
        } else {
            path = "";//$NON-NLS-1$
        }
        if (path.length() == 0) {
            if (!isEmptyStringAllowed()) {
                msg = getErrorMessage();
            }
        } else {
            File file = new File(EclipseTools.getCurrentWorkspacePath().getAbsolutePath() + path);
            if (!file.isFile()) {
                msg = getErrorMessage();
            }
        }

        if (msg != null) { // error
            showErrorMessage(msg);
            return false;
        }// else

        if (doCheckState()) { // OK!
            clearErrorMessage();
            return true;
        }// else

        msg = getErrorMessage(); // subclass might have changed it in the #doCheckState()
        if (msg != null) {
            showErrorMessage(msg);
        }
        return false;
    }

    @Override
    protected String changePressed() {
        File workspacePath = EclipseTools.getCurrentWorkspacePath();
        String filePath = super.changePressed();
        if (filePath != null && filePath.startsWith(workspacePath.getAbsolutePath())) {
            filePath = filePath.substring(workspacePath.getAbsolutePath().length());
        }
        return filePath;
    }

    @Override
    public void setFilterPath(File path) {
        File workspacePath = EclipseTools.getCurrentWorkspacePath();
        if (path.getAbsolutePath().startsWith(workspacePath.getAbsolutePath())) {
            super.setFilterPath(path);
        }
    }
}
