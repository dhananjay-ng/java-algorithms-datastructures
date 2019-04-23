package problems.onheaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortAlmostSortedArray {
    /***
     * Often data is almost-sorted — for example, a server receives timestamped stock quotes
     * and earlier quotes may arrive slightly after later quotes because of differences in server
     * loads and network routes. In this problem we address efficient ways to sort such data.
     * Write a program which takes as input a very long sequence of numbers and prints
     * the numbers in sorted order. Each number is at most k away from its correctly sorted
     * position. (Such an array is sometimes referred to as being For example, no
     * number in the sequence (3, -1,2, 6,4, 5, 8} is more than 2 away from its final sorted
     * position.
     */
    public static List<Integer>
    sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k && sequence.hasNext(); i++) {
            minHeap.add(sequence.next());
        }
        while (sequence.hasNext()) {
            res.add(minHeap.remove());
            minHeap.add(sequence.next());
        }
        while (!minHeap.isEmpty()) {
            res.add(minHeap.remove());
        }
        return res;
    }
}
