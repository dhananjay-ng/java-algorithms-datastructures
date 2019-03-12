package algorithms.string;

public class KMP {

    public static int[] computeSufixPrefixArray(String patten) {
        int[] suffixPrefixArray = new int[patten.length()];
        int i = 1, j = 0;
        while (i < patten.length()) {
            if (patten.charAt(i) == patten.charAt(j)) {
                suffixPrefixArray[i] = ++j;
                i++;
            } else {
                if (j != 0) {
                    j = suffixPrefixArray[j - 1];
                } else {
                    suffixPrefixArray[i] = 0;
                    i++;
                }
            }
        }

        return suffixPrefixArray;
    }

    public static int search(String text, String pattern) {
        int[] suffixPrefixArray = computeSufixPrefixArray(pattern);
        int i = 0, j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = suffixPrefixArray[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length()) return i - j;
        else return -1;
    }

    public static void main(String args[]) {
        System.out.println(search("BCBAABABAC", "ABABAC"));

    }
}
