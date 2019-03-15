package problems.onstack;

import java.util.Deque;
import java.util.LinkedList;

public class IsWellFormedParenthesis {
    public static boolean isWellFormed(String s) {

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if ('{' == s.charAt(i) || '[' == s.charAt(i) || '(' == s.charAt(i)) {
                deque.addFirst(s.charAt(i));
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                else if (s.charAt(i) == '}' && '{' != deque.removeFirst()
                        || s.charAt(i) == ')' && '(' != deque.removeFirst()
                        || s.charAt(i) == ']' && '[' != deque.removeFirst()) {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isWellFormed("{}{}[]()"));
        System.out.println(isWellFormed("}])"));
    }
}
