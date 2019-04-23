package problems.onheaps;

import java.util.*;

public class SortIncreasingDecreasingArray {

    public static enum SubArrayType {
        INCRESING,
        DECREASING
    }

    public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
        List<List<Integer>> sortedSubArrays = new ArrayList<>();
        SubArrayType sat = SubArrayType.INCRESING;
        int startIdx = 0;
        for (int i = 1; i <= A.size(); i++) {
            if (i == A.size()
                    || A.get(i - 1) >= A.get(i) && sat == SubArrayType.INCRESING
                    || A.get(i) > A.get(i - 1) && sat == SubArrayType.DECREASING) {
                List<Integer> sublist = A.subList(startIdx, i);
                if (sat == SubArrayType.DECREASING) {
                    Collections.reverse(sublist);
                }
                startIdx = i;
                sortedSubArrays.add(sublist);
                sat = sat == SubArrayType.INCRESING ? SubArrayType.DECREASING : SubArrayType.INCRESING;
            }
        }

        return mergeSortedArrays(sortedSubArrays);
    }

    public static class ArrayEntry {
        Integer value;
        int arrayId;

        ArrayEntry(int value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> in) {
        List<Iterator<Integer>> iters = new ArrayList<>();
        in.forEach(e -> iters.add(e.iterator()));
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
                in.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        }
        );
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < iters.size(); i++) {
            if (iters.get(i).hasNext())
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
        }

        while (!minHeap.isEmpty()) {
            ArrayEntry cur = minHeap.remove();
            res.add(cur.value);
            if (iters.get(cur.arrayId).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(cur.arrayId).next(), cur.arrayId));
            }

        }
        return res;
    }
}