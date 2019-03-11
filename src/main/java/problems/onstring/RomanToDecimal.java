package problems.onstring;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {
    public static int romanToInteger(String s) {
        Map<Character, Integer> rules = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int res = 0;
        res += rules.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (rules.get(s.charAt(i)) < rules.get(s.charAt(i + 1))) {
                res -= rules.get(s.charAt(i));
            } else {
                res += rules.get(s.charAt(i));
            }
        }
        return res;
    }

    public static int romanToInteger1(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I') {
                res += 1;

            } else if (s.charAt(i) == 'V') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                    res += 4;
                    i--;
                } else {
                    res += 5;
                }

            } else if (s.charAt(i) == 'X') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                    res += 9;
                    i--;
                } else {
                    res += 10;
                }

            } else if (s.charAt(i) == 'L') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                    res += 40;
                    i--;
                } else {
                    res += 50;
                }

            } else if (s.charAt(i) == 'C') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                    res += 90;
                    i--;
                } else {
                    res += 100;
                }

            } else if (s.charAt(i) == 'D') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                    res += 400;
                    i--;
                } else {
                    res += 500;
                }

            } else if (s.charAt(i) == 'M') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                    res += 900;
                    i--;
                } else {
                    res += 1000;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInteger("LIX"));
    }
}
