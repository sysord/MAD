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

/**
 * A {@code TextDslWidget} is a special {@link InputWidget} containing a text zone for
 * Domain&nbsp;Specific&nbsp;Language that can be edited from an Xtext editor.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ElementDslWidget
 */
public interface TextDslWidget extends InputWidget<String> {

	/**
	 * Returns this {@code TextDslWidget} used grammar.
	 * 
	 * @return this {@code TextDslWidget} used grammar.
	 */
	public String getGrammar();

	/**
	 * Set this {@code TextDslWidget} grammar.
	 * 
	 * @param grammar The grammar to define.
	 */
	public void setGrammar(String grammar);
}
