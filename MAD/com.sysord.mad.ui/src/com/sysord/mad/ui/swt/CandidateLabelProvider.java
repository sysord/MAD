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

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.sysord.emf.tools.misc.EMFImageProvider;
import com.sysord.mad.core.Activator;
import com.sysord.mad.widget.Candidate;

/**
 * A {@link LabelProvider} for {@link Candidate} objects.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class CandidateLabelProvider extends LabelProvider implements ITableLabelProvider {

    private EMFImageProvider imageProvider;

    @Override
    public String getText(Object element) {
        if (element instanceof Candidate) {
            return ((Candidate) element).getLabel();
        }// else
        return super.getText(element);
    }
    
    @Override
    public Image getImage(Object element) {
        if (element != null && element instanceof Candidate) {
            Object value = ((Candidate) element).getValue();
            if (value != null && value instanceof Notifier) {
                return getImageProvider().getImageFor((Notifier) value);
            }
        }
        return super.getImage(element);
    }
    
    protected EMFImageProvider getImageProvider() {
        if (imageProvider == null) {
            imageProvider = Activator.getDefault().getInjector().getInstance(EMFImageProvider.class);
        }
        return imageProvider;
    }

    @Override
    public Image getColumnImage(Object element, int columnIndex) {
        return getImage(element);
    }

    @Override
    public String getColumnText(Object element, int columnIndex) {
        return getText(element);
    }
}
