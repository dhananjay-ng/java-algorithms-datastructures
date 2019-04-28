package problems.onsearching;

import java.util.List;

public class SearchEntryEqualsToIndex {
    /***
     * Design an efficient algorithm that takes a sorted array of distinct integers, and returns
     * an index i such that the element at index i equals i. For example, when the input is
     * (-2, 0, 2, 3, 6, 7, 9) your algorithm should return 2 or 3.
     *
     */
    public static int searchEntryEqualToItsIndex(List<Integer> A) {
        int lo = 0, hi = A.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A.get(mid) == mid) return mid;
            else if (A.get(mid) > mid)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return -1;
    }
}
