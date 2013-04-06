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

import com.sysord.mad.converter.WidgetValueConverter;
import com.sysord.mad.mao.MaoException;
import com.sysord.mad.mao.ModelAccessObject;
import com.sysord.mad.widget.Candidate;
import com.sysord.mad.widget.InputWidget;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.WidgetEditableStateListener;
import com.sysord.mad.widget.WidgetVisitor;

/**
 * Implementation of the default behavior of an InputWidget.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractInputWidget<T> extends AbstractOutputWidget<T> implements InputWidget<T> {

    protected boolean editable = true;

    /**
     * The {@link WidgetEditableStateListener}s for this Widget.
     */
    protected List<WidgetEditableStateListener> editableListeners;

    /**
     * Create an {@code AbstractInputWidget} with the given {@code valueTypeClass}.
     * 
     * @param valueTypeClass
     */
    public AbstractInputWidget(Class<T> valueTypeClass) {
        super(valueTypeClass);
        editableListeners = new ArrayList<WidgetEditableStateListener>(1);
    }

    @Override
    public boolean isEditable() {
        return editable;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setValue(T value) {
        if (value != null && Candidate.class.isAssignableFrom(value.getClass())) {
            value = (T) ((Candidate) value).getValue();
        }
                
        T ancientValue = getValue();
        getWidgetValueListener().setActive(false);
        valuedElement.setValue(convertFromType(value));
        getWidgetValueListener().setActive(true);
        try {
            save();
            notifyValueChanged(ancientValue, value);
            notifyViewChanged();
        } catch (MaoException e) {
            valuedElement.setValue(convertFromType(ancientValue));
            e.printStackTrace();
        }
    }

    /**
     * Call the {@link ModelAccessObject} which will save this {@link Widget}.
     * <p>
     * This method is called when the value is changed.
     * 
     * @throws MaoException
     */
    protected void save() throws MaoException {
        synchronized (getMao()) {
            getMao().persistWidgetValue(this);
        }
    }

    /**
     * Convert the value from the Widget type to the semantic element type.
     * 
     * @param value
     * @return the converted value of the semantic element type.
     */
    protected Object convertFromType(T value) {
        WidgetValueConverter<T, Object> converter = getValueConverter();
        if (converter != null) {
            return converter.convertFromWidgetValue(value);
        }// else
        return value;
    }

    @Override
    public void setEditable(boolean editable) {
        this.editable = editable;
        notifyEditableChanged();
    }

    /**
     * Notify the registered listeners the value of the editable state changed.
     */
    private void notifyEditableChanged() {
        for (WidgetEditableStateListener listener : editableListeners) {
            listener.editableStateChanged(editable);
        }
    }

    @Override
    public void addEditableStateListener(WidgetEditableStateListener listener) {
        editableListeners.add(listener);
    }

    @Override
    public void removeEditableStateListener(WidgetEditableStateListener listener) {
        editableListeners.remove(listener);
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
        super.dispose();
    }

    @Override
    public AbstractWidget<T> clone() throws CloneNotSupportedException {
        AbstractInputWidget<T> clone = (AbstractInputWidget<T>) super.clone();
        clone.editable = editable;
        return clone;
    }

}
