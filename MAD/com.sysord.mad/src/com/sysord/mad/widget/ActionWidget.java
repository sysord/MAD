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
 * An ActionWidget represents a not editable widget used for specific actions on this
 * Widget's elements.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see NavigationWidget
 * @see Candidate
 * @see CandidateListener
 */
public interface ActionWidget extends Widget<Void> {

    /**
     * Sets the possible candidates for the action.
     * 
     * @param candidates
     */
    public void setCandidates(List<Candidate> candidates);

    /**
     * Returns the possible candidates for this ActionWidget.
     * 
     * @return the possible candidates for this ActionWidget.
     */
    public List<Candidate> getCandidates();
    
    /**
     * Adds the given {@link CandidateListener} to this {@code ActionWidget}.
     * 
     * @param listener The {@code CandidateListener} to add.
     */
    public void addCandidatesListener(CandidateListener listener);
    
    /**
     * Removes the given {@link CandidateListener} from this {@code ActionWidget}.
     * 
     * @param listener The {@code CandidateListener} to add.
     */
    public void removeCandidatesListener(CandidateListener listener);

}
