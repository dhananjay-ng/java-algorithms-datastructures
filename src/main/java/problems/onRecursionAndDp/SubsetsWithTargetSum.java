package problems.onRecursionAndDp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class SubsetsWithTargetSum {
    public class Solution {
        public ArrayList<ArrayList<Integer>> res;
        int target = 0;

        public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
            this.target = b;
            res = new ArrayList<>();
            Collections.sort(a);
            ListIterator<Integer> it = a.listIterator();
            int prev = -1;
            while (it.hasNext()) {
                int next = it.next();
                if(prev!=-1 && prev == next) {
                    it.remove();
                }
                prev = next;
            }
            helper(a, new ArrayList<>(), 0, 0);
            return res;
        }


        public void helper(ArrayList<Integer> A, ArrayList<Integer> pre,int presum, int start) {
            if(presum == this.target) {
                res.add(new ArrayList<>(pre));
                return;
            }
            for(int i=start; i < A.size(); i++) {
                pre.add(A.get(i));
                presum+=A.get(i);
                helper(A, pre, presum, ++start);
                pre.remove(pre.size()-1);
                presum-=A.get(i);
            }
        }
    }

}
