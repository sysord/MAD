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
package com.sysord.emf.tools.model;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * Implementation of the {@link EContentAdapter} keeping the first {@link Notifier} set to
 * the {@code EContentAdapter2}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class EContentAdapter2 extends EContentAdapter {

    /**
     * The first notifier set to this adapter.
     */
    protected Notifier firstTarget;

    @Override
    public void setTarget(Notifier target) {
        if (firstTarget == null) {
            firstTarget = target;
        }
        super.setTarget(target);
    }

    @Override
    public void unsetTarget(Notifier target) {
        if (target == firstTarget) {
            firstTarget = null;
        }
        super.unsetTarget(target);
    }

    /**
     * Returns the first notifier set to this adapter.
     * 
     * @return the first notifier set to this adapter.
     */
    public Notifier getFirstTarget() {
        return firstTarget;
    }

    /**
     * Returns the {@link Resource} of the {@code first target} or {@code null}.
     * <p>
     * If the first target is a {@code Resource}, the first target will be returned,<br>
     * if the first target is an {@link EObject}, its {@code Resource} will be returned,<br>
     * if the first target is a {@link ResourceSet}, a {@code Resource} will be returned
     * only if it contains <strong>only one</strong> {@code Resource};<br>
     * {@code null} otherwise.
     * 
     * @return the {@link Resource} of the {@code first target} or {@code null}.
     */
    public Resource getResource() {
        Resource resource = null;
        if (firstTarget != null) {
            if (firstTarget instanceof Resource) {
                resource = (Resource) firstTarget;
            } else if (firstTarget instanceof EObject) {
                resource = ((EObject) firstTarget).eResource();
            } else if (firstTarget instanceof ResourceSet) {
                EList<Resource> resources = ((ResourceSet) firstTarget).getResources();
                if (resources.size() == 1) {
                    resource = resources.get(0);
                }
            }
        }
        return resource;
    }
}
