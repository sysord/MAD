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

import java.util.ArrayList;
import java.util.List;

import com.sysord.mad.widget.Candidate;
import com.sysord.mad.widget.CandidateListener;
import com.sysord.mad.widget.ListWidget;
import com.sysord.mad.widget.WidgetVisitor;

/**
 * 
 * Implementation of the default behavior of a ListWidget.
 * 
 * @param <T>
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractListWidget<T> extends AbstractInputWidget<T> implements ListWidget<T> {

    protected List<Candidate> candidates;

    protected List<CandidateListener> candidateListeners;

    /**
     * Create an {@code AbstractListWidget} for the given {@code valueTypeClass}.
     * 
     * @param valueTypeClass
     */
    public AbstractListWidget(Class<T> valueTypeClass) {
        super(valueTypeClass);
        candidates = new ArrayList<Candidate>(0);
        candidateListeners = new ArrayList<CandidateListener>(1);
    }

    @Override
    public List<Candidate> getCandidates() {
        return candidates;
    }

    @Override
    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
        notifyCandidateListeners();
    }

    /**
     * Notifies the {@link CandidateListener}s that this widget's candidates have changed.
     */
    private void notifyCandidateListeners() {
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
    public AbstractWidget<T> clone() throws CloneNotSupportedException {
        AbstractListWidget<T> clone = (AbstractListWidget<T>) super.clone();
        clone.candidates = new ArrayList<Candidate>(candidates);
        return clone;
    }

}
