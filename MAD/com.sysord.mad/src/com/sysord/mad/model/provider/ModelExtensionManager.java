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
package com.sysord.mad.model.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Base method used by MAD_EXTENSION query langauge
 * for obtains Master model elements extensions owned
 * by an extension model.
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public interface ModelExtensionManager {

	/**
	 * Returns true if extension can be created for the element.
	 * @param element
	 * @return
	 */
	public boolean elementSupportExtension(EObject model, EObject element);

	
	/**
	 * Called for notify when an extended element have changed
	 * 
	 * @param extensionModel TODO
	 * @param extendedElement
	 * @param changedFeature
	 * @param oldValue
	 * @param newValue
	 * @return return true if the extension model have been changed
	 */
	public boolean onExtendedElementChange(EObject extensionModel, EObject extendedElement, EStructuralFeature changedFeature, Object oldValue, Object newValue);
	
	/**
	 * Retrieve and return the extension model element that should contain an extension of the type extensionType for the element.
	 * 
	 * @param element
	 * @param extensionType name of the extension type. (can be null if not deterministic for select the container)
	 * @param createIfNotExists if extension not exits, try to create it
	 * @return
	 */
	public EObject getElementExtensionContainer(EObject model, EObject element, String extensionTypeName, boolean createIfNotExists);

	
	/**
	 * Retrieve and return the extension of type extensionType contained by the extenion container.
	 * 
	 * @param extensionContainer
	 * @param extensionTypeName name of the extension type. (can be null)
	 * @param createIfNotExists if extension not exits, try to create it
	 * @return
	 */
	public EObject getContainedExtension(EObject extensionContainer, String extensionTypeName, boolean createIfNotExists);

	/**
	 * Retrieve and return the extension of type extensionTypeName contained by the extension container.
	 * the discriminator value provide a way for distinguish several extension of same type.
	 * 
	 * @param extensionContainer
	 * @param extensionTypeName
	 * @param discriminator
	 * @param createIfNotExists
	 * @return
	 */
	public EObject getContainedExtension(EObject extensionContainer, String extensionTypeName, String discriminator, boolean createIfNotExists);

	
	/**
	 * Retrieve and return an extension of the type extensionType for the element.
	 * 
	 * if extensionTypeName is null the extension container is returned.
	 * 
	 * @param element
	 * @param extensionTypeName name of the extension type. (can be null)
	 * @param createIfNotExists if extension not exits, try to create it
	 * @return
	 */
	public EObject getElementExtension(EObject model, EObject element, String extensionTypeName, boolean createIfNotExists);
	
	/**
	 * Retrieve and return an extension of the type extensionType for the element.
	 * the discriminator value provide a way for distinguish several extension of same type.
	 * 
	 * if extensionTypeName is null the extension container is returned if exists.
	 * 
	 * @param element
	 * @param extensionTypeName name of the extension type.
	 * @param discriminator 
	 * @param createIfNotExists if extension not exits, try to create it
	 * @return
	 */
	public EObject getElementExtension(EObject model, EObject element, String extensionTypeName, String discriminator, boolean createIfNotExists);

	/**
	 * Try to locate and remove an  extension by type
	 * if extensionTypeName is null all extension for the element will be removed
	 * 
	 * @param model
	 * @param element
	 * @param element container: if null the element container will be used, 
	 * 							when element has been removed it does not have container 
	 * 							and elementContainer will be its container before it has been removed
	 * @param extensionTypeName name of the extension type.
	 * @return 
	 */
	public void removeExtension(EObject model, EObject element, EObject elementContainer, String extensionTypeName);

	/**
	 * Try to locate and remove an UML extension by type and discriminator
	 * if extensionType is null all extension for the element will be removed
	 * 
	 * @param model  
	 * @param element
	 * @param element container: if null the element container will be used, 
	 * 							when element has been removed it does not have container 
	 * 							and element container will be its container before it has been removed
	 * @param extensionTypeName name of the extension type.
	 * @param discriminator
	 * @return
	 */
	public void removeExtension(EObject model, EObject element, EObject elementContainer, String extensionTypeName, String discriminator);

	/**
	 * When an element change ...
	 * @param model
	 * @param element
	 */
	public void updateElementReference(EObject model, EObject element);


	 
	
}
