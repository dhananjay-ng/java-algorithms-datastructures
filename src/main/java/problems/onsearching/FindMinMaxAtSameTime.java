package problems.onsearching;

import java.util.List;

public class FindMinMaxAtSameTime {
    /***
     * Given an array of comparable objects, you can find either the min or the max of the
     * elements in the array with n - 1 comparisons, where n is the length of the array.
     * Comparing elements may be expensive, e.g., a comparison may involve a number
     * of nested calls or the elements being compared may be long strings. Therefore, it is
     * natural to ask if both the min and the max can be computed with less than the 2 (n - 1)
     * comparisons required to compute the min and the max independently.
     * Design an algorithm to find the min and max elements in an array. For example, if
     * A = (3, 2, 5, 1, 2, 4), you should return 1 for the min and 5 for the max.
     *
     */
    public static class MinMax {
        public Integer smallest;
        public Integer largest;

        public MinMax(Integer smallest, Integer largest) {
            this.smallest = smallest;
            this.largest = largest;
        }
    }

    public static MinMax findMinMax(List<Integer> A) {
        if (A.size() == 1) return new MinMax(A.get(0), A.get(0));
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = A.size() - 1;
        if (A.size() % 2 != 0) {
            min = A.get(n);
            max = A.get(n);
            n -= 1;
        }
        for (int i = 0; i <= n; i += 2) {
            if (A.get(i) < A.get(i + 1)) {
                max = A.get(i + 1) > max ? A.get(i + 1) : max;
                min = A.get(i) < min ? A.get(i) : min;
            } else {
                max = A.get(i) > max ? A.get(i) : max;
                min = A.get(i + 1) < min ? A.get(i + 1) : min;
            }
        }


        return new MinMax(min, max);
    }

}
