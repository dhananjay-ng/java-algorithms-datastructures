package problems.onstring;

public class StringWindow {
    /**
     * 76. Minimum Window Substring
     * Hard
     *
     * 3032
     *
     * 220
     *
     * Favorite
     *
     * Share
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
     *
     * Example:
     *
     * Input: S = "ADOBECODEBANC", T = "ABC"
     * Output: "BANC"
     * Note:
     *
     * If there is no such window in S that covers all characters in T, return the empty string "".
     * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for (char a : t.toCharArray()) {
            count[a]++;
        }

        int counter = t.length(), left = 0, right = 0;
        int head = -1, window = Integer.MAX_VALUE;
        while (right < s.length()) {
            if (count[s.charAt(right++)]-- > 0) counter--;

            while (counter == 0) {
                if (window > right - left) {
                    head = left;
                    window = right - left;
                }

                if (count[s.charAt(left++)]++ == 0) counter++;
            }
        }

        return head == -1 ? "" : s.substring(head, head+window);
    }
    public static void main(String[] args) {

    }
}
