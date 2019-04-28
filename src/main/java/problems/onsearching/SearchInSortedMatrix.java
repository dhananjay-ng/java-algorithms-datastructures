package problems.onsearching;

import java.util.Collections;
import java.util.List;

public class SearchInSortedMatrix {
    /**
     *
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * Example 1:
     *
     * Input:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 3
     * Output: true
     * Example 2:
     *
     * Input:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 13
     * Output: false
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int m = matrix.length;
        int col = matrix[0].length -1;
        while(row < m && col >=0){
            if(matrix[row][col] == target) return true;
            else if (matrix[row][col] < target)
                row++;
            else col--;
        }
        return false;
    }

    //or
    public static boolean matrixSearch(List<List<Integer>> A, int x) {
        for (int i= 0; i < A.size(); i++) {
            int indx = Collections.binarySearch(A.get(i), x);
            if (indx >= 0) return true;

        }
        return false;
    }

}
