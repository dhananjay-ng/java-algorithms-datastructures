package problems.onstring;

import java.util.ArrayList;
import java.util.List;

public class ValidIpAddressGeneration {

    public static List<String> getValidIpAddress(String s) {
        List<String> res = new ArrayList<>();
        int maxLength = s.length();
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String first = s.substring(0, i);
            if (isValidPart(first)) {
                for (int j = 1; i + j < s.length() && j < 4; j++) {
                    String second = s.substring(i, i + j);
                    if (isValidPart(second)) {
                        for (int k = 1; i + j + k < s.length() && k < 4; k++) {
                            String third = s.substring(i + j, i + j + k);
                            String fourth = s.substring(i + j + k);
                            if (isValidPart(third) && isValidPart(fourth)) {
                                res.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    public static boolean isValidPart(String part) {
        if (part.length() > 3) return false;
        if (part.startsWith("0") && part.length() > 1) return false;
        int x = Integer.parseInt(part);
        return x >= 0 && x <= 255;
    }

    public static void main(String[] args) {
        List<String> res = getValidIpAddress("11000");
        res.forEach(s -> System.out.println(s));
    }
}
