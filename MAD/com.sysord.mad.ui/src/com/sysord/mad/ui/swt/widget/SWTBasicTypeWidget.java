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

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.swt.ColorRegistry;
import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.*;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;

/**
 * Default SWT implementation of the MAD {@link BasicTypeWidget}.
 * <p>
 * Used for :
 * <ul>
 * <li><strong>Text</strong> widget</li>
 * <li><strong>Boolean</strong> widget</li>
 * <li><strong>Number</strong> widget</li>
 * <li><strong>Date</strong> widget</li>
 * </ul>
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTBasicTypeWidget extends AbstractSWTWidget {

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof BasicTypeWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Basic Type",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }
    
    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Control swtWidget;
        switch (madWidget.getConfig().getWidgCategory()) {
        case TEXT_WIDGET:
            swtWidget = createTextboxWidget(getSwtContext().getWidgetContainer(), madWidget);
            break;
        case BOOLEAN_WIDGET:
            swtWidget = createCheckboxWidget(getSwtContext().getWidgetContainer(), madWidget);
            break;
        case NUMBER_WIDGET:
            swtWidget = createNumberTextboxWidget(getSwtContext().getWidgetContainer(), madWidget);
            break;
        case DATE_WIDGET:
            swtWidget = createDateTextboxWidget(getSwtContext().getWidgetContainer(), madWidget);
            break;
        default:
            return null;
        }
        // Add a listener on the MAD Widget editable property
        SWTWidgetUtil.addNewEditableStateListener((InputWidget<?>) madWidget, swtWidget);
        return swtWidget;
    }

    /**
     * Creates the textbox SWT widget.
     * 
     * @param container
     * @param basicWidget
     * @return the created textbox.
     */
    protected Control createTextboxWidget(Composite container, Widget<?> madWidget) {
        BasicTypeWidget<String> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        Label errorLabel = createLabelColumn(toolkit, container, widget);
        String value = widget.getValue() == null ? Lbl.emptyString : widget.getValue();
        Text textBox = toolkit.createText(container, value, SWT.BORDER);
        textBox.setLayoutData(GridDataHelper.horizontalFill());
        textBox.setEnabled(widget.isEditable());
        // Add the commands buttons for the textbox.
        addCommandsButtons(container, toolkit, widget, textBox);
        // Add the listeners to the widget and the textbox.
        addTextboxListeners(widget, textBox, errorLabel);
        return textBox;
    }

    /**
     * Creates the checkbox SWT widget.
     * 
     * @param container
     * @param basicWidget
     * @return the created checkbox.
     */
    protected Control createCheckboxWidget(Composite container, Widget<?> madWidget) {
        BasicTypeWidget<Boolean> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        String label = widget.getLabel() == null ? Lbl.emptyString : widget.getLabel();
        Label errorLabel = toolkit.createLabel(container, null, SWT.NONE);
        errorLabel.setImage(EclipseTools.getSharedImage(ISharedImages.IMG_OBJS_ERROR_TSK));
        errorLabel.setVisible(false);
        Button checkbox = toolkit.createButton(container, label, SWT.CHECK);
        checkbox.setLayoutData(GridDataHelper.horizontalFill());
        checkbox.setSelection(widget.getValue() == null ? false : widget.getValue());
        checkbox.setEnabled(widget.isEditable());
        // Add the commands buttons for the checkbox.
        addCommandsButtons(container, toolkit, widget, checkbox);
        // Add the listeners to the widget and the checkbox.
        addCheckboxListeners(widget, checkbox, errorLabel);
        return checkbox;
    }

    /**
     * Creates a Textbox SWT widget for numbers.
     * 
     * @param container
     * @param basicWidget
     * @return the created textbox for numbers.
     */
    protected Control createNumberTextboxWidget(Composite container, Widget<?> madWidget) {
        BasicTypeWidget<Number> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        Label errorLabel = createLabelColumn(toolkit, container, widget);
        String valueString = getNumberStringValue(widget.getValue());
        Text numberTextBox = toolkit.createText(container, valueString, SWT.BORDER);
        numberTextBox.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        numberTextBox.setEnabled(widget.isEditable());
        // Add the commands buttons for the textbox.
        addCommandsButtons(container, toolkit, widget, numberTextBox);
        // Add the listeners to the widget and the textbox.
        addNumberTextboxListeners(widget, numberTextBox, errorLabel);
        return numberTextBox;
    }

    /**
     * Creates a textbox SWT widget for dates.
     * 
     * @param container
     * @param basicWidget
     * @return the created textbox for dates.
     */
    protected Control createDateTextboxWidget(Composite container, Widget<?> madWidget) {
        BasicTypeWidget<Date> widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        Label errorLabel = createLabelColumn(toolkit, container, widget);
        String valueString = getDateStringValue(widget.getValue());
        Text dateTextBox = toolkit.createText(container, valueString, SWT.BORDER);
        dateTextBox.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        dateTextBox.setEnabled(widget.isEditable());
        dateTextBox.setText(valueString);
        // Add the commands buttons for the textbox.
        addCommandsButtons(container, toolkit, widget, dateTextBox);
        // Add the listeners to the widget and the textbox.
        addDateTextboxListeners(widget, dateTextBox, errorLabel);
        return dateTextBox;
    }

    protected String getNumberStringValue(Number numberValue) {
        if (numberValue == null) {
            return Lbl.emptyString;
        }// else

        Class<? extends Number> valueClass = numberValue.getClass();
        String valueString = Lbl.emptyString;
        if (Double.class.isAssignableFrom(valueClass)) {
            valueString = String.valueOf(numberValue.doubleValue());
        } else if (Integer.class.isAssignableFrom(valueClass)) {
            valueString = String.valueOf(numberValue.intValue());
        } else if (Float.class.isAssignableFrom(valueClass)) {
            valueString = String.valueOf(numberValue.floatValue());
        } else {
            valueString = numberValue.toString();
        }
        return valueString;
    }

    protected Number getNumberValue(BasicTypeWidget<Number> basicTypeWidget, String value) {
        Class<? extends Number> valueClass = basicTypeWidget.getValue().getClass();
        if (value == null || value.length() < 1) {
            return null;
        }// else
        if (Integer.class.isAssignableFrom(valueClass)) {
            return Integer.parseInt(value);
        }// else
        if (Double.class.isAssignableFrom(valueClass)) {
            return Double.parseDouble(value);
        }// else
        if (Float.class.isAssignableFrom(valueClass)) {
            return Float.parseFloat(value);
        }// else
        if (BigDecimal.class.isAssignableFrom(valueClass)) {
            return new BigDecimal(value);
        }// else
        return null;
    }

    protected String getDateStringValue(Date widgetValue) {
        String valueString = Lbl.emptyString;
        if (widgetValue == null) {
            valueString = Lbl.emptyString;
        } else {
            valueString = new SimpleDateFormat("dd/MM/yyyy").format(widgetValue); //$NON-NLS-1$
        }
        return valueString;
    }

    protected Date getDateValue(BasicTypeWidget<Date> basicTypeWidget, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }// else
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(value); //$NON-NLS-1$
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Add the needed listeners to a {@link Text} widget and its corresponding
     * {@link BasicTypeWidget}.
     * 
     * @param widget
     * @param textBox
     * @param errorLabel
     */
    protected void addTextboxListeners(final BasicTypeWidget<String> widget, final Text textBox, final Label errorLabel) {
        final FocusListener[] focusContainer = new FocusListener[1];
        final KeyListener[] keyContainer = new KeyListener[1];
        // Add a listener for external widget value change.
        final AWidgetValueListener<String> valueListener = new AWidgetValueListener<String>() {

            @Override
            protected void _valueChanged(String ancientValue, String newValue) {
                if (!textBox.isDisposed()) {
                    textBox.removeFocusListener(focusContainer[0]);
                    textBox.removeKeyListener(keyContainer[0]);
                    textBox.setText(newValue == null ? Lbl.emptyString : newValue);
                    textBox.addFocusListener(focusContainer[0]);
                    textBox.addKeyListener(keyContainer[0]);
                    errorLabel.setToolTipText(Lbl.emptyString);
                    errorLabel.setVisible(false);
                }
            }
        };
        widget.addValueListener(valueListener);
        // Create the ModelAction for changing the textbox content
        final ModelAction textboxContentChangedAction = new ModelAction(valueListener, widget.getAdapter()) {

            @Override
            protected void action() {
                widget.setValue(textBox.getText() == null ? Lbl.emptyString : textBox.getText());
            }

            @Override
            protected boolean canRun() {
                boolean canrun = !textBox.isDisposed();
                if (canrun) {
                    String error = validate(widget, textBox.getText());
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    if (error != null) {
                        textBox.setBackground(ColorRegistry.get(PALE_RED));
                    } else {
                        textBox.setBackground(ColorRegistry.get(WHITE));
                    }
                    canrun = canrun && error == null;
                }
                return canrun
                        && !textBox.getText().equals(widget.getValue() == null ? Lbl.emptyString : widget.getValue());
            }
        };
        // Add a focus lost listener on the SWT widget updating the MAD widget value
        FocusAdapter focusListener = new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                textboxContentChangedAction.execute();
            }
        };
        focusContainer[0] = focusListener;
        textBox.addFocusListener(focusListener);
        // Add a ENTER Key listener on the SWT widget updating the MAD widget value
        KeyAdapter keyListener = new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) {
                    textboxContentChangedAction.execute();
                }
            }
        };
        keyContainer[0] = keyListener;
        textBox.addKeyListener(keyListener);
    }

    /**
     * Add the needed listeners to a {@link Text} widget and its corresponding
     * {@link BasicTypeWidget} for a NumberWidget.
     * 
     * @param widget
     * @param numberTextBox
     * @param errorLabel
     */
    protected void addNumberTextboxListeners(final BasicTypeWidget<Number> widget, final Text numberTextBox,
            final Label errorLabel) {
        final FocusListener[] focusContainer = new FocusListener[1];
        final KeyListener[] keyContainer = new KeyListener[1];
        // Add a listener for external widget value change.
        final AWidgetValueListener<Number> valueListener = new AWidgetValueListener<Number>() {

            @Override
            protected void _valueChanged(Number ancientValue, Number newValue) {
                if (!numberTextBox.isDisposed()) {
                    numberTextBox.removeFocusListener(focusContainer[0]);
                    numberTextBox.removeKeyListener(keyContainer[0]);
                    numberTextBox.setText(getNumberStringValue(newValue));
                    numberTextBox.addFocusListener(focusContainer[0]);
                    numberTextBox.addKeyListener(keyContainer[0]);
                }
            }
        };
        widget.addValueListener(valueListener);
        // Create the ModelAction for changing the textbox content
        final ModelAction numberContentChangedAction = new ModelAction(valueListener, widget.getAdapter()) {

            @Override
            protected void action() {
                widget.setValue(getNumberValue(widget, numberTextBox.getText()));
            }

            @Override
            protected boolean canRun() {
                boolean canrun = !numberTextBox.isDisposed();
                if (canrun) {
                    String error = validate(widget, getNumberValue(widget, numberTextBox.getText()));
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    if (error != null) {
                        numberTextBox.setBackground(ColorRegistry.get(PALE_RED));
                    } else {
                        numberTextBox.setBackground(ColorRegistry.get(WHITE));
                    }
                    canrun = canrun && error == null;
                }
                return canrun
                        && !numberTextBox.getText().equals(
                                widget.getValue() == null ? Lbl.emptyString : widget.getValue());
            }
        };
        // Add a focus lost listener on the SWT widget updating the MAD widget value
        FocusAdapter focusListener = new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                numberContentChangedAction.execute();
            }
        };
        focusContainer[0] = focusListener;
        numberTextBox.addFocusListener(focusListener);
        // Add an ENTER Key listener on the SWT widget updating the MAD widget value
        KeyAdapter keyListener = new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) {
                    numberContentChangedAction.execute();
                }
            }
        };
        keyContainer[0] = keyListener;
        numberTextBox.addKeyListener(keyListener);
    }

    /**
     * Add the needed listeners to a {@link Text} widget and its corresponding
     * {@link BasicTypeWidget} for a DateWidget.
     * 
     * @param widget
     * @param dateTextBox
     * @param errorLabel
     */
    protected void addDateTextboxListeners(final BasicTypeWidget<Date> widget, final Text dateTextBox,
            final Label errorLabel) {
        final FocusListener[] focusContainer = new FocusListener[1];
        final KeyListener[] keyContainer = new KeyListener[1];
        // Add a listener for external widget value change.
        final AWidgetValueListener<Date> valueListener = new AWidgetValueListener<Date>() {

            @Override
            protected void _valueChanged(Date ancientValue, Date newValue) {
                if (!dateTextBox.isDisposed()) {
                    dateTextBox.removeFocusListener(focusContainer[0]);
                    dateTextBox.removeKeyListener(keyContainer[0]);
                    dateTextBox.setText(getDateStringValue(newValue));
                    dateTextBox.addFocusListener(focusContainer[0]);
                    dateTextBox.addKeyListener(keyContainer[0]);
                }
            }
        };
        widget.addValueListener(valueListener);
        // Create the ModelAction for changing the textbox content
        final ModelAction dateChangedAction = new ModelAction(valueListener, widget.getAdapter()) {

            @Override
            protected void action() {
                widget.setValue(getDateValue(widget, dateTextBox.getText()));
            }

            @Override
            protected boolean canRun() {
                boolean canrun = !dateTextBox.isDisposed();
                if (canrun) {
                    String error = validate(widget, getDateValue(widget, dateTextBox.getText()));
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    if (error != null) {
                        dateTextBox.setBackground(ColorRegistry.get(PALE_RED));
                    } else {
                        dateTextBox.setBackground(ColorRegistry.get(WHITE));
                    }
                    canrun = canrun && error == null;
                }
                return canrun
                        && !dateTextBox.getText().equals(
                                widget.getValue() == null ? Lbl.emptyString : widget.getValue());
            }
        };
        // Add a focus lost listener on the SWT widget updating the MAD widget value
        FocusAdapter focusListener = new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                dateChangedAction.execute();
            }
        };
        focusContainer[0] = focusListener;
        dateTextBox.addFocusListener(focusListener);
        // Add an ENTER Key listener on the SWT widget updating the MAD widget value
        KeyAdapter keyListener = new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) {
                    dateChangedAction.execute();
                }
            }
        };
        keyContainer[0] = keyListener;
        dateTextBox.addKeyListener(keyListener);
    }

    /**
     * Add the needed listeners to a {@link Button} widget (checkbox) and its
     * corresponding {@link BasicTypeWidget}.
     * 
     * @param widget
     * @param checkbox
     * @param errorLabel
     */
    protected void addCheckboxListeners(final BasicTypeWidget<Boolean> widget, final Button checkbox,
            final Label errorLabel) {
        final SelectionListener[] selectionContainer = new SelectionListener[1];
        // Add a value listener on the MAD CheckBox widget.
        final AWidgetValueListener<Boolean> valueListener = new AWidgetValueListener<Boolean>() {

            @Override
            protected void _valueChanged(Boolean ancientValue, Boolean newValue) {
                if (!checkbox.isDisposed()) {
                    checkbox.removeSelectionListener(selectionContainer[0]);
                    checkbox.setSelection(newValue == null ? false : newValue);
                    checkbox.addSelectionListener(selectionContainer[0]);
                }
            }
        };
        widget.addValueListener(valueListener);
        // Create the ModelAction for changing the checkbox selected status
        final ModelAction checkboxStatusChangedAction = new ModelAction(valueListener, widget.getAdapter()) {

            @Override
            protected void action() {
                widget.setValue(checkbox.getSelection());
            }

            @Override
            protected boolean canRun() {
                boolean canrun = !checkbox.isDisposed();
                if (canrun) {
                    String error = validate(widget, checkbox.getSelection());
                    errorLabel.setToolTipText(error);
                    errorLabel.setVisible(error != null);
                    canrun = canrun && error == null;
                }
                return canrun;
            }
        };
        // Add a selection listener on the SWT button (checkbox)
        SelectionAdapter selectionListener = new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                checkboxStatusChangedAction.execute();
            }
        };
        selectionContainer[0] = selectionListener;
        checkbox.addSelectionListener(selectionListener);
    }

}
