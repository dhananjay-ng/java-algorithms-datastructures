package problems.onRecursionAndDp.dp;

import java.util.Arrays;

public class WineProblem {
    int[] wines = {2, 4, 6, 2, 5};
    int N = wines.length;
    int dp[][] = new int [N+1][N+1];
    public int profit(int be, int en){

        if (be > en) return 0;
        if (this.dp[be][en]!=-1) return this.dp[be][en];

        int year = N - (en - be + 1) + 1;

        this.dp[be][en] = Math.max( profit(be+1, en) + wines[be-1]*year,
                profit(be, en - 1) + wines[en-1]*year);


        return this.dp[be][en];
    }

    public static void main(String[] args) {
        WineProblem wineProblem = new WineProblem();
        for (int i = 0; i < wineProblem.N; i++){
            wineProblem.dp[i] = new int[wineProblem.N+1];
            Arrays.fill(wineProblem.dp[i], -1);
        }

        System.out.println(wineProblem.profit(1, 5));

    }

}
