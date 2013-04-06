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
package com.sysord.mad.widget.impl;

import com.sysord.mad.widget.Candidate;

/**
 * Candidate for List widget 
 * contain value and its description label 
 */
public class CandidateImpl implements Candidate {

	/**
	 * candidate label
	 */
	protected String label;
	
	/**
	 * candidate value
	 */
	protected Object value;

		
	public CandidateImpl(String label, Object value) {
		super();
		this.label = label;
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.widget.impl.CandidateValue#getLabel()
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.widget.impl.CandidateValue#setLabel(java.lang.String)
	 */
	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.widget.impl.CandidateValue#getValue()
	 */
	@Override
	public Object getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see com.sysord.mad.widget.impl.CandidateValue#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(Object value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null)
	        return false;
	    // else
	    if (this == obj)
	        return true;
	    // else
	    if (!(obj instanceof Candidate))
	        return false;
	    // else
	    
	    Object otherValue = ((Candidate) obj).getValue();
	    
	    if (value == null && otherValue == null)
	        return true;
	    // else
	    if (value != null) {
	        return value.equals(otherValue);
	    }// else
	    
	    return false;
	}
	
	
}
