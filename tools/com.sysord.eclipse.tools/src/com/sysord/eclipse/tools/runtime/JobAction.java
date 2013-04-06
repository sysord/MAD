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
package com.sysord.eclipse.tools.runtime;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;

/**
 * Action for scheduling a job.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class JobAction extends Action {

    /**
     * The job to schedule on {@code run} call.
     */
    private Job job;

    /**
     * Create a {@code JobAction} with the given {@link Job}.
     * <p>
     * When the {@code run} method of the action will be called, the job will be
     * scheduled.
     * 
     * @param job
     */
    public JobAction(Job job) {
        this.job = job;
    }

    @Override
    public void run() {
        job.schedule();
    }
}