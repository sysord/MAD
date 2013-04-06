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
 * Represents a converter between {@code Double} and {@code String}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class DoubleConverter implements WidgetValueConverter<String, Double> {

    protected String format;
    private DecimalFormat formatter;

    /**
     * Create a new {@code DoubleConverter} with a default format.
     */
    public DoubleConverter() {
    }

    /**
     * Create a new {@code DoubleConverter} with the given format.
     * 
     * @param format
     * @see DecimalFormat
     */
    public DoubleConverter(String format) {
        this.format = format;
    }

    @Override
    public Double convertFromWidgetValue(String value) {
        try {
            if (format == null || format.length() == 0) {
                return Double.parseDouble(value);
            } else {
                DecimalFormat decimalFormat = getFormatter();
                return (Double) decimalFormat.parse(value);
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
    public String convertFromElement(Double semanticElement) {
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
