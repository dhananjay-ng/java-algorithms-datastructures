package problems.onheaps;

import java.util.PriorityQueue;

public class KthLargestElement {
    //todo solve this again with quick sort partition method
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();

    }
}
