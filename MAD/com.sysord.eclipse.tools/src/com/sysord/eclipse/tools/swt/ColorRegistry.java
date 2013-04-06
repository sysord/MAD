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

import java.util.*;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;

/**
 * Registry of {@link Color}s.
 * <p>
 * The {@code Color}s are managed by an instance of {@link ColorRegistry} per
 * {@link Display}. That is, when a {@code Display} is disposed, all of its associated
 * colors are disposed too.
 * <p>
 * The colors <strong>should not be disposed</strong> externaly.
 * <p>
 * This class provides two getters for colors :
 * <ul>
 * <li>{@link #get(int, int, int)} : <br>
 * This method takes the 3 arguments representing the three color's components,
 * <strong>red, green, blue</strong>, and returns the corresponding {@code Color}.</li>
 * <li>{@link #get(int)} : <br>
 * This method takes as argument a <em>code</em> representing the 3 color's components on
 * 24 bits.<br>
 * That is, 0xFF0000 (red), 0x00FF00 (green), 0x0000FF (blue).<br>
 * You can create a <em>code</em> with {@link #getCode(int, int, int)} which takes the 3
 * color's components as arguments.</li>
 * </ul>
 * These two methods <strong>must be called in an SWT User Interface thread</strong>.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class ColorRegistry {

    private static Map<Display, ColorRegistry> colorRegistries = Collections
            .synchronizedMap(new HashMap<Display, ColorRegistry>(2));
    private Map<Integer, Color> colors;
    private Display display;

    /**
     * Creates a {@code ColorRegistry} for the given {@link Display}.
     * 
     * @param display
     */
    private ColorRegistry(Display display) {
        this.display = display;
        colors = Collections.synchronizedMap(new TreeMap<Integer, Color>());
        hookDisposeListener();
    }

    /**
     * Returns the {@link Color} corresponding to the given 3 color's component's.
     * 
     * @param red Amount of red in the color.
     * @param green Amount of green in the color.
     * @param blue Amount of blue in the color.
     * @return the {@link Color} corresponding to the given 3 color's component's.
     * @see Color#Color(org.eclipse.swt.graphics.Device, int, int, int)
     */
    public static Color get(int red, int green, int blue) {
        ColorRegistry registry = getRegitry();
        return registry.getColor(red, green, blue);
    }

    /**
     * Returns the {@link Color} corresponding to the given {@code code}.
     * <p>
     * The {@code code} is composed of the 3 color's components (red, green, blue) on 24
     * bits.
     * 
     * @param code The code of the color to create.
     * @return the {@link Color} corresponding to the given {@code code}.
     * @see #getCode(int, int, int)
     */
    public static Color get(int code) {
        ColorRegistry registry = getRegitry();
        int red = (code & 0xFF0000) >> 16;
        int green = (code & 0x00FF00) >> 8;
        int blue = code & 0x0000FF;
        return registry.getColor(red, green, blue);
    }

    /**
     * Creates and return the code corresponding to the given 3 color's components.
     * 
     * @param red Amount of red.
     * @param green Amount of green.
     * @param blue Amount of blue.
     * @return the corresponding color code.
     */
    public static int getCode(int red, int green, int blue) {
        return red << 16 | green << 8 | blue;
    }

    private static ColorRegistry getRegitry() {
        ColorRegistry registry = colorRegistries.get(getDisplay());
        if (registry == null) {
            registry = new ColorRegistry(getDisplay());
            colorRegistries.put(getDisplay(), registry);
        }
        return registry;
    }

    private static Display getDisplay() {
        Display display = Display.getCurrent();
        Assert.isNotNull(display, ColorRegistry.class.getName() + " was called outside SWT thread.");
        return display;
    }

    private Color getColor(int red, int green, int blue) {
        int code = getCode(red, green, blue);
        Color color = colors.get(code);
        if (color == null) {
            color = createColor(red, green, blue);
        }
        return color;
    }

    private Color createColor(int red, int green, int blue) {
        Color color = new Color(display, red, green, blue);
        colors.put(getCode(red, green, blue), color);
        return color;
    }

    private void hookDisposeListener() {
        display.addListener(SWT.Dispose, new Listener() {

            @Override
            public void handleEvent(Event event) {
                synchronized (colors) {
                    for (Color color : colors.values()) {
                        color.dispose();
                    }
                    colors.clear();
                }
                colorRegistries.remove(display);
                display = null;
            }
        });
    }
}
