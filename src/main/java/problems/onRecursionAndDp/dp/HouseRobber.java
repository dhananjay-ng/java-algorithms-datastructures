package problems.onRecursionAndDp.dp;

import java.util.Arrays;

public class HouseRobber {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * Example 2:
     * <p>
     * Input: [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     * Total amount you can rob = 2 + 9 + 1 = 12.
     */

    public int rob(int[] nums) {
        int[] cache = new int[nums.length + 1];
        Arrays.fill(cache, -1);
        return rob(nums, nums.length - 1, cache);
    }

    public int rob(int[] nums, int i, int[] cache) {
        if (i < 0) return 0;
        if (cache[i] != -1) return cache[i];
        cache[i] = Math.max(rob(nums, i - 2, cache) + nums[i], rob(nums, i - 1, cache));
        return cache[i];
    }
}
/**

 * A robber has 2 options: a) rob current house i; b) don't rob current house.
 * If an option "a" is selected it means she can't rob previous i-1 house but can safely proceed to the one before previous i-2 and gets all cumulative loot that follows.
 * If an option "b" is selected the robber gets all the possible loot from robbery of i-1 and all the following buildings.
 * So it boils down to calculating what is more profitable:
 *
 * robbery of current house + loot from houses before the previous
 * loot from the previous house robbery and any loot captured before that
 * rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )
 */
