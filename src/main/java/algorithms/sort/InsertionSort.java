package algorithms.sort;

public class InsertionSort {

    private InsertionSort() { }


    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && SortUtil.less(a[j], a[j-1]); j--) {
                SortUtil.exch(a, j, j-1);
            }
        }
    }

    public static void sort(int[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && SortUtil.less(a[j], a[j-1]); j--) {
                SortUtil.exch(a, j, j-1);
            }
        }
    }

    public static int[] indexSort(int[] a) {
        int n = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++)
            index[i] = i;

        for (int i = 0; i < n; i++)
            for (int j = i; j > 0 && SortUtil.less(a[index[j]], a[index[j-1]]); j--)
                SortUtil.exch(index, j, j-1);

        return index;
    }
}
