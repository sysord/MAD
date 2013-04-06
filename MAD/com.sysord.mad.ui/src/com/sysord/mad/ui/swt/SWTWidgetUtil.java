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
package com.sysord.mad.ui.swt;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.sysord.eclipse.tools.swt.SWTUtil;
import com.sysord.emf.tools.misc.ActivatableAdapter;
import com.sysord.mad.widget.*;

/**
 * Utility class for SWT Widget used in MAD.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTWidgetUtil {

    // Suppresses default constructor, ensuring non-instantiability.
    private SWTWidgetUtil() {
    }

    public static void addNewEditableStateListener(InputWidget<?> widget, final Control control) {
        widget.addEditableStateListener(new AWidgetEditableStateListener() {

            @Override
            protected void _editableStateChanged(boolean newEditableState) {
                control.setEnabled(newEditableState);
            }
        });
    }

    public static void addVisibilityListener(Widget<?> widget, final Control control) {
        widget.addVisibilityListener(new WidgetVisibilityListener() {

            @Override
            public void visibilityChanged(boolean visibility) {
                if (!control.isDisposed()) {
                    control.setVisible(visibility);
                }
            }
        });
    }
    
    public static void addControlDisposedListener(final Control control, final Widget<?> widget) {
        final WidgetDisposeListener disposeListener = new WidgetDisposeListener() {
            
            @Override
            public <T> void widgetDispose(Widget<T> widget) {
                if (!control.isDisposed()) {
                    Display display = SWTUtil.getDisplay(control);
                    display.asyncExec(new Runnable() {
                        
                        @Override
                        public void run() {
                            control.dispose();
                        }
                    });
                }
            }
        };
        widget.addDisposeListener(disposeListener);
        control.addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
                widget.removeDisposeListener(disposeListener);
                widget.dispose();
            }
        });
    }

    public static void deactivateAdapters(ActivatableAdapter... adapters) {
        for (int i = 0; i < adapters.length; i++) {
            adapters[i].setActive(false);
        }
    }

    public static void activateAdapters(ActivatableAdapter... adapters) {
        for (int i = 0; i < adapters.length; i++) {
            adapters[i].setActive(true);
        }
    }
}
