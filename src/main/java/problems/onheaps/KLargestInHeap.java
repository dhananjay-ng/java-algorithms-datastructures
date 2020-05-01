package problems.onheaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestInHeap {
    /**
     * A heap contains limited information about the ordering of elements, so unlike a sorted
     * array or a balanced BST, naive algorithms for computing the k largest elements have
     * a time complexity that depends linearly on the number of elements in the collection.
     * Given a max-heap, represented as an array A, design an algorithm that computes the k
     * largest elements stored in the max-heap. You cannot modify the heap. For example, if
     * if array representation of heap
     * is (561, 314, 401, 28, 156, 359, 271, 11, 3), the four largest elements are 561, 314, 401, and
     * 359.
     */
    public static class HeapEntry {
        int val;
        int index;

        public HeapEntry(int val, int index) {
            this.index = index;
            this.val = val;
        }
    }

    public static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<HeapEntry> levelPq = new PriorityQueue<>((o1, o2) -> {
            return o2.val - o1.val; //reverse comparater
        });
        if (A.size() == 0) return res;
        levelPq.add(new HeapEntry(A.get(0), 0));
        int count = 0;
        while (!levelPq.isEmpty() && count < k) {
            HeapEntry entry = levelPq.remove();
            res.add(entry.val);
            count++;
            int nextindx = 2 * entry.index + 1;
            if (nextindx < A.size())
                levelPq.add(new HeapEntry(A.get(nextindx), nextindx));
            if (nextindx + 1 < A.size())
                levelPq.add(new HeapEntry(A.get(nextindx + 1), nextindx + 1));
        }
        return res;
    }
}
