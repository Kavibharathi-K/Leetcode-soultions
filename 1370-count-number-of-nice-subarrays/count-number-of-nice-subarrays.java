class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] % 2 == 0) nums[i] = 0;
            else nums[i] = 1;
        }

        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k)
    {
        if(k < 0) return 0;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int result = 0;

        while(right < nums.length)
        {
            currentSum += nums[right];

            while(currentSum > k)
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