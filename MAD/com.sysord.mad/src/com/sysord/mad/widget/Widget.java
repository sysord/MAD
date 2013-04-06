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
package com.sysord.mad.widget;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;

import com.sysord.eclipse.tools.diagnostic.Diagnostic;
import com.sysord.emf.tools.misc.ActivatableAdapter;
import com.sysord.mad.command.MadCommand;
import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.emitter.ModelElementView;
import com.sysord.mad.emitter.WidgetFactory;
import com.sysord.mad.mao.MaoCommand;
import com.sysord.mad.mao.ValuedSemanticElement;

/**
 * A {@code Widget} is a description of a graphical component associated with a semantic
 * element of a model.
 * <p>
 * {@code Widget} is the <em>super-interface</em> of all existing widgets.
 * <p>
 * The widgets are put together to form a {@link ModelElementView}.
 * 
 * @param <T> Type of the represented ecore model element.
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see ValuedSemanticElement
 * @see ActionWidget
 * @see OutputWidget
 * @see InputWidget
 * @see FlexibleWidget
 * @see WidgetFactory
 * @see ModelElementView
 */
public interface Widget<T> extends Cloneable {

	/**
	 * Creates and returns an adapter of type {@code adapterClass} if this widget can be
	 * adapted to the given {@code adapterClass}, {@code null} otherwise.
	 * 
	 * @param <AT> the adapter type.
	 * @param adapterClass the adapter type class.
	 * @return the adapter if it exists;<br>
	 *         {@code null} otherwise.
	 */
	public <AT> AT getAdapter(Class<AT> adapterClass);

	/**
	 * Returns this widget's ID.
	 * 
	 * @return this widget's ID.
	 */
	public String getId();

	/**
	 * Returns this widget {@link ModelElementView view model}.
	 * 
	 * @return this widget view model.
	 */
	public ModelElementView getOwnerViewModel();

	/**
	 * Sets the owner view model for this widget.
	 * 
	 * @param viewModel The {@link ModelElementView view model} to set.
	 */
	public void setOwnerViewModel(ModelElementView viewModel);

	/**
	 * Returns the valued semantic {@link ValuedSemanticElement element} of this widget.
	 * 
	 * @return the valued semantic element of this widget.
	 */
	public ValuedSemanticElement getValuedSemanticElement();

	/**
	 * Set the valued semantic element for this widget.
	 * 
	 * @param valuedElement The valued semantic {@link ValuedSemanticElement element} to
	 *        set.
	 */
	public void setValuedSemanticElement(ValuedSemanticElement valuedElement);

	/**
	 * Returns this widget's label.
	 * 
	 * @return this widget's label.
	 */
	public String getLabel();

	/**
	 * Redefines this widget's label
	 * 
	 * @param label The label to define.
	 */
	public void setLabel(String label);

	/**
	 * Defines this widget's visibility.
	 * 
	 * @param visible {@code true} if this widget should be visible;<br>
	 *        {@code false} otherwise.
	 */
	public void setVisible(boolean visible);

	/**
	 * Returns the visibility state of this widget.
	 * 
	 * @return {@code true} if this widget is defined to be visible;<br>
	 *         {@code false} otherwise.
	 */
	public boolean isVisible();

	/**
	 * Returns the {@link Class} object of the type of this widget's value.
	 * 
	 * @return the {@link Class} object of the type of this widget's value.
	 */
	public Class<T> getType();

	/**
	 * Calls the {@link WidgetVisitor#visit(Widget)} method corresponding to this widget's
	 * instance type.
	 * 
	 * @param visitor The {@link WidgetVisitor visitor} to accept.
	 */
	public <V> V accept(WidgetVisitor<V> visitor);

	/**
	 * Returns this widget's {@link WidgetConfiguration configuration}.
	 * 
	 * @return this widget's configuration.
	 */
	public WidgetConfiguration<T> getConfig();

	/**
	 * Sets this widget's {@link WidgetConfiguration configuration}.
	 * 
	 * @param config The configuration to set.
	 */
	public void setConfig(WidgetConfiguration<T> config);

	/**
	 * Sets this widget's owner.
	 * 
	 * @param widget The owner of this widget.
	 */
	public void setOwnerWidget(Widget<?> widget);

	/**
	 * Returns the {@code Widget} owning this widget.
	 * <p>
	 * The owner can be {@code null} if this widget is at the root of the
	 * {@link ModelElementView view}.
	 * 
	 * @return the {@link Widget} owning this widget.
	 */
	public Widget<?> getOwnerWidget();

	/**
	 * Returns the element context : context for all evaluation.
	 * 
	 * @return the element context.
	 */
	public EObject getContextElement();

	/**
	 * Adds the given {@link MaoCommand command} with the specified {@code id}.
	 * 
	 * @param commandId The id of the command to add.
	 * @param command The command to add.
	 */
	public void addCommand(String commandId, MadCommand command);

	/**
	 * Removes the {@link MaoCommand command} corresponding to the given {@code id}.
	 * 
	 * @param commandId The id of the command to remove.
	 */
	public void removeCommand(String commandId);

	/**
	 * Returns the {@link MaoCommand command} corresponding to the given {@code id}.
	 * 
	 * @param commandId The id of the command to retrieve.
	 */
	public MadCommand getCommand(String commandId);

	/**
	 * Executes the {@link MaoCommand command} corresponding to the given {@code id}.
	 * 
	 * @param commandId The id of the command to execute.
	 */
	public void executeCommand(String commandId);

	/**
	 * Returns this widget's {@link ActivatableAdapter}.
	 * <p>
	 * The {@code ActivatableAdapter} is the one put on the {@link EObject} element of
	 * {@link #getValuedSemanticElement()}.
	 * 
	 * @return this widget's {@link Adapter}.
	 */
	public ActivatableAdapter getAdapter();

	/**
	 * Disposes this {@code Widget}.
	 */
	public void dispose();

	/**
	 * Adds the given {@link WidgetDisposeListener} to this Widget.
	 * 
	 * @param listener The listener to add.
	 */
	public void addDisposeListener(WidgetDisposeListener listener);

	/**
	 * Removes the given {@link WidgetDisposeListener} from this Widget.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeDisposeListener(WidgetDisposeListener listener);

	/**
	 * Adds the given {@link WidgetVisibilityListener} to this Widget.
	 * 
	 * @param listener The listener to add.
	 */
	public void addVisibilityListener(WidgetVisibilityListener listener);

	/**
	 * Removes the given {@link WidgetVisibilityListener} from this Widget.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeVisibilityListener(WidgetVisibilityListener listener);

	/**
	 * Adds the given {@link WidgetElementListener} to this widget.
	 * 
	 * @param listener The listener to add.
	 */
	public void addElementListener(WidgetElementListener listener);

	/**
	 * Removes the given {@link WidgetElementListener} from this widget.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeElementListener(WidgetElementListener listener);

	/**
	 * Creates a copy of this widget.
	 * 
	 * @return the created copy of this widget.
	 */
	public Widget<T> clone() throws CloneNotSupportedException;
	
	/**
	 * the widget status diagnostic getter.
	 * @return
	 */
	public Diagnostic getStatus();

	/**
	 * Sets a diagnostic for defining an error or warning status for the widget
	 * @param diagnostic
	 */
	public void setStatus(Diagnostic diagnostic);
	
}
