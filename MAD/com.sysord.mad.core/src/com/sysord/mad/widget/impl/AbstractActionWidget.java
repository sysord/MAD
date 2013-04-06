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

import java.util.*;

import com.sysord.mad.widget.*;

/**
 * Abstract implementation of the {@link ActionWidget} interface.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractActionWidget extends AbstractWidget<Void> implements ActionWidget {

    protected List<Candidate> candidates = Collections.emptyList();

    protected List<CandidateListener> candidateListeners;

    /**
     * Create an {@code AbstractActionWidget} for the given {@code valueTypeClass}.
     * 
     * @param valueTypeClass
     */
    public AbstractActionWidget() {
        super(Void.class);
        candidateListeners = new ArrayList<CandidateListener>(1);
    }

    @Override
    public List<Candidate> getCandidates() {
        return candidates;
    }

    @Override
    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
        notifyCandidateListeners(candidates);
    }

    /**
     * Notifies the registered {@link CandidateListener}s this widget's candidates have
     * changed.
     * 
     * @param candidates The new list of candidates.
     */
    private void notifyCandidateListeners(List<Candidate> candidates) {
        for (CandidateListener listener : candidateListeners) {
            listener.candidatesChanged(candidates);
        }
    }

    @Override
    public void addCandidatesListener(CandidateListener listener) {
        candidateListeners.add(listener);
    }

    @Override
    public void removeCandidatesListener(CandidateListener listener) {
        candidateListeners.remove(listener);
    }

    @Override
    public <V> V accept(WidgetVisitor<V> visitor) {
        V value = visitor.visit(this);
        if (value != null) {
            return value;
        }
        return super.accept(visitor);
    }

    @Override
    public AbstractWidget<Void> clone() throws CloneNotSupportedException {
        AbstractActionWidget clone = (AbstractActionWidget) super.clone();
        clone.candidates = new ArrayList<Candidate>(candidates);
        return clone;
    }

}
