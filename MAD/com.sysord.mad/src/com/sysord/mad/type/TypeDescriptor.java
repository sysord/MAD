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
package com.sysord.mad.type;

import org.eclipse.emf.ecore.EClassifier;

/**
 * Structure for type Description.
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public interface TypeDescriptor {

	public enum TYPE_CATEGORY{
		UNKNOW,

		NULL,

		STRING,
		BOOLEAN,
		DATE,
		LONG,
		INTEGER,
		FLOAT,
		DOUBLE,
	
		EOBJECT,
		OBJECT,
		
		COLLECTION,
		SEQUENCE,
		SET,
		ORDERED_SET,
		BAG
	}
	
	/**
	 * returns the type category
	 * @return
	 */
	public TYPE_CATEGORY getTypeCategory();
	
	public boolean isNull();
	
	public boolean isString();
	public boolean isBoolean();
	public boolean isDate();
	public boolean isLong();
	public boolean isInteger();
	public boolean isFloat();
	public boolean isDouble();
	
	public boolean isEObject();
	public boolean isCollection();
	public boolean isSequence();
	public boolean isSet();
	public boolean isOrderedSet();
	public boolean isBag();
	
	public boolean isMap();
	
	public Class<?> getType();
	public EClassifier getEType();
	
	/**
	 * When type is a collection, returns the {@link TypeDescriptor} for the
	 * items contained by the collection.
	 * @return {@link TypeDescriptor} for the items contained by a collection type.
	 */
	public TypeDescriptor getItemTypeDescriptor();

	/**
	 * Set the {@link TypeDescriptor} for the items contained by a collection type
	 */
	public TypeDescriptor setItemTypeDescriptor(TypeDescriptor itemAnalyze);
	
	
}
