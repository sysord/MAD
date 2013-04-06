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
package com.sysord.mad.emitter;

import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.widget.Widget;

/**
 * A {@code ViewEmitter} will create a {@link ModelElementView view} with the given
 * {@link Context context}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see Context
 * @see ModelElementView
 */
public interface ViewEmitter {

	/**
	 * Configures this {@code ViewEmitter} with the given {@link Context context}.
	 * <p>
	 * This method must be called before any other methods.
	 * <p>
	 * If this {@code ViewEmitter} is already configured with an other {@link Context
	 * context}, the previous context will be replaced.
	 * 
	 * @param context The {@link Context context} used for configuring this
	 *        {@code ViewEmitter}.
	 */
	public void configure(Context context);

	/**
	 * Creates a {@link ModelElementView view} using the defined {@link Context context}.
	 * 
	 * @return the created {@link ModelElementView view}.
	 * @throws IllegalStateException if this {@code ViewEmitter} has not been configured.
	 */
	public ModelElementView emitView();

	/**
	 * Creates and add the specified {@link Widget} to the {@link ModelElementView view}.
	 * <p>
	 * The specified WidgetConfig must not be {@code null}.
	 * 
	 * @param config The {@link WidgetConfiguration configuration} of the widget to
	 *        create.
	 * @return the created {@link Widget widget}.
	 * @throws IllegalArgumentException if the type is not usable for a widget.
	 */
	public Widget<?> emitWidget(WidgetConfiguration<?> config);

}
