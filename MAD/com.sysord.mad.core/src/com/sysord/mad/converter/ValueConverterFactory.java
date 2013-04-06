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
package com.sysord.mad.converter;

import java.util.Date;

import com.sysord.mad.configuration.ValueConverterConfiguration;

/**
 * Factory creating converters for widget's values.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
@SuppressWarnings("unchecked")
public class ValueConverterFactory {

    /**
     * Return a {@link WidgetValueConverter} corresponding to the given
     * {@code widgetValueType} class and {@code ValueConverterConfiguration}.
     * 
     * @param widgetValueType Class of the Widget value.
     * @param config The converter parameters defined in the MAD dsl configuration.
     * @return a {@link WidgetValueConverter} corresponding to the given
     *         {@code widgetValueType} class and {@code ValueConverterConfiguration}.
     */
    public <V, E> WidgetValueConverter<V, E> get(Class<V> widgetValueType, ValueConverterConfiguration config) {
        if (widgetValueType == null || config == null) {
            return null;
        }// else

        switch (config.getCategory()) {
        case DATE_CONVERTER: /* Falls through */
        case DATETIME_CONVERTER:
            return (WidgetValueConverter<V, E>) caseDateConverter(widgetValueType, config);
        case DOUBLE_CONVERTER:
            return (WidgetValueConverter<V, E>) caseDoubleConverter(widgetValueType, config);
        case FLOAT_CONVERTER:
            return (WidgetValueConverter<V, E>) caseFloatConverter(widgetValueType, config);
        case INTEGER_CONVERTER:
            return (WidgetValueConverter<V, E>) caseIntegerConverter(widgetValueType, config);
        case XTEXT_CONVERTER:
            return (WidgetValueConverter<V, E>) caseXtextConverter(widgetValueType, config);
        }
        return null;
    }

    protected <V> WidgetValueConverter<V, Date> caseDateConverter(Class<V> widgetValueType,
            ValueConverterConfiguration config) {
        if (String.class.isAssignableFrom(widgetValueType)) {
            return (WidgetValueConverter<V, Date>) new StringDateConverter(config);
        }// else
        return null;
    }

    protected <V> WidgetValueConverter<V, Double> caseDoubleConverter(Class<V> widgetValueType,
            ValueConverterConfiguration config) {
        if (String.class.isAssignableFrom(widgetValueType)) {
            return (WidgetValueConverter<V, Double>) new DoubleConverter(config.getConfiguration());
        }// else
        return null;
    }

    protected <V> WidgetValueConverter<V, Float> caseFloatConverter(Class<V> widgetValueType,
            ValueConverterConfiguration config) {
        if (String.class.isAssignableFrom(widgetValueType)) {
            return (WidgetValueConverter<V, Float>) new FloatConverter(config.getConfiguration());
        }// else
        return null;
    }

    protected <V> WidgetValueConverter<V, Integer> caseIntegerConverter(Class<V> widgetValueType,
            ValueConverterConfiguration config) {
        if (String.class.isAssignableFrom(widgetValueType)) {
            return (WidgetValueConverter<V, Integer>) new IntegerConverter();
        }// else
        return null;
    }

    protected <V> WidgetValueConverter<V, String> caseXtextConverter(Class<V> widgetValueType,
            ValueConverterConfiguration config) {
        if (String.class.isAssignableFrom(widgetValueType)) {
            // TODO Create the Xtext Converter
        }// else
        return null;
    }

}
