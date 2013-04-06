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

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

/**
 * Helper for creating {@link GridData}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see GridDataFactory
 */
public class GridDataHelper {

	// Suppressing default constructor, ensuring non-instantiability
	private GridDataHelper() {
	}

	/**
	 * Returns a default new {@link GridData} :
	 * <ul>
	 * <li>horizontal alignment : {@link SWT#BEGINNING}</li>
	 * <li>vertical alignment : {@link SWT#BEGINNING}</li>
	 * <li>grab horizontal space : {@code false}</li>
	 * <li>grab vertical space : {@code false}</li>
	 * </ul>
	 * 
	 * @return a new {@link GridData} with grab horizontal space behavior
	 */
	public static GridData defaultData() {
		return new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false);
	}

	/**
	 * Returns a new {@link GridData} with grab horizontal space behavior :
	 * <ul>
	 * <li>horizontal alignment : {@link SWT#BEGINNING}</li>
	 * <li>vertical alignment : {@link SWT#BEGINNING}</li>
	 * <li>grab horizontal space : {@code true}</li>
	 * <li>grab vertical space : {@code false}</li>
	 * </ul>
	 * 
	 * @return a new {@link GridData} with grab horizontal space behavior
	 */
	public static GridData horizontalGrab() {
		return new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false);
	}

	/**
	 * Returns a new {@link GridData} with grab horizontal space behavior and horizontal
	 * fill alignment :
	 * <ul>
	 * <li>horizontal alignment : {@link SWT#FILL}</li>
	 * <li>vertical alignment : {@link SWT#BEGINNING}</li>
	 * <li>grab horizontal space : {@code true}</li>
	 * <li>grab vertical space : {@code false}</li>
	 * </ul>
	 * 
	 * @return a new {@link GridData} with grab horizontal space behavior
	 */
	public static GridData horizontalFill() {
		return new GridData(SWT.FILL, SWT.BEGINNING, true, false);
	}

	/**
	 * Returns a new {@link GridData} with grab vertical space behavior :
	 * <ul>
	 * <li>horizontal alignment : {@link SWT#BEGINNING}</li>
	 * <li>vertical alignment : {@link SWT#FILL}</li>
	 * <li>grab horizontal space : {@code false}</li>
	 * <li>grab vertical space : {@code true}</li>
	 * </ul>
	 * 
	 * @return a new {@link GridData} with grab vertical space behavior
	 */
	public static GridData verticalFill() {
		return new GridData(SWT.BEGINNING, SWT.FILL, false, true);
	}

	/**
	 * Returns a new {@link GridData} for filling both directions :
	 * <ul>
	 * <li>horizontal alignment : {@link SWT#FILL}</li>
	 * <li>vertical alignment : {@link SWT#FILL}</li>
	 * <li>grab horizontal space : {@code true}</li>
	 * <li>grab vertical space : {@code true}</li>
	 * </ul>
	 * 
	 * @return a new {@link GridData} for filling both directions
	 */
	public static GridData bothFill() {
		return new GridData(SWT.FILL, SWT.FILL, true, true);
	}

	/**
	 * Returns a new {@link GridData} with horizontal align right and grabbing horizontal
	 * space :
	 * <ul>
	 * <li>horizontal alignment : {@link SWT#RIGHT}</li>
	 * <li>vertical alignment : {@link SWT#BEGINNING}</li>
	 * <li>grab horizontal space : {@code true}</li>
	 * <li>grab vertical space : {@code false}</li>
	 * </ul>
	 * 
	 * @return a new {@link GridData} with horizontal align right and grabbing horizontal
	 *         space
	 */
	public static GridData alignRightHorizontalGrab() {
		return new GridData(SWT.RIGHT, SWT.BEGINNING, true, false);
	}
}
