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
 * A {@code ListWidget} is an {@link InputWidget} where the value is a list of editable
 * elements.
 * 
 * @param <T> The type of the value represented by this widget.
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see SingleSelectWidget
 * @see MultiSelectWidget
 * @see Candidate
 */
public interface ListWidget<T> extends InputWidget<T> {

	/**
	 * Sets the cadidates of this {@code ListWidget}.<br>
	 * A {@link Candidate candidate} is a possible value for this widget.
	 * 
	 * @param candidates The list of candidates to set.
	 */
	public void setCandidates(List<Candidate> candidates);

	/**
	 * Returns the candidates of this {@code ListWidget}.<br>
	 * A {@link Candidate candidate} is a possible value for this widget.
	 * 
	 * @return the candidates of this {@code ListWidget}.
	 */
	public List<Candidate> getCandidates();

	/**
	 * Add the given {@link CandidateListener} to this {@code ListWidget}.
	 * 
	 * @param listener The {@code CandidateListener} to add.
	 */
	public void addCandidatesListener(CandidateListener listener);

	/**
	 * Remove the given {@link CandidateListener} from this {@code ListWidget}.
	 * 
	 * @param listener The {@code CandidateListener} to add.
	 */
	public void removeCandidatesListener(CandidateListener listener);

}
