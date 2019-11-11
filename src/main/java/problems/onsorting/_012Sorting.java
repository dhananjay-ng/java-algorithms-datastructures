package problems.onsorting;

import testingsystem.misccode.Reader2;

import java.lang.*;
import java.io.*;

public class _012Sorting {
    /**
     * Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
     *
     * Input:
     * The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.
     *
     * Output:
     * For each testcase, print the sorted array.
     *
     * Constraints:
     * 1 <= T <= 500
     * 1 <= N <= 106
     * 0 <= Ai <= 2
     *
     * Example:
     * Input :
     * 2
     * 5
     * 0 2 1 2 0
     * 3
     * 0 1 0
     *
     * Output:
     * 0 0 1 2 2
     * 0 0 1
     */

    static int partition(int a[], int lo, int hi) {
        int i = lo - 1;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], 1) || a[i] == 1) {
                if (i == hi) break;
            }

            while (less(1, a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            excg(a, i, j);
        }
        return j;
    }

    static boolean less(int a, int b) {
        return a < b;
    }

    static void excg(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        Reader2 in = new Reader2();
        StringBuilder result = new StringBuilder();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            int lo=0,mid=0,hi=n-1;
            while(mid<=hi){
                if(a[mid]==0){
                    excg(a,mid,lo);
                    mid++;lo++;
                } else if(a[mid]==1){
                    mid++;
                } else{
                    excg(a,mid,hi);
                    hi--;
                }
            }
//or
            int ub = partition(a, 0, a.length - 1);
            int i = 0;
            while (true) {
                while (a[i] != 1) {
                    i++;
                    if (i >= ub) break;
                }
                while (a[ub] == 1) {
                    ub--;
                    if (ub < i) break;
                }
                if (i < ub) {
                    excg(a, i, ub);
                } else {
                    break;
                }
            }
            for (int ele : a) {
                result.append(ele + " ");
            }
            result.append("\n");

        }
        System.out.println(result);
    }
}