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
package com.sysord.mad.ui.swt;

import java.util.Comparator;

import org.eclipse.jface.viewers.ViewerComparator;

import com.sysord.mad.widget.Candidate;

/**
 * {@link ViewerComparator} for {@link Candidate}s.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class CandidateComparator extends ViewerComparator {
    
    /**
     * Shared instance of {@link CandidateComparator}.
     */
    public static final CandidateComparator instance = new CandidateComparator();

    private Comparator<String> stringIgnoreCaseComparator;

    @Override
    protected Comparator<String> getComparator() {
        if (stringIgnoreCaseComparator == null) {
            stringIgnoreCaseComparator = new Comparator<String>() {

                @Override
                public int compare(String string1, String string2) {
                    return string1.compareToIgnoreCase(string2);
                }
            };
        }
        return stringIgnoreCaseComparator;
    }
}
