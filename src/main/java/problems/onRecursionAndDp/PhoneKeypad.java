package problems.onRecursionAndDp;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeypad {
    private String[] MAPPINGS = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        StringBuilder builder = new StringBuilder();
        find(res, 0, builder, digits);
        return res;
    }

    private void find(List<String> res, int i, StringBuilder builder, String digits) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        for (int j = 0; j < MAPPINGS[digits.charAt(i)-'0'].length();j++) {
            builder.append(MAPPINGS[digits.charAt(i)-'0'].charAt(j));
            find(res, i+1, builder, digits);
            builder.setLength(builder.length() - 1);

        }

    }
}
