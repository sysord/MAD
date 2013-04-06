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

import com.sysord.eclipse.tools.swt.ImageResource;
import com.sysord.mad.configuration.CommandDefinition;
import com.sysord.mad.configuration.UICommandDefinition;
import com.sysord.mad.configuration.madConfigDsl.COMMAND_CATEGORY_MDSL;
import com.sysord.mad.configuration.madConfigDsl.ClassDescriptorMdsl;
import com.sysord.mad.configuration.madConfigDsl.CommandDefinitionMdsl;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;
import com.sysord.mad.configuration.util.MadConfigDslUtil;
import com.sysord.mad.query.QueryDefinition;
import com.sysord.mad.query.QueryDefinition.RETURN_VALUE_OCCURENCE;
import com.sysord.mad.query.impl.QueryFactory;
import com.sysord.mad.query.impl.SingleQueryDefinitionImpl;


public class CommandDefinitionImpl implements CommandDefinition{

	protected CommandDefinitionMdsl commandDefinitionMdsl;
	
	/**
	 * unique Id for the command
	 */
	protected String commandId;

	protected String labelExpression;
	
	/**
	 * Query definition for the action
	 */
	protected QueryDefinition<?> queryAction;

	/**
	 * Icon IMage resource
	 */
	protected ImageResource iconDescriptor;

	/**
	 * UICommand to be executed after the action
	 */
	protected List<UICommandDefinition> onSuccessPostActionCommands = new ArrayList<UICommandDefinition>();
	protected List<UICommandDefinition> onErrorPostActionCommands = new ArrayList<UICommandDefinition>();
	
	
	public CommandDefinitionImpl(String commandId, CommandDefinitionMdsl commandDefinitionMdsl, 
								List<QueryDefinitionMdsl> preQueries, String labelExpression) {
		super();
		this.commandDefinitionMdsl = commandDefinitionMdsl;
		this.commandId = commandId;
		this.labelExpression = labelExpression;
		createQueryAction(preQueries);
		createCommandIconDescriptor(commandDefinitionMdsl);
	}

	protected void createQueryAction(List<QueryDefinitionMdsl> preQueries){
		//queryAction = new QueryDefinitionImpl(MadConfigDslUtil.resolveQuery(commandDefinitionMdsl.getAction()), Object.class, RETURN_VALUE_OCCURENCE.NONE_VALUE);		
		//queryAction = ConfigurationManagerHelper.createQueryDefinition(MadConfigDslUtil.resolveQuery(commandDefinitionMdsl.getAction()), Object.class, RETURN_VALUE_OCCURENCE.NONE_VALUE);	
				
		//Create editable Query condition 
		QueryDefinitionMdsl actionQueryDefMdsl = MadConfigDslUtil.resolveQuery(commandDefinitionMdsl.getAction());
		//items commands context are since located it's the item context. don't need to add preQueries
		if(preQueries != null && commandDefinitionMdsl.getCategory() != COMMAND_CATEGORY_MDSL.ITEM_COMMAND){
			List<QueryDefinitionMdsl> actionQueryMdsl = new ArrayList<QueryDefinitionMdsl>();
			actionQueryMdsl.addAll(preQueries);
			actionQueryMdsl.add(actionQueryDefMdsl);				
			queryAction = QueryFactory.createQueryDefinition(actionQueryMdsl, Object.class, RETURN_VALUE_OCCURENCE.NONE_VALUE);			
		}else{
			queryAction = QueryFactory.createQueryDefinition(actionQueryDefMdsl, Object.class, RETURN_VALUE_OCCURENCE.NONE_VALUE);				
		}		
	}

	
	
	@Override
	public String getCommandId() {
		return commandId;
	} 


	@Override
	public COMMAND_CATEGORY getCommandCategory() {
		switch (commandDefinitionMdsl.getCategory()) {
		case GLOBAL_COMMAND:
			return COMMAND_CATEGORY.GLOBAL_COMMAND;
		case ITEM_COMMAND:
			return COMMAND_CATEGORY.ITEM_COMMAND;
		default:
			return  COMMAND_CATEGORY.UNKNOW_CATEGORY_COMMAND;
		}
	}

	@Override
	public String getCommandLabel() {
		return labelExpression;
	}

	@Override
	public QueryDefinition<?> getQueryAction() {
		return queryAction;
	}

	@Override
	public List<UICommandDefinition> getOnSuccessPostActionCommands() {
		return onSuccessPostActionCommands;
	}
	
	@Override
	public List<UICommandDefinition> getOnErrorPostActionCommands() {
		return onErrorPostActionCommands;
	}


	@Override
	public boolean useIcon() {
		return iconDescriptor != null;
	}

	@Override
	public ImageResource getIconDescriptor() {
		return iconDescriptor;
	}

	/**
	 * Create the {@link ImageResource} for the icon if defined
	 * @param commandDefMdsl
	 */
	protected void createCommandIconDescriptor(CommandDefinitionMdsl commandDefMdsl){
		ImageResource  iconDescriptor = null;
		if(commandDefMdsl.getIcon() != null){
			if(commandDefMdsl.getIcon().getBundleUri() != null){
				iconDescriptor = new ImageResource(commandDefMdsl.getIcon().getBundleUri());
			}else{
				ClassDescriptorMdsl classDescriptor = commandDefMdsl.getIcon().getBundleDescriptor();
				iconDescriptor = new ImageResource(classDescriptor.getPluginId(), classDescriptor.getClassName());				
			}
		}
		this.iconDescriptor = iconDescriptor;
	}
	
	
}
