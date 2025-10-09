class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentBuy = prices[0];
        int currentProfit = 0;

        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] < currentBuy) 
            {
                currentBuy = prices[i];
                currentProfit = 0;
            }
            else 
            {
                currentProfit = prices[i] - currentBuy;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
}