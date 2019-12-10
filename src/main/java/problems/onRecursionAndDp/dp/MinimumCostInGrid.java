package problems.onRecursionAndDp.dp;

public class MinimumCostInGrid {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid.length];
        dp[0][0] = grid[0][0];

        //fill the first row as there is only one way to visit row from right side
        //so cost will be cost till previous cell + current grid cost
        for (int i=1;i<grid.length;i++) dp[0][i] = dp[0][i-1] + grid[0][i];

        //same for first column there is only  one way to visit by from top.
        for (int i=1;i<grid.length;i++) dp[i][0] = dp[i-1][0] + grid[i][0];

        //for remaining each cell there are two possibilities from top  and from right
        //so to minimize cost take minimum at each step > optimal substructure
        //final minimum depends on minimum at each step.
        for (int i=1;i<grid.length;i++){
            for (int j=1;j<grid.length;j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[grid.length-1][grid.length-1];
    }

    public static void main(String[] args) {
       int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(grid.length);
        System.out.println(grid[0].length);
    }
}
/**
 64. Minimum Path Sum
 Medium

 1878

 46

 Add to List

 Share
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example:

 Input:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 Output: 7
 Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */