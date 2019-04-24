package problems.onheaps;

import java.util.*;

public class OnlineMedian {
    /***
     * You want to compute the running median of a sequence of numbers. The sequence is
     * presented to you in a streaming fashion — you cannot back up to read an earlier value,
     * and you need to output the median after reading in each new element. For example,
     * if the input is 1,0, 3, 5, 2, 0,1 the output is 1,0.5, 1,2,2, 1.5, 1.
     * Design an algorithm for computing the running median of a sequence.
     */
    public static List<Double> onlineMedian(Iterator<Integer> sequence) {
        List<Double> res = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while (sequence.hasNext()) {
            Integer entry = sequence.next();
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

            if (minHeap.size() == maxHeap.size()) {
                res.add(0.5 * (minHeap.peek() + maxHeap.peek()));
            } else {
                res.add(Double.valueOf(minHeap.peek()));
            }

        }
        return res;
    }
}
