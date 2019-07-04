package problems.onsorting;

public class TwoMaxNumberSimultaniously {
    /**
     * Given an array with all elements greater than or equal to zero. Return the maximum product of two numbers possible.
     *
     * Input:
     * The first line of input contains an integer T denoting the number of test cases.
     * The first line of each test case is N, size of array. The second line of each test case contains array elements.
     *
     * Output:
     * Print the maximum product of two numbers possible
     */
    public int find(int a[]) {
        int n = a.length;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (max1 < a[i]) {
                max2 = max1;
                max1 = Math.max(max1, a[i]);
            } else if (max2 < a[i]) {
                max2 = a[i];
            }
        }
        return max1 * max2;
    }
}
