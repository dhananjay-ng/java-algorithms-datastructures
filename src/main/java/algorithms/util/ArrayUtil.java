package algorithms.util;

public class ArrayUtil {
    public static float doFloatSumFromCharArray(String[] A) {
        char a[] = A[0].toCharArray();
        String aa = "";
        float sum = 0.0f;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] == '\"') {
                continue;
            }
            if (a[i] != ',') {
                aa += a[i];
            } else {
                sum += Float.parseFloat(aa);
                aa = "";
            }
            if (i == a.length - 1 - 1) {
                sum += Float.parseFloat(aa);
                aa = "";
            }
        }

        return sum;

    }
}