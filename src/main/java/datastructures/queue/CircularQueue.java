package datastructures.queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class CircularQueue {

    private int head = 0, tail = 0, numQueueElements = 0;
    private static final int SCALE_FACTOR = 2;
    private Integer[] entries;

    public CircularQueue(int capacity) {
        entries = new Integer[capacity];
    }

    public void enqueue(Integer x) {

        if (numQueueElements == entries.length) { // Need to resize.
            // Makes the queue elements appear consecutively.
            Collections.rotate(Arrays.asList(entries), -head);
            // Resets head and tail.
            head = 0;
            tail = numQueueElements;
            entries = Arrays.copyOf(entries, numQueueElements * SCALE_FACTOR);
        }

        entries[tail] = x;
        tail = (tail + 1) % entries.length;
        ++numQueueElements;
    }

    public Integer dequeue() {

        if (numQueueElements != 0) {
            --numQueueElements;
            Integer result = entries[head];
            head = (head + 1) % entries.length;
            return result;
        }
        throw new NoSuchElementException("Dequeue called on an empty queue.");
    }

    public int size() {
        return numQueueElements;
    }

    @Override
    public String toString() {

        return "Queue{"
                + "head=" + head + ", tail=" + tail +
                ", entries=" + Arrays.toString(entries) + '}';
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(2);
        q.enqueue(2);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(3);
        q.enqueue(3);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(3);
        q.enqueue(3);
        q.enqueue(3);
        q.enqueue(3);
        q.enqueue(3);


        System.out.println(q.toString());
    }

}
