package problems.onstring;

import java.util.HashMap;

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
    public static String stringWindow(String s1, String s2) {

        HashMap<Character, Integer> foundCharCount = new HashMap<>();
        HashMap<Character, Integer> neededCharCount = new HashMap<>();

//min positions of start and end index
        int startmin = 0;
        int endmin = Integer.MAX_VALUE;

// to hold current iteration
        int iter = 0;
        int curStart = -1;

        int curFoundLength = 0;
        int neededLength = s2.length();
        for (int i = 0; i < s2.length(); i++) {
            foundCharCount.put(s2.charAt(i),0);
            if(neededCharCount.containsKey(s2.charAt(i))) {
                neededCharCount.put(s2.charAt(i), neededCharCount.get(s2.charAt(i)) + 1);
            } else {
                neededCharCount.put(s2.charAt(i),1);
            }
        }

        for (int i = 0; i < s2.length(); i++) foundCharCount.put(s2.charAt(i),0);



        for (iter = 0; iter < s1.length(); iter++) {
            Character currentChar = s1.charAt(iter);
            if(foundCharCount.containsKey(currentChar) && !(curFoundLength == neededLength)) {
                if (curStart == -1) curStart = iter;
                foundCharCount.put(currentChar, foundCharCount.get(currentChar) +1);
                if (foundCharCount.get(currentChar) <= neededCharCount.get(currentChar)) {
                    curFoundLength++;
                }
            }
            if (curFoundLength == neededLength) {
                if (iter - curStart < endmin - startmin) {
                    startmin = curStart;
                    endmin = iter;
                }
                foundCharCount.put(s1.charAt(curStart), foundCharCount.get(s1.charAt(curStart)) -1);
                if(foundCharCount.get(s1.charAt(curStart)) < neededCharCount.get(s1.charAt(curStart))) {
                    curFoundLength--;
                }
                for(int i=curStart+1; i < s1.length();i++) {
                    if (foundCharCount.containsKey(s1.charAt(i))) {
                        curStart = i;
                        break;
                    }
                }

            }
            if ((curFoundLength == neededLength)) {
                iter--;
            }

        }

        if (startmin >=0 && startmin <=s1.length() && endmin >=0 && endmin<=s1.length()) {
            return s1.substring(startmin, endmin+1);
        } else {
            return "No string";
        }
    }

    public static void main(String[] args) {

    }
}
