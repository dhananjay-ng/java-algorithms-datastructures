package problems.onqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueFromStacks {

    Deque<Integer> forEnqueue = new LinkedList<>();
    Deque<Integer> forDequeue = new LinkedList<>();

    public void enqueue(Integer x) {
        forEnqueue.addFirst(x);
    }

    public Integer dequeue() {
        if (forDequeue.isEmpty()) {
            if (forEnqueue.isEmpty()) {
                throw new NoSuchElementException("Dequeu on Empty Stack");
            }
            while (!forEnqueue.isEmpty()) {
                forDequeue.addFirst(forEnqueue.removeFirst());
            }
        }
        return forDequeue.removeFirst();
    }


    public static void main(String[] args) {
        QueueFromStacks qfs = new QueueFromStacks();
        qfs.enqueue(2);
        qfs.enqueue(3);
        qfs.enqueue(4);
        System.out.println(qfs.dequeue());
    }
}