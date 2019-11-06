package problems.onRecursionAndDp;

public class IsArraySorted {
    static boolean isSorted(int[] A, int n) {
        if (n == 1) return true;
        return A[n - 1] < A[n - 2] ? false : isSorted(A, n - 1);
    }

    public static void main(String[] args) {
        int[] A = {1,2,5,3};
        System.out.println(isSorted(A, A.length));
    }
}
