package problems.onhashtable;

import java.util.HashMap;
import java.util.List;

public class LongestSubarrayWithDistinctValues {
    //return length of longest subarray with distinct values.
    public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
        int maxCount = 0;
        int start = 0;
        HashMap<Integer, Integer> distinctSubArray = new HashMap<>();
        for (int front = 0; front < A.size(); front++) {
            if (distinctSubArray.containsKey(A.get(front))) {
                int end = front - 1;
                maxCount = Math.max((end - start) + 1, maxCount);
                int tempStart = distinctSubArray.get(A.get(front)) + 1;
                int removeEnd = distinctSubArray.get(A.get(front));
                for (int i = start; i <= removeEnd; i++)
                    distinctSubArray.remove(A.get(i));

                start = tempStart;
            }
            distinctSubArray.put(A.get(front), front);
        }
        maxCount = Math.max(maxCount, A.size() - start);
        return maxCount;
    }
}
