package problems.onarray;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStockTwice {
    // space O(n) time O(n) ...
    // make use of previous computations
    public static double buyAndSellStockTwice(List<Double> prices) {
        double maxTotalProfitSoFar = 0.0;
        List<Double> firstBuySellProfit = new ArrayList<>();
        double minSoFar = Double.MAX_VALUE;

        for (int i = 0; i < prices.size(); i++) {
            minSoFar = Math.min(minSoFar, prices.get(i));
            maxTotalProfitSoFar = Math.max(maxTotalProfitSoFar, prices.get(i) - minSoFar);
            firstBuySellProfit.add(maxTotalProfitSoFar);
        }

        double maxSoFar = Double.MIN_VALUE;
        for (int i = prices.size() - 1; i > 0; i--) {
            maxSoFar = Math.max(maxSoFar, prices.get(i));
            maxTotalProfitSoFar = Math.max(maxTotalProfitSoFar, ((maxSoFar - prices.get(i)) + firstBuySellProfit.get(i - 1)));
        }


        return maxTotalProfitSoFar;
    }
}
