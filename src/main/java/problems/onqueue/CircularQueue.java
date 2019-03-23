package problems.onqueue;

import java.util.Arrays;

public class CircularQueue {

    public static class Queue {
        int[] q;
        int size = 0;
        int front = 0;
        int end = 0;

        public Queue(int capacity) {
            q = new int[capacity];
        }

        public void enqueue(Integer x) {
            if (size() == q.length) {
                resize(q.length * 2);
            }
            q[end] = x;
            end = (end + 1) % q.length;;
            size++;
        }

        private void resize(int newCapacity) {

            int[] temp = new int[newCapacity];
            int k = 0;
            int i = front;
            do{
                temp[k++] = q[i % q.length];
                i++;
            }while (i % q.length != end);
            // Collections.rotate(Arrays.asList(q), -front);
            //  q = Arrays.copyOf(q, newCapacity); you can use this than above code if array is non primitive

            front = 0;
            end = size;
            q = temp;
        }

        public Integer dequeue() {
            if (size() == 0) {
                throw new IllegalStateException("Deque from empty Queue.");
            }
            if (size()==q.length/4){
                resize(q.length/2);
            }
            int item = q[front];
            front = (front + 1) % q.length;
            size--;
            return item;
        }

        public int size() {
            return size;
        }


        @Override
        public String toString() {

            return "Queue{"
                    + "head=" + front + ", tail=" + end +
                    ", entries=" + Arrays.toString(q) + '}';
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(2);
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

