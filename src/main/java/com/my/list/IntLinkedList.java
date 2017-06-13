package com.my.list;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Created by nik.denisenko on 13/06/2017.
 */
public class IntLinkedList implements Iterable<Integer> {

    private Entry head = null;
    private Entry tail = null;
    private int size = 0;

    private IntLinkedList() {
    }

    public static IntLinkedList newIntLinkedList() {
        return new IntLinkedList();
    }

    public IntLinkedList append(int e) {
        addTail(e);
        return this;
    }

    public IntLinkedList push(int e) {
        addHead(e);
        return this;
    }

    public IntLinkedList removeHead() {
        if (size() <= 1) {
            removeAll();
        } else {
            final Entry h = head;
            removeIf(entry -> entry == h);
        }
        return this;
    }

    public IntLinkedList removeTail() {
        if (size() <= 1) {
            removeAll();
        } else {
            final Entry t = tail;
            removeIf(entry -> entry == t);
        }
        return this;
    }

    public IntLinkedList removeGreaterThan(int e) {
        removeIf(entry -> entry.e > e);
        return this;
    }

    public IntLinkedList removeAll() {
        size = 0;
        head = null;
        tail = null;
        return this;
    }

    private void removeIf(Predicate<Entry> predicate) {
        while (head != null && predicate.test(head)) {
            head = head.next;
            decSize();
        }
        if (head == null) {
            tail = null;
        } else {
            Entry current = head;
            while (current != null && current.next != null) {
                if (predicate.test(current.next)) {
                    current.next = current.next.next;
                    decSize();
                } else {
                    current = current.next;
                }
                tail = current;
            }
        }
    }

    private void addTail(int e) {
        if (isEmpty()) {
            addFirst(newEntry(e));
        } else {
            tail.next = newEntry(e);
            tail = tail.next;
            incSize();
        }
    }

    private void addHead(int e) {
        if (isEmpty()) {
            addFirst(newEntry(e));
        } else {
            head = newEntry(e, head);
            incSize();
        }
    }

    private void addFirst(Entry e) {
        head = e;
        tail = e;
        size = 1;
    }

    private void incSize() {
        size++;
    }

    private void decSize() {
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Entry current = head;

            @Override
            public boolean hasNext() {
                return isEmpty() || current != tail;
            }

            @Override
            public Integer next() {
                final int e = current.e;
                current = current.next;
                return e;
            }
        };
    }

    private static class Entry {
        private int e;
        private Entry next;

        Entry(int e, Entry next) {
            this.e = e;
            this.next = next;
        }

        Entry(int e) {
            this(e, null);
        }
    }

    private static Entry newEntry(int e) {
        return new Entry(e);
    }

    private static Entry newEntry(int e, Entry next) {
        return new Entry(e, next);
    }
}
