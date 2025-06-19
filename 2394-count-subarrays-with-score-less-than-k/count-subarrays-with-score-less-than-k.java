class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left = 0;
        long result = 0;
        long currentSum = 0;
        long currentScore = 1;

        for(int right = 0; right < nums.length; right++) 
        {
            currentSum += nums[right];
            currentScore = currentSum * (right - left + 1);

            while(currentScore >= k)
            {
                currentSum -= nums[left];
                left++;
                currentScore = currentSum * (right - left + 1);
            }
            result += (right - left + 1);
        }
        return result;
    }
}