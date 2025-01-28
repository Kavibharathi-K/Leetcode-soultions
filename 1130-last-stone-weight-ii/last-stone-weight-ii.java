class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for(int i = 0; i < stones.length; i++)
        {
            totalSum += stones[i];
        }

        int target = totalSum / 2;

        int[][] dp = new int[stones.length][target + 1];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        
        return backtrack(0, 0, stones, totalSum , target, dp);
    }

    int backtrack(int index, int currentSum, int[] stones, int totalSum, int target, int[][] dp)
    {
        if(currentSum >= target || index == stones.length)
        {
            return Math.abs(currentSum - (totalSum - currentSum));
        }

        if(dp[index][currentSum] != -1) return dp[index][currentSum];

        return dp[index][currentSum] = Math.min(
            backtrack(index + 1, currentSum + stones[index], stones, totalSum, target, dp),
            backtrack(index + 1, currentSum, stones, totalSum, target, dp)
        );
    }
}