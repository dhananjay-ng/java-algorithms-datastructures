
import java.util.Deque;
import java.util.LinkedList;

public class DequeUse {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        //As Stack
        deque.addFirst(10);
        deque.addFirst(9);
        deque.addFirst(8);
        deque.addFirst(7);
        deque.addFirst(111);
        System.out.println(deque.peek());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());

        //As Queue
        deque.addLast(10);
        deque.addLast(9);
        deque.addLast(8);
        deque.addLast(7);
        System.out.println(deque.peek());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());

    }
}
