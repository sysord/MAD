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
package com.sysord.mad.evaluator.impl.mad;

public interface MadMacros {

	public static final String CREATE_MACRO = "CREATE";
	public static final String DELETE_MACRO = "DELETE";

	public static final String UPDATE_FEATURE_MACRO = "UPDATE_FEATURE";

	public static final String REMOVE_MACRO = "REMOVE_ITEM";

	public static final String MOVE_UP = "MOVE_UP";
	public static final String MOVE_DOWN = "MOVE_DOWN";
	
	public static final String[] MACROS_NAMES = new String []{
		CREATE_MACRO,
		DELETE_MACRO,
		REMOVE_MACRO,
		MOVE_UP,
		MOVE_DOWN,
		UPDATE_FEATURE_MACRO
	};
	
}
