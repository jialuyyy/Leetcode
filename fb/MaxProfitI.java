//Time Complexity : O(n ^ 2)
//for every price, compare the profit if sells at it and buys it from index 0 to index i
//TLE for the last test case, so need to do some optimize

public class MaxProfitI {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int max = 0;
        int globalMax = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[i] > prices[j])
                    max = Math.max(max, prices[i] - prices[j]);
            }
            
            globalMax = Math.max(globalMax, max);
        }
        
        return globalMax;
    }
}
