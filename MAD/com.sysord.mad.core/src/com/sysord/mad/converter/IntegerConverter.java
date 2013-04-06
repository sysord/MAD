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

/**
 * Represents a converter between {@code Integer} and {@code String}.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class IntegerConverter implements WidgetValueConverter<String, Integer> {

    @Override
    public Integer convertFromWidgetValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String convertFromElement(Integer semanticElement) {
        return String.valueOf(semanticElement);
    }

}
