package problems.onarray;

import java.util.List;

public class RemoveDuplicateFromSortedArray {
    // Returns the number of valid entries after deletion.
    public static int deleteDuplicates(List<Integer> A) {

        if(A.size()==0) {
            return 0;
        }
        int cur , pre=A.get(0), nextDisctItemPos = 1;
        for (int i=1;i<A.size();i++) {
            cur = A.get(i);
            if (cur != pre) {
                pre = cur;
                int temp = A.get(nextDisctItemPos);
                A.set(nextDisctItemPos,cur);
                A.set(i,temp);
                nextDisctItemPos++;
            }
        }
        return nextDisctItemPos;
    }
}
