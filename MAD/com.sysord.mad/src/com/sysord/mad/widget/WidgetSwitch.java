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
package com.sysord.mad.widget;

import com.sysord.mad.configuration.WidgetConfiguration;
import com.sysord.mad.configuration.WidgetConfiguration.WIDGET_CATEGORY;

/**
 * Switch over the widget {@link WIDGET_CATEGORY category} of the given
 * {@link WidgetConfiguration configuration}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see WidgetConfiguration
 * @see Widget
 */
public class WidgetSwitch<T> {

	/**
	 * Current widget {@link WidgetConfiguration configuration}.
	 */
	protected WidgetConfiguration<?> widgetConfig;

	/**
	 * Calls <em>caseXXX</em> for the corresponding widget {@link WIDGET_CATEGORY
	 * category}; or {@link #defaultCase()} otherwise.
	 * 
	 * @param widgetConfig The widget configuration over which the switch will be done.
	 * @return the result of <em>caseXXX</em> for the corresponding widget
	 *         {@link WIDGET_CATEGORY category}.
	 */
	public final T doSwitch(WidgetConfiguration<?> widgetConfig) {
		this.widgetConfig = widgetConfig;
		if (widgetConfig.isFlexibleWidget()) {
			return caseFlexibleWidget();
		}// else

		T result = null;
		switch (widgetConfig.getWidgCategory()) {
		case BOOLEAN_WIDGET:
			result = caseCheckbox();
			break;
		case OUTPUTTEXT_WIDGET:
			result = caseOutputText();
			break;
		case TEXT_WIDGET:
			result = caseTextbox();
			break;
		case NUMBER_WIDGET:
			result = caseNumber();
			break;
		case DATE_WIDGET:
			result = caseDate();
			break;
		case SINGLE_SELECT_WIDGET:
			result = caseCombo();
			break;
		case MULTI_SELECT_WIDGET:
			result = caseMultiList();
			break;
		case XTEXT_TEXT_EDITOR_WIDGET:
			result = caseTextDsl();
			break;
		case XTEXT_ELEMENT_EDITOR_WIDGET:
			result = caseElementDsl();
			break;
		case NAVIGATION_WIDGET:
			result = caseNavigationList();
			break;
		default:
			result = defaultCase();
			break;
		}
		return result;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#FLEXIBLE_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseFlexibleWidget() {
		return null;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#BOOLEAN_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseCheckbox() {
		return null;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#OUTPUTTEXT_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseOutputText() {
		return null;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#TEXT_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseTextbox() {
		return null;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#NUMBER_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseNumber() {
		return null;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#DATE_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseDate() {
		return null;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#SINGLE_SELECT_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseCombo() {
		return null;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#MULTI_SELECT_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseMultiList() {
		return null;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#XTEXT_TEXT_EDITOR_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseTextDsl() {
		return null;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#XTEXT_ELEMENT_EDITOR_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseElementDsl() {
		return null;
	}

	/**
	 * Case for category {@link WIDGET_CATEGORY#NAVIGATION_WIDGET}.
	 * <p>
	 * Returns {@code null} by default, this method should be overriden in subclasses.
	 * 
	 * @return {@code null}.
	 */
	protected T caseNavigationList() {
		return null;
	}

	/**
	 * Called if no category corresponds.
	 * <p>
	 * This method throws an {@link IllegalArgumentException} by default.
	 * 
	 * @return Nothing.
	 * @throws IllegalArgumentException this case should not happen.
	 */
	protected T defaultCase() {
		throw new IllegalArgumentException("The category of the widget in the WidgetConfiguration"
				+ widgetConfig.getId() + " is not correct.");
	}

}
