package problems.onsearching;

public class IntSquareRoot {
    /***
     * Write a program which takes a nonnegative integer and returns the largest integer
     * whose square is less than or equal to the given integer. For example, if the input is
     * 16, return 4; if the input is 300, return 17, since 172 = 289 < 300 and 182 = 324 > 300.
     */
    public static int squareRoot(int k) {
        // return (int)Math.sqrt(k);
        //or
        long maxValue = Integer.MIN_VALUE;
        long index = -1;
        long lo = 0, hi = k;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid > maxValue && mid * mid <= k) {
                index = mid;
                maxValue = mid * mid;
                if (maxValue == k) return (int) index;
            } else if (mid * mid < k)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return (int) index;
    }
}
