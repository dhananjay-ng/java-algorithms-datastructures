package problems.onRecursionAndDp;

public class DistinctSubsequences2 {
    /**
     * Given a string S, count the number of distinct, non-empty subsequences of S .
     * <p>
     * Since the result may be large, return the answer modulo 10^9 + 7.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: "abc"
     * Output: 7
     * Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
     * Example 2:
     * <p>
     * Input: "aba"
     * Output: 6
     * Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
     * Example 3:
     * <p>
     * Input: "aaa"
     * Output: 3
     * Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
     * <p>
     * <p>
     * <p>
     * <p>
     * Note:
     * <p>
     * S contains only lowercase letters.
     * 1 <= S.length <= 2000
     *
     * @return
     */
    public static int distinctSubseqII(String s) {
        int res = 1, MOD = 1000000007;
        int[] end = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int pre = res;
            char c = s.charAt(i);
            res = (res * 2 % MOD - end[c - 'a'] + MOD) % MOD;
            end[(int) (c - 'a')] = pre;
        }

        return res - 1; // exclude ""
    }


    public static void main(String[] args) {
        System.out.println(distinctSubseqII("pcrdhwdxmqdznbenhwjsenjhvulyve"));
    }
    /**
     * dp[i] is the number of disctinct subsequences for substring s[0..i]. It includes the empty string "" to make things easy. We'll exclude this one in the end by simply minus 1, so the answer isdp[n-1] - 1.
     *
     * If all characters are distinct, then dp[i] = dp[i-1]*2, that is all previous subsequeuences without s[i], plus all previous subsequeuences appended with s[i].
     *
     * If there are duplicate characters, We use end[c] to denote the number of distinct subsequences ending with char c so far. So number of all previous subsequences with s[i] should be subtracted by previous end[s[i]]. That is:
     * dp[i] = dp[i-1] * 2 - end[s[i]]
     *
     * It is easy to compact dp from O(n) to O(1) as d[i] only depends on dp[i-1]. The code is quite simple actually:
     */
}
