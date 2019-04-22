package problems.onheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Example:
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     */
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                    new Comparator<ListNode>() {
                        @Override
                        public int compare(ListNode o1, ListNode o2) {
                            return o1.val - o2.val;
                        }
                    });

            for(ListNode listnode : lists) {
                if(listnode!=null)
                    minHeap.add(listnode);
            }

            ListNode dummyHead = new ListNode(0);
            ListNode iter = dummyHead;

            while(!minHeap.isEmpty()) {
                iter.next = minHeap.remove();
                iter = iter.next;
                if(iter!=null && iter.next != null) {
                    minHeap.add(iter.next);
                }
            }

            return dummyHead.next;
        }
    }
}
