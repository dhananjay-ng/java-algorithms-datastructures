package datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {

    private int n;
    private Node first;
    private Node last;

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }


    // construct an empty deque
    public Deque() {
        n = 0;
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    private  boolean isUsable(Object node) {
        return node != null;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (!isUsable(item)) {
            throw new IllegalArgumentException();
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.previous = null;
        first.next = oldFirst;

        if (isEmpty()) {
            last = first;
        }
        if (isUsable(oldFirst)) {
            oldFirst.previous = first;
        }
        n++;

    }
    // add the item to the end
    public void addLast(Item item) {
        if (!isUsable(item)) {
            throw new IllegalArgumentException();
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.previous = oldLast;
        last.next = null;

        if (isEmpty()) {
            first = last;
        }

        if (isUsable(oldLast)) {
            oldLast.next = last;
        }
        n++;

    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (!isEmpty()) {
            Item oldFirst = first.item;
            first = first.next;
            if (!isUsable(first)) {
                first = null;
                last = null;

            } else {
                first.previous = null;
            }
            n--;
            return oldFirst;

        }
        throw new NoSuchElementException();
    }
    // remove and return the item from the end
    public Item removeLast() {
        if (!isEmpty()) {
            Item oldLast = last.item;
            last = last.previous;
            if (!isUsable(last)) {
                first = null;
                last = null;

            } else {
                last.next = null;
            }
            n--;
            return oldLast;
        }
        throw new NoSuchElementException();
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        Node current = first;
        @Override
        public boolean hasNext() {
            return isUsable(current);
        }

        @Override
        public Item next() {
            if (!isUsable(current)){ throw new NoSuchElementException(); }
            Item currentItem = current.item;
            current = current.next;
            return currentItem;
        }

        public void remove() { throw new UnsupportedOperationException();  }

    }

    public static void main(String[] args) {
        Deque<Integer> iDequeue = new Deque<>();
        for (int i = 1; i <= 10; i++) {
            iDequeue.addLast(i);
        }

        for (Integer i : iDequeue)
            for (Integer j : iDequeue)
            System.out.print(i*j + " ");


    }
}
