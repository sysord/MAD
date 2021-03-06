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

import java.util.List;

/**
 * Listener for {@link Candidate}s modification events.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see Candidate
 * @see ActionWidget
 * @see ListWidget
 */
public interface CandidateListener {

	/**
	 * Notifies this listener the candidates have changed.
	 * <p>
	 * The given {@code candidates} are the <em>new list</em> of candidates and
	 * <strong>not</strong> only the list of <em>new candidates</em>.
	 * 
	 * @param candidates The new list of <strong>all</strong> candidates.
	 */
	public void candidatesChanged(List<Candidate> candidates);
}
