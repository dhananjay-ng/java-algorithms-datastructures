package problems.onsearching;

import java.util.List;

public class SearchShiftedSortedArray {
    /***
     * An array is said to be cyclically sorted if it is possible to cyclically shift its entries so
     * that it becomes sorted.
     * Design an O(log n) algorithm for finding the position of the smallest element in a
     * cyclically sorted array. Assume all elements are distinct. For example, for the array
     *
     * A= [378, 1, 2, 3]
     * Array is right shifted by 1 element.
     * return 1;
     */
    public static int searchSmallest(List<Integer> A) {
        int lo = 0, hi = A.size() - 1;
        int minVal = Integer.MAX_VALUE, minIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A.get(mid) < minVal) {
                minIndex = mid;
                minVal = A.get(mid);
            } else if (A.get(mid) > A.get(hi))
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return minIndex;
    }
}
