package com.ds.sort;

public class ShellSort {

    public static void sort(int[] a) {
        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && SortUtil.less(a[j], a[j-h]); j -= h) {
                    SortUtil.exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }
}
