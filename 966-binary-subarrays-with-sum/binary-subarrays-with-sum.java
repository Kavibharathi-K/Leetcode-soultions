class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }
    public int helper(int[] nums, int goal)
    {
        if(goal < 0) return 0;
        int result = 0;
        int left = 0;
        int right = 0;
        int currentSum = 0;

        while(right < nums.length)
        {
            currentSum += nums[right];

            while(currentSum > goal)
            {
                currentSum -= nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }
}