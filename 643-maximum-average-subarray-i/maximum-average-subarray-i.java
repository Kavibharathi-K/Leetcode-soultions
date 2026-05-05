class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = 0;
        double currentSum = 0;
        double result = Double.NEGATIVE_INFINITY;

        while(right < nums.length)
        {
            if(right - left + 1 < k)
            {
                currentSum += nums[right];
                right++;
                continue;
            }

            currentSum += nums[right];
            result = Math.max(result, currentSum / k);
            currentSum -= nums[left];
            left++;
            right++;
        }
        return result;
    }
}