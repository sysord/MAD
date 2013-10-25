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
package com.sysord.emf.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.AnyType;
import org.eclipse.ocl.ecore.CollectionType;

import com.sysord.emf.tools.resource.ResourcesManager;
import com.sysord.emf.tools.transaction.TransactionalCommandProvider;
import com.sysord.emf.tools.transaction.TransactionalCommandProviderImpl;

public class EmfToolsFacade {

	//Singleton
	public static EmfToolsFacade instance;
	public static EmfToolsFacade getInstance(){
		if(instance == null){
			instance = new EmfToolsFacade();
		}
		return instance;
	}
	private EmfToolsFacade(){}
	
	
	/**
	 * Resource manager store resources by uri
	 * and listen for resources change.
	 * When a resource change, the resource is reloaded
	 */
	
	protected ResourcesManager resourcesManager;
	
	public ResourcesManager getResourcesManager(){
		if(resourcesManager == null){
			resourcesManager = new ResourcesManager();
		}
		return resourcesManager;
	}
	
	
	protected TransactionalCommandProvider transactionalCommandProvider;

	public TransactionalCommandProvider getTransactionalCommandProvider(){
		if(transactionalCommandProvider == null){
			transactionalCommandProvider = new TransactionalCommandProviderImpl();
		}
		return transactionalCommandProvider;
	}
	
	/**
	 * Executes a command in a EMF transaction.
	 * @param transactionContext element owned by the modified model 
	 * @param command a runnable 
	 */
	public void executeAsTransactionalCommand(EObject transactionContext, Runnable command){
		getTransactionalCommandProvider().executeAsTransactionnalCommand(transactionContext, command);
	}
	
	/**
     * Indicates if the given {@link EClassifier classifiers} are equal.
     * 
     * @param type1
     * @param type2
     * @return {@code true} if the given {@link EClassifier classifiers} are equal;<br>
     *         {@code false} otherwise.
     */
    public boolean typesEqual(EClassifier type1, EClassifier type2) {
        if (type1 == null && type2 == null) {
            return true;
        }// else
        if (type1 == null || type2 == null) {
            return false;
        }

        if (EDataType.class.isInstance(type1) && EDataType.class.isInstance(type2)) {
            if (type1 instanceof CollectionType && type2 instanceof CollectionType) {
                if (((CollectionType) type1).getKind() == ((CollectionType) type2).getKind()) {
                    return typesEqual(((CollectionType) type1).getElementType(),
                            ((CollectionType) type2).getElementType());
                }
            }// else

            // TODO Test du Tuple

            // EEnum, Primitive type
            if (((EDataType) type1).getInstanceClass() == ((EDataType) type2).getInstanceClass()) {
                return true;
            }// else
        }// else

        if (type1 instanceof EClass && type2 instanceof EClass) {
            return isEClassEquals((EClass) type1, (EClass) type2);
        }// else

        if (type1 instanceof AnyType || type2 instanceof AnyType) {
            EClassifier eClassifier1;
            EClassifier eClassifier2;
            eClassifier1 = type1 instanceof AnyType ? type1.eClass() : type1;
            eClassifier2 = type2 instanceof AnyType ? type2.eClass() : type2;
            return eClassifier1.getName().equals(eClassifier2.getName());
        }// else
        
        return false;
    }
	
	/**
	 * return true if eClasses are equals:
	 * - same package
	 * - same name
	 * 
	 * @param eclass1
	 * @param eclass2
	 * @return
	 */
	public boolean isEClassEquals(EClass eclass1, EClass eclass2){
		if(EcoreUtil.equals(eclass1, eclass2)){
			return true;
		}
		
		if (eclass1 == null)
	    {
	        return eclass2 == null;
	    }	      
	    // We know the first object isn't null, so if the second one is, it can't be equal.
		if (eclass2 == null)
		{
			return false;
		}

		//Same name and same package nsURI
		return  eclass1.getName().equals(eclass2.getName())
				&& ((EPackage) eclass1.eContainer()).getNsURI()
					.equals( ((EPackage) eclass2.eContainer()).getNsURI() );								
	}
	
	
	public Class<?> eClassifierToClass(EClassifier eClassifier){
		//TODO ?????
		return EObject.class;
	}
	
	
	public <T extends EObject> List<T> getAllContentsOfEclassType(EObject ele, EClass type) {
		return getAllContentsOfEclassType(ele.eAllContents(), type);
	}

	public <T extends EObject> List<T> getAllContentsOfEclassType(EObject ele, Collection<EClass> types) {
		return getAllContentsOfEclassType(ele.eAllContents(), types);
	}
	
	public <T extends EObject> List<T> getAllContentsOfEclassType(Collection<EObject> elements, EClass type) {
		return getAllContentsOfEclassType(elements.iterator(), type);
	}

	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getAllContentsOfEclassType(Iterator<EObject> itElements, EClass type) {
		List<T> result = new ArrayList<T>();
		while (itElements.hasNext()) {
			EObject object = itElements.next();
			if (isEClassEquals(type, object.eClass())) {
				result.add((T) object);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getAllContentsOfEclassType(Iterator<EObject> itElements, Collection<EClass> types) {
		Set<EClass> selectableClasses = new HashSet<EClass>();
		List<T> result = new ArrayList<T>();
		while (itElements.hasNext()) {
			EObject object = itElements.next();
			boolean isSelectable = false;
			if(selectableClasses.contains(object.eClass())){
				isSelectable = true;
			}else{
				for(EClass type : types){
					if (isEClassEquals(type, object.eClass())) {
						isSelectable = true;
						selectableClasses.add(type);
						break;
					}
				}				
			}
			if(isSelectable){
				result.add((T) object);				
			}
		}
		return result;
	}

	
	
	public <T extends EObject> List<T> getAllContentsExcludingEClassesType(EObject element, List<EClass> excludedTypes) {
		return getAllContentsExcludingEClassesType(element.eAllContents(), excludedTypes);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getAllContentsExcludingEClassesType(Iterator<? extends EObject> itElements, List<EClass> excludedTypes) {
		List<T> result = new ArrayList<T>();
		while (itElements.hasNext()) {
			EObject object = itElements.next();
			boolean isExcluded = false;
			for(EClass excludedType : excludedTypes){
				if (isEClassEquals(excludedType, object.eClass())) {
					isExcluded  = true;
					break;
				}				
			}
			if(!isExcluded){
				result.add((T) object);
			}
		}
		return result;
	}
	
	/**
	 * Look for a container instance of the searchedClass
	 */
    @SuppressWarnings("unchecked")
	public  <T> T getParent(EObject current, Class<T> searchedClass){
		if(searchedClass.equals(current.getClass())){
			return (T) current;
		}else {			
			if(current.eContainer() == null){
				return null;
			}
			return getParent(current.eContainer(), searchedClass);
		}
	}

    @SuppressWarnings("unchecked")
	public  <T> T getParent(EObject current, EClass searchedEClass){
		if(searchedEClass.equals(current.eClass())){
			return (T) current;
		}else {			
			if(current.eContainer() == null){
				return null;
			}
			return getParent(current.eContainer(), searchedEClass);
		}
	}

	/**
	 * Returns all the parents of the given {@link EObject} having the specified
	 * {@link EClass}.
	 * 
	 * @param current The EObject for which to search the parents.
	 * @param searchedEClass The EClass of the parents to search.
	 * @return all the parents of the given {@link EObject} having the specified
	 *         {@link EClass}.
	 * @since 1.1
	 */
    @SuppressWarnings("unchecked")
	public <T> Collection<T>  getParents(EObject current, EClass searchedEClass){
    	Collection<T> parents = new ArrayList<T>();
    	while(current != null){
    		if(searchedEClass.equals(current.eClass())){
    			parents.add((T) current);
    		}    		
			current = current.eContainer();
    	}
    	return parents;
	}

    
    @SuppressWarnings("unchecked")
	public  <T> T getAssignableParent(EObject current, Class<T> searchedClass){
		if(searchedClass.isAssignableFrom(current.getClass())){
			return (T) current;
		}else {			
			if(current.eContainer() == null){
				return null;
			}
			return getAssignableParent(current.eContainer(), searchedClass);
		}
	}
	
 	public EObject getFirstAssignableParent(EObject current, Class<? extends EObject>[] searchedClasses){
 		if(isAssignableFromClasses(current, searchedClasses)){
 			return current;
 		}else {			
 			if(current.eContainer() == null){
 				return null;
 			}
 			return getFirstAssignableParent(current.eContainer(), searchedClasses);
 		}
 	}
    
    protected boolean isAssignableFromClasses(EObject current, Class<? extends EObject>[] searchedClasses){
    	for(Class<? extends EObject> clazz : searchedClasses){
    		if(clazz.isAssignableFrom(current.getClass())){
    			return true;
    		}
    	}
    	return false;
    }

    
    
	
//	public Class<?> eClassToClass(EClass eClass){
//		System.out.println("CREE:" + EcoreUtil.create(eClass));
//		return EcoreUtil.create(eClass).getClass();
//	}
//	public Class<?> eClassifierToClass(EClassifier eClassifier){
//		if(EClass.class.isAssignableFrom(eClassifier.getClass())){
////			if(eClassifier.getInstanceClassName() == null){
////				//package 
////				String classValue = eClassifier.eContainer().getClass().getPackage().getName(); 
////				classValue += '.' + eClassifier.getName();
////				eClassifier.setInstanceClassName(classValue);
////			}
//			Class<?> clazz = eClassToClass(((EClass)eClassifier));
//			return eClassToClass(((EClass)eClassifier));
//		}
//		
//		if(EDataType.class.isAssignableFrom(eClassifier.getClass())){
////			if(eClassifier.get() == null){
////				//package 
////				String classValue = eClassifier.eContainer().getClass().getPackage().getName(); 
////				classValue += '.' + eClassifier.getName();
////				eClassifier.setInstanceClassName(classValue);
////			}			
//			eClassifier.setInstanceClassName("java.lang.String");
//		}
//		
//		return eClassifier.getInstanceClass();
//	}
	
}
