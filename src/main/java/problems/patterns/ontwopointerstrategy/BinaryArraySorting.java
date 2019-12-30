package problems.patterns.ontwopointerstrategy;

public class BinaryArraySorting {
    /**
     * Given a binary array A[] of size N. The task is to arrange array in increasing order.
     *
     * Note: The binary array contains only 0  and 1.
     *
     * Input:
     * The first line of input contains an integer T, denoting the testcases. Every test case contains two lines, first line is N(size of array) and second line is space separated elements of array.
     *
     * Output:
     * Space separated elements of sorted arrays. There should be a new line between output of every test case.
     */
    void binaryArraySort(int a[]) {
        int n = a.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (a[i] == 0 && i < j) {
                i++;
            }
            while (a[j] == 1 && i < j) {
                j--;
            }

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
}
