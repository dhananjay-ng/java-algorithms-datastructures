package problems.onstring;

public class StringToIntViceVersa {

    public static String intToString(int x) {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = x < 0 ? true : false;

        do {
            sb.append(Math.abs(x % 10));
            x /= 10;
        } while (x != 0);
        if (isNegative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public static int stringToInt(String s) {
        int res = 0;
        int multi = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                res *= -1;
            } else {
                res += (s.charAt(i) - 48) * multi;
            }
            multi *= 10;
        }

        return res;
    }

}
