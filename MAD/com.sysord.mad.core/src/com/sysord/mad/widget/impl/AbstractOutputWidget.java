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
package com.sysord.mad.widget.impl;

import java.util.ArrayList;
import java.util.List;

import com.sysord.mad.configuration.ValueConverterConfiguration;
import com.sysord.mad.converter.ValueConverterFactory;
import com.sysord.mad.converter.WidgetValueConverter;
import com.sysord.mad.core.Activator;
import com.sysord.mad.mao.ValuedSemanticElement;
import com.sysord.mad.widget.*;

/**
 * Abstract implementation of the {@link OutputWidget} interface.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractOutputWidget<T> extends AbstractWidget<T> implements OutputWidget<T> {

    protected T value;

    /**
     * The {@link WidgetValueListener}s for this Widget.
     */
    protected List<WidgetValueListener<T>> valueListeners;

    private ValueConverterFactory converterFactory;

    private WidgetValueConverter<T, Object> converter;

    private WidgetValueListener<T> widgetValueListener;

    /**
     * Create an {@code AbstractOutputWidget} with the given {@code valueTypeClass}.
     * 
     * @param valueTypeClass
     */
    public AbstractOutputWidget(Class<T> valueTypeClass) {
        super(valueTypeClass);
        valueListeners = new ArrayList<WidgetValueListener<T>>(1);
    }
    
    @Override
    public void setValuedSemanticElement(ValuedSemanticElement valuedElement) {
        if (this.valuedElement != null) {
            this.valuedElement.removeValueListener(getWidgetValueListener());
        }
        if (valuedElement != null) {
            valuedElement.addValueListener(getWidgetValueListener());
        }
        if (this.valuedElement != null
                && valuedElement != null
                && (this.valuedElement.getElement() != valuedElement.getElement()
                        || this.valuedElement.getValue() != valuedElement.getValue() || this.valuedElement.getValue() != null
                        && !this.valuedElement.getValue().equals(valuedElement.getValue()))) {
            notifyValueChanged(convertToType(this.valuedElement.getValue()), convertToType(valuedElement.getValue()));
        }
        super.setValuedSemanticElement(valuedElement);
    }

    @Override
    public T getValue() {
    	if(valuedElement == null){
    		return null;
    	}
        return convertToType(valuedElement.getValue());
    }

    /**
     * Convert the value from the semantic element type to the Widget type.
     * 
     * @param valuedElementValue
     * @return the converted value of the Widget type.
     */
    @SuppressWarnings("unchecked")
    protected T convertToType(Object valuedElementValue) {
        WidgetValueConverter<T, Object> converter = getValueConverter();
        if (converter != null) {
            return converter.convertFromElement(valuedElementValue);
        }// else
        return (T) valuedElementValue;
    }

    /**
     * Return the converter for this Widget, {@code null} if no converter is set.
     * 
     * @return the converter for this Widget, {@code null} if no converter is set.
     */
    protected WidgetValueConverter<T, Object> getValueConverter() {
        if (converter == null) {
            ValueConverterConfiguration converterConfiguration = getConfig().getValueConverterConfiguration();
            if (converterConfiguration != null) {
                if (valuedElement != null && valuedElement.getValue() != null) {
                    converter = getConverterFactory().get(getType(), converterConfiguration);
                }
            }
        }
        return converter;
    }

    /**
     * Returns the {@link ValueConverterFactory}.
     * 
     * @return the {@link ValueConverterFactory}.
     */
    protected ValueConverterFactory getConverterFactory() {
        if (converterFactory == null) {
            converterFactory = Activator.getDefault().getInjector().getInstance(ValueConverterFactory.class);
        }
        return converterFactory;
    }

    protected WidgetValueListener<T> getWidgetValueListener() {
        if (widgetValueListener == null) {
            widgetValueListener = new AWidgetValueListener<T>() {
                
                @Override
                protected void _valueChanged(T ancientValue, T newValue) {
                    notifyValueChanged(ancientValue, newValue);
                };
            };
        }
        return widgetValueListener;
    }

    /**
     * Notifies the registered {@link WidgetValueListener}s the value of this widget changed.
     */
    protected void notifyValueChanged(T ancientValue, T newValue) {
        for (WidgetValueListener<T> listener : valueListeners) {
            listener.valueChanged(ancientValue, newValue);
        }
    }

    @Override
    public void addValueListener(WidgetValueListener<T> listener) {
        valueListeners.add(listener);
    }

    @Override
    public void removeValueListener(WidgetValueListener<T> listener) {
        valueListeners.remove(listener);
    }

    @Override
    public <V> V accept(WidgetVisitor<V> visitor) {
        V value = visitor.visit(this);
        if (value != null) {
            return value;
        }
        return super.accept(visitor);
    }
    
    @Override
    public void dispose() {
        if (!isDisposed && valuedElement != null) {
            valuedElement.removeValueListener(getWidgetValueListener());
        }
        super.dispose();
    }

    @Override
    public AbstractWidget<T> clone() throws CloneNotSupportedException {
        AbstractOutputWidget<T> clone = (AbstractOutputWidget<T>) super.clone();
        clone.value = value;
        return clone;
    }
}
