package algorithms.string;

public class BoyerMoore {
    public static int[] skipArrayGeneration(String pattern) {
        int radix = 512;
        int[] skipArray = new int[radix];
        for (int i = 0; i < radix; i++) {
            skipArray[i] = -1;
        }

        for (int i = 0; i < pattern.length(); i++) {
            skipArray[pattern.charAt(i)] = i;
        }
        return skipArray;
    }

    public static int search(String text, String pattern) {
        int[] skipArray = skipArrayGeneration(pattern);
        int skip = 0;
        int M = pattern.length();
        int N = text.length();
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    skip = Math.max(1, j - skipArray[text.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) return i;

        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(BoyerMoore.search("Hi this is me", "is"));
    }
}
