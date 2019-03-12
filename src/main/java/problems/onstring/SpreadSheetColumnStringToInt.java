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

    public static String ssDecodeIdToCol( int col) {
        StringBuilder stringBuilder = new StringBuilder();
        while (col>0){
            int mod = (col-1) % 26;
            stringBuilder.append((char) (mod + 'A'));
            col=(col-mod-1)/26;

        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(ssDecodeColID("ZMP"));
        System.out.println(ssDecodeIdToCol(17930));
    }
}
