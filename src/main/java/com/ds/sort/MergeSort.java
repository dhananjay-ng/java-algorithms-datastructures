package com.ds.sort;

public class MergeSort {

    public static void sort(int a[], int aux[], int low, int high) {
        if (low >= high) {
        } else {
            int mid = (low + (high - low) / 2);
            sort(a, aux, low, mid);
            sort(a, aux, mid + 1, high);
            if (a[mid + 1] <= a[low])
                merge(a, aux, low, mid, high);
        }
    }

    private static void merge(int[] a, int[] aux, int low, int mid, int high) {

        for (int i = low; i <= high; i++)
            aux[i] = a[i];

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 7, 9, 7, 0, 3, 1, 2, 5};
        int[] aux = new int[a.length];

        //sort(a, aux, 0, a.length - 1);
        for (int sz = 1; sz < a.length; sz=sz+sz)
            for (int lo = 0; lo < a.length - sz; lo+=sz+sz){
                merge(a,aux,lo,lo + sz - 1, Math.min(lo + sz + sz - 1,a.length - 1));

            }

        for (int ele : a) {
            System.out.println(ele);
        }
    }
}
