package problems.onhashtable;

import java.util.HashMap;
import java.util.Map;

public class IsPalindromePermutaion {
    /**
     * A palindrome is a string that reads the same forwards and backwards, e.g., "level",
     * "rotator", and "foobaraboof".
     * Write a program to test whether the letters forming a string can be permuted to form
     * a palindrome. For example, "edified" can be permuted to form "deified".\
     */
    public static boolean canFormPalindrome(String s) {
        Map<Character, Integer> lookup = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!lookup.containsKey(s.charAt(i))) {
                lookup.put(s.charAt(i), 1);
            } else {
                lookup.put(s.charAt(i), lookup.get(s.charAt(i)) + 1);
            }
        }
        int oddcounter = 0;
        for (Integer value : lookup.values()) {
            if (value % 2 != 0 && ++oddcounter > 1) return false;
        }
        return true;
    }
}
