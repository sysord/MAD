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
package com.sysord.mad.widget;

import org.eclipse.emf.ecore.EObject;

/**
 * An {@code ElementDslWidget} is a special {@link EObject} {@link InputWidget} linked to
 * an Xtext element for proposing an embedded Xtext editor on the specified grammar.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see TextDslWidget
 */
public interface ElementDslWidget extends InputWidget<EObject> {

}
