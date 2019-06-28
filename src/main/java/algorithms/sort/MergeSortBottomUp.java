package algorithms.sort;

import java.io.FileInputStream;
import java.util.Scanner;

public class MergeSortBottomUp {
    public static void merge(String[] src, String dist[], int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) dist[k] = src[j++];
            else if (j > hi) dist[k] = src[i++];
            else if (less(src[i], src[j])) dist[k] = src[i++];
            else dist[k] = src[j++];
        }
    }

    private static boolean less(String s, String s1) {
        if (s.length() <= s1.length()) {
            return true;
        }
        return false;
    }

    public static void sort(String[] src, String dest[]) {

        for (int size = 1; size <= src.length; size = size + size) { //execued logn times as we double each time.
            for (int lo = 0; lo < src.length - size; lo += size + size) {
                merge(src, dest, lo, lo + size - 1, Math.min(lo + size + size - 1, src.length - 1));
            }
            System.arraycopy(dest, 0, src, 0, src.length);
        }

    }

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(new FileInputStream("C:\\Fieldglass\\COPP\\src\\main\\java\\websites\\he\\input.txt"));

        int t = s.nextInt();
        StringBuilder res = new StringBuilder();
        s.nextLine();
        while (t-- > 0) {
            String[] dest = s.nextLine().split(" ");
            String[] src = dest.clone();
            sort(src, dest);
            for (int i = 0; i < dest.length; i++) {
                res.append(" ").append(dest[i]);
            }
            res.append("\n");
        }
        System.out.println(res.toString());
    }
}
