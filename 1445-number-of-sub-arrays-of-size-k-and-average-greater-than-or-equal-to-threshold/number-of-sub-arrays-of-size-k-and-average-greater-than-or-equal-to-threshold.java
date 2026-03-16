class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int currentAverage = 0;
        int result = 0;
        while(right < nums.length)
        {
            if(right - left + 1 < k)
            {
                currentSum += nums[right];
                right++;
                continue;
            }

            currentSum += nums[right];
            currentAverage = currentSum / k;
            if(currentAverage >= threshold) result++;
            currentSum -= nums[left];
            left++;
            right++;
        }
        return result;
    }
}