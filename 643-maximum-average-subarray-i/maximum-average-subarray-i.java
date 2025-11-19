class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k - 1;
        double currentSum = 0;
        double result = 0;
        
        for(int i = 0; i <= right; i++) currentSum += nums[i];

        result = currentSum / k;

        while(right < nums.length - 1)
        {
            result = Math.max(result, currentSum / k);
            currentSum -= nums[left++];
            currentSum += nums[++right];
        }

        result = Math.max(result, currentSum / k);
        return result;
    }
}