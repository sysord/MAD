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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sysord.eclipse.tools.L;

/**
 * Stack of {@link DelayedSWTOperationStack.SWTOperation SWTOperation}s waiting some nano
 * seconds before execution.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class DelayedSWTOperationSet extends DelayedSWTOperationStack {

	protected Set<Object> ids = new HashSet<Object>(20);

	public static DelayedSWTOperationSet get() {
		if (instance == null) {
			instance = new DelayedSWTOperationSet();
		}
		return (DelayedSWTOperationSet) instance;
	}

	@Override
	public void executeOperation(SWTOperation operation) {
		if (!(operation instanceof SWTIdentifiedOperation))
			throw new IllegalArgumentException(L.error_acceptOnlySwtIdentOp);
		// else

		Object id = ((SWTIdentifiedOperation) operation).getId();
		if (id == null)
			return;
		// else

		synchronized (ids) {
			if (ids.contains(id)) {
				operation = null;
			} else {
				ids.add(id);
			}
		}
		super.executeOperation(operation);
	}

	@Override
	public void executeOperations(Collection<SWTOperation> operations) {
		List<SWTOperation> opToAdd = new ArrayList<SWTOperation>(operations.size());
		for (SWTOperation operation : operations) {
			if (!(operation instanceof SWTIdentifiedOperation))
				throw new IllegalArgumentException(L.error_acceptOnlySwtIdentOp);
			// else

			Object id = ((SWTIdentifiedOperation) operation).getId();
			if (id == null)
				break;
			// else

			synchronized (ids) {
				if (!ids.contains(((SWTIdentifiedOperation) operation).getId())) {
					ids.add(((SWTIdentifiedOperation) operation).getId());
					opToAdd.add(operation);
				}
			}
		}
		super.executeOperations(opToAdd);
	}

	@Override
	protected void waitFinished() {
		synchronized (ids) {
			if (ids.size() > 0) {
				ids.clear();
			}
		}
		super.waitFinished();
	}

	public static abstract class SWTIdentifiedOperation implements SWTOperation {

		protected Object id;

		/**
		 * Create a {@code SWTIdentifiedOperation} with the given id.
		 * 
		 * @param id
		 */
		public SWTIdentifiedOperation(Object id) {
			this.id = id;
		}

		/**
		 * Return the value of id.
		 * 
		 * @return the value of id.
		 */
		public Object getId() {
			return id;
		}
	}
}
