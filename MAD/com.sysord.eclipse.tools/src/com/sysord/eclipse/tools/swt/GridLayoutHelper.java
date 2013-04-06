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
package com.sysord.eclipse.tools.swt;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.layout.GridLayout;

/**
 * Helper for creating defaults {@link GridLayout}s.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class GridLayoutHelper {

    private static GridLayout layout;
    private static GridLayout layoutEquals;
    private static GridLayout layoutWithNoMargin;
    private static GridLayout layoutEqualsWithNoMargin;
    private static GridLayout layoutNoMarginNoSpacing;
    private static GridLayout layoutNoSpacing;

    // Suppresses default constructor, ensuring non-instantiability.
    private GridLayoutHelper() {
    }

    /**
     * Create a {@link GridLayout} with the given number of columns and with columns of
     * non equal size.
     * 
     * @param numColumns
     * @return the created {@code GridLayout}.
     */
    public static GridLayout create(int numColumns) {
        return GridLayoutFactory.copyLayout(get(numColumns));
    }

    /**
     * Create a {@link GridLayout} with the given number of columns and with columns of
     * equal size.
     * 
     * @param numColumns
     * @return the created {@code GridLayout}.
     */
    public static GridLayout createEquals(int numColumns) {
        return GridLayoutFactory.copyLayout(getEquals(numColumns));
    }

    /**
     * Create a {@link GridLayout} with the given number of columns, with columns of non
     * equal size and with no margin.
     * 
     * @param numColumns
     * @return the created {@code GridLayout}.
     */
    public static GridLayout createWithNoMargin(int numColumns) {
        return GridLayoutFactory.copyLayout(getWithNoMargin(numColumns));
    }

    /**
     * Create a {@link GridLayout} with the given number of columns, with columns of equal
     * size and with no margin.
     * 
     * @param numColumns
     * @return the created {@code GridLayout}.
     */
    public static GridLayout createEqualsWithNoMargin(int numColumns) {
        return GridLayoutFactory.copyLayout(getEqualsWithNoMargin(numColumns));
    }

    /**
     * Create a {@link GridLayout} with the given number of columns, with columns of non
     * equal size and with no margin nor spacing.
     * 
     * @param numColumns
     * @return the created {@code GridLayout}.
     */
    public static GridLayout createNoSpacingNoMargin(int numColumns) {
        return GridLayoutFactory.copyLayout(getNoSpacingNoMargin(numColumns));
    }

    /**
     * Create a {@link GridLayout} with the given number of columns, with columns of non
     * equal size and with no spacing.
     * 
     * @param numColumns
     * @return the created {@code GridLayout}.
     */
    public static GridLayout createNoSpacing(int numColumns) {
        return GridLayoutFactory.copyLayout(getNoSpacing(numColumns));
    }

    private static GridLayout get(int numColumns) {
        if (layout == null) {
            layout = GridLayoutFactory.swtDefaults().create();
        }
        layout.numColumns = numColumns;
        return layout;
    }

    private static GridLayout getEquals(int numColumns) {
        if (layoutEquals == null) {
            layoutEquals = GridLayoutFactory.swtDefaults().equalWidth(true).create();
        }
        layoutEquals.numColumns = numColumns;
        return layoutEquals;
    }

    private static GridLayout getWithNoMargin(int numColumns) {
        if (layoutWithNoMargin == null) {
            layoutWithNoMargin = GridLayoutFactory.fillDefaults().create();
        }
        layoutWithNoMargin.numColumns = numColumns;
        return layoutWithNoMargin;
    }

    private static GridLayout getEqualsWithNoMargin(int numColumns) {
        if (layoutEqualsWithNoMargin == null) {
            layoutEqualsWithNoMargin = GridLayoutFactory.fillDefaults().equalWidth(true).create();
        }
        layoutEqualsWithNoMargin.numColumns = numColumns;
        return layoutEqualsWithNoMargin;
    }

    private static GridLayout getNoSpacingNoMargin(int numColumns) {
        if (layoutNoMarginNoSpacing == null) {
            layoutNoMarginNoSpacing = GridLayoutFactory.fillDefaults().spacing(0, 0).create();
        }
        layoutNoMarginNoSpacing.numColumns = numColumns;
        return layoutNoMarginNoSpacing;
    }

    private static GridLayout getNoSpacing(int numColumns) {
        if (layoutNoSpacing == null) {
            layoutNoSpacing = GridLayoutFactory.fillDefaults().margins(5, 5).spacing(0, 0).create();
        }
        layoutNoSpacing.numColumns = numColumns;
        return layoutNoSpacing;
    }
}
