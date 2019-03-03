package algorithms.sort;

public class SortUtil {
    // is v < w ?
    public static boolean less(int v, int w) {
        return v < w;
    }


    // exchange a[i] and a[j]
    public static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }



    // is the array a[] sorted?
    public static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    public static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    // print array to standard output
    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
