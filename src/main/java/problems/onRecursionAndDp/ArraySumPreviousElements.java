package problems.onRecursionAndDp;

import java.util.Arrays;

public class ArraySumPreviousElements {
    static void sum(int a[], int i) {
        if( i == a.length) return;
        a[i]+=a[i-1];
        sum(a,i+1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        sum(a,1);
        System.out.println(Arrays.toString(a));
    }
}
