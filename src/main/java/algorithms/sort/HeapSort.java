package algorithms.sort;

public class HeapSort {

    public static void sort(int[] a) {
        int n = a.length;
        //Heap construction
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }

        //sorting
        while (n > 1) {
            exch(a, 1, n);
            sink(a, 1, --n);
        }
    }

    public static void sortReverse(int[] a) {
        int n = a.length;
        //Heap construction
        for (int k = n / 2; k >= 1; k--) {
            sinkReverse(a, k, n);
        }

        //sorting
        while (n > 1) {
            exch(a, 1, n);
            sinkReverse(a, 1, --n);
        }
    }

    private static void sink(int[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) {
                j = j + 1;
            }
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }
    private static void sinkReverse(int[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(a, j, j + 1)) {
                j = j + 1;
            }
            if (!greater(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean greater(int[] a, int i, int j) {
        return Integer.compare(a[i-1], a[j-1]) > 0;
    }

    public static void exch(int[] a, int k, int j) {
        int swap = a[k - 1];
        a[k - 1] = a[j - 1];
        a[j - 1] = swap;
    }

    private static boolean less(int[] a, int j, int i) {
        return Integer.compare(a[j - 1], a[i - 1]) < 0;
    }

    public static void main(String[] args) {
        int a[] = {9, 4, 2, 5, 6, 3, 2, 4, 5, 99};
        sort(a);
        //sortReverse(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
