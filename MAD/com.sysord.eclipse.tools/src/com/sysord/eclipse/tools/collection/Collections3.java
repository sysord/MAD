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
package com.sysord.eclipse.tools.collection;

import java.util.LinkedList;

/**
 * Utility class for collections.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class Collections3 {

    // Suppresses default constructor, ensuring non-instantiability.
    private Collections3() {
    }

    /**
     * Returns a synchronized (thread-safe) {@link LinkedList} backed by the specified
     * {@code LinkedList}. In order to guarantee serial access, it is critical that
     * <strong>all</strong> access to the backing list is accomplished
     * through the returned list.
     * <p>
     * 
     * It is imperative that the user manually synchronize on the returned list when
     * iterating over it:
     * 
     * <pre>
     *  List list = Collections.synchronizedLinkedList(new LinkedList());
     *      ...
     *  synchronized (list) {
     *      Iterator i = list.iterator(); // Must be in synchronized block
     *      while (i.hasNext())
     *          foo(i.next());
     *  }
     * </pre>
     * 
     * Failure to follow this advice may result in non-deterministic behavior.
     * 
     * <p>
     * The returned list will be serializable if the specified list is serializable.
     * 
     * @param list the {@code LinkedList} to be "wrapped" in a synchronized list.
     * @return a synchronized view of the specified list.
     */
    public static <E> LinkedList<E> synchronizedLinkedList(LinkedList<E> list) {
        return new SynchronizedLinkedList<E>(list);
    }
}
