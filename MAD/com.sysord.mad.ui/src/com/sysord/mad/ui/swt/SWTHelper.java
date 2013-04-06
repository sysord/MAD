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

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.eclipse.tools.swt.SWTUtil;

/**
 * Utility class for creating SWT Composites.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTHelper {

    // Suppressing default constructor, ensuring non-instantiability
    private SWTHelper() {
    }

    /**
     * Creates a {@link Section} with the given toolkit.
     * <p>
     * The section will have the specified title and the given image if not {@code null}.
     * 
     * @param toolkit The {@code FormToolkit} that will create the {@code Section}.
     * @param container The container of the {@code Section} to create
     * @param title The title of the {@code Section}.
     * @param image The {@code Image} to put before the title, or {@code null}.
     * @return the created {@code Section}.
     */
    public static Section createSection(FormToolkit toolkit, Composite container, String title, Image image) {
        // Creation of the section by the toolkit
        Section section = toolkit.createSection(container, Section.EXPANDED | Section.TITLE_BAR
                | Section.LEFT_TEXT_CLIENT_ALIGNMENT);
        section.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

        // Creation of a composite holding the image and the title
        Composite sectionDescription = new Composite(section, SWT.NONE);
        sectionDescription.setLayout(GridLayoutHelper.createWithNoMargin(2));

        // Set the image label if the image exists
        if (image != null) {
            Label sectionImage = new Label(sectionDescription, SWT.NONE);
            sectionImage.setImage(image);
        }
        // Set the title label
        Label sectionTitle = new Label(sectionDescription, SWT.NONE);
        sectionTitle.setText(title);
        sectionTitle.setForeground(section.getTitleBarForeground());
        sectionTitle.setFont(section.getFont());

        SWTUtil.incrementFontSize(sectionTitle, 4);

        // Define the section's text client with the composite
        section.setTextClient(sectionDescription);

        return section;
    }

    /**
     * Reduce the font size of the specified {@link Control}.
     * 
     * @param control
     * @param points Number of points to substract from the default font size of the
     *        control.
     * @deprecated Use
     *             {@link com.sysord.eclipse.tools.swt.SWTUtil#incrementFontSize(Control, int)}
     *             instead
     */
    @Deprecated
    public static void changeFontSize(Control control, int points) {
        com.sysord.eclipse.tools.swt.SWTUtil.incrementFontSize(control, points * -1);
    }

    /**
     * Create a new {@code SWT.CHECK} {@link Button}.
     * 
     * @param container The parent {@code Composite} of the {@code Button}.
     * @param label The label of the {@code Button}.
     * @param fontSizeReduction Font size reduction.
     * @return a new {@code SWT.CHECK} {@link Button}.
     */
    public static Button createCheckBox(Composite container, String label, int fontSizeReduction) {
        Button chk = new Button(container, SWT.CHECK);
        chk.setText(label);
        if (fontSizeReduction != 0) {
            changeFontSize(chk, fontSizeReduction);
        }
        return chk;
    }

    /**
     * Create a new {@link ComboViewer}.
     * 
     * @param combo The base {@link Combo} for the {@link ComboViewer} to create.
     * @param contentProvider
     * @param labelProvider
     * @param elementComparer
     * @param input
     * @return the created new {@link ComboViewer}.
     */
    public static ComboViewer createComboViewer(Combo combo, IContentProvider contentProvider,
            IBaseLabelProvider labelProvider, IElementComparer elementComparer, Object input) {
        ComboViewer comboViewer = new ComboViewer(combo);
        if (contentProvider != null) {
            comboViewer.setContentProvider(contentProvider);
        } else {
            comboViewer.setContentProvider(new ArrayContentProvider());
        }
        if (labelProvider != null) {
            comboViewer.setLabelProvider(labelProvider);
        }
        if (elementComparer != null) {
            comboViewer.setComparer(elementComparer);
        }
        if (input != null) {
            comboViewer.setInput(input);
        }
        return comboViewer;
    }

    /**
     * Create a new {@link ComboViewer} with an {@link ArrayContentProvider} as content
     * provider.
     * 
     * @param combo The base {@link Combo} for the {@link ComboViewer} to create.
     * @param labelProvider
     * @param elementComparer
     * @param input
     * @return the created new {@link ComboViewer}.
     */
    public static ComboViewer createComboViewer(Combo combo, IBaseLabelProvider labelProvider,
            IElementComparer elementComparer, Object input) {
        return createComboViewer(combo, null, labelProvider, elementComparer, input);
    }

    /**
     * Create a new {@link ComboViewer} with an {@link ArrayContentProvider} as content
     * provider and no {@link IElementComparer}.
     * 
     * @param combo The base {@link Combo} for the {@link ComboViewer} to create.
     * @param labelProvider
     * @param input
     * @return the created new {@link ComboViewer}.
     */
    public static ComboViewer createComboViewer(Combo combo, IBaseLabelProvider labelProvider, Object input) {
        return createComboViewer(combo, null, labelProvider, null, input);
    }

    /**
     * Execute the {@code Runnable} operation in an asynchronous behaviour.
     * (Convenient method using {@code Display.getDefault().asyncExec()})
     * 
     * @param operation
     */
    public static void execute(Runnable operation) {
        SWTUtil.getDisplay().asyncExec(operation);
    }

    /**
     * Create a new {@link ListViewer}.
     * 
     * @param list The base {@link List} for the {@link ListViewer} to create.
     * @param contentProvider
     * @param labelProvider
     * @param elementComparer
     * @param input
     * @return the created new {@link ListViewer}.
     */
    public static ListViewer createListViewer(List list, IContentProvider contentProvider,
            IBaseLabelProvider labelProvider, IElementComparer elementComparer, Object input) {
        ListViewer listViewer = new ListViewer(list);
        if (contentProvider != null) {
            listViewer.setContentProvider(contentProvider);
        } else {
            listViewer.setContentProvider(new ArrayContentProvider());
        }
        if (labelProvider != null) {
            listViewer.setLabelProvider(labelProvider);
        }
        if (elementComparer != null) {
            listViewer.setComparer(elementComparer);
        }
        if (input != null) {
            listViewer.setInput(input);
        }
        return listViewer;
    }

    /**
     * Create a new {@link ListViewer} with an {@link ArrayContentProvider} as content
     * provider.
     * 
     * @param list The base {@link List} for the {@link ListViewer} to create.
     * @param labelProvider
     * @param elementComparer
     * @param input
     * @return the created new {@link ListViewer}.
     */
    public static ListViewer createListViewer(List list, IBaseLabelProvider labelProvider,
            IElementComparer elementComparer, Object input) {
        return createListViewer(list, null, labelProvider, elementComparer, input);
    }

    /**
     * Create a new {@link ListViewer} with an {@link ArrayContentProvider} as content
     * provider and without {@link IElementComparer}.
     * 
     * @param list The base {@link List} for the {@link ListViewer} to create.
     * @param labelProvider
     * @param input
     * @return the created new {@link ListViewer}.
     */
    public static ListViewer createListViewer(List list, IBaseLabelProvider labelProvider, Object input) {
        return createListViewer(list, null, labelProvider, null, input);
    }
}
