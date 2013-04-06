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

public class TypedValueImpl implements TypedValue {

	protected Object value;
	protected TypeDescriptor type;
	
	
	
	public TypedValueImpl(Object value, TypeDescriptor type) {
		super();
		this.value = value;
		this.type = type;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public TypeDescriptor getType() {
		return type;
	}

}
