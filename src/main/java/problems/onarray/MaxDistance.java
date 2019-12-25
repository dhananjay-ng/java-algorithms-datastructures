package problems.onarray;

public class MaxDistance {


    /**
     * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
     *
     * If there is no solution possible, return -1.
     *
     * Example :
     *
     * A : [3 5 4 2]
     *
     * Output : 2
     * for the pair (3, 4)
     */
    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int maximumGap(final List<Integer> A) {
            if(A.size() == 0) return -1;


            int lmin[] = new int[A.size()];
            int rmax[] = new int[A.size()];

            lmin[0] = A.get(0);
            rmax[A.size()-1] = A.get(A.size()-1);
            for(int i=1,j=A.size()-2;i < A.size();i++,j--) {
                lmin[i] = Math.min(A.get(i), lmin[i-1]);
                rmax[j] = Math.max(A.get(j), rmax[j+1]);
            }

            int i=0, j=0,  max = Integer.MIN_VALUE;

            while(i<=j && j < rmax.length) {

                if(lmin[i] <= rmax[j]) {
                    max = Math.max(j-i, max);
                    j++;
                } else {
                    i++;
                }

            }


            return max;
        }
    }

}
