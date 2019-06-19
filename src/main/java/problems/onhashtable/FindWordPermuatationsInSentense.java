package problems.onhashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindWordPermuatationsInSentense {
    /**
     * This problem is concerned with taking a string (the "sentence" string) and a set
     * of strings (the "words"), and finding the substrings of the sentence which are the
     * concatenation of all the words (in any order). For example, if the sentence string
     * is "amanaplanacanal" and the set of words is {"can", "apl", "ana"), "aplanacan" is a
     * substring of the sentence that is the concatenation of all words.
     * Write a program which takes as input a string (the "sentence") and an array of strings
     * (the "words"), and returns the starting indices of substrings of the sentence string
     * which are the concatenation of all the strings in the words array. Each string must
     * appear exactly once, and their ordering is immaterial. Assume all strings in the words
     * array have equal length. It is possible for the words array to contain duplicates.
     */
    public static List<Integer> findAllSubstrings(String s, List<String> words) {
        List<Integer> res = new ArrayList<>();
        if (words != null && words.size() > 0 && s != null) {
            HashMap<String, Integer> wordCountMap = new HashMap<>();
            for (String word : words) {
                if (wordCountMap.containsKey(word)) {
                    int inc = wordCountMap.get(word) + 1;
                    wordCountMap.put(word, inc);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
            final int MAX_STR_LEN = words.size() * words.get(0).length();
            final int WORD_LEN = words.get(0).length();

            for (int i = 0; i <= s.length() - MAX_STR_LEN + 1; i++) {
                HashMap<String, Integer> tempWordCountMap = new HashMap<>(wordCountMap);
                boolean isSubString = isSubString(i, s, tempWordCountMap, WORD_LEN, words.size());
                if (isSubString) res.add(i);
            }
        }

        return res;
    }

    private static boolean isSubString(int i, String s, HashMap<String, Integer> tempWordCountMap, int word_len, int size) {

        while (true) {
            if (i + word_len > s.length()) return false;
            String nextWord = s.substring(i, i + word_len);
            if (tempWordCountMap.containsKey(nextWord) && tempWordCountMap.get(nextWord) > 0) {
                tempWordCountMap.put(nextWord, (tempWordCountMap.get(nextWord) - 1));
                size--;
                i += word_len;
            } else {
                return false;
            }
            if (size == 0) {
                return true;
            }
        }
    }

}
