package com.sysord.eclipse.tools.swt.widget;

import java.util.*;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sysord.eclipse.tools.swt.GridLayoutHelper;

/**
 * A typical picklist/slushbucket control
 * 
 * @author jesse
 */
public class PickList implements Listener {

    private StructuredViewer m_choicesBucket;
    private final Composite m_container;
    private StructuredViewer m_selectionBucket;
    private Button m_selectButton;
    private Button m_deselectButton;
    private LinkedHashSet<Object> m_selectionElements;
    private ISelectionStrategy m_selectionStrategy;

    protected Set<ISelectionChangedListener> postChangeListeners;
    private boolean listenersActivated = true;
    
    private IElementComparer comparer;
    private IStructuredContentProvider contentProvider;

    /**
     * Create a new PickList.
     * 
     * @param parent
     *        the composite to create the pick list within
     * @param style
     *        The style of the containing composite
     * @param toolkit
     *        the Formtoolkit to use for creating the elements
     * @param choices
     *        the type of viewer to use for the choices bucket.
     * @param selection
     *        the type of viewer to use for the selection bucket
     * @param choicesColumns
     *        the number of columns to display in the choices bucket. This
     *        is ignored if the ViewerType is a list
     * @param selectionColumns
     *        the number of columns to display in the selection bucket. This
     *        is ignored if the ViewerType is a list
     */
    public PickList(Composite parent, int style, FormToolkit toolkit, ViewerType choices, ViewerType selection,
            int choicesColumns, int selectionColumns) {
        m_selectionStrategy = ISelectionStrategy.ANY;

        m_container = toolkit.createComposite(parent, style);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(m_container);
        m_container.setLayout(GridLayoutHelper.createWithNoMargin(3));

        createChoicesBucket(toolkit, choices, choicesColumns);

        addButtons(toolkit);

        createSelectedBucket(toolkit, selection, selectionColumns);
    }

    private void createChoicesBucket(FormToolkit toolkit, ViewerType choices, int choicesColumns) {
            int style = SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL;
            m_choicesBucket = choices.create(toolkit, m_container, style, choicesColumns);
            GridDataFactory.fillDefaults().grab(true, true).applyTo(m_choicesBucket.getControl());
            m_choicesBucket.addFilter(new ViewerFilter() {
    
                @Override
                public boolean select(Viewer viewer, Object parentElement, Object element) {
    //                return !m_selectionElements.contains(element);
                    return !isSelected(element, m_selectionElements);
                }
    
            });
    
            m_choicesBucket.addDoubleClickListener(new IDoubleClickListener() {
    
                @SuppressWarnings("unchecked")
                public void doubleClick(DoubleClickEvent event) {
                    IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                    if (selection.size() == 1) {
                        if (m_choicesBucket instanceof TreeViewer) {
                            TreeViewer viewer = (TreeViewer) m_choicesBucket;
                            Object element = selection.getFirstElement();
                            boolean state = !viewer.getExpandedState(element);
                            viewer.setExpandedState(element, state);
                        }
                    }
                    select(selection.toList());
                }
    
            });
        }

    private void createSelectedBucket(FormToolkit toolkit, ViewerType selection, int selectionColumns) {
        int style = SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL;
        m_selectionBucket = selection.create(toolkit, m_container, style, selectionColumns);
        m_selectionBucket.setContentProvider(new ArrayContentProvider());
        GridDataFactory.fillDefaults().grab(true, true).applyTo(m_selectionBucket.getControl());
        m_selectionElements = new LinkedHashSet<Object>();
        m_selectionBucket.setInput(m_selectionElements);
        m_selectionBucket.addDoubleClickListener(new IDoubleClickListener() {

            @SuppressWarnings("unchecked")
            public void doubleClick(DoubleClickEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                deselect(selection.toList());
            }

        });

    }

    protected boolean isSelected(Object element, Collection<Object> selection) {
        if (comparer == null) {
            return selection.contains(element);
        }// else
        
        for (Object o : selection) {
            if (comparer.equals(o, element))
                return true;
        }
        
        return false;
    }

    private void addButtons(FormToolkit toolkit) {
        Composite composite = toolkit.createComposite(m_container);
        composite.setLayout(new RowLayout(SWT.VERTICAL));
        GridDataFactory.swtDefaults().align(SWT.CENTER, SWT.CENTER).applyTo(composite);

        m_selectButton = toolkit.createButton(composite, ">>", SWT.PUSH);
        m_selectButton.addListener(SWT.Selection, this);
        m_deselectButton = toolkit.createButton(composite, "<<", SWT.PUSH);
        m_deselectButton.addListener(SWT.Selection, this);
    }

    /**
     * Return the value of postChangeListeners.
     * 
     * @return the value of postChangeListeners.
     */
    protected Set<ISelectionChangedListener> getPostChangeListeners() {
        if (postChangeListeners == null) {
            postChangeListeners = new HashSet<ISelectionChangedListener>();
        }
        return postChangeListeners;
    }
    
    public StructuredViewer getChoicesViewer() {
        return m_choicesBucket;
    }
    
    public StructuredViewer getSelectionViewer() {
        return m_selectionBucket;
    }

    /**
     * The label provider to use for the Selection bucket. It must be a valid
     * type for the ViewerType that was chosen for the selection bucket.
     * 
     * @param labelProvider
     *        the provider
     */
    public void setSelectionLabelProvider(ILabelProvider labelProvider) {
        m_selectionBucket.setLabelProvider(labelProvider);
    }

    /**
     * The label provider to use for the choices bucket. It must be a valid type
     * for the ViewerType that was chosen for the choices bucket.
     * 
     * @param labelProvider
     *        the provider
     */
    public void setChoicesLabelProvider(ILabelProvider labelProvider) {
        m_choicesBucket.setLabelProvider(labelProvider);
    }

    /**
     * The content provider to use for the choices bucket. It must be a valid
     * type for the ViewerType that was chosen for the choices bucket.
     * 
     * @param contentProvider
     *        the provider
     */
    public void setChoicesContentProvider(IStructuredContentProvider contentProvider) {
        this.contentProvider = contentProvider;
        m_choicesBucket.setContentProvider(contentProvider);
    }
    
    /**
     * Defines the {@link IElementComparer}
     * 
     * @param comparer
     */
    public void setElementComparer(IElementComparer comparer) {
        this.comparer = comparer;
    }
    
    /**
     * Defines the {@link ViewerComparator}.
     * 
     * @param comparator
     */
    public void setComparator(ViewerComparator comparator) {
        m_choicesBucket.setComparator(comparator);
        m_selectionBucket.setComparator(comparator);
    }

    /**
     * Sets the input for the choices bucket
     * 
     * @param input
     *        The input for the choices bucket
     */
    public void setInput(Object input) {
        m_choicesBucket.setInput(input);
    }

    public void refreshInput(Object input) {
        listenersActivated = false; // Deactivate the listeners
        
        Collection<Object> selection = findCorrespondingSelection(input, getSelection());
        m_selectionElements.clear();
        m_selectionBucket.setSelection(new StructuredSelection());
        m_choicesBucket.setSelection(new StructuredSelection());
        setInput(input);
        select(selection);
        
        listenersActivated = true; // Activate the listeners
    }

    private Collection<Object> findCorrespondingSelection(Object input, Collection<Object> selection) {
        ArrayList<Object> selectedElements = new ArrayList<Object>(selection.size());
        Object[] elements = contentProvider.getElements(input);
        for (Object element : elements) {
            if (isSelected(element, selection)) {
                selectedElements.add(element);
            }
        }
        return selectedElements;
    }

    @SuppressWarnings("unchecked")
    public void handleEvent(Event event) {
        if (event.widget == m_selectButton) {
            select(((IStructuredSelection) m_choicesBucket.getSelection()).toList());
        } else {
            deselect(((IStructuredSelection) m_selectionBucket.getSelection()).toList());
        }
    }

    private void deselect(Collection<Object> elements) {
        m_selectionBucket.setSelection(new StructuredSelection());
        m_choicesBucket.setSelection(new StructuredSelection());
        m_selectionElements.removeAll(elements);
        m_selectionBucket.refresh();
        m_choicesBucket.refresh();
        m_choicesBucket.setSelection(new StructuredSelection(elements));
        notifyPostChangeListeners();
    }

    private void select(Collection<Object> objects) {
        m_selectionBucket.setSelection(new StructuredSelection());
        m_choicesBucket.setSelection(new StructuredSelection());
        for (Object object : objects) {
            if (m_selectionStrategy.canSelect(m_selectionBucket, object)) {
                m_selectionElements.add(object);
            }
        }
        m_selectionBucket.refresh();
        m_choicesBucket.refresh();
        m_choicesBucket.setSelection(new StructuredSelection(m_selectionElements));
        notifyPostChangeListeners();
    }
    
    /**
     * Notify the post change listeners
     */
    private void notifyPostChangeListeners() {
        if (listenersActivated) {
            ISelection selection = new StructuredSelection(m_selectionElements.toArray());
            SelectionChangedEvent event = new SelectionChangedEvent(m_selectionBucket, selection);
            for (ISelectionChangedListener listener : getPostChangeListeners()) {
                listener.selectionChanged(event);
            }
        }
    }

    public void setFocus() {
        m_choicesBucket.getControl().setFocus();
    }

    public void setSelectionStrategy(ISelectionStrategy selectionStrategy) {
        if (selectionStrategy == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        m_selectionStrategy = selectionStrategy;
    }

    public enum ViewerType {
        LIST_VIEWER {

            @Override
            protected StructuredViewer create(FormToolkit toolkit, Composite composite, int style, int columns) {
                ListViewer listViewer = new ListViewer(composite, style);
                toolkit.adapt(listViewer.getList(), true, true);
                return listViewer;
            }

        },
        TABLE_VIEWER {

            @Override
            protected StructuredViewer create(FormToolkit toolkit, Composite composite, int style, int columns) {
                Table table = toolkit.createTable(composite, style);
                for (int i = 1; i < columns; i++) {
                    new TableColumn(table, SWT.NONE);
                }
                return new TableViewer(table);
            }

        },
        TREE_VIEWER {

            @Override
            protected StructuredViewer create(FormToolkit toolkit, Composite composite, int style, int columns) {
                Tree tree = toolkit.createTree(composite, style);
                for (int i = 1; i < columns; i++) {
                    new TreeColumn(tree, SWT.NONE);
                }

                return new TreeViewer(tree);
            }

        };

        protected abstract StructuredViewer create(FormToolkit toolkit, Composite composite, int style, int columns);
    }

    @SuppressWarnings("unchecked")
    public Collection<Object> getSelection() {
        Object data = m_selectionBucket.getInput();
        if (data instanceof Collection) {
            return (Collection<Object>) data;
        }// else

        return Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    public void setSelection(IStructuredSelection selection) {
        deselect(m_selectionElements);
        select(selection.toList());
    }

    /**
     * Return this {@code PickList} composite container.
     * 
     * @return this {@code PickList} composite container.
     */
    public Composite getPickListContainer() {
        return m_container;
    }

    public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
        getPostChangeListeners().add(listener);
    }

    public void removePostSelectionChangedListener(ISelectionChangedListener listener) {
        getPostChangeListeners().remove(listener);
    }

}