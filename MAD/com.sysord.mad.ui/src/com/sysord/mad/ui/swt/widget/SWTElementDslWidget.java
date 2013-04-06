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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Injector;
import com.sysord.eclipse.tools.swt.ColorRegistry;
import com.sysord.mad.configuration.XtextLanguageDescription;
import com.sysord.mad.mao.ValuedSemanticElement;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.ModelAction;
import com.sysord.mad.ui.swt.SWTWidgetUtil;
import com.sysord.mad.widget.*;
import com.sysord.mad.widget.Widget;
import com.sysord.mad.widget.impl.AWidgetValueListener;
import com.sysord.xtext.tools.XtextUtility;
import com.sysord.xtext.tools.editor.*;

/**
 * Default SWT implementation of the {@link ElementDslWidget}.
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTElementDslWidget extends AbstractSWTWidget {
    
    private XtextEmbeddedEditor editor;

    @Override
    protected void checkMadWidget(Widget<?> widget) {
        if (!(widget instanceof ElementDslWidget)) {
            throw new IllegalStateException(Lbl.bind(Lbl.error_cannotCreateWidget, "Element DSL",//$NON-NLS-1$
                    widget.getClass().getName()));
        }
    }

    @Override
    protected Control createSpecificWidget(Widget<?> madWidget) {
        Composite container = getSwtContext().getWidgetContainer();
        ElementDslWidget widget = castWidget(madWidget);
        FormToolkit toolkit = getSwtContext().getToolkit();
        createLabelColumn(toolkit, container, widget);

        Composite dslComposite = toolkit.createComposite(container);
        dslComposite.setLayout(GridLayoutFactory.fillDefaults().create());
        dslComposite.setEnabled(widget.isEditable());
        Composite dslText = toolkit.createComposite(dslComposite, SWT.BORDER);
        dslText.setBackground(ColorRegistry.get(GRAY));
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.minimumHeight = 110;
        dslText.setLayoutData(data);
        dslText.setLayout(GridLayoutFactory.fillDefaults().create());
        Composite dslErrors = toolkit.createComposite(dslComposite);
        data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
        dslErrors.setLayoutData(data);
        dslErrors.setLayout(GridLayoutFactory.fillDefaults().create());
        try {
            XtextLanguageDescription languageDescription = widget.getConfig().getXtextWidgetLanguageDescriptor();
            Injector languageInjector = XtextUtility.getLanguageInjector(languageDescription.getBundleId(),
                    languageDescription.getActivatorClassName(), languageDescription.getLanguageName());

            editor = XtextElementEditorFactory.createEmbeddedEditor(languageInjector, dslText,
                    widget.getValue(), widget.getValuedSemanticElement().getElementResource());
            addElementDslListeners(widget, editor, dslComposite);
        } catch (XtextElementEditorException e) {
            e.printStackTrace();
        }
        // Add the buttons for this widget
        addCommandsButtons(container, toolkit, widget, dslComposite);
        return dslComposite;
    }

    /**
     * Add the needed listeners to the {@link XtextEmbeddedEditor} widget and its
     * corresponding {@link ElementDslWidget}.
     * 
     * @param widget
     * @param editor
     * @param container
     */
    protected void addElementDslListeners(final ElementDslWidget widget, final XtextEmbeddedEditor editor,
            final Composite container) {
        // final FocusListener[] focusContainer = new FocusListener[1];
        // Add a listener on the MAD element dsl widget
        final AWidgetValueListener<EObject> valueListener = new AWidgetValueListener<EObject>() {

            @Override
            protected void _valueChanged(EObject ancientValue, EObject newValue) {
                if (newValue != null) {
                    // TODO Mettre à jour le composite xtext ?
                }
            }
        };
        widget.addValueListener(valueListener);
        // Create the ModelAction for changing the xtext editor
        final ModelAction editorElementChanged = new ModelAction(valueListener, widget.getAdapter()) {

            @Override
            protected void action() {
                try {
                    if (editor.isContentValid()) {

                        final EObject editedelement = editor.getEditedElement();

                        // Xtext break the model on each change
                        // if other widget mapping xtext model element has changed
                        // our valueElement is out of date
                        getMao().loadWidgetValue(widget);

                        // apply new value
                        widget.setValue(editedelement);

                        final ValuedSemanticElement valueSemanticElement = widget.getValuedSemanticElement();

                        // retrieve merged value
                        final EObject mergedValue = (EObject) valueSemanticElement.getValue();

                        // set the merged element to the editor
                        Display.getDefault().asyncExec(new Runnable() {
                            @Override
                            public void run() {
                                if (mergedValue.eResource() != null) {
                                    // set the merged element
                                	if(!editor.isDisposed()){
                                        editor.setEditedElement(mergedValue);
                                        refreshView();                                		
                                	}
                                }
                            }
                        });
                    } else {
                        editor.cancelEdition();
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            protected boolean canRun() {
                return editor.isDirty();
            }
        };
        // Add a focus lost listener on the SWT xtext widget
        editor.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                editorElementChanged.execute();
            }
        });
        // Add an Editable listener on the MAD multi list widget
        SWTWidgetUtil.addNewEditableStateListener(widget, container);
    }
    
    @Override
    protected void addControlDisposedListener(Widget<?> madWidget, final Control swtWidget) {
        madWidget.addDisposeListener(new WidgetDisposeListener() {
            @Override
            public <T> void widgetDispose(Widget<T> widget) {
                editor.dispose();
                swtWidget.dispose();
            }
        });
    }

}
