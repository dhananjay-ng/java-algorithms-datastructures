package datastructures.queue;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int n;

    // construct an empty randomized queue
    public RandomizedQueue() {
        q = (Item[]) new Object[2];
        n = 0;
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

    // add the item
    public void enqueue(Item item) {
        if (!isUsable(item)) {
            throw new IllegalArgumentException();
        }
        if (n == q.length) { // if full resize
            resize(2*q.length);
        }
        q[n++] = item;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp [i] = q[i];
        }
        q = temp;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int choice = StdRandom.uniform(n);
        Item item = q[choice];
        if (choice == n-1) {
            q[choice] = null;
        } else {
            q[choice] = q[n-1];
            q[n-1] = null;
        }
        n--;
        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }


    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[StdRandom.uniform(n)];
    }
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueArrayIterator();
    }

    private class RandomizedQueueArrayIterator implements Iterator<Item> {

        Item[] randdomShffuleOfQueue = (Item[]) new Object[n];
        private int current = 0;

        public RandomizedQueueArrayIterator() {
            for (int i = 0; i < n; i++) {
                randdomShffuleOfQueue [i] = q[i];
            }
            StdRandom.shuffle(randdomShffuleOfQueue);
        }

        @Override
        public boolean hasNext() {
            return current < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return randdomShffuleOfQueue[current++];
        }

        public void remove() { throw new UnsupportedOperationException();  }

    }

    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        for (int i = 0; i < 9; i++)
            rq.enqueue("" + i);

        for (String x : rq)
            System.out.print(x + " ");

        for (int i = 0; i < 9; i++) {
            System.out.println(rq.dequeue());
        }



        for (String x : rq)
            System.out.print(x + " ");

        System.out.println();

        for (String x : rq)
            System.out.print(x + " ");


    }
}
