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

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Represents a converter between {@code Float} and {@code String}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class FloatConverter implements WidgetValueConverter<String, Float> {

    protected String format;
    private DecimalFormat formatter;

    /**
     * Create a new {@code FloatConverter} with a default format.
     */
    public FloatConverter() {
    }

    /**
     * Create a new {@code FloatConverter} with the given format.
     * 
     * @param format
     * @see DecimalFormat
     */
    public FloatConverter(String format) {
        this.format = format;
    }

    @Override
    public Float convertFromWidgetValue(String value) {
        try {
            if (format == null || format.length() == 0) {
                return Float.parseFloat(value);
            } else {
                DecimalFormat decimalFormat = getFormatter();
                return (Float) decimalFormat.parse(value);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String convertFromElement(Float semanticElement) {
        if (format == null || format.length() == 0) {
            return String.valueOf(semanticElement);
        }// else
        return getFormatter().format(semanticElement);
    }

    private DecimalFormat getFormatter() {
        if (formatter == null) {
            try {
                formatter = new DecimalFormat(format);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return formatter;
    }

}
