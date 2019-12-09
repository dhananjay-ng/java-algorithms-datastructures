package problems.onRecursionAndDp.dp;
import java.util.*;
import java.lang.*;
import java.io.*;
public class DPMinStepsToReduceToOne {
    /**
     * One dimensional DP
     * Given a number n, count minimum steps to minimise it to 1 according to the following criteria:
     *
     * If n is divisible by 2 then we may reduce n to n/2.
     * If n is divisible by 3 then you may reduce n to n/3.
     * Decrement n by 1.
     *
     *
     * Input:
     *
     * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N denoting the number n.
     *
     *
     *
     * Output:
     *
     * Output the minimum steps to minimise the number in a new line for each test case.
     *
     *
     * Constraints:
     *
     * 1<= T <=1000
     *
     * 1<= N <=10000
     *
     *
     * Example:
     *
     * Input:
     *
     * 2
     *
     * 10
     *
     * 6
     *
     * Output:
     *
     * 3
     *
     * 2
     * @param args
     * @throws IOException
     */
    public static void main (String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int t = in.nextInt();
        int[] nums = new int[t];
        int max = -1;
        for(int i=0;i<t;i++){
            nums[i] = in.nextInt();
            if(nums[i] > max ) max = nums[i];
        }


        int[] dp = new int[max+1];
        dp[1] = 0;
        if(max > 1)
            dp[2] = 1;
        if(max>2)
            dp[3] = 1;

        for(int i = 4;i<=max;i++){
            int q1 = Integer.MAX_VALUE;
            int q2 = Integer.MAX_VALUE;
            int q3 = Integer.MAX_VALUE;
            if(i % 3 == 0) q1 = 1 + dp[i / 3];
            if(i % 2 == 0) q2 = 1 + dp[i / 2];
            q3 = 1 + dp[i - 1];

            dp[i] = Math.min(q1, Math.min(q2, q3));
        }
        for( int i = 0; i < t - 1; i++) {
            result.append(dp[nums[i]]).append("\n");
        }
        result.append(dp[nums[t-1]]);
        System.out.print(result.toString());

    }
}
