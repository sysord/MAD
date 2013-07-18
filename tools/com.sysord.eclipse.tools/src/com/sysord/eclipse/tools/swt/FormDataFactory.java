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
package com.sysord.eclipse.tools.swt;

import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;

/**
 * Factory for creating {@link FormData}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see FormData
 * @see FormLayout
 * @since 1.1
 */
public class FormDataFactory {

	public int width;
	public int height;
	public FormAttachment top;
	public FormAttachment right;
	public FormAttachment bottom;
	public FormAttachment left;

	/**
	 * Create a copy of the given {@link FormData}.
	 * 
	 * @param data The {@link FormData} to copy.
	 * @return a copy of the given {@link FormData}.
	 */
	public static FormData copy(FormData data) {
		FormData newData = new FormData(data.width, data.height);
		newData.bottom = data.bottom;
		newData.left = data.left;
		newData.right = data.right;
		newData.top = data.top;
		return newData;
	}

	// Copy a FormAttachment
	private static FormAttachment copy(FormAttachment attachment) {
		if (attachment == null) {
			return null;
		}// else
		final FormAttachment newAttachment = new FormAttachment(attachment.numerator, attachment.offset);
		newAttachment.alignment = attachment.alignment;
		newAttachment.control = attachment.control;
		newAttachment.denominator = attachment.denominator;
		return attachment;
	}

	/**
	 * Create the {@link FormData} defined by this {@code FormDataFactory}.
	 * 
	 * @return the {@link FormData} defined by this {@code FormDataFactory}.
	 */
	public FormData create() {
		FormData data = new FormData(width, height);
		data.top = copy(top);
		data.right = copy(right);
		data.bottom = copy(bottom);
		data.left = copy(left);
		return data;
	}
}
