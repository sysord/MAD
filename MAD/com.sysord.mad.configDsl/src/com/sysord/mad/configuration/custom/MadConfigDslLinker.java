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
package com.sysord.mad.configuration.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.Multimap;
import com.sysord.mad.configuration.madConfigDsl.MadConfigDslPackage;
import com.sysord.mad.configuration.madConfigDsl.QueryDefinitionMdsl;

/**
 * set properties default values
 */
public class MadConfigDslLinker extends LazyLinker{


	
	/**
	 * Configuration for an Eclass
	 */
	protected static class EClassDefaultValueConfig{

		EClass eClass;
		List<FeatureConfig> lFeaturesConfigs = new ArrayList<MadConfigDslLinker.EClassDefaultValueConfig.FeatureConfig>();
		
		/**
		 * Configuration for a Feature
		 */
		protected class FeatureConfig{			
			EStructuralFeature eFeature;
			Object defaultValue;
			
			public FeatureConfig(EStructuralFeature eFeature, Object defaultValue) {
				super();
				this.eFeature = eFeature;
				this.defaultValue = defaultValue;
			}			
		}
		

		public EClassDefaultValueConfig(EClass eClass) {
			super();
			this.eClass = eClass;
		}
		
		/**
		 * Add default value configuration for a feature
		 * @param eFeature
		 * @param defaultValue
		 * @return
		 */
		public EClassDefaultValueConfig add(int eFeatureId , Object defaultValue){
			lFeaturesConfigs.add(new FeatureConfig(eClass.getEStructuralFeature(eFeatureId), defaultValue));
			return this;
		}
	}
	


	
	
	protected static Map<EClass, EClassDefaultValueConfig> configurations = new HashMap<EClass, EClassDefaultValueConfig>();	
	/**
	 * Add Eclass default value configuration
	 * @param eClassConfig
	 */
	protected static void addConfiguration(EClassDefaultValueConfig eClassConfig){
		configurations.put(eClassConfig.eClass, eClassConfig);
	}

//	// Configuration
//	static {
//
//		addConfiguration(new UmllLinker.EClassDefaultValueConfig(UmllDslPackage.Literals.PROPERTY)
//			.add(UmllDslPackage.PROPERTY__CONTAINER_TYPE, ContainerType.NONE)
//			.add(UmllDslPackage.PROPERTY__LOWER, 1)
//			.add(UmllDslPackage.PROPERTY__UPPER, 1)							
//		);
//		
//	}
	
	
	
	@Override
	protected void installProxies(EObject obj, IDiagnosticProducer producer,
			Multimap<Setting, INode> settingsToLink) {


		super.installProxies(obj, producer, settingsToLink);

		try {
			
			//Apply default Query value type when not defined			 
			if(obj.eClass().equals(MadConfigDslPackage.Literals.QUERY_DEFINITION_MDSL) ){
				QueryDefinitionMdsl queryDefMdsl = (QueryDefinitionMdsl) obj;
				if(queryDefMdsl.getReturnType() == null){
					queryDefMdsl.setReturnType(EcorePackage.Literals.ECLASS) ;
				}
			}
			
//			if(obj.eClass().equals(UmllDslPackage.Literals.ASSOCIATION_END) ){
//				super.installProxies(((AssociationEnd) obj).getOpposite(), producer, settingsToLink);
//			}
//
//			
//			if(configurations.containsKey(obj.eClass())){
//				for(UmllLinker.EClassDefaultValueConfig.FeatureConfig featureConf : configurations.get(obj.eClass()).lFeaturesConfigs){
//					if(obj.eClass().getEStructuralFeature(featureConf.eFeature.getName()) != null){
//						obj.eSet(obj.eClass().getEStructuralFeature(featureConf.eFeature.getName()), featureConf.defaultValue);					
//					}
//				}
//			}
//			
//			if(obj.eClass().equals(UmllDslPackage.Literals.ASSOCIATION)){
//				processAssociation(obj);
//			}
//
//			if(obj.eClass().equals(UmllDslPackage.Literals.ASSOCIATION_END) ){
//				processAssociationEnd(obj);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void processAssociation(EObject obj){
		//traiter les associations invalides: association ends inexistance
	}

//	protected void processAssociationEnd(EObject obj){
//		//créer les associations si elles n'existe pas
//		AssociationEnd assocEnd = (AssociationEnd)obj;
//		for(Association assoc : EcoreUtil2.getAllContentsOfType(UmllDslHelper.getModel(obj), Association.class)){
//			if(assoc.getSourceEnd().equals(assocEnd) || assoc.getTargetEnd().equals(assocEnd)){
//				//association exists
//				return;
//			}
//		}
//		
//		AssociationEnd otherEnd = assocEnd.getOpposite();	
//		if(assocEnd.eIsProxy()){
//			assocEnd = (AssociationEnd) EcoreUtil.resolve(otherEnd, obj.eResource());
//		}
//		if(otherEnd.eIsProxy()){
//			otherEnd = (AssociationEnd) EcoreUtil.resolve(otherEnd, obj.eResource());
//		}
//		//create association
//		Association association = UmllDslFactory.eINSTANCE.createAssociation();
//		association.setName(otherEnd.getType().getName() + "_" + assocEnd.getName() 
//							+ "__" + assocEnd.getType().getName() + "_" + otherEnd.getName());		
//		association.setSource(assocEnd.getType());
//		association.setSourceEnd(assocEnd);		
//		association.setTarget(otherEnd.getType());
//		association.setTargetEnd(otherEnd);	
//		//add association to model
//		UmllDslHelper.getModel(obj).getAssociations().add(association);		
//	}

	
}
