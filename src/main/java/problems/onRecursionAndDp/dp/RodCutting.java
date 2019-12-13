package problems.onRecursionAndDp.dp;

public class RodCutting {

    //profit for lengths 1,2,3,4
   static int cost[] = {0, 6, 3, 1, 4};
   static int dp[] = {-1,-1,-1,-1,-1};


    public static int maxProfit(int n) {

        if (n == 0) return 0;
        if (dp[n]!=-1) return dp[n];
        int max = -1;
        for (int i=1;i<=n;i++){
            max = Math.max(max, cost[i] + maxProfit(n - i));
        }

        dp[n] = max;
        return max;
    }
    static int dp1[] = {0,0,0,0,0};

    public static int maxProfitBu(int n) {
        for (int i=1;i<=n;i++){
            int best = 0;
            for (int cut =1; cut<=i;cut++){
                best = Math.max(best , cost[cut]+dp1[i-cut]);
            }
            dp1[i] = best;
        }

        return dp1[n];
    }

    public static void main(String[] args) {

        //length is 4
        System.out.println(maxProfit(4));
        System.out.println(maxProfitBu(4));
    }
}
