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



import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

/**
 * Factory for create XtextEditors for a
 * Xtext model element.
 *
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class XtextElementEditorFactory {

	
	@SuppressWarnings("restriction")
	public static XtextEmbeddedEditor createEmbeddedEditor(Injector languageInjector, Composite container, EObject xtextElement) throws XtextElementEditorException{
		return new XtextEmbeddedEditor(languageInjector, container, xtextElement);
	}
	
	@SuppressWarnings("restriction")
	public static XtextEmbeddedEditor createEmbeddedEditor(Injector languageInjector, Composite container, EObject xtextElement, Resource elementResource) throws XtextElementEditorException{
		return new XtextEmbeddedEditor(languageInjector, container, xtextElement, elementResource);
	}

	@SuppressWarnings("restriction")
	public static XtextSimpleTextEmbeddedEditor createEmbeddedEditor(Injector languageInjector, Composite container, String text) throws XtextElementEditorException{
		return new XtextSimpleTextEmbeddedEditor(languageInjector, container, text); //new XtextEmbeddedEditor(languageInjector, container, text);
	}

}
