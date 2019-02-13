package problems.onarray;

import java.util.Arrays;
import java.util.List;

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
     class Solution {
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

     class Solution2 {

        class Node implements Comparable<Node> {
            public int n;
            public int indx;

            public Node(int n, int indx){
                this.n = n;
                this.indx = indx;
            }

            public int compareTo(int no) {
                return this.n -no;
            }

            @Override
            public int compareTo(Node o) {
                return this.n - o.n;
            }
        }
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int maximumGap(final int[] A) {
            Node[] nodes = new Node[A.length];
            for(int i=0;i<A.length;i++){
                nodes[i] = new Node(A[i],i);
            }
            Arrays.sort(nodes);
            nodes[nodes.length-1].n = nodes[nodes.length-1].indx;
            for (int i=nodes.length - 2;i >= 0; i--) {
                nodes[i].n = Math.max(nodes[i].indx, nodes[i+1].indx);
            }

            int max = Integer.MIN_VALUE;
            for(int i=0;i<nodes.length;i++) {
                max = Math.max(nodes[i].n - nodes[i].indx, max);
            }
            return max;
        }

    }


}
