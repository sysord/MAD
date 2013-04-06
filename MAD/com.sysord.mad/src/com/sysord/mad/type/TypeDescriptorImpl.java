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


public class TypeDescriptorImpl implements TypeDescriptor {

	protected TYPE_CATEGORY category;
	protected Class<?> returnType;
	protected EClassifier returnEType;
	protected TypeDescriptor itemAnalyze;


	public TypeDescriptorImpl(TYPE_CATEGORY category, Class<?> returnType, EClassifier returnEType) {
		super();
		this.category = category;
		this.returnType = returnType;
		this.returnEType = returnEType;
	}

	@Override
	public TYPE_CATEGORY getTypeCategory() {
		return category;
	}
	
	@Override
	public boolean isNull() {
		return category == null;
	}

	@Override
	public boolean isEObject() {
		return returnEType != null;
	}

	@Override
	public boolean isCollection() {
		return category == TYPE_CATEGORY.COLLECTION 
				|| category == TYPE_CATEGORY.SEQUENCE
				|| category == TYPE_CATEGORY.SET
				|| category == TYPE_CATEGORY.ORDERED_SET
				|| category == TYPE_CATEGORY.BAG
				;
	}

	@Override
	public boolean isMap() {
		//TODO:
		return false;
	}

	
	@Override
	public Class<?> getType() {
		return returnType;
	}

	@Override
	public EClassifier getEType() {
		return returnEType;
	}

	@Override
	public TypeDescriptor getItemTypeDescriptor() {
		return itemAnalyze;
	}

	@Override
	public TypeDescriptor setItemTypeDescriptor(TypeDescriptor itemAnalyze) {
		this.itemAnalyze = itemAnalyze;
		return this;
	}

	@Override
	public String toString() {
		return "QueryAnalyzeImpl [category=" + category + ", returnType=" + returnType + ", returnEType=" + returnEType + ", itemAnalyze=" + itemAnalyze + "]";
	}

	@Override
	public boolean isString() {
		return category == TYPE_CATEGORY.STRING;
	}

	@Override
	public boolean isBoolean() {
		return category == TYPE_CATEGORY.BOOLEAN;
	}

	@Override
	public boolean isDate() {
		return category == TYPE_CATEGORY.DATE;
	}

	@Override
	public boolean isLong() {
		return category == TYPE_CATEGORY.LONG;
	}

	@Override
	public boolean isInteger() {
		return category == TYPE_CATEGORY.INTEGER;
	}

	@Override
	public boolean isFloat() {
		return category == TYPE_CATEGORY.FLOAT;
	}

	@Override
	public boolean isDouble() {
		return category == TYPE_CATEGORY.DOUBLE;
	}



	@Override
	public boolean isSequence() {
		return category == TYPE_CATEGORY.SEQUENCE;
	}

	@Override
	public boolean isSet() {
		return category == TYPE_CATEGORY.SET;
	}

	@Override
	public boolean isOrderedSet() {
		return category == TYPE_CATEGORY.ORDERED_SET;
	}

	@Override
	public boolean isBag() {
		return category == TYPE_CATEGORY.BAG;
	}


	
	

}
