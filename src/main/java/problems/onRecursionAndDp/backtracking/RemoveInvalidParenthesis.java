package problems.onRecursionAndDp.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class RemoveInvalidParenthesis {
    public static class Solution {
        ArrayList<String> res;
        HashSet<String> seen;

        public ArrayList<String> solve(String A) {
            res = new ArrayList<>();
            seen = new HashSet<>();
            func(A, 0, invalidParen(A));
            return res;
        }

        public void func(String str, int i, int k) {
            if (k == 0 || i == str.length()) {
                if (k == 0 && invalidParen(str) == 0) {
                    if (!seen.contains(str))
                    res.add(str);
                    seen.add(str);
                }
                return;
            }
            if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                String left = (i > 0) ? str.substring(0, Math.min(i, str.length())) : "";
                String right = (i < str.length() - 1) ? str.substring(i + 1, str.length()) : "";
                func(left + right, i, k - 1);
            }
            func(str, i + 1, k);
        }

        public int invalidParen(String A) {
            int left = 0;
            int right = 0;
            int count = 0;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) == '(') left++;
                if (A.charAt(i) == ')') {
                    right++;
                    if (right > left) {
                        count++;
                        left = 0;
                        right = 0;
                    } else {
                        left-=right;
                        right--;
                    }
                }
            }
            count += left;
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(")(()((((()((").toString());
    }

}
