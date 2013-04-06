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
package com.sysord.mad.configuration;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.emitter.WidgetFactory;
import com.sysord.mad.evaluator.FormatExpressionEvaluationService;
import com.sysord.mad.query.QueryDefinition;
import com.sysord.mad.widget.Widget;

/**
 * Configuration of a {@link Widget} as it is defined in a MAD configuration.
 * <p>
 * A {@code WidgetConfiguration} will be used by the {@link WidgetFactory} to create its
 * corresponding {@link Widget}.
 * 
 * @param <VT> Type of value.
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 */
public interface WidgetConfiguration<VT> {

	/**
	 * Default UI Tab ID provided when no tab is defined for the widget
	 */
	public static final String DEFAULT_UI_TAB_ID = "_MAIN";

	/**
	 * Default UI Tab Label provided when no tab is defined for the widget
	 */
	public static final String DEFAULT_UI_TAB_LABEL = "Main";

	/**
	 * Categories of widgets.
	 */
	public enum WIDGET_CATEGORY {
		TEXT_WIDGET,
		DATE_WIDGET,
		NUMBER_WIDGET,
		BOOLEAN_WIDGET,
		SINGLE_SELECT_WIDGET,
		MULTI_SELECT_WIDGET,
		XTEXT_ELEMENT_EDITOR_WIDGET,
		XTEXT_TEXT_EDITOR_WIDGET,

		NAVIGATION_WIDGET,
		FLEXIBLE_WIDGET,
		COMPOSED_WIDGET,

		OUTPUTTEXT_WIDGET
	}

	/**
	 * Returns the widget id.
	 * 
	 * @return the widget id.
	 */
	public String getId();

	/**
	 * Returns the widget name.
	 * 
	 * @return the widget name.
	 */
	public String getName();

	/**
	 * Returns the widget label.
	 * 
	 * @return the widget label.
	 */
	public String getLabel();

	/**
	 * Returns the widget UI tab ID.
	 * <p>
	 * If no UI tab was defined, {@value #DEFAULT_UI_TAB_ID} is returned.
	 * 
	 * @return the widget UI tab ID.
	 */
	public String getTabId();

	/**
	 * Returns the widget UI tab label.
	 * <p>
	 * If no UI tab was defined, {@value #DEFAULT_UI_TAB_LABEL} is returned.
	 * 
	 * @return the widget ui tab label
	 */
	public String getTabLabel();

	/**
	 * Returns the {@link Layer layers} for which the widget must be visible.
	 * 
	 * @return the {@link Layer layers} for which the widget must be visible.
	 */
	public List<Layer> getLayers();

	/**
	 * Returns the widget value type as a java {@link Class}.
	 * 
	 * @return the widget value type.
	 */
	public Class<VT> getWidgetValueType();

	/**
	 * Returns the candidates value type as a java {@link Class}.
	 * 
	 * @return the candidates value type.
	 */
	public Class<?> getCandidatesType();

	/**
	 * Returns the widget's {@link WIDGET_CATEGORY category}.
	 * 
	 * @return the widget's {@link WIDGET_CATEGORY category}.
	 */
	public WIDGET_CATEGORY getWidgCategory();

	/**
	 * Returns the widget concrete type ID.
	 * 
	 * @return the widget concrete type ID.
	 */
	public String getWidgetType();

	/**
	 * Returns the query used for the evaluation of the widget visibility.
	 * 
	 * @return the query used for the evaluation of the widget visibility.
	 */
	public QueryDefinition<Boolean> getVisibilityQuery();

	/**
	 * Returns the query used for the evaluation of the widget editability.
	 * 
	 * @return the query used for the evaluation of the widget editability.
	 */
	public QueryDefinition<Boolean> getEditableQuery();

	/**
	 * Returns the query used for getting the element value.
	 * 
	 * @return the query used for getting the element value.
	 */
	public QueryDefinition<?> getValueQuery();

	/**
	 * Returns the {@link ValidatorDefinition validators} defined on the widget.
	 * 
	 * @return the {@link ValidatorDefinition validators} defined on the widget.
	 */
	public List<ValidatorDefinition> getValidators();

	/**
	 * Returns the value converter {@link ValueConverterConfiguration configuration}, or
	 * {@code null} if not defined.
	 * 
	 * @return the value converter {@link ValueConverterConfiguration configuration}, or
	 *         {@code null}
	 */
	public ValueConverterConfiguration getValueConverterConfiguration();

	/**
	 * Returns the format expression to apply on the value of an output widget.
	 * <p>
	 * A format expression is a string expression usable for any label in the MAD
	 * configuration (see {@link FormatExpressionEvaluationService} for more details).
	 * 
	 * @return the format expression to apply on the value of an output widget.
	 */
	public String getFormat();

	/**
	 * Returns the query used for selecting candidate elements.
	 * <p>
	 * Used for :
	 * <ul>
	 * <li>{@link WIDGET_CATEGORY#SINGLE_SELECT_WIDGET SINGLE_SELECT_WIDGET}</li>
	 * <li>{@link WIDGET_CATEGORY#MULTI_SELECT_WIDGET MULTI_SELECT_WIDGET}</li>
	 * <li>{@link WIDGET_CATEGORY#NAVIGATION_WIDGET NAVIGATION_WIDGET}</li>
	 * </ul>
	 * 
	 * @return the query used for selecting candidate elements.
	 */
	public QueryDefinition<Collection<?>> getCandidatesQuery();

	/**
	 * Returns the format expression used for generating elements's labels.
	 * <p>
	 * Used for :
	 * <ul>
	 * <li>{@link WIDGET_CATEGORY#SINGLE_SELECT_WIDGET SINGLE_SELECT_WIDGET}</li>
	 * <li>{@link WIDGET_CATEGORY#MULTI_SELECT_WIDGET MULTI_SELECT_WIDGET}</li>
	 * <li>{@link WIDGET_CATEGORY#NAVIGATION_WIDGET NAVIGATION_WIDGET}</li>
	 * </ul>
	 * <p>
	 * A format expression is a string expression usable for any label in the MAD
	 * configuration (see {@link FormatExpressionEvaluationService} for more details).
	 * 
	 * @return the format expression used for generate elements label
	 */
	public String getItemLabelExpression();

	/**
	 * Indicates if the widget is a {@link WIDGET_CATEGORY#FLEXIBLE_WIDGET
	 * FLEXIBLE_WIDGET}.
	 * <p>
	 * It means, the configuration will be replicated for 1 to N elements of the same type
	 * (=> with an identical {@link WidgetConfiguration configuration}).
	 * 
	 * @return {@code true} if the widget is a {@link WIDGET_CATEGORY#FLEXIBLE_WIDGET
	 *         FLEXIBLE_WIDGET};<br>
	 *         {@code false} otherwise.
	 */
	boolean isFlexibleWidget();

	/**
	 * Returns the {@link TypeConfiguration} to replicate by the flexible widget.
	 * 
	 * @return the {@link TypeConfiguration} to replicate by the flexible widget.
	 */
	public TypeConfiguration getFlexibleTemplate();

	/**
	 * Returns all the defined {@link CommandDefinition commands} of the widget.
	 * 
	 * @return all the defined {@link CommandDefinition commands} of the widget.
	 */
	public Collection<CommandDefinition> getWidgetCommands();

	/**
	 * Returns the {@link CommandDefinition command} with the given {@code commandId} used
	 * on the widget.
	 * 
	 * @param commandId The ID of the {@link CommandDefinition command} to retrieve on the
	 *        widget.
	 * @return the {@link CommandDefinition command} with the given {@code commandId} used
	 *         on the widget.
	 */
	public CommandDefinition getWidgetCommand(String commandId);

	/**
	 * Returns the {@link XtextLanguageDescriptor} if the widget uses an Xtext editor.
	 * 
	 * @return the {@link XtextLanguageDescriptor}.
	 */
	public XtextLanguageDescription getXtextWidgetLanguageDescriptor();
	
	/**
	 * Returns true if the widget has been included.
	 * 
	 * @return true if the widget has been included.
	 */
	public boolean isIncludedWidget();
	
	/**
	 * Returns the include query for an included widget 
	 * if widget is not an included widget then return  {@code null}.
	 * 
	 * @return the include query for the widget or  {@code null}
	 */
	public QueryDefinition<EObject> getIncludeQuery();

}
