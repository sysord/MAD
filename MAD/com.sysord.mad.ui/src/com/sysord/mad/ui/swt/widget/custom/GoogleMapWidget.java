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

import static com.sysord.mad.emitter.impl.SWTViewBuilder.GRID_COLUMNS;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.widget.AbstractSWTWidget;
import com.sysord.mad.widget.OutputWidget;
import com.sysord.mad.widget.Widget;

/**
 * Creates a composite containing a web browser for google Map.
 * <p>
 * This widget is intented to be use with a String {@link OutputWidget} where the value is
 * a String representing the latitude and longitude of the initial position on the Map and
 * a zoom value (or none).
 * </p>
 * 
 * <pre>
 * example of value : "43.975275::2.992272::14"
 * </pre>
 * 
 * Where {@code 43.975275} is the latitude, {@code 2.992272} is the longitude and
 * {@code 14} the zoom.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class GoogleMapWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof OutputWidget) || widget.getType() != String.class) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Google Map",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }

    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite parent = getSwtContext().getWidgetContainer();
        OutputWidget<String> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        Composite container = toolkit.createComposite(parent);
        container.setLayout(GridLayoutHelper.createWithNoMargin(1));

        Browser browser = createBrowser(container);
        if (browser == null)
            return null; // No browser
        GridData data = new GridData(SWT.CENTER, SWT.BEGINNING, true, true, 0, 0);
        data.minimumHeight = 300;
        data.minimumWidth = 300;
        browser.setLayoutData(data);

        String value = widget.getValue();
        String[] coordinates = value.split("::"); //$NON-NLS-1$
        String latitude = "0.0"; //$NON-NLS-1$
        String longitude = "0.0"; //$NON-NLS-1$
        String zoom = "13"; //$NON-NLS-1$
        if (coordinates.length >= 2) {
            latitude = coordinates[0];
            longitude = coordinates[1];
            if (coordinates.length > 2) {
                zoom = coordinates[2];
            }
        }

        browser.setText(genGoogleContent(latitude, longitude, zoom));

        addCommandsButtons(parent, toolkit, widget, container);
        data = GridDataFactory.fillDefaults().grab(true, true).span(GRID_COLUMNS - 1, 1).create();
        if (container.getLayoutData() != null) {
            data.horizontalSpan = GRID_COLUMNS;
        }
        container.setLayoutData(data);

        // TODO Modifier la creation des boutons
        // Afficher les boutons en colonne à droite de la MAP
        // Créer un layout avec 2 colonnes de largeur égale
        // en mettant la map alignée a droite et les boutons alignés à gauche
        // cela devrait centrer la map et les widgets...

        return container;
    }

    private Browser createBrowser(Composite container) {
        Browser browser = null;
        try {
            browser = new Browser(container, SWT.WEBKIT | SWT.BORDER);
        } catch (SWTError e) {
            try {
                browser = new Browser(container, SWT.MOZILLA | SWT.BORDER);
            } catch (SWTError e1) {
                try {
                    browser = new Browser(container, SWT.BORDER);
                } catch (SWTError e2) {
                    getLogger().logError(Lbl.browserError, ConsoleLogger.VERY_HIGH);
                }
            }
        }
        return browser;
    }

    public static String genGoogleContent(String latitude, String longitude, String zoom) {
        return "<html><head></head><body><iframe width=\"280\" height=\"280\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" src=\"https://maps.google.fr/?ie=UTF8&amp;ll=" //$NON-NLS-1$
                + latitude + "," //$NON-NLS-1$
                + longitude + "&amp;spn=6.729959,16.907959&amp;t=h&amp;z=" //$NON-NLS-1$
                + zoom + "&amp;output=embed\"></iframe><br /></body></html>"; //$NON-NLS-1$
    }

}
