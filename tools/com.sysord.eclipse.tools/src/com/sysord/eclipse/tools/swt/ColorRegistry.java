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
import org.eclipse.swt.graphics.RGB;
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
		final RGB rgb = createRGB(code);
		return registry.getColor(rgb.red, rgb.green, rgb.blue);
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

	/**
	 * Darken the color corresponding to the given 3 color's components by adding the
	 * specified {@code darkenPoints} to each component.
	 * <p>
	 * The number of {@code darkenPoints} is adapted to avoid a component lower than 0.
	 * So, <code>darken(0,&nbsp;0,&nbsp;0,&nbsp;<em>anyPositiveNumber</em>)</code> will do
	 * nothing.
	 * 
	 * @param red Amount of red.
	 * @param green Amount of green.
	 * @param blue Amount of blue.
	 * @param darkenPoints The number of points to take off from the color components.
	 * @return the color code of the darken color.
	 * @since 1.1
	 */
	public static int darkenCode(int red, int green, int blue, int darkenPoints) {
		darkenPoints = checkDarkenPoints(red, darkenPoints);
		darkenPoints = checkDarkenPoints(green, darkenPoints);
		darkenPoints = checkDarkenPoints(blue, darkenPoints);
		return getCode(red - darkenPoints, green - darkenPoints, blue - darkenPoints);
	}

	/**
	 * Darken the given color by adding the specified {@code darkenPoints} to each of its
	 * components.
	 * 
	 * @param color The color to darken.
	 * @param darkenPoints The number of points to take off from the color components.
	 * @return The darkened color.
	 * @since 1.1
	 */
	public static Color darken(Color color, int darkenPoints) {
		return get(darkenCode(color.getRed(), color.getGreen(), color.getBlue(), darkenPoints));
	}

	/**
	 * Darken the color corresponding to the given code by adding the specified
	 * {@code darkenPoints} to each of its components.
	 * 
	 * @param code The code of the color to darken.
	 * @param darkenPoints The number of points to take off from the color components.
	 * @return The darkened color.
	 * @since 1.1
	 */
	public static Color darken(int code, int darkenPoints) {
		final RGB rgb = createRGB(code);
		return get(darkenCode(rgb.red, rgb.green, rgb.blue, darkenPoints));
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

	private static RGB createRGB(int code) {
		return new RGB((code & 0xFF0000) >> 16, (code & 0x00FF00) >> 8, code & 0x0000FF);
	}
	
	private static int checkDarkenPoints(int colorComponentValue, int darkenPoints) {
		if (colorComponentValue - darkenPoints < 0) {
			darkenPoints = darkenPoints + (colorComponentValue - darkenPoints);
		} else if (colorComponentValue - darkenPoints > 255) {
			darkenPoints = darkenPoints + (colorComponentValue - darkenPoints - 255);
		}
		return darkenPoints;
	}

	private Color getColor(int red, int green, int blue) {
		int code = getCode(red, green, blue);
		Color color = colors.get(code);
		if (color == null || color.isDisposed()) {
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
