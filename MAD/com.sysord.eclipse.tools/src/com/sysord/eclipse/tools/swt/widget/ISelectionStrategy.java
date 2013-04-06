package com.sysord.eclipse.tools.swt.widget;

import org.eclipse.jface.viewers.Viewer;

/**
 * This class determines which classes can be selected with the PickList control
 * 
 * @author jesse
 */
public interface ISelectionStrategy {

    public static final ISelectionStrategy ANY = new ISelectionStrategy() {

        public boolean canSelect(Viewer viewer, Object element) {
            return true;
        }

    };

    /**
     * Return true if the element is permitted to be selected
     * 
     * @param viewer
     *        the viewer containing the element
     * @param element
     *        element to check
     * @return true if the element is permitted to be selected
     */
    public boolean canSelect(Viewer viewer, Object element);
}