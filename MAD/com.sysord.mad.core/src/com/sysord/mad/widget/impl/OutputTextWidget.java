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

import com.sysord.mad.widget.OutputWidget;

/**
 * Represents an {@link OutputWidget} for {@code String} values.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class OutputTextWidget extends AbstractOutputWidget<String> {

    /**
     * Create an {@code OutputTextWidget}.
     */
    public OutputTextWidget() {
        super(String.class);
    }

    @Override
    protected AbstractWidget<String> _clone() throws CloneNotSupportedException {
        return new OutputTextWidget();
    }

}
