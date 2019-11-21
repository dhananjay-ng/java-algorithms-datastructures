package problems.onRecursionAndDp.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    /* A utility function to check if a queen can
     be placed on board[row][col]. Note that this
     function is called when "col" queens are already
     placeed in columns from 0 to col -1. So we need
     to check only left side for attacking queens */
    public static boolean isSafe(int board[][], int row, int col)
    {
        int i, j;

        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }
    public static List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        solve(board, res, n, 0);
        return res;


    }

    private static boolean solve(int[][] board, List<List<String>> res, int n, int i) {
        if(i == n) {
            List<String> result  = new ArrayList<>();
            for (int k = 0; k < board.length; k++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    row.append(board[k][j] == 1 ? "Q" : ".");
                }
                result.add(row.toString());
            }
            res.add(result);
            return false;
        }
        for (int j =0 ; j < board.length; j++) {
            if(isSafe(board, i, j)) {
                board[i][j] = 1;
                boolean done =   solve(board,res, n, i+1);
                if (done) {
                    return true;
                }
                board[i][j] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solveNQueens(4).forEach(strings -> {
            System.out.println(strings.toString());
        });
    }

}
