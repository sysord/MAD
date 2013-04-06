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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jface.viewers.IElementComparer;

import com.sysord.mad.widget.Candidate;

/**
 * An {@link IElementComparer} for {@link Candidate} objects.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class CandidateElementComparer implements IElementComparer {

    @Override
    public boolean equals(Object a, Object b) {
        if (a == null || b == null) {
            return false;
        }// else
        
        if (a instanceof Collection && b instanceof Collection) {
            return collectionsEqual((Collection<?>) a, (Collection<?>) b);
        }// else
        
        a = getCandidateValue(a);
        b = getCandidateValue(b);
        
        if (a == null && b == null) {
            return true;
        }// else
        
        if (a != null && b != null) {

            // FIXME Hack for Enum special case
            if (a instanceof EEnumLiteral) {
                return ((EEnumLiteral) a).getName().equals(b.toString());
            }// else

            return a.equals(b);
        }// else
        return false;
    }
    
    private Object getCandidateValue(Object candidate) {
        Object value;
        if (candidate instanceof Candidate) {
            value = ((Candidate) candidate).getValue();
        } else {
            value = candidate;
        }
        return value;
    }

    protected boolean collectionsEqual(Collection<?> a, Collection<?> b) {
        if (a == b) {
            return true;
        }// else
        
        if (a.size() != b.size()) {
            return false;
        }// else
        
        Iterator<?> aIter = a.iterator();
        Iterator<?> bIter = b.iterator();
        
        while (aIter.hasNext()) {
            Object aElem = aIter.next();
            Object bElem = bIter.next();
            if (!equals(aElem, bElem)) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public int hashCode(Object element) {
        if (element instanceof Candidate) {
            element = ((Candidate) element).getValue();
        }
        return element == null ? 0 : element.hashCode();
    }
}
