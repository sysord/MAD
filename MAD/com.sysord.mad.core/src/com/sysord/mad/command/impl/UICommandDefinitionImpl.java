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
package com.sysord.mad.command.impl;

import java.util.ArrayList;
import java.util.List;

import com.sysord.mad.configuration.UICommandDefinition;
import com.sysord.mad.query.QueryDefinition;

public class UICommandDefinitionImpl implements UICommandDefinition{

	protected UICOMMAND_TYPE commandType;
	
	protected QueryDefinition<?> findTargetQuery;
	
	protected List<String> targetsWidgetsIds = new ArrayList<String>();
	
		
	public UICommandDefinitionImpl(UICOMMAND_TYPE commandType, QueryDefinition<?> findTargetQuery) {
		super();
		this.commandType = commandType;
		this.findTargetQuery = findTargetQuery;
	}

	@Override
	public UICOMMAND_TYPE getCommandType() {
		return commandType;
	}

	@Override
	public QueryDefinition<?> getFindTargetQuery() {
		return findTargetQuery;
	}

	@Override
	public List<String> getTargetsWidgetsIds() {
		return targetsWidgetsIds;
	}

}
