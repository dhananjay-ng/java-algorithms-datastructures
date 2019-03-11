package problems.onstring;

import edu.princeton.cs.algs4.In;

public class RunLengthEncoding {
    public static String decoding(String s) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            int digit = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                digit = (digit * 10) + s.charAt(i) - '0';
                i++;
            }
            StringBuilder pat = new StringBuilder();
            while (i < s.length() && Character.isLetter(s.charAt(i))) {
                pat.append(s.charAt(i));
                i++;
            }

            for (int k = 0; k < digit; k++) {
                decoded.append(pat);
            }
        }

        return decoded.toString();
    }

    public static String encoding(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            i++;
            count++;
            while (i < s.length() && a == s.charAt(i)) {
                count++;
                i++;
            }
            i--;
            sb.append(count).append(a);
            count = 0;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String text = "aaaaaaaaaaaabcccaa";
        System.out.println(encoding(text));
        System.out.println(decoding(encoding(text)));

        System.out.println(decoding(encoding(text)).equals(text));
    }
}
