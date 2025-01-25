class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] counts = new int[n];
        Arrays.fill(counts, 1);
        int maxi = 1;
        int ans = 0;

        for(int index = 0; index < n; index++)
        {
            for(int prevIndex = 0; prevIndex < index; prevIndex++)
            {
                if(nums[index] > nums[prevIndex] && 1 + dp[prevIndex] > dp[index])
                {
                    dp[index] = 1 + dp[prevIndex];
                    counts[index] = counts[prevIndex];
                }
                else if(nums[index] > nums[prevIndex] && 1 + dp[prevIndex] == dp[index])
                {
                    counts[index] = counts[index] + counts[prevIndex];
                }
            }
            maxi = Math.max(maxi, dp[index]);
        }

        for(int i = 0; i < n; i++)
        {
            if(dp[i] == maxi) ans += counts[i];
        }
        return ans;

    }
}