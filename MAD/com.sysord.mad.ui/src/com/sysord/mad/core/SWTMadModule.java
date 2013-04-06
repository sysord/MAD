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
package com.sysord.mad.core;

import com.google.inject.Binder;
import com.sysord.mad.emitter.ViewBuilder;
import com.sysord.mad.emitter.impl.SWTViewBuilder;
import com.sysord.mad.widget.SWTWidgetBuilder;
import com.sysord.mad.widget.WidgetBuilder;

/**
 * Specific module for the MAD SWT view.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTMadModule extends MadDefaultModule {
    
    @Override
    protected void bindViewBuilder(Binder binder) {
        binder.bind(ViewBuilder.class).to(SWTViewBuilder.class).asEagerSingleton();
    }

    @Override
    protected void bindWidgetBuilder(Binder binder) {
        binder.bind(WidgetBuilder.class).to(SWTWidgetBuilder.class).asEagerSingleton();
    }
}
