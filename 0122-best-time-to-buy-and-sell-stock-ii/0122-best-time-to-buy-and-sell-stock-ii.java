import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        } 
        return fun(0, 1, prices, dp);
    }
    
    private int fun(int ind, int buy, int[] prices, int[][] dp) {
        // 1. Base case must be checked first
        if (ind == prices.length) return 0;
        
        // 2. DP lookup happens next
        if (dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;

        if (buy == 1) {
            profit = Math.max(-prices[ind] + fun(ind + 1, 0, prices, dp),
                               0 + fun(ind + 1, 1, prices, dp));
        } 
        else {
            profit = Math.max(prices[ind] + fun(ind + 1, 1, prices, dp),
                               0 + fun(ind + 1, 0, prices, dp));
        }
        
        return dp[ind][buy] = profit;
    }
}