package com.copp.algorithm.sort;

public class SelectionSort {

        private SelectionSort() { }

        public static void sort(int[] a) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                int min = i;
                for (int j = i+1; j < n; j++) {
                    if (less(a[j], a[min])) min = j;
                }
                exch(a, i, min);
                assert isSorted(a, 0, i);
            }
            assert isSorted(a);
        }

        // is v < w ?
        private static boolean less(int v, int w) {
            return v < w;
        }


        // exchange a[i] and a[j]
        private static void exch(int[] a, int i, int j) {
            int swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }



        // is the array a[] sorted?
        private static boolean isSorted(int[] a) {
            return isSorted(a, 0, a.length - 1);
        }

        // is the array sorted from a[lo] to a[hi]
        private static boolean isSorted(int[] a, int lo, int hi) {
            for (int i = lo + 1; i <= hi; i++)
                if (less(a[i], a[i-1])) return false;
            return true;
        }


        // print array to standard output
        private static void show(int[] a) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }
        public static void main(String[] args) {

            int a[] = { 1, 4, 5, 6, 2};
            sort(a);
            show(a);

        }
    }