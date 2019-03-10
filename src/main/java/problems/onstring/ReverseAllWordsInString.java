package problems.onstring;

import java.util.Arrays;

public class ReverseAllWordsInString {
    public static void reverseWords(char[] input) {
        int wordStart = 0, wordEnd = input.length - 1;

        while (wordStart < wordEnd) {
            char temp = input[wordEnd];
            input[wordEnd--] = input[wordStart];
            input[wordStart++] = temp;
        }

        for (int i = 0; i < input.length; i++) {
            wordStart = i;
            while (i < input.length && input[i] != ' ') {
                i++;
            }
            wordEnd = i - 1;
            while (wordStart < wordEnd) {
                char temp = input[wordEnd];
                input[wordEnd--] = input[wordStart];
                input[wordStart++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        char[] in = {'h', 'e', ' ', 'i', 's', ' ', 'd', 'j'};
        reverseWords(in);
        System.out.println(Arrays.toString(in));
    }
}
