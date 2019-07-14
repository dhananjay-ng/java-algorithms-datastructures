package problems.onstring;

public class ReverseWordsInAGivenString {
    /**
     * Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
     * <p>
     * Input:
     * The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.
     * <p>
     * Output:
     * For each test case, in a new line, output a single line containing the reversed String.
     * <p>
     * User Task:
     * The task is to complete the function reverseWords() which reverse words from the given string and prints the answer. The newline is automatically appended by the driver code.
     * <p>
     * Constraints:
     * 1 <= T <= 100
     * 1 <= |S| <= 2000
     * <p>
     * Example:
     * Input:
     * 2
     * i.like.this.program.very.much
     * pqr.mno
     * <p>
     * Output:
     * much.very.program.this.like.i
     * mno.pqr
     * <p>
     * Explanation:
     * Testcase 1: After reversing the whole string(not individual words), the input string becomes much.very.program.this.like.i.
     */

    public static void reverseWords(String sd) {
        if (sd == null || "".equals(sd)) {
            System.out.print(sd);
            return;
        }
        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = sd.length() - 1; i >= 0; i--) {
            if (sd.charAt(i) == '.') {
                result.append(word.reverse()).append(".");
                word = new StringBuilder();
            } else {
                word.append(sd.charAt(i));
            }
        }
        result.append(word.reverse());
        System.out.print(result.toString());
    }
}
