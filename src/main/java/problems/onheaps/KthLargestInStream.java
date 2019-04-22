package problems.onheaps;

import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int m;

    public KthLargestInStream(int k, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.remove();
            }

        }

        this.m = k;

    }

    public int add(int val) {
        if (minHeap.size() < m) {
            minHeap.add(val);
        } else if (val > minHeap.peek()) {
            minHeap.remove();
            minHeap.add(val);
        }

        return minHeap.peek();

    }
}
