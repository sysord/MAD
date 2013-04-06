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

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.sysord.mad.configuration.ValueConverterConfiguration;

/**
 * Converter for {@link Date} elements.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class StringDateConverter implements WidgetValueConverter<String, Date> {

    protected final ValueConverterConfiguration configuration;
    
    protected DateFormat dateFormat;

    /**
     * Create a new {@code DateConverter} with the given configuration.
     */
    public StringDateConverter(ValueConverterConfiguration configuration) {
        this.configuration = configuration;
        init();
    }
    
    private void init() {
        switch (configuration.getCategory()) {
        case DATE_CONVERTER:
            dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
            break;
        case DATETIME_CONVERTER:
            dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            break;
        default:
            throw new RuntimeException("The configuration category is incorrect for this DateConverter.");
        }
    }

    @Override
    public Date convertFromWidgetValue(String value) {
        if (value == null || value.length() == 0) {
            return null;
        }// else
        
        try {
            return dateFormat.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String convertFromElement(Date semanticElement) {
        if (semanticElement == null) {
            return "";
        }// else
        
        return dateFormat.format(semanticElement);
    }
}
