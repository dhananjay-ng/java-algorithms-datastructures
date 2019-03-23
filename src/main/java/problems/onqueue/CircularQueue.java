package problems.onqueue;

public class CircularQueue {

    public static class Queue {
        int[] q;
        int size;
        int front;
        int end;

        public Queue(int capacity) {
            q = new int[capacity];
            size = 0;
            front = -1;
            end = -1;
        }

        public void enqueue(Integer x) {
            if (size() == q.length) {
                resize(q.length * 2);
            }
            int pos = (end + 1) % q.length;
            q[pos] = x;
            end = pos;
            if (front == -1) {
                front = end;
            } //first enqueue
            size++;
        }

        private void resize(int newCapacity) {
            int[] temp = new int[newCapacity];
            int k = 0;
            for (int i = front; i % q.length != end; i++) {
                temp[k++] = q[i % q.length];
            }
            temp[k] = q[end];
            front = 0;
            end = size - 1;
            q = temp;
        }

        public Integer dequeue() {
            if (size() == 0) {
                throw new IllegalStateException("Deque from empty Queue.");
            } else if (size() == q.length / 4) {
                resize(q.length / 2);
            }
            int item = q[front];
            front = (front + 1) % q.length;
            size--;
            if (size() == 0) {
                front = -1;
                end = -1;
            }
            return item;
        }

        public int size() {
            return size;
        }

        @Override
        public String toString() {
            StringBuilder queue = new StringBuilder();
            queue.append("[");
            for (int i = front; i % q.length != end; i++)
                queue.append(q[i]).append(",");

            queue.append(q[end]).append("]");

            return queue.toString();
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

