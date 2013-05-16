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
package com.sysord.mad.ui.swt.widget;

import static com.sysord.mad.emitter.impl.SWTViewBuilder.GRID_COLUMNS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.diagnostic.Diagnostic;
import com.sysord.eclipse.tools.swt.ColorRegistry;
import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.eclipse.tools.swt.SWTUtil;
import com.sysord.mad.configuration.CommandDefinition;
import com.sysord.mad.configuration.CommandDefinition.COMMAND_CATEGORY;
import com.sysord.mad.mao.MaoException;
import com.sysord.mad.mao.ModelAccessObject;
import com.sysord.mad.query.impl.MADQueryUtil;
import com.sysord.mad.ui.MadUiPlugin;
import com.sysord.mad.ui.swt.SWTHelper;
import com.sysord.mad.ui.swt.SWTSpecificWidgetContext;
import com.sysord.mad.ui.swt.SWTWidgetUtil;
import com.sysord.mad.widget.AbstractSpecificWidget;
import com.sysord.mad.widget.ComposedWidget;
import com.sysord.mad.widget.FlexibleWidget;
import com.sysord.mad.widget.SpecificContextHolder;
import com.sysord.mad.widget.Widget;

/**
 * XXX Comment role class
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractSWTWidget extends AbstractSpecificWidget {

	protected static final int NAVIGATION_COLOR = ColorRegistry.getCode(201, 240, 255);

	protected static final int GRAY = ColorRegistry.getCode(240, 240, 240);

	protected static final int PALE_RED = ColorRegistry.getCode(255, 240, 240);

	protected static final int WHITE = ColorRegistry.getCode(255, 255, 255);

	protected SpecificContextHolder specificContextHolder;

	protected SWTSpecificWidgetContext getSwtContext() {
		return (SWTSpecificWidgetContext) specificContextHolder.getSpecificWidgetContext();
	}

	@Override
	public Object createWidget(SpecificContextHolder specificContextHolder, Widget<?> madWidget) {
		if (!(specificContextHolder.getSpecificWidgetContext() instanceof SWTSpecificWidgetContext)) {
			throw new IllegalArgumentException("Specific context is not of type SWTSpecificContext");
		}// else
		this.specificContextHolder = specificContextHolder;
		checkMadWidget(madWidget);

		beforeDiagnosticLabel(madWidget);
		Label lbl_diagnostic = addDiagnosticContent(getSwtContext(), madWidget);
		Control swtWidget = createSpecificWidget(madWidget);
		if (swtWidget != null) {
			addVisibilityListener(madWidget, swtWidget);
			addControlDisposedListener(madWidget, swtWidget);
			addDisposeListenerForDiagnostic(swtWidget, lbl_diagnostic);
		}
		return swtWidget;
	}

	/**
	 * XXX Comment method
	 * 
	 * @param swtSpecificWidgetContext
	 * @param madWidget
	 * @return
	 */
	protected static Label addDiagnosticContent(SWTSpecificWidgetContext swtSpecificWidgetContext, Widget<?> madWidget) {
		FormToolkit toolkit = swtSpecificWidgetContext.getToolkit();
		Composite widgetContainer = swtSpecificWidgetContext.getWidgetContainer();

		Label lbl_diagnostic = toolkit.createLabel(widgetContainer, null, SWT.NONE);
		if (madWidget.getStatus() != null) {
			Diagnostic status = madWidget.getStatus();
			String imgIdentifier;
			switch (status.getLevel()) {
			case ERROR:
				imgIdentifier = ISharedImages.IMG_OBJS_ERROR_TSK;
				break;
			case WARNING:
				imgIdentifier = ISharedImages.IMG_OBJS_WARN_TSK;
				break;
			case INFO:
				imgIdentifier = ISharedImages.IMG_OBJS_INFO_TSK;
				break;
			default:
				imgIdentifier = null;
				break;
			}
			if (imgIdentifier != null) {
				lbl_diagnostic.setImage(EclipseTools.getSharedImage(imgIdentifier));
			}
			lbl_diagnostic.setToolTipText(status.getMessage());
		}
		
		return lbl_diagnostic;
	}

	/**
	 * Adds the disposed listeners to the MAD widget and its corresponding SWT widget.
	 * 
	 * @param madWidget
	 * @param swtWidget
	 */
	protected void addControlDisposedListener(Widget<?> madWidget, Control swtWidget) {
		SWTWidgetUtil.addControlDisposedListener(swtWidget, madWidget);
	}

	/**
	 * Adds the disposed listeners to the MAD widget and its corresponding SWT widget.
	 * 
	 * @param swtWidget
	 * @param lbl_diagnostic 
	 */
	protected void addDisposeListenerForDiagnostic(Control swtWidget, final Label lbl_diagnostic) {
		swtWidget.addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
            	if (!lbl_diagnostic.isDisposed()) {
            		lbl_diagnostic.dispose();
            	}
            }
        });
	}

	/**
	 * Adds the visibility listeners to he MAD widget and its corresponding SWT widget.
	 * 
	 * @param madWidget
	 * @param swtWidget
	 */
	protected void addVisibilityListener(Widget<?> madWidget, Control swtWidget) {
		SWTWidgetUtil.addVisibilityListener(madWidget, swtWidget);
	}

	/**
	 * This method is called just before the creation of the diagnostic label.<br>
	 * It does nothing by default and may be overriden by sub-classes.
	 * 
	 * @param madWidget
	 */
	protected void beforeDiagnosticLabel(Widget<?> madWidget) {
	}

	/**
	 * Creates the SWT widget.
	 * <p>
	 * This method is called after {@link #checkMadWidget()}, the widget can be casted
	 * with
	 * 
	 * @param madWidget
	 * @return the created SWT widget.
	 */
	protected abstract Control createSpecificWidget(Widget<?> madWidget);

	/**
	 * Checks the widget type and raises an exception if the type is not valid for this
	 * specific widget.
	 * 
	 * @throws IllegalStateException if the widget is of an incorrect type.
	 */
	protected abstract void checkMadWidget(Widget<?> widget);

	/**
	 * Casts the given widget into the needed type.
	 * 
	 * @param widget
	 * @return the MAD widget casted into the needed type.
	 */
	@SuppressWarnings("unchecked")
	protected static <T extends Widget<?>> T castWidget(Widget<?> widget) {
		return (T) widget;
	}

	protected static List<CommandDefinition> getUsedCommands(Widget<?> widget) {
		Collection<CommandDefinition> commands;
		if (widget == null) {
			commands = Collections.emptyList();
		} else {
			commands = widget.getConfig().getWidgetCommands();
		}

		// Used commands
		List<CommandDefinition> usedCommands = new ArrayList<CommandDefinition>(commands.size());

		// Get the commands ids to display for the widget.
		for (CommandDefinition command : commands) {
			if (widget instanceof FlexibleWidget && command.getCommandCategory() == COMMAND_CATEGORY.GLOBAL_COMMAND) {
				usedCommands.add(command);
			} else if (widget instanceof ComposedWidget
					&& command.getCommandCategory() == COMMAND_CATEGORY.ITEM_COMMAND) {
				usedCommands.add(command);
			} else if (!(widget instanceof ComposedWidget)
					&& !(widget instanceof FlexibleWidget)
					&& (command.getCommandCategory() == COMMAND_CATEGORY.ITEM_COMMAND || command.getCommandCategory() == COMMAND_CATEGORY.GLOBAL_COMMAND)) {
				usedCommands.add(command);
			}
		}
		return usedCommands;
	}

	/**
	 * Add the command buttons for the specified MAD widget.<br>
	 * Change the layout data of the control if there is no button.
	 * 
	 * @param container
	 * @param widget
	 * @param control
	 */
	protected static void addCommandsButtons(Composite container, FormToolkit toolkit, final Widget<?> widget,
			Control control) {

		List<CommandDefinition> usedCommands = getUsedCommands(widget);

		if (usedCommands.size() == 0) {
			// Change the horizontal span of the SWT control for the third column of the
			// GridLayout
			GridData layoutData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
			layoutData.horizontalSpan = 2;
			control.setLayoutData(layoutData);
		} else {
			// Creates the buttons container
			Composite buttonsContainer = toolkit.createComposite(container);
			buttonsContainer.setLayout(GridLayoutHelper.createWithNoMargin(usedCommands.size()));
			buttonsContainer.setLayoutData(new GridData(SWT.END, SWT.BEGINNING, false, false));

			for (CommandDefinition command : usedCommands) {
				createCommandButton(buttonsContainer, toolkit, widget, command);
			}
		}
	}

	/**
	 * Add the command buttons for the specified MAD widget.<br>
	 * Change the layout data of the control if there is no button.
	 * 
	 * @param container
	 * @param widget
	 * @param control
	 */
	protected static void addFlexibleCommandsButtons(Composite container, FormToolkit toolkit,
			final FlexibleWidget<?> widget) {
		Collection<CommandDefinition> commands;
		if (widget == null) {
			commands = Collections.emptyList();
		} else {
			commands = widget.getConfig().getWidgetCommands();
		}

		// Used commands
		List<CommandDefinition> usedCommands = new ArrayList<CommandDefinition>(commands.size());

		// Get the GLOBAL_COMMAND commands' ids.
		for (CommandDefinition command : commands) {
			if (command.getCommandCategory() == COMMAND_CATEGORY.GLOBAL_COMMAND) {
				usedCommands.add(command);
			}
		}

		if (usedCommands.size() > 0) {
			// Creates the buttons container
			Composite buttonsContainer = toolkit.createComposite(container);
			buttonsContainer.setLayout(GridLayoutHelper.createWithNoMargin(commands.size()));
			GridData data = GridDataHelper.horizontalGrab();
			data.horizontalSpan = GRID_COLUMNS;
			data.verticalIndent = 5;
			buttonsContainer.setLayoutData(data);

			for (CommandDefinition command : usedCommands) {
				createCommandButton(buttonsContainer, toolkit, widget, command);
			}
		}
	}

	/**
	 * Creates an SWT button in the specified {@code container} and add a mouseUp listener
	 * executing the command {@code commandId} contained in the given {@code widget}.
	 * 
	 * @param container The SWT button container.
	 * @param widget The widget containing the command.
	 * @param commandID The ID of the command to execute.
	 * @param commandLabel The label to set on the button.
	 */
	protected static void createCommandButton(Composite container, FormToolkit toolkit, final Widget<?> widget,
			final CommandDefinition command) {
		String commandLabel = getFormatExprEvaluationService().evaluateFormatExpression(widget.getContextElement(),
				command.getCommandLabel(), MADQueryUtil.createArguments(widget.getContextElement()));
		Button btn_command = toolkit.createButton(container, null, SWT.PUSH);
		if (command.useIcon() && command.getIconDescriptor() != null) {
			Image image = EclipseTools.getImageFromPlugin(MadUiPlugin.getDefault(), command.getIconDescriptor());
			if (image != null) {
				btn_command.setImage(image);
			}
			// Use the label into the tooltip
			btn_command.setToolTipText(commandLabel);
		} else {
			btn_command.setText(commandLabel);
		}
		GridData data = GridDataHelper.horizontalGrab();
		if (widget instanceof FlexibleWidget) {
			SWTUtil.computeButtonWidth(btn_command, data);
		} else {
			btn_command.setLayoutData(data);
		}
		btn_command.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SWTHelper.execute(new Runnable() {

					@Override
					public void run() {
						widget.executeCommand(command.getCommandId());
					}
				});
			}
		});
	}

	protected void refreshView() {
		if (getSwtContext() != null && getSwtContext().getModelElementView() != null) {
			ModelAccessObject mao = getMao();
			try {
				synchronized (mao) {
					mao.loadViewValues(getSwtContext().getModelElementView());
				}
			} catch (MaoException e) {
				e.printStackTrace();
			}
		}
	}
}
