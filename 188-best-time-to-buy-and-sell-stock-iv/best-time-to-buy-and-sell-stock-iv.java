class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k + 1];
        int n = prices.length;

        for(int index = n - 1; index >= 0; index--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                for(int cap = 1; cap <= k; cap++)
                {
                    int profit = 0; 
                    if(buy == 1) profit = Math.max(-prices[index] + dp[index + 1][0][cap], dp[index + 1][1][cap]);
                    else profit = Math.max(prices[index] + dp[index + 1][1][cap - 1], dp[index + 1][0][cap]);

                    dp[index][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][k];
    }
}