package problems.onstring;

public class BaseConversion {

    private static int getValue(String n, int b1, boolean isNeg) {
        int val = 0;
        for (int i = isNeg ? 1 : 0; i < n.length(); i++) {
            val *= b1;
            val += Character.isDigit(n.charAt(i)) ? (n.charAt(i) - '0'):((n.charAt(i) - 'A') + 10);
        }
        return val;
    }

    public static char resolveMultiplier(int mul) {
        return mul <= 9 ? (char) (mul + '0') : (char) ('A' + mul - 10);
    }

    public static String convertBase(String numAsString, int b1, int b2) {
        boolean isNegative = numAsString.charAt(0) == '-' ? true : false;

        int value = getValue(numAsString, b1, isNegative);
        StringBuilder sb = new StringBuilder();
        if (value==0)  return isNegative?"-0":"0";
        while (value != 0) {
            sb.append(resolveMultiplier(value % b2));
            value/=b2;
        }
        return (isNegative?"-":"")+sb.reverse().toString();
    }

    /*
    private static int getValue(String n, int b1, boolean isNeg) {
        int val = 0;
        for (int i = isNeg ? 1 : 0; i < n.length(); i++) {
            val *= b1;
            val += Character.isDigit(n.charAt(i)) ? (n.charAt(i) - '0'):((n.charAt(i) - 'A') + 10);
        }
        return val;
    }

    public static char resolveMultiplier(int mul) {
        return mul <= 9 ? (char) (mul + '0') : (char) ('A' + mul - 10);
    }

    public static String convertBase(String numAsString, int b1, int b2) {
        boolean isNegative = numAsString.charAt(0) == '-' ? true : false;
        int value = getValue(numAsString, b1, isNegative);
        StringBuilder sb = new StringBuilder();

        if (isNegative) sb.append('-');

        int maxpow = 0;
        while (Math.pow(b2, maxpow) <= value) {
            maxpow++;
        }
        maxpow--;
        if (maxpow < 0) {
            return sb.append(0).toString();
        }
        while (maxpow >= 0) {
            int mul = 0;
            while (mul * Math.pow(b2, maxpow) <= value) {
                mul++;
            }
            mul--;
            sb.append(resolveMultiplier(mul));
            value -= mul * Math.pow(b2, maxpow);
            maxpow--;
        }

        return sb.toString();
    }
*/


    public static void main(String[] args) {
//        System.out.println(resolveMultiplier(2));
          System.out.println(convertBase("15", 7, 13));
    }
}
