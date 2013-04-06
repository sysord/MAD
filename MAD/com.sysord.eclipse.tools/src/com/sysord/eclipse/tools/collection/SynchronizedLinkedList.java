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

import java.util.*;

/**
 * Synchronized {@link LinkedList}.
 * <p>
 * It is imperative that the user manually synchronize on the returned list when iterating over it:
 * <pre>
 *  LinkedList list = Collections3.synchronizedLinkedList(myLinkedList);
 *     ...
 *  synchronized (list) {
 *      Iterator i = list.iterator(); // Must be in the synchronized block
 *      while (i.hasNext())
 *         foo(i.next());
 *  }
 * </pre>
 *
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SynchronizedLinkedList<E> extends LinkedList<E> {

    private static final long serialVersionUID = 2085876244733929025L;
    
    private LinkedList<E> list;

    private Object mutex;
    
    /**
     * Create a synchronized {@link LinkedList}.
     * 
     * @param list The {@code LinkedList} to synchronize.
     */
    public SynchronizedLinkedList(LinkedList<E> list) {
        this.list = list;
        this.mutex = this;
    }

    @Override
    public boolean isEmpty() {
        synchronized (mutex) { return list.isEmpty(); }
    }

    @Override
    public E getFirst() {
        synchronized (mutex) { return list.getFirst(); }
    }

    @Override
    public E getLast() {
        synchronized (mutex) { return list.getLast(); }
    }

    @Override
    public E removeFirst() {
        synchronized (mutex) { return list.removeFirst(); }
    }

    @Override
    public E removeLast() {
        synchronized (mutex) { return list.removeLast(); }
    }

    @Override
    public void addFirst(E e) {
        synchronized (mutex) { list.addFirst(e); }
    }

    @Override
    public void addLast(E e) {
        synchronized (mutex) { list.addLast(e); }
    }

    @Override
    public boolean contains(Object o) {
        synchronized (mutex) { return list.contains(o); }
    }

    @Override
    public Iterator<E> iterator() {
        synchronized (mutex) { return list.iterator(); }
    }

    @Override
    public int size() {
        synchronized (mutex) { return list.size(); }
    }

    @Override
    public boolean add(E e) {
        synchronized (mutex) { return list.add(e); }
    }

    @Override
    public boolean remove(Object o) {
        synchronized (mutex) { return list.remove(o); }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        synchronized (mutex) { return list.containsAll(c); }
    }

    @Override
    public ListIterator<E> listIterator() {
        synchronized (mutex) { return list.listIterator(); }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        synchronized (mutex) { return list.addAll(c); }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        synchronized (mutex) { return list.addAll(index, c); }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        synchronized (mutex) { return list.removeAll(c); }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        synchronized (mutex) { return list.retainAll(c); }
    }

    @Override
    public void clear() {
        synchronized (mutex) { list.clear(); }
    }

    @Override
    public E get(int index) {
        synchronized (mutex) { return list.get(index); }
    }

    @Override
    public E set(int index, E element) {
        synchronized (mutex) { return list.set(index, element); }
    }

    @Override
    public String toString() {
        synchronized (mutex) { return list.toString(); }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        synchronized (mutex) { return list.subList(fromIndex, toIndex); }
    }

    @Override
    public void add(int index, E element) {
        synchronized (mutex) { list.add(index, element); }
    }

    @Override
    public E remove(int index) {
        synchronized (mutex) { return list.remove(index); }
    }

    @Override
    public boolean equals(Object o) {
        synchronized (mutex) { return list.equals(o); }
    }

    @Override
    public int indexOf(Object o) {
        synchronized (mutex) { return list.indexOf(o); }
    }

    @Override
    public int lastIndexOf(Object o) {
        synchronized (mutex) { return list.lastIndexOf(o); }
    }

    @Override
    public int hashCode() {
        synchronized (mutex) { return list.hashCode(); }
    }

    @Override
    public E peek() {
        synchronized (mutex) { return list.peek(); }
    }

    @Override
    public E element() {
        synchronized (mutex) { return list.element(); }
    }

    @Override
    public E poll() {
        synchronized (mutex) { return list.poll(); }
    }

    @Override
    public E remove() {
        synchronized (mutex) { return list.remove(); }
    }

    @Override
    public boolean offer(E e) {
        synchronized (mutex) { return list.offer(e); }
    }

    @Override
    public boolean offerFirst(E e) {
        synchronized (mutex) { return list.offerFirst(e); }
    }

    @Override
    public boolean offerLast(E e) {
        synchronized (mutex) { return list.offerLast(e); }
    }

    @Override
    public E peekFirst() {
        synchronized (mutex) { return list.peekFirst(); }
    }

    @Override
    public E peekLast() {
        synchronized (mutex) { return list.peekLast(); }
    }

    @Override
    public E pollFirst() {
        synchronized (mutex) { return list.pollFirst(); }
    }

    @Override
    public E pollLast() {
        synchronized (mutex) { return list.pollLast(); }
    }

    @Override
    public void push(E e) {
        synchronized (mutex) { list.push(e); }
    }

    @Override
    public E pop() {
        synchronized (mutex) { return list.pop(); }
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        synchronized (mutex) { return list.removeFirstOccurrence(o); }
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        synchronized (mutex) { return list.removeLastOccurrence(o); }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        synchronized (mutex) { return list.listIterator(index); }
    }

    @Override
    public Iterator<E> descendingIterator() {
        synchronized (mutex) { return list.descendingIterator(); }
    }

    @Override
    public Object clone() {
        synchronized (mutex) { return list.clone(); }
    }

    @Override
    public Object[] toArray() {
        synchronized (mutex) { return list.toArray(); }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        synchronized (mutex) { return list.toArray(a); }
    }
}
