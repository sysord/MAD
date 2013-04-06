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

import java.lang.Thread.State;
import java.util.*;
import java.util.concurrent.locks.LockSupport;

import org.eclipse.swt.widgets.Display;

/**
 * Stack of {@link SWTOperation}s waiting some nano seconds before execution.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class DelayedSWTOperationStack {

	/**
	 * Total duration of the thread.
	 */
	protected static final long THREAD_TIMEOUT = 60000000000L; // 60s;

	/**
	 * Default time out (nano seconds).
	 */
	protected static final long DEFAULT_TIME_TO_WAIT = 15000000L; // 15ms

	protected static DelayedSWTOperationStack instance;

	/**
	 * Time to wait before the execution of all the operations (in nano seconds).
	 */
	protected long timeToWait;

	/**
	 * Remaining time to wait.
	 * <p>
	 * This value is reinitialized when an operation is added.
	 */
	private volatile long timeRemaining;

	private volatile long localTimeout;

	/**
	 * {@link System#nanoTime()} of the thread when it starts.
	 * <p>
	 * This value is set to {@code 0} when the thread stops.
	 */
	protected volatile long threadTimeStarted;

	/**
	 * List of operations to execute.
	 */
	protected final Collection<SWTOperation> operations;

	private LockThread lock;

	/**
	 * Creates a {@code DelayedOperationStack}.
	 */
	protected DelayedSWTOperationStack() {
		operations = createOperationsList();
		timeToWait = DEFAULT_TIME_TO_WAIT;
		timeRemaining = timeToWait;
	}

	/**
	 * Returns the unique instance of the {@code DelayedSWTOperationStack}.
	 * 
	 * @return the unique instance of the {@code DelayedSWTOperationStack}.
	 */
	public static DelayedSWTOperationStack get() {
		if (instance == null) {
			instance = new DelayedSWTOperationStack();
		}
		return instance;
	}

	/**
	 * Puts the given {@link SWTOperation operation} into the stack of operations to
	 * execute.
	 * 
	 * @param operation The {@link SWTOperation operation} to execute.
	 */
	public void executeOperation(SWTOperation operation) {
		checkThread();
		synchronized (operations) {
			if (operation != null) {
				operations.add(operation);
			}
		}
		resetTime();
	}

	/**
	 * Puts the given {@link SWTOperation operations} into the stack of operations to
	 * execute.
	 * 
	 * @param operations The {@link SWTOperation operations} to execute.
	 */
	public void executeOperations(Collection<SWTOperation> operations) {
		checkThread();
		synchronized (this.operations) {
			if (operations != null && operations.size() > 0) {
				this.operations.addAll(operations);
			}
		}
		resetTime();
	}

	/**
	 * Creates the list of {@link SWTOperation}s.
	 * <p>
	 * Called only once in the constructor.
	 * 
	 * @return the created list of {@link SWTOperation}s.
	 */
	protected Collection<SWTOperation> createOperationsList() {
		return Collections.synchronizedList(new ArrayList<SWTOperation>(20));
	}

	/**
	 * Calculates {@link #timeRemaining}.
	 */
	protected void resetTime() {
		timeRemaining = timeToWait;
		localTimeout = System.nanoTime();
	}

	/**
	 * Checks the thread status and start it if necessary.
	 */
	protected void checkThread() {
		synchronized (this) {
			if (lock == null || lock.getState() == State.TERMINATED) {
				lock = new LockThread();
				lock.start();
			}
		}
	}

	/**
	 * Called when the thread as finished of waiting.
	 */
	protected void waitFinished() {
		if (operations.size() == 0)
			return;
		// else

		final SWTOperation[] operationsToExecute;
		synchronized (operations) {
			operationsToExecute = operations.toArray(new SWTOperation[operations.size()]);
			operations.clear();
		}
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < operationsToExecute.length; i++) {
					operationsToExecute[i].execute();
				}
			}
		});
	}

	public static interface SWTOperation {

		public void execute();
	}

	protected class LockThread extends Thread {

		@Override
		public void run() {
			threadTimeStarted = System.nanoTime();
			localTimeout = threadTimeStarted;
			while (System.nanoTime() - localTimeout < THREAD_TIMEOUT) {
				LockSupport.parkNanos(this, timeRemaining);
				timeRemaining -= timeToWait;
				if (timeRemaining <= 0) {
					if (operations.size() > 0)
						LockSupport.parkNanos(this, timeToWait);
					waitFinished();
					timeRemaining = timeToWait;
				}
			}
			threadTimeStarted = 0L;
		}
	}
}
