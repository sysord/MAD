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
import java.util.List;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.xtext.EcoreUtil2;

import com.sysord.mad.MadBooleanAttribute;
import com.sysord.mad.MadCollection;
import com.sysord.mad.MadEnumAttribute;
import com.sysord.mad.MadFactory;
import com.sysord.mad.MadMultiObjectAttribute;
import com.sysord.mad.MadSingleObjectAttribute;
import com.sysord.mad.MadStringAttribute;

public class MadAttributesFactoryImpl implements MadAttributesFactory {

	/* (non-Javadoc)
	 * @see com.sysord.mad.structure.MadAttributesFactory#createMadEnumAttribute(org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	@Override
	public MadEnumAttribute createMadEnumAttribute(EStructuralFeature feature, Object attributeValue) {
		MadEnumAttribute madAttribute = MadFactory.eINSTANCE.createMadEnumAttribute();		
		madAttribute.setName(feature.getName());
		madAttribute.setValue((EEnumLiteral) attributeValue);
		madAttribute.getCandidates().addAll(((EEnum)feature.getEType()).getELiterals());				
		return madAttribute;
	}
	
	/* (non-Javadoc)
	 * @see com.sysord.mad.structure.MadAttributesFactory#createMadStringAttribute(org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	@Override
	public MadStringAttribute createMadStringAttribute(EStructuralFeature feature, Object attributeValue) {
		MadStringAttribute madAttribute = MadFactory.eINSTANCE.createMadStringAttribute();		
		madAttribute.setName(feature.getName());
		madAttribute.setValue((String) attributeValue);				
		return madAttribute;
	}
	
	/* (non-Javadoc)
	 * @see com.sysord.mad.structure.MadAttributesFactory#createMadBooleanAttribute(org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	@Override
	public MadBooleanAttribute createMadBooleanAttribute(EStructuralFeature feature, Object attributeValue) {
		MadBooleanAttribute madAttribute = MadFactory.eINSTANCE.createMadBooleanAttribute();		
		madAttribute.setName(feature.getName());
		madAttribute.setValue((Boolean) attributeValue);				
		return madAttribute;
	}
	
	/* (non-Javadoc)
	 * @see com.sysord.mad.structure.MadAttributesFactory#createMadSingleObjectAttribute(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	@Override
	public MadSingleObjectAttribute createMadSingleObjectAttribute(EObject contextObject, EStructuralFeature feature, Object attributeValue) {
		MadSingleObjectAttribute madAttribute = MadFactory.eINSTANCE.createMadSingleObjectAttribute();		
		madAttribute.setName(feature.getName());
		madAttribute.setValue((EObject) attributeValue);
		madAttribute.getCandidates().addAll(getCandidates(contextObject, feature));		
		return madAttribute;
	}
	
	/* (non-Javadoc)
	 * @see com.sysord.mad.structure.MadAttributesFactory#createMadMultiObjectAttribute(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	@Override
	public MadMultiObjectAttribute createMadMultiObjectAttribute(EObject contextObject, EStructuralFeature feature, Object attributeValue) {
		MadMultiObjectAttribute madAttribute = MadFactory.eINSTANCE.createMadMultiObjectAttribute();		
		madAttribute.setName(feature.getName());
		madAttribute.getValue().addAll((Collection<EObject>) attributeValue);		
		madAttribute.getCandidates().addAll(getCandidates(contextObject, feature));		
		return madAttribute;
	}
	
	/* (non-Javadoc)
	 * @see com.sysord.mad.structure.MadAttributesFactory#getCandidates(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.ETypedElement)
	 */
	@Override
	public Collection<? extends EObject> getCandidates(EObject contextObject, ETypedElement feature){
		//look for candidates
		if(contextObject == null || contextObject.eResource() == null){
			return null;
		}
		EObject root = contextObject.eResource().getContents().get(0);										
		List<? extends EObject> candidates = EcoreUtil2.getAllContentsOfType(root, 
							(Class<? extends EObject>)feature.getEType().getInstanceClass());
		return candidates;
	}

	@Override
	public MadCollection createMadCollection(Collection<? extends EObject> collection) {
		MadCollection madCollection = MadFactory.eINSTANCE.createMadCollection();
		madCollection.getItems().addAll(collection);
		return madCollection;
	}
	
	
}
