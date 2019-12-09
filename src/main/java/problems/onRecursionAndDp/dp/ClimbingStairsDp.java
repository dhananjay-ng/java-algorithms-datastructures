package problems.onRecursionAndDp.dp;

import java.util.Arrays;

/**
 * Climbing Stairs
 * Solution
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairsDp {
    public int climbStairs(int n) {
        int cache[] = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[1] = 1;
        if (n > 1)
            cache[2] = 2;

        return climbdp(n, cache);

    }

    public int climbdp(int n, int[] cache) {
        if (cache[n] != -1) return cache[n];

        cache[n] = climbdp(n - 1, cache) + climbdp(n - 2, cache);
        return cache[n];
    }
}
