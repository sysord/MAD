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

import java.util.*;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Injector;
import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.eclipse.tools.swt.GridDataHelper;
import com.sysord.eclipse.tools.swt.GridLayoutHelper;
import com.sysord.mad.core.Activator;
import com.sysord.mad.emitter.ViewBuilder;
import com.sysord.mad.evaluator.FormatExpressionEvaluationService;
import com.sysord.mad.mao.ModelAccessObject;
import com.sysord.mad.ui.Lbl;
import com.sysord.mad.ui.swt.CandidateElementComparer;
import com.sysord.mad.validator.InvalidWidgetValueException;
import com.sysord.mad.validator.WidgetValueValidationService;
import com.sysord.mad.widget.impl.CandidateImpl;

/**
 * Abstract implementation of a {@link SpecificWidget} for SWT.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class AbstractSpecificWidget implements SpecificWidget {

	private static FormatExpressionEvaluationService formatExprEvaluationService;
    protected String ID;
    private ConsoleLogger logger;
    private WidgetValueValidationService validationService;
    private ViewBuilder viewBuilder;
    private ModelAccessObject mao;

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void setId(String ID) {
        this.ID = ID;
    }

    /**
     * Create a list of {@link Candidate}s with the specified objects collection contained
     * by the candidates collection.
     * 
     * @param selected
     * @return the created list of {@link Candidate}s.
     */
    protected Collection<Candidate> toCandidateList(List<Candidate> candidates, Collection<Object> selected) {
        List<Candidate> selectedCandidates = new ArrayList<Candidate>(selected.size());
        for (Object value : selected) {
            for (Candidate candidate : candidates) {
                if (candidate.getValue() == null && value == null || candidate.getValue() != null
                        && candidate.getValue().equals(value)) {
                    selectedCandidates.add(candidate);
                    break;// Corresponding candidate found
                }
            }// break
        }
        return selectedCandidates;
    }

    /**
     * Return the corresponding candidate of the specified selected Object with the
     * candidates list.
     * 
     * @param selected
     * @return the created list of {@link Candidate}s.
     */
    protected Candidate toCandidateElement(List<Candidate> candidates, Object selected) {
        for (Candidate candidate : candidates) {
            if (candidate.getValue() == null && selected == null || candidate.getValue() != null
                    && candidate.getValue().equals(selected)) {
                return candidate;// Corresponding candidate found
            }
        }
        return null;
    }

    /**
     * Extract the elements from the candidate collection.
     * 
     * @param candidates
     * @return the list of extracted Object from the candidates collection.
     */
    protected Collection<Object> candidatesToElementList(Collection<Object> candidates) {
        List<Object> elements = new ArrayList<Object>();
        for (Object candidate : candidates) {
            if (candidate instanceof Candidate) {
                elements.add(((Candidate) candidate).getValue());
            }
        }
        return elements;
    }

    /**
     * Create a {@link IStructuredSelection} for the given values.
     * <p>
     * If a value is {@code null} it will be transformed in a {@link Candidate} with a
     * {@code null} value.
     * 
     * @param values
     * @return the {@code IStructuredSelection} corresponding to the given values.
     */
    protected IStructuredSelection createSelection(Collection<Object> values) {
        List<Object> selection = new ArrayList<Object>();
        for (Object value : values) {
            if (value == null) {
                selection.add(new CandidateImpl(Lbl.emptyString, null));
            } else {
                selection.add(value);
            }
        }
        return new StructuredSelection(selection);
    }

    /**
     * Create a {@link IStructuredSelection} for the given value.
     * <p>
     * If the value is {@code null} it will be transformed in a {@link Candidate} with a
     * {@code null} value.
     * 
     * @param value
     * @return the {@code IStructuredSelection} corresponding to the given value.
     */
    protected IStructuredSelection createSelection(Object value) {
        LinkedList<Object> values = new LinkedList<Object>();
        values.add(value);
        return createSelection(values);
    }

    protected boolean widgetValueEqualsCandidate(OutputWidget<?> widget, Object candidateOrValue) {
        CandidateElementComparer comparer = new CandidateElementComparer();
        return comparer.equals(widget.getValue(), candidateOrValue);
    }

    /**
     * Validates the value to put on the given widget.
     * 
     * @param widget
     * @param value
     * @return the error message if the validation fails;<br>
     *         {@code null} otherwise.
     */
    protected String validate(InputWidget<?> widget, Object value) {
        String errorMessage = null;
        try {
            getValidationService().validateWidget(widget, value);
        } catch (InvalidWidgetValueException e) {
        	errorMessage = e.getMessage();
        	getLogger().logError(e);
        }
        return errorMessage;
    }

    /**
     * Create a label and set its GridData.
     * 
     * @param toolkit
     * @param container
     * @param widget
     * @return the error message label
     */
    protected static Label createLabelColumn(FormToolkit toolkit, Composite container, Widget<?> widget) {
        // Label container
        Composite labelContainer = toolkit.createComposite(container);
        GridData data = new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false);
        data.verticalIndent = 4;
        labelContainer.setLayoutData(data);
        labelContainer.setLayout(GridLayoutHelper.createNoSpacingNoMargin(2));

        // Error image label
        Label errorImage = toolkit.createLabel(labelContainer, null, SWT.NONE);
        errorImage.setImage(EclipseTools.getSharedImage(ISharedImages.IMG_OBJS_ERROR_TSK));
        errorImage.setLayoutData(GridDataFactory.swtDefaults().create());
        errorImage.setVisible(false);

        // Widget label
        String label = widget.getLabel() == null ? Lbl.emptyString : widget.getLabel();
        Label lbl = toolkit.createLabel(labelContainer, label);
        lbl.setLayoutData(GridDataHelper.defaultData());

        return errorImage;
    }

    /**
     * Returns the {@link WidgetValueValidationService value validation service}.
     * 
     * @return the {@link WidgetValueValidationService value validation service}.
     */
    protected WidgetValueValidationService getValidationService() {
        if (validationService == null) {
            validationService = getInjector().getInstance(WidgetValueValidationService.class);
        }
        return validationService;
    }

    /**
     * retrieves and returns the {@link FormatExpressionEvaluationService} using injector
     * 
     * @return
     */
    protected static FormatExpressionEvaluationService getFormatExprEvaluationService() {
        if (formatExprEvaluationService == null) {
            formatExprEvaluationService = Activator.getDefault().getInjector()
                    .getInstance(FormatExpressionEvaluationService.class);
        }
        return formatExprEvaluationService;
    }

    protected ModelAccessObject getMao() {
        if (mao == null) {
            mao = getInjector().getInstance(ModelAccessObject.class);
        }
        return mao;
    }

    protected ViewBuilder getViewBuilder() {
        if (viewBuilder == null) {
            viewBuilder = getInjector().getInstance(ViewBuilder.class);
        }
        return viewBuilder;
    }

    protected ConsoleLogger getLogger() {
        if (logger == null) {
            logger = getInjector().getInstance(ConsoleLogger.class);
        }
        return logger;
    }

    protected Injector getInjector() {
        return Activator.getDefault().getInjector();
    }
}
