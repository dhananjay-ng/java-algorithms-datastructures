package problems.onarray;

import java.util.List;

public class StockBuySell {
    /**
     * This problem is concerned with the problem of optimally buying and selling a stock
     * once, as described on Page 2. As an example, consider the following sequence of
     * stock prices: (310, 315, 275, 295, 260,270,290,230, 255, 250). The maximum profit that
     * can be made with one buy and one sell is 30 — buy at 260 and sell at 290. Note that
     * 260 is not the lowest price, nor 290 the highest price.
     * Write a program that takes an array denoting the daily stock price, and returns the
     * maximum profit that could be made by buying and then selling one share of that
     * stock.     */
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int maxProfit(final int[] A) {
        int maxProfit=0;
        int minTillNow=Integer.MAX_VALUE;
        if(A.length==1){
            return A[0];
        }
        minTillNow=A[0];
        maxProfit=A[0];
        for (int i = 1; i < A.length ; i++) {
            if((A[i] - minTillNow)> maxProfit ){
                maxProfit = A[i] - minTillNow;
            }
            if(A[i]<minTillNow){
                minTillNow = A[i];
            }

        }
        return maxProfit;
    }
    public static int maxProfit2(final int[] A) {
            int  maxProfit=0;
            if(A.length==1){
                return 0;
            }

            for (int i = 0; i+1 < A.length ; i++) {
                if(A[i]<A[i+1]){
                    maxProfit+=A[i+1]-A[i];
                }
            }
            return maxProfit;

    }
    public static double computeMaxProfit(List<Double> prices) {
        if (prices.size() <2) return 0;
        double maxp = Double.MIN_VALUE;
        double curMin = prices.get(0);
        for (int i=1;i<prices.size();i++) {
            if (prices.get(i)< curMin) {
                curMin = prices.get(i);
            } else if (prices.get(i) - curMin > maxp) {
                maxp =prices.get(i)-curMin;
            }
        }


        return maxp;
    }

    public static void main(String[] args) {
        int A[]={1,2,4,3,5};
       System.out.println(maxProfit2(A));
    }
}
