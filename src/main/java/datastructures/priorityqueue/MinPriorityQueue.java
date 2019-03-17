package datastructures.priorityqueue;

import java.util.NoSuchElementException;

public class MinPriorityQueue {
    private int[] pq;
    private int n;   //size of maxpq


    public MinPriorityQueue(int initCapacity) {
        pq = new int[initCapacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public int max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    public void insert(int key) {
        if (n == pq.length - 1) {
            resize(pq.length * 2);
        }
        pq[++n] = key;
        swim(n);
    }

    public int delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        int max = pq[1];
        exch(1, n--);
        sink(1);
        if ((size() > 0) && (size() == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }
        return max;
    }

    // is pq[1..N] a max heap?
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    //condition check for wheather parent is larger than it's child
    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= n && greater(k, left)) return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    //helpers for doubling size of heap
    private void resize(int capacity) {
        int[] temp = new int[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    //helpers for heap invariant
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j = j + 1;
            }
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    //Helpers
    private boolean less(int i, int j) {
        return Integer.compare(pq[i], pq[j]) < 0;
    }

    private boolean greater(int i, int j) {
        return Integer.compare(pq[i], pq[j]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public static void main(String[] args) {
        MinPriorityQueue mpq = new MinPriorityQueue(1);
        //gonna use resizing as intial size is just 1
        mpq.insert(9);
        mpq.insert(1);
        mpq.insert(3);
        mpq.insert(6);
        mpq.insert(4);
        System.out.println("Is min Heap" + mpq.isMinHeap());


        System.out.println(mpq.delMin());
        System.out.println(mpq.delMin());
        System.out.println(mpq.delMin());
        System.out.println("Is min Heap" + mpq.isMinHeap());

        System.out.println(mpq.delMin());
        System.out.println(mpq.delMin());

    }
}
