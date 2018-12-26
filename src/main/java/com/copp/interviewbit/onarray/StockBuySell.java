package com.copp.interviewbit.onarray;

public class StockBuySell {
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

    public static void main(String[] args) {
        int A[]={1,2,4,3,5};
       System.out.println(maxProfit2(A));
    }
}
