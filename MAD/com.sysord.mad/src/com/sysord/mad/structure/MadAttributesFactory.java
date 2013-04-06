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
package com.sysord.mad.structure;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;

import com.sysord.mad.MadAttribute;
import com.sysord.mad.MadBooleanAttribute;
import com.sysord.mad.MadCollection;
import com.sysord.mad.MadEnumAttribute;
import com.sysord.mad.MadMultiObjectAttribute;
import com.sysord.mad.MadSingleObjectAttribute;
import com.sysord.mad.MadStringAttribute;

/**
 * Factory for {@link MadAttribute}s.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 */
public interface MadAttributesFactory {

	/**
	 * Creates a new {@link MadEnumAttribute}.
	 * 
	 * @param feature
	 * @param attributeValue
	 * @return the created {@code MadEnumAttribute}.
	 */
	public MadEnumAttribute createMadEnumAttribute(EStructuralFeature feature, Object attributeValue);

	/**
	 * Creates a new {@link MadStringAttribute}.
	 * 
	 * @param feature
	 * @param attributeValue
	 * @return the created {@code MadStringAttribute}.
	 */
	public MadStringAttribute createMadStringAttribute(EStructuralFeature feature, Object attributeValue);

	/**
	 * Creates a new {@link MadBooleanAttribute}.
	 * 
	 * @param feature
	 * @param attributeValue
	 * @return the created {@code MadBooleanAttribute}.
	 */
	public MadBooleanAttribute createMadBooleanAttribute(EStructuralFeature feature, Object attributeValue);

	/**
	 * Creates a new {@link MadSingleObjectAttribute}.
	 * 
	 * @param contextObject
	 * @param feature
	 * @param attributeValue
	 * @return the created {@code MadSingleObjectAttribute}.
	 */
	public MadSingleObjectAttribute createMadSingleObjectAttribute(EObject contextObject, EStructuralFeature feature,
			Object attributeValue);

	/**
	 * Creates a new {@link MadMultiObjectAttribute}.
	 * 
	 * @param contextObject
	 * @param feature
	 * @param attributeValue
	 * @return the created {@code MadMultiObjectAttribute}.
	 */
	public MadMultiObjectAttribute createMadMultiObjectAttribute(EObject contextObject, EStructuralFeature feature,
			Object attributeValue);

	/**
	 * Returns the collection of {@link EObject}s corresponding to the type of the given
	 * {@code feature} that are contained into the same {@link Resource} of the given
	 * {@code contextObject}.
	 * 
	 * @param contextObject
	 * @param feature
	 * @return the collection of {@code EObject}s corresponding to the type of the given
	 *         {@code feature}.
	 */
	public Collection<? extends EObject> getCandidates(EObject contextObject, ETypedElement feature);

	/**
	 * Creates a new {@link MadCollection} from the given {@code collection} of
	 * {@link EObject}s.
	 * 
	 * @param collection
	 * @return the created {@code MadCollection}.
	 */
	public MadCollection createMadCollection(Collection<? extends EObject> collection);

}
