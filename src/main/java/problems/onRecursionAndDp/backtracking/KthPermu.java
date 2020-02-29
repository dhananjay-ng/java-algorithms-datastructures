package problems.onRecursionAndDp.backtracking;

import java.util.ArrayList;

public class KthPermu {
    //1. "123"
    //2. "132"
    //3. "213"
    //4. "231"
    //5. "312"
    //6. "321"

    /**
     * if we have n = 3 and k=5 (4th in sequence 0 based indexing)
     * each of this n numbers will have (n-1)! permutations :
     * so first number in kth permutation is (4/(3-1)!) =  4/2 = 2th index;[0 based indexing]
     * now we have first numberr as 3 , 2nd indexed number in 1 2 3.
     * remainingf list = 1 2 :
     * now ealrier we had 6 permu beacause of 3 numbers
     * now numbers left are 2 so there are only 2 permu possible
     * and in this 2 permu which starts from 3, out permu is
     *
     *   k%(n-1)! = 5%2 = 1 1 st permu which starts from 1 2 numbers and if you see this
     *   our group starting with permu of 3 this is 1st permu in remaing elenmt.
     */


    static public class Solution {
        public String getPermutation(int n, int k) {
            if (k > fact(n)) return "";
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            return getPermutation(list, k - 1);

        }

        public String getPermutation(ArrayList<Integer> list, int k) {
            int n = list.size();
            if (n == 0) return "";

            int fact_n = fact(n - 1);
            int index = k / fact_n;
            int num = list.get(index);
            list.remove(index);
            k %= fact_n;
            return num + getPermutation(list, k);
        }

        int fact(int n) {
            if (n > 12) return Integer.MAX_VALUE;

            int fact = 1;
            for (int i = 2; i <= n; i++) {
                fact *= i;
            }

            return fact;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getPermutation(4, 11);
    }

}
