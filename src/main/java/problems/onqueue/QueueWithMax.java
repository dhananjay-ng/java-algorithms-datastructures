package problems.onqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueWithMax {

    Deque<Integer> queueWithMax = new LinkedList<>();
    Deque<Integer> queueForElements = new LinkedList<>();

    public void enqueue(Integer x) {
        queueForElements.addFirst(x);
        while (!queueWithMax.isEmpty() && queueWithMax.peekFirst() < x) {
            queueWithMax.removeFirst();
        }
        queueWithMax.addFirst(x);
    }

    public Integer dequeue() {
        if (queueForElements.isEmpty()) throw new NoSuchElementException("Dequeue from empty");
        if (queueWithMax.peekLast() == queueForElements.peekLast()) {
            queueWithMax.removeLast();
        }
        return queueForElements.removeLast();
    }

    public Integer max() {
        return queueWithMax.peekLast();
    }

    public static void main(String[] args) {
        QueueWithMax qwm = new QueueWithMax();
        qwm.enqueue(8);
        qwm.enqueue(7);
        qwm.enqueue(6);
        qwm.enqueue(5);
        qwm.enqueue(7);
        System.out.println(qwm.max());
        qwm.dequeue();
        System.out.println(qwm.max());
        qwm.dequeue();
        System.out.println(qwm.max());
    }
}