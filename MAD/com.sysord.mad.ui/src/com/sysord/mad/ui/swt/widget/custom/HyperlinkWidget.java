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
package com.sysord.mad.ui.swt.widget.custom;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.eclipse.tools.swt.*;
import com.sysord.mad.core.Activator;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.widget.AbstractSWTWidget;
import com.sysord.mad.widget.OutputWidget;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;

/**
 * Represents a MAD {@link OutputWidget} with an {@link Hyperlink}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class HyperlinkWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof OutputWidget) || widget.getType() != String.class) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Hyper Link",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }

    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite container = getSwtContext().getWidgetContainer();
        OutputWidget<String> widget= castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        createLabelColumn(toolkit, container, widget);

        GridDataFactory dataFactory = GridDataFactory.createFrom(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

        Composite linkContainer = toolkit.createComposite(container);
        linkContainer.setLayout(GridLayoutHelper.create(1));
        linkContainer.setLayoutData(dataFactory.create());

        Hyperlink hyperlink = new Hyperlink(linkContainer, SWT.WRAP);
        hyperlink.setHref(widget.getValue());
        hyperlink.setText(widget.getValue());
        hyperlink.setUnderlined(true);

        toolkit.adapt(hyperlink, false, false);
        hyperlink.setForeground(ColorRegistry.get(0, 0, 255));

        // Add the commands buttons for the hyperlink.
        addCommandsButtons(container, toolkit, widget, linkContainer);
        // Add the listeners to the widget
        addHyperlinkListeners(widget, hyperlink);

        return hyperlink;
    }

    /**
     * Adds the needed listeners to the hyperlink.
     * 
     * @param widget
     * @param hyperlink
     */
    protected void addHyperlinkListeners(OutputWidget<String> widget, final Hyperlink hyperlink) {
        // Add a listener on the MAD output widget
        AWidgetValueListener<String> valueListener = new AWidgetValueListener<String>() {

            @Override
            protected void _valueChanged(String ancientValue, String newValue) {
                if (newValue != null && !hyperlink.isDisposed()) {
                    hyperlink.setHref(newValue);
                    hyperlink.setText(newValue);
                }
            }
        };
        widget.addValueListener(valueListener);

        hyperlink.addHyperlinkListener(new IHyperlinkListener() {

            @Override
            public void linkExited(HyperlinkEvent e) {
            }

            @Override
            public void linkEntered(HyperlinkEvent e) {
            }

            @Override
            public void linkActivated(HyperlinkEvent e) {
                if (!hyperlink.isDisposed()) {
                    try {
                        URL url = new URL(e.getHref().toString());
                        SWTUtil.openBrowser(url, hyperlink.getDisplay(), false);
                    } catch (MalformedURLException e1) {
                        ConsoleLogger logger = Activator.getDefault().getInjector().getInstance(ConsoleLogger.class);
                        logger.logError(e1.getMessage());
                    }
                }
            }
        });

        hyperlink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseUp(MouseEvent e) {
                if (e.button == 2) {
                    try {
                        URL url = new URL(hyperlink.getHref().toString());
                        SWTUtil.openBrowser(url, hyperlink.getDisplay(), true);
                    } catch (MalformedURLException e1) {
                        ConsoleLogger logger = Activator.getDefault().getInjector().getInstance(ConsoleLogger.class);
                        logger.logError(e1.getMessage());
                    }
                }
            }
        });
    }

}
