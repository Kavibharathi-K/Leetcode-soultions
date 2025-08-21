class Solution {
    public int maxProfit(int[] prices) {
        int buyRate = prices[0];
        int currentProfit = 0;
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] < buyRate)
            {
                buyRate = prices[i];
                continue;
            }
            currentProfit = prices[i] - buyRate;
            maxProfit = Math.max(currentProfit, maxProfit);
        }
        return maxProfit;
    }
}