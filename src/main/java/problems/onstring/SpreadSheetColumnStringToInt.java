package problems.onstring;

public class SpreadSheetColumnStringToInt {
    public static int ssDecodeColID(final String col) {
        int val=0;
        for (int i = 0; i < col.length(); i++) {
            val*=26;
            val+=col.charAt(i) - 'A' + 1;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(ssDecodeColID("ZZ"));
    }
}
