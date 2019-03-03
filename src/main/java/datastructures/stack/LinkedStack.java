package datastructures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Iterable<Item> {
    private int n;          // size of the stack
    private Node first;     // top of stack

    private class Node {
        private Item item;
        private Node next;
    }

    public LinkedStack() {
        first = null;
        n = 0;
        assert check();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
        assert check();
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        assert check();
        return item;                   // return the saved item
    }


    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }


    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private boolean check() {

        // check a few properties of instance variable 'first'
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            if (first != null) return false;
        }
        else if (n == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first == null)      return false;
            if (first.next == null) return false;
        }

        // check internal consistency of instance variable n
        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != n) return false;

        return true;
    }

}
