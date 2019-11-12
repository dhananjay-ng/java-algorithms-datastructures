package problems.onRecursionAndDp;

public class KthGrammerRec {
    /**
     * K-th Symbol in Grammar
     * Solution
     * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
     *
     * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
     *
     * Examples:
     * Input: N = 1, K = 1
     * Output: 0
     *
     * Input: N = 2, K = 1
     * Output: 0
     *
     * Input: N = 2, K = 2
     * Output: 1
     *
     * Input: N = 4, K = 5
     * Output: 1
     *
     * Explanation:
     * row 1:     0
     * row 2:   0    1
     * row 3:  0  1  1 0
     * row 4: 0 11 01 00 1   (left child is same as parent, right child is inverse of parent.)
     * Note:
     *
     * N will be an integer in the range [1, 30].
     * K will be an integer in the range [1, 2^(N-1)].
     * @param N
     * @param K
     * @return
     */
        public int kthGrammar(int N, int K) {
            if (N == 1) return 0;
            if (K % 2 == 0) return kthGrammar(N - 1, K / 2) == 0 ? 1 : 0;
            else return kthGrammar(N - 1, (K + 1) / 2);
        }

    /**approach : left child is same as parent, right child is inverse of parent.)
     * We don't need to actually generate the strings "0110..." (would be TLE error anyway)
     * We see that, for any level N, the first half of the string is the same as the string in N-1, the next half is just complement of it. The total number of items in level N is 2^N. The half mark of the string is marked by [2^(N-1)]-th item. So, for any level N:
     * if K is in the first half, it is same as the Kth element in level N-1
     * if K is in the second half, it is the complement of the number in [K-2^(N-1)]-th position in level N-1
     * So, we run the recursion until the base condition (N=1)
     *
     * https://leetcode.com/problems/k-th-symbol-in-grammar/discuss/113697/My-3-lines-C++-recursive-solution
     * The whole structure can be viewed a binary tree, when a node is 0, their two children nodes are 0 and 1, similarly, when a node is 1, two children nodes are 1 and 0. We can know whether the position of K is a left node or a right node by dividing 2. If K is even, current node is right child, and its parent is the (K/2)th node in previous row; else if K is odd, current node is left child and its parent is the ((K+1)/2)th node in previous row.
     * The value of current node depends on its parent node, without knowing its parent node value, we still cannot determine current node value. That's why we need recursion, we keep going previous row to find the parent node until reach the first row. Then all the parent node value will be determined after the recursion function returns.
     */
}
