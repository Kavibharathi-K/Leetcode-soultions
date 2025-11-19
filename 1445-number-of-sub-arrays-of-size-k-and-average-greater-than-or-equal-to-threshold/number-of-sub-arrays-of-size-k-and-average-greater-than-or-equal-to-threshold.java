class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int left = 0;
        int right = k - 1;
        int currentSum = 0;
        int result = 0;

        for(int i = 0; i < k; i++) currentSum += nums[i];

        while(right < nums.length - 1)
        {
            if((currentSum / k) >= threshold) result++;
            currentSum -= nums[left++];
            currentSum += nums[++right];
        }
        if((currentSum / k) >= threshold) result++;
        return result;
    }
}