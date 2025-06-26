class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int minLen = nums.length + 1;

        while(right < nums.length)
        {
            currentSum += nums[right];

            while(currentSum >= target)
            {
                minLen = Math.min(minLen, (right - left + 1));
                currentSum -= nums[left];
                left++;
            }
            right++;
        }
        return (minLen == nums.length + 1) ? 0 : minLen;
    }
}