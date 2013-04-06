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
package com.sysord.mad.mao;

import com.sysord.mad.command.MadCommand;
import com.sysord.mad.emitter.ModelElementView;
import com.sysord.mad.widget.Widget;

/**
 * Service for reading and persisting edited model elements.
 * <p>
 * This service is essentially used to load and update the values of the widgets of a
 * {@link ModelElementView view}.
 * <p>
 * The write accesses are all done into EMF transactions via
 * {@link TransactionalMadCommand}s.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 * @see ModelElementView
 * @see TransactionalMadCommand
 * @see TransactionalCommandProvider
 */
public interface ModelAccessObject {

	/**
	 * Sets value for all elements in the given {@code modelElementView}.
	 * <p>
	 * Values are requested from models and affected to element in the
	 * {@link ModelElementView view}.
	 * 
	 * @param modelElementView The view into which loading the values.
	 */
	public void loadViewValues(ModelElementView modelElementView) throws MaoException;

	/**
	 * View values are persisted into their owner model.
	 * 
	 * @param modelElementView
	 */
	public void persistViewValues(ModelElementView modelElementView) throws MaoException;

	/**
	 * Widget value is persisted in its owner model.
	 * 
	 * @param widget The widget containing the value to persist.
	 */
	public void persistWidgetValue(Widget<?> widget) throws MaoException;

	/**
	 * Loads the value from the owner model and set it to the given widget.
	 * 
	 * @param widget The widget into which the value will be put.
	 */
	public void loadWidgetValue(Widget<?> widget) throws MaoException;

	/**
	 * Creates a transactionnal {@link TransactionalMadCommand command} for executing the
	 * base {@link MadCommand} in an EMF transaction.
	 * 
	 * @param processedElement The element to update.
	 * @param baseCommand The base command to execute into an EMF transaction.
	 * @return The created {@link TransactionalMadCommand}.
	 */
	public MadCommand createTransactionnalMadCommand(ValuedSemanticElement processedElement, MadCommand baseCommand);

}
