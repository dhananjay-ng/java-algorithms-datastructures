package problems.onarray;

import java.util.List;

public class RemoveDuplicateFromSortedArray {
    /**
     * This problem is concerned with deleting repeated elements from a sorted array.
     * For example, for the array (2,3,5,5,7,11,11,11,13), then after deletion, the array is
     * (2,3,5,7,11,13,0,0,0). After deleting repeated elements, there are 6 valid entries.
     * There are no requirements as to the values stored beyond the last valid element.
     * Write a program which takes as input a sorted array and updates it so that all dupli¬
     * cates have been removed and the remaining elements have been shifted left to fill the
     * emptied indices. Return the number of valid elements. Many languages have library
     * functions for performing this operation — you cannot use these functions.
     *
     *Variant: Implement a function which takes as input an array and a key and updates
     * the array so that all occurrences of the input key have been removed and the remaining
     * elements have been shifted left to fill the emptied indices. Return the number of
     * remaining elements. There are no requirements as to the values stored beyond the
     * last valid element.
     * Variant: Write a program which takes as input a sorted array A of integers and a
     * positive integer m, and updates A so that if x appears m times in A it appears exactly
     * min(2 ,m) times in A. The update to A should be performed in one pass, and no
     * additional storage may be allocated.
     */
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
