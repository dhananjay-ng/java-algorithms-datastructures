package problems.onhashtable;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int n = s.length();
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < n; i++) {
            if (freq[t.charAt(i) - 'a']-- == 0) {
                return false;
            }
        }

        return true;
    }

}

