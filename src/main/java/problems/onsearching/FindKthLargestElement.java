package problems.onsearching;

import java.util.Random;

public class FindKthLargestElement {
    /***
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Example 1:
     *
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     * Example 2:
     *
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        Random r = new Random(0);
        while (left <= right) {
            int pivIdx = r.nextInt(right - left + 1) + left;
            int newPivIdx = partition(nums, left, right, pivIdx);
            if ((nums.length - newPivIdx) == k) return nums[newPivIdx];
            else if ((nums.length - newPivIdx) > k) left = newPivIdx + 1;
            else right = newPivIdx - 1;
        }
        return -1;
    }

    public void swap(int nums[], int one, int two) {
        int temp = nums[two];
        nums[two] = nums[one];
        nums[one] = temp;
    }

    public int partition(int[] nums, int left, int right, int pivIdx) {
        int pivVal = nums[pivIdx];
        int newPivIdx = left;
        swap(nums, pivIdx, right);
        for (int i = left; i < right; i++) {
            if (nums[i] < pivVal) {
                swap(nums, newPivIdx, i);
                newPivIdx++;
            }

        }
        swap(nums, newPivIdx, right);
        return newPivIdx;
    }

}
