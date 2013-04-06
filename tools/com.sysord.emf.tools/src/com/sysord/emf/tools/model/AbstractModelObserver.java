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
package com.sysord.emf.tools.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;


public abstract class AbstractModelObserver extends EContentAdapter implements ModelObserver{

	protected static final boolean TRACE = false;
		
	@Override
	public void notifyChanged(Notification notification) {
		String notificationType = "";
		if(!EObject.class.isAssignableFrom(notification.getNotifier().getClass())){
			return;
		}
		try {
			switch(notification.getEventType()){
			case Notification.SET:
				notificationType ="** SET **";
				//feature set
				process_SET_Notification(notification);
				break;
			case Notification.UNSET:
				notificationType ="** UNSET **";
				//feature unset
				process_UNSET_Notification(notification);
				break;

			//Lists:
			case Notification.MOVE:
				notificationType ="** MOVE **";

				break;			
			case Notification.ADD:
				notificationType ="** ADD **";
				process_ADD_Notification(notification);

				break;
			case Notification.ADD_MANY:
				notificationType ="** ADD MANY **";

				break;			
			case Notification.REMOVE:
				notificationType ="** REMOVE **";
				process_REMOVE_Notification(notification);

				break;
			case Notification.REMOVE_MANY:
				notificationType ="** REMOVE MANY **";

				break;	
			case Notification.REMOVING_ADAPTER:
				return;
			}
			
			if(TRACE){				
			System.out.println(
					notificationType + " ==> " + notification.getNotifier().getClass()
					+ " \nfeature:" + notification.getFeature() 
					+ " \nold:" + notification.getOldValue() 
					+ " \nnew:" + notification.getNewValue());
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		super.notifyChanged(notification);
}
	
	
	/**
	 * Set notification processing:
	 * - notify if old value is a removed element
	 * - notify value change
	 * @param notification
	 */
	protected void process_SET_Notification(Notification notification){
		//does old value has been removed
		notifyIfIsRemovedElement(notification.getNotifier(), notification.getOldValue());

		//does new value is a new element
		notifyIfIsNewElement(notification.getNotifier(), notification.getNewValue());

		//notify element change
		elementChanged((EObject)notification.getNotifier(), (EStructuralFeature) notification.getFeature() , notification.getOldValue(), notification.getNewValue());
	}

	/**
	 * Unset notification processing:
	 * - notify if old value is a removed element
	 * - notify value change
	 * @param notification
	 */
	protected void process_UNSET_Notification(Notification notification){
		//does old value has  been removed
		notifyIfIsRemovedElement(notification.getNotifier(), notification.getOldValue());
				
		//notify element change
		elementChanged((EObject)notification.getNotifier(), (EStructuralFeature) notification.getFeature() , notification.getOldValue(), null);
	}
	
	/**
	 * Remove notification processing:
	 * an element has been remove from a list
	 * - notify if the removed element has been removed from model
	 * - notify list change
	 * @param notification
	 */
	protected void process_REMOVE_Notification(Notification notification){
		//does old value  been removed
		notifyIfIsRemovedElement(notification.getNotifier(), notification.getOldValue());
				
		//notify element change
		elementChanged((EObject)notification.getNotifier(), (EStructuralFeature) notification.getFeature() , notification.getOldValue(), null);
	}
	
	/**
	 * Remove notification processing:
	 * an element has been remove from a list
	 * - notify if the removed element has been removed from model
	 * - notify list change
	 * @param notification
	 */
	protected void process_ADD_Notification(Notification notification){
		//does added value is a new element
		notifyIfIsNewElement(notification.getNotifier(), notification.getNewValue());
				
		//notify element change
		elementChanged((EObject)notification.getNotifier(), (EStructuralFeature) notification.getFeature() , notification.getNewValue(), null);
	}
	
	//----------------------------
	// Remove element detection
	//----------------------------
	
	/**
	 * if element is a removed element raise 'Element removed notification'
	 * 
	 * @param notifier
	 * @param element
	 */
	protected void notifyIfIsRemovedElement(Object notifier, Object element){
		if(isRemovedElement(notifier, element)){
			System.out.println("REMOVED:" + element);
			//notify remove
			elementRemoved((EObject) element, (EObject) notifier);			
		}
	}
	/**
	 * Removed elements are EObject that doesn't have container
	 * @param element
	 * @return
	 */
	protected boolean isRemovedElement(Object notifier, Object element){
		return (element != null && EObject.class.isAssignableFrom(element.getClass())
				&& notifier != null && EObject.class.isAssignableFrom(element.getClass())
				 &&  ((EObject)element).eContainer() == null);
	}
	
	

	//----------------------------
	// New element detection
	//----------------------------

	/**
	 * if element is a new element raise 'Element added notification'
	 * @param element
	 */
	protected void notifyIfIsNewElement(Object notifier, Object element){
		if(isNewElement(notifier, element)){
			System.out.println("ADDED:" + element);
			//notify remove
			elementAdded((EObject) element);			
		}
	}
	
	/**
	 * New element have the notifier as container
	 * @param element
	 * @return
	 */
	protected boolean isNewElement(Object notifier, Object element){
		return (notifier != null && element != null 
				&& EObject.class.isAssignableFrom(notifier.getClass()) 
				&& EObject.class.isAssignableFrom(element.getClass()) 
				&&  ((EObject)element).eContainer() == notifier);
	}
	

	@Override
	public abstract void elementAdded(EObject element);

	@Override
	public abstract void elementChanged(EObject element, EStructuralFeature feature, Object oldValue, Object newValue);

	@Override
	public abstract void elementRemoved(EObject element, EObject oldContainer);

}
