package problems.onRecursionAndDp.dp;

public class MaximumSubarray {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * <p>
     * Example:
     * <p>
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     */
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] += nums[i] + ((sums[i - 1] > 0) ? sums[i - 1] : 0);
            maxsum = Math.max(maxsum, sums[i]);
        }

        return maxsum;
    }
}
