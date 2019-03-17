package datastructures.priorityqueue;

public class UnorderedMinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;      //number of elements in priority queue

    public UnorderedMinPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMin() {
        int min = 0;
        for (int i = 1; i < N; i++) {
            if (less(i, min)) min = i;
        }
        exch(min, N - 1);
        return pq[--N];
    }

    private void exch(int max, int i) {
        Key swap = pq[max];
        pq[max] = pq[i];
        pq[i] = swap;
    }


    boolean less(int a, int b) {
        return ((Comparable<Key>) pq[a]).compareTo(pq[b]) < 0;
    }

    public static void main(String[] args) {
        UnorderedMinPQ<Integer> umq = new UnorderedMinPQ<>(4);
        umq.insert(4);
        umq.insert(2);
        umq.insert(9);
        umq.insert(8);

        System.out.println(umq.delMin());
        System.out.println(umq.delMin());
        System.out.println(umq.delMin());
        System.out.println(umq.delMin());

    }
}
