package problems.onhashtable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SmallestSubArrayCoveringSet {
    /**
     * Write a program which takes an array of strings and a set of strings, and return the
     * indices of the starting and ending index of a shortest subarray of the given array that
     * "covers" the set, i.e., contains all strings in the set.
     */
    private static class Subarray {
        public Integer start;
        public Integer end;

        public Subarray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph,
                                                           Set<String> keywords) {

        Map<String, Long> keywordsToCover = keywords.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Subarray result = new Subarray(-1, -1);
        int remainingToCover = keywords.size();
        for (int left = 0, right = 0; right < paragraph.size(); ++right) {
            if (keywordsToCover.containsKey(paragraph.get(right)) &&
                    keywordsToCover.put(paragraph.get(right),
                            keywordsToCover.get(paragraph.get(right)) - 1) >=
                            1) {
                --remainingToCover;
            }

            // Keeps advancing left until it reaches end or keywordsToCover does not
            // have all keywords.
            while (remainingToCover == 0) {
                if ((result.start == -1 && result.end == -1) ||
                        right - left < result.end - result.start) {
                    result.start = left;
                    result.end = right;
                }
                if (keywordsToCover.containsKey(paragraph.get(left)) &&
                        keywordsToCover.put(paragraph.get(left),
                                keywordsToCover.get(paragraph.get(left)) + 1) >=
                                0) {
                    ++remainingToCover;
                }
                ++left;
            }
        }
        return result;
    }

}
