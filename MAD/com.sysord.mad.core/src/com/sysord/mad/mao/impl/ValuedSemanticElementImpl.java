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
package com.sysord.mad.mao.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;

import com.sysord.emf.tools.EMFUtil;
import com.sysord.mad.mao.ValuedElementListener;
import com.sysord.mad.mao.ValuedSemanticElement;
import com.sysord.mad.widget.WidgetValueListener;

public class ValuedSemanticElementImpl implements ValuedSemanticElement {

	protected Resource elementResource;
	protected EObject element;
	
	protected boolean isForeignModelElement;
	protected ACCESS_CATEGORY accesCategory;
	protected ETypedElement featureOrOperation;

	protected Object value;
    protected Adapter adapter;
    
    protected List<ValuedElementListener> valuedElementListeners;
    protected List<WidgetValueListener<?>> valueListeners;
	
	
	public ValuedSemanticElementImpl(EObject element, boolean isForeignModelElement, ACCESS_CATEGORY accesCategory, ETypedElement featureOrOperation, Object value) {
		super();
		this.element = element;
		this.isForeignModelElement = isForeignModelElement;
		this.accesCategory = accesCategory;
		this.featureOrOperation = featureOrOperation;
		this.value = value;
		valuedElementListeners = new ArrayList<ValuedElementListener>(1);
        valueListeners = new ArrayList<WidgetValueListener<?>>(1);
	}


	@Override
	public EObject getElement() {
		return element;
	}

	@Override
	public void setElement(EObject element) {
	    EMFUtil.moveAdapter(adapter, this.element, element);
	    EObject oldElement = this.element;
		this.element = element;		
		notifyElementChanged(oldElement, element);
	}

	@Override
	public Resource getElementResource() {
		if(elementResource == null){
			elementResource = element.eResource();
		}
		return elementResource;
	}

	
	@Override
	public boolean isForeignModelElement() {
		return isForeignModelElement;
	}


	@Override
	public ACCESS_CATEGORY getAccesCategory() {
		return accesCategory;
	}


	@Override
	public ETypedElement getFeatureOrOperation() {
		return featureOrOperation;
	}

	@Override
	public EStructuralFeature getFeature() {
		if(!EStructuralFeature.class.isAssignableFrom(featureOrOperation.getClass())){
			return null;
		}else{
			return (EStructuralFeature) featureOrOperation;			
		}
	}

	@Override
	public EOperation getOperation() {
		if(!EOperation.class.isAssignableFrom(featureOrOperation.getClass())){
			return null;
		}else{
			return (EOperation) featureOrOperation;			
		}
	}


	@Override
	public Object getValue() {
		return value;
	}


	@Override
	public void setValue(Object value) {
	    Object oldValue = this.value;
		this.value = value;
		notifyValueChanged(oldValue, value);
	}



	@Override
    public void setAdapter(Adapter adapter) {
	    this.adapter = adapter;
    }


    @Override
	public boolean isCollection() {
		return (featureOrOperation.getUpperBound() == -1 || featureOrOperation.getUpperBound() > 1);
	}


    /**
     * Notifies the registered {@link ValuedElementListener}s that the element have changed.
     * 
     * @param oldElement
     * @param newElement
     */
    protected void notifyElementChanged(EObject oldElement, EObject newElement) {
        if (oldElement != newElement) {
            for (ValuedElementListener listener : valuedElementListeners) {
                listener.valuedElementChanged(oldElement, newElement);
            }
        }
    }

    /**
     * Notifies the registered {@link WidgetValueListener}s the value changed.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected void notifyValueChanged(Object ancientValue, Object newValue) {
        for (WidgetValueListener listener : valueListeners) {
            listener.valueChanged(ancientValue, newValue);
        }
    }


    @Override
    public void addElementListener(ValuedElementListener listener) {
        valuedElementListeners.add(listener);
    }


    @Override
    public void removeElementListener(ValuedElementListener listener) {
        valuedElementListeners.remove(listener);
    }

    @Override
    public void addValueListener(WidgetValueListener<?> listener) {
        valueListeners.add(listener);
    }

    @Override
    public void removeValueListener(WidgetValueListener<?> listener) {
        valueListeners.remove(listener);
    }

}
