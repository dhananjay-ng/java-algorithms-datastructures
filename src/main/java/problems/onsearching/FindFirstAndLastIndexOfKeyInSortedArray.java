package problems.onsearching;

public class FindFirstAndLastIndexOfKeyInSortedArray {
    /***
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * If the target is not found in the array, return [-1, -1].
     *
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     */
    public int[] searchRange(int[] a, int target) {
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;

        int lof = 0, lol = 0;
        int hif = a.length - 1, hil = hif;
        while (lof <= hif || lol <= hil) {
            if (lof <= hif) {
                int midf = lof + (hif - lof) / 2;
                if (a[midf] == target) {
                    res[0] = midf;
                    hif = midf - 1;
                } else if (a[midf] < target) {
                    lof = midf + 1;
                } else {
                    hif = midf - 1;
                }
            }
            if (lol <= hil) {
                int midl = lol + (hil - lol) / 2;
                if (a[midl] == target) {
                    res[1] = midl;
                    lol = midl + 1;
                } else if (a[midl] < target) {
                    lol = midl + 1;
                } else {
                    hil = midl - 1;
                }
            }
        }

        return res;
    }
}
