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

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;

import com.sysord.mad.widget.WidgetValueListener;

/**
 * Contains a model element, the corresponding value and information for updating /
 * refreshing.
 * <p>
 * The action value is an element property accessed by feature.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 */
public interface ValuedSemanticElement {

	/**
	 * Enumeration of the different modes to access an element.
	 */
	public enum ACCESS_CATEGORY {
		NONE,
		PROPERTY,
		ASSOCIATION_CLASS,
		OPPOSITE_PROPERTY,
		OPERATION_CALL,
		CONTAINER
	}

	/**
	 * Returns the contained element.
	 * 
	 * @return the contained element.
	 */
	public EObject getElement();

	/**
	 * Returns the value of the element.
	 * 
	 * @return the value of the element.
	 */
	public Object getValue();

	/**
	 * Returns the {@link Resource resource} of the contained element.
	 * 
	 * @return the {@link Resource resource} of the contained element.
	 */
	public Resource getElementResource();

	/**
	 * Returns the access {@link ACCESS_CATEGORY category} of this valued semantic
	 * element.
	 * 
	 * @return the access {@link ACCESS_CATEGORY category}.
	 */
	public ACCESS_CATEGORY getAccesCategory();

	/**
	 * Returns the Feature or Operation used/done to obtain the contained element.
	 * 
	 * @return the Feature or Operation used/done to obtain the contained element.
	 */
	public ETypedElement getFeatureOrOperation();

	/**
	 * If the feature or operation is a feature returns it.
	 * 
	 * @return the feature or {@code null}.
	 */
	public EStructuralFeature getFeature();

	/**
	 * If the feature or operation is an operation returns it.
	 * 
	 * @return the operation or {@code null}.
	 */
	public EOperation getOperation();

	/**
	 * Indicates if the contained element is from an other model than the main one.
	 * 
	 * @return {@code true} if the contained element is from an other model;<br>
	 *         {@code false} otherwise.
	 */
	public boolean isForeignModelElement();

	/**
	 * Indicates if the contained value is a {@link Collection}.
	 * 
	 * @return {@code true} if the contained value is a {@link Collection};<br>
	 *         {@code false} otherwise.
	 */
	public boolean isCollection();

	/**
	 * Sets the contained element of this {@link ValuedSemanticElement}.
	 * 
	 * @param element The contained element to set.
	 */
	public void setElement(EObject element);

	/**
	 * Sets the value of the element.
	 * 
	 * @param value The value to set.
	 */
	public void setValue(Object value);

	/**
	 * Sets the {@link Adapter adapter} used for listening to the contained element
	 * notifications.
	 * 
	 * @param adapter The adapter to set.
	 */
	public void setAdapter(Adapter adapter);

	/**
	 * Adds the given {@link ValuedElementListener} to this {@code ValuedSemanticElement}.
	 * 
	 * @param listener The listener to add.
	 */
	public void addElementListener(ValuedElementListener listener);

	/**
	 * Removes the given {@link ValuedElementListener} from this
	 * {@code ValuedSemanticElement}.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeElementListener(ValuedElementListener listener);

	/**
	 * Adds the given {@link WidgetValueListener} to this {@code ValuedSemanticElement}.
	 * 
	 * @param listener The listener to add.
	 */
	public void addValueListener(WidgetValueListener<?> listener);

	/**
	 * Removes the given {@link WidgetValueListener} from this
	 * {@code ValuedSemanticElement}.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeValueListener(WidgetValueListener<?> listener);

}
