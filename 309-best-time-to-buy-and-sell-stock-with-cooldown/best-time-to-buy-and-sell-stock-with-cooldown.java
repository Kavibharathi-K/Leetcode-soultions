class Solution {
    public int maxProfit(int[] prices) {
       int[][] dp = new int[prices.length + 2][2];
       int n = prices.length;

        for(int index = n - 1; index >= 0; index--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                int profit = 0;
                if(buy == 1)
                {
                    profit = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
                }
                else profit = Math.max(prices[index] + dp[index + 2][1], dp[index + 1][0]);

                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }
}