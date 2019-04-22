package javarecipies.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueUse {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : o2 == o1 ? 0: 1;
            }
        });
        for (int i = 0 ;i <= 10; i++) {
            minHeap.add(i);
        }
        System.out.println(minHeap.peek());

    }
}
