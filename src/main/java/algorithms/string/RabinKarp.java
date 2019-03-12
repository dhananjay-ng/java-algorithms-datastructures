package algorithms.string;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {
    public static int search(String text, String pattern) {

        if (text.length() < pattern.length()) return -1;

        int thash = 0, phash = 0;
        int base = 26;
        int powerP = 1; //base^pattter.lengh
        for (int i = 0; i < pattern.length(); i++) {
            powerP = i == 0 ? 1 : base * powerP;
            thash = thash * base + text.charAt(i);
            phash = phash * base + pattern.charAt(i);
        }

        for (int i = pattern.length(); i < text.length(); i++) {

            if (phash == thash && text.substring(i - pattern.length(), i).equals(pattern)) {
                return i - pattern.length();
            }
            thash -= powerP * text.charAt(i - pattern.length());
            thash = thash * base + text.charAt(i);
        }
        if (thash == phash && text.substring(text.length() - pattern.length()).equals(pattern)) {
            return text.length() - pattern.length();
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(RabinKarp.search("Hi this ajndjadjaijansjdnajdaa abdjadad ajdajdajda s me", "ajndjadjaijansjdnajdaa abdjadad"));

    }
}
