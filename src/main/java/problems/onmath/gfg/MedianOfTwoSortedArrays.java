package problems.onmath.gfg;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianOfTwoSortedArrays {
    /**
     * todo find recursives olution
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 2 * n; i++) {
            Integer entry = sc.nextInt();
            addEntryToHeap(minHeap, maxHeap, entry);
        }
        if (minHeap.size() == maxHeap.size()) {
            System.out.println(Integer.valueOf((minHeap.peek() + maxHeap.peek())/2));
        } else {
            System.out.println(Integer.valueOf(minHeap.peek()));
        }

    }

    private static void addEntryToHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, Integer entry) {
        if (minHeap.isEmpty()) {
            minHeap.add(entry);
        } else {
            if (entry >= minHeap.peek()) {
                minHeap.add(entry);
            } else {
                maxHeap.add(entry);
            }
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.remove());
        } else if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.remove());
        }
    }
}
