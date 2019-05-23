package problems.onhashtable;

import java.util.HashSet;
import java.util.List;

public class LongestContainedInterval {
    /**
     * Write a program which takes as input a set of integers represented by an array, and
     * returns the size of a largest subset of integers in the array having the property that if
     * two integers are in the subset, then so are all integers between them. For example, if
     * the input is (3, -2, 7, 9, 8, 1,2,0, -1,5,8), the largest such subset is {-2, -1,0, 1,2,3), so
     * you should return 6.
     */
    public static int longestContainedRange(List<Integer> A) {
        HashSet<Integer> nums = new HashSet<>(A);
        int maxSeq = 0;
        int curMaxSeq = 0;

        for (int i = 0; i < A.size(); i++) {
            int cur = A.get(i);
            if (nums.contains(cur)) {
                curMaxSeq = 1;
                int k = cur - 1;
                while (nums.contains(k)) {
                    curMaxSeq++;
                    nums.remove(k);
                    k--;
                }
                k = cur + 1;
                while (nums.contains(k)) {
                    curMaxSeq++;
                    nums.remove(k);
                    k++;
                }
                maxSeq = Math.max(curMaxSeq, maxSeq);
            }
        }
        return maxSeq;
    }
}
